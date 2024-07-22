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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.BigBuffer;

class UrlLoaderClient_Internal {
  public static final Interface.Manager<UrlLoaderClient, UrlLoaderClient.Proxy> MANAGER =
      new Interface.Manager<UrlLoaderClient, UrlLoaderClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.URLLoaderClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public UrlLoaderClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, UrlLoaderClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public UrlLoaderClient[] buildArray(int size) {
          return new UrlLoaderClient[size];
        }
      };
  private static final int ON_COMPLETE_ORDINAL = 5;
  private static final int ON_RECEIVE_EARLY_HINTS_ORDINAL = 0;
  private static final int ON_RECEIVE_REDIRECT_ORDINAL = 2;
  private static final int ON_RECEIVE_RESPONSE_ORDINAL = 1;
  private static final int ON_TRANSFER_SIZE_UPDATED_ORDINAL = 4;
  private static final int ON_UPLOAD_PROGRESS_ORDINAL = 3;

  UrlLoaderClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements UrlLoaderClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onReceiveEarlyHints(EarlyHints earlyHints) {
      UrlLoaderClientOnReceiveEarlyHintsParams _message =
          new UrlLoaderClientOnReceiveEarlyHintsParams();
      _message.earlyHints = earlyHints;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onReceiveResponse(
        UrlResponseHead head, DataPipe.ConsumerHandle body, BigBuffer cachedMetadata) {
      UrlLoaderClientOnReceiveResponseParams _message =
          new UrlLoaderClientOnReceiveResponseParams();
      _message.head = head;
      _message.body = body;
      _message.cachedMetadata = cachedMetadata;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onReceiveRedirect(UrlRequestRedirectInfo redirectInfo, UrlResponseHead head) {
      UrlLoaderClientOnReceiveRedirectParams _message =
          new UrlLoaderClientOnReceiveRedirectParams();
      _message.redirectInfo = redirectInfo;
      _message.head = head;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onUploadProgress(
        long currentPosition, long totalSize, UrlLoaderClient.OnUploadProgress_Response callback) {
      UrlLoaderClientOnUploadProgressParams _message = new UrlLoaderClientOnUploadProgressParams();
      _message.currentPosition = currentPosition;
      _message.totalSize = totalSize;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new UrlLoaderClientOnUploadProgressResponseParamsForwardToCallback(callback));
    }

    @Override
    public void onTransferSizeUpdated(int transferSizeDiff) {
      UrlLoaderClientOnTransferSizeUpdatedParams _message =
          new UrlLoaderClientOnTransferSizeUpdatedParams();
      _message.transferSizeDiff = transferSizeDiff;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onComplete(UrlLoaderCompletionStatus status) {
      UrlLoaderClientOnCompleteParams _message = new UrlLoaderClientOnCompleteParams();
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<UrlLoaderClient> {
    Stub(Core core, UrlLoaderClient impl) {
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
                UrlLoaderClient_Internal.MANAGER, messageWithHeader);
          case -1:
          case 3:
          default:
            return false;
          case 0:
            getImpl()
                .onReceiveEarlyHints(
                    UrlLoaderClientOnReceiveEarlyHintsParams.deserialize(
                            messageWithHeader.getPayload())
                        .earlyHints);
            return true;
          case 1:
            UrlLoaderClientOnReceiveResponseParams data =
                UrlLoaderClientOnReceiveResponseParams.deserialize(messageWithHeader.getPayload());
            getImpl().onReceiveResponse(data.head, data.body, data.cachedMetadata);
            return true;
          case 2:
            UrlLoaderClientOnReceiveRedirectParams data2 =
                UrlLoaderClientOnReceiveRedirectParams.deserialize(messageWithHeader.getPayload());
            getImpl().onReceiveRedirect(data2.redirectInfo, data2.head);
            return true;
          case 4:
            UrlLoaderClientOnTransferSizeUpdatedParams data3 =
                UrlLoaderClientOnTransferSizeUpdatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onTransferSizeUpdated(data3.transferSizeDiff);
            return true;
          case 5:
            UrlLoaderClientOnCompleteParams data4 =
                UrlLoaderClientOnCompleteParams.deserialize(messageWithHeader.getPayload());
            getImpl().onComplete(data4.status);
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
                getCore(), UrlLoaderClient_Internal.MANAGER, messageWithHeader, receiver);
          case 3:
            UrlLoaderClientOnUploadProgressParams data =
                UrlLoaderClientOnUploadProgressParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .onUploadProgress(
                    data.currentPosition,
                    data.totalSize,
                    new UrlLoaderClientOnUploadProgressResponseParamsProxyToResponder(
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

  static final class UrlLoaderClientOnReceiveEarlyHintsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public EarlyHints earlyHints;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderClientOnReceiveEarlyHintsParams(int version) {
      super(16, version);
    }

    public UrlLoaderClientOnReceiveEarlyHintsParams() {
      this(0);
    }

    public static UrlLoaderClientOnReceiveEarlyHintsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderClientOnReceiveEarlyHintsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderClientOnReceiveEarlyHintsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderClientOnReceiveEarlyHintsParams result =
            new UrlLoaderClientOnReceiveEarlyHintsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.earlyHints = EarlyHints.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.earlyHints, 8, false);
    }
  }

  static final class UrlLoaderClientOnReceiveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ConsumerHandle body;
    public BigBuffer cachedMetadata;
    public UrlResponseHead head;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderClientOnReceiveResponseParams(int version) {
      super(40, version);
      this.body = InvalidHandle.INSTANCE;
    }

    public UrlLoaderClientOnReceiveResponseParams() {
      this(0);
    }

    public static UrlLoaderClientOnReceiveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderClientOnReceiveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderClientOnReceiveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderClientOnReceiveResponseParams result =
            new UrlLoaderClientOnReceiveResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.head = UrlResponseHead.decode(decoder1);
        result.body = decoder0.readConsumerHandle(16, true);
        result.cachedMetadata = BigBuffer.decode(decoder0, 24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.head, 8, false);
      encoder0.encode((Handle) this.body, 16, true);
      encoder0.encode((Union) this.cachedMetadata, 24, true);
    }
  }

  static final class UrlLoaderClientOnReceiveRedirectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UrlResponseHead head;
    public UrlRequestRedirectInfo redirectInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderClientOnReceiveRedirectParams(int version) {
      super(24, version);
    }

    public UrlLoaderClientOnReceiveRedirectParams() {
      this(0);
    }

    public static UrlLoaderClientOnReceiveRedirectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderClientOnReceiveRedirectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderClientOnReceiveRedirectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderClientOnReceiveRedirectParams result =
            new UrlLoaderClientOnReceiveRedirectParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.redirectInfo = UrlRequestRedirectInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.head = UrlResponseHead.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.redirectInfo, 8, false);
      encoder0.encode((Struct) this.head, 16, false);
    }
  }

  static final class UrlLoaderClientOnUploadProgressParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long currentPosition;
    public long totalSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderClientOnUploadProgressParams(int version) {
      super(24, version);
    }

    public UrlLoaderClientOnUploadProgressParams() {
      this(0);
    }

    public static UrlLoaderClientOnUploadProgressParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderClientOnUploadProgressParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderClientOnUploadProgressParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderClientOnUploadProgressParams result =
            new UrlLoaderClientOnUploadProgressParams(elementsOrVersion);
        result.currentPosition = decoder0.readLong(8);
        result.totalSize = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.currentPosition, 8);
      encoder0.encode(this.totalSize, 16);
    }
  }

  static final class UrlLoaderClientOnUploadProgressResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderClientOnUploadProgressResponseParams(int version) {
      super(8, version);
    }

    public UrlLoaderClientOnUploadProgressResponseParams() {
      this(0);
    }

    public static UrlLoaderClientOnUploadProgressResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderClientOnUploadProgressResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderClientOnUploadProgressResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderClientOnUploadProgressResponseParams result =
            new UrlLoaderClientOnUploadProgressResponseParams(elementsOrVersion);
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

  static class UrlLoaderClientOnUploadProgressResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UrlLoaderClient.OnUploadProgress_Response mCallback;

    UrlLoaderClientOnUploadProgressResponseParamsForwardToCallback(
        UrlLoaderClient.OnUploadProgress_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UrlLoaderClientOnUploadProgressResponseParamsProxyToResponder
      implements UrlLoaderClient.OnUploadProgress_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UrlLoaderClientOnUploadProgressResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      UrlLoaderClientOnUploadProgressResponseParams _response =
          new UrlLoaderClientOnUploadProgressResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UrlLoaderClientOnTransferSizeUpdatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int transferSizeDiff;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderClientOnTransferSizeUpdatedParams(int version) {
      super(16, version);
    }

    public UrlLoaderClientOnTransferSizeUpdatedParams() {
      this(0);
    }

    public static UrlLoaderClientOnTransferSizeUpdatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderClientOnTransferSizeUpdatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderClientOnTransferSizeUpdatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderClientOnTransferSizeUpdatedParams result =
            new UrlLoaderClientOnTransferSizeUpdatedParams(elementsOrVersion);
        result.transferSizeDiff = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.transferSizeDiff, 8);
    }
  }

  static final class UrlLoaderClientOnCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UrlLoaderCompletionStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderClientOnCompleteParams(int version) {
      super(16, version);
    }

    public UrlLoaderClientOnCompleteParams() {
      this(0);
    }

    public static UrlLoaderClientOnCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderClientOnCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderClientOnCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderClientOnCompleteParams result =
            new UrlLoaderClientOnCompleteParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = UrlLoaderCompletionStatus.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.status, 8, false);
    }
  }
}
