package org.chromium.media.mojom;

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

class AndroidOverlayProvider_Internal {
  private static final int CREATE_OVERLAY_ORDINAL = 0;
  public static final Interface.Manager<AndroidOverlayProvider, AndroidOverlayProvider.Proxy>
      MANAGER =
          new Interface.Manager<AndroidOverlayProvider, AndroidOverlayProvider.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.AndroidOverlayProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AndroidOverlayProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AndroidOverlayProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public AndroidOverlayProvider[] buildArray(int size) {
              return new AndroidOverlayProvider[size];
            }
          };

  AndroidOverlayProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AndroidOverlayProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createOverlay(
        InterfaceRequest<AndroidOverlay> overlay,
        AndroidOverlayClient client,
        AndroidOverlayConfig config) {
      AndroidOverlayProviderCreateOverlayParams _message =
          new AndroidOverlayProviderCreateOverlayParams();
      _message.overlay = overlay;
      _message.client = client;
      _message.config = config;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<AndroidOverlayProvider> {
    Stub(Core core, AndroidOverlayProvider impl) {
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
                AndroidOverlayProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AndroidOverlayProviderCreateOverlayParams data =
                AndroidOverlayProviderCreateOverlayParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createOverlay(data.overlay, data.client, data.config);
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
                getCore(), AndroidOverlayProvider_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AndroidOverlayProviderCreateOverlayParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AndroidOverlayClient client;
    public AndroidOverlayConfig config;
    public InterfaceRequest<AndroidOverlay> overlay;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AndroidOverlayProviderCreateOverlayParams(int version) {
      super(32, version);
    }

    public AndroidOverlayProviderCreateOverlayParams() {
      this(0);
    }

    public static AndroidOverlayProviderCreateOverlayParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AndroidOverlayProviderCreateOverlayParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AndroidOverlayProviderCreateOverlayParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AndroidOverlayProviderCreateOverlayParams result =
            new AndroidOverlayProviderCreateOverlayParams(elementsOrVersion);
        result.overlay = decoder0.readInterfaceRequest(8, false);
        result.client =
            (AndroidOverlayClient)
                decoder0.readServiceInterface(12, false, AndroidOverlayClient.MANAGER);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.config = AndroidOverlayConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.overlay, 8, false);
      encoder0.encode(this.client, 12, false, AndroidOverlayClient.MANAGER);
      encoder0.encode((Struct) this.config, 24, false);
    }
  }
}
