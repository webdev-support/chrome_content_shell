package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface FileSystemAccessDataTransferToken extends Interface {
  public static final Interface.Manager<FileSystemAccessDataTransferToken, Proxy> MANAGER =
      FileSystemAccessDataTransferToken_Internal.MANAGER;

  public interface GetInternalId_Response {
    void call(UnguessableToken unguessableToken);
  }

  public interface Proxy extends FileSystemAccessDataTransferToken, Interface.Proxy {}

  void clone(InterfaceRequest<FileSystemAccessDataTransferToken> interfaceRequest);

  void getInternalId(GetInternalId_Response getInternalId_Response);
}
