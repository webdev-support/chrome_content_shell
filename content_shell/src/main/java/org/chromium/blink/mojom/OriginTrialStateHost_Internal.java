package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.chromium.url.internal.mojom.Origin;

class OriginTrialStateHost_Internal {
  private static final int APPLY_FEATURE_DIFF_FOR_ORIGIN_TRIAL_ORDINAL = 0;
  private static final int ENABLE_PERSISTENT_TRIAL_ORDINAL = 1;
  public static final Interface.Manager<OriginTrialStateHost, OriginTrialStateHost.Proxy> MANAGER =
      new Interface.Manager<OriginTrialStateHost, OriginTrialStateHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.OriginTrialStateHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public OriginTrialStateHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, OriginTrialStateHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public OriginTrialStateHost[] buildArray(int size) {
          return new OriginTrialStateHost[size];
        }
      };

  OriginTrialStateHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements OriginTrialStateHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void applyFeatureDiffForOriginTrial(
        Map<Integer, OriginTrialFeatureState> originTrialFeatures) {
      OriginTrialStateHostApplyFeatureDiffForOriginTrialParams _message =
          new OriginTrialStateHostApplyFeatureDiffForOriginTrialParams();
      _message.originTrialFeatures = originTrialFeatures;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void enablePersistentTrial(String token, Origin[] scriptOrigins) {
      OriginTrialStateHostEnablePersistentTrialParams _message =
          new OriginTrialStateHostEnablePersistentTrialParams();
      _message.token = token;
      _message.scriptOrigins = scriptOrigins;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<OriginTrialStateHost> {
    Stub(Core core, OriginTrialStateHost impl) {
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
                OriginTrialStateHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .applyFeatureDiffForOriginTrial(
                    OriginTrialStateHostApplyFeatureDiffForOriginTrialParams.deserialize(
                            messageWithHeader.getPayload())
                        .originTrialFeatures);
            return true;
          case 1:
            OriginTrialStateHostEnablePersistentTrialParams data =
                OriginTrialStateHostEnablePersistentTrialParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().enablePersistentTrial(data.token, data.scriptOrigins);
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
                getCore(), OriginTrialStateHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class OriginTrialStateHostApplyFeatureDiffForOriginTrialParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Map<Integer, OriginTrialFeatureState> originTrialFeatures;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OriginTrialStateHostApplyFeatureDiffForOriginTrialParams(int version) {
      super(16, version);
    }

    public OriginTrialStateHostApplyFeatureDiffForOriginTrialParams() {
      this(0);
    }

    public static OriginTrialStateHostApplyFeatureDiffForOriginTrialParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static OriginTrialStateHostApplyFeatureDiffForOriginTrialParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OriginTrialStateHostApplyFeatureDiffForOriginTrialParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OriginTrialStateHostApplyFeatureDiffForOriginTrialParams result =
            new OriginTrialStateHostApplyFeatureDiffForOriginTrialParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        decoder1.readDataHeaderForMap();
        int[] keys0 = decoder1.readInts(8, 0, -1);
        for (int i : keys0) {
          RuntimeFeature.validate(i);
        }
        Decoder decoder2 = decoder1.readPointer(16, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
        OriginTrialFeatureState[] values0 = new OriginTrialFeatureState[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
          values0[i2] = OriginTrialFeatureState.decode(decoder3);
        }
        result.originTrialFeatures = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.originTrialFeatures.put(Integer.valueOf(keys0[index0]), values0[index0]);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      if (this.originTrialFeatures == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.originTrialFeatures.size();
      int[] keys0 = new int[size0];
      OriginTrialFeatureState[] values0 = new OriginTrialFeatureState[size0];
      int index0 = 0;
      for (Map.Entry<Integer, OriginTrialFeatureState> entry0 :
          this.originTrialFeatures.entrySet()) {
        keys0[index0] = entry0.getKey().intValue();
        values0[index0] = entry0.getValue();
        index0++;
      }
      encoder1.encode(keys0, 8, 0, -1);
      Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i1 = 0; i1 < values0.length; i1++) {
        encoder2.encode((Struct) values0[i1], (i1 * 8) + 8, false);
      }
    }
  }

  static final class OriginTrialStateHostEnablePersistentTrialParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin[] scriptOrigins;
    public String token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OriginTrialStateHostEnablePersistentTrialParams(int version) {
      super(24, version);
    }

    public OriginTrialStateHostEnablePersistentTrialParams() {
      this(0);
    }

    public static OriginTrialStateHostEnablePersistentTrialParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OriginTrialStateHostEnablePersistentTrialParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OriginTrialStateHostEnablePersistentTrialParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OriginTrialStateHostEnablePersistentTrialParams result =
            new OriginTrialStateHostEnablePersistentTrialParams(elementsOrVersion);
        result.token = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.scriptOrigins = new Origin[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.scriptOrigins[i1] = Origin.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.token, 8, false);
      Origin[] originArr = this.scriptOrigins;
      if (originArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(originArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        Origin[] originArr2 = this.scriptOrigins;
        if (i0 < originArr2.length) {
          encoder1.encode((Struct) originArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
