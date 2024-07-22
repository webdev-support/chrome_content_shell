package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SmartCardConnectSuccess extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int activeProtocol;
  public SmartCardConnection connection;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SmartCardConnectSuccess(int version) {
    super(24, version);
  }

  public SmartCardConnectSuccess() {
    this(0);
  }

  public static SmartCardConnectSuccess deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SmartCardConnectSuccess deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SmartCardConnectSuccess decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SmartCardConnectSuccess result = new SmartCardConnectSuccess(elementsOrVersion);
      result.connection =
          (SmartCardConnection)
              decoder0.readServiceInterface(8, false, SmartCardConnection.MANAGER);
      int readInt = decoder0.readInt(16);
      result.activeProtocol = readInt;
      SmartCardProtocol.validate(readInt);
      result.activeProtocol = SmartCardProtocol.toKnownValue(result.activeProtocol);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.connection, 8, false, SmartCardConnection.MANAGER);
    encoder0.encode(this.activeProtocol, 16);
  }
}
