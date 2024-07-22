package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ServiceWorkerRouterCondition extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public ServiceWorkerRouterOrCondition orCondition;
  public ServiceWorkerRouterRequestCondition request;
  public ServiceWorkerRouterRunningStatusCondition runningStatus;
  public SafeUrlPattern urlPattern;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerRouterCondition(int version) {
    super(40, version);
  }

  public ServiceWorkerRouterCondition() {
    this(0);
  }

  public static ServiceWorkerRouterCondition deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerRouterCondition deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerRouterCondition decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerRouterCondition result = new ServiceWorkerRouterCondition(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.urlPattern = SafeUrlPattern.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.request = ServiceWorkerRouterRequestCondition.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.runningStatus = ServiceWorkerRouterRunningStatusCondition.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      result.orCondition = ServiceWorkerRouterOrCondition.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.urlPattern, 8, true);
    encoder0.encode((Struct) this.request, 16, true);
    encoder0.encode((Struct) this.runningStatus, 24, true);
    encoder0.encode((Struct) this.orCondition, 32, true);
  }
}
