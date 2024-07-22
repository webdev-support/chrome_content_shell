package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.SchemefulSite;

public final class SharedStorageBudgetMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public double budgetToCharge;
  public SchemefulSite site;
  public boolean topNavigated;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedStorageBudgetMetadata(int version) {
    super(32, version);
  }

  public SharedStorageBudgetMetadata() {
    this(0);
  }

  public static SharedStorageBudgetMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedStorageBudgetMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedStorageBudgetMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedStorageBudgetMetadata result = new SharedStorageBudgetMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.site = SchemefulSite.decode(decoder1);
      result.budgetToCharge = decoder0.readDouble(16);
      result.topNavigated = decoder0.readBoolean(24, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.site, 8, false);
    encoder0.encode(this.budgetToCharge, 16);
    encoder0.encode(this.topNavigated, 24, 0);
  }
}
