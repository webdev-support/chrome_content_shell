package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface AttributionHost extends Interface {
  public static final Interface.Manager<AttributionHost, Proxy> MANAGER =
      AttributionHost_Internal.MANAGER;

  public interface Proxy extends AttributionHost, Interface.Proxy {}

  void notifyNavigationWithBackgroundRegistrationsWillStart(
      AttributionSrcToken attributionSrcToken, int i);

  void registerDataHost(InterfaceRequest<AttributionDataHost> interfaceRequest, int i);

  void registerNavigationDataHost(
      InterfaceRequest<AttributionDataHost> interfaceRequest,
      AttributionSrcToken attributionSrcToken);
}
