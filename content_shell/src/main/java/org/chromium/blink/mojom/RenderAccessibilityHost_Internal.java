package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class RenderAccessibilityHost_Internal {
  private static final int HANDLE_AX_EVENTS_ORDINAL = 0;
  private static final int HANDLE_AX_LOCATION_CHANGES_ORDINAL = 1;
  public static final Interface.Manager<RenderAccessibilityHost, RenderAccessibilityHost.Proxy>
      MANAGER =
          new Interface.Manager<RenderAccessibilityHost, RenderAccessibilityHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.RenderAccessibilityHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public RenderAccessibilityHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, RenderAccessibilityHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public RenderAccessibilityHost[] buildArray(int size) {
              return new RenderAccessibilityHost[size];
            }
          };

  RenderAccessibilityHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RenderAccessibilityHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void handleAxEvents(
        AxUpdatesAndEvents eventsAndUpdates, int resetToken, HandleAxEvents_Response callback) {
      RenderAccessibilityHostHandleAxEventsParams _message =
          new RenderAccessibilityHostHandleAxEventsParams();
      _message.eventsAndUpdates = eventsAndUpdates;
      _message.resetToken = resetToken;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new RenderAccessibilityHostHandleAxEventsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void handleAxLocationChanges(LocationChanges[] changes, int resetToken) {
      RenderAccessibilityHostHandleAxLocationChangesParams _message =
          new RenderAccessibilityHostHandleAxLocationChangesParams();
      _message.changes = changes;
      _message.resetToken = resetToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<RenderAccessibilityHost> {
    Stub(Core core, RenderAccessibilityHost impl) {
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
                RenderAccessibilityHost_Internal.MANAGER, messageWithHeader);
          case 1:
            RenderAccessibilityHostHandleAxLocationChangesParams data =
                RenderAccessibilityHostHandleAxLocationChangesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().handleAxLocationChanges(data.changes, data.resetToken);
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
                getCore(), RenderAccessibilityHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            RenderAccessibilityHostHandleAxEventsParams data =
                RenderAccessibilityHostHandleAxEventsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .handleAxEvents(
                    data.eventsAndUpdates,
                    data.resetToken,
                    new RenderAccessibilityHostHandleAxEventsResponseParamsProxyToResponder(
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

  static final class RenderAccessibilityHostHandleAxEventsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AxUpdatesAndEvents eventsAndUpdates;
    public int resetToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilityHostHandleAxEventsParams(int version) {
      super(24, version);
    }

    public RenderAccessibilityHostHandleAxEventsParams() {
      this(0);
    }

    public static RenderAccessibilityHostHandleAxEventsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilityHostHandleAxEventsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilityHostHandleAxEventsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilityHostHandleAxEventsParams result =
            new RenderAccessibilityHostHandleAxEventsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.eventsAndUpdates = AxUpdatesAndEvents.decode(decoder1);
        result.resetToken = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.eventsAndUpdates, 8, false);
      encoder0.encode(this.resetToken, 16);
    }
  }

  static final class RenderAccessibilityHostHandleAxEventsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilityHostHandleAxEventsResponseParams(int version) {
      super(8, version);
    }

    public RenderAccessibilityHostHandleAxEventsResponseParams() {
      this(0);
    }

    public static RenderAccessibilityHostHandleAxEventsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilityHostHandleAxEventsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilityHostHandleAxEventsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilityHostHandleAxEventsResponseParams result =
            new RenderAccessibilityHostHandleAxEventsResponseParams(elementsOrVersion);
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

  static class RenderAccessibilityHostHandleAxEventsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final RenderAccessibilityHost.HandleAxEvents_Response mCallback;

    RenderAccessibilityHostHandleAxEventsResponseParamsForwardToCallback(
        RenderAccessibilityHost.HandleAxEvents_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class RenderAccessibilityHostHandleAxEventsResponseParamsProxyToResponder
      implements RenderAccessibilityHost.HandleAxEvents_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    RenderAccessibilityHostHandleAxEventsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      RenderAccessibilityHostHandleAxEventsResponseParams _response =
          new RenderAccessibilityHostHandleAxEventsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class RenderAccessibilityHostHandleAxLocationChangesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public LocationChanges[] changes;
    public int resetToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilityHostHandleAxLocationChangesParams(int version) {
      super(24, version);
    }

    public RenderAccessibilityHostHandleAxLocationChangesParams() {
      this(0);
    }

    public static RenderAccessibilityHostHandleAxLocationChangesParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilityHostHandleAxLocationChangesParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilityHostHandleAxLocationChangesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilityHostHandleAxLocationChangesParams result =
            new RenderAccessibilityHostHandleAxLocationChangesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.changes = new LocationChanges[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.changes[i1] = LocationChanges.decode(decoder2);
        }
        result.resetToken = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      LocationChanges[] locationChangesArr = this.changes;
      if (locationChangesArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(locationChangesArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          LocationChanges[] locationChangesArr2 = this.changes;
          if (i0 >= locationChangesArr2.length) {
            break;
          }
          encoder1.encode((Struct) locationChangesArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.resetToken, 16);
    }
  }
}
