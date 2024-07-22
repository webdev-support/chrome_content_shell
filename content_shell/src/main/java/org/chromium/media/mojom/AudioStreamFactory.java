package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface AudioStreamFactory extends Interface {
  public static final Interface.Manager<AudioStreamFactory, Proxy> MANAGER =
      AudioStreamFactory_Internal.MANAGER;

  public interface CreateInputStream_Response {
    void call(
        ReadOnlyAudioDataPipe readOnlyAudioDataPipe, boolean z, UnguessableToken unguessableToken);
  }

  public interface CreateLoopbackStream_Response {
    void call(ReadOnlyAudioDataPipe readOnlyAudioDataPipe);
  }

  public interface CreateOutputStream_Response {
    void call(ReadWriteAudioDataPipe readWriteAudioDataPipe);
  }

  public interface Proxy extends AudioStreamFactory, Interface.Proxy {}

  void associateInputAndOutputForAec(UnguessableToken unguessableToken, String str);

  void bindMuter(
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported,
      UnguessableToken unguessableToken);

  void createInputStream(
      InterfaceRequest<AudioInputStream> interfaceRequest,
      AudioInputStreamClient audioInputStreamClient,
      AudioInputStreamObserver audioInputStreamObserver,
      AudioLog audioLog,
      String str,
      AudioParameters audioParameters,
      int i,
      boolean z,
      ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion,
      AudioProcessingConfig audioProcessingConfig,
      CreateInputStream_Response createInputStream_Response);

  void createLoopbackStream(
      InterfaceRequest<AudioInputStream> interfaceRequest,
      AudioInputStreamClient audioInputStreamClient,
      AudioInputStreamObserver audioInputStreamObserver,
      AudioParameters audioParameters,
      int i,
      UnguessableToken unguessableToken,
      CreateLoopbackStream_Response createLoopbackStream_Response);

  void createOutputStream(
      InterfaceRequest<AudioOutputStream> interfaceRequest,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      AudioLog audioLog,
      String str,
      AudioParameters audioParameters,
      UnguessableToken unguessableToken,
      CreateOutputStream_Response createOutputStream_Response);
}
