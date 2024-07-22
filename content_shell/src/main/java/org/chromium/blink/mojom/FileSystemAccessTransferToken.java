package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface FileSystemAccessTransferToken extends Interface {
  public static final Interface.Manager<FileSystemAccessTransferToken, Proxy> MANAGER =
      FileSystemAccessTransferToken_Internal.MANAGER;

  public interface GetInternalId_Response {
    void call(UnguessableToken unguessableToken);
  }

  public interface Proxy extends FileSystemAccessTransferToken, Interface.Proxy {}

  void clone(InterfaceRequest<FileSystemAccessTransferToken> interfaceRequest);

  void getInternalId(GetInternalId_Response getInternalId_Response);
}
