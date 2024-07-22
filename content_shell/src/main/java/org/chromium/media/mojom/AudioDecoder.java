package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface AudioDecoder extends Interface {
  public static final Manager<AudioDecoder, Proxy> MANAGER = AudioDecoder_Internal.MANAGER;

  public interface Decode_Response {
    void call(DecoderStatus decoderStatus);
  }

  public interface Initialize_Response {
    void call(DecoderStatus decoderStatus, boolean z, int i);
  }

  public interface Proxy extends AudioDecoder, Interface.Proxy {}

  public interface Reset_Response {
    void call();
  }

  void construct(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported, MediaLog mediaLog);

  void decode(DecoderBuffer decoderBuffer, Decode_Response decode_Response);

  void initialize(
      AudioDecoderConfig audioDecoderConfig,
      UnguessableToken unguessableToken,
      Initialize_Response initialize_Response);

  void reset(Reset_Response reset_Response);

  void setDataSource(DataPipe.ConsumerHandle consumerHandle);
}
