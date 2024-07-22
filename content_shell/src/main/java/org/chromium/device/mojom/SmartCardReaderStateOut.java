package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SmartCardReaderStateOut extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] answerToReset;
  public short eventCount;
  public SmartCardReaderStateFlags eventState;
  public String reader;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SmartCardReaderStateOut(int version) {
    super(40, version);
  }

  public SmartCardReaderStateOut() {
    this(0);
  }

  public static SmartCardReaderStateOut deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SmartCardReaderStateOut deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SmartCardReaderStateOut decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SmartCardReaderStateOut result = new SmartCardReaderStateOut(elementsOrVersion);
      result.reader = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.eventState = SmartCardReaderStateFlags.decode(decoder1);
      result.eventCount = decoder0.readShort(24);
      result.answerToReset = decoder0.readBytes(32, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.reader, 8, false);
    encoder0.encode((Struct) this.eventState, 16, false);
    encoder0.encode(this.eventCount, 24);
    encoder0.encode(this.answerToReset, 32, 0, -1);
  }
}
