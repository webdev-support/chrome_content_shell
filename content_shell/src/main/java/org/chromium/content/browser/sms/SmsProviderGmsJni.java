package org.chromium.content.browser.sms;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class SmsProviderGmsJni implements SmsProviderGms.Natives {

  public static final JniStaticTestMocker<SmsProviderGms.Natives> TEST_HOOKS =
      new JniStaticTestMocker<SmsProviderGms.Natives>() {
        @Override
        public void setInstanceForTesting(SmsProviderGms.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          SmsProviderGmsJni.testInstance = instance;
        }
      };
  private static SmsProviderGms.Natives testInstance;

  SmsProviderGmsJni() {}

  @Override
  public void onCancel(long nativeSmsProviderGms) {
    if (nativeSmsProviderGms == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_sms_SmsProviderGms_onCancel(nativeSmsProviderGms);
  }

  @Override
  public void onNotAvailable(long nativeSmsProviderGms) {
    if (nativeSmsProviderGms == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_sms_SmsProviderGms_onNotAvailable(nativeSmsProviderGms);
  }

  @Override
  public void onReceive(long nativeSmsProviderGms, String sms, int backend) {
    if (nativeSmsProviderGms == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_sms_SmsProviderGms_onReceive(
        nativeSmsProviderGms, sms, backend);
  }

  @Override
  public void onTimeout(long nativeSmsProviderGms) {
    if (nativeSmsProviderGms == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_sms_SmsProviderGms_onTimeout(nativeSmsProviderGms);
  }

  public static SmsProviderGms.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      SmsProviderGms.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of SmsProviderGms.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new SmsProviderGmsJni();
  }
}
