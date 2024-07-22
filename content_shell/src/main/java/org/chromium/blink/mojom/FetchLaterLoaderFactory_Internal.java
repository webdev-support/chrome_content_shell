package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.MutableNetworkTrafficAnnotationTag;
import org.chromium.network.mojom.UrlRequest;

class FetchLaterLoaderFactory_Internal {
  private static final int CLONE_ORDINAL = 1;
  private static final int CREATE_LOADER_ORDINAL = 0;
  public static final Interface.Manager<FetchLaterLoaderFactory, FetchLaterLoaderFactory.Proxy>
      MANAGER =
          new Interface.Manager<FetchLaterLoaderFactory, FetchLaterLoaderFactory.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FetchLaterLoaderFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FetchLaterLoaderFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FetchLaterLoaderFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public FetchLaterLoaderFactory[] buildArray(int size) {
              return new FetchLaterLoaderFactory[size];
            }
          };

  FetchLaterLoaderFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FetchLaterLoaderFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createLoader(
        AssociatedInterfaceRequestNotSupported loader,
        int requestId,
        int options,
        UrlRequest request,
        MutableNetworkTrafficAnnotationTag trafficAnnotation) {
      FetchLaterLoaderFactoryCreateLoaderParams _message =
          new FetchLaterLoaderFactoryCreateLoaderParams();
      _message.loader = loader;
      _message.requestId = requestId;
      _message.options = options;
      _message.request = request;
      _message.trafficAnnotation = trafficAnnotation;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void clone(AssociatedInterfaceRequestNotSupported factory) {
      FetchLaterLoaderFactoryCloneParams _message = new FetchLaterLoaderFactoryCloneParams();
      _message.factory = factory;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<FetchLaterLoaderFactory> {
    Stub(Core core, FetchLaterLoaderFactory impl) {
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
                FetchLaterLoaderFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FetchLaterLoaderFactoryCreateLoaderParams data =
                FetchLaterLoaderFactoryCreateLoaderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createLoader(
                    data.loader,
                    data.requestId,
                    data.options,
                    data.request,
                    data.trafficAnnotation);
            return true;
          case 1:
            getImpl()
                .clone(
                    FetchLaterLoaderFactoryCloneParams.deserialize(messageWithHeader.getPayload())
                        .factory);
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
                getCore(), FetchLaterLoaderFactory_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FetchLaterLoaderFactoryCreateLoaderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceRequestNotSupported loader;
    public int options;
    public UrlRequest request;
    public int requestId;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FetchLaterLoaderFactoryCreateLoaderParams(int version) {
      super(40, version);
    }

    public FetchLaterLoaderFactoryCreateLoaderParams() {
      this(0);
    }

    public static FetchLaterLoaderFactoryCreateLoaderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FetchLaterLoaderFactoryCreateLoaderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FetchLaterLoaderFactoryCreateLoaderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FetchLaterLoaderFactoryCreateLoaderParams result =
            new FetchLaterLoaderFactoryCreateLoaderParams(elementsOrVersion);
        result.loader = decoder0.readAssociatedInterfaceRequestNotSupported(8, false);
        result.requestId = decoder0.readInt(12);
        result.options = decoder0.readInt(16);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.request = UrlRequest.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.loader, 8, false);
      encoder0.encode(this.requestId, 12);
      encoder0.encode(this.options, 16);
      encoder0.encode((Struct) this.request, 24, false);
      encoder0.encode((Struct) this.trafficAnnotation, 32, false);
    }
  }

  static final class FetchLaterLoaderFactoryCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceRequestNotSupported factory;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FetchLaterLoaderFactoryCloneParams(int version) {
      super(16, version);
    }

    public FetchLaterLoaderFactoryCloneParams() {
      this(0);
    }

    public static FetchLaterLoaderFactoryCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FetchLaterLoaderFactoryCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FetchLaterLoaderFactoryCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FetchLaterLoaderFactoryCloneParams result =
            new FetchLaterLoaderFactoryCloneParams(elementsOrVersion);
        result.factory = decoder0.readAssociatedInterfaceRequestNotSupported(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.factory, 8, false);
    }
  }
}
