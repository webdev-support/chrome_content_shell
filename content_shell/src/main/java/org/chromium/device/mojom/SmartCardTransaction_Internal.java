package org.chromium.device.mojom;

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

class SmartCardTransaction_Internal {
  private static final int END_TRANSACTION_ORDINAL = 0;
  public static final Interface.Manager<SmartCardTransaction, SmartCardTransaction.Proxy> MANAGER =
      new Interface.Manager<SmartCardTransaction, SmartCardTransaction.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.SmartCardTransaction";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SmartCardTransaction.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SmartCardTransaction impl) {
          return new Stub(core, impl);
        }

        @Override
        public SmartCardTransaction[] buildArray(int size) {
          return new SmartCardTransaction[size];
        }
      };

  SmartCardTransaction_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SmartCardTransaction.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void endTransaction(int disposition, EndTransaction_Response callback) {
      SmartCardTransactionEndTransactionParams _message =
          new SmartCardTransactionEndTransactionParams();
      _message.disposition = disposition;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SmartCardTransactionEndTransactionResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SmartCardTransaction> {
    Stub(Core core, SmartCardTransaction impl) {
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
                SmartCardTransaction_Internal.MANAGER, messageWithHeader);
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
                getCore(), SmartCardTransaction_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SmartCardTransactionEndTransactionParams data =
                SmartCardTransactionEndTransactionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .endTransaction(
                    data.disposition,
                    new SmartCardTransactionEndTransactionResponseParamsProxyToResponder(
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

  static final class SmartCardTransactionEndTransactionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int disposition;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardTransactionEndTransactionParams(int version) {
      super(16, version);
    }

    public SmartCardTransactionEndTransactionParams() {
      this(0);
    }

    public static SmartCardTransactionEndTransactionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardTransactionEndTransactionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardTransactionEndTransactionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardTransactionEndTransactionParams result =
            new SmartCardTransactionEndTransactionParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.disposition = readInt;
        SmartCardDisposition.validate(readInt);
        result.disposition = SmartCardDisposition.toKnownValue(result.disposition);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.disposition, 8);
    }
  }

  static final class SmartCardTransactionEndTransactionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardTransactionEndTransactionResponseParams(int version) {
      super(24, version);
    }

    public SmartCardTransactionEndTransactionResponseParams() {
      this(0);
    }

    public static SmartCardTransactionEndTransactionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardTransactionEndTransactionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardTransactionEndTransactionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardTransactionEndTransactionResponseParams result =
            new SmartCardTransactionEndTransactionResponseParams(elementsOrVersion);
        result.result = SmartCardResult.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class SmartCardTransactionEndTransactionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardTransaction.EndTransaction_Response mCallback;

    SmartCardTransactionEndTransactionResponseParamsForwardToCallback(
        SmartCardTransaction.EndTransaction_Response callback) {
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
        SmartCardTransactionEndTransactionResponseParams response =
            SmartCardTransactionEndTransactionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardTransactionEndTransactionResponseParamsProxyToResponder
      implements SmartCardTransaction.EndTransaction_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardTransactionEndTransactionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardResult result) {
      SmartCardTransactionEndTransactionResponseParams _response =
          new SmartCardTransactionEndTransactionResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
