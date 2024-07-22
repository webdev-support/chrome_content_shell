package org.chromium.service_manager.mojom;

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

class ServiceManagerListener_Internal {
  public static final Interface.Manager<ServiceManagerListener, ServiceManagerListener.Proxy>
      MANAGER =
          new Interface.Manager<ServiceManagerListener, ServiceManagerListener.Proxy>() {
            @Override
            public String getName() {
              return "service_manager.mojom.ServiceManagerListener";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ServiceManagerListener.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ServiceManagerListener impl) {
              return new Stub(core, impl);
            }

            @Override
            public ServiceManagerListener[] buildArray(int size) {
              return new ServiceManagerListener[size];
            }
          };
  private static final int ON_INIT_ORDINAL = 0;
  private static final int ON_SERVICE_CREATED_ORDINAL = 1;
  private static final int ON_SERVICE_FAILED_TO_START_ORDINAL = 4;
  private static final int ON_SERVICE_PID_RECEIVED_ORDINAL = 3;
  private static final int ON_SERVICE_STARTED_ORDINAL = 2;
  private static final int ON_SERVICE_STOPPED_ORDINAL = 5;

  ServiceManagerListener_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceManagerListener.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onInit(RunningServiceInfo[] runningServices) {
      ServiceManagerListenerOnInitParams _message = new ServiceManagerListenerOnInitParams();
      _message.runningServices = runningServices;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onServiceCreated(RunningServiceInfo service) {
      ServiceManagerListenerOnServiceCreatedParams _message =
          new ServiceManagerListenerOnServiceCreatedParams();
      _message.service = service;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onServiceStarted(Identity identity, int pidDeprecated) {
      ServiceManagerListenerOnServiceStartedParams _message =
          new ServiceManagerListenerOnServiceStartedParams();
      _message.identity = identity;
      _message.pidDeprecated = pidDeprecated;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onServicePidReceived(Identity identity, int pid) {
      ServiceManagerListenerOnServicePidReceivedParams _message =
          new ServiceManagerListenerOnServicePidReceivedParams();
      _message.identity = identity;
      _message.pid = pid;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onServiceFailedToStart(Identity identity) {
      ServiceManagerListenerOnServiceFailedToStartParams _message =
          new ServiceManagerListenerOnServiceFailedToStartParams();
      _message.identity = identity;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onServiceStopped(Identity identity) {
      ServiceManagerListenerOnServiceStoppedParams _message =
          new ServiceManagerListenerOnServiceStoppedParams();
      _message.identity = identity;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceManagerListener> {
    Stub(Core core, ServiceManagerListener impl) {
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
                ServiceManagerListener_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ServiceManagerListenerOnInitParams data =
                ServiceManagerListenerOnInitParams.deserialize(messageWithHeader.getPayload());
            getImpl().onInit(data.runningServices);
            return true;
          case 1:
            ServiceManagerListenerOnServiceCreatedParams data2 =
                ServiceManagerListenerOnServiceCreatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onServiceCreated(data2.service);
            return true;
          case 2:
            ServiceManagerListenerOnServiceStartedParams data3 =
                ServiceManagerListenerOnServiceStartedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onServiceStarted(data3.identity, data3.pidDeprecated);
            return true;
          case 3:
            ServiceManagerListenerOnServicePidReceivedParams data4 =
                ServiceManagerListenerOnServicePidReceivedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onServicePidReceived(data4.identity, data4.pid);
            return true;
          case 4:
            ServiceManagerListenerOnServiceFailedToStartParams data5 =
                ServiceManagerListenerOnServiceFailedToStartParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onServiceFailedToStart(data5.identity);
            return true;
          case 5:
            ServiceManagerListenerOnServiceStoppedParams data6 =
                ServiceManagerListenerOnServiceStoppedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onServiceStopped(data6.identity);
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
                getCore(), ServiceManagerListener_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ServiceManagerListenerOnInitParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public RunningServiceInfo[] runningServices;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceManagerListenerOnInitParams(int version) {
      super(16, version);
    }

    public ServiceManagerListenerOnInitParams() {
      this(0);
    }

    public static ServiceManagerListenerOnInitParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceManagerListenerOnInitParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceManagerListenerOnInitParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceManagerListenerOnInitParams result =
            new ServiceManagerListenerOnInitParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.runningServices = new RunningServiceInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.runningServices[i1] = RunningServiceInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      RunningServiceInfo[] runningServiceInfoArr = this.runningServices;
      if (runningServiceInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(runningServiceInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        RunningServiceInfo[] runningServiceInfoArr2 = this.runningServices;
        if (i0 < runningServiceInfoArr2.length) {
          encoder1.encode((Struct) runningServiceInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class ServiceManagerListenerOnServiceCreatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public RunningServiceInfo service;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceManagerListenerOnServiceCreatedParams(int version) {
      super(16, version);
    }

    public ServiceManagerListenerOnServiceCreatedParams() {
      this(0);
    }

    public static ServiceManagerListenerOnServiceCreatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceManagerListenerOnServiceCreatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceManagerListenerOnServiceCreatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceManagerListenerOnServiceCreatedParams result =
            new ServiceManagerListenerOnServiceCreatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.service = RunningServiceInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.service, 8, false);
    }
  }

  static final class ServiceManagerListenerOnServiceStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;
    public int pidDeprecated;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceManagerListenerOnServiceStartedParams(int version) {
      super(24, version);
    }

    public ServiceManagerListenerOnServiceStartedParams() {
      this(0);
    }

    public static ServiceManagerListenerOnServiceStartedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceManagerListenerOnServiceStartedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceManagerListenerOnServiceStartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceManagerListenerOnServiceStartedParams result =
            new ServiceManagerListenerOnServiceStartedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.identity = Identity.decode(decoder1);
        result.pidDeprecated = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.identity, 8, false);
      encoder0.encode(this.pidDeprecated, 16);
    }
  }

  static final class ServiceManagerListenerOnServicePidReceivedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;
    public int pid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceManagerListenerOnServicePidReceivedParams(int version) {
      super(24, version);
    }

    public ServiceManagerListenerOnServicePidReceivedParams() {
      this(0);
    }

    public static ServiceManagerListenerOnServicePidReceivedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceManagerListenerOnServicePidReceivedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceManagerListenerOnServicePidReceivedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceManagerListenerOnServicePidReceivedParams result =
            new ServiceManagerListenerOnServicePidReceivedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.identity = Identity.decode(decoder1);
        result.pid = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.identity, 8, false);
      encoder0.encode(this.pid, 16);
    }
  }

  static final class ServiceManagerListenerOnServiceFailedToStartParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceManagerListenerOnServiceFailedToStartParams(int version) {
      super(16, version);
    }

    public ServiceManagerListenerOnServiceFailedToStartParams() {
      this(0);
    }

    public static ServiceManagerListenerOnServiceFailedToStartParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceManagerListenerOnServiceFailedToStartParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceManagerListenerOnServiceFailedToStartParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceManagerListenerOnServiceFailedToStartParams result =
            new ServiceManagerListenerOnServiceFailedToStartParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.identity = Identity.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.identity, 8, false);
    }
  }

  static final class ServiceManagerListenerOnServiceStoppedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceManagerListenerOnServiceStoppedParams(int version) {
      super(16, version);
    }

    public ServiceManagerListenerOnServiceStoppedParams() {
      this(0);
    }

    public static ServiceManagerListenerOnServiceStoppedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceManagerListenerOnServiceStoppedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceManagerListenerOnServiceStoppedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceManagerListenerOnServiceStoppedParams result =
            new ServiceManagerListenerOnServiceStoppedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.identity = Identity.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.identity, 8, false);
    }
  }
}
