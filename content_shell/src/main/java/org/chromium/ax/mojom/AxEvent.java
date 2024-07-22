package org.chromium.ax.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AxEvent extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int actionRequestId;
  public int eventFrom;
  public int eventFromAction;
  public EventIntent[] eventIntents;
  public int eventType;
  public int id;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AxEvent(int version) {
    super(40, version);
  }

  public AxEvent() {
    this(0);
  }

  public static AxEvent deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AxEvent deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AxEvent decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AxEvent result = new AxEvent(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.eventType = readInt;
      Event.validate(readInt);
      result.eventType = Event.toKnownValue(result.eventType);
      result.id = decoder0.readInt(12);
      int readInt2 = decoder0.readInt(16);
      result.eventFrom = readInt2;
      EventFrom.validate(readInt2);
      result.eventFrom = EventFrom.toKnownValue(result.eventFrom);
      int readInt3 = decoder0.readInt(20);
      result.eventFromAction = readInt3;
      Action.validate(readInt3);
      result.eventFromAction = Action.toKnownValue(result.eventFromAction);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.eventIntents = new EventIntent[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.eventIntents[i1] = EventIntent.decode(decoder2);
      }
      result.actionRequestId = decoder0.readInt(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.eventType, 8);
    encoder0.encode(this.id, 12);
    encoder0.encode(this.eventFrom, 16);
    encoder0.encode(this.eventFromAction, 20);
    EventIntent[] eventIntentArr = this.eventIntents;
    if (eventIntentArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(eventIntentArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        EventIntent[] eventIntentArr2 = this.eventIntents;
        if (i0 >= eventIntentArr2.length) {
          break;
        }
        encoder1.encode((Struct) eventIntentArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.actionRequestId, 32);
  }
}
