package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VideoEncoderUseCase {
  public static final int CAST_MIRRORING = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MEDIA_RECORDER = 1;
  public static final int MIN_VALUE = 0;
  public static final int WEB_CODECS = 2;
  public static final int WEB_RTC = 3;

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

  private VideoEncoderUseCase() {}
}
