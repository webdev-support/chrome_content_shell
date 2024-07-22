package org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class PackageUtils {

  private static final char[] HEX_CHAR_LOOKUP = "0123456789ABCDEF".toCharArray();
  private static final String TAG = "PackageUtils";

  public static PackageInfo getPackageInfo(String packageName, int flags) {
    PackageManager pm = ContextUtils.getApplicationContext().getPackageManager();
    try {
      return pm.getPackageInfo(packageName, flags);
    } catch (PackageManager.NameNotFoundException e) {
      return null;
    }
  }

  public static int getPackageVersion(String packageName) {
    PackageInfo packageInfo = getPackageInfo(packageName, 0);
    if (packageInfo != null) {
      return packageInfo.versionCode;
    }
    return -1;
  }

  public static int getPackageVersion(Context unused, String packageName) {
    return getPackageVersion(packageName);
  }

  public static boolean isPackageInstalled(String packageName) {
    return getPackageInfo(packageName, 0) != null;
  }

  public static PackageInfo getApplicationPackageInfo(int flags) {
    PackageInfo ret = getPackageInfo(BuildInfo.getInstance().packageName, flags);
    if (ret == null) {
      throw new AssertionError();
    }
    return ret;
  }

  public static List<String> getCertificateSHA256FingerprintForPackage(String packageName) {
    Signature[] signatureArr;
    PackageInfo packageInfo = getPackageInfo(packageName, 64);
    if (packageInfo == null) {
      return null;
    }
    ArrayList<String> fingerprints = new ArrayList<>(packageInfo.signatures.length);
    for (Signature signature : packageInfo.signatures) {
      InputStream input = new ByteArrayInputStream(signature.toByteArray());
      try {
        X509Certificate certificate =
            (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(input);
        String hexString =
            byteArrayToHexString(
                MessageDigest.getInstance("SHA256").digest(certificate.getEncoded()));
        fingerprints.add(hexString);
      } catch (NoSuchAlgorithmException | CertificateException e) {
        Log.w(TAG, "Exception", (Throwable) e);
        return null;
      }
    }
    return fingerprints;
  }

  static String byteArrayToHexString(byte[] byteArray) {
    StringBuilder hexString = new StringBuilder((byteArray.length * 3) - 1);
    for (int i = 0; i < byteArray.length; i++) {
      char[] cArr = HEX_CHAR_LOOKUP;
      hexString.append(cArr[(byteArray[i] & 240) >>> 4]);
      hexString.append(cArr[byteArray[i] & 15]);
      if (i < byteArray.length - 1) {
        hexString.append(':');
      }
    }
    return hexString.toString();
  }

  private PackageUtils() {}
}
