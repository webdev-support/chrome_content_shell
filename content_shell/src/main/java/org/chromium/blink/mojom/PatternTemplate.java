package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class PatternTemplate extends Union {

  private FixedPattern mFixed;
  private WildcardPattern mFullWildcard;
  private WildcardPattern mSegmentWildcard;

  public static final class Tag {
    public static final int Fixed = 0;
    public static final int FullWildcard = 1;
    public static final int SegmentWildcard = 2;
  }

  public void setFixed(FixedPattern fixed) {
    this.mTag = 0;
    this.mFixed = fixed;
  }

  public FixedPattern getFixed() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mFixed;
  }

  public void setFullWildcard(WildcardPattern fullWildcard) {
    this.mTag = 1;
    this.mFullWildcard = fullWildcard;
  }

  public WildcardPattern getFullWildcard() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mFullWildcard;
  }

  public void setSegmentWildcard(WildcardPattern segmentWildcard) {
    this.mTag = 2;
    this.mSegmentWildcard = segmentWildcard;
  }

  public WildcardPattern getSegmentWildcard() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mSegmentWildcard;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mFixed, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mFullWildcard, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mSegmentWildcard, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static PatternTemplate deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final PatternTemplate decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    PatternTemplate result = new PatternTemplate();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mFixed = FixedPattern.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mFullWildcard = WildcardPattern.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mSegmentWildcard = WildcardPattern.decode(decoder13);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
