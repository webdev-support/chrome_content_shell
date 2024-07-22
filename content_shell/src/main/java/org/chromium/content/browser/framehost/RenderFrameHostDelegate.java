package org.chromium.content.browser.framehost;

public interface RenderFrameHostDelegate {
  void renderFrameCreated(RenderFrameHostImpl renderFrameHostImpl);

  void renderFrameDeleted(RenderFrameHostImpl renderFrameHostImpl);
}
