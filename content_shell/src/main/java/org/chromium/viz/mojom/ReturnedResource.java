package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.GpuFenceHandle;
import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ReturnedResource extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int count;

  public ResourceId f787id;
  public boolean lost;
  public GpuFenceHandle releaseFence;
  public SyncToken syncToken;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ReturnedResource(int version) {
    super(40, version);
  }

  public ReturnedResource() {
    this(0);
  }

  public static ReturnedResource deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ReturnedResource deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ReturnedResource decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ReturnedResource result = new ReturnedResource(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.f787id = ResourceId.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.syncToken = SyncToken.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.releaseFence = GpuFenceHandle.decode(decoder13);
      result.count = decoder0.readInt(32);
      result.lost = decoder0.readBoolean(36, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.f787id, 8, false);
    encoder0.encode((Struct) this.syncToken, 16, false);
    encoder0.encode((Struct) this.releaseFence, 24, true);
    encoder0.encode(this.count, 32);
    encoder0.encode(this.lost, 36, 0);
  }
}
