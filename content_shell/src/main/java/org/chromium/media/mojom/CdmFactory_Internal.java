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

class CdmFactory_Internal {
  private static final int CREATE_CDM_ORDINAL = 0;
  public static final Interface.Manager<CdmFactory, CdmFactory.Proxy> MANAGER =
      new Interface.Manager<CdmFactory, CdmFactory.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.CdmFactory";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CdmFactory.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CdmFactory impl) {
          return new Stub(core, impl);
        }

        @Override
        public CdmFactory[] buildArray(int size) {
          return new CdmFactory[size];
        }
      };

  CdmFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements CdmFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createCdm(CdmConfig cdmConfig, CreateCdm_Response callback) {
      CdmFactoryCreateCdmParams _message = new CdmFactoryCreateCdmParams();
      _message.cdmConfig = cdmConfig;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CdmFactoryCreateCdmResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<CdmFactory> {
    Stub(Core core, CdmFactory impl) {
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
                CdmFactory_Internal.MANAGER, messageWithHeader);
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
                getCore(), CdmFactory_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CdmFactoryCreateCdmParams data =
                CdmFactoryCreateCdmParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createCdm(
                    data.cdmConfig,
                    new CdmFactoryCreateCdmResponseParamsProxyToResponder(
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

  static final class CdmFactoryCreateCdmParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmConfig cdmConfig;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmFactoryCreateCdmParams(int version) {
      super(16, version);
    }

    public CdmFactoryCreateCdmParams() {
      this(0);
    }

    public static CdmFactoryCreateCdmParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmFactoryCreateCdmParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmFactoryCreateCdmParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmFactoryCreateCdmParams result = new CdmFactoryCreateCdmParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cdmConfig = CdmConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cdmConfig, 8, false);
    }
  }

  static final class CdmFactoryCreateCdmResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ContentDecryptionModule cdm;
    public CdmContext cdmContext;
    public String errorMessage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmFactoryCreateCdmResponseParams(int version) {
      super(32, version);
    }

    public CdmFactoryCreateCdmResponseParams() {
      this(0);
    }

    public static CdmFactoryCreateCdmResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmFactoryCreateCdmResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmFactoryCreateCdmResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmFactoryCreateCdmResponseParams result =
            new CdmFactoryCreateCdmResponseParams(elementsOrVersion);
        result.cdm =
            (ContentDecryptionModule)
                decoder0.readServiceInterface(8, true, ContentDecryptionModule.MANAGER);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.cdmContext = CdmContext.decode(decoder1);
        result.errorMessage = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.cdm, 8, true, ContentDecryptionModule.MANAGER);
      encoder0.encode((Struct) this.cdmContext, 16, true);
      encoder0.encode(this.errorMessage, 24, false);
    }
  }

  static class CdmFactoryCreateCdmResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final CdmFactory.CreateCdm_Response mCallback;

    CdmFactoryCreateCdmResponseParamsForwardToCallback(CdmFactory.CreateCdm_Response callback) {
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
        CdmFactoryCreateCdmResponseParams response =
            CdmFactoryCreateCdmResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.cdm, response.cdmContext, response.errorMessage);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CdmFactoryCreateCdmResponseParamsProxyToResponder
      implements CdmFactory.CreateCdm_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CdmFactoryCreateCdmResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ContentDecryptionModule cdm, CdmContext cdmContext, String errorMessage) {
      CdmFactoryCreateCdmResponseParams _response = new CdmFactoryCreateCdmResponseParams();
      _response.cdm = cdm;
      _response.cdmContext = cdmContext;
      _response.errorMessage = errorMessage;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
