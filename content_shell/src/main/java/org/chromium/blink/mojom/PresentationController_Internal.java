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
import org.chromium.url.mojom.Url;

class PresentationController_Internal {
  public static final Interface.Manager<PresentationController, PresentationController.Proxy>
      MANAGER =
          new Interface.Manager<PresentationController, PresentationController.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.PresentationController";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PresentationController.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PresentationController impl) {
              return new Stub(core, impl);
            }

            @Override
            public PresentationController[] buildArray(int size) {
              return new PresentationController[size];
            }
          };
  private static final int ON_CONNECTION_CLOSED_ORDINAL = 3;
  private static final int ON_CONNECTION_STATE_CHANGED_ORDINAL = 2;
  private static final int ON_DEFAULT_PRESENTATION_STARTED_ORDINAL = 1;
  private static final int ON_SCREEN_AVAILABILITY_UPDATED_ORDINAL = 0;

  PresentationController_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PresentationController.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onScreenAvailabilityUpdated(Url url, int availability) {
      PresentationControllerOnScreenAvailabilityUpdatedParams _message =
          new PresentationControllerOnScreenAvailabilityUpdatedParams();
      _message.url = url;
      _message.availability = availability;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onDefaultPresentationStarted(PresentationConnectionResult result) {
      PresentationControllerOnDefaultPresentationStartedParams _message =
          new PresentationControllerOnDefaultPresentationStartedParams();
      _message.result = result;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onConnectionStateChanged(PresentationInfo presentationInfo, int newState) {
      PresentationControllerOnConnectionStateChangedParams _message =
          new PresentationControllerOnConnectionStateChangedParams();
      _message.presentationInfo = presentationInfo;
      _message.newState = newState;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onConnectionClosed(PresentationInfo presentationInfo, int reason, String message) {
      PresentationControllerOnConnectionClosedParams _message =
          new PresentationControllerOnConnectionClosedParams();
      _message.presentationInfo = presentationInfo;
      _message.reason = reason;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<PresentationController> {
    Stub(Core core, PresentationController impl) {
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
                PresentationController_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PresentationControllerOnScreenAvailabilityUpdatedParams data =
                PresentationControllerOnScreenAvailabilityUpdatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onScreenAvailabilityUpdated(data.url, data.availability);
            return true;
          case 1:
            getImpl()
                .onDefaultPresentationStarted(
                    PresentationControllerOnDefaultPresentationStartedParams.deserialize(
                            messageWithHeader.getPayload())
                        .result);
            return true;
          case 2:
            PresentationControllerOnConnectionStateChangedParams data2 =
                PresentationControllerOnConnectionStateChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onConnectionStateChanged(data2.presentationInfo, data2.newState);
            return true;
          case 3:
            PresentationControllerOnConnectionClosedParams data3 =
                PresentationControllerOnConnectionClosedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onConnectionClosed(data3.presentationInfo, data3.reason, data3.message);
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
                getCore(), PresentationController_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PresentationControllerOnScreenAvailabilityUpdatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int availability;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationControllerOnScreenAvailabilityUpdatedParams(int version) {
      super(24, version);
    }

    public PresentationControllerOnScreenAvailabilityUpdatedParams() {
      this(0);
    }

    public static PresentationControllerOnScreenAvailabilityUpdatedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationControllerOnScreenAvailabilityUpdatedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationControllerOnScreenAvailabilityUpdatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationControllerOnScreenAvailabilityUpdatedParams result =
            new PresentationControllerOnScreenAvailabilityUpdatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.availability = readInt;
        ScreenAvailability.validate(readInt);
        result.availability = ScreenAvailability.toKnownValue(result.availability);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.availability, 16);
    }
  }

  static final class PresentationControllerOnDefaultPresentationStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PresentationConnectionResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationControllerOnDefaultPresentationStartedParams(int version) {
      super(16, version);
    }

    public PresentationControllerOnDefaultPresentationStartedParams() {
      this(0);
    }

    public static PresentationControllerOnDefaultPresentationStartedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationControllerOnDefaultPresentationStartedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationControllerOnDefaultPresentationStartedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationControllerOnDefaultPresentationStartedParams result =
            new PresentationControllerOnDefaultPresentationStartedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = PresentationConnectionResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static final class PresentationControllerOnConnectionStateChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int newState;
    public PresentationInfo presentationInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationControllerOnConnectionStateChangedParams(int version) {
      super(24, version);
    }

    public PresentationControllerOnConnectionStateChangedParams() {
      this(0);
    }

    public static PresentationControllerOnConnectionStateChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationControllerOnConnectionStateChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationControllerOnConnectionStateChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationControllerOnConnectionStateChangedParams result =
            new PresentationControllerOnConnectionStateChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.presentationInfo = PresentationInfo.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.newState = readInt;
        PresentationConnectionState.validate(readInt);
        result.newState = PresentationConnectionState.toKnownValue(result.newState);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.presentationInfo, 8, false);
      encoder0.encode(this.newState, 16);
    }
  }

  static final class PresentationControllerOnConnectionClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String message;
    public PresentationInfo presentationInfo;
    public int reason;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationControllerOnConnectionClosedParams(int version) {
      super(32, version);
    }

    public PresentationControllerOnConnectionClosedParams() {
      this(0);
    }

    public static PresentationControllerOnConnectionClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationControllerOnConnectionClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationControllerOnConnectionClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationControllerOnConnectionClosedParams result =
            new PresentationControllerOnConnectionClosedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.presentationInfo = PresentationInfo.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.reason = readInt;
        PresentationConnectionCloseReason.validate(readInt);
        result.reason = PresentationConnectionCloseReason.toKnownValue(result.reason);
        result.message = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.presentationInfo, 8, false);
      encoder0.encode(this.reason, 16);
      encoder0.encode(this.message, 24, false);
    }
  }
}
