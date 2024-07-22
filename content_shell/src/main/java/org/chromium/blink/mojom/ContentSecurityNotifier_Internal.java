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
import org.chromium.url.mojom.Url;

class ContentSecurityNotifier_Internal {
  public static final Interface.Manager<ContentSecurityNotifier, ContentSecurityNotifier.Proxy>
      MANAGER =
          new Interface.Manager<ContentSecurityNotifier, ContentSecurityNotifier.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ContentSecurityNotifier";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ContentSecurityNotifier.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ContentSecurityNotifier impl) {
              return new Stub(core, impl);
            }

            @Override
            public ContentSecurityNotifier[] buildArray(int size) {
              return new ContentSecurityNotifier[size];
            }
          };
  private static final int NOTIFY_CONTENT_WITH_CERTIFICATE_ERRORS_DISPLAYED_ORDINAL = 1;
  private static final int NOTIFY_CONTENT_WITH_CERTIFICATE_ERRORS_RAN_ORDINAL = 0;
  private static final int NOTIFY_INSECURE_CONTENT_RAN_ORDINAL = 2;

  ContentSecurityNotifier_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ContentSecurityNotifier.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void notifyContentWithCertificateErrorsRan() {
      ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams _message =
          new ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void notifyContentWithCertificateErrorsDisplayed() {
      ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams _message =
          new ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void notifyInsecureContentRan(Url origin, Url insecureUrl) {
      ContentSecurityNotifierNotifyInsecureContentRanParams _message =
          new ContentSecurityNotifierNotifyInsecureContentRanParams();
      _message.origin = origin;
      _message.insecureUrl = insecureUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<ContentSecurityNotifier> {
    Stub(Core core, ContentSecurityNotifier impl) {
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
                ContentSecurityNotifier_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().notifyContentWithCertificateErrorsRan();
            return true;
          case 1:
            ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().notifyContentWithCertificateErrorsDisplayed();
            return true;
          case 2:
            ContentSecurityNotifierNotifyInsecureContentRanParams data =
                ContentSecurityNotifierNotifyInsecureContentRanParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().notifyInsecureContentRan(data.origin, data.insecureUrl);
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
                getCore(), ContentSecurityNotifier_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams(int version) {
      super(8, version);
    }

    public ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams() {
      this(0);
    }

    public static ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams result =
            new ContentSecurityNotifierNotifyContentWithCertificateErrorsRanParams(
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

  static final class ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams(int version) {
      super(8, version);
    }

    public ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams() {
      this(0);
    }

    public static ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams result =
            new ContentSecurityNotifierNotifyContentWithCertificateErrorsDisplayedParams(
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

  static final class ContentSecurityNotifierNotifyInsecureContentRanParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url insecureUrl;
    public Url origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentSecurityNotifierNotifyInsecureContentRanParams(int version) {
      super(24, version);
    }

    public ContentSecurityNotifierNotifyInsecureContentRanParams() {
      this(0);
    }

    public static ContentSecurityNotifierNotifyInsecureContentRanParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentSecurityNotifierNotifyInsecureContentRanParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentSecurityNotifierNotifyInsecureContentRanParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentSecurityNotifierNotifyInsecureContentRanParams result =
            new ContentSecurityNotifierNotifyInsecureContentRanParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.insecureUrl = Url.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode((Struct) this.insecureUrl, 16, false);
    }
  }
}
