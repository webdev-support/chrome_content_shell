package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeTicks;

public interface HighPriorityLocalFrame extends Interface {
  public static final Interface.Manager<HighPriorityLocalFrame, Proxy> MANAGER =
      HighPriorityLocalFrame_Internal.MANAGER;

  public interface DispatchBeforeUnload_Response {
    void call(boolean z, TimeTicks timeTicks, TimeTicks timeTicks2);
  }

  public interface Proxy extends HighPriorityLocalFrame, Interface.Proxy {}

  void dispatchBeforeUnload(boolean z, DispatchBeforeUnload_Response dispatchBeforeUnload_Response);
}
