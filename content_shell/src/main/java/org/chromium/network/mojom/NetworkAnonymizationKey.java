package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class NetworkAnonymizationKey extends Union {

  private EmptyNetworkAnonymizationKey mEmpty;
  private NonEmptyNetworkAnonymizationKey mNonEmpty;

  public static final class Tag {
    public static final int Empty = 0;
    public static final int NonEmpty = 1;
  }

  public void setEmpty(EmptyNetworkAnonymizationKey empty) {
    this.mTag = 0;
    this.mEmpty = empty;
  }

  public EmptyNetworkAnonymizationKey getEmpty() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mEmpty;
  }

  public void setNonEmpty(NonEmptyNetworkAnonymizationKey nonEmpty) {
    this.mTag = 1;
    this.mNonEmpty = nonEmpty;
  }

  public NonEmptyNetworkAnonymizationKey getNonEmpty() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mNonEmpty;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mEmpty, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mNonEmpty, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static NetworkAnonymizationKey deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final NetworkAnonymizationKey decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    NetworkAnonymizationKey result = new NetworkAnonymizationKey();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mEmpty = EmptyNetworkAnonymizationKey.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mNonEmpty = NonEmptyNetworkAnonymizationKey.decode(decoder12);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
