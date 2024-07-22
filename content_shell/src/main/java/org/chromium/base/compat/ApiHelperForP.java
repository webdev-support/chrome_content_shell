package org.chromium.base.compat;

import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.LinkProperties;
import android.os.LocaleList;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;

public final class ApiHelperForP {
  private ApiHelperForP() {}

  public static boolean isPrivateDnsActive(LinkProperties linkProperties) {
    return linkProperties.isPrivateDnsActive();
  }

  public static String getPrivateDnsServerName(LinkProperties linkProperties) {
    return linkProperties.getPrivateDnsServerName();
  }

  public static long getLongVersionCode(PackageInfo packageInfo) {
    return packageInfo.getLongVersionCode();
  }

  public static boolean isLocationEnabled(LocationManager locationManager) {
    return locationManager.isLocationEnabled();
  }

  public static SignalStrength getSignalStrength(TelephonyManager telephonyManager) {
    return telephonyManager.getSignalStrength();
  }

  public static void clearPrimaryClip(ClipboardManager clipboardManager) {
    clipboardManager.clearPrimaryClip();
  }

  public static boolean hasSigningCertificate(
      PackageManager pm, String packageName, byte[] certificate, int type) {
    return pm.hasSigningCertificate(packageName, certificate, type);
  }

  public static TextSelection suggestSelection(
      TextClassifier textClassifier, TextSelection.Request request) {
    return textClassifier.suggestSelection(request);
  }

  public static TextSelection.Request.Builder newTextSelectionRequestBuilder(
      CharSequence text, int startIndex, int endIndex) {
    return new TextSelection.Request.Builder(text, startIndex, endIndex);
  }

  public static TextSelection.Request.Builder setDefaultLocales(
      TextSelection.Request.Builder builder, LocaleList defaultLocales) {
    return builder.setDefaultLocales(defaultLocales);
  }

  public static TextSelection.Request build(TextSelection.Request.Builder builder) {
    return builder.build();
  }
}
