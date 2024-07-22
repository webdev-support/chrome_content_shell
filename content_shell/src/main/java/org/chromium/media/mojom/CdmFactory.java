package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CdmFactory extends Interface {
  public static final Interface.Manager<CdmFactory, Proxy> MANAGER = CdmFactory_Internal.MANAGER;

  public interface CreateCdm_Response {
    void call(ContentDecryptionModule contentDecryptionModule, CdmContext cdmContext, String str);
  }

  public interface Proxy extends CdmFactory, Interface.Proxy {}

  void createCdm(CdmConfig cdmConfig, CreateCdm_Response createCdm_Response);
}
