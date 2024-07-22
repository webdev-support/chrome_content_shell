package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;

public class MessageHeader {

  private static final int FLAGS_OFFSET = 16;
  private static final int INTERFACE_ID_OFFSET = 8;
  public static final int MESSAGE_EXPECTS_RESPONSE_FLAG = 1;
  public static final int MESSAGE_IS_RESPONSE_FLAG = 2;
  public static final int MESSAGE_IS_SYNC_FLAG = 4;
  private static final int MESSAGE_WITH_REQUEST_ID_SIZE = 32;
  private static final int MESSAGE_WITH_REQUEST_ID_VERSION = 1;
  public static final int NO_FLAG = 0;
  private static final int REQUEST_ID_OFFSET = 24;
  private static final int SIMPLE_MESSAGE_SIZE = 24;
  private static final int SIMPLE_MESSAGE_VERSION = 0;
  private static final int TYPE_OFFSET = 12;
  private final DataHeader mDataHeader;
  private final int mFlags;
  private long mRequestId;
  private final int mType;
  private static final DataHeader SIMPLE_MESSAGE_STRUCT_INFO = new DataHeader(24, 0);
  private static final DataHeader MESSAGE_WITH_REQUEST_ID_STRUCT_INFO = new DataHeader(32, 1);

  public MessageHeader(int type) {
    this.mDataHeader = SIMPLE_MESSAGE_STRUCT_INFO;
    this.mType = type;
    this.mFlags = 0;
    this.mRequestId = 0L;
  }

  public MessageHeader(int type, int flags, long requestId) {
    if (!mustHaveRequestId(flags)) {
      throw new AssertionError();
    }
    this.mDataHeader = MESSAGE_WITH_REQUEST_ID_STRUCT_INFO;
    this.mType = type;
    this.mFlags = flags;
    this.mRequestId = requestId;
  }

  public MessageHeader(Message message) {
    Decoder decoder = new Decoder(message);
    DataHeader readDataHeader = decoder.readDataHeader();
    this.mDataHeader = readDataHeader;
    validateDataHeader(readDataHeader);
    int interfaceId = decoder.readInt(8);
    if (interfaceId != 0) {
      throw new DeserializationException(
          "Non-zero interface ID, expecting zero since associated interfaces are not yet supported.");
    }
    this.mType = decoder.readInt(12);
    int readInt = decoder.readInt(16);
    this.mFlags = readInt;
    if (mustHaveRequestId(readInt)) {
      if (readDataHeader.size < 32) {
        throw new DeserializationException(
            "Incorrect message size, expecting at least 32 for a message with a request identifier, but got: "
                + readDataHeader.size);
      } else {
        this.mRequestId = decoder.readLong(24);
        return;
      }
    }
    this.mRequestId = 0L;
  }

  public int getSize() {
    return this.mDataHeader.size;
  }

  public int getType() {
    return this.mType;
  }

  public int getFlags() {
    return this.mFlags;
  }

  public boolean hasFlag(int flag) {
    return (this.mFlags & flag) == flag;
  }

  public boolean hasRequestId() {
    return mustHaveRequestId(this.mFlags);
  }

  public long getRequestId() {
    if (!hasRequestId()) {
      throw new AssertionError();
    }
    return this.mRequestId;
  }

  public void encode(Encoder encoder) {
    encoder.encode(this.mDataHeader);
    encoder.encode(0, 8);
    encoder.encode(getType(), 12);
    encoder.encode(getFlags(), 16);
    if (hasRequestId()) {
      encoder.encode(getRequestId(), 24);
    }
  }

  public boolean validateHeader(int expectedFlags) {
    int knownFlags = getFlags() & 7;
    return knownFlags == expectedFlags;
  }

  public boolean validateHeader(int expectedType, int expectedFlags) {
    return getType() == expectedType && validateHeader(expectedFlags);
  }

  public int hashCode() {
    int i = 1 * 31;
    DataHeader dataHeader = this.mDataHeader;
    int result = i + (dataHeader == null ? 0 : dataHeader.hashCode());
    long j = this.mRequestId;
    return (((((result * 31) + this.mFlags) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.mType;
  }

  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    MessageHeader other = (MessageHeader) object;
    if (BindingsHelper.equals(this.mDataHeader, other.mDataHeader)
        && this.mFlags == other.mFlags
        && this.mRequestId == other.mRequestId
        && this.mType == other.mType) {
      return true;
    }
    return false;
  }

  public void setRequestId(ByteBuffer buffer, long requestId) {
    if (!mustHaveRequestId(buffer.getInt(16))) {
      throw new AssertionError();
    }
    buffer.putLong(24, requestId);
    this.mRequestId = requestId;
  }

  private static boolean mustHaveRequestId(int flags) {
    return (flags & 3) != 0;
  }

  private static void validateDataHeader(DataHeader dataHeader) {
    if (dataHeader.elementsOrVersion < 0) {
      throw new DeserializationException(
          "Incorrect number of fields, expecting at least 0, but got: "
              + dataHeader.elementsOrVersion);
    } else if (dataHeader.size < 24) {
      throw new DeserializationException(
          "Incorrect message size, expecting at least 24, but got: " + dataHeader.size);
    } else if (dataHeader.elementsOrVersion == 0 && dataHeader.size != 24) {
      throw new DeserializationException(
          "Incorrect message size for a message with 0 fields, expecting 24, but got: "
              + dataHeader.size);
    } else if (dataHeader.elementsOrVersion == 1 && dataHeader.size != 32) {
      throw new DeserializationException(
          "Incorrect message size for a message with 1 fields, expecting 32, but got: "
              + dataHeader.size);
    }
  }
}
