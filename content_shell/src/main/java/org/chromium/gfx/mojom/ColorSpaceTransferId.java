package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ColorSpaceTransferId {
  public static final int BT1361_ECG = 13;
  public static final int BT2020_10 = 15;
  public static final int BT2020_12 = 16;
  public static final int BT709 = 1;
  public static final int BT709_APPLE = 2;
  public static final int CUSTOM = 22;
  public static final int CUSTOM_HDR = 23;
  public static final int GAMMA18 = 3;
  public static final int GAMMA22 = 4;
  public static final int GAMMA24 = 5;
  public static final int GAMMA28 = 6;
  public static final int HLG = 19;
  public static final int IEC61966_2_4 = 12;
  public static final int INVALID = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LINEAR = 9;
  public static final int LINEAR_HDR = 21;
  public static final int LOG = 10;
  public static final int LOG_SQRT = 11;
  public static final int MAX_VALUE = 25;
  public static final int MIN_VALUE = 0;
  public static final int PIECEWISE_HDR = 24;

  public static final int f619PQ = 17;
  public static final int SCRGB_LINEAR_80_NITS = 25;
  public static final int SMPTE170M = 7;
  public static final int SMPTE240M = 8;
  public static final int SMPTEST428_1 = 18;
  public static final int SRGB = 14;
  public static final int SRGB_HDR = 20;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 25;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ColorSpaceTransferId() {}
}
