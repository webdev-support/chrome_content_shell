package org.chromium.device.mojom;

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

class HidConnectionClient_Internal {
  public static final Interface.Manager<HidConnectionClient, HidConnectionClient.Proxy> MANAGER =
      new Interface.Manager<HidConnectionClient, HidConnectionClient.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.HidConnectionClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public HidConnectionClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, HidConnectionClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public HidConnectionClient[] buildArray(int size) {
          return new HidConnectionClient[size];
        }
      };
  private static final int ON_INPUT_REPORT_ORDINAL = 0;

  HidConnectionClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements HidConnectionClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onInputReport(byte reportId, byte[] buffer) {
      HidConnectionClientOnInputReportParams _message =
          new HidConnectionClientOnInputReportParams();
      _message.reportId = reportId;
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<HidConnectionClient> {
    Stub(Core core, HidConnectionClient impl) {
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
                HidConnectionClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            HidConnectionClientOnInputReportParams data =
                HidConnectionClientOnInputReportParams.deserialize(messageWithHeader.getPayload());
            getImpl().onInputReport(data.reportId, data.buffer);
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
                getCore(), HidConnectionClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class HidConnectionClientOnInputReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] buffer;
    public byte reportId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidConnectionClientOnInputReportParams(int version) {
      super(24, version);
    }

    public HidConnectionClientOnInputReportParams() {
      this(0);
    }

    public static HidConnectionClientOnInputReportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidConnectionClientOnInputReportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidConnectionClientOnInputReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidConnectionClientOnInputReportParams result =
            new HidConnectionClientOnInputReportParams(elementsOrVersion);
        result.reportId = decoder0.readByte(8);
        result.buffer = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reportId, 8);
      encoder0.encode(this.buffer, 16, 0, -1);
    }
  }
}
