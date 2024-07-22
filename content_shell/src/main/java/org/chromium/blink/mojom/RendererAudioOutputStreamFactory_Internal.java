package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.AudioOutputStreamProvider;
import org.chromium.media.mojom.AudioParameters;
import org.chromium.media.mojom.OutputDeviceStatus;
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
import org.chromium.mojo_base.mojom.UnguessableToken;

class RendererAudioOutputStreamFactory_Internal {
  public static final Interface.Manager<
          RendererAudioOutputStreamFactory, RendererAudioOutputStreamFactory.Proxy>
      MANAGER =
          new Interface.Manager<
              RendererAudioOutputStreamFactory, RendererAudioOutputStreamFactory.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.RendererAudioOutputStreamFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public RendererAudioOutputStreamFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, RendererAudioOutputStreamFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public RendererAudioOutputStreamFactory[] buildArray(int size) {
              return new RendererAudioOutputStreamFactory[size];
            }
          };
  private static final int REQUEST_DEVICE_AUTHORIZATION_ORDINAL = 0;

  RendererAudioOutputStreamFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RendererAudioOutputStreamFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestDeviceAuthorization(
        InterfaceRequest<AudioOutputStreamProvider> streamProviderReceiver,
        UnguessableToken sessionId,
        String deviceId,
        RequestDeviceAuthorization_Response callback) {
      RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams _message =
          new RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams();
      _message.streamProviderReceiver = streamProviderReceiver;
      _message.sessionId = sessionId;
      _message.deviceId = deviceId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<RendererAudioOutputStreamFactory> {
    Stub(Core core, RendererAudioOutputStreamFactory impl) {
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
                RendererAudioOutputStreamFactory_Internal.MANAGER, messageWithHeader);
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
                getCore(),
                RendererAudioOutputStreamFactory_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams data =
                RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestDeviceAuthorization(
                    data.streamProviderReceiver,
                    data.sessionId,
                    data.deviceId,
                    new RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParamsProxyToResponder(
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

  static final class RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String deviceId;
    public UnguessableToken sessionId;
    public InterfaceRequest<AudioOutputStreamProvider> streamProviderReceiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams(int version) {
      super(32, version);
    }

    public RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams() {
      this(0);
    }

    public static RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams result =
            new RendererAudioOutputStreamFactoryRequestDeviceAuthorizationParams(elementsOrVersion);
        result.streamProviderReceiver = decoder0.readInterfaceRequest(8, false);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.sessionId = UnguessableToken.decode(decoder1);
        result.deviceId = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.streamProviderReceiver, 8, false);
      encoder0.encode((Struct) this.sessionId, 16, true);
      encoder0.encode(this.deviceId, 24, false);
    }
  }

  static final class RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String matchedDeviceId;
    public AudioParameters outputParams;
    public int state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams(int version) {
      super(32, version);
    }

    public RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams() {
      this(0);
    }

    public static RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams result =
            new RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams(
                elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.state = readInt;
        OutputDeviceStatus.validate(readInt);
        result.state = OutputDeviceStatus.toKnownValue(result.state);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.outputParams = AudioParameters.decode(decoder1);
        result.matchedDeviceId = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.state, 8);
      encoder0.encode((Struct) this.outputParams, 16, false);
      encoder0.encode(this.matchedDeviceId, 24, false);
    }
  }

  static
  class RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final RendererAudioOutputStreamFactory.RequestDeviceAuthorization_Response mCallback;

    RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParamsForwardToCallback(
        RendererAudioOutputStreamFactory.RequestDeviceAuthorization_Response callback) {
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
        RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams response =
            RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.state, response.outputParams, response.matchedDeviceId);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParamsProxyToResponder
      implements RendererAudioOutputStreamFactory.RequestDeviceAuthorization_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int state, AudioParameters outputParams, String matchedDeviceId) {
      RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams _response =
          new RendererAudioOutputStreamFactoryRequestDeviceAuthorizationResponseParams();
      _response.state = state;
      _response.outputParams = outputParams;
      _response.matchedDeviceId = matchedDeviceId;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
