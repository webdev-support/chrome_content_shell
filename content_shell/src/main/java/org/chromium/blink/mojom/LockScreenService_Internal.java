package org.chromium.blink.mojom;

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

class LockScreenService_Internal {
  private static final int GET_KEYS_ORDINAL = 0;
  public static final Interface.Manager<LockScreenService, LockScreenService.Proxy> MANAGER =
      new Interface.Manager<LockScreenService, LockScreenService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.LockScreenService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LockScreenService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LockScreenService impl) {
          return new Stub(core, impl);
        }

        @Override
        public LockScreenService[] buildArray(int size) {
          return new LockScreenService[size];
        }
      };
  private static final int SET_DATA_ORDINAL = 1;

  LockScreenService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements LockScreenService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getKeys(GetKeys_Response callback) {
      LockScreenServiceGetKeysParams _message = new LockScreenServiceGetKeysParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new LockScreenServiceGetKeysResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setData(String key, String data, SetData_Response callback) {
      LockScreenServiceSetDataParams _message = new LockScreenServiceSetDataParams();
      _message.key = key;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new LockScreenServiceSetDataResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<LockScreenService> {
    Stub(Core core, LockScreenService impl) {
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
                LockScreenService_Internal.MANAGER, messageWithHeader);
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
                getCore(), LockScreenService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            LockScreenServiceGetKeysParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getKeys(
                    new LockScreenServiceGetKeysResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            LockScreenServiceSetDataParams data =
                LockScreenServiceSetDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setData(
                    data.key,
                    data.data,
                    new LockScreenServiceSetDataResponseParamsProxyToResponder(
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

  static final class LockScreenServiceGetKeysParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LockScreenServiceGetKeysParams(int version) {
      super(8, version);
    }

    public LockScreenServiceGetKeysParams() {
      this(0);
    }

    public static LockScreenServiceGetKeysParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LockScreenServiceGetKeysParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LockScreenServiceGetKeysParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LockScreenServiceGetKeysParams result =
            new LockScreenServiceGetKeysParams(elementsOrVersion);
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

  static final class LockScreenServiceGetKeysResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] keys;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LockScreenServiceGetKeysResponseParams(int version) {
      super(16, version);
    }

    public LockScreenServiceGetKeysResponseParams() {
      this(0);
    }

    public static LockScreenServiceGetKeysResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LockScreenServiceGetKeysResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LockScreenServiceGetKeysResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LockScreenServiceGetKeysResponseParams result =
            new LockScreenServiceGetKeysResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.keys = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.keys[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.keys;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.keys;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class LockScreenServiceGetKeysResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LockScreenService.GetKeys_Response mCallback;

    LockScreenServiceGetKeysResponseParamsForwardToCallback(
        LockScreenService.GetKeys_Response callback) {
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
        LockScreenServiceGetKeysResponseParams response =
            LockScreenServiceGetKeysResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.keys);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LockScreenServiceGetKeysResponseParamsProxyToResponder
      implements LockScreenService.GetKeys_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LockScreenServiceGetKeysResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String[] keys) {
      LockScreenServiceGetKeysResponseParams _response =
          new LockScreenServiceGetKeysResponseParams();
      _response.keys = keys;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LockScreenServiceSetDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String data;
    public String key;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LockScreenServiceSetDataParams(int version) {
      super(24, version);
    }

    public LockScreenServiceSetDataParams() {
      this(0);
    }

    public static LockScreenServiceSetDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LockScreenServiceSetDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LockScreenServiceSetDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LockScreenServiceSetDataParams result =
            new LockScreenServiceSetDataParams(elementsOrVersion);
        result.key = decoder0.readString(8, false);
        result.data = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8, false);
      encoder0.encode(this.data, 16, false);
    }
  }

  static final class LockScreenServiceSetDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LockScreenServiceSetDataResponseParams(int version) {
      super(16, version);
    }

    public LockScreenServiceSetDataResponseParams() {
      this(0);
    }

    public static LockScreenServiceSetDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LockScreenServiceSetDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LockScreenServiceSetDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LockScreenServiceSetDataResponseParams result =
            new LockScreenServiceSetDataResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        LockScreenServiceStatus.validate(readInt);
        result.status = LockScreenServiceStatus.toKnownValue(result.status);
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

  static class LockScreenServiceSetDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LockScreenService.SetData_Response mCallback;

    LockScreenServiceSetDataResponseParamsForwardToCallback(
        LockScreenService.SetData_Response callback) {
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
        LockScreenServiceSetDataResponseParams response =
            LockScreenServiceSetDataResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LockScreenServiceSetDataResponseParamsProxyToResponder
      implements LockScreenService.SetData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LockScreenServiceSetDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      LockScreenServiceSetDataResponseParams _response =
          new LockScreenServiceSetDataResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
