package org.chromium.payments.mojom;

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

class DigitalGoods_Internal {
  private static final int CONSUME_ORDINAL = 3;
  private static final int GET_DETAILS_ORDINAL = 0;
  private static final int LIST_PURCHASES_ORDINAL = 1;
  private static final int LIST_PURCHASE_HISTORY_ORDINAL = 2;
  public static final Interface.Manager<DigitalGoods, DigitalGoods.Proxy> MANAGER =
      new Interface.Manager<DigitalGoods, DigitalGoods.Proxy>() {
        @Override
        public String getName() {
          return "payments.mojom.DigitalGoods";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DigitalGoods.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DigitalGoods impl) {
          return new Stub(core, impl);
        }

        @Override
        public DigitalGoods[] buildArray(int size) {
          return new DigitalGoods[size];
        }
      };

  DigitalGoods_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements DigitalGoods.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getDetails(String[] itemIds, GetDetails_Response callback) {
      DigitalGoodsGetDetailsParams _message = new DigitalGoodsGetDetailsParams();
      _message.itemIds = itemIds;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DigitalGoodsGetDetailsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void listPurchases(ListPurchases_Response callback) {
      DigitalGoodsListPurchasesParams _message = new DigitalGoodsListPurchasesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new DigitalGoodsListPurchasesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void listPurchaseHistory(ListPurchaseHistory_Response callback) {
      DigitalGoodsListPurchaseHistoryParams _message = new DigitalGoodsListPurchaseHistoryParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new DigitalGoodsListPurchaseHistoryResponseParamsForwardToCallback(callback));
    }

    @Override
    public void consume(String purchaseToken, Consume_Response callback) {
      DigitalGoodsConsumeParams _message = new DigitalGoodsConsumeParams();
      _message.purchaseToken = purchaseToken;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new DigitalGoodsConsumeResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<DigitalGoods> {
    Stub(Core core, DigitalGoods impl) {
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
                DigitalGoods_Internal.MANAGER, messageWithHeader);
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
                getCore(), DigitalGoods_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            DigitalGoodsGetDetailsParams data =
                DigitalGoodsGetDetailsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getDetails(
                    data.itemIds,
                    new DigitalGoodsGetDetailsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            DigitalGoodsListPurchasesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .listPurchases(
                    new DigitalGoodsListPurchasesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            DigitalGoodsListPurchaseHistoryParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .listPurchaseHistory(
                    new DigitalGoodsListPurchaseHistoryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            DigitalGoodsConsumeParams data2 =
                DigitalGoodsConsumeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .consume(
                    data2.purchaseToken,
                    new DigitalGoodsConsumeResponseParamsProxyToResponder(
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

  static final class DigitalGoodsGetDetailsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] itemIds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsGetDetailsParams(int version) {
      super(16, version);
    }

    public DigitalGoodsGetDetailsParams() {
      this(0);
    }

    public static DigitalGoodsGetDetailsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsGetDetailsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsGetDetailsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsGetDetailsParams result = new DigitalGoodsGetDetailsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.itemIds = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.itemIds[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.itemIds;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.itemIds;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class DigitalGoodsGetDetailsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int code;
    public ItemDetails[] itemDetailsList;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsGetDetailsResponseParams(int version) {
      super(24, version);
    }

    public DigitalGoodsGetDetailsResponseParams() {
      this(0);
    }

    public static DigitalGoodsGetDetailsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsGetDetailsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsGetDetailsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsGetDetailsResponseParams result =
            new DigitalGoodsGetDetailsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.code = readInt;
        BillingResponseCode.validate(readInt);
        result.code = BillingResponseCode.toKnownValue(result.code);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.itemDetailsList = new ItemDetails[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.itemDetailsList[i1] = ItemDetails.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.code, 8);
      ItemDetails[] itemDetailsArr = this.itemDetailsList;
      if (itemDetailsArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(itemDetailsArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        ItemDetails[] itemDetailsArr2 = this.itemDetailsList;
        if (i0 < itemDetailsArr2.length) {
          encoder1.encode((Struct) itemDetailsArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class DigitalGoodsGetDetailsResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final DigitalGoods.GetDetails_Response mCallback;

    DigitalGoodsGetDetailsResponseParamsForwardToCallback(
        DigitalGoods.GetDetails_Response callback) {
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
        DigitalGoodsGetDetailsResponseParams response =
            DigitalGoodsGetDetailsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.code, response.itemDetailsList);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DigitalGoodsGetDetailsResponseParamsProxyToResponder
      implements DigitalGoods.GetDetails_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DigitalGoodsGetDetailsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int code, ItemDetails[] itemDetailsList) {
      DigitalGoodsGetDetailsResponseParams _response = new DigitalGoodsGetDetailsResponseParams();
      _response.code = code;
      _response.itemDetailsList = itemDetailsList;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DigitalGoodsListPurchasesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsListPurchasesParams(int version) {
      super(8, version);
    }

    public DigitalGoodsListPurchasesParams() {
      this(0);
    }

    public static DigitalGoodsListPurchasesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsListPurchasesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsListPurchasesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsListPurchasesParams result =
            new DigitalGoodsListPurchasesParams(elementsOrVersion);
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

  static final class DigitalGoodsListPurchasesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int code;
    public PurchaseReference[] purchaseReferenceList;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsListPurchasesResponseParams(int version) {
      super(24, version);
    }

    public DigitalGoodsListPurchasesResponseParams() {
      this(0);
    }

    public static DigitalGoodsListPurchasesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsListPurchasesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsListPurchasesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsListPurchasesResponseParams result =
            new DigitalGoodsListPurchasesResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.code = readInt;
        BillingResponseCode.validate(readInt);
        result.code = BillingResponseCode.toKnownValue(result.code);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.purchaseReferenceList = new PurchaseReference[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.purchaseReferenceList[i1] = PurchaseReference.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.code, 8);
      PurchaseReference[] purchaseReferenceArr = this.purchaseReferenceList;
      if (purchaseReferenceArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(purchaseReferenceArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        PurchaseReference[] purchaseReferenceArr2 = this.purchaseReferenceList;
        if (i0 < purchaseReferenceArr2.length) {
          encoder1.encode((Struct) purchaseReferenceArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class DigitalGoodsListPurchasesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DigitalGoods.ListPurchases_Response mCallback;

    DigitalGoodsListPurchasesResponseParamsForwardToCallback(
        DigitalGoods.ListPurchases_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        DigitalGoodsListPurchasesResponseParams response =
            DigitalGoodsListPurchasesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.code, response.purchaseReferenceList);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DigitalGoodsListPurchasesResponseParamsProxyToResponder
      implements DigitalGoods.ListPurchases_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DigitalGoodsListPurchasesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int code, PurchaseReference[] purchaseReferenceList) {
      DigitalGoodsListPurchasesResponseParams _response =
          new DigitalGoodsListPurchasesResponseParams();
      _response.code = code;
      _response.purchaseReferenceList = purchaseReferenceList;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DigitalGoodsListPurchaseHistoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsListPurchaseHistoryParams(int version) {
      super(8, version);
    }

    public DigitalGoodsListPurchaseHistoryParams() {
      this(0);
    }

    public static DigitalGoodsListPurchaseHistoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsListPurchaseHistoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsListPurchaseHistoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsListPurchaseHistoryParams result =
            new DigitalGoodsListPurchaseHistoryParams(elementsOrVersion);
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

  static final class DigitalGoodsListPurchaseHistoryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int code;
    public PurchaseReference[] purchaseReferenceList;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsListPurchaseHistoryResponseParams(int version) {
      super(24, version);
    }

    public DigitalGoodsListPurchaseHistoryResponseParams() {
      this(0);
    }

    public static DigitalGoodsListPurchaseHistoryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsListPurchaseHistoryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsListPurchaseHistoryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsListPurchaseHistoryResponseParams result =
            new DigitalGoodsListPurchaseHistoryResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.code = readInt;
        BillingResponseCode.validate(readInt);
        result.code = BillingResponseCode.toKnownValue(result.code);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.purchaseReferenceList = new PurchaseReference[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.purchaseReferenceList[i1] = PurchaseReference.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.code, 8);
      PurchaseReference[] purchaseReferenceArr = this.purchaseReferenceList;
      if (purchaseReferenceArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(purchaseReferenceArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        PurchaseReference[] purchaseReferenceArr2 = this.purchaseReferenceList;
        if (i0 < purchaseReferenceArr2.length) {
          encoder1.encode((Struct) purchaseReferenceArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class DigitalGoodsListPurchaseHistoryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DigitalGoods.ListPurchaseHistory_Response mCallback;

    DigitalGoodsListPurchaseHistoryResponseParamsForwardToCallback(
        DigitalGoods.ListPurchaseHistory_Response callback) {
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
        DigitalGoodsListPurchaseHistoryResponseParams response =
            DigitalGoodsListPurchaseHistoryResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.code, response.purchaseReferenceList);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DigitalGoodsListPurchaseHistoryResponseParamsProxyToResponder
      implements DigitalGoods.ListPurchaseHistory_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DigitalGoodsListPurchaseHistoryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int code, PurchaseReference[] purchaseReferenceList) {
      DigitalGoodsListPurchaseHistoryResponseParams _response =
          new DigitalGoodsListPurchaseHistoryResponseParams();
      _response.code = code;
      _response.purchaseReferenceList = purchaseReferenceList;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DigitalGoodsConsumeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String purchaseToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsConsumeParams(int version) {
      super(16, version);
    }

    public DigitalGoodsConsumeParams() {
      this(0);
    }

    public static DigitalGoodsConsumeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsConsumeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsConsumeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsConsumeParams result = new DigitalGoodsConsumeParams(elementsOrVersion);
        result.purchaseToken = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.purchaseToken, 8, false);
    }
  }

  static final class DigitalGoodsConsumeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int code;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsConsumeResponseParams(int version) {
      super(16, version);
    }

    public DigitalGoodsConsumeResponseParams() {
      this(0);
    }

    public static DigitalGoodsConsumeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsConsumeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsConsumeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsConsumeResponseParams result =
            new DigitalGoodsConsumeResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.code = readInt;
        BillingResponseCode.validate(readInt);
        result.code = BillingResponseCode.toKnownValue(result.code);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.code, 8);
    }
  }

  static class DigitalGoodsConsumeResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final DigitalGoods.Consume_Response mCallback;

    DigitalGoodsConsumeResponseParamsForwardToCallback(DigitalGoods.Consume_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        DigitalGoodsConsumeResponseParams response =
            DigitalGoodsConsumeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.code);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DigitalGoodsConsumeResponseParamsProxyToResponder
      implements DigitalGoods.Consume_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DigitalGoodsConsumeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int code) {
      DigitalGoodsConsumeResponseParams _response = new DigitalGoodsConsumeResponseParams();
      _response.code = code;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
