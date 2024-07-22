package org.chromium.net;

import java.nio.charset.StandardCharsets;

public class NetworkTrafficAnnotationTag {
  private final int mHashCode;
  public static final NetworkTrafficAnnotationTag NO_TRAFFIC_ANNOTATION_YET =
      createComplete("undefined", "Nothing here yet.");
  public static final NetworkTrafficAnnotationTag MISSING_TRAFFIC_ANNOTATION =
      createComplete("undefined", "Function called without traffic annotation.");

  public static NetworkTrafficAnnotationTag createComplete(String uniqueId, String proto) {
    return new NetworkTrafficAnnotationTag(uniqueId);
  }

  public int getHashCode() {
    return this.mHashCode;
  }

  private NetworkTrafficAnnotationTag(String uniqueId) {
    this.mHashCode = iterativeHash(uniqueId);
  }

  static int iterativeHash(String s) {
    long acc = 0;
    byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
    for (byte b : bytes) {
      acc = ((31 * acc) + b) % 138003713;
    }
    return (int) acc;
  }
}
