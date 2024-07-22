package org.chromium.components.url_formatter;

import android.text.TextUtils;
import org.chromium.url.GURL;
import org.chromium.url.Origin;
import org.jni_zero.JNINamespace;

@JNINamespace("url_formatter::android")
public final class UrlFormatter {

  public interface Natives {
    GURL fixupUrl(String str);

    String formatOriginForSecurityDisplay(Origin origin, int i);

    String formatStringUrlForSecurityDisplay(String str, int i);

    String formatUrlForCopy(String str);

    String formatUrlForDisplayOmitHTTPScheme(String str);

    String formatUrlForDisplayOmitScheme(String str);

    String formatUrlForDisplayOmitSchemeOmitTrivialSubdomains(String str);

    String formatUrlForDisplayOmitSchemePathAndTrivialSubdomains(GURL gurl);

    String formatUrlForDisplayOmitUsernamePassword(String str);

    String formatUrlForSecurityDisplay(GURL gurl, int i);
  }

  public static GURL fixupUrl(String uri) {
    if (TextUtils.isEmpty(uri)) {
      return GURL.emptyGURL();
    }
    GURL.ensureNativeInitializedForGURL();
    return UrlFormatterJni.get().fixupUrl(uri);
  }

  public static String formatUrlForDisplayOmitScheme(String uri) {
    return UrlFormatterJni.get().formatUrlForDisplayOmitScheme(uri);
  }

  public static String formatUrlForDisplayOmitHTTPScheme(String uri) {
    return UrlFormatterJni.get().formatUrlForDisplayOmitHTTPScheme(uri);
  }

  public static String formatUrlForDisplayOmitSchemeOmitTrivialSubdomains(String uri) {
    return UrlFormatterJni.get().formatUrlForDisplayOmitSchemeOmitTrivialSubdomains(uri);
  }

  public static String formatUrlForDisplayOmitSchemePathAndTrivialSubdomains(GURL uri) {
    return UrlFormatterJni.get().formatUrlForDisplayOmitSchemePathAndTrivialSubdomains(uri);
  }

  public static String formatUrlForDisplayOmitUsernamePassword(String uri) {
    return UrlFormatterJni.get().formatUrlForDisplayOmitUsernamePassword(uri);
  }

  public static String formatUrlForCopy(String uri) {
    return UrlFormatterJni.get().formatUrlForCopy(uri);
  }

  public static String formatUrlForSecurityDisplay(String url) {
    return UrlFormatterJni.get().formatStringUrlForSecurityDisplay(url, 0);
  }

  public static String formatUrlForSecurityDisplay(GURL url, int schemeDisplay) {
    return url == null ? "" : UrlFormatterJni.get().formatUrlForSecurityDisplay(url, schemeDisplay);
  }

  public static String formatOriginForSecurityDisplay(Origin origin, int schemeDisplay) {
    return origin == null
        ? ""
        : UrlFormatterJni.get().formatOriginForSecurityDisplay(origin, schemeDisplay);
  }

  @Deprecated
  public static String formatUrlForSecurityDisplay(String uri, int schemeDisplay) {
    return UrlFormatterJni.get().formatStringUrlForSecurityDisplay(uri, schemeDisplay);
  }
}
