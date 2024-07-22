package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SkcmsTransferFunction extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;

  public float f726a;

  public float f727b;

  public float f728c;

  public float f729d;

  public float f730e;

  public float f731f;

  public float f732g;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SkcmsTransferFunction(int version) {
    super(40, version);
  }

  public SkcmsTransferFunction() {
    this(0);
  }

  public static SkcmsTransferFunction deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SkcmsTransferFunction deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SkcmsTransferFunction decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SkcmsTransferFunction result = new SkcmsTransferFunction(elementsOrVersion);
      result.f732g = decoder0.readFloat(8);
      result.f726a = decoder0.readFloat(12);
      result.f727b = decoder0.readFloat(16);
      result.f728c = decoder0.readFloat(20);
      result.f729d = decoder0.readFloat(24);
      result.f730e = decoder0.readFloat(28);
      result.f731f = decoder0.readFloat(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f732g, 8);
    encoder0.encode(this.f726a, 12);
    encoder0.encode(this.f727b, 16);
    encoder0.encode(this.f728c, 20);
    encoder0.encode(this.f729d, 24);
    encoder0.encode(this.f730e, 28);
    encoder0.encode(this.f731f, 32);
  }
}
