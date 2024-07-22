package org.chromium.media.mojom;

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

class CdmFile_Internal {
  public static final Interface.Manager<CdmFile, CdmFile.Proxy> MANAGER =
      new Interface.Manager<CdmFile, CdmFile.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.CdmFile";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CdmFile.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CdmFile impl) {
          return new Stub(core, impl);
        }

        @Override
        public CdmFile[] buildArray(int size) {
          return new CdmFile[size];
        }
      };
  private static final int READ_ORDINAL = 0;
  private static final int WRITE_ORDINAL = 1;

  CdmFile_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements CdmFile.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void read(Read_Response callback) {
      CdmFileReadParams _message = new CdmFileReadParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CdmFileReadResponseParamsForwardToCallback(callback));
    }

    @Override
    public void write(byte[] data, Write_Response callback) {
      CdmFileWriteParams _message = new CdmFileWriteParams();
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new CdmFileWriteResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<CdmFile> {
    Stub(Core core, CdmFile impl) {
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
                CdmFile_Internal.MANAGER, messageWithHeader);
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
                getCore(), CdmFile_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CdmFileReadParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .read(
                    new CdmFileReadResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            CdmFileWriteParams data =
                CdmFileWriteParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .write(
                    data.data,
                    new CdmFileWriteResponseParamsProxyToResponder(
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

  static final class CdmFileReadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmFileReadParams(int version) {
      super(8, version);
    }

    public CdmFileReadParams() {
      this(0);
    }

    public static CdmFileReadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmFileReadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmFileReadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmFileReadParams result = new CdmFileReadParams(elementsOrVersion);
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

  static final class CdmFileReadResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmFileReadResponseParams(int version) {
      super(24, version);
    }

    public CdmFileReadResponseParams() {
      this(0);
    }

    public static CdmFileReadResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmFileReadResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmFileReadResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmFileReadResponseParams result = new CdmFileReadResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        CdmFile.Status.validate(readInt);
        result.status = CdmFile.Status.toKnownValue(result.status);
        result.data = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.data, 16, 0, -1);
    }
  }

  static class CdmFileReadResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CdmFile.Read_Response mCallback;

    CdmFileReadResponseParamsForwardToCallback(CdmFile.Read_Response callback) {
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
        CdmFileReadResponseParams response =
            CdmFileReadResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.data);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CdmFileReadResponseParamsProxyToResponder implements CdmFile.Read_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CdmFileReadResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, byte[] data) {
      CdmFileReadResponseParams _response = new CdmFileReadResponseParams();
      _response.status = status;
      _response.data = data;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CdmFileWriteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmFileWriteParams(int version) {
      super(16, version);
    }

    public CdmFileWriteParams() {
      this(0);
    }

    public static CdmFileWriteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmFileWriteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmFileWriteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmFileWriteParams result = new CdmFileWriteParams(elementsOrVersion);
        result.data = decoder0.readBytes(8, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.data, 8, 0, -1);
    }
  }

  static final class CdmFileWriteResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmFileWriteResponseParams(int version) {
      super(16, version);
    }

    public CdmFileWriteResponseParams() {
      this(0);
    }

    public static CdmFileWriteResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmFileWriteResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmFileWriteResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmFileWriteResponseParams result = new CdmFileWriteResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        CdmFile.Status.validate(readInt);
        result.status = CdmFile.Status.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
    }
  }

  static class CdmFileWriteResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CdmFile.Write_Response mCallback;

    CdmFileWriteResponseParamsForwardToCallback(CdmFile.Write_Response callback) {
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
        CdmFileWriteResponseParams response =
            CdmFileWriteResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CdmFileWriteResponseParamsProxyToResponder implements CdmFile.Write_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CdmFileWriteResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      CdmFileWriteResponseParams _response = new CdmFileWriteResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
