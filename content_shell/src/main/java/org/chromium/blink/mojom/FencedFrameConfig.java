package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.url.mojom.Url;

public final class FencedFrameConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 152;
  private static final DataHeader[] VERSION_ARRAY;
  public PotentiallyOpaqueAdAuctionData adAuctionData;
  public PotentiallyOpaqueSize containerSize;
  public PotentiallyOpaqueSize contentSize;
  public PotentiallyOpaqueBool deprecatedShouldFreezeInitialSize;
  public int[] effectiveEnabledPermissions;
  public PotentiallyOpaqueUrl mappedUrl;
  public int mode;
  public PotentiallyOpaqueConfigVector nestedConfigs;
  public ParentPermissionsInfo parentPermissionsInfo;
  public PotentiallyOpaqueSharedStorageBudgetMetadata sharedStorageBudgetMetadata;
  public Url urnUuid;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(152, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FencedFrameConfig(int version) {
    super(152, version);
  }

  public FencedFrameConfig() {
    this(0);
  }

  public static FencedFrameConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FencedFrameConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FencedFrameConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FencedFrameConfig result = new FencedFrameConfig(elementsOrVersion);
      result.mappedUrl = PotentiallyOpaqueUrl.decode(decoder0, 8);
      result.containerSize = PotentiallyOpaqueSize.decode(decoder0, 24);
      result.contentSize = PotentiallyOpaqueSize.decode(decoder0, 40);
      result.deprecatedShouldFreezeInitialSize = PotentiallyOpaqueBool.decode(decoder0, 56);
      result.adAuctionData = PotentiallyOpaqueAdAuctionData.decode(decoder0, 72);
      result.nestedConfigs = PotentiallyOpaqueConfigVector.decode(decoder0, 88);
      result.sharedStorageBudgetMetadata =
          PotentiallyOpaqueSharedStorageBudgetMetadata.decode(decoder0, 104);
      Decoder decoder1 = decoder0.readPointer(120, false);
      result.urnUuid = Url.decode(decoder1);
      int readInt = decoder0.readInt(128);
      result.mode = readInt;
      DeprecatedFencedFrameMode.validate(readInt);
      result.mode = DeprecatedFencedFrameMode.toKnownValue(result.mode);
      result.effectiveEnabledPermissions = decoder0.readInts(136, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.effectiveEnabledPermissions;
        if (i1 < iArr.length) {
          PermissionsPolicyFeature.validate(iArr[i1]);
          i1++;
        } else {
          Decoder decoder12 = decoder0.readPointer(144, true);
          result.parentPermissionsInfo = ParentPermissionsInfo.decode(decoder12);
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.mappedUrl, 8, true);
    encoder0.encode((Union) this.containerSize, 24, true);
    encoder0.encode((Union) this.contentSize, 40, true);
    encoder0.encode((Union) this.deprecatedShouldFreezeInitialSize, 56, true);
    encoder0.encode((Union) this.adAuctionData, 72, true);
    encoder0.encode((Union) this.nestedConfigs, 88, true);
    encoder0.encode((Union) this.sharedStorageBudgetMetadata, 104, true);
    encoder0.encode((Struct) this.urnUuid, 120, false);
    encoder0.encode(this.mode, 128);
    encoder0.encode(this.effectiveEnabledPermissions, 136, 0, -1);
    encoder0.encode((Struct) this.parentPermissionsInfo, 144, true);
  }
}
