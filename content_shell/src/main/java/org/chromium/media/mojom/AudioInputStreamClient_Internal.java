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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class AudioInputStreamClient_Internal {
  public static final Interface.Manager<AudioInputStreamClient, AudioInputStreamClient.Proxy>
      MANAGER =
          new Interface.Manager<AudioInputStreamClient, AudioInputStreamClient.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.AudioInputStreamClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AudioInputStreamClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AudioInputStreamClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public AudioInputStreamClient[] buildArray(int size) {
              return new AudioInputStreamClient[size];
            }
          };
  private static final int ON_ERROR_ORDINAL = 0;
  private static final int ON_MUTED_STATE_CHANGED_ORDINAL = 1;

  AudioInputStreamClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioInputStreamClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onError(int code) {
      AudioInputStreamClientOnErrorParams _message = new AudioInputStreamClientOnErrorParams();
      _message.code = code;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onMutedStateChanged(boolean isMuted) {
      AudioInputStreamClientOnMutedStateChangedParams _message =
          new AudioInputStreamClientOnMutedStateChangedParams();
      _message.isMuted = isMuted;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioInputStreamClient> {
    Stub(Core core, AudioInputStreamClient impl) {
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
                AudioInputStreamClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioInputStreamClientOnErrorParams data =
                AudioInputStreamClientOnErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onError(data.code);
            return true;
          case 1:
            AudioInputStreamClientOnMutedStateChangedParams data2 =
                AudioInputStreamClientOnMutedStateChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onMutedStateChanged(data2.isMuted);
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
                getCore(), AudioInputStreamClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioInputStreamClientOnErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int code;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioInputStreamClientOnErrorParams(int version) {
      super(16, version);
    }

    public AudioInputStreamClientOnErrorParams() {
      this(0);
    }

    public static AudioInputStreamClientOnErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioInputStreamClientOnErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioInputStreamClientOnErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioInputStreamClientOnErrorParams result =
            new AudioInputStreamClientOnErrorParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.code = readInt;
        InputStreamErrorCode.validate(readInt);
        result.code = InputStreamErrorCode.toKnownValue(result.code);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.code, 8);
    }
  }

  static final class AudioInputStreamClientOnMutedStateChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isMuted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioInputStreamClientOnMutedStateChangedParams(int version) {
      super(16, version);
    }

    public AudioInputStreamClientOnMutedStateChangedParams() {
      this(0);
    }

    public static AudioInputStreamClientOnMutedStateChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioInputStreamClientOnMutedStateChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioInputStreamClientOnMutedStateChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioInputStreamClientOnMutedStateChangedParams result =
            new AudioInputStreamClientOnMutedStateChangedParams(elementsOrVersion);
        result.isMuted = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isMuted, 8, 0);
    }
  }
}
