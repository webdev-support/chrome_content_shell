package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface AppBannerController extends Interface {
  public static final Interface.Manager<AppBannerController, Proxy> MANAGER =
      AppBannerController_Internal.MANAGER;

  public interface BannerPromptRequest_Response {
    void call(int i);
  }

  public interface Proxy extends AppBannerController, Interface.Proxy {}

  void bannerPromptRequest(
      AppBannerService appBannerService,
      InterfaceRequest<AppBannerEvent> interfaceRequest,
      String[] strArr,
      BannerPromptRequest_Response bannerPromptRequest_Response);
}
