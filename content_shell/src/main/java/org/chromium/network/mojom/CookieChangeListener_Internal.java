package org.chromium.network.mojom;

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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class CookieChangeListener_Internal {
  public static final Interface.Manager<CookieChangeListener, CookieChangeListener.Proxy> MANAGER =
      new Interface.Manager<CookieChangeListener, CookieChangeListener.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.CookieChangeListener";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CookieChangeListener.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CookieChangeListener impl) {
          return new Stub(core, impl);
        }

        @Override
        public CookieChangeListener[] buildArray(int size) {
          return new CookieChangeListener[size];
        }
      };
  private static final int ON_COOKIE_CHANGE_ORDINAL = 0;

  CookieChangeListener_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CookieChangeListener.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onCookieChange(CookieChangeInfo change) {
      CookieChangeListenerOnCookieChangeParams _message =
          new CookieChangeListenerOnCookieChangeParams();
      _message.change = change;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<CookieChangeListener> {
    Stub(Core core, CookieChangeListener impl) {
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
                CookieChangeListener_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CookieChangeListenerOnCookieChangeParams data =
                CookieChangeListenerOnCookieChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onCookieChange(data.change);
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
                getCore(), CookieChangeListener_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CookieChangeListenerOnCookieChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieChangeInfo change;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieChangeListenerOnCookieChangeParams(int version) {
      super(16, version);
    }

    public CookieChangeListenerOnCookieChangeParams() {
      this(0);
    }

    public static CookieChangeListenerOnCookieChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieChangeListenerOnCookieChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieChangeListenerOnCookieChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieChangeListenerOnCookieChangeParams result =
            new CookieChangeListenerOnCookieChangeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.change = CookieChangeInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.change, 8, false);
    }
  }
}
