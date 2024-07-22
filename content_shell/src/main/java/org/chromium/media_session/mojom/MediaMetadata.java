package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class MediaMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public String16 album;
  public String16 artist;
  public ChapterInformation[] chapters;
  public String16 sourceTitle;
  public String16 title;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0), new DataHeader(48, 21)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private MediaMetadata(int version) {
    super(48, version);
  }

  public MediaMetadata() {
    this(21);
  }

  public static MediaMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MediaMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MediaMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MediaMetadata result = new MediaMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.title = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.artist = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.album = String16.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.sourceTitle = String16.decode(decoder14);
      if (elementsOrVersion >= 21) {
        Decoder decoder15 = decoder0.readPointer(40, true);
        if (decoder15 == null) {
          result.chapters = null;
        } else {
          DataHeader si1 = decoder15.readDataHeaderForPointerArray(-1);
          result.chapters = new ChapterInformation[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder15.readPointer((i1 * 8) + 8, false);
            result.chapters[i1] = ChapterInformation.decode(decoder2);
          }
        }
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
    encoder0.encode((Struct) this.artist, 16, false);
    encoder0.encode((Struct) this.album, 24, false);
    encoder0.encode((Struct) this.sourceTitle, 32, false);
    ChapterInformation[] chapterInformationArr = this.chapters;
    if (chapterInformationArr == null) {
      encoder0.encodeNullPointer(40, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(chapterInformationArr.length, 40, -1);
    int i0 = 0;
    while (true) {
      ChapterInformation[] chapterInformationArr2 = this.chapters;
      if (i0 < chapterInformationArr2.length) {
        encoder1.encode((Struct) chapterInformationArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
