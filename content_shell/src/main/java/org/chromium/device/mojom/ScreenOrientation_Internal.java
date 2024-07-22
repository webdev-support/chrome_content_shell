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

class ScreenOrientation_Internal {
  private static final int LOCK_ORIENTATION_ORDINAL = 0;
  public static final Interface.Manager<ScreenOrientation, ScreenOrientation.Proxy> MANAGER =
      new Interface.Manager<ScreenOrientation, ScreenOrientation.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.ScreenOrientation";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ScreenOrientation.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ScreenOrientation impl) {
          return new Stub(core, impl);
        }

        @Override
        public ScreenOrientation[] buildArray(int size) {
          return new ScreenOrientation[size];
        }
      };
  private static final int UNLOCK_ORIENTATION_ORDINAL = 1;

  ScreenOrientation_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ScreenOrientation.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void lockOrientation(int orientation, LockOrientation_Response callback) {
      ScreenOrientationLockOrientationParams _message =
          new ScreenOrientationLockOrientationParams();
      _message.orientation = orientation;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ScreenOrientationLockOrientationResponseParamsForwardToCallback(callback));
    }

    @Override
    public void unlockOrientation() {
      ScreenOrientationUnlockOrientationParams _message =
          new ScreenOrientationUnlockOrientationParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<ScreenOrientation> {
    Stub(Core core, ScreenOrientation impl) {
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
                ScreenOrientation_Internal.MANAGER, messageWithHeader);
          case 1:
            ScreenOrientationUnlockOrientationParams.deserialize(messageWithHeader.getPayload());
            getImpl().unlockOrientation();
            return true;
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
                getCore(), ScreenOrientation_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ScreenOrientationLockOrientationParams data =
                ScreenOrientationLockOrientationParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .lockOrientation(
                    data.orientation,
                    new ScreenOrientationLockOrientationResponseParamsProxyToResponder(
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

  static final class ScreenOrientationLockOrientationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int orientation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ScreenOrientationLockOrientationParams(int version) {
      super(16, version);
    }

    public ScreenOrientationLockOrientationParams() {
      this(0);
    }

    public static ScreenOrientationLockOrientationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ScreenOrientationLockOrientationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ScreenOrientationLockOrientationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ScreenOrientationLockOrientationParams result =
            new ScreenOrientationLockOrientationParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.orientation = readInt;
        ScreenOrientationLockType.validate(readInt);
        result.orientation = ScreenOrientationLockType.toKnownValue(result.orientation);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.orientation, 8);
    }
  }

  static final class ScreenOrientationLockOrientationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ScreenOrientationLockOrientationResponseParams(int version) {
      super(16, version);
    }

    public ScreenOrientationLockOrientationResponseParams() {
      this(0);
    }

    public static ScreenOrientationLockOrientationResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ScreenOrientationLockOrientationResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ScreenOrientationLockOrientationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ScreenOrientationLockOrientationResponseParams result =
            new ScreenOrientationLockOrientationResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        ScreenOrientationLockResult.validate(readInt);
        result.result = ScreenOrientationLockResult.toKnownValue(result.result);
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

  static class ScreenOrientationLockOrientationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ScreenOrientation.LockOrientation_Response mCallback;

    ScreenOrientationLockOrientationResponseParamsForwardToCallback(
        ScreenOrientation.LockOrientation_Response callback) {
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
        ScreenOrientationLockOrientationResponseParams response =
            ScreenOrientationLockOrientationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ScreenOrientationLockOrientationResponseParamsProxyToResponder
      implements ScreenOrientation.LockOrientation_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ScreenOrientationLockOrientationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      ScreenOrientationLockOrientationResponseParams _response =
          new ScreenOrientationLockOrientationResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ScreenOrientationUnlockOrientationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ScreenOrientationUnlockOrientationParams(int version) {
      super(8, version);
    }

    public ScreenOrientationUnlockOrientationParams() {
      this(0);
    }

    public static ScreenOrientationUnlockOrientationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ScreenOrientationUnlockOrientationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ScreenOrientationUnlockOrientationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ScreenOrientationUnlockOrientationParams result =
            new ScreenOrientationUnlockOrientationParams(elementsOrVersion);
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
}
