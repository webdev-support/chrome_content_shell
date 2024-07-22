package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.network.mojom.DataPipeGetter;
import org.chromium.network.mojom.HttpRequestHeaders;
import org.chromium.network.mojom.UrlLoader;
import org.chromium.network.mojom.UrlLoaderClient;

public interface Blob extends Interface {
  public static final Interface.Manager<Blob, Proxy> MANAGER = Blob_Internal.MANAGER;

  public interface CaptureSnapshot_Response {
    void call(long j, Time time);
  }

  public interface GetInternalUuid_Response {
    void call(String str);
  }

  public interface Proxy extends Blob, Interface.Proxy {}

  public interface ReadSideData_Response {
    void call(BigBuffer bigBuffer);
  }

  void asDataPipeGetter(InterfaceRequest<DataPipeGetter> interfaceRequest);

  void captureSnapshot(CaptureSnapshot_Response captureSnapshot_Response);

  void clone(InterfaceRequest<Blob> interfaceRequest);

  void getInternalUuid(GetInternalUuid_Response getInternalUuid_Response);

  void load(
      InterfaceRequest<UrlLoader> interfaceRequest,
      String str,
      HttpRequestHeaders httpRequestHeaders,
      UrlLoaderClient urlLoaderClient);

  void readAll(DataPipe.ProducerHandle producerHandle, BlobReaderClient blobReaderClient);

  void readRange(
      long j, long j2, DataPipe.ProducerHandle producerHandle, BlobReaderClient blobReaderClient);

  void readSideData(ReadSideData_Response readSideData_Response);
}
