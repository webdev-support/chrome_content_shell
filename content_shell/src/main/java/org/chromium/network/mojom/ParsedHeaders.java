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
import org.chromium.mojo.bindings.Union;

public final class ParsedHeaders extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 152;
  private static final DataHeader[] VERSION_ARRAY;
  public int[] acceptCh;
  public AllowCspFromHeaderValue allowCspFrom;
  public boolean clientHintsIgnoredDueToClearSiteDataHeader;
  public String[] contentLanguage;
  public ContentSecurityPolicy[] contentSecurityPolicy;
  public int[] criticalCh;
  public CrossOriginEmbedderPolicy crossOriginEmbedderPolicy;
  public CrossOriginOpenerPolicy crossOriginOpenerPolicy;
  public LinkHeader[] linkHeaders;
  public NoVarySearchWithParseError noVarySearchWithParseError;
  public boolean observeBrowsingTopics;
  public int originAgentCluster;
  public Map<String, String> reportingEndpoints;
  public int[] supportsLoadingMode;
  public TimingAllowOrigin timingAllowOrigin;
  public VariantsHeader[] variantsHeaders;
  public int xfo;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(152, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ParsedHeaders(int version) {
    super(152, version);
    this.xfo = 0;
  }

  public ParsedHeaders() {
    this(0);
  }

  public static ParsedHeaders deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ParsedHeaders deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ParsedHeaders decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ParsedHeaders result = new ParsedHeaders(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.contentSecurityPolicy = new ContentSecurityPolicy[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.contentSecurityPolicy[i1] =
            ContentSecurityPolicy.decode(decoder1.readPointer((i1 * 8) + 8, false));
      }
      result.allowCspFrom = AllowCspFromHeaderValue.decode(decoder0, 16);
      result.crossOriginEmbedderPolicy =
          CrossOriginEmbedderPolicy.decode(decoder0.readPointer(32, false));
      result.crossOriginOpenerPolicy =
          CrossOriginOpenerPolicy.decode(decoder0.readPointer(40, false));
      int readInt = decoder0.readInt(48);
      result.originAgentCluster = readInt;
      OriginAgentClusterValue.validate(readInt);
      result.originAgentCluster = OriginAgentClusterValue.toKnownValue(result.originAgentCluster);
      result.clientHintsIgnoredDueToClearSiteDataHeader = decoder0.readBoolean(52, 0);
      result.observeBrowsingTopics = decoder0.readBoolean(52, 1);
      int[] readInts = decoder0.readInts(56, 1, -1);
      result.acceptCh = readInts;
      if (readInts != null) {
        int i12 = 0;
        while (true) {
          int[] iArr = result.acceptCh;
          if (i12 >= iArr.length) {
            break;
          }
          WebClientHintsType.validate(iArr[i12]);
          i12++;
        }
      }
      int[] readInts2 = decoder0.readInts(64, 1, -1);
      result.criticalCh = readInts2;
      if (readInts2 != null) {
        int i13 = 0;
        while (true) {
          int[] iArr2 = result.criticalCh;
          if (i13 >= iArr2.length) {
            break;
          }
          WebClientHintsType.validate(iArr2[i13]);
          i13++;
        }
      }
      int readInt2 = decoder0.readInt(72);
      result.xfo = readInt2;
      XFrameOptionsValue.validate(readInt2);
      result.xfo = XFrameOptionsValue.toKnownValue(result.xfo);
      Decoder decoder12 = decoder0.readPointer(80, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.linkHeaders = new LinkHeader[si12.elementsOrVersion];
      for (int i14 = 0; i14 < si12.elementsOrVersion; i14++) {
        result.linkHeaders[i14] = LinkHeader.decode(decoder12.readPointer((i14 * 8) + 8, false));
      }
      result.timingAllowOrigin = TimingAllowOrigin.decode(decoder0, 88);
      result.supportsLoadingMode = decoder0.readInts(104, 0, -1);
      int i15 = 0;
      while (true) {
        int[] iArr3 = result.supportsLoadingMode;
        if (i15 >= iArr3.length) {
          break;
        }
        LoadingMode.validate(iArr3[i15]);
        i15++;
      }
      Decoder decoder13 = decoder0.readPointer(112, true);
      if (decoder13 == null) {
        result.reportingEndpoints = null;
      } else {
        decoder13.readDataHeaderForMap();
        Decoder decoder2 = decoder13.readPointer(8, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
        String[] keys0 = new String[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
        }
        Decoder decoder22 = decoder13.readPointer(16, false);
        DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
        String[] values0 = new String[si22.elementsOrVersion];
        for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
          values0[i22] = decoder22.readString((i22 * 8) + 8, false);
        }
        result.reportingEndpoints = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.reportingEndpoints.put(keys0[index0], values0[index0]);
        }
      }
      Decoder decoder14 = decoder0.readPointer(120, true);
      if (decoder14 == null) {
        result.variantsHeaders = null;
      } else {
        DataHeader si13 = decoder14.readDataHeaderForPointerArray(-1);
        result.variantsHeaders = new VariantsHeader[si13.elementsOrVersion];
        for (int i16 = 0; i16 < si13.elementsOrVersion; i16++) {
          result.variantsHeaders[i16] =
              VariantsHeader.decode(decoder14.readPointer((i16 * 8) + 8, false));
        }
      }
      Decoder decoder15 = decoder0.readPointer(128, true);
      if (decoder15 == null) {
        result.contentLanguage = null;
      } else {
        DataHeader si14 = decoder15.readDataHeaderForPointerArray(-1);
        result.contentLanguage = new String[si14.elementsOrVersion];
        for (int i17 = 0; i17 < si14.elementsOrVersion; i17++) {
          result.contentLanguage[i17] = decoder15.readString((i17 * 8) + 8, false);
        }
      }
      result.noVarySearchWithParseError = NoVarySearchWithParseError.decode(decoder0, 136);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    ContentSecurityPolicy[] contentSecurityPolicyArr = this.contentSecurityPolicy;
    if (contentSecurityPolicyArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(contentSecurityPolicyArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ContentSecurityPolicy[] contentSecurityPolicyArr2 = this.contentSecurityPolicy;
        if (i0 >= contentSecurityPolicyArr2.length) {
          break;
        }
        encoder1.encode((Struct) contentSecurityPolicyArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Union) this.allowCspFrom, 16, true);
    encoder0.encode((Struct) this.crossOriginEmbedderPolicy, 32, false);
    encoder0.encode((Struct) this.crossOriginOpenerPolicy, 40, false);
    encoder0.encode(this.originAgentCluster, 48);
    encoder0.encode(this.clientHintsIgnoredDueToClearSiteDataHeader, 52, 0);
    encoder0.encode(this.observeBrowsingTopics, 52, 1);
    encoder0.encode(this.acceptCh, 56, 1, -1);
    encoder0.encode(this.criticalCh, 64, 1, -1);
    encoder0.encode(this.xfo, 72);
    LinkHeader[] linkHeaderArr = this.linkHeaders;
    if (linkHeaderArr == null) {
      encoder0.encodeNullPointer(80, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(linkHeaderArr.length, 80, -1);
      int i02 = 0;
      while (true) {
        LinkHeader[] linkHeaderArr2 = this.linkHeaders;
        if (i02 >= linkHeaderArr2.length) {
          break;
        }
        encoder12.encode((Struct) linkHeaderArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode((Union) this.timingAllowOrigin, 88, true);
    encoder0.encode(this.supportsLoadingMode, 104, 0, -1);
    if (this.reportingEndpoints == null) {
      encoder0.encodeNullPointer(112, true);
    } else {
      Encoder encoder13 = encoder0.encoderForMap(112);
      int size0 = this.reportingEndpoints.size();
      String[] keys0 = new String[size0];
      String[] values0 = new String[size0];
      int index0 = 0;
      for (Map.Entry<String, String> entry0 : this.reportingEndpoints.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder13.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder13.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode(values0[i12], (i12 * 8) + 8, false);
      }
    }
    VariantsHeader[] variantsHeaderArr = this.variantsHeaders;
    if (variantsHeaderArr == null) {
      encoder0.encodeNullPointer(120, true);
    } else {
      Encoder encoder14 = encoder0.encodePointerArray(variantsHeaderArr.length, 120, -1);
      int i03 = 0;
      while (true) {
        VariantsHeader[] variantsHeaderArr2 = this.variantsHeaders;
        if (i03 >= variantsHeaderArr2.length) {
          break;
        }
        encoder14.encode((Struct) variantsHeaderArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    String[] strArr = this.contentLanguage;
    if (strArr == null) {
      encoder0.encodeNullPointer(128, true);
    } else {
      Encoder encoder15 = encoder0.encodePointerArray(strArr.length, 128, -1);
      int i04 = 0;
      while (true) {
        String[] strArr2 = this.contentLanguage;
        if (i04 >= strArr2.length) {
          break;
        }
        encoder15.encode(strArr2[i04], (i04 * 8) + 8, false);
        i04++;
      }
    }
    encoder0.encode((Union) this.noVarySearchWithParseError, 136, true);
  }
}
