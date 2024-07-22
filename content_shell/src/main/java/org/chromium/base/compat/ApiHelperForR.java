package org.chromium.base.compat;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.view.Display;
import android.view.InputEvent;
import android.view.VerifiedInputEvent;
import android.view.WindowManager;
import java.io.File;

public final class ApiHelperForR {
  private ApiHelperForR() {}

  public static Display getDisplay(Context context) throws UnsupportedOperationException {
    return context.getDisplay();
  }

  public static File getVolumeDir(StorageManager manager, Uri uri) {
    return manager.getStorageVolume(uri).getDirectory();
  }

  public static VerifiedInputEvent verifyInputEvent(InputManager manager, InputEvent inputEvent) {
    return manager.verifyInputEvent(inputEvent);
  }

  public static void setProcessStateSummary(ActivityManager am, byte[] bytes) {
    am.setProcessStateSummary(bytes);
  }

  public static Rect getMaximumWindowMetricsBounds(WindowManager manager) {
    return manager.getMaximumWindowMetrics().getBounds();
  }
}
