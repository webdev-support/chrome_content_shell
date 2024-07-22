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

class QuotaManagerHost_Internal {
  private static final int ADD_CHANGE_LISTENER_ORDINAL = 0;
  public static final Interface.Manager<QuotaManagerHost, QuotaManagerHost.Proxy> MANAGER =
      new Interface.Manager<QuotaManagerHost, QuotaManagerHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.QuotaManagerHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public QuotaManagerHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, QuotaManagerHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public QuotaManagerHost[] buildArray(int size) {
          return new QuotaManagerHost[size];
        }
      };
  private static final int QUERY_STORAGE_USAGE_AND_QUOTA_ORDINAL = 1;

  QuotaManagerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements QuotaManagerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addChangeListener(
        QuotaChangeListener listener, AddChangeListener_Response callback) {
      QuotaManagerHostAddChangeListenerParams _message =
          new QuotaManagerHostAddChangeListenerParams();
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new QuotaManagerHostAddChangeListenerResponseParamsForwardToCallback(callback));
    }

    @Override
    public void queryStorageUsageAndQuota(QueryStorageUsageAndQuota_Response callback) {
      QuotaManagerHostQueryStorageUsageAndQuotaParams _message =
          new QuotaManagerHostQueryStorageUsageAndQuotaParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new QuotaManagerHostQueryStorageUsageAndQuotaResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<QuotaManagerHost> {
    Stub(Core core, QuotaManagerHost impl) {
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
                QuotaManagerHost_Internal.MANAGER, messageWithHeader);
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
                getCore(), QuotaManagerHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            QuotaManagerHostAddChangeListenerParams data =
                QuotaManagerHostAddChangeListenerParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addChangeListener(
                    data.listener,
                    new QuotaManagerHostAddChangeListenerResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            QuotaManagerHostQueryStorageUsageAndQuotaParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .queryStorageUsageAndQuota(
                    new QuotaManagerHostQueryStorageUsageAndQuotaResponseParamsProxyToResponder(
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

  static final class QuotaManagerHostAddChangeListenerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public QuotaChangeListener listener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private QuotaManagerHostAddChangeListenerParams(int version) {
      super(16, version);
    }

    public QuotaManagerHostAddChangeListenerParams() {
      this(0);
    }

    public static QuotaManagerHostAddChangeListenerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static QuotaManagerHostAddChangeListenerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static QuotaManagerHostAddChangeListenerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        QuotaManagerHostAddChangeListenerParams result =
            new QuotaManagerHostAddChangeListenerParams(elementsOrVersion);
        result.listener =
            (QuotaChangeListener)
                decoder0.readServiceInterface(8, false, QuotaChangeListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.listener, 8, false, QuotaChangeListener.MANAGER);
    }
  }

  static final class QuotaManagerHostAddChangeListenerResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private QuotaManagerHostAddChangeListenerResponseParams(int version) {
      super(8, version);
    }

    public QuotaManagerHostAddChangeListenerResponseParams() {
      this(0);
    }

    public static QuotaManagerHostAddChangeListenerResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static QuotaManagerHostAddChangeListenerResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static QuotaManagerHostAddChangeListenerResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        QuotaManagerHostAddChangeListenerResponseParams result =
            new QuotaManagerHostAddChangeListenerResponseParams(elementsOrVersion);
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

  static class QuotaManagerHostAddChangeListenerResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final QuotaManagerHost.AddChangeListener_Response mCallback;

    QuotaManagerHostAddChangeListenerResponseParamsForwardToCallback(
        QuotaManagerHost.AddChangeListener_Response callback) {
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

  static class QuotaManagerHostAddChangeListenerResponseParamsProxyToResponder
      implements QuotaManagerHost.AddChangeListener_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    QuotaManagerHostAddChangeListenerResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      QuotaManagerHostAddChangeListenerResponseParams _response =
          new QuotaManagerHostAddChangeListenerResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class QuotaManagerHostQueryStorageUsageAndQuotaParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private QuotaManagerHostQueryStorageUsageAndQuotaParams(int version) {
      super(8, version);
    }

    public QuotaManagerHostQueryStorageUsageAndQuotaParams() {
      this(0);
    }

    public static QuotaManagerHostQueryStorageUsageAndQuotaParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static QuotaManagerHostQueryStorageUsageAndQuotaParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static QuotaManagerHostQueryStorageUsageAndQuotaParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        QuotaManagerHostQueryStorageUsageAndQuotaParams result =
            new QuotaManagerHostQueryStorageUsageAndQuotaParams(elementsOrVersion);
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

  static final class QuotaManagerHostQueryStorageUsageAndQuotaResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public long currentQuota;
    public long currentUsage;
    public int error;
    public UsageBreakdown usageBreakdown;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private QuotaManagerHostQueryStorageUsageAndQuotaResponseParams(int version) {
      super(40, version);
    }

    public QuotaManagerHostQueryStorageUsageAndQuotaResponseParams() {
      this(0);
    }

    public static QuotaManagerHostQueryStorageUsageAndQuotaResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static QuotaManagerHostQueryStorageUsageAndQuotaResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static QuotaManagerHostQueryStorageUsageAndQuotaResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        QuotaManagerHostQueryStorageUsageAndQuotaResponseParams result =
            new QuotaManagerHostQueryStorageUsageAndQuotaResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        QuotaStatusCode.validate(readInt);
        result.error = QuotaStatusCode.toKnownValue(result.error);
        result.currentUsage = decoder0.readLong(16);
        result.currentQuota = decoder0.readLong(24);
        Decoder decoder1 = decoder0.readPointer(32, false);
        result.usageBreakdown = UsageBreakdown.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.currentUsage, 16);
      encoder0.encode(this.currentQuota, 24);
      encoder0.encode((Struct) this.usageBreakdown, 32, false);
    }
  }

  static class QuotaManagerHostQueryStorageUsageAndQuotaResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final QuotaManagerHost.QueryStorageUsageAndQuota_Response mCallback;

    QuotaManagerHostQueryStorageUsageAndQuotaResponseParamsForwardToCallback(
        QuotaManagerHost.QueryStorageUsageAndQuota_Response callback) {
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
        QuotaManagerHostQueryStorageUsageAndQuotaResponseParams response =
            QuotaManagerHostQueryStorageUsageAndQuotaResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(
            response.error, response.currentUsage, response.currentQuota, response.usageBreakdown);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class QuotaManagerHostQueryStorageUsageAndQuotaResponseParamsProxyToResponder
      implements QuotaManagerHost.QueryStorageUsageAndQuota_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    QuotaManagerHostQueryStorageUsageAndQuotaResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int error, long currentUsage, long currentQuota, UsageBreakdown usageBreakdown) {
      QuotaManagerHostQueryStorageUsageAndQuotaResponseParams _response =
          new QuotaManagerHostQueryStorageUsageAndQuotaResponseParams();
      _response.error = error;
      _response.currentUsage = currentUsage;
      _response.currentQuota = currentQuota;
      _response.usageBreakdown = usageBreakdown;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
