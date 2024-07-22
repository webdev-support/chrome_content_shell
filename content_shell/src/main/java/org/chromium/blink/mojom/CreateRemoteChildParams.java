package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class CreateRemoteChildParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public CreateRemoteChildParams[] childParams;
  public UnguessableToken devtoolsFrameToken;
  public RemoteFrameInterfacesFromBrowser frameInterfaces;
  public boolean isLoading;
  public FrameToken openerFrameToken;
  public FrameOwnerProperties ownerProperties;
  public FrameReplicationState replicationState;
  public RemoteFrameToken token;
  public int treeScopeType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CreateRemoteChildParams(int version) {
    super(80, version);
  }

  public CreateRemoteChildParams() {
    this(0);
  }

  public static CreateRemoteChildParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CreateRemoteChildParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CreateRemoteChildParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CreateRemoteChildParams result = new CreateRemoteChildParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.token = RemoteFrameToken.decode(decoder1);
      result.openerFrameToken = FrameToken.decode(decoder0, 16);
      int readInt = decoder0.readInt(32);
      result.treeScopeType = readInt;
      TreeScopeType.validate(readInt);
      result.treeScopeType = TreeScopeType.toKnownValue(result.treeScopeType);
      result.isLoading = decoder0.readBoolean(36, 0);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.replicationState = FrameReplicationState.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(48, false);
      result.ownerProperties = FrameOwnerProperties.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(56, false);
      result.devtoolsFrameToken = UnguessableToken.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(64, false);
      result.frameInterfaces = RemoteFrameInterfacesFromBrowser.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(72, false);
      DataHeader si1 = decoder16.readDataHeaderForPointerArray(-1);
      result.childParams = new CreateRemoteChildParams[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder16.readPointer((i1 * 8) + 8, false);
        result.childParams[i1] = decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.token, 8, false);
    encoder0.encode((Union) this.openerFrameToken, 16, true);
    encoder0.encode(this.treeScopeType, 32);
    encoder0.encode(this.isLoading, 36, 0);
    encoder0.encode((Struct) this.replicationState, 40, false);
    encoder0.encode((Struct) this.ownerProperties, 48, false);
    encoder0.encode((Struct) this.devtoolsFrameToken, 56, false);
    encoder0.encode((Struct) this.frameInterfaces, 64, false);
    CreateRemoteChildParams[] createRemoteChildParamsArr = this.childParams;
    if (createRemoteChildParamsArr == null) {
      encoder0.encodeNullPointer(72, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(createRemoteChildParamsArr.length, 72, -1);
    int i0 = 0;
    while (true) {
      CreateRemoteChildParams[] createRemoteChildParamsArr2 = this.childParams;
      if (i0 < createRemoteChildParamsArr2.length) {
        encoder1.encode((Struct) createRemoteChildParamsArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
