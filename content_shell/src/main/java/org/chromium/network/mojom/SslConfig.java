package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SslConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public String[] clientCertPoolingPolicy;
  public short[] disabledCipherSuites;
  public boolean echEnabled;
  public int insecureHashOverride;
  public int postQuantumOverride;
  public boolean revCheckingEnabled;
  public boolean revCheckingRequiredLocalAnchors;
  public int rsaKeyUsageForLocalAnchorsOverride;
  public boolean sha1LocalAnchorsEnabled;
  public boolean symantecEnforcementDisabled;
  public int versionMax;
  public int versionMin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SslConfig(int version) {
    super(48, version);
    this.revCheckingEnabled = false;
    this.revCheckingRequiredLocalAnchors = false;
    this.sha1LocalAnchorsEnabled = false;
    this.symantecEnforcementDisabled = false;
    this.versionMin = 0;
    this.versionMax = 1;
    this.postQuantumOverride = 0;
    this.echEnabled = true;
    this.insecureHashOverride = 0;
    this.rsaKeyUsageForLocalAnchorsOverride = 0;
  }

  public SslConfig() {
    this(0);
  }

  public static SslConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SslConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SslConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SslConfig result = new SslConfig(elementsOrVersion);
      result.revCheckingEnabled = decoder0.readBoolean(8, 0);
      result.revCheckingRequiredLocalAnchors = decoder0.readBoolean(8, 1);
      result.sha1LocalAnchorsEnabled = decoder0.readBoolean(8, 2);
      result.symantecEnforcementDisabled = decoder0.readBoolean(8, 3);
      result.echEnabled = decoder0.readBoolean(8, 4);
      int readInt = decoder0.readInt(12);
      result.versionMin = readInt;
      SslVersion.validate(readInt);
      result.versionMin = SslVersion.toKnownValue(result.versionMin);
      int readInt2 = decoder0.readInt(16);
      result.versionMax = readInt2;
      SslVersion.validate(readInt2);
      result.versionMax = SslVersion.toKnownValue(result.versionMax);
      int readInt3 = decoder0.readInt(20);
      result.postQuantumOverride = readInt3;
      OptionalBool.validate(readInt3);
      result.postQuantumOverride = OptionalBool.toKnownValue(result.postQuantumOverride);
      result.disabledCipherSuites = decoder0.readShorts(24, 0, -1);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.clientCertPoolingPolicy = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.clientCertPoolingPolicy[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      int readInt4 = decoder0.readInt(40);
      result.insecureHashOverride = readInt4;
      OptionalBool.validate(readInt4);
      result.insecureHashOverride = OptionalBool.toKnownValue(result.insecureHashOverride);
      int readInt5 = decoder0.readInt(44);
      result.rsaKeyUsageForLocalAnchorsOverride = readInt5;
      OptionalBool.validate(readInt5);
      result.rsaKeyUsageForLocalAnchorsOverride =
          OptionalBool.toKnownValue(result.rsaKeyUsageForLocalAnchorsOverride);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.revCheckingEnabled, 8, 0);
    encoder0.encode(this.revCheckingRequiredLocalAnchors, 8, 1);
    encoder0.encode(this.sha1LocalAnchorsEnabled, 8, 2);
    encoder0.encode(this.symantecEnforcementDisabled, 8, 3);
    encoder0.encode(this.echEnabled, 8, 4);
    encoder0.encode(this.versionMin, 12);
    encoder0.encode(this.versionMax, 16);
    encoder0.encode(this.postQuantumOverride, 20);
    encoder0.encode(this.disabledCipherSuites, 24, 0, -1);
    String[] strArr = this.clientCertPoolingPolicy;
    if (strArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.clientCertPoolingPolicy;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.insecureHashOverride, 40);
    encoder0.encode(this.rsaKeyUsageForLocalAnchorsOverride, 44);
  }
}
