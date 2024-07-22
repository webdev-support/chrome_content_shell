package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioLog extends Interface {
  public static final Interface.Manager<AudioLog, Proxy> MANAGER = AudioLog_Internal.MANAGER;

  public interface Proxy extends AudioLog, Interface.Proxy {}

  void onClosed();

  void onCreated(AudioParameters audioParameters, String str);

  void onError();

  void onLogMessage(String str);

  void onProcessingStateChanged(String str);

  void onSetVolume(double d);

  void onStarted();

  void onStopped();
}
