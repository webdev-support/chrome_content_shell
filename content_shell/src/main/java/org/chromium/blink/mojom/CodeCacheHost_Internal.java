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
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

class CodeCacheHost_Internal {
  private static final int CLEAR_CODE_CACHE_ENTRY_ORDINAL = 2;
  private static final int DID_GENERATE_CACHEABLE_METADATA_IN_CACHE_STORAGE_ORDINAL = 3;
  private static final int DID_GENERATE_CACHEABLE_METADATA_ORDINAL = 0;
  private static final int FETCH_CACHED_CODE_ORDINAL = 1;
  public static final Interface.Manager<CodeCacheHost, CodeCacheHost.Proxy> MANAGER =
      new Interface.Manager<CodeCacheHost, CodeCacheHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.CodeCacheHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CodeCacheHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CodeCacheHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public CodeCacheHost[] buildArray(int size) {
          return new CodeCacheHost[size];
        }
      };

  CodeCacheHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements CodeCacheHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void didGenerateCacheableMetadata(
        int cacheType, Url url, Time expectedResponseTime, BigBuffer data) {
      CodeCacheHostDidGenerateCacheableMetadataParams _message =
          new CodeCacheHostDidGenerateCacheableMetadataParams();
      _message.cacheType = cacheType;
      _message.url = url;
      _message.expectedResponseTime = expectedResponseTime;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void fetchCachedCode(int cacheType, Url url, FetchCachedCode_Response callback) {
      CodeCacheHostFetchCachedCodeParams _message = new CodeCacheHostFetchCachedCodeParams();
      _message.cacheType = cacheType;
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new CodeCacheHostFetchCachedCodeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearCodeCacheEntry(int cacheType, Url url) {
      CodeCacheHostClearCodeCacheEntryParams _message =
          new CodeCacheHostClearCodeCacheEntryParams();
      _message.cacheType = cacheType;
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void didGenerateCacheableMetadataInCacheStorage(
        Url url, Time expectedResponseTime, BigBuffer data, String cacheStorageCacheName) {
      CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams _message =
          new CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams();
      _message.url = url;
      _message.expectedResponseTime = expectedResponseTime;
      _message.data = data;
      _message.cacheStorageCacheName = cacheStorageCacheName;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<CodeCacheHost> {
    Stub(Core core, CodeCacheHost impl) {
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
                CodeCacheHost_Internal.MANAGER, messageWithHeader);
          case -1:
          case 1:
          default:
            return false;
          case 0:
            CodeCacheHostDidGenerateCacheableMetadataParams data =
                CodeCacheHostDidGenerateCacheableMetadataParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .didGenerateCacheableMetadata(
                    data.cacheType, data.url, data.expectedResponseTime, data.data);
            return true;
          case 2:
            CodeCacheHostClearCodeCacheEntryParams data2 =
                CodeCacheHostClearCodeCacheEntryParams.deserialize(messageWithHeader.getPayload());
            getImpl().clearCodeCacheEntry(data2.cacheType, data2.url);
            return true;
          case 3:
            CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams data3 =
                CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .didGenerateCacheableMetadataInCacheStorage(
                    data3.url, data3.expectedResponseTime, data3.data, data3.cacheStorageCacheName);
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
                getCore(), CodeCacheHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            CodeCacheHostFetchCachedCodeParams data =
                CodeCacheHostFetchCachedCodeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .fetchCachedCode(
                    data.cacheType,
                    data.url,
                    new CodeCacheHostFetchCachedCodeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CodeCacheHostDidGenerateCacheableMetadataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public int cacheType;
    public BigBuffer data;
    public Time expectedResponseTime;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CodeCacheHostDidGenerateCacheableMetadataParams(int version) {
      super(48, version);
    }

    public CodeCacheHostDidGenerateCacheableMetadataParams() {
      this(0);
    }

    public static CodeCacheHostDidGenerateCacheableMetadataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CodeCacheHostDidGenerateCacheableMetadataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CodeCacheHostDidGenerateCacheableMetadataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CodeCacheHostDidGenerateCacheableMetadataParams result =
            new CodeCacheHostDidGenerateCacheableMetadataParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.cacheType = readInt;
        CodeCacheType.validate(readInt);
        result.cacheType = CodeCacheType.toKnownValue(result.cacheType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.expectedResponseTime = Time.decode(decoder12);
        result.data = BigBuffer.decode(decoder0, 32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.cacheType, 8);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode((Struct) this.expectedResponseTime, 24, false);
      encoder0.encode((Union) this.data, 32, false);
    }
  }

  static final class CodeCacheHostFetchCachedCodeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int cacheType;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CodeCacheHostFetchCachedCodeParams(int version) {
      super(24, version);
    }

    public CodeCacheHostFetchCachedCodeParams() {
      this(0);
    }

    public static CodeCacheHostFetchCachedCodeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CodeCacheHostFetchCachedCodeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CodeCacheHostFetchCachedCodeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CodeCacheHostFetchCachedCodeParams result =
            new CodeCacheHostFetchCachedCodeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.cacheType = readInt;
        CodeCacheType.validate(readInt);
        result.cacheType = CodeCacheType.toKnownValue(result.cacheType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.cacheType, 8);
      encoder0.encode((Struct) this.url, 16, false);
    }
  }

  static final class CodeCacheHostFetchCachedCodeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public BigBuffer data;
    public Time responseTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CodeCacheHostFetchCachedCodeResponseParams(int version) {
      super(32, version);
    }

    public CodeCacheHostFetchCachedCodeResponseParams() {
      this(0);
    }

    public static CodeCacheHostFetchCachedCodeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CodeCacheHostFetchCachedCodeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CodeCacheHostFetchCachedCodeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CodeCacheHostFetchCachedCodeResponseParams result =
            new CodeCacheHostFetchCachedCodeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.responseTime = Time.decode(decoder1);
        result.data = BigBuffer.decode(decoder0, 16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.responseTime, 8, false);
      encoder0.encode((Union) this.data, 16, false);
    }
  }

  static class CodeCacheHostFetchCachedCodeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CodeCacheHost.FetchCachedCode_Response mCallback;

    CodeCacheHostFetchCachedCodeResponseParamsForwardToCallback(
        CodeCacheHost.FetchCachedCode_Response callback) {
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
        CodeCacheHostFetchCachedCodeResponseParams response =
            CodeCacheHostFetchCachedCodeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.responseTime, response.data);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CodeCacheHostFetchCachedCodeResponseParamsProxyToResponder
      implements CodeCacheHost.FetchCachedCode_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CodeCacheHostFetchCachedCodeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Time responseTime, BigBuffer data) {
      CodeCacheHostFetchCachedCodeResponseParams _response =
          new CodeCacheHostFetchCachedCodeResponseParams();
      _response.responseTime = responseTime;
      _response.data = data;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CodeCacheHostClearCodeCacheEntryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int cacheType;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CodeCacheHostClearCodeCacheEntryParams(int version) {
      super(24, version);
    }

    public CodeCacheHostClearCodeCacheEntryParams() {
      this(0);
    }

    public static CodeCacheHostClearCodeCacheEntryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CodeCacheHostClearCodeCacheEntryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CodeCacheHostClearCodeCacheEntryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CodeCacheHostClearCodeCacheEntryParams result =
            new CodeCacheHostClearCodeCacheEntryParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.cacheType = readInt;
        CodeCacheType.validate(readInt);
        result.cacheType = CodeCacheType.toKnownValue(result.cacheType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.cacheType, 8);
      encoder0.encode((Struct) this.url, 16, false);
    }
  }

  static final class CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public String cacheStorageCacheName;
    public BigBuffer data;
    public Time expectedResponseTime;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams(int version) {
      super(48, version);
    }

    public CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams() {
      this(0);
    }

    public static CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams result =
            new CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.expectedResponseTime = Time.decode(decoder12);
        result.data = BigBuffer.decode(decoder0, 24);
        result.cacheStorageCacheName = decoder0.readString(40, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.expectedResponseTime, 16, false);
      encoder0.encode((Union) this.data, 24, false);
      encoder0.encode(this.cacheStorageCacheName, 40, false);
    }
  }
}
