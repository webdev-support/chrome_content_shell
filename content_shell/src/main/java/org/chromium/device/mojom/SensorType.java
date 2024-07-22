package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SensorType {
  public static final int ABSOLUTE_ORIENTATION_EULER_ANGLES = 8;
  public static final int ABSOLUTE_ORIENTATION_QUATERNION = 9;
  public static final int ACCELEROMETER = 2;
  public static final int AMBIENT_LIGHT = 0;
  public static final int GRAVITY = 4;
  public static final int GYROSCOPE = 5;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LINEAR_ACCELERATION = 3;
  public static final int MAGNETOMETER = 6;
  public static final int MAX_VALUE = 11;
  public static final int MIN_VALUE = 0;
  public static final int PRESSURE = 7;
  public static final int PROXIMITY = 1;
  public static final int RELATIVE_ORIENTATION_EULER_ANGLES = 10;
  public static final int RELATIVE_ORIENTATION_QUATERNION = 11;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 11;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SensorType() {}
}
