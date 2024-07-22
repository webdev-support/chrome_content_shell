package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NetworkServiceParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public UrlLoaderNetworkServiceObserver defaultObserver;
  public EnvironmentVariable[] environment;
  public boolean firstPartySetsEnabled;
  public int initialConnectionSubtype;
  public int initialConnectionType;
  public int ipProtectionProxyBypassPolicy;
  public SystemDnsResolver systemDnsResolver;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NetworkServiceParams(int version) {
    super(48, version);
    this.initialConnectionType = 0;
    this.initialConnectionSubtype = 0;
  }

  public NetworkServiceParams() {
    this(0);
  }

  public static NetworkServiceParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NetworkServiceParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NetworkServiceParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NetworkServiceParams result = new NetworkServiceParams(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.initialConnectionType = readInt;
      ConnectionType.validate(readInt);
      result.initialConnectionType = ConnectionType.toKnownValue(result.initialConnectionType);
      int readInt2 = decoder0.readInt(12);
      result.initialConnectionSubtype = readInt2;
      ConnectionSubtype.validate(readInt2);
      result.initialConnectionSubtype =
          ConnectionSubtype.toKnownValue(result.initialConnectionSubtype);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.environment = new EnvironmentVariable[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.environment[i1] = EnvironmentVariable.decode(decoder2);
      }
      result.defaultObserver =
          (UrlLoaderNetworkServiceObserver)
              decoder0.readServiceInterface(24, false, UrlLoaderNetworkServiceObserver.MANAGER);
      result.firstPartySetsEnabled = decoder0.readBoolean(32, 0);
      result.systemDnsResolver =
          (SystemDnsResolver) decoder0.readServiceInterface(36, true, SystemDnsResolver.MANAGER);
      int readInt3 = decoder0.readInt(44);
      result.ipProtectionProxyBypassPolicy = readInt3;
      IpProtectionProxyBypassPolicy.validate(readInt3);
      result.ipProtectionProxyBypassPolicy =
          IpProtectionProxyBypassPolicy.toKnownValue(result.ipProtectionProxyBypassPolicy);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.initialConnectionType, 8);
    encoder0.encode(this.initialConnectionSubtype, 12);
    EnvironmentVariable[] environmentVariableArr = this.environment;
    if (environmentVariableArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(environmentVariableArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        EnvironmentVariable[] environmentVariableArr2 = this.environment;
        if (i0 >= environmentVariableArr2.length) {
          break;
        }
        encoder1.encode((Struct) environmentVariableArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.defaultObserver, 24, false, UrlLoaderNetworkServiceObserver.MANAGER);
    encoder0.encode(this.firstPartySetsEnabled, 32, 0);
    encoder0.encode(this.systemDnsResolver, 36, true, SystemDnsResolver.MANAGER);
    encoder0.encode(this.ipProtectionProxyBypassPolicy, 44);
  }
}
