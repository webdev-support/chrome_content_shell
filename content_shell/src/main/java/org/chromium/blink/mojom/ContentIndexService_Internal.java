package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
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
import org.chromium.skia.mojom.BitmapN32;
import org.chromium.url.mojom.Url;

class ContentIndexService_Internal {
  private static final int ADD_ORDINAL = 2;
  private static final int CHECK_OFFLINE_CAPABILITY_ORDINAL = 1;
  private static final int DELETE_ORDINAL = 3;
  private static final int GET_DESCRIPTIONS_ORDINAL = 4;
  private static final int GET_ICON_SIZES_ORDINAL = 0;
  public static final Interface.Manager<ContentIndexService, ContentIndexService.Proxy> MANAGER =
      new Interface.Manager<ContentIndexService, ContentIndexService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ContentIndexService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ContentIndexService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ContentIndexService impl) {
          return new Stub(core, impl);
        }

        @Override
        public ContentIndexService[] buildArray(int size) {
          return new ContentIndexService[size];
        }
      };

  ContentIndexService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ContentIndexService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getIconSizes(int category, GetIconSizes_Response callback) {
      ContentIndexServiceGetIconSizesParams _message = new ContentIndexServiceGetIconSizesParams();
      _message.category = category;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ContentIndexServiceGetIconSizesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void checkOfflineCapability(
        long serviceWorkerRegistrationId, Url launchUrl, CheckOfflineCapability_Response callback) {
      ContentIndexServiceCheckOfflineCapabilityParams _message =
          new ContentIndexServiceCheckOfflineCapabilityParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.launchUrl = launchUrl;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ContentIndexServiceCheckOfflineCapabilityResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void add(
        long serviceWorkerRegistrationId,
        ContentDescription description,
        BitmapN32[] icon,
        Url launchUrl,
        Add_Response callback) {
      ContentIndexServiceAddParams _message = new ContentIndexServiceAddParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.description = description;
      _message.icon = icon;
      _message.launchUrl = launchUrl;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ContentIndexServiceAddResponseParamsForwardToCallback(callback));
    }

    @Override
    public void delete(long serviceWorkerRegistrationId, String id, Delete_Response callback) {
      ContentIndexServiceDeleteParams _message = new ContentIndexServiceDeleteParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new ContentIndexServiceDeleteResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getDescriptions(
        long serviceWorkerRegistrationId, GetDescriptions_Response callback) {
      ContentIndexServiceGetDescriptionsParams _message =
          new ContentIndexServiceGetDescriptionsParams();
      _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new ContentIndexServiceGetDescriptionsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ContentIndexService> {
    Stub(Core core, ContentIndexService impl) {
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
                ContentIndexService_Internal.MANAGER, messageWithHeader);
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
                getCore(), ContentIndexService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .getIconSizes(
                    ContentIndexServiceGetIconSizesParams.deserialize(
                            messageWithHeader.getPayload())
                        .category,
                    new ContentIndexServiceGetIconSizesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            ContentIndexServiceCheckOfflineCapabilityParams data =
                ContentIndexServiceCheckOfflineCapabilityParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .checkOfflineCapability(
                    data.serviceWorkerRegistrationId,
                    data.launchUrl,
                    new ContentIndexServiceCheckOfflineCapabilityResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            ContentIndexServiceAddParams data2 =
                ContentIndexServiceAddParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .add(
                    data2.serviceWorkerRegistrationId,
                    data2.description,
                    data2.icon,
                    data2.launchUrl,
                    new ContentIndexServiceAddResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            ContentIndexServiceDeleteParams data3 =
                ContentIndexServiceDeleteParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .delete(
                    data3.serviceWorkerRegistrationId,
                    data3.id,
                    new ContentIndexServiceDeleteResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            ContentIndexServiceGetDescriptionsParams data4 =
                ContentIndexServiceGetDescriptionsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getDescriptions(
                    data4.serviceWorkerRegistrationId,
                    new ContentIndexServiceGetDescriptionsResponseParamsProxyToResponder(
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

  static final class ContentIndexServiceGetIconSizesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int category;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceGetIconSizesParams(int version) {
      super(16, version);
    }

    public ContentIndexServiceGetIconSizesParams() {
      this(0);
    }

    public static ContentIndexServiceGetIconSizesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceGetIconSizesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceGetIconSizesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceGetIconSizesParams result =
            new ContentIndexServiceGetIconSizesParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.category = readInt;
        ContentCategory.validate(readInt);
        result.category = ContentCategory.toKnownValue(result.category);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.category, 8);
    }
  }

  static final class ContentIndexServiceGetIconSizesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Size[] iconSizes;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceGetIconSizesResponseParams(int version) {
      super(16, version);
    }

    public ContentIndexServiceGetIconSizesResponseParams() {
      this(0);
    }

    public static ContentIndexServiceGetIconSizesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceGetIconSizesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceGetIconSizesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceGetIconSizesResponseParams result =
            new ContentIndexServiceGetIconSizesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.iconSizes = new Size[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.iconSizes[i1] = Size.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Size[] sizeArr = this.iconSizes;
      if (sizeArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(sizeArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Size[] sizeArr2 = this.iconSizes;
        if (i0 < sizeArr2.length) {
          encoder1.encode((Struct) sizeArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class ContentIndexServiceGetIconSizesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentIndexService.GetIconSizes_Response mCallback;

    ContentIndexServiceGetIconSizesResponseParamsForwardToCallback(
        ContentIndexService.GetIconSizes_Response callback) {
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
        ContentIndexServiceGetIconSizesResponseParams response =
            ContentIndexServiceGetIconSizesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.iconSizes);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentIndexServiceGetIconSizesResponseParamsProxyToResponder
      implements ContentIndexService.GetIconSizes_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentIndexServiceGetIconSizesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Size[] iconSizes) {
      ContentIndexServiceGetIconSizesResponseParams _response =
          new ContentIndexServiceGetIconSizesResponseParams();
      _response.iconSizes = iconSizes;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentIndexServiceCheckOfflineCapabilityParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url launchUrl;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceCheckOfflineCapabilityParams(int version) {
      super(24, version);
    }

    public ContentIndexServiceCheckOfflineCapabilityParams() {
      this(0);
    }

    public static ContentIndexServiceCheckOfflineCapabilityParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceCheckOfflineCapabilityParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceCheckOfflineCapabilityParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceCheckOfflineCapabilityParams result =
            new ContentIndexServiceCheckOfflineCapabilityParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.launchUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      encoder0.encode((Struct) this.launchUrl, 16, false);
    }
  }

  static final class ContentIndexServiceCheckOfflineCapabilityResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isOfflineCapable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceCheckOfflineCapabilityResponseParams(int version) {
      super(16, version);
    }

    public ContentIndexServiceCheckOfflineCapabilityResponseParams() {
      this(0);
    }

    public static ContentIndexServiceCheckOfflineCapabilityResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceCheckOfflineCapabilityResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceCheckOfflineCapabilityResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceCheckOfflineCapabilityResponseParams result =
            new ContentIndexServiceCheckOfflineCapabilityResponseParams(elementsOrVersion);
        result.isOfflineCapable = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isOfflineCapable, 8, 0);
    }
  }

  static class ContentIndexServiceCheckOfflineCapabilityResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentIndexService.CheckOfflineCapability_Response mCallback;

    ContentIndexServiceCheckOfflineCapabilityResponseParamsForwardToCallback(
        ContentIndexService.CheckOfflineCapability_Response callback) {
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
        ContentIndexServiceCheckOfflineCapabilityResponseParams response =
            ContentIndexServiceCheckOfflineCapabilityResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.isOfflineCapable);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentIndexServiceCheckOfflineCapabilityResponseParamsProxyToResponder
      implements ContentIndexService.CheckOfflineCapability_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentIndexServiceCheckOfflineCapabilityResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean isOfflineCapable) {
      ContentIndexServiceCheckOfflineCapabilityResponseParams _response =
          new ContentIndexServiceCheckOfflineCapabilityResponseParams();
      _response.isOfflineCapable = isOfflineCapable;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentIndexServiceAddParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public ContentDescription description;
    public BitmapN32[] icon;
    public Url launchUrl;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceAddParams(int version) {
      super(40, version);
    }

    public ContentIndexServiceAddParams() {
      this(0);
    }

    public static ContentIndexServiceAddParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceAddParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceAddParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceAddParams result = new ContentIndexServiceAddParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        result.description = ContentDescription.decode(decoder0.readPointer(16, false));
        Decoder decoder1 = decoder0.readPointer(24, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.icon = new BitmapN32[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.icon[i1] = BitmapN32.decode(decoder2);
        }
        result.launchUrl = Url.decode(decoder0.readPointer(32, false));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      encoder0.encode((Struct) this.description, 16, false);
      BitmapN32[] bitmapN32Arr = this.icon;
      if (bitmapN32Arr == null) {
        encoder0.encodeNullPointer(24, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(bitmapN32Arr.length, 24, -1);
        int i0 = 0;
        while (true) {
          BitmapN32[] bitmapN32Arr2 = this.icon;
          if (i0 >= bitmapN32Arr2.length) {
            break;
          }
          encoder1.encode((Struct) bitmapN32Arr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.launchUrl, 32, false);
    }
  }

  static final class ContentIndexServiceAddResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceAddResponseParams(int version) {
      super(16, version);
    }

    public ContentIndexServiceAddResponseParams() {
      this(0);
    }

    public static ContentIndexServiceAddResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceAddResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceAddResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceAddResponseParams result =
            new ContentIndexServiceAddResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ContentIndexError.validate(readInt);
        result.error = ContentIndexError.toKnownValue(result.error);
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

  static class ContentIndexServiceAddResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ContentIndexService.Add_Response mCallback;

    ContentIndexServiceAddResponseParamsForwardToCallback(
        ContentIndexService.Add_Response callback) {
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
        ContentIndexServiceAddResponseParams response =
            ContentIndexServiceAddResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentIndexServiceAddResponseParamsProxyToResponder
      implements ContentIndexService.Add_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentIndexServiceAddResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error) {
      ContentIndexServiceAddResponseParams _response = new ContentIndexServiceAddResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentIndexServiceDeleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String id;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceDeleteParams(int version) {
      super(24, version);
    }

    public ContentIndexServiceDeleteParams() {
      this(0);
    }

    public static ContentIndexServiceDeleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceDeleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceDeleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceDeleteParams result =
            new ContentIndexServiceDeleteParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        result.id = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
      encoder0.encode(this.id, 16, false);
    }
  }

  static final class ContentIndexServiceDeleteResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceDeleteResponseParams(int version) {
      super(16, version);
    }

    public ContentIndexServiceDeleteResponseParams() {
      this(0);
    }

    public static ContentIndexServiceDeleteResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceDeleteResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceDeleteResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceDeleteResponseParams result =
            new ContentIndexServiceDeleteResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ContentIndexError.validate(readInt);
        result.error = ContentIndexError.toKnownValue(result.error);
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

  static class ContentIndexServiceDeleteResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentIndexService.Delete_Response mCallback;

    ContentIndexServiceDeleteResponseParamsForwardToCallback(
        ContentIndexService.Delete_Response callback) {
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
        ContentIndexServiceDeleteResponseParams response =
            ContentIndexServiceDeleteResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentIndexServiceDeleteResponseParamsProxyToResponder
      implements ContentIndexService.Delete_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentIndexServiceDeleteResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error) {
      ContentIndexServiceDeleteResponseParams _response =
          new ContentIndexServiceDeleteResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ContentIndexServiceGetDescriptionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long serviceWorkerRegistrationId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceGetDescriptionsParams(int version) {
      super(16, version);
    }

    public ContentIndexServiceGetDescriptionsParams() {
      this(0);
    }

    public static ContentIndexServiceGetDescriptionsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceGetDescriptionsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceGetDescriptionsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceGetDescriptionsParams result =
            new ContentIndexServiceGetDescriptionsParams(elementsOrVersion);
        result.serviceWorkerRegistrationId = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceWorkerRegistrationId, 8);
    }
  }

  static final class ContentIndexServiceGetDescriptionsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ContentDescription[] descriptions;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentIndexServiceGetDescriptionsResponseParams(int version) {
      super(24, version);
    }

    public ContentIndexServiceGetDescriptionsResponseParams() {
      this(0);
    }

    public static ContentIndexServiceGetDescriptionsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentIndexServiceGetDescriptionsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentIndexServiceGetDescriptionsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentIndexServiceGetDescriptionsResponseParams result =
            new ContentIndexServiceGetDescriptionsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ContentIndexError.validate(readInt);
        result.error = ContentIndexError.toKnownValue(result.error);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.descriptions = new ContentDescription[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.descriptions[i1] = ContentDescription.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      ContentDescription[] contentDescriptionArr = this.descriptions;
      if (contentDescriptionArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(contentDescriptionArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        ContentDescription[] contentDescriptionArr2 = this.descriptions;
        if (i0 < contentDescriptionArr2.length) {
          encoder1.encode((Struct) contentDescriptionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class ContentIndexServiceGetDescriptionsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ContentIndexService.GetDescriptions_Response mCallback;

    ContentIndexServiceGetDescriptionsResponseParamsForwardToCallback(
        ContentIndexService.GetDescriptions_Response callback) {
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
        ContentIndexServiceGetDescriptionsResponseParams response =
            ContentIndexServiceGetDescriptionsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.descriptions);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContentIndexServiceGetDescriptionsResponseParamsProxyToResponder
      implements ContentIndexService.GetDescriptions_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContentIndexServiceGetDescriptionsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, ContentDescription[] descriptions) {
      ContentIndexServiceGetDescriptionsResponseParams _response =
          new ContentIndexServiceGetDescriptionsResponseParams();
      _response.error = error;
      _response.descriptions = descriptions;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
