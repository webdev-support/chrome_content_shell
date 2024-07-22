package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioInputStream extends Interface {
  public static final Interface.Manager<AudioInputStream, Proxy> MANAGER =
      AudioInputStream_Internal.MANAGER;

  public interface Proxy extends AudioInputStream, Interface.Proxy {}

  void record();

  void setVolume(double d);
}
