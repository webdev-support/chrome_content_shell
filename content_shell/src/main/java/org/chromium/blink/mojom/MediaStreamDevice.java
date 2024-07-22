package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.AudioParameters;
import org.chromium.media.mojom.DisplayMediaInformation;
import org.chromium.media.mojom.VideoFacingMode;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class MediaStreamDevice extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public long displayId;
  public DisplayMediaInformation displayMediaInfo;
  public String groupId;

  public String f439id;
  public AudioParameters input;
  public String matchedOutputDeviceId;
  public String name;
  public UnguessableToken sessionId;
  public int type;
  public int videoFacing;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MediaStreamDevice(int version) {
    super(80, version);
  }

  public MediaStreamDevice() {
    this(0);
  }

  public static MediaStreamDevice deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MediaStreamDevice deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MediaStreamDevice decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MediaStreamDevice result = new MediaStreamDevice(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      MediaStreamType.validate(readInt);
      result.type = MediaStreamType.toKnownValue(result.type);
      int readInt2 = decoder0.readInt(12);
      result.videoFacing = readInt2;
      VideoFacingMode.validate(readInt2);
      result.videoFacing = VideoFacingMode.toKnownValue(result.videoFacing);
      result.f439id = decoder0.readString(16, false);
      result.displayId = decoder0.readLong(24);
      result.groupId = decoder0.readString(32, true);
      result.matchedOutputDeviceId = decoder0.readString(40, true);
      result.name = decoder0.readString(48, false);
      Decoder decoder1 = decoder0.readPointer(56, false);
      result.input = AudioParameters.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(64, true);
      result.sessionId = UnguessableToken.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(72, true);
      result.displayMediaInfo = DisplayMediaInformation.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.videoFacing, 12);
    encoder0.encode(this.f439id, 16, false);
    encoder0.encode(this.displayId, 24);
    encoder0.encode(this.groupId, 32, true);
    encoder0.encode(this.matchedOutputDeviceId, 40, true);
    encoder0.encode(this.name, 48, false);
    encoder0.encode((Struct) this.input, 56, false);
    encoder0.encode((Struct) this.sessionId, 64, true);
    encoder0.encode((Struct) this.displayMediaInfo, 72, true);
  }
}
