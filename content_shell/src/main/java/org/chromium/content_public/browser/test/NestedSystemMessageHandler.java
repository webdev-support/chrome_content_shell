package org.chromium.content_public.browser.test;

import android.os.Handler;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class NestedSystemMessageHandler {
  private static final int QUIT_MESSAGE = 10;
  private static final Handler sHandler = new Handler();

  private NestedSystemMessageHandler() {}

  private static boolean dispatchOneMessage() {
    // TODO
    return false;
    /*
        try {
          LooperUtils.runSingleNestedLooperTask();
          return true;
        } catch (IllegalAccessException
            | IllegalArgumentException
            | SecurityException
            | InvocationTargetException e) {
          e.printStackTrace();
          return false;
        }
    */
  }

  private static void postQuitMessage() {
    Handler handler = sHandler;
    handler.sendMessage(handler.obtainMessage(10));
  }
}
