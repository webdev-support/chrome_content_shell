package org.chromium.net;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class NetworkActiveNotifierJni implements NetworkActiveNotifier.Natives {
  public static final JniStaticTestMocker<NetworkActiveNotifier.Natives> TEST_HOOKS =
      instance -> {
        if (!GEN_JNI.TESTING_ENABLED) {
          throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
        NetworkActiveNotifierJni.testInstance = instance;
      };
  private static NetworkActiveNotifier.Natives testInstance;

  NetworkActiveNotifierJni() {}

  @Override
  public void notifyOfDefaultNetworkActive(long nativePtr) {
    if (nativePtr == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_NetworkActiveNotifier_notifyOfDefaultNetworkActive(nativePtr);
  }

  public static NetworkActiveNotifier.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      NetworkActiveNotifier.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of NetworkActiveNotifier.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new NetworkActiveNotifierJni();
  }
}
