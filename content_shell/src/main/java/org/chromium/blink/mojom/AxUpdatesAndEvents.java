package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.ax.mojom.AxEvent;
import org.chromium.ax.mojom.AxTreeUpdate;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AxUpdatesAndEvents extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public AxEvent[] events;
  public AxTreeUpdate[] updates;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AxUpdatesAndEvents(int version) {
    super(24, version);
  }

  public AxUpdatesAndEvents() {
    this(0);
  }

  public static AxUpdatesAndEvents deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AxUpdatesAndEvents deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AxUpdatesAndEvents decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AxUpdatesAndEvents result = new AxUpdatesAndEvents(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.updates = new AxTreeUpdate[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.updates[i1] = AxTreeUpdate.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.events = new AxEvent[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.events[i12] = AxEvent.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    AxTreeUpdate[] axTreeUpdateArr = this.updates;
    if (axTreeUpdateArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(axTreeUpdateArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        AxTreeUpdate[] axTreeUpdateArr2 = this.updates;
        if (i0 >= axTreeUpdateArr2.length) {
          break;
        }
        encoder1.encode((Struct) axTreeUpdateArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    AxEvent[] axEventArr = this.events;
    if (axEventArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(axEventArr.length, 16, -1);
    int i02 = 0;
    while (true) {
      AxEvent[] axEventArr2 = this.events;
      if (i02 < axEventArr2.length) {
        encoder12.encode((Struct) axEventArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
