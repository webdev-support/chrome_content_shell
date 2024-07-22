package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.network.mojom.AttributionSupport;
import org.chromium.skia.mojom.SkColor;

class PageBroadcast_Internal {
  private static final int ACTIVATE_PRERENDERED_PAGE_ORDINAL = 2;
  private static final int AUDIO_STATE_CHANGED_ORDINAL = 1;
  private static final int CREATE_REMOTE_MAIN_FRAME_ORDINAL = 7;
  public static final Interface.Manager<PageBroadcast, PageBroadcast.Proxy> MANAGER =
      new Interface.Manager<PageBroadcast, PageBroadcast.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PageBroadcast";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PageBroadcast.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PageBroadcast impl) {
          return new Stub(core, impl);
        }

        @Override
        public PageBroadcast[] buildArray(int size) {
          return new PageBroadcast[size];
        }
      };
  private static final int SET_HISTORY_OFFSET_AND_LENGTH_ORDINAL = 5;
  private static final int SET_PAGE_ATTRIBUTION_SUPPORT_ORDINAL = 9;
  private static final int SET_PAGE_BASE_BACKGROUND_COLOR_ORDINAL = 6;
  private static final int SET_PAGE_LIFECYCLE_STATE_ORDINAL = 0;
  private static final int UPDATE_COLOR_PROVIDERS_ORDINAL = 10;
  private static final int UPDATE_PAGE_BROWSING_CONTEXT_GROUP_ORDINAL = 8;
  private static final int UPDATE_RENDERER_PREFERENCES_ORDINAL = 4;
  private static final int UPDATE_WEB_PREFERENCES_ORDINAL = 3;

  PageBroadcast_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements PageBroadcast.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setPageLifecycleState(
        PageLifecycleState state,
        PageRestoreParams pageRestoreParams,
        SetPageLifecycleState_Response callback) {
      PageBroadcastSetPageLifecycleStateParams _message =
          new PageBroadcastSetPageLifecycleStateParams();
      _message.state = state;
      _message.pageRestoreParams = pageRestoreParams;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new PageBroadcastSetPageLifecycleStateResponseParamsForwardToCallback(callback));
    }

    @Override
    public void audioStateChanged(boolean isAudioPlaying) {
      PageBroadcastAudioStateChangedParams _message = new PageBroadcastAudioStateChangedParams();
      _message.isAudioPlaying = isAudioPlaying;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void activatePrerenderedPage(
        PrerenderPageActivationParams prerenderPageActivationParams,
        ActivatePrerenderedPage_Response callback) {
      PageBroadcastActivatePrerenderedPageParams _message =
          new PageBroadcastActivatePrerenderedPageParams();
      _message.prerenderPageActivationParams = prerenderPageActivationParams;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new PageBroadcastActivatePrerenderedPageResponseParamsForwardToCallback(callback));
    }

    @Override
    public void updateWebPreferences(WebPreferences preferences) {
      PageBroadcastUpdateWebPreferencesParams _message =
          new PageBroadcastUpdateWebPreferencesParams();
      _message.preferences = preferences;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void updateRendererPreferences(RendererPreferences preferences) {
      PageBroadcastUpdateRendererPreferencesParams _message =
          new PageBroadcastUpdateRendererPreferencesParams();
      _message.preferences = preferences;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void setHistoryOffsetAndLength(int offset, int length) {
      PageBroadcastSetHistoryOffsetAndLengthParams _message =
          new PageBroadcastSetHistoryOffsetAndLengthParams();
      _message.offset = offset;
      _message.length = length;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void setPageBaseBackgroundColor(SkColor color) {
      PageBroadcastSetPageBaseBackgroundColorParams _message =
          new PageBroadcastSetPageBaseBackgroundColorParams();
      _message.color = color;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void createRemoteMainFrame(
        RemoteFrameToken token,
        FrameToken openerFrameToken,
        FrameReplicationState replicationState,
        boolean isLoading,
        UnguessableToken devtoolsFrameToken,
        RemoteFrameInterfacesFromBrowser remoteFrameInterfaces,
        RemoteMainFrameInterfaces remoteMainFrameInterfaces) {
      PageBroadcastCreateRemoteMainFrameParams _message =
          new PageBroadcastCreateRemoteMainFrameParams();
      _message.token = token;
      _message.openerFrameToken = openerFrameToken;
      _message.replicationState = replicationState;
      _message.isLoading = isLoading;
      _message.devtoolsFrameToken = devtoolsFrameToken;
      _message.remoteFrameInterfaces = remoteFrameInterfaces;
      _message.remoteMainFrameInterfaces = remoteMainFrameInterfaces;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void updatePageBrowsingContextGroup(BrowsingContextGroupInfo browsingContextGroupInfo) {
      PageBroadcastUpdatePageBrowsingContextGroupParams _message =
          new PageBroadcastUpdatePageBrowsingContextGroupParams();
      _message.browsingContextGroupInfo = browsingContextGroupInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void setPageAttributionSupport(int support) {
      PageBroadcastSetPageAttributionSupportParams _message =
          new PageBroadcastSetPageAttributionSupportParams();
      _message.support = support;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void updateColorProviders(ColorProviderColorMaps colorProviderColors) {
      PageBroadcastUpdateColorProvidersParams _message =
          new PageBroadcastUpdateColorProvidersParams();
      _message.colorProviderColors = colorProviderColors;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }
  }

  public static final class Stub extends Interface.Stub<PageBroadcast> {
    Stub(Core core, PageBroadcast impl) {
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
                PageBroadcast_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 2:
          default:
            return false;
          case 1:
            PageBroadcastAudioStateChangedParams data =
                PageBroadcastAudioStateChangedParams.deserialize(messageWithHeader.getPayload());
            getImpl().audioStateChanged(data.isAudioPlaying);
            return true;
          case 3:
            PageBroadcastUpdateWebPreferencesParams data2 =
                PageBroadcastUpdateWebPreferencesParams.deserialize(messageWithHeader.getPayload());
            getImpl().updateWebPreferences(data2.preferences);
            return true;
          case 4:
            PageBroadcastUpdateRendererPreferencesParams data3 =
                PageBroadcastUpdateRendererPreferencesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateRendererPreferences(data3.preferences);
            return true;
          case 5:
            PageBroadcastSetHistoryOffsetAndLengthParams data4 =
                PageBroadcastSetHistoryOffsetAndLengthParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setHistoryOffsetAndLength(data4.offset, data4.length);
            return true;
          case 6:
            PageBroadcastSetPageBaseBackgroundColorParams data5 =
                PageBroadcastSetPageBaseBackgroundColorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setPageBaseBackgroundColor(data5.color);
            return true;
          case 7:
            PageBroadcastCreateRemoteMainFrameParams data6 =
                PageBroadcastCreateRemoteMainFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createRemoteMainFrame(
                    data6.token,
                    data6.openerFrameToken,
                    data6.replicationState,
                    data6.isLoading,
                    data6.devtoolsFrameToken,
                    data6.remoteFrameInterfaces,
                    data6.remoteMainFrameInterfaces);
            return true;
          case 8:
            PageBroadcastUpdatePageBrowsingContextGroupParams data7 =
                PageBroadcastUpdatePageBrowsingContextGroupParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updatePageBrowsingContextGroup(data7.browsingContextGroupInfo);
            return true;
          case 9:
            PageBroadcastSetPageAttributionSupportParams data8 =
                PageBroadcastSetPageAttributionSupportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setPageAttributionSupport(data8.support);
            return true;
          case 10:
            PageBroadcastUpdateColorProvidersParams data9 =
                PageBroadcastUpdateColorProvidersParams.deserialize(messageWithHeader.getPayload());
            getImpl().updateColorProviders(data9.colorProviderColors);
            return true;
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
                getCore(), PageBroadcast_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            PageBroadcastSetPageLifecycleStateParams data =
                PageBroadcastSetPageLifecycleStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setPageLifecycleState(
                    data.state,
                    data.pageRestoreParams,
                    new PageBroadcastSetPageLifecycleStateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            getImpl()
                .activatePrerenderedPage(
                    PageBroadcastActivatePrerenderedPageParams.deserialize(
                            messageWithHeader.getPayload())
                        .prerenderPageActivationParams,
                    new PageBroadcastActivatePrerenderedPageResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PageBroadcastSetPageLifecycleStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PageRestoreParams pageRestoreParams;
    public PageLifecycleState state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastSetPageLifecycleStateParams(int version) {
      super(24, version);
    }

    public PageBroadcastSetPageLifecycleStateParams() {
      this(0);
    }

    public static PageBroadcastSetPageLifecycleStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastSetPageLifecycleStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastSetPageLifecycleStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastSetPageLifecycleStateParams result =
            new PageBroadcastSetPageLifecycleStateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.state = PageLifecycleState.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.pageRestoreParams = PageRestoreParams.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.state, 8, false);
      encoder0.encode((Struct) this.pageRestoreParams, 16, true);
    }
  }

  static final class PageBroadcastSetPageLifecycleStateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastSetPageLifecycleStateResponseParams(int version) {
      super(8, version);
    }

    public PageBroadcastSetPageLifecycleStateResponseParams() {
      this(0);
    }

    public static PageBroadcastSetPageLifecycleStateResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastSetPageLifecycleStateResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastSetPageLifecycleStateResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastSetPageLifecycleStateResponseParams result =
            new PageBroadcastSetPageLifecycleStateResponseParams(elementsOrVersion);
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

  static class PageBroadcastSetPageLifecycleStateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PageBroadcast.SetPageLifecycleState_Response mCallback;

    PageBroadcastSetPageLifecycleStateResponseParamsForwardToCallback(
        PageBroadcast.SetPageLifecycleState_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PageBroadcastSetPageLifecycleStateResponseParamsProxyToResponder
      implements PageBroadcast.SetPageLifecycleState_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PageBroadcastSetPageLifecycleStateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      PageBroadcastSetPageLifecycleStateResponseParams _response =
          new PageBroadcastSetPageLifecycleStateResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PageBroadcastAudioStateChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isAudioPlaying;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastAudioStateChangedParams(int version) {
      super(16, version);
    }

    public PageBroadcastAudioStateChangedParams() {
      this(0);
    }

    public static PageBroadcastAudioStateChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastAudioStateChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastAudioStateChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastAudioStateChangedParams result =
            new PageBroadcastAudioStateChangedParams(elementsOrVersion);
        result.isAudioPlaying = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isAudioPlaying, 8, 0);
    }
  }

  static final class PageBroadcastActivatePrerenderedPageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PrerenderPageActivationParams prerenderPageActivationParams;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastActivatePrerenderedPageParams(int version) {
      super(16, version);
    }

    public PageBroadcastActivatePrerenderedPageParams() {
      this(0);
    }

    public static PageBroadcastActivatePrerenderedPageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastActivatePrerenderedPageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastActivatePrerenderedPageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastActivatePrerenderedPageParams result =
            new PageBroadcastActivatePrerenderedPageParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.prerenderPageActivationParams = PrerenderPageActivationParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.prerenderPageActivationParams, 8, false);
    }
  }

  static final class PageBroadcastActivatePrerenderedPageResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastActivatePrerenderedPageResponseParams(int version) {
      super(8, version);
    }

    public PageBroadcastActivatePrerenderedPageResponseParams() {
      this(0);
    }

    public static PageBroadcastActivatePrerenderedPageResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastActivatePrerenderedPageResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastActivatePrerenderedPageResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastActivatePrerenderedPageResponseParams result =
            new PageBroadcastActivatePrerenderedPageResponseParams(elementsOrVersion);
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

  static class PageBroadcastActivatePrerenderedPageResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PageBroadcast.ActivatePrerenderedPage_Response mCallback;

    PageBroadcastActivatePrerenderedPageResponseParamsForwardToCallback(
        PageBroadcast.ActivatePrerenderedPage_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PageBroadcastActivatePrerenderedPageResponseParamsProxyToResponder
      implements PageBroadcast.ActivatePrerenderedPage_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PageBroadcastActivatePrerenderedPageResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      PageBroadcastActivatePrerenderedPageResponseParams _response =
          new PageBroadcastActivatePrerenderedPageResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PageBroadcastUpdateWebPreferencesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public WebPreferences preferences;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastUpdateWebPreferencesParams(int version) {
      super(16, version);
    }

    public PageBroadcastUpdateWebPreferencesParams() {
      this(0);
    }

    public static PageBroadcastUpdateWebPreferencesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastUpdateWebPreferencesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastUpdateWebPreferencesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastUpdateWebPreferencesParams result =
            new PageBroadcastUpdateWebPreferencesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.preferences = WebPreferences.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.preferences, 8, false);
    }
  }

  static final class PageBroadcastUpdateRendererPreferencesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public RendererPreferences preferences;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastUpdateRendererPreferencesParams(int version) {
      super(16, version);
    }

    public PageBroadcastUpdateRendererPreferencesParams() {
      this(0);
    }

    public static PageBroadcastUpdateRendererPreferencesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastUpdateRendererPreferencesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastUpdateRendererPreferencesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastUpdateRendererPreferencesParams result =
            new PageBroadcastUpdateRendererPreferencesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.preferences = RendererPreferences.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.preferences, 8, false);
    }
  }

  static final class PageBroadcastSetHistoryOffsetAndLengthParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int length;
    public int offset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastSetHistoryOffsetAndLengthParams(int version) {
      super(16, version);
    }

    public PageBroadcastSetHistoryOffsetAndLengthParams() {
      this(0);
    }

    public static PageBroadcastSetHistoryOffsetAndLengthParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastSetHistoryOffsetAndLengthParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastSetHistoryOffsetAndLengthParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastSetHistoryOffsetAndLengthParams result =
            new PageBroadcastSetHistoryOffsetAndLengthParams(elementsOrVersion);
        result.offset = decoder0.readInt(8);
        result.length = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.offset, 8);
      encoder0.encode(this.length, 12);
    }
  }

  static final class PageBroadcastSetPageBaseBackgroundColorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SkColor color;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastSetPageBaseBackgroundColorParams(int version) {
      super(16, version);
    }

    public PageBroadcastSetPageBaseBackgroundColorParams() {
      this(0);
    }

    public static PageBroadcastSetPageBaseBackgroundColorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastSetPageBaseBackgroundColorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastSetPageBaseBackgroundColorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastSetPageBaseBackgroundColorParams result =
            new PageBroadcastSetPageBaseBackgroundColorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.color = SkColor.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.color, 8, true);
    }
  }

  static final class PageBroadcastCreateRemoteMainFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 72;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken devtoolsFrameToken;
    public boolean isLoading;
    public FrameToken openerFrameToken;
    public RemoteFrameInterfacesFromBrowser remoteFrameInterfaces;
    public RemoteMainFrameInterfaces remoteMainFrameInterfaces;
    public FrameReplicationState replicationState;
    public RemoteFrameToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastCreateRemoteMainFrameParams(int version) {
      super(72, version);
    }

    public PageBroadcastCreateRemoteMainFrameParams() {
      this(0);
    }

    public static PageBroadcastCreateRemoteMainFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastCreateRemoteMainFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastCreateRemoteMainFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastCreateRemoteMainFrameParams result =
            new PageBroadcastCreateRemoteMainFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.token = RemoteFrameToken.decode(decoder1);
        result.openerFrameToken = FrameToken.decode(decoder0, 16);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.replicationState = FrameReplicationState.decode(decoder12);
        result.isLoading = decoder0.readBoolean(40, 0);
        Decoder decoder13 = decoder0.readPointer(48, false);
        result.devtoolsFrameToken = UnguessableToken.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(56, false);
        result.remoteFrameInterfaces = RemoteFrameInterfacesFromBrowser.decode(decoder14);
        Decoder decoder15 = decoder0.readPointer(64, false);
        result.remoteMainFrameInterfaces = RemoteMainFrameInterfaces.decode(decoder15);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.token, 8, false);
      encoder0.encode((Union) this.openerFrameToken, 16, true);
      encoder0.encode((Struct) this.replicationState, 32, false);
      encoder0.encode(this.isLoading, 40, 0);
      encoder0.encode((Struct) this.devtoolsFrameToken, 48, false);
      encoder0.encode((Struct) this.remoteFrameInterfaces, 56, false);
      encoder0.encode((Struct) this.remoteMainFrameInterfaces, 64, false);
    }
  }

  static final class PageBroadcastUpdatePageBrowsingContextGroupParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BrowsingContextGroupInfo browsingContextGroupInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastUpdatePageBrowsingContextGroupParams(int version) {
      super(16, version);
    }

    public PageBroadcastUpdatePageBrowsingContextGroupParams() {
      this(0);
    }

    public static PageBroadcastUpdatePageBrowsingContextGroupParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastUpdatePageBrowsingContextGroupParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastUpdatePageBrowsingContextGroupParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastUpdatePageBrowsingContextGroupParams result =
            new PageBroadcastUpdatePageBrowsingContextGroupParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.browsingContextGroupInfo = BrowsingContextGroupInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.browsingContextGroupInfo, 8, false);
    }
  }

  static final class PageBroadcastSetPageAttributionSupportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int support;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastSetPageAttributionSupportParams(int version) {
      super(16, version);
    }

    public PageBroadcastSetPageAttributionSupportParams() {
      this(0);
    }

    public static PageBroadcastSetPageAttributionSupportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastSetPageAttributionSupportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastSetPageAttributionSupportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastSetPageAttributionSupportParams result =
            new PageBroadcastSetPageAttributionSupportParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.support = readInt;
        AttributionSupport.validate(readInt);
        result.support = AttributionSupport.toKnownValue(result.support);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.support, 8);
    }
  }

  static final class PageBroadcastUpdateColorProvidersParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ColorProviderColorMaps colorProviderColors;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PageBroadcastUpdateColorProvidersParams(int version) {
      super(16, version);
    }

    public PageBroadcastUpdateColorProvidersParams() {
      this(0);
    }

    public static PageBroadcastUpdateColorProvidersParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PageBroadcastUpdateColorProvidersParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PageBroadcastUpdateColorProvidersParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PageBroadcastUpdateColorProvidersParams result =
            new PageBroadcastUpdateColorProvidersParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.colorProviderColors = ColorProviderColorMaps.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.colorProviderColors, 8, false);
    }
  }
}
