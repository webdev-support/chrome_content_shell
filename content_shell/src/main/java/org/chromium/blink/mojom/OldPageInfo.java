package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class OldPageInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public LocalFrameToken frameTokenForOldMainFrame;
  public PageLifecycleState newLifecycleStateForOldPage;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private OldPageInfo(int version) {
    super(24, version);
  }

  public OldPageInfo() {
    this(0);
  }

  public static OldPageInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static OldPageInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static OldPageInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      OldPageInfo result = new OldPageInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.frameTokenForOldMainFrame = LocalFrameToken.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.newLifecycleStateForOldPage = PageLifecycleState.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.frameTokenForOldMainFrame, 8, false);
    encoder0.encode((Struct) this.newLifecycleStateForOldPage, 16, false);
  }
}
