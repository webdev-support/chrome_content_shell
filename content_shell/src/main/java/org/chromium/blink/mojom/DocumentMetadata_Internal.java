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

class DocumentMetadata_Internal {
  private static final int GET_ENTITIES_ORDINAL = 0;
  public static final Interface.Manager<DocumentMetadata, DocumentMetadata.Proxy> MANAGER =
      new Interface.Manager<DocumentMetadata, DocumentMetadata.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.DocumentMetadata";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DocumentMetadata.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DocumentMetadata impl) {
          return new Stub(core, impl);
        }

        @Override
        public DocumentMetadata[] buildArray(int size) {
          return new DocumentMetadata[size];
        }
      };

  DocumentMetadata_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DocumentMetadata.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getEntities(GetEntities_Response callback) {
      DocumentMetadataGetEntitiesParams _message = new DocumentMetadataGetEntitiesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DocumentMetadataGetEntitiesResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<DocumentMetadata> {
    Stub(Core core, DocumentMetadata impl) {
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
                DocumentMetadata_Internal.MANAGER, messageWithHeader);
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
                getCore(), DocumentMetadata_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            DocumentMetadataGetEntitiesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getEntities(
                    new DocumentMetadataGetEntitiesResponseParamsProxyToResponder(
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

  static final class DocumentMetadataGetEntitiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DocumentMetadataGetEntitiesParams(int version) {
      super(8, version);
    }

    public DocumentMetadataGetEntitiesParams() {
      this(0);
    }

    public static DocumentMetadataGetEntitiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DocumentMetadataGetEntitiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DocumentMetadataGetEntitiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DocumentMetadataGetEntitiesParams result =
            new DocumentMetadataGetEntitiesParams(elementsOrVersion);
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

  static final class DocumentMetadataGetEntitiesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public WebPage page;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DocumentMetadataGetEntitiesResponseParams(int version) {
      super(16, version);
    }

    public DocumentMetadataGetEntitiesResponseParams() {
      this(0);
    }

    public static DocumentMetadataGetEntitiesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DocumentMetadataGetEntitiesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DocumentMetadataGetEntitiesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DocumentMetadataGetEntitiesResponseParams result =
            new DocumentMetadataGetEntitiesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.page = WebPage.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.page, 8, true);
    }
  }

  static class DocumentMetadataGetEntitiesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DocumentMetadata.GetEntities_Response mCallback;

    DocumentMetadataGetEntitiesResponseParamsForwardToCallback(
        DocumentMetadata.GetEntities_Response callback) {
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
        DocumentMetadataGetEntitiesResponseParams response =
            DocumentMetadataGetEntitiesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.page);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DocumentMetadataGetEntitiesResponseParamsProxyToResponder
      implements DocumentMetadata.GetEntities_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DocumentMetadataGetEntitiesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(WebPage page) {
      DocumentMetadataGetEntitiesResponseParams _response =
          new DocumentMetadataGetEntitiesResponseParams();
      _response.page = page;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
