package org.chromium.mojo.bindings;

public class SerializationException extends RuntimeException {
  public SerializationException(String message) {
    super(message);
  }

  public SerializationException(Exception cause) {
    super(cause);
  }
}
