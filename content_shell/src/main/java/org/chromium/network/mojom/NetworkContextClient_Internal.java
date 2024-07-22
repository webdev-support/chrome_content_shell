package org.chromium.network.mojom;

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
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.ReadOnlyFile;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

class NetworkContextClient_Internal {
  public static final Interface.Manager<NetworkContextClient, NetworkContextClient.Proxy> MANAGER =
      new Interface.Manager<NetworkContextClient, NetworkContextClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.NetworkContextClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public NetworkContextClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, NetworkContextClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public NetworkContextClient[] buildArray(int size) {
          return new NetworkContextClient[size];
        }
      };
  private static final int ON_CAN_SEND_DOMAIN_RELIABILITY_UPLOAD_ORDINAL = 2;
  private static final int ON_CAN_SEND_REPORTING_REPORTS_ORDINAL = 1;
  private static final int ON_CAN_SEND_SCT_AUDITING_REPORT_ORDINAL = 4;
  private static final int ON_FILE_UPLOAD_REQUESTED_ORDINAL = 0;
  private static final int ON_GENERATE_HTTP_NEGOTIATE_AUTH_TOKEN_ORDINAL = 3;
  private static final int ON_NEW_SCT_AUDITING_REPORT_SENT_ORDINAL = 5;

  NetworkContextClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements NetworkContextClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onFileUploadRequested(
        int processId,
        boolean async,
        FilePath[] filePaths,
        Url destinationUrl,
        NetworkContextClient.OnFileUploadRequested_Response callback) {
      NetworkContextClientOnFileUploadRequestedParams _message =
          new NetworkContextClientOnFileUploadRequestedParams();
      _message.processId = processId;
      _message.async = async;
      _message.filePaths = filePaths;
      _message.destinationUrl = destinationUrl;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new NetworkContextClientOnFileUploadRequestedResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onCanSendReportingReports(
        Origin[] origins, NetworkContextClient.OnCanSendReportingReports_Response callback) {
      NetworkContextClientOnCanSendReportingReportsParams _message =
          new NetworkContextClientOnCanSendReportingReportsParams();
      _message.origins = origins;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new NetworkContextClientOnCanSendReportingReportsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onCanSendDomainReliabilityUpload(
        Origin origin, NetworkContextClient.OnCanSendDomainReliabilityUpload_Response callback) {
      NetworkContextClientOnCanSendDomainReliabilityUploadParams _message =
          new NetworkContextClientOnCanSendDomainReliabilityUploadParams();
      _message.origin = origin;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onGenerateHttpNegotiateAuthToken(
        String serverAuthToken,
        boolean canDelegate,
        String authNegotiateAndroidAccountType,
        String spn,
        NetworkContextClient.OnGenerateHttpNegotiateAuthToken_Response callback) {
      NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams _message =
          new NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams();
      _message.serverAuthToken = serverAuthToken;
      _message.canDelegate = canDelegate;
      _message.authNegotiateAndroidAccountType = authNegotiateAndroidAccountType;
      _message.spn = spn;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onCanSendSctAuditingReport(
        NetworkContextClient.OnCanSendSctAuditingReport_Response callback) {
      NetworkContextClientOnCanSendSctAuditingReportParams _message =
          new NetworkContextClientOnCanSendSctAuditingReportParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new NetworkContextClientOnCanSendSctAuditingReportResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onNewSctAuditingReportSent() {
      NetworkContextClientOnNewSctAuditingReportSentParams _message =
          new NetworkContextClientOnNewSctAuditingReportSentParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<NetworkContextClient> {
    Stub(Core core, NetworkContextClient impl) {
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
                NetworkContextClient_Internal.MANAGER, messageWithHeader);
          case 5:
            NetworkContextClientOnNewSctAuditingReportSentParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onNewSctAuditingReportSent();
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
                getCore(), NetworkContextClient_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            NetworkContextClientOnFileUploadRequestedParams data =
                NetworkContextClientOnFileUploadRequestedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onFileUploadRequested(
                    data.processId,
                    data.async,
                    data.filePaths,
                    data.destinationUrl,
                    new NetworkContextClientOnFileUploadRequestedResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            getImpl()
                .onCanSendReportingReports(
                    NetworkContextClientOnCanSendReportingReportsParams.deserialize(
                            messageWithHeader.getPayload())
                        .origins,
                    new NetworkContextClientOnCanSendReportingReportsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .onCanSendDomainReliabilityUpload(
                    NetworkContextClientOnCanSendDomainReliabilityUploadParams.deserialize(
                            messageWithHeader.getPayload())
                        .origin,
                    new NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams data2 =
                NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onGenerateHttpNegotiateAuthToken(
                    data2.serverAuthToken,
                    data2.canDelegate,
                    data2.authNegotiateAndroidAccountType,
                    data2.spn,
                    new NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            NetworkContextClientOnCanSendSctAuditingReportParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .onCanSendSctAuditingReport(
                    new NetworkContextClientOnCanSendSctAuditingReportResponseParamsProxyToResponder(
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

  static final class NetworkContextClientOnFileUploadRequestedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean async;
    public Url destinationUrl;
    public FilePath[] filePaths;
    public int processId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnFileUploadRequestedParams(int version) {
      super(32, version);
    }

    public NetworkContextClientOnFileUploadRequestedParams() {
      this(0);
    }

    public static NetworkContextClientOnFileUploadRequestedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnFileUploadRequestedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnFileUploadRequestedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnFileUploadRequestedParams result =
            new NetworkContextClientOnFileUploadRequestedParams(elementsOrVersion);
        result.processId = decoder0.readInt(8);
        result.async = decoder0.readBoolean(12, 0);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.filePaths = new FilePath[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.filePaths[i1] = FilePath.decode(decoder2);
        }
        result.destinationUrl = Url.decode(decoder0.readPointer(24, false));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.processId, 8);
      encoder0.encode(this.async, 12, 0);
      FilePath[] filePathArr = this.filePaths;
      if (filePathArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(filePathArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          FilePath[] filePathArr2 = this.filePaths;
          if (i0 >= filePathArr2.length) {
            break;
          }
          encoder1.encode((Struct) filePathArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.destinationUrl, 24, false);
    }
  }

  static final class NetworkContextClientOnFileUploadRequestedResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyFile[] files;
    public int netError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnFileUploadRequestedResponseParams(int version) {
      super(24, version);
    }

    public NetworkContextClientOnFileUploadRequestedResponseParams() {
      this(0);
    }

    public static NetworkContextClientOnFileUploadRequestedResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnFileUploadRequestedResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnFileUploadRequestedResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnFileUploadRequestedResponseParams result =
            new NetworkContextClientOnFileUploadRequestedResponseParams(elementsOrVersion);
        result.netError = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.files = new ReadOnlyFile[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.files[i1] = ReadOnlyFile.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.netError, 8);
      ReadOnlyFile[] readOnlyFileArr = this.files;
      if (readOnlyFileArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(readOnlyFileArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        ReadOnlyFile[] readOnlyFileArr2 = this.files;
        if (i0 < readOnlyFileArr2.length) {
          encoder1.encode((Struct) readOnlyFileArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class NetworkContextClientOnFileUploadRequestedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContextClient.OnFileUploadRequested_Response mCallback;

    NetworkContextClientOnFileUploadRequestedResponseParamsForwardToCallback(
        NetworkContextClient.OnFileUploadRequested_Response callback) {
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
        NetworkContextClientOnFileUploadRequestedResponseParams response =
            NetworkContextClientOnFileUploadRequestedResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.netError, response.files);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClientOnFileUploadRequestedResponseParamsProxyToResponder
      implements NetworkContextClient.OnFileUploadRequested_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClientOnFileUploadRequestedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int netError, ReadOnlyFile[] files) {
      NetworkContextClientOnFileUploadRequestedResponseParams _response =
          new NetworkContextClientOnFileUploadRequestedResponseParams();
      _response.netError = netError;
      _response.files = files;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClientOnCanSendReportingReportsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin[] origins;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnCanSendReportingReportsParams(int version) {
      super(16, version);
    }

    public NetworkContextClientOnCanSendReportingReportsParams() {
      this(0);
    }

    public static NetworkContextClientOnCanSendReportingReportsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnCanSendReportingReportsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnCanSendReportingReportsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnCanSendReportingReportsParams result =
            new NetworkContextClientOnCanSendReportingReportsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.origins = new Origin[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.origins[i1] = Origin.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Origin[] originArr = this.origins;
      if (originArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(originArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Origin[] originArr2 = this.origins;
        if (i0 < originArr2.length) {
          encoder1.encode((Struct) originArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class NetworkContextClientOnCanSendReportingReportsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin[] origins;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnCanSendReportingReportsResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextClientOnCanSendReportingReportsResponseParams() {
      this(0);
    }

    public static NetworkContextClientOnCanSendReportingReportsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnCanSendReportingReportsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnCanSendReportingReportsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnCanSendReportingReportsResponseParams result =
            new NetworkContextClientOnCanSendReportingReportsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.origins = new Origin[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.origins[i1] = Origin.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Origin[] originArr = this.origins;
      if (originArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(originArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Origin[] originArr2 = this.origins;
        if (i0 < originArr2.length) {
          encoder1.encode((Struct) originArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class NetworkContextClientOnCanSendReportingReportsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContextClient.OnCanSendReportingReports_Response mCallback;

    NetworkContextClientOnCanSendReportingReportsResponseParamsForwardToCallback(
        NetworkContextClient.OnCanSendReportingReports_Response callback) {
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
        NetworkContextClientOnCanSendReportingReportsResponseParams response =
            NetworkContextClientOnCanSendReportingReportsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.origins);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClientOnCanSendReportingReportsResponseParamsProxyToResponder
      implements NetworkContextClient.OnCanSendReportingReports_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClientOnCanSendReportingReportsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Origin[] origins) {
      NetworkContextClientOnCanSendReportingReportsResponseParams _response =
          new NetworkContextClientOnCanSendReportingReportsResponseParams();
      _response.origins = origins;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClientOnCanSendDomainReliabilityUploadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnCanSendDomainReliabilityUploadParams(int version) {
      super(16, version);
    }

    public NetworkContextClientOnCanSendDomainReliabilityUploadParams() {
      this(0);
    }

    public static NetworkContextClientOnCanSendDomainReliabilityUploadParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnCanSendDomainReliabilityUploadParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnCanSendDomainReliabilityUploadParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnCanSendDomainReliabilityUploadParams result =
            new NetworkContextClientOnCanSendDomainReliabilityUploadParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
    }
  }

  static final class NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allowed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams() {
      this(0);
    }

    public static NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams result =
            new NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams(
                elementsOrVersion);
        result.allowed = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.allowed, 8, 0);
    }
  }

  static class NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContextClient.OnCanSendDomainReliabilityUpload_Response mCallback;

    NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsForwardToCallback(
        NetworkContextClient.OnCanSendDomainReliabilityUpload_Response callback) {
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
        NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams response =
            NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.allowed);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsProxyToResponder
      implements NetworkContextClient.OnCanSendDomainReliabilityUpload_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean allowed) {
      NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams _response =
          new NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams();
      _response.allowed = allowed;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public String authNegotiateAndroidAccountType;
    public boolean canDelegate;
    public String serverAuthToken;
    public String spn;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams(int version) {
      super(40, version);
    }

    public NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams() {
      this(0);
    }

    public static NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams result =
            new NetworkContextClientOnGenerateHttpNegotiateAuthTokenParams(elementsOrVersion);
        result.serverAuthToken = decoder0.readString(8, false);
        result.canDelegate = decoder0.readBoolean(16, 0);
        result.authNegotiateAndroidAccountType = decoder0.readString(24, false);
        result.spn = decoder0.readString(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serverAuthToken, 8, false);
      encoder0.encode(this.canDelegate, 16, 0);
      encoder0.encode(this.authNegotiateAndroidAccountType, 24, false);
      encoder0.encode(this.spn, 32, false);
    }
  }

  static final class NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String authToken;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams(int version) {
      super(24, version);
    }

    public NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams() {
      this(0);
    }

    public static NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams result =
            new NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams(
                elementsOrVersion);
        result.result = decoder0.readInt(8);
        result.authToken = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode(this.authToken, 16, false);
    }
  }

  static class NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContextClient.OnGenerateHttpNegotiateAuthToken_Response mCallback;

    NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParamsForwardToCallback(
        NetworkContextClient.OnGenerateHttpNegotiateAuthToken_Response callback) {
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
        NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams response =
            NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.authToken);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParamsProxyToResponder
      implements NetworkContextClient.OnGenerateHttpNegotiateAuthToken_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, String authToken) {
      NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams _response =
          new NetworkContextClientOnGenerateHttpNegotiateAuthTokenResponseParams();
      _response.result = result;
      _response.authToken = authToken;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClientOnCanSendSctAuditingReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnCanSendSctAuditingReportParams(int version) {
      super(8, version);
    }

    public NetworkContextClientOnCanSendSctAuditingReportParams() {
      this(0);
    }

    public static NetworkContextClientOnCanSendSctAuditingReportParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnCanSendSctAuditingReportParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnCanSendSctAuditingReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnCanSendSctAuditingReportParams result =
            new NetworkContextClientOnCanSendSctAuditingReportParams(elementsOrVersion);
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

  static final class NetworkContextClientOnCanSendSctAuditingReportResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allowed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnCanSendSctAuditingReportResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextClientOnCanSendSctAuditingReportResponseParams() {
      this(0);
    }

    public static NetworkContextClientOnCanSendSctAuditingReportResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnCanSendSctAuditingReportResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnCanSendSctAuditingReportResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnCanSendSctAuditingReportResponseParams result =
            new NetworkContextClientOnCanSendSctAuditingReportResponseParams(elementsOrVersion);
        result.allowed = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.allowed, 8, 0);
    }
  }

  static class NetworkContextClientOnCanSendSctAuditingReportResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContextClient.OnCanSendSctAuditingReport_Response mCallback;

    NetworkContextClientOnCanSendSctAuditingReportResponseParamsForwardToCallback(
        NetworkContextClient.OnCanSendSctAuditingReport_Response callback) {
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
        NetworkContextClientOnCanSendSctAuditingReportResponseParams response =
            NetworkContextClientOnCanSendSctAuditingReportResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.allowed);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClientOnCanSendSctAuditingReportResponseParamsProxyToResponder
      implements NetworkContextClient.OnCanSendSctAuditingReport_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClientOnCanSendSctAuditingReportResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean allowed) {
      NetworkContextClientOnCanSendSctAuditingReportResponseParams _response =
          new NetworkContextClientOnCanSendSctAuditingReportResponseParams();
      _response.allowed = allowed;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClientOnNewSctAuditingReportSentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClientOnNewSctAuditingReportSentParams(int version) {
      super(8, version);
    }

    public NetworkContextClientOnNewSctAuditingReportSentParams() {
      this(0);
    }

    public static NetworkContextClientOnNewSctAuditingReportSentParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClientOnNewSctAuditingReportSentParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClientOnNewSctAuditingReportSentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClientOnNewSctAuditingReportSentParams result =
            new NetworkContextClientOnNewSctAuditingReportSentParams(elementsOrVersion);
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
}
