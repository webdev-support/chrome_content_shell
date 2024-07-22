package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SerializedBlob extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Blob blob;
  public String contentType;
  public long size;
  public String uuid;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SerializedBlob(int version) {
    super(40, version);
  }

  public SerializedBlob() {
    this(0);
  }

  public static SerializedBlob deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SerializedBlob deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SerializedBlob decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SerializedBlob result = new SerializedBlob(elementsOrVersion);
      result.uuid = decoder0.readString(8, false);
      result.contentType = decoder0.readString(16, false);
      result.size = decoder0.readLong(24);
      result.blob = (Blob) decoder0.readServiceInterface(32, false, Blob.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.uuid, 8, false);
    encoder0.encode(this.contentType, 16, false);
    encoder0.encode(this.size, 24);
    encoder0.encode(this.blob, 32, false, Blob.MANAGER);
  }
}
