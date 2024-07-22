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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class SharedWorkerHost_Internal {
  public static final Interface.Manager<SharedWorkerHost, SharedWorkerHost.Proxy> MANAGER =
      new Interface.Manager<SharedWorkerHost, SharedWorkerHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.SharedWorkerHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SharedWorkerHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SharedWorkerHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public SharedWorkerHost[] buildArray(int size) {
          return new SharedWorkerHost[size];
        }
      };
  private static final int ON_CONNECTED_ORDINAL = 0;
  private static final int ON_CONTEXT_CLOSED_ORDINAL = 1;
  private static final int ON_FEATURE_USED_ORDINAL = 4;
  private static final int ON_READY_FOR_INSPECTION_ORDINAL = 2;
  private static final int ON_SCRIPT_LOAD_FAILED_ORDINAL = 3;

  SharedWorkerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SharedWorkerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onConnected(int connectionId) {
      SharedWorkerHostOnConnectedParams _message = new SharedWorkerHostOnConnectedParams();
      _message.connectionId = connectionId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onContextClosed() {
      SharedWorkerHostOnContextClosedParams _message = new SharedWorkerHostOnContextClosedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onReadyForInspection(
        DevToolsAgent agent, InterfaceRequest<DevToolsAgentHost> agentHost) {
      SharedWorkerHostOnReadyForInspectionParams _message =
          new SharedWorkerHostOnReadyForInspectionParams();
      _message.agent = agent;
      _message.agentHost = agentHost;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onScriptLoadFailed(String errorMessage) {
      SharedWorkerHostOnScriptLoadFailedParams _message =
          new SharedWorkerHostOnScriptLoadFailedParams();
      _message.errorMessage = errorMessage;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onFeatureUsed(int feature) {
      SharedWorkerHostOnFeatureUsedParams _message = new SharedWorkerHostOnFeatureUsedParams();
      _message.feature = feature;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<SharedWorkerHost> {
    Stub(Core core, SharedWorkerHost impl) {
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
                SharedWorkerHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .onConnected(
                    SharedWorkerHostOnConnectedParams.deserialize(messageWithHeader.getPayload())
                        .connectionId);
            return true;
          case 1:
            SharedWorkerHostOnContextClosedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onContextClosed();
            return true;
          case 2:
            SharedWorkerHostOnReadyForInspectionParams data =
                SharedWorkerHostOnReadyForInspectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onReadyForInspection(data.agent, data.agentHost);
            return true;
          case 3:
            SharedWorkerHostOnScriptLoadFailedParams data2 =
                SharedWorkerHostOnScriptLoadFailedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onScriptLoadFailed(data2.errorMessage);
            return true;
          case 4:
            SharedWorkerHostOnFeatureUsedParams data3 =
                SharedWorkerHostOnFeatureUsedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onFeatureUsed(data3.feature);
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
                getCore(), SharedWorkerHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SharedWorkerHostOnConnectedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int connectionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerHostOnConnectedParams(int version) {
      super(16, version);
    }

    public SharedWorkerHostOnConnectedParams() {
      this(0);
    }

    public static SharedWorkerHostOnConnectedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerHostOnConnectedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerHostOnConnectedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerHostOnConnectedParams result =
            new SharedWorkerHostOnConnectedParams(elementsOrVersion);
        result.connectionId = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.connectionId, 8);
    }
  }

  static final class SharedWorkerHostOnContextClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerHostOnContextClosedParams(int version) {
      super(8, version);
    }

    public SharedWorkerHostOnContextClosedParams() {
      this(0);
    }

    public static SharedWorkerHostOnContextClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerHostOnContextClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerHostOnContextClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerHostOnContextClosedParams result =
            new SharedWorkerHostOnContextClosedParams(elementsOrVersion);
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

  static final class SharedWorkerHostOnReadyForInspectionParams extends Struct {
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

    private SharedWorkerHostOnReadyForInspectionParams(int version) {
      super(24, version);
    }

    public SharedWorkerHostOnReadyForInspectionParams() {
      this(0);
    }

    public static SharedWorkerHostOnReadyForInspectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerHostOnReadyForInspectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerHostOnReadyForInspectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerHostOnReadyForInspectionParams result =
            new SharedWorkerHostOnReadyForInspectionParams(elementsOrVersion);
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

  static final class SharedWorkerHostOnScriptLoadFailedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String errorMessage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerHostOnScriptLoadFailedParams(int version) {
      super(16, version);
    }

    public SharedWorkerHostOnScriptLoadFailedParams() {
      this(0);
    }

    public static SharedWorkerHostOnScriptLoadFailedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerHostOnScriptLoadFailedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerHostOnScriptLoadFailedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerHostOnScriptLoadFailedParams result =
            new SharedWorkerHostOnScriptLoadFailedParams(elementsOrVersion);
        result.errorMessage = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorMessage, 8, false);
    }
  }

  static final class SharedWorkerHostOnFeatureUsedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int feature;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerHostOnFeatureUsedParams(int version) {
      super(16, version);
    }

    public SharedWorkerHostOnFeatureUsedParams() {
      this(0);
    }

    public static SharedWorkerHostOnFeatureUsedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerHostOnFeatureUsedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerHostOnFeatureUsedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerHostOnFeatureUsedParams result =
            new SharedWorkerHostOnFeatureUsedParams(elementsOrVersion);
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
}
