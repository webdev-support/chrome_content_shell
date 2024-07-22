package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BeginFrameInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public BeginFrameArgs args;
  public Map<Integer, FrameTimingDetails> details;
  public boolean frameAck;
  public ReturnedResource[] resources;
  public int sinkId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BeginFrameInfo(int version) {
    super(40, version);
  }

  public BeginFrameInfo() {
    this(0);
  }

  public static BeginFrameInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BeginFrameInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BeginFrameInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BeginFrameInfo result = new BeginFrameInfo(elementsOrVersion);
      result.sinkId = decoder0.readInt(8);
      result.frameAck = decoder0.readBoolean(12, 0);
      result.args = BeginFrameArgs.decode(decoder0.readPointer(16, false));
      Decoder decoder1 = decoder0.readPointer(24, false);
      decoder1.readDataHeaderForMap();
      int[] keys0 = decoder1.readInts(8, 0, -1);
      Decoder decoder2 = decoder1.readPointer(16, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
      FrameTimingDetails[] values0 = new FrameTimingDetails[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
        values0[i2] = FrameTimingDetails.decode(decoder3);
      }
      result.details = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.details.put(Integer.valueOf(keys0[index0]), values0[index0]);
      }
      Decoder decoder12 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder12.readDataHeaderForPointerArray(-1);
      result.resources = new ReturnedResource[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.resources[i1] = ReturnedResource.decode(decoder12.readPointer((i1 * 8) + 8, false));
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.sinkId, 8);
    encoder0.encode(this.frameAck, 12, 0);
    encoder0.encode((Struct) this.args, 16, false);
    if (this.details == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(24);
      int size0 = this.details.size();
      int[] keys0 = new int[size0];
      FrameTimingDetails[] values0 = new FrameTimingDetails[size0];
      int index0 = 0;
      for (Map.Entry<Integer, FrameTimingDetails> entry0 : this.details.entrySet()) {
        keys0[index0] = entry0.getKey().intValue();
        values0[index0] = entry0.getValue();
        index0++;
      }
      encoder1.encode(keys0, 8, 0, -1);
      Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i1 = 0; i1 < values0.length; i1++) {
        encoder2.encode((Struct) values0[i1], (i1 * 8) + 8, false);
      }
    }
    ReturnedResource[] returnedResourceArr = this.resources;
    if (returnedResourceArr == null) {
      encoder0.encodeNullPointer(32, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(returnedResourceArr.length, 32, -1);
    int i0 = 0;
    while (true) {
      ReturnedResource[] returnedResourceArr2 = this.resources;
      if (i0 < returnedResourceArr2.length) {
        encoder12.encode((Struct) returnedResourceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
