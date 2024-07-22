package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class MediaSessionActionDetails extends Union {

  private MediaSessionSeekToDetails mSeekTo;

  public static final class Tag {
    public static final int SeekTo = 0;
  }

  public void setSeekTo(MediaSessionSeekToDetails seekTo) {
    this.mTag = 0;
    this.mSeekTo = seekTo;
  }

  public MediaSessionSeekToDetails getSeekTo() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mSeekTo;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mSeekTo, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static MediaSessionActionDetails deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final MediaSessionActionDetails decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    MediaSessionActionDetails result = new MediaSessionActionDetails();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mSeekTo = MediaSessionSeekToDetails.decode(decoder1);
        result.mTag = 0;
        break;
    }
    return result;
  }
}
