package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class BeginFrameArgs extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean animateOnly;
  public TimeTicks clientArrivalTime;
  public TimeTicks deadline;
  public TimeTicks dispatchTime;
  public TimeTicks frameTime;
  public long framesThrottledSinceLast;
  public TimeDelta interval;
  public boolean onCriticalPath;
  public long sequenceNumber;
  public long sourceId;
  public long traceId;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BeginFrameArgs(int version) {
    super(88, version);
  }

  public BeginFrameArgs() {
    this(0);
  }

  public static BeginFrameArgs deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BeginFrameArgs deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BeginFrameArgs decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BeginFrameArgs result = new BeginFrameArgs(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.frameTime = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.deadline = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.interval = TimeDelta.decode(decoder13);
      result.sourceId = decoder0.readLong(32);
      result.sequenceNumber = decoder0.readLong(40);
      result.framesThrottledSinceLast = decoder0.readLong(48);
      result.traceId = decoder0.readLong(56);
      Decoder decoder14 = decoder0.readPointer(64, false);
      result.dispatchTime = TimeTicks.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(72, false);
      result.clientArrivalTime = TimeTicks.decode(decoder15);
      int readInt = decoder0.readInt(80);
      result.type = readInt;
      BeginFrameArgsType.validate(readInt);
      result.type = BeginFrameArgsType.toKnownValue(result.type);
      result.onCriticalPath = decoder0.readBoolean(84, 0);
      result.animateOnly = decoder0.readBoolean(84, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.frameTime, 8, false);
    encoder0.encode((Struct) this.deadline, 16, false);
    encoder0.encode((Struct) this.interval, 24, false);
    encoder0.encode(this.sourceId, 32);
    encoder0.encode(this.sequenceNumber, 40);
    encoder0.encode(this.framesThrottledSinceLast, 48);
    encoder0.encode(this.traceId, 56);
    encoder0.encode((Struct) this.dispatchTime, 64, false);
    encoder0.encode((Struct) this.clientArrivalTime, 72, false);
    encoder0.encode(this.type, 80);
    encoder0.encode(this.onCriticalPath, 84, 0);
    encoder0.encode(this.animateOnly, 84, 1);
  }
}
