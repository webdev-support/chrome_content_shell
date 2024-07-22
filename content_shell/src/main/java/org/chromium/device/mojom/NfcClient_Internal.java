package org.chromium.device.mojom;

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

class NfcClient_Internal {
  public static final Interface.Manager<NfcClient, NfcClient.Proxy> MANAGER =
      new Interface.Manager<NfcClient, NfcClient.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.NFCClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public NfcClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, NfcClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public NfcClient[] buildArray(int size) {
          return new NfcClient[size];
        }
      };
  private static final int ON_ERROR_ORDINAL = 1;
  private static final int ON_WATCH_ORDINAL = 0;

  NfcClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements NfcClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onWatch(int[] watchIds, String serialNumber, NdefMessage message) {
      NfcClientOnWatchParams _message = new NfcClientOnWatchParams();
      _message.watchIds = watchIds;
      _message.serialNumber = serialNumber;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onError(NdefError error) {
      NfcClientOnErrorParams _message = new NfcClientOnErrorParams();
      _message.error = error;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<NfcClient> {
    Stub(Core core, NfcClient impl) {
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
                NfcClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            NfcClientOnWatchParams data =
                NfcClientOnWatchParams.deserialize(messageWithHeader.getPayload());
            getImpl().onWatch(data.watchIds, data.serialNumber, data.message);
            return true;
          case 1:
            getImpl()
                .onError(NfcClientOnErrorParams.deserialize(messageWithHeader.getPayload()).error);
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
                getCore(), NfcClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NfcClientOnWatchParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public NdefMessage message;
    public String serialNumber;
    public int[] watchIds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcClientOnWatchParams(int version) {
      super(32, version);
    }

    public NfcClientOnWatchParams() {
      this(0);
    }

    public static NfcClientOnWatchParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcClientOnWatchParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcClientOnWatchParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcClientOnWatchParams result = new NfcClientOnWatchParams(elementsOrVersion);
        result.watchIds = decoder0.readInts(8, 0, -1);
        result.serialNumber = decoder0.readString(16, true);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.message = NdefMessage.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.watchIds, 8, 0, -1);
      encoder0.encode(this.serialNumber, 16, true);
      encoder0.encode((Struct) this.message, 24, false);
    }
  }

  static final class NfcClientOnErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public NdefError error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcClientOnErrorParams(int version) {
      super(16, version);
    }

    public NfcClientOnErrorParams() {
      this(0);
    }

    public static NfcClientOnErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcClientOnErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcClientOnErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcClientOnErrorParams result = new NfcClientOnErrorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.error = NdefError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.error, 8, false);
    }
  }
}
