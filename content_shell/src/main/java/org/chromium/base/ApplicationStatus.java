package org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import com.example.chromium_content_view.BuildConfig;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class ApplicationStatus {

  private static final String CACHE_ACTIVITY_TASKID_KEY = "cache_activity_taskid_enabled";
  private static final String TOOLBAR_CALLBACK_WRAPPER_CLASS =
      "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";
  private static Activity sActivity;
  private static ObserverList<ApplicationStateListener> sApplicationStateListeners;
  private static ObserverList<ActivityStateListener> sGeneralActivityStateListeners;
  private static ApplicationStateListener sNativeApplicationStateListener;
  private static ObserverList<TaskVisibilityListener> sTaskVisibilityListeners;
  private static ObserverList<WindowFocusChangedListener> sWindowFocusListeners;
  private static final Map<Activity, ActivityInfo> sActivityInfo =
      Collections.synchronizedMap(new HashMap());
  public static final Map<Activity, Integer> sActivityTaskId =
      Collections.synchronizedMap(new HashMap());
  private static int sCurrentApplicationState = 0;

  public interface ActivityStateListener {
    void onActivityStateChange(Activity activity, int i);
  }

  public interface ApplicationStateListener {
    void onApplicationStateChange(int i);
  }

  public interface Natives {
    void onApplicationStateChange(int i);
  }

  public interface TaskVisibilityListener {
    void onTaskVisibilityChanged(int i, boolean z);
  }

  public interface WindowFocusChangedListener {
    void onWindowFocusChanged(Activity activity, boolean z);
  }

  public static class ActivityInfo {
    private ObserverList<ActivityStateListener> mListeners;
    private int mStatus;

    private ActivityInfo() {
      this.mStatus = 6;
      this.mListeners = new ObserverList<>();
    }

    public int getStatus() {
      return this.mStatus;
    }

    public void setStatus(int status) {
      this.mStatus = status;
    }

    public ObserverList<ActivityStateListener> getListeners() {
      return this.mListeners;
    }
  }

  private ApplicationStatus() {}

  public static void registerWindowFocusChangedListener(WindowFocusChangedListener listener) {
    if (!isInitialized()) {
      throw new AssertionError();
    }
    if (sWindowFocusListeners == null) {
      sWindowFocusListeners = new ObserverList<>();
    }
    sWindowFocusListeners.addObserver(listener);
  }

  public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener listener) {
    ObserverList<WindowFocusChangedListener> observerList = sWindowFocusListeners;
    if (observerList == null) {
      return;
    }
    observerList.removeObserver(listener);
  }

  public static void registerTaskVisibilityListener(TaskVisibilityListener listener) {
    if (!isInitialized()) {
      throw new AssertionError();
    }
    if (sTaskVisibilityListeners == null) {
      sTaskVisibilityListeners = new ObserverList<>();
    }
    sTaskVisibilityListeners.addObserver(listener);
  }

  public static void unregisterTaskVisibilityListener(TaskVisibilityListener listener) {
    ObserverList<TaskVisibilityListener> observerList = sTaskVisibilityListeners;
    if (observerList == null) {
      return;
    }
    observerList.removeObserver(listener);
  }

  public static void setCachingEnabled(boolean enabled) {
    SharedPreferences.Editor editor = ContextUtils.getAppSharedPreferences().edit();
    editor.putBoolean(CACHE_ACTIVITY_TASKID_KEY, enabled).apply();
  }

  public static boolean isCachingEnabled() {
    StrictModeContext ignored = StrictModeContext.allowDiskReads();
    try {
      boolean z =
          ContextUtils.getAppSharedPreferences().getBoolean(CACHE_ACTIVITY_TASKID_KEY, false);
      if (ignored != null) {
        ignored.close();
      }
      return z;
    } catch (Throwable th) {
      if (ignored != null) {
        try {
          ignored.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public static int getTaskId(Activity activity) {
    if (isCachingEnabled()) {
      Map<Activity, Integer> map = sActivityTaskId;
      if (!map.containsKey(activity)) {
        synchronized (map) {
          map.put(activity, Integer.valueOf(activity.getTaskId()));
        }
      }
      return map.get(activity).intValue();
    }
    return activity.getTaskId();
  }

  public static class WindowCallbackProxy implements InvocationHandler {
    private final Activity mActivity;
    private final Window.Callback mCallback;

    public WindowCallbackProxy(Activity activity, Window.Callback callback) {
      this.mCallback = callback;
      this.mActivity = activity;
    }

    @Override     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      if (method.getName().equals("onWindowFocusChanged")
          && args.length == 1
          && (args[0] instanceof Boolean)) {
        onWindowFocusChanged(((Boolean) args[0]).booleanValue());
        return null;
      }
      try {
        return method.invoke(this.mCallback, args);
      } catch (InvocationTargetException e) {
        if (e.getCause() instanceof AbstractMethodError) {
          throw e.getCause();
        }
        throw e;
      }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
      this.mCallback.onWindowFocusChanged(hasFocus);
      if (ApplicationStatus.sWindowFocusListeners != null) {
        Iterator it = ApplicationStatus.sWindowFocusListeners.iterator();
        while (it.hasNext()) {
          WindowFocusChangedListener listener = (WindowFocusChangedListener) it.next();
          listener.onWindowFocusChanged(this.mActivity, hasFocus);
        }
      }
    }
  }

  public static boolean isInitialized() {
    boolean z;
    synchronized (sActivityInfo) {
      z = sCurrentApplicationState != 0;
    }
    return z;
  }

  public static void initialize(Application application) {
    if (isInitialized()) {
      throw new AssertionError();
    }
    synchronized (sActivityInfo) {
      sCurrentApplicationState = 4;
    }
    registerWindowFocusChangedListener(
        new WindowFocusChangedListener() {
          @Override
          public void onWindowFocusChanged(Activity activity, boolean hasFocus) {
            int state;
            if (hasFocus
                && activity != ApplicationStatus.sActivity
                && (state = ApplicationStatus.getStateForActivity(activity)) != 6
                && state != 5) {
              ApplicationStatus.sActivity = activity;
            }
          }
        });
    application.registerActivityLifecycleCallbacks(
        new Application.ActivityLifecycleCallbacks() {

          @Override
          public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            ApplicationStatus.onStateChange(activity, 1);
            Window.Callback callback = activity.getWindow().getCallback();
            activity
                .getWindow()
                .setCallback(ApplicationStatus.createWindowCallbackProxy(activity, callback));
          }

          @Override // android.app.Application.ActivityLifecycleCallbacks
          public void onActivityDestroyed(Activity activity) {
            ApplicationStatus.onStateChange(activity, 6);
            checkCallback(activity);
          }

          @Override // android.app.Application.ActivityLifecycleCallbacks
          public void onActivityPaused(Activity activity) {
            ApplicationStatus.onStateChange(activity, 4);
            checkCallback(activity);
          }

          @Override // android.app.Application.ActivityLifecycleCallbacks
          public void onActivityResumed(Activity activity) {
            ApplicationStatus.onStateChange(activity, 3);
            checkCallback(activity);
          }

          @Override // android.app.Application.ActivityLifecycleCallbacks
          public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            checkCallback(activity);
          }

          @Override // android.app.Application.ActivityLifecycleCallbacks
          public void onActivityStarted(Activity activity) {
            ApplicationStatus.onStateChange(activity, 2);
            checkCallback(activity);
          }

          @Override // android.app.Application.ActivityLifecycleCallbacks
          public void onActivityStopped(Activity activity) {
            ApplicationStatus.onStateChange(activity, 5);
            checkCallback(activity);
          }

          private void checkCallback(Activity activity) {
            if (BuildConfig.ENABLE_ASSERTS
                && !ApplicationStatus.reachesWindowCallback(activity.getWindow().getCallback())) {
              throw new AssertionError();
            }
          }
        });
  }

  static Window.Callback createWindowCallbackProxy(Activity activity, Window.Callback callback) {
    return (Window.Callback)
        Proxy.newProxyInstance(
            Window.Callback.class.getClassLoader(),
            new Class[] {Window.Callback.class},
            new WindowCallbackProxy(activity, callback));
  }

  static boolean reachesWindowCallback(Window.Callback callback) {
    Field[] declaredFields;
    if (callback == null) {
      return false;
    }
    if (callback.getClass().getName().equals(TOOLBAR_CALLBACK_WRAPPER_CLASS)) {
      return true;
    }
    if (Proxy.isProxyClass(callback.getClass())) {
      return Proxy.getInvocationHandler(callback) instanceof WindowCallbackProxy;
    }
    for (Class<?> c = callback.getClass(); c != Object.class; c = c.getSuperclass()) {
      for (Field f : c.getDeclaredFields()) {
        if (f.getType().isAssignableFrom(Window.Callback.class)) {
          boolean isAccessible = f.isAccessible();
          f.setAccessible(true);
          try {
            Window.Callback fieldCb = (Window.Callback) f.get(callback);
            f.setAccessible(isAccessible);
            if (reachesWindowCallback(fieldCb)) {
              return true;
            }
          } catch (IllegalAccessException e) {
            f.setAccessible(isAccessible);
          } catch (Throwable th) {
            f.setAccessible(isAccessible);
            throw th;
          }
        }
      }
    }
    return false;
  }

  public static void onStateChange(Activity activity, int newState) {
    ActivityInfo info;
    ObserverList<ApplicationStateListener> observerList;
    ObserverList<TaskVisibilityListener> observerList2;
    if (activity == null) {
      throw new AssertionError();
    }
    if (sActivity == null || newState == 1 || newState == 3 || newState == 2) {
      sActivity = activity;
    }
    int oldApplicationState = getStateForApplication();
    boolean oldTaskVisibility = isTaskVisible(getTaskId(activity));
    Map<Activity, ActivityInfo> map = sActivityInfo;
    synchronized (map) {
      if (newState == 1) {
        if (map.containsKey(activity)) {
          throw new AssertionError();
        }
        map.put(activity, new ActivityInfo());
      }
      info = map.get(activity);
      info.setStatus(newState);
      if (newState == 6) {
        map.remove(activity);
        if (activity == sActivity) {
          sActivity = null;
        }
      }
      sCurrentApplicationState = determineApplicationStateLocked();
    }
    Iterator<ActivityStateListener> it = info.getListeners().iterator();
    while (it.hasNext()) {
      ActivityStateListener listener = it.next();
      listener.onActivityStateChange(activity, newState);
    }
    ObserverList<ActivityStateListener> observerList3 = sGeneralActivityStateListeners;
    if (observerList3 != null) {
      Iterator<ActivityStateListener> it2 = observerList3.iterator();
      while (it2.hasNext()) {
        ActivityStateListener listener2 = it2.next();
        listener2.onActivityStateChange(activity, newState);
      }
    }
    boolean taskVisibility = isTaskVisible(getTaskId(activity));
    if (taskVisibility != oldTaskVisibility && (observerList2 = sTaskVisibilityListeners) != null) {
      Iterator<TaskVisibilityListener> it3 = observerList2.iterator();
      while (it3.hasNext()) {
        TaskVisibilityListener listener3 = it3.next();
        listener3.onTaskVisibilityChanged(getTaskId(activity), taskVisibility);
      }
    }
    int applicationState = getStateForApplication();
    if (applicationState != oldApplicationState
        && (observerList = sApplicationStateListeners) != null) {
      Iterator<ApplicationStateListener> it4 = observerList.iterator();
      while (it4.hasNext()) {
        ApplicationStateListener listener4 = it4.next();
        listener4.onApplicationStateChange(applicationState);
      }
    }
    Map<Activity, Integer> map2 = sActivityTaskId;
    synchronized (map2) {
      if (newState == 6) {
        map2.remove(activity);
      }
    }
  }

  public static void onStateChangeForTesting(Activity activity, int newState) {
    onStateChange(activity, newState);
  }

  public static Activity getLastTrackedFocusedActivity() {
    return sActivity;
  }

  public static List<Activity> getRunningActivities() {
    ArrayList arrayList;
    if (!isInitialized()) {
      throw new AssertionError();
    }
    Map<Activity, ActivityInfo> map = sActivityInfo;
    synchronized (map) {
      arrayList = new ArrayList(map.keySet());
    }
    return arrayList;
  }

  public static int getStateForActivity(Activity activity) {
    ActivityInfo info;
    if (!isInitialized()) {
      throw new AssertionError();
    }
    if (activity == null || (info = sActivityInfo.get(activity)) == null) {
      return 6;
    }
    return info.getStatus();
  }

  public static int getStateForApplication() {
    int i;
    synchronized (sActivityInfo) {
      i = sCurrentApplicationState;
    }
    return i;
  }

  public static boolean hasVisibleActivities() {
    if (!isInitialized()) {
      throw new AssertionError();
    }
    int state = getStateForApplication();
    return state == 1 || state == 2;
  }

  public static boolean isEveryActivityDestroyed() {
    if (!isInitialized()) {
      throw new AssertionError();
    }
    return sActivityInfo.isEmpty();
  }

  public static boolean isTaskVisible(int taskId) {
    int state;
    if (!isInitialized()) {
      throw new AssertionError();
    }
    for (Map.Entry<Activity, ActivityInfo> entry : sActivityInfo.entrySet()) {
      if (getTaskId(entry.getKey()) == taskId
          && ((state = entry.getValue().getStatus()) == 3 || state == 4)) {
        return true;
      }
    }
    return false;
  }

  public static boolean cleanupInvalidTask(int taskId) {
    List<Activity> inaccessibleActivities = new ArrayList<>();
    for (Map.Entry<Activity, Integer> activityTaskInfo : sActivityTaskId.entrySet()) {
      if (taskId == activityTaskInfo.getValue().intValue()) {
        inaccessibleActivities.add(activityTaskInfo.getKey());
      }
    }
    for (Activity activity : inaccessibleActivities) {
      onStateChange(activity, 6);
    }
    return !inaccessibleActivities.isEmpty();
  }

  public static void registerStateListenerForAllActivities(ActivityStateListener listener) {
    if (!isInitialized()) {
      throw new AssertionError();
    }
    if (sGeneralActivityStateListeners == null) {
      sGeneralActivityStateListeners = new ObserverList<>();
    }
    sGeneralActivityStateListeners.addObserver(listener);
  }

  public static void registerStateListenerForActivity(
      ActivityStateListener listener, Activity activity) {
    if (!isInitialized()) {
      throw new AssertionError();
    }
    if (activity == null) {
      throw new AssertionError();
    }
    ActivityInfo info = sActivityInfo.get(activity);
    if (info == null) {
      boolean isDestroyed = activity.isDestroyed();
      throw new AssertionError(
          "destroyed: " + isDestroyed + " finishing: " + activity.isFinishing());
    } else if (info.getStatus() == 6) {
      throw new AssertionError();
    } else {
      info.getListeners().addObserver(listener);
    }
  }

  public static void unregisterActivityStateListener(ActivityStateListener listener) {
    ObserverList<ActivityStateListener> observerList = sGeneralActivityStateListeners;
    if (observerList != null) {
      observerList.removeObserver(listener);
    }
    Map<Activity, ActivityInfo> map = sActivityInfo;
    synchronized (map) {
      for (ActivityInfo info : map.values()) {
        info.getListeners().removeObserver(listener);
      }
    }
  }

  public static void registerApplicationStateListener(ApplicationStateListener listener) {
    if (sApplicationStateListeners == null) {
      sApplicationStateListeners = new ObserverList<>();
    }
    sApplicationStateListeners.addObserver(listener);
  }

  public static void unregisterApplicationStateListener(ApplicationStateListener listener) {
    ObserverList<ApplicationStateListener> observerList = sApplicationStateListeners;
    if (observerList == null) {
      return;
    }
    observerList.removeObserver(listener);
  }

  public static void destroyForJUnitTests() {
    Map<Activity, ActivityInfo> map = sActivityInfo;
    synchronized (map) {
      ObserverList<ApplicationStateListener> observerList = sApplicationStateListeners;
      if (observerList != null) {
        observerList.clear();
      }
      ObserverList<ActivityStateListener> observerList2 = sGeneralActivityStateListeners;
      if (observerList2 != null) {
        observerList2.clear();
      }
      ObserverList<TaskVisibilityListener> observerList3 = sTaskVisibilityListeners;
      if (observerList3 != null) {
        observerList3.clear();
      }
      map.clear();
      sActivityTaskId.clear();
      ObserverList<WindowFocusChangedListener> observerList4 = sWindowFocusListeners;
      if (observerList4 != null) {
        observerList4.clear();
      }
      sCurrentApplicationState = 0;
      sActivity = null;
      sNativeApplicationStateListener = null;
    }
  }

  public static void resetActivitiesForInstrumentationTests() {
    if (!ThreadUtils.runningOnUiThread()) {
      throw new AssertionError();
    }
    Map<Activity, ActivityInfo> map = sActivityInfo;
    synchronized (map) {
      Iterator it = new HashSet(map.keySet()).iterator();
      while (it.hasNext()) {
        Activity activity = (Activity) it.next();
        if (activity.getApplication() != null) {
          throw new AssertionError(
              "Real activities that are launched should be closed by test code and not rely on this cleanup of mocks.");
        }
        onStateChangeForTesting(activity, 6);
      }
    }
  }

  private static void registerThreadSafeNativeApplicationStateListener() {
    ThreadUtils.runOnUiThread(
        new Runnable() {
          @Override
          public void run() {
            if (ApplicationStatus.sNativeApplicationStateListener != null) {
              return;
            }
            ApplicationStatus.sNativeApplicationStateListener =
                new ApplicationStateListener() {
                  @Override
                  public void onApplicationStateChange(int newState) {
                    ApplicationStatusJni.get().onApplicationStateChange(newState);
                  }
                };
            ApplicationStatus.registerApplicationStateListener(
                ApplicationStatus.sNativeApplicationStateListener);
          }
        });
  }

  private static int determineApplicationStateLocked() {
    boolean hasPausedActivity = false;
    boolean hasStoppedActivity = false;
    for (ActivityInfo info : sActivityInfo.values()) {
      int state = info.getStatus();
      if (state != 4 && state != 5 && state != 6) {
        return 1;
      }
      if (state == 4) {
        hasPausedActivity = true;
      } else if (state == 5) {
        hasStoppedActivity = true;
      }
    }
    if (hasPausedActivity) {
      return 2;
    }
    return hasStoppedActivity ? 3 : 4;
  }
}
