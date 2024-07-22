package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioInputStreamClient extends Interface {
  public static final Interface.Manager<AudioInputStreamClient, Proxy> MANAGER =
      AudioInputStreamClient_Internal.MANAGER;

  public interface Proxy extends AudioInputStreamClient, Interface.Proxy {}

  void onError(int i);

  void onMutedStateChanged(boolean z);
}
