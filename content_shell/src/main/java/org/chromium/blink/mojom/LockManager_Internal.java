package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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

class LockManager_Internal {
  public static final Interface.Manager<LockManager, LockManager.Proxy> MANAGER =
      new Interface.Manager<LockManager, LockManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.LockManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LockManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LockManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public LockManager[] buildArray(int size) {
          return new LockManager[size];
        }
      };
  private static final int QUERY_STATE_ORDINAL = 1;
  private static final int REQUEST_LOCK_ORDINAL = 0;

  LockManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements LockManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestLock(
        String name, int mode, int wait, AssociatedInterfaceNotSupported request) {
      LockManagerRequestLockParams _message = new LockManagerRequestLockParams();
      _message.name = name;
      _message.mode = mode;
      _message.wait = wait;
      _message.request = request;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void queryState(QueryState_Response callback) {
      LockManagerQueryStateParams _message = new LockManagerQueryStateParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new LockManagerQueryStateResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<LockManager> {
    Stub(Core core, LockManager impl) {
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
                LockManager_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            LockManagerRequestLockParams data =
                LockManagerRequestLockParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestLock(data.name, data.mode, data.wait, data.request);
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
                getCore(), LockManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            LockManagerQueryStateParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .queryState(
                    new LockManagerQueryStateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class LockManagerRequestLockParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int mode;
    public String name;
    public AssociatedInterfaceNotSupported request;
    public int wait;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LockManagerRequestLockParams(int version) {
      super(32, version);
    }

    public LockManagerRequestLockParams() {
      this(0);
    }

    public static LockManagerRequestLockParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LockManagerRequestLockParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LockManagerRequestLockParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LockManagerRequestLockParams result = new LockManagerRequestLockParams(elementsOrVersion);
        result.name = decoder0.readString(8, false);
        int readInt = decoder0.readInt(16);
        result.mode = readInt;
        LockMode.validate(readInt);
        result.mode = LockMode.toKnownValue(result.mode);
        int readInt2 = decoder0.readInt(20);
        result.wait = readInt2;
        LockManager.WaitMode.validate(readInt2);
        result.wait = LockManager.WaitMode.toKnownValue(result.wait);
        result.request = decoder0.readAssociatedServiceInterfaceNotSupported(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.name, 8, false);
      encoder0.encode(this.mode, 16);
      encoder0.encode(this.wait, 20);
      encoder0.encode(this.request, 24, false);
    }
  }

  static final class LockManagerQueryStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LockManagerQueryStateParams(int version) {
      super(8, version);
    }

    public LockManagerQueryStateParams() {
      this(0);
    }

    public static LockManagerQueryStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LockManagerQueryStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LockManagerQueryStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LockManagerQueryStateParams result = new LockManagerQueryStateParams(elementsOrVersion);
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

  static final class LockManagerQueryStateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public LockInfo[] held;
    public LockInfo[] requested;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LockManagerQueryStateResponseParams(int version) {
      super(24, version);
    }

    public LockManagerQueryStateResponseParams() {
      this(0);
    }

    public static LockManagerQueryStateResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LockManagerQueryStateResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LockManagerQueryStateResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LockManagerQueryStateResponseParams result =
            new LockManagerQueryStateResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.requested = new LockInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.requested[i1] = LockInfo.decode(decoder2);
        }
        Decoder decoder12 = decoder0.readPointer(16, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.held = new LockInfo[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.held[i12] = LockInfo.decode(decoder22);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      LockInfo[] lockInfoArr = this.requested;
      if (lockInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(lockInfoArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          LockInfo[] lockInfoArr2 = this.requested;
          if (i0 >= lockInfoArr2.length) {
            break;
          }
          encoder1.encode((Struct) lockInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      LockInfo[] lockInfoArr3 = this.held;
      if (lockInfoArr3 == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder12 = encoder0.encodePointerArray(lockInfoArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        LockInfo[] lockInfoArr4 = this.held;
        if (i02 < lockInfoArr4.length) {
          encoder12.encode((Struct) lockInfoArr4[i02], (i02 * 8) + 8, false);
          i02++;
        } else {
          return;
        }
      }
    }
  }

  static class LockManagerQueryStateResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final LockManager.QueryState_Response mCallback;

    LockManagerQueryStateResponseParamsForwardToCallback(LockManager.QueryState_Response callback) {
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
        LockManagerQueryStateResponseParams response =
            LockManagerQueryStateResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.requested, response.held);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LockManagerQueryStateResponseParamsProxyToResponder
      implements LockManager.QueryState_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LockManagerQueryStateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(LockInfo[] requested, LockInfo[] held) {
      LockManagerQueryStateResponseParams _response = new LockManagerQueryStateResponseParams();
      _response.requested = requested;
      _response.held = held;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
