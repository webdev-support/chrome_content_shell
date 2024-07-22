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

class IdleManager_Internal {
  private static final int ADD_MONITOR_ORDINAL = 0;
  public static final Interface.Manager<IdleManager, IdleManager.Proxy> MANAGER =
      new Interface.Manager<IdleManager, IdleManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.IdleManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public IdleManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, IdleManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public IdleManager[] buildArray(int size) {
          return new IdleManager[size];
        }
      };

  IdleManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements IdleManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addMonitor(IdleMonitor monitor, AddMonitor_Response callback) {
      IdleManagerAddMonitorParams _message = new IdleManagerAddMonitorParams();
      _message.monitor = monitor;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new IdleManagerAddMonitorResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<IdleManager> {
    Stub(Core core, IdleManager impl) {
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
                IdleManager_Internal.MANAGER, messageWithHeader);
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
                getCore(), IdleManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            IdleManagerAddMonitorParams data =
                IdleManagerAddMonitorParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addMonitor(
                    data.monitor,
                    new IdleManagerAddMonitorResponseParamsProxyToResponder(
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

  static final class IdleManagerAddMonitorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public IdleMonitor monitor;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IdleManagerAddMonitorParams(int version) {
      super(16, version);
    }

    public IdleManagerAddMonitorParams() {
      this(0);
    }

    public static IdleManagerAddMonitorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IdleManagerAddMonitorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IdleManagerAddMonitorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IdleManagerAddMonitorParams result = new IdleManagerAddMonitorParams(elementsOrVersion);
        result.monitor = (IdleMonitor) decoder0.readServiceInterface(8, false, IdleMonitor.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.monitor, 8, false, IdleMonitor.MANAGER);
    }
  }

  static final class IdleManagerAddMonitorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public IdleState state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IdleManagerAddMonitorResponseParams(int version) {
      super(24, version);
    }

    public IdleManagerAddMonitorResponseParams() {
      this(0);
    }

    public static IdleManagerAddMonitorResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IdleManagerAddMonitorResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IdleManagerAddMonitorResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IdleManagerAddMonitorResponseParams result =
            new IdleManagerAddMonitorResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        IdleManagerError.validate(readInt);
        result.error = IdleManagerError.toKnownValue(result.error);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.state = IdleState.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode((Struct) this.state, 16, true);
    }
  }

  static class IdleManagerAddMonitorResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final IdleManager.AddMonitor_Response mCallback;

    IdleManagerAddMonitorResponseParamsForwardToCallback(IdleManager.AddMonitor_Response callback) {
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
        IdleManagerAddMonitorResponseParams response =
            IdleManagerAddMonitorResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.state);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class IdleManagerAddMonitorResponseParamsProxyToResponder
      implements IdleManager.AddMonitor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    IdleManagerAddMonitorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, IdleState state) {
      IdleManagerAddMonitorResponseParams _response = new IdleManagerAddMonitorResponseParams();
      _response.error = error;
      _response.state = state;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
