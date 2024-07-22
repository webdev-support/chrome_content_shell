package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class BufferUsage {
  public static final int CAMERA_AND_CPU_READ_WRITE = 3;
  public static final int GPU_READ = 0;
  public static final int GPU_READ_CPU_READ_WRITE = 7;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 10;
  public static final int MIN_VALUE = 0;
  public static final int PROTECTED_SCANOUT_VDA_WRITE = 6;
  public static final int SCANOUT = 1;
  public static final int SCANOUT_CAMERA_READ_WRITE = 2;
  public static final int SCANOUT_CPU_READ_WRITE = 4;
  public static final int SCANOUT_FRONT_RENDERING = 10;
  public static final int SCANOUT_VDA_WRITE = 5;
  public static final int SCANOUT_VEA_CPU_READ = 8;
  public static final int VEA_READ_CAMERA_AND_CPU_READ_WRITE = 9;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 10;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private BufferUsage() {}
}
