package org.chromium.network.mojom;

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
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

class DevToolsObserver_Internal {
  private static final int CLONE_ORDINAL = 13;
  public static final Interface.Manager<DevToolsObserver, DevToolsObserver.Proxy> MANAGER =
      new Interface.Manager<DevToolsObserver, DevToolsObserver.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.DevToolsObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DevToolsObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DevToolsObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public DevToolsObserver[] buildArray(int size) {
          return new DevToolsObserver[size];
        }
      };
  private static final int ON_CORB_ERROR_ORDINAL = 8;
  private static final int ON_CORS_ERROR_ORDINAL = 7;
  private static final int ON_CORS_PREFLIGHT_REQUEST_COMPLETED_ORDINAL = 5;
  private static final int ON_CORS_PREFLIGHT_REQUEST_ORDINAL = 3;
  private static final int ON_CORS_PREFLIGHT_RESPONSE_ORDINAL = 4;
  private static final int ON_PRIVATE_NETWORK_REQUEST_ORDINAL = 2;
  private static final int ON_RAW_REQUEST_ORDINAL = 0;
  private static final int ON_RAW_RESPONSE_ORDINAL = 1;
  private static final int ON_SUBRESOURCE_WEB_BUNDLE_INNER_RESPONSE_ERROR_ORDINAL = 12;
  private static final int ON_SUBRESOURCE_WEB_BUNDLE_INNER_RESPONSE_ORDINAL = 11;
  private static final int ON_SUBRESOURCE_WEB_BUNDLE_METADATA_ERROR_ORDINAL = 10;
  private static final int ON_SUBRESOURCE_WEB_BUNDLE_METADATA_ORDINAL = 9;
  private static final int ON_TRUST_TOKEN_OPERATION_DONE_ORDINAL = 6;

  DevToolsObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DevToolsObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onRawRequest(
        String devtoolRequestId,
        CookieWithAccessResult[] cookiesWithAccessResult,
        HttpRawHeaderPair[] headers,
        TimeTicks timestamp,
        ClientSecurityState clientSecurityState,
        OtherPartitionInfo otherPartitionInfo) {
      DevToolsObserverOnRawRequestParams _message = new DevToolsObserverOnRawRequestParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.cookiesWithAccessResult = cookiesWithAccessResult;
      _message.headers = headers;
      _message.timestamp = timestamp;
      _message.clientSecurityState = clientSecurityState;
      _message.otherPartitionInfo = otherPartitionInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onRawResponse(
        String devtoolRequestId,
        CookieAndLineWithAccessResult[] cookiesWithAccessResult,
        HttpRawHeaderPair[] headers,
        String rawResponseHeaders,
        int resourceAddressSpace,
        int httpStatusCode,
        CookiePartitionKey cookiePartitionKey) {
      DevToolsObserverOnRawResponseParams _message = new DevToolsObserverOnRawResponseParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.cookiesWithAccessResult = cookiesWithAccessResult;
      _message.headers = headers;
      _message.rawResponseHeaders = rawResponseHeaders;
      _message.resourceAddressSpace = resourceAddressSpace;
      _message.httpStatusCode = httpStatusCode;
      _message.cookiePartitionKey = cookiePartitionKey;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onPrivateNetworkRequest(
        String devtoolRequestId,
        Url url,
        boolean isWarning,
        int resourceAddressSpace,
        ClientSecurityState clientSecurityState) {
      DevToolsObserverOnPrivateNetworkRequestParams _message =
          new DevToolsObserverOnPrivateNetworkRequestParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.url = url;
      _message.isWarning = isWarning;
      _message.resourceAddressSpace = resourceAddressSpace;
      _message.clientSecurityState = clientSecurityState;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onCorsPreflightRequest(
        UnguessableToken devtoolRequestId,
        HttpRequestHeaders requestHeaders,
        UrlRequestDevToolsInfo requestInfo,
        Url initiatorUrl,
        String initiatorDevtoolRequestId) {
      DevToolsObserverOnCorsPreflightRequestParams _message =
          new DevToolsObserverOnCorsPreflightRequestParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.requestHeaders = requestHeaders;
      _message.requestInfo = requestInfo;
      _message.initiatorUrl = initiatorUrl;
      _message.initiatorDevtoolRequestId = initiatorDevtoolRequestId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onCorsPreflightResponse(
        UnguessableToken devtoolRequestId, Url url, UrlResponseHeadDevToolsInfo head) {
      DevToolsObserverOnCorsPreflightResponseParams _message =
          new DevToolsObserverOnCorsPreflightResponseParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.url = url;
      _message.head = head;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onCorsPreflightRequestCompleted(
        UnguessableToken devtoolRequestId, UrlLoaderCompletionStatus status) {
      DevToolsObserverOnCorsPreflightRequestCompletedParams _message =
          new DevToolsObserverOnCorsPreflightRequestCompletedParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void onTrustTokenOperationDone(
        String devtoolRequestId, TrustTokenOperationResult result) {
      DevToolsObserverOnTrustTokenOperationDoneParams _message =
          new DevToolsObserverOnTrustTokenOperationDoneParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.result = result;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void onCorsError(
        String devtoolRequestId,
        Origin initiatorOrigin,
        ClientSecurityState clientSecurityState,
        Url url,
        CorsErrorStatus status,
        boolean isWarning) {
      DevToolsObserverOnCorsErrorParams _message = new DevToolsObserverOnCorsErrorParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.initiatorOrigin = initiatorOrigin;
      _message.clientSecurityState = clientSecurityState;
      _message.url = url;
      _message.status = status;
      _message.isWarning = isWarning;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void onCorbError(String devtoolsRequestId, Url url) {
      DevToolsObserverOnCorbErrorParams _message = new DevToolsObserverOnCorbErrorParams();
      _message.devtoolsRequestId = devtoolsRequestId;
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void onSubresourceWebBundleMetadata(String devtoolRequestId, Url[] urls) {
      DevToolsObserverOnSubresourceWebBundleMetadataParams _message =
          new DevToolsObserverOnSubresourceWebBundleMetadataParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.urls = urls;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void onSubresourceWebBundleMetadataError(String devtoolRequestId, String errorMessage) {
      DevToolsObserverOnSubresourceWebBundleMetadataErrorParams _message =
          new DevToolsObserverOnSubresourceWebBundleMetadataErrorParams();
      _message.devtoolRequestId = devtoolRequestId;
      _message.errorMessage = errorMessage;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void onSubresourceWebBundleInnerResponse(
        String innerRequestDevtoolsId, Url url, String bundleRequestDevtoolsId) {
      DevToolsObserverOnSubresourceWebBundleInnerResponseParams _message =
          new DevToolsObserverOnSubresourceWebBundleInnerResponseParams();
      _message.innerRequestDevtoolsId = innerRequestDevtoolsId;
      _message.url = url;
      _message.bundleRequestDevtoolsId = bundleRequestDevtoolsId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void onSubresourceWebBundleInnerResponseError(
        String innerRequestDevtoolsId,
        Url url,
        String errorMessage,
        String bundleRequestDevtoolsId) {
      DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams _message =
          new DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams();
      _message.innerRequestDevtoolsId = innerRequestDevtoolsId;
      _message.url = url;
      _message.errorMessage = errorMessage;
      _message.bundleRequestDevtoolsId = bundleRequestDevtoolsId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void clone(InterfaceRequest<DevToolsObserver> listener) {
      DevToolsObserverCloneParams _message = new DevToolsObserverCloneParams();
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }
  }

  public static final class Stub extends Interface.Stub<DevToolsObserver> {
    Stub(Core core, DevToolsObserver impl) {
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
                DevToolsObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            DevToolsObserverOnRawRequestParams data =
                DevToolsObserverOnRawRequestParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .onRawRequest(
                    data.devtoolRequestId,
                    data.cookiesWithAccessResult,
                    data.headers,
                    data.timestamp,
                    data.clientSecurityState,
                    data.otherPartitionInfo);
            return true;
          case 1:
            DevToolsObserverOnRawResponseParams data2 =
                DevToolsObserverOnRawResponseParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .onRawResponse(
                    data2.devtoolRequestId,
                    data2.cookiesWithAccessResult,
                    data2.headers,
                    data2.rawResponseHeaders,
                    data2.resourceAddressSpace,
                    data2.httpStatusCode,
                    data2.cookiePartitionKey);
            return true;
          case 2:
            DevToolsObserverOnPrivateNetworkRequestParams data3 =
                DevToolsObserverOnPrivateNetworkRequestParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onPrivateNetworkRequest(
                    data3.devtoolRequestId,
                    data3.url,
                    data3.isWarning,
                    data3.resourceAddressSpace,
                    data3.clientSecurityState);
            return true;
          case 3:
            DevToolsObserverOnCorsPreflightRequestParams data4 =
                DevToolsObserverOnCorsPreflightRequestParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onCorsPreflightRequest(
                    data4.devtoolRequestId,
                    data4.requestHeaders,
                    data4.requestInfo,
                    data4.initiatorUrl,
                    data4.initiatorDevtoolRequestId);
            return true;
          case 4:
            DevToolsObserverOnCorsPreflightResponseParams data5 =
                DevToolsObserverOnCorsPreflightResponseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onCorsPreflightResponse(data5.devtoolRequestId, data5.url, data5.head);
            return true;
          case 5:
            DevToolsObserverOnCorsPreflightRequestCompletedParams data6 =
                DevToolsObserverOnCorsPreflightRequestCompletedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onCorsPreflightRequestCompleted(data6.devtoolRequestId, data6.status);
            return true;
          case 6:
            DevToolsObserverOnTrustTokenOperationDoneParams data7 =
                DevToolsObserverOnTrustTokenOperationDoneParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onTrustTokenOperationDone(data7.devtoolRequestId, data7.result);
            return true;
          case 7:
            DevToolsObserverOnCorsErrorParams data8 =
                DevToolsObserverOnCorsErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .onCorsError(
                    data8.devtoolRequestId,
                    data8.initiatorOrigin,
                    data8.clientSecurityState,
                    data8.url,
                    data8.status,
                    data8.isWarning);
            return true;
          case 8:
            DevToolsObserverOnCorbErrorParams data9 =
                DevToolsObserverOnCorbErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onCorbError(data9.devtoolsRequestId, data9.url);
            return true;
          case 9:
            DevToolsObserverOnSubresourceWebBundleMetadataParams data10 =
                DevToolsObserverOnSubresourceWebBundleMetadataParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onSubresourceWebBundleMetadata(data10.devtoolRequestId, data10.urls);
            return true;
          case 10:
            DevToolsObserverOnSubresourceWebBundleMetadataErrorParams data11 =
                DevToolsObserverOnSubresourceWebBundleMetadataErrorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onSubresourceWebBundleMetadataError(data11.devtoolRequestId, data11.errorMessage);
            return true;
          case 11:
            DevToolsObserverOnSubresourceWebBundleInnerResponseParams data12 =
                DevToolsObserverOnSubresourceWebBundleInnerResponseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onSubresourceWebBundleInnerResponse(
                    data12.innerRequestDevtoolsId, data12.url, data12.bundleRequestDevtoolsId);
            return true;
          case 12:
            DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams data13 =
                DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onSubresourceWebBundleInnerResponseError(
                    data13.innerRequestDevtoolsId,
                    data13.url,
                    data13.errorMessage,
                    data13.bundleRequestDevtoolsId);
            return true;
          case 13:
            getImpl()
                .clone(
                    DevToolsObserverCloneParams.deserialize(messageWithHeader.getPayload())
                        .listener);
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
                getCore(), DevToolsObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class DevToolsObserverOnRawRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public ClientSecurityState clientSecurityState;
    public CookieWithAccessResult[] cookiesWithAccessResult;
    public String devtoolRequestId;
    public HttpRawHeaderPair[] headers;
    public OtherPartitionInfo otherPartitionInfo;
    public TimeTicks timestamp;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnRawRequestParams(int version) {
      super(56, version);
    }

    public DevToolsObserverOnRawRequestParams() {
      this(0);
    }

    public static DevToolsObserverOnRawRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnRawRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnRawRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnRawRequestParams result =
            new DevToolsObserverOnRawRequestParams(elementsOrVersion);
        result.devtoolRequestId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.cookiesWithAccessResult = new CookieWithAccessResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.cookiesWithAccessResult[i1] = CookieWithAccessResult.decode(decoder2);
        }
        Decoder decoder12 = decoder0.readPointer(24, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.headers = new HttpRawHeaderPair[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.headers[i12] = HttpRawHeaderPair.decode(decoder22);
        }
        result.timestamp = TimeTicks.decode(decoder0.readPointer(32, false));
        result.clientSecurityState = ClientSecurityState.decode(decoder0.readPointer(40, true));
        result.otherPartitionInfo = OtherPartitionInfo.decode(decoder0.readPointer(48, true));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.devtoolRequestId, 8, false);
      CookieWithAccessResult[] cookieWithAccessResultArr = this.cookiesWithAccessResult;
      if (cookieWithAccessResultArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(cookieWithAccessResultArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          CookieWithAccessResult[] cookieWithAccessResultArr2 = this.cookiesWithAccessResult;
          if (i0 >= cookieWithAccessResultArr2.length) {
            break;
          }
          encoder1.encode((Struct) cookieWithAccessResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      HttpRawHeaderPair[] httpRawHeaderPairArr = this.headers;
      if (httpRawHeaderPairArr == null) {
        encoder0.encodeNullPointer(24, false);
      } else {
        Encoder encoder12 = encoder0.encodePointerArray(httpRawHeaderPairArr.length, 24, -1);
        int i02 = 0;
        while (true) {
          HttpRawHeaderPair[] httpRawHeaderPairArr2 = this.headers;
          if (i02 >= httpRawHeaderPairArr2.length) {
            break;
          }
          encoder12.encode((Struct) httpRawHeaderPairArr2[i02], (i02 * 8) + 8, false);
          i02++;
        }
      }
      encoder0.encode((Struct) this.timestamp, 32, false);
      encoder0.encode((Struct) this.clientSecurityState, 40, true);
      encoder0.encode((Struct) this.otherPartitionInfo, 48, true);
    }
  }

  static final class DevToolsObserverOnRawResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public CookiePartitionKey cookiePartitionKey;
    public CookieAndLineWithAccessResult[] cookiesWithAccessResult;
    public String devtoolRequestId;
    public HttpRawHeaderPair[] headers;
    public int httpStatusCode;
    public String rawResponseHeaders;
    public int resourceAddressSpace;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnRawResponseParams(int version) {
      super(56, version);
    }

    public DevToolsObserverOnRawResponseParams() {
      this(0);
    }

    public static DevToolsObserverOnRawResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnRawResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnRawResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnRawResponseParams result =
            new DevToolsObserverOnRawResponseParams(elementsOrVersion);
        result.devtoolRequestId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.cookiesWithAccessResult = new CookieAndLineWithAccessResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.cookiesWithAccessResult[i1] = CookieAndLineWithAccessResult.decode(decoder2);
        }
        Decoder decoder12 = decoder0.readPointer(24, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.headers = new HttpRawHeaderPair[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.headers[i12] = HttpRawHeaderPair.decode(decoder22);
        }
        result.rawResponseHeaders = decoder0.readString(32, true);
        int readInt = decoder0.readInt(40);
        result.resourceAddressSpace = readInt;
        IpAddressSpace.validate(readInt);
        result.resourceAddressSpace = IpAddressSpace.toKnownValue(result.resourceAddressSpace);
        result.httpStatusCode = decoder0.readInt(44);
        result.cookiePartitionKey = CookiePartitionKey.decode(decoder0.readPointer(48, true));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.devtoolRequestId, 8, false);
      CookieAndLineWithAccessResult[] cookieAndLineWithAccessResultArr =
          this.cookiesWithAccessResult;
      if (cookieAndLineWithAccessResultArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 =
            encoder0.encodePointerArray(cookieAndLineWithAccessResultArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          CookieAndLineWithAccessResult[] cookieAndLineWithAccessResultArr2 =
              this.cookiesWithAccessResult;
          if (i0 >= cookieAndLineWithAccessResultArr2.length) {
            break;
          }
          encoder1.encode((Struct) cookieAndLineWithAccessResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      HttpRawHeaderPair[] httpRawHeaderPairArr = this.headers;
      if (httpRawHeaderPairArr == null) {
        encoder0.encodeNullPointer(24, false);
      } else {
        Encoder encoder12 = encoder0.encodePointerArray(httpRawHeaderPairArr.length, 24, -1);
        int i02 = 0;
        while (true) {
          HttpRawHeaderPair[] httpRawHeaderPairArr2 = this.headers;
          if (i02 >= httpRawHeaderPairArr2.length) {
            break;
          }
          encoder12.encode((Struct) httpRawHeaderPairArr2[i02], (i02 * 8) + 8, false);
          i02++;
        }
      }
      encoder0.encode(this.rawResponseHeaders, 32, true);
      encoder0.encode(this.resourceAddressSpace, 40);
      encoder0.encode(this.httpStatusCode, 44);
      encoder0.encode((Struct) this.cookiePartitionKey, 48, true);
    }
  }

  static final class DevToolsObserverOnPrivateNetworkRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public ClientSecurityState clientSecurityState;
    public String devtoolRequestId;
    public boolean isWarning;
    public int resourceAddressSpace;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnPrivateNetworkRequestParams(int version) {
      super(40, version);
    }

    public DevToolsObserverOnPrivateNetworkRequestParams() {
      this(0);
    }

    public static DevToolsObserverOnPrivateNetworkRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnPrivateNetworkRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnPrivateNetworkRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnPrivateNetworkRequestParams result =
            new DevToolsObserverOnPrivateNetworkRequestParams(elementsOrVersion);
        result.devtoolRequestId = decoder0.readString(8, true);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        result.isWarning = decoder0.readBoolean(24, 0);
        int readInt = decoder0.readInt(28);
        result.resourceAddressSpace = readInt;
        IpAddressSpace.validate(readInt);
        result.resourceAddressSpace = IpAddressSpace.toKnownValue(result.resourceAddressSpace);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.clientSecurityState = ClientSecurityState.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.devtoolRequestId, 8, true);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode(this.isWarning, 24, 0);
      encoder0.encode(this.resourceAddressSpace, 28);
      encoder0.encode((Struct) this.clientSecurityState, 32, false);
    }
  }

  static final class DevToolsObserverOnCorsPreflightRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken devtoolRequestId;
    public String initiatorDevtoolRequestId;
    public Url initiatorUrl;
    public HttpRequestHeaders requestHeaders;
    public UrlRequestDevToolsInfo requestInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnCorsPreflightRequestParams(int version) {
      super(48, version);
    }

    public DevToolsObserverOnCorsPreflightRequestParams() {
      this(0);
    }

    public static DevToolsObserverOnCorsPreflightRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnCorsPreflightRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnCorsPreflightRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnCorsPreflightRequestParams result =
            new DevToolsObserverOnCorsPreflightRequestParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.devtoolRequestId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.requestHeaders = HttpRequestHeaders.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.requestInfo = UrlRequestDevToolsInfo.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(32, false);
        result.initiatorUrl = Url.decode(decoder14);
        result.initiatorDevtoolRequestId = decoder0.readString(40, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.devtoolRequestId, 8, false);
      encoder0.encode((Struct) this.requestHeaders, 16, false);
      encoder0.encode((Struct) this.requestInfo, 24, false);
      encoder0.encode((Struct) this.initiatorUrl, 32, false);
      encoder0.encode(this.initiatorDevtoolRequestId, 40, false);
    }
  }

  static final class DevToolsObserverOnCorsPreflightResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken devtoolRequestId;
    public UrlResponseHeadDevToolsInfo head;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnCorsPreflightResponseParams(int version) {
      super(32, version);
    }

    public DevToolsObserverOnCorsPreflightResponseParams() {
      this(0);
    }

    public static DevToolsObserverOnCorsPreflightResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnCorsPreflightResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnCorsPreflightResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnCorsPreflightResponseParams result =
            new DevToolsObserverOnCorsPreflightResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.devtoolRequestId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.head = UrlResponseHeadDevToolsInfo.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.devtoolRequestId, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode((Struct) this.head, 24, false);
    }
  }

  static final class DevToolsObserverOnCorsPreflightRequestCompletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken devtoolRequestId;
    public UrlLoaderCompletionStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnCorsPreflightRequestCompletedParams(int version) {
      super(24, version);
    }

    public DevToolsObserverOnCorsPreflightRequestCompletedParams() {
      this(0);
    }

    public static DevToolsObserverOnCorsPreflightRequestCompletedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnCorsPreflightRequestCompletedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnCorsPreflightRequestCompletedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnCorsPreflightRequestCompletedParams result =
            new DevToolsObserverOnCorsPreflightRequestCompletedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.devtoolRequestId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.status = UrlLoaderCompletionStatus.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.devtoolRequestId, 8, false);
      encoder0.encode((Struct) this.status, 16, false);
    }
  }

  static final class DevToolsObserverOnTrustTokenOperationDoneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String devtoolRequestId;
    public TrustTokenOperationResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnTrustTokenOperationDoneParams(int version) {
      super(24, version);
    }

    public DevToolsObserverOnTrustTokenOperationDoneParams() {
      this(0);
    }

    public static DevToolsObserverOnTrustTokenOperationDoneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnTrustTokenOperationDoneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnTrustTokenOperationDoneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnTrustTokenOperationDoneParams result =
            new DevToolsObserverOnTrustTokenOperationDoneParams(elementsOrVersion);
        result.devtoolRequestId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.result = TrustTokenOperationResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.devtoolRequestId, 8, false);
      encoder0.encode((Struct) this.result, 16, false);
    }
  }

  static final class DevToolsObserverOnCorsErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public ClientSecurityState clientSecurityState;
    public String devtoolRequestId;
    public Origin initiatorOrigin;
    public boolean isWarning;
    public CorsErrorStatus status;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnCorsErrorParams(int version) {
      super(56, version);
    }

    public DevToolsObserverOnCorsErrorParams() {
      this(0);
    }

    public static DevToolsObserverOnCorsErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnCorsErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnCorsErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnCorsErrorParams result =
            new DevToolsObserverOnCorsErrorParams(elementsOrVersion);
        result.devtoolRequestId = decoder0.readString(8, true);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.initiatorOrigin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.clientSecurityState = ClientSecurityState.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.url = Url.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(40, false);
        result.status = CorsErrorStatus.decode(decoder14);
        result.isWarning = decoder0.readBoolean(48, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.devtoolRequestId, 8, true);
      encoder0.encode((Struct) this.initiatorOrigin, 16, true);
      encoder0.encode((Struct) this.clientSecurityState, 24, true);
      encoder0.encode((Struct) this.url, 32, false);
      encoder0.encode((Struct) this.status, 40, false);
      encoder0.encode(this.isWarning, 48, 0);
    }
  }

  static final class DevToolsObserverOnCorbErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String devtoolsRequestId;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnCorbErrorParams(int version) {
      super(24, version);
    }

    public DevToolsObserverOnCorbErrorParams() {
      this(0);
    }

    public static DevToolsObserverOnCorbErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnCorbErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnCorbErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnCorbErrorParams result =
            new DevToolsObserverOnCorbErrorParams(elementsOrVersion);
        result.devtoolsRequestId = decoder0.readString(8, true);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.devtoolsRequestId, 8, true);
      encoder0.encode((Struct) this.url, 16, false);
    }
  }

  static final class DevToolsObserverOnSubresourceWebBundleMetadataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String devtoolRequestId;
    public Url[] urls;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnSubresourceWebBundleMetadataParams(int version) {
      super(24, version);
    }

    public DevToolsObserverOnSubresourceWebBundleMetadataParams() {
      this(0);
    }

    public static DevToolsObserverOnSubresourceWebBundleMetadataParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnSubresourceWebBundleMetadataParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnSubresourceWebBundleMetadataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnSubresourceWebBundleMetadataParams result =
            new DevToolsObserverOnSubresourceWebBundleMetadataParams(elementsOrVersion);
        result.devtoolRequestId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.urls = new Url[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.urls[i1] = Url.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.devtoolRequestId, 8, false);
      Url[] urlArr = this.urls;
      if (urlArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.urls;
        if (i0 < urlArr2.length) {
          encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class DevToolsObserverOnSubresourceWebBundleMetadataErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String devtoolRequestId;
    public String errorMessage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnSubresourceWebBundleMetadataErrorParams(int version) {
      super(24, version);
    }

    public DevToolsObserverOnSubresourceWebBundleMetadataErrorParams() {
      this(0);
    }

    public static DevToolsObserverOnSubresourceWebBundleMetadataErrorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnSubresourceWebBundleMetadataErrorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnSubresourceWebBundleMetadataErrorParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnSubresourceWebBundleMetadataErrorParams result =
            new DevToolsObserverOnSubresourceWebBundleMetadataErrorParams(elementsOrVersion);
        result.devtoolRequestId = decoder0.readString(8, false);
        result.errorMessage = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.devtoolRequestId, 8, false);
      encoder0.encode(this.errorMessage, 16, false);
    }
  }

  static final class DevToolsObserverOnSubresourceWebBundleInnerResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String bundleRequestDevtoolsId;
    public String innerRequestDevtoolsId;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnSubresourceWebBundleInnerResponseParams(int version) {
      super(32, version);
    }

    public DevToolsObserverOnSubresourceWebBundleInnerResponseParams() {
      this(0);
    }

    public static DevToolsObserverOnSubresourceWebBundleInnerResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnSubresourceWebBundleInnerResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnSubresourceWebBundleInnerResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnSubresourceWebBundleInnerResponseParams result =
            new DevToolsObserverOnSubresourceWebBundleInnerResponseParams(elementsOrVersion);
        result.innerRequestDevtoolsId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        result.bundleRequestDevtoolsId = decoder0.readString(24, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.innerRequestDevtoolsId, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode(this.bundleRequestDevtoolsId, 24, true);
    }
  }

  static final class DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public String bundleRequestDevtoolsId;
    public String errorMessage;
    public String innerRequestDevtoolsId;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams(int version) {
      super(40, version);
    }

    public DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams() {
      this(0);
    }

    public static DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams result =
            new DevToolsObserverOnSubresourceWebBundleInnerResponseErrorParams(elementsOrVersion);
        result.innerRequestDevtoolsId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        result.errorMessage = decoder0.readString(24, false);
        result.bundleRequestDevtoolsId = decoder0.readString(32, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.innerRequestDevtoolsId, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode(this.errorMessage, 24, false);
      encoder0.encode(this.bundleRequestDevtoolsId, 32, true);
    }
  }

  static final class DevToolsObserverCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<DevToolsObserver> listener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsObserverCloneParams(int version) {
      super(16, version);
    }

    public DevToolsObserverCloneParams() {
      this(0);
    }

    public static DevToolsObserverCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsObserverCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsObserverCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsObserverCloneParams result = new DevToolsObserverCloneParams(elementsOrVersion);
        result.listener = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.listener, 8, false);
    }
  }
}
