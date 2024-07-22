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

class CookieStore_Internal {
  private static final int ADD_SUBSCRIPTIONS_ORDINAL = 0;
  private static final int GET_SUBSCRIPTIONS_ORDINAL = 2;
  public static final Interface.Manager<CookieStore, CookieStore.Proxy> MANAGER =
      new Interface.Manager<CookieStore, CookieStore.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.CookieStore";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CookieStore.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CookieStore impl) {
          return new Stub(core, impl);
        }

        @Override
        public CookieStore[] buildArray(int size) {
          return new CookieStore[size];
        }
      };
  private static final int REMOVE_SUBSCRIPTIONS_ORDINAL = 1;

  CookieStore_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements CookieStore.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addSubscriptions(
        long serviceWorkerRegistrationId,
        CookieChangeSubscription[] subscription,
        AddSubscriptions_Response callback) {
      CookieStoreAddSubscriptionsParams _message = new CookieStoreAddSubscriptionsParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.subscription = subscription;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CookieStoreAddSubscriptionsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void removeSubscriptions(
        long serviceWorkerRegistrationId,
        CookieChangeSubscription[] subscription,
        RemoveSubscriptions_Response callback) {
      CookieStoreRemoveSubscriptionsParams _message = new CookieStoreRemoveSubscriptionsParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.subscription = subscription;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new CookieStoreRemoveSubscriptionsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getSubscriptions(
        long serviceWorkerRegistrationId, GetSubscriptions_Response callback) {
      CookieStoreGetSubscriptionsParams _message = new CookieStoreGetSubscriptionsParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new CookieStoreGetSubscriptionsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<CookieStore> {
    Stub(Core core, CookieStore impl) {
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
                CookieStore_Internal.MANAGER, messageWithHeader);
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
                getCore(), CookieStore_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CookieStoreAddSubscriptionsParams data =
                CookieStoreAddSubscriptionsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addSubscriptions(
                    data.serviceWorkerRegistrationId,
                    data.subscription,
                    new CookieStoreAddSubscriptionsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            CookieStoreRemoveSubscriptionsParams data2 =
                CookieStoreRemoveSubscriptionsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .removeSubscriptions(
                    data2.serviceWorkerRegistrationId,
                    data2.subscription,
                    new CookieStoreRemoveSubscriptionsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .getSubscriptions(
                    CookieStoreGetSubscriptionsParams.deserialize(messageWithHeader.getPayload())
                        .serviceWorkerRegistrationId,
                    new CookieStoreGetSubscriptionsResponseParamsProxyToResponder(
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

  static final class CookieStoreAddSubscriptionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long serviceWorkerRegistrationId;
    public CookieChangeSubscription[] subscription;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieStoreAddSubscriptionsParams(int version) {
      super(24, version);
    }

    public CookieStoreAddSubscriptionsParams() {
      this(0);
    }

    public static CookieStoreAddSubscriptionsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieStoreAddSubscriptionsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieStoreAddSubscriptionsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieStoreAddSubscriptionsParams result =
            new CookieStoreAddSubscriptionsParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.subscription = new CookieChangeSubscription[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.subscription[i1] = CookieChangeSubscription.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      CookieChangeSubscription[] cookieChangeSubscriptionArr = this.subscription;
      if (cookieChangeSubscriptionArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(cookieChangeSubscriptionArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        CookieChangeSubscription[] cookieChangeSubscriptionArr2 = this.subscription;
        if (i0 < cookieChangeSubscriptionArr2.length) {
          encoder1.encode((Struct) cookieChangeSubscriptionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class CookieStoreAddSubscriptionsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieStoreAddSubscriptionsResponseParams(int version) {
      super(16, version);
    }

    public CookieStoreAddSubscriptionsResponseParams() {
      this(0);
    }

    public static CookieStoreAddSubscriptionsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieStoreAddSubscriptionsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieStoreAddSubscriptionsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieStoreAddSubscriptionsResponseParams result =
            new CookieStoreAddSubscriptionsResponseParams(elementsOrVersion);
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

  static class CookieStoreAddSubscriptionsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieStore.AddSubscriptions_Response mCallback;

    CookieStoreAddSubscriptionsResponseParamsForwardToCallback(
        CookieStore.AddSubscriptions_Response callback) {
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
        CookieStoreAddSubscriptionsResponseParams response =
            CookieStoreAddSubscriptionsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieStoreAddSubscriptionsResponseParamsProxyToResponder
      implements CookieStore.AddSubscriptions_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieStoreAddSubscriptionsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      CookieStoreAddSubscriptionsResponseParams _response =
          new CookieStoreAddSubscriptionsResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieStoreRemoveSubscriptionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long serviceWorkerRegistrationId;
    public CookieChangeSubscription[] subscription;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieStoreRemoveSubscriptionsParams(int version) {
      super(24, version);
    }

    public CookieStoreRemoveSubscriptionsParams() {
      this(0);
    }

    public static CookieStoreRemoveSubscriptionsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieStoreRemoveSubscriptionsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieStoreRemoveSubscriptionsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieStoreRemoveSubscriptionsParams result =
            new CookieStoreRemoveSubscriptionsParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.subscription = new CookieChangeSubscription[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.subscription[i1] = CookieChangeSubscription.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      CookieChangeSubscription[] cookieChangeSubscriptionArr = this.subscription;
      if (cookieChangeSubscriptionArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(cookieChangeSubscriptionArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        CookieChangeSubscription[] cookieChangeSubscriptionArr2 = this.subscription;
        if (i0 < cookieChangeSubscriptionArr2.length) {
          encoder1.encode((Struct) cookieChangeSubscriptionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class CookieStoreRemoveSubscriptionsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieStoreRemoveSubscriptionsResponseParams(int version) {
      super(16, version);
    }

    public CookieStoreRemoveSubscriptionsResponseParams() {
      this(0);
    }

    public static CookieStoreRemoveSubscriptionsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieStoreRemoveSubscriptionsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieStoreRemoveSubscriptionsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieStoreRemoveSubscriptionsResponseParams result =
            new CookieStoreRemoveSubscriptionsResponseParams(elementsOrVersion);
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

  static class CookieStoreRemoveSubscriptionsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieStore.RemoveSubscriptions_Response mCallback;

    CookieStoreRemoveSubscriptionsResponseParamsForwardToCallback(
        CookieStore.RemoveSubscriptions_Response callback) {
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
        CookieStoreRemoveSubscriptionsResponseParams response =
            CookieStoreRemoveSubscriptionsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieStoreRemoveSubscriptionsResponseParamsProxyToResponder
      implements CookieStore.RemoveSubscriptions_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieStoreRemoveSubscriptionsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      CookieStoreRemoveSubscriptionsResponseParams _response =
          new CookieStoreRemoveSubscriptionsResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieStoreGetSubscriptionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieStoreGetSubscriptionsParams(int version) {
      super(16, version);
    }

    public CookieStoreGetSubscriptionsParams() {
      this(0);
    }

    public static CookieStoreGetSubscriptionsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieStoreGetSubscriptionsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieStoreGetSubscriptionsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieStoreGetSubscriptionsParams result =
            new CookieStoreGetSubscriptionsParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
    }
  }

  static final class CookieStoreGetSubscriptionsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieChangeSubscription[] subscriptions;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieStoreGetSubscriptionsResponseParams(int version) {
      super(24, version);
    }

    public CookieStoreGetSubscriptionsResponseParams() {
      this(0);
    }

    public static CookieStoreGetSubscriptionsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieStoreGetSubscriptionsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieStoreGetSubscriptionsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieStoreGetSubscriptionsResponseParams result =
            new CookieStoreGetSubscriptionsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.subscriptions = new CookieChangeSubscription[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.subscriptions[i1] = CookieChangeSubscription.decode(decoder2);
        }
        result.success = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      CookieChangeSubscription[] cookieChangeSubscriptionArr = this.subscriptions;
      if (cookieChangeSubscriptionArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(cookieChangeSubscriptionArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          CookieChangeSubscription[] cookieChangeSubscriptionArr2 = this.subscriptions;
          if (i0 >= cookieChangeSubscriptionArr2.length) {
            break;
          }
          encoder1.encode((Struct) cookieChangeSubscriptionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.success, 16, 0);
    }
  }

  static class CookieStoreGetSubscriptionsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieStore.GetSubscriptions_Response mCallback;

    CookieStoreGetSubscriptionsResponseParamsForwardToCallback(
        CookieStore.GetSubscriptions_Response callback) {
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
        CookieStoreGetSubscriptionsResponseParams response =
            CookieStoreGetSubscriptionsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.subscriptions, response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieStoreGetSubscriptionsResponseParamsProxyToResponder
      implements CookieStore.GetSubscriptions_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieStoreGetSubscriptionsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CookieChangeSubscription[] subscriptions, boolean success) {
      CookieStoreGetSubscriptionsResponseParams _response =
          new CookieStoreGetSubscriptionsResponseParams();
      _response.subscriptions = subscriptions;
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
