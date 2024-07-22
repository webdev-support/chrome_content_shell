package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.ui.mojom.EventPointerType;

public final class GestureData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 112;
  private static final DataHeader[] VERSION_ARRAY;
  public Size contactSize;
  public FlingData flingData;
  public boolean isSourceTouchEventSetBlocking;
  public PinchBeginData pinchBeginData;
  public PinchEndData pinchEndData;
  public PinchUpdateData pinchUpdateData;
  public int primaryPointerType;
  public int primaryUniqueTouchEventId;
  public PointF screenPosition;
  public ScrollData scrollData;
  public int sourceDevice;
  public TapData tapData;
  public TapDownData tapDownData;
  public int uniqueTouchEventId;
  public PointF widgetPosition;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(112, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GestureData(int version) {
    super(112, version);
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
      result.screenPosition = PointF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.widgetPosition = PointF.decode(decoder12);
      int readInt = decoder0.readInt(24);
      result.sourceDevice = readInt;
      GestureDevice.validate(readInt);
      result.sourceDevice = GestureDevice.toKnownValue(result.sourceDevice);
      result.isSourceTouchEventSetBlocking = decoder0.readBoolean(28, 0);
      int readInt2 = decoder0.readInt(32);
      result.primaryPointerType = readInt2;
      EventPointerType.validate(readInt2);
      result.primaryPointerType = EventPointerType.toKnownValue(result.primaryPointerType);
      result.primaryUniqueTouchEventId = decoder0.readInt(36);
      result.uniqueTouchEventId = decoder0.readInt(40);
      Decoder decoder13 = decoder0.readPointer(48, true);
      result.contactSize = Size.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(56, true);
      result.scrollData = ScrollData.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(64, true);
      result.pinchBeginData = PinchBeginData.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(72, true);
      result.pinchUpdateData = PinchUpdateData.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(80, true);
      result.pinchEndData = PinchEndData.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(88, true);
      result.tapData = TapData.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(96, true);
      result.tapDownData = TapDownData.decode(decoder19);
      Decoder decoder110 = decoder0.readPointer(104, true);
      result.flingData = FlingData.decode(decoder110);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.screenPosition, 8, false);
    encoder0.encode((Struct) this.widgetPosition, 16, false);
    encoder0.encode(this.sourceDevice, 24);
    encoder0.encode(this.isSourceTouchEventSetBlocking, 28, 0);
    encoder0.encode(this.primaryPointerType, 32);
    encoder0.encode(this.primaryUniqueTouchEventId, 36);
    encoder0.encode(this.uniqueTouchEventId, 40);
    encoder0.encode((Struct) this.contactSize, 48, true);
    encoder0.encode((Struct) this.scrollData, 56, true);
    encoder0.encode((Struct) this.pinchBeginData, 64, true);
    encoder0.encode((Struct) this.pinchUpdateData, 72, true);
    encoder0.encode((Struct) this.pinchEndData, 80, true);
    encoder0.encode((Struct) this.tapData, 88, true);
    encoder0.encode((Struct) this.tapDownData, 96, true);
    encoder0.encode((Struct) this.flingData, 104, true);
  }
}
