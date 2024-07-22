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

class NonPersistentNotificationListener_Internal {
  public static final Interface.Manager<
          NonPersistentNotificationListener, NonPersistentNotificationListener.Proxy>
      MANAGER =
          new Interface.Manager<
              NonPersistentNotificationListener, NonPersistentNotificationListener.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.NonPersistentNotificationListener";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public NonPersistentNotificationListener.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, NonPersistentNotificationListener impl) {
              return new Stub(core, impl);
            }

            @Override
            public NonPersistentNotificationListener[] buildArray(int size) {
              return new NonPersistentNotificationListener[size];
            }
          };
  private static final int ON_CLICK_ORDINAL = 1;
  private static final int ON_CLOSE_ORDINAL = 2;
  private static final int ON_SHOW_ORDINAL = 0;

  NonPersistentNotificationListener_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements NonPersistentNotificationListener.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onShow() {
      NonPersistentNotificationListenerOnShowParams _message =
          new NonPersistentNotificationListenerOnShowParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onClick(OnClick_Response callback) {
      NonPersistentNotificationListenerOnClickParams _message =
          new NonPersistentNotificationListenerOnClickParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new NonPersistentNotificationListenerOnClickResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onClose(OnClose_Response callback) {
      NonPersistentNotificationListenerOnCloseParams _message =
          new NonPersistentNotificationListenerOnCloseParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new NonPersistentNotificationListenerOnCloseResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<NonPersistentNotificationListener> {
    Stub(Core core, NonPersistentNotificationListener impl) {
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
                NonPersistentNotificationListener_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            NonPersistentNotificationListenerOnShowParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onShow();
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
                getCore(),
                NonPersistentNotificationListener_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
          default:
            return false;
          case 1:
            NonPersistentNotificationListenerOnClickParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .onClick(
                    new NonPersistentNotificationListenerOnClickResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            NonPersistentNotificationListenerOnCloseParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .onClose(
                    new NonPersistentNotificationListenerOnCloseResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NonPersistentNotificationListenerOnShowParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NonPersistentNotificationListenerOnShowParams(int version) {
      super(8, version);
    }

    public NonPersistentNotificationListenerOnShowParams() {
      this(0);
    }

    public static NonPersistentNotificationListenerOnShowParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NonPersistentNotificationListenerOnShowParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NonPersistentNotificationListenerOnShowParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NonPersistentNotificationListenerOnShowParams result =
            new NonPersistentNotificationListenerOnShowParams(elementsOrVersion);
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

  static final class NonPersistentNotificationListenerOnClickParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NonPersistentNotificationListenerOnClickParams(int version) {
      super(8, version);
    }

    public NonPersistentNotificationListenerOnClickParams() {
      this(0);
    }

    public static NonPersistentNotificationListenerOnClickParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NonPersistentNotificationListenerOnClickParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NonPersistentNotificationListenerOnClickParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NonPersistentNotificationListenerOnClickParams result =
            new NonPersistentNotificationListenerOnClickParams(elementsOrVersion);
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

  static final class NonPersistentNotificationListenerOnClickResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NonPersistentNotificationListenerOnClickResponseParams(int version) {
      super(8, version);
    }

    public NonPersistentNotificationListenerOnClickResponseParams() {
      this(0);
    }

    public static NonPersistentNotificationListenerOnClickResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NonPersistentNotificationListenerOnClickResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NonPersistentNotificationListenerOnClickResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NonPersistentNotificationListenerOnClickResponseParams result =
            new NonPersistentNotificationListenerOnClickResponseParams(elementsOrVersion);
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

  static class NonPersistentNotificationListenerOnClickResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NonPersistentNotificationListener.OnClick_Response mCallback;

    NonPersistentNotificationListenerOnClickResponseParamsForwardToCallback(
        NonPersistentNotificationListener.OnClick_Response callback) {
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

  static class NonPersistentNotificationListenerOnClickResponseParamsProxyToResponder
      implements NonPersistentNotificationListener.OnClick_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NonPersistentNotificationListenerOnClickResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NonPersistentNotificationListenerOnClickResponseParams _response =
          new NonPersistentNotificationListenerOnClickResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NonPersistentNotificationListenerOnCloseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NonPersistentNotificationListenerOnCloseParams(int version) {
      super(8, version);
    }

    public NonPersistentNotificationListenerOnCloseParams() {
      this(0);
    }

    public static NonPersistentNotificationListenerOnCloseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NonPersistentNotificationListenerOnCloseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NonPersistentNotificationListenerOnCloseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NonPersistentNotificationListenerOnCloseParams result =
            new NonPersistentNotificationListenerOnCloseParams(elementsOrVersion);
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

  static final class NonPersistentNotificationListenerOnCloseResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NonPersistentNotificationListenerOnCloseResponseParams(int version) {
      super(8, version);
    }

    public NonPersistentNotificationListenerOnCloseResponseParams() {
      this(0);
    }

    public static NonPersistentNotificationListenerOnCloseResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NonPersistentNotificationListenerOnCloseResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NonPersistentNotificationListenerOnCloseResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NonPersistentNotificationListenerOnCloseResponseParams result =
            new NonPersistentNotificationListenerOnCloseResponseParams(elementsOrVersion);
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

  static class NonPersistentNotificationListenerOnCloseResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NonPersistentNotificationListener.OnClose_Response mCallback;

    NonPersistentNotificationListenerOnCloseResponseParamsForwardToCallback(
        NonPersistentNotificationListener.OnClose_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NonPersistentNotificationListenerOnCloseResponseParamsProxyToResponder
      implements NonPersistentNotificationListener.OnClose_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NonPersistentNotificationListenerOnCloseResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NonPersistentNotificationListenerOnCloseResponseParams _response =
          new NonPersistentNotificationListenerOnCloseResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
