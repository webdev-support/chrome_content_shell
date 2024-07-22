package org.chromium.device.mojom;

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

class WakeLockProvider_Internal {
  private static final int GET_ACTIVE_WAKE_LOCKS_FOR_TESTS_ORDINAL = 3;
  private static final int GET_WAKE_LOCK_CONTEXT_FOR_ID_ORDINAL = 0;
  private static final int GET_WAKE_LOCK_WITHOUT_CONTEXT_ORDINAL = 1;
  public static final Interface.Manager<WakeLockProvider, WakeLockProvider.Proxy> MANAGER =
      new Interface.Manager<WakeLockProvider, WakeLockProvider.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.WakeLockProvider";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WakeLockProvider.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WakeLockProvider impl) {
          return new Stub(core, impl);
        }

        @Override
        public WakeLockProvider[] buildArray(int size) {
          return new WakeLockProvider[size];
        }
      };
  private static final int NOTIFY_ON_WAKE_LOCK_DEACTIVATION_ORDINAL = 2;

  WakeLockProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WakeLockProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getWakeLockContextForId(int contextId, InterfaceRequest<WakeLockContext> context) {
      WakeLockProviderGetWakeLockContextForIdParams _message =
          new WakeLockProviderGetWakeLockContextForIdParams();
      _message.contextId = contextId;
      _message.context = context;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void getWakeLockWithoutContext(
        int type, int reason, String description, InterfaceRequest<WakeLock> wakeLock) {
      WakeLockProviderGetWakeLockWithoutContextParams _message =
          new WakeLockProviderGetWakeLockWithoutContextParams();
      _message.type = type;
      _message.reason = reason;
      _message.description = description;
      _message.wakeLock = wakeLock;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void notifyOnWakeLockDeactivation(int type, WakeLockObserver observer) {
      WakeLockProviderNotifyOnWakeLockDeactivationParams _message =
          new WakeLockProviderNotifyOnWakeLockDeactivationParams();
      _message.type = type;
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void getActiveWakeLocksForTests(int type, GetActiveWakeLocksForTests_Response callback) {
      WakeLockProviderGetActiveWakeLocksForTestsParams _message =
          new WakeLockProviderGetActiveWakeLocksForTestsParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<WakeLockProvider> {
    Stub(Core core, WakeLockProvider impl) {
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
                WakeLockProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WakeLockProviderGetWakeLockContextForIdParams data =
                WakeLockProviderGetWakeLockContextForIdParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getWakeLockContextForId(data.contextId, data.context);
            return true;
          case 1:
            WakeLockProviderGetWakeLockWithoutContextParams data2 =
                WakeLockProviderGetWakeLockWithoutContextParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getWakeLockWithoutContext(
                    data2.type, data2.reason, data2.description, data2.wakeLock);
            return true;
          case 2:
            WakeLockProviderNotifyOnWakeLockDeactivationParams data3 =
                WakeLockProviderNotifyOnWakeLockDeactivationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().notifyOnWakeLockDeactivation(data3.type, data3.observer);
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
                getCore(), WakeLockProvider_Internal.MANAGER, messageWithHeader, receiver);
          case 3:
            WakeLockProviderGetActiveWakeLocksForTestsParams data =
                WakeLockProviderGetActiveWakeLocksForTestsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getActiveWakeLocksForTests(
                    data.type,
                    new WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder(
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

  static final class WakeLockProviderGetWakeLockContextForIdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<WakeLockContext> context;
    public int contextId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockProviderGetWakeLockContextForIdParams(int version) {
      super(16, version);
    }

    public WakeLockProviderGetWakeLockContextForIdParams() {
      this(0);
    }

    public static WakeLockProviderGetWakeLockContextForIdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockProviderGetWakeLockContextForIdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockProviderGetWakeLockContextForIdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockProviderGetWakeLockContextForIdParams result =
            new WakeLockProviderGetWakeLockContextForIdParams(elementsOrVersion);
        result.contextId = decoder0.readInt(8);
        result.context = decoder0.readInterfaceRequest(12, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.contextId, 8);
      encoder0.encode((InterfaceRequest) this.context, 12, false);
    }
  }

  static final class WakeLockProviderGetWakeLockWithoutContextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String description;
    public int reason;
    public int type;
    public InterfaceRequest<WakeLock> wakeLock;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockProviderGetWakeLockWithoutContextParams(int version) {
      super(32, version);
    }

    public WakeLockProviderGetWakeLockWithoutContextParams() {
      this(0);
    }

    public static WakeLockProviderGetWakeLockWithoutContextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockProviderGetWakeLockWithoutContextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockProviderGetWakeLockWithoutContextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockProviderGetWakeLockWithoutContextParams result =
            new WakeLockProviderGetWakeLockWithoutContextParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        WakeLockType.validate(readInt);
        result.type = WakeLockType.toKnownValue(result.type);
        int readInt2 = decoder0.readInt(12);
        result.reason = readInt2;
        WakeLockReason.validate(readInt2);
        result.reason = WakeLockReason.toKnownValue(result.reason);
        result.description = decoder0.readString(16, false);
        result.wakeLock = decoder0.readInterfaceRequest(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode(this.reason, 12);
      encoder0.encode(this.description, 16, false);
      encoder0.encode((InterfaceRequest) this.wakeLock, 24, false);
    }
  }

  static final class WakeLockProviderNotifyOnWakeLockDeactivationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public WakeLockObserver observer;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockProviderNotifyOnWakeLockDeactivationParams(int version) {
      super(24, version);
    }

    public WakeLockProviderNotifyOnWakeLockDeactivationParams() {
      this(0);
    }

    public static WakeLockProviderNotifyOnWakeLockDeactivationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockProviderNotifyOnWakeLockDeactivationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockProviderNotifyOnWakeLockDeactivationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockProviderNotifyOnWakeLockDeactivationParams result =
            new WakeLockProviderNotifyOnWakeLockDeactivationParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        WakeLockType.validate(readInt);
        result.type = WakeLockType.toKnownValue(result.type);
        result.observer =
            (WakeLockObserver) decoder0.readServiceInterface(12, false, WakeLockObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode(this.observer, 12, false, WakeLockObserver.MANAGER);
    }
  }

  static final class WakeLockProviderGetActiveWakeLocksForTestsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockProviderGetActiveWakeLocksForTestsParams(int version) {
      super(16, version);
    }

    public WakeLockProviderGetActiveWakeLocksForTestsParams() {
      this(0);
    }

    public static WakeLockProviderGetActiveWakeLocksForTestsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockProviderGetActiveWakeLocksForTestsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockProviderGetActiveWakeLocksForTestsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockProviderGetActiveWakeLocksForTestsParams result =
            new WakeLockProviderGetActiveWakeLocksForTestsParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        WakeLockType.validate(readInt);
        result.type = WakeLockType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static final class WakeLockProviderGetActiveWakeLocksForTestsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int count;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockProviderGetActiveWakeLocksForTestsResponseParams(int version) {
      super(16, version);
    }

    public WakeLockProviderGetActiveWakeLocksForTestsResponseParams() {
      this(0);
    }

    public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockProviderGetActiveWakeLocksForTestsResponseParams result =
            new WakeLockProviderGetActiveWakeLocksForTestsResponseParams(elementsOrVersion);
        result.count = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.count, 8);
    }
  }

  static class WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WakeLockProvider.GetActiveWakeLocksForTests_Response mCallback;

    WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback(
        WakeLockProvider.GetActiveWakeLocksForTests_Response callback) {
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
        WakeLockProviderGetActiveWakeLocksForTestsResponseParams response =
            WakeLockProviderGetActiveWakeLocksForTestsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.count);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder
      implements WakeLockProvider.GetActiveWakeLocksForTests_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int count) {
      WakeLockProviderGetActiveWakeLocksForTestsResponseParams _response =
          new WakeLockProviderGetActiveWakeLocksForTestsResponseParams();
      _response.count = count;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
