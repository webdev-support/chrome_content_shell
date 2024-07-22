package org.chromium.gl.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class GlImplementation {
  public static final int GL_IMPLEMENTATION_DISABLED = 4;
  public static final int GL_IMPLEMENTATION_EGLANGLE = 5;
  public static final int GL_IMPLEMENTATION_EGLGLES2 = 1;
  public static final int GL_IMPLEMENTATION_MOCK_GL = 2;
  public static final int GL_IMPLEMENTATION_NONE = 0;
  public static final int GL_IMPLEMENTATION_STUB_GL = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private GlImplementation() {}
}
