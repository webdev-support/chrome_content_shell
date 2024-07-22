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
import org.chromium.skia.mojom.BitmapN32;

class BackgroundFetchRegistrationService_Internal {
  private static final int ABORT_ORDINAL = 1;
  private static final int ADD_REGISTRATION_OBSERVER_ORDINAL = 3;
  public static final Interface.Manager<
          BackgroundFetchRegistrationService, BackgroundFetchRegistrationService.Proxy>
      MANAGER =
          new Interface.Manager<
              BackgroundFetchRegistrationService, BackgroundFetchRegistrationService.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.BackgroundFetchRegistrationService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public BackgroundFetchRegistrationService.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, BackgroundFetchRegistrationService impl) {
              return new Stub(core, impl);
            }

            @Override
            public BackgroundFetchRegistrationService[] buildArray(int size) {
              return new BackgroundFetchRegistrationService[size];
            }
          };
  private static final int MATCH_REQUESTS_ORDINAL = 2;
  private static final int UPDATE_UI_ORDINAL = 0;

  BackgroundFetchRegistrationService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements BackgroundFetchRegistrationService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void updateUi(String title, BitmapN32 icon, UpdateUi_Response callback) {
      BackgroundFetchRegistrationServiceUpdateUiParams _message =
          new BackgroundFetchRegistrationServiceUpdateUiParams();
      _message.title = title;
      _message.icon = icon;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new BackgroundFetchRegistrationServiceUpdateUiResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void abort(Abort_Response callback) {
      BackgroundFetchRegistrationServiceAbortParams _message =
          new BackgroundFetchRegistrationServiceAbortParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new BackgroundFetchRegistrationServiceAbortResponseParamsForwardToCallback(callback));
    }

    @Override
    public void matchRequests(
        FetchApiRequest requestToMatch,
        CacheQueryOptions cacheQueryOptions,
        boolean matchAll,
        MatchRequests_Response callback) {
      BackgroundFetchRegistrationServiceMatchRequestsParams _message =
          new BackgroundFetchRegistrationServiceMatchRequestsParams();
      _message.requestToMatch = requestToMatch;
      _message.cacheQueryOptions = cacheQueryOptions;
      _message.matchAll = matchAll;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new BackgroundFetchRegistrationServiceMatchRequestsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void addRegistrationObserver(BackgroundFetchRegistrationObserver observer) {
      BackgroundFetchRegistrationServiceAddRegistrationObserverParams _message =
          new BackgroundFetchRegistrationServiceAddRegistrationObserverParams();
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<BackgroundFetchRegistrationService> {
    Stub(Core core, BackgroundFetchRegistrationService impl) {
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
                BackgroundFetchRegistrationService_Internal.MANAGER, messageWithHeader);
          case 3:
            BackgroundFetchRegistrationServiceAddRegistrationObserverParams data =
                BackgroundFetchRegistrationServiceAddRegistrationObserverParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addRegistrationObserver(data.observer);
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
                getCore(),
                BackgroundFetchRegistrationService_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            BackgroundFetchRegistrationServiceUpdateUiParams data =
                BackgroundFetchRegistrationServiceUpdateUiParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .updateUi(
                    data.title,
                    data.icon,
                    new BackgroundFetchRegistrationServiceUpdateUiResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            BackgroundFetchRegistrationServiceAbortParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .abort(
                    new BackgroundFetchRegistrationServiceAbortResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            BackgroundFetchRegistrationServiceMatchRequestsParams data2 =
                BackgroundFetchRegistrationServiceMatchRequestsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .matchRequests(
                    data2.requestToMatch,
                    data2.cacheQueryOptions,
                    data2.matchAll,
                    new BackgroundFetchRegistrationServiceMatchRequestsResponseParamsProxyToResponder(
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

  static final class BackgroundFetchRegistrationServiceUpdateUiParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BitmapN32 icon;
    public String title;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationServiceUpdateUiParams(int version) {
      super(24, version);
    }

    public BackgroundFetchRegistrationServiceUpdateUiParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationServiceUpdateUiParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationServiceUpdateUiParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationServiceUpdateUiParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationServiceUpdateUiParams result =
            new BackgroundFetchRegistrationServiceUpdateUiParams(elementsOrVersion);
        result.title = decoder0.readString(8, true);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.icon = BitmapN32.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.title, 8, true);
      encoder0.encode((Struct) this.icon, 16, true);
    }
  }

  static final class BackgroundFetchRegistrationServiceUpdateUiResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationServiceUpdateUiResponseParams(int version) {
      super(16, version);
    }

    public BackgroundFetchRegistrationServiceUpdateUiResponseParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationServiceUpdateUiResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationServiceUpdateUiResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationServiceUpdateUiResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationServiceUpdateUiResponseParams result =
            new BackgroundFetchRegistrationServiceUpdateUiResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        BackgroundFetchError.validate(readInt);
        result.error = BackgroundFetchError.toKnownValue(result.error);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
    }
  }

  static class BackgroundFetchRegistrationServiceUpdateUiResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BackgroundFetchRegistrationService.UpdateUi_Response mCallback;

    BackgroundFetchRegistrationServiceUpdateUiResponseParamsForwardToCallback(
        BackgroundFetchRegistrationService.UpdateUi_Response callback) {
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
        BackgroundFetchRegistrationServiceUpdateUiResponseParams response =
            BackgroundFetchRegistrationServiceUpdateUiResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BackgroundFetchRegistrationServiceUpdateUiResponseParamsProxyToResponder
      implements BackgroundFetchRegistrationService.UpdateUi_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BackgroundFetchRegistrationServiceUpdateUiResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error) {
      BackgroundFetchRegistrationServiceUpdateUiResponseParams _response =
          new BackgroundFetchRegistrationServiceUpdateUiResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BackgroundFetchRegistrationServiceAbortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationServiceAbortParams(int version) {
      super(8, version);
    }

    public BackgroundFetchRegistrationServiceAbortParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationServiceAbortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationServiceAbortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationServiceAbortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationServiceAbortParams result =
            new BackgroundFetchRegistrationServiceAbortParams(elementsOrVersion);
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

  static final class BackgroundFetchRegistrationServiceAbortResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationServiceAbortResponseParams(int version) {
      super(16, version);
    }

    public BackgroundFetchRegistrationServiceAbortResponseParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationServiceAbortResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationServiceAbortResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationServiceAbortResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationServiceAbortResponseParams result =
            new BackgroundFetchRegistrationServiceAbortResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        BackgroundFetchError.validate(readInt);
        result.error = BackgroundFetchError.toKnownValue(result.error);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
    }
  }

  static class BackgroundFetchRegistrationServiceAbortResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BackgroundFetchRegistrationService.Abort_Response mCallback;

    BackgroundFetchRegistrationServiceAbortResponseParamsForwardToCallback(
        BackgroundFetchRegistrationService.Abort_Response callback) {
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
        BackgroundFetchRegistrationServiceAbortResponseParams response =
            BackgroundFetchRegistrationServiceAbortResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BackgroundFetchRegistrationServiceAbortResponseParamsProxyToResponder
      implements BackgroundFetchRegistrationService.Abort_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BackgroundFetchRegistrationServiceAbortResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error) {
      BackgroundFetchRegistrationServiceAbortResponseParams _response =
          new BackgroundFetchRegistrationServiceAbortResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BackgroundFetchRegistrationServiceMatchRequestsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public CacheQueryOptions cacheQueryOptions;
    public boolean matchAll;
    public FetchApiRequest requestToMatch;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationServiceMatchRequestsParams(int version) {
      super(32, version);
    }

    public BackgroundFetchRegistrationServiceMatchRequestsParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationServiceMatchRequestsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationServiceMatchRequestsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationServiceMatchRequestsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationServiceMatchRequestsParams result =
            new BackgroundFetchRegistrationServiceMatchRequestsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.requestToMatch = FetchApiRequest.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.cacheQueryOptions = CacheQueryOptions.decode(decoder12);
        result.matchAll = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestToMatch, 8, true);
      encoder0.encode((Struct) this.cacheQueryOptions, 16, true);
      encoder0.encode(this.matchAll, 24, 0);
    }
  }

  static final class BackgroundFetchRegistrationServiceMatchRequestsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BackgroundFetchSettledFetch[] fetches;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationServiceMatchRequestsResponseParams(int version) {
      super(16, version);
    }

    public BackgroundFetchRegistrationServiceMatchRequestsResponseParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationServiceMatchRequestsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationServiceMatchRequestsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationServiceMatchRequestsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationServiceMatchRequestsResponseParams result =
            new BackgroundFetchRegistrationServiceMatchRequestsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.fetches = new BackgroundFetchSettledFetch[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.fetches[i1] = BackgroundFetchSettledFetch.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      BackgroundFetchSettledFetch[] backgroundFetchSettledFetchArr = this.fetches;
      if (backgroundFetchSettledFetchArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(backgroundFetchSettledFetchArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        BackgroundFetchSettledFetch[] backgroundFetchSettledFetchArr2 = this.fetches;
        if (i0 < backgroundFetchSettledFetchArr2.length) {
          encoder1.encode((Struct) backgroundFetchSettledFetchArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class BackgroundFetchRegistrationServiceMatchRequestsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BackgroundFetchRegistrationService.MatchRequests_Response mCallback;

    BackgroundFetchRegistrationServiceMatchRequestsResponseParamsForwardToCallback(
        BackgroundFetchRegistrationService.MatchRequests_Response callback) {
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
        BackgroundFetchRegistrationServiceMatchRequestsResponseParams response =
            BackgroundFetchRegistrationServiceMatchRequestsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.fetches);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BackgroundFetchRegistrationServiceMatchRequestsResponseParamsProxyToResponder
      implements BackgroundFetchRegistrationService.MatchRequests_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BackgroundFetchRegistrationServiceMatchRequestsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BackgroundFetchSettledFetch[] fetches) {
      BackgroundFetchRegistrationServiceMatchRequestsResponseParams _response =
          new BackgroundFetchRegistrationServiceMatchRequestsResponseParams();
      _response.fetches = fetches;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BackgroundFetchRegistrationServiceAddRegistrationObserverParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BackgroundFetchRegistrationObserver observer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchRegistrationServiceAddRegistrationObserverParams(int version) {
      super(16, version);
    }

    public BackgroundFetchRegistrationServiceAddRegistrationObserverParams() {
      this(0);
    }

    public static BackgroundFetchRegistrationServiceAddRegistrationObserverParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationServiceAddRegistrationObserverParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationServiceAddRegistrationObserverParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchRegistrationServiceAddRegistrationObserverParams result =
            new BackgroundFetchRegistrationServiceAddRegistrationObserverParams(elementsOrVersion);
        result.observer =
            (BackgroundFetchRegistrationObserver)
                decoder0.readServiceInterface(
                    8, false, BackgroundFetchRegistrationObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.observer, 8, false, BackgroundFetchRegistrationObserver.MANAGER);
    }
  }
}
