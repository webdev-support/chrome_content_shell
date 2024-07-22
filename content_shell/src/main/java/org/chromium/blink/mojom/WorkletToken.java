package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class WorkletToken extends Union {

  private AnimationWorkletToken mAnimationWorkletToken;
  private AudioWorkletToken mAudioWorkletToken;
  private LayoutWorkletToken mLayoutWorkletToken;
  private PaintWorkletToken mPaintWorkletToken;
  private SharedStorageWorkletToken mSharedStorageWorkletToken;

  public static final class Tag {
    public static final int AnimationWorkletToken = 0;
    public static final int AudioWorkletToken = 1;
    public static final int LayoutWorkletToken = 2;
    public static final int PaintWorkletToken = 3;
    public static final int SharedStorageWorkletToken = 4;
  }

  public void setAnimationWorkletToken(AnimationWorkletToken animationWorkletToken) {
    this.mTag = 0;
    this.mAnimationWorkletToken = animationWorkletToken;
  }

  public AnimationWorkletToken getAnimationWorkletToken() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mAnimationWorkletToken;
  }

  public void setAudioWorkletToken(AudioWorkletToken audioWorkletToken) {
    this.mTag = 1;
    this.mAudioWorkletToken = audioWorkletToken;
  }

  public AudioWorkletToken getAudioWorkletToken() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mAudioWorkletToken;
  }

  public void setLayoutWorkletToken(LayoutWorkletToken layoutWorkletToken) {
    this.mTag = 2;
    this.mLayoutWorkletToken = layoutWorkletToken;
  }

  public LayoutWorkletToken getLayoutWorkletToken() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mLayoutWorkletToken;
  }

  public void setPaintWorkletToken(PaintWorkletToken paintWorkletToken) {
    this.mTag = 3;
    this.mPaintWorkletToken = paintWorkletToken;
  }

  public PaintWorkletToken getPaintWorkletToken() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mPaintWorkletToken;
  }

  public void setSharedStorageWorkletToken(SharedStorageWorkletToken sharedStorageWorkletToken) {
    this.mTag = 4;
    this.mSharedStorageWorkletToken = sharedStorageWorkletToken;
  }

  public SharedStorageWorkletToken getSharedStorageWorkletToken() {
    if (this.mTag != 4) {
      throw new AssertionError();
    }
    return this.mSharedStorageWorkletToken;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mAnimationWorkletToken, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mAudioWorkletToken, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mLayoutWorkletToken, offset + 8, false);
        return;
      case 3:
        encoder0.encode((Struct) this.mPaintWorkletToken, offset + 8, false);
        return;
      case 4:
        encoder0.encode((Struct) this.mSharedStorageWorkletToken, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static WorkletToken deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final WorkletToken decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    WorkletToken result = new WorkletToken();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mAnimationWorkletToken = AnimationWorkletToken.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mAudioWorkletToken = AudioWorkletToken.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mLayoutWorkletToken = LayoutWorkletToken.decode(decoder13);
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder14 = decoder0.readPointer(offset + 8, false);
        result.mPaintWorkletToken = PaintWorkletToken.decode(decoder14);
        result.mTag = 3;
        break;
      case 4:
        Decoder decoder15 = decoder0.readPointer(offset + 8, false);
        result.mSharedStorageWorkletToken = SharedStorageWorkletToken.decode(decoder15);
        result.mTag = 4;
        break;
    }
    return result;
  }
}
