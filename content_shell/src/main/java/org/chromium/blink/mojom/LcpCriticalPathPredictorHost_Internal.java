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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.ByteString;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

class LcpCriticalPathPredictorHost_Internal {
  public static final Interface.Manager<
          LcpCriticalPathPredictorHost, LcpCriticalPathPredictorHost.Proxy>
      MANAGER =
          new Interface.Manager<
              LcpCriticalPathPredictorHost, LcpCriticalPathPredictorHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.LCPCriticalPathPredictorHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public LcpCriticalPathPredictorHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, LcpCriticalPathPredictorHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public LcpCriticalPathPredictorHost[] buildArray(int size) {
              return new LcpCriticalPathPredictorHost[size];
            }
          };
  private static final int NOTIFY_FETCHED_FONT_ORDINAL = 3;
  private static final int NOTIFY_FETCHED_SUBRESOURCE_ORDINAL = 4;
  private static final int SET_LCP_ELEMENT_LOCATOR_ORDINAL = 0;
  private static final int SET_LCP_INFLUENCER_SCRIPT_URLS_ORDINAL = 1;
  private static final int SET_PRECONNECT_ORIGINS_ORDINAL = 2;

  LcpCriticalPathPredictorHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements LcpCriticalPathPredictorHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setLcpElementLocator(ByteString lcpElementLocator, Integer predictedLcpIndex) {
      LcpCriticalPathPredictorHostSetLcpElementLocatorParams _message =
          new LcpCriticalPathPredictorHostSetLcpElementLocatorParams();
      _message.lcpElementLocator = lcpElementLocator;
      _message.predictedLcpIndex = predictedLcpIndex;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setLcpInfluencerScriptUrls(Url[] lcpInfluencerScripts) {
      LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams _message =
          new LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams();
      _message.lcpInfluencerScripts = lcpInfluencerScripts;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setPreconnectOrigins(Url[] origins) {
      LcpCriticalPathPredictorHostSetPreconnectOriginsParams _message =
          new LcpCriticalPathPredictorHostSetPreconnectOriginsParams();
      _message.origins = origins;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void notifyFetchedFont(Url fontUrl) {
      LcpCriticalPathPredictorHostNotifyFetchedFontParams _message =
          new LcpCriticalPathPredictorHostNotifyFetchedFontParams();
      _message.fontUrl = fontUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void notifyFetchedSubresource(Url subresourceUrl, TimeDelta subresourceLoadStart) {
      LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams _message =
          new LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams();
      _message.subresourceUrl = subresourceUrl;
      _message.subresourceLoadStart = subresourceLoadStart;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<LcpCriticalPathPredictorHost> {
    Stub(Core core, LcpCriticalPathPredictorHost impl) {
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
                LcpCriticalPathPredictorHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            LcpCriticalPathPredictorHostSetLcpElementLocatorParams data =
                LcpCriticalPathPredictorHostSetLcpElementLocatorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setLcpElementLocator(data.lcpElementLocator, data.predictedLcpIndex);
            return true;
          case 1:
            getImpl()
                .setLcpInfluencerScriptUrls(
                    LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams.deserialize(
                            messageWithHeader.getPayload())
                        .lcpInfluencerScripts);
            return true;
          case 2:
            getImpl()
                .setPreconnectOrigins(
                    LcpCriticalPathPredictorHostSetPreconnectOriginsParams.deserialize(
                            messageWithHeader.getPayload())
                        .origins);
            return true;
          case 3:
            getImpl()
                .notifyFetchedFont(
                    LcpCriticalPathPredictorHostNotifyFetchedFontParams.deserialize(
                            messageWithHeader.getPayload())
                        .fontUrl);
            return true;
          case 4:
            LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams data2 =
                LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().notifyFetchedSubresource(data2.subresourceUrl, data2.subresourceLoadStart);
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
                getCore(),
                LcpCriticalPathPredictorHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class LcpCriticalPathPredictorHostSetLcpElementLocatorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ByteString lcpElementLocator;
    public Integer predictedLcpIndex;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LcpCriticalPathPredictorHostSetLcpElementLocatorParams(int version) {
      super(24, version);
    }

    public LcpCriticalPathPredictorHostSetLcpElementLocatorParams() {
      this(0);
    }

    public static LcpCriticalPathPredictorHostSetLcpElementLocatorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LcpCriticalPathPredictorHostSetLcpElementLocatorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LcpCriticalPathPredictorHostSetLcpElementLocatorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LcpCriticalPathPredictorHostSetLcpElementLocatorParams result =
            new LcpCriticalPathPredictorHostSetLcpElementLocatorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.lcpElementLocator = ByteString.decode(decoder1);
        if (decoder0.readBoolean(16, 0)) {
          result.predictedLcpIndex = new Integer(decoder0.readInt(20));
        } else {
          result.predictedLcpIndex = null;
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      int predictedLcpIndex$value;
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.lcpElementLocator, 8, false);
      Integer num = this.predictedLcpIndex;
      boolean predictedLcpIndex$flag = num != null;
      if (predictedLcpIndex$flag) {
        predictedLcpIndex$value = num.intValue();
      } else {
        predictedLcpIndex$value = 0;
      }
      encoder0.encode(predictedLcpIndex$flag, 16, 0);
      encoder0.encode(predictedLcpIndex$value, 20);
    }
  }

  static final class LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url[] lcpInfluencerScripts;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams(int version) {
      super(16, version);
    }

    public LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams() {
      this(0);
    }

    public static LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams result =
            new LcpCriticalPathPredictorHostSetLcpInfluencerScriptUrlsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.lcpInfluencerScripts = new Url[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.lcpInfluencerScripts[i1] = Url.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Url[] urlArr = this.lcpInfluencerScripts;
      if (urlArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.lcpInfluencerScripts;
        if (i0 < urlArr2.length) {
          encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class LcpCriticalPathPredictorHostSetPreconnectOriginsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url[] origins;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LcpCriticalPathPredictorHostSetPreconnectOriginsParams(int version) {
      super(16, version);
    }

    public LcpCriticalPathPredictorHostSetPreconnectOriginsParams() {
      this(0);
    }

    public static LcpCriticalPathPredictorHostSetPreconnectOriginsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LcpCriticalPathPredictorHostSetPreconnectOriginsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LcpCriticalPathPredictorHostSetPreconnectOriginsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LcpCriticalPathPredictorHostSetPreconnectOriginsParams result =
            new LcpCriticalPathPredictorHostSetPreconnectOriginsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.origins = new Url[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.origins[i1] = Url.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Url[] urlArr = this.origins;
      if (urlArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.origins;
        if (i0 < urlArr2.length) {
          encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class LcpCriticalPathPredictorHostNotifyFetchedFontParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url fontUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LcpCriticalPathPredictorHostNotifyFetchedFontParams(int version) {
      super(16, version);
    }

    public LcpCriticalPathPredictorHostNotifyFetchedFontParams() {
      this(0);
    }

    public static LcpCriticalPathPredictorHostNotifyFetchedFontParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LcpCriticalPathPredictorHostNotifyFetchedFontParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LcpCriticalPathPredictorHostNotifyFetchedFontParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LcpCriticalPathPredictorHostNotifyFetchedFontParams result =
            new LcpCriticalPathPredictorHostNotifyFetchedFontParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.fontUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.fontUrl, 8, false);
    }
  }

  static final class LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta subresourceLoadStart;
    public Url subresourceUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams(int version) {
      super(24, version);
    }

    public LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams() {
      this(0);
    }

    public static LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams result =
            new LcpCriticalPathPredictorHostNotifyFetchedSubresourceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.subresourceUrl = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.subresourceLoadStart = TimeDelta.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.subresourceUrl, 8, false);
      encoder0.encode((Struct) this.subresourceLoadStart, 16, false);
    }
  }
}
