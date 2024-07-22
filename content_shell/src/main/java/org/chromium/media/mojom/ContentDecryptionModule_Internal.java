package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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

class ContentDecryptionModule_Internal {
  private static final int CLOSE_SESSION_ORDINAL = 6;
  private static final int CREATE_SESSION_AND_GENERATE_REQUEST_ORDINAL = 3;
  private static final int GET_STATUS_FOR_POLICY_ORDINAL = 2;
  private static final int LOAD_SESSION_ORDINAL = 4;
  public static final Interface.Manager<ContentDecryptionModule, ContentDecryptionModule.Proxy>
      MANAGER =
          new Interface.Manager<ContentDecryptionModule, ContentDecryptionModule.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.ContentDecryptionModule";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ContentDecryptionModule.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ContentDecryptionModule impl) {
              return new Stub(core, impl);
            }

            @Override
            public ContentDecryptionModule[] buildArray(int size) {
              return new ContentDecryptionModule[size];
            }
          };
  private static final int REMOVE_SESSION_ORDINAL = 7;
  private static final int SET_CLIENT_ORDINAL = 0;
  private static final int SET_SERVER_CERTIFICATE_ORDINAL = 1;
  private static final int UPDATE_SESSION_ORDINAL = 5;

  ContentDecryptionModule_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ContentDecryptionModule.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setClient(AssociatedInterfaceNotSupported client) {
      ContentDecryptionModuleSetClientParams _message =
          new ContentDecryptionModuleSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setServerCertificate(
        byte[] certificateData, SetServerCertificate_Response callback) {
      ContentDecryptionModuleSetServerCertificateParams _message =
          new ContentDecryptionModuleSetServerCertificateParams();
      _message.certificateData = certificateData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ContentDecryptionModuleSetServerCertificateResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getStatusForPolicy(int minHdcpVersion, GetStatusForPolicy_Response callback) {
      ContentDecryptionModuleGetStatusForPolicyParams _message =
          new ContentDecryptionModuleGetStatusForPolicyParams();
      _message.minHdcpVersion = minHdcpVersion;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ContentDecryptionModuleGetStatusForPolicyResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void createSessionAndGenerateRequest(
        int sessionType,
        int initDataType,
        byte[] initData,
        CreateSessionAndGenerateRequest_Response callback) {
      ContentDecryptionModuleCreateSessionAndGenerateRequestParams _message =
          new ContentDecryptionModuleCreateSessionAndGenerateRequestParams();
      _message.sessionType = sessionType;
      _message.initDataType = initDataType;
      _message.initData = initData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void loadSession(int sessionType, String sessionId, LoadSession_Response callback) {
      ContentDecryptionModuleLoadSessionParams _message =
          new ContentDecryptionModuleLoadSessionParams();
      _message.sessionType = sessionType;
      _message.sessionId = sessionId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new ContentDecryptionModuleLoadSessionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void updateSession(String sessionId, byte[] response, UpdateSession_Response callback) {
      ContentDecryptionModuleUpdateSessionParams _message =
          new ContentDecryptionModuleUpdateSessionParams();
      _message.sessionId = sessionId;
      _message.response = response;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new ContentDecryptionModuleUpdateSessionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void closeSession(String sessionId, CloseSession_Response callback) {
      ContentDecryptionModuleCloseSessionParams _message =
          new ContentDecryptionModuleCloseSessionParams();
      _message.sessionId = sessionId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new ContentDecryptionModuleCloseSessionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void removeSession(String sessionId, RemoveSession_Response callback) {
      ContentDecryptionModuleRemoveSessionParams _message =
          new ContentDecryptionModuleRemoveSessionParams();
      _message.sessionId = sessionId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new ContentDecryptionModuleRemoveSessionResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ContentDecryptionModule> {
    Stub(Core core, ContentDecryptionModule impl) {
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
                ContentDecryptionModule_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ContentDecryptionModuleSetClientParams data =
                ContentDecryptionModuleSetClientParams.deserialize(messageWithHeader.getPayload());
            getImpl().setClient(data.client);
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
                getCore(), ContentDecryptionModule_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            ContentDecryptionModuleSetServerCertificateParams data =
                ContentDecryptionModuleSetServerCertificateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setServerCertificate(
                    data.certificateData,
                    new ContentDecryptionModuleSetServerCertificateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            ContentDecryptionModuleGetStatusForPolicyParams data2 =
                ContentDecryptionModuleGetStatusForPolicyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getStatusForPolicy(
                    data2.minHdcpVersion,
                    new ContentDecryptionModuleGetStatusForPolicyResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            ContentDecryptionModuleCreateSessionAndGenerateRequestParams data3 =
                ContentDecryptionModuleCreateSessionAndGenerateRequestParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createSessionAndGenerateRequest(
                    data3.sessionType,
                    data3.initDataType,
                    data3.initData,
                    new ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            ContentDecryptionModuleLoadSessionParams data4 =
                ContentDecryptionModuleLoadSessionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .loadSession(
                    data4.sessionType,
                    data4.sessionId,
                    new ContentDecryptionModuleLoadSessionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            ContentDecryptionModuleUpdateSessionParams data5 =
                ContentDecryptionModuleUpdateSessionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .updateSession(
                    data5.sessionId,
                    data5.response,
                    new ContentDecryptionModuleUpdateSessionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            ContentDecryptionModuleCloseSessionParams data6 =
                ContentDecryptionModuleCloseSessionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .closeSession(
                    data6.sessionId,
                    new ContentDecryptionModuleCloseSessionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            ContentDecryptionModuleRemoveSessionParams data7 =
                ContentDecryptionModuleRemoveSessionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .removeSession(
                    data7.sessionId,
                    new ContentDecryptionModuleRemoveSessionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ContentDecryptionModuleSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleSetClientParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleSetClientParams() {
      this(0);
    }

    public static ContentDecryptionModuleSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleSetClientParams result =
            new ContentDecryptionModuleSetClientParams(elementsOrVersion);
        result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false);
    }
  }

  static final class ContentDecryptionModuleSetServerCertificateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] certificateData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleSetServerCertificateParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleSetServerCertificateParams() {
      this(0);
    }

    public static ContentDecryptionModuleSetServerCertificateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleSetServerCertificateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleSetServerCertificateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleSetServerCertificateParams result =
            new ContentDecryptionModuleSetServerCertificateParams(elementsOrVersion);
        result.certificateData = decoder0.readBytes(8, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.certificateData, 8, 0, -1);
    }
  }

  static final class ContentDecryptionModuleSetServerCertificateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmPromiseResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleSetServerCertificateResponseParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleSetServerCertificateResponseParams() {
      this(0);
    }

    public static ContentDecryptionModuleSetServerCertificateResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleSetServerCertificateResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleSetServerCertificateResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleSetServerCertificateResponseParams result =
            new ContentDecryptionModuleSetServerCertificateResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = CdmPromiseResult.decode(decoder1);
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

  static class ContentDecryptionModuleSetServerCertificateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentDecryptionModule.SetServerCertificate_Response mCallback;

    ContentDecryptionModuleSetServerCertificateResponseParamsForwardToCallback(
        ContentDecryptionModule.SetServerCertificate_Response callback) {
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
        ContentDecryptionModuleSetServerCertificateResponseParams response =
            ContentDecryptionModuleSetServerCertificateResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentDecryptionModuleSetServerCertificateResponseParamsProxyToResponder
      implements ContentDecryptionModule.SetServerCertificate_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentDecryptionModuleSetServerCertificateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CdmPromiseResult result) {
      ContentDecryptionModuleSetServerCertificateResponseParams _response =
          new ContentDecryptionModuleSetServerCertificateResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentDecryptionModuleGetStatusForPolicyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int minHdcpVersion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleGetStatusForPolicyParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleGetStatusForPolicyParams() {
      this(0);
    }

    public static ContentDecryptionModuleGetStatusForPolicyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleGetStatusForPolicyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleGetStatusForPolicyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleGetStatusForPolicyParams result =
            new ContentDecryptionModuleGetStatusForPolicyParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.minHdcpVersion = readInt;
        HdcpVersion.validate(readInt);
        result.minHdcpVersion = HdcpVersion.toKnownValue(result.minHdcpVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.minHdcpVersion, 8);
    }
  }

  static final class ContentDecryptionModuleGetStatusForPolicyResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int keyStatus;
    public CdmPromiseResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleGetStatusForPolicyResponseParams(int version) {
      super(24, version);
    }

    public ContentDecryptionModuleGetStatusForPolicyResponseParams() {
      this(0);
    }

    public static ContentDecryptionModuleGetStatusForPolicyResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleGetStatusForPolicyResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleGetStatusForPolicyResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleGetStatusForPolicyResponseParams result =
            new ContentDecryptionModuleGetStatusForPolicyResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = CdmPromiseResult.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.keyStatus = readInt;
        CdmKeyStatus.validate(readInt);
        result.keyStatus = CdmKeyStatus.toKnownValue(result.keyStatus);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.keyStatus, 16);
    }
  }

  static class ContentDecryptionModuleGetStatusForPolicyResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentDecryptionModule.GetStatusForPolicy_Response mCallback;

    ContentDecryptionModuleGetStatusForPolicyResponseParamsForwardToCallback(
        ContentDecryptionModule.GetStatusForPolicy_Response callback) {
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
        ContentDecryptionModuleGetStatusForPolicyResponseParams response =
            ContentDecryptionModuleGetStatusForPolicyResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.keyStatus);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentDecryptionModuleGetStatusForPolicyResponseParamsProxyToResponder
      implements ContentDecryptionModule.GetStatusForPolicy_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentDecryptionModuleGetStatusForPolicyResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CdmPromiseResult result, int keyStatus) {
      ContentDecryptionModuleGetStatusForPolicyResponseParams _response =
          new ContentDecryptionModuleGetStatusForPolicyResponseParams();
      _response.result = result;
      _response.keyStatus = keyStatus;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentDecryptionModuleCreateSessionAndGenerateRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] initData;
    public int initDataType;
    public int sessionType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleCreateSessionAndGenerateRequestParams(int version) {
      super(24, version);
    }

    public ContentDecryptionModuleCreateSessionAndGenerateRequestParams() {
      this(0);
    }

    public static ContentDecryptionModuleCreateSessionAndGenerateRequestParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleCreateSessionAndGenerateRequestParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleCreateSessionAndGenerateRequestParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleCreateSessionAndGenerateRequestParams result =
            new ContentDecryptionModuleCreateSessionAndGenerateRequestParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.sessionType = readInt;
        CdmSessionType.validate(readInt);
        result.sessionType = CdmSessionType.toKnownValue(result.sessionType);
        int readInt2 = decoder0.readInt(12);
        result.initDataType = readInt2;
        EmeInitDataType.validate(readInt2);
        result.initDataType = EmeInitDataType.toKnownValue(result.initDataType);
        result.initData = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionType, 8);
      encoder0.encode(this.initDataType, 12);
      encoder0.encode(this.initData, 16, 0, -1);
    }
  }

  static final class ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmPromiseResult result;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams(int version) {
      super(24, version);
    }

    public ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams() {
      this(0);
    }

    public static ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams result =
            new ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = CdmPromiseResult.decode(decoder1);
        result.sessionId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.sessionId, 16, false);
    }
  }

  static class ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentDecryptionModule.CreateSessionAndGenerateRequest_Response mCallback;

    ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsForwardToCallback(
        ContentDecryptionModule.CreateSessionAndGenerateRequest_Response callback) {
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
        ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams response =
            ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.sessionId);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsProxyToResponder
      implements ContentDecryptionModule.CreateSessionAndGenerateRequest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CdmPromiseResult result, String sessionId) {
      ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams _response =
          new ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams();
      _response.result = result;
      _response.sessionId = sessionId;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentDecryptionModuleLoadSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String sessionId;
    public int sessionType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleLoadSessionParams(int version) {
      super(24, version);
    }

    public ContentDecryptionModuleLoadSessionParams() {
      this(0);
    }

    public static ContentDecryptionModuleLoadSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleLoadSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleLoadSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleLoadSessionParams result =
            new ContentDecryptionModuleLoadSessionParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.sessionType = readInt;
        CdmSessionType.validate(readInt);
        result.sessionType = CdmSessionType.toKnownValue(result.sessionType);
        result.sessionId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionType, 8);
      encoder0.encode(this.sessionId, 16, false);
    }
  }

  static final class ContentDecryptionModuleLoadSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmPromiseResult result;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleLoadSessionResponseParams(int version) {
      super(24, version);
    }

    public ContentDecryptionModuleLoadSessionResponseParams() {
      this(0);
    }

    public static ContentDecryptionModuleLoadSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleLoadSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleLoadSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleLoadSessionResponseParams result =
            new ContentDecryptionModuleLoadSessionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = CdmPromiseResult.decode(decoder1);
        result.sessionId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.sessionId, 16, false);
    }
  }

  static class ContentDecryptionModuleLoadSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentDecryptionModule.LoadSession_Response mCallback;

    ContentDecryptionModuleLoadSessionResponseParamsForwardToCallback(
        ContentDecryptionModule.LoadSession_Response callback) {
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
        ContentDecryptionModuleLoadSessionResponseParams response =
            ContentDecryptionModuleLoadSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.sessionId);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentDecryptionModuleLoadSessionResponseParamsProxyToResponder
      implements ContentDecryptionModule.LoadSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentDecryptionModuleLoadSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CdmPromiseResult result, String sessionId) {
      ContentDecryptionModuleLoadSessionResponseParams _response =
          new ContentDecryptionModuleLoadSessionResponseParams();
      _response.result = result;
      _response.sessionId = sessionId;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentDecryptionModuleUpdateSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] response;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleUpdateSessionParams(int version) {
      super(24, version);
    }

    public ContentDecryptionModuleUpdateSessionParams() {
      this(0);
    }

    public static ContentDecryptionModuleUpdateSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleUpdateSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleUpdateSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleUpdateSessionParams result =
            new ContentDecryptionModuleUpdateSessionParams(elementsOrVersion);
        result.sessionId = decoder0.readString(8, false);
        result.response = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionId, 8, false);
      encoder0.encode(this.response, 16, 0, -1);
    }
  }

  static final class ContentDecryptionModuleUpdateSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmPromiseResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleUpdateSessionResponseParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleUpdateSessionResponseParams() {
      this(0);
    }

    public static ContentDecryptionModuleUpdateSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleUpdateSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleUpdateSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleUpdateSessionResponseParams result =
            new ContentDecryptionModuleUpdateSessionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = CdmPromiseResult.decode(decoder1);
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

  static class ContentDecryptionModuleUpdateSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentDecryptionModule.UpdateSession_Response mCallback;

    ContentDecryptionModuleUpdateSessionResponseParamsForwardToCallback(
        ContentDecryptionModule.UpdateSession_Response callback) {
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
        ContentDecryptionModuleUpdateSessionResponseParams response =
            ContentDecryptionModuleUpdateSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentDecryptionModuleUpdateSessionResponseParamsProxyToResponder
      implements ContentDecryptionModule.UpdateSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentDecryptionModuleUpdateSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CdmPromiseResult result) {
      ContentDecryptionModuleUpdateSessionResponseParams _response =
          new ContentDecryptionModuleUpdateSessionResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentDecryptionModuleCloseSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleCloseSessionParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleCloseSessionParams() {
      this(0);
    }

    public static ContentDecryptionModuleCloseSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleCloseSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleCloseSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleCloseSessionParams result =
            new ContentDecryptionModuleCloseSessionParams(elementsOrVersion);
        result.sessionId = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionId, 8, false);
    }
  }

  static final class ContentDecryptionModuleCloseSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmPromiseResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleCloseSessionResponseParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleCloseSessionResponseParams() {
      this(0);
    }

    public static ContentDecryptionModuleCloseSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleCloseSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleCloseSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleCloseSessionResponseParams result =
            new ContentDecryptionModuleCloseSessionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = CdmPromiseResult.decode(decoder1);
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

  static class ContentDecryptionModuleCloseSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentDecryptionModule.CloseSession_Response mCallback;

    ContentDecryptionModuleCloseSessionResponseParamsForwardToCallback(
        ContentDecryptionModule.CloseSession_Response callback) {
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
        ContentDecryptionModuleCloseSessionResponseParams response =
            ContentDecryptionModuleCloseSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentDecryptionModuleCloseSessionResponseParamsProxyToResponder
      implements ContentDecryptionModule.CloseSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentDecryptionModuleCloseSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CdmPromiseResult result) {
      ContentDecryptionModuleCloseSessionResponseParams _response =
          new ContentDecryptionModuleCloseSessionResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentDecryptionModuleRemoveSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleRemoveSessionParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleRemoveSessionParams() {
      this(0);
    }

    public static ContentDecryptionModuleRemoveSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleRemoveSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleRemoveSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleRemoveSessionParams result =
            new ContentDecryptionModuleRemoveSessionParams(elementsOrVersion);
        result.sessionId = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionId, 8, false);
    }
  }

  static final class ContentDecryptionModuleRemoveSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmPromiseResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleRemoveSessionResponseParams(int version) {
      super(16, version);
    }

    public ContentDecryptionModuleRemoveSessionResponseParams() {
      this(0);
    }

    public static ContentDecryptionModuleRemoveSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleRemoveSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleRemoveSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleRemoveSessionResponseParams result =
            new ContentDecryptionModuleRemoveSessionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = CdmPromiseResult.decode(decoder1);
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

  static class ContentDecryptionModuleRemoveSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentDecryptionModule.RemoveSession_Response mCallback;

    ContentDecryptionModuleRemoveSessionResponseParamsForwardToCallback(
        ContentDecryptionModule.RemoveSession_Response callback) {
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
        ContentDecryptionModuleRemoveSessionResponseParams response =
            ContentDecryptionModuleRemoveSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentDecryptionModuleRemoveSessionResponseParamsProxyToResponder
      implements ContentDecryptionModule.RemoveSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentDecryptionModuleRemoveSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CdmPromiseResult result) {
      ContentDecryptionModuleRemoveSessionResponseParams _response =
          new ContentDecryptionModuleRemoveSessionResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
