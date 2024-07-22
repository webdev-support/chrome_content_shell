package org.chromium.mojo.bindings;

public class DeserializationException extends RuntimeException {
  public DeserializationException(String message) {
    super(message);
  }

  public DeserializationException(Exception cause) {
    super(cause);
  }
}
