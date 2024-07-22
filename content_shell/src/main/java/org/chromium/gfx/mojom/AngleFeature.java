package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AngleFeature extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public String bug;
  public String category;
  public String condition;
  public String description;
  public String name;
  public String status;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AngleFeature(int version) {
    super(56, version);
  }

  public AngleFeature() {
    this(0);
  }

  public static AngleFeature deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AngleFeature deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AngleFeature decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AngleFeature result = new AngleFeature(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      result.category = decoder0.readString(16, false);
      result.description = decoder0.readString(24, false);
      result.bug = decoder0.readString(32, false);
      result.status = decoder0.readString(40, false);
      result.condition = decoder0.readString(48, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode(this.category, 16, false);
    encoder0.encode(this.description, 24, false);
    encoder0.encode(this.bug, 32, false);
    encoder0.encode(this.status, 40, false);
    encoder0.encode(this.condition, 48, false);
  }
}
