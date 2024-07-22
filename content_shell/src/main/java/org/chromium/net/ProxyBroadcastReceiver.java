package org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class ProxyBroadcastReceiver extends BroadcastReceiver {
  private final ProxyChangeListener mListener;

  public ProxyBroadcastReceiver(ProxyChangeListener listener) {
    this.mListener = listener;
  }

  @Override // android.content.BroadcastReceiver
  public void onReceive(Context context, Intent intent) {
    if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
      this.mListener.updateProxyConfigFromConnectivityManager(intent);
    }
  }
}
