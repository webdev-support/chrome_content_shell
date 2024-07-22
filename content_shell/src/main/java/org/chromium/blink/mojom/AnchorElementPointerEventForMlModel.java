package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AnchorElementPointerEventForMlModel extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int anchorId;
  public boolean isMouse;
  public int userInteractionEventType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AnchorElementPointerEventForMlModel(int version) {
    super(24, version);
  }

  public AnchorElementPointerEventForMlModel() {
    this(0);
  }

  public static AnchorElementPointerEventForMlModel deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AnchorElementPointerEventForMlModel deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AnchorElementPointerEventForMlModel decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AnchorElementPointerEventForMlModel result =
          new AnchorElementPointerEventForMlModel(elementsOrVersion);
      result.anchorId = decoder0.readInt(8);
      result.isMouse = decoder0.readBoolean(12, 0);
      int readInt = decoder0.readInt(16);
      result.userInteractionEventType = readInt;
      AnchorElementUserInteractionEventForMlModelType.validate(readInt);
      result.userInteractionEventType =
          AnchorElementUserInteractionEventForMlModelType.toKnownValue(
              result.userInteractionEventType);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.anchorId, 8);
    encoder0.encode(this.isMouse, 12, 0);
    encoder0.encode(this.userInteractionEventType, 16);
  }
}
