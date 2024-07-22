package org.chromium.base.task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
  private static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT;
  private static final int KEEP_ALIVE_SECONDS = 30;
  private static final int MAXIMUM_POOL_SIZE;
  private static final int RUNNABLE_WARNING_COUNT = 32;
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  private static final ThreadFactory sThreadFactory;

  static {
    int availableProcessors = Runtime.getRuntime().availableProcessors();
    CPU_COUNT = availableProcessors;
    CORE_POOL_SIZE = Math.max(2, Math.min(availableProcessors - 1, 4));
    MAXIMUM_POOL_SIZE = (availableProcessors * 2) + 1;
    sThreadFactory =
        new ThreadFactory() {
          private final AtomicInteger mCount = new AtomicInteger(1);

          @Override
          public Thread newThread(Runnable r) {
            return new Thread(r, "CrAsyncTask #" + this.mCount.getAndIncrement());
          }
        };
    sPoolWorkQueue = new ArrayBlockingQueue(128);
  }

  public ChromeThreadPoolExecutor() {
    this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
  }

  ChromeThreadPoolExecutor(
      int corePoolSize,
      int maximumPoolSize,
      long keepAliveTime,
      TimeUnit unit,
      BlockingQueue<Runnable> workQueue,
      ThreadFactory threadFactory) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    allowCoreThreadTimeOut(true);
  }

  private static String getClassName(Runnable runnable) {
    Class blamedClass = runnable.getClass();
    if (blamedClass == AsyncTask.NamedFutureTask.class) {
      blamedClass = ((AsyncTask.NamedFutureTask) runnable).getBlamedClass();
    } else if (blamedClass.getEnclosingClass() == android.os.AsyncTask.class) {
      blamedClass = android.os.AsyncTask.class;
    }
    return blamedClass.getName();
  }

  private Map<String, Integer> getNumberOfClassNameOccurrencesInQueue() {
    Map<String, Integer> counts = new HashMap<>();
    Runnable[] copiedQueue = (Runnable[]) getQueue().toArray(new Runnable[0]);
    for (Runnable runnable : copiedQueue) {
      String className = getClassName(runnable);
      int count = counts.containsKey(className) ? counts.get(className).intValue() : 0;
      counts.put(className, Integer.valueOf(count + 1));
    }
    return counts;
  }

  private String findClassNamesWithTooManyRunnables(Map<String, Integer> counts) {
    StringBuilder classesWithTooManyRunnables = new StringBuilder();
    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
      if (entry.getValue().intValue() > 32) {
        classesWithTooManyRunnables.append(entry.getKey()).append(' ');
      }
    }
    if (classesWithTooManyRunnables.length() == 0) {
      return "NO CLASSES FOUND";
    }
    return classesWithTooManyRunnables.toString();
  }

  @Override   public void execute(Runnable r) {
    try {
      super.execute(r);
    } catch (RejectedExecutionException e) {
      Map<String, Integer> counts = getNumberOfClassNameOccurrencesInQueue();
      throw new RejectedExecutionException(
          "Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(counts), e);
    }
  }
}
