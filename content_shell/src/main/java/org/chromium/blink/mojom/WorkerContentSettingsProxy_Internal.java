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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class WorkerContentSettingsProxy_Internal {
  private static final int ALLOW_CACHE_STORAGE_ORDINAL = 1;
  private static final int ALLOW_INDEXED_DB_ORDINAL = 0;
  private static final int ALLOW_WEB_LOCKS_ORDINAL = 2;
  public static final Interface.Manager<
          WorkerContentSettingsProxy, WorkerContentSettingsProxy.Proxy>
      MANAGER =
          new Interface.Manager<WorkerContentSettingsProxy, WorkerContentSettingsProxy.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.WorkerContentSettingsProxy";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public WorkerContentSettingsProxy.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, WorkerContentSettingsProxy impl) {
              return new Stub(core, impl);
            }

            @Override
            public WorkerContentSettingsProxy[] buildArray(int size) {
              return new WorkerContentSettingsProxy[size];
            }
          };
  private static final int REQUEST_FILE_SYSTEM_ACCESS_SYNC_ORDINAL = 3;

  WorkerContentSettingsProxy_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WorkerContentSettingsProxy.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void allowIndexedDb(AllowIndexedDb_Response callback) {
      WorkerContentSettingsProxyAllowIndexedDbParams _message =
          new WorkerContentSettingsProxyAllowIndexedDbParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WorkerContentSettingsProxyAllowIndexedDbResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void allowCacheStorage(AllowCacheStorage_Response callback) {
      WorkerContentSettingsProxyAllowCacheStorageParams _message =
          new WorkerContentSettingsProxyAllowCacheStorageParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new WorkerContentSettingsProxyAllowCacheStorageResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void allowWebLocks(AllowWebLocks_Response callback) {
      WorkerContentSettingsProxyAllowWebLocksParams _message =
          new WorkerContentSettingsProxyAllowWebLocksParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new WorkerContentSettingsProxyAllowWebLocksResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestFileSystemAccessSync(RequestFileSystemAccessSync_Response callback) {
      WorkerContentSettingsProxyRequestFileSystemAccessSyncParams _message =
          new WorkerContentSettingsProxyRequestFileSystemAccessSyncParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<WorkerContentSettingsProxy> {
    Stub(Core core, WorkerContentSettingsProxy impl) {
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
                WorkerContentSettingsProxy_Internal.MANAGER, messageWithHeader);
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
                WorkerContentSettingsProxy_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            WorkerContentSettingsProxyAllowIndexedDbParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .allowIndexedDb(
                    new WorkerContentSettingsProxyAllowIndexedDbResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            WorkerContentSettingsProxyAllowCacheStorageParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .allowCacheStorage(
                    new WorkerContentSettingsProxyAllowCacheStorageResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            WorkerContentSettingsProxyAllowWebLocksParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .allowWebLocks(
                    new WorkerContentSettingsProxyAllowWebLocksResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            WorkerContentSettingsProxyRequestFileSystemAccessSyncParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .requestFileSystemAccessSync(
                    new WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsProxyToResponder(
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

  static final class WorkerContentSettingsProxyAllowIndexedDbParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WorkerContentSettingsProxyAllowIndexedDbParams(int version) {
      super(8, version);
    }

    public WorkerContentSettingsProxyAllowIndexedDbParams() {
      this(0);
    }

    public static WorkerContentSettingsProxyAllowIndexedDbParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WorkerContentSettingsProxyAllowIndexedDbParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerContentSettingsProxyAllowIndexedDbParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkerContentSettingsProxyAllowIndexedDbParams result =
            new WorkerContentSettingsProxyAllowIndexedDbParams(elementsOrVersion);
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

  static final class WorkerContentSettingsProxyAllowIndexedDbResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WorkerContentSettingsProxyAllowIndexedDbResponseParams(int version) {
      super(16, version);
    }

    public WorkerContentSettingsProxyAllowIndexedDbResponseParams() {
      this(0);
    }

    public static WorkerContentSettingsProxyAllowIndexedDbResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WorkerContentSettingsProxyAllowIndexedDbResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerContentSettingsProxyAllowIndexedDbResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkerContentSettingsProxyAllowIndexedDbResponseParams result =
            new WorkerContentSettingsProxyAllowIndexedDbResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class WorkerContentSettingsProxyAllowIndexedDbResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WorkerContentSettingsProxy.AllowIndexedDb_Response mCallback;

    WorkerContentSettingsProxyAllowIndexedDbResponseParamsForwardToCallback(
        WorkerContentSettingsProxy.AllowIndexedDb_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 6)) {
          return false;
        }
        WorkerContentSettingsProxyAllowIndexedDbResponseParams response =
            WorkerContentSettingsProxyAllowIndexedDbResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WorkerContentSettingsProxyAllowIndexedDbResponseParamsProxyToResponder
      implements WorkerContentSettingsProxy.AllowIndexedDb_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WorkerContentSettingsProxyAllowIndexedDbResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      WorkerContentSettingsProxyAllowIndexedDbResponseParams _response =
          new WorkerContentSettingsProxyAllowIndexedDbResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WorkerContentSettingsProxyAllowCacheStorageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WorkerContentSettingsProxyAllowCacheStorageParams(int version) {
      super(8, version);
    }

    public WorkerContentSettingsProxyAllowCacheStorageParams() {
      this(0);
    }

    public static WorkerContentSettingsProxyAllowCacheStorageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WorkerContentSettingsProxyAllowCacheStorageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerContentSettingsProxyAllowCacheStorageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkerContentSettingsProxyAllowCacheStorageParams result =
            new WorkerContentSettingsProxyAllowCacheStorageParams(elementsOrVersion);
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

  static final class WorkerContentSettingsProxyAllowCacheStorageResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WorkerContentSettingsProxyAllowCacheStorageResponseParams(int version) {
      super(16, version);
    }

    public WorkerContentSettingsProxyAllowCacheStorageResponseParams() {
      this(0);
    }

    public static WorkerContentSettingsProxyAllowCacheStorageResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WorkerContentSettingsProxyAllowCacheStorageResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerContentSettingsProxyAllowCacheStorageResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkerContentSettingsProxyAllowCacheStorageResponseParams result =
            new WorkerContentSettingsProxyAllowCacheStorageResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class WorkerContentSettingsProxyAllowCacheStorageResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WorkerContentSettingsProxy.AllowCacheStorage_Response mCallback;

    WorkerContentSettingsProxyAllowCacheStorageResponseParamsForwardToCallback(
        WorkerContentSettingsProxy.AllowCacheStorage_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 6)) {
          return false;
        }
        WorkerContentSettingsProxyAllowCacheStorageResponseParams response =
            WorkerContentSettingsProxyAllowCacheStorageResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WorkerContentSettingsProxyAllowCacheStorageResponseParamsProxyToResponder
      implements WorkerContentSettingsProxy.AllowCacheStorage_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WorkerContentSettingsProxyAllowCacheStorageResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      WorkerContentSettingsProxyAllowCacheStorageResponseParams _response =
          new WorkerContentSettingsProxyAllowCacheStorageResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WorkerContentSettingsProxyAllowWebLocksParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WorkerContentSettingsProxyAllowWebLocksParams(int version) {
      super(8, version);
    }

    public WorkerContentSettingsProxyAllowWebLocksParams() {
      this(0);
    }

    public static WorkerContentSettingsProxyAllowWebLocksParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WorkerContentSettingsProxyAllowWebLocksParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerContentSettingsProxyAllowWebLocksParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkerContentSettingsProxyAllowWebLocksParams result =
            new WorkerContentSettingsProxyAllowWebLocksParams(elementsOrVersion);
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

  static final class WorkerContentSettingsProxyAllowWebLocksResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WorkerContentSettingsProxyAllowWebLocksResponseParams(int version) {
      super(16, version);
    }

    public WorkerContentSettingsProxyAllowWebLocksResponseParams() {
      this(0);
    }

    public static WorkerContentSettingsProxyAllowWebLocksResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WorkerContentSettingsProxyAllowWebLocksResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerContentSettingsProxyAllowWebLocksResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkerContentSettingsProxyAllowWebLocksResponseParams result =
            new WorkerContentSettingsProxyAllowWebLocksResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class WorkerContentSettingsProxyAllowWebLocksResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WorkerContentSettingsProxy.AllowWebLocks_Response mCallback;

    WorkerContentSettingsProxyAllowWebLocksResponseParamsForwardToCallback(
        WorkerContentSettingsProxy.AllowWebLocks_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 6)) {
          return false;
        }
        WorkerContentSettingsProxyAllowWebLocksResponseParams response =
            WorkerContentSettingsProxyAllowWebLocksResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WorkerContentSettingsProxyAllowWebLocksResponseParamsProxyToResponder
      implements WorkerContentSettingsProxy.AllowWebLocks_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WorkerContentSettingsProxyAllowWebLocksResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      WorkerContentSettingsProxyAllowWebLocksResponseParams _response =
          new WorkerContentSettingsProxyAllowWebLocksResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WorkerContentSettingsProxyRequestFileSystemAccessSyncParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WorkerContentSettingsProxyRequestFileSystemAccessSyncParams(int version) {
      super(8, version);
    }

    public WorkerContentSettingsProxyRequestFileSystemAccessSyncParams() {
      this(0);
    }

    public static WorkerContentSettingsProxyRequestFileSystemAccessSyncParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WorkerContentSettingsProxyRequestFileSystemAccessSyncParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerContentSettingsProxyRequestFileSystemAccessSyncParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkerContentSettingsProxyRequestFileSystemAccessSyncParams result =
            new WorkerContentSettingsProxyRequestFileSystemAccessSyncParams(elementsOrVersion);
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

  static final class WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams(int version) {
      super(16, version);
    }

    public WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams() {
      this(0);
    }

    public static WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams result =
            new WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams(
                elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WorkerContentSettingsProxy.RequestFileSystemAccessSync_Response mCallback;

    WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsForwardToCallback(
        WorkerContentSettingsProxy.RequestFileSystemAccessSync_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 6)) {
          return false;
        }
        WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams response =
            WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsProxyToResponder
      implements WorkerContentSettingsProxy.RequestFileSystemAccessSync_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams _response =
          new WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
