package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.String16;

public final class PluginInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int backgroundColor;
  public String16 description;
  public FilePath filename;
  public boolean mayUseExternalHandler;
  public PluginMimeType[] mimeTypes;
  public String16 name;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PluginInfo(int version) {
    super(48, version);
  }

  public PluginInfo() {
    this(0);
  }

  public static PluginInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PluginInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PluginInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PluginInfo result = new PluginInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.name = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.description = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.filename = FilePath.decode(decoder13);
      result.backgroundColor = decoder0.readInt(32);
      result.mayUseExternalHandler = decoder0.readBoolean(36, 0);
      Decoder decoder14 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
      result.mimeTypes = new PluginMimeType[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder14.readPointer((i1 * 8) + 8, false);
        result.mimeTypes[i1] = PluginMimeType.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.name, 8, false);
    encoder0.encode((Struct) this.description, 16, false);
    encoder0.encode((Struct) this.filename, 24, false);
    encoder0.encode(this.backgroundColor, 32);
    encoder0.encode(this.mayUseExternalHandler, 36, 0);
    PluginMimeType[] pluginMimeTypeArr = this.mimeTypes;
    if (pluginMimeTypeArr == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(pluginMimeTypeArr.length, 40, -1);
    int i0 = 0;
    while (true) {
      PluginMimeType[] pluginMimeTypeArr2 = this.mimeTypes;
      if (i0 < pluginMimeTypeArr2.length) {
        encoder1.encode((Struct) pluginMimeTypeArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
