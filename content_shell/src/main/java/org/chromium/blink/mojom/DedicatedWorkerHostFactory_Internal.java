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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.CredentialsMode;
import org.chromium.network.mojom.CrossOriginEmbedderPolicy;
import org.chromium.url.mojom.Url;

class DedicatedWorkerHostFactory_Internal {
  private static final int CREATE_WORKER_HOST_AND_START_SCRIPT_LOAD_ORDINAL = 1;
  private static final int CREATE_WORKER_HOST_ORDINAL = 0;
  public static final Interface.Manager<
          DedicatedWorkerHostFactory, DedicatedWorkerHostFactory.Proxy>
      MANAGER =
          new Interface.Manager<DedicatedWorkerHostFactory, DedicatedWorkerHostFactory.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.DedicatedWorkerHostFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public DedicatedWorkerHostFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, DedicatedWorkerHostFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public DedicatedWorkerHostFactory[] buildArray(int size) {
              return new DedicatedWorkerHostFactory[size];
            }
          };

  DedicatedWorkerHostFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DedicatedWorkerHostFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createWorkerHost(
        DedicatedWorkerToken token,
        Url scriptUrl,
        InterfaceRequest<BrowserInterfaceBroker> browserInterfaceBroker,
        InterfaceRequest<DedicatedWorkerHost> host,
        CreateWorkerHost_Response callback) {
      DedicatedWorkerHostFactoryCreateWorkerHostParams _message =
          new DedicatedWorkerHostFactoryCreateWorkerHostParams();
      _message.token = token;
      _message.scriptUrl = scriptUrl;
      _message.browserInterfaceBroker = browserInterfaceBroker;
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DedicatedWorkerHostFactoryCreateWorkerHostResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void createWorkerHostAndStartScriptLoad(
        DedicatedWorkerToken token,
        Url scriptUrl,
        int credentialsMode,
        FetchClientSettingsObject outsideFetchClientSettingsObject,
        BlobUrlToken blobUrlToken,
        DedicatedWorkerHostFactoryClient client,
        boolean hasStorageAccess) {
      DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams _message =
          new DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams();
      _message.token = token;
      _message.scriptUrl = scriptUrl;
      _message.credentialsMode = credentialsMode;
      _message.outsideFetchClientSettingsObject = outsideFetchClientSettingsObject;
      _message.blobUrlToken = blobUrlToken;
      _message.client = client;
      _message.hasStorageAccess = hasStorageAccess;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<DedicatedWorkerHostFactory> {
    Stub(Core core, DedicatedWorkerHostFactory impl) {
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
                DedicatedWorkerHostFactory_Internal.MANAGER, messageWithHeader);
          case 1:
            DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams data =
                DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createWorkerHostAndStartScriptLoad(
                    data.token,
                    data.scriptUrl,
                    data.credentialsMode,
                    data.outsideFetchClientSettingsObject,
                    data.blobUrlToken,
                    data.client,
                    data.hasStorageAccess);
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
                getCore(),
                DedicatedWorkerHostFactory_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            DedicatedWorkerHostFactoryCreateWorkerHostParams data =
                DedicatedWorkerHostFactoryCreateWorkerHostParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createWorkerHost(
                    data.token,
                    data.scriptUrl,
                    data.browserInterfaceBroker,
                    data.host,
                    new DedicatedWorkerHostFactoryCreateWorkerHostResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class DedicatedWorkerHostFactoryCreateWorkerHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<BrowserInterfaceBroker> browserInterfaceBroker;
    public InterfaceRequest<DedicatedWorkerHost> host;
    public Url scriptUrl;
    public DedicatedWorkerToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DedicatedWorkerHostFactoryCreateWorkerHostParams(int version) {
      super(32, version);
    }

    public DedicatedWorkerHostFactoryCreateWorkerHostParams() {
      this(0);
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DedicatedWorkerHostFactoryCreateWorkerHostParams result =
            new DedicatedWorkerHostFactoryCreateWorkerHostParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.token = DedicatedWorkerToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.scriptUrl = Url.decode(decoder12);
        result.browserInterfaceBroker = decoder0.readInterfaceRequest(24, false);
        result.host = decoder0.readInterfaceRequest(28, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.token, 8, false);
      encoder0.encode((Struct) this.scriptUrl, 16, false);
      encoder0.encode((InterfaceRequest) this.browserInterfaceBroker, 24, false);
      encoder0.encode((InterfaceRequest) this.host, 28, false);
    }
  }

  static final class DedicatedWorkerHostFactoryCreateWorkerHostResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BackForwardCacheControllerHost backForwardCacheControllerHost;
    public CrossOriginEmbedderPolicy parentCoep;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DedicatedWorkerHostFactoryCreateWorkerHostResponseParams(int version) {
      super(24, version);
    }

    public DedicatedWorkerHostFactoryCreateWorkerHostResponseParams() {
      this(0);
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DedicatedWorkerHostFactoryCreateWorkerHostResponseParams result =
            new DedicatedWorkerHostFactoryCreateWorkerHostResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.parentCoep = CrossOriginEmbedderPolicy.decode(decoder1);
        result.backForwardCacheControllerHost =
            (BackForwardCacheControllerHost)
                decoder0.readServiceInterface(16, true, BackForwardCacheControllerHost.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.parentCoep, 8, false);
      encoder0.encode(
          this.backForwardCacheControllerHost, 16, true, BackForwardCacheControllerHost.MANAGER);
    }
  }

  static class DedicatedWorkerHostFactoryCreateWorkerHostResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DedicatedWorkerHostFactory.CreateWorkerHost_Response mCallback;

    DedicatedWorkerHostFactoryCreateWorkerHostResponseParamsForwardToCallback(
        DedicatedWorkerHostFactory.CreateWorkerHost_Response callback) {
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
        DedicatedWorkerHostFactoryCreateWorkerHostResponseParams response =
            DedicatedWorkerHostFactoryCreateWorkerHostResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.parentCoep, response.backForwardCacheControllerHost);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DedicatedWorkerHostFactoryCreateWorkerHostResponseParamsProxyToResponder
      implements DedicatedWorkerHostFactory.CreateWorkerHost_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DedicatedWorkerHostFactoryCreateWorkerHostResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        CrossOriginEmbedderPolicy parentCoep,
        BackForwardCacheControllerHost backForwardCacheControllerHost) {
      DedicatedWorkerHostFactoryCreateWorkerHostResponseParams _response =
          new DedicatedWorkerHostFactoryCreateWorkerHostResponseParams();
      _response.parentCoep = parentCoep;
      _response.backForwardCacheControllerHost = backForwardCacheControllerHost;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public BlobUrlToken blobUrlToken;
    public DedicatedWorkerHostFactoryClient client;
    public int credentialsMode;
    public boolean hasStorageAccess;
    public FetchClientSettingsObject outsideFetchClientSettingsObject;
    public Url scriptUrl;
    public DedicatedWorkerToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams(int version) {
      super(56, version);
    }

    public DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams() {
      this(0);
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams result =
            new DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.token = DedicatedWorkerToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.scriptUrl = Url.decode(decoder12);
        int readInt = decoder0.readInt(24);
        result.credentialsMode = readInt;
        CredentialsMode.validate(readInt);
        result.credentialsMode = CredentialsMode.toKnownValue(result.credentialsMode);
        result.hasStorageAccess = decoder0.readBoolean(28, 0);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.outsideFetchClientSettingsObject = FetchClientSettingsObject.decode(decoder13);
        result.blobUrlToken =
            (BlobUrlToken) decoder0.readServiceInterface(40, true, BlobUrlToken.MANAGER);
        result.client =
            (DedicatedWorkerHostFactoryClient)
                decoder0.readServiceInterface(48, false, DedicatedWorkerHostFactoryClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.token, 8, false);
      encoder0.encode((Struct) this.scriptUrl, 16, false);
      encoder0.encode(this.credentialsMode, 24);
      encoder0.encode(this.hasStorageAccess, 28, 0);
      encoder0.encode((Struct) this.outsideFetchClientSettingsObject, 32, false);
      encoder0.encode(this.blobUrlToken, 40, true, BlobUrlToken.MANAGER);
      encoder0.encode(this.client, 48, false, DedicatedWorkerHostFactoryClient.MANAGER);
    }
  }
}
