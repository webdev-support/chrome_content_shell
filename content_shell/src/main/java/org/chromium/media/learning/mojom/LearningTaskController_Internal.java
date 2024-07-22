package org.chromium.media.learning.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class LearningTaskController_Internal {
  private static final int BEGIN_OBSERVATION_ORDINAL = 0;
  private static final int CANCEL_OBSERVATION_ORDINAL = 2;
  private static final int COMPLETE_OBSERVATION_ORDINAL = 1;
  public static final Interface.Manager<LearningTaskController, LearningTaskController.Proxy>
      MANAGER =
          new Interface.Manager<LearningTaskController, LearningTaskController.Proxy>() {
            @Override
            public String getName() {
              return "media.learning.mojom.LearningTaskController";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public LearningTaskController.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, LearningTaskController impl) {
              return new Stub(core, impl);
            }

            @Override
            public LearningTaskController[] buildArray(int size) {
              return new LearningTaskController[size];
            }
          };
  private static final int PREDICT_DISTRIBUTION_ORDINAL = 4;
  private static final int UPDATE_DEFAULT_TARGET_ORDINAL = 3;

  LearningTaskController_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements LearningTaskController.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void beginObservation(
        UnguessableToken id, FeatureValue[] features, TargetValue defaultTarget) {
      LearningTaskControllerBeginObservationParams _message =
          new LearningTaskControllerBeginObservationParams();
      _message.id = id;
      _message.features = features;
      _message.defaultTarget = defaultTarget;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void completeObservation(UnguessableToken id, ObservationCompletion completion) {
      LearningTaskControllerCompleteObservationParams _message =
          new LearningTaskControllerCompleteObservationParams();
      _message.id = id;
      _message.completion = completion;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void cancelObservation(UnguessableToken id) {
      LearningTaskControllerCancelObservationParams _message =
          new LearningTaskControllerCancelObservationParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void updateDefaultTarget(UnguessableToken id, TargetValue defaultTarget) {
      LearningTaskControllerUpdateDefaultTargetParams _message =
          new LearningTaskControllerUpdateDefaultTargetParams();
      _message.id = id;
      _message.defaultTarget = defaultTarget;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void predictDistribution(
        FeatureValue[] features, PredictDistribution_Response callback) {
      LearningTaskControllerPredictDistributionParams _message =
          new LearningTaskControllerPredictDistributionParams();
      _message.features = features;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new LearningTaskControllerPredictDistributionResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<LearningTaskController> {
    Stub(Core core, LearningTaskController impl) {
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
                LearningTaskController_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            LearningTaskControllerBeginObservationParams data =
                LearningTaskControllerBeginObservationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().beginObservation(data.id, data.features, data.defaultTarget);
            return true;
          case 1:
            LearningTaskControllerCompleteObservationParams data2 =
                LearningTaskControllerCompleteObservationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().completeObservation(data2.id, data2.completion);
            return true;
          case 2:
            getImpl()
                .cancelObservation(
                    LearningTaskControllerCancelObservationParams.deserialize(
                            messageWithHeader.getPayload())
                        .id);
            return true;
          case 3:
            LearningTaskControllerUpdateDefaultTargetParams data3 =
                LearningTaskControllerUpdateDefaultTargetParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateDefaultTarget(data3.id, data3.defaultTarget);
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
                getCore(), LearningTaskController_Internal.MANAGER, messageWithHeader, receiver);
          case 4:
            LearningTaskControllerPredictDistributionParams data =
                LearningTaskControllerPredictDistributionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .predictDistribution(
                    data.features,
                    new LearningTaskControllerPredictDistributionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class LearningTaskControllerBeginObservationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public TargetValue defaultTarget;
    public FeatureValue[] features;
    public UnguessableToken id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LearningTaskControllerBeginObservationParams(int version) {
      super(32, version);
    }

    public LearningTaskControllerBeginObservationParams() {
      this(0);
    }

    public static LearningTaskControllerBeginObservationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LearningTaskControllerBeginObservationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LearningTaskControllerBeginObservationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LearningTaskControllerBeginObservationParams result =
            new LearningTaskControllerBeginObservationParams(elementsOrVersion);
        result.id = UnguessableToken.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.features = new FeatureValue[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.features[i1] = FeatureValue.decode(decoder2);
        }
        result.defaultTarget = TargetValue.decode(decoder0.readPointer(24, true));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.id, 8, false);
      FeatureValue[] featureValueArr = this.features;
      if (featureValueArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(featureValueArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          FeatureValue[] featureValueArr2 = this.features;
          if (i0 >= featureValueArr2.length) {
            break;
          }
          encoder1.encode((Struct) featureValueArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.defaultTarget, 24, true);
    }
  }

  static final class LearningTaskControllerCompleteObservationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ObservationCompletion completion;
    public UnguessableToken id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LearningTaskControllerCompleteObservationParams(int version) {
      super(24, version);
    }

    public LearningTaskControllerCompleteObservationParams() {
      this(0);
    }

    public static LearningTaskControllerCompleteObservationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LearningTaskControllerCompleteObservationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LearningTaskControllerCompleteObservationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LearningTaskControllerCompleteObservationParams result =
            new LearningTaskControllerCompleteObservationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.id = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.completion = ObservationCompletion.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.id, 8, false);
      encoder0.encode((Struct) this.completion, 16, false);
    }
  }

  static final class LearningTaskControllerCancelObservationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LearningTaskControllerCancelObservationParams(int version) {
      super(16, version);
    }

    public LearningTaskControllerCancelObservationParams() {
      this(0);
    }

    public static LearningTaskControllerCancelObservationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LearningTaskControllerCancelObservationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LearningTaskControllerCancelObservationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LearningTaskControllerCancelObservationParams result =
            new LearningTaskControllerCancelObservationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.id = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.id, 8, false);
    }
  }

  static final class LearningTaskControllerUpdateDefaultTargetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public TargetValue defaultTarget;
    public UnguessableToken id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LearningTaskControllerUpdateDefaultTargetParams(int version) {
      super(24, version);
    }

    public LearningTaskControllerUpdateDefaultTargetParams() {
      this(0);
    }

    public static LearningTaskControllerUpdateDefaultTargetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LearningTaskControllerUpdateDefaultTargetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LearningTaskControllerUpdateDefaultTargetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LearningTaskControllerUpdateDefaultTargetParams result =
            new LearningTaskControllerUpdateDefaultTargetParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.id = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.defaultTarget = TargetValue.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.id, 8, false);
      encoder0.encode((Struct) this.defaultTarget, 16, true);
    }
  }

  static final class LearningTaskControllerPredictDistributionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FeatureValue[] features;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LearningTaskControllerPredictDistributionParams(int version) {
      super(16, version);
    }

    public LearningTaskControllerPredictDistributionParams() {
      this(0);
    }

    public static LearningTaskControllerPredictDistributionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LearningTaskControllerPredictDistributionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LearningTaskControllerPredictDistributionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LearningTaskControllerPredictDistributionParams result =
            new LearningTaskControllerPredictDistributionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.features = new FeatureValue[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.features[i1] = FeatureValue.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      FeatureValue[] featureValueArr = this.features;
      if (featureValueArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(featureValueArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        FeatureValue[] featureValueArr2 = this.features;
        if (i0 < featureValueArr2.length) {
          encoder1.encode((Struct) featureValueArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class LearningTaskControllerPredictDistributionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TargetHistogram predicted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LearningTaskControllerPredictDistributionResponseParams(int version) {
      super(16, version);
    }

    public LearningTaskControllerPredictDistributionResponseParams() {
      this(0);
    }

    public static LearningTaskControllerPredictDistributionResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LearningTaskControllerPredictDistributionResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LearningTaskControllerPredictDistributionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LearningTaskControllerPredictDistributionResponseParams result =
            new LearningTaskControllerPredictDistributionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.predicted = TargetHistogram.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.predicted, 8, true);
    }
  }

  static class LearningTaskControllerPredictDistributionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LearningTaskController.PredictDistribution_Response mCallback;

    LearningTaskControllerPredictDistributionResponseParamsForwardToCallback(
        LearningTaskController.PredictDistribution_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        LearningTaskControllerPredictDistributionResponseParams response =
            LearningTaskControllerPredictDistributionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.predicted);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LearningTaskControllerPredictDistributionResponseParamsProxyToResponder
      implements LearningTaskController.PredictDistribution_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LearningTaskControllerPredictDistributionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(TargetHistogram predicted) {
      LearningTaskControllerPredictDistributionResponseParams _response =
          new LearningTaskControllerPredictDistributionResponseParams();
      _response.predicted = predicted;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
