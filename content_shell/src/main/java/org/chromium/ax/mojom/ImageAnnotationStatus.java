package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ImageAnnotationStatus {
  public static final int ANNOTATION_ADULT = 8;
  public static final int ANNOTATION_EMPTY = 7;
  public static final int ANNOTATION_PENDING = 5;
  public static final int ANNOTATION_PROCESS_FAILED = 9;
  public static final int ANNOTATION_SUCCEEDED = 6;
  public static final int ELIGIBLE_FOR_ANNOTATION = 3;
  public static final int INELIGIBLE_FOR_ANNOTATION = 2;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 9;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SILENTLY_ELIGIBLE_FOR_ANNOTATION = 4;
  public static final int WILL_NOT_ANNOTATE_DUE_TO_SCHEME = 1;

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

  private ImageAnnotationStatus() {}
}
