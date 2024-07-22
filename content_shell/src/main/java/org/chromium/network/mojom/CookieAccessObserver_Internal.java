package org.chromium.network.mojom;

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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class CookieAccessObserver_Internal {
  private static final int CLONE_ORDINAL = 1;
  public static final Interface.Manager<CookieAccessObserver, CookieAccessObserver.Proxy> MANAGER =
      new Interface.Manager<CookieAccessObserver, CookieAccessObserver.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.CookieAccessObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CookieAccessObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CookieAccessObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public CookieAccessObserver[] buildArray(int size) {
          return new CookieAccessObserver[size];
        }
      };
  private static final int ON_COOKIES_ACCESSED_ORDINAL = 0;

  CookieAccessObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CookieAccessObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onCookiesAccessed(CookieAccessDetails[] details) {
      CookieAccessObserverOnCookiesAccessedParams _message =
          new CookieAccessObserverOnCookiesAccessedParams();
      _message.details = details;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void clone(InterfaceRequest<CookieAccessObserver> listener) {
      CookieAccessObserverCloneParams _message = new CookieAccessObserverCloneParams();
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<CookieAccessObserver> {
    Stub(Core core, CookieAccessObserver impl) {
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
                CookieAccessObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CookieAccessObserverOnCookiesAccessedParams data =
                CookieAccessObserverOnCookiesAccessedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onCookiesAccessed(data.details);
            return true;
          case 1:
            CookieAccessObserverCloneParams data2 =
                CookieAccessObserverCloneParams.deserialize(messageWithHeader.getPayload());
            getImpl().clone(data2.listener);
            return true;
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
                getCore(), CookieAccessObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CookieAccessObserverOnCookiesAccessedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieAccessDetails[] details;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieAccessObserverOnCookiesAccessedParams(int version) {
      super(16, version);
    }

    public CookieAccessObserverOnCookiesAccessedParams() {
      this(0);
    }

    public static CookieAccessObserverOnCookiesAccessedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieAccessObserverOnCookiesAccessedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieAccessObserverOnCookiesAccessedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieAccessObserverOnCookiesAccessedParams result =
            new CookieAccessObserverOnCookiesAccessedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.details = new CookieAccessDetails[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.details[i1] = CookieAccessDetails.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      CookieAccessDetails[] cookieAccessDetailsArr = this.details;
      if (cookieAccessDetailsArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(cookieAccessDetailsArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        CookieAccessDetails[] cookieAccessDetailsArr2 = this.details;
        if (i0 < cookieAccessDetailsArr2.length) {
          encoder1.encode((Struct) cookieAccessDetailsArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class CookieAccessObserverCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<CookieAccessObserver> listener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieAccessObserverCloneParams(int version) {
      super(16, version);
    }

    public CookieAccessObserverCloneParams() {
      this(0);
    }

    public static CookieAccessObserverCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieAccessObserverCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieAccessObserverCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieAccessObserverCloneParams result =
            new CookieAccessObserverCloneParams(elementsOrVersion);
        result.listener = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.listener, 8, false);
    }
  }
}
