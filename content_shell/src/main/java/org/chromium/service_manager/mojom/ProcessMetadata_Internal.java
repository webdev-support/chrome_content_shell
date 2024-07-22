package org.chromium.service_manager.mojom;

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
import org.chromium.mojo_base.mojom.ProcessId;

class ProcessMetadata_Internal {
  public static final Interface.Manager<ProcessMetadata, ProcessMetadata.Proxy> MANAGER =
      new Interface.Manager<ProcessMetadata, ProcessMetadata.Proxy>() {
        @Override
        public String getName() {
          return "service_manager.mojom.ProcessMetadata";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ProcessMetadata.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ProcessMetadata impl) {
          return new Stub(core, impl);
        }

        @Override
        public ProcessMetadata[] buildArray(int size) {
          return new ProcessMetadata[size];
        }
      };
  private static final int SET_PID_ORDINAL = 0;

  ProcessMetadata_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements ProcessMetadata.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setPid(ProcessId pid) {
      ProcessMetadataSetPidParams _message = new ProcessMetadataSetPidParams();
      _message.pid = pid;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<ProcessMetadata> {
    Stub(Core core, ProcessMetadata impl) {
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
                ProcessMetadata_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ProcessMetadataSetPidParams data =
                ProcessMetadataSetPidParams.deserialize(messageWithHeader.getPayload());
            getImpl().setPid(data.pid);
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
                getCore(), ProcessMetadata_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ProcessMetadataSetPidParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ProcessId pid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProcessMetadataSetPidParams(int version) {
      super(16, version);
    }

    public ProcessMetadataSetPidParams() {
      this(0);
    }

    public static ProcessMetadataSetPidParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProcessMetadataSetPidParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProcessMetadataSetPidParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProcessMetadataSetPidParams result = new ProcessMetadataSetPidParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pid = ProcessId.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pid, 8, false);
    }
  }
}
