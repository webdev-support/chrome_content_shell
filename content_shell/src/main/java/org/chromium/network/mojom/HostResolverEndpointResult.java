package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HostResolverEndpointResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public IpEndPoint[] ipEndpoints;
  public ConnectionEndpointMetadata metadata;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HostResolverEndpointResult(int version) {
    super(24, version);
  }

  public HostResolverEndpointResult() {
    this(0);
  }

  public static HostResolverEndpointResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HostResolverEndpointResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HostResolverEndpointResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HostResolverEndpointResult result = new HostResolverEndpointResult(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.ipEndpoints = new IpEndPoint[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.ipEndpoints[i1] = IpEndPoint.decode(decoder2);
      }
      result.metadata = ConnectionEndpointMetadata.decode(decoder0.readPointer(16, false));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    IpEndPoint[] ipEndPointArr = this.ipEndpoints;
    if (ipEndPointArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(ipEndPointArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        IpEndPoint[] ipEndPointArr2 = this.ipEndpoints;
        if (i0 >= ipEndPointArr2.length) {
          break;
        }
        encoder1.encode((Struct) ipEndPointArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.metadata, 16, false);
  }
}
