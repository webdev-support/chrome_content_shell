package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ManagedConfigurationService_Internal {
  private static final int GET_MANAGED_CONFIGURATION_ORDINAL = 0;
  public static final Interface.Manager<
          ManagedConfigurationService, ManagedConfigurationService.Proxy>
      MANAGER =
          new Interface.Manager<ManagedConfigurationService, ManagedConfigurationService.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ManagedConfigurationService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ManagedConfigurationService.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ManagedConfigurationService impl) {
              return new Stub(core, impl);
            }

            @Override
            public ManagedConfigurationService[] buildArray(int size) {
              return new ManagedConfigurationService[size];
            }
          };
  private static final int SUBSCRIBE_TO_MANAGED_CONFIGURATION_ORDINAL = 1;

  ManagedConfigurationService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ManagedConfigurationService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getManagedConfiguration(String[] keys, GetManagedConfiguration_Response callback) {
      ManagedConfigurationServiceGetManagedConfigurationParams _message =
          new ManagedConfigurationServiceGetManagedConfigurationParams();
      _message.keys = keys;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ManagedConfigurationServiceGetManagedConfigurationResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void subscribeToManagedConfiguration(ManagedConfigurationObserver observer) {
      ManagedConfigurationServiceSubscribeToManagedConfigurationParams _message =
          new ManagedConfigurationServiceSubscribeToManagedConfigurationParams();
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<ManagedConfigurationService> {
    Stub(Core core, ManagedConfigurationService impl) {
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
                ManagedConfigurationService_Internal.MANAGER, messageWithHeader);
          case 1:
            ManagedConfigurationServiceSubscribeToManagedConfigurationParams data =
                ManagedConfigurationServiceSubscribeToManagedConfigurationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().subscribeToManagedConfiguration(data.observer);
            return true;
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
                ManagedConfigurationService_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            ManagedConfigurationServiceGetManagedConfigurationParams data =
                ManagedConfigurationServiceGetManagedConfigurationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getManagedConfiguration(
                    data.keys,
                    new ManagedConfigurationServiceGetManagedConfigurationResponseParamsProxyToResponder(
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

  static final class ManagedConfigurationServiceGetManagedConfigurationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] keys;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManagedConfigurationServiceGetManagedConfigurationParams(int version) {
      super(16, version);
    }

    public ManagedConfigurationServiceGetManagedConfigurationParams() {
      this(0);
    }

    public static ManagedConfigurationServiceGetManagedConfigurationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ManagedConfigurationServiceGetManagedConfigurationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManagedConfigurationServiceGetManagedConfigurationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManagedConfigurationServiceGetManagedConfigurationParams result =
            new ManagedConfigurationServiceGetManagedConfigurationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.keys = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.keys[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.keys;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.keys;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class ManagedConfigurationServiceGetManagedConfigurationResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Map<String, String> configurations;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManagedConfigurationServiceGetManagedConfigurationResponseParams(int version) {
      super(16, version);
    }

    public ManagedConfigurationServiceGetManagedConfigurationResponseParams() {
      this(0);
    }

    public static ManagedConfigurationServiceGetManagedConfigurationResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ManagedConfigurationServiceGetManagedConfigurationResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManagedConfigurationServiceGetManagedConfigurationResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManagedConfigurationServiceGetManagedConfigurationResponseParams result =
            new ManagedConfigurationServiceGetManagedConfigurationResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        if (decoder1 == null) {
          result.configurations = null;
        } else {
          decoder1.readDataHeaderForMap();
          Decoder decoder2 = decoder1.readPointer(8, false);
          DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
          String[] keys0 = new String[si2.elementsOrVersion];
          for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
            keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
          }
          Decoder decoder22 = decoder1.readPointer(16, false);
          DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
          String[] values0 = new String[si22.elementsOrVersion];
          for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
            values0[i22] = decoder22.readString((i22 * 8) + 8, false);
          }
          result.configurations = new HashMap();
          for (int index0 = 0; index0 < keys0.length; index0++) {
            result.configurations.put(keys0[index0], values0[index0]);
          }
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      if (this.configurations == null) {
        encoder0.encodeNullPointer(8, true);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.configurations.size();
      String[] keys0 = new String[size0];
      String[] values0 = new String[size0];
      int index0 = 0;
      for (Map.Entry<String, String> entry0 : this.configurations.entrySet()) {
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
        encoder22.encode(values0[i12], (i12 * 8) + 8, false);
      }
    }
  }

  static class ManagedConfigurationServiceGetManagedConfigurationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ManagedConfigurationService.GetManagedConfiguration_Response mCallback;

    ManagedConfigurationServiceGetManagedConfigurationResponseParamsForwardToCallback(
        ManagedConfigurationService.GetManagedConfiguration_Response callback) {
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
        ManagedConfigurationServiceGetManagedConfigurationResponseParams response =
            ManagedConfigurationServiceGetManagedConfigurationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.configurations);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ManagedConfigurationServiceGetManagedConfigurationResponseParamsProxyToResponder
      implements ManagedConfigurationService.GetManagedConfiguration_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ManagedConfigurationServiceGetManagedConfigurationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Map<String, String> configurations) {
      ManagedConfigurationServiceGetManagedConfigurationResponseParams _response =
          new ManagedConfigurationServiceGetManagedConfigurationResponseParams();
      _response.configurations = configurations;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ManagedConfigurationServiceSubscribeToManagedConfigurationParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ManagedConfigurationObserver observer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManagedConfigurationServiceSubscribeToManagedConfigurationParams(int version) {
      super(16, version);
    }

    public ManagedConfigurationServiceSubscribeToManagedConfigurationParams() {
      this(0);
    }

    public static ManagedConfigurationServiceSubscribeToManagedConfigurationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ManagedConfigurationServiceSubscribeToManagedConfigurationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManagedConfigurationServiceSubscribeToManagedConfigurationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManagedConfigurationServiceSubscribeToManagedConfigurationParams result =
            new ManagedConfigurationServiceSubscribeToManagedConfigurationParams(elementsOrVersion);
        result.observer =
            (ManagedConfigurationObserver)
                decoder0.readServiceInterface(8, false, ManagedConfigurationObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.observer, 8, false, ManagedConfigurationObserver.MANAGER);
    }
  }
}
