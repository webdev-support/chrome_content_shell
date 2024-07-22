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
import org.chromium.mojo.system.Core;

class OomIntervention_Internal {
  public static final Interface.Manager<OomIntervention, OomIntervention.Proxy> MANAGER =
      new Interface.Manager<OomIntervention, OomIntervention.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.OomIntervention";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public OomIntervention.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, OomIntervention impl) {
          return new Stub(core, impl);
        }

        @Override
        public OomIntervention[] buildArray(int size) {
          return new OomIntervention[size];
        }
      };
  private static final int START_DETECTION_ORDINAL = 0;

  OomIntervention_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements OomIntervention.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void startDetection(
        OomInterventionHost host,
        DetectionArgs detectionArgs,
        boolean rendererPauseEnabled,
        boolean navigateAdsEnabled,
        boolean purgeV8MemoryEnabled) {
      OomInterventionStartDetectionParams _message = new OomInterventionStartDetectionParams();
      _message.host = host;
      _message.detectionArgs = detectionArgs;
      _message.rendererPauseEnabled = rendererPauseEnabled;
      _message.navigateAdsEnabled = navigateAdsEnabled;
      _message.purgeV8MemoryEnabled = purgeV8MemoryEnabled;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<OomIntervention> {
    Stub(Core core, OomIntervention impl) {
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
                OomIntervention_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            OomInterventionStartDetectionParams data =
                OomInterventionStartDetectionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .startDetection(
                    data.host,
                    data.detectionArgs,
                    data.rendererPauseEnabled,
                    data.navigateAdsEnabled,
                    data.purgeV8MemoryEnabled);
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
                getCore(), OomIntervention_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class OomInterventionStartDetectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public DetectionArgs detectionArgs;
    public OomInterventionHost host;
    public boolean navigateAdsEnabled;
    public boolean purgeV8MemoryEnabled;
    public boolean rendererPauseEnabled;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OomInterventionStartDetectionParams(int version) {
      super(32, version);
    }

    public OomInterventionStartDetectionParams() {
      this(0);
    }

    public static OomInterventionStartDetectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OomInterventionStartDetectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OomInterventionStartDetectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OomInterventionStartDetectionParams result =
            new OomInterventionStartDetectionParams(elementsOrVersion);
        result.host =
            (OomInterventionHost)
                decoder0.readServiceInterface(8, false, OomInterventionHost.MANAGER);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.detectionArgs = DetectionArgs.decode(decoder1);
        result.rendererPauseEnabled = decoder0.readBoolean(24, 0);
        result.navigateAdsEnabled = decoder0.readBoolean(24, 1);
        result.purgeV8MemoryEnabled = decoder0.readBoolean(24, 2);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.host, 8, false, OomInterventionHost.MANAGER);
      encoder0.encode((Struct) this.detectionArgs, 16, false);
      encoder0.encode(this.rendererPauseEnabled, 24, 0);
      encoder0.encode(this.navigateAdsEnabled, 24, 1);
      encoder0.encode(this.purgeV8MemoryEnabled, 24, 2);
    }
  }
}
