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
import org.chromium.url.mojom.Url;

class PresentationService_Internal {
  private static final int CLOSE_CONNECTION_ORDINAL = 7;
  private static final int LISTEN_FOR_SCREEN_AVAILABILITY_ORDINAL = 3;
  public static final Interface.Manager<PresentationService, PresentationService.Proxy> MANAGER =
      new Interface.Manager<PresentationService, PresentationService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PresentationService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PresentationService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PresentationService impl) {
          return new Stub(core, impl);
        }

        @Override
        public PresentationService[] buildArray(int size) {
          return new PresentationService[size];
        }
      };
  private static final int RECONNECT_PRESENTATION_ORDINAL = 6;
  private static final int SET_CONTROLLER_ORDINAL = 0;
  private static final int SET_DEFAULT_PRESENTATION_URLS_ORDINAL = 2;
  private static final int SET_RECEIVER_ORDINAL = 1;
  private static final int START_PRESENTATION_ORDINAL = 5;
  private static final int STOP_LISTENING_FOR_SCREEN_AVAILABILITY_ORDINAL = 4;
  private static final int TERMINATE_ORDINAL = 8;

  PresentationService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PresentationService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setController(PresentationController controller) {
      PresentationServiceSetControllerParams _message =
          new PresentationServiceSetControllerParams();
      _message.controller = controller;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setReceiver(PresentationReceiver receiver) {
      PresentationServiceSetReceiverParams _message = new PresentationServiceSetReceiverParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setDefaultPresentationUrls(Url[] presentationUrls) {
      PresentationServiceSetDefaultPresentationUrlsParams _message =
          new PresentationServiceSetDefaultPresentationUrlsParams();
      _message.presentationUrls = presentationUrls;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void listenForScreenAvailability(Url availabilityUrl) {
      PresentationServiceListenForScreenAvailabilityParams _message =
          new PresentationServiceListenForScreenAvailabilityParams();
      _message.availabilityUrl = availabilityUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void stopListeningForScreenAvailability(Url availabilityUrl) {
      PresentationServiceStopListeningForScreenAvailabilityParams _message =
          new PresentationServiceStopListeningForScreenAvailabilityParams();
      _message.availabilityUrl = availabilityUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void startPresentation(Url[] presentationUrls, StartPresentation_Response callback) {
      PresentationServiceStartPresentationParams _message =
          new PresentationServiceStartPresentationParams();
      _message.presentationUrls = presentationUrls;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new PresentationServiceStartPresentationResponseParamsForwardToCallback(callback));
    }

    @Override
    public void reconnectPresentation(
        Url[] presentationUrls, String presentationId, ReconnectPresentation_Response callback) {
      PresentationServiceReconnectPresentationParams _message =
          new PresentationServiceReconnectPresentationParams();
      _message.presentationUrls = presentationUrls;
      _message.presentationId = presentationId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new PresentationServiceReconnectPresentationResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void closeConnection(Url presentationUrl, String presentationId) {
      PresentationServiceCloseConnectionParams _message =
          new PresentationServiceCloseConnectionParams();
      _message.presentationUrl = presentationUrl;
      _message.presentationId = presentationId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void terminate(Url presentationUrl, String presentationId) {
      PresentationServiceTerminateParams _message = new PresentationServiceTerminateParams();
      _message.presentationUrl = presentationUrl;
      _message.presentationId = presentationId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<PresentationService> {
    Stub(Core core, PresentationService impl) {
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
                PresentationService_Internal.MANAGER, messageWithHeader);
          case -1:
          case 5:
          case 6:
          default:
            return false;
          case 0:
            PresentationServiceSetControllerParams data =
                PresentationServiceSetControllerParams.deserialize(messageWithHeader.getPayload());
            getImpl().setController(data.controller);
            return true;
          case 1:
            PresentationServiceSetReceiverParams data2 =
                PresentationServiceSetReceiverParams.deserialize(messageWithHeader.getPayload());
            getImpl().setReceiver(data2.receiver);
            return true;
          case 2:
            PresentationServiceSetDefaultPresentationUrlsParams data3 =
                PresentationServiceSetDefaultPresentationUrlsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setDefaultPresentationUrls(data3.presentationUrls);
            return true;
          case 3:
            PresentationServiceListenForScreenAvailabilityParams data4 =
                PresentationServiceListenForScreenAvailabilityParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().listenForScreenAvailability(data4.availabilityUrl);
            return true;
          case 4:
            PresentationServiceStopListeningForScreenAvailabilityParams data5 =
                PresentationServiceStopListeningForScreenAvailabilityParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().stopListeningForScreenAvailability(data5.availabilityUrl);
            return true;
          case 7:
            PresentationServiceCloseConnectionParams data6 =
                PresentationServiceCloseConnectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().closeConnection(data6.presentationUrl, data6.presentationId);
            return true;
          case 8:
            PresentationServiceTerminateParams data7 =
                PresentationServiceTerminateParams.deserialize(messageWithHeader.getPayload());
            getImpl().terminate(data7.presentationUrl, data7.presentationId);
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
                getCore(), PresentationService_Internal.MANAGER, messageWithHeader, receiver);
          case 5:
            getImpl()
                .startPresentation(
                    PresentationServiceStartPresentationParams.deserialize(
                            messageWithHeader.getPayload())
                        .presentationUrls,
                    new PresentationServiceStartPresentationResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            PresentationServiceReconnectPresentationParams data =
                PresentationServiceReconnectPresentationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .reconnectPresentation(
                    data.presentationUrls,
                    data.presentationId,
                    new PresentationServiceReconnectPresentationResponseParamsProxyToResponder(
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

  static final class PresentationServiceSetControllerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PresentationController controller;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceSetControllerParams(int version) {
      super(16, version);
    }

    public PresentationServiceSetControllerParams() {
      this(0);
    }

    public static PresentationServiceSetControllerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceSetControllerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceSetControllerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceSetControllerParams result =
            new PresentationServiceSetControllerParams(elementsOrVersion);
        result.controller =
            (PresentationController)
                decoder0.readServiceInterface(8, false, PresentationController.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.controller, 8, false, PresentationController.MANAGER);
    }
  }

  static final class PresentationServiceSetReceiverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PresentationReceiver receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceSetReceiverParams(int version) {
      super(16, version);
    }

    public PresentationServiceSetReceiverParams() {
      this(0);
    }

    public static PresentationServiceSetReceiverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceSetReceiverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceSetReceiverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceSetReceiverParams result =
            new PresentationServiceSetReceiverParams(elementsOrVersion);
        result.receiver =
            (PresentationReceiver)
                decoder0.readServiceInterface(8, false, PresentationReceiver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.receiver, 8, false, PresentationReceiver.MANAGER);
    }
  }

  static final class PresentationServiceSetDefaultPresentationUrlsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url[] presentationUrls;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceSetDefaultPresentationUrlsParams(int version) {
      super(16, version);
    }

    public PresentationServiceSetDefaultPresentationUrlsParams() {
      this(0);
    }

    public static PresentationServiceSetDefaultPresentationUrlsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceSetDefaultPresentationUrlsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceSetDefaultPresentationUrlsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceSetDefaultPresentationUrlsParams result =
            new PresentationServiceSetDefaultPresentationUrlsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.presentationUrls = new Url[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.presentationUrls[i1] = Url.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Url[] urlArr = this.presentationUrls;
      if (urlArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.presentationUrls;
        if (i0 < urlArr2.length) {
          encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class PresentationServiceListenForScreenAvailabilityParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url availabilityUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceListenForScreenAvailabilityParams(int version) {
      super(16, version);
    }

    public PresentationServiceListenForScreenAvailabilityParams() {
      this(0);
    }

    public static PresentationServiceListenForScreenAvailabilityParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceListenForScreenAvailabilityParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceListenForScreenAvailabilityParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceListenForScreenAvailabilityParams result =
            new PresentationServiceListenForScreenAvailabilityParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.availabilityUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.availabilityUrl, 8, false);
    }
  }

  static final class PresentationServiceStopListeningForScreenAvailabilityParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url availabilityUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceStopListeningForScreenAvailabilityParams(int version) {
      super(16, version);
    }

    public PresentationServiceStopListeningForScreenAvailabilityParams() {
      this(0);
    }

    public static PresentationServiceStopListeningForScreenAvailabilityParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceStopListeningForScreenAvailabilityParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceStopListeningForScreenAvailabilityParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceStopListeningForScreenAvailabilityParams result =
            new PresentationServiceStopListeningForScreenAvailabilityParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.availabilityUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.availabilityUrl, 8, false);
    }
  }

  static final class PresentationServiceStartPresentationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url[] presentationUrls;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceStartPresentationParams(int version) {
      super(16, version);
    }

    public PresentationServiceStartPresentationParams() {
      this(0);
    }

    public static PresentationServiceStartPresentationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceStartPresentationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceStartPresentationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceStartPresentationParams result =
            new PresentationServiceStartPresentationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.presentationUrls = new Url[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.presentationUrls[i1] = Url.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Url[] urlArr = this.presentationUrls;
      if (urlArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.presentationUrls;
        if (i0 < urlArr2.length) {
          encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class PresentationServiceStartPresentationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PresentationError error;
    public PresentationConnectionResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceStartPresentationResponseParams(int version) {
      super(24, version);
    }

    public PresentationServiceStartPresentationResponseParams() {
      this(0);
    }

    public static PresentationServiceStartPresentationResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceStartPresentationResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceStartPresentationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceStartPresentationResponseParams result =
            new PresentationServiceStartPresentationResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.result = PresentationConnectionResult.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.error = PresentationError.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, true);
      encoder0.encode((Struct) this.error, 16, true);
    }
  }

  static class PresentationServiceStartPresentationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PresentationService.StartPresentation_Response mCallback;

    PresentationServiceStartPresentationResponseParamsForwardToCallback(
        PresentationService.StartPresentation_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        PresentationServiceStartPresentationResponseParams response =
            PresentationServiceStartPresentationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PresentationServiceStartPresentationResponseParamsProxyToResponder
      implements PresentationService.StartPresentation_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PresentationServiceStartPresentationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(PresentationConnectionResult result, PresentationError error) {
      PresentationServiceStartPresentationResponseParams _response =
          new PresentationServiceStartPresentationResponseParams();
      _response.result = result;
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PresentationServiceReconnectPresentationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String presentationId;
    public Url[] presentationUrls;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceReconnectPresentationParams(int version) {
      super(24, version);
    }

    public PresentationServiceReconnectPresentationParams() {
      this(0);
    }

    public static PresentationServiceReconnectPresentationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceReconnectPresentationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceReconnectPresentationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceReconnectPresentationParams result =
            new PresentationServiceReconnectPresentationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.presentationUrls = new Url[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.presentationUrls[i1] = Url.decode(decoder2);
        }
        result.presentationId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Url[] urlArr = this.presentationUrls;
      if (urlArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          Url[] urlArr2 = this.presentationUrls;
          if (i0 >= urlArr2.length) {
            break;
          }
          encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.presentationId, 16, false);
    }
  }

  static final class PresentationServiceReconnectPresentationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PresentationError error;
    public PresentationConnectionResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceReconnectPresentationResponseParams(int version) {
      super(24, version);
    }

    public PresentationServiceReconnectPresentationResponseParams() {
      this(0);
    }

    public static PresentationServiceReconnectPresentationResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceReconnectPresentationResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceReconnectPresentationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceReconnectPresentationResponseParams result =
            new PresentationServiceReconnectPresentationResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.result = PresentationConnectionResult.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.error = PresentationError.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, true);
      encoder0.encode((Struct) this.error, 16, true);
    }
  }

  static class PresentationServiceReconnectPresentationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PresentationService.ReconnectPresentation_Response mCallback;

    PresentationServiceReconnectPresentationResponseParamsForwardToCallback(
        PresentationService.ReconnectPresentation_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        PresentationServiceReconnectPresentationResponseParams response =
            PresentationServiceReconnectPresentationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PresentationServiceReconnectPresentationResponseParamsProxyToResponder
      implements PresentationService.ReconnectPresentation_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PresentationServiceReconnectPresentationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(PresentationConnectionResult result, PresentationError error) {
      PresentationServiceReconnectPresentationResponseParams _response =
          new PresentationServiceReconnectPresentationResponseParams();
      _response.result = result;
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PresentationServiceCloseConnectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String presentationId;
    public Url presentationUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceCloseConnectionParams(int version) {
      super(24, version);
    }

    public PresentationServiceCloseConnectionParams() {
      this(0);
    }

    public static PresentationServiceCloseConnectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceCloseConnectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceCloseConnectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceCloseConnectionParams result =
            new PresentationServiceCloseConnectionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.presentationUrl = Url.decode(decoder1);
        result.presentationId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.presentationUrl, 8, false);
      encoder0.encode(this.presentationId, 16, false);
    }
  }

  static final class PresentationServiceTerminateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String presentationId;
    public Url presentationUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationServiceTerminateParams(int version) {
      super(24, version);
    }

    public PresentationServiceTerminateParams() {
      this(0);
    }

    public static PresentationServiceTerminateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationServiceTerminateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationServiceTerminateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationServiceTerminateParams result =
            new PresentationServiceTerminateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.presentationUrl = Url.decode(decoder1);
        result.presentationId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.presentationUrl, 8, false);
      encoder0.encode(this.presentationId, 16, false);
    }
  }
}
