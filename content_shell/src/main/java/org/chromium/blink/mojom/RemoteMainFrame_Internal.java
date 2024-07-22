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

class RemoteMainFrame_Internal {
  public static final Interface.Manager<RemoteMainFrame, RemoteMainFrame.Proxy> MANAGER =
      new Interface.Manager<RemoteMainFrame, RemoteMainFrame.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.RemoteMainFrame";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public RemoteMainFrame.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, RemoteMainFrame impl) {
          return new Stub(core, impl);
        }

        @Override
        public RemoteMainFrame[] buildArray(int size) {
          return new RemoteMainFrame[size];
        }
      };
  private static final int UPDATE_TEXT_AUTOSIZER_PAGE_INFO_ORDINAL = 0;

  RemoteMainFrame_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements RemoteMainFrame.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void updateTextAutosizerPageInfo(TextAutosizerPageInfo pageInfo) {
      RemoteMainFrameUpdateTextAutosizerPageInfoParams _message =
          new RemoteMainFrameUpdateTextAutosizerPageInfoParams();
      _message.pageInfo = pageInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<RemoteMainFrame> {
    Stub(Core core, RemoteMainFrame impl) {
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
                RemoteMainFrame_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            RemoteMainFrameUpdateTextAutosizerPageInfoParams data =
                RemoteMainFrameUpdateTextAutosizerPageInfoParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateTextAutosizerPageInfo(data.pageInfo);
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
                getCore(), RemoteMainFrame_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class RemoteMainFrameUpdateTextAutosizerPageInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TextAutosizerPageInfo pageInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteMainFrameUpdateTextAutosizerPageInfoParams(int version) {
      super(16, version);
    }

    public RemoteMainFrameUpdateTextAutosizerPageInfoParams() {
      this(0);
    }

    public static RemoteMainFrameUpdateTextAutosizerPageInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteMainFrameUpdateTextAutosizerPageInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteMainFrameUpdateTextAutosizerPageInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteMainFrameUpdateTextAutosizerPageInfoParams result =
            new RemoteMainFrameUpdateTextAutosizerPageInfoParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pageInfo = TextAutosizerPageInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pageInfo, 8, false);
    }
  }
}
