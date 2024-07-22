package org.chromium.ax.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class AxActionData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 128;
  private static final DataHeader[] VERSION_ARRAY;
  public int action;
  public int anchorNodeId;
  public int anchorOffset;
  public AxTreeId childTreeId;
  public int customActionId;
  public int flags;
  public int focusNodeId;
  public int focusOffset;
  public int hitTestEventToFire;
  public int horizontalScrollAlignment;
  public int requestId;
  public int scrollBehavior;
  public String sourceExtensionId;
  public int targetNodeId;
  public Point targetPoint;
  public Rect targetRect;
  public AxTreeId targetTreeId;
  public String value;
  public int verticalScrollAlignment;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(112, 0), new DataHeader(128, 1)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private AxActionData(int version) {
    super(128, version);
  }

  public AxActionData() {
    this(1);
  }

  public static AxActionData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AxActionData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AxActionData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AxActionData result = new AxActionData(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.action = readInt;
      Action.validate(readInt);
      result.action = Action.toKnownValue(result.action);
      result.targetNodeId = decoder0.readInt(12);
      result.targetTreeId = AxTreeId.decode(decoder0, 16);
      result.sourceExtensionId = decoder0.readString(32, false);
      result.requestId = decoder0.readInt(40);
      result.flags = decoder0.readInt(44);
      result.anchorNodeId = decoder0.readInt(48);
      result.anchorOffset = decoder0.readInt(52);
      result.focusNodeId = decoder0.readInt(56);
      result.focusOffset = decoder0.readInt(60);
      result.customActionId = decoder0.readInt(64);
      int readInt2 = decoder0.readInt(68);
      result.hitTestEventToFire = readInt2;
      Event.validate(readInt2);
      result.hitTestEventToFire = Event.toKnownValue(result.hitTestEventToFire);
      Decoder decoder1 = decoder0.readPointer(72, false);
      result.targetRect = Rect.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(80, false);
      result.targetPoint = Point.decode(decoder12);
      result.value = decoder0.readString(88, false);
      int readInt3 = decoder0.readInt(96);
      result.horizontalScrollAlignment = readInt3;
      ScrollAlignment.validate(readInt3);
      result.horizontalScrollAlignment =
          ScrollAlignment.toKnownValue(result.horizontalScrollAlignment);
      int readInt4 = decoder0.readInt(100);
      result.verticalScrollAlignment = readInt4;
      ScrollAlignment.validate(readInt4);
      result.verticalScrollAlignment = ScrollAlignment.toKnownValue(result.verticalScrollAlignment);
      int readInt5 = decoder0.readInt(104);
      result.scrollBehavior = readInt5;
      ScrollBehavior.validate(readInt5);
      result.scrollBehavior = ScrollBehavior.toKnownValue(result.scrollBehavior);
      if (elementsOrVersion >= 1) {
        result.childTreeId = AxTreeId.decode(decoder0, 112);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.action, 8);
    encoder0.encode(this.targetNodeId, 12);
    encoder0.encode((Union) this.targetTreeId, 16, false);
    encoder0.encode(this.sourceExtensionId, 32, false);
    encoder0.encode(this.requestId, 40);
    encoder0.encode(this.flags, 44);
    encoder0.encode(this.anchorNodeId, 48);
    encoder0.encode(this.anchorOffset, 52);
    encoder0.encode(this.focusNodeId, 56);
    encoder0.encode(this.focusOffset, 60);
    encoder0.encode(this.customActionId, 64);
    encoder0.encode(this.hitTestEventToFire, 68);
    encoder0.encode((Struct) this.targetRect, 72, false);
    encoder0.encode((Struct) this.targetPoint, 80, false);
    encoder0.encode(this.value, 88, false);
    encoder0.encode(this.horizontalScrollAlignment, 96);
    encoder0.encode(this.verticalScrollAlignment, 100);
    encoder0.encode(this.scrollBehavior, 104);
    encoder0.encode((Union) this.childTreeId, 112, true);
  }
}
