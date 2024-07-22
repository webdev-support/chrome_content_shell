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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class LeakDetector_Internal {
  public static final Interface.Manager<LeakDetector, LeakDetector.Proxy> MANAGER =
      new Interface.Manager<LeakDetector, LeakDetector.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.LeakDetector";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LeakDetector.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LeakDetector impl) {
          return new Stub(core, impl);
        }

        @Override
        public LeakDetector[] buildArray(int size) {
          return new LeakDetector[size];
        }
      };
  private static final int PERFORM_LEAK_DETECTION_ORDINAL = 0;

  LeakDetector_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements LeakDetector.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void performLeakDetection(PerformLeakDetection_Response callback) {
      LeakDetectorPerformLeakDetectionParams _message =
          new LeakDetectorPerformLeakDetectionParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new LeakDetectorPerformLeakDetectionResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<LeakDetector> {
    Stub(Core core, LeakDetector impl) {
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
                LeakDetector_Internal.MANAGER, messageWithHeader);
          default:
            return false;
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
                getCore(), LeakDetector_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            LeakDetectorPerformLeakDetectionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .performLeakDetection(
                    new LeakDetectorPerformLeakDetectionResponseParamsProxyToResponder(
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

  static final class LeakDetectorPerformLeakDetectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LeakDetectorPerformLeakDetectionParams(int version) {
      super(8, version);
    }

    public LeakDetectorPerformLeakDetectionParams() {
      this(0);
    }

    public static LeakDetectorPerformLeakDetectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LeakDetectorPerformLeakDetectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LeakDetectorPerformLeakDetectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LeakDetectorPerformLeakDetectionParams result =
            new LeakDetectorPerformLeakDetectionParams(elementsOrVersion);
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

  static final class LeakDetectorPerformLeakDetectionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public LeakDetectionResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LeakDetectorPerformLeakDetectionResponseParams(int version) {
      super(16, version);
    }

    public LeakDetectorPerformLeakDetectionResponseParams() {
      this(0);
    }

    public static LeakDetectorPerformLeakDetectionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LeakDetectorPerformLeakDetectionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LeakDetectorPerformLeakDetectionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LeakDetectorPerformLeakDetectionResponseParams result =
            new LeakDetectorPerformLeakDetectionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.result = LeakDetectionResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, true);
    }
  }

  static class LeakDetectorPerformLeakDetectionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LeakDetector.PerformLeakDetection_Response mCallback;

    LeakDetectorPerformLeakDetectionResponseParamsForwardToCallback(
        LeakDetector.PerformLeakDetection_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        LeakDetectorPerformLeakDetectionResponseParams response =
            LeakDetectorPerformLeakDetectionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LeakDetectorPerformLeakDetectionResponseParamsProxyToResponder
      implements LeakDetector.PerformLeakDetection_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LeakDetectorPerformLeakDetectionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(LeakDetectionResult result) {
      LeakDetectorPerformLeakDetectionResponseParams _response =
          new LeakDetectorPerformLeakDetectionResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
