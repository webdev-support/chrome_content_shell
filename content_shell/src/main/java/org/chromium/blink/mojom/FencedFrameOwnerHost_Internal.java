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
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.url.mojom.Url;

class FencedFrameOwnerHost_Internal {
  private static final int DID_CHANGE_FRAME_POLICY_ORDINAL = 1;
  public static final Interface.Manager<FencedFrameOwnerHost, FencedFrameOwnerHost.Proxy> MANAGER =
      new Interface.Manager<FencedFrameOwnerHost, FencedFrameOwnerHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FencedFrameOwnerHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FencedFrameOwnerHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FencedFrameOwnerHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public FencedFrameOwnerHost[] buildArray(int size) {
          return new FencedFrameOwnerHost[size];
        }
      };
  private static final int NAVIGATE_ORDINAL = 0;

  FencedFrameOwnerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FencedFrameOwnerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void navigate(
        Url url, TimeTicks navigationStartTime, String16 embedderSharedStorageContext) {
      FencedFrameOwnerHostNavigateParams _message = new FencedFrameOwnerHostNavigateParams();
      _message.url = url;
      _message.navigationStartTime = navigationStartTime;
      _message.embedderSharedStorageContext = embedderSharedStorageContext;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void didChangeFramePolicy(FramePolicy framePolicy) {
      FencedFrameOwnerHostDidChangeFramePolicyParams _message =
          new FencedFrameOwnerHostDidChangeFramePolicyParams();
      _message.framePolicy = framePolicy;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<FencedFrameOwnerHost> {
    Stub(Core core, FencedFrameOwnerHost impl) {
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
                FencedFrameOwnerHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FencedFrameOwnerHostNavigateParams data =
                FencedFrameOwnerHostNavigateParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .navigate(data.url, data.navigationStartTime, data.embedderSharedStorageContext);
            return true;
          case 1:
            getImpl()
                .didChangeFramePolicy(
                    FencedFrameOwnerHostDidChangeFramePolicyParams.deserialize(
                            messageWithHeader.getPayload())
                        .framePolicy);
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
                getCore(), FencedFrameOwnerHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FencedFrameOwnerHostNavigateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 embedderSharedStorageContext;
    public TimeTicks navigationStartTime;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FencedFrameOwnerHostNavigateParams(int version) {
      super(32, version);
    }

    public FencedFrameOwnerHostNavigateParams() {
      this(0);
    }

    public static FencedFrameOwnerHostNavigateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FencedFrameOwnerHostNavigateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FencedFrameOwnerHostNavigateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FencedFrameOwnerHostNavigateParams result =
            new FencedFrameOwnerHostNavigateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.navigationStartTime = TimeTicks.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.embedderSharedStorageContext = String16.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.navigationStartTime, 16, false);
      encoder0.encode((Struct) this.embedderSharedStorageContext, 24, true);
    }
  }

  static final class FencedFrameOwnerHostDidChangeFramePolicyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FramePolicy framePolicy;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FencedFrameOwnerHostDidChangeFramePolicyParams(int version) {
      super(16, version);
    }

    public FencedFrameOwnerHostDidChangeFramePolicyParams() {
      this(0);
    }

    public static FencedFrameOwnerHostDidChangeFramePolicyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FencedFrameOwnerHostDidChangeFramePolicyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FencedFrameOwnerHostDidChangeFramePolicyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FencedFrameOwnerHostDidChangeFramePolicyParams result =
            new FencedFrameOwnerHostDidChangeFramePolicyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.framePolicy = FramePolicy.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.framePolicy, 8, false);
    }
  }
}
