package org.chromium.media.mojom;

public final class VideoCaptureFrameDropReason {
  public static final int ANDROID_API1_UNEXPECTED_DATA_LENGTH = 7;
  public static final int ANDROID_API2_ACQUIRED_IMAGE_IS_NULL = 8;
  public static final int ANDROID_GET_BYTE_ARRAY_ELEMENTS_FAILED = 6;
  public static final int ANDROID_THROTTLING = 5;
  public static final int BUFFER_POOL_BUFFER_ALLOCATION_FAILED = 15;
  public static final int BUFFER_POOL_MAX_BUFFER_COUNT_EXCEEDED = 14;
  public static final int CROP_VERSION_NOT_CURRENT_DEPRECATED = 26;
  public static final int DEVICE_CLIENT_FRAME_HAS_INVALID_FORMAT = 1;
  public static final int DEVICE_CLIENT_LIBYUV_CONVERT_TO_I420_FAILED = 2;
  public static final int GPU_MEMORY_BUFFER_MAP_FAILED = 27;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 28;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int RENDERER_SINK_FRAME_DELIVERER_IS_NOT_STARTED = 25;
  public static final int RESOLUTION_ADAPTER_FRAME_IS_NOT_VALID = 19;
  public static final int RESOLUTION_ADAPTER_FRAME_RATE_IS_HIGHER_THAN_REQUESTED = 22;
  public static final int RESOLUTION_ADAPTER_HAS_NO_CALLBACKS = 23;
  public static final int RESOLUTION_ADAPTER_TIMESTAMP_TOO_CLOSE_TO_PREVIOUS_DEPRECATED = 21;
  public static final int RESOLUTION_ADAPTER_WRAPPING_FRAME_FOR_CROPPING_FAILED = 20;
  public static final int SUB_CAPTURE_TARGET_VERSION_NOT_CURRENT = 28;
  public static final int V4L2_BUFFER_ERROR_FLAG_WAS_SET = 3;
  public static final int V4L2_INVALID_NUMBER_OF_BYTES_IN_BUFFER = 4;
  public static final int VIDEO_CAPTURE_IMPL_FAILED_TO_WRAP_DATA_AS_MEDIA_VIDEO_FRAME = 17;
  public static final int VIDEO_CAPTURE_IMPL_NOT_IN_STARTED_STATE = 16;
  public static final int VIDEO_TRACK_ADAPTER_HAS_NO_RESOLUTION_ADAPTERS = 18;

  public static final int f674x5dffd423 = 24;
  public static final int WIN_DIRECT_SHOW_FAILED_TO_GET_MEMORY_POINTER_FROM_MEDIA_SAMPLE = 10;
  public static final int WIN_DIRECT_SHOW_UNEXPECTED_SAMPLE_LENGTH = 9;
  public static final int WIN_MEDIA_FOUNDATION_GET_BUFFER_BY_INDEX_RETURNED_NULL = 13;
  public static final int WIN_MEDIA_FOUNDATION_LOCKING_BUFFER_DELIEVERED_NULLPTR = 12;
  public static final int WIN_MEDIA_FOUNDATION_RECEIVED_SAMPLE_IS_NULL = 11;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 28;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private VideoCaptureFrameDropReason() {}
}
