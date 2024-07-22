package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.attribution_reporting.mojom.OsRegistration;
import org.chromium.attribution_reporting.mojom.SourceRegistration;
import org.chromium.attribution_reporting.mojom.SuitableOrigin;
import org.chromium.attribution_reporting.mojom.TriggerRegistration;
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
import org.chromium.network.mojom.TriggerVerification;

class AttributionDataHost_Internal {
  public static final Interface.Manager<AttributionDataHost, AttributionDataHost.Proxy> MANAGER =
      new Interface.Manager<AttributionDataHost, AttributionDataHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.AttributionDataHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AttributionDataHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AttributionDataHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public AttributionDataHost[] buildArray(int size) {
          return new AttributionDataHost[size];
        }
      };
  private static final int OS_SOURCE_DATA_AVAILABLE_ORDINAL = 2;
  private static final int OS_TRIGGER_DATA_AVAILABLE_ORDINAL = 3;
  private static final int SOURCE_DATA_AVAILABLE_ORDINAL = 0;
  private static final int TRIGGER_DATA_AVAILABLE_ORDINAL = 1;

  AttributionDataHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AttributionDataHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void sourceDataAvailable(SuitableOrigin reportingOrigin, SourceRegistration data) {
      AttributionDataHostSourceDataAvailableParams _message =
          new AttributionDataHostSourceDataAvailableParams();
      _message.reportingOrigin = reportingOrigin;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void triggerDataAvailable(
        SuitableOrigin reportingOrigin,
        TriggerRegistration data,
        TriggerVerification[] verifications) {
      AttributionDataHostTriggerDataAvailableParams _message =
          new AttributionDataHostTriggerDataAvailableParams();
      _message.reportingOrigin = reportingOrigin;
      _message.data = data;
      _message.verifications = verifications;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void osSourceDataAvailable(OsRegistration registration) {
      AttributionDataHostOsSourceDataAvailableParams _message =
          new AttributionDataHostOsSourceDataAvailableParams();
      _message.registration = registration;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void osTriggerDataAvailable(OsRegistration registration) {
      AttributionDataHostOsTriggerDataAvailableParams _message =
          new AttributionDataHostOsTriggerDataAvailableParams();
      _message.registration = registration;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<AttributionDataHost> {
    Stub(Core core, AttributionDataHost impl) {
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
                AttributionDataHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AttributionDataHostSourceDataAvailableParams data =
                AttributionDataHostSourceDataAvailableParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().sourceDataAvailable(data.reportingOrigin, data.data);
            return true;
          case 1:
            AttributionDataHostTriggerDataAvailableParams data2 =
                AttributionDataHostTriggerDataAvailableParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().triggerDataAvailable(data2.reportingOrigin, data2.data, data2.verifications);
            return true;
          case 2:
            getImpl()
                .osSourceDataAvailable(
                    AttributionDataHostOsSourceDataAvailableParams.deserialize(
                            messageWithHeader.getPayload())
                        .registration);
            return true;
          case 3:
            getImpl()
                .osTriggerDataAvailable(
                    AttributionDataHostOsTriggerDataAvailableParams.deserialize(
                            messageWithHeader.getPayload())
                        .registration);
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
                getCore(), AttributionDataHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AttributionDataHostSourceDataAvailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SourceRegistration data;
    public SuitableOrigin reportingOrigin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AttributionDataHostSourceDataAvailableParams(int version) {
      super(24, version);
    }

    public AttributionDataHostSourceDataAvailableParams() {
      this(0);
    }

    public static AttributionDataHostSourceDataAvailableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AttributionDataHostSourceDataAvailableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AttributionDataHostSourceDataAvailableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AttributionDataHostSourceDataAvailableParams result =
            new AttributionDataHostSourceDataAvailableParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.reportingOrigin = SuitableOrigin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.data = SourceRegistration.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.reportingOrigin, 8, false);
      encoder0.encode((Struct) this.data, 16, false);
    }
  }

  static final class AttributionDataHostTriggerDataAvailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public TriggerRegistration data;
    public SuitableOrigin reportingOrigin;
    public TriggerVerification[] verifications;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AttributionDataHostTriggerDataAvailableParams(int version) {
      super(32, version);
    }

    public AttributionDataHostTriggerDataAvailableParams() {
      this(0);
    }

    public static AttributionDataHostTriggerDataAvailableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AttributionDataHostTriggerDataAvailableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AttributionDataHostTriggerDataAvailableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AttributionDataHostTriggerDataAvailableParams result =
            new AttributionDataHostTriggerDataAvailableParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.reportingOrigin = SuitableOrigin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.data = TriggerRegistration.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
        result.verifications = new TriggerVerification[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
          result.verifications[i1] = TriggerVerification.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.reportingOrigin, 8, false);
      encoder0.encode((Struct) this.data, 16, false);
      TriggerVerification[] triggerVerificationArr = this.verifications;
      if (triggerVerificationArr == null) {
        encoder0.encodeNullPointer(24, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(triggerVerificationArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        TriggerVerification[] triggerVerificationArr2 = this.verifications;
        if (i0 < triggerVerificationArr2.length) {
          encoder1.encode((Struct) triggerVerificationArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class AttributionDataHostOsSourceDataAvailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public OsRegistration registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AttributionDataHostOsSourceDataAvailableParams(int version) {
      super(16, version);
    }

    public AttributionDataHostOsSourceDataAvailableParams() {
      this(0);
    }

    public static AttributionDataHostOsSourceDataAvailableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AttributionDataHostOsSourceDataAvailableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AttributionDataHostOsSourceDataAvailableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AttributionDataHostOsSourceDataAvailableParams result =
            new AttributionDataHostOsSourceDataAvailableParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.registration = OsRegistration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.registration, 8, false);
    }
  }

  static final class AttributionDataHostOsTriggerDataAvailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public OsRegistration registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AttributionDataHostOsTriggerDataAvailableParams(int version) {
      super(16, version);
    }

    public AttributionDataHostOsTriggerDataAvailableParams() {
      this(0);
    }

    public static AttributionDataHostOsTriggerDataAvailableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AttributionDataHostOsTriggerDataAvailableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AttributionDataHostOsTriggerDataAvailableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AttributionDataHostOsTriggerDataAvailableParams result =
            new AttributionDataHostOsTriggerDataAvailableParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.registration = OsRegistration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.registration, 8, false);
    }
  }
}
