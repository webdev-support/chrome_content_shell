package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class Report extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public ReportBody body;
  public String type;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Report(int version) {
    super(32, version);
  }

  public Report() {
    this(0);
  }

  public static Report deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Report deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Report decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Report result = new Report(elementsOrVersion);
      result.type = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.body = ReportBody.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8, false);
    encoder0.encode((Struct) this.url, 16, false);
    encoder0.encode((Struct) this.body, 24, true);
  }
}
