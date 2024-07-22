package org.chromium.device.mojom;

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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class FingerprintObserver_Internal {
  public static final Interface.Manager<FingerprintObserver, FingerprintObserver.Proxy> MANAGER =
      new Interface.Manager<FingerprintObserver, FingerprintObserver.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.FingerprintObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FingerprintObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FingerprintObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public FingerprintObserver[] buildArray(int size) {
          return new FingerprintObserver[size];
        }
      };
  private static final int ON_AUTH_SCAN_DONE_ORDINAL = 3;
  private static final int ON_ENROLL_SCAN_DONE_ORDINAL = 2;
  private static final int ON_RESTARTED_ORDINAL = 0;
  private static final int ON_SESSION_FAILED_ORDINAL = 4;
  private static final int ON_STATUS_CHANGED_ORDINAL = 1;

  FingerprintObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FingerprintObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onRestarted() {
      FingerprintObserverOnRestartedParams _message = new FingerprintObserverOnRestartedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onStatusChanged(int status) {
      FingerprintObserverOnStatusChangedParams _message =
          new FingerprintObserverOnStatusChangedParams();
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onEnrollScanDone(int scanResult, boolean isComplete, int percentComplete) {
      FingerprintObserverOnEnrollScanDoneParams _message =
          new FingerprintObserverOnEnrollScanDoneParams();
      _message.scanResult = scanResult;
      _message.isComplete = isComplete;
      _message.percentComplete = percentComplete;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onAuthScanDone(FingerprintMessage msg, Map<String, String[]> matches) {
      FingerprintObserverOnAuthScanDoneParams _message =
          new FingerprintObserverOnAuthScanDoneParams();
      _message.msg = msg;
      _message.matches = matches;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onSessionFailed() {
      FingerprintObserverOnSessionFailedParams _message =
          new FingerprintObserverOnSessionFailedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<FingerprintObserver> {
    Stub(Core core, FingerprintObserver impl) {
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
                FingerprintObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FingerprintObserverOnRestartedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onRestarted();
            return true;
          case 1:
            getImpl()
                .onStatusChanged(
                    FingerprintObserverOnStatusChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .status);
            return true;
          case 2:
            FingerprintObserverOnEnrollScanDoneParams data =
                FingerprintObserverOnEnrollScanDoneParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onEnrollScanDone(data.scanResult, data.isComplete, data.percentComplete);
            return true;
          case 3:
            FingerprintObserverOnAuthScanDoneParams data2 =
                FingerprintObserverOnAuthScanDoneParams.deserialize(messageWithHeader.getPayload());
            getImpl().onAuthScanDone(data2.msg, data2.matches);
            return true;
          case 4:
            FingerprintObserverOnSessionFailedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onSessionFailed();
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
                getCore(), FingerprintObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FingerprintObserverOnRestartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintObserverOnRestartedParams(int version) {
      super(8, version);
    }

    public FingerprintObserverOnRestartedParams() {
      this(0);
    }

    public static FingerprintObserverOnRestartedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintObserverOnRestartedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintObserverOnRestartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintObserverOnRestartedParams result =
            new FingerprintObserverOnRestartedParams(elementsOrVersion);
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

  static final class FingerprintObserverOnStatusChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintObserverOnStatusChangedParams(int version) {
      super(16, version);
    }

    public FingerprintObserverOnStatusChangedParams() {
      this(0);
    }

    public static FingerprintObserverOnStatusChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintObserverOnStatusChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintObserverOnStatusChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintObserverOnStatusChangedParams result =
            new FingerprintObserverOnStatusChangedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        BiometricsManagerStatus.validate(readInt);
        result.status = BiometricsManagerStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
    }
  }

  static final class FingerprintObserverOnEnrollScanDoneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isComplete;
    public int percentComplete;
    public int scanResult;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintObserverOnEnrollScanDoneParams(int version) {
      super(24, version);
    }

    public FingerprintObserverOnEnrollScanDoneParams() {
      this(0);
    }

    public static FingerprintObserverOnEnrollScanDoneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintObserverOnEnrollScanDoneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintObserverOnEnrollScanDoneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintObserverOnEnrollScanDoneParams result =
            new FingerprintObserverOnEnrollScanDoneParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.scanResult = readInt;
        ScanResult.validate(readInt);
        result.scanResult = ScanResult.toKnownValue(result.scanResult);
        result.isComplete = decoder0.readBoolean(12, 0);
        result.percentComplete = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.scanResult, 8);
      encoder0.encode(this.isComplete, 12, 0);
      encoder0.encode(this.percentComplete, 16);
    }
  }

  static final class FingerprintObserverOnAuthScanDoneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Map<String, String[]> matches;
    public FingerprintMessage msg;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintObserverOnAuthScanDoneParams(int version) {
      super(32, version);
    }

    public FingerprintObserverOnAuthScanDoneParams() {
      this(0);
    }

    public static FingerprintObserverOnAuthScanDoneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintObserverOnAuthScanDoneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintObserverOnAuthScanDoneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintObserverOnAuthScanDoneParams result =
            new FingerprintObserverOnAuthScanDoneParams(elementsOrVersion);
        result.msg = FingerprintMessage.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, false);
        decoder1.readDataHeaderForMap();
        Decoder decoder2 = decoder1.readPointer(8, false);
        int i = -1;
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
        String[] keys0 = new String[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
        }
        Decoder decoder22 = decoder1.readPointer(16, false);
        DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
        String[][] values0 = new String[si22.elementsOrVersion][];
        int i22 = 0;
        while (i22 < si22.elementsOrVersion) {
          Decoder decoder3 = decoder22.readPointer((i22 * 8) + 8, false);
          DataHeader si3 = decoder3.readDataHeaderForPointerArray(i);
          values0[i22] = new String[si3.elementsOrVersion];
          int i3 = 0;
          while (i3 < si3.elementsOrVersion) {
            values0[i22][i3] = decoder3.readString((i3 * 8) + 8, false);
            i3++;
            mainDataHeader = mainDataHeader;
          }
          i22++;
          i = -1;
        }
        result.matches = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.matches.put(keys0[index0], values0[index0]);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.msg, 8, false);
      if (this.matches == null) {
        encoder0.encodeNullPointer(24, false);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(24);
      int size0 = this.matches.size();
      String[] keys0 = new String[size0];
      String[][] values0 = new String[size0][];
      int index0 = 0;
      for (Map.Entry<String, String[]> entry0 : this.matches.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      int i = -1;
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
      int i12 = 0;
      while (i12 < values0.length) {
        if (values0[i12] == null) {
          encoder22.encodeNullPointer((i12 * 8) + 8, false);
        } else {
          Encoder encoder3 = encoder22.encodePointerArray(values0[i12].length, (i12 * 8) + 8, i);
          for (int i2 = 0; i2 < values0[i12].length; i2++) {
            encoder3.encode(values0[i12][i2], (i2 * 8) + 8, false);
          }
        }
        i12++;
        i = -1;
      }
    }
  }

  static final class FingerprintObserverOnSessionFailedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintObserverOnSessionFailedParams(int version) {
      super(8, version);
    }

    public FingerprintObserverOnSessionFailedParams() {
      this(0);
    }

    public static FingerprintObserverOnSessionFailedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintObserverOnSessionFailedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintObserverOnSessionFailedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintObserverOnSessionFailedParams result =
            new FingerprintObserverOnSessionFailedParams(elementsOrVersion);
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
