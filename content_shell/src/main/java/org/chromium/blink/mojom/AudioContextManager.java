package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioContextManager extends Interface {
  public static final Interface.Manager<AudioContextManager, Proxy> MANAGER =
      AudioContextManager_Internal.MANAGER;

  public interface Proxy extends AudioContextManager, Interface.Proxy {}

  void audioContextAudiblePlaybackStarted(int i);

  void audioContextAudiblePlaybackStopped(int i);
}
