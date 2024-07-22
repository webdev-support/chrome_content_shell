package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HttpAuthDynamicParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowGssapiLibraryLoad;
  public String[] allowedSchemes;
  public String androidNegotiateAccountType;
  public boolean basicOverHttpEnabled;
  public String delegateAllowlist;
  public boolean delegateByKdcPolicy;
  public boolean enableNegotiatePort;
  public boolean negotiateDisableCnameLookup;
  public boolean ntlmV2Enabled;
  public String[] patternsAllowedToUseAllSchemes;
  public String serverAllowlist;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HttpAuthDynamicParams(int version) {
    super(56, version);
    this.delegateByKdcPolicy = false;
    this.negotiateDisableCnameLookup = false;
    this.enableNegotiatePort = false;
    this.ntlmV2Enabled = true;
    this.allowGssapiLibraryLoad = true;
    this.basicOverHttpEnabled = true;
  }

  public HttpAuthDynamicParams() {
    this(0);
  }

  public static HttpAuthDynamicParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HttpAuthDynamicParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HttpAuthDynamicParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HttpAuthDynamicParams result = new HttpAuthDynamicParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      if (decoder1 == null) {
        result.allowedSchemes = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.allowedSchemes = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.allowedSchemes[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.patternsAllowedToUseAllSchemes = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.patternsAllowedToUseAllSchemes[i12] = decoder12.readString((i12 * 8) + 8, false);
      }
      result.serverAllowlist = decoder0.readString(24, false);
      result.delegateAllowlist = decoder0.readString(32, false);
      result.delegateByKdcPolicy = decoder0.readBoolean(40, 0);
      result.negotiateDisableCnameLookup = decoder0.readBoolean(40, 1);
      result.enableNegotiatePort = decoder0.readBoolean(40, 2);
      result.ntlmV2Enabled = decoder0.readBoolean(40, 3);
      result.allowGssapiLibraryLoad = decoder0.readBoolean(40, 4);
      result.basicOverHttpEnabled = decoder0.readBoolean(40, 5);
      result.androidNegotiateAccountType = decoder0.readString(48, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    String[] strArr = this.allowedSchemes;
    if (strArr == null) {
      encoder0.encodeNullPointer(8, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.allowedSchemes;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr3 = this.patternsAllowedToUseAllSchemes;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        String[] strArr4 = this.patternsAllowedToUseAllSchemes;
        if (i02 >= strArr4.length) {
          break;
        }
        encoder12.encode(strArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode(this.serverAllowlist, 24, false);
    encoder0.encode(this.delegateAllowlist, 32, false);
    encoder0.encode(this.delegateByKdcPolicy, 40, 0);
    encoder0.encode(this.negotiateDisableCnameLookup, 40, 1);
    encoder0.encode(this.enableNegotiatePort, 40, 2);
    encoder0.encode(this.ntlmV2Enabled, 40, 3);
    encoder0.encode(this.allowGssapiLibraryLoad, 40, 4);
    encoder0.encode(this.basicOverHttpEnabled, 40, 5);
    encoder0.encode(this.androidNegotiateAccountType, 48, false);
  }
}
