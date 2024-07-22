package org.chromium.shape_detection.mojom;

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
import org.chromium.skia.mojom.BitmapN32;

class FaceDetection_Internal {
  private static final int DETECT_ORDINAL = 0;
  public static final Interface.Manager<FaceDetection, FaceDetection.Proxy> MANAGER =
      new Interface.Manager<FaceDetection, FaceDetection.Proxy>() {
        @Override
        public String getName() {
          return "shape_detection.mojom.FaceDetection";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FaceDetection.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FaceDetection impl) {
          return new Stub(core, impl);
        }

        @Override
        public FaceDetection[] buildArray(int size) {
          return new FaceDetection[size];
        }
      };

  FaceDetection_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements FaceDetection.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void detect(BitmapN32 bitmapData, FaceDetection.Detect_Response callback) {
      FaceDetectionDetectParams _message = new FaceDetectionDetectParams();
      _message.bitmapData = bitmapData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FaceDetectionDetectResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FaceDetection> {
    Stub(Core core, FaceDetection impl) {
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
                FaceDetection_Internal.MANAGER, messageWithHeader);
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
                getCore(), FaceDetection_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FaceDetectionDetectParams data =
                FaceDetectionDetectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .detect(
                    data.bitmapData,
                    new FaceDetectionDetectResponseParamsProxyToResponder(
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

  static final class FaceDetectionDetectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BitmapN32 bitmapData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FaceDetectionDetectParams(int version) {
      super(16, version);
    }

    public FaceDetectionDetectParams() {
      this(0);
    }

    public static FaceDetectionDetectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FaceDetectionDetectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FaceDetectionDetectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FaceDetectionDetectParams result = new FaceDetectionDetectParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.bitmapData = BitmapN32.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.bitmapData, 8, false);
    }
  }

  static final class FaceDetectionDetectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FaceDetectionResult[] results;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FaceDetectionDetectResponseParams(int version) {
      super(16, version);
    }

    public FaceDetectionDetectResponseParams() {
      this(0);
    }

    public static FaceDetectionDetectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FaceDetectionDetectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FaceDetectionDetectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FaceDetectionDetectResponseParams result =
            new FaceDetectionDetectResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.results = new FaceDetectionResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.results[i1] = FaceDetectionResult.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      FaceDetectionResult[] faceDetectionResultArr = this.results;
      if (faceDetectionResultArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(faceDetectionResultArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        FaceDetectionResult[] faceDetectionResultArr2 = this.results;
        if (i0 < faceDetectionResultArr2.length) {
          encoder1.encode((Struct) faceDetectionResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class FaceDetectionDetectResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final FaceDetection.Detect_Response mCallback;

    FaceDetectionDetectResponseParamsForwardToCallback(FaceDetection.Detect_Response callback) {
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
        FaceDetectionDetectResponseParams response =
            FaceDetectionDetectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.results);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FaceDetectionDetectResponseParamsProxyToResponder
      implements FaceDetection.Detect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FaceDetectionDetectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FaceDetectionResult[] results) {
      FaceDetectionDetectResponseParams _response = new FaceDetectionDetectResponseParams();
      _response.results = results;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
