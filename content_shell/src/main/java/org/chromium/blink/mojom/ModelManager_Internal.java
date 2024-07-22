package org.chromium.blink.mojom;

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

class ModelManager_Internal {
  private static final int CAN_CREATE_GENERIC_SESSION_ORDINAL = 0;
  private static final int CREATE_GENERIC_SESSION_ORDINAL = 1;
  public static final Interface.Manager<ModelManager, ModelManager.Proxy> MANAGER =
      new Interface.Manager<ModelManager, ModelManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ModelManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ModelManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ModelManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public ModelManager[] buildArray(int size) {
          return new ModelManager[size];
        }
      };

  ModelManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements ModelManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void canCreateGenericSession(CanCreateGenericSession_Response callback) {
      ModelManagerCanCreateGenericSessionParams _message =
          new ModelManagerCanCreateGenericSessionParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ModelManagerCanCreateGenericSessionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createGenericSession(
        InterfaceRequest<ModelGenericSession> session, CreateGenericSession_Response callback) {
      ModelManagerCreateGenericSessionParams _message =
          new ModelManagerCreateGenericSessionParams();
      _message.session = session;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ModelManagerCreateGenericSessionResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ModelManager> {
    Stub(Core core, ModelManager impl) {
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
                ModelManager_Internal.MANAGER, messageWithHeader);
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
                getCore(), ModelManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ModelManagerCanCreateGenericSessionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .canCreateGenericSession(
                    new ModelManagerCanCreateGenericSessionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            ModelManagerCreateGenericSessionParams data =
                ModelManagerCreateGenericSessionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createGenericSession(
                    data.session,
                    new ModelManagerCreateGenericSessionResponseParamsProxyToResponder(
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

  static final class ModelManagerCanCreateGenericSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ModelManagerCanCreateGenericSessionParams(int version) {
      super(8, version);
    }

    public ModelManagerCanCreateGenericSessionParams() {
      this(0);
    }

    public static ModelManagerCanCreateGenericSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ModelManagerCanCreateGenericSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ModelManagerCanCreateGenericSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ModelManagerCanCreateGenericSessionParams result =
            new ModelManagerCanCreateGenericSessionParams(elementsOrVersion);
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

  static final class ModelManagerCanCreateGenericSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean canCreate;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ModelManagerCanCreateGenericSessionResponseParams(int version) {
      super(16, version);
    }

    public ModelManagerCanCreateGenericSessionResponseParams() {
      this(0);
    }

    public static ModelManagerCanCreateGenericSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ModelManagerCanCreateGenericSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ModelManagerCanCreateGenericSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ModelManagerCanCreateGenericSessionResponseParams result =
            new ModelManagerCanCreateGenericSessionResponseParams(elementsOrVersion);
        result.canCreate = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.canCreate, 8, 0);
    }
  }

  static class ModelManagerCanCreateGenericSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ModelManager.CanCreateGenericSession_Response mCallback;

    ModelManagerCanCreateGenericSessionResponseParamsForwardToCallback(
        ModelManager.CanCreateGenericSession_Response callback) {
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
        ModelManagerCanCreateGenericSessionResponseParams response =
            ModelManagerCanCreateGenericSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.canCreate);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ModelManagerCanCreateGenericSessionResponseParamsProxyToResponder
      implements ModelManager.CanCreateGenericSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ModelManagerCanCreateGenericSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean canCreate) {
      ModelManagerCanCreateGenericSessionResponseParams _response =
          new ModelManagerCanCreateGenericSessionResponseParams();
      _response.canCreate = canCreate;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ModelManagerCreateGenericSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<ModelGenericSession> session;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ModelManagerCreateGenericSessionParams(int version) {
      super(16, version);
    }

    public ModelManagerCreateGenericSessionParams() {
      this(0);
    }

    public static ModelManagerCreateGenericSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ModelManagerCreateGenericSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ModelManagerCreateGenericSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ModelManagerCreateGenericSessionParams result =
            new ModelManagerCreateGenericSessionParams(elementsOrVersion);
        result.session = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.session, 8, false);
    }
  }

  static final class ModelManagerCreateGenericSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ModelManagerCreateGenericSessionResponseParams(int version) {
      super(16, version);
    }

    public ModelManagerCreateGenericSessionResponseParams() {
      this(0);
    }

    public static ModelManagerCreateGenericSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ModelManagerCreateGenericSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ModelManagerCreateGenericSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ModelManagerCreateGenericSessionResponseParams result =
            new ModelManagerCreateGenericSessionResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class ModelManagerCreateGenericSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ModelManager.CreateGenericSession_Response mCallback;

    ModelManagerCreateGenericSessionResponseParamsForwardToCallback(
        ModelManager.CreateGenericSession_Response callback) {
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
        ModelManagerCreateGenericSessionResponseParams response =
            ModelManagerCreateGenericSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ModelManagerCreateGenericSessionResponseParamsProxyToResponder
      implements ModelManager.CreateGenericSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ModelManagerCreateGenericSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      ModelManagerCreateGenericSessionResponseParams _response =
          new ModelManagerCreateGenericSessionResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
