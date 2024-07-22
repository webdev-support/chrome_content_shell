package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

public interface AudioInputStreamObserver extends Interface {
  public static final Interface.Manager<AudioInputStreamObserver, Proxy> MANAGER =
      AudioInputStreamObserver_Internal.MANAGER;

  public interface Proxy extends AudioInputStreamObserver, Interface.Proxy {}

  void didStartRecording();

  public static final class DisconnectReason {
    public static final int DEFAULT = 0;
    public static final int DEVICE_IN_USE = 6;
    public static final int DOCUMENT_DESTROYED = 4;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 6;
    public static final int MIN_VALUE = 0;
    public static final int PLATFORM_ERROR = 1;
    public static final int STREAM_CREATION_FAILED = 3;
    public static final int SYSTEM_PERMISSIONS = 5;
    public static final int TERMINATED_BY_CLIENT = 2;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 6;
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
