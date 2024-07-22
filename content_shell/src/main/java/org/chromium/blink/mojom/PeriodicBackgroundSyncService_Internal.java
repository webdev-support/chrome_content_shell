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

class PeriodicBackgroundSyncService_Internal {
  private static final int GET_REGISTRATIONS_ORDINAL = 2;
  public static final Interface.Manager<
          PeriodicBackgroundSyncService, PeriodicBackgroundSyncService.Proxy>
      MANAGER =
          new Interface.Manager<
              PeriodicBackgroundSyncService, PeriodicBackgroundSyncService.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.PeriodicBackgroundSyncService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PeriodicBackgroundSyncService.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PeriodicBackgroundSyncService impl) {
              return new Stub(core, impl);
            }

            @Override
            public PeriodicBackgroundSyncService[] buildArray(int size) {
              return new PeriodicBackgroundSyncService[size];
            }
          };
  private static final int REGISTER_ORDINAL = 0;
  private static final int UNREGISTER_ORDINAL = 1;

  PeriodicBackgroundSyncService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PeriodicBackgroundSyncService.Proxy {
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
      PeriodicBackgroundSyncServiceRegisterParams _message =
          new PeriodicBackgroundSyncServiceRegisterParams();
      _message.options = options;
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new PeriodicBackgroundSyncServiceRegisterResponseParamsForwardToCallback(callback));
    }

    @Override
    public void unregister(
        long serviceWorkerRegistrationId, String tag, Unregister_Response callback) {
      PeriodicBackgroundSyncServiceUnregisterParams _message =
          new PeriodicBackgroundSyncServiceUnregisterParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.tag = tag;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new PeriodicBackgroundSyncServiceUnregisterResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getRegistrations(
        long serviceWorkerRegistrationId, GetRegistrations_Response callback) {
      PeriodicBackgroundSyncServiceGetRegistrationsParams _message =
          new PeriodicBackgroundSyncServiceGetRegistrationsParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<PeriodicBackgroundSyncService> {
    Stub(Core core, PeriodicBackgroundSyncService impl) {
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
                PeriodicBackgroundSyncService_Internal.MANAGER, messageWithHeader);
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
                PeriodicBackgroundSyncService_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            PeriodicBackgroundSyncServiceRegisterParams data =
                PeriodicBackgroundSyncServiceRegisterParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .register(
                    data.options,
                    data.serviceWorkerRegistrationId,
                    new PeriodicBackgroundSyncServiceRegisterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            PeriodicBackgroundSyncServiceUnregisterParams data2 =
                PeriodicBackgroundSyncServiceUnregisterParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .unregister(
                    data2.serviceWorkerRegistrationId,
                    data2.tag,
                    new PeriodicBackgroundSyncServiceUnregisterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .getRegistrations(
                    PeriodicBackgroundSyncServiceGetRegistrationsParams.deserialize(
                            messageWithHeader.getPayload())
                        .serviceWorkerRegistrationId,
                    new PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder(
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

  static final class PeriodicBackgroundSyncServiceRegisterParams extends Struct {
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

    private PeriodicBackgroundSyncServiceRegisterParams(int version) {
      super(24, version);
    }

    public PeriodicBackgroundSyncServiceRegisterParams() {
      this(0);
    }

    public static PeriodicBackgroundSyncServiceRegisterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeriodicBackgroundSyncServiceRegisterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeriodicBackgroundSyncServiceRegisterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeriodicBackgroundSyncServiceRegisterParams result =
            new PeriodicBackgroundSyncServiceRegisterParams(elementsOrVersion);
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

  static final class PeriodicBackgroundSyncServiceRegisterResponseParams extends Struct {
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

    private PeriodicBackgroundSyncServiceRegisterResponseParams(int version) {
      super(24, version);
    }

    public PeriodicBackgroundSyncServiceRegisterResponseParams() {
      this(0);
    }

    public static PeriodicBackgroundSyncServiceRegisterResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeriodicBackgroundSyncServiceRegisterResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeriodicBackgroundSyncServiceRegisterResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeriodicBackgroundSyncServiceRegisterResponseParams result =
            new PeriodicBackgroundSyncServiceRegisterResponseParams(elementsOrVersion);
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

  static class PeriodicBackgroundSyncServiceRegisterResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PeriodicBackgroundSyncService.Register_Response mCallback;

    PeriodicBackgroundSyncServiceRegisterResponseParamsForwardToCallback(
        PeriodicBackgroundSyncService.Register_Response callback) {
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
        PeriodicBackgroundSyncServiceRegisterResponseParams response =
            PeriodicBackgroundSyncServiceRegisterResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.err, response.options);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PeriodicBackgroundSyncServiceRegisterResponseParamsProxyToResponder
      implements PeriodicBackgroundSyncService.Register_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PeriodicBackgroundSyncServiceRegisterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int err, SyncRegistrationOptions options) {
      PeriodicBackgroundSyncServiceRegisterResponseParams _response =
          new PeriodicBackgroundSyncServiceRegisterResponseParams();
      _response.err = err;
      _response.options = options;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PeriodicBackgroundSyncServiceUnregisterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long serviceWorkerRegistrationId;
    public String tag;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeriodicBackgroundSyncServiceUnregisterParams(int version) {
      super(24, version);
    }

    public PeriodicBackgroundSyncServiceUnregisterParams() {
      this(0);
    }

    public static PeriodicBackgroundSyncServiceUnregisterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeriodicBackgroundSyncServiceUnregisterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeriodicBackgroundSyncServiceUnregisterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeriodicBackgroundSyncServiceUnregisterParams result =
            new PeriodicBackgroundSyncServiceUnregisterParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        result.tag = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      encoder0.encode(this.tag, 16, false);
    }
  }

  static final class PeriodicBackgroundSyncServiceUnregisterResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int err;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeriodicBackgroundSyncServiceUnregisterResponseParams(int version) {
      super(16, version);
    }

    public PeriodicBackgroundSyncServiceUnregisterResponseParams() {
      this(0);
    }

    public static PeriodicBackgroundSyncServiceUnregisterResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PeriodicBackgroundSyncServiceUnregisterResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeriodicBackgroundSyncServiceUnregisterResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeriodicBackgroundSyncServiceUnregisterResponseParams result =
            new PeriodicBackgroundSyncServiceUnregisterResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.err = readInt;
        BackgroundSyncError.validate(readInt);
        result.err = BackgroundSyncError.toKnownValue(result.err);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.err, 8);
    }
  }

  static class PeriodicBackgroundSyncServiceUnregisterResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PeriodicBackgroundSyncService.Unregister_Response mCallback;

    PeriodicBackgroundSyncServiceUnregisterResponseParamsForwardToCallback(
        PeriodicBackgroundSyncService.Unregister_Response callback) {
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
        PeriodicBackgroundSyncServiceUnregisterResponseParams response =
            PeriodicBackgroundSyncServiceUnregisterResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.err);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PeriodicBackgroundSyncServiceUnregisterResponseParamsProxyToResponder
      implements PeriodicBackgroundSyncService.Unregister_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PeriodicBackgroundSyncServiceUnregisterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int err) {
      PeriodicBackgroundSyncServiceUnregisterResponseParams _response =
          new PeriodicBackgroundSyncServiceUnregisterResponseParams();
      _response.err = err;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PeriodicBackgroundSyncServiceGetRegistrationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeriodicBackgroundSyncServiceGetRegistrationsParams(int version) {
      super(16, version);
    }

    public PeriodicBackgroundSyncServiceGetRegistrationsParams() {
      this(0);
    }

    public static PeriodicBackgroundSyncServiceGetRegistrationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeriodicBackgroundSyncServiceGetRegistrationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeriodicBackgroundSyncServiceGetRegistrationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeriodicBackgroundSyncServiceGetRegistrationsParams result =
            new PeriodicBackgroundSyncServiceGetRegistrationsParams(elementsOrVersion);
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

  static final class PeriodicBackgroundSyncServiceGetRegistrationsResponseParams extends Struct {
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

    private PeriodicBackgroundSyncServiceGetRegistrationsResponseParams(int version) {
      super(24, version);
    }

    public PeriodicBackgroundSyncServiceGetRegistrationsResponseParams() {
      this(0);
    }

    public static PeriodicBackgroundSyncServiceGetRegistrationsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PeriodicBackgroundSyncServiceGetRegistrationsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeriodicBackgroundSyncServiceGetRegistrationsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeriodicBackgroundSyncServiceGetRegistrationsResponseParams result =
            new PeriodicBackgroundSyncServiceGetRegistrationsResponseParams(elementsOrVersion);
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

  static class PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PeriodicBackgroundSyncService.GetRegistrations_Response mCallback;

    PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback(
        PeriodicBackgroundSyncService.GetRegistrations_Response callback) {
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
        PeriodicBackgroundSyncServiceGetRegistrationsResponseParams response =
            PeriodicBackgroundSyncServiceGetRegistrationsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.err, response.registrations);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder
      implements PeriodicBackgroundSyncService.GetRegistrations_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int err, SyncRegistrationOptions[] registrations) {
      PeriodicBackgroundSyncServiceGetRegistrationsResponseParams _response =
          new PeriodicBackgroundSyncServiceGetRegistrationsResponseParams();
      _response.err = err;
      _response.registrations = registrations;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
