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
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

class ReportingServiceProxy_Internal {
  public static final Interface.Manager<ReportingServiceProxy, ReportingServiceProxy.Proxy>
      MANAGER =
          new Interface.Manager<ReportingServiceProxy, ReportingServiceProxy.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ReportingServiceProxy";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ReportingServiceProxy.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ReportingServiceProxy impl) {
              return new Stub(core, impl);
            }

            @Override
            public ReportingServiceProxy[] buildArray(int size) {
              return new ReportingServiceProxy[size];
            }
          };
  private static final int QUEUE_CSP_VIOLATION_REPORT_ORDINAL = 2;
  private static final int QUEUE_DEPRECATION_REPORT_ORDINAL = 1;
  private static final int QUEUE_DOCUMENT_POLICY_VIOLATION_REPORT_ORDINAL = 4;
  private static final int QUEUE_INTERVENTION_REPORT_ORDINAL = 0;
  private static final int QUEUE_PERMISSIONS_POLICY_VIOLATION_REPORT_ORDINAL = 3;

  ReportingServiceProxy_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ReportingServiceProxy.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void queueInterventionReport(
        Url url, String id, String message, String sourceFile, int lineNumber, int columnNumber) {
      ReportingServiceProxyQueueInterventionReportParams _message =
          new ReportingServiceProxyQueueInterventionReportParams();
      _message.url = url;
      _message.id = id;
      _message.message = message;
      _message.sourceFile = sourceFile;
      _message.lineNumber = lineNumber;
      _message.columnNumber = columnNumber;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void queueDeprecationReport(
        Url url,
        String id,
        Time anticipatedRemoval,
        String message,
        String sourceFile,
        int lineNumber,
        int columnNumber) {
      ReportingServiceProxyQueueDeprecationReportParams _message =
          new ReportingServiceProxyQueueDeprecationReportParams();
      _message.url = url;
      _message.id = id;
      _message.anticipatedRemoval = anticipatedRemoval;
      _message.message = message;
      _message.sourceFile = sourceFile;
      _message.lineNumber = lineNumber;
      _message.columnNumber = columnNumber;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void queueCspViolationReport(
        Url url,
        String group,
        String documentUrl,
        String referrer,
        String blockedUrl,
        String effectiveDirective,
        String originalPolicy,
        String sourceFile,
        String scriptSample,
        String disposition,
        short statusCode,
        int lineNumber,
        int columnNumber) {
      ReportingServiceProxyQueueCspViolationReportParams _message =
          new ReportingServiceProxyQueueCspViolationReportParams();
      _message.url = url;
      _message.group = group;
      _message.documentUrl = documentUrl;
      _message.referrer = referrer;
      _message.blockedUrl = blockedUrl;
      _message.effectiveDirective = effectiveDirective;
      _message.originalPolicy = originalPolicy;
      _message.sourceFile = sourceFile;
      _message.scriptSample = scriptSample;
      _message.disposition = disposition;
      _message.statusCode = statusCode;
      _message.lineNumber = lineNumber;
      _message.columnNumber = columnNumber;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void queuePermissionsPolicyViolationReport(
        Url url,
        String endpoint,
        String policyId,
        String disposition,
        String message,
        String sourceFile,
        int lineNumber,
        int columnNumber) {
      ReportingServiceProxyQueuePermissionsPolicyViolationReportParams _message =
          new ReportingServiceProxyQueuePermissionsPolicyViolationReportParams();
      _message.url = url;
      _message.endpoint = endpoint;
      _message.policyId = policyId;
      _message.disposition = disposition;
      _message.message = message;
      _message.sourceFile = sourceFile;
      _message.lineNumber = lineNumber;
      _message.columnNumber = columnNumber;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void queueDocumentPolicyViolationReport(
        Url url,
        String group,
        String policyId,
        String disposition,
        String message,
        String sourceFile,
        int lineNumber,
        int columnNumber) {
      ReportingServiceProxyQueueDocumentPolicyViolationReportParams _message =
          new ReportingServiceProxyQueueDocumentPolicyViolationReportParams();
      _message.url = url;
      _message.group = group;
      _message.policyId = policyId;
      _message.disposition = disposition;
      _message.message = message;
      _message.sourceFile = sourceFile;
      _message.lineNumber = lineNumber;
      _message.columnNumber = columnNumber;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<ReportingServiceProxy> {
    Stub(Core core, ReportingServiceProxy impl) {
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
                ReportingServiceProxy_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ReportingServiceProxyQueueInterventionReportParams data =
                ReportingServiceProxyQueueInterventionReportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .queueInterventionReport(
                    data.url,
                    data.id,
                    data.message,
                    data.sourceFile,
                    data.lineNumber,
                    data.columnNumber);
            return true;
          case 1:
            ReportingServiceProxyQueueDeprecationReportParams data2 =
                ReportingServiceProxyQueueDeprecationReportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .queueDeprecationReport(
                    data2.url,
                    data2.id,
                    data2.anticipatedRemoval,
                    data2.message,
                    data2.sourceFile,
                    data2.lineNumber,
                    data2.columnNumber);
            return true;
          case 2:
            ReportingServiceProxyQueueCspViolationReportParams data3 =
                ReportingServiceProxyQueueCspViolationReportParams.deserialize(
                    messageWithHeader.getPayload());
            ReportingServiceProxy impl = getImpl();
            Url url = data3.url;
            String str = data3.group;
            String str2 = data3.documentUrl;
            String str3 = data3.referrer;
            String str4 = data3.blockedUrl;
            String str5 = data3.effectiveDirective;
            String str6 = data3.originalPolicy;
            String str7 = data3.sourceFile;
            String str8 = data3.scriptSample;
            String str9 = data3.disposition;
            short s = data3.statusCode;
            int i = data3.lineNumber;
            int flags2 = data3.columnNumber;
            impl.queueCspViolationReport(
                url, str, str2, str3, str4, str5, str6, str7, str8, str9, s, i, flags2);
            return true;
          case 3:
            ReportingServiceProxyQueuePermissionsPolicyViolationReportParams data4 =
                ReportingServiceProxyQueuePermissionsPolicyViolationReportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .queuePermissionsPolicyViolationReport(
                    data4.url,
                    data4.endpoint,
                    data4.policyId,
                    data4.disposition,
                    data4.message,
                    data4.sourceFile,
                    data4.lineNumber,
                    data4.columnNumber);
            return true;
          case 4:
            ReportingServiceProxyQueueDocumentPolicyViolationReportParams data5 =
                ReportingServiceProxyQueueDocumentPolicyViolationReportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .queueDocumentPolicyViolationReport(
                    data5.url,
                    data5.group,
                    data5.policyId,
                    data5.disposition,
                    data5.message,
                    data5.sourceFile,
                    data5.lineNumber,
                    data5.columnNumber);
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
                getCore(), ReportingServiceProxy_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ReportingServiceProxyQueueInterventionReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public int columnNumber;
    public String id;
    public int lineNumber;
    public String message;
    public String sourceFile;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReportingServiceProxyQueueInterventionReportParams(int version) {
      super(48, version);
    }

    public ReportingServiceProxyQueueInterventionReportParams() {
      this(0);
    }

    public static ReportingServiceProxyQueueInterventionReportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ReportingServiceProxyQueueInterventionReportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReportingServiceProxyQueueInterventionReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReportingServiceProxyQueueInterventionReportParams result =
            new ReportingServiceProxyQueueInterventionReportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.id = decoder0.readString(16, false);
        result.message = decoder0.readString(24, false);
        result.sourceFile = decoder0.readString(32, true);
        result.lineNumber = decoder0.readInt(40);
        result.columnNumber = decoder0.readInt(44);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.id, 16, false);
      encoder0.encode(this.message, 24, false);
      encoder0.encode(this.sourceFile, 32, true);
      encoder0.encode(this.lineNumber, 40);
      encoder0.encode(this.columnNumber, 44);
    }
  }

  static final class ReportingServiceProxyQueueDeprecationReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public Time anticipatedRemoval;
    public int columnNumber;
    public String id;
    public int lineNumber;
    public String message;
    public String sourceFile;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReportingServiceProxyQueueDeprecationReportParams(int version) {
      super(56, version);
    }

    public ReportingServiceProxyQueueDeprecationReportParams() {
      this(0);
    }

    public static ReportingServiceProxyQueueDeprecationReportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ReportingServiceProxyQueueDeprecationReportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReportingServiceProxyQueueDeprecationReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReportingServiceProxyQueueDeprecationReportParams result =
            new ReportingServiceProxyQueueDeprecationReportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.id = decoder0.readString(16, false);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.anticipatedRemoval = Time.decode(decoder12);
        result.message = decoder0.readString(32, false);
        result.sourceFile = decoder0.readString(40, true);
        result.lineNumber = decoder0.readInt(48);
        result.columnNumber = decoder0.readInt(52);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.id, 16, false);
      encoder0.encode((Struct) this.anticipatedRemoval, 24, true);
      encoder0.encode(this.message, 32, false);
      encoder0.encode(this.sourceFile, 40, true);
      encoder0.encode(this.lineNumber, 48);
      encoder0.encode(this.columnNumber, 52);
    }
  }

  static final class ReportingServiceProxyQueueCspViolationReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 104;
    private static final DataHeader[] VERSION_ARRAY;
    public String blockedUrl;
    public int columnNumber;
    public String disposition;
    public String documentUrl;
    public String effectiveDirective;
    public String group;
    public int lineNumber;
    public String originalPolicy;
    public String referrer;
    public String scriptSample;
    public String sourceFile;
    public short statusCode;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(104, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReportingServiceProxyQueueCspViolationReportParams(int version) {
      super(104, version);
    }

    public ReportingServiceProxyQueueCspViolationReportParams() {
      this(0);
    }

    public static ReportingServiceProxyQueueCspViolationReportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ReportingServiceProxyQueueCspViolationReportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReportingServiceProxyQueueCspViolationReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReportingServiceProxyQueueCspViolationReportParams result =
            new ReportingServiceProxyQueueCspViolationReportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.group = decoder0.readString(16, false);
        result.documentUrl = decoder0.readString(24, false);
        result.referrer = decoder0.readString(32, true);
        result.blockedUrl = decoder0.readString(40, true);
        result.effectiveDirective = decoder0.readString(48, false);
        result.originalPolicy = decoder0.readString(56, false);
        result.sourceFile = decoder0.readString(64, true);
        result.scriptSample = decoder0.readString(72, true);
        result.disposition = decoder0.readString(80, false);
        result.statusCode = decoder0.readShort(88);
        result.lineNumber = decoder0.readInt(92);
        result.columnNumber = decoder0.readInt(96);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.group, 16, false);
      encoder0.encode(this.documentUrl, 24, false);
      encoder0.encode(this.referrer, 32, true);
      encoder0.encode(this.blockedUrl, 40, true);
      encoder0.encode(this.effectiveDirective, 48, false);
      encoder0.encode(this.originalPolicy, 56, false);
      encoder0.encode(this.sourceFile, 64, true);
      encoder0.encode(this.scriptSample, 72, true);
      encoder0.encode(this.disposition, 80, false);
      encoder0.encode(this.statusCode, 88);
      encoder0.encode(this.lineNumber, 92);
      encoder0.encode(this.columnNumber, 96);
    }
  }

  static final class ReportingServiceProxyQueuePermissionsPolicyViolationReportParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY;
    public int columnNumber;
    public String disposition;
    public String endpoint;
    public int lineNumber;
    public String message;
    public String policyId;
    public String sourceFile;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReportingServiceProxyQueuePermissionsPolicyViolationReportParams(int version) {
      super(64, version);
    }

    public ReportingServiceProxyQueuePermissionsPolicyViolationReportParams() {
      this(0);
    }

    public static ReportingServiceProxyQueuePermissionsPolicyViolationReportParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ReportingServiceProxyQueuePermissionsPolicyViolationReportParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReportingServiceProxyQueuePermissionsPolicyViolationReportParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReportingServiceProxyQueuePermissionsPolicyViolationReportParams result =
            new ReportingServiceProxyQueuePermissionsPolicyViolationReportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.endpoint = decoder0.readString(16, false);
        result.policyId = decoder0.readString(24, false);
        result.disposition = decoder0.readString(32, false);
        result.message = decoder0.readString(40, true);
        result.sourceFile = decoder0.readString(48, true);
        result.lineNumber = decoder0.readInt(56);
        result.columnNumber = decoder0.readInt(60);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.endpoint, 16, false);
      encoder0.encode(this.policyId, 24, false);
      encoder0.encode(this.disposition, 32, false);
      encoder0.encode(this.message, 40, true);
      encoder0.encode(this.sourceFile, 48, true);
      encoder0.encode(this.lineNumber, 56);
      encoder0.encode(this.columnNumber, 60);
    }
  }

  static final class ReportingServiceProxyQueueDocumentPolicyViolationReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY;
    public int columnNumber;
    public String disposition;
    public String group;
    public int lineNumber;
    public String message;
    public String policyId;
    public String sourceFile;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReportingServiceProxyQueueDocumentPolicyViolationReportParams(int version) {
      super(64, version);
    }

    public ReportingServiceProxyQueueDocumentPolicyViolationReportParams() {
      this(0);
    }

    public static ReportingServiceProxyQueueDocumentPolicyViolationReportParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ReportingServiceProxyQueueDocumentPolicyViolationReportParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReportingServiceProxyQueueDocumentPolicyViolationReportParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReportingServiceProxyQueueDocumentPolicyViolationReportParams result =
            new ReportingServiceProxyQueueDocumentPolicyViolationReportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.group = decoder0.readString(16, false);
        result.policyId = decoder0.readString(24, false);
        result.disposition = decoder0.readString(32, false);
        result.message = decoder0.readString(40, true);
        result.sourceFile = decoder0.readString(48, true);
        result.lineNumber = decoder0.readInt(56);
        result.columnNumber = decoder0.readInt(60);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.group, 16, false);
      encoder0.encode(this.policyId, 24, false);
      encoder0.encode(this.disposition, 32, false);
      encoder0.encode(this.message, 40, true);
      encoder0.encode(this.sourceFile, 48, true);
      encoder0.encode(this.lineNumber, 56);
      encoder0.encode(this.columnNumber, 60);
    }
  }
}
