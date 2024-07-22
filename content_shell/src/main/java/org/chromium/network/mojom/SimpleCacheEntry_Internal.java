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

class SimpleCacheEntry_Internal {
  private static final int CLOSE_ORDINAL = 4;
  public static final Interface.Manager<SimpleCacheEntry, SimpleCacheEntry.Proxy> MANAGER =
      new Interface.Manager<SimpleCacheEntry, SimpleCacheEntry.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.SimpleCacheEntry";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SimpleCacheEntry.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SimpleCacheEntry impl) {
          return new Stub(core, impl);
        }

        @Override
        public SimpleCacheEntry[] buildArray(int size) {
          return new SimpleCacheEntry[size];
        }
      };
  private static final int READ_DATA_ORDINAL = 1;
  private static final int READ_SPARSE_DATA_ORDINAL = 3;
  private static final int WRITE_DATA_ORDINAL = 0;
  private static final int WRITE_SPARSE_DATA_ORDINAL = 2;

  SimpleCacheEntry_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SimpleCacheEntry.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void writeData(
        int index,
        int offset,
        byte[] data,
        boolean truncate,
        SimpleCacheEntry.WriteData_Response callback) {
      SimpleCacheEntryWriteDataParams _message = new SimpleCacheEntryWriteDataParams();
      _message.index = index;
      _message.offset = offset;
      _message.data = data;
      _message.truncate = truncate;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SimpleCacheEntryWriteDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readData(
        int index, int offset, int length, SimpleCacheEntry.ReadData_Response callback) {
      SimpleCacheEntryReadDataParams _message = new SimpleCacheEntryReadDataParams();
      _message.index = index;
      _message.offset = offset;
      _message.length = length;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SimpleCacheEntryReadDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void writeSparseData(
        int offset, byte[] data, SimpleCacheEntry.WriteSparseData_Response callback) {
      SimpleCacheEntryWriteSparseDataParams _message = new SimpleCacheEntryWriteSparseDataParams();
      _message.offset = offset;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new SimpleCacheEntryWriteSparseDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readSparseData(
        int offset, int length, SimpleCacheEntry.ReadSparseData_Response callback) {
      SimpleCacheEntryReadSparseDataParams _message = new SimpleCacheEntryReadSparseDataParams();
      _message.offset = offset;
      _message.length = length;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new SimpleCacheEntryReadSparseDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void close(SimpleCacheEntry.Close_Response callback) {
      SimpleCacheEntryCloseParams _message = new SimpleCacheEntryCloseParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new SimpleCacheEntryCloseResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SimpleCacheEntry> {
    Stub(Core core, SimpleCacheEntry impl) {
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
                SimpleCacheEntry_Internal.MANAGER, messageWithHeader);
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
                getCore(), SimpleCacheEntry_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SimpleCacheEntryWriteDataParams data =
                SimpleCacheEntryWriteDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .writeData(
                    data.index,
                    data.offset,
                    data.data,
                    data.truncate,
                    new SimpleCacheEntryWriteDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            SimpleCacheEntryReadDataParams data2 =
                SimpleCacheEntryReadDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readData(
                    data2.index,
                    data2.offset,
                    data2.length,
                    new SimpleCacheEntryReadDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            SimpleCacheEntryWriteSparseDataParams data3 =
                SimpleCacheEntryWriteSparseDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .writeSparseData(
                    data3.offset,
                    data3.data,
                    new SimpleCacheEntryWriteSparseDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            SimpleCacheEntryReadSparseDataParams data4 =
                SimpleCacheEntryReadSparseDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readSparseData(
                    data4.offset,
                    data4.length,
                    new SimpleCacheEntryReadSparseDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            SimpleCacheEntryCloseParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .close(
                    new SimpleCacheEntryCloseResponseParamsProxyToResponder(
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

  static final class SimpleCacheEntryWriteDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;
    public int index;
    public int offset;
    public boolean truncate;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryWriteDataParams(int version) {
      super(32, version);
    }

    public SimpleCacheEntryWriteDataParams() {
      this(0);
    }

    public static SimpleCacheEntryWriteDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryWriteDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryWriteDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryWriteDataParams result =
            new SimpleCacheEntryWriteDataParams(elementsOrVersion);
        result.index = decoder0.readInt(8);
        result.offset = decoder0.readInt(12);
        result.data = decoder0.readBytes(16, 0, -1);
        result.truncate = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.index, 8);
      encoder0.encode(this.offset, 12);
      encoder0.encode(this.data, 16, 0, -1);
      encoder0.encode(this.truncate, 24, 0);
    }
  }

  static final class SimpleCacheEntryWriteDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryWriteDataResponseParams(int version) {
      super(16, version);
    }

    public SimpleCacheEntryWriteDataResponseParams() {
      this(0);
    }

    public static SimpleCacheEntryWriteDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryWriteDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryWriteDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryWriteDataResponseParams result =
            new SimpleCacheEntryWriteDataResponseParams(elementsOrVersion);
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

  static class SimpleCacheEntryWriteDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SimpleCacheEntry.WriteData_Response mCallback;

    SimpleCacheEntryWriteDataResponseParamsForwardToCallback(
        SimpleCacheEntry.WriteData_Response callback) {
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
        SimpleCacheEntryWriteDataResponseParams response =
            SimpleCacheEntryWriteDataResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheEntryWriteDataResponseParamsProxyToResponder
      implements SimpleCacheEntry.WriteData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheEntryWriteDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      SimpleCacheEntryWriteDataResponseParams _response =
          new SimpleCacheEntryWriteDataResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SimpleCacheEntryReadDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int index;
    public int length;
    public int offset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryReadDataParams(int version) {
      super(24, version);
    }

    public SimpleCacheEntryReadDataParams() {
      this(0);
    }

    public static SimpleCacheEntryReadDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryReadDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryReadDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryReadDataParams result =
            new SimpleCacheEntryReadDataParams(elementsOrVersion);
        result.index = decoder0.readInt(8);
        result.offset = decoder0.readInt(12);
        result.length = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.index, 8);
      encoder0.encode(this.offset, 12);
      encoder0.encode(this.length, 16);
    }
  }

  static final class SimpleCacheEntryReadDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryReadDataResponseParams(int version) {
      super(24, version);
    }

    public SimpleCacheEntryReadDataResponseParams() {
      this(0);
    }

    public static SimpleCacheEntryReadDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryReadDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryReadDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryReadDataResponseParams result =
            new SimpleCacheEntryReadDataResponseParams(elementsOrVersion);
        result.data = decoder0.readBytes(8, 0, -1);
        result.result = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.data, 8, 0, -1);
      encoder0.encode(this.result, 16);
    }
  }

  static class SimpleCacheEntryReadDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SimpleCacheEntry.ReadData_Response mCallback;

    SimpleCacheEntryReadDataResponseParamsForwardToCallback(
        SimpleCacheEntry.ReadData_Response callback) {
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
        SimpleCacheEntryReadDataResponseParams response =
            SimpleCacheEntryReadDataResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.data, response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheEntryReadDataResponseParamsProxyToResponder
      implements SimpleCacheEntry.ReadData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheEntryReadDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(byte[] data, int result) {
      SimpleCacheEntryReadDataResponseParams _response =
          new SimpleCacheEntryReadDataResponseParams();
      _response.data = data;
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SimpleCacheEntryWriteSparseDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;
    public int offset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryWriteSparseDataParams(int version) {
      super(24, version);
    }

    public SimpleCacheEntryWriteSparseDataParams() {
      this(0);
    }

    public static SimpleCacheEntryWriteSparseDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryWriteSparseDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryWriteSparseDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryWriteSparseDataParams result =
            new SimpleCacheEntryWriteSparseDataParams(elementsOrVersion);
        result.offset = decoder0.readInt(8);
        result.data = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.offset, 8);
      encoder0.encode(this.data, 16, 0, -1);
    }
  }

  static final class SimpleCacheEntryWriteSparseDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryWriteSparseDataResponseParams(int version) {
      super(16, version);
    }

    public SimpleCacheEntryWriteSparseDataResponseParams() {
      this(0);
    }

    public static SimpleCacheEntryWriteSparseDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryWriteSparseDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryWriteSparseDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryWriteSparseDataResponseParams result =
            new SimpleCacheEntryWriteSparseDataResponseParams(elementsOrVersion);
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

  static class SimpleCacheEntryWriteSparseDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SimpleCacheEntry.WriteSparseData_Response mCallback;

    SimpleCacheEntryWriteSparseDataResponseParamsForwardToCallback(
        SimpleCacheEntry.WriteSparseData_Response callback) {
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
        SimpleCacheEntryWriteSparseDataResponseParams response =
            SimpleCacheEntryWriteSparseDataResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheEntryWriteSparseDataResponseParamsProxyToResponder
      implements SimpleCacheEntry.WriteSparseData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheEntryWriteSparseDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      SimpleCacheEntryWriteSparseDataResponseParams _response =
          new SimpleCacheEntryWriteSparseDataResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SimpleCacheEntryReadSparseDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int length;
    public int offset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryReadSparseDataParams(int version) {
      super(16, version);
    }

    public SimpleCacheEntryReadSparseDataParams() {
      this(0);
    }

    public static SimpleCacheEntryReadSparseDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryReadSparseDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryReadSparseDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryReadSparseDataParams result =
            new SimpleCacheEntryReadSparseDataParams(elementsOrVersion);
        result.offset = decoder0.readInt(8);
        result.length = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.offset, 8);
      encoder0.encode(this.length, 12);
    }
  }

  static final class SimpleCacheEntryReadSparseDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryReadSparseDataResponseParams(int version) {
      super(24, version);
    }

    public SimpleCacheEntryReadSparseDataResponseParams() {
      this(0);
    }

    public static SimpleCacheEntryReadSparseDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryReadSparseDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryReadSparseDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryReadSparseDataResponseParams result =
            new SimpleCacheEntryReadSparseDataResponseParams(elementsOrVersion);
        result.data = decoder0.readBytes(8, 0, -1);
        result.result = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.data, 8, 0, -1);
      encoder0.encode(this.result, 16);
    }
  }

  static class SimpleCacheEntryReadSparseDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SimpleCacheEntry.ReadSparseData_Response mCallback;

    SimpleCacheEntryReadSparseDataResponseParamsForwardToCallback(
        SimpleCacheEntry.ReadSparseData_Response callback) {
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
        SimpleCacheEntryReadSparseDataResponseParams response =
            SimpleCacheEntryReadSparseDataResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.data, response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheEntryReadSparseDataResponseParamsProxyToResponder
      implements SimpleCacheEntry.ReadSparseData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheEntryReadSparseDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(byte[] data, int result) {
      SimpleCacheEntryReadSparseDataResponseParams _response =
          new SimpleCacheEntryReadSparseDataResponseParams();
      _response.data = data;
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SimpleCacheEntryCloseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryCloseParams(int version) {
      super(8, version);
    }

    public SimpleCacheEntryCloseParams() {
      this(0);
    }

    public static SimpleCacheEntryCloseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryCloseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryCloseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryCloseParams result = new SimpleCacheEntryCloseParams(elementsOrVersion);
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

  static final class SimpleCacheEntryCloseResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SimpleCacheEntryCloseResponseParams(int version) {
      super(8, version);
    }

    public SimpleCacheEntryCloseResponseParams() {
      this(0);
    }

    public static SimpleCacheEntryCloseResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SimpleCacheEntryCloseResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SimpleCacheEntryCloseResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SimpleCacheEntryCloseResponseParams result =
            new SimpleCacheEntryCloseResponseParams(elementsOrVersion);
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

  static class SimpleCacheEntryCloseResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SimpleCacheEntry.Close_Response mCallback;

    SimpleCacheEntryCloseResponseParamsForwardToCallback(SimpleCacheEntry.Close_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SimpleCacheEntryCloseResponseParamsProxyToResponder
      implements SimpleCacheEntry.Close_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SimpleCacheEntryCloseResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      SimpleCacheEntryCloseResponseParams _response = new SimpleCacheEntryCloseResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
