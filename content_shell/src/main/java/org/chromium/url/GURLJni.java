package org.chromium.url;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class GURLJni implements GURL.Natives {
  public static final JniStaticTestMocker<GURL.Natives> TEST_HOOKS =
      new JniStaticTestMocker<GURL.Natives>() {
        @Override
        public void setInstanceForTesting(GURL.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          GURLJni.testInstance = instance;
        }
      };
  private static GURL.Natives testInstance;

  GURLJni() {}

  @Override
  public long createNative(String spec, boolean isValid, long nativeParsed) {
    return GEN_JNI.org_chromium_url_GURL_createNative(spec, isValid, nativeParsed);
  }

  @Override
  public boolean domainIs(String spec, boolean isValid, long nativeParsed, String domain) {
    return GEN_JNI.org_chromium_url_GURL_domainIs(spec, isValid, nativeParsed, domain);
  }

  @Override
  public void getOrigin(String spec, boolean isValid, long nativeParsed, GURL target) {
    GEN_JNI.org_chromium_url_GURL_getOrigin(spec, isValid, nativeParsed, target);
  }

  @Override
  public void init(String uri, GURL target) {
    GEN_JNI.org_chromium_url_GURL_init(uri, target);
  }

  @Override
  public void replaceComponents(
      String spec,
      boolean isValid,
      long nativeParsed,
      String username,
      boolean clearUsername,
      String password,
      boolean clearPassword,
      GURL result) {
    GEN_JNI.org_chromium_url_GURL_replaceComponents(
        spec, isValid, nativeParsed, username, clearUsername, password, clearPassword, result);
  }

  public static GURL.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      GURL.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of GURL.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new GURLJni();
  }
}
