package org.chromium.media;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Size;

public class ScreenResolutionUtil {
  public static boolean isResolutionSupportedForType(String mimeType, Size targetResolution) {
    MediaCodecInfo.VideoCapabilities videoCapabilities;
    MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
    for (MediaCodecInfo codecInfo : codecInfos) {
      try {
        MediaCodecInfo.CodecCapabilities codecCapabilities =
            codecInfo.getCapabilitiesForType(mimeType);
        if (codecCapabilities != null
            && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null
            && videoCapabilities.isSizeSupported(
                targetResolution.getWidth(), targetResolution.getHeight())) {
          return true;
        }
      } catch (IllegalArgumentException e) {
      }
    }
    return false;
  }
}
