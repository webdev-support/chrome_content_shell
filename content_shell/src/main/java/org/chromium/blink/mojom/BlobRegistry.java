package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.url.internal.mojom.Origin;

public interface BlobRegistry extends Interface {
  public static final Interface.Manager<BlobRegistry, Proxy> MANAGER =
      BlobRegistry_Internal.MANAGER;

  public interface GetBlobFromUuid_Response {
    void call();
  }

  public interface Proxy extends BlobRegistry, Interface.Proxy {}

  public interface RegisterFromStream_Response {
    void call(SerializedBlob serializedBlob);
  }

  public interface Register_Response {
    void call();
  }

  void getBlobFromUuid(
      InterfaceRequest<Blob> interfaceRequest,
      String str,
      GetBlobFromUuid_Response getBlobFromUuid_Response);

  void register(
      InterfaceRequest<Blob> interfaceRequest,
      String str,
      String str2,
      String str3,
      DataElement[] dataElementArr,
      Register_Response register_Response);

  void registerFromStream(
      String str,
      String str2,
      long j,
      DataPipe.ConsumerHandle consumerHandle,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      RegisterFromStream_Response registerFromStream_Response);

  void urlStoreForOrigin(
      Origin origin, AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);
}
