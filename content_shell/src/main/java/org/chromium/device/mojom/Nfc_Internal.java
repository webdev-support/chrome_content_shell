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
import org.chromium.mojo.system.Core;

class Nfc_Internal {
  private static final int CANCEL_MAKE_READ_ONLY_ORDINAL = 4;
  private static final int CANCEL_PUSH_ORDINAL = 2;
  private static final int CANCEL_WATCH_ORDINAL = 6;
  private static final int MAKE_READ_ONLY_ORDINAL = 3;
  public static final Interface.Manager<Nfc, Nfc.Proxy> MANAGER =
      new Interface.Manager<Nfc, Nfc.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.NFC";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Nfc.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Nfc impl) {
          return new Stub(core, impl);
        }

        @Override
        public Nfc[] buildArray(int size) {
          return new Nfc[size];
        }
      };
  private static final int PUSH_ORDINAL = 1;
  private static final int SET_CLIENT_ORDINAL = 0;
  private static final int WATCH_ORDINAL = 5;

  Nfc_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Nfc.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setClient(NfcClient client) {
      NfcSetClientParams _message = new NfcSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void push(NdefMessage message, NdefWriteOptions options, Push_Response callback) {
      NfcPushParams _message = new NfcPushParams();
      _message.message = message;
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new NfcPushResponseParamsForwardToCallback(callback));
    }

    @Override
    public void cancelPush() {
      NfcCancelPushParams _message = new NfcCancelPushParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void makeReadOnly(MakeReadOnly_Response callback) {
      NfcMakeReadOnlyParams _message = new NfcMakeReadOnlyParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new NfcMakeReadOnlyResponseParamsForwardToCallback(callback));
    }

    @Override
    public void cancelMakeReadOnly() {
      NfcCancelMakeReadOnlyParams _message = new NfcCancelMakeReadOnlyParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void watch(int id, Watch_Response callback) {
      NfcWatchParams _message = new NfcWatchParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new NfcWatchResponseParamsForwardToCallback(callback));
    }

    @Override
    public void cancelWatch(int id) {
      NfcCancelWatchParams _message = new NfcCancelWatchParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }
  }

  public static final class Stub extends Interface.Stub<Nfc> {
    Stub(Core core, Nfc impl) {
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
                Nfc_Internal.MANAGER, messageWithHeader);
          case -1:
          case 1:
          case 3:
          case 5:
          default:
            return false;
          case 0:
            NfcSetClientParams data =
                NfcSetClientParams.deserialize(messageWithHeader.getPayload());
            getImpl().setClient(data.client);
            return true;
          case 2:
            NfcCancelPushParams.deserialize(messageWithHeader.getPayload());
            getImpl().cancelPush();
            return true;
          case 4:
            NfcCancelMakeReadOnlyParams.deserialize(messageWithHeader.getPayload());
            getImpl().cancelMakeReadOnly();
            return true;
          case 6:
            NfcCancelWatchParams data2 =
                NfcCancelWatchParams.deserialize(messageWithHeader.getPayload());
            getImpl().cancelWatch(data2.id);
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
                getCore(), Nfc_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 2:
          case 4:
          default:
            return false;
          case 1:
            NfcPushParams data = NfcPushParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .push(
                    data.message,
                    data.options,
                    new NfcPushResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            NfcMakeReadOnlyParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .makeReadOnly(
                    new NfcMakeReadOnlyResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            getImpl()
                .watch(
                    NfcWatchParams.deserialize(messageWithHeader.getPayload()).id,
                    new NfcWatchResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NfcSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public NfcClient client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcSetClientParams(int version) {
      super(16, version);
    }

    public NfcSetClientParams() {
      this(0);
    }

    public static NfcSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcSetClientParams result = new NfcSetClientParams(elementsOrVersion);
        result.client = (NfcClient) decoder0.readServiceInterface(8, false, NfcClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, NfcClient.MANAGER);
    }
  }

  static final class NfcPushParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public NdefMessage message;
    public NdefWriteOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcPushParams(int version) {
      super(24, version);
    }

    public NfcPushParams() {
      this(0);
    }

    public static NfcPushParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcPushParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcPushParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcPushParams result = new NfcPushParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.message = NdefMessage.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.options = NdefWriteOptions.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.message, 8, false);
      encoder0.encode((Struct) this.options, 16, true);
    }
  }

  static final class NfcPushResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public NdefError error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcPushResponseParams(int version) {
      super(16, version);
    }

    public NfcPushResponseParams() {
      this(0);
    }

    public static NfcPushResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcPushResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcPushResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcPushResponseParams result = new NfcPushResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.error = NdefError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.error, 8, true);
    }
  }

  static class NfcPushResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Nfc.Push_Response mCallback;

    NfcPushResponseParamsForwardToCallback(Nfc.Push_Response callback) {
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
        NfcPushResponseParams response =
            NfcPushResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NfcPushResponseParamsProxyToResponder implements Nfc.Push_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NfcPushResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(NdefError error) {
      NfcPushResponseParams _response = new NfcPushResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NfcCancelPushParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcCancelPushParams(int version) {
      super(8, version);
    }

    public NfcCancelPushParams() {
      this(0);
    }

    public static NfcCancelPushParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcCancelPushParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcCancelPushParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcCancelPushParams result = new NfcCancelPushParams(elementsOrVersion);
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

  static final class NfcMakeReadOnlyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcMakeReadOnlyParams(int version) {
      super(8, version);
    }

    public NfcMakeReadOnlyParams() {
      this(0);
    }

    public static NfcMakeReadOnlyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcMakeReadOnlyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcMakeReadOnlyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcMakeReadOnlyParams result = new NfcMakeReadOnlyParams(elementsOrVersion);
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

  static final class NfcMakeReadOnlyResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public NdefError error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcMakeReadOnlyResponseParams(int version) {
      super(16, version);
    }

    public NfcMakeReadOnlyResponseParams() {
      this(0);
    }

    public static NfcMakeReadOnlyResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcMakeReadOnlyResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcMakeReadOnlyResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcMakeReadOnlyResponseParams result = new NfcMakeReadOnlyResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.error = NdefError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.error, 8, true);
    }
  }

  static class NfcMakeReadOnlyResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Nfc.MakeReadOnly_Response mCallback;

    NfcMakeReadOnlyResponseParamsForwardToCallback(Nfc.MakeReadOnly_Response callback) {
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
        NfcMakeReadOnlyResponseParams response =
            NfcMakeReadOnlyResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NfcMakeReadOnlyResponseParamsProxyToResponder implements Nfc.MakeReadOnly_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NfcMakeReadOnlyResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(NdefError error) {
      NfcMakeReadOnlyResponseParams _response = new NfcMakeReadOnlyResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NfcCancelMakeReadOnlyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcCancelMakeReadOnlyParams(int version) {
      super(8, version);
    }

    public NfcCancelMakeReadOnlyParams() {
      this(0);
    }

    public static NfcCancelMakeReadOnlyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcCancelMakeReadOnlyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcCancelMakeReadOnlyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcCancelMakeReadOnlyParams result = new NfcCancelMakeReadOnlyParams(elementsOrVersion);
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

  static final class NfcWatchParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcWatchParams(int version) {
      super(16, version);
    }

    public NfcWatchParams() {
      this(0);
    }

    public static NfcWatchParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcWatchParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcWatchParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcWatchParams result = new NfcWatchParams(elementsOrVersion);
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

  static final class NfcWatchResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public NdefError error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcWatchResponseParams(int version) {
      super(16, version);
    }

    public NfcWatchResponseParams() {
      this(0);
    }

    public static NfcWatchResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcWatchResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcWatchResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcWatchResponseParams result = new NfcWatchResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.error = NdefError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.error, 8, true);
    }
  }

  static class NfcWatchResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Nfc.Watch_Response mCallback;

    NfcWatchResponseParamsForwardToCallback(Nfc.Watch_Response callback) {
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
        NfcWatchResponseParams response =
            NfcWatchResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NfcWatchResponseParamsProxyToResponder implements Nfc.Watch_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NfcWatchResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(NdefError error) {
      NfcWatchResponseParams _response = new NfcWatchResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NfcCancelWatchParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcCancelWatchParams(int version) {
      super(16, version);
    }

    public NfcCancelWatchParams() {
      this(0);
    }

    public static NfcCancelWatchParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcCancelWatchParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcCancelWatchParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcCancelWatchParams result = new NfcCancelWatchParams(elementsOrVersion);
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
}
