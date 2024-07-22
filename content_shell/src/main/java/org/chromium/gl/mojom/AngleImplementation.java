package org.chromium.gl.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AngleImplementation {
  public static final int D3D11 = 2;
  public static final int D3D9 = 1;
  public static final int DEFAULT = 9;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 9;
  public static final int METAL = 8;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int NULL = 5;
  public static final int OPEN_GL = 3;
  public static final int OPEN_GLES = 4;
  public static final int SWIFT_SHADER = 7;
  public static final int VULKAN = 6;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 9;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private AngleImplementation() {}
}
