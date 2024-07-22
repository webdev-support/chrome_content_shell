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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class BadgeService_Internal {
  private static final int CLEAR_BADGE_ORDINAL = 1;
  public static final Interface.Manager<BadgeService, BadgeService.Proxy> MANAGER =
      new Interface.Manager<BadgeService, BadgeService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.BadgeService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public BadgeService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, BadgeService impl) {
          return new Stub(core, impl);
        }

        @Override
        public BadgeService[] buildArray(int size) {
          return new BadgeService[size];
        }
      };
  private static final int SET_BADGE_ORDINAL = 0;

  BadgeService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements BadgeService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setBadge(BadgeValue value) {
      BadgeServiceSetBadgeParams _message = new BadgeServiceSetBadgeParams();
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void clearBadge() {
      BadgeServiceClearBadgeParams _message = new BadgeServiceClearBadgeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<BadgeService> {
    Stub(Core core, BadgeService impl) {
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
                BadgeService_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            BadgeServiceSetBadgeParams data =
                BadgeServiceSetBadgeParams.deserialize(messageWithHeader.getPayload());
            getImpl().setBadge(data.value);
            return true;
          case 1:
            BadgeServiceClearBadgeParams.deserialize(messageWithHeader.getPayload());
            getImpl().clearBadge();
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
                getCore(), BadgeService_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class BadgeServiceSetBadgeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BadgeValue value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BadgeServiceSetBadgeParams(int version) {
      super(24, version);
    }

    public BadgeServiceSetBadgeParams() {
      this(0);
    }

    public static BadgeServiceSetBadgeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BadgeServiceSetBadgeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BadgeServiceSetBadgeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BadgeServiceSetBadgeParams result = new BadgeServiceSetBadgeParams(elementsOrVersion);
        result.value = BadgeValue.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.value, 8, false);
    }
  }

  static final class BadgeServiceClearBadgeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BadgeServiceClearBadgeParams(int version) {
      super(8, version);
    }

    public BadgeServiceClearBadgeParams() {
      this(0);
    }

    public static BadgeServiceClearBadgeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BadgeServiceClearBadgeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BadgeServiceClearBadgeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BadgeServiceClearBadgeParams result = new BadgeServiceClearBadgeParams(elementsOrVersion);
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
