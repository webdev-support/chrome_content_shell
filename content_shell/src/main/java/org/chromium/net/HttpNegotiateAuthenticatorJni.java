package org.chromium.net;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class HttpNegotiateAuthenticatorJni implements HttpNegotiateAuthenticator.Natives {

  public static final JniStaticTestMocker<HttpNegotiateAuthenticator.Natives> TEST_HOOKS =
      new JniStaticTestMocker<HttpNegotiateAuthenticator.Natives>() {
        @Override
        public void setInstanceForTesting(HttpNegotiateAuthenticator.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          HttpNegotiateAuthenticatorJni.testInstance = instance;
        }
      };
  private static HttpNegotiateAuthenticator.Natives testInstance;

  HttpNegotiateAuthenticatorJni() {}

  @Override
  public void setResult(
      long nativeJavaNegotiateResultWrapper,
      HttpNegotiateAuthenticator caller,
      int status,
      String authToken) {
    if (nativeJavaNegotiateResultWrapper == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_net_HttpNegotiateAuthenticator_setResult(
        nativeJavaNegotiateResultWrapper, caller, status, authToken);
  }

  public static HttpNegotiateAuthenticator.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      HttpNegotiateAuthenticator.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of HttpNegotiateAuthenticator.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new HttpNegotiateAuthenticatorJni();
  }
}
