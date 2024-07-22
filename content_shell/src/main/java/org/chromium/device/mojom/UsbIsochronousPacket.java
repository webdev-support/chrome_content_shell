package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UsbIsochronousPacket extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int length;
  public int status;
  public int transferredLength;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UsbIsochronousPacket(int version) {
    super(24, version);
  }

  public UsbIsochronousPacket() {
    this(0);
  }

  public static UsbIsochronousPacket deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UsbIsochronousPacket deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UsbIsochronousPacket decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UsbIsochronousPacket result = new UsbIsochronousPacket(elementsOrVersion);
      result.length = decoder0.readInt(8);
      result.transferredLength = decoder0.readInt(12);
      int readInt = decoder0.readInt(16);
      result.status = readInt;
      UsbTransferStatus.validate(readInt);
      result.status = UsbTransferStatus.toKnownValue(result.status);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.length, 8);
    encoder0.encode(this.transferredLength, 12);
    encoder0.encode(this.status, 16);
  }
}
