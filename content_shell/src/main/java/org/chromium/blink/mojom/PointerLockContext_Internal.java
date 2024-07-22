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

class PointerLockContext_Internal {
  public static final Interface.Manager<PointerLockContext, PointerLockContext.Proxy> MANAGER =
      new Interface.Manager<PointerLockContext, PointerLockContext.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PointerLockContext";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PointerLockContext.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PointerLockContext impl) {
          return new Stub(core, impl);
        }

        @Override
        public PointerLockContext[] buildArray(int size) {
          return new PointerLockContext[size];
        }
      };
  private static final int REQUEST_MOUSE_LOCK_CHANGE_ORDINAL = 0;

  PointerLockContext_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PointerLockContext.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestMouseLockChange(
        boolean unadjustedMovement, RequestMouseLockChange_Response callback) {
      PointerLockContextRequestMouseLockChangeParams _message =
          new PointerLockContextRequestMouseLockChangeParams();
      _message.unadjustedMovement = unadjustedMovement;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new PointerLockContextRequestMouseLockChangeResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<PointerLockContext> {
    Stub(Core core, PointerLockContext impl) {
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
                PointerLockContext_Internal.MANAGER, messageWithHeader);
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
                getCore(), PointerLockContext_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            PointerLockContextRequestMouseLockChangeParams data =
                PointerLockContextRequestMouseLockChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestMouseLockChange(
                    data.unadjustedMovement,
                    new PointerLockContextRequestMouseLockChangeResponseParamsProxyToResponder(
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

  static final class PointerLockContextRequestMouseLockChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean unadjustedMovement;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PointerLockContextRequestMouseLockChangeParams(int version) {
      super(16, version);
    }

    public PointerLockContextRequestMouseLockChangeParams() {
      this(0);
    }

    public static PointerLockContextRequestMouseLockChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PointerLockContextRequestMouseLockChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PointerLockContextRequestMouseLockChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PointerLockContextRequestMouseLockChangeParams result =
            new PointerLockContextRequestMouseLockChangeParams(elementsOrVersion);
        result.unadjustedMovement = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.unadjustedMovement, 8, 0);
    }
  }

  static final class PointerLockContextRequestMouseLockChangeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PointerLockContextRequestMouseLockChangeResponseParams(int version) {
      super(16, version);
    }

    public PointerLockContextRequestMouseLockChangeResponseParams() {
      this(0);
    }

    public static PointerLockContextRequestMouseLockChangeResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PointerLockContextRequestMouseLockChangeResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PointerLockContextRequestMouseLockChangeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PointerLockContextRequestMouseLockChangeResponseParams result =
            new PointerLockContextRequestMouseLockChangeResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        PointerLockResult.validate(readInt);
        result.result = PointerLockResult.toKnownValue(result.result);
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

  static class PointerLockContextRequestMouseLockChangeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PointerLockContext.RequestMouseLockChange_Response mCallback;

    PointerLockContextRequestMouseLockChangeResponseParamsForwardToCallback(
        PointerLockContext.RequestMouseLockChange_Response callback) {
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
        PointerLockContextRequestMouseLockChangeResponseParams response =
            PointerLockContextRequestMouseLockChangeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PointerLockContextRequestMouseLockChangeResponseParamsProxyToResponder
      implements PointerLockContext.RequestMouseLockChange_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PointerLockContextRequestMouseLockChangeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      PointerLockContextRequestMouseLockChangeResponseParams _response =
          new PointerLockContextRequestMouseLockChangeResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
