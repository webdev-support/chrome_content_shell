package org.chromium.content.browser;

import org.chromium.base.Callback;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class TracingControllerAndroidImplJni implements TracingControllerAndroidImpl.Natives {

  public static final JniStaticTestMocker<TracingControllerAndroidImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<TracingControllerAndroidImpl.Natives>() {
        @Override
        public void setInstanceForTesting(TracingControllerAndroidImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          TracingControllerAndroidImplJni.testInstance = instance;
        }
      };
  private static TracingControllerAndroidImpl.Natives testInstance;

  TracingControllerAndroidImplJni() {}

  @Override
  public void destroy(long nativeTracingControllerAndroid, TracingControllerAndroidImpl caller) {
    if (nativeTracingControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_TracingControllerAndroidImpl_destroy(
        nativeTracingControllerAndroid, caller);
  }

  @Override
  public String getDefaultCategories(TracingControllerAndroidImpl caller) {
    return GEN_JNI.org_chromium_content_browser_TracingControllerAndroidImpl_getDefaultCategories(
        caller);
  }

  @Override
  public boolean getKnownCategoriesAsync(
      long nativeTracingControllerAndroid, TracingControllerAndroidImpl caller, Callback callback) {
    if (nativeTracingControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_TracingControllerAndroidImpl_getKnownCategoriesAsync(
            nativeTracingControllerAndroid, caller, callback);
  }

  @Override
  public boolean getTraceBufferUsageAsync(
      long nativeTracingControllerAndroid, TracingControllerAndroidImpl caller, Callback callback) {
    if (nativeTracingControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_TracingControllerAndroidImpl_getTraceBufferUsageAsync(
            nativeTracingControllerAndroid, caller, callback);
  }

  @Override
  public long init(TracingControllerAndroidImpl caller) {
    return GEN_JNI.org_chromium_content_browser_TracingControllerAndroidImpl_init(caller);
  }

  @Override
  public boolean startTracing(
      long nativeTracingControllerAndroid,
      TracingControllerAndroidImpl caller,
      String categories,
      String traceOptions,
      boolean useProtobuf) {
    if (nativeTracingControllerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_TracingControllerAndroidImpl_startTracing(
        nativeTracingControllerAndroid, caller, categories, traceOptions, useProtobuf);
  }

  @Override
  public void stopTracing(
      long nativeTracingControllerAndroid,
      TracingControllerAndroidImpl caller,
      String filename,
      boolean compressFile,
      boolean useProtobuf,
      Callback callback) {
    if (nativeTracingControllerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_TracingControllerAndroidImpl_stopTracing(
        nativeTracingControllerAndroid, caller, filename, compressFile, useProtobuf, callback);
  }

  public static TracingControllerAndroidImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      TracingControllerAndroidImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of TracingControllerAndroidImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new TracingControllerAndroidImplJni();
  }
}
