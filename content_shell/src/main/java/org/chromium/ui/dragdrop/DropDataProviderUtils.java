package org.chromium.ui.dragdrop;

import android.net.Uri;
import android.os.Bundle;
import org.chromium.base.ContextUtils;

public class DropDataProviderUtils {

  public static boolean clearImageCache(boolean imageIsInUse) {
    Bundle bundle = new Bundle();
    bundle.putBoolean(DropDataProviderImpl.IMAGE_USAGE_PARAM, imageIsInUse);
    try {
      ContextUtils.getApplicationContext()
          .getContentResolver()
          .call(
              DropDataProviderImpl.FULL_AUTH_URI,
              DropDataProviderImpl.ON_DRAG_END_METHOD_NAME,
              "",
              bundle);
      return true;
    } catch (IllegalArgumentException | NullPointerException e) {
      return false;
    }
  }

  public static boolean setClearCachedDataIntervalMs(int delay) {
    Bundle bundle = new Bundle();
    bundle.putInt(DropDataProviderImpl.CLEAR_CACHE_PARAM, delay);
    try {
      ContextUtils.getApplicationContext()
          .getContentResolver()
          .call(
              DropDataProviderImpl.FULL_AUTH_URI,
              DropDataProviderImpl.SET_INTERVAL_METHOD_NAME,
              "",
              bundle);
      return true;
    } catch (IllegalArgumentException | NullPointerException e) {
      return false;
    }
  }

  /* JADX WARN: Type inference failed for: r2v0, types: [byte[], java.io.Serializable] */
  public static Uri cacheImageData(DropDataAndroid dropData) {
    Bundle bundle = new Bundle();
    bundle.putSerializable(DropDataProviderImpl.BYTES_PARAM, dropData.imageContent);
    bundle.putString(
        DropDataProviderImpl.IMAGE_CONTENT_EXTENSION_PARAM, dropData.imageContentExtension);
    bundle.putString(DropDataProviderImpl.IMAGE_FILE_PARAM, dropData.imageFilename);
    try {
      Bundle cachedUriBundle =
          ContextUtils.getApplicationContext()
              .getContentResolver()
              .call(
                  DropDataProviderImpl.FULL_AUTH_URI,
                  DropDataProviderImpl.CACHE_METHOD_NAME,
                  "",
                  bundle);
      return (Uri) cachedUriBundle.getParcelable("uri");
    } catch (IllegalArgumentException | NullPointerException e) {
      return null;
    }
  }
}
