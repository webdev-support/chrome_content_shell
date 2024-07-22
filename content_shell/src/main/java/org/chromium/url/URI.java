package org.chromium.url;

import java.net.URISyntaxException;

@Deprecated
public class URI extends GURL {
  public URI(String uri) throws URISyntaxException {
    super(uri);
    if (!isValid()) {
      throw new URISyntaxException(uri, "Uri could not be parsed as a valid GURL");
    }
  }

  private URI() {}

  public static URI create(String str) {
    try {
      return new URI(str);
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public URI getOrigin() {
    URI target = new URI();
    getOriginInternal(target);
    return target;
  }

  public String getFragment() {
    return getRef();
  }

  public boolean isAbsolute() {
    return !getScheme().isEmpty();
  }

  public String toString() {
    return getPossiblyInvalidSpec();
  }
}
