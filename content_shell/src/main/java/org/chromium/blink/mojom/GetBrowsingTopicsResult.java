package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class GetBrowsingTopicsResult extends Union {

  private EpochTopic[] mBrowsingTopics;
  private String mErrorMessage;

  public static final class Tag {
    public static final int BrowsingTopics = 1;
    public static final int ErrorMessage = 0;
  }

  public void setErrorMessage(String errorMessage) {
    this.mTag = 0;
    this.mErrorMessage = errorMessage;
  }

  public String getErrorMessage() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mErrorMessage;
  }

  public void setBrowsingTopics(EpochTopic[] browsingTopics) {
    this.mTag = 1;
    this.mBrowsingTopics = browsingTopics;
  }

  public EpochTopic[] getBrowsingTopics() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mBrowsingTopics;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mErrorMessage, offset + 8, false);
        return;
      case 1:
        EpochTopic[] epochTopicArr = this.mBrowsingTopics;
        if (epochTopicArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(epochTopicArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          EpochTopic[] epochTopicArr2 = this.mBrowsingTopics;
          if (i0 < epochTopicArr2.length) {
            encoder1.encode((Struct) epochTopicArr2[i0], (i0 * 8) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      default:
        return;
    }
  }

  public static GetBrowsingTopicsResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final GetBrowsingTopicsResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    GetBrowsingTopicsResult result = new GetBrowsingTopicsResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mErrorMessage = decoder0.readString(offset + 8, false);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mBrowsingTopics = new EpochTopic[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.mBrowsingTopics[i1] = EpochTopic.decode(decoder2);
        }
        result.mTag = 1;
        break;
    }
    return result;
  }
}
