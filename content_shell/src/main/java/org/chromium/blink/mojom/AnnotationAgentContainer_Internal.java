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

class AnnotationAgentContainer_Internal {
  private static final int CREATE_AGENT_FROM_SELECTION_ORDINAL = 1;
  private static final int CREATE_AGENT_ORDINAL = 0;
  public static final Interface.Manager<AnnotationAgentContainer, AnnotationAgentContainer.Proxy>
      MANAGER =
          new Interface.Manager<AnnotationAgentContainer, AnnotationAgentContainer.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.AnnotationAgentContainer";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AnnotationAgentContainer.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AnnotationAgentContainer impl) {
              return new Stub(core, impl);
            }

            @Override
            public AnnotationAgentContainer[] buildArray(int size) {
              return new AnnotationAgentContainer[size];
            }
          };

  AnnotationAgentContainer_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AnnotationAgentContainer.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createAgent(
        AnnotationAgentHost hostRemote,
        InterfaceRequest<AnnotationAgent> agentReceiver,
        int type,
        String serializedSelector) {
      AnnotationAgentContainerCreateAgentParams _message =
          new AnnotationAgentContainerCreateAgentParams();
      _message.hostRemote = hostRemote;
      _message.agentReceiver = agentReceiver;
      _message.type = type;
      _message.serializedSelector = serializedSelector;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void createAgentFromSelection(int type, CreateAgentFromSelection_Response callback) {
      AnnotationAgentContainerCreateAgentFromSelectionParams _message =
          new AnnotationAgentContainerCreateAgentFromSelectionParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new AnnotationAgentContainerCreateAgentFromSelectionResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<AnnotationAgentContainer> {
    Stub(Core core, AnnotationAgentContainer impl) {
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
                AnnotationAgentContainer_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AnnotationAgentContainerCreateAgentParams data =
                AnnotationAgentContainerCreateAgentParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createAgent(
                    data.hostRemote, data.agentReceiver, data.type, data.serializedSelector);
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
                getCore(), AnnotationAgentContainer_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            AnnotationAgentContainerCreateAgentFromSelectionParams data =
                AnnotationAgentContainerCreateAgentFromSelectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createAgentFromSelection(
                    data.type,
                    new AnnotationAgentContainerCreateAgentFromSelectionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AnnotationAgentContainerCreateAgentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AnnotationAgent> agentReceiver;
    public AnnotationAgentHost hostRemote;
    public String serializedSelector;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnnotationAgentContainerCreateAgentParams(int version) {
      super(32, version);
    }

    public AnnotationAgentContainerCreateAgentParams() {
      this(0);
    }

    public static AnnotationAgentContainerCreateAgentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AnnotationAgentContainerCreateAgentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnnotationAgentContainerCreateAgentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnnotationAgentContainerCreateAgentParams result =
            new AnnotationAgentContainerCreateAgentParams(elementsOrVersion);
        result.hostRemote =
            (AnnotationAgentHost)
                decoder0.readServiceInterface(8, false, AnnotationAgentHost.MANAGER);
        result.agentReceiver = decoder0.readInterfaceRequest(16, false);
        int readInt = decoder0.readInt(20);
        result.type = readInt;
        AnnotationType.validate(readInt);
        result.type = AnnotationType.toKnownValue(result.type);
        result.serializedSelector = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.hostRemote, 8, false, AnnotationAgentHost.MANAGER);
      encoder0.encode((InterfaceRequest) this.agentReceiver, 16, false);
      encoder0.encode(this.type, 20);
      encoder0.encode(this.serializedSelector, 24, false);
    }
  }

  static final class AnnotationAgentContainerCreateAgentFromSelectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnnotationAgentContainerCreateAgentFromSelectionParams(int version) {
      super(16, version);
    }

    public AnnotationAgentContainerCreateAgentFromSelectionParams() {
      this(0);
    }

    public static AnnotationAgentContainerCreateAgentFromSelectionParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnnotationAgentContainerCreateAgentFromSelectionParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnnotationAgentContainerCreateAgentFromSelectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnnotationAgentContainerCreateAgentFromSelectionParams result =
            new AnnotationAgentContainerCreateAgentFromSelectionParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        AnnotationType.validate(readInt);
        result.type = AnnotationType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static final class AnnotationAgentContainerCreateAgentFromSelectionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public int readyStatus;
    public SelectorCreationResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnnotationAgentContainerCreateAgentFromSelectionResponseParams(int version) {
      super(24, version);
    }

    public AnnotationAgentContainerCreateAgentFromSelectionResponseParams() {
      this(0);
    }

    public static AnnotationAgentContainerCreateAgentFromSelectionResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnnotationAgentContainerCreateAgentFromSelectionResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnnotationAgentContainerCreateAgentFromSelectionResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnnotationAgentContainerCreateAgentFromSelectionResponseParams result =
            new AnnotationAgentContainerCreateAgentFromSelectionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.result = SelectorCreationResult.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.error = readInt;
        LinkGenerationError.validate(readInt);
        result.error = LinkGenerationError.toKnownValue(result.error);
        int readInt2 = decoder0.readInt(20);
        result.readyStatus = readInt2;
        LinkGenerationReadyStatus.validate(readInt2);
        result.readyStatus = LinkGenerationReadyStatus.toKnownValue(result.readyStatus);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, true);
      encoder0.encode(this.error, 16);
      encoder0.encode(this.readyStatus, 20);
    }
  }

  static class AnnotationAgentContainerCreateAgentFromSelectionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AnnotationAgentContainer.CreateAgentFromSelection_Response mCallback;

    AnnotationAgentContainerCreateAgentFromSelectionResponseParamsForwardToCallback(
        AnnotationAgentContainer.CreateAgentFromSelection_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        AnnotationAgentContainerCreateAgentFromSelectionResponseParams response =
            AnnotationAgentContainerCreateAgentFromSelectionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.error, response.readyStatus);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AnnotationAgentContainerCreateAgentFromSelectionResponseParamsProxyToResponder
      implements AnnotationAgentContainer.CreateAgentFromSelection_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AnnotationAgentContainerCreateAgentFromSelectionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SelectorCreationResult result, int error, int readyStatus) {
      AnnotationAgentContainerCreateAgentFromSelectionResponseParams _response =
          new AnnotationAgentContainerCreateAgentFromSelectionResponseParams();
      _response.result = result;
      _response.error = error;
      _response.readyStatus = readyStatus;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
