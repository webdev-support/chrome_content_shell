package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class MediaSessionInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public String audioSinkId;
  public int[] audioVideoStates;
  public int cameraState;
  public int deprecatedAudioVideoState;
  public boolean forceDuck;
  public boolean hasPresentation;
  public boolean hideMetadata;
  public boolean ignoreForActiveSession;
  public boolean isControllable;
  public boolean isSensitive;
  public int microphoneState;
  public boolean muted;
  public int pictureInPictureState;
  public int playbackState;
  public boolean preferStopForGainFocusLoss;
  public RemotePlaybackMetadata remotePlaybackMetadata;
  public int state;

  static {
    DataHeader[] dataHeaderArr = {
      new DataHeader(16, 0),
      new DataHeader(24, 1),
      new DataHeader(24, 2),
      new DataHeader(24, 4),
      new DataHeader(24, 6),
      new DataHeader(24, 7),
      new DataHeader(32, 8),
      new DataHeader(40, 9),
      new DataHeader(48, 10),
      new DataHeader(56, 11),
      new DataHeader(56, 12),
      new DataHeader(56, 14),
      new DataHeader(64, 15),
      new DataHeader(64, 16),
      new DataHeader(64, 20)
    };
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[14];
  }

  public static final class SessionState {
    public static final int ACTIVE = 0;
    public static final int DUCKING = 1;
    public static final int INACTIVE = 3;
    private static final boolean IS_EXTENSIBLE = true;
    public static final int MAX_VALUE = 3;
    public static final int MIN_VALUE = 0;
    public static final int SUSPENDED = 2;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 3;
    }

    public static void validate(int value) {}

    public static int toKnownValue(int value) {
      return value;
    }

    private SessionState() {}
  }

  private MediaSessionInfo(int version) {
    super(64, version);
  }

  public MediaSessionInfo() {
    this(20);
  }

  public static MediaSessionInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MediaSessionInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MediaSessionInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MediaSessionInfo result = new MediaSessionInfo(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.state = readInt;
      SessionState.validate(readInt);
      result.state = SessionState.toKnownValue(result.state);
      result.forceDuck = decoder0.readBoolean(12, 0);
      if (elementsOrVersion >= 2) {
        result.isControllable = decoder0.readBoolean(12, 1);
      }
      if (elementsOrVersion >= 4) {
        result.preferStopForGainFocusLoss = decoder0.readBoolean(12, 2);
      }
      if (elementsOrVersion >= 6) {
        result.isSensitive = decoder0.readBoolean(12, 3);
      }
      if (elementsOrVersion >= 12) {
        result.muted = decoder0.readBoolean(12, 4);
      }
      if (elementsOrVersion >= 14) {
        result.hasPresentation = decoder0.readBoolean(12, 5);
      }
      if (elementsOrVersion >= 16) {
        result.hideMetadata = decoder0.readBoolean(12, 6);
      }
      if (elementsOrVersion >= 20) {
        result.ignoreForActiveSession = decoder0.readBoolean(12, 7);
      }
      if (elementsOrVersion >= 1) {
        int readInt2 = decoder0.readInt(16);
        result.playbackState = readInt2;
        MediaPlaybackState.validate(readInt2);
        result.playbackState = MediaPlaybackState.toKnownValue(result.playbackState);
      }
      if (elementsOrVersion >= 7) {
        int readInt3 = decoder0.readInt(20);
        result.pictureInPictureState = readInt3;
        MediaPictureInPictureState.validate(readInt3);
        result.pictureInPictureState =
            MediaPictureInPictureState.toKnownValue(result.pictureInPictureState);
      }
      if (elementsOrVersion >= 8) {
        int readInt4 = decoder0.readInt(24);
        result.deprecatedAudioVideoState = readInt4;
        MediaAudioVideoState.validate(readInt4);
        result.deprecatedAudioVideoState =
            MediaAudioVideoState.toKnownValue(result.deprecatedAudioVideoState);
      }
      if (elementsOrVersion >= 11) {
        int readInt5 = decoder0.readInt(28);
        result.microphoneState = readInt5;
        MicrophoneState.validate(readInt5);
        result.microphoneState = MicrophoneState.toKnownValue(result.microphoneState);
      }
      if (elementsOrVersion >= 9) {
        result.audioSinkId = decoder0.readString(32, true);
      }
      if (elementsOrVersion >= 10) {
        int[] readInts = decoder0.readInts(40, 1, -1);
        result.audioVideoStates = readInts;
        if (readInts != null) {
          int i1 = 0;
          while (true) {
            int[] iArr = result.audioVideoStates;
            if (i1 >= iArr.length) {
              break;
            }
            MediaAudioVideoState.validate(iArr[i1]);
            i1++;
          }
        }
      }
      if (elementsOrVersion >= 11) {
        int readInt6 = decoder0.readInt(48);
        result.cameraState = readInt6;
        CameraState.validate(readInt6);
        result.cameraState = CameraState.toKnownValue(result.cameraState);
      }
      if (elementsOrVersion >= 15) {
        Decoder decoder1 = decoder0.readPointer(56, true);
        result.remotePlaybackMetadata = RemotePlaybackMetadata.decode(decoder1);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.state, 8);
    encoder0.encode(this.forceDuck, 12, 0);
    encoder0.encode(this.isControllable, 12, 1);
    encoder0.encode(this.preferStopForGainFocusLoss, 12, 2);
    encoder0.encode(this.isSensitive, 12, 3);
    encoder0.encode(this.muted, 12, 4);
    encoder0.encode(this.hasPresentation, 12, 5);
    encoder0.encode(this.hideMetadata, 12, 6);
    encoder0.encode(this.ignoreForActiveSession, 12, 7);
    encoder0.encode(this.playbackState, 16);
    encoder0.encode(this.pictureInPictureState, 20);
    encoder0.encode(this.deprecatedAudioVideoState, 24);
    encoder0.encode(this.microphoneState, 28);
    encoder0.encode(this.audioSinkId, 32, true);
    encoder0.encode(this.audioVideoStates, 40, 1, -1);
    encoder0.encode(this.cameraState, 48);
    encoder0.encode((Struct) this.remotePlaybackMetadata, 56, true);
  }
}
