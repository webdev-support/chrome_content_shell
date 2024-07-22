package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.MediaSessionAction;
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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class MediaSessionClient_Internal {
  private static final int DID_RECEIVE_ACTION_ORDINAL = 0;
  public static final Interface.Manager<MediaSessionClient, MediaSessionClient.Proxy> MANAGER =
      new Interface.Manager<MediaSessionClient, MediaSessionClient.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.MediaSessionClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public MediaSessionClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, MediaSessionClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public MediaSessionClient[] buildArray(int size) {
          return new MediaSessionClient[size];
        }
      };

  MediaSessionClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaSessionClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void didReceiveAction(int action, MediaSessionActionDetails details) {
      MediaSessionClientDidReceiveActionParams _message =
          new MediaSessionClientDidReceiveActionParams();
      _message.action = action;
      _message.details = details;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaSessionClient> {
    Stub(Core core, MediaSessionClient impl) {
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
                MediaSessionClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaSessionClientDidReceiveActionParams data =
                MediaSessionClientDidReceiveActionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didReceiveAction(data.action, data.details);
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
                getCore(), MediaSessionClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaSessionClientDidReceiveActionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int action;
    public MediaSessionActionDetails details;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionClientDidReceiveActionParams(int version) {
      super(32, version);
    }

    public MediaSessionClientDidReceiveActionParams() {
      this(0);
    }

    public static MediaSessionClientDidReceiveActionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionClientDidReceiveActionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionClientDidReceiveActionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionClientDidReceiveActionParams result =
            new MediaSessionClientDidReceiveActionParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.action = readInt;
        MediaSessionAction.validate(readInt);
        result.action = MediaSessionAction.toKnownValue(result.action);
        result.details = MediaSessionActionDetails.decode(decoder0, 16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.action, 8);
      encoder0.encode((Union) this.details, 16, true);
    }
  }
}
