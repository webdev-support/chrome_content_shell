package org.chromium.webshare.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.SerializedBlob;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.SafeBaseName;

public final class SharedFile extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public SerializedBlob blob;
  public SafeBaseName name;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedFile(int version) {
    super(24, version);
  }

  public SharedFile() {
    this(0);
  }

  public static SharedFile deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedFile deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedFile decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedFile result = new SharedFile(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.name = SafeBaseName.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.blob = SerializedBlob.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.name, 8, false);
    encoder0.encode((Struct) this.blob, 16, false);
  }
}
