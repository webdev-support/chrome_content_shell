package org.chromium.webshare.mojom;

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

class ShareService_Internal {
  public static final Interface.Manager<ShareService, ShareService.Proxy> MANAGER =
      new Interface.Manager<ShareService, ShareService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ShareService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ShareService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ShareService impl) {
          return new Stub(core, impl);
        }

        @Override
        public ShareService[] buildArray(int size) {
          return new ShareService[size];
        }
      };
  private static final int SHARE_ORDINAL = 0;

  ShareService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements ShareService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void share(
        String title,
        String text,
        Url url,
        SharedFile[] files,
        ShareService.Share_Response callback) {
      ShareServiceShareParams _message = new ShareServiceShareParams();
      _message.title = title;
      _message.text = text;
      _message.url = url;
      _message.files = files;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ShareServiceShareResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ShareService> {
    Stub(Core core, ShareService impl) {
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
                ShareService_Internal.MANAGER, messageWithHeader);
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
                getCore(), ShareService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ShareServiceShareParams data =
                ShareServiceShareParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .share(
                    data.title,
                    data.text,
                    data.url,
                    data.files,
                    new ShareServiceShareResponseParamsProxyToResponder(
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

  static final class ShareServiceShareParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public SharedFile[] files;
    public String text;
    public String title;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ShareServiceShareParams(int version) {
      super(40, version);
    }

    public ShareServiceShareParams() {
      this(0);
    }

    public static ShareServiceShareParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ShareServiceShareParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ShareServiceShareParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ShareServiceShareParams result = new ShareServiceShareParams(elementsOrVersion);
        result.title = decoder0.readString(8, false);
        result.text = decoder0.readString(16, false);
        result.url = Url.decode(decoder0.readPointer(24, false));
        Decoder decoder1 = decoder0.readPointer(32, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.files = new SharedFile[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.files[i1] = SharedFile.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.title, 8, false);
      encoder0.encode(this.text, 16, false);
      encoder0.encode((Struct) this.url, 24, false);
      SharedFile[] sharedFileArr = this.files;
      if (sharedFileArr == null) {
        encoder0.encodeNullPointer(32, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(sharedFileArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        SharedFile[] sharedFileArr2 = this.files;
        if (i0 < sharedFileArr2.length) {
          encoder1.encode((Struct) sharedFileArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class ShareServiceShareResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ShareServiceShareResponseParams(int version) {
      super(16, version);
    }

    public ShareServiceShareResponseParams() {
      this(0);
    }

    public static ShareServiceShareResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ShareServiceShareResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ShareServiceShareResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ShareServiceShareResponseParams result =
            new ShareServiceShareResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ShareError.validate(readInt);
        result.error = ShareError.toKnownValue(result.error);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
    }
  }

  static class ShareServiceShareResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ShareService.Share_Response mCallback;

    ShareServiceShareResponseParamsForwardToCallback(ShareService.Share_Response callback) {
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
        ShareServiceShareResponseParams response =
            ShareServiceShareResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ShareServiceShareResponseParamsProxyToResponder
      implements ShareService.Share_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ShareServiceShareResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error) {
      ShareServiceShareResponseParams _response = new ShareServiceShareResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
