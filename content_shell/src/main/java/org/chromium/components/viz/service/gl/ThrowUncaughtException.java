package org.chromium.components.viz.service.gl;

import org.chromium.base.ThreadUtils;

abstract class ThrowUncaughtException {
  ThrowUncaughtException() {}

  private static void post() {
    ThreadUtils.postOnUiThread(
        new Runnable() {
          @Override
          public void run() {
            throw new RuntimeException("Intentional exception not caught by JNI");
          }
        });
  }
}
