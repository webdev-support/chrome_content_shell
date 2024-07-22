package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UsbEndpointInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int direction;
  public byte endpointNumber;
  public byte[] extraData;
  public int packetSize;
  public byte pollingInterval;
  public int synchronizationType;
  public int type;
  public int usageType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UsbEndpointInfo(int version) {
    super(40, version);
  }

  public UsbEndpointInfo() {
    this(0);
  }

  public static UsbEndpointInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UsbEndpointInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UsbEndpointInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UsbEndpointInfo result = new UsbEndpointInfo(elementsOrVersion);
      result.endpointNumber = decoder0.readByte(8);
      result.pollingInterval = decoder0.readByte(9);
      int readInt = decoder0.readInt(12);
      result.direction = readInt;
      UsbTransferDirection.validate(readInt);
      result.direction = UsbTransferDirection.toKnownValue(result.direction);
      int readInt2 = decoder0.readInt(16);
      result.type = readInt2;
      UsbTransferType.validate(readInt2);
      result.type = UsbTransferType.toKnownValue(result.type);
      result.packetSize = decoder0.readInt(20);
      int readInt3 = decoder0.readInt(24);
      result.synchronizationType = readInt3;
      UsbSynchronizationType.validate(readInt3);
      result.synchronizationType = UsbSynchronizationType.toKnownValue(result.synchronizationType);
      int readInt4 = decoder0.readInt(28);
      result.usageType = readInt4;
      UsbUsageType.validate(readInt4);
      result.usageType = UsbUsageType.toKnownValue(result.usageType);
      result.extraData = decoder0.readBytes(32, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.endpointNumber, 8);
    encoder0.encode(this.pollingInterval, 9);
    encoder0.encode(this.direction, 12);
    encoder0.encode(this.type, 16);
    encoder0.encode(this.packetSize, 20);
    encoder0.encode(this.synchronizationType, 24);
    encoder0.encode(this.usageType, 28);
    encoder0.encode(this.extraData, 32, 0, -1);
  }
}
