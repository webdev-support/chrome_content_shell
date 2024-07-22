package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

public interface DemuxerStream extends Interface {
  public static final Interface.Manager<DemuxerStream, Proxy> MANAGER =
      DemuxerStream_Internal.MANAGER;

  public interface Initialize_Response {
    void call(
        int i,
        DataPipe.ConsumerHandle consumerHandle,
        AudioDecoderConfig audioDecoderConfig,
        VideoDecoderConfig videoDecoderConfig);
  }

  public interface Proxy extends DemuxerStream, Interface.Proxy {}

  public interface Read_Response {
    void call(
        int i,
        DecoderBuffer[] decoderBufferArr,
        AudioDecoderConfig audioDecoderConfig,
        VideoDecoderConfig videoDecoderConfig);
  }

  void enableBitstreamConverter();

  void initialize(Initialize_Response initialize_Response);

  void read(int i, Read_Response read_Response);

  public static final class Type {
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

    private Type() {}
  }

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
}
