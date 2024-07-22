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

class OutputProtection_Internal {
  private static final int ENABLE_PROTECTION_ORDINAL = 1;
  public static final Interface.Manager<OutputProtection, OutputProtection.Proxy> MANAGER =
      new Interface.Manager<OutputProtection, OutputProtection.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.OutputProtection";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public OutputProtection.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, OutputProtection impl) {
          return new Stub(core, impl);
        }

        @Override
        public OutputProtection[] buildArray(int size) {
          return new OutputProtection[size];
        }
      };
  private static final int QUERY_STATUS_ORDINAL = 0;

  OutputProtection_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements OutputProtection.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void queryStatus(QueryStatus_Response callback) {
      OutputProtectionQueryStatusParams _message = new OutputProtectionQueryStatusParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new OutputProtectionQueryStatusResponseParamsForwardToCallback(callback));
    }

    @Override
    public void enableProtection(int desiredProtectionMask, EnableProtection_Response callback) {
      OutputProtectionEnableProtectionParams _message =
          new OutputProtectionEnableProtectionParams();
      _message.desiredProtectionMask = desiredProtectionMask;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new OutputProtectionEnableProtectionResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<OutputProtection> {
    Stub(Core core, OutputProtection impl) {
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
                OutputProtection_Internal.MANAGER, messageWithHeader);
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
                getCore(), OutputProtection_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            OutputProtectionQueryStatusParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .queryStatus(
                    new OutputProtectionQueryStatusResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            OutputProtectionEnableProtectionParams data =
                OutputProtectionEnableProtectionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .enableProtection(
                    data.desiredProtectionMask,
                    new OutputProtectionEnableProtectionResponseParamsProxyToResponder(
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

  static final class OutputProtectionQueryStatusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OutputProtectionQueryStatusParams(int version) {
      super(8, version);
    }

    public OutputProtectionQueryStatusParams() {
      this(0);
    }

    public static OutputProtectionQueryStatusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OutputProtectionQueryStatusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OutputProtectionQueryStatusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OutputProtectionQueryStatusParams result =
            new OutputProtectionQueryStatusParams(elementsOrVersion);
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

  static final class OutputProtectionQueryStatusResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int linkMask;
    public int protectionMask;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OutputProtectionQueryStatusResponseParams(int version) {
      super(24, version);
    }

    public OutputProtectionQueryStatusResponseParams() {
      this(0);
    }

    public static OutputProtectionQueryStatusResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OutputProtectionQueryStatusResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OutputProtectionQueryStatusResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OutputProtectionQueryStatusResponseParams result =
            new OutputProtectionQueryStatusResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        result.linkMask = decoder0.readInt(12);
        result.protectionMask = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode(this.linkMask, 12);
      encoder0.encode(this.protectionMask, 16);
    }
  }

  static class OutputProtectionQueryStatusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final OutputProtection.QueryStatus_Response mCallback;

    OutputProtectionQueryStatusResponseParamsForwardToCallback(
        OutputProtection.QueryStatus_Response callback) {
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
        OutputProtectionQueryStatusResponseParams response =
            OutputProtectionQueryStatusResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.linkMask, response.protectionMask);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class OutputProtectionQueryStatusResponseParamsProxyToResponder
      implements OutputProtection.QueryStatus_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    OutputProtectionQueryStatusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, int linkMask, int protectionMask) {
      OutputProtectionQueryStatusResponseParams _response =
          new OutputProtectionQueryStatusResponseParams();
      _response.success = success;
      _response.linkMask = linkMask;
      _response.protectionMask = protectionMask;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class OutputProtectionEnableProtectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int desiredProtectionMask;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OutputProtectionEnableProtectionParams(int version) {
      super(16, version);
    }

    public OutputProtectionEnableProtectionParams() {
      this(0);
    }

    public static OutputProtectionEnableProtectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OutputProtectionEnableProtectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OutputProtectionEnableProtectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OutputProtectionEnableProtectionParams result =
            new OutputProtectionEnableProtectionParams(elementsOrVersion);
        result.desiredProtectionMask = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.desiredProtectionMask, 8);
    }
  }

  static final class OutputProtectionEnableProtectionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OutputProtectionEnableProtectionResponseParams(int version) {
      super(16, version);
    }

    public OutputProtectionEnableProtectionResponseParams() {
      this(0);
    }

    public static OutputProtectionEnableProtectionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OutputProtectionEnableProtectionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OutputProtectionEnableProtectionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OutputProtectionEnableProtectionResponseParams result =
            new OutputProtectionEnableProtectionResponseParams(elementsOrVersion);
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

  static class OutputProtectionEnableProtectionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final OutputProtection.EnableProtection_Response mCallback;

    OutputProtectionEnableProtectionResponseParamsForwardToCallback(
        OutputProtection.EnableProtection_Response callback) {
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
        OutputProtectionEnableProtectionResponseParams response =
            OutputProtectionEnableProtectionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class OutputProtectionEnableProtectionResponseParamsProxyToResponder
      implements OutputProtection.EnableProtection_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    OutputProtectionEnableProtectionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      OutputProtectionEnableProtectionResponseParams _response =
          new OutputProtectionEnableProtectionResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
