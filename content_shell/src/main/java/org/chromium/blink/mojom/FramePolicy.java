package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.network.mojom.WebSandboxFlags;

public final class FramePolicy extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public ParsedPermissionsPolicyDeclaration[] containerPolicy;
  public Map<Integer, PolicyValue> requiredDocumentPolicy;
  public int sandboxFlags;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FramePolicy(int version) {
    super(32, version);
  }

  public FramePolicy() {
    this(0);
  }

  public static FramePolicy deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FramePolicy deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FramePolicy decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FramePolicy result = new FramePolicy(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.sandboxFlags = readInt;
      WebSandboxFlags.validate(readInt);
      result.sandboxFlags = WebSandboxFlags.toKnownValue(result.sandboxFlags);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.containerPolicy = new ParsedPermissionsPolicyDeclaration[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.containerPolicy[i1] =
            ParsedPermissionsPolicyDeclaration.decode(decoder1.readPointer((i1 * 8) + 8, false));
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      decoder12.readDataHeaderForMap();
      int[] keys0 = decoder12.readInts(8, 0, -1);
      for (int i : keys0) {
        DocumentPolicyFeature.validate(i);
      }
      Decoder decoder2 = decoder12.readPointer(16, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
      PolicyValue[] values0 = new PolicyValue[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        values0[i2] = PolicyValue.decode(decoder2, (i2 * 16) + 8);
      }
      result.requiredDocumentPolicy = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.requiredDocumentPolicy.put(Integer.valueOf(keys0[index0]), values0[index0]);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.sandboxFlags, 8);
    ParsedPermissionsPolicyDeclaration[] parsedPermissionsPolicyDeclarationArr =
        this.containerPolicy;
    if (parsedPermissionsPolicyDeclarationArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(parsedPermissionsPolicyDeclarationArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        ParsedPermissionsPolicyDeclaration[] parsedPermissionsPolicyDeclarationArr2 =
            this.containerPolicy;
        if (i0 >= parsedPermissionsPolicyDeclarationArr2.length) {
          break;
        }
        encoder1.encode((Struct) parsedPermissionsPolicyDeclarationArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    if (this.requiredDocumentPolicy == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder12 = encoder0.encoderForMap(24);
    int size0 = this.requiredDocumentPolicy.size();
    int[] keys0 = new int[size0];
    PolicyValue[] values0 = new PolicyValue[size0];
    int index0 = 0;
    for (Map.Entry<Integer, PolicyValue> entry0 : this.requiredDocumentPolicy.entrySet()) {
      keys0[index0] = entry0.getKey().intValue();
      values0[index0] = entry0.getValue();
      index0++;
    }
    encoder12.encode(keys0, 8, 0, -1);
    Encoder encoder2 = encoder12.encodeUnionArray(values0.length, 16, -1);
    for (int i1 = 0; i1 < values0.length; i1++) {
      encoder2.encode((Union) values0[i1], (i1 * 16) + 8, false);
    }
  }
}
