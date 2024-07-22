package org.chromium.components.download;

import android.net.Uri;

public class DownloadDelegate {
  public String remapGenericMimeType(String mimeType, String url, String filename) {
    return mimeType;
  }

  public Uri parseOriginalUrl(String originalUrl) {
    return Uri.parse(originalUrl);
  }

  public boolean isDownloadOnSDCard(String filePath) {
    return false;
  }
}
