package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class Event extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public int action;
  public int flags;
  public GestureData gestureData;
  public KeyData keyData;
  public LatencyInfo latency;
  public MouseData mouseData;
  public Map<String, byte[]> properties;
  public ScrollData scrollData;
  public TimeTicks timeStamp;
  public TouchData touchData;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Event(int version) {
    super(80, version);
  }

  public Event() {
    this(0);
  }

  public static Event deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Event deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Event decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Event result = new Event(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.action = readInt;
      EventType.validate(readInt);
      result.action = EventType.toKnownValue(result.action);
      result.flags = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.timeStamp = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.latency = LatencyInfo.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, true);
      result.keyData = KeyData.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, true);
      result.gestureData = GestureData.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, true);
      result.scrollData = ScrollData.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, true);
      result.touchData = TouchData.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(64, true);
      result.mouseData = MouseData.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(72, true);
      if (decoder18 == null) {
        result.properties = null;
      } else {
        decoder18.readDataHeaderForMap();
        Decoder decoder2 = decoder18.readPointer(8, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
        String[] keys0 = new String[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
        }
        Decoder decoder22 = decoder18.readPointer(16, false);
        DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
        byte[][] values0 = new byte[si22.elementsOrVersion][];
        for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
          values0[i22] = decoder22.readBytes((i22 * 8) + 8, 0, -1);
        }
        result.properties = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.properties.put(keys0[index0], values0[index0]);
        }
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
    encoder0.encode(this.flags, 12);
    encoder0.encode((Struct) this.timeStamp, 16, false);
    encoder0.encode((Struct) this.latency, 24, false);
    encoder0.encode((Struct) this.keyData, 32, true);
    encoder0.encode((Struct) this.gestureData, 40, true);
    encoder0.encode((Struct) this.scrollData, 48, true);
    encoder0.encode((Struct) this.touchData, 56, true);
    encoder0.encode((Struct) this.mouseData, 64, true);
    if (this.properties == null) {
      encoder0.encodeNullPointer(72, true);
      return;
    }
    Encoder encoder1 = encoder0.encoderForMap(72);
    int size0 = this.properties.size();
    String[] keys0 = new String[size0];
    byte[][] values0 = new byte[size0][];
    int index0 = 0;
    for (Map.Entry<String, byte[]> entry0 : this.properties.entrySet()) {
      keys0[index0] = entry0.getKey();
      values0[index0] = entry0.getValue();
      index0++;
    }
    Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
    for (int i1 = 0; i1 < keys0.length; i1++) {
      encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
    }
    Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
    for (int i12 = 0; i12 < values0.length; i12++) {
      encoder22.encode(values0[i12], (i12 * 8) + 8, 0, -1);
    }
  }
}
