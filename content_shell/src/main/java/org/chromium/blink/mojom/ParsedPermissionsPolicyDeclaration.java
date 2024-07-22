package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class ParsedPermissionsPolicyDeclaration extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public OriginWithPossibleWildcards[] allowedOrigins;
  public int feature;
  public boolean matchesAllOrigins;
  public boolean matchesOpaqueSrc;
  public String reportingEndpoint;
  public Origin selfIfMatches;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ParsedPermissionsPolicyDeclaration(int version) {
    super(40, version);
  }

  public ParsedPermissionsPolicyDeclaration() {
    this(0);
  }

  public static ParsedPermissionsPolicyDeclaration deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ParsedPermissionsPolicyDeclaration deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ParsedPermissionsPolicyDeclaration decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ParsedPermissionsPolicyDeclaration result =
          new ParsedPermissionsPolicyDeclaration(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.feature = readInt;
      PermissionsPolicyFeature.validate(readInt);
      result.feature = PermissionsPolicyFeature.toKnownValue(result.feature);
      result.matchesAllOrigins = decoder0.readBoolean(12, 0);
      result.matchesOpaqueSrc = decoder0.readBoolean(12, 1);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.allowedOrigins = new OriginWithPossibleWildcards[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.allowedOrigins[i1] = OriginWithPossibleWildcards.decode(decoder2);
      }
      result.selfIfMatches = Origin.decode(decoder0.readPointer(24, true));
      result.reportingEndpoint = decoder0.readString(32, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.feature, 8);
    encoder0.encode(this.matchesAllOrigins, 12, 0);
    encoder0.encode(this.matchesOpaqueSrc, 12, 1);
    OriginWithPossibleWildcards[] originWithPossibleWildcardsArr = this.allowedOrigins;
    if (originWithPossibleWildcardsArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(originWithPossibleWildcardsArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        OriginWithPossibleWildcards[] originWithPossibleWildcardsArr2 = this.allowedOrigins;
        if (i0 >= originWithPossibleWildcardsArr2.length) {
          break;
        }
        encoder1.encode((Struct) originWithPossibleWildcardsArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.selfIfMatches, 24, true);
    encoder0.encode(this.reportingEndpoint, 32, true);
  }
}
