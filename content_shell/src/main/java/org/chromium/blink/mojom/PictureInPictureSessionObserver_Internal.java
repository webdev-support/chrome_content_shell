package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
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

class PictureInPictureSessionObserver_Internal {
  public static final Interface.Manager<
          PictureInPictureSessionObserver, PictureInPictureSessionObserver.Proxy>
      MANAGER =
          new Interface.Manager<
              PictureInPictureSessionObserver, PictureInPictureSessionObserver.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.PictureInPictureSessionObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PictureInPictureSessionObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PictureInPictureSessionObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public PictureInPictureSessionObserver[] buildArray(int size) {
              return new PictureInPictureSessionObserver[size];
            }
          };
  private static final int ON_STOPPED_ORDINAL = 1;
  private static final int ON_WINDOW_SIZE_CHANGED_ORDINAL = 0;

  PictureInPictureSessionObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PictureInPictureSessionObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onWindowSizeChanged(Size size) {
      PictureInPictureSessionObserverOnWindowSizeChangedParams _message =
          new PictureInPictureSessionObserverOnWindowSizeChangedParams();
      _message.size = size;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onStopped() {
      PictureInPictureSessionObserverOnStoppedParams _message =
          new PictureInPictureSessionObserverOnStoppedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<PictureInPictureSessionObserver> {
    Stub(Core core, PictureInPictureSessionObserver impl) {
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
                PictureInPictureSessionObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PictureInPictureSessionObserverOnWindowSizeChangedParams data =
                PictureInPictureSessionObserverOnWindowSizeChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onWindowSizeChanged(data.size);
            return true;
          case 1:
            PictureInPictureSessionObserverOnStoppedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onStopped();
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
                PictureInPictureSessionObserver_Internal.MANAGER,
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

  static final class PictureInPictureSessionObserverOnWindowSizeChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Size size;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PictureInPictureSessionObserverOnWindowSizeChangedParams(int version) {
      super(16, version);
    }

    public PictureInPictureSessionObserverOnWindowSizeChangedParams() {
      this(0);
    }

    public static PictureInPictureSessionObserverOnWindowSizeChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PictureInPictureSessionObserverOnWindowSizeChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PictureInPictureSessionObserverOnWindowSizeChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PictureInPictureSessionObserverOnWindowSizeChangedParams result =
            new PictureInPictureSessionObserverOnWindowSizeChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.size = Size.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.size, 8, false);
    }
  }

  static final class PictureInPictureSessionObserverOnStoppedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PictureInPictureSessionObserverOnStoppedParams(int version) {
      super(8, version);
    }

    public PictureInPictureSessionObserverOnStoppedParams() {
      this(0);
    }

    public static PictureInPictureSessionObserverOnStoppedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PictureInPictureSessionObserverOnStoppedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PictureInPictureSessionObserverOnStoppedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PictureInPictureSessionObserverOnStoppedParams result =
            new PictureInPictureSessionObserverOnStoppedParams(elementsOrVersion);
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
