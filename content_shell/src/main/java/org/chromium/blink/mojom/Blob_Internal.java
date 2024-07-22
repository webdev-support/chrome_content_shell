package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.network.mojom.DataPipeGetter;
import org.chromium.network.mojom.HttpRequestHeaders;
import org.chromium.network.mojom.UrlLoader;
import org.chromium.network.mojom.UrlLoaderClient;

class Blob_Internal {
  private static final int AS_DATA_PIPE_GETTER_ORDINAL = 1;
  private static final int CAPTURE_SNAPSHOT_ORDINAL = 6;
  private static final int CLONE_ORDINAL = 0;
  private static final int GET_INTERNAL_UUID_ORDINAL = 7;
  private static final int LOAD_ORDINAL = 4;
  public static final Interface.Manager<Blob, Blob.Proxy> MANAGER =
      new Interface.Manager<Blob, Blob.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.Blob";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Blob.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Blob impl) {
          return new Stub(core, impl);
        }

        @Override
        public Blob[] buildArray(int size) {
          return new Blob[size];
        }
      };
  private static final int READ_ALL_ORDINAL = 2;
  private static final int READ_RANGE_ORDINAL = 3;
  private static final int READ_SIDE_DATA_ORDINAL = 5;

  Blob_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Blob.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void clone(InterfaceRequest<Blob> blob) {
      BlobCloneParams _message = new BlobCloneParams();
      _message.blob = blob;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void asDataPipeGetter(InterfaceRequest<DataPipeGetter> dataPipeGetter) {
      BlobAsDataPipeGetterParams _message = new BlobAsDataPipeGetterParams();
      _message.dataPipeGetter = dataPipeGetter;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void readAll(DataPipe.ProducerHandle pipe, BlobReaderClient client) {
      BlobReadAllParams _message = new BlobReadAllParams();
      _message.pipe = pipe;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void readRange(
        long offset, long length, DataPipe.ProducerHandle pipe, BlobReaderClient client) {
      BlobReadRangeParams _message = new BlobReadRangeParams();
      _message.offset = offset;
      _message.length = length;
      _message.pipe = pipe;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void load(
        InterfaceRequest<UrlLoader> loader,
        String requestMethod,
        HttpRequestHeaders headers,
        UrlLoaderClient client) {
      BlobLoadParams _message = new BlobLoadParams();
      _message.loader = loader;
      _message.requestMethod = requestMethod;
      _message.headers = headers;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void readSideData(ReadSideData_Response callback) {
      BlobReadSideDataParams _message = new BlobReadSideDataParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new BlobReadSideDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void captureSnapshot(CaptureSnapshot_Response callback) {
      BlobCaptureSnapshotParams _message = new BlobCaptureSnapshotParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new BlobCaptureSnapshotResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getInternalUuid(GetInternalUuid_Response callback) {
      BlobGetInternalUuidParams _message = new BlobGetInternalUuidParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new BlobGetInternalUuidResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<Blob> {
    Stub(Core core, Blob impl) {
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
                Blob_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            BlobCloneParams data = BlobCloneParams.deserialize(messageWithHeader.getPayload());
            getImpl().clone(data.blob);
            return true;
          case 1:
            BlobAsDataPipeGetterParams data2 =
                BlobAsDataPipeGetterParams.deserialize(messageWithHeader.getPayload());
            getImpl().asDataPipeGetter(data2.dataPipeGetter);
            return true;
          case 2:
            BlobReadAllParams data3 = BlobReadAllParams.deserialize(messageWithHeader.getPayload());
            getImpl().readAll(data3.pipe, data3.client);
            return true;
          case 3:
            BlobReadRangeParams data4 =
                BlobReadRangeParams.deserialize(messageWithHeader.getPayload());
            getImpl().readRange(data4.offset, data4.length, data4.pipe, data4.client);
            return true;
          case 4:
            BlobLoadParams data5 = BlobLoadParams.deserialize(messageWithHeader.getPayload());
            getImpl().load(data5.loader, data5.requestMethod, data5.headers, data5.client);
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
                getCore(), Blob_Internal.MANAGER, messageWithHeader, receiver);
          case 5:
            BlobReadSideDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readSideData(
                    new BlobReadSideDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            BlobCaptureSnapshotParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .captureSnapshot(
                    new BlobCaptureSnapshotResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            BlobGetInternalUuidParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getInternalUuid(
                    new BlobGetInternalUuidResponseParamsProxyToResponder(
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

  static final class BlobCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Blob> blob;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobCloneParams(int version) {
      super(16, version);
    }

    public BlobCloneParams() {
      this(0);
    }

    public static BlobCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobCloneParams result = new BlobCloneParams(elementsOrVersion);
        result.blob = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.blob, 8, false);
    }
  }

  static final class BlobAsDataPipeGetterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<DataPipeGetter> dataPipeGetter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobAsDataPipeGetterParams(int version) {
      super(16, version);
    }

    public BlobAsDataPipeGetterParams() {
      this(0);
    }

    public static BlobAsDataPipeGetterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobAsDataPipeGetterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobAsDataPipeGetterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobAsDataPipeGetterParams result = new BlobAsDataPipeGetterParams(elementsOrVersion);
        result.dataPipeGetter = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.dataPipeGetter, 8, false);
    }
  }

  static final class BlobReadAllParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BlobReaderClient client;
    public DataPipe.ProducerHandle pipe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobReadAllParams(int version) {
      super(24, version);
      this.pipe = InvalidHandle.INSTANCE;
    }

    public BlobReadAllParams() {
      this(0);
    }

    public static BlobReadAllParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobReadAllParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobReadAllParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobReadAllParams result = new BlobReadAllParams(elementsOrVersion);
        result.pipe = decoder0.readProducerHandle(8, false);
        result.client =
            (BlobReaderClient) decoder0.readServiceInterface(12, true, BlobReaderClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Handle) this.pipe, 8, false);
      encoder0.encode(this.client, 12, true, BlobReaderClient.MANAGER);
    }
  }

  static final class BlobReadRangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public BlobReaderClient client;
    public long length;
    public long offset;
    public DataPipe.ProducerHandle pipe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobReadRangeParams(int version) {
      super(40, version);
      this.pipe = InvalidHandle.INSTANCE;
    }

    public BlobReadRangeParams() {
      this(0);
    }

    public static BlobReadRangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobReadRangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobReadRangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobReadRangeParams result = new BlobReadRangeParams(elementsOrVersion);
        result.offset = decoder0.readLong(8);
        result.length = decoder0.readLong(16);
        result.pipe = decoder0.readProducerHandle(24, false);
        result.client =
            (BlobReaderClient) decoder0.readServiceInterface(28, true, BlobReaderClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.offset, 8);
      encoder0.encode(this.length, 16);
      encoder0.encode((Handle) this.pipe, 24, false);
      encoder0.encode(this.client, 28, true, BlobReaderClient.MANAGER);
    }
  }

  static final class BlobLoadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public UrlLoaderClient client;
    public HttpRequestHeaders headers;
    public InterfaceRequest<UrlLoader> loader;
    public String requestMethod;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobLoadParams(int version) {
      super(40, version);
    }

    public BlobLoadParams() {
      this(0);
    }

    public static BlobLoadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobLoadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobLoadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobLoadParams result = new BlobLoadParams(elementsOrVersion);
        result.loader = decoder0.readInterfaceRequest(8, false);
        result.requestMethod = decoder0.readString(16, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.headers = HttpRequestHeaders.decode(decoder1);
        result.client =
            (UrlLoaderClient) decoder0.readServiceInterface(32, false, UrlLoaderClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.loader, 8, false);
      encoder0.encode(this.requestMethod, 16, false);
      encoder0.encode((Struct) this.headers, 24, false);
      encoder0.encode(this.client, 32, false, UrlLoaderClient.MANAGER);
    }
  }

  static final class BlobReadSideDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobReadSideDataParams(int version) {
      super(8, version);
    }

    public BlobReadSideDataParams() {
      this(0);
    }

    public static BlobReadSideDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobReadSideDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobReadSideDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobReadSideDataParams result = new BlobReadSideDataParams(elementsOrVersion);
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

  static final class BlobReadSideDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BigBuffer data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobReadSideDataResponseParams(int version) {
      super(24, version);
    }

    public BlobReadSideDataResponseParams() {
      this(0);
    }

    public static BlobReadSideDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobReadSideDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobReadSideDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobReadSideDataResponseParams result =
            new BlobReadSideDataResponseParams(elementsOrVersion);
        result.data = BigBuffer.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.data, 8, true);
    }
  }

  static class BlobReadSideDataResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Blob.ReadSideData_Response mCallback;

    BlobReadSideDataResponseParamsForwardToCallback(Blob.ReadSideData_Response callback) {
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
        BlobReadSideDataResponseParams response =
            BlobReadSideDataResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.data);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BlobReadSideDataResponseParamsProxyToResponder
      implements Blob.ReadSideData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BlobReadSideDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigBuffer data) {
      BlobReadSideDataResponseParams _response = new BlobReadSideDataResponseParams();
      _response.data = data;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BlobCaptureSnapshotParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobCaptureSnapshotParams(int version) {
      super(8, version);
    }

    public BlobCaptureSnapshotParams() {
      this(0);
    }

    public static BlobCaptureSnapshotParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobCaptureSnapshotParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobCaptureSnapshotParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobCaptureSnapshotParams result = new BlobCaptureSnapshotParams(elementsOrVersion);
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

  static final class BlobCaptureSnapshotResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long length;
    public Time modificationTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobCaptureSnapshotResponseParams(int version) {
      super(24, version);
    }

    public BlobCaptureSnapshotResponseParams() {
      this(0);
    }

    public static BlobCaptureSnapshotResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobCaptureSnapshotResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobCaptureSnapshotResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobCaptureSnapshotResponseParams result =
            new BlobCaptureSnapshotResponseParams(elementsOrVersion);
        result.length = decoder0.readLong(8);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.modificationTime = Time.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.length, 8);
      encoder0.encode((Struct) this.modificationTime, 16, true);
    }
  }

  static class BlobCaptureSnapshotResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Blob.CaptureSnapshot_Response mCallback;

    BlobCaptureSnapshotResponseParamsForwardToCallback(Blob.CaptureSnapshot_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 6)) {
          return false;
        }
        BlobCaptureSnapshotResponseParams response =
            BlobCaptureSnapshotResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.length, response.modificationTime);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BlobCaptureSnapshotResponseParamsProxyToResponder
      implements Blob.CaptureSnapshot_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BlobCaptureSnapshotResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(long length, Time modificationTime) {
      BlobCaptureSnapshotResponseParams _response = new BlobCaptureSnapshotResponseParams();
      _response.length = length;
      _response.modificationTime = modificationTime;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BlobGetInternalUuidParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobGetInternalUuidParams(int version) {
      super(8, version);
    }

    public BlobGetInternalUuidParams() {
      this(0);
    }

    public static BlobGetInternalUuidParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobGetInternalUuidParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobGetInternalUuidParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobGetInternalUuidParams result = new BlobGetInternalUuidParams(elementsOrVersion);
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

  static final class BlobGetInternalUuidResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String uuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobGetInternalUuidResponseParams(int version) {
      super(16, version);
    }

    public BlobGetInternalUuidResponseParams() {
      this(0);
    }

    public static BlobGetInternalUuidResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobGetInternalUuidResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobGetInternalUuidResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobGetInternalUuidResponseParams result =
            new BlobGetInternalUuidResponseParams(elementsOrVersion);
        result.uuid = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.uuid, 8, false);
    }
  }

  static class BlobGetInternalUuidResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Blob.GetInternalUuid_Response mCallback;

    BlobGetInternalUuidResponseParamsForwardToCallback(Blob.GetInternalUuid_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 2)) {
          return false;
        }
        BlobGetInternalUuidResponseParams response =
            BlobGetInternalUuidResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.uuid);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BlobGetInternalUuidResponseParamsProxyToResponder
      implements Blob.GetInternalUuid_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BlobGetInternalUuidResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String uuid) {
      BlobGetInternalUuidResponseParams _response = new BlobGetInternalUuidResponseParams();
      _response.uuid = uuid;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
