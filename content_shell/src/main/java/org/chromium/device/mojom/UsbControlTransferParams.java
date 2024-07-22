package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UsbControlTransferParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  public static final String SECURITY_KEY_AOA_MODEL = "12eba9f901039b36";
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public short index;
  public int recipient;
  public byte request;
  public int type;
  public short value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UsbControlTransferParams(int version) {
    super(24, version);
  }

  public UsbControlTransferParams() {
    this(0);
  }

  public static UsbControlTransferParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UsbControlTransferParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UsbControlTransferParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UsbControlTransferParams result = new UsbControlTransferParams(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      UsbControlTransferType.validate(readInt);
      result.type = UsbControlTransferType.toKnownValue(result.type);
      int readInt2 = decoder0.readInt(12);
      result.recipient = readInt2;
      UsbControlTransferRecipient.validate(readInt2);
      result.recipient = UsbControlTransferRecipient.toKnownValue(result.recipient);
      result.request = decoder0.readByte(16);
      result.value = decoder0.readShort(18);
      result.index = decoder0.readShort(20);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.recipient, 12);
    encoder0.encode(this.request, 16);
    encoder0.encode(this.value, 18);
    encoder0.encode(this.index, 20);
  }
}
