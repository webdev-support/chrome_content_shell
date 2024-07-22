package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RemotePlaybackMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String audioCodec;
  public boolean isEncryptedMedia;
  public boolean remotePlaybackDisabled;
  public boolean remotePlaybackStarted;
  public String unusedField;
  public String videoCodec;

  static {
    DataHeader[] dataHeaderArr = {
      new DataHeader(32, 0), new DataHeader(40, 17), new DataHeader(40, 18)
    };
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[2];
  }

  private RemotePlaybackMetadata(int version) {
    super(40, version);
  }

  public RemotePlaybackMetadata() {
    this(18);
  }

  public static RemotePlaybackMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RemotePlaybackMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RemotePlaybackMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RemotePlaybackMetadata result = new RemotePlaybackMetadata(elementsOrVersion);
      result.videoCodec = decoder0.readString(8, false);
      result.audioCodec = decoder0.readString(16, false);
      result.remotePlaybackDisabled = decoder0.readBoolean(24, 0);
      if (elementsOrVersion >= 17) {
        result.remotePlaybackStarted = decoder0.readBoolean(24, 1);
      }
      if (elementsOrVersion >= 18) {
        result.isEncryptedMedia = decoder0.readBoolean(24, 2);
      }
      if (elementsOrVersion >= 17) {
        result.unusedField = decoder0.readString(32, true);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.videoCodec, 8, false);
    encoder0.encode(this.audioCodec, 16, false);
    encoder0.encode(this.remotePlaybackDisabled, 24, 0);
    encoder0.encode(this.remotePlaybackStarted, 24, 1);
    encoder0.encode(this.isEncryptedMedia, 24, 2);
    encoder0.encode(this.unusedField, 32, true);
  }
}
