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
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

class DevToolsAgentHost_Internal {
  private static final int BRING_TO_FOREGROUND_ORDINAL = 3;
  private static final int CHILD_TARGET_CREATED_ORDINAL = 0;
  private static final int MAIN_THREAD_DEBUGGER_PAUSED_ORDINAL = 1;
  private static final int MAIN_THREAD_DEBUGGER_RESUMED_ORDINAL = 2;
  public static final Interface.Manager<DevToolsAgentHost, DevToolsAgentHost.Proxy> MANAGER =
      new Interface.Manager<DevToolsAgentHost, DevToolsAgentHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.DevToolsAgentHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DevToolsAgentHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DevToolsAgentHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public DevToolsAgentHost[] buildArray(int size) {
          return new DevToolsAgentHost[size];
        }
      };

  DevToolsAgentHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DevToolsAgentHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void childTargetCreated(
        DevToolsAgent workerDevtoolsAgent,
        InterfaceRequest<DevToolsAgentHost> workerDevtoolsAgentHost,
        Url url,
        String name,
        UnguessableToken devtoolsWorkerToken,
        boolean waitingForDebugger,
        int contextType) {
      DevToolsAgentHostChildTargetCreatedParams _message =
          new DevToolsAgentHostChildTargetCreatedParams();
      _message.workerDevtoolsAgent = workerDevtoolsAgent;
      _message.workerDevtoolsAgentHost = workerDevtoolsAgentHost;
      _message.url = url;
      _message.name = name;
      _message.devtoolsWorkerToken = devtoolsWorkerToken;
      _message.waitingForDebugger = waitingForDebugger;
      _message.contextType = contextType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void mainThreadDebuggerPaused() {
      DevToolsAgentHostMainThreadDebuggerPausedParams _message =
          new DevToolsAgentHostMainThreadDebuggerPausedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void mainThreadDebuggerResumed() {
      DevToolsAgentHostMainThreadDebuggerResumedParams _message =
          new DevToolsAgentHostMainThreadDebuggerResumedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void bringToForeground() {
      DevToolsAgentHostBringToForegroundParams _message =
          new DevToolsAgentHostBringToForegroundParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<DevToolsAgentHost> {
    Stub(Core core, DevToolsAgentHost impl) {
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
                DevToolsAgentHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            DevToolsAgentHostChildTargetCreatedParams data =
                DevToolsAgentHostChildTargetCreatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .childTargetCreated(
                    data.workerDevtoolsAgent,
                    data.workerDevtoolsAgentHost,
                    data.url,
                    data.name,
                    data.devtoolsWorkerToken,
                    data.waitingForDebugger,
                    data.contextType);
            return true;
          case 1:
            DevToolsAgentHostMainThreadDebuggerPausedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().mainThreadDebuggerPaused();
            return true;
          case 2:
            DevToolsAgentHostMainThreadDebuggerResumedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().mainThreadDebuggerResumed();
            return true;
          case 3:
            DevToolsAgentHostBringToForegroundParams.deserialize(messageWithHeader.getPayload());
            getImpl().bringToForeground();
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
                getCore(), DevToolsAgentHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class DevToolsAgentHostChildTargetCreatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public int contextType;
    public UnguessableToken devtoolsWorkerToken;
    public String name;
    public Url url;
    public boolean waitingForDebugger;
    public DevToolsAgent workerDevtoolsAgent;
    public InterfaceRequest<DevToolsAgentHost> workerDevtoolsAgentHost;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsAgentHostChildTargetCreatedParams(int version) {
      super(56, version);
    }

    public DevToolsAgentHostChildTargetCreatedParams() {
      this(0);
    }

    public static DevToolsAgentHostChildTargetCreatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsAgentHostChildTargetCreatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsAgentHostChildTargetCreatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsAgentHostChildTargetCreatedParams result =
            new DevToolsAgentHostChildTargetCreatedParams(elementsOrVersion);
        result.workerDevtoolsAgent =
            (DevToolsAgent) decoder0.readServiceInterface(8, false, DevToolsAgent.MANAGER);
        result.workerDevtoolsAgentHost = decoder0.readInterfaceRequest(16, false);
        result.waitingForDebugger = decoder0.readBoolean(20, 0);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.url = Url.decode(decoder1);
        result.name = decoder0.readString(32, false);
        Decoder decoder12 = decoder0.readPointer(40, false);
        result.devtoolsWorkerToken = UnguessableToken.decode(decoder12);
        int readInt = decoder0.readInt(48);
        result.contextType = readInt;
        DevToolsExecutionContextType.validate(readInt);
        result.contextType = DevToolsExecutionContextType.toKnownValue(result.contextType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.workerDevtoolsAgent, 8, false, DevToolsAgent.MANAGER);
      encoder0.encode((InterfaceRequest) this.workerDevtoolsAgentHost, 16, false);
      encoder0.encode(this.waitingForDebugger, 20, 0);
      encoder0.encode((Struct) this.url, 24, false);
      encoder0.encode(this.name, 32, false);
      encoder0.encode((Struct) this.devtoolsWorkerToken, 40, false);
      encoder0.encode(this.contextType, 48);
    }
  }

  static final class DevToolsAgentHostMainThreadDebuggerPausedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsAgentHostMainThreadDebuggerPausedParams(int version) {
      super(8, version);
    }

    public DevToolsAgentHostMainThreadDebuggerPausedParams() {
      this(0);
    }

    public static DevToolsAgentHostMainThreadDebuggerPausedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsAgentHostMainThreadDebuggerPausedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsAgentHostMainThreadDebuggerPausedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsAgentHostMainThreadDebuggerPausedParams result =
            new DevToolsAgentHostMainThreadDebuggerPausedParams(elementsOrVersion);
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

  static final class DevToolsAgentHostMainThreadDebuggerResumedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsAgentHostMainThreadDebuggerResumedParams(int version) {
      super(8, version);
    }

    public DevToolsAgentHostMainThreadDebuggerResumedParams() {
      this(0);
    }

    public static DevToolsAgentHostMainThreadDebuggerResumedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsAgentHostMainThreadDebuggerResumedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsAgentHostMainThreadDebuggerResumedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsAgentHostMainThreadDebuggerResumedParams result =
            new DevToolsAgentHostMainThreadDebuggerResumedParams(elementsOrVersion);
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

  static final class DevToolsAgentHostBringToForegroundParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsAgentHostBringToForegroundParams(int version) {
      super(8, version);
    }

    public DevToolsAgentHostBringToForegroundParams() {
      this(0);
    }

    public static DevToolsAgentHostBringToForegroundParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsAgentHostBringToForegroundParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsAgentHostBringToForegroundParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsAgentHostBringToForegroundParams result =
            new DevToolsAgentHostBringToForegroundParams(elementsOrVersion);
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
