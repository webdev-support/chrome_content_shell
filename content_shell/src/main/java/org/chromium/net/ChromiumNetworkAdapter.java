package org.chromium.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public final class ChromiumNetworkAdapter {
  private ChromiumNetworkAdapter() {}

  public static URLConnection openConnection(URL url, NetworkTrafficAnnotationTag trafficAnnotation)
      throws IOException {
    return url.openConnection();
  }

  public static URLConnection openConnection(
      URL url, Proxy proxy, NetworkTrafficAnnotationTag trafficAnnotation) throws IOException {
    return url.openConnection(proxy);
  }

  public static InputStream openStream(URL url, NetworkTrafficAnnotationTag trafficAnnotation)
      throws IOException {
    return url.openStream();
  }
}
