package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

public interface AudioOutputStreamObserver extends Interface {
  public static final Interface.Manager<AudioOutputStreamObserver, Proxy> MANAGER =
      AudioOutputStreamObserver_Internal.MANAGER;

  public interface Proxy extends AudioOutputStreamObserver, Interface.Proxy {}

  void didChangeAudibleState(boolean z);

  void didStartPlaying();

  void didStopPlaying();

  public static final class DisconnectReason {
    public static final int DEFAULT = 0;
    public static final int DOCUMENT_DESTROYED = 4;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 4;
    public static final int MIN_VALUE = 0;
    public static final int PLATFORM_ERROR = 1;
    public static final int STREAM_CREATION_FAILED = 3;
    public static final int TERMINATED_BY_CLIENT = 2;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private DisconnectReason() {}
  }
}
