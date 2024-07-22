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

class ScreenOrientationListener_Internal {
  private static final int IS_AUTO_ROTATE_ENABLED_BY_USER_ORDINAL = 0;
  public static final Interface.Manager<ScreenOrientationListener, ScreenOrientationListener.Proxy>
      MANAGER =
          new Interface.Manager<ScreenOrientationListener, ScreenOrientationListener.Proxy>() {
            @Override
            public String getName() {
              return "device.mojom.ScreenOrientationListener";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ScreenOrientationListener.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ScreenOrientationListener impl) {
              return new Stub(core, impl);
            }

            @Override
            public ScreenOrientationListener[] buildArray(int size) {
              return new ScreenOrientationListener[size];
            }
          };

  ScreenOrientationListener_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ScreenOrientationListener.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void isAutoRotateEnabledByUser(IsAutoRotateEnabledByUser_Response callback) {
      ScreenOrientationListenerIsAutoRotateEnabledByUserParams _message =
          new ScreenOrientationListenerIsAutoRotateEnabledByUserParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<ScreenOrientationListener> {
    Stub(Core core, ScreenOrientationListener impl) {
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
                ScreenOrientationListener_Internal.MANAGER, messageWithHeader);
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
                getCore(), ScreenOrientationListener_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ScreenOrientationListenerIsAutoRotateEnabledByUserParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .isAutoRotateEnabledByUser(
                    new ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsProxyToResponder(
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

  static final class ScreenOrientationListenerIsAutoRotateEnabledByUserParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ScreenOrientationListenerIsAutoRotateEnabledByUserParams(int version) {
      super(8, version);
    }

    public ScreenOrientationListenerIsAutoRotateEnabledByUserParams() {
      this(0);
    }

    public static ScreenOrientationListenerIsAutoRotateEnabledByUserParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ScreenOrientationListenerIsAutoRotateEnabledByUserParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ScreenOrientationListenerIsAutoRotateEnabledByUserParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ScreenOrientationListenerIsAutoRotateEnabledByUserParams result =
            new ScreenOrientationListenerIsAutoRotateEnabledByUserParams(elementsOrVersion);
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

  static final class ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enabled;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams(int version) {
      super(16, version);
    }

    public ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams() {
      this(0);
    }

    public static ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams result =
            new ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams(elementsOrVersion);
        result.enabled = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enabled, 8, 0);
    }
  }

  static class ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ScreenOrientationListener.IsAutoRotateEnabledByUser_Response mCallback;

    ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsForwardToCallback(
        ScreenOrientationListener.IsAutoRotateEnabledByUser_Response callback) {
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
        ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams response =
            ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.enabled);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsProxyToResponder
      implements ScreenOrientationListener.IsAutoRotateEnabledByUser_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean enabled) {
      ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams _response =
          new ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams();
      _response.enabled = enabled;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
