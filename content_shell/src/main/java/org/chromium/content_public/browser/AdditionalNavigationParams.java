package org.chromium.content_public.browser;

import org.chromium.base.UnguessableToken;

public class AdditionalNavigationParams {
  private final long mAttributionRuntimeFeatures;
  private final UnguessableToken mAttributionSrcToken;
  private final UnguessableToken mInitiatorFrameToken;
  private final int mInitiatorProcessId;

  public AdditionalNavigationParams(
      UnguessableToken initiatorFrameToken,
      int initiatorProcessId,
      UnguessableToken attributionSrcToken,
      long attributionRuntimeFeatures) {
    this.mInitiatorFrameToken = initiatorFrameToken;
    this.mInitiatorProcessId = initiatorProcessId;
    this.mAttributionSrcToken = attributionSrcToken;
    this.mAttributionRuntimeFeatures = attributionRuntimeFeatures;
  }

  public UnguessableToken getInitiatorFrameToken() {
    return this.mInitiatorFrameToken;
  }

  public int getInitiatorProcessId() {
    return this.mInitiatorProcessId;
  }

  public UnguessableToken getAttributionSrcToken() {
    return this.mAttributionSrcToken;
  }

  public long getAttributionRuntimeFeatures() {
    return this.mAttributionRuntimeFeatures;
  }
}
