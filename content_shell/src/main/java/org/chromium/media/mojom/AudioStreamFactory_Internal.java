package org.chromium.media.mojom;

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
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;
import org.chromium.mojo_base.mojom.UnguessableToken;

class AudioStreamFactory_Internal {
  private static final int ASSOCIATE_INPUT_AND_OUTPUT_FOR_AEC_ORDINAL = 1;
  private static final int BIND_MUTER_ORDINAL = 3;
  private static final int CREATE_INPUT_STREAM_ORDINAL = 0;
  private static final int CREATE_LOOPBACK_STREAM_ORDINAL = 4;
  private static final int CREATE_OUTPUT_STREAM_ORDINAL = 2;
  public static final Interface.Manager<AudioStreamFactory, AudioStreamFactory.Proxy> MANAGER =
      new Interface.Manager<AudioStreamFactory, AudioStreamFactory.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.AudioStreamFactory";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AudioStreamFactory.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AudioStreamFactory impl) {
          return new Stub(core, impl);
        }

        @Override
        public AudioStreamFactory[] buildArray(int size) {
          return new AudioStreamFactory[size];
        }
      };

  AudioStreamFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioStreamFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createInputStream(
        InterfaceRequest<AudioInputStream> stream,
        AudioInputStreamClient client,
        AudioInputStreamObserver observer,
        AudioLog log,
        String deviceId,
        AudioParameters params,
        int sharedMemoryCount,
        boolean enableAgc,
        ReadOnlySharedMemoryRegion keyPressCountBuffer,
        AudioProcessingConfig processingConfig,
        CreateInputStream_Response callback) {
      AudioStreamFactoryCreateInputStreamParams _message =
          new AudioStreamFactoryCreateInputStreamParams();
      _message.stream = stream;
      _message.client = client;
      _message.observer = observer;
      _message.log = log;
      _message.deviceId = deviceId;
      _message.params = params;
      _message.sharedMemoryCount = sharedMemoryCount;
      _message.enableAgc = enableAgc;
      _message.keyPressCountBuffer = keyPressCountBuffer;
      _message.processingConfig = processingConfig;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new AudioStreamFactoryCreateInputStreamResponseParamsForwardToCallback(callback));
    }

    @Override
    public void associateInputAndOutputForAec(
        UnguessableToken inputStreamId, String outputDeviceId) {
      AudioStreamFactoryAssociateInputAndOutputForAecParams _message =
          new AudioStreamFactoryAssociateInputAndOutputForAecParams();
      _message.inputStreamId = inputStreamId;
      _message.outputDeviceId = outputDeviceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void createOutputStream(
        InterfaceRequest<AudioOutputStream> stream,
        AssociatedInterfaceNotSupported observer,
        AudioLog log,
        String deviceId,
        AudioParameters params,
        UnguessableToken groupId,
        CreateOutputStream_Response callback) {
      AudioStreamFactoryCreateOutputStreamParams _message =
          new AudioStreamFactoryCreateOutputStreamParams();
      _message.stream = stream;
      _message.observer = observer;
      _message.log = log;
      _message.deviceId = deviceId;
      _message.params = params;
      _message.groupId = groupId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new AudioStreamFactoryCreateOutputStreamResponseParamsForwardToCallback(callback));
    }

    @Override
    public void bindMuter(
        AssociatedInterfaceRequestNotSupported receiver, UnguessableToken groupId) {
      AudioStreamFactoryBindMuterParams _message = new AudioStreamFactoryBindMuterParams();
      _message.receiver = receiver;
      _message.groupId = groupId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void createLoopbackStream(
        InterfaceRequest<AudioInputStream> receiver,
        AudioInputStreamClient client,
        AudioInputStreamObserver observer,
        AudioParameters params,
        int sharedMemoryCount,
        UnguessableToken groupId,
        CreateLoopbackStream_Response callback) {
      AudioStreamFactoryCreateLoopbackStreamParams _message =
          new AudioStreamFactoryCreateLoopbackStreamParams();
      _message.receiver = receiver;
      _message.client = client;
      _message.observer = observer;
      _message.params = params;
      _message.sharedMemoryCount = sharedMemoryCount;
      _message.groupId = groupId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new AudioStreamFactoryCreateLoopbackStreamResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<AudioStreamFactory> {
    Stub(Core core, AudioStreamFactory impl) {
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
                AudioStreamFactory_Internal.MANAGER, messageWithHeader);
          case 1:
            AudioStreamFactoryAssociateInputAndOutputForAecParams data =
                AudioStreamFactoryAssociateInputAndOutputForAecParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().associateInputAndOutputForAec(data.inputStreamId, data.outputDeviceId);
            return true;
          case 3:
            AudioStreamFactoryBindMuterParams data2 =
                AudioStreamFactoryBindMuterParams.deserialize(messageWithHeader.getPayload());
            getImpl().bindMuter(data2.receiver, data2.groupId);
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
                getCore(), AudioStreamFactory_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            AudioStreamFactoryCreateInputStreamParams data =
                AudioStreamFactoryCreateInputStreamParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createInputStream(
                    data.stream,
                    data.client,
                    data.observer,
                    data.log,
                    data.deviceId,
                    data.params,
                    data.sharedMemoryCount,
                    data.enableAgc,
                    data.keyPressCountBuffer,
                    data.processingConfig,
                    new AudioStreamFactoryCreateInputStreamResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          case 3:
          default:
            return false;
          case 2:
            AudioStreamFactoryCreateOutputStreamParams data2 =
                AudioStreamFactoryCreateOutputStreamParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createOutputStream(
                    data2.stream,
                    data2.observer,
                    data2.log,
                    data2.deviceId,
                    data2.params,
                    data2.groupId,
                    new AudioStreamFactoryCreateOutputStreamResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            AudioStreamFactoryCreateLoopbackStreamParams data3 =
                AudioStreamFactoryCreateLoopbackStreamParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createLoopbackStream(
                    data3.receiver,
                    data3.client,
                    data3.observer,
                    data3.params,
                    data3.sharedMemoryCount,
                    data3.groupId,
                    new AudioStreamFactoryCreateLoopbackStreamResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioStreamFactoryCreateInputStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 80;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioInputStreamClient client;
    public String deviceId;
    public boolean enableAgc;
    public ReadOnlySharedMemoryRegion keyPressCountBuffer;
    public AudioLog log;
    public AudioInputStreamObserver observer;
    public AudioParameters params;
    public AudioProcessingConfig processingConfig;
    public int sharedMemoryCount;
    public InterfaceRequest<AudioInputStream> stream;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioStreamFactoryCreateInputStreamParams(int version) {
      super(80, version);
    }

    public AudioStreamFactoryCreateInputStreamParams() {
      this(0);
    }

    public static AudioStreamFactoryCreateInputStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioStreamFactoryCreateInputStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioStreamFactoryCreateInputStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioStreamFactoryCreateInputStreamParams result =
            new AudioStreamFactoryCreateInputStreamParams(elementsOrVersion);
        result.stream = decoder0.readInterfaceRequest(8, false);
        result.client =
            (AudioInputStreamClient)
                decoder0.readServiceInterface(12, false, AudioInputStreamClient.MANAGER);
        result.observer =
            (AudioInputStreamObserver)
                decoder0.readServiceInterface(20, true, AudioInputStreamObserver.MANAGER);
        result.log = (AudioLog) decoder0.readServiceInterface(28, true, AudioLog.MANAGER);
        result.sharedMemoryCount = decoder0.readInt(36);
        result.deviceId = decoder0.readString(40, false);
        Decoder decoder1 = decoder0.readPointer(48, false);
        result.params = AudioParameters.decode(decoder1);
        result.enableAgc = decoder0.readBoolean(56, 0);
        Decoder decoder12 = decoder0.readPointer(64, true);
        result.keyPressCountBuffer = ReadOnlySharedMemoryRegion.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(72, true);
        result.processingConfig = AudioProcessingConfig.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.stream, 8, false);
      encoder0.encode(this.client, 12, false, AudioInputStreamClient.MANAGER);
      encoder0.encode(this.observer, 20, true, AudioInputStreamObserver.MANAGER);
      encoder0.encode(this.log, 28, true, AudioLog.MANAGER);
      encoder0.encode(this.sharedMemoryCount, 36);
      encoder0.encode(this.deviceId, 40, false);
      encoder0.encode((Struct) this.params, 48, false);
      encoder0.encode(this.enableAgc, 56, 0);
      encoder0.encode((Struct) this.keyPressCountBuffer, 64, true);
      encoder0.encode((Struct) this.processingConfig, 72, true);
    }
  }

  static final class AudioStreamFactoryCreateInputStreamResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyAudioDataPipe dataPipe;
    public boolean initiallyMuted;
    public UnguessableToken streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioStreamFactoryCreateInputStreamResponseParams(int version) {
      super(32, version);
    }

    public AudioStreamFactoryCreateInputStreamResponseParams() {
      this(0);
    }

    public static AudioStreamFactoryCreateInputStreamResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioStreamFactoryCreateInputStreamResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioStreamFactoryCreateInputStreamResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioStreamFactoryCreateInputStreamResponseParams result =
            new AudioStreamFactoryCreateInputStreamResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.dataPipe = ReadOnlyAudioDataPipe.decode(decoder1);
        result.initiallyMuted = decoder0.readBoolean(16, 0);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.streamId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.dataPipe, 8, true);
      encoder0.encode(this.initiallyMuted, 16, 0);
      encoder0.encode((Struct) this.streamId, 24, true);
    }
  }

  static class AudioStreamFactoryCreateInputStreamResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioStreamFactory.CreateInputStream_Response mCallback;

    AudioStreamFactoryCreateInputStreamResponseParamsForwardToCallback(
        AudioStreamFactory.CreateInputStream_Response callback) {
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
        AudioStreamFactoryCreateInputStreamResponseParams response =
            AudioStreamFactoryCreateInputStreamResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.dataPipe, response.initiallyMuted, response.streamId);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioStreamFactoryCreateInputStreamResponseParamsProxyToResponder
      implements AudioStreamFactory.CreateInputStream_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioStreamFactoryCreateInputStreamResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        ReadOnlyAudioDataPipe dataPipe, boolean initiallyMuted, UnguessableToken streamId) {
      AudioStreamFactoryCreateInputStreamResponseParams _response =
          new AudioStreamFactoryCreateInputStreamResponseParams();
      _response.dataPipe = dataPipe;
      _response.initiallyMuted = initiallyMuted;
      _response.streamId = streamId;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioStreamFactoryAssociateInputAndOutputForAecParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken inputStreamId;
    public String outputDeviceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioStreamFactoryAssociateInputAndOutputForAecParams(int version) {
      super(24, version);
    }

    public AudioStreamFactoryAssociateInputAndOutputForAecParams() {
      this(0);
    }

    public static AudioStreamFactoryAssociateInputAndOutputForAecParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioStreamFactoryAssociateInputAndOutputForAecParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioStreamFactoryAssociateInputAndOutputForAecParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioStreamFactoryAssociateInputAndOutputForAecParams result =
            new AudioStreamFactoryAssociateInputAndOutputForAecParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.inputStreamId = UnguessableToken.decode(decoder1);
        result.outputDeviceId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.inputStreamId, 8, false);
      encoder0.encode(this.outputDeviceId, 16, false);
    }
  }

  static final class AudioStreamFactoryCreateOutputStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public String deviceId;
    public UnguessableToken groupId;
    public AudioLog log;
    public AssociatedInterfaceNotSupported observer;
    public AudioParameters params;
    public InterfaceRequest<AudioOutputStream> stream;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioStreamFactoryCreateOutputStreamParams(int version) {
      super(56, version);
    }

    public AudioStreamFactoryCreateOutputStreamParams() {
      this(0);
    }

    public static AudioStreamFactoryCreateOutputStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioStreamFactoryCreateOutputStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioStreamFactoryCreateOutputStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioStreamFactoryCreateOutputStreamParams result =
            new AudioStreamFactoryCreateOutputStreamParams(elementsOrVersion);
        result.stream = decoder0.readInterfaceRequest(8, false);
        result.observer = decoder0.readAssociatedServiceInterfaceNotSupported(12, true);
        result.log = (AudioLog) decoder0.readServiceInterface(20, true, AudioLog.MANAGER);
        result.deviceId = decoder0.readString(32, false);
        Decoder decoder1 = decoder0.readPointer(40, false);
        result.params = AudioParameters.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(48, false);
        result.groupId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.stream, 8, false);
      encoder0.encode(this.observer, 12, true);
      encoder0.encode(this.log, 20, true, AudioLog.MANAGER);
      encoder0.encode(this.deviceId, 32, false);
      encoder0.encode((Struct) this.params, 40, false);
      encoder0.encode((Struct) this.groupId, 48, false);
    }
  }

  static final class AudioStreamFactoryCreateOutputStreamResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadWriteAudioDataPipe dataPipe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioStreamFactoryCreateOutputStreamResponseParams(int version) {
      super(16, version);
    }

    public AudioStreamFactoryCreateOutputStreamResponseParams() {
      this(0);
    }

    public static AudioStreamFactoryCreateOutputStreamResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioStreamFactoryCreateOutputStreamResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioStreamFactoryCreateOutputStreamResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioStreamFactoryCreateOutputStreamResponseParams result =
            new AudioStreamFactoryCreateOutputStreamResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.dataPipe = ReadWriteAudioDataPipe.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.dataPipe, 8, true);
    }
  }

  static class AudioStreamFactoryCreateOutputStreamResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioStreamFactory.CreateOutputStream_Response mCallback;

    AudioStreamFactoryCreateOutputStreamResponseParamsForwardToCallback(
        AudioStreamFactory.CreateOutputStream_Response callback) {
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
        AudioStreamFactoryCreateOutputStreamResponseParams response =
            AudioStreamFactoryCreateOutputStreamResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.dataPipe);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioStreamFactoryCreateOutputStreamResponseParamsProxyToResponder
      implements AudioStreamFactory.CreateOutputStream_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioStreamFactoryCreateOutputStreamResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ReadWriteAudioDataPipe dataPipe) {
      AudioStreamFactoryCreateOutputStreamResponseParams _response =
          new AudioStreamFactoryCreateOutputStreamResponseParams();
      _response.dataPipe = dataPipe;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioStreamFactoryBindMuterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken groupId;
    public AssociatedInterfaceRequestNotSupported receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioStreamFactoryBindMuterParams(int version) {
      super(24, version);
    }

    public AudioStreamFactoryBindMuterParams() {
      this(0);
    }

    public static AudioStreamFactoryBindMuterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioStreamFactoryBindMuterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioStreamFactoryBindMuterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioStreamFactoryBindMuterParams result =
            new AudioStreamFactoryBindMuterParams(elementsOrVersion);
        result.receiver = decoder0.readAssociatedInterfaceRequestNotSupported(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.groupId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.receiver, 8, false);
      encoder0.encode((Struct) this.groupId, 16, false);
    }
  }

  static final class AudioStreamFactoryCreateLoopbackStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioInputStreamClient client;
    public UnguessableToken groupId;
    public AudioInputStreamObserver observer;
    public AudioParameters params;
    public InterfaceRequest<AudioInputStream> receiver;
    public int sharedMemoryCount;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioStreamFactoryCreateLoopbackStreamParams(int version) {
      super(48, version);
    }

    public AudioStreamFactoryCreateLoopbackStreamParams() {
      this(0);
    }

    public static AudioStreamFactoryCreateLoopbackStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioStreamFactoryCreateLoopbackStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioStreamFactoryCreateLoopbackStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioStreamFactoryCreateLoopbackStreamParams result =
            new AudioStreamFactoryCreateLoopbackStreamParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        result.client =
            (AudioInputStreamClient)
                decoder0.readServiceInterface(12, false, AudioInputStreamClient.MANAGER);
        result.observer =
            (AudioInputStreamObserver)
                decoder0.readServiceInterface(20, false, AudioInputStreamObserver.MANAGER);
        result.sharedMemoryCount = decoder0.readInt(28);
        Decoder decoder1 = decoder0.readPointer(32, false);
        result.params = AudioParameters.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(40, false);
        result.groupId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
      encoder0.encode(this.client, 12, false, AudioInputStreamClient.MANAGER);
      encoder0.encode(this.observer, 20, false, AudioInputStreamObserver.MANAGER);
      encoder0.encode(this.sharedMemoryCount, 28);
      encoder0.encode((Struct) this.params, 32, false);
      encoder0.encode((Struct) this.groupId, 40, false);
    }
  }

  static final class AudioStreamFactoryCreateLoopbackStreamResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyAudioDataPipe dataPipe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioStreamFactoryCreateLoopbackStreamResponseParams(int version) {
      super(16, version);
    }

    public AudioStreamFactoryCreateLoopbackStreamResponseParams() {
      this(0);
    }

    public static AudioStreamFactoryCreateLoopbackStreamResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioStreamFactoryCreateLoopbackStreamResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioStreamFactoryCreateLoopbackStreamResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioStreamFactoryCreateLoopbackStreamResponseParams result =
            new AudioStreamFactoryCreateLoopbackStreamResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.dataPipe = ReadOnlyAudioDataPipe.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.dataPipe, 8, true);
    }
  }

  static class AudioStreamFactoryCreateLoopbackStreamResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioStreamFactory.CreateLoopbackStream_Response mCallback;

    AudioStreamFactoryCreateLoopbackStreamResponseParamsForwardToCallback(
        AudioStreamFactory.CreateLoopbackStream_Response callback) {
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
        AudioStreamFactoryCreateLoopbackStreamResponseParams response =
            AudioStreamFactoryCreateLoopbackStreamResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.dataPipe);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioStreamFactoryCreateLoopbackStreamResponseParamsProxyToResponder
      implements AudioStreamFactory.CreateLoopbackStream_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioStreamFactoryCreateLoopbackStreamResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ReadOnlyAudioDataPipe dataPipe) {
      AudioStreamFactoryCreateLoopbackStreamResponseParams _response =
          new AudioStreamFactoryCreateLoopbackStreamResponseParams();
      _response.dataPipe = dataPipe;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
