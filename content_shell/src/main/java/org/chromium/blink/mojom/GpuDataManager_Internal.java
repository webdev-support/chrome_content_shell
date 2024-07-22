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
import org.chromium.url.mojom.Url;

class GpuDataManager_Internal {
  private static final int ARE3_DAP_IS_BLOCKED_FOR_URL_ORDINAL = 0;
  public static final Interface.Manager<GpuDataManager, GpuDataManager.Proxy> MANAGER =
      new Interface.Manager<GpuDataManager, GpuDataManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.GpuDataManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public GpuDataManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, GpuDataManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public GpuDataManager[] buildArray(int size) {
          return new GpuDataManager[size];
        }
      };

  GpuDataManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements GpuDataManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void are3DapIsBlockedForUrl(Url url, Are3DapIsBlockedForUrl_Response callback) {
      GpuDataManagerAre3DapIsBlockedForUrlParams _message =
          new GpuDataManagerAre3DapIsBlockedForUrlParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new GpuDataManagerAre3DapIsBlockedForUrlResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<GpuDataManager> {
    Stub(Core core, GpuDataManager impl) {
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
                GpuDataManager_Internal.MANAGER, messageWithHeader);
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
                getCore(), GpuDataManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            GpuDataManagerAre3DapIsBlockedForUrlParams data =
                GpuDataManagerAre3DapIsBlockedForUrlParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .are3DapIsBlockedForUrl(
                    data.url,
                    new GpuDataManagerAre3DapIsBlockedForUrlResponseParamsProxyToResponder(
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

  static final class GpuDataManagerAre3DapIsBlockedForUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuDataManagerAre3DapIsBlockedForUrlParams(int version) {
      super(16, version);
    }

    public GpuDataManagerAre3DapIsBlockedForUrlParams() {
      this(0);
    }

    public static GpuDataManagerAre3DapIsBlockedForUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuDataManagerAre3DapIsBlockedForUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuDataManagerAre3DapIsBlockedForUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuDataManagerAre3DapIsBlockedForUrlParams result =
            new GpuDataManagerAre3DapIsBlockedForUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class GpuDataManagerAre3DapIsBlockedForUrlResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean blocked;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuDataManagerAre3DapIsBlockedForUrlResponseParams(int version) {
      super(16, version);
    }

    public GpuDataManagerAre3DapIsBlockedForUrlResponseParams() {
      this(0);
    }

    public static GpuDataManagerAre3DapIsBlockedForUrlResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuDataManagerAre3DapIsBlockedForUrlResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuDataManagerAre3DapIsBlockedForUrlResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuDataManagerAre3DapIsBlockedForUrlResponseParams result =
            new GpuDataManagerAre3DapIsBlockedForUrlResponseParams(elementsOrVersion);
        result.blocked = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.blocked, 8, 0);
    }
  }

  static class GpuDataManagerAre3DapIsBlockedForUrlResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final GpuDataManager.Are3DapIsBlockedForUrl_Response mCallback;

    GpuDataManagerAre3DapIsBlockedForUrlResponseParamsForwardToCallback(
        GpuDataManager.Are3DapIsBlockedForUrl_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 6)) {
          return false;
        }
        GpuDataManagerAre3DapIsBlockedForUrlResponseParams response =
            GpuDataManagerAre3DapIsBlockedForUrlResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.blocked);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class GpuDataManagerAre3DapIsBlockedForUrlResponseParamsProxyToResponder
      implements GpuDataManager.Are3DapIsBlockedForUrl_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    GpuDataManagerAre3DapIsBlockedForUrlResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean blocked) {
      GpuDataManagerAre3DapIsBlockedForUrlResponseParams _response =
          new GpuDataManagerAre3DapIsBlockedForUrlResponseParams();
      _response.blocked = blocked;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
