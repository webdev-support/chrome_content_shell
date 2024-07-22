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

class VibrationManager_Internal {
  private static final int CANCEL_ORDINAL = 1;
  public static final Interface.Manager<VibrationManager, VibrationManager.Proxy> MANAGER =
      new Interface.Manager<VibrationManager, VibrationManager.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.VibrationManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public VibrationManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, VibrationManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public VibrationManager[] buildArray(int size) {
          return new VibrationManager[size];
        }
      };
  private static final int VIBRATE_ORDINAL = 0;

  VibrationManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VibrationManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void vibrate(long milliseconds, Vibrate_Response callback) {
      VibrationManagerVibrateParams _message = new VibrationManagerVibrateParams();
      _message.milliseconds = milliseconds;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new VibrationManagerVibrateResponseParamsForwardToCallback(callback));
    }

    @Override
    public void cancel(Cancel_Response callback) {
      VibrationManagerCancelParams _message = new VibrationManagerCancelParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new VibrationManagerCancelResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<VibrationManager> {
    Stub(Core core, VibrationManager impl) {
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
                VibrationManager_Internal.MANAGER, messageWithHeader);
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
                getCore(), VibrationManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            VibrationManagerVibrateParams data =
                VibrationManagerVibrateParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .vibrate(
                    data.milliseconds,
                    new VibrationManagerVibrateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            VibrationManagerCancelParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .cancel(
                    new VibrationManagerCancelResponseParamsProxyToResponder(
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

  static final class VibrationManagerVibrateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long milliseconds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VibrationManagerVibrateParams(int version) {
      super(16, version);
    }

    public VibrationManagerVibrateParams() {
      this(0);
    }

    public static VibrationManagerVibrateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VibrationManagerVibrateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VibrationManagerVibrateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VibrationManagerVibrateParams result = new VibrationManagerVibrateParams(elementsOrVersion);
        result.milliseconds = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.milliseconds, 8);
    }
  }

  static final class VibrationManagerVibrateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VibrationManagerVibrateResponseParams(int version) {
      super(8, version);
    }

    public VibrationManagerVibrateResponseParams() {
      this(0);
    }

    public static VibrationManagerVibrateResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VibrationManagerVibrateResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VibrationManagerVibrateResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VibrationManagerVibrateResponseParams result =
            new VibrationManagerVibrateResponseParams(elementsOrVersion);
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

  static class VibrationManagerVibrateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VibrationManager.Vibrate_Response mCallback;

    VibrationManagerVibrateResponseParamsForwardToCallback(
        VibrationManager.Vibrate_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VibrationManagerVibrateResponseParamsProxyToResponder
      implements VibrationManager.Vibrate_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VibrationManagerVibrateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      VibrationManagerVibrateResponseParams _response = new VibrationManagerVibrateResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VibrationManagerCancelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VibrationManagerCancelParams(int version) {
      super(8, version);
    }

    public VibrationManagerCancelParams() {
      this(0);
    }

    public static VibrationManagerCancelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VibrationManagerCancelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VibrationManagerCancelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VibrationManagerCancelParams result = new VibrationManagerCancelParams(elementsOrVersion);
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

  static final class VibrationManagerCancelResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VibrationManagerCancelResponseParams(int version) {
      super(8, version);
    }

    public VibrationManagerCancelResponseParams() {
      this(0);
    }

    public static VibrationManagerCancelResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VibrationManagerCancelResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VibrationManagerCancelResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VibrationManagerCancelResponseParams result =
            new VibrationManagerCancelResponseParams(elementsOrVersion);
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

  static class VibrationManagerCancelResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final VibrationManager.Cancel_Response mCallback;

    VibrationManagerCancelResponseParamsForwardToCallback(
        VibrationManager.Cancel_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VibrationManagerCancelResponseParamsProxyToResponder
      implements VibrationManager.Cancel_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VibrationManagerCancelResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      VibrationManagerCancelResponseParams _response = new VibrationManagerCancelResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
