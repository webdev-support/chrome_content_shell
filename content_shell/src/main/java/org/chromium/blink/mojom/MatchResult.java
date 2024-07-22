package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class MatchResult extends Union {

  private EagerResponse mEagerResponse;
  private FetchApiResponse mResponse;
  private int mStatus;

  public static final class Tag {
    public static final int EagerResponse = 2;
    public static final int Response = 1;
    public static final int Status = 0;
  }

  public void setStatus(int status) {
    this.mTag = 0;
    this.mStatus = status;
  }

  public int getStatus() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mStatus;
  }

  public void setResponse(FetchApiResponse response) {
    this.mTag = 1;
    this.mResponse = response;
  }

  public FetchApiResponse getResponse() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mResponse;
  }

  public void setEagerResponse(EagerResponse eagerResponse) {
    this.mTag = 2;
    this.mEagerResponse = eagerResponse;
  }

  public EagerResponse getEagerResponse() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mEagerResponse;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mStatus, offset + 8);
        return;
      case 1:
        encoder0.encode((Struct) this.mResponse, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mEagerResponse, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static MatchResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final MatchResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    MatchResult result = new MatchResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        int readInt = decoder0.readInt(offset + 8);
        result.mStatus = readInt;
        CacheStorageError.validate(readInt);
        result.mStatus = CacheStorageError.toKnownValue(result.mStatus);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mResponse = FetchApiResponse.decode(decoder1);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mEagerResponse = EagerResponse.decode(decoder12);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
