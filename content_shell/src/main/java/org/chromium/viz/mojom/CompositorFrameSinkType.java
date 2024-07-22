package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CompositorFrameSinkType {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LAYER_TREE = 3;
  public static final int MAX_VALUE = 3;
  public static final int MEDIA_STREAM = 2;
  public static final int MIN_VALUE = 0;
  public static final int UNSPECIFIED = 0;
  public static final int VIDEO = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CompositorFrameSinkType() {}
}
