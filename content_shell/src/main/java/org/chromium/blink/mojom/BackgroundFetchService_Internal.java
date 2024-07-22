package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
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

class BackgroundFetchService_Internal {
  private static final int FETCH_ORDINAL = 0;
  private static final int GET_DEVELOPER_IDS_ORDINAL = 2;
  private static final int GET_ICON_DISPLAY_SIZE_ORDINAL = 3;
  private static final int GET_REGISTRATION_ORDINAL = 1;
  public static final Interface.Manager<BackgroundFetchService, BackgroundFetchService.Proxy>
      MANAGER =
          new Interface.Manager<BackgroundFetchService, BackgroundFetchService.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.BackgroundFetchService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public BackgroundFetchService.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, BackgroundFetchService impl) {
              return new Stub(core, impl);
            }

            @Override
            public BackgroundFetchService[] buildArray(int size) {
              return new BackgroundFetchService[size];
            }
          };

  BackgroundFetchService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements BackgroundFetchService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void fetch(
        long serviceWorkerRegistrationId,
        String developerId,
        FetchApiRequest[] requests,
        BackgroundFetchOptions options,
        BitmapN32 icon,
        BackgroundFetchUkmData ukmData,
        Fetch_Response callback) {
      BackgroundFetchServiceFetchParams _message = new BackgroundFetchServiceFetchParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.developerId = developerId;
      _message.requests = requests;
      _message.options = options;
      _message.icon = icon;
      _message.ukmData = ukmData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new BackgroundFetchServiceFetchResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getRegistration(
        long serviceWorkerRegistrationId, String developerId, GetRegistration_Response callback) {
      BackgroundFetchServiceGetRegistrationParams _message =
          new BackgroundFetchServiceGetRegistrationParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.developerId = developerId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new BackgroundFetchServiceGetRegistrationResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getDeveloperIds(
        long serviceWorkerRegistrationId, GetDeveloperIds_Response callback) {
      BackgroundFetchServiceGetDeveloperIdsParams _message =
          new BackgroundFetchServiceGetDeveloperIdsParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new BackgroundFetchServiceGetDeveloperIdsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getIconDisplaySize(GetIconDisplaySize_Response callback) {
      BackgroundFetchServiceGetIconDisplaySizeParams _message =
          new BackgroundFetchServiceGetIconDisplaySizeParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new BackgroundFetchServiceGetIconDisplaySizeResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<BackgroundFetchService> {
    Stub(Core core, BackgroundFetchService impl) {
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
                BackgroundFetchService_Internal.MANAGER, messageWithHeader);
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
                getCore(), BackgroundFetchService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            BackgroundFetchServiceFetchParams data =
                BackgroundFetchServiceFetchParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .fetch(
                    data.serviceWorkerRegistrationId,
                    data.developerId,
                    data.requests,
                    data.options,
                    data.icon,
                    data.ukmData,
                    new BackgroundFetchServiceFetchResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            BackgroundFetchServiceGetRegistrationParams data2 =
                BackgroundFetchServiceGetRegistrationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getRegistration(
                    data2.serviceWorkerRegistrationId,
                    data2.developerId,
                    new BackgroundFetchServiceGetRegistrationResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .getDeveloperIds(
                    BackgroundFetchServiceGetDeveloperIdsParams.deserialize(
                            messageWithHeader.getPayload())
                        .serviceWorkerRegistrationId,
                    new BackgroundFetchServiceGetDeveloperIdsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            BackgroundFetchServiceGetIconDisplaySizeParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getIconDisplaySize(
                    new BackgroundFetchServiceGetIconDisplaySizeResponseParamsProxyToResponder(
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

  static final class BackgroundFetchServiceFetchParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public String developerId;
    public BitmapN32 icon;
    public BackgroundFetchOptions options;
    public FetchApiRequest[] requests;
    public long serviceWorkerRegistrationId;
    public BackgroundFetchUkmData ukmData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchServiceFetchParams(int version) {
      super(56, version);
    }

    public BackgroundFetchServiceFetchParams() {
      this(0);
    }

    public static BackgroundFetchServiceFetchParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchServiceFetchParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchServiceFetchParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchServiceFetchParams result =
            new BackgroundFetchServiceFetchParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        result.developerId = decoder0.readString(16, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.requests = new FetchApiRequest[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.requests[i1] = FetchApiRequest.decode(decoder2);
        }
        result.options = BackgroundFetchOptions.decode(decoder0.readPointer(32, false));
        result.icon = BitmapN32.decode(decoder0.readPointer(40, true));
        result.ukmData = BackgroundFetchUkmData.decode(decoder0.readPointer(48, false));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      encoder0.encode(this.developerId, 16, false);
      FetchApiRequest[] fetchApiRequestArr = this.requests;
      if (fetchApiRequestArr == null) {
        encoder0.encodeNullPointer(24, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(fetchApiRequestArr.length, 24, -1);
        int i0 = 0;
        while (true) {
          FetchApiRequest[] fetchApiRequestArr2 = this.requests;
          if (i0 >= fetchApiRequestArr2.length) {
            break;
          }
          encoder1.encode((Struct) fetchApiRequestArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.options, 32, false);
      encoder0.encode((Struct) this.icon, 40, true);
      encoder0.encode((Struct) this.ukmData, 48, false);
    }
  }

  static final class BackgroundFetchServiceFetchResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public BackgroundFetchRegistration registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchServiceFetchResponseParams(int version) {
      super(24, version);
    }

    public BackgroundFetchServiceFetchResponseParams() {
      this(0);
    }

    public static BackgroundFetchServiceFetchResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchServiceFetchResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchServiceFetchResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchServiceFetchResponseParams result =
            new BackgroundFetchServiceFetchResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        BackgroundFetchError.validate(readInt);
        result.error = BackgroundFetchError.toKnownValue(result.error);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.registration = BackgroundFetchRegistration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode((Struct) this.registration, 16, true);
    }
  }

  static class BackgroundFetchServiceFetchResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BackgroundFetchService.Fetch_Response mCallback;

    BackgroundFetchServiceFetchResponseParamsForwardToCallback(
        BackgroundFetchService.Fetch_Response callback) {
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
        BackgroundFetchServiceFetchResponseParams response =
            BackgroundFetchServiceFetchResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.registration);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BackgroundFetchServiceFetchResponseParamsProxyToResponder
      implements BackgroundFetchService.Fetch_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BackgroundFetchServiceFetchResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, BackgroundFetchRegistration registration) {
      BackgroundFetchServiceFetchResponseParams _response =
          new BackgroundFetchServiceFetchResponseParams();
      _response.error = error;
      _response.registration = registration;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BackgroundFetchServiceGetRegistrationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String developerId;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchServiceGetRegistrationParams(int version) {
      super(24, version);
    }

    public BackgroundFetchServiceGetRegistrationParams() {
      this(0);
    }

    public static BackgroundFetchServiceGetRegistrationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchServiceGetRegistrationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchServiceGetRegistrationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchServiceGetRegistrationParams result =
            new BackgroundFetchServiceGetRegistrationParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        result.developerId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      encoder0.encode(this.developerId, 16, false);
    }
  }

  static final class BackgroundFetchServiceGetRegistrationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public BackgroundFetchRegistration registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchServiceGetRegistrationResponseParams(int version) {
      super(24, version);
    }

    public BackgroundFetchServiceGetRegistrationResponseParams() {
      this(0);
    }

    public static BackgroundFetchServiceGetRegistrationResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchServiceGetRegistrationResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchServiceGetRegistrationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchServiceGetRegistrationResponseParams result =
            new BackgroundFetchServiceGetRegistrationResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        BackgroundFetchError.validate(readInt);
        result.error = BackgroundFetchError.toKnownValue(result.error);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.registration = BackgroundFetchRegistration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode((Struct) this.registration, 16, true);
    }
  }

  static class BackgroundFetchServiceGetRegistrationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BackgroundFetchService.GetRegistration_Response mCallback;

    BackgroundFetchServiceGetRegistrationResponseParamsForwardToCallback(
        BackgroundFetchService.GetRegistration_Response callback) {
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
        BackgroundFetchServiceGetRegistrationResponseParams response =
            BackgroundFetchServiceGetRegistrationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.registration);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BackgroundFetchServiceGetRegistrationResponseParamsProxyToResponder
      implements BackgroundFetchService.GetRegistration_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BackgroundFetchServiceGetRegistrationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, BackgroundFetchRegistration registration) {
      BackgroundFetchServiceGetRegistrationResponseParams _response =
          new BackgroundFetchServiceGetRegistrationResponseParams();
      _response.error = error;
      _response.registration = registration;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BackgroundFetchServiceGetDeveloperIdsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchServiceGetDeveloperIdsParams(int version) {
      super(16, version);
    }

    public BackgroundFetchServiceGetDeveloperIdsParams() {
      this(0);
    }

    public static BackgroundFetchServiceGetDeveloperIdsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchServiceGetDeveloperIdsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchServiceGetDeveloperIdsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchServiceGetDeveloperIdsParams result =
            new BackgroundFetchServiceGetDeveloperIdsParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
    }
  }

  static final class BackgroundFetchServiceGetDeveloperIdsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] developerIds;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchServiceGetDeveloperIdsResponseParams(int version) {
      super(24, version);
    }

    public BackgroundFetchServiceGetDeveloperIdsResponseParams() {
      this(0);
    }

    public static BackgroundFetchServiceGetDeveloperIdsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchServiceGetDeveloperIdsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchServiceGetDeveloperIdsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchServiceGetDeveloperIdsResponseParams result =
            new BackgroundFetchServiceGetDeveloperIdsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        BackgroundFetchError.validate(readInt);
        result.error = BackgroundFetchError.toKnownValue(result.error);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.developerIds = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.developerIds[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      String[] strArr = this.developerIds;
      if (strArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.developerIds;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class BackgroundFetchServiceGetDeveloperIdsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BackgroundFetchService.GetDeveloperIds_Response mCallback;

    BackgroundFetchServiceGetDeveloperIdsResponseParamsForwardToCallback(
        BackgroundFetchService.GetDeveloperIds_Response callback) {
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
        BackgroundFetchServiceGetDeveloperIdsResponseParams response =
            BackgroundFetchServiceGetDeveloperIdsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.developerIds);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BackgroundFetchServiceGetDeveloperIdsResponseParamsProxyToResponder
      implements BackgroundFetchService.GetDeveloperIds_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BackgroundFetchServiceGetDeveloperIdsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String[] developerIds) {
      BackgroundFetchServiceGetDeveloperIdsResponseParams _response =
          new BackgroundFetchServiceGetDeveloperIdsResponseParams();
      _response.error = error;
      _response.developerIds = developerIds;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class BackgroundFetchServiceGetIconDisplaySizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchServiceGetIconDisplaySizeParams(int version) {
      super(8, version);
    }

    public BackgroundFetchServiceGetIconDisplaySizeParams() {
      this(0);
    }

    public static BackgroundFetchServiceGetIconDisplaySizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchServiceGetIconDisplaySizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchServiceGetIconDisplaySizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchServiceGetIconDisplaySizeParams result =
            new BackgroundFetchServiceGetIconDisplaySizeParams(elementsOrVersion);
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

  static final class BackgroundFetchServiceGetIconDisplaySizeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Size iconSizePixels;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackgroundFetchServiceGetIconDisplaySizeResponseParams(int version) {
      super(16, version);
    }

    public BackgroundFetchServiceGetIconDisplaySizeResponseParams() {
      this(0);
    }

    public static BackgroundFetchServiceGetIconDisplaySizeResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackgroundFetchServiceGetIconDisplaySizeResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchServiceGetIconDisplaySizeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackgroundFetchServiceGetIconDisplaySizeResponseParams result =
            new BackgroundFetchServiceGetIconDisplaySizeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.iconSizePixels = Size.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.iconSizePixels, 8, false);
    }
  }

  static class BackgroundFetchServiceGetIconDisplaySizeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BackgroundFetchService.GetIconDisplaySize_Response mCallback;

    BackgroundFetchServiceGetIconDisplaySizeResponseParamsForwardToCallback(
        BackgroundFetchService.GetIconDisplaySize_Response callback) {
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
        BackgroundFetchServiceGetIconDisplaySizeResponseParams response =
            BackgroundFetchServiceGetIconDisplaySizeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.iconSizePixels);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BackgroundFetchServiceGetIconDisplaySizeResponseParamsProxyToResponder
      implements BackgroundFetchService.GetIconDisplaySize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BackgroundFetchServiceGetIconDisplaySizeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Size iconSizePixels) {
      BackgroundFetchServiceGetIconDisplaySizeResponseParams _response =
          new BackgroundFetchServiceGetIconDisplaySizeResponseParams();
      _response.iconSizePixels = iconSizePixels;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
