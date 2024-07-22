package org.chromium.base;

import java.util.Map;

public class JNIUtils {

  private static final String TAG = "JNIUtils";
  private static ClassLoader sJniClassLoader;

  private static ClassLoader getSplitClassLoader(String splitName) {
    if (!splitName.isEmpty()) {
      boolean isInstalled = BundleUtils.isIsolatedSplitInstalled(splitName);
      Log.i(
          TAG,
          "Init JNI Classloader for %s. isInstalled=%b",
          splitName,
          Boolean.valueOf(isInstalled));
      if (isInstalled) {
        return BundleUtils.getOrCreateSplitClassLoader(splitName);
      }
    }
    ClassLoader classLoader = sJniClassLoader;
    return classLoader != null ? classLoader : JNIUtils.class.getClassLoader();
  }

  public static void setClassLoader(ClassLoader classLoader) {
    sJniClassLoader = classLoader;
  }

  public static <K, V> void splitMap(Map<K, V> map, K[] outKeys, V[] outValues) {
    if (map.size() != outKeys.length) {
      throw new AssertionError();
    }
    if (outValues.length != outKeys.length) {
      throw new AssertionError();
    }
    int i = 0;
    for (Map.Entry<K, V> entry : map.entrySet()) {
      outKeys[i] = entry.getKey();
      outValues[i] = entry.getValue();
      i++;
    }
  }
}
