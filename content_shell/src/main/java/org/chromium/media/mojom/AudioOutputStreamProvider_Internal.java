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

class AudioOutputStreamProvider_Internal {
  private static final int ACQUIRE_ORDINAL = 0;
  public static final Interface.Manager<AudioOutputStreamProvider, AudioOutputStreamProvider.Proxy>
      MANAGER =
          new Interface.Manager<AudioOutputStreamProvider, AudioOutputStreamProvider.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.AudioOutputStreamProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AudioOutputStreamProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AudioOutputStreamProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public AudioOutputStreamProvider[] buildArray(int size) {
              return new AudioOutputStreamProvider[size];
            }
          };

  AudioOutputStreamProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioOutputStreamProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void acquire(AudioParameters params, AudioOutputStreamProviderClient client) {
      AudioOutputStreamProviderAcquireParams _message =
          new AudioOutputStreamProviderAcquireParams();
      _message.params = params;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioOutputStreamProvider> {
    Stub(Core core, AudioOutputStreamProvider impl) {
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
                AudioOutputStreamProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioOutputStreamProviderAcquireParams data =
                AudioOutputStreamProviderAcquireParams.deserialize(messageWithHeader.getPayload());
            getImpl().acquire(data.params, data.client);
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
                getCore(), AudioOutputStreamProvider_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioOutputStreamProviderAcquireParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioOutputStreamProviderClient client;
    public AudioParameters params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioOutputStreamProviderAcquireParams(int version) {
      super(24, version);
    }

    public AudioOutputStreamProviderAcquireParams() {
      this(0);
    }

    public static AudioOutputStreamProviderAcquireParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioOutputStreamProviderAcquireParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioOutputStreamProviderAcquireParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioOutputStreamProviderAcquireParams result =
            new AudioOutputStreamProviderAcquireParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = AudioParameters.decode(decoder1);
        result.client =
            (AudioOutputStreamProviderClient)
                decoder0.readServiceInterface(16, false, AudioOutputStreamProviderClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
      encoder0.encode(this.client, 16, false, AudioOutputStreamProviderClient.MANAGER);
    }
  }
}
