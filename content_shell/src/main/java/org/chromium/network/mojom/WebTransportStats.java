package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class WebTransportStats extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public long datagramsExpiredOutgoing;
  public long datagramsLostOutgoing;
  public long estimatedSendRateBps;
  public TimeDelta minRtt;
  public TimeDelta rttVariation;
  public TimeDelta smoothedRtt;
  public Time timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebTransportStats(int version) {
    super(64, version);
  }

  public WebTransportStats() {
    this(0);
  }

  public static WebTransportStats deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebTransportStats deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebTransportStats decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebTransportStats result = new WebTransportStats(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.timestamp = Time.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.minRtt = TimeDelta.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.smoothedRtt = TimeDelta.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.rttVariation = TimeDelta.decode(decoder14);
      result.estimatedSendRateBps = decoder0.readLong(40);
      result.datagramsExpiredOutgoing = decoder0.readLong(48);
      result.datagramsLostOutgoing = decoder0.readLong(56);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.timestamp, 8, false);
    encoder0.encode((Struct) this.minRtt, 16, false);
    encoder0.encode((Struct) this.smoothedRtt, 24, false);
    encoder0.encode((Struct) this.rttVariation, 32, false);
    encoder0.encode(this.estimatedSendRateBps, 40);
    encoder0.encode(this.datagramsExpiredOutgoing, 48);
    encoder0.encode(this.datagramsLostOutgoing, 56);
  }
}
