package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.UntypedHandle;

class StableCdmContext_Internal {
  private static final int ALLOCATE_SECURE_BUFFER_ORDINAL = 4;
  private static final int GET_HW_CONFIG_DATA_ORDINAL = 2;
  private static final int GET_HW_KEY_DATA_ORDINAL = 0;
  private static final int GET_SCREEN_RESOLUTIONS_ORDINAL = 3;
  public static final Interface.Manager<StableCdmContext, StableCdmContext.Proxy> MANAGER =
      new Interface.Manager<StableCdmContext, StableCdmContext.Proxy>() {
        @Override
        public String getName() {
          return "media.stable.mojom.StableCdmContext";
        }

        @Override
        public int getVersion() {
          return 3;
        }

        @Override
        public StableCdmContext.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, StableCdmContext impl) {
          return new Stub(core, impl);
        }

        @Override
        public StableCdmContext[] buildArray(int size) {
          return new StableCdmContext[size];
        }
      };
  private static final int PARSE_ENCRYPTED_SLICE_HEADER_ORDINAL = 5;
  private static final int REGISTER_EVENT_CALLBACK_ORDINAL = 1;

  StableCdmContext_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements StableCdmContext.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getHwKeyData(
        DecryptConfig decryptConfig, byte[] hwIdentifier, GetHwKeyData_Response callback) {
      StableCdmContextGetHwKeyDataParams _message = new StableCdmContextGetHwKeyDataParams();
      _message.decryptConfig = decryptConfig;
      _message.hwIdentifier = hwIdentifier;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new StableCdmContextGetHwKeyDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void registerEventCallback(CdmContextEventCallback callback) {
      StableCdmContextRegisterEventCallbackParams _message =
          new StableCdmContextRegisterEventCallbackParams();
      _message.callback = callback;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void getHwConfigData(GetHwConfigData_Response callback) {
      StableCdmContextGetHwConfigDataParams _message = new StableCdmContextGetHwConfigDataParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new StableCdmContextGetHwConfigDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getScreenResolutions(GetScreenResolutions_Response callback) {
      StableCdmContextGetScreenResolutionsParams _message =
          new StableCdmContextGetScreenResolutionsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new StableCdmContextGetScreenResolutionsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void allocateSecureBuffer(int size, AllocateSecureBuffer_Response callback) {
      StableCdmContextAllocateSecureBufferParams _message =
          new StableCdmContextAllocateSecureBufferParams();
      _message.size = size;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new StableCdmContextAllocateSecureBufferResponseParamsForwardToCallback(callback));
    }

    @Override
    public void parseEncryptedSliceHeader(
        long secureHandle,
        int offset,
        byte[] streamData,
        ParseEncryptedSliceHeader_Response callback) {
      StableCdmContextParseEncryptedSliceHeaderParams _message =
          new StableCdmContextParseEncryptedSliceHeaderParams();
      _message.secureHandle = secureHandle;
      _message.offset = offset;
      _message.streamData = streamData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new StableCdmContextParseEncryptedSliceHeaderResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<StableCdmContext> {
    Stub(Core core, StableCdmContext impl) {
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
                StableCdmContext_Internal.MANAGER, messageWithHeader);
          case 1:
            StableCdmContextRegisterEventCallbackParams data =
                StableCdmContextRegisterEventCallbackParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().registerEventCallback(data.callback);
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
                getCore(), StableCdmContext_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            StableCdmContextGetHwKeyDataParams data =
                StableCdmContextGetHwKeyDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getHwKeyData(
                    data.decryptConfig,
                    data.hwIdentifier,
                    new StableCdmContextGetHwKeyDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            StableCdmContextGetHwConfigDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getHwConfigData(
                    new StableCdmContextGetHwConfigDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            StableCdmContextGetScreenResolutionsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getScreenResolutions(
                    new StableCdmContextGetScreenResolutionsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            getImpl()
                .allocateSecureBuffer(
                    StableCdmContextAllocateSecureBufferParams.deserialize(
                            messageWithHeader.getPayload())
                        .size,
                    new StableCdmContextAllocateSecureBufferResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            StableCdmContextParseEncryptedSliceHeaderParams data2 =
                StableCdmContextParseEncryptedSliceHeaderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .parseEncryptedSliceHeader(
                    data2.secureHandle,
                    data2.offset,
                    data2.streamData,
                    new StableCdmContextParseEncryptedSliceHeaderResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class StableCdmContextGetHwKeyDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DecryptConfig decryptConfig;
    public byte[] hwIdentifier;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextGetHwKeyDataParams(int version) {
      super(24, version);
    }

    public StableCdmContextGetHwKeyDataParams() {
      this(0);
    }

    public static StableCdmContextGetHwKeyDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextGetHwKeyDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextGetHwKeyDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextGetHwKeyDataParams result =
            new StableCdmContextGetHwKeyDataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.decryptConfig = DecryptConfig.decode(decoder1);
        result.hwIdentifier = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.decryptConfig, 8, false);
      encoder0.encode(this.hwIdentifier, 16, 0, -1);
    }
  }

  static final class StableCdmContextGetHwKeyDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] keyData;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextGetHwKeyDataResponseParams(int version) {
      super(24, version);
    }

    public StableCdmContextGetHwKeyDataResponseParams() {
      this(0);
    }

    public static StableCdmContextGetHwKeyDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextGetHwKeyDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextGetHwKeyDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextGetHwKeyDataResponseParams result =
            new StableCdmContextGetHwKeyDataResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        DecryptStatus.validate(readInt);
        result.status = DecryptStatus.toKnownValue(result.status);
        result.keyData = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.keyData, 16, 0, -1);
    }
  }

  static class StableCdmContextGetHwKeyDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableCdmContext.GetHwKeyData_Response mCallback;

    StableCdmContextGetHwKeyDataResponseParamsForwardToCallback(
        StableCdmContext.GetHwKeyData_Response callback) {
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
        StableCdmContextGetHwKeyDataResponseParams response =
            StableCdmContextGetHwKeyDataResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.keyData);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StableCdmContextGetHwKeyDataResponseParamsProxyToResponder
      implements StableCdmContext.GetHwKeyData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableCdmContextGetHwKeyDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, byte[] keyData) {
      StableCdmContextGetHwKeyDataResponseParams _response =
          new StableCdmContextGetHwKeyDataResponseParams();
      _response.status = status;
      _response.keyData = keyData;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class StableCdmContextRegisterEventCallbackParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmContextEventCallback callback;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextRegisterEventCallbackParams(int version) {
      super(16, version);
    }

    public StableCdmContextRegisterEventCallbackParams() {
      this(0);
    }

    public static StableCdmContextRegisterEventCallbackParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextRegisterEventCallbackParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextRegisterEventCallbackParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextRegisterEventCallbackParams result =
            new StableCdmContextRegisterEventCallbackParams(elementsOrVersion);
        result.callback =
            (CdmContextEventCallback)
                decoder0.readServiceInterface(8, false, CdmContextEventCallback.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.callback, 8, false, CdmContextEventCallback.MANAGER);
    }
  }

  static final class StableCdmContextGetHwConfigDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextGetHwConfigDataParams(int version) {
      super(8, version);
    }

    public StableCdmContextGetHwConfigDataParams() {
      this(0);
    }

    public static StableCdmContextGetHwConfigDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextGetHwConfigDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextGetHwConfigDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextGetHwConfigDataParams result =
            new StableCdmContextGetHwConfigDataParams(elementsOrVersion);
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

  static final class StableCdmContextGetHwConfigDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] configData;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextGetHwConfigDataResponseParams(int version) {
      super(24, version);
    }

    public StableCdmContextGetHwConfigDataResponseParams() {
      this(0);
    }

    public static StableCdmContextGetHwConfigDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextGetHwConfigDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextGetHwConfigDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextGetHwConfigDataResponseParams result =
            new StableCdmContextGetHwConfigDataResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        result.configData = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode(this.configData, 16, 0, -1);
    }
  }

  static class StableCdmContextGetHwConfigDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableCdmContext.GetHwConfigData_Response mCallback;

    StableCdmContextGetHwConfigDataResponseParamsForwardToCallback(
        StableCdmContext.GetHwConfigData_Response callback) {
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
        StableCdmContextGetHwConfigDataResponseParams response =
            StableCdmContextGetHwConfigDataResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.configData);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StableCdmContextGetHwConfigDataResponseParamsProxyToResponder
      implements StableCdmContext.GetHwConfigData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableCdmContextGetHwConfigDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, byte[] configData) {
      StableCdmContextGetHwConfigDataResponseParams _response =
          new StableCdmContextGetHwConfigDataResponseParams();
      _response.success = success;
      _response.configData = configData;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class StableCdmContextGetScreenResolutionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextGetScreenResolutionsParams(int version) {
      super(8, version);
    }

    public StableCdmContextGetScreenResolutionsParams() {
      this(0);
    }

    public static StableCdmContextGetScreenResolutionsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextGetScreenResolutionsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextGetScreenResolutionsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextGetScreenResolutionsParams result =
            new StableCdmContextGetScreenResolutionsParams(elementsOrVersion);
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

  static final class StableCdmContextGetScreenResolutionsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Size[] resolutions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextGetScreenResolutionsResponseParams(int version) {
      super(16, version);
    }

    public StableCdmContextGetScreenResolutionsResponseParams() {
      this(0);
    }

    public static StableCdmContextGetScreenResolutionsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextGetScreenResolutionsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextGetScreenResolutionsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextGetScreenResolutionsResponseParams result =
            new StableCdmContextGetScreenResolutionsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.resolutions = new Size[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.resolutions[i1] = Size.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Size[] sizeArr = this.resolutions;
      if (sizeArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(sizeArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Size[] sizeArr2 = this.resolutions;
        if (i0 < sizeArr2.length) {
          encoder1.encode((Struct) sizeArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class StableCdmContextGetScreenResolutionsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableCdmContext.GetScreenResolutions_Response mCallback;

    StableCdmContextGetScreenResolutionsResponseParamsForwardToCallback(
        StableCdmContext.GetScreenResolutions_Response callback) {
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
        StableCdmContextGetScreenResolutionsResponseParams response =
            StableCdmContextGetScreenResolutionsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.resolutions);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StableCdmContextGetScreenResolutionsResponseParamsProxyToResponder
      implements StableCdmContext.GetScreenResolutions_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableCdmContextGetScreenResolutionsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Size[] resolutions) {
      StableCdmContextGetScreenResolutionsResponseParams _response =
          new StableCdmContextGetScreenResolutionsResponseParams();
      _response.resolutions = resolutions;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class StableCdmContextAllocateSecureBufferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int size;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextAllocateSecureBufferParams(int version) {
      super(16, version);
    }

    public StableCdmContextAllocateSecureBufferParams() {
      this(0);
    }

    public static StableCdmContextAllocateSecureBufferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextAllocateSecureBufferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextAllocateSecureBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextAllocateSecureBufferParams result =
            new StableCdmContextAllocateSecureBufferParams(elementsOrVersion);
        result.size = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.size, 8);
    }
  }

  static final class StableCdmContextAllocateSecureBufferResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UntypedHandle secureBuffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextAllocateSecureBufferResponseParams(int version) {
      super(16, version);
      this.secureBuffer = InvalidHandle.INSTANCE;
    }

    public StableCdmContextAllocateSecureBufferResponseParams() {
      this(0);
    }

    public static StableCdmContextAllocateSecureBufferResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextAllocateSecureBufferResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextAllocateSecureBufferResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextAllocateSecureBufferResponseParams result =
            new StableCdmContextAllocateSecureBufferResponseParams(elementsOrVersion);
        result.secureBuffer = decoder0.readUntypedHandle(8, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Handle) this.secureBuffer, 8, true);
    }
  }

  static class StableCdmContextAllocateSecureBufferResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableCdmContext.AllocateSecureBuffer_Response mCallback;

    StableCdmContextAllocateSecureBufferResponseParamsForwardToCallback(
        StableCdmContext.AllocateSecureBuffer_Response callback) {
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
        StableCdmContextAllocateSecureBufferResponseParams response =
            StableCdmContextAllocateSecureBufferResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.secureBuffer);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StableCdmContextAllocateSecureBufferResponseParamsProxyToResponder
      implements StableCdmContext.AllocateSecureBuffer_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableCdmContextAllocateSecureBufferResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(UntypedHandle secureBuffer) {
      StableCdmContextAllocateSecureBufferResponseParams _response =
          new StableCdmContextAllocateSecureBufferResponseParams();
      _response.secureBuffer = secureBuffer;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class StableCdmContextParseEncryptedSliceHeaderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int offset;
    public long secureHandle;
    public byte[] streamData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextParseEncryptedSliceHeaderParams(int version) {
      super(32, version);
    }

    public StableCdmContextParseEncryptedSliceHeaderParams() {
      this(0);
    }

    public static StableCdmContextParseEncryptedSliceHeaderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextParseEncryptedSliceHeaderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextParseEncryptedSliceHeaderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextParseEncryptedSliceHeaderParams result =
            new StableCdmContextParseEncryptedSliceHeaderParams(elementsOrVersion);
        result.secureHandle = decoder0.readLong(8);
        result.offset = decoder0.readInt(16);
        result.streamData = decoder0.readBytes(24, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.secureHandle, 8);
      encoder0.encode(this.offset, 16);
      encoder0.encode(this.streamData, 24, 0, -1);
    }
  }

  static final class StableCdmContextParseEncryptedSliceHeaderResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] sliceHeader;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableCdmContextParseEncryptedSliceHeaderResponseParams(int version) {
      super(24, version);
    }

    public StableCdmContextParseEncryptedSliceHeaderResponseParams() {
      this(0);
    }

    public static StableCdmContextParseEncryptedSliceHeaderResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static StableCdmContextParseEncryptedSliceHeaderResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableCdmContextParseEncryptedSliceHeaderResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableCdmContextParseEncryptedSliceHeaderResponseParams result =
            new StableCdmContextParseEncryptedSliceHeaderResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        result.sliceHeader = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode(this.sliceHeader, 16, 0, -1);
    }
  }

  static class StableCdmContextParseEncryptedSliceHeaderResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableCdmContext.ParseEncryptedSliceHeader_Response mCallback;

    StableCdmContextParseEncryptedSliceHeaderResponseParamsForwardToCallback(
        StableCdmContext.ParseEncryptedSliceHeader_Response callback) {
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
        StableCdmContextParseEncryptedSliceHeaderResponseParams response =
            StableCdmContextParseEncryptedSliceHeaderResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.sliceHeader);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StableCdmContextParseEncryptedSliceHeaderResponseParamsProxyToResponder
      implements StableCdmContext.ParseEncryptedSliceHeader_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableCdmContextParseEncryptedSliceHeaderResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, byte[] sliceHeader) {
      StableCdmContextParseEncryptedSliceHeaderResponseParams _response =
          new StableCdmContextParseEncryptedSliceHeaderResponseParams();
      _response.success = success;
      _response.sliceHeader = sliceHeader;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
