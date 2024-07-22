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

class BlobReaderClient_Internal {
  public static final Interface.Manager<BlobReaderClient, BlobReaderClient.Proxy> MANAGER =
      new Interface.Manager<BlobReaderClient, BlobReaderClient.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.BlobReaderClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public BlobReaderClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, BlobReaderClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public BlobReaderClient[] buildArray(int size) {
          return new BlobReaderClient[size];
        }
      };
  private static final int ON_CALCULATED_SIZE_ORDINAL = 0;
  private static final int ON_COMPLETE_ORDINAL = 1;

  BlobReaderClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements BlobReaderClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onCalculatedSize(long totalSize, long expectedContentSize) {
      BlobReaderClientOnCalculatedSizeParams _message =
          new BlobReaderClientOnCalculatedSizeParams();
      _message.totalSize = totalSize;
      _message.expectedContentSize = expectedContentSize;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onComplete(int status, long dataLength) {
      BlobReaderClientOnCompleteParams _message = new BlobReaderClientOnCompleteParams();
      _message.status = status;
      _message.dataLength = dataLength;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<BlobReaderClient> {
    Stub(Core core, BlobReaderClient impl) {
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
                BlobReaderClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            BlobReaderClientOnCalculatedSizeParams data =
                BlobReaderClientOnCalculatedSizeParams.deserialize(messageWithHeader.getPayload());
            getImpl().onCalculatedSize(data.totalSize, data.expectedContentSize);
            return true;
          case 1:
            BlobReaderClientOnCompleteParams data2 =
                BlobReaderClientOnCompleteParams.deserialize(messageWithHeader.getPayload());
            getImpl().onComplete(data2.status, data2.dataLength);
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
                getCore(), BlobReaderClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class BlobReaderClientOnCalculatedSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long expectedContentSize;
    public long totalSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobReaderClientOnCalculatedSizeParams(int version) {
      super(24, version);
    }

    public BlobReaderClientOnCalculatedSizeParams() {
      this(0);
    }

    public static BlobReaderClientOnCalculatedSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobReaderClientOnCalculatedSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobReaderClientOnCalculatedSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobReaderClientOnCalculatedSizeParams result =
            new BlobReaderClientOnCalculatedSizeParams(elementsOrVersion);
        result.totalSize = decoder0.readLong(8);
        result.expectedContentSize = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.totalSize, 8);
      encoder0.encode(this.expectedContentSize, 16);
    }
  }

  static final class BlobReaderClientOnCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long dataLength;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobReaderClientOnCompleteParams(int version) {
      super(24, version);
    }

    public BlobReaderClientOnCompleteParams() {
      this(0);
    }

    public static BlobReaderClientOnCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobReaderClientOnCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobReaderClientOnCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobReaderClientOnCompleteParams result =
            new BlobReaderClientOnCompleteParams(elementsOrVersion);
        result.status = decoder0.readInt(8);
        result.dataLength = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.dataLength, 16);
    }
  }
}
