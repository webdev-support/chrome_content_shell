package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface MediaPlayer extends Interface {
  public static final Interface.Manager<MediaPlayer, Proxy> MANAGER = MediaPlayer_Internal.MANAGER;

  public interface Proxy extends MediaPlayer, Interface.Proxy {}

  void requestEnterPictureInPicture();

  void requestMediaRemoting();

  void requestMute(boolean z);

  void requestPause(boolean z);

  void requestPlay();

  void requestSeekBackward(TimeDelta timeDelta);

  void requestSeekForward(TimeDelta timeDelta);

  void requestSeekTo(TimeDelta timeDelta);

  void setAudioSinkId(String str);

  void setPersistentState(boolean z);

  void setPowerExperimentState(boolean z);

  void setVolumeMultiplier(double d);

  void suspendForFrameClosed();
}
