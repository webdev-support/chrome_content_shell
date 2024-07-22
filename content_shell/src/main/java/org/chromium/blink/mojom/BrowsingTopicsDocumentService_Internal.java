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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class BrowsingTopicsDocumentService_Internal {
  private static final int GET_BROWSING_TOPICS_ORDINAL = 0;
  public static final Interface.Manager<
          BrowsingTopicsDocumentService, BrowsingTopicsDocumentService.Proxy>
      MANAGER =
          new Interface.Manager<
              BrowsingTopicsDocumentService, BrowsingTopicsDocumentService.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.BrowsingTopicsDocumentService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public BrowsingTopicsDocumentService.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, BrowsingTopicsDocumentService impl) {
              return new Stub(core, impl);
            }

            @Override
            public BrowsingTopicsDocumentService[] buildArray(int size) {
              return new BrowsingTopicsDocumentService[size];
            }
          };

  BrowsingTopicsDocumentService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements BrowsingTopicsDocumentService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getBrowsingTopics(boolean observe, GetBrowsingTopics_Response callback) {
      BrowsingTopicsDocumentServiceGetBrowsingTopicsParams _message =
          new BrowsingTopicsDocumentServiceGetBrowsingTopicsParams();
      _message.observe = observe;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<BrowsingTopicsDocumentService> {
    Stub(Core core, BrowsingTopicsDocumentService impl) {
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
                BrowsingTopicsDocumentService_Internal.MANAGER, messageWithHeader);
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
                BrowsingTopicsDocumentService_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            BrowsingTopicsDocumentServiceGetBrowsingTopicsParams data =
                BrowsingTopicsDocumentServiceGetBrowsingTopicsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getBrowsingTopics(
                    data.observe,
                    new BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParamsProxyToResponder(
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

  static final class BrowsingTopicsDocumentServiceGetBrowsingTopicsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean observe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BrowsingTopicsDocumentServiceGetBrowsingTopicsParams(int version) {
      super(16, version);
    }

    public BrowsingTopicsDocumentServiceGetBrowsingTopicsParams() {
      this(0);
    }

    public static BrowsingTopicsDocumentServiceGetBrowsingTopicsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BrowsingTopicsDocumentServiceGetBrowsingTopicsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BrowsingTopicsDocumentServiceGetBrowsingTopicsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BrowsingTopicsDocumentServiceGetBrowsingTopicsParams result =
            new BrowsingTopicsDocumentServiceGetBrowsingTopicsParams(elementsOrVersion);
        result.observe = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.observe, 8, 0);
    }
  }

  static final class BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public GetBrowsingTopicsResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams(int version) {
      super(24, version);
    }

    public BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams() {
      this(0);
    }

    public static BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams result =
            new BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams(elementsOrVersion);
        result.result = GetBrowsingTopicsResult.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final BrowsingTopicsDocumentService.GetBrowsingTopics_Response mCallback;

    BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParamsForwardToCallback(
        BrowsingTopicsDocumentService.GetBrowsingTopics_Response callback) {
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
        BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams response =
            BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParamsProxyToResponder
      implements BrowsingTopicsDocumentService.GetBrowsingTopics_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(GetBrowsingTopicsResult result) {
      BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams _response =
          new BrowsingTopicsDocumentServiceGetBrowsingTopicsResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
