package org.chromium.mojo.bindings;

public final class DataHeader {
  public static final int ELEMENTS_OR_VERSION_OFFSET = 4;
  public static final int HEADER_SIZE = 8;
  public static final int SIZE_OFFSET = 0;
  public final int elementsOrVersion;
  public final int size;

  public DataHeader(int size, int elementsOrVersion) {
    this.size = size;
    this.elementsOrVersion = elementsOrVersion;
  }

  public int hashCode() {
    int result = (1 * 31) + this.elementsOrVersion;
    return (result * 31) + this.size;
  }

  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    DataHeader other = (DataHeader) object;
    if (this.elementsOrVersion == other.elementsOrVersion && this.size == other.size) {
      return true;
    }
    return false;
  }
}
