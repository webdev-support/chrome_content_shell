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

class EyeDropperChooser_Internal {
  private static final int CHOOSE_ORDINAL = 0;
  public static final Interface.Manager<EyeDropperChooser, EyeDropperChooser.Proxy> MANAGER =
      new Interface.Manager<EyeDropperChooser, EyeDropperChooser.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.EyeDropperChooser";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public EyeDropperChooser.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, EyeDropperChooser impl) {
          return new Stub(core, impl);
        }

        @Override
        public EyeDropperChooser[] buildArray(int size) {
          return new EyeDropperChooser[size];
        }
      };

  EyeDropperChooser_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements EyeDropperChooser.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void choose(Choose_Response callback) {
      EyeDropperChooserChooseParams _message = new EyeDropperChooserChooseParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new EyeDropperChooserChooseResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<EyeDropperChooser> {
    Stub(Core core, EyeDropperChooser impl) {
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
                EyeDropperChooser_Internal.MANAGER, messageWithHeader);
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
                getCore(), EyeDropperChooser_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            EyeDropperChooserChooseParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .choose(
                    new EyeDropperChooserChooseResponseParamsProxyToResponder(
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

  static final class EyeDropperChooserChooseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EyeDropperChooserChooseParams(int version) {
      super(8, version);
    }

    public EyeDropperChooserChooseParams() {
      this(0);
    }

    public static EyeDropperChooserChooseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EyeDropperChooserChooseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EyeDropperChooserChooseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EyeDropperChooserChooseParams result = new EyeDropperChooserChooseParams(elementsOrVersion);
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

  static final class EyeDropperChooserChooseResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int color;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EyeDropperChooserChooseResponseParams(int version) {
      super(16, version);
    }

    public EyeDropperChooserChooseResponseParams() {
      this(0);
    }

    public static EyeDropperChooserChooseResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EyeDropperChooserChooseResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EyeDropperChooserChooseResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EyeDropperChooserChooseResponseParams result =
            new EyeDropperChooserChooseResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        result.color = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode(this.color, 12);
    }
  }

  static class EyeDropperChooserChooseResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final EyeDropperChooser.Choose_Response mCallback;

    EyeDropperChooserChooseResponseParamsForwardToCallback(
        EyeDropperChooser.Choose_Response callback) {
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
        EyeDropperChooserChooseResponseParams response =
            EyeDropperChooserChooseResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.color);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class EyeDropperChooserChooseResponseParamsProxyToResponder
      implements EyeDropperChooser.Choose_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    EyeDropperChooserChooseResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, int color) {
      EyeDropperChooserChooseResponseParams _response = new EyeDropperChooserChooseResponseParams();
      _response.success = success;
      _response.color = color;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
