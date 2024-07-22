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

class DedicatedWorkerHostFactoryClient_Internal {
  public static final Interface.Manager<
          DedicatedWorkerHostFactoryClient, DedicatedWorkerHostFactoryClient.Proxy>
      MANAGER =
          new Interface.Manager<
              DedicatedWorkerHostFactoryClient, DedicatedWorkerHostFactoryClient.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.DedicatedWorkerHostFactoryClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public DedicatedWorkerHostFactoryClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, DedicatedWorkerHostFactoryClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public DedicatedWorkerHostFactoryClient[] buildArray(int size) {
              return new DedicatedWorkerHostFactoryClient[size];
            }
          };
  private static final int ON_SCRIPT_LOAD_STARTED_ORDINAL = 1;
  private static final int ON_SCRIPT_LOAD_START_FAILED_ORDINAL = 2;
  private static final int ON_WORKER_HOST_CREATED_ORDINAL = 0;

  DedicatedWorkerHostFactoryClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DedicatedWorkerHostFactoryClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onWorkerHostCreated(
        BrowserInterfaceBroker browserInterfaceBroker, DedicatedWorkerHost host) {
      DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams _message =
          new DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams();
      _message.browserInterfaceBroker = browserInterfaceBroker;
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onScriptLoadStarted(
        ServiceWorkerContainerInfoForClient serviceWorkerContainerInfo,
        WorkerMainScriptLoadParams mainScriptLoadParams,
        UrlLoaderFactoryBundle subresourceLoaderFactories,
        InterfaceRequest<SubresourceLoaderUpdater> subresourceLoaderUpdater,
        ControllerServiceWorkerInfo controllerInfo,
        BackForwardCacheControllerHost backForwardCacheControllerHost) {
      DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams _message =
          new DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams();
      _message.serviceWorkerContainerInfo = serviceWorkerContainerInfo;
      _message.mainScriptLoadParams = mainScriptLoadParams;
      _message.subresourceLoaderFactories = subresourceLoaderFactories;
      _message.subresourceLoaderUpdater = subresourceLoaderUpdater;
      _message.controllerInfo = controllerInfo;
      _message.backForwardCacheControllerHost = backForwardCacheControllerHost;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onScriptLoadStartFailed() {
      DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams _message =
          new DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<DedicatedWorkerHostFactoryClient> {
    Stub(Core core, DedicatedWorkerHostFactoryClient impl) {
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
                DedicatedWorkerHostFactoryClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams data =
                DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onWorkerHostCreated(data.browserInterfaceBroker, data.host);
            return true;
          case 1:
            DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams data2 =
                DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onScriptLoadStarted(
                    data2.serviceWorkerContainerInfo,
                    data2.mainScriptLoadParams,
                    data2.subresourceLoaderFactories,
                    data2.subresourceLoaderUpdater,
                    data2.controllerInfo,
                    data2.backForwardCacheControllerHost);
            return true;
          case 2:
            DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onScriptLoadStartFailed();
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
                getCore(),
                DedicatedWorkerHostFactoryClient_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BrowserInterfaceBroker browserInterfaceBroker;
    public DedicatedWorkerHost host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams(int version) {
      super(24, version);
    }

    public DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams() {
      this(0);
    }

    public static DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams result =
            new DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams(elementsOrVersion);
        result.browserInterfaceBroker =
            (BrowserInterfaceBroker)
                decoder0.readServiceInterface(8, false, BrowserInterfaceBroker.MANAGER);
        result.host =
            (DedicatedWorkerHost)
                decoder0.readServiceInterface(16, false, DedicatedWorkerHost.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.browserInterfaceBroker, 8, false, BrowserInterfaceBroker.MANAGER);
      encoder0.encode(this.host, 16, false, DedicatedWorkerHost.MANAGER);
    }
  }

  static final class DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public BackForwardCacheControllerHost backForwardCacheControllerHost;
    public ControllerServiceWorkerInfo controllerInfo;
    public WorkerMainScriptLoadParams mainScriptLoadParams;
    public ServiceWorkerContainerInfoForClient serviceWorkerContainerInfo;
    public UrlLoaderFactoryBundle subresourceLoaderFactories;
    public InterfaceRequest<SubresourceLoaderUpdater> subresourceLoaderUpdater;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams(int version) {
      super(56, version);
    }

    public DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams() {
      this(0);
    }

    public static DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams result =
            new DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.serviceWorkerContainerInfo = ServiceWorkerContainerInfoForClient.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.mainScriptLoadParams = WorkerMainScriptLoadParams.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.subresourceLoaderFactories = UrlLoaderFactoryBundle.decode(decoder13);
        result.subresourceLoaderUpdater = decoder0.readInterfaceRequest(32, false);
        Decoder decoder14 = decoder0.readPointer(40, true);
        result.controllerInfo = ControllerServiceWorkerInfo.decode(decoder14);
        result.backForwardCacheControllerHost =
            (BackForwardCacheControllerHost)
                decoder0.readServiceInterface(48, false, BackForwardCacheControllerHost.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.serviceWorkerContainerInfo, 8, true);
      encoder0.encode((Struct) this.mainScriptLoadParams, 16, false);
      encoder0.encode((Struct) this.subresourceLoaderFactories, 24, false);
      encoder0.encode((InterfaceRequest) this.subresourceLoaderUpdater, 32, false);
      encoder0.encode((Struct) this.controllerInfo, 40, true);
      encoder0.encode(
          this.backForwardCacheControllerHost, 48, false, BackForwardCacheControllerHost.MANAGER);
    }
  }

  static final class DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams(int version) {
      super(8, version);
    }

    public DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams() {
      this(0);
    }

    public static DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams result =
            new DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams(elementsOrVersion);
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
}
