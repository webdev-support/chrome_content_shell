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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.url.mojom.Url;

class ContextMenuClient_Internal {
  private static final int CONTEXT_MENU_CLOSED_ORDINAL = 1;
  private static final int CUSTOM_CONTEXT_MENU_ACTION_ORDINAL = 0;
  public static final Interface.Manager<ContextMenuClient, ContextMenuClient.Proxy> MANAGER =
      new Interface.Manager<ContextMenuClient, ContextMenuClient.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ContextMenuClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ContextMenuClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ContextMenuClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public ContextMenuClient[] buildArray(int size) {
          return new ContextMenuClient[size];
        }
      };

  ContextMenuClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ContextMenuClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void customContextMenuAction(int action) {
      ContextMenuClientCustomContextMenuActionParams _message =
          new ContextMenuClientCustomContextMenuActionParams();
      _message.action = action;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void contextMenuClosed(Url linkFollowed) {
      ContextMenuClientContextMenuClosedParams _message =
          new ContextMenuClientContextMenuClosedParams();
      _message.linkFollowed = linkFollowed;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<ContextMenuClient> {
    Stub(Core core, ContextMenuClient impl) {
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
                ContextMenuClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ContextMenuClientCustomContextMenuActionParams data =
                ContextMenuClientCustomContextMenuActionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().customContextMenuAction(data.action);
            return true;
          case 1:
            ContextMenuClientContextMenuClosedParams data2 =
                ContextMenuClientContextMenuClosedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().contextMenuClosed(data2.linkFollowed);
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
                getCore(), ContextMenuClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ContextMenuClientCustomContextMenuActionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int action;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContextMenuClientCustomContextMenuActionParams(int version) {
      super(16, version);
    }

    public ContextMenuClientCustomContextMenuActionParams() {
      this(0);
    }

    public static ContextMenuClientCustomContextMenuActionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContextMenuClientCustomContextMenuActionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContextMenuClientCustomContextMenuActionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContextMenuClientCustomContextMenuActionParams result =
            new ContextMenuClientCustomContextMenuActionParams(elementsOrVersion);
        result.action = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.action, 8);
    }
  }

  static final class ContextMenuClientContextMenuClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url linkFollowed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContextMenuClientContextMenuClosedParams(int version) {
      super(16, version);
    }

    public ContextMenuClientContextMenuClosedParams() {
      this(0);
    }

    public static ContextMenuClientContextMenuClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContextMenuClientContextMenuClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContextMenuClientContextMenuClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContextMenuClientContextMenuClosedParams result =
            new ContextMenuClientContextMenuClosedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.linkFollowed = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.linkFollowed, 8, false);
    }
  }
}
