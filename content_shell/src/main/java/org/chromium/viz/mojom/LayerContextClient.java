package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

public interface LayerContextClient extends Interface {
  public static final Interface.Manager<LayerContextClient, Proxy> MANAGER =
      LayerContextClient_Internal.MANAGER;

  public interface Proxy extends LayerContextClient, Interface.Proxy {}

  void onRequestCommitForFrame(BeginFrameArgs beginFrameArgs);
}
