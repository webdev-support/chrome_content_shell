package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SerialConnectionOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int bitrate;
  public boolean ctsFlowControl;
  public int dataBits;
  public boolean hasCtsFlowControl;
  public int parityBit;
  public int stopBits;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SerialConnectionOptions(int version) {
    super(32, version);
    this.bitrate = 0;
    this.dataBits = 0;
    this.parityBit = 0;
    this.stopBits = 0;
    this.hasCtsFlowControl = false;
  }

  public SerialConnectionOptions() {
    this(0);
  }

  public static SerialConnectionOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SerialConnectionOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SerialConnectionOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SerialConnectionOptions result = new SerialConnectionOptions(elementsOrVersion);
      result.bitrate = decoder0.readInt(8);
      int readInt = decoder0.readInt(12);
      result.dataBits = readInt;
      SerialDataBits.validate(readInt);
      result.dataBits = SerialDataBits.toKnownValue(result.dataBits);
      int readInt2 = decoder0.readInt(16);
      result.parityBit = readInt2;
      SerialParityBit.validate(readInt2);
      result.parityBit = SerialParityBit.toKnownValue(result.parityBit);
      int readInt3 = decoder0.readInt(20);
      result.stopBits = readInt3;
      SerialStopBits.validate(readInt3);
      result.stopBits = SerialStopBits.toKnownValue(result.stopBits);
      result.ctsFlowControl = decoder0.readBoolean(24, 0);
      result.hasCtsFlowControl = decoder0.readBoolean(24, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.bitrate, 8);
    encoder0.encode(this.dataBits, 12);
    encoder0.encode(this.parityBit, 16);
    encoder0.encode(this.stopBits, 20);
    encoder0.encode(this.ctsFlowControl, 24, 0);
    encoder0.encode(this.hasCtsFlowControl, 24, 1);
  }
}
