package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class FencedFrameProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 144;
  private static final DataHeader[] VERSION_ARRAY;
  public PotentiallyOpaqueAdAuctionData adAuctionData;
  public boolean canDisableUntrustedNetwork;
  public PotentiallyOpaqueSize containerSize;
  public PotentiallyOpaqueSize contentSize;
  public PotentiallyOpaqueBool deprecatedShouldFreezeInitialSize;
  public int[] effectiveEnabledPermissions;
  public boolean hasFencedFrameReporting;
  public PotentiallyOpaqueUrl mappedUrl;
  public int mode;
  public PotentiallyOpaqueUrnConfigVector nestedUrnConfigPairs;
  public ParentPermissionsInfo parentPermissionsInfo;
  public PotentiallyOpaqueSharedStorageBudgetMetadata sharedStorageBudgetMetadata;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(144, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FencedFrameProperties(int version) {
    super(144, version);
  }

  public FencedFrameProperties() {
    this(0);
  }

  public static FencedFrameProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FencedFrameProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FencedFrameProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FencedFrameProperties result = new FencedFrameProperties(elementsOrVersion);
      result.mappedUrl = PotentiallyOpaqueUrl.decode(decoder0, 8);
      result.containerSize = PotentiallyOpaqueSize.decode(decoder0, 24);
      result.contentSize = PotentiallyOpaqueSize.decode(decoder0, 40);
      result.deprecatedShouldFreezeInitialSize = PotentiallyOpaqueBool.decode(decoder0, 56);
      result.adAuctionData = PotentiallyOpaqueAdAuctionData.decode(decoder0, 72);
      result.nestedUrnConfigPairs = PotentiallyOpaqueUrnConfigVector.decode(decoder0, 88);
      result.sharedStorageBudgetMetadata =
          PotentiallyOpaqueSharedStorageBudgetMetadata.decode(decoder0, 104);
      result.hasFencedFrameReporting = decoder0.readBoolean(120, 0);
      result.canDisableUntrustedNetwork = decoder0.readBoolean(120, 1);
      int readInt = decoder0.readInt(124);
      result.mode = readInt;
      DeprecatedFencedFrameMode.validate(readInt);
      result.mode = DeprecatedFencedFrameMode.toKnownValue(result.mode);
      result.effectiveEnabledPermissions = decoder0.readInts(128, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.effectiveEnabledPermissions;
        if (i1 >= iArr.length) {
          Decoder decoder1 = decoder0.readPointer(136, true);
          result.parentPermissionsInfo = ParentPermissionsInfo.decode(decoder1);
          return result;
        }
        PermissionsPolicyFeature.validate(iArr[i1]);
        i1++;
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
    encoder0.encode((Union) this.nestedUrnConfigPairs, 88, true);
    encoder0.encode((Union) this.sharedStorageBudgetMetadata, 104, true);
    encoder0.encode(this.hasFencedFrameReporting, 120, 0);
    encoder0.encode(this.canDisableUntrustedNetwork, 120, 1);
    encoder0.encode(this.mode, 124);
    encoder0.encode(this.effectiveEnabledPermissions, 128, 0, -1);
    encoder0.encode((Struct) this.parentPermissionsInfo, 136, true);
  }
}
