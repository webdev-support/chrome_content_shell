package org.chromium.content.browser.webid;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class DigitalIdentityProviderJni implements DigitalIdentityProvider.Natives {

  public static final JniStaticTestMocker<DigitalIdentityProvider.Natives> TEST_HOOKS =
      new JniStaticTestMocker<DigitalIdentityProvider.Natives>() {
        @Override
        public void setInstanceForTesting(DigitalIdentityProvider.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          DigitalIdentityProviderJni.testInstance = instance;
        }
      };
  private static DigitalIdentityProvider.Natives testInstance;

  DigitalIdentityProviderJni() {}

  @Override
  public void onError(long nativeDigitalIdentityProviderAndroid) {
    if (nativeDigitalIdentityProviderAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_webid_DigitalIdentityProvider_onError(
        nativeDigitalIdentityProviderAndroid);
  }

  @Override
  public void onReceive(long nativeDigitalIdentityProviderAndroid, String digitalIdentity) {
    if (nativeDigitalIdentityProviderAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_webid_DigitalIdentityProvider_onReceive(
        nativeDigitalIdentityProviderAndroid, digitalIdentity);
  }

  public static DigitalIdentityProvider.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      DigitalIdentityProvider.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of DigitalIdentityProvider.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new DigitalIdentityProviderJni();
  }
}
