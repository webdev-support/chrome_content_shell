package org.chromium.base.version_info;

public class VersionInfo {
  public static boolean isLocalBuild() {
    return true;
  }

  public static boolean isCanaryBuild() {
    return false;
  }

  public static boolean isDevBuild() {
    return false;
  }

  public static boolean isBetaBuild() {
    return false;
  }

  public static boolean isStableBuild() {
    return false;
  }

  public static boolean isOfficialBuild() {
    return false;
  }

  public static String getProductVersion() {
    return VersionConstants.PRODUCT_VERSION;
  }

  public static int getProductMajorVersion() {
    return 123;
  }

  public static int getBuildVersion() {
    return VersionConstants.PRODUCT_BUILD_VERSION;
  }
}
