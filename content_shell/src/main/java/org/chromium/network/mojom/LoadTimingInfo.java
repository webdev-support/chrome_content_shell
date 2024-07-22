package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class LoadTimingInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 152;
  private static final DataHeader[] VERSION_ARRAY;
  public LoadTimingInfoConnectTiming connectTiming;
  public TimeTicks firstEarlyHintsTime;
  public TimeTicks proxyResolveEnd;
  public TimeTicks proxyResolveStart;
  public TimeTicks pushEnd;
  public TimeTicks pushStart;
  public TimeTicks receiveHeadersEnd;
  public TimeTicks receiveHeadersStart;
  public TimeTicks receiveNonInformationalHeadersStart;
  public TimeTicks requestStart;
  public Time requestStartTime;
  public TimeTicks sendEnd;
  public TimeTicks sendStart;
  public TimeTicks serviceWorkerFetchStart;
  public TimeTicks serviceWorkerReadyTime;
  public TimeTicks serviceWorkerRespondWithSettled;
  public TimeTicks serviceWorkerStartTime;
  public int socketLogId;
  public boolean socketReused;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(152, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LoadTimingInfo(int version) {
    super(152, version);
  }

  public LoadTimingInfo() {
    this(0);
  }

  public static LoadTimingInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LoadTimingInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LoadTimingInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LoadTimingInfo result = new LoadTimingInfo(elementsOrVersion);
      result.socketReused = decoder0.readBoolean(8, 0);
      result.socketLogId = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.requestStartTime = Time.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.requestStart = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.proxyResolveStart = TimeTicks.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.proxyResolveEnd = TimeTicks.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.connectTiming = LoadTimingInfoConnectTiming.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, false);
      result.sendStart = TimeTicks.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(64, false);
      result.sendEnd = TimeTicks.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(72, false);
      result.receiveHeadersStart = TimeTicks.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(80, false);
      result.receiveHeadersEnd = TimeTicks.decode(decoder19);
      Decoder decoder110 = decoder0.readPointer(88, false);
      result.receiveNonInformationalHeadersStart = TimeTicks.decode(decoder110);
      Decoder decoder111 = decoder0.readPointer(96, false);
      result.firstEarlyHintsTime = TimeTicks.decode(decoder111);
      Decoder decoder112 = decoder0.readPointer(104, false);
      result.pushStart = TimeTicks.decode(decoder112);
      Decoder decoder113 = decoder0.readPointer(112, false);
      result.pushEnd = TimeTicks.decode(decoder113);
      Decoder decoder114 = decoder0.readPointer(120, false);
      result.serviceWorkerStartTime = TimeTicks.decode(decoder114);
      Decoder decoder115 = decoder0.readPointer(128, false);
      result.serviceWorkerReadyTime = TimeTicks.decode(decoder115);
      Decoder decoder116 = decoder0.readPointer(136, false);
      result.serviceWorkerFetchStart = TimeTicks.decode(decoder116);
      Decoder decoder117 = decoder0.readPointer(144, false);
      result.serviceWorkerRespondWithSettled = TimeTicks.decode(decoder117);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.socketReused, 8, 0);
    encoder0.encode(this.socketLogId, 12);
    encoder0.encode((Struct) this.requestStartTime, 16, false);
    encoder0.encode((Struct) this.requestStart, 24, false);
    encoder0.encode((Struct) this.proxyResolveStart, 32, false);
    encoder0.encode((Struct) this.proxyResolveEnd, 40, false);
    encoder0.encode((Struct) this.connectTiming, 48, false);
    encoder0.encode((Struct) this.sendStart, 56, false);
    encoder0.encode((Struct) this.sendEnd, 64, false);
    encoder0.encode((Struct) this.receiveHeadersStart, 72, false);
    encoder0.encode((Struct) this.receiveHeadersEnd, 80, false);
    encoder0.encode((Struct) this.receiveNonInformationalHeadersStart, 88, false);
    encoder0.encode((Struct) this.firstEarlyHintsTime, 96, false);
    encoder0.encode((Struct) this.pushStart, 104, false);
    encoder0.encode((Struct) this.pushEnd, 112, false);
    encoder0.encode((Struct) this.serviceWorkerStartTime, 120, false);
    encoder0.encode((Struct) this.serviceWorkerReadyTime, 128, false);
    encoder0.encode((Struct) this.serviceWorkerFetchStart, 136, false);
    encoder0.encode((Struct) this.serviceWorkerRespondWithSettled, 144, false);
  }
}
