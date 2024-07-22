package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CdmCapability extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int[] audioCodecs;
  public int[] encryptionSchemes;
  public int[] sessionTypes;
  public Map<Integer, VideoCodecInfo> videoCodecs;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CdmCapability(int version) {
    super(40, version);
  }

  public CdmCapability() {
    this(0);
  }

  public static CdmCapability deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CdmCapability deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CdmCapability decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CdmCapability result = new CdmCapability(elementsOrVersion);
      result.audioCodecs = decoder0.readInts(8, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.audioCodecs;
        if (i1 >= iArr.length) {
          break;
        }
        AudioCodec.validate(iArr[i1]);
        i1++;
      }
      Decoder decoder1 = decoder0.readPointer(16, false);
      decoder1.readDataHeaderForMap();
      int[] keys0 = decoder1.readInts(8, 0, -1);
      for (int i : keys0) {
        VideoCodec.validate(i);
      }
      Decoder decoder2 = decoder1.readPointer(16, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
      VideoCodecInfo[] values0 = new VideoCodecInfo[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
        values0[i2] = VideoCodecInfo.decode(decoder3);
      }
      result.videoCodecs = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.videoCodecs.put(Integer.valueOf(keys0[index0]), values0[index0]);
      }
      result.encryptionSchemes = decoder0.readInts(24, 0, -1);
      int i12 = 0;
      while (true) {
        int[] iArr2 = result.encryptionSchemes;
        if (i12 >= iArr2.length) {
          break;
        }
        EncryptionScheme.validate(iArr2[i12]);
        i12++;
      }
      result.sessionTypes = decoder0.readInts(32, 0, -1);
      int i13 = 0;
      while (true) {
        int[] iArr3 = result.sessionTypes;
        if (i13 < iArr3.length) {
          CdmSessionType.validate(iArr3[i13]);
          i13++;
        } else {
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
    encoder0.encode(this.audioCodecs, 8, 0, -1);
    if (this.videoCodecs == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(16);
      int size0 = this.videoCodecs.size();
      int[] keys0 = new int[size0];
      VideoCodecInfo[] values0 = new VideoCodecInfo[size0];
      int index0 = 0;
      for (Map.Entry<Integer, VideoCodecInfo> entry0 : this.videoCodecs.entrySet()) {
        keys0[index0] = entry0.getKey().intValue();
        values0[index0] = entry0.getValue();
        index0++;
      }
      encoder1.encode(keys0, 8, 0, -1);
      Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i1 = 0; i1 < values0.length; i1++) {
        encoder2.encode((Struct) values0[i1], (i1 * 8) + 8, false);
      }
    }
    encoder0.encode(this.encryptionSchemes, 24, 0, -1);
    encoder0.encode(this.sessionTypes, 32, 0, -1);
  }
}
