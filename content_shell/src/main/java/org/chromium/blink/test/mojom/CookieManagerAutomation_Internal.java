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
import org.chromium.network.mojom.CookieWithAccessResult;

class CookieManagerAutomation_Internal {
  private static final int DELETE_ALL_COOKIES_ORDINAL = 0;
  private static final int GET_ALL_COOKIES_ORDINAL = 1;
  private static final int GET_NAMED_COOKIE_ORDINAL = 2;
  public static final Interface.Manager<CookieManagerAutomation, CookieManagerAutomation.Proxy>
      MANAGER =
          new Interface.Manager<CookieManagerAutomation, CookieManagerAutomation.Proxy>() {
            @Override
            public String getName() {
              return "blink.test.mojom.CookieManagerAutomation";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CookieManagerAutomation.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CookieManagerAutomation impl) {
              return new Stub(core, impl);
            }

            @Override
            public CookieManagerAutomation[] buildArray(int size) {
              return new CookieManagerAutomation[size];
            }
          };

  CookieManagerAutomation_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CookieManagerAutomation.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void deleteAllCookies(DeleteAllCookies_Response callback) {
      CookieManagerAutomationDeleteAllCookiesParams _message =
          new CookieManagerAutomationDeleteAllCookiesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CookieManagerAutomationDeleteAllCookiesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getAllCookies(GetAllCookies_Response callback) {
      CookieManagerAutomationGetAllCookiesParams _message =
          new CookieManagerAutomationGetAllCookiesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new CookieManagerAutomationGetAllCookiesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getNamedCookie(String name, GetNamedCookie_Response callback) {
      CookieManagerAutomationGetNamedCookieParams _message =
          new CookieManagerAutomationGetNamedCookieParams();
      _message.name = name;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new CookieManagerAutomationGetNamedCookieResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<CookieManagerAutomation> {
    Stub(Core core, CookieManagerAutomation impl) {
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
                CookieManagerAutomation_Internal.MANAGER, messageWithHeader);
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
                getCore(), CookieManagerAutomation_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CookieManagerAutomationDeleteAllCookiesParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .deleteAllCookies(
                    new CookieManagerAutomationDeleteAllCookiesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            CookieManagerAutomationGetAllCookiesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getAllCookies(
                    new CookieManagerAutomationGetAllCookiesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            CookieManagerAutomationGetNamedCookieParams data =
                CookieManagerAutomationGetNamedCookieParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getNamedCookie(
                    data.name,
                    new CookieManagerAutomationGetNamedCookieResponseParamsProxyToResponder(
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

  static final class CookieManagerAutomationDeleteAllCookiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAutomationDeleteAllCookiesParams(int version) {
      super(8, version);
    }

    public CookieManagerAutomationDeleteAllCookiesParams() {
      this(0);
    }

    public static CookieManagerAutomationDeleteAllCookiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAutomationDeleteAllCookiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAutomationDeleteAllCookiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAutomationDeleteAllCookiesParams result =
            new CookieManagerAutomationDeleteAllCookiesParams(elementsOrVersion);
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

  static final class CookieManagerAutomationDeleteAllCookiesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAutomationDeleteAllCookiesResponseParams(int version) {
      super(8, version);
    }

    public CookieManagerAutomationDeleteAllCookiesResponseParams() {
      this(0);
    }

    public static CookieManagerAutomationDeleteAllCookiesResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAutomationDeleteAllCookiesResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAutomationDeleteAllCookiesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAutomationDeleteAllCookiesResponseParams result =
            new CookieManagerAutomationDeleteAllCookiesResponseParams(elementsOrVersion);
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

  static class CookieManagerAutomationDeleteAllCookiesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManagerAutomation.DeleteAllCookies_Response mCallback;

    CookieManagerAutomationDeleteAllCookiesResponseParamsForwardToCallback(
        CookieManagerAutomation.DeleteAllCookies_Response callback) {
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

  static class CookieManagerAutomationDeleteAllCookiesResponseParamsProxyToResponder
      implements CookieManagerAutomation.DeleteAllCookies_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerAutomationDeleteAllCookiesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      CookieManagerAutomationDeleteAllCookiesResponseParams _response =
          new CookieManagerAutomationDeleteAllCookiesResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerAutomationGetAllCookiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAutomationGetAllCookiesParams(int version) {
      super(8, version);
    }

    public CookieManagerAutomationGetAllCookiesParams() {
      this(0);
    }

    public static CookieManagerAutomationGetAllCookiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAutomationGetAllCookiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAutomationGetAllCookiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAutomationGetAllCookiesParams result =
            new CookieManagerAutomationGetAllCookiesParams(elementsOrVersion);
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

  static final class CookieManagerAutomationGetAllCookiesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieWithAccessResult[] cookies;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAutomationGetAllCookiesResponseParams(int version) {
      super(16, version);
    }

    public CookieManagerAutomationGetAllCookiesResponseParams() {
      this(0);
    }

    public static CookieManagerAutomationGetAllCookiesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAutomationGetAllCookiesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAutomationGetAllCookiesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAutomationGetAllCookiesResponseParams result =
            new CookieManagerAutomationGetAllCookiesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.cookies = new CookieWithAccessResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.cookies[i1] = CookieWithAccessResult.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      CookieWithAccessResult[] cookieWithAccessResultArr = this.cookies;
      if (cookieWithAccessResultArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(cookieWithAccessResultArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        CookieWithAccessResult[] cookieWithAccessResultArr2 = this.cookies;
        if (i0 < cookieWithAccessResultArr2.length) {
          encoder1.encode((Struct) cookieWithAccessResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class CookieManagerAutomationGetAllCookiesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManagerAutomation.GetAllCookies_Response mCallback;

    CookieManagerAutomationGetAllCookiesResponseParamsForwardToCallback(
        CookieManagerAutomation.GetAllCookies_Response callback) {
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
        CookieManagerAutomationGetAllCookiesResponseParams response =
            CookieManagerAutomationGetAllCookiesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.cookies);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerAutomationGetAllCookiesResponseParamsProxyToResponder
      implements CookieManagerAutomation.GetAllCookies_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerAutomationGetAllCookiesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CookieWithAccessResult[] cookies) {
      CookieManagerAutomationGetAllCookiesResponseParams _response =
          new CookieManagerAutomationGetAllCookiesResponseParams();
      _response.cookies = cookies;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CookieManagerAutomationGetNamedCookieParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String name;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAutomationGetNamedCookieParams(int version) {
      super(16, version);
    }

    public CookieManagerAutomationGetNamedCookieParams() {
      this(0);
    }

    public static CookieManagerAutomationGetNamedCookieParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAutomationGetNamedCookieParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAutomationGetNamedCookieParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAutomationGetNamedCookieParams result =
            new CookieManagerAutomationGetNamedCookieParams(elementsOrVersion);
        result.name = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.name, 8, false);
    }
  }

  static final class CookieManagerAutomationGetNamedCookieResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieWithAccessResult cookie;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieManagerAutomationGetNamedCookieResponseParams(int version) {
      super(16, version);
    }

    public CookieManagerAutomationGetNamedCookieResponseParams() {
      this(0);
    }

    public static CookieManagerAutomationGetNamedCookieResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieManagerAutomationGetNamedCookieResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerAutomationGetNamedCookieResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieManagerAutomationGetNamedCookieResponseParams result =
            new CookieManagerAutomationGetNamedCookieResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.cookie = CookieWithAccessResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cookie, 8, true);
    }
  }

  static class CookieManagerAutomationGetNamedCookieResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieManagerAutomation.GetNamedCookie_Response mCallback;

    CookieManagerAutomationGetNamedCookieResponseParamsForwardToCallback(
        CookieManagerAutomation.GetNamedCookie_Response callback) {
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
        CookieManagerAutomationGetNamedCookieResponseParams response =
            CookieManagerAutomationGetNamedCookieResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.cookie);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieManagerAutomationGetNamedCookieResponseParamsProxyToResponder
      implements CookieManagerAutomation.GetNamedCookie_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieManagerAutomationGetNamedCookieResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(CookieWithAccessResult cookie) {
      CookieManagerAutomationGetNamedCookieResponseParams _response =
          new CookieManagerAutomationGetNamedCookieResponseParams();
      _response.cookie = cookie;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
