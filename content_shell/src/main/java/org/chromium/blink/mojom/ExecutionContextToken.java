package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class ExecutionContextToken extends Union {

  private AnimationWorkletToken mAnimationWorkletToken;
  private AudioWorkletToken mAudioWorkletToken;
  private DedicatedWorkerToken mDedicatedWorkerToken;
  private LayoutWorkletToken mLayoutWorkletToken;
  private LocalFrameToken mLocalFrameToken;
  private PaintWorkletToken mPaintWorkletToken;
  private ServiceWorkerToken mServiceWorkerToken;
  private ShadowRealmToken mShadowRealmToken;
  private SharedStorageWorkletToken mSharedStorageWorkletToken;
  private SharedWorkerToken mSharedWorkerToken;

  public static final class Tag {
    public static final int AnimationWorkletToken = 4;
    public static final int AudioWorkletToken = 5;
    public static final int DedicatedWorkerToken = 1;
    public static final int LayoutWorkletToken = 6;
    public static final int LocalFrameToken = 0;
    public static final int PaintWorkletToken = 7;
    public static final int ServiceWorkerToken = 2;
    public static final int ShadowRealmToken = 9;
    public static final int SharedStorageWorkletToken = 8;
    public static final int SharedWorkerToken = 3;
  }

  public void setLocalFrameToken(LocalFrameToken localFrameToken) {
    this.mTag = 0;
    this.mLocalFrameToken = localFrameToken;
  }

  public LocalFrameToken getLocalFrameToken() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mLocalFrameToken;
  }

  public void setDedicatedWorkerToken(DedicatedWorkerToken dedicatedWorkerToken) {
    this.mTag = 1;
    this.mDedicatedWorkerToken = dedicatedWorkerToken;
  }

  public DedicatedWorkerToken getDedicatedWorkerToken() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mDedicatedWorkerToken;
  }

  public void setServiceWorkerToken(ServiceWorkerToken serviceWorkerToken) {
    this.mTag = 2;
    this.mServiceWorkerToken = serviceWorkerToken;
  }

  public ServiceWorkerToken getServiceWorkerToken() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mServiceWorkerToken;
  }

  public void setSharedWorkerToken(SharedWorkerToken sharedWorkerToken) {
    this.mTag = 3;
    this.mSharedWorkerToken = sharedWorkerToken;
  }

  public SharedWorkerToken getSharedWorkerToken() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mSharedWorkerToken;
  }

  public void setAnimationWorkletToken(AnimationWorkletToken animationWorkletToken) {
    this.mTag = 4;
    this.mAnimationWorkletToken = animationWorkletToken;
  }

  public AnimationWorkletToken getAnimationWorkletToken() {
    if (this.mTag != 4) {
      throw new AssertionError();
    }
    return this.mAnimationWorkletToken;
  }

  public void setAudioWorkletToken(AudioWorkletToken audioWorkletToken) {
    this.mTag = 5;
    this.mAudioWorkletToken = audioWorkletToken;
  }

  public AudioWorkletToken getAudioWorkletToken() {
    if (this.mTag != 5) {
      throw new AssertionError();
    }
    return this.mAudioWorkletToken;
  }

  public void setLayoutWorkletToken(LayoutWorkletToken layoutWorkletToken) {
    this.mTag = 6;
    this.mLayoutWorkletToken = layoutWorkletToken;
  }

  public LayoutWorkletToken getLayoutWorkletToken() {
    if (this.mTag != 6) {
      throw new AssertionError();
    }
    return this.mLayoutWorkletToken;
  }

  public void setPaintWorkletToken(PaintWorkletToken paintWorkletToken) {
    this.mTag = 7;
    this.mPaintWorkletToken = paintWorkletToken;
  }

  public PaintWorkletToken getPaintWorkletToken() {
    if (this.mTag != 7) {
      throw new AssertionError();
    }
    return this.mPaintWorkletToken;
  }

  public void setSharedStorageWorkletToken(SharedStorageWorkletToken sharedStorageWorkletToken) {
    this.mTag = 8;
    this.mSharedStorageWorkletToken = sharedStorageWorkletToken;
  }

  public SharedStorageWorkletToken getSharedStorageWorkletToken() {
    if (this.mTag != 8) {
      throw new AssertionError();
    }
    return this.mSharedStorageWorkletToken;
  }

  public void setShadowRealmToken(ShadowRealmToken shadowRealmToken) {
    this.mTag = 9;
    this.mShadowRealmToken = shadowRealmToken;
  }

  public ShadowRealmToken getShadowRealmToken() {
    if (this.mTag != 9) {
      throw new AssertionError();
    }
    return this.mShadowRealmToken;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mLocalFrameToken, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mDedicatedWorkerToken, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mServiceWorkerToken, offset + 8, false);
        return;
      case 3:
        encoder0.encode((Struct) this.mSharedWorkerToken, offset + 8, false);
        return;
      case 4:
        encoder0.encode((Struct) this.mAnimationWorkletToken, offset + 8, false);
        return;
      case 5:
        encoder0.encode((Struct) this.mAudioWorkletToken, offset + 8, false);
        return;
      case 6:
        encoder0.encode((Struct) this.mLayoutWorkletToken, offset + 8, false);
        return;
      case 7:
        encoder0.encode((Struct) this.mPaintWorkletToken, offset + 8, false);
        return;
      case 8:
        encoder0.encode((Struct) this.mSharedStorageWorkletToken, offset + 8, false);
        return;
      case 9:
        encoder0.encode((Struct) this.mShadowRealmToken, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static ExecutionContextToken deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final ExecutionContextToken decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    ExecutionContextToken result = new ExecutionContextToken();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mLocalFrameToken = LocalFrameToken.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mDedicatedWorkerToken = DedicatedWorkerToken.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mServiceWorkerToken = ServiceWorkerToken.decode(decoder13);
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder14 = decoder0.readPointer(offset + 8, false);
        result.mSharedWorkerToken = SharedWorkerToken.decode(decoder14);
        result.mTag = 3;
        break;
      case 4:
        Decoder decoder15 = decoder0.readPointer(offset + 8, false);
        result.mAnimationWorkletToken = AnimationWorkletToken.decode(decoder15);
        result.mTag = 4;
        break;
      case 5:
        Decoder decoder16 = decoder0.readPointer(offset + 8, false);
        result.mAudioWorkletToken = AudioWorkletToken.decode(decoder16);
        result.mTag = 5;
        break;
      case 6:
        Decoder decoder17 = decoder0.readPointer(offset + 8, false);
        result.mLayoutWorkletToken = LayoutWorkletToken.decode(decoder17);
        result.mTag = 6;
        break;
      case 7:
        Decoder decoder18 = decoder0.readPointer(offset + 8, false);
        result.mPaintWorkletToken = PaintWorkletToken.decode(decoder18);
        result.mTag = 7;
        break;
      case 8:
        Decoder decoder19 = decoder0.readPointer(offset + 8, false);
        result.mSharedStorageWorkletToken = SharedStorageWorkletToken.decode(decoder19);
        result.mTag = 8;
        break;
      case 9:
        Decoder decoder110 = decoder0.readPointer(offset + 8, false);
        result.mShadowRealmToken = ShadowRealmToken.decode(decoder110);
        result.mTag = 9;
        break;
    }
    return result;
  }
}
