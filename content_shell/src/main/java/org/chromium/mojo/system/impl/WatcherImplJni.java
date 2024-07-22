package org.chromium.mojo.system.impl;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class WatcherImplJni implements WatcherImpl.Natives {
  public static final JniStaticTestMocker<WatcherImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<WatcherImpl.Natives>() {
        @Override
        public void setInstanceForTesting(WatcherImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          WatcherImplJni.testInstance = instance;
        }
      };
  private static WatcherImpl.Natives testInstance;

  WatcherImplJni() {}

  @Override
  public void cancel(WatcherImpl caller, long implPtr) {
    GEN_JNI.org_chromium_mojo_system_impl_WatcherImpl_cancel(caller, implPtr);
  }

  @Override
  public long createWatcher(WatcherImpl caller) {
    return GEN_JNI.org_chromium_mojo_system_impl_WatcherImpl_createWatcher(caller);
  }

  @Override
  public void delete(WatcherImpl caller, long implPtr) {
    GEN_JNI.org_chromium_mojo_system_impl_WatcherImpl_delete(caller, implPtr);
  }

  @Override
  public int start(WatcherImpl caller, long implPtr, long mojoHandle, int flags) {
    return GEN_JNI.org_chromium_mojo_system_impl_WatcherImpl_start(
        caller, implPtr, mojoHandle, flags);
  }

  public static WatcherImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      WatcherImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of WatcherImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new WatcherImplJni();
  }
}
