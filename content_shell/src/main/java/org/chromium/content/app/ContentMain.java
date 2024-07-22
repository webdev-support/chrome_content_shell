package org.chromium.content.app;

import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class ContentMain {

  public interface Natives {
    int start(boolean z);
  }

  public static int start(boolean startMinimalBrowser) {
    return ContentMainJni.get().start(startMinimalBrowser);
  }
}
