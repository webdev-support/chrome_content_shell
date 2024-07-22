package org.chromium.media_session.mojom;

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

class MediaControllerImageObserver_Internal {
  public static final Interface.Manager<
          MediaControllerImageObserver, MediaControllerImageObserver.Proxy>
      MANAGER =
          new Interface.Manager<
              MediaControllerImageObserver, MediaControllerImageObserver.Proxy>() {
            @Override
            public String getName() {
              return "media_session.mojom.MediaControllerImageObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public MediaControllerImageObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, MediaControllerImageObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public MediaControllerImageObserver[] buildArray(int size) {
              return new MediaControllerImageObserver[size];
            }
          };
  private static final int MEDIA_CONTROLLER_IMAGE_CHANGED_ORDINAL = 0;

  MediaControllerImageObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaControllerImageObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void mediaControllerImageChanged(int type, MediaImageBitmap bitmap) {
      MediaControllerImageObserverMediaControllerImageChangedParams _message =
          new MediaControllerImageObserverMediaControllerImageChangedParams();
      _message.type = type;
      _message.bitmap = bitmap;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaControllerImageObserver> {
    Stub(Core core, MediaControllerImageObserver impl) {
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
                MediaControllerImageObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaControllerImageObserverMediaControllerImageChangedParams data =
                MediaControllerImageObserverMediaControllerImageChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaControllerImageChanged(data.type, data.bitmap);
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
                MediaControllerImageObserver_Internal.MANAGER,
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

  static final class MediaControllerImageObserverMediaControllerImageChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaImageBitmap bitmap;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaControllerImageObserverMediaControllerImageChangedParams(int version) {
      super(24, version);
    }

    public MediaControllerImageObserverMediaControllerImageChangedParams() {
      this(0);
    }

    public static MediaControllerImageObserverMediaControllerImageChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaControllerImageObserverMediaControllerImageChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaControllerImageObserverMediaControllerImageChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaControllerImageObserverMediaControllerImageChangedParams result =
            new MediaControllerImageObserverMediaControllerImageChangedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        MediaSessionImageType.validate(readInt);
        result.type = MediaSessionImageType.toKnownValue(result.type);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.bitmap = MediaImageBitmap.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode((Struct) this.bitmap, 16, true);
    }
  }
}
