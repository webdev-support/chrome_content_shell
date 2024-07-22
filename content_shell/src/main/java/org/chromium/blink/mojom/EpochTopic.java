package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class EpochTopic extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public String configVersion;
  public String modelVersion;
  public String taxonomyVersion;
  public int topic;
  public String version;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EpochTopic(int version) {
    super(48, version);
  }

  public EpochTopic() {
    this(0);
  }

  public static EpochTopic deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EpochTopic deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EpochTopic decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EpochTopic result = new EpochTopic(elementsOrVersion);
      result.topic = decoder0.readInt(8);
      result.version = decoder0.readString(16, false);
      result.configVersion = decoder0.readString(24, false);
      result.modelVersion = decoder0.readString(32, false);
      result.taxonomyVersion = decoder0.readString(40, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.topic, 8);
    encoder0.encode(this.version, 16, false);
    encoder0.encode(this.configVersion, 24, false);
    encoder0.encode(this.modelVersion, 32, false);
    encoder0.encode(this.taxonomyVersion, 40, false);
  }
}
