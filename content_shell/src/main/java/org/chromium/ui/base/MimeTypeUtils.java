package org.chromium.ui.base;

import android.os.Build;
import android.webkit.MimeTypeMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.BuildInfo;
import org.chromium.device.nfc.NdefMessageUtils;
import org.chromium.url.GURL;

public class MimeTypeUtils {
  public static final String CHROME_MIMETYPE_LINK = "chrome/link";
  public static final String CHROME_MIMETYPE_TAB = "chrome/tab";
  public static final String CHROME_MIMETYPE_TEXT = "chrome/text";
  public static final String IMAGE_MIME_TYPE = "image/*";
  public static final int NUM_MIME_TYPE_ENTRIES = 6;
  public static final String TEXT_MIME_TYPE = "text/plain";

  @Retention(RetentionPolicy.SOURCE)
  public @interface Type {
    public static final int AUDIO = 3;
    public static final int IMAGE = 2;
    public static final int PDF = 5;
    public static final int TEXT = 1;
    public static final int UNKNOWN = 0;
    public static final int VIDEO = 4;
  }

  public static int getMimeTypeForUrl(GURL url) {
    String type;
    String extension = MimeTypeMap.getFileExtensionFromUrl(url.getSpec());
    if (extension == null
        || (type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)) == null) {
      return 0;
    }
    if (type.startsWith(NdefMessageUtils.RECORD_TYPE_TEXT)) {
      return 1;
    }
    if (type.startsWith("image")) {
      return 2;
    }
    if (type.startsWith("audio")) {
      return 3;
    }
    if (type.startsWith("video")) {
      return 4;
    }
    if (!type.equals("application/pdf")) {
      return 0;
    }
    return 5;
  }

  public static String getPermissionNameForMimeType(int mimeType) {
    if (useExternalStoragePermission()) {
      return "android.permission.READ_EXTERNAL_STORAGE";
    }
    switch (mimeType) {
      case 2:
        return "android.permission.READ_MEDIA_IMAGES";
      case 3:
        return "android.permission.READ_MEDIA_AUDIO";
      case 4:
        return "android.permission.READ_MEDIA_VIDEO";
      default:
        return null;
    }
  }

  static boolean useExternalStoragePermission() {
    return Build.VERSION.SDK_INT < 33 || !BuildInfo.targetsAtLeastT();
  }
}
