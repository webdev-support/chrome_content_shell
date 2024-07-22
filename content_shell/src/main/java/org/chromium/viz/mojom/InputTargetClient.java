package org.chromium.viz.mojom;

import org.chromium.gfx.mojom.PointF;
import org.chromium.mojo.bindings.Interface;

public interface InputTargetClient extends Interface {
  public static final Interface.Manager<InputTargetClient, Proxy> MANAGER =
      InputTargetClient_Internal.MANAGER;

  public interface FrameSinkIdAt_Response {
    void call(FrameSinkId frameSinkId, PointF pointF);
  }

  public interface Proxy extends InputTargetClient, Interface.Proxy {}

  void frameSinkIdAt(PointF pointF, long j, FrameSinkIdAt_Response frameSinkIdAt_Response);
}
