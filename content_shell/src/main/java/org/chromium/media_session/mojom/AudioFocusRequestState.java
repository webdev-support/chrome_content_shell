package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class AudioFocusRequestState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int audioFocusType;
  public UnguessableToken requestId;
  public MediaSessionInfo sessionInfo;
  public UnguessableToken sourceId;
  public String sourceName;

  static {
    DataHeader[] dataHeaderArr = {
      new DataHeader(24, 0), new DataHeader(32, 2), new DataHeader(40, 3), new DataHeader(48, 9)
    };
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[3];
  }

  private AudioFocusRequestState(int version) {
    super(48, version);
  }

  public AudioFocusRequestState() {
    this(9);
  }

  public static AudioFocusRequestState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioFocusRequestState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioFocusRequestState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioFocusRequestState result = new AudioFocusRequestState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.sessionInfo = MediaSessionInfo.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.audioFocusType = readInt;
      AudioFocusType.validate(readInt);
      result.audioFocusType = AudioFocusType.toKnownValue(result.audioFocusType);
      if (elementsOrVersion >= 2) {
        result.sourceName = decoder0.readString(24, true);
      }
      if (elementsOrVersion >= 3) {
        Decoder decoder12 = decoder0.readPointer(32, true);
        result.requestId = UnguessableToken.decode(decoder12);
      }
      if (elementsOrVersion >= 9) {
        Decoder decoder13 = decoder0.readPointer(40, true);
        result.sourceId = UnguessableToken.decode(decoder13);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.sessionInfo, 8, false);
    encoder0.encode(this.audioFocusType, 16);
    encoder0.encode(this.sourceName, 24, true);
    encoder0.encode((Struct) this.requestId, 32, true);
    encoder0.encode((Struct) this.sourceId, 40, true);
  }
}
