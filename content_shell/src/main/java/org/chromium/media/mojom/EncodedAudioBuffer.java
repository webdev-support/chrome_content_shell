package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class EncodedAudioBuffer extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] data;
  public TimeDelta duration;
  public AudioParameters params;
  public TimeDelta timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EncodedAudioBuffer(int version) {
    super(40, version);
  }

  public EncodedAudioBuffer() {
    this(0);
  }

  public static EncodedAudioBuffer deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EncodedAudioBuffer deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EncodedAudioBuffer decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EncodedAudioBuffer result = new EncodedAudioBuffer(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.params = AudioParameters.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.timestamp = TimeDelta.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.duration = TimeDelta.decode(decoder13);
      result.data = decoder0.readBytes(32, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.params, 8, false);
    encoder0.encode((Struct) this.timestamp, 16, false);
    encoder0.encode((Struct) this.duration, 24, false);
    encoder0.encode(this.data, 32, 0, -1);
  }
}
