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
import org.chromium.mojo_base.mojom.ReadOnlyFile;

class Hyphenation_Internal {
  public static final Interface.Manager<Hyphenation, Hyphenation.Proxy> MANAGER =
      new Interface.Manager<Hyphenation, Hyphenation.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.Hyphenation";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Hyphenation.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Hyphenation impl) {
          return new Stub(core, impl);
        }

        @Override
        public Hyphenation[] buildArray(int size) {
          return new Hyphenation[size];
        }
      };
  private static final int OPEN_DICTIONARY_ORDINAL = 0;

  Hyphenation_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Hyphenation.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void openDictionary(String locale, OpenDictionary_Response callback) {
      HyphenationOpenDictionaryParams _message = new HyphenationOpenDictionaryParams();
      _message.locale = locale;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new HyphenationOpenDictionaryResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<Hyphenation> {
    Stub(Core core, Hyphenation impl) {
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
                Hyphenation_Internal.MANAGER, messageWithHeader);
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
                getCore(), Hyphenation_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            HyphenationOpenDictionaryParams data =
                HyphenationOpenDictionaryParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .openDictionary(
                    data.locale,
                    new HyphenationOpenDictionaryResponseParamsProxyToResponder(
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

  static final class HyphenationOpenDictionaryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String locale;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HyphenationOpenDictionaryParams(int version) {
      super(16, version);
    }

    public HyphenationOpenDictionaryParams() {
      this(0);
    }

    public static HyphenationOpenDictionaryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HyphenationOpenDictionaryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HyphenationOpenDictionaryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HyphenationOpenDictionaryParams result =
            new HyphenationOpenDictionaryParams(elementsOrVersion);
        result.locale = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.locale, 8, false);
    }
  }

  static final class HyphenationOpenDictionaryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyFile hyphenationDictionaryHandle;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HyphenationOpenDictionaryResponseParams(int version) {
      super(16, version);
    }

    public HyphenationOpenDictionaryResponseParams() {
      this(0);
    }

    public static HyphenationOpenDictionaryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HyphenationOpenDictionaryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HyphenationOpenDictionaryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HyphenationOpenDictionaryResponseParams result =
            new HyphenationOpenDictionaryResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.hyphenationDictionaryHandle = ReadOnlyFile.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.hyphenationDictionaryHandle, 8, true);
    }
  }

  static class HyphenationOpenDictionaryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Hyphenation.OpenDictionary_Response mCallback;

    HyphenationOpenDictionaryResponseParamsForwardToCallback(
        Hyphenation.OpenDictionary_Response callback) {
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
        HyphenationOpenDictionaryResponseParams response =
            HyphenationOpenDictionaryResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.hyphenationDictionaryHandle);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HyphenationOpenDictionaryResponseParamsProxyToResponder
      implements Hyphenation.OpenDictionary_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HyphenationOpenDictionaryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ReadOnlyFile hyphenationDictionaryHandle) {
      HyphenationOpenDictionaryResponseParams _response =
          new HyphenationOpenDictionaryResponseParams();
      _response.hyphenationDictionaryHandle = hyphenationDictionaryHandle;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
