package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

public interface Decryptor extends Interface {
  public static final Interface.Manager<Decryptor, Proxy> MANAGER = Decryptor_Internal.MANAGER;

  public interface DecryptAndDecodeAudio_Response {
    void call(int i, AudioBuffer[] audioBufferArr);
  }

  public interface DecryptAndDecodeVideo_Response {
    void call(int i, VideoFrame videoFrame, FrameResourceReleaser frameResourceReleaser);
  }

  public interface Decrypt_Response {
    void call(int i, DecoderBuffer decoderBuffer);
  }

  public interface InitializeAudioDecoder_Response {
    void call(boolean z);
  }

  public interface InitializeVideoDecoder_Response {
    void call(boolean z);
  }

  public interface Proxy extends Decryptor, Interface.Proxy {}

  void cancelDecrypt(int i);

  void decrypt(int i, DecoderBuffer decoderBuffer, Decrypt_Response decrypt_Response);

  void decryptAndDecodeAudio(
      DecoderBuffer decoderBuffer, DecryptAndDecodeAudio_Response decryptAndDecodeAudio_Response);

  void decryptAndDecodeVideo(
      DecoderBuffer decoderBuffer, DecryptAndDecodeVideo_Response decryptAndDecodeVideo_Response);

  void deinitializeDecoder(int i);

  void initialize(
      DataPipe.ConsumerHandle consumerHandle,
      DataPipe.ConsumerHandle consumerHandle2,
      DataPipe.ConsumerHandle consumerHandle3,
      DataPipe.ProducerHandle producerHandle);

  void initializeAudioDecoder(
      AudioDecoderConfig audioDecoderConfig,
      InitializeAudioDecoder_Response initializeAudioDecoder_Response);

  void initializeVideoDecoder(
      VideoDecoderConfig videoDecoderConfig,
      InitializeVideoDecoder_Response initializeVideoDecoder_Response);

  void resetDecoder(int i);

  public static final class Status {
    private static final boolean IS_EXTENSIBLE = false;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return false;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Status() {}
  }

  public static final class StreamType {
    private static final boolean IS_EXTENSIBLE = false;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return false;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private StreamType() {}
  }
}
