package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface MediaSession extends Interface {
  public static final Interface.Manager<MediaSession, Proxy> MANAGER =
      MediaSession_Internal.MANAGER;

  public interface GetDebugInfo_Response {
    void call(MediaSessionDebugInfo mediaSessionDebugInfo);
  }

  public interface GetMediaImageBitmap_Response {
    void call(MediaImageBitmap mediaImageBitmap);
  }

  public interface GetMediaSessionInfo_Response {
    void call(MediaSessionInfo mediaSessionInfo);
  }

  public interface Proxy extends MediaSession, Interface.Proxy {}

  void addObserver(MediaSessionObserver mediaSessionObserver);

  void enterAutoPictureInPicture();

  void enterPictureInPicture();

  void exitPictureInPicture();

  void getDebugInfo(GetDebugInfo_Response getDebugInfo_Response);

  void getMediaImageBitmap(
      MediaImage mediaImage,
      int i,
      int i2,
      GetMediaImageBitmap_Response getMediaImageBitmap_Response);

  void getMediaSessionInfo(GetMediaSessionInfo_Response getMediaSessionInfo_Response);

  void hangUp();

  void nextSlide();

  void nextTrack();

  void previousSlide();

  void previousTrack();

  void raise();

  void requestMediaRemoting();

  void resume(int i);

  void scrubTo(TimeDelta timeDelta);

  void seek(TimeDelta timeDelta);

  void seekTo(TimeDelta timeDelta);

  void setAudioSinkId(String str);

  void setMute(boolean z);

  void skipAd();

  void startDucking();

  void stop(int i);

  void stopDucking();

  void suspend(int i);

  void toggleCamera();

  void toggleMicrophone();

  public static final class SuspendType {
    public static final int CONTENT = 2;
    private static final boolean IS_EXTENSIBLE = true;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int SYSTEM = 0;

    public static final int f679UI = 1;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 2;
    }

    public static void validate(int value) {}

    public static int toKnownValue(int value) {
      return value;
    }

    private SuspendType() {}
  }
}
