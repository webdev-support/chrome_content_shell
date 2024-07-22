package org.chromium.network.mojom;

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

class CustomProxyConfigClient_Internal {
  public static final Interface.Manager<CustomProxyConfigClient, CustomProxyConfigClient.Proxy>
      MANAGER =
          new Interface.Manager<CustomProxyConfigClient, CustomProxyConfigClient.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.CustomProxyConfigClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CustomProxyConfigClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CustomProxyConfigClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public CustomProxyConfigClient[] buildArray(int size) {
              return new CustomProxyConfigClient[size];
            }
          };
  private static final int ON_CUSTOM_PROXY_CONFIG_UPDATED_ORDINAL = 0;

  CustomProxyConfigClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CustomProxyConfigClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onCustomProxyConfigUpdated(
        CustomProxyConfig proxyConfig,
        CustomProxyConfigClient.OnCustomProxyConfigUpdated_Response callback) {
      CustomProxyConfigClientOnCustomProxyConfigUpdatedParams _message =
          new CustomProxyConfigClientOnCustomProxyConfigUpdatedParams();
      _message.proxyConfig = proxyConfig;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<CustomProxyConfigClient> {
    Stub(Core core, CustomProxyConfigClient impl) {
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
                CustomProxyConfigClient_Internal.MANAGER, messageWithHeader);
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
                getCore(), CustomProxyConfigClient_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CustomProxyConfigClientOnCustomProxyConfigUpdatedParams data =
                CustomProxyConfigClientOnCustomProxyConfigUpdatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onCustomProxyConfigUpdated(
                    data.proxyConfig,
                    new CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParamsProxyToResponder(
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

  static final class CustomProxyConfigClientOnCustomProxyConfigUpdatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CustomProxyConfig proxyConfig;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CustomProxyConfigClientOnCustomProxyConfigUpdatedParams(int version) {
      super(16, version);
    }

    public CustomProxyConfigClientOnCustomProxyConfigUpdatedParams() {
      this(0);
    }

    public static CustomProxyConfigClientOnCustomProxyConfigUpdatedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CustomProxyConfigClientOnCustomProxyConfigUpdatedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CustomProxyConfigClientOnCustomProxyConfigUpdatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CustomProxyConfigClientOnCustomProxyConfigUpdatedParams result =
            new CustomProxyConfigClientOnCustomProxyConfigUpdatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.proxyConfig = CustomProxyConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.proxyConfig, 8, false);
    }
  }

  static final class CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams(int version) {
      super(8, version);
    }

    public CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams() {
      this(0);
    }

    public static CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams result =
            new CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams(elementsOrVersion);
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

  static class CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CustomProxyConfigClient.OnCustomProxyConfigUpdated_Response mCallback;

    CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParamsForwardToCallback(
        CustomProxyConfigClient.OnCustomProxyConfigUpdated_Response callback) {
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

  static class CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParamsProxyToResponder
      implements CustomProxyConfigClient.OnCustomProxyConfigUpdated_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams _response =
          new CustomProxyConfigClientOnCustomProxyConfigUpdatedResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
