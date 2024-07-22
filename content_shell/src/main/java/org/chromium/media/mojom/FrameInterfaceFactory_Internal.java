package org.chromium.media.mojom;

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
import org.chromium.mojo_base.mojom.GenericPendingReceiver;
import org.chromium.url.internal.mojom.Origin;

class FrameInterfaceFactory_Internal {
  private static final int BIND_EMBEDDER_RECEIVER_ORDINAL = 3;
  private static final int CREATE_CDM_STORAGE_ORDINAL = 1;
  private static final int CREATE_PROVISION_FETCHER_ORDINAL = 0;
  private static final int GET_CDM_ORIGIN_ORDINAL = 2;
  public static final Interface.Manager<FrameInterfaceFactory, FrameInterfaceFactory.Proxy>
      MANAGER =
          new Interface.Manager<FrameInterfaceFactory, FrameInterfaceFactory.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.FrameInterfaceFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FrameInterfaceFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FrameInterfaceFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public FrameInterfaceFactory[] buildArray(int size) {
              return new FrameInterfaceFactory[size];
            }
          };

  FrameInterfaceFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FrameInterfaceFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createProvisionFetcher(InterfaceRequest<ProvisionFetcher> provisionFetcher) {
      FrameInterfaceFactoryCreateProvisionFetcherParams _message =
          new FrameInterfaceFactoryCreateProvisionFetcherParams();
      _message.provisionFetcher = provisionFetcher;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void createCdmStorage(InterfaceRequest<CdmStorage> cdmStorage) {
      FrameInterfaceFactoryCreateCdmStorageParams _message =
          new FrameInterfaceFactoryCreateCdmStorageParams();
      _message.cdmStorage = cdmStorage;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void getCdmOrigin(GetCdmOrigin_Response callback) {
      FrameInterfaceFactoryGetCdmOriginParams _message =
          new FrameInterfaceFactoryGetCdmOriginParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new FrameInterfaceFactoryGetCdmOriginResponseParamsForwardToCallback(callback));
    }

    @Override
    public void bindEmbedderReceiver(GenericPendingReceiver receiver) {
      FrameInterfaceFactoryBindEmbedderReceiverParams _message =
          new FrameInterfaceFactoryBindEmbedderReceiverParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<FrameInterfaceFactory> {
    Stub(Core core, FrameInterfaceFactory impl) {
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
                FrameInterfaceFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          case 2:
          default:
            return false;
          case 0:
            FrameInterfaceFactoryCreateProvisionFetcherParams data =
                FrameInterfaceFactoryCreateProvisionFetcherParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createProvisionFetcher(data.provisionFetcher);
            return true;
          case 1:
            FrameInterfaceFactoryCreateCdmStorageParams data2 =
                FrameInterfaceFactoryCreateCdmStorageParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createCdmStorage(data2.cdmStorage);
            return true;
          case 3:
            FrameInterfaceFactoryBindEmbedderReceiverParams data3 =
                FrameInterfaceFactoryBindEmbedderReceiverParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().bindEmbedderReceiver(data3.receiver);
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
                getCore(), FrameInterfaceFactory_Internal.MANAGER, messageWithHeader, receiver);
          case 2:
            FrameInterfaceFactoryGetCdmOriginParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getCdmOrigin(
                    new FrameInterfaceFactoryGetCdmOriginResponseParamsProxyToResponder(
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

  static final class FrameInterfaceFactoryCreateProvisionFetcherParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<ProvisionFetcher> provisionFetcher;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameInterfaceFactoryCreateProvisionFetcherParams(int version) {
      super(16, version);
    }

    public FrameInterfaceFactoryCreateProvisionFetcherParams() {
      this(0);
    }

    public static FrameInterfaceFactoryCreateProvisionFetcherParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameInterfaceFactoryCreateProvisionFetcherParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameInterfaceFactoryCreateProvisionFetcherParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameInterfaceFactoryCreateProvisionFetcherParams result =
            new FrameInterfaceFactoryCreateProvisionFetcherParams(elementsOrVersion);
        result.provisionFetcher = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.provisionFetcher, 8, false);
    }
  }

  static final class FrameInterfaceFactoryCreateCdmStorageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<CdmStorage> cdmStorage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameInterfaceFactoryCreateCdmStorageParams(int version) {
      super(16, version);
    }

    public FrameInterfaceFactoryCreateCdmStorageParams() {
      this(0);
    }

    public static FrameInterfaceFactoryCreateCdmStorageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameInterfaceFactoryCreateCdmStorageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameInterfaceFactoryCreateCdmStorageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameInterfaceFactoryCreateCdmStorageParams result =
            new FrameInterfaceFactoryCreateCdmStorageParams(elementsOrVersion);
        result.cdmStorage = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.cdmStorage, 8, false);
    }
  }

  static final class FrameInterfaceFactoryGetCdmOriginParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameInterfaceFactoryGetCdmOriginParams(int version) {
      super(8, version);
    }

    public FrameInterfaceFactoryGetCdmOriginParams() {
      this(0);
    }

    public static FrameInterfaceFactoryGetCdmOriginParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameInterfaceFactoryGetCdmOriginParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameInterfaceFactoryGetCdmOriginParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameInterfaceFactoryGetCdmOriginParams result =
            new FrameInterfaceFactoryGetCdmOriginParams(elementsOrVersion);
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

  static final class FrameInterfaceFactoryGetCdmOriginResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin cdmOrigin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameInterfaceFactoryGetCdmOriginResponseParams(int version) {
      super(16, version);
    }

    public FrameInterfaceFactoryGetCdmOriginResponseParams() {
      this(0);
    }

    public static FrameInterfaceFactoryGetCdmOriginResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameInterfaceFactoryGetCdmOriginResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameInterfaceFactoryGetCdmOriginResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameInterfaceFactoryGetCdmOriginResponseParams result =
            new FrameInterfaceFactoryGetCdmOriginResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cdmOrigin = Origin.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cdmOrigin, 8, false);
    }
  }

  static class FrameInterfaceFactoryGetCdmOriginResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FrameInterfaceFactory.GetCdmOrigin_Response mCallback;

    FrameInterfaceFactoryGetCdmOriginResponseParamsForwardToCallback(
        FrameInterfaceFactory.GetCdmOrigin_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 6)) {
          return false;
        }
        FrameInterfaceFactoryGetCdmOriginResponseParams response =
            FrameInterfaceFactoryGetCdmOriginResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.cdmOrigin);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FrameInterfaceFactoryGetCdmOriginResponseParamsProxyToResponder
      implements FrameInterfaceFactory.GetCdmOrigin_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FrameInterfaceFactoryGetCdmOriginResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Origin cdmOrigin) {
      FrameInterfaceFactoryGetCdmOriginResponseParams _response =
          new FrameInterfaceFactoryGetCdmOriginResponseParams();
      _response.cdmOrigin = cdmOrigin;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FrameInterfaceFactoryBindEmbedderReceiverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public GenericPendingReceiver receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameInterfaceFactoryBindEmbedderReceiverParams(int version) {
      super(16, version);
    }

    public FrameInterfaceFactoryBindEmbedderReceiverParams() {
      this(0);
    }

    public static FrameInterfaceFactoryBindEmbedderReceiverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameInterfaceFactoryBindEmbedderReceiverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameInterfaceFactoryBindEmbedderReceiverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameInterfaceFactoryBindEmbedderReceiverParams result =
            new FrameInterfaceFactoryBindEmbedderReceiverParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.receiver = GenericPendingReceiver.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.receiver, 8, false);
    }
  }
}
