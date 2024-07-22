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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class StorageAreaObserver_Internal {
  private static final int ALL_DELETED_ORDINAL = 3;
  private static final int KEY_CHANGED_ORDINAL = 0;
  private static final int KEY_CHANGE_FAILED_ORDINAL = 1;
  private static final int KEY_DELETED_ORDINAL = 2;
  public static final Interface.Manager<StorageAreaObserver, StorageAreaObserver.Proxy> MANAGER =
      new Interface.Manager<StorageAreaObserver, StorageAreaObserver.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.StorageAreaObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public StorageAreaObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, StorageAreaObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public StorageAreaObserver[] buildArray(int size) {
          return new StorageAreaObserver[size];
        }
      };
  private static final int SHOULD_SEND_OLD_VALUE_ON_MUTATIONS_ORDINAL = 4;

  StorageAreaObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements StorageAreaObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void keyChanged(byte[] key, byte[] newValue, byte[] oldValue, String source) {
      StorageAreaObserverKeyChangedParams _message = new StorageAreaObserverKeyChangedParams();
      _message.key = key;
      _message.newValue = newValue;
      _message.oldValue = oldValue;
      _message.source = source;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void keyChangeFailed(byte[] key, String source) {
      StorageAreaObserverKeyChangeFailedParams _message =
          new StorageAreaObserverKeyChangeFailedParams();
      _message.key = key;
      _message.source = source;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void keyDeleted(byte[] key, byte[] oldValue, String source) {
      StorageAreaObserverKeyDeletedParams _message = new StorageAreaObserverKeyDeletedParams();
      _message.key = key;
      _message.oldValue = oldValue;
      _message.source = source;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void allDeleted(boolean wasNonempty, String source) {
      StorageAreaObserverAllDeletedParams _message = new StorageAreaObserverAllDeletedParams();
      _message.wasNonempty = wasNonempty;
      _message.source = source;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void shouldSendOldValueOnMutations(boolean value) {
      StorageAreaObserverShouldSendOldValueOnMutationsParams _message =
          new StorageAreaObserverShouldSendOldValueOnMutationsParams();
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<StorageAreaObserver> {
    Stub(Core core, StorageAreaObserver impl) {
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
                StorageAreaObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            StorageAreaObserverKeyChangedParams data =
                StorageAreaObserverKeyChangedParams.deserialize(messageWithHeader.getPayload());
            getImpl().keyChanged(data.key, data.newValue, data.oldValue, data.source);
            return true;
          case 1:
            StorageAreaObserverKeyChangeFailedParams data2 =
                StorageAreaObserverKeyChangeFailedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().keyChangeFailed(data2.key, data2.source);
            return true;
          case 2:
            StorageAreaObserverKeyDeletedParams data3 =
                StorageAreaObserverKeyDeletedParams.deserialize(messageWithHeader.getPayload());
            getImpl().keyDeleted(data3.key, data3.oldValue, data3.source);
            return true;
          case 3:
            StorageAreaObserverAllDeletedParams data4 =
                StorageAreaObserverAllDeletedParams.deserialize(messageWithHeader.getPayload());
            getImpl().allDeleted(data4.wasNonempty, data4.source);
            return true;
          case 4:
            getImpl()
                .shouldSendOldValueOnMutations(
                    StorageAreaObserverShouldSendOldValueOnMutationsParams.deserialize(
                            messageWithHeader.getPayload())
                        .value);
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
                getCore(), StorageAreaObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class StorageAreaObserverKeyChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] key;
    public byte[] newValue;
    public byte[] oldValue;
    public String source;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StorageAreaObserverKeyChangedParams(int version) {
      super(40, version);
    }

    public StorageAreaObserverKeyChangedParams() {
      this(0);
    }

    public static StorageAreaObserverKeyChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StorageAreaObserverKeyChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StorageAreaObserverKeyChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StorageAreaObserverKeyChangedParams result =
            new StorageAreaObserverKeyChangedParams(elementsOrVersion);
        result.key = decoder0.readBytes(8, 0, -1);
        result.newValue = decoder0.readBytes(16, 0, -1);
        result.oldValue = decoder0.readBytes(24, 1, -1);
        result.source = decoder0.readString(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8, 0, -1);
      encoder0.encode(this.newValue, 16, 0, -1);
      encoder0.encode(this.oldValue, 24, 1, -1);
      encoder0.encode(this.source, 32, false);
    }
  }

  static final class StorageAreaObserverKeyChangeFailedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] key;
    public String source;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StorageAreaObserverKeyChangeFailedParams(int version) {
      super(24, version);
    }

    public StorageAreaObserverKeyChangeFailedParams() {
      this(0);
    }

    public static StorageAreaObserverKeyChangeFailedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StorageAreaObserverKeyChangeFailedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StorageAreaObserverKeyChangeFailedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StorageAreaObserverKeyChangeFailedParams result =
            new StorageAreaObserverKeyChangeFailedParams(elementsOrVersion);
        result.key = decoder0.readBytes(8, 0, -1);
        result.source = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8, 0, -1);
      encoder0.encode(this.source, 16, false);
    }
  }

  static final class StorageAreaObserverKeyDeletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] key;
    public byte[] oldValue;
    public String source;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StorageAreaObserverKeyDeletedParams(int version) {
      super(32, version);
    }

    public StorageAreaObserverKeyDeletedParams() {
      this(0);
    }

    public static StorageAreaObserverKeyDeletedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StorageAreaObserverKeyDeletedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StorageAreaObserverKeyDeletedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StorageAreaObserverKeyDeletedParams result =
            new StorageAreaObserverKeyDeletedParams(elementsOrVersion);
        result.key = decoder0.readBytes(8, 0, -1);
        result.oldValue = decoder0.readBytes(16, 1, -1);
        result.source = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8, 0, -1);
      encoder0.encode(this.oldValue, 16, 1, -1);
      encoder0.encode(this.source, 24, false);
    }
  }

  static final class StorageAreaObserverAllDeletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String source;
    public boolean wasNonempty;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StorageAreaObserverAllDeletedParams(int version) {
      super(24, version);
    }

    public StorageAreaObserverAllDeletedParams() {
      this(0);
    }

    public static StorageAreaObserverAllDeletedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StorageAreaObserverAllDeletedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StorageAreaObserverAllDeletedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StorageAreaObserverAllDeletedParams result =
            new StorageAreaObserverAllDeletedParams(elementsOrVersion);
        result.wasNonempty = decoder0.readBoolean(8, 0);
        result.source = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.wasNonempty, 8, 0);
      encoder0.encode(this.source, 16, false);
    }
  }

  static final class StorageAreaObserverShouldSendOldValueOnMutationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StorageAreaObserverShouldSendOldValueOnMutationsParams(int version) {
      super(16, version);
    }

    public StorageAreaObserverShouldSendOldValueOnMutationsParams() {
      this(0);
    }

    public static StorageAreaObserverShouldSendOldValueOnMutationsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static StorageAreaObserverShouldSendOldValueOnMutationsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StorageAreaObserverShouldSendOldValueOnMutationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StorageAreaObserverShouldSendOldValueOnMutationsParams result =
            new StorageAreaObserverShouldSendOldValueOnMutationsParams(elementsOrVersion);
        result.value = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.value, 8, 0);
    }
  }
}
