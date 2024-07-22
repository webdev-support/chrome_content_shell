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
import org.chromium.mojo_base.mojom.TimeDelta;

class SmartCardContext_Internal {
  private static final int CANCEL_ORDINAL = 2;
  private static final int CONNECT_ORDINAL = 3;
  private static final int GET_STATUS_CHANGE_ORDINAL = 1;
  private static final int LIST_READERS_ORDINAL = 0;
  public static final Interface.Manager<SmartCardContext, SmartCardContext.Proxy> MANAGER =
      new Interface.Manager<SmartCardContext, SmartCardContext.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.SmartCardContext";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SmartCardContext.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SmartCardContext impl) {
          return new Stub(core, impl);
        }

        @Override
        public SmartCardContext[] buildArray(int size) {
          return new SmartCardContext[size];
        }
      };

  SmartCardContext_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SmartCardContext.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void listReaders(ListReaders_Response callback) {
      SmartCardContextListReadersParams _message = new SmartCardContextListReadersParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SmartCardContextListReadersResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getStatusChange(
        TimeDelta timeout,
        SmartCardReaderStateIn[] readerStates,
        GetStatusChange_Response callback) {
      SmartCardContextGetStatusChangeParams _message = new SmartCardContextGetStatusChangeParams();
      _message.timeout = timeout;
      _message.readerStates = readerStates;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SmartCardContextGetStatusChangeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void cancel(Cancel_Response callback) {
      SmartCardContextCancelParams _message = new SmartCardContextCancelParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new SmartCardContextCancelResponseParamsForwardToCallback(callback));
    }

    @Override
    public void connect(
        String reader,
        int shareMode,
        SmartCardProtocols preferredProtocols,
        Connect_Response callback) {
      SmartCardContextConnectParams _message = new SmartCardContextConnectParams();
      _message.reader = reader;
      _message.shareMode = shareMode;
      _message.preferredProtocols = preferredProtocols;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new SmartCardContextConnectResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SmartCardContext> {
    Stub(Core core, SmartCardContext impl) {
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
                SmartCardContext_Internal.MANAGER, messageWithHeader);
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
                getCore(), SmartCardContext_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SmartCardContextListReadersParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .listReaders(
                    new SmartCardContextListReadersResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            SmartCardContextGetStatusChangeParams data =
                SmartCardContextGetStatusChangeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getStatusChange(
                    data.timeout,
                    data.readerStates,
                    new SmartCardContextGetStatusChangeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            SmartCardContextCancelParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .cancel(
                    new SmartCardContextCancelResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            SmartCardContextConnectParams data2 =
                SmartCardContextConnectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .connect(
                    data2.reader,
                    data2.shareMode,
                    data2.preferredProtocols,
                    new SmartCardContextConnectResponseParamsProxyToResponder(
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

  static final class SmartCardContextListReadersParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextListReadersParams(int version) {
      super(8, version);
    }

    public SmartCardContextListReadersParams() {
      this(0);
    }

    public static SmartCardContextListReadersParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextListReadersParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextListReadersParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextListReadersParams result =
            new SmartCardContextListReadersParams(elementsOrVersion);
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

  static final class SmartCardContextListReadersResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardListReadersResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextListReadersResponseParams(int version) {
      super(24, version);
    }

    public SmartCardContextListReadersResponseParams() {
      this(0);
    }

    public static SmartCardContextListReadersResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextListReadersResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextListReadersResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextListReadersResponseParams result =
            new SmartCardContextListReadersResponseParams(elementsOrVersion);
        result.result = SmartCardListReadersResult.decode(decoder0, 8);
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

  static class SmartCardContextListReadersResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardContext.ListReaders_Response mCallback;

    SmartCardContextListReadersResponseParamsForwardToCallback(
        SmartCardContext.ListReaders_Response callback) {
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
        SmartCardContextListReadersResponseParams response =
            SmartCardContextListReadersResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardContextListReadersResponseParamsProxyToResponder
      implements SmartCardContext.ListReaders_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardContextListReadersResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardListReadersResult result) {
      SmartCardContextListReadersResponseParams _response =
          new SmartCardContextListReadersResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardContextGetStatusChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardReaderStateIn[] readerStates;
    public TimeDelta timeout;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextGetStatusChangeParams(int version) {
      super(24, version);
    }

    public SmartCardContextGetStatusChangeParams() {
      this(0);
    }

    public static SmartCardContextGetStatusChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextGetStatusChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextGetStatusChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextGetStatusChangeParams result =
            new SmartCardContextGetStatusChangeParams(elementsOrVersion);
        result.timeout = TimeDelta.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.readerStates = new SmartCardReaderStateIn[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.readerStates[i1] = SmartCardReaderStateIn.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.timeout, 8, false);
      SmartCardReaderStateIn[] smartCardReaderStateInArr = this.readerStates;
      if (smartCardReaderStateInArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(smartCardReaderStateInArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        SmartCardReaderStateIn[] smartCardReaderStateInArr2 = this.readerStates;
        if (i0 < smartCardReaderStateInArr2.length) {
          encoder1.encode((Struct) smartCardReaderStateInArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class SmartCardContextGetStatusChangeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardStatusChangeResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextGetStatusChangeResponseParams(int version) {
      super(24, version);
    }

    public SmartCardContextGetStatusChangeResponseParams() {
      this(0);
    }

    public static SmartCardContextGetStatusChangeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextGetStatusChangeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextGetStatusChangeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextGetStatusChangeResponseParams result =
            new SmartCardContextGetStatusChangeResponseParams(elementsOrVersion);
        result.result = SmartCardStatusChangeResult.decode(decoder0, 8);
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

  static class SmartCardContextGetStatusChangeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardContext.GetStatusChange_Response mCallback;

    SmartCardContextGetStatusChangeResponseParamsForwardToCallback(
        SmartCardContext.GetStatusChange_Response callback) {
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
        SmartCardContextGetStatusChangeResponseParams response =
            SmartCardContextGetStatusChangeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardContextGetStatusChangeResponseParamsProxyToResponder
      implements SmartCardContext.GetStatusChange_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardContextGetStatusChangeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardStatusChangeResult result) {
      SmartCardContextGetStatusChangeResponseParams _response =
          new SmartCardContextGetStatusChangeResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardContextCancelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextCancelParams(int version) {
      super(8, version);
    }

    public SmartCardContextCancelParams() {
      this(0);
    }

    public static SmartCardContextCancelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextCancelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextCancelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextCancelParams result = new SmartCardContextCancelParams(elementsOrVersion);
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

  static final class SmartCardContextCancelResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextCancelResponseParams(int version) {
      super(24, version);
    }

    public SmartCardContextCancelResponseParams() {
      this(0);
    }

    public static SmartCardContextCancelResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextCancelResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextCancelResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextCancelResponseParams result =
            new SmartCardContextCancelResponseParams(elementsOrVersion);
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

  static class SmartCardContextCancelResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SmartCardContext.Cancel_Response mCallback;

    SmartCardContextCancelResponseParamsForwardToCallback(
        SmartCardContext.Cancel_Response callback) {
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
        SmartCardContextCancelResponseParams response =
            SmartCardContextCancelResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardContextCancelResponseParamsProxyToResponder
      implements SmartCardContext.Cancel_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardContextCancelResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardResult result) {
      SmartCardContextCancelResponseParams _response = new SmartCardContextCancelResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SmartCardContextConnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardProtocols preferredProtocols;
    public String reader;
    public int shareMode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextConnectParams(int version) {
      super(32, version);
    }

    public SmartCardContextConnectParams() {
      this(0);
    }

    public static SmartCardContextConnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextConnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextConnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextConnectParams result = new SmartCardContextConnectParams(elementsOrVersion);
        result.reader = decoder0.readString(8, false);
        int readInt = decoder0.readInt(16);
        result.shareMode = readInt;
        SmartCardShareMode.validate(readInt);
        result.shareMode = SmartCardShareMode.toKnownValue(result.shareMode);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.preferredProtocols = SmartCardProtocols.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reader, 8, false);
      encoder0.encode(this.shareMode, 16);
      encoder0.encode((Struct) this.preferredProtocols, 24, false);
    }
  }

  static final class SmartCardContextConnectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardConnectResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextConnectResponseParams(int version) {
      super(24, version);
    }

    public SmartCardContextConnectResponseParams() {
      this(0);
    }

    public static SmartCardContextConnectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextConnectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextConnectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextConnectResponseParams result =
            new SmartCardContextConnectResponseParams(elementsOrVersion);
        result.result = SmartCardConnectResult.decode(decoder0, 8);
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

  static class SmartCardContextConnectResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardContext.Connect_Response mCallback;

    SmartCardContextConnectResponseParamsForwardToCallback(
        SmartCardContext.Connect_Response callback) {
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
        SmartCardContextConnectResponseParams response =
            SmartCardContextConnectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardContextConnectResponseParamsProxyToResponder
      implements SmartCardContext.Connect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardContextConnectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardConnectResult result) {
      SmartCardContextConnectResponseParams _response = new SmartCardContextConnectResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
