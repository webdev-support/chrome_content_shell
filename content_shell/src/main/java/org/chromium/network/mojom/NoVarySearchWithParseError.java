package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class NoVarySearchWithParseError extends Union {

  private NoVarySearch mNoVarySearch;
  private int mParseError;

  public static final class Tag {
    public static final int NoVarySearch = 0;
    public static final int ParseError = 1;
  }

  public void setNoVarySearch(NoVarySearch noVarySearch) {
    this.mTag = 0;
    this.mNoVarySearch = noVarySearch;
  }

  public NoVarySearch getNoVarySearch() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mNoVarySearch;
  }

  public void setParseError(int parseError) {
    this.mTag = 1;
    this.mParseError = parseError;
  }

  public int getParseError() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mParseError;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mNoVarySearch, offset + 8, false);
        return;
      case 1:
        encoder0.encode(this.mParseError, offset + 8);
        return;
      default:
        return;
    }
  }

  public static NoVarySearchWithParseError deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final NoVarySearchWithParseError decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    NoVarySearchWithParseError result = new NoVarySearchWithParseError();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mNoVarySearch = NoVarySearch.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        int readInt = decoder0.readInt(offset + 8);
        result.mParseError = readInt;
        NoVarySearchParseError.validate(readInt);
        result.mParseError = NoVarySearchParseError.toKnownValue(result.mParseError);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
