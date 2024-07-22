package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class DocumentPolicyFeature {
  public static final int DEFAULT = 0;
  public static final int DOCUMENT_WRITE = 9;
  public static final int FONT_DISPLAY = 1;
  public static final int FORCE_LOAD_AT_TOP = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JS_PROFILING = 11;
  public static final int LAYOUT_ANIMATIONS = 8;
  public static final int LOSSLESS_IMAGES_MAX_BPP = 2;
  public static final int LOSSLESS_IMAGES_STRICT_MAX_BPP = 4;
  public static final int LOSSY_IMAGES_MAX_BPP = 5;
  public static final int MAX_VALUE = 12;
  public static final int MIN_VALUE = 0;
  public static final int OVERSIZED_IMAGES = 6;
  public static final int SYNC_SCRIPT = 10;
  public static final int SYNC_XHR = 12;
  public static final int UNSIZED_MEDIA = 7;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 12;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private DocumentPolicyFeature() {}
}
