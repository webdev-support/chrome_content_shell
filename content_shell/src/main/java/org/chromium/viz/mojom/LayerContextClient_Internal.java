package org.chromium.viz.mojom;

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

class LayerContextClient_Internal {
  public static final Interface.Manager<LayerContextClient, LayerContextClient.Proxy> MANAGER =
      new Interface.Manager<LayerContextClient, LayerContextClient.Proxy>() {
        @Override
        public String getName() {
          return "viz.mojom.LayerContextClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LayerContextClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LayerContextClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public LayerContextClient[] buildArray(int size) {
          return new LayerContextClient[size];
        }
      };
  private static final int ON_REQUEST_COMMIT_FOR_FRAME_ORDINAL = 0;

  LayerContextClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements LayerContextClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onRequestCommitForFrame(BeginFrameArgs args) {
      LayerContextClientOnRequestCommitForFrameParams _message =
          new LayerContextClientOnRequestCommitForFrameParams();
      _message.args = args;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<LayerContextClient> {
    Stub(Core core, LayerContextClient impl) {
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
                LayerContextClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            LayerContextClientOnRequestCommitForFrameParams data =
                LayerContextClientOnRequestCommitForFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onRequestCommitForFrame(data.args);
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
                getCore(), LayerContextClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class LayerContextClientOnRequestCommitForFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BeginFrameArgs args;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LayerContextClientOnRequestCommitForFrameParams(int version) {
      super(16, version);
    }

    public LayerContextClientOnRequestCommitForFrameParams() {
      this(0);
    }

    public static LayerContextClientOnRequestCommitForFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LayerContextClientOnRequestCommitForFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LayerContextClientOnRequestCommitForFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LayerContextClientOnRequestCommitForFrameParams result =
            new LayerContextClientOnRequestCommitForFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.args = BeginFrameArgs.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.args, 8, false);
    }
  }
}
