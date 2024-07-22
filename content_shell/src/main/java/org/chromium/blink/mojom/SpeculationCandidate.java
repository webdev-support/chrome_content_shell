package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.NoVarySearch;
import org.chromium.url.mojom.Url;

public final class SpeculationCandidate extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public int action;
  public int eagerness;
  public int injectionType;
  public NoVarySearch noVarySearchHint;
  public Referrer referrer;
  public boolean requiresAnonymousClientIpWhenCrossOrigin;
  public int targetBrowsingContextNameHint;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SpeculationCandidate(int version) {
    super(56, version);
    this.action = 0;
    this.requiresAnonymousClientIpWhenCrossOrigin = false;
    this.targetBrowsingContextNameHint = 0;
    this.eagerness = 0;
    this.injectionType = 0;
  }

  public SpeculationCandidate() {
    this(0);
  }

  public static SpeculationCandidate deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SpeculationCandidate deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SpeculationCandidate decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SpeculationCandidate result = new SpeculationCandidate(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.action = readInt;
      SpeculationAction.validate(readInt);
      result.action = SpeculationAction.toKnownValue(result.action);
      result.requiresAnonymousClientIpWhenCrossOrigin = decoder0.readBoolean(20, 0);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.referrer = Referrer.decode(decoder12);
      int readInt2 = decoder0.readInt(32);
      result.targetBrowsingContextNameHint = readInt2;
      SpeculationTargetHint.validate(readInt2);
      result.targetBrowsingContextNameHint =
          SpeculationTargetHint.toKnownValue(result.targetBrowsingContextNameHint);
      int readInt3 = decoder0.readInt(36);
      result.eagerness = readInt3;
      SpeculationEagerness.validate(readInt3);
      result.eagerness = SpeculationEagerness.toKnownValue(result.eagerness);
      Decoder decoder13 = decoder0.readPointer(40, true);
      result.noVarySearchHint = NoVarySearch.decode(decoder13);
      int readInt4 = decoder0.readInt(48);
      result.injectionType = readInt4;
      SpeculationInjectionType.validate(readInt4);
      result.injectionType = SpeculationInjectionType.toKnownValue(result.injectionType);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode(this.action, 16);
    encoder0.encode(this.requiresAnonymousClientIpWhenCrossOrigin, 20, 0);
    encoder0.encode((Struct) this.referrer, 24, false);
    encoder0.encode(this.targetBrowsingContextNameHint, 32);
    encoder0.encode(this.eagerness, 36);
    encoder0.encode((Struct) this.noVarySearchHint, 40, true);
    encoder0.encode(this.injectionType, 48);
  }
}
