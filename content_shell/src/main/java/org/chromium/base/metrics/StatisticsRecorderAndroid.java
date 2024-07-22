package org.chromium.base.metrics;

import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public final class StatisticsRecorderAndroid {

  public interface Natives {
    String toJson(int i);
  }

  private StatisticsRecorderAndroid() {}

  public static String toJson(int verbosityLevel) {
    return StatisticsRecorderAndroidJni.get().toJson(verbosityLevel);
  }
}
