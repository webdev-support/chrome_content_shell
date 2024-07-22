package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.HdrMetadata;
import org.chromium.gfx.mojom.Size;
import org.chromium.gpu.mojom.MailboxHolder;
import org.chromium.gpu.mojom.VulkanYCbCrInfo;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class TransferableResource extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public ColorSpace colorSpace;
  public SharedImageFormat format;
  public HdrMetadata hdrMetadata;

  public ResourceId f788id;
  public boolean isBackedBySurfaceTexture;
  public boolean isOverlayCandidate;
  public boolean isSoftware;
  public MailboxHolder mailboxHolder;
  public boolean needsDetiling;
  public Size size;
  public int synchronizationType;
  public boolean wantsPromotionHint;
  public VulkanYCbCrInfo ycbcrInfo;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TransferableResource(int version) {
    super(80, version);
  }

  public TransferableResource() {
    this(0);
  }

  public static TransferableResource deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TransferableResource deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TransferableResource decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TransferableResource result = new TransferableResource(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.f788id = ResourceId.decode(decoder1);
      result.format = SharedImageFormat.decode(decoder0, 16);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.size = Size.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(40, false);
      result.mailboxHolder = MailboxHolder.decode(decoder13);
      int readInt = decoder0.readInt(48);
      result.synchronizationType = readInt;
      SynchronizationType.validate(readInt);
      result.synchronizationType = SynchronizationType.toKnownValue(result.synchronizationType);
      result.isSoftware = decoder0.readBoolean(52, 0);
      result.isOverlayCandidate = decoder0.readBoolean(52, 1);
      result.isBackedBySurfaceTexture = decoder0.readBoolean(52, 2);
      result.wantsPromotionHint = decoder0.readBoolean(52, 3);
      result.needsDetiling = decoder0.readBoolean(52, 4);
      Decoder decoder14 = decoder0.readPointer(56, false);
      result.colorSpace = ColorSpace.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(64, false);
      result.hdrMetadata = HdrMetadata.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(72, true);
      result.ycbcrInfo = VulkanYCbCrInfo.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.f788id, 8, false);
    encoder0.encode((Union) this.format, 16, false);
    encoder0.encode((Struct) this.size, 32, false);
    encoder0.encode((Struct) this.mailboxHolder, 40, false);
    encoder0.encode(this.synchronizationType, 48);
    encoder0.encode(this.isSoftware, 52, 0);
    encoder0.encode(this.isOverlayCandidate, 52, 1);
    encoder0.encode(this.isBackedBySurfaceTexture, 52, 2);
    encoder0.encode(this.wantsPromotionHint, 52, 3);
    encoder0.encode(this.needsDetiling, 52, 4);
    encoder0.encode((Struct) this.colorSpace, 56, false);
    encoder0.encode((Struct) this.hdrMetadata, 64, false);
    encoder0.encode((Struct) this.ycbcrInfo, 72, true);
  }
}
