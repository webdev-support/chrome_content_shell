package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.Value;
import org.chromium.network.mojom.CookieChangeInfo;
import org.chromium.payments.mojom.CanMakePaymentEventData;
import org.chromium.payments.mojom.PaymentHandlerResponseCallback;
import org.chromium.payments.mojom.PaymentRequestEventData;

class ServiceWorker_Internal {
  private static final int ADD_KEEP_ALIVE_ORDINAL = 22;
  private static final int ADD_MESSAGE_TO_CONSOLE_ORDINAL = 24;
  private static final int CLEAR_KEEP_ALIVE_ORDINAL = 23;
  private static final int DISPATCH_ABORT_PAYMENT_EVENT_ORDINAL = 15;
  private static final int DISPATCH_ACTIVATE_EVENT_ORDINAL = 2;
  private static final int DISPATCH_BACKGROUND_FETCH_ABORT_EVENT_ORDINAL = 3;
  private static final int DISPATCH_BACKGROUND_FETCH_CLICK_EVENT_ORDINAL = 4;
  private static final int DISPATCH_BACKGROUND_FETCH_FAIL_EVENT_ORDINAL = 5;
  private static final int DISPATCH_BACKGROUND_FETCH_SUCCESS_EVENT_ORDINAL = 6;
  private static final int DISPATCH_CAN_MAKE_PAYMENT_EVENT_ORDINAL = 16;
  private static final int DISPATCH_CONTENT_DELETE_EVENT_ORDINAL = 19;
  private static final int DISPATCH_COOKIE_CHANGE_EVENT_ORDINAL = 7;
  private static final int DISPATCH_EXTENDABLE_MESSAGE_EVENT_ORDINAL = 18;
  private static final int DISPATCH_FETCH_EVENT_FOR_MAIN_RESOURCE_ORDINAL = 8;
  private static final int DISPATCH_INSTALL_EVENT_ORDINAL = 1;
  private static final int DISPATCH_NOTIFICATION_CLICK_EVENT_ORDINAL = 9;
  private static final int DISPATCH_NOTIFICATION_CLOSE_EVENT_ORDINAL = 10;
  private static final int DISPATCH_PAYMENT_REQUEST_EVENT_ORDINAL = 17;
  private static final int DISPATCH_PERIODIC_SYNC_EVENT_ORDINAL = 14;
  private static final int DISPATCH_PUSH_EVENT_ORDINAL = 11;
  private static final int DISPATCH_PUSH_SUBSCRIPTION_CHANGE_EVENT_ORDINAL = 12;
  private static final int DISPATCH_SYNC_EVENT_ORDINAL = 13;
  private static final int EXECUTE_SCRIPT_FOR_TEST_ORDINAL = 25;
  private static final int INITIALIZE_GLOBAL_SCOPE_ORDINAL = 0;
  public static final Interface.Manager<ServiceWorker, ServiceWorker.Proxy> MANAGER =
      new Interface.Manager<ServiceWorker, ServiceWorker.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ServiceWorker";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ServiceWorker.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ServiceWorker impl) {
          return new Stub(core, impl);
        }

        @Override
        public ServiceWorker[] buildArray(int size) {
          return new ServiceWorker[size];
        }
      };
  private static final int PING_ORDINAL = 20;
  private static final int SET_IDLE_DELAY_ORDINAL = 21;

  ServiceWorker_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements ServiceWorker.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void initializeGlobalScope(
        AssociatedInterfaceNotSupported serviceWorkerHost,
        AssociatedInterfaceNotSupported associatedInterfacesToBrowser,
        AssociatedInterfaceRequestNotSupported associatedInterfacesFromBrowser,
        ServiceWorkerRegistrationObjectInfo registrationInfo,
        ServiceWorkerObjectInfo serviceWorkerInfo,
        int fetchHandlerExistence,
        InterfaceRequest<ReportingObserver> reportingObserverReceiver,
        int ancestorFrameType,
        StorageKey storageKey) {
      ServiceWorkerInitializeGlobalScopeParams _message =
          new ServiceWorkerInitializeGlobalScopeParams();
      _message.serviceWorkerHost = serviceWorkerHost;
      _message.associatedInterfacesToBrowser = associatedInterfacesToBrowser;
      _message.associatedInterfacesFromBrowser = associatedInterfacesFromBrowser;
      _message.registrationInfo = registrationInfo;
      _message.serviceWorkerInfo = serviceWorkerInfo;
      _message.fetchHandlerExistence = fetchHandlerExistence;
      _message.reportingObserverReceiver = reportingObserverReceiver;
      _message.ancestorFrameType = ancestorFrameType;
      _message.storageKey = storageKey;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void dispatchInstallEvent(DispatchInstallEvent_Response callback) {
      ServiceWorkerDispatchInstallEventParams _message =
          new ServiceWorkerDispatchInstallEventParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ServiceWorkerDispatchInstallEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dispatchActivateEvent(DispatchActivateEvent_Response callback) {
      ServiceWorkerDispatchActivateEventParams _message =
          new ServiceWorkerDispatchActivateEventParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ServiceWorkerDispatchActivateEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dispatchBackgroundFetchAbortEvent(
        BackgroundFetchRegistration registration,
        DispatchBackgroundFetchAbortEvent_Response callback) {
      ServiceWorkerDispatchBackgroundFetchAbortEventParams _message =
          new ServiceWorkerDispatchBackgroundFetchAbortEventParams();
      _message.registration = registration;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchBackgroundFetchClickEvent(
        BackgroundFetchRegistration registration,
        DispatchBackgroundFetchClickEvent_Response callback) {
      ServiceWorkerDispatchBackgroundFetchClickEventParams _message =
          new ServiceWorkerDispatchBackgroundFetchClickEventParams();
      _message.registration = registration;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchBackgroundFetchFailEvent(
        BackgroundFetchRegistration registration,
        DispatchBackgroundFetchFailEvent_Response callback) {
      ServiceWorkerDispatchBackgroundFetchFailEventParams _message =
          new ServiceWorkerDispatchBackgroundFetchFailEventParams();
      _message.registration = registration;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchBackgroundFetchSuccessEvent(
        BackgroundFetchRegistration registration,
        DispatchBackgroundFetchSuccessEvent_Response callback) {
      ServiceWorkerDispatchBackgroundFetchSuccessEventParams _message =
          new ServiceWorkerDispatchBackgroundFetchSuccessEventParams();
      _message.registration = registration;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchCookieChangeEvent(
        CookieChangeInfo change, DispatchCookieChangeEvent_Response callback) {
      ServiceWorkerDispatchCookieChangeEventParams _message =
          new ServiceWorkerDispatchCookieChangeEventParams();
      _message.change = change;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new ServiceWorkerDispatchCookieChangeEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dispatchFetchEventForMainResource(
        DispatchFetchEventParams params,
        ServiceWorkerFetchResponseCallback responseCallback,
        DispatchFetchEventForMainResource_Response callback) {
      ServiceWorkerDispatchFetchEventForMainResourceParams _message =
          new ServiceWorkerDispatchFetchEventForMainResourceParams();
      _message.params = params;
      _message.responseCallback = responseCallback;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new ServiceWorkerDispatchFetchEventForMainResourceResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchNotificationClickEvent(
        String notificationId,
        NotificationData notificationData,
        int actionIndex,
        String16 reply,
        DispatchNotificationClickEvent_Response callback) {
      ServiceWorkerDispatchNotificationClickEventParams _message =
          new ServiceWorkerDispatchNotificationClickEventParams();
      _message.notificationId = notificationId;
      _message.notificationData = notificationData;
      _message.actionIndex = actionIndex;
      _message.reply = reply;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new ServiceWorkerDispatchNotificationClickEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchNotificationCloseEvent(
        String notificationId,
        NotificationData notificationData,
        DispatchNotificationCloseEvent_Response callback) {
      ServiceWorkerDispatchNotificationCloseEventParams _message =
          new ServiceWorkerDispatchNotificationCloseEventParams();
      _message.notificationId = notificationId;
      _message.notificationData = notificationData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new ServiceWorkerDispatchNotificationCloseEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchPushEvent(String payload, DispatchPushEvent_Response callback) {
      ServiceWorkerDispatchPushEventParams _message = new ServiceWorkerDispatchPushEventParams();
      _message.payload = payload;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new ServiceWorkerDispatchPushEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dispatchPushSubscriptionChangeEvent(
        PushSubscription oldSubscription,
        PushSubscription newSubscription,
        DispatchPushSubscriptionChangeEvent_Response callback) {
      ServiceWorkerDispatchPushSubscriptionChangeEventParams _message =
          new ServiceWorkerDispatchPushSubscriptionChangeEventParams();
      _message.oldSubscription = oldSubscription;
      _message.newSubscription = newSubscription;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)),
              new ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchSyncEvent(
        String tag, boolean lastChance, TimeDelta timeout, DispatchSyncEvent_Response callback) {
      ServiceWorkerDispatchSyncEventParams _message = new ServiceWorkerDispatchSyncEventParams();
      _message.tag = tag;
      _message.lastChance = lastChance;
      _message.timeout = timeout;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)),
              new ServiceWorkerDispatchSyncEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dispatchPeriodicSyncEvent(
        String tag, TimeDelta timeout, DispatchPeriodicSyncEvent_Response callback) {
      ServiceWorkerDispatchPeriodicSyncEventParams _message =
          new ServiceWorkerDispatchPeriodicSyncEventParams();
      _message.tag = tag;
      _message.timeout = timeout;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)),
              new ServiceWorkerDispatchPeriodicSyncEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dispatchAbortPaymentEvent(
        PaymentHandlerResponseCallback resultOfAbortPayment,
        DispatchAbortPaymentEvent_Response callback) {
      ServiceWorkerDispatchAbortPaymentEventParams _message =
          new ServiceWorkerDispatchAbortPaymentEventParams();
      _message.resultOfAbortPayment = resultOfAbortPayment;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(15, 1, 0L)),
              new ServiceWorkerDispatchAbortPaymentEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dispatchCanMakePaymentEvent(
        CanMakePaymentEventData eventData,
        PaymentHandlerResponseCallback resultOfCanMakePayment,
        DispatchCanMakePaymentEvent_Response callback) {
      ServiceWorkerDispatchCanMakePaymentEventParams _message =
          new ServiceWorkerDispatchCanMakePaymentEventParams();
      _message.eventData = eventData;
      _message.resultOfCanMakePayment = resultOfCanMakePayment;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(16, 1, 0L)),
              new ServiceWorkerDispatchCanMakePaymentEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchPaymentRequestEvent(
        PaymentRequestEventData requestData,
        PaymentHandlerResponseCallback responseCallback,
        DispatchPaymentRequestEvent_Response callback) {
      ServiceWorkerDispatchPaymentRequestEventParams _message =
          new ServiceWorkerDispatchPaymentRequestEventParams();
      _message.requestData = requestData;
      _message.responseCallback = responseCallback;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(17, 1, 0L)),
              new ServiceWorkerDispatchPaymentRequestEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchExtendableMessageEvent(
        ExtendableMessageEvent event, DispatchExtendableMessageEvent_Response callback) {
      ServiceWorkerDispatchExtendableMessageEventParams _message =
          new ServiceWorkerDispatchExtendableMessageEventParams();
      _message.event = event;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(18, 1, 0L)),
              new ServiceWorkerDispatchExtendableMessageEventResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dispatchContentDeleteEvent(
        String id, DispatchContentDeleteEvent_Response callback) {
      ServiceWorkerDispatchContentDeleteEventParams _message =
          new ServiceWorkerDispatchContentDeleteEventParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(19, 1, 0L)),
              new ServiceWorkerDispatchContentDeleteEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void ping(Ping_Response callback) {
      ServiceWorkerPingParams _message = new ServiceWorkerPingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(20, 1, 0L)),
              new ServiceWorkerPingResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setIdleDelay(TimeDelta delay) {
      ServiceWorkerSetIdleDelayParams _message = new ServiceWorkerSetIdleDelayParams();
      _message.delay = delay;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(21)));
    }

    @Override
    public void addKeepAlive() {
      ServiceWorkerAddKeepAliveParams _message = new ServiceWorkerAddKeepAliveParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(22)));
    }

    @Override
    public void clearKeepAlive() {
      ServiceWorkerClearKeepAliveParams _message = new ServiceWorkerClearKeepAliveParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(23)));
    }

    @Override
    public void addMessageToConsole(int level, String message) {
      ServiceWorkerAddMessageToConsoleParams _message =
          new ServiceWorkerAddMessageToConsoleParams();
      _message.level = level;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(24)));
    }

    @Override
    public void executeScriptForTest(
        BigString16 javascript, boolean wantsResult, ExecuteScriptForTest_Response callback) {
      ServiceWorkerExecuteScriptForTestParams _message =
          new ServiceWorkerExecuteScriptForTestParams();
      _message.javascript = javascript;
      _message.wantsResult = wantsResult;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(25, 1, 0L)),
              new ServiceWorkerExecuteScriptForTestResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorker> {
    Stub(Core core, ServiceWorker impl) {
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
                ServiceWorker_Internal.MANAGER, messageWithHeader);
          case 0:
            ServiceWorkerInitializeGlobalScopeParams data =
                ServiceWorkerInitializeGlobalScopeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .initializeGlobalScope(
                    data.serviceWorkerHost,
                    data.associatedInterfacesToBrowser,
                    data.associatedInterfacesFromBrowser,
                    data.registrationInfo,
                    data.serviceWorkerInfo,
                    data.fetchHandlerExistence,
                    data.reportingObserverReceiver,
                    data.ancestorFrameType,
                    data.storageKey);
            return true;
          case 21:
            getImpl()
                .setIdleDelay(
                    ServiceWorkerSetIdleDelayParams.deserialize(messageWithHeader.getPayload())
                        .delay);
            return true;
          case 22:
            ServiceWorkerAddKeepAliveParams.deserialize(messageWithHeader.getPayload());
            getImpl().addKeepAlive();
            return true;
          case 23:
            ServiceWorkerClearKeepAliveParams.deserialize(messageWithHeader.getPayload());
            getImpl().clearKeepAlive();
            return true;
          case 24:
            ServiceWorkerAddMessageToConsoleParams data2 =
                ServiceWorkerAddMessageToConsoleParams.deserialize(messageWithHeader.getPayload());
            getImpl().addMessageToConsole(data2.level, data2.message);
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
                getCore(), ServiceWorker_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 21:
          case 22:
          case 23:
          case 24:
          default:
            return false;
          case 1:
            ServiceWorkerDispatchInstallEventParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .dispatchInstallEvent(
                    new ServiceWorkerDispatchInstallEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            ServiceWorkerDispatchActivateEventParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .dispatchActivateEvent(
                    new ServiceWorkerDispatchActivateEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            ServiceWorkerDispatchBackgroundFetchAbortEventParams data =
                ServiceWorkerDispatchBackgroundFetchAbortEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchBackgroundFetchAbortEvent(
                    data.registration,
                    new ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            ServiceWorkerDispatchBackgroundFetchClickEventParams data2 =
                ServiceWorkerDispatchBackgroundFetchClickEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchBackgroundFetchClickEvent(
                    data2.registration,
                    new ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            ServiceWorkerDispatchBackgroundFetchFailEventParams data3 =
                ServiceWorkerDispatchBackgroundFetchFailEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchBackgroundFetchFailEvent(
                    data3.registration,
                    new ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            ServiceWorkerDispatchBackgroundFetchSuccessEventParams data4 =
                ServiceWorkerDispatchBackgroundFetchSuccessEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchBackgroundFetchSuccessEvent(
                    data4.registration,
                    new ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            ServiceWorkerDispatchCookieChangeEventParams data5 =
                ServiceWorkerDispatchCookieChangeEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchCookieChangeEvent(
                    data5.change,
                    new ServiceWorkerDispatchCookieChangeEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            ServiceWorkerDispatchFetchEventForMainResourceParams data6 =
                ServiceWorkerDispatchFetchEventForMainResourceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchFetchEventForMainResource(
                    data6.params,
                    data6.responseCallback,
                    new ServiceWorkerDispatchFetchEventForMainResourceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            ServiceWorkerDispatchNotificationClickEventParams data7 =
                ServiceWorkerDispatchNotificationClickEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchNotificationClickEvent(
                    data7.notificationId,
                    data7.notificationData,
                    data7.actionIndex,
                    data7.reply,
                    new ServiceWorkerDispatchNotificationClickEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 10:
            ServiceWorkerDispatchNotificationCloseEventParams data8 =
                ServiceWorkerDispatchNotificationCloseEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchNotificationCloseEvent(
                    data8.notificationId,
                    data8.notificationData,
                    new ServiceWorkerDispatchNotificationCloseEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            ServiceWorkerDispatchPushEventParams data9 =
                ServiceWorkerDispatchPushEventParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .dispatchPushEvent(
                    data9.payload,
                    new ServiceWorkerDispatchPushEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 12:
            ServiceWorkerDispatchPushSubscriptionChangeEventParams data10 =
                ServiceWorkerDispatchPushSubscriptionChangeEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchPushSubscriptionChangeEvent(
                    data10.oldSubscription,
                    data10.newSubscription,
                    new ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 13:
            ServiceWorkerDispatchSyncEventParams data11 =
                ServiceWorkerDispatchSyncEventParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .dispatchSyncEvent(
                    data11.tag,
                    data11.lastChance,
                    data11.timeout,
                    new ServiceWorkerDispatchSyncEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 14:
            ServiceWorkerDispatchPeriodicSyncEventParams data12 =
                ServiceWorkerDispatchPeriodicSyncEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchPeriodicSyncEvent(
                    data12.tag,
                    data12.timeout,
                    new ServiceWorkerDispatchPeriodicSyncEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 15:
            ServiceWorkerDispatchAbortPaymentEventParams data13 =
                ServiceWorkerDispatchAbortPaymentEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchAbortPaymentEvent(
                    data13.resultOfAbortPayment,
                    new ServiceWorkerDispatchAbortPaymentEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 16:
            ServiceWorkerDispatchCanMakePaymentEventParams data14 =
                ServiceWorkerDispatchCanMakePaymentEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchCanMakePaymentEvent(
                    data14.eventData,
                    data14.resultOfCanMakePayment,
                    new ServiceWorkerDispatchCanMakePaymentEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 17:
            ServiceWorkerDispatchPaymentRequestEventParams data15 =
                ServiceWorkerDispatchPaymentRequestEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchPaymentRequestEvent(
                    data15.requestData,
                    data15.responseCallback,
                    new ServiceWorkerDispatchPaymentRequestEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 18:
            ServiceWorkerDispatchExtendableMessageEventParams data16 =
                ServiceWorkerDispatchExtendableMessageEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchExtendableMessageEvent(
                    data16.event,
                    new ServiceWorkerDispatchExtendableMessageEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 19:
            ServiceWorkerDispatchContentDeleteEventParams data17 =
                ServiceWorkerDispatchContentDeleteEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchContentDeleteEvent(
                    data17.id,
                    new ServiceWorkerDispatchContentDeleteEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 20:
            ServiceWorkerPingParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .ping(
                    new ServiceWorkerPingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 25:
            ServiceWorkerExecuteScriptForTestParams data18 =
                ServiceWorkerExecuteScriptForTestParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .executeScriptForTest(
                    data18.javascript,
                    data18.wantsResult,
                    new ServiceWorkerExecuteScriptForTestResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ServiceWorkerInitializeGlobalScopeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY;
    public int ancestorFrameType;
    public AssociatedInterfaceRequestNotSupported associatedInterfacesFromBrowser;
    public AssociatedInterfaceNotSupported associatedInterfacesToBrowser;
    public int fetchHandlerExistence;
    public ServiceWorkerRegistrationObjectInfo registrationInfo;
    public InterfaceRequest<ReportingObserver> reportingObserverReceiver;
    public AssociatedInterfaceNotSupported serviceWorkerHost;
    public ServiceWorkerObjectInfo serviceWorkerInfo;
    public StorageKey storageKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerInitializeGlobalScopeParams(int version) {
      super(64, version);
    }

    public ServiceWorkerInitializeGlobalScopeParams() {
      this(0);
    }

    public static ServiceWorkerInitializeGlobalScopeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerInitializeGlobalScopeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerInitializeGlobalScopeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerInitializeGlobalScopeParams result =
            new ServiceWorkerInitializeGlobalScopeParams(elementsOrVersion);
        result.serviceWorkerHost = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        result.associatedInterfacesToBrowser =
            decoder0.readAssociatedServiceInterfaceNotSupported(16, false);
        result.associatedInterfacesFromBrowser =
            decoder0.readAssociatedInterfaceRequestNotSupported(24, false);
        int readInt = decoder0.readInt(28);
        result.fetchHandlerExistence = readInt;
        FetchHandlerExistence.validate(readInt);
        result.fetchHandlerExistence =
            FetchHandlerExistence.toKnownValue(result.fetchHandlerExistence);
        Decoder decoder1 = decoder0.readPointer(32, false);
        result.registrationInfo = ServiceWorkerRegistrationObjectInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(40, false);
        result.serviceWorkerInfo = ServiceWorkerObjectInfo.decode(decoder12);
        result.reportingObserverReceiver = decoder0.readInterfaceRequest(48, true);
        int readInt2 = decoder0.readInt(52);
        result.ancestorFrameType = readInt2;
        AncestorFrameType.validate(readInt2);
        result.ancestorFrameType = AncestorFrameType.toKnownValue(result.ancestorFrameType);
        Decoder decoder13 = decoder0.readPointer(56, false);
        result.storageKey = StorageKey.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerHost, 8, false);
      encoder0.encode(this.associatedInterfacesToBrowser, 16, false);
      encoder0.encode(this.associatedInterfacesFromBrowser, 24, false);
      encoder0.encode(this.fetchHandlerExistence, 28);
      encoder0.encode((Struct) this.registrationInfo, 32, false);
      encoder0.encode((Struct) this.serviceWorkerInfo, 40, false);
      encoder0.encode((InterfaceRequest) this.reportingObserverReceiver, 48, true);
      encoder0.encode(this.ancestorFrameType, 52);
      encoder0.encode((Struct) this.storageKey, 56, false);
    }
  }

  static final class ServiceWorkerDispatchInstallEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchInstallEventParams(int version) {
      super(8, version);
    }

    public ServiceWorkerDispatchInstallEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchInstallEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchInstallEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchInstallEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchInstallEventParams result =
            new ServiceWorkerDispatchInstallEventParams(elementsOrVersion);
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

  static final class ServiceWorkerDispatchInstallEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int fetchCount;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchInstallEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchInstallEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchInstallEventResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchInstallEventResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchInstallEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchInstallEventResponseParams result =
            new ServiceWorkerDispatchInstallEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
        result.fetchCount = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.fetchCount, 12);
    }
  }

  static class ServiceWorkerDispatchInstallEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchInstallEvent_Response mCallback;

    ServiceWorkerDispatchInstallEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchInstallEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        ServiceWorkerDispatchInstallEventResponseParams response =
            ServiceWorkerDispatchInstallEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.fetchCount);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchInstallEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchInstallEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchInstallEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, int fetchCount) {
      ServiceWorkerDispatchInstallEventResponseParams _response =
          new ServiceWorkerDispatchInstallEventResponseParams();
      _response.status = status;
      _response.fetchCount = fetchCount;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchActivateEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchActivateEventParams(int version) {
      super(8, version);
    }

    public ServiceWorkerDispatchActivateEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchActivateEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchActivateEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchActivateEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchActivateEventParams result =
            new ServiceWorkerDispatchActivateEventParams(elementsOrVersion);
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

  static final class ServiceWorkerDispatchActivateEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchActivateEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchActivateEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchActivateEventResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchActivateEventResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchActivateEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchActivateEventResponseParams result =
            new ServiceWorkerDispatchActivateEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchActivateEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchActivateEvent_Response mCallback;

    ServiceWorkerDispatchActivateEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchActivateEvent_Response callback) {
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
        ServiceWorkerDispatchActivateEventResponseParams response =
            ServiceWorkerDispatchActivateEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchActivateEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchActivateEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchActivateEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchActivateEventResponseParams _response =
          new ServiceWorkerDispatchActivateEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchBackgroundFetchAbortEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BackgroundFetchRegistration registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchBackgroundFetchAbortEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchBackgroundFetchAbortEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchBackgroundFetchAbortEventParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchBackgroundFetchAbortEventParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchBackgroundFetchAbortEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchBackgroundFetchAbortEventParams result =
            new ServiceWorkerDispatchBackgroundFetchAbortEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.registration = BackgroundFetchRegistration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.registration, 8, false);
    }
  }

  static final class ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams result =
            new ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchBackgroundFetchAbortEvent_Response mCallback;

    ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchBackgroundFetchAbortEvent_Response callback) {
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
        ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams response =
            ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchBackgroundFetchAbortEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams _response =
          new ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchBackgroundFetchClickEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BackgroundFetchRegistration registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchBackgroundFetchClickEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchBackgroundFetchClickEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchBackgroundFetchClickEventParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchBackgroundFetchClickEventParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchBackgroundFetchClickEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchBackgroundFetchClickEventParams result =
            new ServiceWorkerDispatchBackgroundFetchClickEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.registration = BackgroundFetchRegistration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.registration, 8, false);
    }
  }

  static final class ServiceWorkerDispatchBackgroundFetchClickEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchBackgroundFetchClickEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchBackgroundFetchClickEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchBackgroundFetchClickEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchBackgroundFetchClickEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchBackgroundFetchClickEventResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchBackgroundFetchClickEventResponseParams result =
            new ServiceWorkerDispatchBackgroundFetchClickEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchBackgroundFetchClickEvent_Response mCallback;

    ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchBackgroundFetchClickEvent_Response callback) {
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
        ServiceWorkerDispatchBackgroundFetchClickEventResponseParams response =
            ServiceWorkerDispatchBackgroundFetchClickEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchBackgroundFetchClickEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchBackgroundFetchClickEventResponseParams _response =
          new ServiceWorkerDispatchBackgroundFetchClickEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchBackgroundFetchFailEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BackgroundFetchRegistration registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchBackgroundFetchFailEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchBackgroundFetchFailEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchBackgroundFetchFailEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchBackgroundFetchFailEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchBackgroundFetchFailEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchBackgroundFetchFailEventParams result =
            new ServiceWorkerDispatchBackgroundFetchFailEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.registration = BackgroundFetchRegistration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.registration, 8, false);
    }
  }

  static final class ServiceWorkerDispatchBackgroundFetchFailEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchBackgroundFetchFailEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchBackgroundFetchFailEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchBackgroundFetchFailEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchBackgroundFetchFailEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchBackgroundFetchFailEventResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchBackgroundFetchFailEventResponseParams result =
            new ServiceWorkerDispatchBackgroundFetchFailEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchBackgroundFetchFailEvent_Response mCallback;

    ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchBackgroundFetchFailEvent_Response callback) {
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
        ServiceWorkerDispatchBackgroundFetchFailEventResponseParams response =
            ServiceWorkerDispatchBackgroundFetchFailEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchBackgroundFetchFailEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchBackgroundFetchFailEventResponseParams _response =
          new ServiceWorkerDispatchBackgroundFetchFailEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchBackgroundFetchSuccessEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BackgroundFetchRegistration registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchBackgroundFetchSuccessEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchBackgroundFetchSuccessEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchBackgroundFetchSuccessEventParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchBackgroundFetchSuccessEventParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchBackgroundFetchSuccessEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchBackgroundFetchSuccessEventParams result =
            new ServiceWorkerDispatchBackgroundFetchSuccessEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.registration = BackgroundFetchRegistration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.registration, 8, false);
    }
  }

  static final class ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams result =
            new ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchBackgroundFetchSuccessEvent_Response mCallback;

    ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchBackgroundFetchSuccessEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams response =
            ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchBackgroundFetchSuccessEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams _response =
          new ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchCookieChangeEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieChangeInfo change;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchCookieChangeEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchCookieChangeEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchCookieChangeEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchCookieChangeEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchCookieChangeEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchCookieChangeEventParams result =
            new ServiceWorkerDispatchCookieChangeEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.change = CookieChangeInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.change, 8, false);
    }
  }

  static final class ServiceWorkerDispatchCookieChangeEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchCookieChangeEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchCookieChangeEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchCookieChangeEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchCookieChangeEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchCookieChangeEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchCookieChangeEventResponseParams result =
            new ServiceWorkerDispatchCookieChangeEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchCookieChangeEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchCookieChangeEvent_Response mCallback;

    ServiceWorkerDispatchCookieChangeEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchCookieChangeEvent_Response callback) {
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
        ServiceWorkerDispatchCookieChangeEventResponseParams response =
            ServiceWorkerDispatchCookieChangeEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchCookieChangeEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchCookieChangeEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchCookieChangeEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchCookieChangeEventResponseParams _response =
          new ServiceWorkerDispatchCookieChangeEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchFetchEventForMainResourceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DispatchFetchEventParams params;
    public ServiceWorkerFetchResponseCallback responseCallback;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchFetchEventForMainResourceParams(int version) {
      super(24, version);
    }

    public ServiceWorkerDispatchFetchEventForMainResourceParams() {
      this(0);
    }

    public static ServiceWorkerDispatchFetchEventForMainResourceParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchFetchEventForMainResourceParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchFetchEventForMainResourceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchFetchEventForMainResourceParams result =
            new ServiceWorkerDispatchFetchEventForMainResourceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = DispatchFetchEventParams.decode(decoder1);
        result.responseCallback =
            (ServiceWorkerFetchResponseCallback)
                decoder0.readServiceInterface(
                    16, false, ServiceWorkerFetchResponseCallback.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
      encoder0.encode(this.responseCallback, 16, false, ServiceWorkerFetchResponseCallback.MANAGER);
    }
  }

  static final class ServiceWorkerDispatchFetchEventForMainResourceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchFetchEventForMainResourceResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchFetchEventForMainResourceResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchFetchEventForMainResourceResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchFetchEventForMainResourceResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchFetchEventForMainResourceResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchFetchEventForMainResourceResponseParams result =
            new ServiceWorkerDispatchFetchEventForMainResourceResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchFetchEventForMainResourceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchFetchEventForMainResource_Response mCallback;

    ServiceWorkerDispatchFetchEventForMainResourceResponseParamsForwardToCallback(
        ServiceWorker.DispatchFetchEventForMainResource_Response callback) {
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
        ServiceWorkerDispatchFetchEventForMainResourceResponseParams response =
            ServiceWorkerDispatchFetchEventForMainResourceResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchFetchEventForMainResourceResponseParamsProxyToResponder
      implements ServiceWorker.DispatchFetchEventForMainResource_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchFetchEventForMainResourceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchFetchEventForMainResourceResponseParams _response =
          new ServiceWorkerDispatchFetchEventForMainResourceResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchNotificationClickEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public int actionIndex;
    public NotificationData notificationData;
    public String notificationId;
    public String16 reply;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchNotificationClickEventParams(int version) {
      super(40, version);
    }

    public ServiceWorkerDispatchNotificationClickEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchNotificationClickEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchNotificationClickEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchNotificationClickEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchNotificationClickEventParams result =
            new ServiceWorkerDispatchNotificationClickEventParams(elementsOrVersion);
        result.notificationId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.notificationData = NotificationData.decode(decoder1);
        result.actionIndex = decoder0.readInt(24);
        Decoder decoder12 = decoder0.readPointer(32, true);
        result.reply = String16.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.notificationId, 8, false);
      encoder0.encode((Struct) this.notificationData, 16, false);
      encoder0.encode(this.actionIndex, 24);
      encoder0.encode((Struct) this.reply, 32, true);
    }
  }

  static final class ServiceWorkerDispatchNotificationClickEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchNotificationClickEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchNotificationClickEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchNotificationClickEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchNotificationClickEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchNotificationClickEventResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchNotificationClickEventResponseParams result =
            new ServiceWorkerDispatchNotificationClickEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchNotificationClickEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchNotificationClickEvent_Response mCallback;

    ServiceWorkerDispatchNotificationClickEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchNotificationClickEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 2)) {
          return false;
        }
        ServiceWorkerDispatchNotificationClickEventResponseParams response =
            ServiceWorkerDispatchNotificationClickEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchNotificationClickEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchNotificationClickEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchNotificationClickEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchNotificationClickEventResponseParams _response =
          new ServiceWorkerDispatchNotificationClickEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchNotificationCloseEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public NotificationData notificationData;
    public String notificationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchNotificationCloseEventParams(int version) {
      super(24, version);
    }

    public ServiceWorkerDispatchNotificationCloseEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchNotificationCloseEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchNotificationCloseEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchNotificationCloseEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchNotificationCloseEventParams result =
            new ServiceWorkerDispatchNotificationCloseEventParams(elementsOrVersion);
        result.notificationId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.notificationData = NotificationData.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.notificationId, 8, false);
      encoder0.encode((Struct) this.notificationData, 16, false);
    }
  }

  static final class ServiceWorkerDispatchNotificationCloseEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchNotificationCloseEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchNotificationCloseEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchNotificationCloseEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchNotificationCloseEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchNotificationCloseEventResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchNotificationCloseEventResponseParams result =
            new ServiceWorkerDispatchNotificationCloseEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchNotificationCloseEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchNotificationCloseEvent_Response mCallback;

    ServiceWorkerDispatchNotificationCloseEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchNotificationCloseEvent_Response callback) {
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
        ServiceWorkerDispatchNotificationCloseEventResponseParams response =
            ServiceWorkerDispatchNotificationCloseEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchNotificationCloseEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchNotificationCloseEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchNotificationCloseEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchNotificationCloseEventResponseParams _response =
          new ServiceWorkerDispatchNotificationCloseEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchPushEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String payload;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchPushEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchPushEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchPushEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchPushEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchPushEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchPushEventParams result =
            new ServiceWorkerDispatchPushEventParams(elementsOrVersion);
        result.payload = decoder0.readString(8, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.payload, 8, true);
    }
  }

  static final class ServiceWorkerDispatchPushEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchPushEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchPushEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchPushEventResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchPushEventResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchPushEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchPushEventResponseParams result =
            new ServiceWorkerDispatchPushEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchPushEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchPushEvent_Response mCallback;

    ServiceWorkerDispatchPushEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchPushEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 2)) {
          return false;
        }
        ServiceWorkerDispatchPushEventResponseParams response =
            ServiceWorkerDispatchPushEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchPushEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchPushEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchPushEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchPushEventResponseParams _response =
          new ServiceWorkerDispatchPushEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchPushSubscriptionChangeEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PushSubscription newSubscription;
    public PushSubscription oldSubscription;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchPushSubscriptionChangeEventParams(int version) {
      super(24, version);
    }

    public ServiceWorkerDispatchPushSubscriptionChangeEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchPushSubscriptionChangeEventParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchPushSubscriptionChangeEventParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchPushSubscriptionChangeEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchPushSubscriptionChangeEventParams result =
            new ServiceWorkerDispatchPushSubscriptionChangeEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.oldSubscription = PushSubscription.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.newSubscription = PushSubscription.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.oldSubscription, 8, true);
      encoder0.encode((Struct) this.newSubscription, 16, true);
    }
  }

  static final class ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams result =
            new ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchPushSubscriptionChangeEvent_Response mCallback;

    ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchPushSubscriptionChangeEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(12, 2)) {
          return false;
        }
        ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams response =
            ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchPushSubscriptionChangeEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams _response =
          new ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchSyncEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean lastChance;
    public String tag;
    public TimeDelta timeout;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchSyncEventParams(int version) {
      super(32, version);
    }

    public ServiceWorkerDispatchSyncEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchSyncEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchSyncEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchSyncEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchSyncEventParams result =
            new ServiceWorkerDispatchSyncEventParams(elementsOrVersion);
        result.tag = decoder0.readString(8, false);
        result.lastChance = decoder0.readBoolean(16, 0);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.timeout = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.tag, 8, false);
      encoder0.encode(this.lastChance, 16, 0);
      encoder0.encode((Struct) this.timeout, 24, false);
    }
  }

  static final class ServiceWorkerDispatchSyncEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchSyncEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchSyncEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchSyncEventResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchSyncEventResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchSyncEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchSyncEventResponseParams result =
            new ServiceWorkerDispatchSyncEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchSyncEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchSyncEvent_Response mCallback;

    ServiceWorkerDispatchSyncEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchSyncEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(13, 2)) {
          return false;
        }
        ServiceWorkerDispatchSyncEventResponseParams response =
            ServiceWorkerDispatchSyncEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchSyncEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchSyncEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchSyncEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchSyncEventResponseParams _response =
          new ServiceWorkerDispatchSyncEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(13, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchPeriodicSyncEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String tag;
    public TimeDelta timeout;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchPeriodicSyncEventParams(int version) {
      super(24, version);
    }

    public ServiceWorkerDispatchPeriodicSyncEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchPeriodicSyncEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchPeriodicSyncEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchPeriodicSyncEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchPeriodicSyncEventParams result =
            new ServiceWorkerDispatchPeriodicSyncEventParams(elementsOrVersion);
        result.tag = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.timeout = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.tag, 8, false);
      encoder0.encode((Struct) this.timeout, 16, false);
    }
  }

  static final class ServiceWorkerDispatchPeriodicSyncEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchPeriodicSyncEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchPeriodicSyncEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchPeriodicSyncEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchPeriodicSyncEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchPeriodicSyncEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchPeriodicSyncEventResponseParams result =
            new ServiceWorkerDispatchPeriodicSyncEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchPeriodicSyncEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchPeriodicSyncEvent_Response mCallback;

    ServiceWorkerDispatchPeriodicSyncEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchPeriodicSyncEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(14, 2)) {
          return false;
        }
        ServiceWorkerDispatchPeriodicSyncEventResponseParams response =
            ServiceWorkerDispatchPeriodicSyncEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchPeriodicSyncEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchPeriodicSyncEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchPeriodicSyncEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchPeriodicSyncEventResponseParams _response =
          new ServiceWorkerDispatchPeriodicSyncEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(14, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchAbortPaymentEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentHandlerResponseCallback resultOfAbortPayment;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchAbortPaymentEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchAbortPaymentEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchAbortPaymentEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchAbortPaymentEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchAbortPaymentEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchAbortPaymentEventParams result =
            new ServiceWorkerDispatchAbortPaymentEventParams(elementsOrVersion);
        result.resultOfAbortPayment =
            (PaymentHandlerResponseCallback)
                decoder0.readServiceInterface(8, false, PaymentHandlerResponseCallback.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.resultOfAbortPayment, 8, false, PaymentHandlerResponseCallback.MANAGER);
    }
  }

  static final class ServiceWorkerDispatchAbortPaymentEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchAbortPaymentEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchAbortPaymentEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchAbortPaymentEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchAbortPaymentEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchAbortPaymentEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchAbortPaymentEventResponseParams result =
            new ServiceWorkerDispatchAbortPaymentEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchAbortPaymentEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchAbortPaymentEvent_Response mCallback;

    ServiceWorkerDispatchAbortPaymentEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchAbortPaymentEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(15, 2)) {
          return false;
        }
        ServiceWorkerDispatchAbortPaymentEventResponseParams response =
            ServiceWorkerDispatchAbortPaymentEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchAbortPaymentEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchAbortPaymentEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchAbortPaymentEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchAbortPaymentEventResponseParams _response =
          new ServiceWorkerDispatchAbortPaymentEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(15, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchCanMakePaymentEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public CanMakePaymentEventData eventData;
    public PaymentHandlerResponseCallback resultOfCanMakePayment;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchCanMakePaymentEventParams(int version) {
      super(24, version);
    }

    public ServiceWorkerDispatchCanMakePaymentEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchCanMakePaymentEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchCanMakePaymentEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchCanMakePaymentEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchCanMakePaymentEventParams result =
            new ServiceWorkerDispatchCanMakePaymentEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.eventData = CanMakePaymentEventData.decode(decoder1);
        result.resultOfCanMakePayment =
            (PaymentHandlerResponseCallback)
                decoder0.readServiceInterface(16, false, PaymentHandlerResponseCallback.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.eventData, 8, false);
      encoder0.encode(
          this.resultOfCanMakePayment, 16, false, PaymentHandlerResponseCallback.MANAGER);
    }
  }

  static final class ServiceWorkerDispatchCanMakePaymentEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchCanMakePaymentEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchCanMakePaymentEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchCanMakePaymentEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchCanMakePaymentEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchCanMakePaymentEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchCanMakePaymentEventResponseParams result =
            new ServiceWorkerDispatchCanMakePaymentEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchCanMakePaymentEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchCanMakePaymentEvent_Response mCallback;

    ServiceWorkerDispatchCanMakePaymentEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchCanMakePaymentEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(16, 2)) {
          return false;
        }
        ServiceWorkerDispatchCanMakePaymentEventResponseParams response =
            ServiceWorkerDispatchCanMakePaymentEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchCanMakePaymentEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchCanMakePaymentEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchCanMakePaymentEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchCanMakePaymentEventResponseParams _response =
          new ServiceWorkerDispatchCanMakePaymentEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(16, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchPaymentRequestEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentRequestEventData requestData;
    public PaymentHandlerResponseCallback responseCallback;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchPaymentRequestEventParams(int version) {
      super(24, version);
    }

    public ServiceWorkerDispatchPaymentRequestEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchPaymentRequestEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchPaymentRequestEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchPaymentRequestEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchPaymentRequestEventParams result =
            new ServiceWorkerDispatchPaymentRequestEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.requestData = PaymentRequestEventData.decode(decoder1);
        result.responseCallback =
            (PaymentHandlerResponseCallback)
                decoder0.readServiceInterface(16, false, PaymentHandlerResponseCallback.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestData, 8, false);
      encoder0.encode(this.responseCallback, 16, false, PaymentHandlerResponseCallback.MANAGER);
    }
  }

  static final class ServiceWorkerDispatchPaymentRequestEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchPaymentRequestEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchPaymentRequestEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchPaymentRequestEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchPaymentRequestEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchPaymentRequestEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchPaymentRequestEventResponseParams result =
            new ServiceWorkerDispatchPaymentRequestEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchPaymentRequestEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchPaymentRequestEvent_Response mCallback;

    ServiceWorkerDispatchPaymentRequestEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchPaymentRequestEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(17, 2)) {
          return false;
        }
        ServiceWorkerDispatchPaymentRequestEventResponseParams response =
            ServiceWorkerDispatchPaymentRequestEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchPaymentRequestEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchPaymentRequestEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchPaymentRequestEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchPaymentRequestEventResponseParams _response =
          new ServiceWorkerDispatchPaymentRequestEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(17, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchExtendableMessageEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ExtendableMessageEvent event;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchExtendableMessageEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchExtendableMessageEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchExtendableMessageEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchExtendableMessageEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchExtendableMessageEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchExtendableMessageEventParams result =
            new ServiceWorkerDispatchExtendableMessageEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.event = ExtendableMessageEvent.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.event, 8, false);
    }
  }

  static final class ServiceWorkerDispatchExtendableMessageEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchExtendableMessageEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchExtendableMessageEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchExtendableMessageEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchExtendableMessageEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchExtendableMessageEventResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchExtendableMessageEventResponseParams result =
            new ServiceWorkerDispatchExtendableMessageEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchExtendableMessageEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchExtendableMessageEvent_Response mCallback;

    ServiceWorkerDispatchExtendableMessageEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchExtendableMessageEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(18, 2)) {
          return false;
        }
        ServiceWorkerDispatchExtendableMessageEventResponseParams response =
            ServiceWorkerDispatchExtendableMessageEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchExtendableMessageEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchExtendableMessageEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchExtendableMessageEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchExtendableMessageEventResponseParams _response =
          new ServiceWorkerDispatchExtendableMessageEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(18, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerDispatchContentDeleteEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchContentDeleteEventParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchContentDeleteEventParams() {
      this(0);
    }

    public static ServiceWorkerDispatchContentDeleteEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchContentDeleteEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchContentDeleteEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchContentDeleteEventParams result =
            new ServiceWorkerDispatchContentDeleteEventParams(elementsOrVersion);
        result.id = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8, false);
    }
  }

  static final class ServiceWorkerDispatchContentDeleteEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerDispatchContentDeleteEventResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerDispatchContentDeleteEventResponseParams() {
      this(0);
    }

    public static ServiceWorkerDispatchContentDeleteEventResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerDispatchContentDeleteEventResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerDispatchContentDeleteEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerDispatchContentDeleteEventResponseParams result =
            new ServiceWorkerDispatchContentDeleteEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static class ServiceWorkerDispatchContentDeleteEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.DispatchContentDeleteEvent_Response mCallback;

    ServiceWorkerDispatchContentDeleteEventResponseParamsForwardToCallback(
        ServiceWorker.DispatchContentDeleteEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(19, 2)) {
          return false;
        }
        ServiceWorkerDispatchContentDeleteEventResponseParams response =
            ServiceWorkerDispatchContentDeleteEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerDispatchContentDeleteEventResponseParamsProxyToResponder
      implements ServiceWorker.DispatchContentDeleteEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerDispatchContentDeleteEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ServiceWorkerDispatchContentDeleteEventResponseParams _response =
          new ServiceWorkerDispatchContentDeleteEventResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(19, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerPingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerPingParams(int version) {
      super(8, version);
    }

    public ServiceWorkerPingParams() {
      this(0);
    }

    public static ServiceWorkerPingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerPingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerPingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerPingParams result = new ServiceWorkerPingParams(elementsOrVersion);
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

  static final class ServiceWorkerPingResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerPingResponseParams(int version) {
      super(8, version);
    }

    public ServiceWorkerPingResponseParams() {
      this(0);
    }

    public static ServiceWorkerPingResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerPingResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerPingResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerPingResponseParams result =
            new ServiceWorkerPingResponseParams(elementsOrVersion);
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

  static class ServiceWorkerPingResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ServiceWorker.Ping_Response mCallback;

    ServiceWorkerPingResponseParamsForwardToCallback(ServiceWorker.Ping_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(20, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerPingResponseParamsProxyToResponder
      implements ServiceWorker.Ping_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerPingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      ServiceWorkerPingResponseParams _response = new ServiceWorkerPingResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(20, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerSetIdleDelayParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta delay;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerSetIdleDelayParams(int version) {
      super(16, version);
    }

    public ServiceWorkerSetIdleDelayParams() {
      this(0);
    }

    public static ServiceWorkerSetIdleDelayParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerSetIdleDelayParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerSetIdleDelayParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerSetIdleDelayParams result =
            new ServiceWorkerSetIdleDelayParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.delay = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.delay, 8, false);
    }
  }

  static final class ServiceWorkerAddKeepAliveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerAddKeepAliveParams(int version) {
      super(8, version);
    }

    public ServiceWorkerAddKeepAliveParams() {
      this(0);
    }

    public static ServiceWorkerAddKeepAliveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerAddKeepAliveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerAddKeepAliveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerAddKeepAliveParams result =
            new ServiceWorkerAddKeepAliveParams(elementsOrVersion);
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

  static final class ServiceWorkerClearKeepAliveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerClearKeepAliveParams(int version) {
      super(8, version);
    }

    public ServiceWorkerClearKeepAliveParams() {
      this(0);
    }

    public static ServiceWorkerClearKeepAliveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerClearKeepAliveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerClearKeepAliveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerClearKeepAliveParams result =
            new ServiceWorkerClearKeepAliveParams(elementsOrVersion);
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

  static final class ServiceWorkerAddMessageToConsoleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int level;
    public String message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerAddMessageToConsoleParams(int version) {
      super(24, version);
    }

    public ServiceWorkerAddMessageToConsoleParams() {
      this(0);
    }

    public static ServiceWorkerAddMessageToConsoleParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerAddMessageToConsoleParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerAddMessageToConsoleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerAddMessageToConsoleParams result =
            new ServiceWorkerAddMessageToConsoleParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.level = readInt;
        ConsoleMessageLevel.validate(readInt);
        result.level = ConsoleMessageLevel.toKnownValue(result.level);
        result.message = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.level, 8);
      encoder0.encode(this.message, 16, false);
    }
  }

  static final class ServiceWorkerExecuteScriptForTestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 javascript;
    public boolean wantsResult;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerExecuteScriptForTestParams(int version) {
      super(24, version);
    }

    public ServiceWorkerExecuteScriptForTestParams() {
      this(0);
    }

    public static ServiceWorkerExecuteScriptForTestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerExecuteScriptForTestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerExecuteScriptForTestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerExecuteScriptForTestParams result =
            new ServiceWorkerExecuteScriptForTestParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.javascript = BigString16.decode(decoder1);
        result.wantsResult = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.javascript, 8, false);
      encoder0.encode(this.wantsResult, 16, 0);
    }
  }

  static final class ServiceWorkerExecuteScriptForTestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String error;
    public Value result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerExecuteScriptForTestResponseParams(int version) {
      super(32, version);
    }

    public ServiceWorkerExecuteScriptForTestResponseParams() {
      this(0);
    }

    public static ServiceWorkerExecuteScriptForTestResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerExecuteScriptForTestResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerExecuteScriptForTestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerExecuteScriptForTestResponseParams result =
            new ServiceWorkerExecuteScriptForTestResponseParams(elementsOrVersion);
        result.result = Value.decode(decoder0, 8);
        result.error = decoder0.readString(24, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
      encoder0.encode(this.error, 24, true);
    }
  }

  static class ServiceWorkerExecuteScriptForTestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorker.ExecuteScriptForTest_Response mCallback;

    ServiceWorkerExecuteScriptForTestResponseParamsForwardToCallback(
        ServiceWorker.ExecuteScriptForTest_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(25, 2)) {
          return false;
        }
        ServiceWorkerExecuteScriptForTestResponseParams response =
            ServiceWorkerExecuteScriptForTestResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerExecuteScriptForTestResponseParamsProxyToResponder
      implements ServiceWorker.ExecuteScriptForTest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerExecuteScriptForTestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Value result, String error) {
      ServiceWorkerExecuteScriptForTestResponseParams _response =
          new ServiceWorkerExecuteScriptForTestResponseParams();
      _response.result = result;
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(25, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
