package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

class EmbeddedWorkerInstanceHost_Internal {
  private static final int COUNT_FEATURE_ORDINAL = 1;
  public static final Interface.Manager<
          EmbeddedWorkerInstanceHost, EmbeddedWorkerInstanceHost.Proxy>
      MANAGER =
          new Interface.Manager<EmbeddedWorkerInstanceHost, EmbeddedWorkerInstanceHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.EmbeddedWorkerInstanceHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public EmbeddedWorkerInstanceHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, EmbeddedWorkerInstanceHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public EmbeddedWorkerInstanceHost[] buildArray(int size) {
              return new EmbeddedWorkerInstanceHost[size];
            }
          };
  private static final int ON_READY_FOR_INSPECTION_ORDINAL = 2;
  private static final int ON_REPORT_CONSOLE_MESSAGE_ORDINAL = 7;
  private static final int ON_REPORT_EXCEPTION_ORDINAL = 6;
  private static final int ON_SCRIPT_EVALUATION_START_ORDINAL = 4;
  private static final int ON_SCRIPT_LOADED_ORDINAL = 3;
  private static final int ON_STARTED_ORDINAL = 5;
  private static final int ON_STOPPED_ORDINAL = 8;
  private static final int REQUEST_TERMINATION_ORDINAL = 0;

  EmbeddedWorkerInstanceHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements EmbeddedWorkerInstanceHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestTermination(RequestTermination_Response callback) {
      EmbeddedWorkerInstanceHostRequestTerminationParams _message =
          new EmbeddedWorkerInstanceHostRequestTerminationParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new EmbeddedWorkerInstanceHostRequestTerminationResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void countFeature(int feature) {
      EmbeddedWorkerInstanceHostCountFeatureParams _message =
          new EmbeddedWorkerInstanceHostCountFeatureParams();
      _message.feature = feature;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onReadyForInspection(
        DevToolsAgent agent, InterfaceRequest<DevToolsAgentHost> agentHost) {
      EmbeddedWorkerInstanceHostOnReadyForInspectionParams _message =
          new EmbeddedWorkerInstanceHostOnReadyForInspectionParams();
      _message.agent = agent;
      _message.agentHost = agentHost;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onScriptLoaded() {
      EmbeddedWorkerInstanceHostOnScriptLoadedParams _message =
          new EmbeddedWorkerInstanceHostOnScriptLoadedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onScriptEvaluationStart() {
      EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams _message =
          new EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onStarted(
        int status,
        int fetchHandlerType,
        boolean hasHidEventHandlers,
        boolean hasUsbEventHandlers,
        int threadId,
        EmbeddedWorkerStartTiming startTiming) {
      EmbeddedWorkerInstanceHostOnStartedParams _message =
          new EmbeddedWorkerInstanceHostOnStartedParams();
      _message.status = status;
      _message.fetchHandlerType = fetchHandlerType;
      _message.hasHidEventHandlers = hasHidEventHandlers;
      _message.hasUsbEventHandlers = hasUsbEventHandlers;
      _message.threadId = threadId;
      _message.startTiming = startTiming;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void onReportException(
        String16 errorMessage, int lineNumber, int columnNumber, Url sourceUrl) {
      EmbeddedWorkerInstanceHostOnReportExceptionParams _message =
          new EmbeddedWorkerInstanceHostOnReportExceptionParams();
      _message.errorMessage = errorMessage;
      _message.lineNumber = lineNumber;
      _message.columnNumber = columnNumber;
      _message.sourceUrl = sourceUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void onReportConsoleMessage(
        int source, int messageLevel, String16 message, int lineNumber, Url sourceUrl) {
      EmbeddedWorkerInstanceHostOnReportConsoleMessageParams _message =
          new EmbeddedWorkerInstanceHostOnReportConsoleMessageParams();
      _message.source = source;
      _message.messageLevel = messageLevel;
      _message.message = message;
      _message.lineNumber = lineNumber;
      _message.sourceUrl = sourceUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void onStopped() {
      EmbeddedWorkerInstanceHostOnStoppedParams _message =
          new EmbeddedWorkerInstanceHostOnStoppedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<EmbeddedWorkerInstanceHost> {
    Stub(Core core, EmbeddedWorkerInstanceHost impl) {
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
                EmbeddedWorkerInstanceHost_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          default:
            return false;
          case 1:
            getImpl()
                .countFeature(
                    EmbeddedWorkerInstanceHostCountFeatureParams.deserialize(
                            messageWithHeader.getPayload())
                        .feature);
            return true;
          case 2:
            EmbeddedWorkerInstanceHostOnReadyForInspectionParams data =
                EmbeddedWorkerInstanceHostOnReadyForInspectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onReadyForInspection(data.agent, data.agentHost);
            return true;
          case 3:
            EmbeddedWorkerInstanceHostOnScriptLoadedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onScriptLoaded();
            return true;
          case 4:
            EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onScriptEvaluationStart();
            return true;
          case 5:
            EmbeddedWorkerInstanceHostOnStartedParams data2 =
                EmbeddedWorkerInstanceHostOnStartedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onStarted(
                    data2.status,
                    data2.fetchHandlerType,
                    data2.hasHidEventHandlers,
                    data2.hasUsbEventHandlers,
                    data2.threadId,
                    data2.startTiming);
            return true;
          case 6:
            EmbeddedWorkerInstanceHostOnReportExceptionParams data3 =
                EmbeddedWorkerInstanceHostOnReportExceptionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onReportException(
                    data3.errorMessage, data3.lineNumber, data3.columnNumber, data3.sourceUrl);
            return true;
          case 7:
            EmbeddedWorkerInstanceHostOnReportConsoleMessageParams data4 =
                EmbeddedWorkerInstanceHostOnReportConsoleMessageParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onReportConsoleMessage(
                    data4.source,
                    data4.messageLevel,
                    data4.message,
                    data4.lineNumber,
                    data4.sourceUrl);
            return true;
          case 8:
            EmbeddedWorkerInstanceHostOnStoppedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onStopped();
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
                EmbeddedWorkerInstanceHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            EmbeddedWorkerInstanceHostRequestTerminationParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .requestTermination(
                    new EmbeddedWorkerInstanceHostRequestTerminationResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class EmbeddedWorkerInstanceHostRequestTerminationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostRequestTerminationParams(int version) {
      super(8, version);
    }

    public EmbeddedWorkerInstanceHostRequestTerminationParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostRequestTerminationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostRequestTerminationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostRequestTerminationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostRequestTerminationParams result =
            new EmbeddedWorkerInstanceHostRequestTerminationParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class EmbeddedWorkerInstanceHostRequestTerminationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean willBeTerminated;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostRequestTerminationResponseParams(int version) {
      super(16, version);
    }

    public EmbeddedWorkerInstanceHostRequestTerminationResponseParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostRequestTerminationResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostRequestTerminationResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostRequestTerminationResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostRequestTerminationResponseParams result =
            new EmbeddedWorkerInstanceHostRequestTerminationResponseParams(elementsOrVersion);
        result.willBeTerminated = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.willBeTerminated, 8, 0);
    }
  }

  static class EmbeddedWorkerInstanceHostRequestTerminationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final EmbeddedWorkerInstanceHost.RequestTermination_Response mCallback;

    EmbeddedWorkerInstanceHostRequestTerminationResponseParamsForwardToCallback(
        EmbeddedWorkerInstanceHost.RequestTermination_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        EmbeddedWorkerInstanceHostRequestTerminationResponseParams response =
            EmbeddedWorkerInstanceHostRequestTerminationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.willBeTerminated);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class EmbeddedWorkerInstanceHostRequestTerminationResponseParamsProxyToResponder
      implements EmbeddedWorkerInstanceHost.RequestTermination_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    EmbeddedWorkerInstanceHostRequestTerminationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean willBeTerminated) {
      EmbeddedWorkerInstanceHostRequestTerminationResponseParams _response =
          new EmbeddedWorkerInstanceHostRequestTerminationResponseParams();
      _response.willBeTerminated = willBeTerminated;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class EmbeddedWorkerInstanceHostCountFeatureParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int feature;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostCountFeatureParams(int version) {
      super(16, version);
    }

    public EmbeddedWorkerInstanceHostCountFeatureParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostCountFeatureParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostCountFeatureParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostCountFeatureParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostCountFeatureParams result =
            new EmbeddedWorkerInstanceHostCountFeatureParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.feature = readInt;
        WebFeature.validate(readInt);
        result.feature = WebFeature.toKnownValue(result.feature);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.feature, 8);
    }
  }

  static final class EmbeddedWorkerInstanceHostOnReadyForInspectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DevToolsAgent agent;
    public InterfaceRequest<DevToolsAgentHost> agentHost;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostOnReadyForInspectionParams(int version) {
      super(24, version);
    }

    public EmbeddedWorkerInstanceHostOnReadyForInspectionParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostOnReadyForInspectionParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostOnReadyForInspectionParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostOnReadyForInspectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostOnReadyForInspectionParams result =
            new EmbeddedWorkerInstanceHostOnReadyForInspectionParams(elementsOrVersion);
        result.agent =
            (DevToolsAgent) decoder0.readServiceInterface(8, false, DevToolsAgent.MANAGER);
        result.agentHost = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.agent, 8, false, DevToolsAgent.MANAGER);
      encoder0.encode((InterfaceRequest) this.agentHost, 16, false);
    }
  }

  static final class EmbeddedWorkerInstanceHostOnScriptLoadedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostOnScriptLoadedParams(int version) {
      super(8, version);
    }

    public EmbeddedWorkerInstanceHostOnScriptLoadedParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostOnScriptLoadedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostOnScriptLoadedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostOnScriptLoadedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostOnScriptLoadedParams result =
            new EmbeddedWorkerInstanceHostOnScriptLoadedParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams(int version) {
      super(8, version);
    }

    public EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams result =
            new EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class EmbeddedWorkerInstanceHostOnStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int fetchHandlerType;
    public boolean hasHidEventHandlers;
    public boolean hasUsbEventHandlers;
    public EmbeddedWorkerStartTiming startTiming;
    public int status;
    public int threadId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostOnStartedParams(int version) {
      super(32, version);
    }

    public EmbeddedWorkerInstanceHostOnStartedParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostOnStartedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostOnStartedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostOnStartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostOnStartedParams result =
            new EmbeddedWorkerInstanceHostOnStartedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerStartStatus.validate(readInt);
        result.status = ServiceWorkerStartStatus.toKnownValue(result.status);
        int readInt2 = decoder0.readInt(12);
        result.fetchHandlerType = readInt2;
        ServiceWorkerFetchHandlerType.validate(readInt2);
        result.fetchHandlerType =
            ServiceWorkerFetchHandlerType.toKnownValue(result.fetchHandlerType);
        result.hasHidEventHandlers = decoder0.readBoolean(16, 0);
        result.hasUsbEventHandlers = decoder0.readBoolean(16, 1);
        result.threadId = decoder0.readInt(20);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.startTiming = EmbeddedWorkerStartTiming.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.fetchHandlerType, 12);
      encoder0.encode(this.hasHidEventHandlers, 16, 0);
      encoder0.encode(this.hasUsbEventHandlers, 16, 1);
      encoder0.encode(this.threadId, 20);
      encoder0.encode((Struct) this.startTiming, 24, false);
    }
  }

  static final class EmbeddedWorkerInstanceHostOnReportExceptionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int columnNumber;
    public String16 errorMessage;
    public int lineNumber;
    public Url sourceUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostOnReportExceptionParams(int version) {
      super(32, version);
    }

    public EmbeddedWorkerInstanceHostOnReportExceptionParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostOnReportExceptionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostOnReportExceptionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostOnReportExceptionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostOnReportExceptionParams result =
            new EmbeddedWorkerInstanceHostOnReportExceptionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.errorMessage = String16.decode(decoder1);
        result.lineNumber = decoder0.readInt(16);
        result.columnNumber = decoder0.readInt(20);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.sourceUrl = Url.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.errorMessage, 8, false);
      encoder0.encode(this.lineNumber, 16);
      encoder0.encode(this.columnNumber, 20);
      encoder0.encode((Struct) this.sourceUrl, 24, false);
    }
  }

  static final class EmbeddedWorkerInstanceHostOnReportConsoleMessageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public int lineNumber;
    public String16 message;
    public int messageLevel;
    public int source;
    public Url sourceUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostOnReportConsoleMessageParams(int version) {
      super(40, version);
    }

    public EmbeddedWorkerInstanceHostOnReportConsoleMessageParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostOnReportConsoleMessageParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostOnReportConsoleMessageParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostOnReportConsoleMessageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostOnReportConsoleMessageParams result =
            new EmbeddedWorkerInstanceHostOnReportConsoleMessageParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.source = readInt;
        ConsoleMessageSource.validate(readInt);
        result.source = ConsoleMessageSource.toKnownValue(result.source);
        int readInt2 = decoder0.readInt(12);
        result.messageLevel = readInt2;
        ConsoleMessageLevel.validate(readInt2);
        result.messageLevel = ConsoleMessageLevel.toKnownValue(result.messageLevel);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.message = String16.decode(decoder1);
        result.lineNumber = decoder0.readInt(24);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.sourceUrl = Url.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.source, 8);
      encoder0.encode(this.messageLevel, 12);
      encoder0.encode((Struct) this.message, 16, false);
      encoder0.encode(this.lineNumber, 24);
      encoder0.encode((Struct) this.sourceUrl, 32, false);
    }
  }

  static final class EmbeddedWorkerInstanceHostOnStoppedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceHostOnStoppedParams(int version) {
      super(8, version);
    }

    public EmbeddedWorkerInstanceHostOnStoppedParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceHostOnStoppedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceHostOnStoppedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceHostOnStoppedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceHostOnStoppedParams result =
            new EmbeddedWorkerInstanceHostOnStoppedParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }
}
