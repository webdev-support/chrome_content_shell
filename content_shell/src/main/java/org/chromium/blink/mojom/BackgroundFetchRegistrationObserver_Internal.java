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

class BackgroundFetchRegistrationObserver_Internal {
  public static final Interface.Manager<
          BackgroundFetchRegistrationObserver, BackgroundFetchRegistrationObserver.Proxy>
      MANAGER =
          new Interface.Manager<
              BackgroundFetchRegistrationObserver, BackgroundFetchRegistrationObserver.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.BackgroundFetchRegistrationObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public BackgroundFetchRegistrationObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, BackgroundFetchRegistrationObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public BackgroundFetchRegistrationObserver[] buildArray(int size) {
              return new BackgroundFetchRegistrationObserver[size];
            }
          };
  private static final int ON_PROGRESS_ORDINAL = 0;
  private static final int ON_RECORDS_UNAVAILABLE_ORDINAL = 1;
  private static final int ON_REQUEST_COMPLETED_ORDINAL = 2;

  BackgroundFetchRegistrationObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements BackgroundFetchRegistrationObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onProgress(
        long uploadTotal,
        long uploaded,
        long downloadTotal,
        long downloaded,
        int result,
        int failureReason) {
      BackgroundFetchRegistrationObserverOnProgressParams _message =
          new BackgroundFetchRegistrationObserverOnProgressParams();
      _message.uploadTotal = uploadTotal;
      _message.uploaded = uploaded;
      _message.downloadTotal = downloadTotal;
      _message.downloaded = downloaded;
      _message.result = result;
      _message.failureReason = failureReason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onRecordsUnavailable() {
      BackgroundFetchRegistrationObserverOnRecordsUnavailableParams _message =
          new BackgroundFetchRegistrationObserverOnRecordsUnavailableParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onRequestCompleted(FetchApiRequest request, FetchApiResponse response) {
      BackgroundFetchRegistrationObserverOnRequestCompletedParams _message =
          new BackgroundFetchRegistrationObserverOnRequestCompletedParams();
      _message.request = request;
      _message.response = response;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<BackgroundFetchRegistrationObserver> {
    Stub(Core core, BackgroundFetchRegistrationObserver impl) {
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
                BackgroundFetchRegistrationObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            BackgroundFetchRegistrationObserverOnProgressParams data =
                BackgroundFetchRegistrationObserverOnProgressParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onProgress(
                    data.uploadTotal,
                    data.uploaded,
                    data.downloadTotal,
                    data.downloaded,
                    data.result,
                    data.failureReason);
            return true;
          case 1:
            BackgroundFetchRegistrationObserverOnRecordsUnavailableParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onRecordsUnavailable();
            return true;
          case 2:
            BackgroundFetchRegistrationObserverOnRequestCompletedParams data2 =
                BackgroundFetchRegistrationObserverOnRequestCompletedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onRequestCompleted(data2.request, data2.response);
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
                getCore(),
                BackgroundFetchRegistrationObserver_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class BackgroundFetchRegistrationObserverOnProgressParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public long downloadTotal;
    public long downloaded;
    public int failureReason;
    public int result;
    public long uploadTotal;
    public long uploaded;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationObserverOnProgressParams(int version) {
      super(48, version);
    }

    public BackgroundFetchRegistrationObserverOnProgressParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationObserverOnProgressParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationObserverOnProgressParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationObserverOnProgressParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationObserverOnProgressParams result =
            new BackgroundFetchRegistrationObserverOnProgressParams(elementsOrVersion);
        result.uploadTotal = decoder0.readLong(8);
        result.uploaded = decoder0.readLong(16);
        result.downloadTotal = decoder0.readLong(24);
        result.downloaded = decoder0.readLong(32);
        int readInt = decoder0.readInt(40);
        result.result = readInt;
        BackgroundFetchResult.validate(readInt);
        result.result = BackgroundFetchResult.toKnownValue(result.result);
        int readInt2 = decoder0.readInt(44);
        result.failureReason = readInt2;
        BackgroundFetchFailureReason.validate(readInt2);
        result.failureReason = BackgroundFetchFailureReason.toKnownValue(result.failureReason);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.uploadTotal, 8);
      encoder0.encode(this.uploaded, 16);
      encoder0.encode(this.downloadTotal, 24);
      encoder0.encode(this.downloaded, 32);
      encoder0.encode(this.result, 40);
      encoder0.encode(this.failureReason, 44);
    }
  }

  static final class BackgroundFetchRegistrationObserverOnRecordsUnavailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationObserverOnRecordsUnavailableParams(int version) {
      super(8, version);
    }

    public BackgroundFetchRegistrationObserverOnRecordsUnavailableParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationObserverOnRecordsUnavailableParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationObserverOnRecordsUnavailableParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationObserverOnRecordsUnavailableParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationObserverOnRecordsUnavailableParams result =
            new BackgroundFetchRegistrationObserverOnRecordsUnavailableParams(elementsOrVersion);
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

  static final class BackgroundFetchRegistrationObserverOnRequestCompletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FetchApiRequest request;
    public FetchApiResponse response;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationObserverOnRequestCompletedParams(int version) {
      super(24, version);
    }

    public BackgroundFetchRegistrationObserverOnRequestCompletedParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationObserverOnRequestCompletedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationObserverOnRequestCompletedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationObserverOnRequestCompletedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationObserverOnRequestCompletedParams result =
            new BackgroundFetchRegistrationObserverOnRequestCompletedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.request = FetchApiRequest.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.response = FetchApiResponse.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.request, 8, false);
      encoder0.encode((Struct) this.response, 16, true);
    }
  }
}
