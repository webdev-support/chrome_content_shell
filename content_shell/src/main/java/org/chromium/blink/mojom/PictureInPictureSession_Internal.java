package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class PictureInPictureSession_Internal {
  public static final Interface.Manager<PictureInPictureSession, PictureInPictureSession.Proxy>
      MANAGER =
          new Interface.Manager<PictureInPictureSession, PictureInPictureSession.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.PictureInPictureSession";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PictureInPictureSession.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PictureInPictureSession impl) {
              return new Stub(core, impl);
            }

            @Override
            public PictureInPictureSession[] buildArray(int size) {
              return new PictureInPictureSession[size];
            }
          };
  private static final int STOP_ORDINAL = 1;
  private static final int UPDATE_ORDINAL = 0;

  PictureInPictureSession_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PictureInPictureSession.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void update(
        int playerId,
        AssociatedInterfaceNotSupported playerRemote,
        SurfaceId surfaceId,
        Size naturalSize,
        boolean showPlayPauseButton) {
      PictureInPictureSessionUpdateParams _message = new PictureInPictureSessionUpdateParams();
      _message.playerId = playerId;
      _message.playerRemote = playerRemote;
      _message.surfaceId = surfaceId;
      _message.naturalSize = naturalSize;
      _message.showPlayPauseButton = showPlayPauseButton;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void stop(Stop_Response callback) {
      PictureInPictureSessionStopParams _message = new PictureInPictureSessionStopParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new PictureInPictureSessionStopResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<PictureInPictureSession> {
    Stub(Core core, PictureInPictureSession impl) {
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
                PictureInPictureSession_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PictureInPictureSessionUpdateParams data =
                PictureInPictureSessionUpdateParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .update(
                    data.playerId,
                    data.playerRemote,
                    data.surfaceId,
                    data.naturalSize,
                    data.showPlayPauseButton);
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
                getCore(), PictureInPictureSession_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            PictureInPictureSessionStopParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .stop(
                    new PictureInPictureSessionStopResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PictureInPictureSessionUpdateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public Size naturalSize;
    public int playerId;
    public AssociatedInterfaceNotSupported playerRemote;
    public boolean showPlayPauseButton;
    public SurfaceId surfaceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PictureInPictureSessionUpdateParams(int version) {
      super(40, version);
    }

    public PictureInPictureSessionUpdateParams() {
      this(0);
    }

    public static PictureInPictureSessionUpdateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PictureInPictureSessionUpdateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PictureInPictureSessionUpdateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PictureInPictureSessionUpdateParams result =
            new PictureInPictureSessionUpdateParams(elementsOrVersion);
        result.playerId = decoder0.readInt(8);
        result.playerRemote = decoder0.readAssociatedServiceInterfaceNotSupported(12, false);
        result.showPlayPauseButton = decoder0.readBoolean(20, 0);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.surfaceId = SurfaceId.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.naturalSize = Size.decode(decoder12);
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
    }
  }

  static final class PictureInPictureSessionStopParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PictureInPictureSessionStopParams(int version) {
      super(8, version);
    }

    public PictureInPictureSessionStopParams() {
      this(0);
    }

    public static PictureInPictureSessionStopParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PictureInPictureSessionStopParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PictureInPictureSessionStopParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PictureInPictureSessionStopParams result =
            new PictureInPictureSessionStopParams(elementsOrVersion);
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

  static final class PictureInPictureSessionStopResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PictureInPictureSessionStopResponseParams(int version) {
      super(8, version);
    }

    public PictureInPictureSessionStopResponseParams() {
      this(0);
    }

    public static PictureInPictureSessionStopResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PictureInPictureSessionStopResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PictureInPictureSessionStopResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PictureInPictureSessionStopResponseParams result =
            new PictureInPictureSessionStopResponseParams(elementsOrVersion);
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

  static class PictureInPictureSessionStopResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PictureInPictureSession.Stop_Response mCallback;

    PictureInPictureSessionStopResponseParamsForwardToCallback(
        PictureInPictureSession.Stop_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PictureInPictureSessionStopResponseParamsProxyToResponder
      implements PictureInPictureSession.Stop_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PictureInPictureSessionStopResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      PictureInPictureSessionStopResponseParams _response =
          new PictureInPictureSessionStopResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
