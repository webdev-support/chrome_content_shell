package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface InnerTextAgent extends Interface {
  public static final Interface.Manager<InnerTextAgent, Proxy> MANAGER =
      InnerTextAgent_Internal.MANAGER;

  public interface GetInnerText_Response {
    void call(InnerTextFrame innerTextFrame);
  }

  public interface Proxy extends InnerTextAgent, Interface.Proxy {}

  void getInnerText(InnerTextParams innerTextParams, GetInnerText_Response getInnerText_Response);
}
