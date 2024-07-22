package org.chromium.base;

import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public abstract class CpuFeatures {

  public interface Natives {
    int getCoreCount();

    long getCpuFeatures();
  }

  public static int getCount() {
    return CpuFeaturesJni.get().getCoreCount();
  }

  public static long getMask() {
    return CpuFeaturesJni.get().getCpuFeatures();
  }
}
