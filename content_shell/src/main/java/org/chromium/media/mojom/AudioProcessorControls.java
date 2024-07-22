package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioProcessorControls extends Interface {
  public static final Interface.Manager<AudioProcessorControls, Proxy> MANAGER =
      AudioProcessorControls_Internal.MANAGER;

  public interface GetStats_Response {
    void call(AudioProcessingStats audioProcessingStats);
  }

  public interface Proxy extends AudioProcessorControls, Interface.Proxy {}

  void getStats(GetStats_Response getStats_Response);

  void setPreferredNumCaptureChannels(int i);
}
