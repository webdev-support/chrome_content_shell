package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.components.content_settings.ContentSettingsType;
import org.chromium.content_settings.mojom.ContentSettingPatternSource;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

class CookieManager_Internal {

  private static final int ADD_COOKIE_CHANGE_LISTENER_ORDINAL = 7;
  private static final int ADD_GLOBAL_CHANGE_LISTENER_ORDINAL = 8;
  private static final int ALLOW_FILE_SCHEME_COOKIES_ORDINAL = 11;
  private static final int BLOCK_THIRD_PARTY_COOKIES_ORDINAL = 14;
  private static final int BLOCK_TRUNCATED_COOKIES_ORDINAL = 15;
  private static final int CLONE_INTERFACE_ORDINAL = 9;
  private static final int DELETE_CANONICAL_COOKIE_ORDINAL = 4;
  private static final int DELETE_COOKIES_ORDINAL = 5;
  private static final int DELETE_SESSION_ONLY_COOKIES_ORDINAL = 6;
  private static final int FLUSH_COOKIE_STORE_ORDINAL = 10;
  private static final int GET_ALL_COOKIES_ORDINAL = 0;
  private static final int GET_ALL_COOKIES_WITH_ACCESS_SEMANTICS_ORDINAL = 1;
  private static final int GET_COOKIE_LIST_ORDINAL = 2;
  public static final Interface.Manager<CookieManager, CookieManager.Proxy> MANAGER =
      new Interface.Manager<CookieManager, CookieManager.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.CookieManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CookieManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CookieManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public CookieManager[] buildArray(int size) {
          return new CookieManager[size];
        }
      };
  private static final int SET_CANONICAL_COOKIE_ORDINAL = 3;
  private static final int SET_CONTENT_SETTINGS_ORDINAL = 12;
  private static final int SET_FORCE_KEEP_SESSION_STATE_ORDINAL = 13;
  private static final int SET_MITIGATIONS_ENABLED_FOR3PCD_ORDINAL = 16;
  private static final int SET_PRE_COMMIT_CALLBACK_DELAY_FOR_TESTING_ORDINAL = 18;
  private static final int SET_TRACKING_PROTECTION_ENABLED_FOR3PCD_ORDINAL = 17;

  CookieManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements CookieManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getAllCookies(CookieManager.GetAllCookies_Response callback) {
      CookieManagerGetAllCookiesParams _message = new CookieManagerGetAllCookiesParams();
      ServiceMessage serviceMessage =
          _message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L));
      CookieManagerGetAllCookiesResponseParamsForwardToCallback
          cookieManagerGetAllCookiesResponseParamsForwardToCallback =
              new CookieManagerGetAllCookiesResponseParamsForwardToCallback(callback);
      HandlerImpl proxyHandler = getProxyHandler();
      MessageReceiverWithResponder messageReceiver = proxyHandler.getMessageReceiver();
      messageReceiver.acceptWithResponder(
          serviceMessage, cookieManagerGetAllCookiesResponseParamsForwardToCallback);
    }

    @Override
    public void getAllCookiesWithAccessSemantics(
        CookieManager.GetAllCookiesWithAccessSemantics_Response callback) {
      CookieManagerGetAllCookiesWithAccessSemanticsParams _message =
          new CookieManagerGetAllCookiesWithAccessSemanticsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new CookieManagerGetAllCookiesWithAccessSemanticsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getCookieList(
        Url url,
        CookieOptions cookieOptions,
        CookiePartitionKeyCollection cookiePartitionKeyCollection,
        CookieManager.GetCookieList_Response callback) {
      CookieManagerGetCookieListParams _message = new CookieManagerGetCookieListParams();
      _message.url = url;
      _message.cookieOptions = cookieOptions;
      _message.cookiePartitionKeyCollection = cookiePartitionKeyCollection;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new CookieManagerGetCookieListResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setCanonicalCookie(
        CanonicalCookie cookie,
        Url sourceUrl,
        CookieOptions cookieOptions,
        CookieManager.SetCanonicalCookie_Response callback) {
      CookieManagerSetCanonicalCookieParams _message = new CookieManagerSetCanonicalCookieParams();
      _message.cookie = cookie;
      _message.sourceUrl = sourceUrl;
      _message.cookieOptions = cookieOptions;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new CookieManagerSetCanonicalCookieResponseParamsForwardToCallback(callback));
    }

    @Override
    public void deleteCanonicalCookie(
        CanonicalCookie cookie, CookieManager.DeleteCanonicalCookie_Response callback) {
      CookieManagerDeleteCanonicalCookieParams _message =
          new CookieManagerDeleteCanonicalCookieParams();
      _message.cookie = cookie;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new CookieManagerDeleteCanonicalCookieResponseParamsForwardToCallback(callback));
    }

    @Override
    public void deleteCookies(
        CookieDeletionFilter filter, CookieManager.DeleteCookies_Response callback) {
      CookieManagerDeleteCookiesParams _message = new CookieManagerDeleteCookiesParams();
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new CookieManagerDeleteCookiesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void deleteSessionOnlyCookies(CookieManager.DeleteSessionOnlyCookies_Response callback) {
      CookieManagerDeleteSessionOnlyCookiesParams _message =
          new CookieManagerDeleteSessionOnlyCookiesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new CookieManagerDeleteSessionOnlyCookiesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void addCookieChangeListener(Url url, String name, CookieChangeListener listener) {
      CookieManagerAddCookieChangeListenerParams _message =
          new CookieManagerAddCookieChangeListenerParams();
      _message.url = url;
      _message.name = name;
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void addGlobalChangeListener(CookieChangeListener notificationPointer) {
      CookieManagerAddGlobalChangeListenerParams _message =
          new CookieManagerAddGlobalChangeListenerParams();
      _message.notificationPointer = notificationPointer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void cloneInterface(InterfaceRequest<CookieManager> newInterface) {
      CookieManagerCloneInterfaceParams _message = new CookieManagerCloneInterfaceParams();
      _message.newInterface = newInterface;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void flushCookieStore(CookieManager.FlushCookieStore_Response callback) {
      CookieManagerFlushCookieStoreParams _message = new CookieManagerFlushCookieStoreParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new CookieManagerFlushCookieStoreResponseParamsForwardToCallback(callback));
    }

    @Override
    public void allowFileSchemeCookies(
        boolean allow, CookieManager.AllowFileSchemeCookies_Response callback) {
      CookieManagerAllowFileSchemeCookiesParams _message =
          new CookieManagerAllowFileSchemeCookiesParams();
      _message.allow = allow;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new CookieManagerAllowFileSchemeCookiesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setContentSettings(
        int contentSettingsType,
        ContentSettingPatternSource[] settings,
        CookieManager.SetContentSettings_Response callback) {
      CookieManagerSetContentSettingsParams _message = new CookieManagerSetContentSettingsParams();
      _message.contentSettingsType = contentSettingsType;
      _message.settings = settings;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)),
              new CookieManagerSetContentSettingsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setForceKeepSessionState() {
      CookieManagerSetForceKeepSessionStateParams _message =
          new CookieManagerSetForceKeepSessionStateParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void blockThirdPartyCookies(boolean block) {
      CookieManagerBlockThirdPartyCookiesParams _message =
          new CookieManagerBlockThirdPartyCookiesParams();
      _message.block = block;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
    }

    @Override
    public void blockTruncatedCookies(boolean block) {
      CookieManagerBlockTruncatedCookiesParams _message =
          new CookieManagerBlockTruncatedCookiesParams();
      _message.block = block;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15)));
    }

    @Override
    public void setMitigationsEnabledFor3pcd(boolean enable) {
      CookieManagerSetMitigationsEnabledFor3pcdParams _message =
          new CookieManagerSetMitigationsEnabledFor3pcdParams();
      _message.enable = enable;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(16)));
    }

    @Override
    public void setTrackingProtectionEnabledFor3pcd(boolean enable) {
      CookieManagerSetTrackingProtectionEnabledFor3pcdParams _message =
          new CookieManagerSetTrackingProtectionEnabledFor3pcdParams();
      _message.enable = enable;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(17)));
    }

    @Override
    public void setPreCommitCallbackDelayForTesting(TimeDelta delay) {
      CookieManagerSetPreCommitCallbackDelayForTestingParams _message =
          new CookieManagerSetPreCommitCallbackDelayForTestingParams();
      _message.delay = delay;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(18)));
    }
  }

  public static final class Stub extends Interface.Stub<CookieManager> {
    Stub(Core core, CookieManager impl) {
      super(core, impl);
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 0;
        if (header.hasFlag(4)) {
          flags = 0 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -2:
            return InterfaceControlMessagesHelper.handleRunOrClosePipe(
                CookieManager_Internal.MANAGER, messageWithHeader);
          case 7:
            CookieManagerAddCookieChangeListenerParams data =
                CookieManagerAddCookieChangeListenerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addCookieChangeListener(data.url, data.name, data.listener);
            return true;
          case 8:
            getImpl()
                .addGlobalChangeListener(
                    CookieManagerAddGlobalChangeListenerParams.deserialize(
                            messageWithHeader.getPayload())
                        .notificationPointer);
            return true;
          case 9:
            getImpl()
                .cloneInterface(
                    CookieManagerCloneInterfaceParams.deserialize(messageWithHeader.getPayload())
                        .newInterface);
            return true;
          case 13:
            CookieManagerSetForceKeepSessionStateParams.deserialize(messageWithHeader.getPayload());
            getImpl().setForceKeepSessionState();
            return true;
          case 14:
            getImpl()
                .blockThirdPartyCookies(
                    CookieManagerBlockThirdPartyCookiesParams.deserialize(
                            messageWithHeader.getPayload())
                        .block);
            return true;
          case 15:
            getImpl()
                .blockTruncatedCookies(
                    CookieManagerBlockTruncatedCookiesParams.deserialize(
                            messageWithHeader.getPayload())
                        .block);
            return true;
          case 16:
            getImpl()
                .setMitigationsEnabledFor3pcd(
                    CookieManagerSetMitigationsEnabledFor3pcdParams.deserialize(
                            messageWithHeader.getPayload())
                        .enable);
            return true;
          case 17:
            getImpl()
                .setTrackingProtectionEnabledFor3pcd(
                    CookieManagerSetTrackingProtectionEnabledFor3pcdParams.deserialize(
                            messageWithHeader.getPayload())
                        .enable);
            return true;
          case 18:
            getImpl()
                .setPreCommitCallbackDelayForTesting(
                    CookieManagerSetPreCommitCallbackDelayForTestingParams.deserialize(
                            messageWithHeader.getPayload())
                        .delay);
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }

    @Override
    public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 1;
        if (header.hasFlag(4)) {
          flags = 1 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -1:
            return InterfaceControlMessagesHelper.handleRun(
                getCore(), CookieManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CookieManagerGetAllCookiesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getAllCookies(
                    new CookieManagerGetAllCookiesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            CookieManagerGetAllCookiesWithAccessSemanticsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getAllCookiesWithAccessSemantics(
                    new CookieManagerGetAllCookiesWithAccessSemanticsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            CookieManagerGetCookieListParams data =
                CookieManagerGetCookieListParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getCookieList(
                    data.url,
                    data.cookieOptions,
                    data.cookiePartitionKeyCollection,
                    new CookieManagerGetCookieListResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            CookieManagerSetCanonicalCookieParams data2 =
                CookieManagerSetCanonicalCookieParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setCanonicalCookie(
                    data2.cookie,
                    data2.sourceUrl,
                    data2.cookieOptions,
                    new CookieManagerSetCanonicalCookieResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            getImpl()
                .deleteCanonicalCookie(
                    CookieManagerDeleteCanonicalCookieParams.deserialize(
                            messageWithHeader.getPayload())
                        .cookie,
                    new CookieManagerDeleteCanonicalCookieResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            getImpl()
                .deleteCookies(
                    CookieManagerDeleteCookiesParams.deserialize(messageWithHeader.getPayload())
                        .filter,
                    new CookieManagerDeleteCookiesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            CookieManagerDeleteSessionOnlyCookiesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .deleteSessionOnlyCookies(
                    new CookieManagerDeleteSessionOnlyCookiesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
          case 8:
          case 9:
          default:
            return false;
          case 10:
            CookieManagerFlushCookieStoreParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .flushCookieStore(
                    new CookieManagerFlushCookieStoreResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            getImpl()
                .allowFileSchemeCookies(
                    CookieManagerAllowFileSchemeCookiesParams.deserialize(
                            messageWithHeader.getPayload())
                        .allow,
                    new CookieManagerAllowFileSchemeCookiesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 12:
            CookieManagerSetContentSettingsParams data3 =
                CookieManagerSetContentSettingsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setContentSettings(
                    data3.contentSettingsType,
                    data3.settings,
                    new CookieManagerSetContentSettingsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CookieManagerGetAllCookiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerGetAllCookiesParams(int version) {
      super(8, version);
    }

    public CookieManagerGetAllCookiesParams() {
      this(0);
    }

    public static CookieManagerGetAllCookiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerGetAllCookiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerGetAllCookiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerGetAllCookiesParams result =
            new CookieManagerGetAllCookiesParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class CookieManagerGetAllCookiesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CanonicalCookie[] cookies;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerGetAllCookiesResponseParams(int version) {
      super(16, version);
    }

    public CookieManagerGetAllCookiesResponseParams() {
      this(0);
    }

    public static CookieManagerGetAllCookiesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerGetAllCookiesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerGetAllCookiesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerGetAllCookiesResponseParams result =
            new CookieManagerGetAllCookiesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.cookies = new CanonicalCookie[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.cookies[i1] = CanonicalCookie.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      CanonicalCookie[] canonicalCookieArr = this.cookies;
      if (canonicalCookieArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(canonicalCookieArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        CanonicalCookie[] canonicalCookieArr2 = this.cookies;
        if (i0 < canonicalCookieArr2.length) {
          encoder1.encode((Struct) canonicalCookieArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class CookieManagerGetAllCookiesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.GetAllCookies_Response mCallback;

    CookieManagerGetAllCookiesResponseParamsForwardToCallback(
        CookieManager.GetAllCookies_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        CookieManagerGetAllCookiesResponseParams response =
            CookieManagerGetAllCookiesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.cookies);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerGetAllCookiesResponseParamsProxyToResponder
      implements CookieManager.GetAllCookies_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerGetAllCookiesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CanonicalCookie[] cookies) {
      CookieManagerGetAllCookiesResponseParams _response =
          new CookieManagerGetAllCookiesResponseParams();
      _response.cookies = cookies;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerGetAllCookiesWithAccessSemanticsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerGetAllCookiesWithAccessSemanticsParams(int version) {
      super(8, version);
    }

    public CookieManagerGetAllCookiesWithAccessSemanticsParams() {
      this(0);
    }

    public static CookieManagerGetAllCookiesWithAccessSemanticsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerGetAllCookiesWithAccessSemanticsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerGetAllCookiesWithAccessSemanticsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerGetAllCookiesWithAccessSemanticsParams result =
            new CookieManagerGetAllCookiesWithAccessSemanticsParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class CookieManagerGetAllCookiesWithAccessSemanticsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] accessSemanticsList;
    public CanonicalCookie[] cookies;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerGetAllCookiesWithAccessSemanticsResponseParams(int version) {
      super(24, version);
    }

    public CookieManagerGetAllCookiesWithAccessSemanticsResponseParams() {
      this(0);
    }

    public static CookieManagerGetAllCookiesWithAccessSemanticsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerGetAllCookiesWithAccessSemanticsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerGetAllCookiesWithAccessSemanticsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerGetAllCookiesWithAccessSemanticsResponseParams result =
            new CookieManagerGetAllCookiesWithAccessSemanticsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.cookies = new CanonicalCookie[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.cookies[i1] = CanonicalCookie.decode(decoder2);
        }
        result.accessSemanticsList = decoder0.readInts(16, 0, -1);
        int i12 = 0;
        while (true) {
          int[] iArr = result.accessSemanticsList;
          if (i12 < iArr.length) {
            CookieAccessSemantics.validate(iArr[i12]);
            i12++;
          } else {
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
      CanonicalCookie[] canonicalCookieArr = this.cookies;
      if (canonicalCookieArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(canonicalCookieArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          CanonicalCookie[] canonicalCookieArr2 = this.cookies;
          if (i0 >= canonicalCookieArr2.length) {
            break;
          }
          encoder1.encode((Struct) canonicalCookieArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.accessSemanticsList, 16, 0, -1);
    }
  }

  static class CookieManagerGetAllCookiesWithAccessSemanticsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.GetAllCookiesWithAccessSemantics_Response mCallback;

    CookieManagerGetAllCookiesWithAccessSemanticsResponseParamsForwardToCallback(
        CookieManager.GetAllCookiesWithAccessSemantics_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        CookieManagerGetAllCookiesWithAccessSemanticsResponseParams response =
            CookieManagerGetAllCookiesWithAccessSemanticsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.cookies, response.accessSemanticsList);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerGetAllCookiesWithAccessSemanticsResponseParamsProxyToResponder
      implements CookieManager.GetAllCookiesWithAccessSemantics_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerGetAllCookiesWithAccessSemanticsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CanonicalCookie[] cookies, int[] accessSemanticsList) {
      CookieManagerGetAllCookiesWithAccessSemanticsResponseParams _response =
          new CookieManagerGetAllCookiesWithAccessSemanticsResponseParams();
      _response.cookies = cookies;
      _response.accessSemanticsList = accessSemanticsList;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerGetCookieListParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieOptions cookieOptions;
    public CookiePartitionKeyCollection cookiePartitionKeyCollection;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerGetCookieListParams(int version) {
      super(32, version);
    }

    public CookieManagerGetCookieListParams() {
      this(0);
    }

    public static CookieManagerGetCookieListParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerGetCookieListParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerGetCookieListParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerGetCookieListParams result =
            new CookieManagerGetCookieListParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.cookieOptions = CookieOptions.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.cookiePartitionKeyCollection = CookiePartitionKeyCollection.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.cookieOptions, 16, false);
      encoder0.encode((Struct) this.cookiePartitionKeyCollection, 24, false);
    }
  }

  static final class CookieManagerGetCookieListResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieWithAccessResult[] cookies;
    public CookieWithAccessResult[] excludedCookies;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerGetCookieListResponseParams(int version) {
      super(24, version);
    }

    public CookieManagerGetCookieListResponseParams() {
      this(0);
    }

    public static CookieManagerGetCookieListResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerGetCookieListResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerGetCookieListResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerGetCookieListResponseParams result =
            new CookieManagerGetCookieListResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.cookies = new CookieWithAccessResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.cookies[i1] = CookieWithAccessResult.decode(decoder2);
        }
        Decoder decoder12 = decoder0.readPointer(16, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.excludedCookies = new CookieWithAccessResult[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.excludedCookies[i12] = CookieWithAccessResult.decode(decoder22);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      CookieWithAccessResult[] cookieWithAccessResultArr = this.cookies;
      if (cookieWithAccessResultArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(cookieWithAccessResultArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          CookieWithAccessResult[] cookieWithAccessResultArr2 = this.cookies;
          if (i0 >= cookieWithAccessResultArr2.length) {
            break;
          }
          encoder1.encode((Struct) cookieWithAccessResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      CookieWithAccessResult[] cookieWithAccessResultArr3 = this.excludedCookies;
      if (cookieWithAccessResultArr3 == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder12 = encoder0.encodePointerArray(cookieWithAccessResultArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        CookieWithAccessResult[] cookieWithAccessResultArr4 = this.excludedCookies;
        if (i02 < cookieWithAccessResultArr4.length) {
          encoder12.encode((Struct) cookieWithAccessResultArr4[i02], (i02 * 8) + 8, false);
          i02++;
        } else {
          return;
        }
      }
    }
  }

  static class CookieManagerGetCookieListResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.GetCookieList_Response mCallback;

    CookieManagerGetCookieListResponseParamsForwardToCallback(
        CookieManager.GetCookieList_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        CookieManagerGetCookieListResponseParams response =
            CookieManagerGetCookieListResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.cookies, response.excludedCookies);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerGetCookieListResponseParamsProxyToResponder
      implements CookieManager.GetCookieList_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerGetCookieListResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CookieWithAccessResult[] cookies, CookieWithAccessResult[] excludedCookies) {
      CookieManagerGetCookieListResponseParams _response =
          new CookieManagerGetCookieListResponseParams();
      _response.cookies = cookies;
      _response.excludedCookies = excludedCookies;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerSetCanonicalCookieParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public CanonicalCookie cookie;
    public CookieOptions cookieOptions;
    public Url sourceUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerSetCanonicalCookieParams(int version) {
      super(32, version);
    }

    public CookieManagerSetCanonicalCookieParams() {
      this(0);
    }

    public static CookieManagerSetCanonicalCookieParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerSetCanonicalCookieParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerSetCanonicalCookieParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerSetCanonicalCookieParams result =
            new CookieManagerSetCanonicalCookieParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cookie = CanonicalCookie.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.sourceUrl = Url.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.cookieOptions = CookieOptions.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cookie, 8, false);
      encoder0.encode((Struct) this.sourceUrl, 16, false);
      encoder0.encode((Struct) this.cookieOptions, 24, false);
    }
  }

  static final class CookieManagerSetCanonicalCookieResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieAccessResult accessResult;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerSetCanonicalCookieResponseParams(int version) {
      super(16, version);
    }

    public CookieManagerSetCanonicalCookieResponseParams() {
      this(0);
    }

    public static CookieManagerSetCanonicalCookieResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerSetCanonicalCookieResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerSetCanonicalCookieResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerSetCanonicalCookieResponseParams result =
            new CookieManagerSetCanonicalCookieResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.accessResult = CookieAccessResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.accessResult, 8, false);
    }
  }

  static class CookieManagerSetCanonicalCookieResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.SetCanonicalCookie_Response mCallback;

    CookieManagerSetCanonicalCookieResponseParamsForwardToCallback(
        CookieManager.SetCanonicalCookie_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        CookieManagerSetCanonicalCookieResponseParams response =
            CookieManagerSetCanonicalCookieResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.accessResult);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerSetCanonicalCookieResponseParamsProxyToResponder
      implements CookieManager.SetCanonicalCookie_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerSetCanonicalCookieResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CookieAccessResult accessResult) {
      CookieManagerSetCanonicalCookieResponseParams _response =
          new CookieManagerSetCanonicalCookieResponseParams();
      _response.accessResult = accessResult;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerDeleteCanonicalCookieParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CanonicalCookie cookie;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerDeleteCanonicalCookieParams(int version) {
      super(16, version);
    }

    public CookieManagerDeleteCanonicalCookieParams() {
      this(0);
    }

    public static CookieManagerDeleteCanonicalCookieParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerDeleteCanonicalCookieParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerDeleteCanonicalCookieParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerDeleteCanonicalCookieParams result =
            new CookieManagerDeleteCanonicalCookieParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cookie = CanonicalCookie.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cookie, 8, false);
    }
  }

  static final class CookieManagerDeleteCanonicalCookieResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerDeleteCanonicalCookieResponseParams(int version) {
      super(16, version);
    }

    public CookieManagerDeleteCanonicalCookieResponseParams() {
      this(0);
    }

    public static CookieManagerDeleteCanonicalCookieResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerDeleteCanonicalCookieResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerDeleteCanonicalCookieResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerDeleteCanonicalCookieResponseParams result =
            new CookieManagerDeleteCanonicalCookieResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class CookieManagerDeleteCanonicalCookieResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.DeleteCanonicalCookie_Response mCallback;

    CookieManagerDeleteCanonicalCookieResponseParamsForwardToCallback(
        CookieManager.DeleteCanonicalCookie_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        CookieManagerDeleteCanonicalCookieResponseParams response =
            CookieManagerDeleteCanonicalCookieResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerDeleteCanonicalCookieResponseParamsProxyToResponder
      implements CookieManager.DeleteCanonicalCookie_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerDeleteCanonicalCookieResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      CookieManagerDeleteCanonicalCookieResponseParams _response =
          new CookieManagerDeleteCanonicalCookieResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerDeleteCookiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieDeletionFilter filter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerDeleteCookiesParams(int version) {
      super(16, version);
    }

    public CookieManagerDeleteCookiesParams() {
      this(0);
    }

    public static CookieManagerDeleteCookiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerDeleteCookiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerDeleteCookiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerDeleteCookiesParams result =
            new CookieManagerDeleteCookiesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filter = CookieDeletionFilter.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, false);
    }
  }

  static final class CookieManagerDeleteCookiesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int numDeleted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerDeleteCookiesResponseParams(int version) {
      super(16, version);
    }

    public CookieManagerDeleteCookiesResponseParams() {
      this(0);
    }

    public static CookieManagerDeleteCookiesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerDeleteCookiesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerDeleteCookiesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerDeleteCookiesResponseParams result =
            new CookieManagerDeleteCookiesResponseParams(elementsOrVersion);
        result.numDeleted = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.numDeleted, 8);
    }
  }

  static class CookieManagerDeleteCookiesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.DeleteCookies_Response mCallback;

    CookieManagerDeleteCookiesResponseParamsForwardToCallback(
        CookieManager.DeleteCookies_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        CookieManagerDeleteCookiesResponseParams response =
            CookieManagerDeleteCookiesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.numDeleted);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerDeleteCookiesResponseParamsProxyToResponder
      implements CookieManager.DeleteCookies_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerDeleteCookiesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int numDeleted) {
      CookieManagerDeleteCookiesResponseParams _response =
          new CookieManagerDeleteCookiesResponseParams();
      _response.numDeleted = numDeleted;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerDeleteSessionOnlyCookiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerDeleteSessionOnlyCookiesParams(int version) {
      super(8, version);
    }

    public CookieManagerDeleteSessionOnlyCookiesParams() {
      this(0);
    }

    public static CookieManagerDeleteSessionOnlyCookiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerDeleteSessionOnlyCookiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerDeleteSessionOnlyCookiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerDeleteSessionOnlyCookiesParams result =
            new CookieManagerDeleteSessionOnlyCookiesParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class CookieManagerDeleteSessionOnlyCookiesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int numDeleted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerDeleteSessionOnlyCookiesResponseParams(int version) {
      super(16, version);
    }

    public CookieManagerDeleteSessionOnlyCookiesResponseParams() {
      this(0);
    }

    public static CookieManagerDeleteSessionOnlyCookiesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerDeleteSessionOnlyCookiesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerDeleteSessionOnlyCookiesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerDeleteSessionOnlyCookiesResponseParams result =
            new CookieManagerDeleteSessionOnlyCookiesResponseParams(elementsOrVersion);
        result.numDeleted = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.numDeleted, 8);
    }
  }

  static class CookieManagerDeleteSessionOnlyCookiesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.DeleteSessionOnlyCookies_Response mCallback;

    CookieManagerDeleteSessionOnlyCookiesResponseParamsForwardToCallback(
        CookieManager.DeleteSessionOnlyCookies_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        CookieManagerDeleteSessionOnlyCookiesResponseParams response =
            CookieManagerDeleteSessionOnlyCookiesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.numDeleted);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerDeleteSessionOnlyCookiesResponseParamsProxyToResponder
      implements CookieManager.DeleteSessionOnlyCookies_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerDeleteSessionOnlyCookiesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int numDeleted) {
      CookieManagerDeleteSessionOnlyCookiesResponseParams _response =
          new CookieManagerDeleteSessionOnlyCookiesResponseParams();
      _response.numDeleted = numDeleted;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerAddCookieChangeListenerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieChangeListener listener;
    public String name;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAddCookieChangeListenerParams(int version) {
      super(32, version);
    }

    public CookieManagerAddCookieChangeListenerParams() {
      this(0);
    }

    public static CookieManagerAddCookieChangeListenerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAddCookieChangeListenerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAddCookieChangeListenerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAddCookieChangeListenerParams result =
            new CookieManagerAddCookieChangeListenerParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.name = decoder0.readString(16, true);
        result.listener =
            (CookieChangeListener)
                decoder0.readServiceInterface(24, false, CookieChangeListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.name, 16, true);
      encoder0.encode(this.listener, 24, false, CookieChangeListener.MANAGER);
    }
  }

  static final class CookieManagerAddGlobalChangeListenerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieChangeListener notificationPointer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAddGlobalChangeListenerParams(int version) {
      super(16, version);
    }

    public CookieManagerAddGlobalChangeListenerParams() {
      this(0);
    }

    public static CookieManagerAddGlobalChangeListenerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAddGlobalChangeListenerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAddGlobalChangeListenerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAddGlobalChangeListenerParams result =
            new CookieManagerAddGlobalChangeListenerParams(elementsOrVersion);
        result.notificationPointer =
            (CookieChangeListener)
                decoder0.readServiceInterface(8, false, CookieChangeListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.notificationPointer, 8, false, CookieChangeListener.MANAGER);
    }
  }

  static final class CookieManagerCloneInterfaceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<CookieManager> newInterface;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerCloneInterfaceParams(int version) {
      super(16, version);
    }

    public CookieManagerCloneInterfaceParams() {
      this(0);
    }

    public static CookieManagerCloneInterfaceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerCloneInterfaceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerCloneInterfaceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerCloneInterfaceParams result =
            new CookieManagerCloneInterfaceParams(elementsOrVersion);
        result.newInterface = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.newInterface, 8, false);
    }
  }

  static final class CookieManagerFlushCookieStoreParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerFlushCookieStoreParams(int version) {
      super(8, version);
    }

    public CookieManagerFlushCookieStoreParams() {
      this(0);
    }

    public static CookieManagerFlushCookieStoreParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerFlushCookieStoreParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerFlushCookieStoreParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerFlushCookieStoreParams result =
            new CookieManagerFlushCookieStoreParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class CookieManagerFlushCookieStoreResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerFlushCookieStoreResponseParams(int version) {
      super(8, version);
    }

    public CookieManagerFlushCookieStoreResponseParams() {
      this(0);
    }

    public static CookieManagerFlushCookieStoreResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerFlushCookieStoreResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerFlushCookieStoreResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerFlushCookieStoreResponseParams result =
            new CookieManagerFlushCookieStoreResponseParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static class CookieManagerFlushCookieStoreResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.FlushCookieStore_Response mCallback;

    CookieManagerFlushCookieStoreResponseParamsForwardToCallback(
        CookieManager.FlushCookieStore_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(10, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerFlushCookieStoreResponseParamsProxyToResponder
      implements CookieManager.FlushCookieStore_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerFlushCookieStoreResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      CookieManagerFlushCookieStoreResponseParams _response =
          new CookieManagerFlushCookieStoreResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerAllowFileSchemeCookiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allow;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAllowFileSchemeCookiesParams(int version) {
      super(16, version);
    }

    public CookieManagerAllowFileSchemeCookiesParams() {
      this(0);
    }

    public static CookieManagerAllowFileSchemeCookiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAllowFileSchemeCookiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAllowFileSchemeCookiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAllowFileSchemeCookiesParams result =
            new CookieManagerAllowFileSchemeCookiesParams(elementsOrVersion);
        result.allow = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.allow, 8, 0);
    }
  }

  static final class CookieManagerAllowFileSchemeCookiesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAllowFileSchemeCookiesResponseParams(int version) {
      super(16, version);
    }

    public CookieManagerAllowFileSchemeCookiesResponseParams() {
      this(0);
    }

    public static CookieManagerAllowFileSchemeCookiesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAllowFileSchemeCookiesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAllowFileSchemeCookiesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAllowFileSchemeCookiesResponseParams result =
            new CookieManagerAllowFileSchemeCookiesResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class CookieManagerAllowFileSchemeCookiesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.AllowFileSchemeCookies_Response mCallback;

    CookieManagerAllowFileSchemeCookiesResponseParamsForwardToCallback(
        CookieManager.AllowFileSchemeCookies_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 2)) {
          return false;
        }
        CookieManagerAllowFileSchemeCookiesResponseParams response =
            CookieManagerAllowFileSchemeCookiesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerAllowFileSchemeCookiesResponseParamsProxyToResponder
      implements CookieManager.AllowFileSchemeCookies_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerAllowFileSchemeCookiesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      CookieManagerAllowFileSchemeCookiesResponseParams _response =
          new CookieManagerAllowFileSchemeCookiesResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerSetContentSettingsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int contentSettingsType;
    public ContentSettingPatternSource[] settings;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerSetContentSettingsParams(int version) {
      super(24, version);
    }

    public CookieManagerSetContentSettingsParams() {
      this(0);
    }

    public static CookieManagerSetContentSettingsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerSetContentSettingsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerSetContentSettingsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerSetContentSettingsParams result =
            new CookieManagerSetContentSettingsParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.contentSettingsType = readInt;
        ContentSettingsType.validate(readInt);
        result.contentSettingsType = ContentSettingsType.toKnownValue(result.contentSettingsType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.settings = new ContentSettingPatternSource[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.settings[i1] = ContentSettingPatternSource.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.contentSettingsType, 8);
      ContentSettingPatternSource[] contentSettingPatternSourceArr = this.settings;
      if (contentSettingPatternSourceArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(contentSettingPatternSourceArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        ContentSettingPatternSource[] contentSettingPatternSourceArr2 = this.settings;
        if (i0 < contentSettingPatternSourceArr2.length) {
          encoder1.encode((Struct) contentSettingPatternSourceArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class CookieManagerSetContentSettingsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerSetContentSettingsResponseParams(int version) {
      super(8, version);
    }

    public CookieManagerSetContentSettingsResponseParams() {
      this(0);
    }

    public static CookieManagerSetContentSettingsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerSetContentSettingsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerSetContentSettingsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerSetContentSettingsResponseParams result =
            new CookieManagerSetContentSettingsResponseParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static class CookieManagerSetContentSettingsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManager.SetContentSettings_Response mCallback;

    CookieManagerSetContentSettingsResponseParamsForwardToCallback(
        CookieManager.SetContentSettings_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(12, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerSetContentSettingsResponseParamsProxyToResponder
      implements CookieManager.SetContentSettings_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerSetContentSettingsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      CookieManagerSetContentSettingsResponseParams _response =
          new CookieManagerSetContentSettingsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerSetForceKeepSessionStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerSetForceKeepSessionStateParams(int version) {
      super(8, version);
    }

    public CookieManagerSetForceKeepSessionStateParams() {
      this(0);
    }

    public static CookieManagerSetForceKeepSessionStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerSetForceKeepSessionStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerSetForceKeepSessionStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerSetForceKeepSessionStateParams result =
            new CookieManagerSetForceKeepSessionStateParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class CookieManagerBlockThirdPartyCookiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean block;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerBlockThirdPartyCookiesParams(int version) {
      super(16, version);
    }

    public CookieManagerBlockThirdPartyCookiesParams() {
      this(0);
    }

    public static CookieManagerBlockThirdPartyCookiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerBlockThirdPartyCookiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerBlockThirdPartyCookiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerBlockThirdPartyCookiesParams result =
            new CookieManagerBlockThirdPartyCookiesParams(elementsOrVersion);
        result.block = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.block, 8, 0);
    }
  }

  static final class CookieManagerBlockTruncatedCookiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean block;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerBlockTruncatedCookiesParams(int version) {
      super(16, version);
    }

    public CookieManagerBlockTruncatedCookiesParams() {
      this(0);
    }

    public static CookieManagerBlockTruncatedCookiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerBlockTruncatedCookiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerBlockTruncatedCookiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerBlockTruncatedCookiesParams result =
            new CookieManagerBlockTruncatedCookiesParams(elementsOrVersion);
        result.block = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.block, 8, 0);
    }
  }

  static final class CookieManagerSetMitigationsEnabledFor3pcdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerSetMitigationsEnabledFor3pcdParams(int version) {
      super(16, version);
    }

    public CookieManagerSetMitigationsEnabledFor3pcdParams() {
      this(0);
    }

    public static CookieManagerSetMitigationsEnabledFor3pcdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerSetMitigationsEnabledFor3pcdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerSetMitigationsEnabledFor3pcdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerSetMitigationsEnabledFor3pcdParams result =
            new CookieManagerSetMitigationsEnabledFor3pcdParams(elementsOrVersion);
        result.enable = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enable, 8, 0);
    }
  }

  static final class CookieManagerSetTrackingProtectionEnabledFor3pcdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerSetTrackingProtectionEnabledFor3pcdParams(int version) {
      super(16, version);
    }

    public CookieManagerSetTrackingProtectionEnabledFor3pcdParams() {
      this(0);
    }

    public static CookieManagerSetTrackingProtectionEnabledFor3pcdParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerSetTrackingProtectionEnabledFor3pcdParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerSetTrackingProtectionEnabledFor3pcdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerSetTrackingProtectionEnabledFor3pcdParams result =
            new CookieManagerSetTrackingProtectionEnabledFor3pcdParams(elementsOrVersion);
        result.enable = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enable, 8, 0);
    }
  }

  static final class CookieManagerSetPreCommitCallbackDelayForTestingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta delay;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerSetPreCommitCallbackDelayForTestingParams(int version) {
      super(16, version);
    }

    public CookieManagerSetPreCommitCallbackDelayForTestingParams() {
      this(0);
    }

    public static CookieManagerSetPreCommitCallbackDelayForTestingParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerSetPreCommitCallbackDelayForTestingParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerSetPreCommitCallbackDelayForTestingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerSetPreCommitCallbackDelayForTestingParams result =
            new CookieManagerSetPreCommitCallbackDelayForTestingParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.delay = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.delay, 8, false);
    }
  }
}
