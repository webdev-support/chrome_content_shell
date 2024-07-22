package org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import com.example.chromium_content_view.BuildConfig;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.chromium.base.compat.ApiHelperForO;
import org.chromium.base.metrics.RecordHistogram;

public class BundleUtils {

  private static final String LOADED_SPLITS_KEY = "split_compat_loaded_splits";
  private static final String TAG = "BundleUtils";
  private static Boolean sIsBundle;
  private static SplitCompatClassLoader sSplitCompatClassLoaderInstance;
  private static ArrayList<String> sSplitsToRestore;
  private static final Object sSplitLock = new Object();
  private static final ArrayMap<String, ClassLoader> sCachedClassLoaders = new ArrayMap<>();
  private static final Map<String, ClassLoader> sInflationClassLoaders =
      Collections.synchronizedMap(new ArrayMap());

  public static void resetForTesting() {
    sIsBundle = null;
    sCachedClassLoaders.clear();
    sInflationClassLoaders.clear();
    sSplitCompatClassLoaderInstance = null;
    sSplitsToRestore = null;
  }

  public static boolean isBundleForNative() {
    return isBundle();
  }

  public static boolean isBundle() {
    if (!BuildConfig.BUNDLES_SUPPORTED) {
      return false;
    }
    Boolean bool = sIsBundle;
    if (bool == null) {
      throw new AssertionError();
    }
    return bool.booleanValue();
  }

  public static void setIsBundle(boolean isBundle) {
    sIsBundle = Boolean.valueOf(isBundle);
  }

  public static boolean isolatedSplitsEnabled() {
    return BuildConfig.ISOLATED_SPLITS_ENABLED;
  }

  private static String getSplitApkPath(String splitName) {
    int idx;
    ApplicationInfo appInfo = ContextUtils.getApplicationContext().getApplicationInfo();
    String[] splitNames = appInfo.splitNames;
    if (splitNames != null && (idx = Arrays.binarySearch(splitNames, splitName)) >= 0) {
      return appInfo.splitSourceDirs[idx];
    }
    return null;
  }

  public static boolean isIsolatedSplitInstalled(String splitName) {
    return getSplitApkPath(splitName) != null;
  }

  public static Object getSplitContextLock() {
    return sSplitLock;
  }

