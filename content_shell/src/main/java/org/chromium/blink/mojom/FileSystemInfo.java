package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class FileSystemInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int mountType;
  public String name;
  public Url rootUrl;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FileSystemInfo(int version) {
    super(32, version);
    this.mountType = 0;
  }

  public FileSystemInfo() {
    this(0);
  }

  public static FileSystemInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FileSystemInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FileSystemInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FileSystemInfo result = new FileSystemInfo(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.rootUrl = Url.decode(decoder1);
      int readInt = decoder0.readInt(24);
      result.mountType = readInt;
      FileSystemType.validate(readInt);
      result.mountType = FileSystemType.toKnownValue(result.mountType);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode((Struct) this.rootUrl, 16, false);
    encoder0.encode(this.mountType, 24);
  }
}
