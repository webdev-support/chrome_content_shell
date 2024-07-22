package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class PageRestoreParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int currentHistoryListLength;
  public TimeTicks navigationStart;
  public int pendingHistoryListOffset;
  public ViewTransitionState viewTransitionState;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PageRestoreParams(int version) {
    super(32, version);
  }

  public PageRestoreParams() {
    this(0);
  }

  public static PageRestoreParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PageRestoreParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PageRestoreParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PageRestoreParams result = new PageRestoreParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.navigationStart = TimeTicks.decode(decoder1);
      result.pendingHistoryListOffset = decoder0.readInt(16);
      result.currentHistoryListLength = decoder0.readInt(20);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.viewTransitionState = ViewTransitionState.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.navigationStart, 8, false);
    encoder0.encode(this.pendingHistoryListOffset, 16);
    encoder0.encode(this.currentHistoryListLength, 20);
    encoder0.encode((Struct) this.viewTransitionState, 24, true);
  }
}
