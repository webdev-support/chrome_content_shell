package org.chromium.blink.test.mojom;

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

class VirtualAuthenticatorManager_Internal {
  private static final int CLEAR_AUTHENTICATORS_ORDINAL = 3;
  private static final int CREATE_AUTHENTICATOR_ORDINAL = 0;
  private static final int GET_AUTHENTICATORS_ORDINAL = 1;
  public static final Interface.Manager<
          VirtualAuthenticatorManager, VirtualAuthenticatorManager.Proxy>
      MANAGER =
          new Interface.Manager<VirtualAuthenticatorManager, VirtualAuthenticatorManager.Proxy>() {
            @Override
            public String getName() {
              return "blink.test.mojom.VirtualAuthenticatorManager";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public VirtualAuthenticatorManager.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, VirtualAuthenticatorManager impl) {
              return new Stub(core, impl);
            }

            @Override
            public VirtualAuthenticatorManager[] buildArray(int size) {
              return new VirtualAuthenticatorManager[size];
            }
          };
  private static final int REMOVE_AUTHENTICATOR_ORDINAL = 2;

  VirtualAuthenticatorManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VirtualAuthenticatorManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createAuthenticator(
        VirtualAuthenticatorOptions options, CreateAuthenticator_Response callback) {
      VirtualAuthenticatorManagerCreateAuthenticatorParams _message =
          new VirtualAuthenticatorManagerCreateAuthenticatorParams();
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getAuthenticators(GetAuthenticators_Response callback) {
      VirtualAuthenticatorManagerGetAuthenticatorsParams _message =
          new VirtualAuthenticatorManagerGetAuthenticatorsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void removeAuthenticator(String id, RemoveAuthenticator_Response callback) {
      VirtualAuthenticatorManagerRemoveAuthenticatorParams _message =
          new VirtualAuthenticatorManagerRemoveAuthenticatorParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clearAuthenticators(ClearAuthenticators_Response callback) {
      VirtualAuthenticatorManagerClearAuthenticatorsParams _message =
          new VirtualAuthenticatorManagerClearAuthenticatorsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<VirtualAuthenticatorManager> {
    Stub(Core core, VirtualAuthenticatorManager impl) {
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
                VirtualAuthenticatorManager_Internal.MANAGER, messageWithHeader);
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
                getCore(),
                VirtualAuthenticatorManager_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            VirtualAuthenticatorManagerCreateAuthenticatorParams data =
                VirtualAuthenticatorManagerCreateAuthenticatorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createAuthenticator(
                    data.options,
                    new VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            VirtualAuthenticatorManagerGetAuthenticatorsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getAuthenticators(
                    new VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            VirtualAuthenticatorManagerRemoveAuthenticatorParams data2 =
                VirtualAuthenticatorManagerRemoveAuthenticatorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .removeAuthenticator(
                    data2.id,
                    new VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            VirtualAuthenticatorManagerClearAuthenticatorsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .clearAuthenticators(
                    new VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsProxyToResponder(
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

  static final class VirtualAuthenticatorManagerCreateAuthenticatorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public VirtualAuthenticatorOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorManagerCreateAuthenticatorParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorManagerCreateAuthenticatorParams() {
      this(0);
    }

    public static VirtualAuthenticatorManagerCreateAuthenticatorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorManagerCreateAuthenticatorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorManagerCreateAuthenticatorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorManagerCreateAuthenticatorParams result =
            new VirtualAuthenticatorManagerCreateAuthenticatorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.options = VirtualAuthenticatorOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.options, 8, false);
    }
  }

  static final class VirtualAuthenticatorManagerCreateAuthenticatorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public VirtualAuthenticator authenticator;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorManagerCreateAuthenticatorResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorManagerCreateAuthenticatorResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorManagerCreateAuthenticatorResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorManagerCreateAuthenticatorResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorManagerCreateAuthenticatorResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorManagerCreateAuthenticatorResponseParams result =
            new VirtualAuthenticatorManagerCreateAuthenticatorResponseParams(elementsOrVersion);
        result.authenticator =
            (VirtualAuthenticator)
                decoder0.readServiceInterface(8, false, VirtualAuthenticator.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.authenticator, 8, false, VirtualAuthenticator.MANAGER);
    }
  }

  static class VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticatorManager.CreateAuthenticator_Response mCallback;

    VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsForwardToCallback(
        VirtualAuthenticatorManager.CreateAuthenticator_Response callback) {
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
        VirtualAuthenticatorManagerCreateAuthenticatorResponseParams response =
            VirtualAuthenticatorManagerCreateAuthenticatorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.authenticator);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsProxyToResponder
      implements VirtualAuthenticatorManager.CreateAuthenticator_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(VirtualAuthenticator authenticator) {
      VirtualAuthenticatorManagerCreateAuthenticatorResponseParams _response =
          new VirtualAuthenticatorManagerCreateAuthenticatorResponseParams();
      _response.authenticator = authenticator;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorManagerGetAuthenticatorsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorManagerGetAuthenticatorsParams(int version) {
      super(8, version);
    }

    public VirtualAuthenticatorManagerGetAuthenticatorsParams() {
      this(0);
    }

    public static VirtualAuthenticatorManagerGetAuthenticatorsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorManagerGetAuthenticatorsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorManagerGetAuthenticatorsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorManagerGetAuthenticatorsParams result =
            new VirtualAuthenticatorManagerGetAuthenticatorsParams(elementsOrVersion);
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

  static final class VirtualAuthenticatorManagerGetAuthenticatorsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public VirtualAuthenticator[] authenticators;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorManagerGetAuthenticatorsResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorManagerGetAuthenticatorsResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorManagerGetAuthenticatorsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorManagerGetAuthenticatorsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorManagerGetAuthenticatorsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorManagerGetAuthenticatorsResponseParams result =
            new VirtualAuthenticatorManagerGetAuthenticatorsResponseParams(elementsOrVersion);
        result.authenticators =
            (VirtualAuthenticator[])
                decoder0.readServiceInterfaces(8, 0, -1, VirtualAuthenticator.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.authenticators, 8, 0, -1, VirtualAuthenticator.MANAGER);
    }
  }

  static class VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticatorManager.GetAuthenticators_Response mCallback;

    VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsForwardToCallback(
        VirtualAuthenticatorManager.GetAuthenticators_Response callback) {
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
        VirtualAuthenticatorManagerGetAuthenticatorsResponseParams response =
            VirtualAuthenticatorManagerGetAuthenticatorsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.authenticators);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsProxyToResponder
      implements VirtualAuthenticatorManager.GetAuthenticators_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(VirtualAuthenticator[] authenticators) {
      VirtualAuthenticatorManagerGetAuthenticatorsResponseParams _response =
          new VirtualAuthenticatorManagerGetAuthenticatorsResponseParams();
      _response.authenticators = authenticators;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorManagerRemoveAuthenticatorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorManagerRemoveAuthenticatorParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorManagerRemoveAuthenticatorParams() {
      this(0);
    }

    public static VirtualAuthenticatorManagerRemoveAuthenticatorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorManagerRemoveAuthenticatorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorManagerRemoveAuthenticatorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorManagerRemoveAuthenticatorParams result =
            new VirtualAuthenticatorManagerRemoveAuthenticatorParams(elementsOrVersion);
        result.id = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8, false);
    }
  }

  static final class VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean removed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams result =
            new VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams(elementsOrVersion);
        result.removed = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.removed, 8, 0);
    }
  }

  static class VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticatorManager.RemoveAuthenticator_Response mCallback;

    VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsForwardToCallback(
        VirtualAuthenticatorManager.RemoveAuthenticator_Response callback) {
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
        VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams response =
            VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.removed);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsProxyToResponder
      implements VirtualAuthenticatorManager.RemoveAuthenticator_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean removed) {
      VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams _response =
          new VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams();
      _response.removed = removed;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorManagerClearAuthenticatorsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorManagerClearAuthenticatorsParams(int version) {
      super(8, version);
    }

    public VirtualAuthenticatorManagerClearAuthenticatorsParams() {
      this(0);
    }

    public static VirtualAuthenticatorManagerClearAuthenticatorsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorManagerClearAuthenticatorsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorManagerClearAuthenticatorsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorManagerClearAuthenticatorsParams result =
            new VirtualAuthenticatorManagerClearAuthenticatorsParams(elementsOrVersion);
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

  static final class VirtualAuthenticatorManagerClearAuthenticatorsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorManagerClearAuthenticatorsResponseParams(int version) {
      super(8, version);
    }

    public VirtualAuthenticatorManagerClearAuthenticatorsResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorManagerClearAuthenticatorsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorManagerClearAuthenticatorsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorManagerClearAuthenticatorsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorManagerClearAuthenticatorsResponseParams result =
            new VirtualAuthenticatorManagerClearAuthenticatorsResponseParams(elementsOrVersion);
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

  static class VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticatorManager.ClearAuthenticators_Response mCallback;

    VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsForwardToCallback(
        VirtualAuthenticatorManager.ClearAuthenticators_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsProxyToResponder
      implements VirtualAuthenticatorManager.ClearAuthenticators_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      VirtualAuthenticatorManagerClearAuthenticatorsResponseParams _response =
          new VirtualAuthenticatorManagerClearAuthenticatorsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
