package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class GestureData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public GestureDataDetails details;
  public int deviceType;
  public LocationData location;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GestureData(int version) {
    super(40, version);
  }

  public GestureData() {
    this(0);
  }

  public static GestureData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GestureData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GestureData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GestureData result = new GestureData(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.location = LocationData.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.deviceType = readInt;
      GestureDeviceType.validate(readInt);
      result.deviceType = GestureDeviceType.toKnownValue(result.deviceType);
      result.details = GestureDataDetails.decode(decoder0, 24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.location, 8, false);
    encoder0.encode(this.deviceType, 16);
    encoder0.encode((Union) this.details, 24, true);
  }
}
