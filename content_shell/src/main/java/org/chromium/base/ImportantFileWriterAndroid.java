package org.chromium.base;

import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class ImportantFileWriterAndroid {

  public interface Natives {
    boolean writeFileAtomically(String str, byte[] bArr);
  }

  public static boolean writeFileAtomically(String fileName, byte[] data) {
    return ImportantFileWriterAndroidJni.get().writeFileAtomically(fileName, data);
  }
}
