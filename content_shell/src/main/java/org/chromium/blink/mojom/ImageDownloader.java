package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.BitmapN32;
import org.chromium.url.mojom.Url;

public interface ImageDownloader extends Interface {
  public static final Interface.Manager<ImageDownloader, Proxy> MANAGER =
      ImageDownloader_Internal.MANAGER;

  public interface DownloadImage_Response {
    void call(int i, BitmapN32[] bitmapN32Arr, Size[] sizeArr);
  }

  public interface Proxy extends ImageDownloader, Interface.Proxy {}

  void downloadImage(
      Url url,
      boolean z,
      Size size,
      int i,
      boolean z2,
      DownloadImage_Response downloadImage_Response);
}
