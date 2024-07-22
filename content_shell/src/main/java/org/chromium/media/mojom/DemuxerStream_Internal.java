package org.chromium.media.mojom;

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

class DemuxerStream_Internal {
  private static final int ENABLE_BITSTREAM_CONVERTER_ORDINAL = 2;
  private static final int INITIALIZE_ORDINAL = 0;
  public static final Interface.Manager<DemuxerStream, DemuxerStream.Proxy> MANAGER =
      new Interface.Manager<DemuxerStream, DemuxerStream.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.DemuxerStream";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DemuxerStream.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DemuxerStream impl) {
          return new Stub(core, impl);
        }

        @Override
        public DemuxerStream[] buildArray(int size) {
          return new DemuxerStream[size];
        }
      };
  private static final int READ_ORDINAL = 1;

  DemuxerStream_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements DemuxerStream.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void initialize(Initialize_Response callback) {
      DemuxerStreamInitializeParams _message = new DemuxerStreamInitializeParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DemuxerStreamInitializeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void read(int count, Read_Response callback) {
      DemuxerStreamReadParams _message = new DemuxerStreamReadParams();
      _message.count = count;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new DemuxerStreamReadResponseParamsForwardToCallback(callback));
    }

    @Override
    public void enableBitstreamConverter() {
      DemuxerStreamEnableBitstreamConverterParams _message =
          new DemuxerStreamEnableBitstreamConverterParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<DemuxerStream> {
    Stub(Core core, DemuxerStream impl) {
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
                DemuxerStream_Internal.MANAGER, messageWithHeader);
          case 2:
            DemuxerStreamEnableBitstreamConverterParams.deserialize(messageWithHeader.getPayload());
            getImpl().enableBitstreamConverter();
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
                getCore(), DemuxerStream_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            DemuxerStreamInitializeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .initialize(
                    new DemuxerStreamInitializeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            DemuxerStreamReadParams data =
                DemuxerStreamReadParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .read(
                    data.count,
                    new DemuxerStreamReadResponseParamsProxyToResponder(
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

  static final class DemuxerStreamInitializeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DemuxerStreamInitializeParams(int version) {
      super(8, version);
    }

    public DemuxerStreamInitializeParams() {
      this(0);
    }

    public static DemuxerStreamInitializeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DemuxerStreamInitializeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DemuxerStreamInitializeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DemuxerStreamInitializeParams result = new DemuxerStreamInitializeParams(elementsOrVersion);
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

  static final class DemuxerStreamInitializeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioDecoderConfig audioConfig;
    public DataPipe.ConsumerHandle pipe;
    public int type;
    public VideoDecoderConfig videoConfig;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DemuxerStreamInitializeResponseParams(int version) {
      super(32, version);
      this.pipe = InvalidHandle.INSTANCE;
    }

    public DemuxerStreamInitializeResponseParams() {
      this(0);
    }

    public static DemuxerStreamInitializeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DemuxerStreamInitializeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DemuxerStreamInitializeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DemuxerStreamInitializeResponseParams result =
            new DemuxerStreamInitializeResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        DemuxerStream.Type.validate(readInt);
        result.type = DemuxerStream.Type.toKnownValue(result.type);
        result.pipe = decoder0.readConsumerHandle(12, false);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.audioConfig = AudioDecoderConfig.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.videoConfig = VideoDecoderConfig.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode((Handle) this.pipe, 12, false);
      encoder0.encode((Struct) this.audioConfig, 16, true);
      encoder0.encode((Struct) this.videoConfig, 24, true);
    }
  }

  static class DemuxerStreamInitializeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DemuxerStream.Initialize_Response mCallback;

    DemuxerStreamInitializeResponseParamsForwardToCallback(
        DemuxerStream.Initialize_Response callback) {
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
        DemuxerStreamInitializeResponseParams response =
            DemuxerStreamInitializeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.type, response.pipe, response.audioConfig, response.videoConfig);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DemuxerStreamInitializeResponseParamsProxyToResponder
      implements DemuxerStream.Initialize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DemuxerStreamInitializeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int type,
        DataPipe.ConsumerHandle pipe,
        AudioDecoderConfig audioConfig,
        VideoDecoderConfig videoConfig) {
      DemuxerStreamInitializeResponseParams _response = new DemuxerStreamInitializeResponseParams();
      _response.type = type;
      _response.pipe = pipe;
      _response.audioConfig = audioConfig;
      _response.videoConfig = videoConfig;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DemuxerStreamReadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int count;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DemuxerStreamReadParams(int version) {
      super(16, version);
    }

    public DemuxerStreamReadParams() {
      this(0);
    }

    public static DemuxerStreamReadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DemuxerStreamReadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DemuxerStreamReadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DemuxerStreamReadParams result = new DemuxerStreamReadParams(elementsOrVersion);
        result.count = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.count, 8);
    }
  }

  static final class DemuxerStreamReadResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioDecoderConfig audioConfig;
    public DecoderBuffer[] batchBuffers;
    public int status;
    public VideoDecoderConfig videoConfig;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DemuxerStreamReadResponseParams(int version) {
      super(40, version);
    }

    public DemuxerStreamReadResponseParams() {
      this(0);
    }

    public static DemuxerStreamReadResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DemuxerStreamReadResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DemuxerStreamReadResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DemuxerStreamReadResponseParams result =
            new DemuxerStreamReadResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        DemuxerStream.Status.validate(readInt);
        result.status = DemuxerStream.Status.toKnownValue(result.status);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.batchBuffers = new DecoderBuffer[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.batchBuffers[i1] = DecoderBuffer.decode(decoder2);
        }
        result.audioConfig = AudioDecoderConfig.decode(decoder0.readPointer(24, true));
        result.videoConfig = VideoDecoderConfig.decode(decoder0.readPointer(32, true));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      DecoderBuffer[] decoderBufferArr = this.batchBuffers;
      if (decoderBufferArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(decoderBufferArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          DecoderBuffer[] decoderBufferArr2 = this.batchBuffers;
          if (i0 >= decoderBufferArr2.length) {
            break;
          }
          encoder1.encode((Struct) decoderBufferArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.audioConfig, 24, true);
      encoder0.encode((Struct) this.videoConfig, 32, true);
    }
  }

  static class DemuxerStreamReadResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final DemuxerStream.Read_Response mCallback;

    DemuxerStreamReadResponseParamsForwardToCallback(DemuxerStream.Read_Response callback) {
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
        DemuxerStreamReadResponseParams response =
            DemuxerStreamReadResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.status, response.batchBuffers, response.audioConfig, response.videoConfig);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DemuxerStreamReadResponseParamsProxyToResponder
      implements DemuxerStream.Read_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DemuxerStreamReadResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int status,
        DecoderBuffer[] batchBuffers,
        AudioDecoderConfig audioConfig,
        VideoDecoderConfig videoConfig) {
      DemuxerStreamReadResponseParams _response = new DemuxerStreamReadResponseParams();
      _response.status = status;
      _response.batchBuffers = batchBuffers;
      _response.audioConfig = audioConfig;
      _response.videoConfig = videoConfig;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DemuxerStreamEnableBitstreamConverterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DemuxerStreamEnableBitstreamConverterParams(int version) {
      super(8, version);
    }

    public DemuxerStreamEnableBitstreamConverterParams() {
      this(0);
    }

    public static DemuxerStreamEnableBitstreamConverterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DemuxerStreamEnableBitstreamConverterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DemuxerStreamEnableBitstreamConverterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DemuxerStreamEnableBitstreamConverterParams result =
            new DemuxerStreamEnableBitstreamConverterParams(elementsOrVersion);
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
}
