package org.chromium.media.stable.mojom;

public final class ColorSpacePrimaryId {
  public static final int ADOBE_RGB = 12;
  public static final int APPLE_GENERIC_RGB = 13;
  public static final int BT2020 = 7;
  public static final int BT470BG = 3;
  public static final int BT470M = 2;
  public static final int BT709 = 1;
  public static final int CUSTOM = 15;
  public static final int DEFAULT_VALUE = 0;
  public static final int FILM = 6;
  public static final int INVALID = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 15;
  public static final int MIN_VALUE = 0;
  public static final int SMPTE170M = 4;
  public static final int SMPTE240M = 5;
  public static final int SMPTEST428_1 = 8;
  public static final int SMPTEST431_2 = 9;
  public static final int SMPTEST432_1 = 10;
  public static final int WIDE_GAMUT_COLOR_SPIN = 14;
  public static final int XYZ_D50 = 11;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 15;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private ColorSpacePrimaryId() {}
}
