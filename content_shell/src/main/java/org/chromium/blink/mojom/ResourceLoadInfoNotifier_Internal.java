package org.chromium.blink.mojom;

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
import org.chromium.network.mojom.RequestDestination;
import org.chromium.network.mojom.UrlLoaderCompletionStatus;
import org.chromium.network.mojom.UrlRequestRedirectInfo;
import org.chromium.network.mojom.UrlResponseHead;
import org.chromium.url.mojom.SchemeHostPort;

class ResourceLoadInfoNotifier_Internal {
  private static final int CLONE_ORDINAL = 6;
  public static final Interface.Manager<ResourceLoadInfoNotifier, ResourceLoadInfoNotifier.Proxy>
      MANAGER =
          new Interface.Manager<ResourceLoadInfoNotifier, ResourceLoadInfoNotifier.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ResourceLoadInfoNotifier";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ResourceLoadInfoNotifier.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ResourceLoadInfoNotifier impl) {
              return new Stub(core, impl);
            }

            @Override
            public ResourceLoadInfoNotifier[] buildArray(int size) {
              return new ResourceLoadInfoNotifier[size];
            }
          };
  private static final int NOTIFY_RESOURCE_LOAD_CANCELED_ORDINAL = 5;
  private static final int NOTIFY_RESOURCE_LOAD_COMPLETED_ORDINAL = 4;
  private static final int NOTIFY_RESOURCE_REDIRECT_RECEIVED_ORDINAL = 1;
  private static final int NOTIFY_RESOURCE_RESPONSE_RECEIVED_ORDINAL = 2;
  private static final int NOTIFY_RESOURCE_TRANSFER_SIZE_UPDATED_ORDINAL = 3;
  private static final int NOTIFY_UPDATE_USER_GESTURE_CARRYOVER_INFO_ORDINAL = 0;

  ResourceLoadInfoNotifier_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ResourceLoadInfoNotifier.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void notifyUpdateUserGestureCarryoverInfo() {
      ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams _message =
          new ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void notifyResourceRedirectReceived(
        UrlRequestRedirectInfo redirectInfo, UrlResponseHead redirectResponse) {
      ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams _message =
          new ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams();
      _message.redirectInfo = redirectInfo;
      _message.redirectResponse = redirectResponse;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void notifyResourceResponseReceived(
        long requestId,
        SchemeHostPort finalResponseUrl,
        UrlResponseHead head,
        int requestDestination,
        boolean isAdResource) {
      ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams _message =
          new ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams();
      _message.requestId = requestId;
      _message.finalResponseUrl = finalResponseUrl;
      _message.head = head;
      _message.requestDestination = requestDestination;
      _message.isAdResource = isAdResource;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void notifyResourceTransferSizeUpdated(long requestId, int transferSizeDiff) {
      ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams _message =
          new ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams();
      _message.requestId = requestId;
      _message.transferSizeDiff = transferSizeDiff;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void notifyResourceLoadCompleted(
        ResourceLoadInfo resourceLoadInfo, UrlLoaderCompletionStatus status) {
      ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams _message =
          new ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams();
      _message.resourceLoadInfo = resourceLoadInfo;
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void notifyResourceLoadCanceled(long requestId) {
      ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams _message =
          new ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams();
      _message.requestId = requestId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void clone(InterfaceRequest<ResourceLoadInfoNotifier> pendingResourceLoadInfoNotifier) {
      ResourceLoadInfoNotifierCloneParams _message = new ResourceLoadInfoNotifierCloneParams();
      _message.pendingResourceLoadInfoNotifier = pendingResourceLoadInfoNotifier;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }
  }

  public static final class Stub extends Interface.Stub<ResourceLoadInfoNotifier> {
    Stub(Core core, ResourceLoadInfoNotifier impl) {
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
                ResourceLoadInfoNotifier_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().notifyUpdateUserGestureCarryoverInfo();
            return true;
          case 1:
            ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams data =
                ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().notifyResourceRedirectReceived(data.redirectInfo, data.redirectResponse);
            return true;
          case 2:
            ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams data2 =
                ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .notifyResourceResponseReceived(
                    data2.requestId,
                    data2.finalResponseUrl,
                    data2.head,
                    data2.requestDestination,
                    data2.isAdResource);
            return true;
          case 3:
            ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams data3 =
                ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().notifyResourceTransferSizeUpdated(data3.requestId, data3.transferSizeDiff);
            return true;
          case 4:
            ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams data4 =
                ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().notifyResourceLoadCompleted(data4.resourceLoadInfo, data4.status);
            return true;
          case 5:
            getImpl()
                .notifyResourceLoadCanceled(
                    ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams.deserialize(
                            messageWithHeader.getPayload())
                        .requestId);
            return true;
          case 6:
            getImpl()
                .clone(
                    ResourceLoadInfoNotifierCloneParams.deserialize(messageWithHeader.getPayload())
                        .pendingResourceLoadInfoNotifier);
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
                getCore(), ResourceLoadInfoNotifier_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams(int version) {
      super(8, version);
    }

    public ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams() {
      this(0);
    }

    public static ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams result =
            new ResourceLoadInfoNotifierNotifyUpdateUserGestureCarryoverInfoParams(
                elementsOrVersion);
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

  static final class ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UrlRequestRedirectInfo redirectInfo;
    public UrlResponseHead redirectResponse;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams(int version) {
      super(24, version);
    }

    public ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams() {
      this(0);
    }

    public static ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams result =
            new ResourceLoadInfoNotifierNotifyResourceRedirectReceivedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.redirectInfo = UrlRequestRedirectInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.redirectResponse = UrlResponseHead.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.redirectInfo, 8, false);
      encoder0.encode((Struct) this.redirectResponse, 16, false);
    }
  }

  static final class ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public SchemeHostPort finalResponseUrl;
    public UrlResponseHead head;
    public boolean isAdResource;
    public int requestDestination;
    public long requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams(int version) {
      super(40, version);
    }

    public ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams() {
      this(0);
    }

    public static ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams result =
            new ResourceLoadInfoNotifierNotifyResourceResponseReceivedParams(elementsOrVersion);
        result.requestId = decoder0.readLong(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.finalResponseUrl = SchemeHostPort.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.head = UrlResponseHead.decode(decoder12);
        int readInt = decoder0.readInt(32);
        result.requestDestination = readInt;
        RequestDestination.validate(readInt);
        result.requestDestination = RequestDestination.toKnownValue(result.requestDestination);
        result.isAdResource = decoder0.readBoolean(36, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode((Struct) this.finalResponseUrl, 16, false);
      encoder0.encode((Struct) this.head, 24, false);
      encoder0.encode(this.requestDestination, 32);
      encoder0.encode(this.isAdResource, 36, 0);
    }
  }

  static final class ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long requestId;
    public int transferSizeDiff;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams(int version) {
      super(24, version);
    }

    public ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams() {
      this(0);
    }

    public static ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams result =
            new ResourceLoadInfoNotifierNotifyResourceTransferSizeUpdatedParams(elementsOrVersion);
        result.requestId = decoder0.readLong(8);
        result.transferSizeDiff = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.transferSizeDiff, 16);
    }
  }

  static final class ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ResourceLoadInfo resourceLoadInfo;
    public UrlLoaderCompletionStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams(int version) {
      super(24, version);
    }

    public ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams() {
      this(0);
    }

    public static ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams result =
            new ResourceLoadInfoNotifierNotifyResourceLoadCompletedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.resourceLoadInfo = ResourceLoadInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.status = UrlLoaderCompletionStatus.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.resourceLoadInfo, 8, false);
      encoder0.encode((Struct) this.status, 16, false);
    }
  }

  static final class ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams(int version) {
      super(16, version);
    }

    public ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams() {
      this(0);
    }

    public static ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams result =
            new ResourceLoadInfoNotifierNotifyResourceLoadCanceledParams(elementsOrVersion);
        result.requestId = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
    }
  }

  static final class ResourceLoadInfoNotifierCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<ResourceLoadInfoNotifier> pendingResourceLoadInfoNotifier;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResourceLoadInfoNotifierCloneParams(int version) {
      super(16, version);
    }

    public ResourceLoadInfoNotifierCloneParams() {
      this(0);
    }

    public static ResourceLoadInfoNotifierCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ResourceLoadInfoNotifierCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResourceLoadInfoNotifierCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResourceLoadInfoNotifierCloneParams result =
            new ResourceLoadInfoNotifierCloneParams(elementsOrVersion);
        result.pendingResourceLoadInfoNotifier = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.pendingResourceLoadInfoNotifier, 8, false);
    }
  }
}
