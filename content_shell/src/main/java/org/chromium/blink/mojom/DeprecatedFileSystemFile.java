package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

public final class DeprecatedFileSystemFile extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Url filesystemUrl;
  public long length;
  public Time modificationTime;
  public long offset;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DeprecatedFileSystemFile(int version) {
    super(40, version);
  }

  public DeprecatedFileSystemFile() {
    this(0);
  }

  public static DeprecatedFileSystemFile deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DeprecatedFileSystemFile deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DeprecatedFileSystemFile decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DeprecatedFileSystemFile result = new DeprecatedFileSystemFile(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.filesystemUrl = Url.decode(decoder1);
      result.offset = decoder0.readLong(16);
      result.length = decoder0.readLong(24);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.modificationTime = Time.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.filesystemUrl, 8, false);
    encoder0.encode(this.offset, 16);
    encoder0.encode(this.length, 24);
    encoder0.encode((Struct) this.modificationTime, 32, false);
  }
}
