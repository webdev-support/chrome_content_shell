package org.chromium.content_public.browser;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.List;
import org.chromium.url.GURL;

public interface ImageDownloadCallback {
  void onFinishDownloadImage(int i, int i2, GURL gurl, List<Bitmap> list, List<Rect> list2);
}
