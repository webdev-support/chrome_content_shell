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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.url.internal.mojom.Origin;

class AcceptChFrameObserver_Internal {
  private static final int CLONE_ORDINAL = 1;
  public static final Interface.Manager<AcceptChFrameObserver, AcceptChFrameObserver.Proxy>
      MANAGER =
          new Interface.Manager<AcceptChFrameObserver, AcceptChFrameObserver.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.AcceptCHFrameObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AcceptChFrameObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AcceptChFrameObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public AcceptChFrameObserver[] buildArray(int size) {
              return new AcceptChFrameObserver[size];
            }
          };
  private static final int ON_ACCEPT_CH_FRAME_RECEIVED_ORDINAL = 0;

  AcceptChFrameObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AcceptChFrameObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onAcceptChFrameReceived(
        Origin origin,
        int[] acceptChFrame,
        AcceptChFrameObserver.OnAcceptChFrameReceived_Response callback) {
      AcceptChFrameObserverOnAcceptChFrameReceivedParams _message =
          new AcceptChFrameObserverOnAcceptChFrameReceivedParams();
      _message.origin = origin;
      _message.acceptChFrame = acceptChFrame;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clone(InterfaceRequest<AcceptChFrameObserver> listener) {
      AcceptChFrameObserverCloneParams _message = new AcceptChFrameObserverCloneParams();
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<AcceptChFrameObserver> {
    Stub(Core core, AcceptChFrameObserver impl) {
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
                AcceptChFrameObserver_Internal.MANAGER, messageWithHeader);
          case 1:
            AcceptChFrameObserverCloneParams data =
                AcceptChFrameObserverCloneParams.deserialize(messageWithHeader.getPayload());
            getImpl().clone(data.listener);
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
                getCore(), AcceptChFrameObserver_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            AcceptChFrameObserverOnAcceptChFrameReceivedParams data =
                AcceptChFrameObserverOnAcceptChFrameReceivedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onAcceptChFrameReceived(
                    data.origin,
                    data.acceptChFrame,
                    new AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsProxyToResponder(
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

  static final class AcceptChFrameObserverOnAcceptChFrameReceivedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] acceptChFrame;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AcceptChFrameObserverOnAcceptChFrameReceivedParams(int version) {
      super(24, version);
    }

    public AcceptChFrameObserverOnAcceptChFrameReceivedParams() {
      this(0);
    }

    public static AcceptChFrameObserverOnAcceptChFrameReceivedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AcceptChFrameObserverOnAcceptChFrameReceivedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AcceptChFrameObserverOnAcceptChFrameReceivedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AcceptChFrameObserverOnAcceptChFrameReceivedParams result =
            new AcceptChFrameObserverOnAcceptChFrameReceivedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        result.acceptChFrame = decoder0.readInts(16, 0, -1);
        int i1 = 0;
        while (true) {
          int[] iArr = result.acceptChFrame;
          if (i1 < iArr.length) {
            WebClientHintsType.validate(iArr[i1]);
            i1++;
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
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode(this.acceptChFrame, 16, 0, -1);
    }
  }

  static final class AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams(int version) {
      super(16, version);
    }

    public AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams() {
      this(0);
    }

    public static AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams result =
            new AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams(elementsOrVersion);
        result.status = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
    }
  }

  static class AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AcceptChFrameObserver.OnAcceptChFrameReceived_Response mCallback;

    AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsForwardToCallback(
        AcceptChFrameObserver.OnAcceptChFrameReceived_Response callback) {
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
        AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams response =
            AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsProxyToResponder
      implements AcceptChFrameObserver.OnAcceptChFrameReceived_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams _response =
          new AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AcceptChFrameObserverCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AcceptChFrameObserver> listener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AcceptChFrameObserverCloneParams(int version) {
      super(16, version);
    }

    public AcceptChFrameObserverCloneParams() {
      this(0);
    }

    public static AcceptChFrameObserverCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AcceptChFrameObserverCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AcceptChFrameObserverCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AcceptChFrameObserverCloneParams result =
            new AcceptChFrameObserverCloneParams(elementsOrVersion);
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
