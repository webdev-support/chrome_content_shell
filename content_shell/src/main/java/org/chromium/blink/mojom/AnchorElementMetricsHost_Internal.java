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

class AnchorElementMetricsHost_Internal {
  public static final Interface.Manager<AnchorElementMetricsHost, AnchorElementMetricsHost.Proxy>
      MANAGER =
          new Interface.Manager<AnchorElementMetricsHost, AnchorElementMetricsHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.AnchorElementMetricsHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AnchorElementMetricsHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AnchorElementMetricsHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public AnchorElementMetricsHost[] buildArray(int size) {
              return new AnchorElementMetricsHost[size];
            }
          };
  private static final int PROCESS_POINTER_EVENT_USING_ML_MODEL_ORDINAL = 8;
  private static final int REPORT_ANCHOR_ELEMENTS_ENTERED_VIEWPORT_ORDINAL = 2;
  private static final int REPORT_ANCHOR_ELEMENTS_LEFT_VIEWPORT_ORDINAL = 3;
  private static final int REPORT_ANCHOR_ELEMENT_CLICK_ORDINAL = 0;
  private static final int REPORT_ANCHOR_ELEMENT_POINTER_DATA_ON_HOVER_TIMER_FIRED_ORDINAL = 7;
  private static final int REPORT_ANCHOR_ELEMENT_POINTER_DOWN_ORDINAL = 6;
  private static final int REPORT_ANCHOR_ELEMENT_POINTER_OUT_ORDINAL = 5;
  private static final int REPORT_ANCHOR_ELEMENT_POINTER_OVER_ORDINAL = 4;
  private static final int REPORT_NEW_ANCHOR_ELEMENTS_ORDINAL = 1;
  private static final int SHOULD_SKIP_UPDATE_DELAYS_ORDINAL = 9;

  AnchorElementMetricsHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AnchorElementMetricsHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void reportAnchorElementClick(AnchorElementClick clicked) {
      AnchorElementMetricsHostReportAnchorElementClickParams _message =
          new AnchorElementMetricsHostReportAnchorElementClickParams();
      _message.clicked = clicked;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void reportNewAnchorElements(AnchorElementMetrics[] metrics) {
      AnchorElementMetricsHostReportNewAnchorElementsParams _message =
          new AnchorElementMetricsHostReportNewAnchorElementsParams();
      _message.metrics = metrics;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void reportAnchorElementsEnteredViewport(AnchorElementEnteredViewport[] elements) {
      AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams _message =
          new AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams();
      _message.elements = elements;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void reportAnchorElementsLeftViewport(AnchorElementLeftViewport[] elements) {
      AnchorElementMetricsHostReportAnchorElementsLeftViewportParams _message =
          new AnchorElementMetricsHostReportAnchorElementsLeftViewportParams();
      _message.elements = elements;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void reportAnchorElementPointerOver(AnchorElementPointerOver pointerOverEvent) {
      AnchorElementMetricsHostReportAnchorElementPointerOverParams _message =
          new AnchorElementMetricsHostReportAnchorElementPointerOverParams();
      _message.pointerOverEvent = pointerOverEvent;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void reportAnchorElementPointerOut(AnchorElementPointerOut hoverEvent) {
      AnchorElementMetricsHostReportAnchorElementPointerOutParams _message =
          new AnchorElementMetricsHostReportAnchorElementPointerOutParams();
      _message.hoverEvent = hoverEvent;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void reportAnchorElementPointerDown(AnchorElementPointerDown pointerDownEvent) {
      AnchorElementMetricsHostReportAnchorElementPointerDownParams _message =
          new AnchorElementMetricsHostReportAnchorElementPointerDownParams();
      _message.pointerDownEvent = pointerDownEvent;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void reportAnchorElementPointerDataOnHoverTimerFired(
        AnchorElementPointerDataOnHoverTimerFired pointerData) {
      AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams _message =
          new AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams();
      _message.pointerData = pointerData;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void processPointerEventUsingMlModel(AnchorElementPointerEventForMlModel pointerEvent) {
      AnchorElementMetricsHostProcessPointerEventUsingMlModelParams _message =
          new AnchorElementMetricsHostProcessPointerEventUsingMlModelParams();
      _message.pointerEvent = pointerEvent;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void shouldSkipUpdateDelays(ShouldSkipUpdateDelays_Response callback) {
      AnchorElementMetricsHostShouldSkipUpdateDelaysParams _message =
          new AnchorElementMetricsHostShouldSkipUpdateDelaysParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<AnchorElementMetricsHost> {
    Stub(Core core, AnchorElementMetricsHost impl) {
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
                AnchorElementMetricsHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AnchorElementMetricsHostReportAnchorElementClickParams data =
                AnchorElementMetricsHostReportAnchorElementClickParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportAnchorElementClick(data.clicked);
            return true;
          case 1:
            AnchorElementMetricsHostReportNewAnchorElementsParams data2 =
                AnchorElementMetricsHostReportNewAnchorElementsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportNewAnchorElements(data2.metrics);
            return true;
          case 2:
            AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams data3 =
                AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportAnchorElementsEnteredViewport(data3.elements);
            return true;
          case 3:
            AnchorElementMetricsHostReportAnchorElementsLeftViewportParams data4 =
                AnchorElementMetricsHostReportAnchorElementsLeftViewportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportAnchorElementsLeftViewport(data4.elements);
            return true;
          case 4:
            AnchorElementMetricsHostReportAnchorElementPointerOverParams data5 =
                AnchorElementMetricsHostReportAnchorElementPointerOverParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportAnchorElementPointerOver(data5.pointerOverEvent);
            return true;
          case 5:
            AnchorElementMetricsHostReportAnchorElementPointerOutParams data6 =
                AnchorElementMetricsHostReportAnchorElementPointerOutParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportAnchorElementPointerOut(data6.hoverEvent);
            return true;
          case 6:
            AnchorElementMetricsHostReportAnchorElementPointerDownParams data7 =
                AnchorElementMetricsHostReportAnchorElementPointerDownParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportAnchorElementPointerDown(data7.pointerDownEvent);
            return true;
          case 7:
            AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams data8 =
                AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams
                    .deserialize(messageWithHeader.getPayload());
            getImpl().reportAnchorElementPointerDataOnHoverTimerFired(data8.pointerData);
            return true;
          case 8:
            AnchorElementMetricsHostProcessPointerEventUsingMlModelParams data9 =
                AnchorElementMetricsHostProcessPointerEventUsingMlModelParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().processPointerEventUsingMlModel(data9.pointerEvent);
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
                getCore(), AnchorElementMetricsHost_Internal.MANAGER, messageWithHeader, receiver);
          case 9:
            AnchorElementMetricsHostShouldSkipUpdateDelaysParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .shouldSkipUpdateDelays(
                    new AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParamsProxyToResponder(
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

  static final class AnchorElementMetricsHostReportAnchorElementClickParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementClick clicked;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostReportAnchorElementClickParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostReportAnchorElementClickParams() {
      this(0);
    }

    public static AnchorElementMetricsHostReportAnchorElementClickParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostReportAnchorElementClickParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostReportAnchorElementClickParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostReportAnchorElementClickParams result =
            new AnchorElementMetricsHostReportAnchorElementClickParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.clicked = AnchorElementClick.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.clicked, 8, false);
    }
  }

  static final class AnchorElementMetricsHostReportNewAnchorElementsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementMetrics[] metrics;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostReportNewAnchorElementsParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostReportNewAnchorElementsParams() {
      this(0);
    }

    public static AnchorElementMetricsHostReportNewAnchorElementsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostReportNewAnchorElementsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostReportNewAnchorElementsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostReportNewAnchorElementsParams result =
            new AnchorElementMetricsHostReportNewAnchorElementsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.metrics = new AnchorElementMetrics[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.metrics[i1] = AnchorElementMetrics.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      AnchorElementMetrics[] anchorElementMetricsArr = this.metrics;
      if (anchorElementMetricsArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(anchorElementMetricsArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        AnchorElementMetrics[] anchorElementMetricsArr2 = this.metrics;
        if (i0 < anchorElementMetricsArr2.length) {
          encoder1.encode((Struct) anchorElementMetricsArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementEnteredViewport[] elements;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams() {
      this(0);
    }

    public static AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams result =
            new AnchorElementMetricsHostReportAnchorElementsEnteredViewportParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.elements = new AnchorElementEnteredViewport[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.elements[i1] = AnchorElementEnteredViewport.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      AnchorElementEnteredViewport[] anchorElementEnteredViewportArr = this.elements;
      if (anchorElementEnteredViewportArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(anchorElementEnteredViewportArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        AnchorElementEnteredViewport[] anchorElementEnteredViewportArr2 = this.elements;
        if (i0 < anchorElementEnteredViewportArr2.length) {
          encoder1.encode((Struct) anchorElementEnteredViewportArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class AnchorElementMetricsHostReportAnchorElementsLeftViewportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementLeftViewport[] elements;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostReportAnchorElementsLeftViewportParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostReportAnchorElementsLeftViewportParams() {
      this(0);
    }

    public static AnchorElementMetricsHostReportAnchorElementsLeftViewportParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostReportAnchorElementsLeftViewportParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostReportAnchorElementsLeftViewportParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostReportAnchorElementsLeftViewportParams result =
            new AnchorElementMetricsHostReportAnchorElementsLeftViewportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.elements = new AnchorElementLeftViewport[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.elements[i1] = AnchorElementLeftViewport.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      AnchorElementLeftViewport[] anchorElementLeftViewportArr = this.elements;
      if (anchorElementLeftViewportArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(anchorElementLeftViewportArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        AnchorElementLeftViewport[] anchorElementLeftViewportArr2 = this.elements;
        if (i0 < anchorElementLeftViewportArr2.length) {
          encoder1.encode((Struct) anchorElementLeftViewportArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class AnchorElementMetricsHostReportAnchorElementPointerOverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementPointerOver pointerOverEvent;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostReportAnchorElementPointerOverParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostReportAnchorElementPointerOverParams() {
      this(0);
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerOverParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerOverParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerOverParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostReportAnchorElementPointerOverParams result =
            new AnchorElementMetricsHostReportAnchorElementPointerOverParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pointerOverEvent = AnchorElementPointerOver.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pointerOverEvent, 8, false);
    }
  }

  static final class AnchorElementMetricsHostReportAnchorElementPointerOutParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementPointerOut hoverEvent;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostReportAnchorElementPointerOutParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostReportAnchorElementPointerOutParams() {
      this(0);
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerOutParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerOutParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerOutParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostReportAnchorElementPointerOutParams result =
            new AnchorElementMetricsHostReportAnchorElementPointerOutParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.hoverEvent = AnchorElementPointerOut.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.hoverEvent, 8, false);
    }
  }

  static final class AnchorElementMetricsHostReportAnchorElementPointerDownParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementPointerDown pointerDownEvent;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostReportAnchorElementPointerDownParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostReportAnchorElementPointerDownParams() {
      this(0);
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerDownParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerDownParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerDownParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostReportAnchorElementPointerDownParams result =
            new AnchorElementMetricsHostReportAnchorElementPointerDownParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pointerDownEvent = AnchorElementPointerDown.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pointerDownEvent, 8, false);
    }
  }

  static final class AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementPointerDataOnHoverTimerFired pointerData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams(
        int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams() {
      this(0);
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams result =
            new AnchorElementMetricsHostReportAnchorElementPointerDataOnHoverTimerFiredParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pointerData = AnchorElementPointerDataOnHoverTimerFired.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pointerData, 8, false);
    }
  }

  static final class AnchorElementMetricsHostProcessPointerEventUsingMlModelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementPointerEventForMlModel pointerEvent;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostProcessPointerEventUsingMlModelParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostProcessPointerEventUsingMlModelParams() {
      this(0);
    }

    public static AnchorElementMetricsHostProcessPointerEventUsingMlModelParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostProcessPointerEventUsingMlModelParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostProcessPointerEventUsingMlModelParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostProcessPointerEventUsingMlModelParams result =
            new AnchorElementMetricsHostProcessPointerEventUsingMlModelParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pointerEvent = AnchorElementPointerEventForMlModel.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pointerEvent, 8, false);
    }
  }

  static final class AnchorElementMetricsHostShouldSkipUpdateDelaysParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostShouldSkipUpdateDelaysParams(int version) {
      super(8, version);
    }

    public AnchorElementMetricsHostShouldSkipUpdateDelaysParams() {
      this(0);
    }

    public static AnchorElementMetricsHostShouldSkipUpdateDelaysParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostShouldSkipUpdateDelaysParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostShouldSkipUpdateDelaysParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostShouldSkipUpdateDelaysParams result =
            new AnchorElementMetricsHostShouldSkipUpdateDelaysParams(elementsOrVersion);
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

  static final class AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean shouldSkipForTesting;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams(int version) {
      super(16, version);
    }

    public AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams() {
      this(0);
    }

    public static AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams result =
            new AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams(elementsOrVersion);
        result.shouldSkipForTesting = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.shouldSkipForTesting, 8, 0);
    }
  }

  static class AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AnchorElementMetricsHost.ShouldSkipUpdateDelays_Response mCallback;

    AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParamsForwardToCallback(
        AnchorElementMetricsHost.ShouldSkipUpdateDelays_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 2)) {
          return false;
        }
        AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams response =
            AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.shouldSkipForTesting);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParamsProxyToResponder
      implements AnchorElementMetricsHost.ShouldSkipUpdateDelays_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean shouldSkipForTesting) {
      AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams _response =
          new AnchorElementMetricsHostShouldSkipUpdateDelaysResponseParams();
      _response.shouldSkipForTesting = shouldSkipForTesting;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
