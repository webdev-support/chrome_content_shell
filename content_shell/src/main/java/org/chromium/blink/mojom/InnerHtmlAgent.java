package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface InnerHtmlAgent extends Interface {
  public static final Interface.Manager<InnerHtmlAgent, Proxy> MANAGER =
      InnerHtmlAgent_Internal.MANAGER;

  public interface GetInnerHtml_Response {
    void call(String str);
  }

  public interface Proxy extends InnerHtmlAgent, Interface.Proxy {}

  void getInnerHtml(GetInnerHtml_Response getInnerHtml_Response);
}
