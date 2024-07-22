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

class PressureManager_Internal {
  private static final int ADD_CLIENT_ORDINAL = 0;
  public static final Interface.Manager<PressureManager, PressureManager.Proxy> MANAGER =
      new Interface.Manager<PressureManager, PressureManager.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.PressureManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PressureManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PressureManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public PressureManager[] buildArray(int size) {
          return new PressureManager[size];
        }
      };

  PressureManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements PressureManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addClient(PressureClient client, int source, AddClient_Response callback) {
      PressureManagerAddClientParams _message = new PressureManagerAddClientParams();
      _message.client = client;
      _message.source = source;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new PressureManagerAddClientResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<PressureManager> {
    Stub(Core core, PressureManager impl) {
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
                PressureManager_Internal.MANAGER, messageWithHeader);
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
                getCore(), PressureManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            PressureManagerAddClientParams data =
                PressureManagerAddClientParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addClient(
                    data.client,
                    data.source,
                    new PressureManagerAddClientResponseParamsProxyToResponder(
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

  static final class PressureManagerAddClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PressureClient client;
    public int source;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PressureManagerAddClientParams(int version) {
      super(24, version);
    }

    public PressureManagerAddClientParams() {
      this(0);
    }

    public static PressureManagerAddClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PressureManagerAddClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PressureManagerAddClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PressureManagerAddClientParams result =
            new PressureManagerAddClientParams(elementsOrVersion);
        result.client =
            (PressureClient) decoder0.readServiceInterface(8, false, PressureClient.MANAGER);
        int readInt = decoder0.readInt(16);
        result.source = readInt;
        PressureSource.validate(readInt);
        result.source = PressureSource.toKnownValue(result.source);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, PressureClient.MANAGER);
      encoder0.encode(this.source, 16);
    }
  }

  static final class PressureManagerAddClientResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PressureManagerAddClientResponseParams(int version) {
      super(16, version);
    }

    public PressureManagerAddClientResponseParams() {
      this(0);
    }

    public static PressureManagerAddClientResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PressureManagerAddClientResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PressureManagerAddClientResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PressureManagerAddClientResponseParams result =
            new PressureManagerAddClientResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PressureStatus.validate(readInt);
        result.status = PressureStatus.toKnownValue(result.status);
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

  static class PressureManagerAddClientResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PressureManager.AddClient_Response mCallback;

    PressureManagerAddClientResponseParamsForwardToCallback(
        PressureManager.AddClient_Response callback) {
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
        PressureManagerAddClientResponseParams response =
            PressureManagerAddClientResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PressureManagerAddClientResponseParamsProxyToResponder
      implements PressureManager.AddClient_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PressureManagerAddClientResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      PressureManagerAddClientResponseParams _response =
          new PressureManagerAddClientResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
