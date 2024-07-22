package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

public final class PushSubscription extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] auth;
  public Url endpoint;
  public Time expirationTime;
  public PushSubscriptionOptions options;
  public byte[] p256dh;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PushSubscription(int version) {
    super(48, version);
  }

  public PushSubscription() {
    this(0);
  }

  public static PushSubscription deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PushSubscription deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PushSubscription decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PushSubscription result = new PushSubscription(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.endpoint = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.expirationTime = Time.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.options = PushSubscriptionOptions.decode(decoder13);
      result.p256dh = decoder0.readBytes(32, 0, -1);
      result.auth = decoder0.readBytes(40, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.endpoint, 8, false);
    encoder0.encode((Struct) this.expirationTime, 16, true);
    encoder0.encode((Struct) this.options, 24, false);
    encoder0.encode(this.p256dh, 32, 0, -1);
    encoder0.encode(this.auth, 40, 0, -1);
  }
}
