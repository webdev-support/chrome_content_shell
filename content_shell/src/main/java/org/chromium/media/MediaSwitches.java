package org.chromium.media;

public abstract class MediaSwitches {
  public static final String ALLOW_RA_IN_DEV_MODE = "allow-ra-in-dev-mode";
  public static final String ALSA_INPUT_DEVICE = "alsa-input-device";
  public static final String ALSA_OUTPUT_DEVICE = "alsa-output-device";
  public static final String AUDIO_BUFFER_SIZE = "audio-buffer-size";
  public static final String AUDIO_CAPTURER_WITH_ECHO_CANCELLATION =
      "audio-capturer-with-echo-cancellation";
  public static final String AUDIO_CODECS_FROM_EDID = "audio-codecs-from-edid";
  public static final String AUTOPLAY_NO_GESTURE_REQUIRED_POLICY =
      "autoplay-policy=no-user-gesture-required";
  public static final String AUTOPLAY_POLICY = "autoplay-policy";
  public static final String AUTO_GRANT_CAPTURED_SURFACE_CONTROL_PROMPT =
      "auto-grant-captured-surface-control-prompt";
  public static final String CAST_MIRRORING_TARGET_PLAYOUT_DELAY =
      "cast-mirroring-target-playout-delay";
  public static final String CAST_STREAMING_FORCE_DISABLE_HARDWARE_H264 =
      "cast-streaming-force-disable-hardware-h264";
  public static final String CAST_STREAMING_FORCE_DISABLE_HARDWARE_VP8 =
      "cast-streaming-force-disable-hardware-vp8";
  public static final String CAST_STREAMING_FORCE_ENABLE_HARDWARE_H264 =
      "cast-streaming-force-enable-hardware-h264";
  public static final String CAST_STREAMING_FORCE_ENABLE_HARDWARE_VP8 =
      "cast-streaming-force-enable-hardware-vp8";
  public static final String CLEAR_KEY_CDM_PATH_FOR_TESTING = "clear-key-cdm-path-for-testing";
  public static final String DISABLE_ACCELERATED_MJPEG_DECODE = "disable-accelerated-mjpeg-decode";
  public static final String DISABLE_AUDIO_INPUT = "disable-audio-input";
  public static final String DISABLE_AUDIO_OUTPUT = "disable-audio-output";
  public static final String DISABLE_BACKGROUND_MEDIA_SUSPEND = "disable-background-media-suspend";
  public static final String DISABLE_RTC_SMOOTHNESS_ALGORITHM = "disable-rtc-smoothness-algorithm";
  public static final String DOCUMENT_USER_ACTIVATION_REQUIRED_POLICY =
      "document-user-activation-required";
  public static final String ENABLE_EXCLUSIVE_AUDIO = "enable-exclusive-audio";
  public static final String ENABLE_LIVE_CAPTION_PREF_FOR_TESTING =
      "enable-live-caption-pref-for-testing";
  public static final String ENABLE_PRIMARY_NODE_ACCESS_FOR_VKMS_TESTING =
      "enable-primary-node-access-for-vkms-testing";
  public static final String ENABLE_PROTECTED_VIDEO_BUFFERS = "enable-protected-video-buffers";
  public static final String FAIL_AUDIO_STREAM_CREATION = "fail-audio-stream-creation";
  public static final String FORCE_PROTECTED_VIDEO_OUTPUT_BUFFERS =
      "force-protected-video-output-buffers";
  public static final String FORCE_VIDEO_OVERLAYS = "force-video-overlays";
  public static final String FORCE_WAVE_AUDIO = "force-wave-audio";
  public static final String HARDWARE_VIDEO_DECODE_FRAME_RATE = "hardware-video-decode-framerate";
  public static final String MIN_VIDEO_DECODER_OUTPUT_BUFFER_SIZE =
      "min-video-decoder-output-buffer-size";
  public static final String MSE_AUDIO_BUFFER_SIZE_LIMIT_MB = "mse-audio-buffer-size-limit-mb";
  public static final String MSE_VIDEO_BUFFER_SIZE_LIMIT_MB = "mse-video-buffer-size-limit-mb";
  public static final String MUTE_AUDIO = "mute-audio";
  public static final String NO_USER_GESTURE_REQUIRED_POLICY = "no-user-gesture-required";
  public static final String OVERRIDE_ENABLED_CDM_INTERFACE_VERSION =
      "override-enabled-cdm-interface-version";
  public static final String OVERRIDE_HARDWARE_SECURE_CODECS_FOR_TESTING =
      "override-hardware-secure-codecs-for-testing";
  public static final String REPORT_VP9_AS_AN_UNSUPPORTED_MIME_TYPE =
      "report-vp9-as-an-unsupported-mime-type";
  public static final String SYSTEM_AEC_ENABLED = "system-aec-enabled";
  public static final String TRY_SUPPORTED_CHANNEL_LAYOUTS = "try-supported-channel-layouts";
  public static final String UNSAFELY_ALLOW_PROTECTED_MEDIA_IDENTIFIER_FOR_DOMAIN =
      "unsafely-allow-protected-media-identifier-for-domain";
  public static final String USER_GESTURE_REQUIRED_POLICY = "user-gesture-required";
  public static final String USE_CRAS = "use-cras";
  public static final String USE_FAKE_DEVICE_FOR_MEDIA_STREAM = "use-fake-device-for-media-stream";
  public static final String USE_FAKE_MJPEG_DECODE_ACCELERATOR =
      "use-fake-mjpeg-decode-accelerator";
  public static final String USE_FILE_FOR_FAKE_AUDIO_CAPTURE = "use-file-for-fake-audio-capture";
  public static final String USE_FILE_FOR_FAKE_VIDEO_CAPTURE = "use-file-for-fake-video-capture";
  public static final String VIDEO_THREADS = "video-threads";
  public static final String WAVE_OUT_BUFFERS = "waveout-buffers";

  private MediaSwitches() {}
}
