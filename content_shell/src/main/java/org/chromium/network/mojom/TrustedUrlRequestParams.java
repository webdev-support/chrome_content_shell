package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TrustedUrlRequestParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public AcceptChFrameObserver acceptChFrameObserver;
  public boolean allowCookiesFromBrowser;
  public ClientSecurityState clientSecurityState;
  public CookieAccessObserver cookieObserver;
  public DevToolsObserver devtoolsObserver;
  public boolean disableSecureDns;
  public boolean hasUserActivation;
  public IsolationInfo isolationInfo;
  public SharedDictionaryAccessObserver sharedDictionaryObserver;
  public TrustTokenAccessObserver trustTokenObserver;
  public UrlLoaderNetworkServiceObserver urlLoaderNetworkObserver;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TrustedUrlRequestParams(int version) {
    super(80, version);
  }

  public TrustedUrlRequestParams() {
    this(0);
  }

  public static TrustedUrlRequestParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TrustedUrlRequestParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TrustedUrlRequestParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TrustedUrlRequestParams result = new TrustedUrlRequestParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.isolationInfo = IsolationInfo.decode(decoder1);
      result.disableSecureDns = decoder0.readBoolean(16, 0);
      result.hasUserActivation = decoder0.readBoolean(16, 1);
      result.allowCookiesFromBrowser = decoder0.readBoolean(16, 2);
      result.cookieObserver =
          (CookieAccessObserver)
              decoder0.readServiceInterface(20, true, CookieAccessObserver.MANAGER);
      result.trustTokenObserver =
          (TrustTokenAccessObserver)
              decoder0.readServiceInterface(28, true, TrustTokenAccessObserver.MANAGER);
      result.urlLoaderNetworkObserver =
          (UrlLoaderNetworkServiceObserver)
              decoder0.readServiceInterface(36, true, UrlLoaderNetworkServiceObserver.MANAGER);
      result.devtoolsObserver =
          (DevToolsObserver) decoder0.readServiceInterface(44, true, DevToolsObserver.MANAGER);
      Decoder decoder12 = decoder0.readPointer(56, true);
      result.clientSecurityState = ClientSecurityState.decode(decoder12);
      result.acceptChFrameObserver =
          (AcceptChFrameObserver)
              decoder0.readServiceInterface(64, true, AcceptChFrameObserver.MANAGER);
      result.sharedDictionaryObserver =
          (SharedDictionaryAccessObserver)
              decoder0.readServiceInterface(72, true, SharedDictionaryAccessObserver.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.isolationInfo, 8, false);
    encoder0.encode(this.disableSecureDns, 16, 0);
    encoder0.encode(this.hasUserActivation, 16, 1);
    encoder0.encode(this.allowCookiesFromBrowser, 16, 2);
    encoder0.encode(this.cookieObserver, 20, true, CookieAccessObserver.MANAGER);
    encoder0.encode(this.trustTokenObserver, 28, true, TrustTokenAccessObserver.MANAGER);
    encoder0.encode(
        this.urlLoaderNetworkObserver, 36, true, UrlLoaderNetworkServiceObserver.MANAGER);
    encoder0.encode(this.devtoolsObserver, 44, true, DevToolsObserver.MANAGER);
    encoder0.encode((Struct) this.clientSecurityState, 56, true);
    encoder0.encode(this.acceptChFrameObserver, 64, true, AcceptChFrameObserver.MANAGER);
    encoder0.encode(
        this.sharedDictionaryObserver, 72, true, SharedDictionaryAccessObserver.MANAGER);
  }
}
