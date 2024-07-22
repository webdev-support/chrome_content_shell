package org.chromium.media.mojom;

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

class AndroidOverlayClient_Internal {
  public static final Interface.Manager<AndroidOverlayClient, AndroidOverlayClient.Proxy> MANAGER =
      new Interface.Manager<AndroidOverlayClient, AndroidOverlayClient.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.AndroidOverlayClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AndroidOverlayClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AndroidOverlayClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public AndroidOverlayClient[] buildArray(int size) {
          return new AndroidOverlayClient[size];
        }
      };
  private static final int ON_DESTROYED_ORDINAL = 1;
  private static final int ON_POWER_EFFICIENT_STATE_ORDINAL = 3;
  private static final int ON_SURFACE_READY_ORDINAL = 0;
  private static final int ON_SYNCHRONOUSLY_DESTROYED_ORDINAL = 2;

  AndroidOverlayClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AndroidOverlayClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onSurfaceReady(long surfaceKey) {
      AndroidOverlayClientOnSurfaceReadyParams _message =
          new AndroidOverlayClientOnSurfaceReadyParams();
      _message.surfaceKey = surfaceKey;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onDestroyed() {
      AndroidOverlayClientOnDestroyedParams _message = new AndroidOverlayClientOnDestroyedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onSynchronouslyDestroyed(OnSynchronouslyDestroyed_Response callback) {
      AndroidOverlayClientOnSynchronouslyDestroyedParams _message =
          new AndroidOverlayClientOnSynchronouslyDestroyedParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new AndroidOverlayClientOnSynchronouslyDestroyedResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onPowerEfficientState(boolean isPowerEfficient) {
      AndroidOverlayClientOnPowerEfficientStateParams _message =
          new AndroidOverlayClientOnPowerEfficientStateParams();
      _message.isPowerEfficient = isPowerEfficient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<AndroidOverlayClient> {
    Stub(Core core, AndroidOverlayClient impl) {
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
                AndroidOverlayClient_Internal.MANAGER, messageWithHeader);
          case -1:
          case 2:
          default:
            return false;
          case 0:
            AndroidOverlayClientOnSurfaceReadyParams data =
                AndroidOverlayClientOnSurfaceReadyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onSurfaceReady(data.surfaceKey);
            return true;
          case 1:
            AndroidOverlayClientOnDestroyedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onDestroyed();
            return true;
          case 3:
            AndroidOverlayClientOnPowerEfficientStateParams data2 =
                AndroidOverlayClientOnPowerEfficientStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onPowerEfficientState(data2.isPowerEfficient);
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
                getCore(), AndroidOverlayClient_Internal.MANAGER, messageWithHeader, receiver);
          case 2:
            AndroidOverlayClientOnSynchronouslyDestroyedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .onSynchronouslyDestroyed(
                    new AndroidOverlayClientOnSynchronouslyDestroyedResponseParamsProxyToResponder(
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

  static final class AndroidOverlayClientOnSurfaceReadyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long surfaceKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AndroidOverlayClientOnSurfaceReadyParams(int version) {
      super(16, version);
    }

    public AndroidOverlayClientOnSurfaceReadyParams() {
      this(0);
    }

    public static AndroidOverlayClientOnSurfaceReadyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AndroidOverlayClientOnSurfaceReadyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AndroidOverlayClientOnSurfaceReadyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AndroidOverlayClientOnSurfaceReadyParams result =
            new AndroidOverlayClientOnSurfaceReadyParams(elementsOrVersion);
        result.surfaceKey = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.surfaceKey, 8);
    }
  }

  static final class AndroidOverlayClientOnDestroyedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AndroidOverlayClientOnDestroyedParams(int version) {
      super(8, version);
    }

    public AndroidOverlayClientOnDestroyedParams() {
      this(0);
    }

    public static AndroidOverlayClientOnDestroyedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AndroidOverlayClientOnDestroyedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AndroidOverlayClientOnDestroyedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AndroidOverlayClientOnDestroyedParams result =
            new AndroidOverlayClientOnDestroyedParams(elementsOrVersion);
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

  static final class AndroidOverlayClientOnSynchronouslyDestroyedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AndroidOverlayClientOnSynchronouslyDestroyedParams(int version) {
      super(8, version);
    }

    public AndroidOverlayClientOnSynchronouslyDestroyedParams() {
      this(0);
    }

    public static AndroidOverlayClientOnSynchronouslyDestroyedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AndroidOverlayClientOnSynchronouslyDestroyedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AndroidOverlayClientOnSynchronouslyDestroyedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AndroidOverlayClientOnSynchronouslyDestroyedParams result =
            new AndroidOverlayClientOnSynchronouslyDestroyedParams(elementsOrVersion);
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

  static final class AndroidOverlayClientOnSynchronouslyDestroyedResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AndroidOverlayClientOnSynchronouslyDestroyedResponseParams(int version) {
      super(8, version);
    }

    public AndroidOverlayClientOnSynchronouslyDestroyedResponseParams() {
      this(0);
    }

    public static AndroidOverlayClientOnSynchronouslyDestroyedResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AndroidOverlayClientOnSynchronouslyDestroyedResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AndroidOverlayClientOnSynchronouslyDestroyedResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AndroidOverlayClientOnSynchronouslyDestroyedResponseParams result =
            new AndroidOverlayClientOnSynchronouslyDestroyedResponseParams(elementsOrVersion);
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

  static class AndroidOverlayClientOnSynchronouslyDestroyedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AndroidOverlayClient.OnSynchronouslyDestroyed_Response mCallback;

    AndroidOverlayClientOnSynchronouslyDestroyedResponseParamsForwardToCallback(
        AndroidOverlayClient.OnSynchronouslyDestroyed_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AndroidOverlayClientOnSynchronouslyDestroyedResponseParamsProxyToResponder
      implements AndroidOverlayClient.OnSynchronouslyDestroyed_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AndroidOverlayClientOnSynchronouslyDestroyedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      AndroidOverlayClientOnSynchronouslyDestroyedResponseParams _response =
          new AndroidOverlayClientOnSynchronouslyDestroyedResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AndroidOverlayClientOnPowerEfficientStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isPowerEfficient;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AndroidOverlayClientOnPowerEfficientStateParams(int version) {
      super(16, version);
    }

    public AndroidOverlayClientOnPowerEfficientStateParams() {
      this(0);
    }

    public static AndroidOverlayClientOnPowerEfficientStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AndroidOverlayClientOnPowerEfficientStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AndroidOverlayClientOnPowerEfficientStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AndroidOverlayClientOnPowerEfficientStateParams result =
            new AndroidOverlayClientOnPowerEfficientStateParams(elementsOrVersion);
        result.isPowerEfficient = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isPowerEfficient, 8, 0);
    }
  }
}
