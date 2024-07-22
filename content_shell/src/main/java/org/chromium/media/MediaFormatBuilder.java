package org.chromium.media;

import android.media.MediaFormat;
import android.os.Build;
import java.nio.ByteBuffer;
import org.chromium.base.ContextUtils;
import org.chromium.device.nfc.NdefMessageUtils;

class MediaFormatBuilder {
  MediaFormatBuilder() {}

  public static MediaFormat createVideoDecoderFormat(
      String mime,
      int width,
      int height,
      byte[][] csds,
      HdrMetadata hdrMetadata,
      boolean allowAdaptivePlayback) {
    MediaFormat format = MediaFormat.createVideoFormat(mime, width, height);
    if (format == null) {
      return null;
    }
    setCodecSpecificData(format, csds);
    if (hdrMetadata != null) {
      hdrMetadata.addMetadataToFormat(format);
    }
    addInputSizeInfoToFormat(format, allowAdaptivePlayback);
    return format;
  }

  public static MediaFormat createVideoEncoderFormat(
      String mime,
      int width,
      int height,
      int bitrateMode,
      int bitRate,
      int frameRate,
      int iFrameInterval,
      int colorFormat,
      boolean allowAdaptivePlayback) {
    MediaFormat format = MediaFormat.createVideoFormat(mime, width, height);
    format.setInteger("bitrate", bitRate);
    format.setInteger("frame-rate", frameRate);
    format.setInteger("i-frame-interval", iFrameInterval);
    format.setInteger("color-format", colorFormat);
    format.setInteger("bitrate-mode", bitrateMode);
    addInputSizeInfoToFormat(format, allowAdaptivePlayback);
    return format;
  }

  public static MediaFormat createAudioFormat(
      String mime, int sampleRate, int channelCount, byte[][] csds, boolean frameHasAdtsHeader) {
    MediaFormat format = MediaFormat.createAudioFormat(mime, sampleRate, channelCount);
    setCodecSpecificData(format, csds);
    if (frameHasAdtsHeader) {
      format.setInteger("is-adts", 1);
    }
    return format;
  }

  private static void setCodecSpecificData(MediaFormat format, byte[][] csds) {
    for (int i = 0; i < csds.length; i++) {
      if (csds[i].length != 0) {
        String name = "csd-" + i;
        format.setByteBuffer(name, ByteBuffer.wrap(csds[i]));
      }
    }
  }

  /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
  private static void addInputSizeInfoToFormat(MediaFormat format, boolean allowAdaptivePlayback) {
    char c;
    int maxPixels;
    int minCompressionRatio;
    if (allowAdaptivePlayback) {
      if (DisplayCompat.isTv(ContextUtils.getApplicationContext())) {
        MaxAnticipatedResolutionEstimator.Resolution resolution =
            MaxAnticipatedResolutionEstimator.getScreenResolution(format);
        format.setInteger("max-width", resolution.getWidth());
        format.setInteger("max-height", resolution.getHeight());
      } else {
        format.setInteger("max-width", format.getInteger("width"));
        format.setInteger("max-height", format.getInteger("height"));
      }
    }
    if (format.containsKey("max-input-size")) {
      return;
    }
    int maxHeight = Math.max(128, format.getInteger("height"));
    if (allowAdaptivePlayback && format.containsKey("max-height")) {
      maxHeight = Math.max(maxHeight, format.getInteger("max-height"));
    }
    int maxWidth = Math.max(128, format.getInteger("width"));
    if (allowAdaptivePlayback && format.containsKey("max-width")) {
      maxWidth = Math.max(maxHeight, format.getInteger("max-width"));
    }
    String string = format.getString(NdefMessageUtils.RECORD_TYPE_MIME);
    switch (string.hashCode()) {
      case -1662735862:
        if (string.equals(MediaCodecUtil.MimeTypes.VIDEO_AV1)) {
          c = 4;
          break;
        }
        c = 65535;
        break;
      case -1662541442:
        if (string.equals(MediaCodecUtil.MimeTypes.VIDEO_HEVC)) {
          c = 2;
          break;
        }
        c = 65535;
        break;
      case 1331836730:
        if (string.equals(MediaCodecUtil.MimeTypes.VIDEO_H264)) {
          c = 0;
          break;
        }
        c = 65535;
        break;
      case 1599127256:
        if (string.equals(MediaCodecUtil.MimeTypes.VIDEO_VP8)) {
          c = 1;
          break;
        }
        c = 65535;
        break;
      case 1599127257:
        if (string.equals(MediaCodecUtil.MimeTypes.VIDEO_VP9)) {
          c = 3;
          break;
        }
        c = 65535;
        break;
      default:
        c = 65535;
        break;
    }
    switch (c) {
      case 0:
        if ("BRAVIA 4K 2015".equals(Build.MODEL)) {
          return;
        }
        maxPixels = ((maxWidth + 15) / 16) * ((maxHeight + 15) / 16) * 16 * 16;
        minCompressionRatio = 2;
        break;
      case 1:
        maxPixels = maxWidth * maxHeight;
        minCompressionRatio = 2;
        break;
      case 2:
      case 3:
      case 4:
        maxPixels = maxWidth * maxHeight;
        minCompressionRatio = 4;
        break;
      default:
        return;
    }
    int maxInputSize = (maxPixels * 3) / (minCompressionRatio * 2);
    format.setInteger("max-input-size", maxInputSize);
  }
}
