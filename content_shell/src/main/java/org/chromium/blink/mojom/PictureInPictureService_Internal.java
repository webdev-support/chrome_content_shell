package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
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
import org.chromium.viz.mojom.SurfaceId;

class PictureInPictureService_Internal {
  public static final Interface.Manager<PictureInPictureService, PictureInPictureService.Proxy>
      MANAGER =
          new Interface.Manager<PictureInPictureService, PictureInPictureService.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.PictureInPictureService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PictureInPictureService.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PictureInPictureService impl) {
              return new Stub(core, impl);
            }

            @Override
            public PictureInPictureService[] buildArray(int size) {
              return new PictureInPictureService[size];
            }
          };
  private static final int START_SESSION_ORDINAL = 0;

  PictureInPictureService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PictureInPictureService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void startSession(
        int playerId,
        AssociatedInterfaceNotSupported playerRemote,
        SurfaceId surfaceId,
        Size naturalSize,
        boolean showPlayPauseButton,
        PictureInPictureSessionObserver observer,
        Rect sourceBounds,
        StartSession_Response callback) {
      PictureInPictureServiceStartSessionParams _message =
          new PictureInPictureServiceStartSessionParams();
      _message.playerId = playerId;
      _message.playerRemote = playerRemote;
      _message.surfaceId = surfaceId;
      _message.naturalSize = naturalSize;
      _message.showPlayPauseButton = showPlayPauseButton;
      _message.observer = observer;
      _message.sourceBounds = sourceBounds;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new PictureInPictureServiceStartSessionResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<PictureInPictureService> {
    Stub(Core core, PictureInPictureService impl) {
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
                PictureInPictureService_Internal.MANAGER, messageWithHeader);
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
                getCore(), PictureInPictureService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            PictureInPictureServiceStartSessionParams data =
                PictureInPictureServiceStartSessionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .startSession(
                    data.playerId,
                    data.playerRemote,
                    data.surfaceId,
                    data.naturalSize,
                    data.showPlayPauseButton,
                    data.observer,
                    data.sourceBounds,
                    new PictureInPictureServiceStartSessionResponseParamsProxyToResponder(
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

  static final class PictureInPictureServiceStartSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public Size naturalSize;
    public PictureInPictureSessionObserver observer;
    public int playerId;
    public AssociatedInterfaceNotSupported playerRemote;
    public boolean showPlayPauseButton;
    public Rect sourceBounds;
    public SurfaceId surfaceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PictureInPictureServiceStartSessionParams(int version) {
      super(56, version);
    }

    public PictureInPictureServiceStartSessionParams() {
      this(0);
    }

    public static PictureInPictureServiceStartSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PictureInPictureServiceStartSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PictureInPictureServiceStartSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PictureInPictureServiceStartSessionParams result =
            new PictureInPictureServiceStartSessionParams(elementsOrVersion);
        result.playerId = decoder0.readInt(8);
        result.playerRemote = decoder0.readAssociatedServiceInterfaceNotSupported(12, false);
        result.showPlayPauseButton = decoder0.readBoolean(20, 0);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.surfaceId = SurfaceId.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.naturalSize = Size.decode(decoder12);
        result.observer =
            (PictureInPictureSessionObserver)
                decoder0.readServiceInterface(40, false, PictureInPictureSessionObserver.MANAGER);
        Decoder decoder13 = decoder0.readPointer(48, false);
        result.sourceBounds = Rect.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.playerId, 8);
      encoder0.encode(this.playerRemote, 12, false);
      encoder0.encode(this.showPlayPauseButton, 20, 0);
      encoder0.encode((Struct) this.surfaceId, 24, false);
      encoder0.encode((Struct) this.naturalSize, 32, false);
      encoder0.encode(this.observer, 40, false, PictureInPictureSessionObserver.MANAGER);
      encoder0.encode((Struct) this.sourceBounds, 48, false);
    }
  }

  static final class PictureInPictureServiceStartSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PictureInPictureSession session;
    public Size size;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PictureInPictureServiceStartSessionResponseParams(int version) {
      super(24, version);
    }

    public PictureInPictureServiceStartSessionResponseParams() {
      this(0);
    }

    public static PictureInPictureServiceStartSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PictureInPictureServiceStartSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PictureInPictureServiceStartSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PictureInPictureServiceStartSessionResponseParams result =
            new PictureInPictureServiceStartSessionResponseParams(elementsOrVersion);
        result.session =
            (PictureInPictureSession)
                decoder0.readServiceInterface(8, true, PictureInPictureSession.MANAGER);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.size = Size.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.session, 8, true, PictureInPictureSession.MANAGER);
      encoder0.encode((Struct) this.size, 16, false);
    }
  }

  static class PictureInPictureServiceStartSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PictureInPictureService.StartSession_Response mCallback;

    PictureInPictureServiceStartSessionResponseParamsForwardToCallback(
        PictureInPictureService.StartSession_Response callback) {
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
        PictureInPictureServiceStartSessionResponseParams response =
            PictureInPictureServiceStartSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.session, response.size);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PictureInPictureServiceStartSessionResponseParamsProxyToResponder
      implements PictureInPictureService.StartSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PictureInPictureServiceStartSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(PictureInPictureSession session, Size size) {
      PictureInPictureServiceStartSessionResponseParams _response =
          new PictureInPictureServiceStartSessionResponseParams();
      _response.session = session;
      _response.size = size;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
