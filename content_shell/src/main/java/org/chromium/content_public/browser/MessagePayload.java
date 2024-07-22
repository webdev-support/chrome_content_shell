package org.chromium.content_public.browser;

import java.util.Objects;

public final class MessagePayload {
  private final byte[] mArrayBuffer;
  private final String mString;
  private final int mType;

  public MessagePayload(String string) {
    this.mType = 0;
    this.mString = string;
    this.mArrayBuffer = null;
  }

  public MessagePayload(byte[] arrayBuffer) {
    Objects.requireNonNull(arrayBuffer, "arrayBuffer cannot be null.");
    this.mType = 1;
    this.mArrayBuffer = arrayBuffer;
    this.mString = null;
  }

  public int getType() {
    return this.mType;
  }

  public String getAsString() {
    checkType(0);
    return this.mString;
  }

  public byte[] getAsArrayBuffer() {
    checkType(1);
    Objects.requireNonNull(this.mArrayBuffer, "mArrayBuffer cannot be null.");
    return this.mArrayBuffer;
  }

  private void checkType(int expectedType) {
    if (this.mType != expectedType) {
      String typeToString = typeToString(expectedType);
      throw new IllegalStateException(
          "Expected " + typeToString + ", but type is " + typeToString(this.mType));
    }
  }

  public static String typeToString(int type) {
    switch (type) {
      case -1:
        return "Invalid";
      case 0:
        return "String";
      case 1:
        return "ArrayBuffer";
      default:
        throw new IllegalArgumentException("Unknown type: " + type);
    }
  }
}
