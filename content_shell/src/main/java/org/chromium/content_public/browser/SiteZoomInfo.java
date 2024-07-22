package org.chromium.content_public.browser;

public final class SiteZoomInfo {
  public final String host;
  public final double zoomLevel;

  public SiteZoomInfo(String host, double zoomLevel) {
    this.host = host;
    this.zoomLevel = zoomLevel;
  }
}
