package org.chromium.net;

import org.jni_zero.JNINamespace;

@JNINamespace("net")
public final class HttpUtil {

  public interface Natives {
    boolean isAllowedHeader(String str, String str2);
  }

  public static boolean isAllowedHeader(String headerName, String headerValue) {
    return HttpUtilJni.get().isAllowedHeader(headerName, headerValue);
  }
}
