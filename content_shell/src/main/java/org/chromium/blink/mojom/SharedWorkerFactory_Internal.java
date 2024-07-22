package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class SharedWorkerFactory_Internal {
  private static final int CREATE_SHARED_WORKER_ORDINAL = 0;
  public static final Interface.Manager<SharedWorkerFactory, SharedWorkerFactory.Proxy> MANAGER =
      new Interface.Manager<SharedWorkerFactory, SharedWorkerFactory.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.SharedWorkerFactory";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SharedWorkerFactory.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SharedWorkerFactory impl) {
          return new Stub(core, impl);
        }

        @Override
        public SharedWorkerFactory[] buildArray(int size) {
          return new SharedWorkerFactory[size];
        }
      };

  SharedWorkerFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SharedWorkerFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createSharedWorker(
        SharedWorkerInfo info,
        SharedWorkerToken token,
        StorageKey constructorKey,
        boolean isConstructorSecureContext,
        String userAgent,
        UserAgentMetadata uaMetadata,
        boolean pauseOnStart,
        UnguessableToken devtoolsWorkerToken,
        RendererPreferences rendererPreferences,
        InterfaceRequest<RendererPreferenceWatcher> preferenceWatcherReceiver,
        WorkerContentSettingsProxy contentSettings,
        ServiceWorkerContainerInfoForClient serviceWorkerContainerInfo,
        WorkerMainScriptLoadParams mainScriptLoadParams,
        UrlLoaderFactoryBundle subresourceLoaderFactories,
        ControllerServiceWorkerInfo controllerInfo,
        PolicyContainer policyContainer,
        SharedWorkerHost host,
        InterfaceRequest<SharedWorker> sharedWorker,
        BrowserInterfaceBroker browserInterfaceBroker,
        long ukmSourceId,
        boolean requireCrossSiteRequestForCookies) {
      SharedWorkerFactoryCreateSharedWorkerParams _message =
          new SharedWorkerFactoryCreateSharedWorkerParams();
      _message.info = info;
      _message.token = token;
      _message.constructorKey = constructorKey;
      _message.isConstructorSecureContext = isConstructorSecureContext;
      _message.userAgent = userAgent;
      _message.uaMetadata = uaMetadata;
      _message.pauseOnStart = pauseOnStart;
      _message.devtoolsWorkerToken = devtoolsWorkerToken;
      _message.rendererPreferences = rendererPreferences;
      _message.preferenceWatcherReceiver = preferenceWatcherReceiver;
      _message.contentSettings = contentSettings;
      _message.serviceWorkerContainerInfo = serviceWorkerContainerInfo;
      _message.mainScriptLoadParams = mainScriptLoadParams;
      _message.subresourceLoaderFactories = subresourceLoaderFactories;
      _message.controllerInfo = controllerInfo;
      _message.policyContainer = policyContainer;
      _message.host = host;
      _message.sharedWorker = sharedWorker;
      _message.browserInterfaceBroker = browserInterfaceBroker;
      _message.ukmSourceId = ukmSourceId;
      _message.requireCrossSiteRequestForCookies = requireCrossSiteRequestForCookies;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<SharedWorkerFactory> {
    Stub(Core core, SharedWorkerFactory impl) {
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
                SharedWorkerFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SharedWorkerFactoryCreateSharedWorkerParams data =
                SharedWorkerFactoryCreateSharedWorkerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createSharedWorker(
                    data.info,
                    data.token,
                    data.constructorKey,
                    data.isConstructorSecureContext,
                    data.userAgent,
                    data.uaMetadata,
                    data.pauseOnStart,
                    data.devtoolsWorkerToken,
                    data.rendererPreferences,
                    data.preferenceWatcherReceiver,
                    data.contentSettings,
                    data.serviceWorkerContainerInfo,
                    data.mainScriptLoadParams,
                    data.subresourceLoaderFactories,
                    data.controllerInfo,
                    data.policyContainer,
                    data.host,
                    data.sharedWorker,
                    data.browserInterfaceBroker,
                    data.ukmSourceId,
                    data.requireCrossSiteRequestForCookies);
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
                getCore(), SharedWorkerFactory_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SharedWorkerFactoryCreateSharedWorkerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 152;
    private static final DataHeader[] VERSION_ARRAY;
    public BrowserInterfaceBroker browserInterfaceBroker;
    public StorageKey constructorKey;
    public WorkerContentSettingsProxy contentSettings;
    public ControllerServiceWorkerInfo controllerInfo;
    public UnguessableToken devtoolsWorkerToken;
    public SharedWorkerHost host;
    public SharedWorkerInfo info;
    public boolean isConstructorSecureContext;
    public WorkerMainScriptLoadParams mainScriptLoadParams;
    public boolean pauseOnStart;
    public PolicyContainer policyContainer;
    public InterfaceRequest<RendererPreferenceWatcher> preferenceWatcherReceiver;
    public RendererPreferences rendererPreferences;
    public boolean requireCrossSiteRequestForCookies;
    public ServiceWorkerContainerInfoForClient serviceWorkerContainerInfo;
    public InterfaceRequest<SharedWorker> sharedWorker;
    public UrlLoaderFactoryBundle subresourceLoaderFactories;
    public SharedWorkerToken token;
    public UserAgentMetadata uaMetadata;
    public long ukmSourceId;
    public String userAgent;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(152, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerFactoryCreateSharedWorkerParams(int version) {
      super(152, version);
    }

    public SharedWorkerFactoryCreateSharedWorkerParams() {
      this(0);
    }

    public static SharedWorkerFactoryCreateSharedWorkerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerFactoryCreateSharedWorkerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerFactoryCreateSharedWorkerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerFactoryCreateSharedWorkerParams result =
            new SharedWorkerFactoryCreateSharedWorkerParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.info = SharedWorkerInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.token = SharedWorkerToken.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.constructorKey = StorageKey.decode(decoder13);
        result.isConstructorSecureContext = decoder0.readBoolean(32, 0);
        result.pauseOnStart = decoder0.readBoolean(32, 1);
        result.requireCrossSiteRequestForCookies = decoder0.readBoolean(32, 2);
        result.preferenceWatcherReceiver = decoder0.readInterfaceRequest(36, false);
        result.userAgent = decoder0.readString(40, false);
        Decoder decoder14 = decoder0.readPointer(48, false);
        result.uaMetadata = UserAgentMetadata.decode(decoder14);
        Decoder decoder15 = decoder0.readPointer(56, false);
        result.devtoolsWorkerToken = UnguessableToken.decode(decoder15);
        Decoder decoder16 = decoder0.readPointer(64, false);
        result.rendererPreferences = RendererPreferences.decode(decoder16);
        result.contentSettings =
            (WorkerContentSettingsProxy)
                decoder0.readServiceInterface(72, false, WorkerContentSettingsProxy.MANAGER);
        Decoder decoder17 = decoder0.readPointer(80, true);
        result.serviceWorkerContainerInfo = ServiceWorkerContainerInfoForClient.decode(decoder17);
        Decoder decoder18 = decoder0.readPointer(88, false);
        result.mainScriptLoadParams = WorkerMainScriptLoadParams.decode(decoder18);
        Decoder decoder19 = decoder0.readPointer(96, false);
        result.subresourceLoaderFactories = UrlLoaderFactoryBundle.decode(decoder19);
        Decoder decoder110 = decoder0.readPointer(104, true);
        result.controllerInfo = ControllerServiceWorkerInfo.decode(decoder110);
        Decoder decoder111 = decoder0.readPointer(112, false);
        result.policyContainer = PolicyContainer.decode(decoder111);
        result.host =
            (SharedWorkerHost) decoder0.readServiceInterface(120, false, SharedWorkerHost.MANAGER);
        result.sharedWorker = decoder0.readInterfaceRequest(128, false);
        result.browserInterfaceBroker =
            (BrowserInterfaceBroker)
                decoder0.readServiceInterface(132, false, BrowserInterfaceBroker.MANAGER);
        result.ukmSourceId = decoder0.readLong(144);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.info, 8, false);
      encoder0.encode((Struct) this.token, 16, false);
      encoder0.encode((Struct) this.constructorKey, 24, false);
      encoder0.encode(this.isConstructorSecureContext, 32, 0);
      encoder0.encode(this.pauseOnStart, 32, 1);
      encoder0.encode(this.requireCrossSiteRequestForCookies, 32, 2);
      encoder0.encode((InterfaceRequest) this.preferenceWatcherReceiver, 36, false);
      encoder0.encode(this.userAgent, 40, false);
      encoder0.encode((Struct) this.uaMetadata, 48, false);
      encoder0.encode((Struct) this.devtoolsWorkerToken, 56, false);
      encoder0.encode((Struct) this.rendererPreferences, 64, false);
      encoder0.encode(this.contentSettings, 72, false, WorkerContentSettingsProxy.MANAGER);
      encoder0.encode((Struct) this.serviceWorkerContainerInfo, 80, true);
      encoder0.encode((Struct) this.mainScriptLoadParams, 88, false);
      encoder0.encode((Struct) this.subresourceLoaderFactories, 96, false);
      encoder0.encode((Struct) this.controllerInfo, 104, true);
      encoder0.encode((Struct) this.policyContainer, 112, false);
      encoder0.encode(this.host, 120, false, SharedWorkerHost.MANAGER);
      encoder0.encode((InterfaceRequest) this.sharedWorker, 128, false);
      encoder0.encode(this.browserInterfaceBroker, 132, false, BrowserInterfaceBroker.MANAGER);
      encoder0.encode(this.ukmSourceId, 144);
    }
  }
}
