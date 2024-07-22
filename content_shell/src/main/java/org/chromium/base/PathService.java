package org.chromium.base;

import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public abstract class PathService {
  public static final int DIR_MODULE = 3;

  public interface Natives {
    void override(int i, String str);
  }

  private PathService() {}

  public static void override(int what, String path) {
    PathServiceJni.get().override(what, path);
  }
}
