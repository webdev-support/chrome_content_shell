package org.chromium.ax.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class EventIntent extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int command;
  public int inputEventType;
  public int moveDirection;
  public int textBoundary;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EventIntent(int version) {
    super(24, version);
  }

  public EventIntent() {
    this(0);
  }

  public static EventIntent deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EventIntent deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EventIntent decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EventIntent result = new EventIntent(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.command = readInt;
      Command.validate(readInt);
      result.command = Command.toKnownValue(result.command);
      int readInt2 = decoder0.readInt(12);
      result.inputEventType = readInt2;
      InputEventType.validate(readInt2);
      result.inputEventType = InputEventType.toKnownValue(result.inputEventType);
      int readInt3 = decoder0.readInt(16);
      result.textBoundary = readInt3;
      TextBoundary.validate(readInt3);
      result.textBoundary = TextBoundary.toKnownValue(result.textBoundary);
      int readInt4 = decoder0.readInt(20);
      result.moveDirection = readInt4;
      MoveDirection.validate(readInt4);
      result.moveDirection = MoveDirection.toKnownValue(result.moveDirection);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.command, 8);
    encoder0.encode(this.inputEventType, 12);
    encoder0.encode(this.textBoundary, 16);
    encoder0.encode(this.moveDirection, 20);
  }
}
