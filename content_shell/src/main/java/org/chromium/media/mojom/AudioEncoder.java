package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface AudioEncoder extends Interface {
  public static final Interface.Manager<AudioEncoder, Proxy> MANAGER =
      AudioEncoder_Internal.MANAGER;

  public interface Encode_Response {
    void call(EncoderStatus encoderStatus);
  }

  public interface Flush_Response {
    void call(EncoderStatus encoderStatus);
  }

  public interface Initialize_Response {
    void call(EncoderStatus encoderStatus);
  }

  public interface Proxy extends AudioEncoder, Interface.Proxy {}

  void encode(AudioBuffer audioBuffer, Encode_Response encode_Response);

  void flush(Flush_Response flush_Response);

  void initialize(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      AudioEncoderConfig audioEncoderConfig,
      Initialize_Response initialize_Response);
}
