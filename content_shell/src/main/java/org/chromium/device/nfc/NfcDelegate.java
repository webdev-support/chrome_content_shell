package org.chromium.device.nfc;

import android.app.Activity;
import org.chromium.base.Callback;

public interface NfcDelegate {
  void stopTrackingActivityForHost(int i);

  void trackActivityForHost(int i, Callback<Activity> callback);
}
