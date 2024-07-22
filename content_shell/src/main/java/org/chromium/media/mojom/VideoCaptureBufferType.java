package org.chromium.media.mojom;

public final class VideoCaptureBufferType {
  public static final int GPU_MEMORY_BUFFER = 3;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAILBOX_HOLDER = 2;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int SHARED_MEMORY = 0;
  public static final int SHARED_MEMORY_VIA_RAW_FILE_DESCRIPTOR_DEPRECATED = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private VideoCaptureBufferType() {}
}
