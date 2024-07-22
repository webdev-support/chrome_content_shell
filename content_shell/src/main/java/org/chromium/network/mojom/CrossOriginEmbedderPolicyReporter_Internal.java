package org.chromium.network.mojom;

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
import org.chromium.url.mojom.Url;

class CrossOriginEmbedderPolicyReporter_Internal {
  private static final int CLONE_ORDINAL = 1;
  public static final Interface.Manager<
          CrossOriginEmbedderPolicyReporter, CrossOriginEmbedderPolicyReporter.Proxy>
      MANAGER =
          new Interface.Manager<
              CrossOriginEmbedderPolicyReporter, CrossOriginEmbedderPolicyReporter.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.CrossOriginEmbedderPolicyReporter";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CrossOriginEmbedderPolicyReporter.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CrossOriginEmbedderPolicyReporter impl) {
              return new Stub(core, impl);
            }

            @Override
            public CrossOriginEmbedderPolicyReporter[] buildArray(int size) {
              return new CrossOriginEmbedderPolicyReporter[size];
            }
          };
  private static final int QUEUE_CORP_VIOLATION_REPORT_ORDINAL = 0;

  CrossOriginEmbedderPolicyReporter_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CrossOriginEmbedderPolicyReporter.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void queueCorpViolationReport(Url blockedUrl, int destination, boolean reportOnly) {
      CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams _message =
          new CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams();
      _message.blockedUrl = blockedUrl;
      _message.destination = destination;
      _message.reportOnly = reportOnly;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void clone(InterfaceRequest<CrossOriginEmbedderPolicyReporter> receiver) {
      CrossOriginEmbedderPolicyReporterCloneParams _message =
          new CrossOriginEmbedderPolicyReporterCloneParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<CrossOriginEmbedderPolicyReporter> {
    Stub(Core core, CrossOriginEmbedderPolicyReporter impl) {
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
                CrossOriginEmbedderPolicyReporter_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams data =
                CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().queueCorpViolationReport(data.blockedUrl, data.destination, data.reportOnly);
            return true;
          case 1:
            getImpl()
                .clone(
                    CrossOriginEmbedderPolicyReporterCloneParams.deserialize(
                            messageWithHeader.getPayload())
                        .receiver);
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
                CrossOriginEmbedderPolicyReporter_Internal.MANAGER,
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

  static final class CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url blockedUrl;
    public int destination;
    public boolean reportOnly;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams(int version) {
      super(24, version);
    }

    public CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams() {
      this(0);
    }

    public static CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams result =
            new CrossOriginEmbedderPolicyReporterQueueCorpViolationReportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.blockedUrl = Url.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.destination = readInt;
        RequestDestination.validate(readInt);
        result.destination = RequestDestination.toKnownValue(result.destination);
        result.reportOnly = decoder0.readBoolean(20, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.blockedUrl, 8, false);
      encoder0.encode(this.destination, 16);
      encoder0.encode(this.reportOnly, 20, 0);
    }
  }

  static final class CrossOriginEmbedderPolicyReporterCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<CrossOriginEmbedderPolicyReporter> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CrossOriginEmbedderPolicyReporterCloneParams(int version) {
      super(16, version);
    }

    public CrossOriginEmbedderPolicyReporterCloneParams() {
      this(0);
    }

    public static CrossOriginEmbedderPolicyReporterCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CrossOriginEmbedderPolicyReporterCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CrossOriginEmbedderPolicyReporterCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CrossOriginEmbedderPolicyReporterCloneParams result =
            new CrossOriginEmbedderPolicyReporterCloneParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }
}
