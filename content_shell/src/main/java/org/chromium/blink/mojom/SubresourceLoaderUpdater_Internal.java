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

class SubresourceLoaderUpdater_Internal {
  public static final Interface.Manager<SubresourceLoaderUpdater, SubresourceLoaderUpdater.Proxy>
      MANAGER =
          new Interface.Manager<SubresourceLoaderUpdater, SubresourceLoaderUpdater.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.SubresourceLoaderUpdater";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SubresourceLoaderUpdater.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SubresourceLoaderUpdater impl) {
              return new Stub(core, impl);
            }

            @Override
            public SubresourceLoaderUpdater[] buildArray(int size) {
              return new SubresourceLoaderUpdater[size];
            }
          };
  private static final int UPDATE_SUBRESOURCE_LOADER_FACTORIES_ORDINAL = 0;

  SubresourceLoaderUpdater_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SubresourceLoaderUpdater.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void updateSubresourceLoaderFactories(
        UrlLoaderFactoryBundle subresourceLoaderFactories) {
      SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams _message =
          new SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams();
      _message.subresourceLoaderFactories = subresourceLoaderFactories;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<SubresourceLoaderUpdater> {
    Stub(Core core, SubresourceLoaderUpdater impl) {
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
                SubresourceLoaderUpdater_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams data =
                SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateSubresourceLoaderFactories(data.subresourceLoaderFactories);
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
                getCore(), SubresourceLoaderUpdater_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UrlLoaderFactoryBundle subresourceLoaderFactories;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams(int version) {
      super(16, version);
    }

    public SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams() {
      this(0);
    }

    public static SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams result =
            new SubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.subresourceLoaderFactories = UrlLoaderFactoryBundle.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.subresourceLoaderFactories, 8, false);
    }
  }
}
