package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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
import org.chromium.mojo_base.mojom.UnguessableToken;

class AudioDecoder_Internal {
  private static final int CONSTRUCT_ORDINAL = 0;
  private static final int DECODE_ORDINAL = 3;
  private static final int INITIALIZE_ORDINAL = 1;
  public static final Interface.Manager<AudioDecoder, AudioDecoder.Proxy> MANAGER =
      new Interface.Manager<AudioDecoder, AudioDecoder.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.AudioDecoder";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AudioDecoder.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AudioDecoder impl) {
          return new Stub(core, impl);
        }

        @Override
        public AudioDecoder[] buildArray(int size) {
          return new AudioDecoder[size];
        }
      };
  private static final int RESET_ORDINAL = 4;
  private static final int SET_DATA_SOURCE_ORDINAL = 2;

  AudioDecoder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements AudioDecoder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void construct(AssociatedInterfaceNotSupported client, MediaLog mediaLog) {
      AudioDecoderConstructParams _message = new AudioDecoderConstructParams();
      _message.client = client;
      _message.mediaLog = mediaLog;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void initialize(
        AudioDecoderConfig config, UnguessableToken cdmId, Initialize_Response callback) {
      AudioDecoderInitializeParams _message = new AudioDecoderInitializeParams();
      _message.config = config;
      _message.cdmId = cdmId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new AudioDecoderInitializeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setDataSource(DataPipe.ConsumerHandle receivePipe) {
      AudioDecoderSetDataSourceParams _message = new AudioDecoderSetDataSourceParams();
      _message.receivePipe = receivePipe;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void decode(DecoderBuffer buffer, Decode_Response callback) {
      AudioDecoderDecodeParams _message = new AudioDecoderDecodeParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new AudioDecoderDecodeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void reset(Reset_Response callback) {
      AudioDecoderResetParams _message = new AudioDecoderResetParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new AudioDecoderResetResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<AudioDecoder> {
    Stub(Core core, AudioDecoder impl) {
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
                AudioDecoder_Internal.MANAGER, messageWithHeader);
          case -1:
          case 1:
          default:
            return false;
          case 0:
            AudioDecoderConstructParams data =
                AudioDecoderConstructParams.deserialize(messageWithHeader.getPayload());
            getImpl().construct(data.client, data.mediaLog);
            return true;
          case 2:
            getImpl()
                .setDataSource(
                    AudioDecoderSetDataSourceParams.deserialize(messageWithHeader.getPayload())
                        .receivePipe);
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
                getCore(), AudioDecoder_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 2:
          default:
            return false;
          case 1:
            AudioDecoderInitializeParams data =
                AudioDecoderInitializeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .initialize(
                    data.config,
                    data.cdmId,
                    new AudioDecoderInitializeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            getImpl()
                .decode(
                    AudioDecoderDecodeParams.deserialize(messageWithHeader.getPayload()).buffer,
                    new AudioDecoderDecodeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            AudioDecoderResetParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .reset(
                    new AudioDecoderResetResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioDecoderConstructParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;
    public MediaLog mediaLog;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioDecoderConstructParams(int version) {
      super(24, version);
    }

    public AudioDecoderConstructParams() {
      this(0);
    }

    public static AudioDecoderConstructParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioDecoderConstructParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderConstructParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioDecoderConstructParams result = new AudioDecoderConstructParams(elementsOrVersion);
        result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        result.mediaLog = (MediaLog) decoder0.readServiceInterface(16, false, MediaLog.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false);
      encoder0.encode(this.mediaLog, 16, false, MediaLog.MANAGER);
    }
  }

  static final class AudioDecoderInitializeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken cdmId;
    public AudioDecoderConfig config;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioDecoderInitializeParams(int version) {
      super(24, version);
    }

    public AudioDecoderInitializeParams() {
      this(0);
    }

    public static AudioDecoderInitializeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioDecoderInitializeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderInitializeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioDecoderInitializeParams result = new AudioDecoderInitializeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = AudioDecoderConfig.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.cdmId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.config, 8, false);
      encoder0.encode((Struct) this.cdmId, 16, true);
    }
  }

  static final class AudioDecoderInitializeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int decoderType;
    public boolean needsBitstreamConversion;
    public DecoderStatus success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioDecoderInitializeResponseParams(int version) {
      super(24, version);
    }

    public AudioDecoderInitializeResponseParams() {
      this(0);
    }

    public static AudioDecoderInitializeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioDecoderInitializeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderInitializeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioDecoderInitializeResponseParams result =
            new AudioDecoderInitializeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.success = DecoderStatus.decode(decoder1);
        result.needsBitstreamConversion = decoder0.readBoolean(16, 0);
        int readInt = decoder0.readInt(20);
        result.decoderType = readInt;
        AudioDecoderType.validate(readInt);
        result.decoderType = AudioDecoderType.toKnownValue(result.decoderType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.success, 8, false);
      encoder0.encode(this.needsBitstreamConversion, 16, 0);
      encoder0.encode(this.decoderType, 20);
    }
  }

  static class AudioDecoderInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final AudioDecoder.Initialize_Response mCallback;

    AudioDecoderInitializeResponseParamsForwardToCallback(
        AudioDecoder.Initialize_Response callback) {
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
        AudioDecoderInitializeResponseParams response =
            AudioDecoderInitializeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.success, response.needsBitstreamConversion, response.decoderType);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioDecoderInitializeResponseParamsProxyToResponder
      implements AudioDecoder.Initialize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioDecoderInitializeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(DecoderStatus success, boolean needsBitstreamConversion, int decoderType) {
      AudioDecoderInitializeResponseParams _response = new AudioDecoderInitializeResponseParams();
      _response.success = success;
      _response.needsBitstreamConversion = needsBitstreamConversion;
      _response.decoderType = decoderType;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioDecoderSetDataSourceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ConsumerHandle receivePipe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioDecoderSetDataSourceParams(int version) {
      super(16, version);
      this.receivePipe = InvalidHandle.INSTANCE;
    }

    public AudioDecoderSetDataSourceParams() {
      this(0);
    }

    public static AudioDecoderSetDataSourceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioDecoderSetDataSourceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderSetDataSourceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioDecoderSetDataSourceParams result =
            new AudioDecoderSetDataSourceParams(elementsOrVersion);
        result.receivePipe = decoder0.readConsumerHandle(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Handle) this.receivePipe, 8, false);
    }
  }

  static final class AudioDecoderDecodeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderBuffer buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioDecoderDecodeParams(int version) {
      super(16, version);
    }

    public AudioDecoderDecodeParams() {
      this(0);
    }

    public static AudioDecoderDecodeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioDecoderDecodeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderDecodeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioDecoderDecodeParams result = new AudioDecoderDecodeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.buffer = DecoderBuffer.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.buffer, 8, false);
    }
  }

  static final class AudioDecoderDecodeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioDecoderDecodeResponseParams(int version) {
      super(16, version);
    }

    public AudioDecoderDecodeResponseParams() {
      this(0);
    }

    public static AudioDecoderDecodeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioDecoderDecodeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderDecodeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioDecoderDecodeResponseParams result =
            new AudioDecoderDecodeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = DecoderStatus.decode(decoder1);
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

  static class AudioDecoderDecodeResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final AudioDecoder.Decode_Response mCallback;

    AudioDecoderDecodeResponseParamsForwardToCallback(AudioDecoder.Decode_Response callback) {
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
        AudioDecoderDecodeResponseParams response =
            AudioDecoderDecodeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioDecoderDecodeResponseParamsProxyToResponder
      implements AudioDecoder.Decode_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioDecoderDecodeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(DecoderStatus status) {
      AudioDecoderDecodeResponseParams _response = new AudioDecoderDecodeResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioDecoderResetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioDecoderResetParams(int version) {
      super(8, version);
    }

    public AudioDecoderResetParams() {
      this(0);
    }

    public static AudioDecoderResetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioDecoderResetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderResetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioDecoderResetParams result = new AudioDecoderResetParams(elementsOrVersion);
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

  static final class AudioDecoderResetResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioDecoderResetResponseParams(int version) {
      super(8, version);
    }

    public AudioDecoderResetResponseParams() {
      this(0);
    }

    public static AudioDecoderResetResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioDecoderResetResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderResetResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioDecoderResetResponseParams result =
            new AudioDecoderResetResponseParams(elementsOrVersion);
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

  static class AudioDecoderResetResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final AudioDecoder.Reset_Response mCallback;

    AudioDecoderResetResponseParamsForwardToCallback(AudioDecoder.Reset_Response callback) {
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

  static class AudioDecoderResetResponseParamsProxyToResponder
      implements AudioDecoder.Reset_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioDecoderResetResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      AudioDecoderResetResponseParams _response = new AudioDecoderResetResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
