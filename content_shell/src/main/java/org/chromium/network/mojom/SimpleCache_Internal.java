package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class SimpleCache_Internal {
  private static final int CREATE_ENTRY_ORDINAL = 0;
  private static final int DETACH_ORDINAL = 5;
  private static final int DOOM_ALL_ENTRIES_ORDINAL = 3;
  private static final int DOOM_ENTRY_ORDINAL = 2;
  private static final int ENUMERATE_ENTRIES_ORDINAL = 4;
  public static final Interface.Manager<SimpleCache, SimpleCache.Proxy> MANAGER =
      new Interface.Manager<SimpleCache, SimpleCache.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.SimpleCache";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SimpleCache.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SimpleCache impl) {
          return new Stub(core, impl);
        }

        @Override
        public SimpleCache[] buildArray(int size) {
          return new SimpleCache[size];
        }
      };
  private static final int OPEN_ENTRY_ORDINAL = 1;

  SimpleCache_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SimpleCache.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createEntry(String key, SimpleCache.CreateEntry_Response callback) {
      SimpleCacheCreateEntryParams _message = new SimpleCacheCreateEntryParams();
      _message.key = key;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SimpleCacheCreateEntryResponseParamsForwardToCallback(callback));
    }

    @Override
    public void openEntry(String key, SimpleCache.OpenEntry_Response callback) {
      SimpleCacheOpenEntryParams _message = new SimpleCacheOpenEntryParams();
      _message.key = key;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SimpleCacheOpenEntryResponseParamsForwardToCallback(callback));
    }

    @Override
    public void doomEntry(String key, SimpleCache.DoomEntry_Response callback) {
      SimpleCacheDoomEntryParams _message = new SimpleCacheDoomEntryParams();
      _message.key = key;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new SimpleCacheDoomEntryResponseParamsForwardToCallback(callback));
    }

    @Override
    public void doomAllEntries(SimpleCache.DoomAllEntries_Response callback) {
      SimpleCacheDoomAllEntriesParams _message = new SimpleCacheDoomAllEntriesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new SimpleCacheDoomAllEntriesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void enumerateEntries(InterfaceRequest<SimpleCacheEntryEnumerator> receiver) {
      SimpleCacheEnumerateEntriesParams _message = new SimpleCacheEnumerateEntriesParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void detach(SimpleCache.Detach_Response callback) {
      SimpleCacheDetachParams _message = new SimpleCacheDetachParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new SimpleCacheDetachResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SimpleCache> {
    Stub(Core core, SimpleCache impl) {
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
                SimpleCache_Internal.MANAGER, messageWithHeader);
          case 4:
            SimpleCacheEnumerateEntriesParams data =
                SimpleCacheEnumerateEntriesParams.deserialize(messageWithHeader.getPayload());
            getImpl().enumerateEntries(data.receiver);
            return true;
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
                getCore(), SimpleCache_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SimpleCacheCreateEntryParams data =
                SimpleCacheCreateEntryParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createEntry(
                    data.key,
                    new SimpleCacheCreateEntryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            SimpleCacheOpenEntryParams data2 =
                SimpleCacheOpenEntryParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .openEntry(
                    data2.key,
                    new SimpleCacheOpenEntryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            SimpleCacheDoomEntryParams data3 =
                SimpleCacheDoomEntryParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .doomEntry(
                    data3.key,
                    new SimpleCacheDoomEntryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            SimpleCacheDoomAllEntriesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .doomAllEntries(
                    new SimpleCacheDoomAllEntriesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
          default:
            return false;
          case 5:
            SimpleCacheDetachParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .detach(
                    new SimpleCacheDetachResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SimpleCacheCreateEntryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String key;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheCreateEntryParams(int version) {
      super(16, version);
    }

    public SimpleCacheCreateEntryParams() {
      this(0);
    }

    public static SimpleCacheCreateEntryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheCreateEntryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheCreateEntryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheCreateEntryParams result = new SimpleCacheCreateEntryParams(elementsOrVersion);
        result.key = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8, false);
    }
  }

  static final class SimpleCacheCreateEntryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SimpleCacheEntry entry;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheCreateEntryResponseParams(int version) {
      super(24, version);
    }

    public SimpleCacheCreateEntryResponseParams() {
      this(0);
    }

    public static SimpleCacheCreateEntryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheCreateEntryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheCreateEntryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheCreateEntryResponseParams result =
            new SimpleCacheCreateEntryResponseParams(elementsOrVersion);
        result.entry =
            (SimpleCacheEntry) decoder0.readServiceInterface(8, true, SimpleCacheEntry.MANAGER);
        result.error = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.entry, 8, true, SimpleCacheEntry.MANAGER);
      encoder0.encode(this.error, 16);
    }
  }

  static class SimpleCacheCreateEntryResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SimpleCache.CreateEntry_Response mCallback;

    SimpleCacheCreateEntryResponseParamsForwardToCallback(
        SimpleCache.CreateEntry_Response callback) {
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
        SimpleCacheCreateEntryResponseParams response =
            SimpleCacheCreateEntryResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.entry, response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheCreateEntryResponseParamsProxyToResponder
      implements SimpleCache.CreateEntry_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheCreateEntryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SimpleCacheEntry entry, int error) {
      SimpleCacheCreateEntryResponseParams _response = new SimpleCacheCreateEntryResponseParams();
      _response.entry = entry;
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SimpleCacheOpenEntryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String key;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheOpenEntryParams(int version) {
      super(16, version);
    }

    public SimpleCacheOpenEntryParams() {
      this(0);
    }

    public static SimpleCacheOpenEntryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheOpenEntryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheOpenEntryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheOpenEntryParams result = new SimpleCacheOpenEntryParams(elementsOrVersion);
        result.key = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8, false);
    }
  }

  static final class SimpleCacheOpenEntryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SimpleCacheEntry entry;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheOpenEntryResponseParams(int version) {
      super(24, version);
    }

    public SimpleCacheOpenEntryResponseParams() {
      this(0);
    }

    public static SimpleCacheOpenEntryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheOpenEntryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheOpenEntryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheOpenEntryResponseParams result =
            new SimpleCacheOpenEntryResponseParams(elementsOrVersion);
        result.entry =
            (SimpleCacheEntry) decoder0.readServiceInterface(8, true, SimpleCacheEntry.MANAGER);
        result.error = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.entry, 8, true, SimpleCacheEntry.MANAGER);
      encoder0.encode(this.error, 16);
    }
  }

  static class SimpleCacheOpenEntryResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SimpleCache.OpenEntry_Response mCallback;

    SimpleCacheOpenEntryResponseParamsForwardToCallback(SimpleCache.OpenEntry_Response callback) {
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
        SimpleCacheOpenEntryResponseParams response =
            SimpleCacheOpenEntryResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.entry, response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheOpenEntryResponseParamsProxyToResponder
      implements SimpleCache.OpenEntry_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheOpenEntryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SimpleCacheEntry entry, int error) {
      SimpleCacheOpenEntryResponseParams _response = new SimpleCacheOpenEntryResponseParams();
      _response.entry = entry;
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SimpleCacheDoomEntryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String key;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheDoomEntryParams(int version) {
      super(16, version);
    }

    public SimpleCacheDoomEntryParams() {
      this(0);
    }

    public static SimpleCacheDoomEntryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheDoomEntryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheDoomEntryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheDoomEntryParams result = new SimpleCacheDoomEntryParams(elementsOrVersion);
        result.key = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8, false);
    }
  }

  static final class SimpleCacheDoomEntryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheDoomEntryResponseParams(int version) {
      super(16, version);
    }

    public SimpleCacheDoomEntryResponseParams() {
      this(0);
    }

    public static SimpleCacheDoomEntryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheDoomEntryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheDoomEntryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheDoomEntryResponseParams result =
            new SimpleCacheDoomEntryResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
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

  static class SimpleCacheDoomEntryResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SimpleCache.DoomEntry_Response mCallback;

    SimpleCacheDoomEntryResponseParamsForwardToCallback(SimpleCache.DoomEntry_Response callback) {
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
        SimpleCacheDoomEntryResponseParams response =
            SimpleCacheDoomEntryResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheDoomEntryResponseParamsProxyToResponder
      implements SimpleCache.DoomEntry_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheDoomEntryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      SimpleCacheDoomEntryResponseParams _response = new SimpleCacheDoomEntryResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SimpleCacheDoomAllEntriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheDoomAllEntriesParams(int version) {
      super(8, version);
    }

    public SimpleCacheDoomAllEntriesParams() {
      this(0);
    }

    public static SimpleCacheDoomAllEntriesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheDoomAllEntriesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheDoomAllEntriesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheDoomAllEntriesParams result =
            new SimpleCacheDoomAllEntriesParams(elementsOrVersion);
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

  static final class SimpleCacheDoomAllEntriesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheDoomAllEntriesResponseParams(int version) {
      super(16, version);
    }

    public SimpleCacheDoomAllEntriesResponseParams() {
      this(0);
    }

    public static SimpleCacheDoomAllEntriesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheDoomAllEntriesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheDoomAllEntriesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheDoomAllEntriesResponseParams result =
            new SimpleCacheDoomAllEntriesResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
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

  static class SimpleCacheDoomAllEntriesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SimpleCache.DoomAllEntries_Response mCallback;

    SimpleCacheDoomAllEntriesResponseParamsForwardToCallback(
        SimpleCache.DoomAllEntries_Response callback) {
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
        SimpleCacheDoomAllEntriesResponseParams response =
            SimpleCacheDoomAllEntriesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheDoomAllEntriesResponseParamsProxyToResponder
      implements SimpleCache.DoomAllEntries_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheDoomAllEntriesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      SimpleCacheDoomAllEntriesResponseParams _response =
          new SimpleCacheDoomAllEntriesResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SimpleCacheEnumerateEntriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<SimpleCacheEntryEnumerator> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEnumerateEntriesParams(int version) {
      super(16, version);
    }

    public SimpleCacheEnumerateEntriesParams() {
      this(0);
    }

    public static SimpleCacheEnumerateEntriesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEnumerateEntriesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEnumerateEntriesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEnumerateEntriesParams result =
            new SimpleCacheEnumerateEntriesParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }

  static final class SimpleCacheDetachParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheDetachParams(int version) {
      super(8, version);
    }

    public SimpleCacheDetachParams() {
      this(0);
    }

    public static SimpleCacheDetachParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheDetachParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheDetachParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheDetachParams result = new SimpleCacheDetachParams(elementsOrVersion);
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

  static final class SimpleCacheDetachResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheDetachResponseParams(int version) {
      super(8, version);
    }

    public SimpleCacheDetachResponseParams() {
      this(0);
    }

    public static SimpleCacheDetachResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheDetachResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheDetachResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheDetachResponseParams result =
            new SimpleCacheDetachResponseParams(elementsOrVersion);
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

  static class SimpleCacheDetachResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SimpleCache.Detach_Response mCallback;

    SimpleCacheDetachResponseParamsForwardToCallback(SimpleCache.Detach_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheDetachResponseParamsProxyToResponder
      implements SimpleCache.Detach_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheDetachResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      SimpleCacheDetachResponseParams _response = new SimpleCacheDetachResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
