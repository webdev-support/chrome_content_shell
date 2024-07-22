package org.chromium.net;

import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.base.metrics.ScopedSysTraceEvent;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeClassQualifiedName;

@JNINamespace("net")
public class NetworkChangeNotifier {

  private static NetworkChangeNotifier sInstance;
  private NetworkChangeNotifierAutoDetect mAutoDetector;
  private int mCurrentConnectionType = 0;
  private int mCurrentConnectionCost = 0;
  private final ArrayList<Long> mNativeChangeNotifiers = new ArrayList<>();
  private final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers =
      new ObserverList<>();

  public interface ConnectionTypeObserver {
    void onConnectionTypeChanged(int i);
  }

  public interface Natives {
    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyConnectionCostChanged(long j, NetworkChangeNotifier networkChangeNotifier, int i);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyConnectionTypeChanged(
        long j, NetworkChangeNotifier networkChangeNotifier, int i, long j2);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyMaxBandwidthChanged(long j, NetworkChangeNotifier networkChangeNotifier, int i);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyOfNetworkConnect(
        long j, NetworkChangeNotifier networkChangeNotifier, long j2, int i);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyOfNetworkDisconnect(long j, NetworkChangeNotifier networkChangeNotifier, long j2);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyOfNetworkSoonToDisconnect(
        long j, NetworkChangeNotifier networkChangeNotifier, long j2);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyPurgeActiveNetworkList(
        long j, NetworkChangeNotifier networkChangeNotifier, long[] jArr);
  }

  protected NetworkChangeNotifier() {}

  public static NetworkChangeNotifier init() {
    if (sInstance == null) {
      sInstance = new NetworkChangeNotifier();
    }
    return sInstance;
  }

  public static boolean isInitialized() {
    return sInstance != null;
  }

  public static void resetInstanceForTests() {
    sInstance = new NetworkChangeNotifier();
  }

  public static void resetInstanceForTests(NetworkChangeNotifier notifier) {
    sInstance = notifier;
  }

  public int getCurrentConnectionType() {
    return this.mCurrentConnectionType;
  }

