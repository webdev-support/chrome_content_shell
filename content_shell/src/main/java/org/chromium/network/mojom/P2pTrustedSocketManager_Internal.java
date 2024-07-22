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

class P2pTrustedSocketManager_Internal {
  public static final Interface.Manager<P2pTrustedSocketManager, P2pTrustedSocketManager.Proxy>
      MANAGER =
          new Interface.Manager<P2pTrustedSocketManager, P2pTrustedSocketManager.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.P2PTrustedSocketManager";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public P2pTrustedSocketManager.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, P2pTrustedSocketManager impl) {
              return new Stub(core, impl);
            }

            @Override
            public P2pTrustedSocketManager[] buildArray(int size) {
              return new P2pTrustedSocketManager[size];
            }
          };
  private static final int PAUSE_NETWORK_CHANGE_NOTIFICATIONS_ORDINAL = 2;
  private static final int RESUME_NETWORK_CHANGE_NOTIFICATIONS_ORDINAL = 3;
  private static final int START_RTP_DUMP_ORDINAL = 0;
  private static final int STOP_RTP_DUMP_ORDINAL = 1;

  P2pTrustedSocketManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements P2pTrustedSocketManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void startRtpDump(boolean incoming, boolean outgoing) {
      P2pTrustedSocketManagerStartRtpDumpParams _message =
          new P2pTrustedSocketManagerStartRtpDumpParams();
      _message.incoming = incoming;
      _message.outgoing = outgoing;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void stopRtpDump(boolean incoming, boolean outgoing) {
      P2pTrustedSocketManagerStopRtpDumpParams _message =
          new P2pTrustedSocketManagerStopRtpDumpParams();
      _message.incoming = incoming;
      _message.outgoing = outgoing;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void pauseNetworkChangeNotifications() {
      P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams _message =
          new P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void resumeNetworkChangeNotifications() {
      P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams _message =
          new P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<P2pTrustedSocketManager> {
    Stub(Core core, P2pTrustedSocketManager impl) {
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
                P2pTrustedSocketManager_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            P2pTrustedSocketManagerStartRtpDumpParams data =
                P2pTrustedSocketManagerStartRtpDumpParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().startRtpDump(data.incoming, data.outgoing);
            return true;
          case 1:
            P2pTrustedSocketManagerStopRtpDumpParams data2 =
                P2pTrustedSocketManagerStopRtpDumpParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().stopRtpDump(data2.incoming, data2.outgoing);
            return true;
          case 2:
            P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().pauseNetworkChangeNotifications();
            return true;
          case 3:
            P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().resumeNetworkChangeNotifications();
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
                getCore(), P2pTrustedSocketManager_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class P2pTrustedSocketManagerStartRtpDumpParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean incoming;
    public boolean outgoing;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pTrustedSocketManagerStartRtpDumpParams(int version) {
      super(16, version);
    }

    public P2pTrustedSocketManagerStartRtpDumpParams() {
      this(0);
    }

    public static P2pTrustedSocketManagerStartRtpDumpParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pTrustedSocketManagerStartRtpDumpParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pTrustedSocketManagerStartRtpDumpParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pTrustedSocketManagerStartRtpDumpParams result =
            new P2pTrustedSocketManagerStartRtpDumpParams(elementsOrVersion);
        result.incoming = decoder0.readBoolean(8, 0);
        result.outgoing = decoder0.readBoolean(8, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.incoming, 8, 0);
      encoder0.encode(this.outgoing, 8, 1);
    }
  }

  static final class P2pTrustedSocketManagerStopRtpDumpParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean incoming;
    public boolean outgoing;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pTrustedSocketManagerStopRtpDumpParams(int version) {
      super(16, version);
    }

    public P2pTrustedSocketManagerStopRtpDumpParams() {
      this(0);
    }

    public static P2pTrustedSocketManagerStopRtpDumpParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pTrustedSocketManagerStopRtpDumpParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pTrustedSocketManagerStopRtpDumpParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pTrustedSocketManagerStopRtpDumpParams result =
            new P2pTrustedSocketManagerStopRtpDumpParams(elementsOrVersion);
        result.incoming = decoder0.readBoolean(8, 0);
        result.outgoing = decoder0.readBoolean(8, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.incoming, 8, 0);
      encoder0.encode(this.outgoing, 8, 1);
    }
  }

  static final class P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams(int version) {
      super(8, version);
    }

    public P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams() {
      this(0);
    }

    public static P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams result =
            new P2pTrustedSocketManagerPauseNetworkChangeNotificationsParams(elementsOrVersion);
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

  static final class P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams(int version) {
      super(8, version);
    }

    public P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams() {
      this(0);
    }

    public static P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams result =
            new P2pTrustedSocketManagerResumeNetworkChangeNotificationsParams(elementsOrVersion);
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
}
