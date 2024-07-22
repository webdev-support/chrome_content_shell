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
import org.chromium.url.mojom.Url;

class CredentialManager_Internal {
  private static final int GET_ORDINAL = 2;
  public static final Interface.Manager<CredentialManager, CredentialManager.Proxy> MANAGER =
      new Interface.Manager<CredentialManager, CredentialManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.CredentialManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CredentialManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CredentialManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public CredentialManager[] buildArray(int size) {
          return new CredentialManager[size];
        }
      };
  private static final int PREVENT_SILENT_ACCESS_ORDINAL = 1;
  private static final int STORE_ORDINAL = 0;

  CredentialManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CredentialManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void store(CredentialInfo credential, Store_Response callback) {
      CredentialManagerStoreParams _message = new CredentialManagerStoreParams();
      _message.credential = credential;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CredentialManagerStoreResponseParamsForwardToCallback(callback));
    }

    @Override
    public void preventSilentAccess(PreventSilentAccess_Response callback) {
      CredentialManagerPreventSilentAccessParams _message =
          new CredentialManagerPreventSilentAccessParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new CredentialManagerPreventSilentAccessResponseParamsForwardToCallback(callback));
    }

    @Override
    public void get(
        int mediation, boolean includePasswords, Url[] federations, Get_Response callback) {
      CredentialManagerGetParams _message = new CredentialManagerGetParams();
      _message.mediation = mediation;
      _message.includePasswords = includePasswords;
      _message.federations = federations;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new CredentialManagerGetResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<CredentialManager> {
    Stub(Core core, CredentialManager impl) {
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
                CredentialManager_Internal.MANAGER, messageWithHeader);
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
                getCore(), CredentialManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .store(
                    CredentialManagerStoreParams.deserialize(messageWithHeader.getPayload())
                        .credential,
                    new CredentialManagerStoreResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            CredentialManagerPreventSilentAccessParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .preventSilentAccess(
                    new CredentialManagerPreventSilentAccessResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            CredentialManagerGetParams data =
                CredentialManagerGetParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .get(
                    data.mediation,
                    data.includePasswords,
                    data.federations,
                    new CredentialManagerGetResponseParamsProxyToResponder(
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

  static final class CredentialManagerStoreParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CredentialInfo credential;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CredentialManagerStoreParams(int version) {
      super(16, version);
    }

    public CredentialManagerStoreParams() {
      this(0);
    }

    public static CredentialManagerStoreParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CredentialManagerStoreParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CredentialManagerStoreParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CredentialManagerStoreParams result = new CredentialManagerStoreParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.credential = CredentialInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.credential, 8, false);
    }
  }

  static final class CredentialManagerStoreResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CredentialManagerStoreResponseParams(int version) {
      super(8, version);
    }

    public CredentialManagerStoreResponseParams() {
      this(0);
    }

    public static CredentialManagerStoreResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CredentialManagerStoreResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CredentialManagerStoreResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CredentialManagerStoreResponseParams result =
            new CredentialManagerStoreResponseParams(elementsOrVersion);
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

  static class CredentialManagerStoreResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CredentialManager.Store_Response mCallback;

    CredentialManagerStoreResponseParamsForwardToCallback(
        CredentialManager.Store_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CredentialManagerStoreResponseParamsProxyToResponder
      implements CredentialManager.Store_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CredentialManagerStoreResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      CredentialManagerStoreResponseParams _response = new CredentialManagerStoreResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CredentialManagerPreventSilentAccessParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CredentialManagerPreventSilentAccessParams(int version) {
      super(8, version);
    }

    public CredentialManagerPreventSilentAccessParams() {
      this(0);
    }

    public static CredentialManagerPreventSilentAccessParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CredentialManagerPreventSilentAccessParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CredentialManagerPreventSilentAccessParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CredentialManagerPreventSilentAccessParams result =
            new CredentialManagerPreventSilentAccessParams(elementsOrVersion);
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

  static final class CredentialManagerPreventSilentAccessResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CredentialManagerPreventSilentAccessResponseParams(int version) {
      super(8, version);
    }

    public CredentialManagerPreventSilentAccessResponseParams() {
      this(0);
    }

    public static CredentialManagerPreventSilentAccessResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CredentialManagerPreventSilentAccessResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CredentialManagerPreventSilentAccessResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CredentialManagerPreventSilentAccessResponseParams result =
            new CredentialManagerPreventSilentAccessResponseParams(elementsOrVersion);
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

  static class CredentialManagerPreventSilentAccessResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CredentialManager.PreventSilentAccess_Response mCallback;

    CredentialManagerPreventSilentAccessResponseParamsForwardToCallback(
        CredentialManager.PreventSilentAccess_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CredentialManagerPreventSilentAccessResponseParamsProxyToResponder
      implements CredentialManager.PreventSilentAccess_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CredentialManagerPreventSilentAccessResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      CredentialManagerPreventSilentAccessResponseParams _response =
          new CredentialManagerPreventSilentAccessResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CredentialManagerGetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url[] federations;
    public boolean includePasswords;
    public int mediation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CredentialManagerGetParams(int version) {
      super(24, version);
    }

    public CredentialManagerGetParams() {
      this(0);
    }

    public static CredentialManagerGetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CredentialManagerGetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CredentialManagerGetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CredentialManagerGetParams result = new CredentialManagerGetParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.mediation = readInt;
        CredentialMediationRequirement.validate(readInt);
        result.mediation = CredentialMediationRequirement.toKnownValue(result.mediation);
        result.includePasswords = decoder0.readBoolean(12, 0);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.federations = new Url[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.federations[i1] = Url.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.mediation, 8);
      encoder0.encode(this.includePasswords, 12, 0);
      Url[] urlArr = this.federations;
      if (urlArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.federations;
        if (i0 < urlArr2.length) {
          encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class CredentialManagerGetResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public CredentialInfo credential;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CredentialManagerGetResponseParams(int version) {
      super(24, version);
    }

    public CredentialManagerGetResponseParams() {
      this(0);
    }

    public static CredentialManagerGetResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CredentialManagerGetResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CredentialManagerGetResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CredentialManagerGetResponseParams result =
            new CredentialManagerGetResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        CredentialManagerError.validate(readInt);
        result.error = CredentialManagerError.toKnownValue(result.error);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.credential = CredentialInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode((Struct) this.credential, 16, true);
    }
  }

  static class CredentialManagerGetResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CredentialManager.Get_Response mCallback;

    CredentialManagerGetResponseParamsForwardToCallback(CredentialManager.Get_Response callback) {
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
        CredentialManagerGetResponseParams response =
            CredentialManagerGetResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.credential);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CredentialManagerGetResponseParamsProxyToResponder
      implements CredentialManager.Get_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CredentialManagerGetResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, CredentialInfo credential) {
      CredentialManagerGetResponseParams _response = new CredentialManagerGetResponseParams();
      _response.error = error;
      _response.credential = credential;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
