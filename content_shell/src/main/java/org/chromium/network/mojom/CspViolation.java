package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class CspViolation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public Url blockedUrl;
  public String consoleMessage;
  public String directive;
  public String effectiveDirective;
  public String header;
  public String[] reportEndpoints;
  public SourceLocation sourceLocation;
  public int type;
  public boolean useReportingApi;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CspViolation(int version) {
    super(72, version);
  }

  public CspViolation() {
    this(0);
  }

  public static CspViolation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CspViolation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CspViolation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CspViolation result = new CspViolation(elementsOrVersion);
      result.directive = decoder0.readString(8, false);
      result.effectiveDirective = decoder0.readString(16, false);
      result.consoleMessage = decoder0.readString(24, false);
      result.blockedUrl = Url.decode(decoder0.readPointer(32, false));
      Decoder decoder1 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.reportEndpoints = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.reportEndpoints[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      result.useReportingApi = decoder0.readBoolean(48, 0);
      int readInt = decoder0.readInt(52);
      result.type = readInt;
      ContentSecurityPolicyType.validate(readInt);
      result.type = ContentSecurityPolicyType.toKnownValue(result.type);
      result.header = decoder0.readString(56, false);
      result.sourceLocation = SourceLocation.decode(decoder0.readPointer(64, false));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.directive, 8, false);
    encoder0.encode(this.effectiveDirective, 16, false);
    encoder0.encode(this.consoleMessage, 24, false);
    encoder0.encode((Struct) this.blockedUrl, 32, false);
    String[] strArr = this.reportEndpoints;
    if (strArr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 40, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.reportEndpoints;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.useReportingApi, 48, 0);
    encoder0.encode(this.type, 52);
    encoder0.encode(this.header, 56, false);
    encoder0.encode((Struct) this.sourceLocation, 64, false);
  }
}
