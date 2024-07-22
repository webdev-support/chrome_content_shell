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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.String16;

class CacheStorage_Internal {
  private static final int DELETE_ORDINAL = 1;
  private static final int HAS_ORDINAL = 0;
  private static final int KEYS_ORDINAL = 2;
  public static final Interface.Manager<CacheStorage, CacheStorage.Proxy> MANAGER =
      new Interface.Manager<CacheStorage, CacheStorage.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.CacheStorage";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CacheStorage.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CacheStorage impl) {
          return new Stub(core, impl);
        }

        @Override
        public CacheStorage[] buildArray(int size) {
          return new CacheStorage[size];
        }
      };
  private static final int MATCH_ORDINAL = 3;
  private static final int OPEN_ORDINAL = 4;

  CacheStorage_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements CacheStorage.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void has(String16 cacheName, long traceId, Has_Response callback) {
      CacheStorageHasParams _message = new CacheStorageHasParams();
      _message.cacheName = cacheName;
      _message.traceId = traceId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CacheStorageHasResponseParamsForwardToCallback(callback));
    }

    @Override
    public void delete(String16 cacheName, long traceId, Delete_Response callback) {
      CacheStorageDeleteParams _message = new CacheStorageDeleteParams();
      _message.cacheName = cacheName;
      _message.traceId = traceId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new CacheStorageDeleteResponseParamsForwardToCallback(callback));
    }

    @Override
    public void keys(long traceId, Keys_Response callback) {
      CacheStorageKeysParams _message = new CacheStorageKeysParams();
      _message.traceId = traceId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new CacheStorageKeysResponseParamsForwardToCallback(callback));
    }

    @Override
    public void match(
        FetchApiRequest request,
        MultiCacheQueryOptions matchOptions,
        boolean inRelatedFetchEvent,
        boolean inRangeFetchEvent,
        long traceId,
        Match_Response callback) {
      CacheStorageMatchParams _message = new CacheStorageMatchParams();
      _message.request = request;
      _message.matchOptions = matchOptions;
      _message.inRelatedFetchEvent = inRelatedFetchEvent;
      _message.inRangeFetchEvent = inRangeFetchEvent;
      _message.traceId = traceId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new CacheStorageMatchResponseParamsForwardToCallback(callback));
    }

    @Override
    public void open(String16 cacheName, long traceId, Open_Response callback) {
      CacheStorageOpenParams _message = new CacheStorageOpenParams();
      _message.cacheName = cacheName;
      _message.traceId = traceId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new CacheStorageOpenResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<CacheStorage> {
    Stub(Core core, CacheStorage impl) {
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
                CacheStorage_Internal.MANAGER, messageWithHeader);
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
                getCore(), CacheStorage_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CacheStorageHasParams data =
                CacheStorageHasParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .has(
                    data.cacheName,
                    data.traceId,
                    new CacheStorageHasResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            CacheStorageDeleteParams data2 =
                CacheStorageDeleteParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .delete(
                    data2.cacheName,
                    data2.traceId,
                    new CacheStorageDeleteResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .keys(
                    CacheStorageKeysParams.deserialize(messageWithHeader.getPayload()).traceId,
                    new CacheStorageKeysResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            CacheStorageMatchParams data3 =
                CacheStorageMatchParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .match(
                    data3.request,
                    data3.matchOptions,
                    data3.inRelatedFetchEvent,
                    data3.inRangeFetchEvent,
                    data3.traceId,
                    new CacheStorageMatchResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            CacheStorageOpenParams data4 =
                CacheStorageOpenParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .open(
                    data4.cacheName,
                    data4.traceId,
                    new CacheStorageOpenResponseParamsProxyToResponder(
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

  static final class CacheStorageHasParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 cacheName;
    public long traceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageHasParams(int version) {
      super(24, version);
    }

    public CacheStorageHasParams() {
      this(0);
    }

    public static CacheStorageHasParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageHasParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageHasParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageHasParams result = new CacheStorageHasParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cacheName = String16.decode(decoder1);
        result.traceId = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cacheName, 8, false);
      encoder0.encode(this.traceId, 16);
    }
  }

  static final class CacheStorageHasResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageHasResponseParams(int version) {
      super(16, version);
    }

    public CacheStorageHasResponseParams() {
      this(0);
    }

    public static CacheStorageHasResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageHasResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageHasResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageHasResponseParams result = new CacheStorageHasResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        CacheStorageError.validate(readInt);
        result.result = CacheStorageError.toKnownValue(result.result);
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

  static class CacheStorageHasResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CacheStorage.Has_Response mCallback;

    CacheStorageHasResponseParamsForwardToCallback(CacheStorage.Has_Response callback) {
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
        CacheStorageHasResponseParams response =
            CacheStorageHasResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CacheStorageHasResponseParamsProxyToResponder implements CacheStorage.Has_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CacheStorageHasResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      CacheStorageHasResponseParams _response = new CacheStorageHasResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CacheStorageDeleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 cacheName;
    public long traceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageDeleteParams(int version) {
      super(24, version);
    }

    public CacheStorageDeleteParams() {
      this(0);
    }

    public static CacheStorageDeleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageDeleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageDeleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageDeleteParams result = new CacheStorageDeleteParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cacheName = String16.decode(decoder1);
        result.traceId = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cacheName, 8, false);
      encoder0.encode(this.traceId, 16);
    }
  }

  static final class CacheStorageDeleteResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageDeleteResponseParams(int version) {
      super(16, version);
    }

    public CacheStorageDeleteResponseParams() {
      this(0);
    }

    public static CacheStorageDeleteResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageDeleteResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageDeleteResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageDeleteResponseParams result =
            new CacheStorageDeleteResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        CacheStorageError.validate(readInt);
        result.result = CacheStorageError.toKnownValue(result.result);
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

  static class CacheStorageDeleteResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CacheStorage.Delete_Response mCallback;

    CacheStorageDeleteResponseParamsForwardToCallback(CacheStorage.Delete_Response callback) {
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
        CacheStorageDeleteResponseParams response =
            CacheStorageDeleteResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CacheStorageDeleteResponseParamsProxyToResponder
      implements CacheStorage.Delete_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CacheStorageDeleteResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      CacheStorageDeleteResponseParams _response = new CacheStorageDeleteResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CacheStorageKeysParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long traceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageKeysParams(int version) {
      super(16, version);
    }

    public CacheStorageKeysParams() {
      this(0);
    }

    public static CacheStorageKeysParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageKeysParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageKeysParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageKeysParams result = new CacheStorageKeysParams(elementsOrVersion);
        result.traceId = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.traceId, 8);
    }
  }

  static final class CacheStorageKeysResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String16[] keys;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageKeysResponseParams(int version) {
      super(16, version);
    }

    public CacheStorageKeysResponseParams() {
      this(0);
    }

    public static CacheStorageKeysResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageKeysResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageKeysResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageKeysResponseParams result =
            new CacheStorageKeysResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.keys = new String16[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.keys[i1] = String16.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String16[] string16Arr = this.keys;
      if (string16Arr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(string16Arr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String16[] string16Arr2 = this.keys;
        if (i0 < string16Arr2.length) {
          encoder1.encode((Struct) string16Arr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class CacheStorageKeysResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CacheStorage.Keys_Response mCallback;

    CacheStorageKeysResponseParamsForwardToCallback(CacheStorage.Keys_Response callback) {
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
        CacheStorageKeysResponseParams response =
            CacheStorageKeysResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.keys);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CacheStorageKeysResponseParamsProxyToResponder
      implements CacheStorage.Keys_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CacheStorageKeysResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String16[] keys) {
      CacheStorageKeysResponseParams _response = new CacheStorageKeysResponseParams();
      _response.keys = keys;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CacheStorageMatchParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean inRangeFetchEvent;
    public boolean inRelatedFetchEvent;
    public MultiCacheQueryOptions matchOptions;
    public FetchApiRequest request;
    public long traceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageMatchParams(int version) {
      super(40, version);
    }

    public CacheStorageMatchParams() {
      this(0);
    }

    public static CacheStorageMatchParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageMatchParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageMatchParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageMatchParams result = new CacheStorageMatchParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.request = FetchApiRequest.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.matchOptions = MultiCacheQueryOptions.decode(decoder12);
        result.inRelatedFetchEvent = decoder0.readBoolean(24, 0);
        result.inRangeFetchEvent = decoder0.readBoolean(24, 1);
        result.traceId = decoder0.readLong(32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.request, 8, false);
      encoder0.encode((Struct) this.matchOptions, 16, false);
      encoder0.encode(this.inRelatedFetchEvent, 24, 0);
      encoder0.encode(this.inRangeFetchEvent, 24, 1);
      encoder0.encode(this.traceId, 32);
    }
  }

  static final class CacheStorageMatchResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MatchResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageMatchResponseParams(int version) {
      super(24, version);
    }

    public CacheStorageMatchResponseParams() {
      this(0);
    }

    public static CacheStorageMatchResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageMatchResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageMatchResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageMatchResponseParams result =
            new CacheStorageMatchResponseParams(elementsOrVersion);
        result.result = MatchResult.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class CacheStorageMatchResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CacheStorage.Match_Response mCallback;

    CacheStorageMatchResponseParamsForwardToCallback(CacheStorage.Match_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        CacheStorageMatchResponseParams response =
            CacheStorageMatchResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CacheStorageMatchResponseParamsProxyToResponder
      implements CacheStorage.Match_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CacheStorageMatchResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(MatchResult result) {
      CacheStorageMatchResponseParams _response = new CacheStorageMatchResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CacheStorageOpenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 cacheName;
    public long traceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageOpenParams(int version) {
      super(24, version);
    }

    public CacheStorageOpenParams() {
      this(0);
    }

    public static CacheStorageOpenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageOpenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageOpenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageOpenParams result = new CacheStorageOpenParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cacheName = String16.decode(decoder1);
        result.traceId = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cacheName, 8, false);
      encoder0.encode(this.traceId, 16);
    }
  }

  static final class CacheStorageOpenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public OpenResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CacheStorageOpenResponseParams(int version) {
      super(24, version);
    }

    public CacheStorageOpenResponseParams() {
      this(0);
    }

    public static CacheStorageOpenResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CacheStorageOpenResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CacheStorageOpenResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CacheStorageOpenResponseParams result =
            new CacheStorageOpenResponseParams(elementsOrVersion);
        result.result = OpenResult.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class CacheStorageOpenResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CacheStorage.Open_Response mCallback;

    CacheStorageOpenResponseParamsForwardToCallback(CacheStorage.Open_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        CacheStorageOpenResponseParams response =
            CacheStorageOpenResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CacheStorageOpenResponseParamsProxyToResponder
      implements CacheStorage.Open_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CacheStorageOpenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(OpenResult result) {
      CacheStorageOpenResponseParams _response = new CacheStorageOpenResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
