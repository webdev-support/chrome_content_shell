package org.chromium.url;

import java.net.IDN;
import org.jni_zero.JNINamespace;

@JNINamespace("url::android")
public class IDNStringUtil {
  private static String idnToASCII(String src) {
    try {
      return IDN.toASCII(src, 2);
    } catch (Exception e) {
      return null;
    }
  }
}
