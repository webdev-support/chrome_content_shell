package org.chromium.net;

import android.content.Context;
import android.net.ConnectivityManager;
import org.chromium.base.ContextUtils;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeClassQualifiedName;

@JNINamespace("net")
public class NetworkActiveNotifier implements ConnectivityManager.OnNetworkActiveListener {
  private boolean mAreNotificationsEnabled;
  private final ConnectivityManager mConnectivityManager;
  private final long mNativeNetworkActiveObserver;

  public interface Natives {
    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyOfDefaultNetworkActive(long j);
  }

  public static NetworkActiveNotifier build(long nativeNetworkActiveNotifier) {
    return new NetworkActiveNotifier(nativeNetworkActiveNotifier);
  }

  public void enableNotifications() {
    this.mAreNotificationsEnabled = true;
    this.mConnectivityManager.addDefaultNetworkActiveListener(this);
  }

  public void disableNotifications() {
    this.mAreNotificationsEnabled = false;
    this.mConnectivityManager.removeDefaultNetworkActiveListener(this);
  }

  public boolean isDefaultNetworkActive() {
    return this.mConnectivityManager.isDefaultNetworkActive();
  }

  @Override // android.net.ConnectivityManager.OnNetworkActiveListener
  public void onNetworkActive() {
    NetworkActiveNotifierJni.get().notifyOfDefaultNetworkActive(this.mNativeNetworkActiveObserver);
  }

  public void fakeDefaultNetworkActive() {
    if (this.mAreNotificationsEnabled) {
      onNetworkActive();
    }
  }

  private NetworkActiveNotifier(long nativeNetworkActiveNotifier) {
    this.mNativeNetworkActiveObserver = nativeNetworkActiveNotifier;
    Context ctx = ContextUtils.getApplicationContext();
    this.mConnectivityManager = (ConnectivityManager) ctx.getSystemService("connectivity");
  }
}
