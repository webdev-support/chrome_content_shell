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
import org.chromium.network.mojom.MutablePartialNetworkTrafficAnnotationTag;

class PublicIpAddressGeolocationProvider_Internal {
  private static final int CREATE_GEOLOCATION_ORDINAL = 0;
  public static final Interface.Manager<
          PublicIpAddressGeolocationProvider, PublicIpAddressGeolocationProvider.Proxy>
      MANAGER =
          new Interface.Manager<
              PublicIpAddressGeolocationProvider, PublicIpAddressGeolocationProvider.Proxy>() {
            @Override
            public String getName() {
              return "device.mojom.PublicIpAddressGeolocationProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PublicIpAddressGeolocationProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PublicIpAddressGeolocationProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public PublicIpAddressGeolocationProvider[] buildArray(int size) {
              return new PublicIpAddressGeolocationProvider[size];
            }
          };

  PublicIpAddressGeolocationProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PublicIpAddressGeolocationProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createGeolocation(
        MutablePartialNetworkTrafficAnnotationTag tag, InterfaceRequest<Geolocation> receiver) {
      PublicIpAddressGeolocationProviderCreateGeolocationParams _message =
          new PublicIpAddressGeolocationProviderCreateGeolocationParams();
      _message.tag = tag;
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<PublicIpAddressGeolocationProvider> {
    Stub(Core core, PublicIpAddressGeolocationProvider impl) {
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
                PublicIpAddressGeolocationProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PublicIpAddressGeolocationProviderCreateGeolocationParams data =
                PublicIpAddressGeolocationProviderCreateGeolocationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createGeolocation(data.tag, data.receiver);
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
                getCore(),
                PublicIpAddressGeolocationProvider_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PublicIpAddressGeolocationProviderCreateGeolocationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Geolocation> receiver;
    public MutablePartialNetworkTrafficAnnotationTag tag;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PublicIpAddressGeolocationProviderCreateGeolocationParams(int version) {
      super(24, version);
    }

    public PublicIpAddressGeolocationProviderCreateGeolocationParams() {
      this(0);
    }

    public static PublicIpAddressGeolocationProviderCreateGeolocationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PublicIpAddressGeolocationProviderCreateGeolocationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PublicIpAddressGeolocationProviderCreateGeolocationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PublicIpAddressGeolocationProviderCreateGeolocationParams result =
            new PublicIpAddressGeolocationProviderCreateGeolocationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.tag = MutablePartialNetworkTrafficAnnotationTag.decode(decoder1);
        result.receiver = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.tag, 8, false);
      encoder0.encode((InterfaceRequest) this.receiver, 16, false);
    }
  }
}
