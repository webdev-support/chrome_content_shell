package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.BigBuffer;

public final class SerializedArrayBufferContents extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public BigBuffer contents;
  public boolean isResizableByUserJavascript;
  public long maxByteLength;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SerializedArrayBufferContents(int version) {
    super(40, version);
    this.isResizableByUserJavascript = false;
    this.maxByteLength = 0L;
  }

  public SerializedArrayBufferContents() {
    this(0);
  }

  public static SerializedArrayBufferContents deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SerializedArrayBufferContents deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SerializedArrayBufferContents decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SerializedArrayBufferContents result = new SerializedArrayBufferContents(elementsOrVersion);
      result.contents = BigBuffer.decode(decoder0, 8);
      result.isResizableByUserJavascript = decoder0.readBoolean(24, 0);
      result.maxByteLength = decoder0.readLong(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.contents, 8, false);
    encoder0.encode(this.isResizableByUserJavascript, 24, 0);
    encoder0.encode(this.maxByteLength, 32);
  }
}
