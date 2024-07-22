package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.BitmapN32;
import org.chromium.url.mojom.Url;

public interface ContentIndexService extends Interface {
  public static final Interface.Manager<ContentIndexService, Proxy> MANAGER =
      ContentIndexService_Internal.MANAGER;
  public static final int MAX_ICON_RESOLUTION = 65536;

  public interface Add_Response {
    void call(int i);
  }

  public interface CheckOfflineCapability_Response {
    void call(boolean z);
  }

  public interface Delete_Response {
    void call(int i);
  }

  public interface GetDescriptions_Response {
    void call(int i, ContentDescription[] contentDescriptionArr);
  }

  public interface GetIconSizes_Response {
    void call(Size[] sizeArr);
  }

  public interface Proxy extends ContentIndexService, Interface.Proxy {}

  void add(
      long j,
      ContentDescription contentDescription,
      BitmapN32[] bitmapN32Arr,
      Url url,
      Add_Response add_Response);

  void checkOfflineCapability(
      long j, Url url, CheckOfflineCapability_Response checkOfflineCapability_Response);

  void delete(long j, String str, Delete_Response delete_Response);

  void getDescriptions(long j, GetDescriptions_Response getDescriptions_Response);

  void getIconSizes(int i, GetIconSizes_Response getIconSizes_Response);
}
