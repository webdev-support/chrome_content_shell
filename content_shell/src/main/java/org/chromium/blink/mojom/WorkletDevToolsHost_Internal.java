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

class WorkletDevToolsHost_Internal {
  public static final Interface.Manager<WorkletDevToolsHost, WorkletDevToolsHost.Proxy> MANAGER =
      new Interface.Manager<WorkletDevToolsHost, WorkletDevToolsHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WorkletDevToolsHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WorkletDevToolsHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WorkletDevToolsHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public WorkletDevToolsHost[] buildArray(int size) {
          return new WorkletDevToolsHost[size];
        }
      };
  private static final int ON_READY_FOR_INSPECTION_ORDINAL = 0;

  WorkletDevToolsHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WorkletDevToolsHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onReadyForInspection(
        DevToolsAgent agent, InterfaceRequest<DevToolsAgentHost> agentHost) {
      WorkletDevToolsHostOnReadyForInspectionParams _message =
          new WorkletDevToolsHostOnReadyForInspectionParams();
      _message.agent = agent;
      _message.agentHost = agentHost;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<WorkletDevToolsHost> {
    Stub(Core core, WorkletDevToolsHost impl) {
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
                WorkletDevToolsHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WorkletDevToolsHostOnReadyForInspectionParams data =
                WorkletDevToolsHostOnReadyForInspectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onReadyForInspection(data.agent, data.agentHost);
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
                getCore(), WorkletDevToolsHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WorkletDevToolsHostOnReadyForInspectionParams extends Struct {
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

    private WorkletDevToolsHostOnReadyForInspectionParams(int version) {
      super(24, version);
    }

    public WorkletDevToolsHostOnReadyForInspectionParams() {
      this(0);
    }

    public static WorkletDevToolsHostOnReadyForInspectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WorkletDevToolsHostOnReadyForInspectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkletDevToolsHostOnReadyForInspectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkletDevToolsHostOnReadyForInspectionParams result =
            new WorkletDevToolsHostOnReadyForInspectionParams(elementsOrVersion);
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
}
