package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface FileBackedBlobFactory extends Interface {
  public static final Interface.Manager<FileBackedBlobFactory, Proxy> MANAGER =
      FileBackedBlobFactory_Internal.MANAGER;

  public interface Proxy extends FileBackedBlobFactory, Interface.Proxy {}

  public interface RegisterBlobSync_Response {
    void call();
  }

  void registerBlob(
      InterfaceRequest<Blob> interfaceRequest,
      String str,
      String str2,
      DataElementFile dataElementFile);

  void registerBlobSync(
      InterfaceRequest<Blob> interfaceRequest,
      String str,
      String str2,
      DataElementFile dataElementFile,
      RegisterBlobSync_Response registerBlobSync_Response);
}
