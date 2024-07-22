package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class MediaFoundationRendererNotifier_Internal {
  public static final Interface.Manager<
          MediaFoundationRendererNotifier, MediaFoundationRendererNotifier.Proxy>
      MANAGER =
          new Interface.Manager<
              MediaFoundationRendererNotifier, MediaFoundationRendererNotifier.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.MediaFoundationRendererNotifier";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public MediaFoundationRendererNotifier.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, MediaFoundationRendererNotifier impl) {
              return new Stub(core, impl);
            }

            @Override
            public MediaFoundationRendererNotifier[] buildArray(int size) {
              return new MediaFoundationRendererNotifier[size];
            }
          };
  private static final int MEDIA_FOUNDATION_RENDERER_CREATED_ORDINAL = 0;

  MediaFoundationRendererNotifier_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaFoundationRendererNotifier.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void mediaFoundationRendererCreated(
        InterfaceRequest<MediaFoundationRendererObserver> observer) {
      MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams _message =
          new MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams();
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaFoundationRendererNotifier> {
    Stub(Core core, MediaFoundationRendererNotifier impl) {
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
                MediaFoundationRendererNotifier_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams data =
                MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaFoundationRendererCreated(data.observer);
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
                getCore(),
                MediaFoundationRendererNotifier_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<MediaFoundationRendererObserver> observer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams(int version) {
      super(16, version);
    }

    public MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams() {
      this(0);
    }

    public static MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams result =
            new MediaFoundationRendererNotifierMediaFoundationRendererCreatedParams(
                elementsOrVersion);
        result.observer = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.observer, 8, false);
    }
  }
}
