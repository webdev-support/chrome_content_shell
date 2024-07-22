package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.network.mojom.RedirectMode;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class DownloadUrlParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public BlobUrlToken blobUrlToken;
  public int crossOriginRedirects;
  public Blob dataUrlBlob;
  public boolean hasUserGesture;
  public Origin initiatorOrigin;
  public boolean isContextMenuSave;
  public Referrer referrer;
  public String16 suggestedName;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DownloadUrlParams(int version) {
    super(64, version);
    this.isContextMenuSave = false;
    this.hasUserGesture = false;
  }

  public DownloadUrlParams() {
    this(0);
  }

  public static DownloadUrlParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DownloadUrlParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DownloadUrlParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DownloadUrlParams result = new DownloadUrlParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.referrer = Referrer.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.initiatorOrigin = Origin.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      result.suggestedName = String16.decode(decoder14);
      int readInt = decoder0.readInt(40);
      result.crossOriginRedirects = readInt;
      RedirectMode.validate(readInt);
      result.crossOriginRedirects = RedirectMode.toKnownValue(result.crossOriginRedirects);
      result.blobUrlToken =
          (BlobUrlToken) decoder0.readServiceInterface(44, true, BlobUrlToken.MANAGER);
      result.dataUrlBlob = (Blob) decoder0.readServiceInterface(52, true, Blob.MANAGER);
      result.isContextMenuSave = decoder0.readBoolean(60, 0);
      result.hasUserGesture = decoder0.readBoolean(60, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode((Struct) this.referrer, 16, true);
    encoder0.encode((Struct) this.initiatorOrigin, 24, true);
    encoder0.encode((Struct) this.suggestedName, 32, true);
    encoder0.encode(this.crossOriginRedirects, 40);
    encoder0.encode(this.blobUrlToken, 44, true, BlobUrlToken.MANAGER);
    encoder0.encode(this.dataUrlBlob, 52, true, Blob.MANAGER);
    encoder0.encode(this.isContextMenuSave, 60, 0);
    encoder0.encode(this.hasUserGesture, 60, 1);
  }
}
