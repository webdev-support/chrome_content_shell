package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.bluetooth.mojom.Uuid;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class SerialPortInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public Uuid bluetoothServiceClassId;
  public String displayName;
  public boolean hasProductId;
  public boolean hasVendorId;
  public FilePath path;
  public short productId;
  public String serialNumber;
  public UnguessableToken token;
  public int type;
  public short vendorId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SerialPortInfo(int version) {
    super(64, version);
    this.type = 0;
    this.hasVendorId = false;
    this.hasProductId = false;
  }

  public SerialPortInfo() {
    this(0);
  }

  public static SerialPortInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SerialPortInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SerialPortInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SerialPortInfo result = new SerialPortInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.token = UnguessableToken.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.path = FilePath.decode(decoder12);
      int readInt = decoder0.readInt(24);
      result.type = readInt;
      SerialPortType.validate(readInt);
      result.type = SerialPortType.toKnownValue(result.type);
      result.vendorId = decoder0.readShort(28);
      result.hasVendorId = decoder0.readBoolean(30, 0);
      result.hasProductId = decoder0.readBoolean(30, 1);
      result.productId = decoder0.readShort(32);
      Decoder decoder13 = decoder0.readPointer(40, true);
      result.bluetoothServiceClassId = Uuid.decode(decoder13);
      result.displayName = decoder0.readString(48, true);
      result.serialNumber = decoder0.readString(56, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.token, 8, false);
    encoder0.encode((Struct) this.path, 16, false);
    encoder0.encode(this.type, 24);
    encoder0.encode(this.vendorId, 28);
    encoder0.encode(this.hasVendorId, 30, 0);
    encoder0.encode(this.hasProductId, 30, 1);
    encoder0.encode(this.productId, 32);
    encoder0.encode((Struct) this.bluetoothServiceClassId, 40, true);
    encoder0.encode(this.displayName, 48, true);
    encoder0.encode(this.serialNumber, 56, true);
  }
}
