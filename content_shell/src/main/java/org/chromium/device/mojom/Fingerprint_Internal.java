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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class Fingerprint_Internal {
  private static final int ADD_FINGERPRINT_OBSERVER_ORDINAL = 9;
  private static final int CANCEL_CURRENT_ENROLL_SESSION_ORDINAL = 2;
  private static final int DESTROY_ALL_RECORDS_ORDINAL = 8;
  private static final int END_CURRENT_AUTH_SESSION_ORDINAL = 7;
  private static final int GET_RECORDS_FOR_USER_ORDINAL = 0;
  public static final Interface.Manager<Fingerprint, Fingerprint.Proxy> MANAGER =
      new Interface.Manager<Fingerprint, Fingerprint.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.Fingerprint";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Fingerprint.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Fingerprint impl) {
          return new Stub(core, impl);
        }

        @Override
        public Fingerprint[] buildArray(int size) {
          return new Fingerprint[size];
        }
      };
  private static final int REMOVE_RECORD_ORDINAL = 5;
  private static final int REQUEST_RECORD_LABEL_ORDINAL = 3;
  private static final int REQUEST_TYPE_ORDINAL = 10;
  private static final int SET_RECORD_LABEL_ORDINAL = 4;
  private static final int START_AUTH_SESSION_ORDINAL = 6;
  private static final int START_ENROLL_SESSION_ORDINAL = 1;

  Fingerprint_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Fingerprint.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getRecordsForUser(String userId, GetRecordsForUser_Response callback) {
      FingerprintGetRecordsForUserParams _message = new FingerprintGetRecordsForUserParams();
      _message.userId = userId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FingerprintGetRecordsForUserResponseParamsForwardToCallback(callback));
    }

    @Override
    public void startEnrollSession(String userId, String label) {
      FingerprintStartEnrollSessionParams _message = new FingerprintStartEnrollSessionParams();
      _message.userId = userId;
      _message.label = label;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void cancelCurrentEnrollSession(CancelCurrentEnrollSession_Response callback) {
      FingerprintCancelCurrentEnrollSessionParams _message =
          new FingerprintCancelCurrentEnrollSessionParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new FingerprintCancelCurrentEnrollSessionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestRecordLabel(String recordPath, RequestRecordLabel_Response callback) {
      FingerprintRequestRecordLabelParams _message = new FingerprintRequestRecordLabelParams();
      _message.recordPath = recordPath;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FingerprintRequestRecordLabelResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setRecordLabel(
        String recordPath, String newLabel, SetRecordLabel_Response callback) {
      FingerprintSetRecordLabelParams _message = new FingerprintSetRecordLabelParams();
      _message.recordPath = recordPath;
      _message.newLabel = newLabel;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new FingerprintSetRecordLabelResponseParamsForwardToCallback(callback));
    }

    @Override
    public void removeRecord(String recordPath, RemoveRecord_Response callback) {
      FingerprintRemoveRecordParams _message = new FingerprintRemoveRecordParams();
      _message.recordPath = recordPath;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new FingerprintRemoveRecordResponseParamsForwardToCallback(callback));
    }

    @Override
    public void startAuthSession() {
      FingerprintStartAuthSessionParams _message = new FingerprintStartAuthSessionParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void endCurrentAuthSession(EndCurrentAuthSession_Response callback) {
      FingerprintEndCurrentAuthSessionParams _message =
          new FingerprintEndCurrentAuthSessionParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new FingerprintEndCurrentAuthSessionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void destroyAllRecords(DestroyAllRecords_Response callback) {
      FingerprintDestroyAllRecordsParams _message = new FingerprintDestroyAllRecordsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new FingerprintDestroyAllRecordsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void addFingerprintObserver(FingerprintObserver observer) {
      FingerprintAddFingerprintObserverParams _message =
          new FingerprintAddFingerprintObserverParams();
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void requestType(RequestType_Response callback) {
      FingerprintRequestTypeParams _message = new FingerprintRequestTypeParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new FingerprintRequestTypeResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<Fingerprint> {
    Stub(Core core, Fingerprint impl) {
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
                Fingerprint_Internal.MANAGER, messageWithHeader);
          case 1:
            FingerprintStartEnrollSessionParams data =
                FingerprintStartEnrollSessionParams.deserialize(messageWithHeader.getPayload());
            getImpl().startEnrollSession(data.userId, data.label);
            return true;
          case 6:
            FingerprintStartAuthSessionParams.deserialize(messageWithHeader.getPayload());
            getImpl().startAuthSession();
            return true;
          case 9:
            getImpl()
                .addFingerprintObserver(
                    FingerprintAddFingerprintObserverParams.deserialize(
                            messageWithHeader.getPayload())
                        .observer);
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
                getCore(), Fingerprint_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FingerprintGetRecordsForUserParams data =
                FingerprintGetRecordsForUserParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getRecordsForUser(
                    data.userId,
                    new FingerprintGetRecordsForUserResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          case 6:
          case 9:
          default:
            return false;
          case 2:
            FingerprintCancelCurrentEnrollSessionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .cancelCurrentEnrollSession(
                    new FingerprintCancelCurrentEnrollSessionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            FingerprintRequestRecordLabelParams data2 =
                FingerprintRequestRecordLabelParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestRecordLabel(
                    data2.recordPath,
                    new FingerprintRequestRecordLabelResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            FingerprintSetRecordLabelParams data3 =
                FingerprintSetRecordLabelParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setRecordLabel(
                    data3.recordPath,
                    data3.newLabel,
                    new FingerprintSetRecordLabelResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            FingerprintRemoveRecordParams data4 =
                FingerprintRemoveRecordParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .removeRecord(
                    data4.recordPath,
                    new FingerprintRemoveRecordResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            FingerprintEndCurrentAuthSessionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .endCurrentAuthSession(
                    new FingerprintEndCurrentAuthSessionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            FingerprintDestroyAllRecordsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .destroyAllRecords(
                    new FingerprintDestroyAllRecordsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 10:
            FingerprintRequestTypeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestType(
                    new FingerprintRequestTypeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FingerprintGetRecordsForUserParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String userId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintGetRecordsForUserParams(int version) {
      super(16, version);
    }

    public FingerprintGetRecordsForUserParams() {
      this(0);
    }

    public static FingerprintGetRecordsForUserParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintGetRecordsForUserParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintGetRecordsForUserParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintGetRecordsForUserParams result =
            new FingerprintGetRecordsForUserParams(elementsOrVersion);
        result.userId = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.userId, 8, false);
    }
  }

  static final class FingerprintGetRecordsForUserResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Map<String, String> records;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintGetRecordsForUserResponseParams(int version) {
      super(24, version);
    }

    public FingerprintGetRecordsForUserResponseParams() {
      this(0);
    }

    public static FingerprintGetRecordsForUserResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintGetRecordsForUserResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintGetRecordsForUserResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintGetRecordsForUserResponseParams result =
            new FingerprintGetRecordsForUserResponseParams(elementsOrVersion);
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
        String[] values0 = new String[si22.elementsOrVersion];
        for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
          values0[i22] = decoder22.readString((i22 * 8) + 8, false);
        }
        result.records = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.records.put(keys0[index0], values0[index0]);
        }
        result.success = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      if (this.records == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encoderForMap(8);
        int size0 = this.records.size();
        String[] keys0 = new String[size0];
        String[] values0 = new String[size0];
        int index0 = 0;
        for (Map.Entry<String, String> entry0 : this.records.entrySet()) {
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
      encoder0.encode(this.success, 16, 0);
    }
  }

  static class FingerprintGetRecordsForUserResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Fingerprint.GetRecordsForUser_Response mCallback;

    FingerprintGetRecordsForUserResponseParamsForwardToCallback(
        Fingerprint.GetRecordsForUser_Response callback) {
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
        FingerprintGetRecordsForUserResponseParams response =
            FingerprintGetRecordsForUserResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.records, response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FingerprintGetRecordsForUserResponseParamsProxyToResponder
      implements Fingerprint.GetRecordsForUser_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FingerprintGetRecordsForUserResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Map<String, String> records, boolean success) {
      FingerprintGetRecordsForUserResponseParams _response =
          new FingerprintGetRecordsForUserResponseParams();
      _response.records = records;
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FingerprintStartEnrollSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String label;
    public String userId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintStartEnrollSessionParams(int version) {
      super(24, version);
    }

    public FingerprintStartEnrollSessionParams() {
      this(0);
    }

    public static FingerprintStartEnrollSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintStartEnrollSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintStartEnrollSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintStartEnrollSessionParams result =
            new FingerprintStartEnrollSessionParams(elementsOrVersion);
        result.userId = decoder0.readString(8, false);
        result.label = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.userId, 8, false);
      encoder0.encode(this.label, 16, false);
    }
  }

  static final class FingerprintCancelCurrentEnrollSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintCancelCurrentEnrollSessionParams(int version) {
      super(8, version);
    }

    public FingerprintCancelCurrentEnrollSessionParams() {
      this(0);
    }

    public static FingerprintCancelCurrentEnrollSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintCancelCurrentEnrollSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintCancelCurrentEnrollSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintCancelCurrentEnrollSessionParams result =
            new FingerprintCancelCurrentEnrollSessionParams(elementsOrVersion);
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

  static final class FingerprintCancelCurrentEnrollSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintCancelCurrentEnrollSessionResponseParams(int version) {
      super(16, version);
    }

    public FingerprintCancelCurrentEnrollSessionResponseParams() {
      this(0);
    }

    public static FingerprintCancelCurrentEnrollSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintCancelCurrentEnrollSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintCancelCurrentEnrollSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintCancelCurrentEnrollSessionResponseParams result =
            new FingerprintCancelCurrentEnrollSessionResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FingerprintCancelCurrentEnrollSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Fingerprint.CancelCurrentEnrollSession_Response mCallback;

    FingerprintCancelCurrentEnrollSessionResponseParamsForwardToCallback(
        Fingerprint.CancelCurrentEnrollSession_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        FingerprintCancelCurrentEnrollSessionResponseParams response =
            FingerprintCancelCurrentEnrollSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FingerprintCancelCurrentEnrollSessionResponseParamsProxyToResponder
      implements Fingerprint.CancelCurrentEnrollSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FingerprintCancelCurrentEnrollSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FingerprintCancelCurrentEnrollSessionResponseParams _response =
          new FingerprintCancelCurrentEnrollSessionResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FingerprintRequestRecordLabelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String recordPath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintRequestRecordLabelParams(int version) {
      super(16, version);
    }

    public FingerprintRequestRecordLabelParams() {
      this(0);
    }

    public static FingerprintRequestRecordLabelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintRequestRecordLabelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintRequestRecordLabelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintRequestRecordLabelParams result =
            new FingerprintRequestRecordLabelParams(elementsOrVersion);
        result.recordPath = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.recordPath, 8, false);
    }
  }

  static final class FingerprintRequestRecordLabelResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String label;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintRequestRecordLabelResponseParams(int version) {
      super(16, version);
    }

    public FingerprintRequestRecordLabelResponseParams() {
      this(0);
    }

    public static FingerprintRequestRecordLabelResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintRequestRecordLabelResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintRequestRecordLabelResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintRequestRecordLabelResponseParams result =
            new FingerprintRequestRecordLabelResponseParams(elementsOrVersion);
        result.label = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
    }
  }

  static class FingerprintRequestRecordLabelResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Fingerprint.RequestRecordLabel_Response mCallback;

    FingerprintRequestRecordLabelResponseParamsForwardToCallback(
        Fingerprint.RequestRecordLabel_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        FingerprintRequestRecordLabelResponseParams response =
            FingerprintRequestRecordLabelResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.label);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FingerprintRequestRecordLabelResponseParamsProxyToResponder
      implements Fingerprint.RequestRecordLabel_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FingerprintRequestRecordLabelResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String label) {
      FingerprintRequestRecordLabelResponseParams _response =
          new FingerprintRequestRecordLabelResponseParams();
      _response.label = label;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FingerprintSetRecordLabelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String newLabel;
    public String recordPath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintSetRecordLabelParams(int version) {
      super(24, version);
    }

    public FingerprintSetRecordLabelParams() {
      this(0);
    }

    public static FingerprintSetRecordLabelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintSetRecordLabelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintSetRecordLabelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintSetRecordLabelParams result =
            new FingerprintSetRecordLabelParams(elementsOrVersion);
        result.recordPath = decoder0.readString(8, false);
        result.newLabel = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.recordPath, 8, false);
      encoder0.encode(this.newLabel, 16, false);
    }
  }

  static final class FingerprintSetRecordLabelResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintSetRecordLabelResponseParams(int version) {
      super(16, version);
    }

    public FingerprintSetRecordLabelResponseParams() {
      this(0);
    }

    public static FingerprintSetRecordLabelResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintSetRecordLabelResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintSetRecordLabelResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintSetRecordLabelResponseParams result =
            new FingerprintSetRecordLabelResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FingerprintSetRecordLabelResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Fingerprint.SetRecordLabel_Response mCallback;

    FingerprintSetRecordLabelResponseParamsForwardToCallback(
        Fingerprint.SetRecordLabel_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        FingerprintSetRecordLabelResponseParams response =
            FingerprintSetRecordLabelResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FingerprintSetRecordLabelResponseParamsProxyToResponder
      implements Fingerprint.SetRecordLabel_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FingerprintSetRecordLabelResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FingerprintSetRecordLabelResponseParams _response =
          new FingerprintSetRecordLabelResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FingerprintRemoveRecordParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String recordPath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintRemoveRecordParams(int version) {
      super(16, version);
    }

    public FingerprintRemoveRecordParams() {
      this(0);
    }

    public static FingerprintRemoveRecordParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintRemoveRecordParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintRemoveRecordParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintRemoveRecordParams result = new FingerprintRemoveRecordParams(elementsOrVersion);
        result.recordPath = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.recordPath, 8, false);
    }
  }

  static final class FingerprintRemoveRecordResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintRemoveRecordResponseParams(int version) {
      super(16, version);
    }

    public FingerprintRemoveRecordResponseParams() {
      this(0);
    }

    public static FingerprintRemoveRecordResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintRemoveRecordResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintRemoveRecordResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintRemoveRecordResponseParams result =
            new FingerprintRemoveRecordResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FingerprintRemoveRecordResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Fingerprint.RemoveRecord_Response mCallback;

    FingerprintRemoveRecordResponseParamsForwardToCallback(
        Fingerprint.RemoveRecord_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        FingerprintRemoveRecordResponseParams response =
            FingerprintRemoveRecordResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FingerprintRemoveRecordResponseParamsProxyToResponder
      implements Fingerprint.RemoveRecord_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FingerprintRemoveRecordResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FingerprintRemoveRecordResponseParams _response = new FingerprintRemoveRecordResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FingerprintStartAuthSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintStartAuthSessionParams(int version) {
      super(8, version);
    }

    public FingerprintStartAuthSessionParams() {
      this(0);
    }

    public static FingerprintStartAuthSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintStartAuthSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintStartAuthSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintStartAuthSessionParams result =
            new FingerprintStartAuthSessionParams(elementsOrVersion);
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

  static final class FingerprintEndCurrentAuthSessionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintEndCurrentAuthSessionParams(int version) {
      super(8, version);
    }

    public FingerprintEndCurrentAuthSessionParams() {
      this(0);
    }

    public static FingerprintEndCurrentAuthSessionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintEndCurrentAuthSessionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintEndCurrentAuthSessionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintEndCurrentAuthSessionParams result =
            new FingerprintEndCurrentAuthSessionParams(elementsOrVersion);
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

  static final class FingerprintEndCurrentAuthSessionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintEndCurrentAuthSessionResponseParams(int version) {
      super(16, version);
    }

    public FingerprintEndCurrentAuthSessionResponseParams() {
      this(0);
    }

    public static FingerprintEndCurrentAuthSessionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintEndCurrentAuthSessionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintEndCurrentAuthSessionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintEndCurrentAuthSessionResponseParams result =
            new FingerprintEndCurrentAuthSessionResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FingerprintEndCurrentAuthSessionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Fingerprint.EndCurrentAuthSession_Response mCallback;

    FingerprintEndCurrentAuthSessionResponseParamsForwardToCallback(
        Fingerprint.EndCurrentAuthSession_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 2)) {
          return false;
        }
        FingerprintEndCurrentAuthSessionResponseParams response =
            FingerprintEndCurrentAuthSessionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FingerprintEndCurrentAuthSessionResponseParamsProxyToResponder
      implements Fingerprint.EndCurrentAuthSession_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FingerprintEndCurrentAuthSessionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FingerprintEndCurrentAuthSessionResponseParams _response =
          new FingerprintEndCurrentAuthSessionResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FingerprintDestroyAllRecordsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintDestroyAllRecordsParams(int version) {
      super(8, version);
    }

    public FingerprintDestroyAllRecordsParams() {
      this(0);
    }

    public static FingerprintDestroyAllRecordsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintDestroyAllRecordsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintDestroyAllRecordsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintDestroyAllRecordsParams result =
            new FingerprintDestroyAllRecordsParams(elementsOrVersion);
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

  static final class FingerprintDestroyAllRecordsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintDestroyAllRecordsResponseParams(int version) {
      super(16, version);
    }

    public FingerprintDestroyAllRecordsResponseParams() {
      this(0);
    }

    public static FingerprintDestroyAllRecordsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintDestroyAllRecordsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintDestroyAllRecordsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintDestroyAllRecordsResponseParams result =
            new FingerprintDestroyAllRecordsResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FingerprintDestroyAllRecordsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Fingerprint.DestroyAllRecords_Response mCallback;

    FingerprintDestroyAllRecordsResponseParamsForwardToCallback(
        Fingerprint.DestroyAllRecords_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        FingerprintDestroyAllRecordsResponseParams response =
            FingerprintDestroyAllRecordsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FingerprintDestroyAllRecordsResponseParamsProxyToResponder
      implements Fingerprint.DestroyAllRecords_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FingerprintDestroyAllRecordsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FingerprintDestroyAllRecordsResponseParams _response =
          new FingerprintDestroyAllRecordsResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FingerprintAddFingerprintObserverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FingerprintObserver observer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintAddFingerprintObserverParams(int version) {
      super(16, version);
    }

    public FingerprintAddFingerprintObserverParams() {
      this(0);
    }

    public static FingerprintAddFingerprintObserverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintAddFingerprintObserverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintAddFingerprintObserverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintAddFingerprintObserverParams result =
            new FingerprintAddFingerprintObserverParams(elementsOrVersion);
        result.observer =
            (FingerprintObserver)
                decoder0.readServiceInterface(8, false, FingerprintObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.observer, 8, false, FingerprintObserver.MANAGER);
    }
  }

  static final class FingerprintRequestTypeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintRequestTypeParams(int version) {
      super(8, version);
    }

    public FingerprintRequestTypeParams() {
      this(0);
    }

    public static FingerprintRequestTypeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintRequestTypeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintRequestTypeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintRequestTypeParams result = new FingerprintRequestTypeParams(elementsOrVersion);
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

  static final class FingerprintRequestTypeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FingerprintRequestTypeResponseParams(int version) {
      super(16, version);
    }

    public FingerprintRequestTypeResponseParams() {
      this(0);
    }

    public static FingerprintRequestTypeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FingerprintRequestTypeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FingerprintRequestTypeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FingerprintRequestTypeResponseParams result =
            new FingerprintRequestTypeResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        BiometricType.validate(readInt);
        result.type = BiometricType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static class FingerprintRequestTypeResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Fingerprint.RequestType_Response mCallback;

    FingerprintRequestTypeResponseParamsForwardToCallback(
        Fingerprint.RequestType_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(10, 2)) {
          return false;
        }
        FingerprintRequestTypeResponseParams response =
            FingerprintRequestTypeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.type);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FingerprintRequestTypeResponseParamsProxyToResponder
      implements Fingerprint.RequestType_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FingerprintRequestTypeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int type) {
      FingerprintRequestTypeResponseParams _response = new FingerprintRequestTypeResponseParams();
      _response.type = type;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
