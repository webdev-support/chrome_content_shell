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

class PowerMonitorClient_Internal {
  public static final Interface.Manager<PowerMonitorClient, PowerMonitorClient.Proxy> MANAGER =
      new Interface.Manager<PowerMonitorClient, PowerMonitorClient.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.PowerMonitorClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PowerMonitorClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PowerMonitorClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public PowerMonitorClient[] buildArray(int size) {
          return new PowerMonitorClient[size];
        }
      };
  private static final int POWER_STATE_CHANGE_ORDINAL = 0;
  private static final int RESUME_ORDINAL = 2;
  private static final int SUSPEND_ORDINAL = 1;

  PowerMonitorClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PowerMonitorClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void powerStateChange(boolean onBatteryPower) {
      PowerMonitorClientPowerStateChangeParams _message =
          new PowerMonitorClientPowerStateChangeParams();
      _message.onBatteryPower = onBatteryPower;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void suspend() {
      PowerMonitorClientSuspendParams _message = new PowerMonitorClientSuspendParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void resume() {
      PowerMonitorClientResumeParams _message = new PowerMonitorClientResumeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<PowerMonitorClient> {
    Stub(Core core, PowerMonitorClient impl) {
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
                PowerMonitorClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PowerMonitorClientPowerStateChangeParams data =
                PowerMonitorClientPowerStateChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().powerStateChange(data.onBatteryPower);
            return true;
          case 1:
            PowerMonitorClientSuspendParams.deserialize(messageWithHeader.getPayload());
            getImpl().suspend();
            return true;
          case 2:
            PowerMonitorClientResumeParams.deserialize(messageWithHeader.getPayload());
            getImpl().resume();
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
                getCore(), PowerMonitorClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PowerMonitorClientPowerStateChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean onBatteryPower;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PowerMonitorClientPowerStateChangeParams(int version) {
      super(16, version);
    }

    public PowerMonitorClientPowerStateChangeParams() {
      this(0);
    }

    public static PowerMonitorClientPowerStateChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PowerMonitorClientPowerStateChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PowerMonitorClientPowerStateChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PowerMonitorClientPowerStateChangeParams result =
            new PowerMonitorClientPowerStateChangeParams(elementsOrVersion);
        result.onBatteryPower = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.onBatteryPower, 8, 0);
    }
  }

  static final class PowerMonitorClientSuspendParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PowerMonitorClientSuspendParams(int version) {
      super(8, version);
    }

    public PowerMonitorClientSuspendParams() {
      this(0);
    }

    public static PowerMonitorClientSuspendParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PowerMonitorClientSuspendParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PowerMonitorClientSuspendParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PowerMonitorClientSuspendParams result =
            new PowerMonitorClientSuspendParams(elementsOrVersion);
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

  static final class PowerMonitorClientResumeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PowerMonitorClientResumeParams(int version) {
      super(8, version);
    }

    public PowerMonitorClientResumeParams() {
      this(0);
    }

    public static PowerMonitorClientResumeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PowerMonitorClientResumeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PowerMonitorClientResumeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PowerMonitorClientResumeParams result =
            new PowerMonitorClientResumeParams(elementsOrVersion);
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
