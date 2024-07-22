package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SubAppsServiceAddResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public String manifestIdPath;
  public int resultCode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SubAppsServiceAddResult(int version) {
    super(24, version);
  }

  public SubAppsServiceAddResult() {
    this(0);
  }

  public static SubAppsServiceAddResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SubAppsServiceAddResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SubAppsServiceAddResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SubAppsServiceAddResult result = new SubAppsServiceAddResult(elementsOrVersion);
      result.manifestIdPath = decoder0.readString(8, false);
      int readInt = decoder0.readInt(16);
      result.resultCode = readInt;
      SubAppsServiceResultCode.validate(readInt);
      result.resultCode = SubAppsServiceResultCode.toKnownValue(result.resultCode);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.manifestIdPath, 8, false);
    encoder0.encode(this.resultCode, 16);
  }
}
