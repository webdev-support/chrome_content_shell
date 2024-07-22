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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.Time;

class BytesProvider_Internal {
  public static final Interface.Manager<BytesProvider, BytesProvider.Proxy> MANAGER =
      new Interface.Manager<BytesProvider, BytesProvider.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.BytesProvider";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public BytesProvider.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, BytesProvider impl) {
          return new Stub(core, impl);
        }

        @Override
        public BytesProvider[] buildArray(int size) {
          return new BytesProvider[size];
        }
      };
  private static final int REQUEST_AS_FILE_ORDINAL = 2;
  private static final int REQUEST_AS_REPLY_ORDINAL = 0;
  private static final int REQUEST_AS_STREAM_ORDINAL = 1;

  BytesProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements BytesProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestAsReply(RequestAsReply_Response callback) {
      BytesProviderRequestAsReplyParams _message = new BytesProviderRequestAsReplyParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new BytesProviderRequestAsReplyResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestAsStream(DataPipe.ProducerHandle pipe) {
      BytesProviderRequestAsStreamParams _message = new BytesProviderRequestAsStreamParams();
      _message.pipe = pipe;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void requestAsFile(
        long sourceOffset,
        long sourceSize,
        org.chromium.mojo_base.mojom.File file,
        long fileOffset,
        RequestAsFile_Response callback) {
      BytesProviderRequestAsFileParams _message = new BytesProviderRequestAsFileParams();
      _message.sourceOffset = sourceOffset;
      _message.sourceSize = sourceSize;
      _message.file = file;
      _message.fileOffset = fileOffset;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new BytesProviderRequestAsFileResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<BytesProvider> {
    Stub(Core core, BytesProvider impl) {
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
                BytesProvider_Internal.MANAGER, messageWithHeader);
          case 1:
            BytesProviderRequestAsStreamParams data =
                BytesProviderRequestAsStreamParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestAsStream(data.pipe);
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
                getCore(), BytesProvider_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            BytesProviderRequestAsReplyParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestAsReply(
                    new BytesProviderRequestAsReplyResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            BytesProviderRequestAsFileParams data =
                BytesProviderRequestAsFileParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestAsFile(
                    data.sourceOffset,
                    data.sourceSize,
                    data.file,
                    data.fileOffset,
                    new BytesProviderRequestAsFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class BytesProviderRequestAsReplyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BytesProviderRequestAsReplyParams(int version) {
      super(8, version);
    }

    public BytesProviderRequestAsReplyParams() {
      this(0);
    }

    public static BytesProviderRequestAsReplyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BytesProviderRequestAsReplyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BytesProviderRequestAsReplyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BytesProviderRequestAsReplyParams result =
            new BytesProviderRequestAsReplyParams(elementsOrVersion);
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

  static final class BytesProviderRequestAsReplyResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BytesProviderRequestAsReplyResponseParams(int version) {
      super(16, version);
    }

    public BytesProviderRequestAsReplyResponseParams() {
      this(0);
    }

    public static BytesProviderRequestAsReplyResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BytesProviderRequestAsReplyResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BytesProviderRequestAsReplyResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BytesProviderRequestAsReplyResponseParams result =
            new BytesProviderRequestAsReplyResponseParams(elementsOrVersion);
        result.data = decoder0.readBytes(8, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.data, 8, 0, -1);
    }
  }

  static class BytesProviderRequestAsReplyResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BytesProvider.RequestAsReply_Response mCallback;

    BytesProviderRequestAsReplyResponseParamsForwardToCallback(
        BytesProvider.RequestAsReply_Response callback) {
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
        BytesProviderRequestAsReplyResponseParams response =
            BytesProviderRequestAsReplyResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.data);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BytesProviderRequestAsReplyResponseParamsProxyToResponder
      implements BytesProvider.RequestAsReply_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BytesProviderRequestAsReplyResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(byte[] data) {
      BytesProviderRequestAsReplyResponseParams _response =
          new BytesProviderRequestAsReplyResponseParams();
      _response.data = data;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BytesProviderRequestAsStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ProducerHandle pipe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BytesProviderRequestAsStreamParams(int version) {
      super(16, version);
      this.pipe = InvalidHandle.INSTANCE;
    }

    public BytesProviderRequestAsStreamParams() {
      this(0);
    }

    public static BytesProviderRequestAsStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BytesProviderRequestAsStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BytesProviderRequestAsStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BytesProviderRequestAsStreamParams result =
            new BytesProviderRequestAsStreamParams(elementsOrVersion);
        result.pipe = decoder0.readProducerHandle(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Handle) this.pipe, 8, false);
    }
  }

  static final class BytesProviderRequestAsFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public org.chromium.mojo_base.mojom.File file;
    public long fileOffset;
    public long sourceOffset;
    public long sourceSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BytesProviderRequestAsFileParams(int version) {
      super(40, version);
    }

    public BytesProviderRequestAsFileParams() {
      this(0);
    }

    public static BytesProviderRequestAsFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BytesProviderRequestAsFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BytesProviderRequestAsFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BytesProviderRequestAsFileParams result =
            new BytesProviderRequestAsFileParams(elementsOrVersion);
        result.sourceOffset = decoder0.readLong(8);
        result.sourceSize = decoder0.readLong(16);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.file = org.chromium.mojo_base.mojom.File.decode(decoder1);
        result.fileOffset = decoder0.readLong(32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sourceOffset, 8);
      encoder0.encode(this.sourceSize, 16);
      encoder0.encode((Struct) this.file, 24, false);
      encoder0.encode(this.fileOffset, 32);
    }
  }

  static final class BytesProviderRequestAsFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Time timeFileModified;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BytesProviderRequestAsFileResponseParams(int version) {
      super(16, version);
    }

    public BytesProviderRequestAsFileResponseParams() {
      this(0);
    }

    public static BytesProviderRequestAsFileResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BytesProviderRequestAsFileResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BytesProviderRequestAsFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BytesProviderRequestAsFileResponseParams result =
            new BytesProviderRequestAsFileResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.timeFileModified = Time.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.timeFileModified, 8, true);
    }
  }

  static class BytesProviderRequestAsFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BytesProvider.RequestAsFile_Response mCallback;

    BytesProviderRequestAsFileResponseParamsForwardToCallback(
        BytesProvider.RequestAsFile_Response callback) {
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
        BytesProviderRequestAsFileResponseParams response =
            BytesProviderRequestAsFileResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.timeFileModified);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BytesProviderRequestAsFileResponseParamsProxyToResponder
      implements BytesProvider.RequestAsFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BytesProviderRequestAsFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Time timeFileModified) {
      BytesProviderRequestAsFileResponseParams _response =
          new BytesProviderRequestAsFileResponseParams();
      _response.timeFileModified = timeFileModified;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
