package org.chromium.network.mojom;

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

class SslConfigClient_Internal {
  public static final Interface.Manager<SslConfigClient, SslConfigClient.Proxy> MANAGER =
      new Interface.Manager<SslConfigClient, SslConfigClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.SSLConfigClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SslConfigClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SslConfigClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public SslConfigClient[] buildArray(int size) {
          return new SslConfigClient[size];
        }
      };
  private static final int ON_SSL_CONFIG_UPDATED_ORDINAL = 0;

  SslConfigClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SslConfigClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onSslConfigUpdated(SslConfig sslConfig) {
      SslConfigClientOnSslConfigUpdatedParams _message =
          new SslConfigClientOnSslConfigUpdatedParams();
      _message.sslConfig = sslConfig;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<SslConfigClient> {
    Stub(Core core, SslConfigClient impl) {
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
                SslConfigClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SslConfigClientOnSslConfigUpdatedParams data =
                SslConfigClientOnSslConfigUpdatedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onSslConfigUpdated(data.sslConfig);
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
                getCore(), SslConfigClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SslConfigClientOnSslConfigUpdatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SslConfig sslConfig;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SslConfigClientOnSslConfigUpdatedParams(int version) {
      super(16, version);
    }

    public SslConfigClientOnSslConfigUpdatedParams() {
      this(0);
    }

    public static SslConfigClientOnSslConfigUpdatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SslConfigClientOnSslConfigUpdatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SslConfigClientOnSslConfigUpdatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SslConfigClientOnSslConfigUpdatedParams result =
            new SslConfigClientOnSslConfigUpdatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.sslConfig = SslConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sslConfig, 8, false);
    }
  }
}