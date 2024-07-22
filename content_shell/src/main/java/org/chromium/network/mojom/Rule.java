package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class Rule extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String[] dnsAliases;
  public String hostPattern;
  public int hostResolverFlags;
  public String replacement;
  public int resolverType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Rule(int version) {
    super(40, version);
  }

  public Rule() {
    this(0);
  }

  public static Rule deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Rule deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Rule decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Rule result = new Rule(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.resolverType = readInt;
      ResolverType.validate(readInt);
      result.resolverType = ResolverType.toKnownValue(result.resolverType);
      result.hostResolverFlags = decoder0.readInt(12);
      result.hostPattern = decoder0.readString(16, false);
      result.replacement = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.dnsAliases = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.dnsAliases[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.resolverType, 8);
    encoder0.encode(this.hostResolverFlags, 12);
    encoder0.encode(this.hostPattern, 16, false);
    encoder0.encode(this.replacement, 24, false);
    String[] strArr = this.dnsAliases;
    if (strArr == null) {
      encoder0.encodeNullPointer(32, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 32, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.dnsAliases;
      if (i0 < strArr2.length) {
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