  public int getCurrentConnectionSubtype() {
    ScopedSysTraceEvent event =
        ScopedSysTraceEvent.scoped("NetworkChangeNotifier.getCurrentConnectionSubtype");
    try {
      NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
      if (networkChangeNotifierAutoDetect != null) {
        networkChangeNotifierAutoDetect.updateCurrentNetworkState();
        int connectionSubtype = this.mAutoDetector.getCurrentNetworkState().getConnectionSubtype();
        if (event != null) {
          event.close();
        }
        return connectionSubtype;
      } else if (event != null) {
        event.close();
        return 0;
      } else {
        return 0;
      }
    } catch (Throwable th) {
      if (event != null) {
        try {
          event.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public int getCurrentConnectionCost() {
    return this.mCurrentConnectionCost;
  }

  public long getCurrentDefaultNetId() {
    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
    if (networkChangeNotifierAutoDetect == null) {
      return -1L;
    }
    return networkChangeNotifierAutoDetect.getDefaultNetId();
  }

  public long[] getCurrentNetworksAndTypes() {
    ScopedSysTraceEvent event =
        ScopedSysTraceEvent.scoped("NetworkChangeNotifierAutoDetect.getCurrentNetworksAndTypes");
    try {
      NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
      long[] networksAndTypes =
          networkChangeNotifierAutoDetect == null
              ? new long[0]
              : networkChangeNotifierAutoDetect.getNetworksAndTypes();
      if (event != null) {
        event.close();
      }
      return networksAndTypes;
    } catch (Throwable th) {
      if (event != null) {
        try {
          event.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public void addNativeObserver(long nativeChangeNotifier) {
    this.mNativeChangeNotifiers.add(Long.valueOf(nativeChangeNotifier));
  }

  public void removeNativeObserver(long nativeChangeNotifier) {
    this.mNativeChangeNotifiers.remove(Long.valueOf(nativeChangeNotifier));
  }

  public boolean registerNetworkCallbackFailed() {
    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
    if (networkChangeNotifierAutoDetect == null) {
      return false;
    }
    return networkChangeNotifierAutoDetect.registerNetworkCallbackFailed();
  }

  public static NetworkChangeNotifier getInstance() {
    NetworkChangeNotifier networkChangeNotifier = sInstance;
    if (networkChangeNotifier == null) {
      throw new AssertionError();
    }
    return networkChangeNotifier;
  }

  public static void setAutoDetectConnectivityState(boolean shouldAutoDetect) {
    getInstance()
        .setAutoDetectConnectivityStateInternal(
            shouldAutoDetect, new RegistrationPolicyApplicationStatus());
  }

  public static void registerToReceiveNotificationsAlways() {
    getInstance()
        .setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
  }

  public static void setAutoDetectConnectivityState(
      NetworkChangeNotifierAutoDetect.RegistrationPolicy policy) {
    getInstance().setAutoDetectConnectivityStateInternal(true, policy);
  }

  private void destroyAutoDetector() {
    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
    if (networkChangeNotifierAutoDetect != null) {
      networkChangeNotifierAutoDetect.destroy();
      this.mAutoDetector = null;
    }
  }

  private void setAutoDetectConnectivityStateInternal(
      boolean shouldAutoDetect, NetworkChangeNotifierAutoDetect.RegistrationPolicy policy) {
    ScopedSysTraceEvent event =
        ScopedSysTraceEvent.scoped("NetworkChangeNotifier.setAutoDetectConnectivityStateInternal");
    try {
      if (shouldAutoDetect) {
        if (this.mAutoDetector == null) {
          NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect =
              new NetworkChangeNotifierAutoDetect(
                  new NetworkChangeNotifierAutoDetect.Observer() {
                    @Override
                    public void onConnectionTypeChanged(int newConnectionType) {
                      NetworkChangeNotifier.this.updateCurrentConnectionType(newConnectionType);
                    }

                    @Override
                    public void onConnectionCostChanged(int newConnectionCost) {
                      NetworkChangeNotifier.this.notifyObserversOfConnectionCostChange(
                          newConnectionCost);
                    }

                    @Override
                    public void onConnectionSubtypeChanged(int newConnectionSubtype) {
                      NetworkChangeNotifier.this.notifyObserversOfConnectionSubtypeChange(
                          newConnectionSubtype);
                    }

                    @Override
                    public void onNetworkConnect(long netId, int connectionType) {
                      NetworkChangeNotifier.this.notifyObserversOfNetworkConnect(
                          netId, connectionType);
                    }

                    @Override
                    public void onNetworkSoonToDisconnect(long netId) {
                      NetworkChangeNotifier.this.notifyObserversOfNetworkSoonToDisconnect(netId);
                    }

                    @Override
                    public void onNetworkDisconnect(long netId) {
                      NetworkChangeNotifier.this.notifyObserversOfNetworkDisconnect(netId);
                    }

                    @Override
                    public void purgeActiveNetworkList(long[] activeNetIds) {
                      NetworkChangeNotifier.this.notifyObserversToPurgeActiveNetworkList(
                          activeNetIds);
                    }
                  },
                  policy);
          this.mAutoDetector = networkChangeNotifierAutoDetect;
          networkChangeNotifierAutoDetect.updateCurrentNetworkState();
          NetworkChangeNotifierAutoDetect.NetworkState networkState =
              this.mAutoDetector.getCurrentNetworkState();
          updateCurrentConnectionType(networkState.getConnectionType());
          updateCurrentConnectionCost(networkState.getConnectionCost());
          notifyObserversOfConnectionSubtypeChange(networkState.getConnectionSubtype());
        }
      } else {
        destroyAutoDetector();
      }
      if (event != null) {
        event.close();
      }
    } catch (Throwable th) {
      if (event != null) {
        try {
          event.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public static void forceConnectivityState(boolean networkAvailable) {
    setAutoDetectConnectivityState(false);
    getInstance().forceConnectivityStateInternal(networkAvailable);
  }

  private void forceConnectivityStateInternal(boolean forceOnline) {
    boolean connectionCurrentlyExists = this.mCurrentConnectionType != 6;
    if (connectionCurrentlyExists != forceOnline) {
      updateCurrentConnectionType(forceOnline ? 0 : 6);
      notifyObserversOfConnectionSubtypeChange(forceOnline ? 0 : 1);
    }
  }

  public static void fakeNetworkConnected(long netId, int connectionType) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfNetworkConnect(netId, connectionType);
  }

  public static void fakeNetworkSoonToBeDisconnected(long netId) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfNetworkSoonToDisconnect(netId);
  }

  public static void fakeNetworkDisconnected(long netId) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfNetworkDisconnect(netId);
  }

  public static void fakePurgeActiveNetworkList(long[] activeNetIds) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversToPurgeActiveNetworkList(activeNetIds);
  }

  public static void fakeDefaultNetwork(long netId, int connectionType) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfConnectionTypeChange(connectionType, netId);
  }

  public static void fakeConnectionCostChanged(int connectionCost) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfConnectionCostChange(connectionCost);
  }

  public static void fakeConnectionSubtypeChanged(int connectionSubtype) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfConnectionSubtypeChange(connectionSubtype);
  }

  public void updateCurrentConnectionType(int newConnectionType) {
    this.mCurrentConnectionType = newConnectionType;
    notifyObserversOfConnectionTypeChange(newConnectionType);
  }

  void notifyObserversOfConnectionTypeChange(int newConnectionType) {
    notifyObserversOfConnectionTypeChange(newConnectionType, getCurrentDefaultNetId());
  }

  private void notifyObserversOfConnectionTypeChange(int newConnectionType, long defaultNetId) {
    Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
    while (it.hasNext()) {
      Long nativeChangeNotifier = it.next();
      NetworkChangeNotifierJni.get()
          .notifyConnectionTypeChanged(
              nativeChangeNotifier.longValue(), this, newConnectionType, defaultNetId);
    }
    Iterator<ConnectionTypeObserver> it2 = this.mConnectionTypeObservers.iterator();
    while (it2.hasNext()) {
      ConnectionTypeObserver observer = it2.next();
      observer.onConnectionTypeChanged(newConnectionType);
    }
  }

  private void updateCurrentConnectionCost(int newConnectionCost) {
    this.mCurrentConnectionCost = newConnectionCost;
    notifyObserversOfConnectionCostChange(newConnectionCost);
  }

  void notifyObserversOfConnectionCostChange(int newConnectionCost) {
    Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
    while (it.hasNext()) {
      Long nativeChangeNotifier = it.next();
      NetworkChangeNotifierJni.get()
          .notifyConnectionCostChanged(nativeChangeNotifier.longValue(), this, newConnectionCost);
    }
  }

  void notifyObserversOfConnectionSubtypeChange(int connectionSubtype) {
    Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
    while (it.hasNext()) {
      Long nativeChangeNotifier = it.next();
      NetworkChangeNotifierJni.get()
          .notifyMaxBandwidthChanged(nativeChangeNotifier.longValue(), this, connectionSubtype);
    }
  }

  void notifyObserversOfNetworkConnect(long netId, int connectionType) {
    Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
    while (it.hasNext()) {
      Long nativeChangeNotifier = it.next();
      NetworkChangeNotifierJni.get()
          .notifyOfNetworkConnect(nativeChangeNotifier.longValue(), this, netId, connectionType);
    }
  }

  void notifyObserversOfNetworkSoonToDisconnect(long netId) {
    Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
    while (it.hasNext()) {
      Long nativeChangeNotifier = it.next();
      NetworkChangeNotifierJni.get()
          .notifyOfNetworkSoonToDisconnect(nativeChangeNotifier.longValue(), this, netId);
    }
  }

  void notifyObserversOfNetworkDisconnect(long netId) {
    Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
    while (it.hasNext()) {
      Long nativeChangeNotifier = it.next();
      NetworkChangeNotifierJni.get()
          .notifyOfNetworkDisconnect(nativeChangeNotifier.longValue(), this, netId);
    }
  }

  void notifyObserversToPurgeActiveNetworkList(long[] activeNetIds) {
    Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
    while (it.hasNext()) {
      Long nativeChangeNotifier = it.next();
      NetworkChangeNotifierJni.get()
          .notifyPurgeActiveNetworkList(nativeChangeNotifier.longValue(), this, activeNetIds);
    }
  }

  public static void addConnectionTypeObserver(ConnectionTypeObserver observer) {
    getInstance().addConnectionTypeObserverInternal(observer);
  }

  private void addConnectionTypeObserverInternal(ConnectionTypeObserver observer) {
    this.mConnectionTypeObservers.addObserver(observer);
  }

  public static void removeConnectionTypeObserver(ConnectionTypeObserver observer) {
    getInstance().removeConnectionTypeObserverInternal(observer);
  }

  private void removeConnectionTypeObserverInternal(ConnectionTypeObserver observer) {
    this.mConnectionTypeObservers.removeObserver(observer);
  }

  public static NetworkChangeNotifierAutoDetect getAutoDetectorForTest() {
    return getInstance().mAutoDetector;
  }

  public static boolean isOnline() {
    int connectionType = getInstance().getCurrentConnectionType();
    return connectionType != 6;
  }
}
