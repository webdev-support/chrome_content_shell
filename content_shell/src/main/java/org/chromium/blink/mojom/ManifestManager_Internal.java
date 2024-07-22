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
import org.chromium.url.mojom.Url;

class ManifestManager_Internal {
  public static final Interface.Manager<ManifestManager, ManifestManager.Proxy> MANAGER =
      new Interface.Manager<ManifestManager, ManifestManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ManifestManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ManifestManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ManifestManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public ManifestManager[] buildArray(int size) {
          return new ManifestManager[size];
        }
      };
  private static final int PARSE_MANIFEST_FROM_STRING_ORDINAL = 2;
  private static final int REQUEST_MANIFEST_DEBUG_INFO_ORDINAL = 1;
  private static final int REQUEST_MANIFEST_ORDINAL = 0;

  ManifestManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements ManifestManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestManifest(RequestManifest_Response callback) {
      ManifestManagerRequestManifestParams _message = new ManifestManagerRequestManifestParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ManifestManagerRequestManifestResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestManifestDebugInfo(RequestManifestDebugInfo_Response callback) {
      ManifestManagerRequestManifestDebugInfoParams _message =
          new ManifestManagerRequestManifestDebugInfoParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ManifestManagerRequestManifestDebugInfoResponseParamsForwardToCallback(callback));
    }

    @Override
    public void parseManifestFromString(
        Url documentUrl,
        Url manifestUrl,
        String manifestContent,
        ParseManifestFromString_Response callback) {
      ManifestManagerParseManifestFromStringParams _message =
          new ManifestManagerParseManifestFromStringParams();
      _message.documentUrl = documentUrl;
      _message.manifestUrl = manifestUrl;
      _message.manifestContent = manifestContent;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ManifestManagerParseManifestFromStringResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ManifestManager> {
    Stub(Core core, ManifestManager impl) {
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
                ManifestManager_Internal.MANAGER, messageWithHeader);
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
                getCore(), ManifestManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ManifestManagerRequestManifestParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestManifest(
                    new ManifestManagerRequestManifestResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            ManifestManagerRequestManifestDebugInfoParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .requestManifestDebugInfo(
                    new ManifestManagerRequestManifestDebugInfoResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            ManifestManagerParseManifestFromStringParams data =
                ManifestManagerParseManifestFromStringParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .parseManifestFromString(
                    data.documentUrl,
                    data.manifestUrl,
                    data.manifestContent,
                    new ManifestManagerParseManifestFromStringResponseParamsProxyToResponder(
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

  static final class ManifestManagerRequestManifestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManifestManagerRequestManifestParams(int version) {
      super(8, version);
    }

    public ManifestManagerRequestManifestParams() {
      this(0);
    }

    public static ManifestManagerRequestManifestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ManifestManagerRequestManifestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestManagerRequestManifestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManifestManagerRequestManifestParams result =
            new ManifestManagerRequestManifestParams(elementsOrVersion);
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

  static final class ManifestManagerRequestManifestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Manifest_ manifest;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManifestManagerRequestManifestResponseParams(int version) {
      super(24, version);
    }

    public ManifestManagerRequestManifestResponseParams() {
      this(0);
    }

    public static ManifestManagerRequestManifestResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ManifestManagerRequestManifestResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestManagerRequestManifestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManifestManagerRequestManifestResponseParams result =
            new ManifestManagerRequestManifestResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.manifest = Manifest_.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.manifest, 16, true);
    }
  }

  static class ManifestManagerRequestManifestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ManifestManager.RequestManifest_Response mCallback;

    ManifestManagerRequestManifestResponseParamsForwardToCallback(
        ManifestManager.RequestManifest_Response callback) {
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
        ManifestManagerRequestManifestResponseParams response =
            ManifestManagerRequestManifestResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.url, response.manifest);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ManifestManagerRequestManifestResponseParamsProxyToResponder
      implements ManifestManager.RequestManifest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ManifestManagerRequestManifestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Url url, Manifest_ manifest) {
      ManifestManagerRequestManifestResponseParams _response =
          new ManifestManagerRequestManifestResponseParams();
      _response.url = url;
      _response.manifest = manifest;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ManifestManagerRequestManifestDebugInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManifestManagerRequestManifestDebugInfoParams(int version) {
      super(8, version);
    }

    public ManifestManagerRequestManifestDebugInfoParams() {
      this(0);
    }

    public static ManifestManagerRequestManifestDebugInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ManifestManagerRequestManifestDebugInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestManagerRequestManifestDebugInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManifestManagerRequestManifestDebugInfoParams result =
            new ManifestManagerRequestManifestDebugInfoParams(elementsOrVersion);
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

  static final class ManifestManagerRequestManifestDebugInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ManifestDebugInfo debugInfo;
    public Manifest_ parsedManifest;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManifestManagerRequestManifestDebugInfoResponseParams(int version) {
      super(32, version);
    }

    public ManifestManagerRequestManifestDebugInfoResponseParams() {
      this(0);
    }

    public static ManifestManagerRequestManifestDebugInfoResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ManifestManagerRequestManifestDebugInfoResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestManagerRequestManifestDebugInfoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManifestManagerRequestManifestDebugInfoResponseParams result =
            new ManifestManagerRequestManifestDebugInfoResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.parsedManifest = Manifest_.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.debugInfo = ManifestDebugInfo.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.parsedManifest, 16, true);
      encoder0.encode((Struct) this.debugInfo, 24, true);
    }
  }

  static class ManifestManagerRequestManifestDebugInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ManifestManager.RequestManifestDebugInfo_Response mCallback;

    ManifestManagerRequestManifestDebugInfoResponseParamsForwardToCallback(
        ManifestManager.RequestManifestDebugInfo_Response callback) {
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
        ManifestManagerRequestManifestDebugInfoResponseParams response =
            ManifestManagerRequestManifestDebugInfoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.url, response.parsedManifest, response.debugInfo);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ManifestManagerRequestManifestDebugInfoResponseParamsProxyToResponder
      implements ManifestManager.RequestManifestDebugInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ManifestManagerRequestManifestDebugInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Url url, Manifest_ parsedManifest, ManifestDebugInfo debugInfo) {
      ManifestManagerRequestManifestDebugInfoResponseParams _response =
          new ManifestManagerRequestManifestDebugInfoResponseParams();
      _response.url = url;
      _response.parsedManifest = parsedManifest;
      _response.debugInfo = debugInfo;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ManifestManagerParseManifestFromStringParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Url documentUrl;
    public String manifestContent;
    public Url manifestUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManifestManagerParseManifestFromStringParams(int version) {
      super(32, version);
    }

    public ManifestManagerParseManifestFromStringParams() {
      this(0);
    }

    public static ManifestManagerParseManifestFromStringParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ManifestManagerParseManifestFromStringParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestManagerParseManifestFromStringParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManifestManagerParseManifestFromStringParams result =
            new ManifestManagerParseManifestFromStringParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.documentUrl = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.manifestUrl = Url.decode(decoder12);
        result.manifestContent = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.documentUrl, 8, false);
      encoder0.encode((Struct) this.manifestUrl, 16, false);
      encoder0.encode(this.manifestContent, 24, false);
    }
  }

  static final class ManifestManagerParseManifestFromStringResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Manifest_ parsedManifest;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ManifestManagerParseManifestFromStringResponseParams(int version) {
      super(16, version);
    }

    public ManifestManagerParseManifestFromStringResponseParams() {
      this(0);
    }

    public static ManifestManagerParseManifestFromStringResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ManifestManagerParseManifestFromStringResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestManagerParseManifestFromStringResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ManifestManagerParseManifestFromStringResponseParams result =
            new ManifestManagerParseManifestFromStringResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.parsedManifest = Manifest_.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.parsedManifest, 8, true);
    }
  }

  static class ManifestManagerParseManifestFromStringResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ManifestManager.ParseManifestFromString_Response mCallback;

    ManifestManagerParseManifestFromStringResponseParamsForwardToCallback(
        ManifestManager.ParseManifestFromString_Response callback) {
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
        ManifestManagerParseManifestFromStringResponseParams response =
            ManifestManagerParseManifestFromStringResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.parsedManifest);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ManifestManagerParseManifestFromStringResponseParamsProxyToResponder
      implements ManifestManager.ParseManifestFromString_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ManifestManagerParseManifestFromStringResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Manifest_ parsedManifest) {
      ManifestManagerParseManifestFromStringResponseParams _response =
          new ManifestManagerParseManifestFromStringResponseParams();
      _response.parsedManifest = parsedManifest;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
