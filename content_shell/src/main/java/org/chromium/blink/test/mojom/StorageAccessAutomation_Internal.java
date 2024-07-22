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

class StorageAccessAutomation_Internal {
  public static final Interface.Manager<StorageAccessAutomation, StorageAccessAutomation.Proxy>
      MANAGER =
          new Interface.Manager<StorageAccessAutomation, StorageAccessAutomation.Proxy>() {
            @Override
            public String getName() {
              return "blink.test.mojom.StorageAccessAutomation";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public StorageAccessAutomation.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, StorageAccessAutomation impl) {
              return new Stub(core, impl);
            }

            @Override
            public StorageAccessAutomation[] buildArray(int size) {
              return new StorageAccessAutomation[size];
            }
          };
  private static final int SET_STORAGE_ACCESS_ORDINAL = 0;

  StorageAccessAutomation_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements StorageAccessAutomation.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setStorageAccess(
        String origin,
        String embeddingOrigin,
        boolean allowed,
        SetStorageAccess_Response callback) {
      StorageAccessAutomationSetStorageAccessParams _message =
          new StorageAccessAutomationSetStorageAccessParams();
      _message.origin = origin;
      _message.embeddingOrigin = embeddingOrigin;
      _message.allowed = allowed;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new StorageAccessAutomationSetStorageAccessResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<StorageAccessAutomation> {
    Stub(Core core, StorageAccessAutomation impl) {
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
                StorageAccessAutomation_Internal.MANAGER, messageWithHeader);
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
                getCore(), StorageAccessAutomation_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            StorageAccessAutomationSetStorageAccessParams data =
                StorageAccessAutomationSetStorageAccessParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setStorageAccess(
                    data.origin,
                    data.embeddingOrigin,
                    data.allowed,
                    new StorageAccessAutomationSetStorageAccessResponseParamsProxyToResponder(
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

  static final class StorageAccessAutomationSetStorageAccessParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allowed;
    public String embeddingOrigin;
    public String origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StorageAccessAutomationSetStorageAccessParams(int version) {
      super(32, version);
    }

    public StorageAccessAutomationSetStorageAccessParams() {
      this(0);
    }

    public static StorageAccessAutomationSetStorageAccessParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StorageAccessAutomationSetStorageAccessParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StorageAccessAutomationSetStorageAccessParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StorageAccessAutomationSetStorageAccessParams result =
            new StorageAccessAutomationSetStorageAccessParams(elementsOrVersion);
        result.origin = decoder0.readString(8, false);
        result.embeddingOrigin = decoder0.readString(16, false);
        result.allowed = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.origin, 8, false);
      encoder0.encode(this.embeddingOrigin, 16, false);
      encoder0.encode(this.allowed, 24, 0);
    }
  }

  static final class StorageAccessAutomationSetStorageAccessResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StorageAccessAutomationSetStorageAccessResponseParams(int version) {
      super(16, version);
    }

    public StorageAccessAutomationSetStorageAccessResponseParams() {
      this(0);
    }

    public static StorageAccessAutomationSetStorageAccessResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static StorageAccessAutomationSetStorageAccessResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StorageAccessAutomationSetStorageAccessResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StorageAccessAutomationSetStorageAccessResponseParams result =
            new StorageAccessAutomationSetStorageAccessResponseParams(elementsOrVersion);
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

  static class StorageAccessAutomationSetStorageAccessResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StorageAccessAutomation.SetStorageAccess_Response mCallback;

    StorageAccessAutomationSetStorageAccessResponseParamsForwardToCallback(
        StorageAccessAutomation.SetStorageAccess_Response callback) {
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
        StorageAccessAutomationSetStorageAccessResponseParams response =
            StorageAccessAutomationSetStorageAccessResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StorageAccessAutomationSetStorageAccessResponseParamsProxyToResponder
      implements StorageAccessAutomation.SetStorageAccess_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StorageAccessAutomationSetStorageAccessResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      StorageAccessAutomationSetStorageAccessResponseParams _response =
          new StorageAccessAutomationSetStorageAccessResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
