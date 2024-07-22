package org.chromium.mojo.system.impl;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class BaseRunLoopJni implements BaseRunLoop.Natives {
  public static final JniStaticTestMocker<BaseRunLoop.Natives> TEST_HOOKS =
      new JniStaticTestMocker<BaseRunLoop.Natives>() {
        @Override
        public void setInstanceForTesting(BaseRunLoop.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          BaseRunLoopJni.testInstance = instance;
        }
      };
  private static BaseRunLoop.Natives testInstance;

  BaseRunLoopJni() {}

  @Override
  public long createBaseRunLoop(BaseRunLoop caller) {
    return GEN_JNI.org_chromium_mojo_system_impl_BaseRunLoop_createBaseRunLoop(caller);
  }

  @Override
  public void deleteMessageLoop(BaseRunLoop caller, long runLoopID) {
    GEN_JNI.org_chromium_mojo_system_impl_BaseRunLoop_deleteMessageLoop(caller, runLoopID);
  }

  @Override
  public void postDelayedTask(BaseRunLoop caller, long runLoopID, Runnable runnable, long delay) {
    GEN_JNI.org_chromium_mojo_system_impl_BaseRunLoop_postDelayedTask(
        caller, runLoopID, runnable, delay);
  }

  @Override
  public void run(BaseRunLoop caller) {
    GEN_JNI.org_chromium_mojo_system_impl_BaseRunLoop_run(caller);
  }

  @Override
  public void runUntilIdle(BaseRunLoop caller) {
    GEN_JNI.org_chromium_mojo_system_impl_BaseRunLoop_runUntilIdle(caller);
  }

  public static BaseRunLoop.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      BaseRunLoop.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of BaseRunLoop.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new BaseRunLoopJni();
  }
}
