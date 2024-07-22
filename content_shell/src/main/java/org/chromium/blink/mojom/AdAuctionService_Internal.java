package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Uuid;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

class AdAuctionService_Internal {
  private static final int CLEAR_ORIGIN_JOINED_INTEREST_GROUPS_ORDINAL = 7;
  private static final int CREATE_AD_REQUEST_ORDINAL = 0;
  private static final int CREATE_AUCTION_NONCE_ORDINAL = 2;
  private static final int DEPRECATED_GET_URL_FROM_URN_ORDINAL = 9;
  private static final int DEPRECATED_REPLACE_IN_URN_ORDINAL = 10;
  private static final int FINALIZE_AD_ORDINAL = 1;
  private static final int GET_INTEREST_GROUP_AD_AUCTION_DATA_ORDINAL = 11;
  private static final int JOIN_INTEREST_GROUP_ORDINAL = 4;
  private static final int LEAVE_INTEREST_GROUP_FOR_DOCUMENT_ORDINAL = 6;
  private static final int LEAVE_INTEREST_GROUP_ORDINAL = 5;
  public static final Interface.Manager<AdAuctionService, AdAuctionService.Proxy> MANAGER =
      new Interface.Manager<AdAuctionService, AdAuctionService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.AdAuctionService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AdAuctionService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AdAuctionService impl) {
          return new Stub(core, impl);
        }

        @Override
        public AdAuctionService[] buildArray(int size) {
          return new AdAuctionService[size];
        }
      };
  private static final int RUN_AD_AUCTION_ORDINAL = 3;
  private static final int UPDATE_AD_INTEREST_GROUPS_ORDINAL = 8;

  AdAuctionService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AdAuctionService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createAdRequest(AdRequestConfig config, CreateAdRequest_Response callback) {
      AdAuctionServiceCreateAdRequestParams _message = new AdAuctionServiceCreateAdRequestParams();
      _message.config = config;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new AdAuctionServiceCreateAdRequestResponseParamsForwardToCallback(callback));
    }

    @Override
    public void finalizeAd(String adsGuid, AuctionAdConfig config, FinalizeAd_Response callback) {
      AdAuctionServiceFinalizeAdParams _message = new AdAuctionServiceFinalizeAdParams();
      _message.adsGuid = adsGuid;
      _message.config = config;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new AdAuctionServiceFinalizeAdResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createAuctionNonce(CreateAuctionNonce_Response callback) {
      AdAuctionServiceCreateAuctionNonceParams _message =
          new AdAuctionServiceCreateAuctionNonceParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new AdAuctionServiceCreateAuctionNonceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void runAdAuction(
        AuctionAdConfig config,
        InterfaceRequest<AbortableAdAuction> abortReceiver,
        RunAdAuction_Response callback) {
      AdAuctionServiceRunAdAuctionParams _message = new AdAuctionServiceRunAdAuctionParams();
      _message.config = config;
      _message.abortReceiver = abortReceiver;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new AdAuctionServiceRunAdAuctionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void joinInterestGroup(InterestGroup group, JoinInterestGroup_Response callback) {
      AdAuctionServiceJoinInterestGroupParams _message =
          new AdAuctionServiceJoinInterestGroupParams();
      _message.group = group;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new AdAuctionServiceJoinInterestGroupResponseParamsForwardToCallback(callback));
    }

    @Override
    public void leaveInterestGroup(
        Origin owner, String name, LeaveInterestGroup_Response callback) {
      AdAuctionServiceLeaveInterestGroupParams _message =
          new AdAuctionServiceLeaveInterestGroupParams();
      _message.owner = owner;
      _message.name = name;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new AdAuctionServiceLeaveInterestGroupResponseParamsForwardToCallback(callback));
    }

    @Override
    public void leaveInterestGroupForDocument() {
      AdAuctionServiceLeaveInterestGroupForDocumentParams _message =
          new AdAuctionServiceLeaveInterestGroupForDocumentParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void clearOriginJoinedInterestGroups(
        Origin owner,
        String[] interestGroupsToKeep,
        ClearOriginJoinedInterestGroups_Response callback) {
      AdAuctionServiceClearOriginJoinedInterestGroupsParams _message =
          new AdAuctionServiceClearOriginJoinedInterestGroupsParams();
      _message.owner = owner;
      _message.interestGroupsToKeep = interestGroupsToKeep;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new AdAuctionServiceClearOriginJoinedInterestGroupsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void updateAdInterestGroups() {
      AdAuctionServiceUpdateAdInterestGroupsParams _message =
          new AdAuctionServiceUpdateAdInterestGroupsParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void deprecatedGetUrlFromUrn(
        Url uuidUrl, boolean sendReports, DeprecatedGetUrlFromUrn_Response callback) {
      AdAuctionServiceDeprecatedGetUrlFromUrnParams _message =
          new AdAuctionServiceDeprecatedGetUrlFromUrnParams();
      _message.uuidUrl = uuidUrl;
      _message.sendReports = sendReports;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new AdAuctionServiceDeprecatedGetUrlFromUrnResponseParamsForwardToCallback(callback));
    }

    @Override
    public void deprecatedReplaceInUrn(
        Url uuidUrl,
        AdKeywordReplacement[] replacements,
        DeprecatedReplaceInUrn_Response callback) {
      AdAuctionServiceDeprecatedReplaceInUrnParams _message =
          new AdAuctionServiceDeprecatedReplaceInUrnParams();
      _message.uuidUrl = uuidUrl;
      _message.replacements = replacements;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new AdAuctionServiceDeprecatedReplaceInUrnResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getInterestGroupAdAuctionData(
        Origin seller, Origin coordinator, GetInterestGroupAdAuctionData_Response callback) {
      AdAuctionServiceGetInterestGroupAdAuctionDataParams _message =
          new AdAuctionServiceGetInterestGroupAdAuctionDataParams();
      _message.seller = seller;
      _message.coordinator = coordinator;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new AdAuctionServiceGetInterestGroupAdAuctionDataResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<AdAuctionService> {
    Stub(Core core, AdAuctionService impl) {
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
                AdAuctionService_Internal.MANAGER, messageWithHeader);
          case 6:
            AdAuctionServiceLeaveInterestGroupForDocumentParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().leaveInterestGroupForDocument();
            return true;
          case 8:
            AdAuctionServiceUpdateAdInterestGroupsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().updateAdInterestGroups();
            return true;
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
                getCore(), AdAuctionService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .createAdRequest(
                    AdAuctionServiceCreateAdRequestParams.deserialize(
                            messageWithHeader.getPayload())
                        .config,
                    new AdAuctionServiceCreateAdRequestResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            AdAuctionServiceFinalizeAdParams data =
                AdAuctionServiceFinalizeAdParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .finalizeAd(
                    data.adsGuid,
                    data.config,
                    new AdAuctionServiceFinalizeAdResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            AdAuctionServiceCreateAuctionNonceParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createAuctionNonce(
                    new AdAuctionServiceCreateAuctionNonceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            AdAuctionServiceRunAdAuctionParams data2 =
                AdAuctionServiceRunAdAuctionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .runAdAuction(
                    data2.config,
                    data2.abortReceiver,
                    new AdAuctionServiceRunAdAuctionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            AdAuctionServiceJoinInterestGroupParams data3 =
                AdAuctionServiceJoinInterestGroupParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .joinInterestGroup(
                    data3.group,
                    new AdAuctionServiceJoinInterestGroupResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            AdAuctionServiceLeaveInterestGroupParams data4 =
                AdAuctionServiceLeaveInterestGroupParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .leaveInterestGroup(
                    data4.owner,
                    data4.name,
                    new AdAuctionServiceLeaveInterestGroupResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
          case 8:
          default:
            return false;
          case 7:
            AdAuctionServiceClearOriginJoinedInterestGroupsParams data5 =
                AdAuctionServiceClearOriginJoinedInterestGroupsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearOriginJoinedInterestGroups(
                    data5.owner,
                    data5.interestGroupsToKeep,
                    new AdAuctionServiceClearOriginJoinedInterestGroupsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            AdAuctionServiceDeprecatedGetUrlFromUrnParams data6 =
                AdAuctionServiceDeprecatedGetUrlFromUrnParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .deprecatedGetUrlFromUrn(
                    data6.uuidUrl,
                    data6.sendReports,
                    new AdAuctionServiceDeprecatedGetUrlFromUrnResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 10:
            AdAuctionServiceDeprecatedReplaceInUrnParams data7 =
                AdAuctionServiceDeprecatedReplaceInUrnParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .deprecatedReplaceInUrn(
                    data7.uuidUrl,
                    data7.replacements,
                    new AdAuctionServiceDeprecatedReplaceInUrnResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            AdAuctionServiceGetInterestGroupAdAuctionDataParams data8 =
                AdAuctionServiceGetInterestGroupAdAuctionDataParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getInterestGroupAdAuctionData(
                    data8.seller,
                    data8.coordinator,
                    new AdAuctionServiceGetInterestGroupAdAuctionDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AdAuctionServiceCreateAdRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AdRequestConfig config;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceCreateAdRequestParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceCreateAdRequestParams() {
      this(0);
    }

    public static AdAuctionServiceCreateAdRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceCreateAdRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceCreateAdRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceCreateAdRequestParams result =
            new AdAuctionServiceCreateAdRequestParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = AdRequestConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.config, 8, false);
    }
  }

  static final class AdAuctionServiceCreateAdRequestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String adsGuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceCreateAdRequestResponseParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceCreateAdRequestResponseParams() {
      this(0);
    }

    public static AdAuctionServiceCreateAdRequestResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceCreateAdRequestResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceCreateAdRequestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceCreateAdRequestResponseParams result =
            new AdAuctionServiceCreateAdRequestResponseParams(elementsOrVersion);
        result.adsGuid = decoder0.readString(8, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.adsGuid, 8, true);
    }
  }

  static class AdAuctionServiceCreateAdRequestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.CreateAdRequest_Response mCallback;

    AdAuctionServiceCreateAdRequestResponseParamsForwardToCallback(
        AdAuctionService.CreateAdRequest_Response callback) {
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
        AdAuctionServiceCreateAdRequestResponseParams response =
            AdAuctionServiceCreateAdRequestResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.adsGuid);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceCreateAdRequestResponseParamsProxyToResponder
      implements AdAuctionService.CreateAdRequest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceCreateAdRequestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String adsGuid) {
      AdAuctionServiceCreateAdRequestResponseParams _response =
          new AdAuctionServiceCreateAdRequestResponseParams();
      _response.adsGuid = adsGuid;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceFinalizeAdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String adsGuid;
    public AuctionAdConfig config;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceFinalizeAdParams(int version) {
      super(24, version);
    }

    public AdAuctionServiceFinalizeAdParams() {
      this(0);
    }

    public static AdAuctionServiceFinalizeAdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceFinalizeAdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceFinalizeAdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceFinalizeAdParams result =
            new AdAuctionServiceFinalizeAdParams(elementsOrVersion);
        result.adsGuid = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.config = AuctionAdConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.adsGuid, 8, false);
      encoder0.encode((Struct) this.config, 16, false);
    }
  }

  static final class AdAuctionServiceFinalizeAdResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url adDisplayUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceFinalizeAdResponseParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceFinalizeAdResponseParams() {
      this(0);
    }

    public static AdAuctionServiceFinalizeAdResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceFinalizeAdResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceFinalizeAdResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceFinalizeAdResponseParams result =
            new AdAuctionServiceFinalizeAdResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.adDisplayUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.adDisplayUrl, 8, true);
    }
  }

  static class AdAuctionServiceFinalizeAdResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.FinalizeAd_Response mCallback;

    AdAuctionServiceFinalizeAdResponseParamsForwardToCallback(
        AdAuctionService.FinalizeAd_Response callback) {
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
        AdAuctionServiceFinalizeAdResponseParams response =
            AdAuctionServiceFinalizeAdResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.adDisplayUrl);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceFinalizeAdResponseParamsProxyToResponder
      implements AdAuctionService.FinalizeAd_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceFinalizeAdResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Url adDisplayUrl) {
      AdAuctionServiceFinalizeAdResponseParams _response =
          new AdAuctionServiceFinalizeAdResponseParams();
      _response.adDisplayUrl = adDisplayUrl;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceCreateAuctionNonceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceCreateAuctionNonceParams(int version) {
      super(8, version);
    }

    public AdAuctionServiceCreateAuctionNonceParams() {
      this(0);
    }

    public static AdAuctionServiceCreateAuctionNonceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceCreateAuctionNonceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceCreateAuctionNonceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceCreateAuctionNonceParams result =
            new AdAuctionServiceCreateAuctionNonceParams(elementsOrVersion);
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

  static final class AdAuctionServiceCreateAuctionNonceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Uuid nonce;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceCreateAuctionNonceResponseParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceCreateAuctionNonceResponseParams() {
      this(0);
    }

    public static AdAuctionServiceCreateAuctionNonceResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceCreateAuctionNonceResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceCreateAuctionNonceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceCreateAuctionNonceResponseParams result =
            new AdAuctionServiceCreateAuctionNonceResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.nonce = Uuid.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.nonce, 8, false);
    }
  }

  static class AdAuctionServiceCreateAuctionNonceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.CreateAuctionNonce_Response mCallback;

    AdAuctionServiceCreateAuctionNonceResponseParamsForwardToCallback(
        AdAuctionService.CreateAuctionNonce_Response callback) {
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
        AdAuctionServiceCreateAuctionNonceResponseParams response =
            AdAuctionServiceCreateAuctionNonceResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.nonce);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceCreateAuctionNonceResponseParamsProxyToResponder
      implements AdAuctionService.CreateAuctionNonce_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceCreateAuctionNonceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Uuid nonce) {
      AdAuctionServiceCreateAuctionNonceResponseParams _response =
          new AdAuctionServiceCreateAuctionNonceResponseParams();
      _response.nonce = nonce;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceRunAdAuctionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AbortableAdAuction> abortReceiver;
    public AuctionAdConfig config;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceRunAdAuctionParams(int version) {
      super(24, version);
    }

    public AdAuctionServiceRunAdAuctionParams() {
      this(0);
    }

    public static AdAuctionServiceRunAdAuctionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceRunAdAuctionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceRunAdAuctionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceRunAdAuctionParams result =
            new AdAuctionServiceRunAdAuctionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = AuctionAdConfig.decode(decoder1);
        result.abortReceiver = decoder0.readInterfaceRequest(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.config, 8, false);
      encoder0.encode((InterfaceRequest) this.abortReceiver, 16, true);
    }
  }

  static final class AdAuctionServiceRunAdAuctionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean abortedByScript;
    public FencedFrameConfig config;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceRunAdAuctionResponseParams(int version) {
      super(24, version);
    }

    public AdAuctionServiceRunAdAuctionResponseParams() {
      this(0);
    }

    public static AdAuctionServiceRunAdAuctionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceRunAdAuctionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceRunAdAuctionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceRunAdAuctionResponseParams result =
            new AdAuctionServiceRunAdAuctionResponseParams(elementsOrVersion);
        result.abortedByScript = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.config = FencedFrameConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.abortedByScript, 8, 0);
      encoder0.encode((Struct) this.config, 16, true);
    }
  }

  static class AdAuctionServiceRunAdAuctionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.RunAdAuction_Response mCallback;

    AdAuctionServiceRunAdAuctionResponseParamsForwardToCallback(
        AdAuctionService.RunAdAuction_Response callback) {
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
        AdAuctionServiceRunAdAuctionResponseParams response =
            AdAuctionServiceRunAdAuctionResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.abortedByScript, response.config);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceRunAdAuctionResponseParamsProxyToResponder
      implements AdAuctionService.RunAdAuction_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceRunAdAuctionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean abortedByScript, FencedFrameConfig config) {
      AdAuctionServiceRunAdAuctionResponseParams _response =
          new AdAuctionServiceRunAdAuctionResponseParams();
      _response.abortedByScript = abortedByScript;
      _response.config = config;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceJoinInterestGroupParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterestGroup group;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceJoinInterestGroupParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceJoinInterestGroupParams() {
      this(0);
    }

    public static AdAuctionServiceJoinInterestGroupParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceJoinInterestGroupParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceJoinInterestGroupParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceJoinInterestGroupParams result =
            new AdAuctionServiceJoinInterestGroupParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.group = InterestGroup.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.group, 8, false);
    }
  }

  static final class AdAuctionServiceJoinInterestGroupResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean failedWellKnownCheck;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceJoinInterestGroupResponseParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceJoinInterestGroupResponseParams() {
      this(0);
    }

    public static AdAuctionServiceJoinInterestGroupResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceJoinInterestGroupResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceJoinInterestGroupResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceJoinInterestGroupResponseParams result =
            new AdAuctionServiceJoinInterestGroupResponseParams(elementsOrVersion);
        result.failedWellKnownCheck = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.failedWellKnownCheck, 8, 0);
    }
  }

  static class AdAuctionServiceJoinInterestGroupResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.JoinInterestGroup_Response mCallback;

    AdAuctionServiceJoinInterestGroupResponseParamsForwardToCallback(
        AdAuctionService.JoinInterestGroup_Response callback) {
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
        AdAuctionServiceJoinInterestGroupResponseParams response =
            AdAuctionServiceJoinInterestGroupResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.failedWellKnownCheck);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceJoinInterestGroupResponseParamsProxyToResponder
      implements AdAuctionService.JoinInterestGroup_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceJoinInterestGroupResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean failedWellKnownCheck) {
      AdAuctionServiceJoinInterestGroupResponseParams _response =
          new AdAuctionServiceJoinInterestGroupResponseParams();
      _response.failedWellKnownCheck = failedWellKnownCheck;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceLeaveInterestGroupParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String name;
    public Origin owner;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceLeaveInterestGroupParams(int version) {
      super(24, version);
    }

    public AdAuctionServiceLeaveInterestGroupParams() {
      this(0);
    }

    public static AdAuctionServiceLeaveInterestGroupParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceLeaveInterestGroupParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceLeaveInterestGroupParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceLeaveInterestGroupParams result =
            new AdAuctionServiceLeaveInterestGroupParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.owner = Origin.decode(decoder1);
        result.name = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.owner, 8, false);
      encoder0.encode(this.name, 16, false);
    }
  }

  static final class AdAuctionServiceLeaveInterestGroupResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean failedWellKnownCheck;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceLeaveInterestGroupResponseParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceLeaveInterestGroupResponseParams() {
      this(0);
    }

    public static AdAuctionServiceLeaveInterestGroupResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceLeaveInterestGroupResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceLeaveInterestGroupResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceLeaveInterestGroupResponseParams result =
            new AdAuctionServiceLeaveInterestGroupResponseParams(elementsOrVersion);
        result.failedWellKnownCheck = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.failedWellKnownCheck, 8, 0);
    }
  }

  static class AdAuctionServiceLeaveInterestGroupResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.LeaveInterestGroup_Response mCallback;

    AdAuctionServiceLeaveInterestGroupResponseParamsForwardToCallback(
        AdAuctionService.LeaveInterestGroup_Response callback) {
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
        AdAuctionServiceLeaveInterestGroupResponseParams response =
            AdAuctionServiceLeaveInterestGroupResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.failedWellKnownCheck);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceLeaveInterestGroupResponseParamsProxyToResponder
      implements AdAuctionService.LeaveInterestGroup_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceLeaveInterestGroupResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean failedWellKnownCheck) {
      AdAuctionServiceLeaveInterestGroupResponseParams _response =
          new AdAuctionServiceLeaveInterestGroupResponseParams();
      _response.failedWellKnownCheck = failedWellKnownCheck;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceLeaveInterestGroupForDocumentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceLeaveInterestGroupForDocumentParams(int version) {
      super(8, version);
    }

    public AdAuctionServiceLeaveInterestGroupForDocumentParams() {
      this(0);
    }

    public static AdAuctionServiceLeaveInterestGroupForDocumentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceLeaveInterestGroupForDocumentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceLeaveInterestGroupForDocumentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceLeaveInterestGroupForDocumentParams result =
            new AdAuctionServiceLeaveInterestGroupForDocumentParams(elementsOrVersion);
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

  static final class AdAuctionServiceClearOriginJoinedInterestGroupsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] interestGroupsToKeep;
    public Origin owner;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceClearOriginJoinedInterestGroupsParams(int version) {
      super(24, version);
    }

    public AdAuctionServiceClearOriginJoinedInterestGroupsParams() {
      this(0);
    }

    public static AdAuctionServiceClearOriginJoinedInterestGroupsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceClearOriginJoinedInterestGroupsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceClearOriginJoinedInterestGroupsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceClearOriginJoinedInterestGroupsParams result =
            new AdAuctionServiceClearOriginJoinedInterestGroupsParams(elementsOrVersion);
        result.owner = Origin.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.interestGroupsToKeep = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.interestGroupsToKeep[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.owner, 8, false);
      String[] strArr = this.interestGroupsToKeep;
      if (strArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.interestGroupsToKeep;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean failedWellKnownCheck;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams() {
      this(0);
    }

    public static AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams result =
            new AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams(elementsOrVersion);
        result.failedWellKnownCheck = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.failedWellKnownCheck, 8, 0);
    }
  }

  static class AdAuctionServiceClearOriginJoinedInterestGroupsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.ClearOriginJoinedInterestGroups_Response mCallback;

    AdAuctionServiceClearOriginJoinedInterestGroupsResponseParamsForwardToCallback(
        AdAuctionService.ClearOriginJoinedInterestGroups_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 2)) {
          return false;
        }
        AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams response =
            AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.failedWellKnownCheck);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceClearOriginJoinedInterestGroupsResponseParamsProxyToResponder
      implements AdAuctionService.ClearOriginJoinedInterestGroups_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceClearOriginJoinedInterestGroupsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean failedWellKnownCheck) {
      AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams _response =
          new AdAuctionServiceClearOriginJoinedInterestGroupsResponseParams();
      _response.failedWellKnownCheck = failedWellKnownCheck;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceUpdateAdInterestGroupsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceUpdateAdInterestGroupsParams(int version) {
      super(8, version);
    }

    public AdAuctionServiceUpdateAdInterestGroupsParams() {
      this(0);
    }

    public static AdAuctionServiceUpdateAdInterestGroupsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceUpdateAdInterestGroupsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceUpdateAdInterestGroupsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceUpdateAdInterestGroupsParams result =
            new AdAuctionServiceUpdateAdInterestGroupsParams(elementsOrVersion);
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

  static final class AdAuctionServiceDeprecatedGetUrlFromUrnParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean sendReports;
    public Url uuidUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceDeprecatedGetUrlFromUrnParams(int version) {
      super(24, version);
    }

    public AdAuctionServiceDeprecatedGetUrlFromUrnParams() {
      this(0);
    }

    public static AdAuctionServiceDeprecatedGetUrlFromUrnParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceDeprecatedGetUrlFromUrnParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceDeprecatedGetUrlFromUrnParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceDeprecatedGetUrlFromUrnParams result =
            new AdAuctionServiceDeprecatedGetUrlFromUrnParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.uuidUrl = Url.decode(decoder1);
        result.sendReports = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.uuidUrl, 8, false);
      encoder0.encode(this.sendReports, 16, 0);
    }
  }

  static final class AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url decodedUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams(int version) {
      super(16, version);
    }

    public AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams() {
      this(0);
    }

    public static AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams result =
            new AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.decodedUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.decodedUrl, 8, true);
    }
  }

  static class AdAuctionServiceDeprecatedGetUrlFromUrnResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.DeprecatedGetUrlFromUrn_Response mCallback;

    AdAuctionServiceDeprecatedGetUrlFromUrnResponseParamsForwardToCallback(
        AdAuctionService.DeprecatedGetUrlFromUrn_Response callback) {
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
        AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams response =
            AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.decodedUrl);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceDeprecatedGetUrlFromUrnResponseParamsProxyToResponder
      implements AdAuctionService.DeprecatedGetUrlFromUrn_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceDeprecatedGetUrlFromUrnResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Url decodedUrl) {
      AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams _response =
          new AdAuctionServiceDeprecatedGetUrlFromUrnResponseParams();
      _response.decodedUrl = decodedUrl;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceDeprecatedReplaceInUrnParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AdKeywordReplacement[] replacements;
    public Url uuidUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceDeprecatedReplaceInUrnParams(int version) {
      super(24, version);
    }

    public AdAuctionServiceDeprecatedReplaceInUrnParams() {
      this(0);
    }

    public static AdAuctionServiceDeprecatedReplaceInUrnParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceDeprecatedReplaceInUrnParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceDeprecatedReplaceInUrnParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceDeprecatedReplaceInUrnParams result =
            new AdAuctionServiceDeprecatedReplaceInUrnParams(elementsOrVersion);
        result.uuidUrl = Url.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.replacements = new AdKeywordReplacement[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.replacements[i1] = AdKeywordReplacement.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.uuidUrl, 8, false);
      AdKeywordReplacement[] adKeywordReplacementArr = this.replacements;
      if (adKeywordReplacementArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(adKeywordReplacementArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        AdKeywordReplacement[] adKeywordReplacementArr2 = this.replacements;
        if (i0 < adKeywordReplacementArr2.length) {
          encoder1.encode((Struct) adKeywordReplacementArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class AdAuctionServiceDeprecatedReplaceInUrnResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceDeprecatedReplaceInUrnResponseParams(int version) {
      super(8, version);
    }

    public AdAuctionServiceDeprecatedReplaceInUrnResponseParams() {
      this(0);
    }

    public static AdAuctionServiceDeprecatedReplaceInUrnResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceDeprecatedReplaceInUrnResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceDeprecatedReplaceInUrnResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceDeprecatedReplaceInUrnResponseParams result =
            new AdAuctionServiceDeprecatedReplaceInUrnResponseParams(elementsOrVersion);
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

  static class AdAuctionServiceDeprecatedReplaceInUrnResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.DeprecatedReplaceInUrn_Response mCallback;

    AdAuctionServiceDeprecatedReplaceInUrnResponseParamsForwardToCallback(
        AdAuctionService.DeprecatedReplaceInUrn_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(10, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceDeprecatedReplaceInUrnResponseParamsProxyToResponder
      implements AdAuctionService.DeprecatedReplaceInUrn_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceDeprecatedReplaceInUrnResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      AdAuctionServiceDeprecatedReplaceInUrnResponseParams _response =
          new AdAuctionServiceDeprecatedReplaceInUrnResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AdAuctionServiceGetInterestGroupAdAuctionDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin coordinator;
    public Origin seller;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceGetInterestGroupAdAuctionDataParams(int version) {
      super(24, version);
    }

    public AdAuctionServiceGetInterestGroupAdAuctionDataParams() {
      this(0);
    }

    public static AdAuctionServiceGetInterestGroupAdAuctionDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceGetInterestGroupAdAuctionDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceGetInterestGroupAdAuctionDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceGetInterestGroupAdAuctionDataParams result =
            new AdAuctionServiceGetInterestGroupAdAuctionDataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.seller = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.coordinator = Origin.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.seller, 8, false);
      encoder0.encode((Struct) this.coordinator, 16, true);
    }
  }

  static final class AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public String errorMessage;
    public BigBuffer request;
    public Uuid requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams(int version) {
      super(40, version);
    }

    public AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams() {
      this(0);
    }

    public static AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams result =
            new AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams(elementsOrVersion);
        result.request = BigBuffer.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, true);
        result.requestId = Uuid.decode(decoder1);
        result.errorMessage = decoder0.readString(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.request, 8, false);
      encoder0.encode((Struct) this.requestId, 24, true);
      encoder0.encode(this.errorMessage, 32, false);
    }
  }

  static class AdAuctionServiceGetInterestGroupAdAuctionDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AdAuctionService.GetInterestGroupAdAuctionData_Response mCallback;

    AdAuctionServiceGetInterestGroupAdAuctionDataResponseParamsForwardToCallback(
        AdAuctionService.GetInterestGroupAdAuctionData_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 2)) {
          return false;
        }
        AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams response =
            AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.request, response.requestId, response.errorMessage);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AdAuctionServiceGetInterestGroupAdAuctionDataResponseParamsProxyToResponder
      implements AdAuctionService.GetInterestGroupAdAuctionData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AdAuctionServiceGetInterestGroupAdAuctionDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigBuffer request, Uuid requestId, String errorMessage) {
      AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams _response =
          new AdAuctionServiceGetInterestGroupAdAuctionDataResponseParams();
      _response.request = request;
      _response.requestId = requestId;
      _response.errorMessage = errorMessage;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
