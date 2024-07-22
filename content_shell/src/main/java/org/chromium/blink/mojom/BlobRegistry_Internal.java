package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.url.internal.mojom.Origin;

class BlobRegistry_Internal {
  private static final int GET_BLOB_FROM_UUID_ORDINAL = 2;
  public static final Interface.Manager<BlobRegistry, BlobRegistry.Proxy> MANAGER =
      new Interface.Manager<BlobRegistry, BlobRegistry.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.BlobRegistry";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public BlobRegistry.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, BlobRegistry impl) {
          return new Stub(core, impl);
        }

        @Override
        public BlobRegistry[] buildArray(int size) {
          return new BlobRegistry[size];
        }
      };
  private static final int REGISTER_FROM_STREAM_ORDINAL = 1;
  private static final int REGISTER_ORDINAL = 0;
  private static final int URL_STORE_FOR_ORIGIN_ORDINAL = 3;

  BlobRegistry_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements BlobRegistry.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void register(
        InterfaceRequest<Blob> blob,
        String uuid,
        String contentType,
        String contentDisposition,
        DataElement[] elements,
        Register_Response callback) {
      BlobRegistryRegisterParams _message = new BlobRegistryRegisterParams();
      _message.blob = blob;
      _message.uuid = uuid;
      _message.contentType = contentType;
      _message.contentDisposition = contentDisposition;
      _message.elements = elements;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new BlobRegistryRegisterResponseParamsForwardToCallback(callback));
    }

    @Override
    public void registerFromStream(
        String contentType,
        String contentDisposition,
        long lengthHint,
        DataPipe.ConsumerHandle data,
        AssociatedInterfaceNotSupported progressClient,
        RegisterFromStream_Response callback) {
      BlobRegistryRegisterFromStreamParams _message = new BlobRegistryRegisterFromStreamParams();
      _message.contentType = contentType;
      _message.contentDisposition = contentDisposition;
      _message.lengthHint = lengthHint;
      _message.data = data;
      _message.progressClient = progressClient;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new BlobRegistryRegisterFromStreamResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getBlobFromUuid(
        InterfaceRequest<Blob> blob, String uuid, GetBlobFromUuid_Response callback) {
      BlobRegistryGetBlobFromUuidParams _message = new BlobRegistryGetBlobFromUuidParams();
      _message.blob = blob;
      _message.uuid = uuid;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new BlobRegistryGetBlobFromUuidResponseParamsForwardToCallback(callback));
    }

    @Override
    public void urlStoreForOrigin(Origin origin, AssociatedInterfaceRequestNotSupported urlStore) {
      BlobRegistryUrlStoreForOriginParams _message = new BlobRegistryUrlStoreForOriginParams();
      _message.origin = origin;
      _message.urlStore = urlStore;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<BlobRegistry> {
    Stub(Core core, BlobRegistry impl) {
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
                BlobRegistry_Internal.MANAGER, messageWithHeader);
          case 3:
            BlobRegistryUrlStoreForOriginParams data =
                BlobRegistryUrlStoreForOriginParams.deserialize(messageWithHeader.getPayload());
            getImpl().urlStoreForOrigin(data.origin, data.urlStore);
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
                getCore(), BlobRegistry_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            BlobRegistryRegisterParams data =
                BlobRegistryRegisterParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .register(
                    data.blob,
                    data.uuid,
                    data.contentType,
                    data.contentDisposition,
                    data.elements,
                    new BlobRegistryRegisterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            BlobRegistryRegisterFromStreamParams data2 =
                BlobRegistryRegisterFromStreamParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .registerFromStream(
                    data2.contentType,
                    data2.contentDisposition,
                    data2.lengthHint,
                    data2.data,
                    data2.progressClient,
                    new BlobRegistryRegisterFromStreamResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            BlobRegistryGetBlobFromUuidParams data3 =
                BlobRegistryGetBlobFromUuidParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getBlobFromUuid(
                    data3.blob,
                    data3.uuid,
                    new BlobRegistryGetBlobFromUuidResponseParamsProxyToResponder(
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

  static final class BlobRegistryRegisterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Blob> blob;
    public String contentDisposition;
    public String contentType;
    public DataElement[] elements;
    public String uuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobRegistryRegisterParams(int version) {
      super(48, version);
    }

    public BlobRegistryRegisterParams() {
      this(0);
    }

    public static BlobRegistryRegisterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobRegistryRegisterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobRegistryRegisterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobRegistryRegisterParams result = new BlobRegistryRegisterParams(elementsOrVersion);
        result.blob = decoder0.readInterfaceRequest(8, false);
        result.uuid = decoder0.readString(16, false);
        result.contentType = decoder0.readString(24, false);
        result.contentDisposition = decoder0.readString(32, false);
        Decoder decoder1 = decoder0.readPointer(40, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.elements = new DataElement[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.elements[i1] = DataElement.decode(decoder1, (i1 * 16) + 8);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.blob, 8, false);
      encoder0.encode(this.uuid, 16, false);
      encoder0.encode(this.contentType, 24, false);
      encoder0.encode(this.contentDisposition, 32, false);
      DataElement[] dataElementArr = this.elements;
      if (dataElementArr == null) {
        encoder0.encodeNullPointer(40, false);
        return;
      }
      Encoder encoder1 = encoder0.encodeUnionArray(dataElementArr.length, 40, -1);
      int i0 = 0;
      while (true) {
        DataElement[] dataElementArr2 = this.elements;
        if (i0 < dataElementArr2.length) {
          encoder1.encode((Union) dataElementArr2[i0], (i0 * 16) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class BlobRegistryRegisterResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobRegistryRegisterResponseParams(int version) {
      super(8, version);
    }

    public BlobRegistryRegisterResponseParams() {
      this(0);
    }

    public static BlobRegistryRegisterResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobRegistryRegisterResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobRegistryRegisterResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobRegistryRegisterResponseParams result =
            new BlobRegistryRegisterResponseParams(elementsOrVersion);
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

  static class BlobRegistryRegisterResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final BlobRegistry.Register_Response mCallback;

    BlobRegistryRegisterResponseParamsForwardToCallback(BlobRegistry.Register_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BlobRegistryRegisterResponseParamsProxyToResponder
      implements BlobRegistry.Register_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BlobRegistryRegisterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      BlobRegistryRegisterResponseParams _response = new BlobRegistryRegisterResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BlobRegistryRegisterFromStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public String contentDisposition;
    public String contentType;
    public DataPipe.ConsumerHandle data;
    public long lengthHint;
    public AssociatedInterfaceNotSupported progressClient;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobRegistryRegisterFromStreamParams(int version) {
      super(48, version);
      this.data = InvalidHandle.INSTANCE;
    }

    public BlobRegistryRegisterFromStreamParams() {
      this(0);
    }

    public static BlobRegistryRegisterFromStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobRegistryRegisterFromStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobRegistryRegisterFromStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobRegistryRegisterFromStreamParams result =
            new BlobRegistryRegisterFromStreamParams(elementsOrVersion);
        result.contentType = decoder0.readString(8, false);
        result.contentDisposition = decoder0.readString(16, false);
        result.lengthHint = decoder0.readLong(24);
        result.data = decoder0.readConsumerHandle(32, false);
        result.progressClient = decoder0.readAssociatedServiceInterfaceNotSupported(36, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.contentType, 8, false);
      encoder0.encode(this.contentDisposition, 16, false);
      encoder0.encode(this.lengthHint, 24);
      encoder0.encode((Handle) this.data, 32, false);
      encoder0.encode(this.progressClient, 36, true);
    }
  }

  static final class BlobRegistryRegisterFromStreamResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SerializedBlob blob;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobRegistryRegisterFromStreamResponseParams(int version) {
      super(16, version);
    }

    public BlobRegistryRegisterFromStreamResponseParams() {
      this(0);
    }

    public static BlobRegistryRegisterFromStreamResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobRegistryRegisterFromStreamResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobRegistryRegisterFromStreamResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobRegistryRegisterFromStreamResponseParams result =
            new BlobRegistryRegisterFromStreamResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.blob = SerializedBlob.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.blob, 8, true);
    }
  }

  static class BlobRegistryRegisterFromStreamResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BlobRegistry.RegisterFromStream_Response mCallback;

    BlobRegistryRegisterFromStreamResponseParamsForwardToCallback(
        BlobRegistry.RegisterFromStream_Response callback) {
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
        BlobRegistryRegisterFromStreamResponseParams response =
            BlobRegistryRegisterFromStreamResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.blob);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BlobRegistryRegisterFromStreamResponseParamsProxyToResponder
      implements BlobRegistry.RegisterFromStream_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BlobRegistryRegisterFromStreamResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SerializedBlob blob) {
      BlobRegistryRegisterFromStreamResponseParams _response =
          new BlobRegistryRegisterFromStreamResponseParams();
      _response.blob = blob;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BlobRegistryGetBlobFromUuidParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Blob> blob;
    public String uuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobRegistryGetBlobFromUuidParams(int version) {
      super(24, version);
    }

    public BlobRegistryGetBlobFromUuidParams() {
      this(0);
    }

    public static BlobRegistryGetBlobFromUuidParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobRegistryGetBlobFromUuidParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobRegistryGetBlobFromUuidParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobRegistryGetBlobFromUuidParams result =
            new BlobRegistryGetBlobFromUuidParams(elementsOrVersion);
        result.blob = decoder0.readInterfaceRequest(8, false);
        result.uuid = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.blob, 8, false);
      encoder0.encode(this.uuid, 16, false);
    }
  }

  static final class BlobRegistryGetBlobFromUuidResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobRegistryGetBlobFromUuidResponseParams(int version) {
      super(8, version);
    }

    public BlobRegistryGetBlobFromUuidResponseParams() {
      this(0);
    }

    public static BlobRegistryGetBlobFromUuidResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobRegistryGetBlobFromUuidResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobRegistryGetBlobFromUuidResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobRegistryGetBlobFromUuidResponseParams result =
            new BlobRegistryGetBlobFromUuidResponseParams(elementsOrVersion);
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

  static class BlobRegistryGetBlobFromUuidResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BlobRegistry.GetBlobFromUuid_Response mCallback;

    BlobRegistryGetBlobFromUuidResponseParamsForwardToCallback(
        BlobRegistry.GetBlobFromUuid_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BlobRegistryGetBlobFromUuidResponseParamsProxyToResponder
      implements BlobRegistry.GetBlobFromUuid_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BlobRegistryGetBlobFromUuidResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      BlobRegistryGetBlobFromUuidResponseParams _response =
          new BlobRegistryGetBlobFromUuidResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BlobRegistryUrlStoreForOriginParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin origin;
    public AssociatedInterfaceRequestNotSupported urlStore;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobRegistryUrlStoreForOriginParams(int version) {
      super(24, version);
    }

    public BlobRegistryUrlStoreForOriginParams() {
      this(0);
    }

    public static BlobRegistryUrlStoreForOriginParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobRegistryUrlStoreForOriginParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobRegistryUrlStoreForOriginParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobRegistryUrlStoreForOriginParams result =
            new BlobRegistryUrlStoreForOriginParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        result.urlStore = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode(this.urlStore, 16, false);
    }
  }
}
