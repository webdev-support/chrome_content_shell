package org.chromium.cc.mojom;

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

class RenderFrameMetadataObserver_Internal {
  public static final Interface.Manager<
          RenderFrameMetadataObserver, RenderFrameMetadataObserver.Proxy>
      MANAGER =
          new Interface.Manager<RenderFrameMetadataObserver, RenderFrameMetadataObserver.Proxy>() {
            @Override
            public String getName() {
              return "cc.mojom.RenderFrameMetadataObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public RenderFrameMetadataObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, RenderFrameMetadataObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public RenderFrameMetadataObserver[] buildArray(int size) {
              return new RenderFrameMetadataObserver[size];
            }
          };
  private static final int REPORT_ALL_FRAME_SUBMISSIONS_FOR_TESTING_ORDINAL = 1;
  private static final int UPDATE_ROOT_SCROLL_OFFSET_UPDATE_FREQUENCY_ORDINAL = 0;

  RenderFrameMetadataObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RenderFrameMetadataObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void updateRootScrollOffsetUpdateFrequency(int frequency) {
      RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams _message =
          new RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams();
      _message.frequency = frequency;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void reportAllFrameSubmissionsForTesting(boolean enabled) {
      RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams _message =
          new RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams();
      _message.enabled = enabled;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<RenderFrameMetadataObserver> {
    Stub(Core core, RenderFrameMetadataObserver impl) {
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
                RenderFrameMetadataObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams data =
                RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateRootScrollOffsetUpdateFrequency(data.frequency);
            return true;
          case 1:
            RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams data2 =
                RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportAllFrameSubmissionsForTesting(data2.enabled);
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
                RenderFrameMetadataObserver_Internal.MANAGER,
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

  static final class RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int frequency;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams(int version) {
      super(16, version);
    }

    public RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams() {
      this(0);
    }

    public static RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams result =
            new RenderFrameMetadataObserverUpdateRootScrollOffsetUpdateFrequencyParams(
                elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.frequency = readInt;
        RootScrollOffsetUpdateFrequency.validate(readInt);
        result.frequency = RootScrollOffsetUpdateFrequency.toKnownValue(result.frequency);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.frequency, 8);
    }
  }

  static final class RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enabled;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams(int version) {
      super(16, version);
    }

    public RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams() {
      this(0);
    }

    public static RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams result =
            new RenderFrameMetadataObserverReportAllFrameSubmissionsForTestingParams(
                elementsOrVersion);
        result.enabled = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enabled, 8, 0);
    }
  }
}
