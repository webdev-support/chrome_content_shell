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

class AudioInputStreamObserver_Internal {
  private static final int DID_START_RECORDING_ORDINAL = 0;
  public static final Interface.Manager<AudioInputStreamObserver, AudioInputStreamObserver.Proxy>
      MANAGER =
          new Interface.Manager<AudioInputStreamObserver, AudioInputStreamObserver.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.AudioInputStreamObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AudioInputStreamObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AudioInputStreamObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public AudioInputStreamObserver[] buildArray(int size) {
              return new AudioInputStreamObserver[size];
            }
          };

  AudioInputStreamObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioInputStreamObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void didStartRecording() {
      AudioInputStreamObserverDidStartRecordingParams _message =
          new AudioInputStreamObserverDidStartRecordingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioInputStreamObserver> {
    Stub(Core core, AudioInputStreamObserver impl) {
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
                AudioInputStreamObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioInputStreamObserverDidStartRecordingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didStartRecording();
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
                getCore(), AudioInputStreamObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioInputStreamObserverDidStartRecordingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioInputStreamObserverDidStartRecordingParams(int version) {
      super(8, version);
    }

    public AudioInputStreamObserverDidStartRecordingParams() {
      this(0);
    }

    public static AudioInputStreamObserverDidStartRecordingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioInputStreamObserverDidStartRecordingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioInputStreamObserverDidStartRecordingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioInputStreamObserverDidStartRecordingParams result =
            new AudioInputStreamObserverDidStartRecordingParams(elementsOrVersion);
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
