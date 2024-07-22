package org.chromium.base.process_launcher;

import android.os.IBinder;

interface ChildServiceConnectionDelegate {
  void onServiceConnected(IBinder iBinder);

  void onServiceDisconnected();
}
