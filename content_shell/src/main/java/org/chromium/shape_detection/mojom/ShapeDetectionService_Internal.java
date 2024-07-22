package org.chromium.shape_detection.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class ShapeDetectionService_Internal {
  private static final int BIND_BARCODE_DETECTION_PROVIDER_ORDINAL = 0;
  private static final int BIND_FACE_DETECTION_PROVIDER_ORDINAL = 1;
  private static final int BIND_TEXT_DETECTION_ORDINAL = 2;
  public static final Interface.Manager<ShapeDetectionService, ShapeDetectionService.Proxy>
      MANAGER =
          new Interface.Manager<ShapeDetectionService, ShapeDetectionService.Proxy>() {
            @Override
            public String getName() {
              return "shape_detection.mojom.ShapeDetectionService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ShapeDetectionService.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ShapeDetectionService impl) {
              return new Stub(core, impl);
            }

            @Override
            public ShapeDetectionService[] buildArray(int size) {
              return new ShapeDetectionService[size];
            }
          };

  ShapeDetectionService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ShapeDetectionService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void bindBarcodeDetectionProvider(InterfaceRequest<BarcodeDetectionProvider> receiver) {
      ShapeDetectionServiceBindBarcodeDetectionProviderParams _message =
          new ShapeDetectionServiceBindBarcodeDetectionProviderParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void bindFaceDetectionProvider(InterfaceRequest<FaceDetectionProvider> receiver) {
      ShapeDetectionServiceBindFaceDetectionProviderParams _message =
          new ShapeDetectionServiceBindFaceDetectionProviderParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void bindTextDetection(InterfaceRequest<TextDetection> receiver) {
      ShapeDetectionServiceBindTextDetectionParams _message =
          new ShapeDetectionServiceBindTextDetectionParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<ShapeDetectionService> {
    Stub(Core core, ShapeDetectionService impl) {
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
                ShapeDetectionService_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ShapeDetectionServiceBindBarcodeDetectionProviderParams data =
                ShapeDetectionServiceBindBarcodeDetectionProviderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().bindBarcodeDetectionProvider(data.receiver);
            return true;
          case 1:
            ShapeDetectionServiceBindFaceDetectionProviderParams data2 =
                ShapeDetectionServiceBindFaceDetectionProviderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().bindFaceDetectionProvider(data2.receiver);
            return true;
          case 2:
            ShapeDetectionServiceBindTextDetectionParams data3 =
                ShapeDetectionServiceBindTextDetectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().bindTextDetection(data3.receiver);
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
                getCore(), ShapeDetectionService_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ShapeDetectionServiceBindBarcodeDetectionProviderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<BarcodeDetectionProvider> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ShapeDetectionServiceBindBarcodeDetectionProviderParams(int version) {
      super(16, version);
    }

    public ShapeDetectionServiceBindBarcodeDetectionProviderParams() {
      this(0);
    }

    public static ShapeDetectionServiceBindBarcodeDetectionProviderParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ShapeDetectionServiceBindBarcodeDetectionProviderParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ShapeDetectionServiceBindBarcodeDetectionProviderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ShapeDetectionServiceBindBarcodeDetectionProviderParams result =
            new ShapeDetectionServiceBindBarcodeDetectionProviderParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }

  static final class ShapeDetectionServiceBindFaceDetectionProviderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<FaceDetectionProvider> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ShapeDetectionServiceBindFaceDetectionProviderParams(int version) {
      super(16, version);
    }

    public ShapeDetectionServiceBindFaceDetectionProviderParams() {
      this(0);
    }

    public static ShapeDetectionServiceBindFaceDetectionProviderParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ShapeDetectionServiceBindFaceDetectionProviderParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ShapeDetectionServiceBindFaceDetectionProviderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ShapeDetectionServiceBindFaceDetectionProviderParams result =
            new ShapeDetectionServiceBindFaceDetectionProviderParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }

  static final class ShapeDetectionServiceBindTextDetectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<TextDetection> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ShapeDetectionServiceBindTextDetectionParams(int version) {
      super(16, version);
    }

    public ShapeDetectionServiceBindTextDetectionParams() {
      this(0);
    }

    public static ShapeDetectionServiceBindTextDetectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ShapeDetectionServiceBindTextDetectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ShapeDetectionServiceBindTextDetectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ShapeDetectionServiceBindTextDetectionParams result =
            new ShapeDetectionServiceBindTextDetectionParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }
}
