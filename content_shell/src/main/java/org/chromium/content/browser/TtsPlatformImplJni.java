package org.chromium.content.browser;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class TtsPlatformImplJni implements TtsPlatformImpl.Natives {

  public static final JniStaticTestMocker<TtsPlatformImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<TtsPlatformImpl.Natives>() {
        @Override
        public void setInstanceForTesting(TtsPlatformImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          TtsPlatformImplJni.testInstance = instance;
        }
      };
  private static TtsPlatformImpl.Natives testInstance;

  TtsPlatformImplJni() {}

  @Override
  public void onEndEvent(long nativeTtsPlatformImplAndroid, int utteranceId) {
    if (nativeTtsPlatformImplAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_TtsPlatformImpl_onEndEvent(
        nativeTtsPlatformImplAndroid, utteranceId);
  }

  @Override
  public void onErrorEvent(long nativeTtsPlatformImplAndroid, int utteranceId) {
    if (nativeTtsPlatformImplAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_TtsPlatformImpl_onErrorEvent(
        nativeTtsPlatformImplAndroid, utteranceId);
  }

  @Override
  public void onStartEvent(long nativeTtsPlatformImplAndroid, int utteranceId) {
    if (nativeTtsPlatformImplAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_TtsPlatformImpl_onStartEvent(
        nativeTtsPlatformImplAndroid, utteranceId);
  }

  @Override
  public void voicesChanged(long nativeTtsPlatformImplAndroid) {
    if (nativeTtsPlatformImplAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_TtsPlatformImpl_voicesChanged(
        nativeTtsPlatformImplAndroid);
  }

  public static TtsPlatformImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      TtsPlatformImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of TtsPlatformImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new TtsPlatformImplJni();
  }
}
