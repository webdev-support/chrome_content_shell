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

class SmartCardConnection_Internal {
  private static final int BEGIN_TRANSACTION_ORDINAL = 6;
  private static final int CONTROL_ORDINAL = 2;
  private static final int DISCONNECT_ORDINAL = 0;
  private static final int GET_ATTRIB_ORDINAL = 3;
  public static final Interface.Manager<SmartCardConnection, SmartCardConnection.Proxy> MANAGER =
      new Interface.Manager<SmartCardConnection, SmartCardConnection.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.SmartCardConnection";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SmartCardConnection.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SmartCardConnection impl) {
          return new Stub(core, impl);
        }

        @Override
        public SmartCardConnection[] buildArray(int size) {
          return new SmartCardConnection[size];
        }
      };
  private static final int SET_ATTRIB_ORDINAL = 4;
  private static final int STATUS_ORDINAL = 5;
  private static final int TRANSMIT_ORDINAL = 1;

  SmartCardConnection_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SmartCardConnection.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void disconnect(int disposition, Disconnect_Response callback) {
      SmartCardConnectionDisconnectParams _message = new SmartCardConnectionDisconnectParams();
      _message.disposition = disposition;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SmartCardConnectionDisconnectResponseParamsForwardToCallback(callback));
    }

    @Override
    public void transmit(int protocol, byte[] data, Transmit_Response callback) {
      SmartCardConnectionTransmitParams _message = new SmartCardConnectionTransmitParams();
      _message.protocol = protocol;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SmartCardConnectionTransmitResponseParamsForwardToCallback(callback));
    }

    @Override
    public void control(int controlCode, byte[] data, Control_Response callback) {
      SmartCardConnectionControlParams _message = new SmartCardConnectionControlParams();
      _message.controlCode = controlCode;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new SmartCardConnectionControlResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getAttrib(int id, GetAttrib_Response callback) {
      SmartCardConnectionGetAttribParams _message = new SmartCardConnectionGetAttribParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new SmartCardConnectionGetAttribResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setAttrib(int id, byte[] data, SetAttrib_Response callback) {
      SmartCardConnectionSetAttribParams _message = new SmartCardConnectionSetAttribParams();
      _message.id = id;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new SmartCardConnectionSetAttribResponseParamsForwardToCallback(callback));
    }

    @Override
    public void status(Status_Response callback) {
      SmartCardConnectionStatusParams _message = new SmartCardConnectionStatusParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new SmartCardConnectionStatusResponseParamsForwardToCallback(callback));
    }

    @Override
    public void beginTransaction(BeginTransaction_Response callback) {
      SmartCardConnectionBeginTransactionParams _message =
          new SmartCardConnectionBeginTransactionParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new SmartCardConnectionBeginTransactionResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SmartCardConnection> {
    Stub(Core core, SmartCardConnection impl) {
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
                SmartCardConnection_Internal.MANAGER, messageWithHeader);
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
                getCore(), SmartCardConnection_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .disconnect(
                    SmartCardConnectionDisconnectParams.deserialize(messageWithHeader.getPayload())
                        .disposition,
                    new SmartCardConnectionDisconnectResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            SmartCardConnectionTransmitParams data =
                SmartCardConnectionTransmitParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .transmit(
                    data.protocol,
                    data.data,
                    new SmartCardConnectionTransmitResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            SmartCardConnectionControlParams data2 =
                SmartCardConnectionControlParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .control(
                    data2.controlCode,
                    data2.data,
                    new SmartCardConnectionControlResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            SmartCardConnectionGetAttribParams data3 =
                SmartCardConnectionGetAttribParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getAttrib(
                    data3.id,
                    new SmartCardConnectionGetAttribResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            SmartCardConnectionSetAttribParams data4 =
                SmartCardConnectionSetAttribParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setAttrib(
                    data4.id,
                    data4.data,
                    new SmartCardConnectionSetAttribResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            SmartCardConnectionStatusParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .status(
                    new SmartCardConnectionStatusResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            SmartCardConnectionBeginTransactionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .beginTransaction(
                    new SmartCardConnectionBeginTransactionResponseParamsProxyToResponder(
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

  static final class SmartCardConnectionDisconnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int disposition;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionDisconnectParams(int version) {
      super(16, version);
    }

    public SmartCardConnectionDisconnectParams() {
      this(0);
    }

    public static SmartCardConnectionDisconnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionDisconnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionDisconnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionDisconnectParams result =
            new SmartCardConnectionDisconnectParams(elementsOrVersion);
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

  static final class SmartCardConnectionDisconnectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionDisconnectResponseParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionDisconnectResponseParams() {
      this(0);
    }

    public static SmartCardConnectionDisconnectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionDisconnectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionDisconnectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionDisconnectResponseParams result =
            new SmartCardConnectionDisconnectResponseParams(elementsOrVersion);
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

  static class SmartCardConnectionDisconnectResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardConnection.Disconnect_Response mCallback;

    SmartCardConnectionDisconnectResponseParamsForwardToCallback(
        SmartCardConnection.Disconnect_Response callback) {
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
        SmartCardConnectionDisconnectResponseParams response =
            SmartCardConnectionDisconnectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardConnectionDisconnectResponseParamsProxyToResponder
      implements SmartCardConnection.Disconnect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardConnectionDisconnectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardResult result) {
      SmartCardConnectionDisconnectResponseParams _response =
          new SmartCardConnectionDisconnectResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardConnectionTransmitParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;
    public int protocol;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionTransmitParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionTransmitParams() {
      this(0);
    }

    public static SmartCardConnectionTransmitParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionTransmitParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionTransmitParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionTransmitParams result =
            new SmartCardConnectionTransmitParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.protocol = readInt;
        SmartCardProtocol.validate(readInt);
        result.protocol = SmartCardProtocol.toKnownValue(result.protocol);
        result.data = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.protocol, 8);
      encoder0.encode(this.data, 16, 0, -1);
    }
  }

  static final class SmartCardConnectionTransmitResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardDataResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionTransmitResponseParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionTransmitResponseParams() {
      this(0);
    }

    public static SmartCardConnectionTransmitResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionTransmitResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionTransmitResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionTransmitResponseParams result =
            new SmartCardConnectionTransmitResponseParams(elementsOrVersion);
        result.result = SmartCardDataResult.decode(decoder0, 8);
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

  static class SmartCardConnectionTransmitResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardConnection.Transmit_Response mCallback;

    SmartCardConnectionTransmitResponseParamsForwardToCallback(
        SmartCardConnection.Transmit_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        SmartCardConnectionTransmitResponseParams response =
            SmartCardConnectionTransmitResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardConnectionTransmitResponseParamsProxyToResponder
      implements SmartCardConnection.Transmit_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardConnectionTransmitResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardDataResult result) {
      SmartCardConnectionTransmitResponseParams _response =
          new SmartCardConnectionTransmitResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardConnectionControlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int controlCode;
    public byte[] data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionControlParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionControlParams() {
      this(0);
    }

    public static SmartCardConnectionControlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionControlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionControlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionControlParams result =
            new SmartCardConnectionControlParams(elementsOrVersion);
        result.controlCode = decoder0.readInt(8);
        result.data = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.controlCode, 8);
      encoder0.encode(this.data, 16, 0, -1);
    }
  }

  static final class SmartCardConnectionControlResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardDataResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionControlResponseParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionControlResponseParams() {
      this(0);
    }

    public static SmartCardConnectionControlResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionControlResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionControlResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionControlResponseParams result =
            new SmartCardConnectionControlResponseParams(elementsOrVersion);
        result.result = SmartCardDataResult.decode(decoder0, 8);
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

  static class SmartCardConnectionControlResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardConnection.Control_Response mCallback;

    SmartCardConnectionControlResponseParamsForwardToCallback(
        SmartCardConnection.Control_Response callback) {
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
        SmartCardConnectionControlResponseParams response =
            SmartCardConnectionControlResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardConnectionControlResponseParamsProxyToResponder
      implements SmartCardConnection.Control_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardConnectionControlResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardDataResult result) {
      SmartCardConnectionControlResponseParams _response =
          new SmartCardConnectionControlResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardConnectionGetAttribParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionGetAttribParams(int version) {
      super(16, version);
    }

    public SmartCardConnectionGetAttribParams() {
      this(0);
    }

    public static SmartCardConnectionGetAttribParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionGetAttribParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionGetAttribParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionGetAttribParams result =
            new SmartCardConnectionGetAttribParams(elementsOrVersion);
        result.id = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8);
    }
  }

  static final class SmartCardConnectionGetAttribResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardDataResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionGetAttribResponseParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionGetAttribResponseParams() {
      this(0);
    }

    public static SmartCardConnectionGetAttribResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionGetAttribResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionGetAttribResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionGetAttribResponseParams result =
            new SmartCardConnectionGetAttribResponseParams(elementsOrVersion);
        result.result = SmartCardDataResult.decode(decoder0, 8);
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

  static class SmartCardConnectionGetAttribResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardConnection.GetAttrib_Response mCallback;

    SmartCardConnectionGetAttribResponseParamsForwardToCallback(
        SmartCardConnection.GetAttrib_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        SmartCardConnectionGetAttribResponseParams response =
            SmartCardConnectionGetAttribResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardConnectionGetAttribResponseParamsProxyToResponder
      implements SmartCardConnection.GetAttrib_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardConnectionGetAttribResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardDataResult result) {
      SmartCardConnectionGetAttribResponseParams _response =
          new SmartCardConnectionGetAttribResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardConnectionSetAttribParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;
    public int id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionSetAttribParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionSetAttribParams() {
      this(0);
    }

    public static SmartCardConnectionSetAttribParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionSetAttribParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionSetAttribParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionSetAttribParams result =
            new SmartCardConnectionSetAttribParams(elementsOrVersion);
        result.id = decoder0.readInt(8);
        result.data = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8);
      encoder0.encode(this.data, 16, 0, -1);
    }
  }

  static final class SmartCardConnectionSetAttribResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionSetAttribResponseParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionSetAttribResponseParams() {
      this(0);
    }

    public static SmartCardConnectionSetAttribResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionSetAttribResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionSetAttribResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionSetAttribResponseParams result =
            new SmartCardConnectionSetAttribResponseParams(elementsOrVersion);
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

  static class SmartCardConnectionSetAttribResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardConnection.SetAttrib_Response mCallback;

    SmartCardConnectionSetAttribResponseParamsForwardToCallback(
        SmartCardConnection.SetAttrib_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        SmartCardConnectionSetAttribResponseParams response =
            SmartCardConnectionSetAttribResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardConnectionSetAttribResponseParamsProxyToResponder
      implements SmartCardConnection.SetAttrib_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardConnectionSetAttribResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardResult result) {
      SmartCardConnectionSetAttribResponseParams _response =
          new SmartCardConnectionSetAttribResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardConnectionStatusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionStatusParams(int version) {
      super(8, version);
    }

    public SmartCardConnectionStatusParams() {
      this(0);
    }

    public static SmartCardConnectionStatusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionStatusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionStatusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionStatusParams result =
            new SmartCardConnectionStatusParams(elementsOrVersion);
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

  static final class SmartCardConnectionStatusResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardStatusResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionStatusResponseParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionStatusResponseParams() {
      this(0);
    }

    public static SmartCardConnectionStatusResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionStatusResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionStatusResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionStatusResponseParams result =
            new SmartCardConnectionStatusResponseParams(elementsOrVersion);
        result.result = SmartCardStatusResult.decode(decoder0, 8);
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

  static class SmartCardConnectionStatusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardConnection.Status_Response mCallback;

    SmartCardConnectionStatusResponseParamsForwardToCallback(
        SmartCardConnection.Status_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        SmartCardConnectionStatusResponseParams response =
            SmartCardConnectionStatusResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardConnectionStatusResponseParamsProxyToResponder
      implements SmartCardConnection.Status_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardConnectionStatusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardStatusResult result) {
      SmartCardConnectionStatusResponseParams _response =
          new SmartCardConnectionStatusResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardConnectionBeginTransactionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionBeginTransactionParams(int version) {
      super(8, version);
    }

    public SmartCardConnectionBeginTransactionParams() {
      this(0);
    }

    public static SmartCardConnectionBeginTransactionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionBeginTransactionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionBeginTransactionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionBeginTransactionParams result =
            new SmartCardConnectionBeginTransactionParams(elementsOrVersion);
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

  static final class SmartCardConnectionBeginTransactionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardTransactionResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardConnectionBeginTransactionResponseParams(int version) {
      super(24, version);
    }

    public SmartCardConnectionBeginTransactionResponseParams() {
      this(0);
    }

    public static SmartCardConnectionBeginTransactionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardConnectionBeginTransactionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardConnectionBeginTransactionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardConnectionBeginTransactionResponseParams result =
            new SmartCardConnectionBeginTransactionResponseParams(elementsOrVersion);
        result.result = SmartCardTransactionResult.decode(decoder0, 8);
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

  static class SmartCardConnectionBeginTransactionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardConnection.BeginTransaction_Response mCallback;

    SmartCardConnectionBeginTransactionResponseParamsForwardToCallback(
        SmartCardConnection.BeginTransaction_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        SmartCardConnectionBeginTransactionResponseParams response =
            SmartCardConnectionBeginTransactionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardConnectionBeginTransactionResponseParamsProxyToResponder
      implements SmartCardConnection.BeginTransaction_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardConnectionBeginTransactionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardTransactionResult result) {
      SmartCardConnectionBeginTransactionResponseParams _response =
          new SmartCardConnectionBeginTransactionResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
