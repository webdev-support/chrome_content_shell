package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RendererType {
  public static final int CAST = 5;
  public static final int CAST_STREAMING = 9;
  public static final int CONTENT_EMBEDDER_DEFINED = 10;
  public static final int COURIER = 3;
  public static final int FLINGING = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 11;
  public static final int MEDIA_FOUNDATION = 6;
  public static final int MEDIA_PLAYER = 2;
  public static final int MIN_VALUE = 0;
  public static final int MOJO = 1;
  public static final int REMOTING = 8;
  public static final int RENDERER_IMPL = 0;
  public static final int TEST = 11;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 11:
        return true;
      case 7:
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private RendererType() {}
}
