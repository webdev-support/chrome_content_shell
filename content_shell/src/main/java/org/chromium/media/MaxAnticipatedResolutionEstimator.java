package org.chromium.media;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Size;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.blink.mojom.WebFeature;
import org.chromium.device.nfc.NdefMessageUtils;

public class MaxAnticipatedResolutionEstimator {
  private static final int SCREEN_HEIGHT_4K = 2160;
  private static final int SCREEN_WIDTH_4K = 3840;
  private static final String TAG = "EstimateResolution";
  private Context mContext;
  private DisplayManager mDisplayManager;

  public static class Resolution {
    int mHeight;
    int mWidth;

    public Resolution(int width, int height) {
      this.mWidth = width;
      this.mHeight = height;
    }

    public int getWidth() {
      return this.mWidth;
    }

    public int getHeight() {
      return this.mHeight;
    }
  }

  private MaxAnticipatedResolutionEstimator() {}

  public static Resolution getScreenResolution(MediaFormat format) {
    Resolution resolution = getNativeResolution();
    if (resolution == null) {
      resolution.mWidth = format.getInteger("width");
      resolution.mHeight = format.getInteger("height");
    }
    String mimeType = format.getString(NdefMessageUtils.RECORD_TYPE_MIME);
    if (!mimeType.equals(MediaCodecUtil.MimeTypes.VIDEO_HEVC)
        && !mimeType.equals(MediaCodecUtil.MimeTypes.VIDEO_VP9)
        && !mimeType.equals(MediaCodecUtil.MimeTypes.VIDEO_AV1)
        && !mimeType.equals(MediaCodecUtil.MimeTypes.VIDEO_DV)) {
      resolution.mWidth =
          Math.min(resolution.mWidth, (int) WebFeature.MEDIA_STREAM_CONSTRAINTS_VIDEO);
      resolution.mHeight =
          Math.min(resolution.mHeight, (int) WebFeature.AUDIO_NODE_DISCONNECT_FROM_AUDIO_NODE);
    }
    return resolution;
  }

  public static Resolution getNativeResolution() {
    if (Build.VERSION.SDK_INT == 28 && !isNvidiaShield() && is4kVpxSupported()) {
      Log.d(
          TAG,
          "Assuming 4K display capabilities because we can decode VP9 4K video.",
          new Object[0]);
      return new Resolution(3840, SCREEN_HEIGHT_4K);
    }
    Context context = ContextUtils.getApplicationContext();
    DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
    DisplayCompat.ModeCompat[] supportedModes =
        DisplayCompat.getSupportedModes(context, displayManager.getDisplay(0));
    for (DisplayCompat.ModeCompat mode : supportedModes) {
      if (mode.isNative()) {
        return new Resolution(mode.getPhysicalWidth(), mode.getPhysicalHeight());
      }
    }
    return null;
  }

  private static boolean isNvidiaShield() {
    return "NVIDIA".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("SHIELD");
  }

  private static boolean is4kVpxSupported() {
    return ScreenResolutionUtil.isResolutionSupportedForType(
        MediaCodecUtil.MimeTypes.VIDEO_VP9, new Size(3840, SCREEN_HEIGHT_4K));
  }
}
