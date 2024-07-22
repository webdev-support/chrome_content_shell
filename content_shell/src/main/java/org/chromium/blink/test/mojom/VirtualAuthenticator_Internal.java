package org.chromium.blink.test.mojom;

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

class VirtualAuthenticator_Internal {
  private static final int ADD_REGISTRATION_ORDINAL = 1;
  private static final int CLEAR_REGISTRATIONS_ORDINAL = 4;
  private static final int GET_LARGE_BLOB_ORDINAL = 5;
  private static final int GET_REGISTRATIONS_ORDINAL = 2;
  private static final int GET_UNIQUE_ID_ORDINAL = 0;
  public static final Interface.Manager<VirtualAuthenticator, VirtualAuthenticator.Proxy> MANAGER =
      new Interface.Manager<VirtualAuthenticator, VirtualAuthenticator.Proxy>() {
        @Override
        public String getName() {
          return "blink.test.mojom.VirtualAuthenticator";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public VirtualAuthenticator.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, VirtualAuthenticator impl) {
          return new Stub(core, impl);
        }

        @Override
        public VirtualAuthenticator[] buildArray(int size) {
          return new VirtualAuthenticator[size];
        }
      };
  private static final int REMOVE_REGISTRATION_ORDINAL = 3;
  private static final int SET_LARGE_BLOB_ORDINAL = 6;
  private static final int SET_USER_VERIFIED_ORDINAL = 7;

