package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoCodecInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int[] supportedProfiles;
  public boolean supportsClearLead;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoCodecInfo(int version) {
    super(24, version);
    this.supportsClearLead = true;
  }

  public VideoCodecInfo() {
    this(0);
  }

  public static VideoCodecInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoCodecInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoCodecInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoCodecInfo result = new VideoCodecInfo(elementsOrVersion);
      result.supportedProfiles = decoder0.readInts(8, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.supportedProfiles;
        if (i1 < iArr.length) {
          VideoCodecProfile.validate(iArr[i1]);
          i1++;
        } else {
          result.supportsClearLead = decoder0.readBoolean(16, 0);
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.supportedProfiles, 8, 0, -1);
    encoder0.encode(this.supportsClearLead, 16, 0);
  }
}
