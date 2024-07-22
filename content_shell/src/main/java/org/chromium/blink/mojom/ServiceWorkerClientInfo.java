package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.url.mojom.Url;

public final class ServiceWorkerClientInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public int clientType;
  public String clientUuid;
  public TimeTicks creationTime;
  public int frameType;
  public boolean isFocused;
  public TimeTicks lastFocusTime;
  public int lifecycleState;
  public boolean pageHidden;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerClientInfo(int version) {
    super(56, version);
    this.frameType = 2;
    this.pageHidden = true;
    this.isFocused = false;
    this.lifecycleState = 0;
  }

  public ServiceWorkerClientInfo() {
    this(0);
  }

  public static ServiceWorkerClientInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerClientInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerClientInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerClientInfo result = new ServiceWorkerClientInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.frameType = readInt;
      RequestContextFrameType.validate(readInt);
      result.frameType = RequestContextFrameType.toKnownValue(result.frameType);
      int readInt2 = decoder0.readInt(20);
      result.clientType = readInt2;
      ServiceWorkerClientType.validate(readInt2);
      result.clientType = ServiceWorkerClientType.toKnownValue(result.clientType);
      result.clientUuid = decoder0.readString(24, false);
      result.pageHidden = decoder0.readBoolean(32, 0);
      result.isFocused = decoder0.readBoolean(32, 1);
      int readInt3 = decoder0.readInt(36);
      result.lifecycleState = readInt3;
      ServiceWorkerClientLifecycleState.validate(readInt3);
      result.lifecycleState = ServiceWorkerClientLifecycleState.toKnownValue(result.lifecycleState);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.lastFocusTime = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(48, false);
      result.creationTime = TimeTicks.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode(this.frameType, 16);
    encoder0.encode(this.clientType, 20);
    encoder0.encode(this.clientUuid, 24, false);
    encoder0.encode(this.pageHidden, 32, 0);
    encoder0.encode(this.isFocused, 32, 1);
    encoder0.encode(this.lifecycleState, 36);
    encoder0.encode((Struct) this.lastFocusTime, 40, false);
    encoder0.encode((Struct) this.creationTime, 48, false);
  }
}
