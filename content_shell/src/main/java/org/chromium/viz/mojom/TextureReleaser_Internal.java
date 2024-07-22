package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gpu.mojom.SyncToken;
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

class TextureReleaser_Internal {
  public static final Interface.Manager<TextureReleaser, TextureReleaser.Proxy> MANAGER =
      new Interface.Manager<TextureReleaser, TextureReleaser.Proxy>() {
        @Override
        public String getName() {
          return "viz.mojom.TextureReleaser";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public TextureReleaser.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, TextureReleaser impl) {
          return new Stub(core, impl);
        }

        @Override
        public TextureReleaser[] buildArray(int size) {
          return new TextureReleaser[size];
        }
      };
  private static final int RELEASE_ORDINAL = 0;

  TextureReleaser_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements TextureReleaser.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void release(SyncToken syncToken, boolean isLost) {
      TextureReleaserReleaseParams _message = new TextureReleaserReleaseParams();
      _message.syncToken = syncToken;
      _message.isLost = isLost;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<TextureReleaser> {
    Stub(Core core, TextureReleaser impl) {
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
                TextureReleaser_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            TextureReleaserReleaseParams data =
                TextureReleaserReleaseParams.deserialize(messageWithHeader.getPayload());
            getImpl().release(data.syncToken, data.isLost);
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
                getCore(), TextureReleaser_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class TextureReleaserReleaseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isLost;
    public SyncToken syncToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextureReleaserReleaseParams(int version) {
      super(24, version);
    }

    public TextureReleaserReleaseParams() {
      this(0);
    }

    public static TextureReleaserReleaseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextureReleaserReleaseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextureReleaserReleaseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextureReleaserReleaseParams result = new TextureReleaserReleaseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.syncToken = SyncToken.decode(decoder1);
        result.isLost = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.syncToken, 8, false);
      encoder0.encode(this.isLost, 16, 0);
    }
  }
}
