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

class Decryptor_Internal {
  private static final int CANCEL_DECRYPT_ORDINAL = 2;
  private static final int DECRYPT_AND_DECODE_AUDIO_ORDINAL = 5;
  private static final int DECRYPT_AND_DECODE_VIDEO_ORDINAL = 6;
  private static final int DECRYPT_ORDINAL = 1;
  private static final int DEINITIALIZE_DECODER_ORDINAL = 8;
  private static final int INITIALIZE_AUDIO_DECODER_ORDINAL = 3;
  private static final int INITIALIZE_ORDINAL = 0;
  private static final int INITIALIZE_VIDEO_DECODER_ORDINAL = 4;
  public static final Interface.Manager<Decryptor, Decryptor.Proxy> MANAGER =
      new Interface.Manager<Decryptor, Decryptor.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.Decryptor";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Decryptor.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Decryptor impl) {
          return new Stub(core, impl);
        }

        @Override
        public Decryptor[] buildArray(int size) {
          return new Decryptor[size];
        }
      };
  private static final int RESET_DECODER_ORDINAL = 7;

  Decryptor_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Decryptor.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void initialize(
        DataPipe.ConsumerHandle audioPipe,
        DataPipe.ConsumerHandle videoPipe,
        DataPipe.ConsumerHandle decryptPipe,
        DataPipe.ProducerHandle decryptedPipe) {
      DecryptorInitializeParams _message = new DecryptorInitializeParams();
      _message.audioPipe = audioPipe;
      _message.videoPipe = videoPipe;
      _message.decryptPipe = decryptPipe;
      _message.decryptedPipe = decryptedPipe;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void decrypt(int streamType, DecoderBuffer encrypted, Decrypt_Response callback) {
      DecryptorDecryptParams _message = new DecryptorDecryptParams();
      _message.streamType = streamType;
      _message.encrypted = encrypted;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new DecryptorDecryptResponseParamsForwardToCallback(callback));
    }

    @Override
    public void cancelDecrypt(int streamType) {
      DecryptorCancelDecryptParams _message = new DecryptorCancelDecryptParams();
      _message.streamType = streamType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void initializeAudioDecoder(
        AudioDecoderConfig config, InitializeAudioDecoder_Response callback) {
      DecryptorInitializeAudioDecoderParams _message = new DecryptorInitializeAudioDecoderParams();
      _message.config = config;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new DecryptorInitializeAudioDecoderResponseParamsForwardToCallback(callback));
    }

    @Override
    public void initializeVideoDecoder(
        VideoDecoderConfig config, InitializeVideoDecoder_Response callback) {
      DecryptorInitializeVideoDecoderParams _message = new DecryptorInitializeVideoDecoderParams();
      _message.config = config;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new DecryptorInitializeVideoDecoderResponseParamsForwardToCallback(callback));
    }

    @Override
    public void decryptAndDecodeAudio(
        DecoderBuffer encrypted, DecryptAndDecodeAudio_Response callback) {
      DecryptorDecryptAndDecodeAudioParams _message = new DecryptorDecryptAndDecodeAudioParams();
      _message.encrypted = encrypted;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new DecryptorDecryptAndDecodeAudioResponseParamsForwardToCallback(callback));
    }

    @Override
    public void decryptAndDecodeVideo(
        DecoderBuffer encrypted, DecryptAndDecodeVideo_Response callback) {
      DecryptorDecryptAndDecodeVideoParams _message = new DecryptorDecryptAndDecodeVideoParams();
      _message.encrypted = encrypted;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new DecryptorDecryptAndDecodeVideoResponseParamsForwardToCallback(callback));
    }

    @Override
    public void resetDecoder(int streamType) {
      DecryptorResetDecoderParams _message = new DecryptorResetDecoderParams();
      _message.streamType = streamType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void deinitializeDecoder(int streamType) {
      DecryptorDeinitializeDecoderParams _message = new DecryptorDeinitializeDecoderParams();
      _message.streamType = streamType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<Decryptor> {
    Stub(Core core, Decryptor impl) {
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
                Decryptor_Internal.MANAGER, messageWithHeader);
          case 0:
            DecryptorInitializeParams data =
                DecryptorInitializeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .initialize(data.audioPipe, data.videoPipe, data.decryptPipe, data.decryptedPipe);
            return true;
          case 2:
            getImpl()
                .cancelDecrypt(
                    DecryptorCancelDecryptParams.deserialize(messageWithHeader.getPayload())
                        .streamType);
            return true;
          case 7:
            getImpl()
                .resetDecoder(
                    DecryptorResetDecoderParams.deserialize(messageWithHeader.getPayload())
                        .streamType);
            return true;
          case 8:
            getImpl()
                .deinitializeDecoder(
                    DecryptorDeinitializeDecoderParams.deserialize(messageWithHeader.getPayload())
                        .streamType);
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
                getCore(), Decryptor_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 2:
          default:
            return false;
          case 1:
            DecryptorDecryptParams data =
                DecryptorDecryptParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .decrypt(
                    data.streamType,
                    data.encrypted,
                    new DecryptorDecryptResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            getImpl()
                .initializeAudioDecoder(
                    DecryptorInitializeAudioDecoderParams.deserialize(
                            messageWithHeader.getPayload())
                        .config,
                    new DecryptorInitializeAudioDecoderResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            getImpl()
                .initializeVideoDecoder(
                    DecryptorInitializeVideoDecoderParams.deserialize(
                            messageWithHeader.getPayload())
                        .config,
                    new DecryptorInitializeVideoDecoderResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            getImpl()
                .decryptAndDecodeAudio(
                    DecryptorDecryptAndDecodeAudioParams.deserialize(messageWithHeader.getPayload())
                        .encrypted,
                    new DecryptorDecryptAndDecodeAudioResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            getImpl()
                .decryptAndDecodeVideo(
                    DecryptorDecryptAndDecodeVideoParams.deserialize(messageWithHeader.getPayload())
                        .encrypted,
                    new DecryptorDecryptAndDecodeVideoResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class DecryptorInitializeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ConsumerHandle audioPipe;
    public DataPipe.ConsumerHandle decryptPipe;
    public DataPipe.ProducerHandle decryptedPipe;
    public DataPipe.ConsumerHandle videoPipe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorInitializeParams(int version) {
      super(24, version);
      this.audioPipe = InvalidHandle.INSTANCE;
      this.videoPipe = InvalidHandle.INSTANCE;
      this.decryptPipe = InvalidHandle.INSTANCE;
      this.decryptedPipe = InvalidHandle.INSTANCE;
    }

    public DecryptorInitializeParams() {
      this(0);
    }

    public static DecryptorInitializeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorInitializeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorInitializeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorInitializeParams result = new DecryptorInitializeParams(elementsOrVersion);
        result.audioPipe = decoder0.readConsumerHandle(8, false);
        result.videoPipe = decoder0.readConsumerHandle(12, false);
        result.decryptPipe = decoder0.readConsumerHandle(16, false);
        result.decryptedPipe = decoder0.readProducerHandle(20, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Handle) this.audioPipe, 8, false);
      encoder0.encode((Handle) this.videoPipe, 12, false);
      encoder0.encode((Handle) this.decryptPipe, 16, false);
      encoder0.encode((Handle) this.decryptedPipe, 20, false);
    }
  }

  static final class DecryptorDecryptParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderBuffer encrypted;
    public int streamType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorDecryptParams(int version) {
      super(24, version);
    }

    public DecryptorDecryptParams() {
      this(0);
    }

    public static DecryptorDecryptParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorDecryptParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorDecryptParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorDecryptParams result = new DecryptorDecryptParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.streamType = readInt;
        Decryptor.StreamType.validate(readInt);
        result.streamType = Decryptor.StreamType.toKnownValue(result.streamType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.encrypted = DecoderBuffer.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamType, 8);
      encoder0.encode((Struct) this.encrypted, 16, false);
    }
  }

  static final class DecryptorDecryptResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderBuffer buffer;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorDecryptResponseParams(int version) {
      super(24, version);
    }

    public DecryptorDecryptResponseParams() {
      this(0);
    }

    public static DecryptorDecryptResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorDecryptResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorDecryptResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorDecryptResponseParams result =
            new DecryptorDecryptResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        Decryptor.Status.validate(readInt);
        result.status = Decryptor.Status.toKnownValue(result.status);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.buffer = DecoderBuffer.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode((Struct) this.buffer, 16, true);
    }
  }

  static class DecryptorDecryptResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Decryptor.Decrypt_Response mCallback;

    DecryptorDecryptResponseParamsForwardToCallback(Decryptor.Decrypt_Response callback) {
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
        DecryptorDecryptResponseParams response =
            DecryptorDecryptResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.buffer);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DecryptorDecryptResponseParamsProxyToResponder
      implements Decryptor.Decrypt_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DecryptorDecryptResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, DecoderBuffer buffer) {
      DecryptorDecryptResponseParams _response = new DecryptorDecryptResponseParams();
      _response.status = status;
      _response.buffer = buffer;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DecryptorCancelDecryptParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int streamType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorCancelDecryptParams(int version) {
      super(16, version);
    }

    public DecryptorCancelDecryptParams() {
      this(0);
    }

    public static DecryptorCancelDecryptParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorCancelDecryptParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorCancelDecryptParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorCancelDecryptParams result = new DecryptorCancelDecryptParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.streamType = readInt;
        Decryptor.StreamType.validate(readInt);
        result.streamType = Decryptor.StreamType.toKnownValue(result.streamType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamType, 8);
    }
  }

  static final class DecryptorInitializeAudioDecoderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioDecoderConfig config;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorInitializeAudioDecoderParams(int version) {
      super(16, version);
    }

    public DecryptorInitializeAudioDecoderParams() {
      this(0);
    }

    public static DecryptorInitializeAudioDecoderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorInitializeAudioDecoderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorInitializeAudioDecoderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorInitializeAudioDecoderParams result =
            new DecryptorInitializeAudioDecoderParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = AudioDecoderConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.config, 8, false);
    }
  }

  static final class DecryptorInitializeAudioDecoderResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorInitializeAudioDecoderResponseParams(int version) {
      super(16, version);
    }

    public DecryptorInitializeAudioDecoderResponseParams() {
      this(0);
    }

    public static DecryptorInitializeAudioDecoderResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorInitializeAudioDecoderResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorInitializeAudioDecoderResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorInitializeAudioDecoderResponseParams result =
            new DecryptorInitializeAudioDecoderResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class DecryptorInitializeAudioDecoderResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Decryptor.InitializeAudioDecoder_Response mCallback;

    DecryptorInitializeAudioDecoderResponseParamsForwardToCallback(
        Decryptor.InitializeAudioDecoder_Response callback) {
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
        DecryptorInitializeAudioDecoderResponseParams response =
            DecryptorInitializeAudioDecoderResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DecryptorInitializeAudioDecoderResponseParamsProxyToResponder
      implements Decryptor.InitializeAudioDecoder_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DecryptorInitializeAudioDecoderResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      DecryptorInitializeAudioDecoderResponseParams _response =
          new DecryptorInitializeAudioDecoderResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DecryptorInitializeVideoDecoderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public VideoDecoderConfig config;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorInitializeVideoDecoderParams(int version) {
      super(16, version);
    }

    public DecryptorInitializeVideoDecoderParams() {
      this(0);
    }

    public static DecryptorInitializeVideoDecoderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorInitializeVideoDecoderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorInitializeVideoDecoderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorInitializeVideoDecoderParams result =
            new DecryptorInitializeVideoDecoderParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = VideoDecoderConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.config, 8, false);
    }
  }

  static final class DecryptorInitializeVideoDecoderResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorInitializeVideoDecoderResponseParams(int version) {
      super(16, version);
    }

    public DecryptorInitializeVideoDecoderResponseParams() {
      this(0);
    }

    public static DecryptorInitializeVideoDecoderResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorInitializeVideoDecoderResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorInitializeVideoDecoderResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorInitializeVideoDecoderResponseParams result =
            new DecryptorInitializeVideoDecoderResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class DecryptorInitializeVideoDecoderResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Decryptor.InitializeVideoDecoder_Response mCallback;

    DecryptorInitializeVideoDecoderResponseParamsForwardToCallback(
        Decryptor.InitializeVideoDecoder_Response callback) {
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
        DecryptorInitializeVideoDecoderResponseParams response =
            DecryptorInitializeVideoDecoderResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DecryptorInitializeVideoDecoderResponseParamsProxyToResponder
      implements Decryptor.InitializeVideoDecoder_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DecryptorInitializeVideoDecoderResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      DecryptorInitializeVideoDecoderResponseParams _response =
          new DecryptorInitializeVideoDecoderResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DecryptorDecryptAndDecodeAudioParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderBuffer encrypted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorDecryptAndDecodeAudioParams(int version) {
      super(16, version);
    }

    public DecryptorDecryptAndDecodeAudioParams() {
      this(0);
    }

    public static DecryptorDecryptAndDecodeAudioParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorDecryptAndDecodeAudioParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorDecryptAndDecodeAudioParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorDecryptAndDecodeAudioParams result =
            new DecryptorDecryptAndDecodeAudioParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.encrypted = DecoderBuffer.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.encrypted, 8, false);
    }
  }

  static final class DecryptorDecryptAndDecodeAudioResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioBuffer[] audioBuffers;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorDecryptAndDecodeAudioResponseParams(int version) {
      super(24, version);
    }

    public DecryptorDecryptAndDecodeAudioResponseParams() {
      this(0);
    }

    public static DecryptorDecryptAndDecodeAudioResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorDecryptAndDecodeAudioResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorDecryptAndDecodeAudioResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorDecryptAndDecodeAudioResponseParams result =
            new DecryptorDecryptAndDecodeAudioResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        Decryptor.Status.validate(readInt);
        result.status = Decryptor.Status.toKnownValue(result.status);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.audioBuffers = new AudioBuffer[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.audioBuffers[i1] = AudioBuffer.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      AudioBuffer[] audioBufferArr = this.audioBuffers;
      if (audioBufferArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(audioBufferArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        AudioBuffer[] audioBufferArr2 = this.audioBuffers;
        if (i0 < audioBufferArr2.length) {
          encoder1.encode((Struct) audioBufferArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class DecryptorDecryptAndDecodeAudioResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Decryptor.DecryptAndDecodeAudio_Response mCallback;

    DecryptorDecryptAndDecodeAudioResponseParamsForwardToCallback(
        Decryptor.DecryptAndDecodeAudio_Response callback) {
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
        DecryptorDecryptAndDecodeAudioResponseParams response =
            DecryptorDecryptAndDecodeAudioResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.audioBuffers);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DecryptorDecryptAndDecodeAudioResponseParamsProxyToResponder
      implements Decryptor.DecryptAndDecodeAudio_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DecryptorDecryptAndDecodeAudioResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, AudioBuffer[] audioBuffers) {
      DecryptorDecryptAndDecodeAudioResponseParams _response =
          new DecryptorDecryptAndDecodeAudioResponseParams();
      _response.status = status;
      _response.audioBuffers = audioBuffers;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DecryptorDecryptAndDecodeVideoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderBuffer encrypted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorDecryptAndDecodeVideoParams(int version) {
      super(16, version);
    }

    public DecryptorDecryptAndDecodeVideoParams() {
      this(0);
    }

    public static DecryptorDecryptAndDecodeVideoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorDecryptAndDecodeVideoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorDecryptAndDecodeVideoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorDecryptAndDecodeVideoParams result =
            new DecryptorDecryptAndDecodeVideoParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.encrypted = DecoderBuffer.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.encrypted, 8, false);
    }
  }

  static final class DecryptorDecryptAndDecodeVideoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public FrameResourceReleaser releaser;
    public int status;
    public VideoFrame videoFrame;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorDecryptAndDecodeVideoResponseParams(int version) {
      super(32, version);
    }

    public DecryptorDecryptAndDecodeVideoResponseParams() {
      this(0);
    }

    public static DecryptorDecryptAndDecodeVideoResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorDecryptAndDecodeVideoResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorDecryptAndDecodeVideoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorDecryptAndDecodeVideoResponseParams result =
            new DecryptorDecryptAndDecodeVideoResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        Decryptor.Status.validate(readInt);
        result.status = Decryptor.Status.toKnownValue(result.status);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.videoFrame = VideoFrame.decode(decoder1);
        result.releaser =
            (FrameResourceReleaser)
                decoder0.readServiceInterface(24, true, FrameResourceReleaser.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode((Struct) this.videoFrame, 16, true);
      encoder0.encode(this.releaser, 24, true, FrameResourceReleaser.MANAGER);
    }
  }

  static class DecryptorDecryptAndDecodeVideoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Decryptor.DecryptAndDecodeVideo_Response mCallback;

    DecryptorDecryptAndDecodeVideoResponseParamsForwardToCallback(
        Decryptor.DecryptAndDecodeVideo_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        DecryptorDecryptAndDecodeVideoResponseParams response =
            DecryptorDecryptAndDecodeVideoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.videoFrame, response.releaser);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DecryptorDecryptAndDecodeVideoResponseParamsProxyToResponder
      implements Decryptor.DecryptAndDecodeVideo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DecryptorDecryptAndDecodeVideoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, VideoFrame videoFrame, FrameResourceReleaser releaser) {
      DecryptorDecryptAndDecodeVideoResponseParams _response =
          new DecryptorDecryptAndDecodeVideoResponseParams();
      _response.status = status;
      _response.videoFrame = videoFrame;
      _response.releaser = releaser;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DecryptorResetDecoderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int streamType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorResetDecoderParams(int version) {
      super(16, version);
    }

    public DecryptorResetDecoderParams() {
      this(0);
    }

    public static DecryptorResetDecoderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorResetDecoderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorResetDecoderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorResetDecoderParams result = new DecryptorResetDecoderParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.streamType = readInt;
        Decryptor.StreamType.validate(readInt);
        result.streamType = Decryptor.StreamType.toKnownValue(result.streamType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamType, 8);
    }
  }

  static final class DecryptorDeinitializeDecoderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int streamType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DecryptorDeinitializeDecoderParams(int version) {
      super(16, version);
    }

    public DecryptorDeinitializeDecoderParams() {
      this(0);
    }

    public static DecryptorDeinitializeDecoderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DecryptorDeinitializeDecoderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptorDeinitializeDecoderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DecryptorDeinitializeDecoderParams result =
            new DecryptorDeinitializeDecoderParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.streamType = readInt;
        Decryptor.StreamType.validate(readInt);
        result.streamType = Decryptor.StreamType.toKnownValue(result.streamType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamType, 8);
    }
  }
}
