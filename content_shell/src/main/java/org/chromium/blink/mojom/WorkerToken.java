package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class WorkerToken extends Union {

  private DedicatedWorkerToken mDedicatedWorkerToken;
  private ServiceWorkerToken mServiceWorkerToken;
  private SharedWorkerToken mSharedWorkerToken;

  public static final class Tag {
    public static final int DedicatedWorkerToken = 0;
    public static final int ServiceWorkerToken = 1;
    public static final int SharedWorkerToken = 2;
  }

  public void setDedicatedWorkerToken(DedicatedWorkerToken dedicatedWorkerToken) {
    this.mTag = 0;
    this.mDedicatedWorkerToken = dedicatedWorkerToken;
  }

  public DedicatedWorkerToken getDedicatedWorkerToken() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mDedicatedWorkerToken;
  }

  public void setServiceWorkerToken(ServiceWorkerToken serviceWorkerToken) {
    this.mTag = 1;
    this.mServiceWorkerToken = serviceWorkerToken;
  }

  public ServiceWorkerToken getServiceWorkerToken() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mServiceWorkerToken;
  }

  public void setSharedWorkerToken(SharedWorkerToken sharedWorkerToken) {
    this.mTag = 2;
    this.mSharedWorkerToken = sharedWorkerToken;
  }

  public SharedWorkerToken getSharedWorkerToken() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mSharedWorkerToken;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mDedicatedWorkerToken, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mServiceWorkerToken, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mSharedWorkerToken, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static WorkerToken deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final WorkerToken decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    WorkerToken result = new WorkerToken();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mDedicatedWorkerToken = DedicatedWorkerToken.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mServiceWorkerToken = ServiceWorkerToken.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mSharedWorkerToken = SharedWorkerToken.decode(decoder13);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
