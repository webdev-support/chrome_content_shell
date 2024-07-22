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
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.internal.mojom.Origin;

class WebDatabase_Internal {
  private static final int CLOSE_IMMEDIATELY_ORDINAL = 1;
  public static final Interface.Manager<WebDatabase, WebDatabase.Proxy> MANAGER =
      new Interface.Manager<WebDatabase, WebDatabase.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WebDatabase";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebDatabase.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebDatabase impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebDatabase[] buildArray(int size) {
          return new WebDatabase[size];
        }
      };
  private static final int UPDATE_SIZE_ORDINAL = 0;

  WebDatabase_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WebDatabase.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void updateSize(Origin origin, String16 name, long size) {
      WebDatabaseUpdateSizeParams _message = new WebDatabaseUpdateSizeParams();
      _message.origin = origin;
      _message.name = name;
      _message.size = size;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void closeImmediately(Origin origin, String16 name) {
      WebDatabaseCloseImmediatelyParams _message = new WebDatabaseCloseImmediatelyParams();
      _message.origin = origin;
      _message.name = name;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<WebDatabase> {
    Stub(Core core, WebDatabase impl) {
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
                WebDatabase_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WebDatabaseUpdateSizeParams data =
                WebDatabaseUpdateSizeParams.deserialize(messageWithHeader.getPayload());
            getImpl().updateSize(data.origin, data.name, data.size);
            return true;
          case 1:
            WebDatabaseCloseImmediatelyParams data2 =
                WebDatabaseCloseImmediatelyParams.deserialize(messageWithHeader.getPayload());
            getImpl().closeImmediately(data2.origin, data2.name);
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
                getCore(), WebDatabase_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebDatabaseUpdateSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 name;
    public Origin origin;
    public long size;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseUpdateSizeParams(int version) {
      super(32, version);
    }

    public WebDatabaseUpdateSizeParams() {
      this(0);
    }

    public static WebDatabaseUpdateSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseUpdateSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseUpdateSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseUpdateSizeParams result = new WebDatabaseUpdateSizeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.name = String16.decode(decoder12);
        result.size = decoder0.readLong(24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode((Struct) this.name, 16, false);
      encoder0.encode(this.size, 24);
    }
  }

  static final class WebDatabaseCloseImmediatelyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 name;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseCloseImmediatelyParams(int version) {
      super(24, version);
    }

    public WebDatabaseCloseImmediatelyParams() {
      this(0);
    }

    public static WebDatabaseCloseImmediatelyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseCloseImmediatelyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseCloseImmediatelyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseCloseImmediatelyParams result =
            new WebDatabaseCloseImmediatelyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.name = String16.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode((Struct) this.name, 16, false);
    }
  }
}
