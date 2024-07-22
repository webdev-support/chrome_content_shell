package org.chromium.content_public.common;

public class Referrer {
  private final int mPolicy;
  private final String mUrl;

  public Referrer(String url, int policy) {
    this.mUrl = url;
    this.mPolicy = policy;
  }

  public String getUrl() {
    return this.mUrl;
  }

  public int getPolicy() {
    return this.mPolicy;
  }
}
