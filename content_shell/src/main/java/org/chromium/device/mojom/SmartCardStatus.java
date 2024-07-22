package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SmartCardStatus extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] answerToReset;
  public int protocol;
  public String readerName;
  public int state;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SmartCardStatus(int version) {
    super(32, version);
  }

  public SmartCardStatus() {
    this(0);
  }

  public static SmartCardStatus deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SmartCardStatus deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SmartCardStatus decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SmartCardStatus result = new SmartCardStatus(elementsOrVersion);
      result.readerName = decoder0.readString(8, false);
      int readInt = decoder0.readInt(16);
      result.state = readInt;
      SmartCardConnectionState.validate(readInt);
      result.state = SmartCardConnectionState.toKnownValue(result.state);
      int readInt2 = decoder0.readInt(20);
      result.protocol = readInt2;
      SmartCardProtocol.validate(readInt2);
      result.protocol = SmartCardProtocol.toKnownValue(result.protocol);
      result.answerToReset = decoder0.readBytes(24, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.readerName, 8, false);
    encoder0.encode(this.state, 16);
    encoder0.encode(this.protocol, 20);
    encoder0.encode(this.answerToReset, 24, 0, -1);
  }
}
