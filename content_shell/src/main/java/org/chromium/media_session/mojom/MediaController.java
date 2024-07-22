package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface MediaController extends Interface {
  public static final Interface.Manager<MediaController, Proxy> MANAGER =
      MediaController_Internal.MANAGER;

  public interface Proxy extends MediaController, Interface.Proxy {}

  void addObserver(MediaControllerObserver mediaControllerObserver);

  void enterAutoPictureInPicture();

  void enterPictureInPicture();

  void exitPictureInPicture();

  void hangUp();

  void nextTrack();

  void observeImages(
      int i, int i2, int i3, MediaControllerImageObserver mediaControllerImageObserver);

  void previousTrack();

  void raise();

  void requestMediaRemoting();

  void resume();

  void scrubTo(TimeDelta timeDelta);

  void seek(TimeDelta timeDelta);

  void seekTo(TimeDelta timeDelta);

  void setAudioSinkId(String str);

  void setMute(boolean z);

  void skipAd();

  void stop();

  void suspend();

  void toggleCamera();

  void toggleMicrophone();

  void toggleSuspendResume();
}
