package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class LoadTimingInfoConnectTiming extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeTicks connectEnd;
  public TimeTicks connectStart;
  public TimeTicks domainLookupEnd;
  public TimeTicks domainLookupStart;
  public TimeTicks sslEnd;
  public TimeTicks sslStart;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LoadTimingInfoConnectTiming(int version) {
    super(56, version);
  }

  public LoadTimingInfoConnectTiming() {
    this(0);
  }

  public static LoadTimingInfoConnectTiming deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LoadTimingInfoConnectTiming deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LoadTimingInfoConnectTiming decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LoadTimingInfoConnectTiming result = new LoadTimingInfoConnectTiming(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.domainLookupStart = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.domainLookupEnd = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.connectStart = TimeTicks.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.connectEnd = TimeTicks.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, false);
      result.sslStart = TimeTicks.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(48, false);
      result.sslEnd = TimeTicks.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.domainLookupStart, 8, false);
    encoder0.encode((Struct) this.domainLookupEnd, 16, false);
    encoder0.encode((Struct) this.connectStart, 24, false);
    encoder0.encode((Struct) this.connectEnd, 32, false);
    encoder0.encode((Struct) this.sslStart, 40, false);
    encoder0.encode((Struct) this.sslEnd, 48, false);
  }
}
