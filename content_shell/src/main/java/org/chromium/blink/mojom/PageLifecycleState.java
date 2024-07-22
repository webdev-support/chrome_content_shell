package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PageLifecycleState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean evictionEnabled;
  public boolean isFrozen;
  public boolean isInBackForwardCache;
  public int pagehideDispatch;
  public int visibility;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PageLifecycleState(int version) {
    super(24, version);
  }

  public PageLifecycleState() {
    this(0);
  }

  public static PageLifecycleState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PageLifecycleState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PageLifecycleState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PageLifecycleState result = new PageLifecycleState(elementsOrVersion);
      result.isFrozen = decoder0.readBoolean(8, 0);
      result.isInBackForwardCache = decoder0.readBoolean(8, 1);
      result.evictionEnabled = decoder0.readBoolean(8, 2);
      int readInt = decoder0.readInt(12);
      result.visibility = readInt;
      PageVisibilityState.validate(readInt);
      result.visibility = PageVisibilityState.toKnownValue(result.visibility);
      int readInt2 = decoder0.readInt(16);
      result.pagehideDispatch = readInt2;
      PagehideDispatch.validate(readInt2);
      result.pagehideDispatch = PagehideDispatch.toKnownValue(result.pagehideDispatch);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isFrozen, 8, 0);
    encoder0.encode(this.isInBackForwardCache, 8, 1);
    encoder0.encode(this.evictionEnabled, 8, 2);
    encoder0.encode(this.visibility, 12);
    encoder0.encode(this.pagehideDispatch, 16);
  }
}
