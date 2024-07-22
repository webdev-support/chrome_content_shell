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

class BarcodeDetection_Internal {
  private static final int DETECT_ORDINAL = 0;
  public static final Interface.Manager<BarcodeDetection, BarcodeDetection.Proxy> MANAGER =
      new Interface.Manager<BarcodeDetection, BarcodeDetection.Proxy>() {
        @Override
        public String getName() {
          return "shape_detection.mojom.BarcodeDetection";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public BarcodeDetection.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, BarcodeDetection impl) {
          return new Stub(core, impl);
        }

        @Override
        public BarcodeDetection[] buildArray(int size) {
          return new BarcodeDetection[size];
        }
      };

  BarcodeDetection_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements BarcodeDetection.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void detect(BitmapN32 bitmapData, BarcodeDetection.Detect_Response callback) {
      BarcodeDetectionDetectParams _message = new BarcodeDetectionDetectParams();
      _message.bitmapData = bitmapData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new BarcodeDetectionDetectResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<BarcodeDetection> {
    Stub(Core core, BarcodeDetection impl) {
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
                BarcodeDetection_Internal.MANAGER, messageWithHeader);
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
                getCore(), BarcodeDetection_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            BarcodeDetectionDetectParams data =
                BarcodeDetectionDetectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .detect(
                    data.bitmapData,
                    new BarcodeDetectionDetectResponseParamsProxyToResponder(
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

  static final class BarcodeDetectionDetectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BitmapN32 bitmapData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BarcodeDetectionDetectParams(int version) {
      super(16, version);
    }

    public BarcodeDetectionDetectParams() {
      this(0);
    }

    public static BarcodeDetectionDetectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BarcodeDetectionDetectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BarcodeDetectionDetectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BarcodeDetectionDetectParams result = new BarcodeDetectionDetectParams(elementsOrVersion);
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

  static final class BarcodeDetectionDetectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BarcodeDetectionResult[] results;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BarcodeDetectionDetectResponseParams(int version) {
      super(16, version);
    }

    public BarcodeDetectionDetectResponseParams() {
      this(0);
    }

    public static BarcodeDetectionDetectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BarcodeDetectionDetectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BarcodeDetectionDetectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BarcodeDetectionDetectResponseParams result =
            new BarcodeDetectionDetectResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.results = new BarcodeDetectionResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.results[i1] = BarcodeDetectionResult.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      BarcodeDetectionResult[] barcodeDetectionResultArr = this.results;
      if (barcodeDetectionResultArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(barcodeDetectionResultArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        BarcodeDetectionResult[] barcodeDetectionResultArr2 = this.results;
        if (i0 < barcodeDetectionResultArr2.length) {
          encoder1.encode((Struct) barcodeDetectionResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class BarcodeDetectionDetectResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final BarcodeDetection.Detect_Response mCallback;

    BarcodeDetectionDetectResponseParamsForwardToCallback(
        BarcodeDetection.Detect_Response callback) {
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
        BarcodeDetectionDetectResponseParams response =
            BarcodeDetectionDetectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.results);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BarcodeDetectionDetectResponseParamsProxyToResponder
      implements BarcodeDetection.Detect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BarcodeDetectionDetectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BarcodeDetectionResult[] results) {
      BarcodeDetectionDetectResponseParams _response = new BarcodeDetectionDetectResponseParams();
      _response.results = results;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
