package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.BitmapN32;

public interface BackgroundFetchService extends Interface {
  public static final Interface.Manager<BackgroundFetchService, Proxy> MANAGER =
      BackgroundFetchService_Internal.MANAGER;

  public interface Fetch_Response {
    void call(int i, BackgroundFetchRegistration backgroundFetchRegistration);
  }

  public interface GetDeveloperIds_Response {
    void call(int i, String[] strArr);
  }

  public interface GetIconDisplaySize_Response {
    void call(Size size);
  }

  public interface GetRegistration_Response {
    void call(int i, BackgroundFetchRegistration backgroundFetchRegistration);
  }

  public interface Proxy extends BackgroundFetchService, Interface.Proxy {}

  void fetch(
      long j,
      String str,
      FetchApiRequest[] fetchApiRequestArr,
      BackgroundFetchOptions backgroundFetchOptions,
      BitmapN32 bitmapN32,
      BackgroundFetchUkmData backgroundFetchUkmData,
      Fetch_Response fetch_Response);

  void getDeveloperIds(long j, GetDeveloperIds_Response getDeveloperIds_Response);

  void getIconDisplaySize(GetIconDisplaySize_Response getIconDisplaySize_Response);

  void getRegistration(long j, String str, GetRegistration_Response getRegistration_Response);
}
