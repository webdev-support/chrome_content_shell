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

class SharedDictionaryAccessObserver_Internal {
  private static final int CLONE_ORDINAL = 1;
  public static final Interface.Manager<
          SharedDictionaryAccessObserver, SharedDictionaryAccessObserver.Proxy>
      MANAGER =
          new Interface.Manager<
              SharedDictionaryAccessObserver, SharedDictionaryAccessObserver.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.SharedDictionaryAccessObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SharedDictionaryAccessObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SharedDictionaryAccessObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public SharedDictionaryAccessObserver[] buildArray(int size) {
              return new SharedDictionaryAccessObserver[size];
            }
          };
  private static final int ON_SHARED_DICTIONARY_ACCESSED_ORDINAL = 0;

  SharedDictionaryAccessObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SharedDictionaryAccessObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onSharedDictionaryAccessed(SharedDictionaryAccessDetails details) {
      SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams _message =
          new SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams();
      _message.details = details;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void clone(InterfaceRequest<SharedDictionaryAccessObserver> observer) {
      SharedDictionaryAccessObserverCloneParams _message =
          new SharedDictionaryAccessObserverCloneParams();
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<SharedDictionaryAccessObserver> {
    Stub(Core core, SharedDictionaryAccessObserver impl) {
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
                SharedDictionaryAccessObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams data =
                SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onSharedDictionaryAccessed(data.details);
            return true;
          case 1:
            SharedDictionaryAccessObserverCloneParams data2 =
                SharedDictionaryAccessObserverCloneParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().clone(data2.observer);
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
                getCore(),
                SharedDictionaryAccessObserver_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SharedDictionaryAccessDetails details;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams(int version) {
      super(16, version);
    }

    public SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams() {
      this(0);
    }

    public static SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams result =
            new SharedDictionaryAccessObserverOnSharedDictionaryAccessedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.details = SharedDictionaryAccessDetails.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.details, 8, false);
    }
  }

  static final class SharedDictionaryAccessObserverCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<SharedDictionaryAccessObserver> observer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedDictionaryAccessObserverCloneParams(int version) {
      super(16, version);
    }

    public SharedDictionaryAccessObserverCloneParams() {
      this(0);
    }

    public static SharedDictionaryAccessObserverCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedDictionaryAccessObserverCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedDictionaryAccessObserverCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedDictionaryAccessObserverCloneParams result =
            new SharedDictionaryAccessObserverCloneParams(elementsOrVersion);
        result.observer = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.observer, 8, false);
    }
  }
}
