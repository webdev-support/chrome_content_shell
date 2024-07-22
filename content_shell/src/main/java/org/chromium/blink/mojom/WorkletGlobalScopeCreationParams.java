package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class WorkletGlobalScopeCreationParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public WorkletDevToolsHost devtoolsHost;
  public UnguessableToken devtoolsToken;
  public int[] originTrialFeatures;
  public Url scriptUrl;
  public Origin starterOrigin;
  public boolean waitForDebugger;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WorkletGlobalScopeCreationParams(int version) {
    super(56, version);
  }

  public WorkletGlobalScopeCreationParams() {
    this(0);
  }

  public static WorkletGlobalScopeCreationParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WorkletGlobalScopeCreationParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WorkletGlobalScopeCreationParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WorkletGlobalScopeCreationParams result =
          new WorkletGlobalScopeCreationParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.scriptUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.starterOrigin = Origin.decode(decoder12);
      result.originTrialFeatures = decoder0.readInts(24, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.originTrialFeatures;
        if (i1 < iArr.length) {
          OriginTrialFeature.validate(iArr[i1]);
          i1++;
        } else {
          Decoder decoder13 = decoder0.readPointer(32, false);
          result.devtoolsToken = UnguessableToken.decode(decoder13);
          result.devtoolsHost =
              (WorkletDevToolsHost)
                  decoder0.readServiceInterface(40, false, WorkletDevToolsHost.MANAGER);
          result.waitForDebugger = decoder0.readBoolean(48, 0);
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.scriptUrl, 8, false);
    encoder0.encode((Struct) this.starterOrigin, 16, false);
    encoder0.encode(this.originTrialFeatures, 24, 0, -1);
    encoder0.encode((Struct) this.devtoolsToken, 32, false);
    encoder0.encode(this.devtoolsHost, 40, false, WorkletDevToolsHost.MANAGER);
    encoder0.encode(this.waitForDebugger, 48, 0);
  }
}
