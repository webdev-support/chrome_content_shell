package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class AppBannerController_Internal {
  private static final int BANNER_PROMPT_REQUEST_ORDINAL = 0;
  public static final Interface.Manager<AppBannerController, AppBannerController.Proxy> MANAGER =
      new Interface.Manager<AppBannerController, AppBannerController.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.AppBannerController";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AppBannerController.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AppBannerController impl) {
          return new Stub(core, impl);
        }

        @Override
        public AppBannerController[] buildArray(int size) {
          return new AppBannerController[size];
        }
      };

  AppBannerController_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AppBannerController.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void bannerPromptRequest(
        AppBannerService service,
        InterfaceRequest<AppBannerEvent> eventReceiver,
        String[] platform,
        BannerPromptRequest_Response callback) {
      AppBannerControllerBannerPromptRequestParams _message =
          new AppBannerControllerBannerPromptRequestParams();
      _message.service = service;
      _message.eventReceiver = eventReceiver;
      _message.platform = platform;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new AppBannerControllerBannerPromptRequestResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<AppBannerController> {
    Stub(Core core, AppBannerController impl) {
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
                AppBannerController_Internal.MANAGER, messageWithHeader);
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
                getCore(), AppBannerController_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            AppBannerControllerBannerPromptRequestParams data =
                AppBannerControllerBannerPromptRequestParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .bannerPromptRequest(
                    data.service,
                    data.eventReceiver,
                    data.platform,
                    new AppBannerControllerBannerPromptRequestResponseParamsProxyToResponder(
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

  static final class AppBannerControllerBannerPromptRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AppBannerEvent> eventReceiver;
    public String[] platform;
    public AppBannerService service;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AppBannerControllerBannerPromptRequestParams(int version) {
      super(32, version);
    }

    public AppBannerControllerBannerPromptRequestParams() {
      this(0);
    }

    public static AppBannerControllerBannerPromptRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AppBannerControllerBannerPromptRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AppBannerControllerBannerPromptRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AppBannerControllerBannerPromptRequestParams result =
            new AppBannerControllerBannerPromptRequestParams(elementsOrVersion);
        result.service =
            (AppBannerService) decoder0.readServiceInterface(8, false, AppBannerService.MANAGER);
        result.eventReceiver = decoder0.readInterfaceRequest(16, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.platform = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.platform[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.service, 8, false, AppBannerService.MANAGER);
      encoder0.encode((InterfaceRequest) this.eventReceiver, 16, false);
      String[] strArr = this.platform;
      if (strArr == null) {
        encoder0.encodeNullPointer(24, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.platform;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class AppBannerControllerBannerPromptRequestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int reply;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AppBannerControllerBannerPromptRequestResponseParams(int version) {
      super(16, version);
    }

    public AppBannerControllerBannerPromptRequestResponseParams() {
      this(0);
    }

    public static AppBannerControllerBannerPromptRequestResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AppBannerControllerBannerPromptRequestResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AppBannerControllerBannerPromptRequestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AppBannerControllerBannerPromptRequestResponseParams result =
            new AppBannerControllerBannerPromptRequestResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.reply = readInt;
        AppBannerPromptReply.validate(readInt);
        result.reply = AppBannerPromptReply.toKnownValue(result.reply);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reply, 8);
    }
  }

  static class AppBannerControllerBannerPromptRequestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AppBannerController.BannerPromptRequest_Response mCallback;

    AppBannerControllerBannerPromptRequestResponseParamsForwardToCallback(
        AppBannerController.BannerPromptRequest_Response callback) {
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
        AppBannerControllerBannerPromptRequestResponseParams response =
            AppBannerControllerBannerPromptRequestResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.reply);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AppBannerControllerBannerPromptRequestResponseParamsProxyToResponder
      implements AppBannerController.BannerPromptRequest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AppBannerControllerBannerPromptRequestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int reply) {
      AppBannerControllerBannerPromptRequestResponseParams _response =
          new AppBannerControllerBannerPromptRequestResponseParams();
      _response.reply = reply;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
