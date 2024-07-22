package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class ServiceWorkerRegistrationOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Url scope;
  public int type;
  public int updateViaCache;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerRegistrationOptions(int version) {
    super(24, version);
    this.type = 0;
    this.updateViaCache = 0;
  }

  public ServiceWorkerRegistrationOptions() {
    this(0);
  }

  public static ServiceWorkerRegistrationOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerRegistrationOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerRegistrationOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerRegistrationOptions result =
          new ServiceWorkerRegistrationOptions(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.scope = Url.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.type = readInt;
      ScriptType.validate(readInt);
      result.type = ScriptType.toKnownValue(result.type);
      int readInt2 = decoder0.readInt(20);
      result.updateViaCache = readInt2;
      ServiceWorkerUpdateViaCache.validate(readInt2);
      result.updateViaCache = ServiceWorkerUpdateViaCache.toKnownValue(result.updateViaCache);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.scope, 8, false);
    encoder0.encode(this.type, 16);
    encoder0.encode(this.updateViaCache, 20);
  }
}