  public static Context createIsolatedSplitContext(Context base, String splitName) {
    Context context;
    Context context2;
    try {
      if (isApplicationContext(base)) {
        context2 = ApiHelperForO.createContextForSplit(base, splitName);
      } else {
        synchronized (getSplitContextLock()) {
          context = ApiHelperForO.createContextForSplit(base, splitName);
        }
        context2 = context;
      }
      ClassLoader parent = context2.getClassLoader().getParent();
      Context appContext = ContextUtils.getApplicationContext();
      boolean shouldReplaceClassLoader =
          (!isolatedSplitsEnabled()
                  || parent.equals(BundleUtils.class.getClassLoader())
                  || appContext == null
                  || parent.equals(appContext.getClassLoader()))
              ? false
              : true;
      ArrayMap<String, ClassLoader> arrayMap = sCachedClassLoaders;
      synchronized (arrayMap) {
        if (shouldReplaceClassLoader && !arrayMap.containsKey(splitName)) {
          String apkPath = getSplitApkPath(splitName);
          arrayMap.put(splitName, new PathClassLoader(apkPath, appContext.getClassLoader()));
        }
        ClassLoader cachedClassLoader = arrayMap.get(splitName);
        if (cachedClassLoader != null) {
          if (!cachedClassLoader.equals(context2.getClassLoader())) {
            shouldReplaceClassLoader = true;
            replaceClassLoader(context2, cachedClassLoader);
          }
        } else {
          arrayMap.put(splitName, context2.getClassLoader());
        }
      }
      RecordHistogram.recordBooleanHistogram(
          "Android.IsolatedSplits.ClassLoaderReplaced." + splitName, shouldReplaceClassLoader);
      return context2;
    } catch (PackageManager.NameNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static void replaceClassLoader(Context baseContext, ClassLoader classLoader) {
    while (baseContext instanceof ContextWrapper) {
      baseContext = ((ContextWrapper) baseContext).getBaseContext();
    }
    try {
      Field classLoaderField = baseContext.getClass().getDeclaredField("mClassLoader");
      classLoaderField.setAccessible(true);
      classLoaderField.set(baseContext, classLoader);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException("Error setting ClassLoader.", e);
    }
  }

  public static String getNativeLibraryPath(String libraryName, String splitName) {
    StrictModeContext ignored = StrictModeContext.allowDiskReads();
    try {
      String path =
          ((BaseDexClassLoader) BundleUtils.class.getClassLoader()).findLibrary(libraryName);
      if (path == null) {
        ClassLoader classLoader = ContextUtils.getApplicationContext().getClassLoader();
        if (classLoader instanceof BaseDexClassLoader) {
          path = ((BaseDexClassLoader) classLoader).findLibrary(libraryName);
        } else if (classLoader instanceof WrappedClassLoader) {
          path = ((WrappedClassLoader) classLoader).findLibrary(libraryName);
        }
        if (path == null) {
          String splitApkLibraryPath = getSplitApkLibraryPath(libraryName, splitName);
          if (ignored != null) {
            ignored.close();
          }
          return splitApkLibraryPath;
        }
        if (ignored != null) {
          ignored.close();
        }
        return path;
      }
      if (ignored != null) {
        ignored.close();
      }
      return path;
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

  public static void checkContextClassLoader(Context baseContext, Activity activity) {
    ClassLoader activityClassLoader = activity.getClass().getClassLoader();
    ClassLoader contextClassLoader = baseContext.getClassLoader();
    if (activityClassLoader != contextClassLoader) {
      Log.w(
          TAG,
          "Mismatched ClassLoaders between Activity and context (fixing): %s",
          activity.getClass());
      replaceClassLoader(baseContext, activityClassLoader);
    }
  }

  public static Object newInstance(Context context, String className) {
    Context appContext = ContextUtils.getApplicationContext();
    if (appContext != null && canLoadClass(appContext.getClassLoader(), className)) {
      context = appContext;
    }
    try {
      return context.getClassLoader().loadClass(className).newInstance();
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }

  public static Context createContextForInflation(Context context, String splitName) {
    if (!isIsolatedSplitInstalled(splitName)) {
      return context;
    }
    final ClassLoader splitClassLoader = registerSplitClassLoaderForInflation(splitName);
    return new ContextWrapper(context) {
      @Override
      public ClassLoader getClassLoader() {
        return splitClassLoader;
      }

      @Override
      public Object getSystemService(String name) {
        Object ret = super.getSystemService(name);
        if ("layout_inflater".equals(name)) {
          return ((LayoutInflater) ret).cloneInContext(this);
        }
        return ret;
      }
    };
  }

  public static ClassLoader getOrCreateSplitClassLoader(String splitName) {
    ClassLoader ret;
    ArrayMap<String, ClassLoader> arrayMap = sCachedClassLoaders;
    synchronized (arrayMap) {
      ret = arrayMap.get(splitName);
    }
    if (ret == null) {
      createIsolatedSplitContext(ContextUtils.getApplicationContext(), splitName);
      synchronized (arrayMap) {
        ret = arrayMap.get(splitName);
        if (ret == null) {
          throw new AssertionError();
        }
      }
    }
    return ret;
  }

  public static ClassLoader registerSplitClassLoaderForInflation(String splitName) {
    ClassLoader splitClassLoader = getOrCreateSplitClassLoader(splitName);
    sInflationClassLoaders.put(splitName, splitClassLoader);
    return splitClassLoader;
  }

  public static boolean canLoadClass(ClassLoader classLoader, String className) {
    try {
      Class.forName(className, false, classLoader);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }

  public static ClassLoader getSplitCompatClassLoader() {
    if (sSplitCompatClassLoaderInstance == null) {
      sSplitCompatClassLoaderInstance = new SplitCompatClassLoader();
    }
    return sSplitCompatClassLoaderInstance;
  }

  public static void saveLoadedSplits(Bundle outState) {
    outState.putStringArrayList(
        LOADED_SPLITS_KEY, new ArrayList<>(sInflationClassLoaders.keySet()));
  }

  public static void restoreLoadedSplits(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      return;
    }
    sSplitsToRestore = savedInstanceState.getStringArrayList(LOADED_SPLITS_KEY);
  }

  private static class SplitCompatClassLoader extends ClassLoader {
    private static final String TAG = "SplitCompatClassLoader";

    public SplitCompatClassLoader() {
      super(ContextUtils.getApplicationContext().getClassLoader());
      Log.i(TAG, "Splits: %s", BundleUtils.sSplitsToRestore);
    }

    private Class<?> checkSplitsClassLoaders(String className) throws ClassNotFoundException {
      Iterator it = BundleUtils.sInflationClassLoaders.values().iterator();
      while (it.hasNext()) {
        ClassLoader cl = (ClassLoader) it.next();
        try {
          return cl.loadClass(className);
        } catch (ClassNotFoundException e) {
        }
      }
      return null;
    }

    @Override     public Class<?> findClass(String cn) throws ClassNotFoundException {
      Class<?> foundClass = checkSplitsClassLoaders(cn);
      if (foundClass != null) {
        return foundClass;
      }
      if (!cn.startsWith("android.")) {
        if (BundleUtils.sSplitsToRestore != null) {
          restoreSplitsClassLoaders();
          Class<?> foundClass2 = checkSplitsClassLoaders(cn);
          if (foundClass2 != null) {
            return foundClass2;
          }
        }
        Log.d(
            TAG,
            "No class %s amongst %s",
            cn,
            TextUtils.join("\n", BundleUtils.sInflationClassLoaders.keySet()));
      }
      throw new ClassNotFoundException(cn);
    }

    private void restoreSplitsClassLoaders() {
      Iterator it = BundleUtils.sSplitsToRestore.iterator();
      while (it.hasNext()) {
        String splitName = (String) it.next();
        if (!BundleUtils.sInflationClassLoaders.containsKey(splitName)) {
          BundleUtils.registerSplitClassLoaderForInflation(splitName);
        }
      }
      BundleUtils.sSplitsToRestore = null;
    }
  }

  private static String getSplitApkLibraryPath(String libraryName, String splitName) {
    String apkPath = getSplitApkPath(splitName);
    if (apkPath == null) {
      return null;
    }
    try {
      ApplicationInfo info = ContextUtils.getApplicationContext().getApplicationInfo();
      String primaryCpuAbi = (String) info.getClass().getField("primaryCpuAbi").get(info);
      return apkPath + "!/lib/" + primaryCpuAbi + "/" + System.mapLibraryName(libraryName);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }

  private static boolean isApplicationContext(Context context) {
    while (context instanceof ContextWrapper) {
      if (context instanceof Application) {
        return true;
      }
      context = ((ContextWrapper) context).getBaseContext();
    }
    return false;
  }
}
