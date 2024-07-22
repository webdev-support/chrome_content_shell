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

class SharedWorkerClient_Internal {
  public static final Interface.Manager<SharedWorkerClient, SharedWorkerClient.Proxy> MANAGER =
      new Interface.Manager<SharedWorkerClient, SharedWorkerClient.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.SharedWorkerClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SharedWorkerClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SharedWorkerClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public SharedWorkerClient[] buildArray(int size) {
          return new SharedWorkerClient[size];
        }
      };
  private static final int ON_CONNECTED_ORDINAL = 1;
  private static final int ON_CREATED_ORDINAL = 0;
  private static final int ON_FEATURE_USED_ORDINAL = 3;
  private static final int ON_SCRIPT_LOAD_FAILED_ORDINAL = 2;

  SharedWorkerClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SharedWorkerClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onCreated(int creationContextType) {
      SharedWorkerClientOnCreatedParams _message = new SharedWorkerClientOnCreatedParams();
      _message.creationContextType = creationContextType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onConnected(int[] featuresUsed) {
      SharedWorkerClientOnConnectedParams _message = new SharedWorkerClientOnConnectedParams();
      _message.featuresUsed = featuresUsed;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onScriptLoadFailed(String errorMessage) {
      SharedWorkerClientOnScriptLoadFailedParams _message =
          new SharedWorkerClientOnScriptLoadFailedParams();
      _message.errorMessage = errorMessage;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onFeatureUsed(int feature) {
      SharedWorkerClientOnFeatureUsedParams _message = new SharedWorkerClientOnFeatureUsedParams();
      _message.feature = feature;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<SharedWorkerClient> {
    Stub(Core core, SharedWorkerClient impl) {
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
                SharedWorkerClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SharedWorkerClientOnCreatedParams data =
                SharedWorkerClientOnCreatedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onCreated(data.creationContextType);
            return true;
          case 1:
            SharedWorkerClientOnConnectedParams data2 =
                SharedWorkerClientOnConnectedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onConnected(data2.featuresUsed);
            return true;
          case 2:
            SharedWorkerClientOnScriptLoadFailedParams data3 =
                SharedWorkerClientOnScriptLoadFailedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onScriptLoadFailed(data3.errorMessage);
            return true;
          case 3:
            SharedWorkerClientOnFeatureUsedParams data4 =
                SharedWorkerClientOnFeatureUsedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onFeatureUsed(data4.feature);
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
                getCore(), SharedWorkerClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SharedWorkerClientOnCreatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int creationContextType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerClientOnCreatedParams(int version) {
      super(16, version);
    }

    public SharedWorkerClientOnCreatedParams() {
      this(0);
    }

    public static SharedWorkerClientOnCreatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerClientOnCreatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerClientOnCreatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerClientOnCreatedParams result =
            new SharedWorkerClientOnCreatedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.creationContextType = readInt;
        SharedWorkerCreationContextType.validate(readInt);
        result.creationContextType =
            SharedWorkerCreationContextType.toKnownValue(result.creationContextType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.creationContextType, 8);
    }
  }

  static final class SharedWorkerClientOnConnectedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] featuresUsed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerClientOnConnectedParams(int version) {
      super(16, version);
    }

    public SharedWorkerClientOnConnectedParams() {
      this(0);
    }

    public static SharedWorkerClientOnConnectedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerClientOnConnectedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerClientOnConnectedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerClientOnConnectedParams result =
            new SharedWorkerClientOnConnectedParams(elementsOrVersion);
        result.featuresUsed = decoder0.readInts(8, 0, -1);
        int i1 = 0;
        while (true) {
          int[] iArr = result.featuresUsed;
          if (i1 < iArr.length) {
            WebFeature.validate(iArr[i1]);
            i1++;
          } else {
            return result;
          }
        }
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.featuresUsed, 8, 0, -1);
    }
  }

  static final class SharedWorkerClientOnScriptLoadFailedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String errorMessage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerClientOnScriptLoadFailedParams(int version) {
      super(16, version);
    }

    public SharedWorkerClientOnScriptLoadFailedParams() {
      this(0);
    }

    public static SharedWorkerClientOnScriptLoadFailedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerClientOnScriptLoadFailedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerClientOnScriptLoadFailedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerClientOnScriptLoadFailedParams result =
            new SharedWorkerClientOnScriptLoadFailedParams(elementsOrVersion);
        result.errorMessage = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorMessage, 8, false);
    }
  }

  static final class SharedWorkerClientOnFeatureUsedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int feature;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerClientOnFeatureUsedParams(int version) {
      super(16, version);
    }

    public SharedWorkerClientOnFeatureUsedParams() {
      this(0);
    }

    public static SharedWorkerClientOnFeatureUsedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerClientOnFeatureUsedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerClientOnFeatureUsedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerClientOnFeatureUsedParams result =
            new SharedWorkerClientOnFeatureUsedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.feature = readInt;
        WebFeature.validate(readInt);
        result.feature = WebFeature.toKnownValue(result.feature);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.feature, 8);
    }
  }
}
