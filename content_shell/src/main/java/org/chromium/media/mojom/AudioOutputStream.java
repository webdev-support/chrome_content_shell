package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioOutputStream extends Interface {
  public static final Interface.Manager<AudioOutputStream, Proxy> MANAGER =
      AudioOutputStream_Internal.MANAGER;

  public interface Proxy extends AudioOutputStream, Interface.Proxy {}

  void flush();

  void pause();

  void play();

  void setVolume(double d);
}
