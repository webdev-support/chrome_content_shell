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
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

class FederatedAuthRequest_Internal {
  private static final int CANCEL_TOKEN_REQUEST_ORDINAL = 2;
  private static final int CLOSE_MODAL_DIALOG_VIEW_ORDINAL = 7;
  private static final int DISCONNECT_ORDINAL = 9;
  public static final Interface.Manager<FederatedAuthRequest, FederatedAuthRequest.Proxy> MANAGER =
      new Interface.Manager<FederatedAuthRequest, FederatedAuthRequest.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FederatedAuthRequest";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FederatedAuthRequest.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FederatedAuthRequest impl) {
          return new Stub(core, impl);
        }

        @Override
        public FederatedAuthRequest[] buildArray(int size) {
          return new FederatedAuthRequest[size];
        }
      };
  private static final int PREVENT_SILENT_ACCESS_ORDINAL = 8;
  private static final int REGISTER_ID_P_ORDINAL = 5;
  private static final int REQUEST_TOKEN_ORDINAL = 0;
  private static final int REQUEST_USER_INFO_ORDINAL = 1;
  private static final int RESOLVE_TOKEN_REQUEST_ORDINAL = 3;
  private static final int SET_IDP_SIGNIN_STATUS_ORDINAL = 4;
  private static final int UNREGISTER_ID_P_ORDINAL = 6;

  FederatedAuthRequest_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FederatedAuthRequest.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestToken(
        IdentityProviderGetParameters[] idpGetParams,
        int requirement,
        RequestToken_Response callback) {
      FederatedAuthRequestRequestTokenParams _message =
          new FederatedAuthRequestRequestTokenParams();
      _message.idpGetParams = idpGetParams;
      _message.requirement = requirement;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FederatedAuthRequestRequestTokenResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestUserInfo(
        IdentityProviderConfig provider, RequestUserInfo_Response callback) {
      FederatedAuthRequestRequestUserInfoParams _message =
          new FederatedAuthRequestRequestUserInfoParams();
      _message.provider = provider;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FederatedAuthRequestRequestUserInfoResponseParamsForwardToCallback(callback));
    }

    @Override
    public void cancelTokenRequest() {
      FederatedAuthRequestCancelTokenRequestParams _message =
          new FederatedAuthRequestCancelTokenRequestParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void resolveTokenRequest(String token, ResolveTokenRequest_Response callback) {
      FederatedAuthRequestResolveTokenRequestParams _message =
          new FederatedAuthRequestResolveTokenRequestParams();
      _message.token = token;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FederatedAuthRequestResolveTokenRequestResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setIdpSigninStatus(Origin origin, int status) {
      FederatedAuthRequestSetIdpSigninStatusParams _message =
          new FederatedAuthRequestSetIdpSigninStatusParams();
      _message.origin = origin;
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void registerIdP(Url url, RegisterIdP_Response callback) {
      FederatedAuthRequestRegisterIdPParams _message = new FederatedAuthRequestRegisterIdPParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new FederatedAuthRequestRegisterIdPResponseParamsForwardToCallback(callback));
    }

    @Override
    public void unregisterIdP(Url url, UnregisterIdP_Response callback) {
      FederatedAuthRequestUnregisterIdPParams _message =
          new FederatedAuthRequestUnregisterIdPParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new FederatedAuthRequestUnregisterIdPResponseParamsForwardToCallback(callback));
    }

    @Override
    public void closeModalDialogView() {
      FederatedAuthRequestCloseModalDialogViewParams _message =
          new FederatedAuthRequestCloseModalDialogViewParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void preventSilentAccess(PreventSilentAccess_Response callback) {
      FederatedAuthRequestPreventSilentAccessParams _message =
          new FederatedAuthRequestPreventSilentAccessParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new FederatedAuthRequestPreventSilentAccessResponseParamsForwardToCallback(callback));
    }

    @Override
    public void disconnect(
        IdentityCredentialDisconnectOptions options, Disconnect_Response callback) {
      FederatedAuthRequestDisconnectParams _message = new FederatedAuthRequestDisconnectParams();
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new FederatedAuthRequestDisconnectResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FederatedAuthRequest> {
    Stub(Core core, FederatedAuthRequest impl) {
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
                FederatedAuthRequest_Internal.MANAGER, messageWithHeader);
          case 2:
            FederatedAuthRequestCancelTokenRequestParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().cancelTokenRequest();
            return true;
          case 4:
            FederatedAuthRequestSetIdpSigninStatusParams data =
                FederatedAuthRequestSetIdpSigninStatusParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setIdpSigninStatus(data.origin, data.status);
            return true;
          case 7:
            FederatedAuthRequestCloseModalDialogViewParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().closeModalDialogView();
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
                getCore(), FederatedAuthRequest_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FederatedAuthRequestRequestTokenParams data =
                FederatedAuthRequestRequestTokenParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestToken(
                    data.idpGetParams,
                    data.requirement,
                    new FederatedAuthRequestRequestTokenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            getImpl()
                .requestUserInfo(
                    FederatedAuthRequestRequestUserInfoParams.deserialize(
                            messageWithHeader.getPayload())
                        .provider,
                    new FederatedAuthRequestRequestUserInfoResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
          case 4:
          case 7:
          default:
            return false;
          case 3:
            getImpl()
                .resolveTokenRequest(
                    FederatedAuthRequestResolveTokenRequestParams.deserialize(
                            messageWithHeader.getPayload())
                        .token,
                    new FederatedAuthRequestResolveTokenRequestResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            getImpl()
                .registerIdP(
                    FederatedAuthRequestRegisterIdPParams.deserialize(
                            messageWithHeader.getPayload())
                        .url,
                    new FederatedAuthRequestRegisterIdPResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            getImpl()
                .unregisterIdP(
                    FederatedAuthRequestUnregisterIdPParams.deserialize(
                            messageWithHeader.getPayload())
                        .url,
                    new FederatedAuthRequestUnregisterIdPResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            FederatedAuthRequestPreventSilentAccessParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .preventSilentAccess(
                    new FederatedAuthRequestPreventSilentAccessResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            getImpl()
                .disconnect(
                    FederatedAuthRequestDisconnectParams.deserialize(messageWithHeader.getPayload())
                        .options,
                    new FederatedAuthRequestDisconnectResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FederatedAuthRequestRequestTokenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IdentityProviderGetParameters[] idpGetParams;
    public int requirement;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestRequestTokenParams(int version) {
      super(24, version);
    }

    public FederatedAuthRequestRequestTokenParams() {
      this(0);
    }

    public static FederatedAuthRequestRequestTokenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestRequestTokenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestRequestTokenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestRequestTokenParams result =
            new FederatedAuthRequestRequestTokenParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.idpGetParams = new IdentityProviderGetParameters[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.idpGetParams[i1] = IdentityProviderGetParameters.decode(decoder2);
        }
        int readInt = decoder0.readInt(16);
        result.requirement = readInt;
        CredentialMediationRequirement.validate(readInt);
        result.requirement = CredentialMediationRequirement.toKnownValue(result.requirement);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      IdentityProviderGetParameters[] identityProviderGetParametersArr = this.idpGetParams;
      if (identityProviderGetParametersArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 =
            encoder0.encodePointerArray(identityProviderGetParametersArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          IdentityProviderGetParameters[] identityProviderGetParametersArr2 = this.idpGetParams;
          if (i0 >= identityProviderGetParametersArr2.length) {
            break;
          }
          encoder1.encode((Struct) identityProviderGetParametersArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.requirement, 16);
    }
  }

  static final class FederatedAuthRequestRequestTokenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public TokenError error;
    public boolean isAutoSelected;
    public Url selectedIdentityProviderConfigUrl;
    public int status;
    public String token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestRequestTokenResponseParams(int version) {
      super(40, version);
    }

    public FederatedAuthRequestRequestTokenResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestRequestTokenResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestRequestTokenResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestRequestTokenResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestRequestTokenResponseParams result =
            new FederatedAuthRequestRequestTokenResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        RequestTokenStatus.validate(readInt);
        result.status = RequestTokenStatus.toKnownValue(result.status);
        result.isAutoSelected = decoder0.readBoolean(12, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.selectedIdentityProviderConfigUrl = Url.decode(decoder1);
        result.token = decoder0.readString(24, true);
        Decoder decoder12 = decoder0.readPointer(32, true);
        result.error = TokenError.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.isAutoSelected, 12, 0);
      encoder0.encode((Struct) this.selectedIdentityProviderConfigUrl, 16, true);
      encoder0.encode(this.token, 24, true);
      encoder0.encode((Struct) this.error, 32, true);
    }
  }

  static class FederatedAuthRequestRequestTokenResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequest.RequestToken_Response mCallback;

    FederatedAuthRequestRequestTokenResponseParamsForwardToCallback(
        FederatedAuthRequest.RequestToken_Response callback) {
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
        FederatedAuthRequestRequestTokenResponseParams response =
            FederatedAuthRequestRequestTokenResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(
            response.status,
            response.selectedIdentityProviderConfigUrl,
            response.token,
            response.error,
            response.isAutoSelected);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestRequestTokenResponseParamsProxyToResponder
      implements FederatedAuthRequest.RequestToken_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestRequestTokenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int status,
        Url selectedIdentityProviderConfigUrl,
        String token,
        TokenError error,
        boolean isAutoSelected) {
      FederatedAuthRequestRequestTokenResponseParams _response =
          new FederatedAuthRequestRequestTokenResponseParams();
      _response.status = status;
      _response.selectedIdentityProviderConfigUrl = selectedIdentityProviderConfigUrl;
      _response.token = token;
      _response.error = error;
      _response.isAutoSelected = isAutoSelected;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestRequestUserInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public IdentityProviderConfig provider;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestRequestUserInfoParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestRequestUserInfoParams() {
      this(0);
    }

    public static FederatedAuthRequestRequestUserInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestRequestUserInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestRequestUserInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestRequestUserInfoParams result =
            new FederatedAuthRequestRequestUserInfoParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.provider = IdentityProviderConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.provider, 8, false);
    }
  }

  static final class FederatedAuthRequestRequestUserInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;
    public IdentityUserInfo[] userInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestRequestUserInfoResponseParams(int version) {
      super(24, version);
    }

    public FederatedAuthRequestRequestUserInfoResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestRequestUserInfoResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestRequestUserInfoResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestRequestUserInfoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestRequestUserInfoResponseParams result =
            new FederatedAuthRequestRequestUserInfoResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        RequestUserInfoStatus.validate(readInt);
        result.status = RequestUserInfoStatus.toKnownValue(result.status);
        Decoder decoder1 = decoder0.readPointer(16, true);
        if (decoder1 == null) {
          result.userInfo = null;
        } else {
          DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
          result.userInfo = new IdentityUserInfo[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
            result.userInfo[i1] = IdentityUserInfo.decode(decoder2);
          }
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      IdentityUserInfo[] identityUserInfoArr = this.userInfo;
      if (identityUserInfoArr == null) {
        encoder0.encodeNullPointer(16, true);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(identityUserInfoArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        IdentityUserInfo[] identityUserInfoArr2 = this.userInfo;
        if (i0 < identityUserInfoArr2.length) {
          encoder1.encode((Struct) identityUserInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class FederatedAuthRequestRequestUserInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequest.RequestUserInfo_Response mCallback;

    FederatedAuthRequestRequestUserInfoResponseParamsForwardToCallback(
        FederatedAuthRequest.RequestUserInfo_Response callback) {
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
        FederatedAuthRequestRequestUserInfoResponseParams response =
            FederatedAuthRequestRequestUserInfoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.userInfo);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestRequestUserInfoResponseParamsProxyToResponder
      implements FederatedAuthRequest.RequestUserInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestRequestUserInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, IdentityUserInfo[] userInfo) {
      FederatedAuthRequestRequestUserInfoResponseParams _response =
          new FederatedAuthRequestRequestUserInfoResponseParams();
      _response.status = status;
      _response.userInfo = userInfo;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestCancelTokenRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestCancelTokenRequestParams(int version) {
      super(8, version);
    }

    public FederatedAuthRequestCancelTokenRequestParams() {
      this(0);
    }

    public static FederatedAuthRequestCancelTokenRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestCancelTokenRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestCancelTokenRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestCancelTokenRequestParams result =
            new FederatedAuthRequestCancelTokenRequestParams(elementsOrVersion);
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

  static final class FederatedAuthRequestResolveTokenRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestResolveTokenRequestParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestResolveTokenRequestParams() {
      this(0);
    }

    public static FederatedAuthRequestResolveTokenRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestResolveTokenRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestResolveTokenRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestResolveTokenRequestParams result =
            new FederatedAuthRequestResolveTokenRequestParams(elementsOrVersion);
        result.token = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.token, 8, false);
    }
  }

  static final class FederatedAuthRequestResolveTokenRequestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestResolveTokenRequestResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestResolveTokenRequestResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestResolveTokenRequestResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestResolveTokenRequestResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestResolveTokenRequestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestResolveTokenRequestResponseParams result =
            new FederatedAuthRequestResolveTokenRequestResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FederatedAuthRequestResolveTokenRequestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequest.ResolveTokenRequest_Response mCallback;

    FederatedAuthRequestResolveTokenRequestResponseParamsForwardToCallback(
        FederatedAuthRequest.ResolveTokenRequest_Response callback) {
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
        FederatedAuthRequestResolveTokenRequestResponseParams response =
            FederatedAuthRequestResolveTokenRequestResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestResolveTokenRequestResponseParamsProxyToResponder
      implements FederatedAuthRequest.ResolveTokenRequest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestResolveTokenRequestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FederatedAuthRequestResolveTokenRequestResponseParams _response =
          new FederatedAuthRequestResolveTokenRequestResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestSetIdpSigninStatusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin origin;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestSetIdpSigninStatusParams(int version) {
      super(24, version);
    }

    public FederatedAuthRequestSetIdpSigninStatusParams() {
      this(0);
    }

    public static FederatedAuthRequestSetIdpSigninStatusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestSetIdpSigninStatusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestSetIdpSigninStatusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestSetIdpSigninStatusParams result =
            new FederatedAuthRequestSetIdpSigninStatusParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.status = readInt;
        IdpSigninStatus.validate(readInt);
        result.status = IdpSigninStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode(this.status, 16);
    }
  }

  static final class FederatedAuthRequestRegisterIdPParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestRegisterIdPParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestRegisterIdPParams() {
      this(0);
    }

    public static FederatedAuthRequestRegisterIdPParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestRegisterIdPParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestRegisterIdPParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestRegisterIdPParams result =
            new FederatedAuthRequestRegisterIdPParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class FederatedAuthRequestRegisterIdPResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean accepted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestRegisterIdPResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestRegisterIdPResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestRegisterIdPResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestRegisterIdPResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestRegisterIdPResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestRegisterIdPResponseParams result =
            new FederatedAuthRequestRegisterIdPResponseParams(elementsOrVersion);
        result.accepted = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.accepted, 8, 0);
    }
  }

  static class FederatedAuthRequestRegisterIdPResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequest.RegisterIdP_Response mCallback;

    FederatedAuthRequestRegisterIdPResponseParamsForwardToCallback(
        FederatedAuthRequest.RegisterIdP_Response callback) {
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
        FederatedAuthRequestRegisterIdPResponseParams response =
            FederatedAuthRequestRegisterIdPResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.accepted);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestRegisterIdPResponseParamsProxyToResponder
      implements FederatedAuthRequest.RegisterIdP_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestRegisterIdPResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean accepted) {
      FederatedAuthRequestRegisterIdPResponseParams _response =
          new FederatedAuthRequestRegisterIdPResponseParams();
      _response.accepted = accepted;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestUnregisterIdPParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestUnregisterIdPParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestUnregisterIdPParams() {
      this(0);
    }

    public static FederatedAuthRequestUnregisterIdPParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestUnregisterIdPParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestUnregisterIdPParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestUnregisterIdPParams result =
            new FederatedAuthRequestUnregisterIdPParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class FederatedAuthRequestUnregisterIdPResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestUnregisterIdPResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestUnregisterIdPResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestUnregisterIdPResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestUnregisterIdPResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestUnregisterIdPResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestUnregisterIdPResponseParams result =
            new FederatedAuthRequestUnregisterIdPResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FederatedAuthRequestUnregisterIdPResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequest.UnregisterIdP_Response mCallback;

    FederatedAuthRequestUnregisterIdPResponseParamsForwardToCallback(
        FederatedAuthRequest.UnregisterIdP_Response callback) {
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
        FederatedAuthRequestUnregisterIdPResponseParams response =
            FederatedAuthRequestUnregisterIdPResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestUnregisterIdPResponseParamsProxyToResponder
      implements FederatedAuthRequest.UnregisterIdP_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestUnregisterIdPResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FederatedAuthRequestUnregisterIdPResponseParams _response =
          new FederatedAuthRequestUnregisterIdPResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestCloseModalDialogViewParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestCloseModalDialogViewParams(int version) {
      super(8, version);
    }

    public FederatedAuthRequestCloseModalDialogViewParams() {
      this(0);
    }

    public static FederatedAuthRequestCloseModalDialogViewParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestCloseModalDialogViewParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestCloseModalDialogViewParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestCloseModalDialogViewParams result =
            new FederatedAuthRequestCloseModalDialogViewParams(elementsOrVersion);
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

  static final class FederatedAuthRequestPreventSilentAccessParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestPreventSilentAccessParams(int version) {
      super(8, version);
    }

    public FederatedAuthRequestPreventSilentAccessParams() {
      this(0);
    }

    public static FederatedAuthRequestPreventSilentAccessParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestPreventSilentAccessParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestPreventSilentAccessParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestPreventSilentAccessParams result =
            new FederatedAuthRequestPreventSilentAccessParams(elementsOrVersion);
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

  static final class FederatedAuthRequestPreventSilentAccessResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestPreventSilentAccessResponseParams(int version) {
      super(8, version);
    }

    public FederatedAuthRequestPreventSilentAccessResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestPreventSilentAccessResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestPreventSilentAccessResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestPreventSilentAccessResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestPreventSilentAccessResponseParams result =
            new FederatedAuthRequestPreventSilentAccessResponseParams(elementsOrVersion);
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

  static class FederatedAuthRequestPreventSilentAccessResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequest.PreventSilentAccess_Response mCallback;

    FederatedAuthRequestPreventSilentAccessResponseParamsForwardToCallback(
        FederatedAuthRequest.PreventSilentAccess_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestPreventSilentAccessResponseParamsProxyToResponder
      implements FederatedAuthRequest.PreventSilentAccess_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestPreventSilentAccessResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      FederatedAuthRequestPreventSilentAccessResponseParams _response =
          new FederatedAuthRequestPreventSilentAccessResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestDisconnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public IdentityCredentialDisconnectOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestDisconnectParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestDisconnectParams() {
      this(0);
    }

    public static FederatedAuthRequestDisconnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestDisconnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestDisconnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestDisconnectParams result =
            new FederatedAuthRequestDisconnectParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.options = IdentityCredentialDisconnectOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.options, 8, false);
    }
  }

  static final class FederatedAuthRequestDisconnectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestDisconnectResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestDisconnectResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestDisconnectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestDisconnectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestDisconnectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestDisconnectResponseParams result =
            new FederatedAuthRequestDisconnectResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        DisconnectStatus.validate(readInt);
        result.status = DisconnectStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
    }
  }

  static class FederatedAuthRequestDisconnectResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequest.Disconnect_Response mCallback;

    FederatedAuthRequestDisconnectResponseParamsForwardToCallback(
        FederatedAuthRequest.Disconnect_Response callback) {
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
        FederatedAuthRequestDisconnectResponseParams response =
            FederatedAuthRequestDisconnectResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestDisconnectResponseParamsProxyToResponder
      implements FederatedAuthRequest.Disconnect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestDisconnectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      FederatedAuthRequestDisconnectResponseParams _response =
          new FederatedAuthRequestDisconnectResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
