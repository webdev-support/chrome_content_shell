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

class PopupMenuClient_Internal {
  private static final int DID_ACCEPT_INDICES_ORDINAL = 0;
  private static final int DID_CANCEL_ORDINAL = 1;
  public static final Interface.Manager<PopupMenuClient, PopupMenuClient.Proxy> MANAGER =
      new Interface.Manager<PopupMenuClient, PopupMenuClient.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PopupMenuClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PopupMenuClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PopupMenuClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public PopupMenuClient[] buildArray(int size) {
          return new PopupMenuClient[size];
        }
      };

  PopupMenuClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements PopupMenuClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void didAcceptIndices(int[] indices) {
      PopupMenuClientDidAcceptIndicesParams _message = new PopupMenuClientDidAcceptIndicesParams();
      _message.indices = indices;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void didCancel() {
      PopupMenuClientDidCancelParams _message = new PopupMenuClientDidCancelParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<PopupMenuClient> {
    Stub(Core core, PopupMenuClient impl) {
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
                PopupMenuClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PopupMenuClientDidAcceptIndicesParams data =
                PopupMenuClientDidAcceptIndicesParams.deserialize(messageWithHeader.getPayload());
            getImpl().didAcceptIndices(data.indices);
            return true;
          case 1:
            PopupMenuClientDidCancelParams.deserialize(messageWithHeader.getPayload());
            getImpl().didCancel();
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
                getCore(), PopupMenuClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PopupMenuClientDidAcceptIndicesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] indices;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PopupMenuClientDidAcceptIndicesParams(int version) {
      super(16, version);
    }

    public PopupMenuClientDidAcceptIndicesParams() {
      this(0);
    }

    public static PopupMenuClientDidAcceptIndicesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PopupMenuClientDidAcceptIndicesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PopupMenuClientDidAcceptIndicesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PopupMenuClientDidAcceptIndicesParams result =
            new PopupMenuClientDidAcceptIndicesParams(elementsOrVersion);
        result.indices = decoder0.readInts(8, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.indices, 8, 0, -1);
    }
  }

  static final class PopupMenuClientDidCancelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PopupMenuClientDidCancelParams(int version) {
      super(8, version);
    }

    public PopupMenuClientDidCancelParams() {
      this(0);
    }

    public static PopupMenuClientDidCancelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PopupMenuClientDidCancelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PopupMenuClientDidCancelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PopupMenuClientDidCancelParams result =
            new PopupMenuClientDidCancelParams(elementsOrVersion);
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
