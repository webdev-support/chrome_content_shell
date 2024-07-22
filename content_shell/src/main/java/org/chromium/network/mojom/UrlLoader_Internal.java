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
import org.chromium.url.mojom.Url;

class UrlLoader_Internal {
  private static final int FOLLOW_REDIRECT_ORDINAL = 0;
  public static final Interface.Manager<UrlLoader, UrlLoader.Proxy> MANAGER =
      new Interface.Manager<UrlLoader, UrlLoader.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.URLLoader";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public UrlLoader.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, UrlLoader impl) {
          return new Stub(core, impl);
        }

        @Override
        public UrlLoader[] buildArray(int size) {
          return new UrlLoader[size];
        }
      };
  private static final int PAUSE_READING_BODY_FROM_NET_ORDINAL = 2;
  private static final int RESUME_READING_BODY_FROM_NET_ORDINAL = 3;
  private static final int SET_PRIORITY_ORDINAL = 1;

  UrlLoader_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements UrlLoader.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void followRedirect(
        String[] removedHeaders,
        HttpRequestHeaders modifiedHeaders,
        HttpRequestHeaders modifiedCorsExemptHeaders,
        Url newUrl) {
      UrlLoaderFollowRedirectParams _message = new UrlLoaderFollowRedirectParams();
      _message.removedHeaders = removedHeaders;
      _message.modifiedHeaders = modifiedHeaders;
      _message.modifiedCorsExemptHeaders = modifiedCorsExemptHeaders;
      _message.newUrl = newUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setPriority(int priority, int intraPriorityValue) {
      UrlLoaderSetPriorityParams _message = new UrlLoaderSetPriorityParams();
      _message.priority = priority;
      _message.intraPriorityValue = intraPriorityValue;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void pauseReadingBodyFromNet() {
      UrlLoaderPauseReadingBodyFromNetParams _message =
          new UrlLoaderPauseReadingBodyFromNetParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void resumeReadingBodyFromNet() {
      UrlLoaderResumeReadingBodyFromNetParams _message =
          new UrlLoaderResumeReadingBodyFromNetParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<UrlLoader> {
    Stub(Core core, UrlLoader impl) {
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
                UrlLoader_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            UrlLoaderFollowRedirectParams data =
                UrlLoaderFollowRedirectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .followRedirect(
                    data.removedHeaders,
                    data.modifiedHeaders,
                    data.modifiedCorsExemptHeaders,
                    data.newUrl);
            return true;
          case 1:
            UrlLoaderSetPriorityParams data2 =
                UrlLoaderSetPriorityParams.deserialize(messageWithHeader.getPayload());
            getImpl().setPriority(data2.priority, data2.intraPriorityValue);
            return true;
          case 2:
            UrlLoaderPauseReadingBodyFromNetParams.deserialize(messageWithHeader.getPayload());
            getImpl().pauseReadingBodyFromNet();
            return true;
          case 3:
            UrlLoaderResumeReadingBodyFromNetParams.deserialize(messageWithHeader.getPayload());
            getImpl().resumeReadingBodyFromNet();
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
                getCore(), UrlLoader_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class UrlLoaderFollowRedirectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public HttpRequestHeaders modifiedCorsExemptHeaders;
    public HttpRequestHeaders modifiedHeaders;
    public Url newUrl;
    public String[] removedHeaders;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderFollowRedirectParams(int version) {
      super(40, version);
    }

    public UrlLoaderFollowRedirectParams() {
      this(0);
    }

    public static UrlLoaderFollowRedirectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderFollowRedirectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderFollowRedirectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderFollowRedirectParams result = new UrlLoaderFollowRedirectParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.removedHeaders = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.removedHeaders[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        result.modifiedHeaders = HttpRequestHeaders.decode(decoder0.readPointer(16, false));
        result.modifiedCorsExemptHeaders =
            HttpRequestHeaders.decode(decoder0.readPointer(24, false));
        result.newUrl = Url.decode(decoder0.readPointer(32, true));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.removedHeaders;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          String[] strArr2 = this.removedHeaders;
          if (i0 >= strArr2.length) {
            break;
          }
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.modifiedHeaders, 16, false);
      encoder0.encode((Struct) this.modifiedCorsExemptHeaders, 24, false);
      encoder0.encode((Struct) this.newUrl, 32, true);
    }
  }

  static final class UrlLoaderSetPriorityParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int intraPriorityValue;
    public int priority;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderSetPriorityParams(int version) {
      super(16, version);
    }

    public UrlLoaderSetPriorityParams() {
      this(0);
    }

    public static UrlLoaderSetPriorityParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderSetPriorityParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderSetPriorityParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderSetPriorityParams result = new UrlLoaderSetPriorityParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.priority = readInt;
        RequestPriority.validate(readInt);
        result.priority = RequestPriority.toKnownValue(result.priority);
        result.intraPriorityValue = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.priority, 8);
      encoder0.encode(this.intraPriorityValue, 12);
    }
  }

  static final class UrlLoaderPauseReadingBodyFromNetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderPauseReadingBodyFromNetParams(int version) {
      super(8, version);
    }

    public UrlLoaderPauseReadingBodyFromNetParams() {
      this(0);
    }

    public static UrlLoaderPauseReadingBodyFromNetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderPauseReadingBodyFromNetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderPauseReadingBodyFromNetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderPauseReadingBodyFromNetParams result =
            new UrlLoaderPauseReadingBodyFromNetParams(elementsOrVersion);
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

  static final class UrlLoaderResumeReadingBodyFromNetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderResumeReadingBodyFromNetParams(int version) {
      super(8, version);
    }

    public UrlLoaderResumeReadingBodyFromNetParams() {
      this(0);
    }

    public static UrlLoaderResumeReadingBodyFromNetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderResumeReadingBodyFromNetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderResumeReadingBodyFromNetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderResumeReadingBodyFromNetParams result =
            new UrlLoaderResumeReadingBodyFromNetParams(elementsOrVersion);
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
