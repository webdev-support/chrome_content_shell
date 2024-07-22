package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class MatchAllResult extends Union {

  private FetchApiResponse[] mResponses;
  private int mStatus;

  public static final class Tag {
    public static final int Responses = 1;
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

  public void setResponses(FetchApiResponse[] responses) {
    this.mTag = 1;
    this.mResponses = responses;
  }

  public FetchApiResponse[] getResponses() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mResponses;
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
        FetchApiResponse[] fetchApiResponseArr = this.mResponses;
        if (fetchApiResponseArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(fetchApiResponseArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          FetchApiResponse[] fetchApiResponseArr2 = this.mResponses;
          if (i0 < fetchApiResponseArr2.length) {
            encoder1.encode((Struct) fetchApiResponseArr2[i0], (i0 * 8) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      default:
        return;
    }
  }

  public static MatchAllResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final MatchAllResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    MatchAllResult result = new MatchAllResult();
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
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mResponses = new FetchApiResponse[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.mResponses[i1] = FetchApiResponse.decode(decoder2);
        }
        result.mTag = 1;
        break;
    }
    return result;
  }
}
