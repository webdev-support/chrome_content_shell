package org.chromium.network.mojom;

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
import org.chromium.mojo.system.Core;

class SimpleCacheEntryEnumerator_Internal {
  private static final int GET_NEXT_ORDINAL = 0;
  public static final Interface.Manager<
          SimpleCacheEntryEnumerator, SimpleCacheEntryEnumerator.Proxy>
      MANAGER =
          new Interface.Manager<SimpleCacheEntryEnumerator, SimpleCacheEntryEnumerator.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.SimpleCacheEntryEnumerator";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SimpleCacheEntryEnumerator.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SimpleCacheEntryEnumerator impl) {
              return new Stub(core, impl);
            }

            @Override
            public SimpleCacheEntryEnumerator[] buildArray(int size) {
              return new SimpleCacheEntryEnumerator[size];
            }
          };

  SimpleCacheEntryEnumerator_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SimpleCacheEntryEnumerator.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getNext(SimpleCacheEntryEnumerator.GetNext_Response callback) {
      SimpleCacheEntryEnumeratorGetNextParams _message =
          new SimpleCacheEntryEnumeratorGetNextParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SimpleCacheEntryEnumeratorGetNextResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SimpleCacheEntryEnumerator> {
    Stub(Core core, SimpleCacheEntryEnumerator impl) {
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
                SimpleCacheEntryEnumerator_Internal.MANAGER, messageWithHeader);
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
                SimpleCacheEntryEnumerator_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            SimpleCacheEntryEnumeratorGetNextParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getNext(
                    new SimpleCacheEntryEnumeratorGetNextResponseParamsProxyToResponder(
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

  static final class SimpleCacheEntryEnumeratorGetNextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryEnumeratorGetNextParams(int version) {
      super(8, version);
    }

    public SimpleCacheEntryEnumeratorGetNextParams() {
      this(0);
    }

    public static SimpleCacheEntryEnumeratorGetNextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryEnumeratorGetNextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryEnumeratorGetNextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryEnumeratorGetNextParams result =
            new SimpleCacheEntryEnumeratorGetNextParams(elementsOrVersion);
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

  static final class SimpleCacheEntryEnumeratorGetNextResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SimpleCacheOpenEntryResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryEnumeratorGetNextResponseParams(int version) {
      super(16, version);
    }

    public SimpleCacheEntryEnumeratorGetNextResponseParams() {
      this(0);
    }

    public static SimpleCacheEntryEnumeratorGetNextResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryEnumeratorGetNextResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryEnumeratorGetNextResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryEnumeratorGetNextResponseParams result =
            new SimpleCacheEntryEnumeratorGetNextResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = SimpleCacheOpenEntryResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static class SimpleCacheEntryEnumeratorGetNextResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SimpleCacheEntryEnumerator.GetNext_Response mCallback;

    SimpleCacheEntryEnumeratorGetNextResponseParamsForwardToCallback(
        SimpleCacheEntryEnumerator.GetNext_Response callback) {
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
        SimpleCacheEntryEnumeratorGetNextResponseParams response =
            SimpleCacheEntryEnumeratorGetNextResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheEntryEnumeratorGetNextResponseParamsProxyToResponder
      implements SimpleCacheEntryEnumerator.GetNext_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheEntryEnumeratorGetNextResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SimpleCacheOpenEntryResult result) {
      SimpleCacheEntryEnumeratorGetNextResponseParams _response =
          new SimpleCacheEntryEnumeratorGetNextResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
