package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.GenericPendingReceiver;
import org.chromium.url.internal.mojom.Origin;

public interface FrameInterfaceFactory extends Interface {
  public static final Interface.Manager<FrameInterfaceFactory, Proxy> MANAGER =
      FrameInterfaceFactory_Internal.MANAGER;

  public interface GetCdmOrigin_Response {
    void call(Origin origin);
  }

  public interface Proxy extends FrameInterfaceFactory, Interface.Proxy {}

  void bindEmbedderReceiver(GenericPendingReceiver genericPendingReceiver);

  void createCdmStorage(InterfaceRequest<CdmStorage> interfaceRequest);

  void createProvisionFetcher(InterfaceRequest<ProvisionFetcher> interfaceRequest);

  void getCdmOrigin(GetCdmOrigin_Response getCdmOrigin_Response);
}
