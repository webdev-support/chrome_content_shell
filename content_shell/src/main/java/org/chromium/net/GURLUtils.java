package org.chromium.net;

import org.jni_zero.JNINamespace;

@JNINamespace("net")
public final class GURLUtils {

  public interface Natives {
    String getOrigin(String str);
  }

  public static String getOrigin(String url) {
    return GURLUtilsJni.get().getOrigin(url);
  }
}
