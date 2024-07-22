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

class OneShotBackgroundSyncService_Internal {
  private static final int DID_RESOLVE_REGISTRATION_ORDINAL = 1;
  private static final int GET_REGISTRATIONS_ORDINAL = 2;
  public static final Interface.Manager<
          OneShotBackgroundSyncService, OneShotBackgroundSyncService.Proxy>
      MANAGER =
          new Interface.Manager<
              OneShotBackgroundSyncService, OneShotBackgroundSyncService.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.OneShotBackgroundSyncService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public OneShotBackgroundSyncService.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, OneShotBackgroundSyncService impl) {
              return new Stub(core, impl);
            }

            @Override
            public OneShotBackgroundSyncService[] buildArray(int size) {
              return new OneShotBackgroundSyncService[size];
            }
          };
  private static final int REGISTER_ORDINAL = 0;

  OneShotBackgroundSyncService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements OneShotBackgroundSyncService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void register(
        SyncRegistrationOptions options,
        long serviceWorkerRegistrationId,
        Register_Response callback) {
      OneShotBackgroundSyncServiceRegisterParams _message =
          new OneShotBackgroundSyncServiceRegisterParams();
      _message.options = options;
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new OneShotBackgroundSyncServiceRegisterResponseParamsForwardToCallback(callback));
    }

    @Override
    public void didResolveRegistration(BackgroundSyncRegistrationInfo registrationInfo) {
      OneShotBackgroundSyncServiceDidResolveRegistrationParams _message =
          new OneShotBackgroundSyncServiceDidResolveRegistrationParams();
      _message.registrationInfo = registrationInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void getRegistrations(
        long serviceWorkerRegistrationId, GetRegistrations_Response callback) {
      OneShotBackgroundSyncServiceGetRegistrationsParams _message =
          new OneShotBackgroundSyncServiceGetRegistrationsParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new OneShotBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<OneShotBackgroundSyncService> {
    Stub(Core core, OneShotBackgroundSyncService impl) {
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
                OneShotBackgroundSyncService_Internal.MANAGER, messageWithHeader);
          case 1:
            OneShotBackgroundSyncServiceDidResolveRegistrationParams data =
                OneShotBackgroundSyncServiceDidResolveRegistrationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didResolveRegistration(data.registrationInfo);
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
                OneShotBackgroundSyncService_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            OneShotBackgroundSyncServiceRegisterParams data =
                OneShotBackgroundSyncServiceRegisterParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .register(
                    data.options,
                    data.serviceWorkerRegistrationId,
                    new OneShotBackgroundSyncServiceRegisterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            getImpl()
                .getRegistrations(
                    OneShotBackgroundSyncServiceGetRegistrationsParams.deserialize(
                            messageWithHeader.getPayload())
                        .serviceWorkerRegistrationId,
                    new OneShotBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class OneShotBackgroundSyncServiceRegisterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SyncRegistrationOptions options;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OneShotBackgroundSyncServiceRegisterParams(int version) {
      super(24, version);
    }

    public OneShotBackgroundSyncServiceRegisterParams() {
      this(0);
    }

    public static OneShotBackgroundSyncServiceRegisterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OneShotBackgroundSyncServiceRegisterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OneShotBackgroundSyncServiceRegisterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OneShotBackgroundSyncServiceRegisterParams result =
            new OneShotBackgroundSyncServiceRegisterParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.options = SyncRegistrationOptions.decode(decoder1);
        result.serviceWorkerRegistrationId = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.options, 8, false);
      encoder0.encode(this.serviceWorkerRegistrationId, 16);
    }
  }

  static final class OneShotBackgroundSyncServiceRegisterResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int err;
    public SyncRegistrationOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OneShotBackgroundSyncServiceRegisterResponseParams(int version) {
      super(24, version);
    }

    public OneShotBackgroundSyncServiceRegisterResponseParams() {
      this(0);
    }

    public static OneShotBackgroundSyncServiceRegisterResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OneShotBackgroundSyncServiceRegisterResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OneShotBackgroundSyncServiceRegisterResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OneShotBackgroundSyncServiceRegisterResponseParams result =
            new OneShotBackgroundSyncServiceRegisterResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.err = readInt;
        BackgroundSyncError.validate(readInt);
        result.err = BackgroundSyncError.toKnownValue(result.err);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.options = SyncRegistrationOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.err, 8);
      encoder0.encode((Struct) this.options, 16, true);
    }
  }

  static class OneShotBackgroundSyncServiceRegisterResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final OneShotBackgroundSyncService.Register_Response mCallback;

    OneShotBackgroundSyncServiceRegisterResponseParamsForwardToCallback(
        OneShotBackgroundSyncService.Register_Response callback) {
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
        OneShotBackgroundSyncServiceRegisterResponseParams response =
            OneShotBackgroundSyncServiceRegisterResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.err, response.options);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class OneShotBackgroundSyncServiceRegisterResponseParamsProxyToResponder
      implements OneShotBackgroundSyncService.Register_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    OneShotBackgroundSyncServiceRegisterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int err, SyncRegistrationOptions options) {
      OneShotBackgroundSyncServiceRegisterResponseParams _response =
          new OneShotBackgroundSyncServiceRegisterResponseParams();
      _response.err = err;
      _response.options = options;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class OneShotBackgroundSyncServiceDidResolveRegistrationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BackgroundSyncRegistrationInfo registrationInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OneShotBackgroundSyncServiceDidResolveRegistrationParams(int version) {
      super(16, version);
    }

    public OneShotBackgroundSyncServiceDidResolveRegistrationParams() {
      this(0);
    }

    public static OneShotBackgroundSyncServiceDidResolveRegistrationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static OneShotBackgroundSyncServiceDidResolveRegistrationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OneShotBackgroundSyncServiceDidResolveRegistrationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OneShotBackgroundSyncServiceDidResolveRegistrationParams result =
            new OneShotBackgroundSyncServiceDidResolveRegistrationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.registrationInfo = BackgroundSyncRegistrationInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.registrationInfo, 8, false);
    }
  }

  static final class OneShotBackgroundSyncServiceGetRegistrationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OneShotBackgroundSyncServiceGetRegistrationsParams(int version) {
      super(16, version);
    }

    public OneShotBackgroundSyncServiceGetRegistrationsParams() {
      this(0);
    }

    public static OneShotBackgroundSyncServiceGetRegistrationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static OneShotBackgroundSyncServiceGetRegistrationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OneShotBackgroundSyncServiceGetRegistrationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OneShotBackgroundSyncServiceGetRegistrationsParams result =
            new OneShotBackgroundSyncServiceGetRegistrationsParams(elementsOrVersion);
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

  static final class OneShotBackgroundSyncServiceGetRegistrationsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int err;
    public SyncRegistrationOptions[] registrations;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private OneShotBackgroundSyncServiceGetRegistrationsResponseParams(int version) {
      super(24, version);
    }

    public OneShotBackgroundSyncServiceGetRegistrationsResponseParams() {
      this(0);
    }

    public static OneShotBackgroundSyncServiceGetRegistrationsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static OneShotBackgroundSyncServiceGetRegistrationsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static OneShotBackgroundSyncServiceGetRegistrationsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        OneShotBackgroundSyncServiceGetRegistrationsResponseParams result =
            new OneShotBackgroundSyncServiceGetRegistrationsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.err = readInt;
        BackgroundSyncError.validate(readInt);
        result.err = BackgroundSyncError.toKnownValue(result.err);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.registrations = new SyncRegistrationOptions[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.registrations[i1] = SyncRegistrationOptions.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.err, 8);
      SyncRegistrationOptions[] syncRegistrationOptionsArr = this.registrations;
      if (syncRegistrationOptionsArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(syncRegistrationOptionsArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        SyncRegistrationOptions[] syncRegistrationOptionsArr2 = this.registrations;
        if (i0 < syncRegistrationOptionsArr2.length) {
          encoder1.encode((Struct) syncRegistrationOptionsArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class OneShotBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final OneShotBackgroundSyncService.GetRegistrations_Response mCallback;

    OneShotBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback(
        OneShotBackgroundSyncService.GetRegistrations_Response callback) {
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
        OneShotBackgroundSyncServiceGetRegistrationsResponseParams response =
            OneShotBackgroundSyncServiceGetRegistrationsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.err, response.registrations);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class OneShotBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder
      implements OneShotBackgroundSyncService.GetRegistrations_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    OneShotBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int err, SyncRegistrationOptions[] registrations) {
      OneShotBackgroundSyncServiceGetRegistrationsResponseParams _response =
          new OneShotBackgroundSyncServiceGetRegistrationsResponseParams();
      _response.err = err;
      _response.registrations = registrations;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
