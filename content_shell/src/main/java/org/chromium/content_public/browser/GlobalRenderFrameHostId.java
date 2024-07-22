package org.chromium.content_public.browser;

import java.util.Objects;

public final class GlobalRenderFrameHostId {
  private final int mChildId;
  private final int mFrameRoutingId;

  public GlobalRenderFrameHostId(int childId, int frameRoutingId) {
    this.mChildId = childId;
    this.mFrameRoutingId = frameRoutingId;
  }

  public int childId() {
    return this.mChildId;
  }

  public int frameRoutingId() {
    return this.mFrameRoutingId;
  }

  public boolean equals(Object obj) {
    if (obj instanceof GlobalRenderFrameHostId) {
      GlobalRenderFrameHostId that = (GlobalRenderFrameHostId) obj;
      return this.mChildId == that.mChildId && this.mFrameRoutingId == that.mFrameRoutingId;
    }
    return false;
  }

  public int hashCode() {
    return Objects.hash(Integer.valueOf(this.mChildId), Integer.valueOf(this.mFrameRoutingId));
  }
}
