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

class NotificationService_Internal {
  private static final int CLOSE_NON_PERSISTENT_NOTIFICATION_ORDINAL = 2;
  private static final int CLOSE_PERSISTENT_NOTIFICATION_ORDINAL = 4;
  private static final int DISPLAY_NON_PERSISTENT_NOTIFICATION_ORDINAL = 1;
  private static final int DISPLAY_PERSISTENT_NOTIFICATION_ORDINAL = 3;
  private static final int GET_NOTIFICATIONS_ORDINAL = 5;
  private static final int GET_PERMISSION_STATUS_ORDINAL = 0;
  public static final Interface.Manager<NotificationService, NotificationService.Proxy> MANAGER =
      new Interface.Manager<NotificationService, NotificationService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.NotificationService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public NotificationService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, NotificationService impl) {
          return new Stub(core, impl);
        }

        @Override
        public NotificationService[] buildArray(int size) {
          return new NotificationService[size];
        }
      };

  NotificationService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements NotificationService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getPermissionStatus(GetPermissionStatus_Response callback) {
      NotificationServiceGetPermissionStatusParams _message =
          new NotificationServiceGetPermissionStatusParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new NotificationServiceGetPermissionStatusResponseParamsForwardToCallback(callback));
    }

    @Override
    public void displayNonPersistentNotification(
        String token,
        NotificationData notificationData,
        NotificationResources notificationResources,
        NonPersistentNotificationListener eventListener) {
      NotificationServiceDisplayNonPersistentNotificationParams _message =
          new NotificationServiceDisplayNonPersistentNotificationParams();
      _message.token = token;
      _message.notificationData = notificationData;
      _message.notificationResources = notificationResources;
      _message.eventListener = eventListener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void closeNonPersistentNotification(String token) {
      NotificationServiceCloseNonPersistentNotificationParams _message =
          new NotificationServiceCloseNonPersistentNotificationParams();
      _message.token = token;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void displayPersistentNotification(
        long serviceWorkerRegistrationId,
        NotificationData notificationData,
        NotificationResources notificationResources,
        DisplayPersistentNotification_Response callback) {
      NotificationServiceDisplayPersistentNotificationParams _message =
          new NotificationServiceDisplayPersistentNotificationParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.notificationData = notificationData;
      _message.notificationResources = notificationResources;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new NotificationServiceDisplayPersistentNotificationResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void closePersistentNotification(String notificationId) {
      NotificationServiceClosePersistentNotificationParams _message =
          new NotificationServiceClosePersistentNotificationParams();
      _message.notificationId = notificationId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void getNotifications(
        long serviceWorkerRegistrationId,
        String filterTag,
        boolean includeTriggered,
        GetNotifications_Response callback) {
      NotificationServiceGetNotificationsParams _message =
          new NotificationServiceGetNotificationsParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.filterTag = filterTag;
      _message.includeTriggered = includeTriggered;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new NotificationServiceGetNotificationsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<NotificationService> {
    Stub(Core core, NotificationService impl) {
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
                NotificationService_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 3:
          default:
            return false;
          case 1:
            NotificationServiceDisplayNonPersistentNotificationParams data =
                NotificationServiceDisplayNonPersistentNotificationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .displayNonPersistentNotification(
                    data.token,
                    data.notificationData,
                    data.notificationResources,
                    data.eventListener);
            return true;
          case 2:
            getImpl()
                .closeNonPersistentNotification(
                    NotificationServiceCloseNonPersistentNotificationParams.deserialize(
                            messageWithHeader.getPayload())
                        .token);
            return true;
          case 4:
            getImpl()
                .closePersistentNotification(
                    NotificationServiceClosePersistentNotificationParams.deserialize(
                            messageWithHeader.getPayload())
                        .notificationId);
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
                getCore(), NotificationService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            NotificationServiceGetPermissionStatusParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getPermissionStatus(
                    new NotificationServiceGetPermissionStatusResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          case 2:
          case 4:
          default:
            return false;
          case 3:
            NotificationServiceDisplayPersistentNotificationParams data =
                NotificationServiceDisplayPersistentNotificationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .displayPersistentNotification(
                    data.serviceWorkerRegistrationId,
                    data.notificationData,
                    data.notificationResources,
                    new NotificationServiceDisplayPersistentNotificationResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            NotificationServiceGetNotificationsParams data2 =
                NotificationServiceGetNotificationsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getNotifications(
                    data2.serviceWorkerRegistrationId,
                    data2.filterTag,
                    data2.includeTriggered,
                    new NotificationServiceGetNotificationsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NotificationServiceGetPermissionStatusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceGetPermissionStatusParams(int version) {
      super(8, version);
    }

    public NotificationServiceGetPermissionStatusParams() {
      this(0);
    }

    public static NotificationServiceGetPermissionStatusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceGetPermissionStatusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceGetPermissionStatusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceGetPermissionStatusParams result =
            new NotificationServiceGetPermissionStatusParams(elementsOrVersion);
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

  static final class NotificationServiceGetPermissionStatusResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceGetPermissionStatusResponseParams(int version) {
      super(16, version);
    }

    public NotificationServiceGetPermissionStatusResponseParams() {
      this(0);
    }

    public static NotificationServiceGetPermissionStatusResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceGetPermissionStatusResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceGetPermissionStatusResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceGetPermissionStatusResponseParams result =
            new NotificationServiceGetPermissionStatusResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PermissionStatus.validate(readInt);
        result.status = PermissionStatus.toKnownValue(result.status);
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

  static class NotificationServiceGetPermissionStatusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NotificationService.GetPermissionStatus_Response mCallback;

    NotificationServiceGetPermissionStatusResponseParamsForwardToCallback(
        NotificationService.GetPermissionStatus_Response callback) {
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
        NotificationServiceGetPermissionStatusResponseParams response =
            NotificationServiceGetPermissionStatusResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NotificationServiceGetPermissionStatusResponseParamsProxyToResponder
      implements NotificationService.GetPermissionStatus_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NotificationServiceGetPermissionStatusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      NotificationServiceGetPermissionStatusResponseParams _response =
          new NotificationServiceGetPermissionStatusResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NotificationServiceDisplayNonPersistentNotificationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public NonPersistentNotificationListener eventListener;
    public NotificationData notificationData;
    public NotificationResources notificationResources;
    public String token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceDisplayNonPersistentNotificationParams(int version) {
      super(40, version);
    }

    public NotificationServiceDisplayNonPersistentNotificationParams() {
      this(0);
    }

    public static NotificationServiceDisplayNonPersistentNotificationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceDisplayNonPersistentNotificationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceDisplayNonPersistentNotificationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceDisplayNonPersistentNotificationParams result =
            new NotificationServiceDisplayNonPersistentNotificationParams(elementsOrVersion);
        result.token = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.notificationData = NotificationData.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.notificationResources = NotificationResources.decode(decoder12);
        result.eventListener =
            (NonPersistentNotificationListener)
                decoder0.readServiceInterface(32, false, NonPersistentNotificationListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.token, 8, false);
      encoder0.encode((Struct) this.notificationData, 16, false);
      encoder0.encode((Struct) this.notificationResources, 24, false);
      encoder0.encode(this.eventListener, 32, false, NonPersistentNotificationListener.MANAGER);
    }
  }

  static final class NotificationServiceCloseNonPersistentNotificationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceCloseNonPersistentNotificationParams(int version) {
      super(16, version);
    }

    public NotificationServiceCloseNonPersistentNotificationParams() {
      this(0);
    }

    public static NotificationServiceCloseNonPersistentNotificationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceCloseNonPersistentNotificationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceCloseNonPersistentNotificationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceCloseNonPersistentNotificationParams result =
            new NotificationServiceCloseNonPersistentNotificationParams(elementsOrVersion);
        result.token = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.token, 8, false);
    }
  }

  static final class NotificationServiceDisplayPersistentNotificationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public NotificationData notificationData;
    public NotificationResources notificationResources;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceDisplayPersistentNotificationParams(int version) {
      super(32, version);
    }

    public NotificationServiceDisplayPersistentNotificationParams() {
      this(0);
    }

    public static NotificationServiceDisplayPersistentNotificationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceDisplayPersistentNotificationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceDisplayPersistentNotificationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceDisplayPersistentNotificationParams result =
            new NotificationServiceDisplayPersistentNotificationParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.notificationData = NotificationData.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.notificationResources = NotificationResources.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      encoder0.encode((Struct) this.notificationData, 16, false);
      encoder0.encode((Struct) this.notificationResources, 24, false);
    }
  }

  static final class NotificationServiceDisplayPersistentNotificationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceDisplayPersistentNotificationResponseParams(int version) {
      super(16, version);
    }

    public NotificationServiceDisplayPersistentNotificationResponseParams() {
      this(0);
    }

    public static NotificationServiceDisplayPersistentNotificationResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceDisplayPersistentNotificationResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceDisplayPersistentNotificationResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceDisplayPersistentNotificationResponseParams result =
            new NotificationServiceDisplayPersistentNotificationResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        PersistentNotificationError.validate(readInt);
        result.error = PersistentNotificationError.toKnownValue(result.error);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
    }
  }

  static class NotificationServiceDisplayPersistentNotificationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NotificationService.DisplayPersistentNotification_Response mCallback;

    NotificationServiceDisplayPersistentNotificationResponseParamsForwardToCallback(
        NotificationService.DisplayPersistentNotification_Response callback) {
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
        NotificationServiceDisplayPersistentNotificationResponseParams response =
            NotificationServiceDisplayPersistentNotificationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NotificationServiceDisplayPersistentNotificationResponseParamsProxyToResponder
      implements NotificationService.DisplayPersistentNotification_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NotificationServiceDisplayPersistentNotificationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error) {
      NotificationServiceDisplayPersistentNotificationResponseParams _response =
          new NotificationServiceDisplayPersistentNotificationResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NotificationServiceClosePersistentNotificationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String notificationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceClosePersistentNotificationParams(int version) {
      super(16, version);
    }

    public NotificationServiceClosePersistentNotificationParams() {
      this(0);
    }

    public static NotificationServiceClosePersistentNotificationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceClosePersistentNotificationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceClosePersistentNotificationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceClosePersistentNotificationParams result =
            new NotificationServiceClosePersistentNotificationParams(elementsOrVersion);
        result.notificationId = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.notificationId, 8, false);
    }
  }

  static final class NotificationServiceGetNotificationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String filterTag;
    public boolean includeTriggered;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceGetNotificationsParams(int version) {
      super(32, version);
    }

    public NotificationServiceGetNotificationsParams() {
      this(0);
    }

    public static NotificationServiceGetNotificationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceGetNotificationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceGetNotificationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceGetNotificationsParams result =
            new NotificationServiceGetNotificationsParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        result.filterTag = decoder0.readString(16, false);
        result.includeTriggered = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      encoder0.encode(this.filterTag, 16, false);
      encoder0.encode(this.includeTriggered, 24, 0);
    }
  }

  static final class NotificationServiceGetNotificationsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public NotificationData[] notificationDatas;
    public String[] notificationIds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NotificationServiceGetNotificationsResponseParams(int version) {
      super(24, version);
    }

    public NotificationServiceGetNotificationsResponseParams() {
      this(0);
    }

    public static NotificationServiceGetNotificationsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NotificationServiceGetNotificationsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationServiceGetNotificationsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NotificationServiceGetNotificationsResponseParams result =
            new NotificationServiceGetNotificationsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.notificationIds = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.notificationIds[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        Decoder decoder12 = decoder0.readPointer(16, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.notificationDatas = new NotificationData[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder2 = decoder12.readPointer((i12 * 8) + 8, false);
          result.notificationDatas[i12] = NotificationData.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.notificationIds;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          String[] strArr2 = this.notificationIds;
          if (i0 >= strArr2.length) {
            break;
          }
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      NotificationData[] notificationDataArr = this.notificationDatas;
      if (notificationDataArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder12 = encoder0.encodePointerArray(notificationDataArr.length, 16, -1);
      int i02 = 0;
      while (true) {
        NotificationData[] notificationDataArr2 = this.notificationDatas;
        if (i02 < notificationDataArr2.length) {
          encoder12.encode((Struct) notificationDataArr2[i02], (i02 * 8) + 8, false);
          i02++;
        } else {
          return;
        }
      }
    }
  }

  static class NotificationServiceGetNotificationsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NotificationService.GetNotifications_Response mCallback;

    NotificationServiceGetNotificationsResponseParamsForwardToCallback(
        NotificationService.GetNotifications_Response callback) {
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
        NotificationServiceGetNotificationsResponseParams response =
            NotificationServiceGetNotificationsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.notificationIds, response.notificationDatas);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NotificationServiceGetNotificationsResponseParamsProxyToResponder
      implements NotificationService.GetNotifications_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NotificationServiceGetNotificationsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String[] notificationIds, NotificationData[] notificationDatas) {
      NotificationServiceGetNotificationsResponseParams _response =
          new NotificationServiceGetNotificationsResponseParams();
      _response.notificationIds = notificationIds;
      _response.notificationDatas = notificationDatas;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
