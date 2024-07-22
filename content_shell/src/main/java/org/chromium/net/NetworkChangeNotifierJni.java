package org.chromium.net;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class NetworkChangeNotifierJni implements NetworkChangeNotifier.Natives {

  public static final JniStaticTestMocker<NetworkChangeNotifier.Natives> TEST_HOOKS =
      new JniStaticTestMocker<NetworkChangeNotifier.Natives>() {
        @Override
        public void setInstanceForTesting(NetworkChangeNotifier.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          NetworkChangeNotifierJni.testInstance = instance;
        }
      };
  private static NetworkChangeNotifier.Natives testInstance;

  NetworkChangeNotifierJni() {}

  @Override
  public void notifyConnectionCostChanged(
      long nativePtr, NetworkChangeNotifier caller, int newConnectionCost) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_NetworkChangeNotifier_notifyConnectionCostChanged(
        nativePtr, caller, newConnectionCost);
  }

  @Override
  public void notifyConnectionTypeChanged(
      long nativePtr, NetworkChangeNotifier caller, int newConnectionType, long defaultNetId) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(
        nativePtr, caller, newConnectionType, defaultNetId);
  }

  @Override
  public void notifyMaxBandwidthChanged(long nativePtr, NetworkChangeNotifier caller, int subType) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(
        nativePtr, caller, subType);
  }

  @Override
  public void notifyOfNetworkConnect(
      long nativePtr, NetworkChangeNotifier caller, long netId, int connectionType) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(
        nativePtr, caller, netId, connectionType);
  }

  @Override
  public void notifyOfNetworkDisconnect(long nativePtr, NetworkChangeNotifier caller, long netId) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(
        nativePtr, caller, netId);
  }

  @Override
  public void notifyOfNetworkSoonToDisconnect(
      long nativePtr, NetworkChangeNotifier caller, long netId) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(
        nativePtr, caller, netId);
  }

  @Override
  public void notifyPurgeActiveNetworkList(
      long nativePtr, NetworkChangeNotifier caller, long[] activeNetIds) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(
        nativePtr, caller, activeNetIds);
  }

  public static NetworkChangeNotifier.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      NetworkChangeNotifier.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of NetworkChangeNotifier.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new NetworkChangeNotifierJni();
  }
}
