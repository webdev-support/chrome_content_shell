package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class ControllerServiceWorkerInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public String clientId;
  public int effectiveFetchHandlerType;
  public int fetchHandlerBypassOption;
  public int fetchHandlerType;
  public UnguessableToken fetchRequestWindowId;
  public int mode;
  public boolean needRouterEvaluate;
  public ServiceWorkerObjectInfo objectInfo;
  public ControllerServiceWorker remoteController;
  public ServiceWorkerRouterData routerData;
  public String sha256ScriptChecksum;
  public int[] usedFeatures;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ControllerServiceWorkerInfo(int version) {
    super(88, version);
    this.mode = 0;
    this.fetchHandlerType = 0;
    this.effectiveFetchHandlerType = 0;
    this.fetchHandlerBypassOption = 0;
  }

  public ControllerServiceWorkerInfo() {
    this(0);
  }

  public static ControllerServiceWorkerInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ControllerServiceWorkerInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ControllerServiceWorkerInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ControllerServiceWorkerInfo result = new ControllerServiceWorkerInfo(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.mode = readInt;
      ControllerServiceWorkerMode.validate(readInt);
      result.mode = ControllerServiceWorkerMode.toKnownValue(result.mode);
      int readInt2 = decoder0.readInt(12);
      result.fetchHandlerType = readInt2;
      ServiceWorkerFetchHandlerType.validate(readInt2);
      result.fetchHandlerType = ServiceWorkerFetchHandlerType.toKnownValue(result.fetchHandlerType);
      int readInt3 = decoder0.readInt(16);
      result.effectiveFetchHandlerType = readInt3;
      ServiceWorkerFetchHandlerType.validate(readInt3);
      result.effectiveFetchHandlerType =
          ServiceWorkerFetchHandlerType.toKnownValue(result.effectiveFetchHandlerType);
      int readInt4 = decoder0.readInt(20);
      result.fetchHandlerBypassOption = readInt4;
      ServiceWorkerFetchHandlerBypassOption.validate(readInt4);
      result.fetchHandlerBypassOption =
          ServiceWorkerFetchHandlerBypassOption.toKnownValue(result.fetchHandlerBypassOption);
      result.sha256ScriptChecksum = decoder0.readString(24, true);
      result.needRouterEvaluate = decoder0.readBoolean(32, 0);
      Decoder decoder1 = decoder0.readPointer(40, true);
      result.routerData = ServiceWorkerRouterData.decode(decoder1);
      result.remoteController =
          (ControllerServiceWorker)
              decoder0.readServiceInterface(48, true, ControllerServiceWorker.MANAGER);
      result.clientId = decoder0.readString(56, false);
      Decoder decoder12 = decoder0.readPointer(64, true);
      result.fetchRequestWindowId = UnguessableToken.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(72, true);
      result.objectInfo = ServiceWorkerObjectInfo.decode(decoder13);
      result.usedFeatures = decoder0.readInts(80, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.usedFeatures;
        if (i1 < iArr.length) {
          WebFeature.validate(iArr[i1]);
          i1++;
        } else {
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
    encoder0.encode(this.mode, 8);
    encoder0.encode(this.fetchHandlerType, 12);
    encoder0.encode(this.effectiveFetchHandlerType, 16);
    encoder0.encode(this.fetchHandlerBypassOption, 20);
    encoder0.encode(this.sha256ScriptChecksum, 24, true);
    encoder0.encode(this.needRouterEvaluate, 32, 0);
    encoder0.encode((Struct) this.routerData, 40, true);
    encoder0.encode(this.remoteController, 48, true, ControllerServiceWorker.MANAGER);
    encoder0.encode(this.clientId, 56, false);
    encoder0.encode((Struct) this.fetchRequestWindowId, 64, true);
    encoder0.encode((Struct) this.objectInfo, 72, true);
    encoder0.encode(this.usedFeatures, 80, 0, -1);
  }
}
