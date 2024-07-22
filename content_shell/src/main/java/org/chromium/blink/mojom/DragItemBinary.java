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
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.url.mojom.Url;

public final class DragItemBinary extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public String contentDisposition;
  public BigBuffer data;
  public FilePath filenameExtension;
  public boolean isImageAccessible;
  public Url sourceUrl;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DragItemBinary(int version) {
    super(56, version);
  }

  public DragItemBinary() {
    this(0);
  }

  public static DragItemBinary deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DragItemBinary deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DragItemBinary decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DragItemBinary result = new DragItemBinary(elementsOrVersion);
      result.data = BigBuffer.decode(decoder0, 8);
      result.isImageAccessible = decoder0.readBoolean(24, 0);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.sourceUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.filenameExtension = FilePath.decode(decoder12);
      result.contentDisposition = decoder0.readString(48, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.data, 8, false);
    encoder0.encode(this.isImageAccessible, 24, 0);
    encoder0.encode((Struct) this.sourceUrl, 32, false);
    encoder0.encode((Struct) this.filenameExtension, 40, false);
    encoder0.encode(this.contentDisposition, 48, true);
  }
}
