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

class ReportingApiObserver_Internal {
  public static final Interface.Manager<ReportingApiObserver, ReportingApiObserver.Proxy> MANAGER =
      new Interface.Manager<ReportingApiObserver, ReportingApiObserver.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.ReportingApiObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ReportingApiObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ReportingApiObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public ReportingApiObserver[] buildArray(int size) {
          return new ReportingApiObserver[size];
        }
      };
  private static final int ON_ENDPOINTS_UPDATED_FOR_ORIGIN_ORDINAL = 2;
  private static final int ON_REPORT_ADDED_ORDINAL = 0;
  private static final int ON_REPORT_UPDATED_ORDINAL = 1;

  ReportingApiObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ReportingApiObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onReportAdded(ReportingApiReport report) {
      ReportingApiObserverOnReportAddedParams _message =
          new ReportingApiObserverOnReportAddedParams();
      _message.report = report;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onReportUpdated(ReportingApiReport report) {
      ReportingApiObserverOnReportUpdatedParams _message =
          new ReportingApiObserverOnReportUpdatedParams();
      _message.report = report;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onEndpointsUpdatedForOrigin(ReportingApiEndpoint[] endpoints) {
      ReportingApiObserverOnEndpointsUpdatedForOriginParams _message =
          new ReportingApiObserverOnEndpointsUpdatedForOriginParams();
      _message.endpoints = endpoints;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<ReportingApiObserver> {
    Stub(Core core, ReportingApiObserver impl) {
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
                ReportingApiObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ReportingApiObserverOnReportAddedParams data =
                ReportingApiObserverOnReportAddedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onReportAdded(data.report);
            return true;
          case 1:
            ReportingApiObserverOnReportUpdatedParams data2 =
                ReportingApiObserverOnReportUpdatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onReportUpdated(data2.report);
            return true;
          case 2:
            ReportingApiObserverOnEndpointsUpdatedForOriginParams data3 =
                ReportingApiObserverOnEndpointsUpdatedForOriginParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onEndpointsUpdatedForOrigin(data3.endpoints);
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
                getCore(), ReportingApiObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ReportingApiObserverOnReportAddedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReportingApiReport report;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReportingApiObserverOnReportAddedParams(int version) {
      super(16, version);
    }

    public ReportingApiObserverOnReportAddedParams() {
      this(0);
    }

    public static ReportingApiObserverOnReportAddedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ReportingApiObserverOnReportAddedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReportingApiObserverOnReportAddedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReportingApiObserverOnReportAddedParams result =
            new ReportingApiObserverOnReportAddedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.report = ReportingApiReport.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.report, 8, false);
    }
  }

  static final class ReportingApiObserverOnReportUpdatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReportingApiReport report;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReportingApiObserverOnReportUpdatedParams(int version) {
      super(16, version);
    }

    public ReportingApiObserverOnReportUpdatedParams() {
      this(0);
    }

    public static ReportingApiObserverOnReportUpdatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ReportingApiObserverOnReportUpdatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReportingApiObserverOnReportUpdatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReportingApiObserverOnReportUpdatedParams result =
            new ReportingApiObserverOnReportUpdatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.report = ReportingApiReport.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.report, 8, false);
    }
  }

  static final class ReportingApiObserverOnEndpointsUpdatedForOriginParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReportingApiEndpoint[] endpoints;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReportingApiObserverOnEndpointsUpdatedForOriginParams(int version) {
      super(16, version);
    }

    public ReportingApiObserverOnEndpointsUpdatedForOriginParams() {
      this(0);
    }

    public static ReportingApiObserverOnEndpointsUpdatedForOriginParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ReportingApiObserverOnEndpointsUpdatedForOriginParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReportingApiObserverOnEndpointsUpdatedForOriginParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReportingApiObserverOnEndpointsUpdatedForOriginParams result =
            new ReportingApiObserverOnEndpointsUpdatedForOriginParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.endpoints = new ReportingApiEndpoint[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.endpoints[i1] = ReportingApiEndpoint.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      ReportingApiEndpoint[] reportingApiEndpointArr = this.endpoints;
      if (reportingApiEndpointArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(reportingApiEndpointArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ReportingApiEndpoint[] reportingApiEndpointArr2 = this.endpoints;
        if (i0 < reportingApiEndpointArr2.length) {
          encoder1.encode((Struct) reportingApiEndpointArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
