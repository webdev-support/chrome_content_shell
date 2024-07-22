package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class FilePickerOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public FilePickerStartInOptionsUnion startInOptions;
  public String startingDirectoryId;
  public TypeSpecificFilePickerOptionsUnion typeSpecificOptions;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FilePickerOptions(int version) {
    super(48, version);
  }

  public FilePickerOptions() {
    this(0);
  }

  public static FilePickerOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FilePickerOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FilePickerOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FilePickerOptions result = new FilePickerOptions(elementsOrVersion);
      result.typeSpecificOptions = TypeSpecificFilePickerOptionsUnion.decode(decoder0, 8);
      result.startingDirectoryId = decoder0.readString(24, false);
      result.startInOptions = FilePickerStartInOptionsUnion.decode(decoder0, 32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.typeSpecificOptions, 8, false);
    encoder0.encode(this.startingDirectoryId, 24, false);
    encoder0.encode((Union) this.startInOptions, 32, true);
  }
}
