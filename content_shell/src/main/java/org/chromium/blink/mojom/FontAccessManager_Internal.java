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

class FontAccessManager_Internal {
  private static final int ENUMERATE_LOCAL_FONTS_ORDINAL = 0;
  public static final Interface.Manager<FontAccessManager, FontAccessManager.Proxy> MANAGER =
      new Interface.Manager<FontAccessManager, FontAccessManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FontAccessManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FontAccessManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FontAccessManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public FontAccessManager[] buildArray(int size) {
          return new FontAccessManager[size];
        }
      };

  FontAccessManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FontAccessManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void enumerateLocalFonts(EnumerateLocalFonts_Response callback) {
      FontAccessManagerEnumerateLocalFontsParams _message =
          new FontAccessManagerEnumerateLocalFontsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FontAccessManagerEnumerateLocalFontsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FontAccessManager> {
    Stub(Core core, FontAccessManager impl) {
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
                FontAccessManager_Internal.MANAGER, messageWithHeader);
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
                getCore(), FontAccessManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FontAccessManagerEnumerateLocalFontsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .enumerateLocalFonts(
                    new FontAccessManagerEnumerateLocalFontsResponseParamsProxyToResponder(
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

  static final class FontAccessManagerEnumerateLocalFontsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FontAccessManagerEnumerateLocalFontsParams(int version) {
      super(8, version);
    }

    public FontAccessManagerEnumerateLocalFontsParams() {
      this(0);
    }

    public static FontAccessManagerEnumerateLocalFontsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FontAccessManagerEnumerateLocalFontsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FontAccessManagerEnumerateLocalFontsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FontAccessManagerEnumerateLocalFontsParams result =
            new FontAccessManagerEnumerateLocalFontsParams(elementsOrVersion);
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

  static final class FontAccessManagerEnumerateLocalFontsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int enumerationStatus;
    public ReadOnlySharedMemoryRegion enumerationTable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FontAccessManagerEnumerateLocalFontsResponseParams(int version) {
      super(24, version);
    }

    public FontAccessManagerEnumerateLocalFontsResponseParams() {
      this(0);
    }

    public static FontAccessManagerEnumerateLocalFontsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FontAccessManagerEnumerateLocalFontsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FontAccessManagerEnumerateLocalFontsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FontAccessManagerEnumerateLocalFontsResponseParams result =
            new FontAccessManagerEnumerateLocalFontsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.enumerationStatus = readInt;
        FontEnumerationStatus.validate(readInt);
        result.enumerationStatus = FontEnumerationStatus.toKnownValue(result.enumerationStatus);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.enumerationTable = ReadOnlySharedMemoryRegion.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enumerationStatus, 8);
      encoder0.encode((Struct) this.enumerationTable, 16, true);
    }
  }

  static class FontAccessManagerEnumerateLocalFontsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FontAccessManager.EnumerateLocalFonts_Response mCallback;

    FontAccessManagerEnumerateLocalFontsResponseParamsForwardToCallback(
        FontAccessManager.EnumerateLocalFonts_Response callback) {
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
        FontAccessManagerEnumerateLocalFontsResponseParams response =
            FontAccessManagerEnumerateLocalFontsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.enumerationStatus, response.enumerationTable);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FontAccessManagerEnumerateLocalFontsResponseParamsProxyToResponder
      implements FontAccessManager.EnumerateLocalFonts_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FontAccessManagerEnumerateLocalFontsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int enumerationStatus, ReadOnlySharedMemoryRegion enumerationTable) {
      FontAccessManagerEnumerateLocalFontsResponseParams _response =
          new FontAccessManagerEnumerateLocalFontsResponseParams();
      _response.enumerationStatus = enumerationStatus;
      _response.enumerationTable = enumerationTable;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
