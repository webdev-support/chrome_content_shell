package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

class KeySystemSupportObserver_Internal {
  public static final Interface.Manager<KeySystemSupportObserver, KeySystemSupportObserver.Proxy>
      MANAGER =
          new Interface.Manager<KeySystemSupportObserver, KeySystemSupportObserver.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.KeySystemSupportObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public KeySystemSupportObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, KeySystemSupportObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public KeySystemSupportObserver[] buildArray(int size) {
              return new KeySystemSupportObserver[size];
            }
          };
  private static final int ON_KEY_SYSTEM_SUPPORT_UPDATED_ORDINAL = 0;

  KeySystemSupportObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements KeySystemSupportObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onKeySystemSupportUpdated(Map<String, KeySystemCapability> keySystems) {
      KeySystemSupportObserverOnKeySystemSupportUpdatedParams _message =
          new KeySystemSupportObserverOnKeySystemSupportUpdatedParams();
      _message.keySystems = keySystems;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<KeySystemSupportObserver> {
    Stub(Core core, KeySystemSupportObserver impl) {
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
                KeySystemSupportObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            KeySystemSupportObserverOnKeySystemSupportUpdatedParams data =
                KeySystemSupportObserverOnKeySystemSupportUpdatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onKeySystemSupportUpdated(data.keySystems);
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
                getCore(), KeySystemSupportObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class KeySystemSupportObserverOnKeySystemSupportUpdatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Map<String, KeySystemCapability> keySystems;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private KeySystemSupportObserverOnKeySystemSupportUpdatedParams(int version) {
      super(16, version);
    }

    public KeySystemSupportObserverOnKeySystemSupportUpdatedParams() {
      this(0);
    }

    public static KeySystemSupportObserverOnKeySystemSupportUpdatedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static KeySystemSupportObserverOnKeySystemSupportUpdatedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static KeySystemSupportObserverOnKeySystemSupportUpdatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        KeySystemSupportObserverOnKeySystemSupportUpdatedParams result =
            new KeySystemSupportObserverOnKeySystemSupportUpdatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        decoder1.readDataHeaderForMap();
        Decoder decoder2 = decoder1.readPointer(8, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
        String[] keys0 = new String[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
        }
        Decoder decoder22 = decoder1.readPointer(16, false);
        DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
        KeySystemCapability[] values0 = new KeySystemCapability[si22.elementsOrVersion];
        for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
          Decoder decoder3 = decoder22.readPointer((i22 * 8) + 8, false);
          values0[i22] = KeySystemCapability.decode(decoder3);
        }
        result.keySystems = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.keySystems.put(keys0[index0], values0[index0]);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      if (this.keySystems == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.keySystems.size();
      String[] keys0 = new String[size0];
      KeySystemCapability[] values0 = new KeySystemCapability[size0];
      int index0 = 0;
      for (Map.Entry<String, KeySystemCapability> entry0 : this.keySystems.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode((Struct) values0[i12], (i12 * 8) + 8, false);
      }
    }
  }
}
