package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class ServiceWorkerRouterSource extends Union {

  private ServiceWorkerRouterCacheSource mCacheSource;
  private ServiceWorkerRouterFetchEventSource mFetchEventSource;
  private ServiceWorkerRouterNetworkSource mNetworkSource;
  private ServiceWorkerRouterRaceSource mRaceSource;

  public static final class Tag {
    public static final int CacheSource = 3;
    public static final int FetchEventSource = 2;
    public static final int NetworkSource = 0;
    public static final int RaceSource = 1;
  }

  public void setNetworkSource(ServiceWorkerRouterNetworkSource networkSource) {
    this.mTag = 0;
    this.mNetworkSource = networkSource;
  }

  public ServiceWorkerRouterNetworkSource getNetworkSource() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mNetworkSource;
  }

  public void setRaceSource(ServiceWorkerRouterRaceSource raceSource) {
    this.mTag = 1;
    this.mRaceSource = raceSource;
  }

  public ServiceWorkerRouterRaceSource getRaceSource() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mRaceSource;
  }

  public void setFetchEventSource(ServiceWorkerRouterFetchEventSource fetchEventSource) {
    this.mTag = 2;
    this.mFetchEventSource = fetchEventSource;
  }

  public ServiceWorkerRouterFetchEventSource getFetchEventSource() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mFetchEventSource;
  }

  public void setCacheSource(ServiceWorkerRouterCacheSource cacheSource) {
    this.mTag = 3;
    this.mCacheSource = cacheSource;
  }

  public ServiceWorkerRouterCacheSource getCacheSource() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mCacheSource;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mNetworkSource, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mRaceSource, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mFetchEventSource, offset + 8, false);
        return;
      case 3:
        encoder0.encode((Struct) this.mCacheSource, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static ServiceWorkerRouterSource deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final ServiceWorkerRouterSource decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    ServiceWorkerRouterSource result = new ServiceWorkerRouterSource();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mNetworkSource = ServiceWorkerRouterNetworkSource.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mRaceSource = ServiceWorkerRouterRaceSource.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mFetchEventSource = ServiceWorkerRouterFetchEventSource.decode(decoder13);
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder14 = decoder0.readPointer(offset + 8, false);
        result.mCacheSource = ServiceWorkerRouterCacheSource.decode(decoder14);
        result.mTag = 3;
        break;
    }
    return result;
  }
}
