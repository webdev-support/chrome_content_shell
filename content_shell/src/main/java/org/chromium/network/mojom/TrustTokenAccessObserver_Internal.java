package org.chromium.network.mojom;

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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class TrustTokenAccessObserver_Internal {
  private static final int CLONE_ORDINAL = 1;
  public static final Interface.Manager<TrustTokenAccessObserver, TrustTokenAccessObserver.Proxy>
      MANAGER =
          new Interface.Manager<TrustTokenAccessObserver, TrustTokenAccessObserver.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.TrustTokenAccessObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public TrustTokenAccessObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, TrustTokenAccessObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public TrustTokenAccessObserver[] buildArray(int size) {
              return new TrustTokenAccessObserver[size];
            }
          };
  private static final int ON_TRUST_TOKENS_ACCESSED_ORDINAL = 0;

  TrustTokenAccessObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements TrustTokenAccessObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onTrustTokensAccessed(TrustTokenAccessDetails details) {
      TrustTokenAccessObserverOnTrustTokensAccessedParams _message =
          new TrustTokenAccessObserverOnTrustTokensAccessedParams();
      _message.details = details;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void clone(InterfaceRequest<TrustTokenAccessObserver> listener) {
      TrustTokenAccessObserverCloneParams _message = new TrustTokenAccessObserverCloneParams();
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<TrustTokenAccessObserver> {
    Stub(Core core, TrustTokenAccessObserver impl) {
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
                TrustTokenAccessObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            TrustTokenAccessObserverOnTrustTokensAccessedParams data =
                TrustTokenAccessObserverOnTrustTokensAccessedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onTrustTokensAccessed(data.details);
            return true;
          case 1:
            TrustTokenAccessObserverCloneParams data2 =
                TrustTokenAccessObserverCloneParams.deserialize(messageWithHeader.getPayload());
            getImpl().clone(data2.listener);
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
                getCore(), TrustTokenAccessObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class TrustTokenAccessObserverOnTrustTokensAccessedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public TrustTokenAccessDetails details;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustTokenAccessObserverOnTrustTokensAccessedParams(int version) {
      super(24, version);
    }

    public TrustTokenAccessObserverOnTrustTokensAccessedParams() {
      this(0);
    }

    public static TrustTokenAccessObserverOnTrustTokensAccessedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustTokenAccessObserverOnTrustTokensAccessedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustTokenAccessObserverOnTrustTokensAccessedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustTokenAccessObserverOnTrustTokensAccessedParams result =
            new TrustTokenAccessObserverOnTrustTokensAccessedParams(elementsOrVersion);
        result.details = TrustTokenAccessDetails.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.details, 8, false);
    }
  }

  static final class TrustTokenAccessObserverCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<TrustTokenAccessObserver> listener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustTokenAccessObserverCloneParams(int version) {
      super(16, version);
    }

    public TrustTokenAccessObserverCloneParams() {
      this(0);
    }

    public static TrustTokenAccessObserverCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustTokenAccessObserverCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustTokenAccessObserverCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustTokenAccessObserverCloneParams result =
            new TrustTokenAccessObserverCloneParams(elementsOrVersion);
        result.listener = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.listener, 8, false);
    }
  }
}
