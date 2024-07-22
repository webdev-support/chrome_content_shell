package org.chromium.media.stable.mojom;

public final class ColorSpaceMatrixId {
  public static final int BT2020_CL = 9;
  public static final int BT2020_NCL = 8;
  public static final int BT470BG = 4;
  public static final int BT709 = 2;
  public static final int DEFAULT_VALUE = 0;
  public static final int FCC = 3;
  public static final int GBR = 11;
  public static final int INVALID = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 11;
  public static final int MIN_VALUE = 0;
  public static final int RGB = 1;
  public static final int SMPTE170M = 5;
  public static final int SMPTE240M = 6;
  public static final int YCOCG = 7;
  public static final int YDZDX = 10;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 11;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private ColorSpaceMatrixId() {}
}
