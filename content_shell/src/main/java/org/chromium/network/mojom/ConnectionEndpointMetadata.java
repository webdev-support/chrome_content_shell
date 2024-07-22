package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ConnectionEndpointMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] echConfigList;
  public String[] supportedProtocolAlpns;
  public String targetName;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ConnectionEndpointMetadata(int version) {
    super(32, version);
  }

  public ConnectionEndpointMetadata() {
    this(0);
  }

  public static ConnectionEndpointMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ConnectionEndpointMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ConnectionEndpointMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ConnectionEndpointMetadata result = new ConnectionEndpointMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.supportedProtocolAlpns = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.supportedProtocolAlpns[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      result.echConfigList = decoder0.readBytes(16, 0, -1);
      result.targetName = decoder0.readString(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    String[] strArr = this.supportedProtocolAlpns;
    if (strArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.supportedProtocolAlpns;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.echConfigList, 16, 0, -1);
    encoder0.encode(this.targetName, 24, false);
  }
}
