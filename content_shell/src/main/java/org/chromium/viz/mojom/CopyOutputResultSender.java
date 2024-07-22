package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CopyOutputResultSender extends Interface {
  public static final Interface.Manager<CopyOutputResultSender, Proxy> MANAGER =
      CopyOutputResultSender_Internal.MANAGER;

  public interface Proxy extends CopyOutputResultSender, Interface.Proxy {}

  void sendResult(CopyOutputResult copyOutputResult);
}
