package org.chromium.components.url_formatter;

import org.chromium.url.GURL;
import org.chromium.url.Origin;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class UrlFormatterJni implements UrlFormatter.Natives {
  public static final JniStaticTestMocker<UrlFormatter.Natives> TEST_HOOKS =
      new JniStaticTestMocker<UrlFormatter.Natives>() {
        @Override
        public void setInstanceForTesting(UrlFormatter.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          UrlFormatterJni.testInstance = instance;
        }
      };
  private static UrlFormatter.Natives testInstance;

  @Override
  public GURL fixupUrl(String url) {
    return (GURL) GEN_JNI.org_chromium_components_url_1formatter_UrlFormatter_fixupUrl(url);
  }

  @Override
  public String formatOriginForSecurityDisplay(Origin origin, int schemeDisplay) {
    return GEN_JNI
        .org_chromium_components_url_1formatter_UrlFormatter_formatOriginForSecurityDisplay(
            origin, schemeDisplay);
  }

  @Override
  public String formatStringUrlForSecurityDisplay(String url, int schemeDisplay) {
    return GEN_JNI
        .org_chromium_components_url_1formatter_UrlFormatter_formatStringUrlForSecurityDisplay(
            url, schemeDisplay);
  }

  @Override
  public String formatUrlForCopy(String url) {
    return GEN_JNI.org_chromium_components_url_1formatter_UrlFormatter_formatUrlForCopy(url);
  }

  @Override
  public String formatUrlForDisplayOmitHTTPScheme(String url) {
    return GEN_JNI
        .org_chromium_components_url_1formatter_UrlFormatter_formatUrlForDisplayOmitHTTPScheme(url);
  }

  @Override
  public String formatUrlForDisplayOmitScheme(String url) {
    return GEN_JNI
        .org_chromium_components_url_1formatter_UrlFormatter_formatUrlForDisplayOmitScheme(url);
  }

  @Override
  public String formatUrlForDisplayOmitSchemeOmitTrivialSubdomains(String url) {
    return GEN_JNI
        .org_chromium_components_url_1formatter_UrlFormatter_formatUrlForDisplayOmitSchemeOmitTrivialSubdomains(
            url);
  }

  @Override
  public String formatUrlForDisplayOmitSchemePathAndTrivialSubdomains(GURL url) {
    return GEN_JNI
        .org_chromium_components_url_1formatter_UrlFormatter_formatUrlForDisplayOmitSchemePathAndTrivialSubdomains(
            url);
  }

  @Override
  public String formatUrlForDisplayOmitUsernamePassword(String url) {
    return GEN_JNI
        .org_chromium_components_url_1formatter_UrlFormatter_formatUrlForDisplayOmitUsernamePassword(
            url);
  }

  @Override
  public String formatUrlForSecurityDisplay(GURL url, int schemeDisplay) {
    return GEN_JNI.org_chromium_components_url_1formatter_UrlFormatter_formatUrlForSecurityDisplay(
        url, schemeDisplay);
  }

  public static UrlFormatter.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      UrlFormatter.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of UrlFormatter.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new UrlFormatterJni();
  }
}
