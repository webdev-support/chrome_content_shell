package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
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

class FindInPage_Internal {
  private static final int ACTIVATE_NEAREST_FIND_RESULT_ORDINAL = 5;
  private static final int CLEAR_ACTIVE_FIND_MATCH_ORDINAL = 2;
  private static final int FIND_MATCH_RECTS_ORDINAL = 6;
  private static final int FIND_ORDINAL = 0;
  private static final int GET_NEAREST_FIND_RESULT_ORDINAL = 4;
  public static final Interface.Manager<FindInPage, FindInPage.Proxy> MANAGER =
      new Interface.Manager<FindInPage, FindInPage.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FindInPage";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FindInPage.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FindInPage impl) {
          return new Stub(core, impl);
        }

        @Override
        public FindInPage[] buildArray(int size) {
          return new FindInPage[size];
        }
      };
  private static final int SET_CLIENT_ORDINAL = 3;
  private static final int STOP_FINDING_ORDINAL = 1;

  FindInPage_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements FindInPage.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void find(int requestId, String searchText, FindOptions options) {
      FindInPageFindParams _message = new FindInPageFindParams();
      _message.requestId = requestId;
      _message.searchText = searchText;
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void stopFinding(int action) {
      FindInPageStopFindingParams _message = new FindInPageStopFindingParams();
      _message.action = action;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void clearActiveFindMatch() {
      FindInPageClearActiveFindMatchParams _message = new FindInPageClearActiveFindMatchParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void setClient(FindInPageClient client) {
      FindInPageSetClientParams _message = new FindInPageSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void getNearestFindResult(PointF point, GetNearestFindResult_Response callback) {
      FindInPageGetNearestFindResultParams _message = new FindInPageGetNearestFindResultParams();
      _message.point = point;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new FindInPageGetNearestFindResultResponseParamsForwardToCallback(callback));
    }

    @Override
    public void activateNearestFindResult(int requestId, PointF point) {
      FindInPageActivateNearestFindResultParams _message =
          new FindInPageActivateNearestFindResultParams();
      _message.requestId = requestId;
      _message.point = point;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void findMatchRects(int currentVersion, FindMatchRects_Response callback) {
      FindInPageFindMatchRectsParams _message = new FindInPageFindMatchRectsParams();
      _message.currentVersion = currentVersion;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new FindInPageFindMatchRectsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FindInPage> {
    Stub(Core core, FindInPage impl) {
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
                FindInPage_Internal.MANAGER, messageWithHeader);
          case -1:
          case 4:
          default:
            return false;
          case 0:
            FindInPageFindParams data =
                FindInPageFindParams.deserialize(messageWithHeader.getPayload());
            getImpl().find(data.requestId, data.searchText, data.options);
            return true;
          case 1:
            getImpl()
                .stopFinding(
                    FindInPageStopFindingParams.deserialize(messageWithHeader.getPayload()).action);
            return true;
          case 2:
            FindInPageClearActiveFindMatchParams.deserialize(messageWithHeader.getPayload());
            getImpl().clearActiveFindMatch();
            return true;
          case 3:
            getImpl()
                .setClient(
                    FindInPageSetClientParams.deserialize(messageWithHeader.getPayload()).client);
            return true;
          case 5:
            FindInPageActivateNearestFindResultParams data2 =
                FindInPageActivateNearestFindResultParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().activateNearestFindResult(data2.requestId, data2.point);
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
                getCore(), FindInPage_Internal.MANAGER, messageWithHeader, receiver);
          case 4:
            FindInPageGetNearestFindResultParams data =
                FindInPageGetNearestFindResultParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getNearestFindResult(
                    data.point,
                    new FindInPageGetNearestFindResultResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            FindInPageFindMatchRectsParams data2 =
                FindInPageFindMatchRectsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .findMatchRects(
                    data2.currentVersion,
                    new FindInPageFindMatchRectsResponseParamsProxyToResponder(
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

  static final class FindInPageFindParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public FindOptions options;
    public int requestId;
    public String searchText;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageFindParams(int version) {
      super(32, version);
    }

    public FindInPageFindParams() {
      this(0);
    }

    public static FindInPageFindParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageFindParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageFindParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageFindParams result = new FindInPageFindParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.searchText = decoder0.readString(16, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.options = FindOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.searchText, 16, false);
      encoder0.encode((Struct) this.options, 24, false);
    }
  }

  static final class FindInPageStopFindingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int action;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageStopFindingParams(int version) {
      super(16, version);
    }

    public FindInPageStopFindingParams() {
      this(0);
    }

    public static FindInPageStopFindingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageStopFindingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageStopFindingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageStopFindingParams result = new FindInPageStopFindingParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.action = readInt;
        StopFindAction.validate(readInt);
        result.action = StopFindAction.toKnownValue(result.action);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.action, 8);
    }
  }

  static final class FindInPageClearActiveFindMatchParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageClearActiveFindMatchParams(int version) {
      super(8, version);
    }

    public FindInPageClearActiveFindMatchParams() {
      this(0);
    }

    public static FindInPageClearActiveFindMatchParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageClearActiveFindMatchParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageClearActiveFindMatchParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageClearActiveFindMatchParams result =
            new FindInPageClearActiveFindMatchParams(elementsOrVersion);
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

  static final class FindInPageSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FindInPageClient client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageSetClientParams(int version) {
      super(16, version);
    }

    public FindInPageSetClientParams() {
      this(0);
    }

    public static FindInPageSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageSetClientParams result = new FindInPageSetClientParams(elementsOrVersion);
        result.client =
            (FindInPageClient) decoder0.readServiceInterface(8, false, FindInPageClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, FindInPageClient.MANAGER);
    }
  }

  static final class FindInPageGetNearestFindResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PointF point;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageGetNearestFindResultParams(int version) {
      super(16, version);
    }

    public FindInPageGetNearestFindResultParams() {
      this(0);
    }

    public static FindInPageGetNearestFindResultParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageGetNearestFindResultParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageGetNearestFindResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageGetNearestFindResultParams result =
            new FindInPageGetNearestFindResultParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.point = PointF.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.point, 8, false);
    }
  }

  static final class FindInPageGetNearestFindResultResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public float distance;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageGetNearestFindResultResponseParams(int version) {
      super(16, version);
    }

    public FindInPageGetNearestFindResultResponseParams() {
      this(0);
    }

    public static FindInPageGetNearestFindResultResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageGetNearestFindResultResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageGetNearestFindResultResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageGetNearestFindResultResponseParams result =
            new FindInPageGetNearestFindResultResponseParams(elementsOrVersion);
        result.distance = decoder0.readFloat(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.distance, 8);
    }
  }

  static class FindInPageGetNearestFindResultResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FindInPage.GetNearestFindResult_Response mCallback;

    FindInPageGetNearestFindResultResponseParamsForwardToCallback(
        FindInPage.GetNearestFindResult_Response callback) {
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
        FindInPageGetNearestFindResultResponseParams response =
            FindInPageGetNearestFindResultResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.distance);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FindInPageGetNearestFindResultResponseParamsProxyToResponder
      implements FindInPage.GetNearestFindResult_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FindInPageGetNearestFindResultResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(float distance) {
      FindInPageGetNearestFindResultResponseParams _response =
          new FindInPageGetNearestFindResultResponseParams();
      _response.distance = distance;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FindInPageActivateNearestFindResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PointF point;
    public int requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageActivateNearestFindResultParams(int version) {
      super(24, version);
    }

    public FindInPageActivateNearestFindResultParams() {
      this(0);
    }

    public static FindInPageActivateNearestFindResultParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageActivateNearestFindResultParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageActivateNearestFindResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageActivateNearestFindResultParams result =
            new FindInPageActivateNearestFindResultParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.point = PointF.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode((Struct) this.point, 16, false);
    }
  }

  static final class FindInPageFindMatchRectsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int currentVersion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageFindMatchRectsParams(int version) {
      super(16, version);
    }

    public FindInPageFindMatchRectsParams() {
      this(0);
    }

    public static FindInPageFindMatchRectsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageFindMatchRectsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageFindMatchRectsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageFindMatchRectsParams result =
            new FindInPageFindMatchRectsParams(elementsOrVersion);
        result.currentVersion = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.currentVersion, 8);
    }
  }

  static final class FindInPageFindMatchRectsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public RectF activeMatchRect;
    public RectF[] rects;
    public int version;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageFindMatchRectsResponseParams(int version) {
      super(32, version);
    }

    public FindInPageFindMatchRectsResponseParams() {
      this(0);
    }

    public static FindInPageFindMatchRectsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageFindMatchRectsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageFindMatchRectsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageFindMatchRectsResponseParams result =
            new FindInPageFindMatchRectsResponseParams(elementsOrVersion);
        result.version = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.rects = new RectF[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.rects[i1] = RectF.decode(decoder2);
        }
        result.activeMatchRect = RectF.decode(decoder0.readPointer(24, false));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.version, 8);
      RectF[] rectFArr = this.rects;
      if (rectFArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(rectFArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          RectF[] rectFArr2 = this.rects;
          if (i0 >= rectFArr2.length) {
            break;
          }
          encoder1.encode((Struct) rectFArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.activeMatchRect, 24, false);
    }
  }

  static class FindInPageFindMatchRectsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FindInPage.FindMatchRects_Response mCallback;

    FindInPageFindMatchRectsResponseParamsForwardToCallback(
        FindInPage.FindMatchRects_Response callback) {
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
        FindInPageFindMatchRectsResponseParams response =
            FindInPageFindMatchRectsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.version, response.rects, response.activeMatchRect);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FindInPageFindMatchRectsResponseParamsProxyToResponder
      implements FindInPage.FindMatchRects_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FindInPageFindMatchRectsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int version, RectF[] rects, RectF activeMatchRect) {
      FindInPageFindMatchRectsResponseParams _response =
          new FindInPageFindMatchRectsResponseParams();
      _response.version = version;
      _response.rects = rects;
      _response.activeMatchRect = activeMatchRect;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
