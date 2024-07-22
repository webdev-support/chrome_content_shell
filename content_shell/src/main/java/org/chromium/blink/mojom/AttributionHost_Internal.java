package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.attribution_reporting.mojom.RegistrationEligibility;
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

class AttributionHost_Internal {
  public static final Interface.Manager<AttributionHost, AttributionHost.Proxy> MANAGER =
      new Interface.Manager<AttributionHost, AttributionHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.AttributionHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AttributionHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AttributionHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public AttributionHost[] buildArray(int size) {
          return new AttributionHost[size];
        }
      };
  private static final int NOTIFY_NAVIGATION_WITH_BACKGROUND_REGISTRATIONS_WILL_START_ORDINAL = 2;
  private static final int REGISTER_DATA_HOST_ORDINAL = 0;
  private static final int REGISTER_NAVIGATION_DATA_HOST_ORDINAL = 1;

  AttributionHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements AttributionHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void registerDataHost(
        InterfaceRequest<AttributionDataHost> dataHost, int registrationEligibility) {
      AttributionHostRegisterDataHostParams _message = new AttributionHostRegisterDataHostParams();
      _message.dataHost = dataHost;
      _message.registrationEligibility = registrationEligibility;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void registerNavigationDataHost(
        InterfaceRequest<AttributionDataHost> dataHost, AttributionSrcToken attributionSrcToken) {
      AttributionHostRegisterNavigationDataHostParams _message =
          new AttributionHostRegisterNavigationDataHostParams();
      _message.dataHost = dataHost;
      _message.attributionSrcToken = attributionSrcToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void notifyNavigationWithBackgroundRegistrationsWillStart(
        AttributionSrcToken attributionSrcToken, int expectedRegistrations) {
      AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams _message =
          new AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams();
      _message.attributionSrcToken = attributionSrcToken;
      _message.expectedRegistrations = expectedRegistrations;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<AttributionHost> {
    Stub(Core core, AttributionHost impl) {
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
                AttributionHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AttributionHostRegisterDataHostParams data =
                AttributionHostRegisterDataHostParams.deserialize(messageWithHeader.getPayload());
            getImpl().registerDataHost(data.dataHost, data.registrationEligibility);
            return true;
          case 1:
            AttributionHostRegisterNavigationDataHostParams data2 =
                AttributionHostRegisterNavigationDataHostParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().registerNavigationDataHost(data2.dataHost, data2.attributionSrcToken);
            return true;
          case 2:
            AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams data3 =
                AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams
                    .deserialize(messageWithHeader.getPayload());
            getImpl()
                .notifyNavigationWithBackgroundRegistrationsWillStart(
                    data3.attributionSrcToken, data3.expectedRegistrations);
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
                getCore(), AttributionHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AttributionHostRegisterDataHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AttributionDataHost> dataHost;
    public int registrationEligibility;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AttributionHostRegisterDataHostParams(int version) {
      super(16, version);
    }

    public AttributionHostRegisterDataHostParams() {
      this(0);
    }

    public static AttributionHostRegisterDataHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AttributionHostRegisterDataHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AttributionHostRegisterDataHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AttributionHostRegisterDataHostParams result =
            new AttributionHostRegisterDataHostParams(elementsOrVersion);
        result.dataHost = decoder0.readInterfaceRequest(8, false);
        int readInt = decoder0.readInt(12);
        result.registrationEligibility = readInt;
        RegistrationEligibility.validate(readInt);
        result.registrationEligibility =
            RegistrationEligibility.toKnownValue(result.registrationEligibility);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.dataHost, 8, false);
      encoder0.encode(this.registrationEligibility, 12);
    }
  }

  static final class AttributionHostRegisterNavigationDataHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AttributionSrcToken attributionSrcToken;
    public InterfaceRequest<AttributionDataHost> dataHost;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AttributionHostRegisterNavigationDataHostParams(int version) {
      super(24, version);
    }

    public AttributionHostRegisterNavigationDataHostParams() {
      this(0);
    }

    public static AttributionHostRegisterNavigationDataHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AttributionHostRegisterNavigationDataHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AttributionHostRegisterNavigationDataHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AttributionHostRegisterNavigationDataHostParams result =
            new AttributionHostRegisterNavigationDataHostParams(elementsOrVersion);
        result.dataHost = decoder0.readInterfaceRequest(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.attributionSrcToken = AttributionSrcToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.dataHost, 8, false);
      encoder0.encode((Struct) this.attributionSrcToken, 16, false);
    }
  }

  static final class AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AttributionSrcToken attributionSrcToken;
    public int expectedRegistrations;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams(int version) {
      super(24, version);
    }

    public AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams() {
      this(0);
    }

    public static AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams result =
            new AttributionHostNotifyNavigationWithBackgroundRegistrationsWillStartParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.attributionSrcToken = AttributionSrcToken.decode(decoder1);
        result.expectedRegistrations = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.attributionSrcToken, 8, false);
      encoder0.encode(this.expectedRegistrations, 16);
    }
  }
}
