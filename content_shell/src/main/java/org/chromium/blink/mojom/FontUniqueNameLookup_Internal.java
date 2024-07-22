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
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

class FontUniqueNameLookup_Internal {
  private static final int GET_UNIQUE_NAME_LOOKUP_TABLE_IF_AVAILABLE_ORDINAL = 0;
  private static final int GET_UNIQUE_NAME_LOOKUP_TABLE_ORDINAL = 1;
  public static final Interface.Manager<FontUniqueNameLookup, FontUniqueNameLookup.Proxy> MANAGER =
      new Interface.Manager<FontUniqueNameLookup, FontUniqueNameLookup.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FontUniqueNameLookup";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FontUniqueNameLookup.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FontUniqueNameLookup impl) {
          return new Stub(core, impl);
        }

        @Override
        public FontUniqueNameLookup[] buildArray(int size) {
          return new FontUniqueNameLookup[size];
        }
      };

  FontUniqueNameLookup_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FontUniqueNameLookup.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getUniqueNameLookupTableIfAvailable(
        GetUniqueNameLookupTableIfAvailable_Response callback) {
      FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams _message =
          new FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getUniqueNameLookupTable(GetUniqueNameLookupTable_Response callback) {
      FontUniqueNameLookupGetUniqueNameLookupTableParams _message =
          new FontUniqueNameLookupGetUniqueNameLookupTableParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<FontUniqueNameLookup> {
    Stub(Core core, FontUniqueNameLookup impl) {
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
                FontUniqueNameLookup_Internal.MANAGER, messageWithHeader);
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
                getCore(), FontUniqueNameLookup_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getUniqueNameLookupTableIfAvailable(
                    new FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            FontUniqueNameLookupGetUniqueNameLookupTableParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getUniqueNameLookupTable(
                    new FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsProxyToResponder(
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

  static final class FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams(int version) {
      super(8, version);
    }

    public FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams() {
      this(0);
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams result =
            new FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams(elementsOrVersion);
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

  static final class FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlySharedMemoryRegion fontLookupTable;
    public boolean syncAvailable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams(int version) {
      super(24, version);
    }

    public FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams() {
      this(0);
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams result =
            new FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams(
                elementsOrVersion);
        result.syncAvailable = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.fontLookupTable = ReadOnlySharedMemoryRegion.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.syncAvailable, 8, 0);
      encoder0.encode((Struct) this.fontLookupTable, 16, true);
    }
  }

  static
  class FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FontUniqueNameLookup.GetUniqueNameLookupTableIfAvailable_Response mCallback;

    FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsForwardToCallback(
        FontUniqueNameLookup.GetUniqueNameLookupTableIfAvailable_Response callback) {
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
        FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams response =
            FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.syncAvailable, response.fontLookupTable);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsProxyToResponder
      implements FontUniqueNameLookup.GetUniqueNameLookupTableIfAvailable_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean syncAvailable, ReadOnlySharedMemoryRegion fontLookupTable) {
      FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams _response =
          new FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams();
      _response.syncAvailable = syncAvailable;
      _response.fontLookupTable = fontLookupTable;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FontUniqueNameLookupGetUniqueNameLookupTableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FontUniqueNameLookupGetUniqueNameLookupTableParams(int version) {
      super(8, version);
    }

    public FontUniqueNameLookupGetUniqueNameLookupTableParams() {
      this(0);
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FontUniqueNameLookupGetUniqueNameLookupTableParams result =
            new FontUniqueNameLookupGetUniqueNameLookupTableParams(elementsOrVersion);
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

  static final class FontUniqueNameLookupGetUniqueNameLookupTableResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlySharedMemoryRegion fontLookupTable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FontUniqueNameLookupGetUniqueNameLookupTableResponseParams(int version) {
      super(16, version);
    }

    public FontUniqueNameLookupGetUniqueNameLookupTableResponseParams() {
      this(0);
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FontUniqueNameLookupGetUniqueNameLookupTableResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FontUniqueNameLookupGetUniqueNameLookupTableResponseParams result =
            new FontUniqueNameLookupGetUniqueNameLookupTableResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.fontLookupTable = ReadOnlySharedMemoryRegion.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.fontLookupTable, 8, true);
    }
  }

  static class FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FontUniqueNameLookup.GetUniqueNameLookupTable_Response mCallback;

    FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsForwardToCallback(
        FontUniqueNameLookup.GetUniqueNameLookupTable_Response callback) {
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
        FontUniqueNameLookupGetUniqueNameLookupTableResponseParams response =
            FontUniqueNameLookupGetUniqueNameLookupTableResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.fontLookupTable);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsProxyToResponder
      implements FontUniqueNameLookup.GetUniqueNameLookupTable_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ReadOnlySharedMemoryRegion fontLookupTable) {
      FontUniqueNameLookupGetUniqueNameLookupTableResponseParams _response =
          new FontUniqueNameLookupGetUniqueNameLookupTableResponseParams();
      _response.fontLookupTable = fontLookupTable;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
