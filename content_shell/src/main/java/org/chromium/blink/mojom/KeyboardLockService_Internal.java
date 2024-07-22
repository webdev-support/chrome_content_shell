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

class KeyboardLockService_Internal {
  private static final int CANCEL_KEYBOARD_LOCK_ORDINAL = 1;
  private static final int GET_KEYBOARD_LAYOUT_MAP_ORDINAL = 2;
  public static final Interface.Manager<KeyboardLockService, KeyboardLockService.Proxy> MANAGER =
      new Interface.Manager<KeyboardLockService, KeyboardLockService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.KeyboardLockService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public KeyboardLockService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, KeyboardLockService impl) {
          return new Stub(core, impl);
        }

        @Override
        public KeyboardLockService[] buildArray(int size) {
          return new KeyboardLockService[size];
        }
      };
  private static final int REQUEST_KEYBOARD_LOCK_ORDINAL = 0;

  KeyboardLockService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements KeyboardLockService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestKeyboardLock(String[] keyCodes, RequestKeyboardLock_Response callback) {
      KeyboardLockServiceRequestKeyboardLockParams _message =
          new KeyboardLockServiceRequestKeyboardLockParams();
      _message.keyCodes = keyCodes;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new KeyboardLockServiceRequestKeyboardLockResponseParamsForwardToCallback(callback));
    }

    @Override
    public void cancelKeyboardLock() {
      KeyboardLockServiceCancelKeyboardLockParams _message =
          new KeyboardLockServiceCancelKeyboardLockParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void getKeyboardLayoutMap(GetKeyboardLayoutMap_Response callback) {
      KeyboardLockServiceGetKeyboardLayoutMapParams _message =
          new KeyboardLockServiceGetKeyboardLayoutMapParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new KeyboardLockServiceGetKeyboardLayoutMapResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<KeyboardLockService> {
    Stub(Core core, KeyboardLockService impl) {
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
                KeyboardLockService_Internal.MANAGER, messageWithHeader);
          case 1:
            KeyboardLockServiceCancelKeyboardLockParams.deserialize(messageWithHeader.getPayload());
            getImpl().cancelKeyboardLock();
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
                getCore(), KeyboardLockService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            KeyboardLockServiceRequestKeyboardLockParams data =
                KeyboardLockServiceRequestKeyboardLockParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestKeyboardLock(
                    data.keyCodes,
                    new KeyboardLockServiceRequestKeyboardLockResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            KeyboardLockServiceGetKeyboardLayoutMapParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getKeyboardLayoutMap(
                    new KeyboardLockServiceGetKeyboardLayoutMapResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class KeyboardLockServiceRequestKeyboardLockParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] keyCodes;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private KeyboardLockServiceRequestKeyboardLockParams(int version) {
      super(16, version);
    }

    public KeyboardLockServiceRequestKeyboardLockParams() {
      this(0);
    }

    public static KeyboardLockServiceRequestKeyboardLockParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static KeyboardLockServiceRequestKeyboardLockParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static KeyboardLockServiceRequestKeyboardLockParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        KeyboardLockServiceRequestKeyboardLockParams result =
            new KeyboardLockServiceRequestKeyboardLockParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.keyCodes = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.keyCodes[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.keyCodes;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.keyCodes;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class KeyboardLockServiceRequestKeyboardLockResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private KeyboardLockServiceRequestKeyboardLockResponseParams(int version) {
      super(16, version);
    }

    public KeyboardLockServiceRequestKeyboardLockResponseParams() {
      this(0);
    }

    public static KeyboardLockServiceRequestKeyboardLockResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static KeyboardLockServiceRequestKeyboardLockResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static KeyboardLockServiceRequestKeyboardLockResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        KeyboardLockServiceRequestKeyboardLockResponseParams result =
            new KeyboardLockServiceRequestKeyboardLockResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        KeyboardLockRequestResult.validate(readInt);
        result.result = KeyboardLockRequestResult.toKnownValue(result.result);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class KeyboardLockServiceRequestKeyboardLockResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final KeyboardLockService.RequestKeyboardLock_Response mCallback;

    KeyboardLockServiceRequestKeyboardLockResponseParamsForwardToCallback(
        KeyboardLockService.RequestKeyboardLock_Response callback) {
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
        KeyboardLockServiceRequestKeyboardLockResponseParams response =
            KeyboardLockServiceRequestKeyboardLockResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class KeyboardLockServiceRequestKeyboardLockResponseParamsProxyToResponder
      implements KeyboardLockService.RequestKeyboardLock_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    KeyboardLockServiceRequestKeyboardLockResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      KeyboardLockServiceRequestKeyboardLockResponseParams _response =
          new KeyboardLockServiceRequestKeyboardLockResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class KeyboardLockServiceCancelKeyboardLockParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private KeyboardLockServiceCancelKeyboardLockParams(int version) {
      super(8, version);
    }

    public KeyboardLockServiceCancelKeyboardLockParams() {
      this(0);
    }

    public static KeyboardLockServiceCancelKeyboardLockParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static KeyboardLockServiceCancelKeyboardLockParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static KeyboardLockServiceCancelKeyboardLockParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        KeyboardLockServiceCancelKeyboardLockParams result =
            new KeyboardLockServiceCancelKeyboardLockParams(elementsOrVersion);
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

  static final class KeyboardLockServiceGetKeyboardLayoutMapParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private KeyboardLockServiceGetKeyboardLayoutMapParams(int version) {
      super(8, version);
    }

    public KeyboardLockServiceGetKeyboardLayoutMapParams() {
      this(0);
    }

    public static KeyboardLockServiceGetKeyboardLayoutMapParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static KeyboardLockServiceGetKeyboardLayoutMapParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static KeyboardLockServiceGetKeyboardLayoutMapParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        KeyboardLockServiceGetKeyboardLayoutMapParams result =
            new KeyboardLockServiceGetKeyboardLayoutMapParams(elementsOrVersion);
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

  static final class KeyboardLockServiceGetKeyboardLayoutMapResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public GetKeyboardLayoutMapResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private KeyboardLockServiceGetKeyboardLayoutMapResponseParams(int version) {
      super(16, version);
    }

    public KeyboardLockServiceGetKeyboardLayoutMapResponseParams() {
      this(0);
    }

    public static KeyboardLockServiceGetKeyboardLayoutMapResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static KeyboardLockServiceGetKeyboardLayoutMapResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static KeyboardLockServiceGetKeyboardLayoutMapResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        KeyboardLockServiceGetKeyboardLayoutMapResponseParams result =
            new KeyboardLockServiceGetKeyboardLayoutMapResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = GetKeyboardLayoutMapResult.decode(decoder1);
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

  static class KeyboardLockServiceGetKeyboardLayoutMapResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final KeyboardLockService.GetKeyboardLayoutMap_Response mCallback;

    KeyboardLockServiceGetKeyboardLayoutMapResponseParamsForwardToCallback(
        KeyboardLockService.GetKeyboardLayoutMap_Response callback) {
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
        KeyboardLockServiceGetKeyboardLayoutMapResponseParams response =
            KeyboardLockServiceGetKeyboardLayoutMapResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class KeyboardLockServiceGetKeyboardLayoutMapResponseParamsProxyToResponder
      implements KeyboardLockService.GetKeyboardLayoutMap_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    KeyboardLockServiceGetKeyboardLayoutMapResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(GetKeyboardLayoutMapResult result) {
      KeyboardLockServiceGetKeyboardLayoutMapResponseParams _response =
          new KeyboardLockServiceGetKeyboardLayoutMapResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
