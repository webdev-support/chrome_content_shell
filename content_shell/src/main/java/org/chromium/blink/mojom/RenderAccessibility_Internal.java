package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.ax.mojom.AxActionData;
import org.chromium.ax.mojom.AxMode;
import org.chromium.gfx.mojom.Point;
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

class RenderAccessibility_Internal {
  private static final int FATAL_ERROR_ORDINAL = 1;
  private static final int HIT_TEST_ORDINAL = 2;
  public static final Interface.Manager<RenderAccessibility, RenderAccessibility.Proxy> MANAGER =
      new Interface.Manager<RenderAccessibility, RenderAccessibility.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.RenderAccessibility";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public RenderAccessibility.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, RenderAccessibility impl) {
          return new Stub(core, impl);
        }

        @Override
        public RenderAccessibility[] buildArray(int size) {
          return new RenderAccessibility[size];
        }
      };
  private static final int PERFORM_ACTION_ORDINAL = 3;
  private static final int RESET_ORDINAL = 4;
  private static final int SET_MODE_ORDINAL = 0;

  RenderAccessibility_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RenderAccessibility.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setMode(AxMode axMode, int resetToken) {
      RenderAccessibilitySetModeParams _message = new RenderAccessibilitySetModeParams();
      _message.axMode = axMode;
      _message.resetToken = resetToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void fatalError() {
      RenderAccessibilityFatalErrorParams _message = new RenderAccessibilityFatalErrorParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void hitTest(Point point, int eventToFire, int requestId, HitTest_Response callback) {
      RenderAccessibilityHitTestParams _message = new RenderAccessibilityHitTestParams();
      _message.point = point;
      _message.eventToFire = eventToFire;
      _message.requestId = requestId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new RenderAccessibilityHitTestResponseParamsForwardToCallback(callback));
    }

    @Override
    public void performAction(AxActionData actionData) {
      RenderAccessibilityPerformActionParams _message =
          new RenderAccessibilityPerformActionParams();
      _message.actionData = actionData;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void reset(int resetToken) {
      RenderAccessibilityResetParams _message = new RenderAccessibilityResetParams();
      _message.resetToken = resetToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<RenderAccessibility> {
    Stub(Core core, RenderAccessibility impl) {
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
                RenderAccessibility_Internal.MANAGER, messageWithHeader);
          case -1:
          case 2:
          default:
            return false;
          case 0:
            RenderAccessibilitySetModeParams data =
                RenderAccessibilitySetModeParams.deserialize(messageWithHeader.getPayload());
            getImpl().setMode(data.axMode, data.resetToken);
            return true;
          case 1:
            RenderAccessibilityFatalErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().fatalError();
            return true;
          case 3:
            getImpl()
                .performAction(
                    RenderAccessibilityPerformActionParams.deserialize(
                            messageWithHeader.getPayload())
                        .actionData);
            return true;
          case 4:
            getImpl()
                .reset(
                    RenderAccessibilityResetParams.deserialize(messageWithHeader.getPayload())
                        .resetToken);
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
                getCore(), RenderAccessibility_Internal.MANAGER, messageWithHeader, receiver);
          case 2:
            RenderAccessibilityHitTestParams data =
                RenderAccessibilityHitTestParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .hitTest(
                    data.point,
                    data.eventToFire,
                    data.requestId,
                    new RenderAccessibilityHitTestResponseParamsProxyToResponder(
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

  static final class RenderAccessibilitySetModeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AxMode axMode;
    public int resetToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilitySetModeParams(int version) {
      super(24, version);
    }

    public RenderAccessibilitySetModeParams() {
      this(0);
    }

    public static RenderAccessibilitySetModeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilitySetModeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilitySetModeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilitySetModeParams result =
            new RenderAccessibilitySetModeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.axMode = AxMode.decode(decoder1);
        result.resetToken = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.axMode, 8, false);
      encoder0.encode(this.resetToken, 16);
    }
  }

  static final class RenderAccessibilityFatalErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilityFatalErrorParams(int version) {
      super(8, version);
    }

    public RenderAccessibilityFatalErrorParams() {
      this(0);
    }

    public static RenderAccessibilityFatalErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilityFatalErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilityFatalErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilityFatalErrorParams result =
            new RenderAccessibilityFatalErrorParams(elementsOrVersion);
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

  static final class RenderAccessibilityHitTestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int eventToFire;
    public Point point;
    public int requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilityHitTestParams(int version) {
      super(24, version);
    }

    public RenderAccessibilityHitTestParams() {
      this(0);
    }

    public static RenderAccessibilityHitTestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilityHitTestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilityHitTestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilityHitTestParams result =
            new RenderAccessibilityHitTestParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.point = Point.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.eventToFire = readInt;
        org.chromium.ax.mojom.Event.validate(readInt);
        result.eventToFire = org.chromium.ax.mojom.Event.toKnownValue(result.eventToFire);
        result.requestId = decoder0.readInt(20);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.point, 8, false);
      encoder0.encode(this.eventToFire, 16);
      encoder0.encode(this.requestId, 20);
    }
  }

  static final class RenderAccessibilityHitTestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HitTestResponse hitTestResponse;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilityHitTestResponseParams(int version) {
      super(16, version);
    }

    public RenderAccessibilityHitTestResponseParams() {
      this(0);
    }

    public static RenderAccessibilityHitTestResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilityHitTestResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilityHitTestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilityHitTestResponseParams result =
            new RenderAccessibilityHitTestResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.hitTestResponse = HitTestResponse.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.hitTestResponse, 8, true);
    }
  }

  static class RenderAccessibilityHitTestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final RenderAccessibility.HitTest_Response mCallback;

    RenderAccessibilityHitTestResponseParamsForwardToCallback(
        RenderAccessibility.HitTest_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        RenderAccessibilityHitTestResponseParams response =
            RenderAccessibilityHitTestResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.hitTestResponse);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class RenderAccessibilityHitTestResponseParamsProxyToResponder
      implements RenderAccessibility.HitTest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    RenderAccessibilityHitTestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HitTestResponse hitTestResponse) {
      RenderAccessibilityHitTestResponseParams _response =
          new RenderAccessibilityHitTestResponseParams();
      _response.hitTestResponse = hitTestResponse;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class RenderAccessibilityPerformActionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AxActionData actionData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilityPerformActionParams(int version) {
      super(16, version);
    }

    public RenderAccessibilityPerformActionParams() {
      this(0);
    }

    public static RenderAccessibilityPerformActionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilityPerformActionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilityPerformActionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilityPerformActionParams result =
            new RenderAccessibilityPerformActionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.actionData = AxActionData.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.actionData, 8, false);
    }
  }

  static final class RenderAccessibilityResetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int resetToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderAccessibilityResetParams(int version) {
      super(16, version);
    }

    public RenderAccessibilityResetParams() {
      this(0);
    }

    public static RenderAccessibilityResetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RenderAccessibilityResetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderAccessibilityResetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderAccessibilityResetParams result =
            new RenderAccessibilityResetParams(elementsOrVersion);
        result.resetToken = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.resetToken, 8);
    }
  }
}
