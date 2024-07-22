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

class CdmStorage_Internal {
  public static final Interface.Manager<CdmStorage, CdmStorage.Proxy> MANAGER =
      new Interface.Manager<CdmStorage, CdmStorage.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.CdmStorage";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CdmStorage.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CdmStorage impl) {
          return new Stub(core, impl);
        }

        @Override
        public CdmStorage[] buildArray(int size) {
          return new CdmStorage[size];
        }
      };
  private static final int OPEN_ORDINAL = 0;

  CdmStorage_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements CdmStorage.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void open(String fileName, Open_Response callback) {
      CdmStorageOpenParams _message = new CdmStorageOpenParams();
      _message.fileName = fileName;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CdmStorageOpenResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<CdmStorage> {
    Stub(Core core, CdmStorage impl) {
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
                CdmStorage_Internal.MANAGER, messageWithHeader);
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
                getCore(), CdmStorage_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CdmStorageOpenParams data =
                CdmStorageOpenParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .open(
                    data.fileName,
                    new CdmStorageOpenResponseParamsProxyToResponder(
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

  static final class CdmStorageOpenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String fileName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmStorageOpenParams(int version) {
      super(16, version);
    }

    public CdmStorageOpenParams() {
      this(0);
    }

    public static CdmStorageOpenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmStorageOpenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmStorageOpenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmStorageOpenParams result = new CdmStorageOpenParams(elementsOrVersion);
        result.fileName = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.fileName, 8, false);
    }
  }

  static final class CdmStorageOpenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported cdmFile;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmStorageOpenResponseParams(int version) {
      super(24, version);
    }

    public CdmStorageOpenResponseParams() {
      this(0);
    }

    public static CdmStorageOpenResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmStorageOpenResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmStorageOpenResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmStorageOpenResponseParams result = new CdmStorageOpenResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        CdmStorage.Status.validate(readInt);
        result.status = CdmStorage.Status.toKnownValue(result.status);
        result.cdmFile = decoder0.readAssociatedServiceInterfaceNotSupported(12, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.cdmFile, 12, true);
    }
  }

  static class CdmStorageOpenResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CdmStorage.Open_Response mCallback;

    CdmStorageOpenResponseParamsForwardToCallback(CdmStorage.Open_Response callback) {
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
        CdmStorageOpenResponseParams response =
            CdmStorageOpenResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.cdmFile);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CdmStorageOpenResponseParamsProxyToResponder implements CdmStorage.Open_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CdmStorageOpenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, AssociatedInterfaceNotSupported cdmFile) {
      CdmStorageOpenResponseParams _response = new CdmStorageOpenResponseParams();
      _response.status = status;
      _response.cdmFile = cdmFile;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
