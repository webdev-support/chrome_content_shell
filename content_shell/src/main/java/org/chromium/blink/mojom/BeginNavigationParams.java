package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.network.mojom.TrustTokenParams;
import org.chromium.url.mojom.Url;

public final class BeginNavigationParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 112;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeTicks beforeUnloadEnd;
  public TimeTicks beforeUnloadStart;
  public Url clientSideRedirectUrl;
  public DictionaryValue devtoolsInitiator;
  public int forceHistoryPush;
  public boolean hasStorageAccess;
  public String headers;
  public Impression impression;
  public int initiatorActivationAndAdStatus;
  public LocalFrameToken initiatorFrameToken;
  public boolean isContainerInitiated;
  public boolean isFormSubmission;
  public boolean isFullscreenRequested;
  public int loadFlags;
  public int mixedContentContextType;
  public int requestContextType;
  public String searchableFormEncoding;
  public Url searchableFormUrl;
  public boolean skipServiceWorker;
  public TrustTokenParams trustTokenParams;
  public boolean wasInitiatedByLinkClick;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(112, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BeginNavigationParams(int version) {
    super(112, version);
    this.loadFlags = 0;
    this.skipServiceWorker = false;
    this.requestContextType = 0;
    this.mixedContentContextType = 0;
    this.isFormSubmission = false;
    this.wasInitiatedByLinkClick = false;
    this.forceHistoryPush = 1;
    this.isContainerInitiated = false;
    this.isFullscreenRequested = false;
    this.hasStorageAccess = false;
  }

  public BeginNavigationParams() {
    this(0);
  }

  public static BeginNavigationParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BeginNavigationParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BeginNavigationParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BeginNavigationParams result = new BeginNavigationParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.initiatorFrameToken = LocalFrameToken.decode(decoder1);
      result.headers = decoder0.readString(16, false);
      result.loadFlags = decoder0.readInt(24);
      result.skipServiceWorker = decoder0.readBoolean(28, 0);
      result.isFormSubmission = decoder0.readBoolean(28, 1);
      result.wasInitiatedByLinkClick = decoder0.readBoolean(28, 2);
      result.isContainerInitiated = decoder0.readBoolean(28, 3);
      result.isFullscreenRequested = decoder0.readBoolean(28, 4);
      result.hasStorageAccess = decoder0.readBoolean(28, 5);
      int readInt = decoder0.readInt(32);
      result.requestContextType = readInt;
      RequestContextType.validate(readInt);
      result.requestContextType = RequestContextType.toKnownValue(result.requestContextType);
      int readInt2 = decoder0.readInt(36);
      result.mixedContentContextType = readInt2;
      MixedContentContextType.validate(readInt2);
      result.mixedContentContextType =
          MixedContentContextType.toKnownValue(result.mixedContentContextType);
      int readInt3 = decoder0.readInt(40);
      result.forceHistoryPush = readInt3;
      ForceHistoryPush.validate(readInt3);
      result.forceHistoryPush = ForceHistoryPush.toKnownValue(result.forceHistoryPush);
      int readInt4 = decoder0.readInt(44);
      result.initiatorActivationAndAdStatus = readInt4;
      NavigationInitiatorActivationAndAdStatus.validate(readInt4);
      result.initiatorActivationAndAdStatus =
          NavigationInitiatorActivationAndAdStatus.toKnownValue(
              result.initiatorActivationAndAdStatus);
      Decoder decoder12 = decoder0.readPointer(48, false);
      result.searchableFormUrl = Url.decode(decoder12);
      result.searchableFormEncoding = decoder0.readString(56, false);
      Decoder decoder13 = decoder0.readPointer(64, false);
      result.clientSideRedirectUrl = Url.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(72, true);
      result.devtoolsInitiator = DictionaryValue.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(80, true);
      result.trustTokenParams = TrustTokenParams.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(88, true);
      result.impression = Impression.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(96, false);
      result.beforeUnloadStart = TimeTicks.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(104, false);
      result.beforeUnloadEnd = TimeTicks.decode(decoder18);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.initiatorFrameToken, 8, true);
    encoder0.encode(this.headers, 16, false);
    encoder0.encode(this.loadFlags, 24);
    encoder0.encode(this.skipServiceWorker, 28, 0);
    encoder0.encode(this.isFormSubmission, 28, 1);
    encoder0.encode(this.wasInitiatedByLinkClick, 28, 2);
    encoder0.encode(this.isContainerInitiated, 28, 3);
    encoder0.encode(this.isFullscreenRequested, 28, 4);
    encoder0.encode(this.hasStorageAccess, 28, 5);
    encoder0.encode(this.requestContextType, 32);
    encoder0.encode(this.mixedContentContextType, 36);
    encoder0.encode(this.forceHistoryPush, 40);
    encoder0.encode(this.initiatorActivationAndAdStatus, 44);
    encoder0.encode((Struct) this.searchableFormUrl, 48, false);
    encoder0.encode(this.searchableFormEncoding, 56, false);
    encoder0.encode((Struct) this.clientSideRedirectUrl, 64, false);
    encoder0.encode((Struct) this.devtoolsInitiator, 72, true);
    encoder0.encode((Struct) this.trustTokenParams, 80, true);
    encoder0.encode((Struct) this.impression, 88, true);
    encoder0.encode((Struct) this.beforeUnloadStart, 96, false);
    encoder0.encode((Struct) this.beforeUnloadEnd, 104, false);
  }
}
