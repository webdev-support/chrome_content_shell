package org.chromium.content_public.browser;

import org.chromium.content.browser.framehost.RenderFrameHostDelegate;
import org.chromium.content.browser.framehost.RenderFrameHostImpl;

public class WebContentsStatics {
  public static WebContents fromRenderFrameHost(RenderFrameHost rfh) {
    RenderFrameHostDelegate delegate = ((RenderFrameHostImpl) rfh).getRenderFrameHostDelegate();
    if (delegate == null || !(delegate instanceof WebContents)) {
      return null;
    }
    return (WebContents) delegate;
  }
}
