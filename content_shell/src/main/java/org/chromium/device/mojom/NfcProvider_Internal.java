package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class NfcProvider_Internal {
  private static final int GET_NFC_FOR_HOST_ORDINAL = 0;
  public static final Interface.Manager<NfcProvider, NfcProvider.Proxy> MANAGER =
      new Interface.Manager<NfcProvider, NfcProvider.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.NFCProvider";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public NfcProvider.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, NfcProvider impl) {
          return new Stub(core, impl);
        }

        @Override
        public NfcProvider[] buildArray(int size) {
          return new NfcProvider[size];
        }
      };
  private static final int RESUME_NFC_OPERATIONS_ORDINAL = 2;
  private static final int SUSPEND_NFC_OPERATIONS_ORDINAL = 1;

  NfcProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements NfcProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getNfcForHost(int hostId, InterfaceRequest<Nfc> receiver) {
      NfcProviderGetNfcForHostParams _message = new NfcProviderGetNfcForHostParams();
      _message.hostId = hostId;
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void suspendNfcOperations() {
      NfcProviderSuspendNfcOperationsParams _message = new NfcProviderSuspendNfcOperationsParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void resumeNfcOperations() {
      NfcProviderResumeNfcOperationsParams _message = new NfcProviderResumeNfcOperationsParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<NfcProvider> {
    Stub(Core core, NfcProvider impl) {
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
                NfcProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            NfcProviderGetNfcForHostParams data =
                NfcProviderGetNfcForHostParams.deserialize(messageWithHeader.getPayload());
            getImpl().getNfcForHost(data.hostId, data.receiver);
            return true;
          case 1:
            NfcProviderSuspendNfcOperationsParams.deserialize(messageWithHeader.getPayload());
            getImpl().suspendNfcOperations();
            return true;
          case 2:
            NfcProviderResumeNfcOperationsParams.deserialize(messageWithHeader.getPayload());
            getImpl().resumeNfcOperations();
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
                getCore(), NfcProvider_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NfcProviderGetNfcForHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int hostId;
    public InterfaceRequest<Nfc> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcProviderGetNfcForHostParams(int version) {
      super(16, version);
    }

    public NfcProviderGetNfcForHostParams() {
      this(0);
    }

    public static NfcProviderGetNfcForHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcProviderGetNfcForHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcProviderGetNfcForHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcProviderGetNfcForHostParams result =
            new NfcProviderGetNfcForHostParams(elementsOrVersion);
        result.hostId = decoder0.readInt(8);
        result.receiver = decoder0.readInterfaceRequest(12, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.hostId, 8);
      encoder0.encode((InterfaceRequest) this.receiver, 12, false);
    }
  }

  static final class NfcProviderSuspendNfcOperationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcProviderSuspendNfcOperationsParams(int version) {
      super(8, version);
    }

    public NfcProviderSuspendNfcOperationsParams() {
      this(0);
    }

    public static NfcProviderSuspendNfcOperationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcProviderSuspendNfcOperationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcProviderSuspendNfcOperationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcProviderSuspendNfcOperationsParams result =
            new NfcProviderSuspendNfcOperationsParams(elementsOrVersion);
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

  static final class NfcProviderResumeNfcOperationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NfcProviderResumeNfcOperationsParams(int version) {
      super(8, version);
    }

    public NfcProviderResumeNfcOperationsParams() {
      this(0);
    }

    public static NfcProviderResumeNfcOperationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NfcProviderResumeNfcOperationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcProviderResumeNfcOperationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NfcProviderResumeNfcOperationsParams result =
            new NfcProviderResumeNfcOperationsParams(elementsOrVersion);
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
