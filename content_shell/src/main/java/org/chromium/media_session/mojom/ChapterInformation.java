package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class ChapterInformation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public MediaImage[] artwork;
  public TimeDelta startTime;
  public String16 title;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ChapterInformation(int version) {
    super(32, version);
  }

  public ChapterInformation() {
    this(0);
  }

  public static ChapterInformation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ChapterInformation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ChapterInformation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ChapterInformation result = new ChapterInformation(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.title = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.startTime = TimeDelta.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.artwork = new MediaImage[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.artwork[i1] = MediaImage.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.title, 8, false);
    encoder0.encode((Struct) this.startTime, 16, false);
    MediaImage[] mediaImageArr = this.artwork;
    if (mediaImageArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(mediaImageArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      MediaImage[] mediaImageArr2 = this.artwork;
      if (i0 < mediaImageArr2.length) {
        encoder1.encode((Struct) mediaImageArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
