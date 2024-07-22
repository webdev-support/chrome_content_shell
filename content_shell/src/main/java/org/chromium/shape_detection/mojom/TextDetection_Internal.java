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

class TextDetection_Internal {
  private static final int DETECT_ORDINAL = 0;
  public static final Interface.Manager<TextDetection, TextDetection.Proxy> MANAGER =
      new Interface.Manager<TextDetection, TextDetection.Proxy>() {
        @Override
        public String getName() {
          return "shape_detection.mojom.TextDetection";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public TextDetection.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, TextDetection impl) {
          return new Stub(core, impl);
        }

        @Override
        public TextDetection[] buildArray(int size) {
          return new TextDetection[size];
        }
      };

  TextDetection_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements TextDetection.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void detect(BitmapN32 bitmapData, TextDetection.Detect_Response callback) {
      TextDetectionDetectParams _message = new TextDetectionDetectParams();
      _message.bitmapData = bitmapData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new TextDetectionDetectResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<TextDetection> {
    Stub(Core core, TextDetection impl) {
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
                TextDetection_Internal.MANAGER, messageWithHeader);
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
                getCore(), TextDetection_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            TextDetectionDetectParams data =
                TextDetectionDetectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .detect(
                    data.bitmapData,
                    new TextDetectionDetectResponseParamsProxyToResponder(
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

  static final class TextDetectionDetectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BitmapN32 bitmapData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextDetectionDetectParams(int version) {
      super(16, version);
    }

    public TextDetectionDetectParams() {
      this(0);
    }

    public static TextDetectionDetectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextDetectionDetectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextDetectionDetectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextDetectionDetectParams result = new TextDetectionDetectParams(elementsOrVersion);
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

  static final class TextDetectionDetectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TextDetectionResult[] results;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextDetectionDetectResponseParams(int version) {
      super(16, version);
    }

    public TextDetectionDetectResponseParams() {
      this(0);
    }

    public static TextDetectionDetectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextDetectionDetectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextDetectionDetectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextDetectionDetectResponseParams result =
            new TextDetectionDetectResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.results = new TextDetectionResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.results[i1] = TextDetectionResult.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      TextDetectionResult[] textDetectionResultArr = this.results;
      if (textDetectionResultArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(textDetectionResultArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        TextDetectionResult[] textDetectionResultArr2 = this.results;
        if (i0 < textDetectionResultArr2.length) {
          encoder1.encode((Struct) textDetectionResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class TextDetectionDetectResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final TextDetection.Detect_Response mCallback;

    TextDetectionDetectResponseParamsForwardToCallback(TextDetection.Detect_Response callback) {
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
        TextDetectionDetectResponseParams response =
            TextDetectionDetectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.results);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TextDetectionDetectResponseParamsProxyToResponder
      implements TextDetection.Detect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TextDetectionDetectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(TextDetectionResult[] results) {
      TextDetectionDetectResponseParams _response = new TextDetectionDetectResponseParams();
      _response.results = results;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