  VirtualAuthenticator_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VirtualAuthenticator.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getUniqueId(GetUniqueId_Response callback) {
      VirtualAuthenticatorGetUniqueIdParams _message = new VirtualAuthenticatorGetUniqueIdParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new VirtualAuthenticatorGetUniqueIdResponseParamsForwardToCallback(callback));
    }

    @Override
    public void addRegistration(RegisteredKey key, AddRegistration_Response callback) {
      VirtualAuthenticatorAddRegistrationParams _message =
          new VirtualAuthenticatorAddRegistrationParams();
      _message.key = key;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new VirtualAuthenticatorAddRegistrationResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getRegistrations(GetRegistrations_Response callback) {
      VirtualAuthenticatorGetRegistrationsParams _message =
          new VirtualAuthenticatorGetRegistrationsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new VirtualAuthenticatorGetRegistrationsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void removeRegistration(byte[] keyHandle, RemoveRegistration_Response callback) {
      VirtualAuthenticatorRemoveRegistrationParams _message =
          new VirtualAuthenticatorRemoveRegistrationParams();
      _message.keyHandle = keyHandle;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new VirtualAuthenticatorRemoveRegistrationResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearRegistrations(ClearRegistrations_Response callback) {
      VirtualAuthenticatorClearRegistrationsParams _message =
          new VirtualAuthenticatorClearRegistrationsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new VirtualAuthenticatorClearRegistrationsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getLargeBlob(byte[] keyHandle, GetLargeBlob_Response callback) {
      VirtualAuthenticatorGetLargeBlobParams _message =
          new VirtualAuthenticatorGetLargeBlobParams();
      _message.keyHandle = keyHandle;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new VirtualAuthenticatorGetLargeBlobResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setLargeBlob(byte[] keyHandle, byte[] blob, SetLargeBlob_Response callback) {
      VirtualAuthenticatorSetLargeBlobParams _message =
          new VirtualAuthenticatorSetLargeBlobParams();
      _message.keyHandle = keyHandle;
      _message.blob = blob;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new VirtualAuthenticatorSetLargeBlobResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setUserVerified(boolean verified, SetUserVerified_Response callback) {
      VirtualAuthenticatorSetUserVerifiedParams _message =
          new VirtualAuthenticatorSetUserVerifiedParams();
      _message.verified = verified;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new VirtualAuthenticatorSetUserVerifiedResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<VirtualAuthenticator> {
    Stub(Core core, VirtualAuthenticator impl) {
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
                VirtualAuthenticator_Internal.MANAGER, messageWithHeader);
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
                getCore(), VirtualAuthenticator_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            VirtualAuthenticatorGetUniqueIdParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getUniqueId(
                    new VirtualAuthenticatorGetUniqueIdResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            VirtualAuthenticatorAddRegistrationParams data =
                VirtualAuthenticatorAddRegistrationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .addRegistration(
                    data.key,
                    new VirtualAuthenticatorAddRegistrationResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            VirtualAuthenticatorGetRegistrationsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getRegistrations(
                    new VirtualAuthenticatorGetRegistrationsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            VirtualAuthenticatorRemoveRegistrationParams data2 =
                VirtualAuthenticatorRemoveRegistrationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .removeRegistration(
                    data2.keyHandle,
                    new VirtualAuthenticatorRemoveRegistrationResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            VirtualAuthenticatorClearRegistrationsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .clearRegistrations(
                    new VirtualAuthenticatorClearRegistrationsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            VirtualAuthenticatorGetLargeBlobParams data3 =
                VirtualAuthenticatorGetLargeBlobParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getLargeBlob(
                    data3.keyHandle,
                    new VirtualAuthenticatorGetLargeBlobResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            VirtualAuthenticatorSetLargeBlobParams data4 =
                VirtualAuthenticatorSetLargeBlobParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setLargeBlob(
                    data4.keyHandle,
                    data4.blob,
                    new VirtualAuthenticatorSetLargeBlobResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            VirtualAuthenticatorSetUserVerifiedParams data5 =
                VirtualAuthenticatorSetUserVerifiedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setUserVerified(
                    data5.verified,
                    new VirtualAuthenticatorSetUserVerifiedResponseParamsProxyToResponder(
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

  static final class VirtualAuthenticatorGetUniqueIdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorGetUniqueIdParams(int version) {
      super(8, version);
    }

    public VirtualAuthenticatorGetUniqueIdParams() {
      this(0);
    }

    public static VirtualAuthenticatorGetUniqueIdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorGetUniqueIdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorGetUniqueIdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorGetUniqueIdParams result =
            new VirtualAuthenticatorGetUniqueIdParams(elementsOrVersion);
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

  static final class VirtualAuthenticatorGetUniqueIdResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorGetUniqueIdResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorGetUniqueIdResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorGetUniqueIdResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorGetUniqueIdResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorGetUniqueIdResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorGetUniqueIdResponseParams result =
            new VirtualAuthenticatorGetUniqueIdResponseParams(elementsOrVersion);
        result.id = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8, false);
    }
  }

  static class VirtualAuthenticatorGetUniqueIdResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticator.GetUniqueId_Response mCallback;

    VirtualAuthenticatorGetUniqueIdResponseParamsForwardToCallback(
        VirtualAuthenticator.GetUniqueId_Response callback) {
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
        VirtualAuthenticatorGetUniqueIdResponseParams response =
            VirtualAuthenticatorGetUniqueIdResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.id);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorGetUniqueIdResponseParamsProxyToResponder
      implements VirtualAuthenticator.GetUniqueId_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorGetUniqueIdResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String id) {
      VirtualAuthenticatorGetUniqueIdResponseParams _response =
          new VirtualAuthenticatorGetUniqueIdResponseParams();
      _response.id = id;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorAddRegistrationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public RegisteredKey key;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorAddRegistrationParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorAddRegistrationParams() {
      this(0);
    }

    public static VirtualAuthenticatorAddRegistrationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorAddRegistrationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorAddRegistrationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorAddRegistrationParams result =
            new VirtualAuthenticatorAddRegistrationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.key = RegisteredKey.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.key, 8, false);
    }
  }

  static final class VirtualAuthenticatorAddRegistrationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean added;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorAddRegistrationResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorAddRegistrationResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorAddRegistrationResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorAddRegistrationResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorAddRegistrationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorAddRegistrationResponseParams result =
            new VirtualAuthenticatorAddRegistrationResponseParams(elementsOrVersion);
        result.added = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.added, 8, 0);
    }
  }

  static class VirtualAuthenticatorAddRegistrationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticator.AddRegistration_Response mCallback;

    VirtualAuthenticatorAddRegistrationResponseParamsForwardToCallback(
        VirtualAuthenticator.AddRegistration_Response callback) {
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
        VirtualAuthenticatorAddRegistrationResponseParams response =
            VirtualAuthenticatorAddRegistrationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.added);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorAddRegistrationResponseParamsProxyToResponder
      implements VirtualAuthenticator.AddRegistration_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorAddRegistrationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean added) {
      VirtualAuthenticatorAddRegistrationResponseParams _response =
          new VirtualAuthenticatorAddRegistrationResponseParams();
      _response.added = added;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorGetRegistrationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorGetRegistrationsParams(int version) {
      super(8, version);
    }

    public VirtualAuthenticatorGetRegistrationsParams() {
      this(0);
    }

    public static VirtualAuthenticatorGetRegistrationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorGetRegistrationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorGetRegistrationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorGetRegistrationsParams result =
            new VirtualAuthenticatorGetRegistrationsParams(elementsOrVersion);
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

  static final class VirtualAuthenticatorGetRegistrationsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public RegisteredKey[] keys;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorGetRegistrationsResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorGetRegistrationsResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorGetRegistrationsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorGetRegistrationsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorGetRegistrationsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorGetRegistrationsResponseParams result =
            new VirtualAuthenticatorGetRegistrationsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.keys = new RegisteredKey[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.keys[i1] = RegisteredKey.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      RegisteredKey[] registeredKeyArr = this.keys;
      if (registeredKeyArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(registeredKeyArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        RegisteredKey[] registeredKeyArr2 = this.keys;
        if (i0 < registeredKeyArr2.length) {
          encoder1.encode((Struct) registeredKeyArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class VirtualAuthenticatorGetRegistrationsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticator.GetRegistrations_Response mCallback;

    VirtualAuthenticatorGetRegistrationsResponseParamsForwardToCallback(
        VirtualAuthenticator.GetRegistrations_Response callback) {
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
        VirtualAuthenticatorGetRegistrationsResponseParams response =
            VirtualAuthenticatorGetRegistrationsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.keys);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorGetRegistrationsResponseParamsProxyToResponder
      implements VirtualAuthenticator.GetRegistrations_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorGetRegistrationsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(RegisteredKey[] keys) {
      VirtualAuthenticatorGetRegistrationsResponseParams _response =
          new VirtualAuthenticatorGetRegistrationsResponseParams();
      _response.keys = keys;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorRemoveRegistrationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] keyHandle;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorRemoveRegistrationParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorRemoveRegistrationParams() {
      this(0);
    }

    public static VirtualAuthenticatorRemoveRegistrationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorRemoveRegistrationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorRemoveRegistrationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorRemoveRegistrationParams result =
            new VirtualAuthenticatorRemoveRegistrationParams(elementsOrVersion);
        result.keyHandle = decoder0.readBytes(8, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.keyHandle, 8, 0, -1);
    }
  }

  static final class VirtualAuthenticatorRemoveRegistrationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean removed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorRemoveRegistrationResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorRemoveRegistrationResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorRemoveRegistrationResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorRemoveRegistrationResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorRemoveRegistrationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorRemoveRegistrationResponseParams result =
            new VirtualAuthenticatorRemoveRegistrationResponseParams(elementsOrVersion);
        result.removed = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.removed, 8, 0);
    }
  }

  static class VirtualAuthenticatorRemoveRegistrationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticator.RemoveRegistration_Response mCallback;

    VirtualAuthenticatorRemoveRegistrationResponseParamsForwardToCallback(
        VirtualAuthenticator.RemoveRegistration_Response callback) {
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
        VirtualAuthenticatorRemoveRegistrationResponseParams response =
            VirtualAuthenticatorRemoveRegistrationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.removed);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorRemoveRegistrationResponseParamsProxyToResponder
      implements VirtualAuthenticator.RemoveRegistration_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorRemoveRegistrationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean removed) {
      VirtualAuthenticatorRemoveRegistrationResponseParams _response =
          new VirtualAuthenticatorRemoveRegistrationResponseParams();
      _response.removed = removed;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorClearRegistrationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorClearRegistrationsParams(int version) {
      super(8, version);
    }

    public VirtualAuthenticatorClearRegistrationsParams() {
      this(0);
    }

    public static VirtualAuthenticatorClearRegistrationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorClearRegistrationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorClearRegistrationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorClearRegistrationsParams result =
            new VirtualAuthenticatorClearRegistrationsParams(elementsOrVersion);
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

  static final class VirtualAuthenticatorClearRegistrationsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorClearRegistrationsResponseParams(int version) {
      super(8, version);
    }

    public VirtualAuthenticatorClearRegistrationsResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorClearRegistrationsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorClearRegistrationsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorClearRegistrationsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorClearRegistrationsResponseParams result =
            new VirtualAuthenticatorClearRegistrationsResponseParams(elementsOrVersion);
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

  static class VirtualAuthenticatorClearRegistrationsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticator.ClearRegistrations_Response mCallback;

    VirtualAuthenticatorClearRegistrationsResponseParamsForwardToCallback(
        VirtualAuthenticator.ClearRegistrations_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorClearRegistrationsResponseParamsProxyToResponder
      implements VirtualAuthenticator.ClearRegistrations_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorClearRegistrationsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      VirtualAuthenticatorClearRegistrationsResponseParams _response =
          new VirtualAuthenticatorClearRegistrationsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorGetLargeBlobParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] keyHandle;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorGetLargeBlobParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorGetLargeBlobParams() {
      this(0);
    }

    public static VirtualAuthenticatorGetLargeBlobParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorGetLargeBlobParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorGetLargeBlobParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorGetLargeBlobParams result =
            new VirtualAuthenticatorGetLargeBlobParams(elementsOrVersion);
        result.keyHandle = decoder0.readBytes(8, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.keyHandle, 8, 0, -1);
    }
  }

  static final class VirtualAuthenticatorGetLargeBlobResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] blob;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorGetLargeBlobResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorGetLargeBlobResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorGetLargeBlobResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorGetLargeBlobResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorGetLargeBlobResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorGetLargeBlobResponseParams result =
            new VirtualAuthenticatorGetLargeBlobResponseParams(elementsOrVersion);
        result.blob = decoder0.readBytes(8, 1, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.blob, 8, 1, -1);
    }
  }

  static class VirtualAuthenticatorGetLargeBlobResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticator.GetLargeBlob_Response mCallback;

    VirtualAuthenticatorGetLargeBlobResponseParamsForwardToCallback(
        VirtualAuthenticator.GetLargeBlob_Response callback) {
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
        VirtualAuthenticatorGetLargeBlobResponseParams response =
            VirtualAuthenticatorGetLargeBlobResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.blob);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorGetLargeBlobResponseParamsProxyToResponder
      implements VirtualAuthenticator.GetLargeBlob_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorGetLargeBlobResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(byte[] blob) {
      VirtualAuthenticatorGetLargeBlobResponseParams _response =
          new VirtualAuthenticatorGetLargeBlobResponseParams();
      _response.blob = blob;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorSetLargeBlobParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] blob;
    public byte[] keyHandle;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorSetLargeBlobParams(int version) {
      super(24, version);
    }

    public VirtualAuthenticatorSetLargeBlobParams() {
      this(0);
    }

    public static VirtualAuthenticatorSetLargeBlobParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorSetLargeBlobParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorSetLargeBlobParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorSetLargeBlobParams result =
            new VirtualAuthenticatorSetLargeBlobParams(elementsOrVersion);
        result.keyHandle = decoder0.readBytes(8, 0, -1);
        result.blob = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.keyHandle, 8, 0, -1);
      encoder0.encode(this.blob, 16, 0, -1);
    }
  }

  static final class VirtualAuthenticatorSetLargeBlobResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean set;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorSetLargeBlobResponseParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorSetLargeBlobResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorSetLargeBlobResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorSetLargeBlobResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorSetLargeBlobResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorSetLargeBlobResponseParams result =
            new VirtualAuthenticatorSetLargeBlobResponseParams(elementsOrVersion);
        result.set = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.set, 8, 0);
    }
  }

  static class VirtualAuthenticatorSetLargeBlobResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticator.SetLargeBlob_Response mCallback;

    VirtualAuthenticatorSetLargeBlobResponseParamsForwardToCallback(
        VirtualAuthenticator.SetLargeBlob_Response callback) {
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
        VirtualAuthenticatorSetLargeBlobResponseParams response =
            VirtualAuthenticatorSetLargeBlobResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.set);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorSetLargeBlobResponseParamsProxyToResponder
      implements VirtualAuthenticator.SetLargeBlob_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorSetLargeBlobResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean set) {
      VirtualAuthenticatorSetLargeBlobResponseParams _response =
          new VirtualAuthenticatorSetLargeBlobResponseParams();
      _response.set = set;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VirtualAuthenticatorSetUserVerifiedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean verified;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorSetUserVerifiedParams(int version) {
      super(16, version);
    }

    public VirtualAuthenticatorSetUserVerifiedParams() {
      this(0);
    }

    public static VirtualAuthenticatorSetUserVerifiedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorSetUserVerifiedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorSetUserVerifiedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorSetUserVerifiedParams result =
            new VirtualAuthenticatorSetUserVerifiedParams(elementsOrVersion);
        result.verified = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.verified, 8, 0);
    }
  }

  static final class VirtualAuthenticatorSetUserVerifiedResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VirtualAuthenticatorSetUserVerifiedResponseParams(int version) {
      super(8, version);
    }

    public VirtualAuthenticatorSetUserVerifiedResponseParams() {
      this(0);
    }

    public static VirtualAuthenticatorSetUserVerifiedResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorSetUserVerifiedResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorSetUserVerifiedResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VirtualAuthenticatorSetUserVerifiedResponseParams result =
            new VirtualAuthenticatorSetUserVerifiedResponseParams(elementsOrVersion);
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

  static class VirtualAuthenticatorSetUserVerifiedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VirtualAuthenticator.SetUserVerified_Response mCallback;

    VirtualAuthenticatorSetUserVerifiedResponseParamsForwardToCallback(
        VirtualAuthenticator.SetUserVerified_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VirtualAuthenticatorSetUserVerifiedResponseParamsProxyToResponder
      implements VirtualAuthenticator.SetUserVerified_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VirtualAuthenticatorSetUserVerifiedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      VirtualAuthenticatorSetUserVerifiedResponseParams _response =
          new VirtualAuthenticatorSetUserVerifiedResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
