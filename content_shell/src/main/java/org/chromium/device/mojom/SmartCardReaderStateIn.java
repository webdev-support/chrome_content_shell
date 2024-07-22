package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SmartCardReaderStateIn extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public short currentCount;
  public SmartCardReaderStateFlags currentState;
  public String reader;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SmartCardReaderStateIn(int version) {
    super(32, version);
  }

  public SmartCardReaderStateIn() {
    this(0);
  }

  public static SmartCardReaderStateIn deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SmartCardReaderStateIn deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SmartCardReaderStateIn decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SmartCardReaderStateIn result = new SmartCardReaderStateIn(elementsOrVersion);
      result.reader = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.currentState = SmartCardReaderStateFlags.decode(decoder1);
      result.currentCount = decoder0.readShort(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.reader, 8, false);
    encoder0.encode((Struct) this.currentState, 16, false);
    encoder0.encode(this.currentCount, 24);
  }
}
