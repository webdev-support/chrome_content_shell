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

class BatteryMonitor_Internal {
  public static final Interface.Manager<BatteryMonitor, BatteryMonitor.Proxy> MANAGER =
      new Interface.Manager<BatteryMonitor, BatteryMonitor.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.BatteryMonitor";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public BatteryMonitor.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, BatteryMonitor impl) {
          return new Stub(core, impl);
        }

        @Override
        public BatteryMonitor[] buildArray(int size) {
          return new BatteryMonitor[size];
        }
      };
  private static final int QUERY_NEXT_STATUS_ORDINAL = 0;

  BatteryMonitor_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements BatteryMonitor.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void queryNextStatus(QueryNextStatus_Response callback) {
      BatteryMonitorQueryNextStatusParams _message = new BatteryMonitorQueryNextStatusParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new BatteryMonitorQueryNextStatusResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<BatteryMonitor> {
    Stub(Core core, BatteryMonitor impl) {
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
                BatteryMonitor_Internal.MANAGER, messageWithHeader);
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
                getCore(), BatteryMonitor_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            BatteryMonitorQueryNextStatusParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .queryNextStatus(
                    new BatteryMonitorQueryNextStatusResponseParamsProxyToResponder(
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

  static final class BatteryMonitorQueryNextStatusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BatteryMonitorQueryNextStatusParams(int version) {
      super(8, version);
    }

    public BatteryMonitorQueryNextStatusParams() {
      this(0);
    }

    public static BatteryMonitorQueryNextStatusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BatteryMonitorQueryNextStatusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BatteryMonitorQueryNextStatusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BatteryMonitorQueryNextStatusParams result =
            new BatteryMonitorQueryNextStatusParams(elementsOrVersion);
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

  static final class BatteryMonitorQueryNextStatusResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BatteryStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BatteryMonitorQueryNextStatusResponseParams(int version) {
      super(16, version);
    }

    public BatteryMonitorQueryNextStatusResponseParams() {
      this(0);
    }

    public static BatteryMonitorQueryNextStatusResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BatteryMonitorQueryNextStatusResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BatteryMonitorQueryNextStatusResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BatteryMonitorQueryNextStatusResponseParams result =
            new BatteryMonitorQueryNextStatusResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = BatteryStatus.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.status, 8, false);
    }
  }

  static class BatteryMonitorQueryNextStatusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BatteryMonitor.QueryNextStatus_Response mCallback;

    BatteryMonitorQueryNextStatusResponseParamsForwardToCallback(
        BatteryMonitor.QueryNextStatus_Response callback) {
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
        BatteryMonitorQueryNextStatusResponseParams response =
            BatteryMonitorQueryNextStatusResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BatteryMonitorQueryNextStatusResponseParamsProxyToResponder
      implements BatteryMonitor.QueryNextStatus_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BatteryMonitorQueryNextStatusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BatteryStatus status) {
      BatteryMonitorQueryNextStatusResponseParams _response =
          new BatteryMonitorQueryNextStatusResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
