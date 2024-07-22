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

class PrivateAggregationHost_Internal {
  private static final int CONTRIBUTE_TO_HISTOGRAM_ORDINAL = 0;
  private static final int ENABLE_DEBUG_MODE_ORDINAL = 1;
  public static final Interface.Manager<PrivateAggregationHost, PrivateAggregationHost.Proxy>
      MANAGER =
          new Interface.Manager<PrivateAggregationHost, PrivateAggregationHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.PrivateAggregationHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PrivateAggregationHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PrivateAggregationHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public PrivateAggregationHost[] buildArray(int size) {
              return new PrivateAggregationHost[size];
            }
          };

  PrivateAggregationHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PrivateAggregationHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void contributeToHistogram(AggregatableReportHistogramContribution[] contributions) {
      PrivateAggregationHostContributeToHistogramParams _message =
          new PrivateAggregationHostContributeToHistogramParams();
      _message.contributions = contributions;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void enableDebugMode(DebugKey debugKey) {
      PrivateAggregationHostEnableDebugModeParams _message =
          new PrivateAggregationHostEnableDebugModeParams();
      _message.debugKey = debugKey;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<PrivateAggregationHost> {
    Stub(Core core, PrivateAggregationHost impl) {
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
                PrivateAggregationHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PrivateAggregationHostContributeToHistogramParams data =
                PrivateAggregationHostContributeToHistogramParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().contributeToHistogram(data.contributions);
            return true;
          case 1:
            PrivateAggregationHostEnableDebugModeParams data2 =
                PrivateAggregationHostEnableDebugModeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().enableDebugMode(data2.debugKey);
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
                getCore(), PrivateAggregationHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PrivateAggregationHostContributeToHistogramParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AggregatableReportHistogramContribution[] contributions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PrivateAggregationHostContributeToHistogramParams(int version) {
      super(16, version);
    }

    public PrivateAggregationHostContributeToHistogramParams() {
      this(0);
    }

    public static PrivateAggregationHostContributeToHistogramParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PrivateAggregationHostContributeToHistogramParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PrivateAggregationHostContributeToHistogramParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PrivateAggregationHostContributeToHistogramParams result =
            new PrivateAggregationHostContributeToHistogramParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.contributions = new AggregatableReportHistogramContribution[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.contributions[i1] = AggregatableReportHistogramContribution.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      AggregatableReportHistogramContribution[] aggregatableReportHistogramContributionArr =
          this.contributions;
      if (aggregatableReportHistogramContributionArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 =
          encoder0.encodePointerArray(aggregatableReportHistogramContributionArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        AggregatableReportHistogramContribution[] aggregatableReportHistogramContributionArr2 =
            this.contributions;
        if (i0 < aggregatableReportHistogramContributionArr2.length) {
          encoder1.encode(
              (Struct) aggregatableReportHistogramContributionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class PrivateAggregationHostEnableDebugModeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DebugKey debugKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PrivateAggregationHostEnableDebugModeParams(int version) {
      super(16, version);
    }

    public PrivateAggregationHostEnableDebugModeParams() {
      this(0);
    }

    public static PrivateAggregationHostEnableDebugModeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PrivateAggregationHostEnableDebugModeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PrivateAggregationHostEnableDebugModeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PrivateAggregationHostEnableDebugModeParams result =
            new PrivateAggregationHostEnableDebugModeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.debugKey = DebugKey.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.debugKey, 8, true);
    }
  }
}
