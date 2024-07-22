package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ContentSecurityPolicy extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean blockAllMixedContent;
  public Map<Integer, CspSourceList> directives;
  public ContentSecurityPolicyHeader header;
  public String[] parsingErrors;
  public Map<Integer, String> rawDirectives;
  public String[] reportEndpoints;
  public int requireTrustedTypesFor;
  public int sandbox;
  public CspSource selfOrigin;
  public boolean treatAsPublicAddress;
  public CspTrustedTypes trustedTypes;
  public boolean upgradeInsecureRequests;
  public boolean useReportingApi;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ContentSecurityPolicy(int version) {
    super(80, version);
    this.upgradeInsecureRequests = false;
    this.treatAsPublicAddress = false;
    this.blockAllMixedContent = false;
    this.sandbox = 0;
    this.useReportingApi = false;
    this.requireTrustedTypesFor = 0;
  }

  public ContentSecurityPolicy() {
    this(0);
  }

  public static ContentSecurityPolicy deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ContentSecurityPolicy deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ContentSecurityPolicy decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ContentSecurityPolicy result = new ContentSecurityPolicy(elementsOrVersion);
      result.selfOrigin = CspSource.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      decoder1.readDataHeaderForMap();
      int[] keys0 = decoder1.readInts(8, 0, -1);
      for (int i : keys0) {
        CspDirectiveName.validate(i);
      }
      Decoder decoder2 = decoder1.readPointer(16, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
      String[] values0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        values0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      result.rawDirectives = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.rawDirectives.put(Integer.valueOf(keys0[index0]), values0[index0]);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      decoder12.readDataHeaderForMap();
      int[] keys02 = decoder12.readInts(8, 0, -1);
      for (int i3 : keys02) {
        CspDirectiveName.validate(i3);
      }
      Decoder decoder22 = decoder12.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys02.length);
      CspSourceList[] values02 = new CspSourceList[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder3 = decoder22.readPointer((i22 * 8) + 8, false);
        values02[i22] = CspSourceList.decode(decoder3);
      }
      result.directives = new HashMap();
      for (int index02 = 0; index02 < keys02.length; index02++) {
        result.directives.put(Integer.valueOf(keys02[index02]), values02[index02]);
      }
      result.upgradeInsecureRequests = decoder0.readBoolean(32, 0);
      result.treatAsPublicAddress = decoder0.readBoolean(32, 1);
      result.blockAllMixedContent = decoder0.readBoolean(32, 2);
      result.useReportingApi = decoder0.readBoolean(32, 3);
      int readInt = decoder0.readInt(36);
      result.sandbox = readInt;
      WebSandboxFlags.validate(readInt);
      result.sandbox = WebSandboxFlags.toKnownValue(result.sandbox);
      result.header = ContentSecurityPolicyHeader.decode(decoder0.readPointer(40, false));
      Decoder decoder13 = decoder0.readPointer(48, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.reportEndpoints = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.reportEndpoints[i1] = decoder13.readString((i1 * 8) + 8, false);
      }
      int readInt2 = decoder0.readInt(56);
      result.requireTrustedTypesFor = readInt2;
      CspRequireTrustedTypesFor.validate(readInt2);
      result.requireTrustedTypesFor =
          CspRequireTrustedTypesFor.toKnownValue(result.requireTrustedTypesFor);
      result.trustedTypes = CspTrustedTypes.decode(decoder0.readPointer(64, true));
      Decoder decoder14 = decoder0.readPointer(72, false);
      DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
      result.parsingErrors = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.parsingErrors[i12] = decoder14.readString((i12 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.selfOrigin, 8, false);
    if (this.rawDirectives == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(16);
      int size0 = this.rawDirectives.size();
      int[] keys0 = new int[size0];
      String[] values0 = new String[size0];
      int index0 = 0;
      for (Map.Entry<Integer, String> entry0 : this.rawDirectives.entrySet()) {
        keys0[index0] = entry0.getKey().intValue();
        values0[index0] = entry0.getValue();
        index0++;
      }
      encoder1.encode(keys0, 8, 0, -1);
      Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i1 = 0; i1 < values0.length; i1++) {
        encoder2.encode(values0[i1], (i1 * 8) + 8, false);
      }
    }
    if (this.directives == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder12 = encoder0.encoderForMap(24);
      int size02 = this.directives.size();
      int[] keys02 = new int[size02];
      CspSourceList[] values02 = new CspSourceList[size02];
      int index02 = 0;
      for (Map.Entry<Integer, CspSourceList> entry02 : this.directives.entrySet()) {
        keys02[index02] = entry02.getKey().intValue();
        values02[index02] = entry02.getValue();
        index02++;
      }
      encoder12.encode(keys02, 8, 0, -1);
      Encoder encoder22 = encoder12.encodePointerArray(values02.length, 16, -1);
      for (int i12 = 0; i12 < values02.length; i12++) {
        encoder22.encode((Struct) values02[i12], (i12 * 8) + 8, false);
      }
    }
    encoder0.encode(this.upgradeInsecureRequests, 32, 0);
    encoder0.encode(this.treatAsPublicAddress, 32, 1);
    encoder0.encode(this.blockAllMixedContent, 32, 2);
    encoder0.encode(this.useReportingApi, 32, 3);
    encoder0.encode(this.sandbox, 36);
    encoder0.encode((Struct) this.header, 40, false);
    String[] strArr = this.reportEndpoints;
    if (strArr == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(strArr.length, 48, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.reportEndpoints;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder13.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.requireTrustedTypesFor, 56);
    encoder0.encode((Struct) this.trustedTypes, 64, true);
    String[] strArr3 = this.parsingErrors;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(72, false);
      return;
    }
    Encoder encoder14 = encoder0.encodePointerArray(strArr3.length, 72, -1);
    int i02 = 0;
    while (true) {
      String[] strArr4 = this.parsingErrors;
      if (i02 < strArr4.length) {
        encoder14.encode(strArr4[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
