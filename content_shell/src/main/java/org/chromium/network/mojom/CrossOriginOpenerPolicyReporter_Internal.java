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

class CrossOriginOpenerPolicyReporter_Internal {
  public static final Interface.Manager<
          CrossOriginOpenerPolicyReporter, CrossOriginOpenerPolicyReporter.Proxy>
      MANAGER =
          new Interface.Manager<
              CrossOriginOpenerPolicyReporter, CrossOriginOpenerPolicyReporter.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.CrossOriginOpenerPolicyReporter";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CrossOriginOpenerPolicyReporter.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CrossOriginOpenerPolicyReporter impl) {
              return new Stub(core, impl);
            }

            @Override
            public CrossOriginOpenerPolicyReporter[] buildArray(int size) {
              return new CrossOriginOpenerPolicyReporter[size];
            }
          };
  private static final int QUEUE_ACCESS_REPORT_ORDINAL = 0;

  CrossOriginOpenerPolicyReporter_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CrossOriginOpenerPolicyReporter.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void queueAccessReport(
        int reportType, String property, SourceLocation sourceLocation, String reportedWindowUrl) {
      CrossOriginOpenerPolicyReporterQueueAccessReportParams _message =
          new CrossOriginOpenerPolicyReporterQueueAccessReportParams();
      _message.reportType = reportType;
      _message.property = property;
      _message.sourceLocation = sourceLocation;
      _message.reportedWindowUrl = reportedWindowUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<CrossOriginOpenerPolicyReporter> {
    Stub(Core core, CrossOriginOpenerPolicyReporter impl) {
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
                CrossOriginOpenerPolicyReporter_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CrossOriginOpenerPolicyReporterQueueAccessReportParams data =
                CrossOriginOpenerPolicyReporterQueueAccessReportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .queueAccessReport(
                    data.reportType, data.property, data.sourceLocation, data.reportedWindowUrl);
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
                CrossOriginOpenerPolicyReporter_Internal.MANAGER,
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

  static final class CrossOriginOpenerPolicyReporterQueueAccessReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public String property;
    public int reportType;
    public String reportedWindowUrl;
    public SourceLocation sourceLocation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CrossOriginOpenerPolicyReporterQueueAccessReportParams(int version) {
      super(40, version);
    }

    public CrossOriginOpenerPolicyReporterQueueAccessReportParams() {
      this(0);
    }

    public static CrossOriginOpenerPolicyReporterQueueAccessReportParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CrossOriginOpenerPolicyReporterQueueAccessReportParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CrossOriginOpenerPolicyReporterQueueAccessReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CrossOriginOpenerPolicyReporterQueueAccessReportParams result =
            new CrossOriginOpenerPolicyReporterQueueAccessReportParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.reportType = readInt;
        CoopAccessReportType.validate(readInt);
        result.reportType = CoopAccessReportType.toKnownValue(result.reportType);
        result.property = decoder0.readString(16, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.sourceLocation = SourceLocation.decode(decoder1);
        result.reportedWindowUrl = decoder0.readString(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reportType, 8);
      encoder0.encode(this.property, 16, false);
      encoder0.encode((Struct) this.sourceLocation, 24, false);
      encoder0.encode(this.reportedWindowUrl, 32, false);
    }
  }
}
