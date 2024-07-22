package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
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

class TextFragmentReceiver_Internal {
  private static final int CANCEL_ORDINAL = 0;
  private static final int EXTRACT_FIRST_FRAGMENT_RECT_ORDINAL = 5;
  private static final int EXTRACT_TEXT_FRAGMENTS_MATCHES_ORDINAL = 3;
  private static final int GET_EXISTING_SELECTORS_ORDINAL = 4;
  public static final Interface.Manager<TextFragmentReceiver, TextFragmentReceiver.Proxy> MANAGER =
      new Interface.Manager<TextFragmentReceiver, TextFragmentReceiver.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.TextFragmentReceiver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public TextFragmentReceiver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, TextFragmentReceiver impl) {
          return new Stub(core, impl);
        }

        @Override
        public TextFragmentReceiver[] buildArray(int size) {
          return new TextFragmentReceiver[size];
        }
      };
  private static final int REMOVE_FRAGMENTS_ORDINAL = 2;
  private static final int REQUEST_SELECTOR_ORDINAL = 1;

  TextFragmentReceiver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements TextFragmentReceiver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void cancel() {
      TextFragmentReceiverCancelParams _message = new TextFragmentReceiverCancelParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void requestSelector(RequestSelector_Response callback) {
      TextFragmentReceiverRequestSelectorParams _message =
          new TextFragmentReceiverRequestSelectorParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new TextFragmentReceiverRequestSelectorResponseParamsForwardToCallback(callback));
    }

    @Override
    public void removeFragments() {
      TextFragmentReceiverRemoveFragmentsParams _message =
          new TextFragmentReceiverRemoveFragmentsParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void extractTextFragmentsMatches(ExtractTextFragmentsMatches_Response callback) {
      TextFragmentReceiverExtractTextFragmentsMatchesParams _message =
          new TextFragmentReceiverExtractTextFragmentsMatchesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new TextFragmentReceiverExtractTextFragmentsMatchesResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getExistingSelectors(GetExistingSelectors_Response callback) {
      TextFragmentReceiverGetExistingSelectorsParams _message =
          new TextFragmentReceiverGetExistingSelectorsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new TextFragmentReceiverGetExistingSelectorsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void extractFirstFragmentRect(ExtractFirstFragmentRect_Response callback) {
      TextFragmentReceiverExtractFirstFragmentRectParams _message =
          new TextFragmentReceiverExtractFirstFragmentRectParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new TextFragmentReceiverExtractFirstFragmentRectResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<TextFragmentReceiver> {
    Stub(Core core, TextFragmentReceiver impl) {
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
                TextFragmentReceiver_Internal.MANAGER, messageWithHeader);
          case -1:
          case 1:
          default:
            return false;
          case 0:
            TextFragmentReceiverCancelParams.deserialize(messageWithHeader.getPayload());
            getImpl().cancel();
            return true;
          case 2:
            TextFragmentReceiverRemoveFragmentsParams.deserialize(messageWithHeader.getPayload());
            getImpl().removeFragments();
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
                getCore(), TextFragmentReceiver_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 2:
          default:
            return false;
          case 1:
            TextFragmentReceiverRequestSelectorParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestSelector(
                    new TextFragmentReceiverRequestSelectorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            TextFragmentReceiverExtractTextFragmentsMatchesParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .extractTextFragmentsMatches(
                    new TextFragmentReceiverExtractTextFragmentsMatchesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            TextFragmentReceiverGetExistingSelectorsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getExistingSelectors(
                    new TextFragmentReceiverGetExistingSelectorsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            TextFragmentReceiverExtractFirstFragmentRectParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .extractFirstFragmentRect(
                    new TextFragmentReceiverExtractFirstFragmentRectResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class TextFragmentReceiverCancelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverCancelParams(int version) {
      super(8, version);
    }

    public TextFragmentReceiverCancelParams() {
      this(0);
    }

    public static TextFragmentReceiverCancelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverCancelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverCancelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverCancelParams result =
            new TextFragmentReceiverCancelParams(elementsOrVersion);
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

  static final class TextFragmentReceiverRequestSelectorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverRequestSelectorParams(int version) {
      super(8, version);
    }

    public TextFragmentReceiverRequestSelectorParams() {
      this(0);
    }

    public static TextFragmentReceiverRequestSelectorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverRequestSelectorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverRequestSelectorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverRequestSelectorParams result =
            new TextFragmentReceiverRequestSelectorParams(elementsOrVersion);
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

  static final class TextFragmentReceiverRequestSelectorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public int readyStatus;
    public String selector;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverRequestSelectorResponseParams(int version) {
      super(24, version);
    }

    public TextFragmentReceiverRequestSelectorResponseParams() {
      this(0);
    }

    public static TextFragmentReceiverRequestSelectorResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverRequestSelectorResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverRequestSelectorResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverRequestSelectorResponseParams result =
            new TextFragmentReceiverRequestSelectorResponseParams(elementsOrVersion);
        result.selector = decoder0.readString(8, false);
        int readInt = decoder0.readInt(16);
        result.error = readInt;
        LinkGenerationError.validate(readInt);
        result.error = LinkGenerationError.toKnownValue(result.error);
        int readInt2 = decoder0.readInt(20);
        result.readyStatus = readInt2;
        LinkGenerationReadyStatus.validate(readInt2);
        result.readyStatus = LinkGenerationReadyStatus.toKnownValue(result.readyStatus);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.selector, 8, false);
      encoder0.encode(this.error, 16);
      encoder0.encode(this.readyStatus, 20);
    }
  }

  static class TextFragmentReceiverRequestSelectorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final TextFragmentReceiver.RequestSelector_Response mCallback;

    TextFragmentReceiverRequestSelectorResponseParamsForwardToCallback(
        TextFragmentReceiver.RequestSelector_Response callback) {
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
        TextFragmentReceiverRequestSelectorResponseParams response =
            TextFragmentReceiverRequestSelectorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.selector, response.error, response.readyStatus);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TextFragmentReceiverRequestSelectorResponseParamsProxyToResponder
      implements TextFragmentReceiver.RequestSelector_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TextFragmentReceiverRequestSelectorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String selector, int error, int readyStatus) {
      TextFragmentReceiverRequestSelectorResponseParams _response =
          new TextFragmentReceiverRequestSelectorResponseParams();
      _response.selector = selector;
      _response.error = error;
      _response.readyStatus = readyStatus;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class TextFragmentReceiverRemoveFragmentsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverRemoveFragmentsParams(int version) {
      super(8, version);
    }

    public TextFragmentReceiverRemoveFragmentsParams() {
      this(0);
    }

    public static TextFragmentReceiverRemoveFragmentsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverRemoveFragmentsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverRemoveFragmentsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverRemoveFragmentsParams result =
            new TextFragmentReceiverRemoveFragmentsParams(elementsOrVersion);
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

  static final class TextFragmentReceiverExtractTextFragmentsMatchesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverExtractTextFragmentsMatchesParams(int version) {
      super(8, version);
    }

    public TextFragmentReceiverExtractTextFragmentsMatchesParams() {
      this(0);
    }

    public static TextFragmentReceiverExtractTextFragmentsMatchesParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverExtractTextFragmentsMatchesParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverExtractTextFragmentsMatchesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverExtractTextFragmentsMatchesParams result =
            new TextFragmentReceiverExtractTextFragmentsMatchesParams(elementsOrVersion);
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

  static final class TextFragmentReceiverExtractTextFragmentsMatchesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] text;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverExtractTextFragmentsMatchesResponseParams(int version) {
      super(16, version);
    }

    public TextFragmentReceiverExtractTextFragmentsMatchesResponseParams() {
      this(0);
    }

    public static TextFragmentReceiverExtractTextFragmentsMatchesResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverExtractTextFragmentsMatchesResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverExtractTextFragmentsMatchesResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverExtractTextFragmentsMatchesResponseParams result =
            new TextFragmentReceiverExtractTextFragmentsMatchesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.text = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.text[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.text;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.text;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class TextFragmentReceiverExtractTextFragmentsMatchesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final TextFragmentReceiver.ExtractTextFragmentsMatches_Response mCallback;

    TextFragmentReceiverExtractTextFragmentsMatchesResponseParamsForwardToCallback(
        TextFragmentReceiver.ExtractTextFragmentsMatches_Response callback) {
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
        TextFragmentReceiverExtractTextFragmentsMatchesResponseParams response =
            TextFragmentReceiverExtractTextFragmentsMatchesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.text);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TextFragmentReceiverExtractTextFragmentsMatchesResponseParamsProxyToResponder
      implements TextFragmentReceiver.ExtractTextFragmentsMatches_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TextFragmentReceiverExtractTextFragmentsMatchesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String[] text) {
      TextFragmentReceiverExtractTextFragmentsMatchesResponseParams _response =
          new TextFragmentReceiverExtractTextFragmentsMatchesResponseParams();
      _response.text = text;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class TextFragmentReceiverGetExistingSelectorsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverGetExistingSelectorsParams(int version) {
      super(8, version);
    }

    public TextFragmentReceiverGetExistingSelectorsParams() {
      this(0);
    }

    public static TextFragmentReceiverGetExistingSelectorsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverGetExistingSelectorsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverGetExistingSelectorsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverGetExistingSelectorsParams result =
            new TextFragmentReceiverGetExistingSelectorsParams(elementsOrVersion);
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

  static final class TextFragmentReceiverGetExistingSelectorsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] selectors;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverGetExistingSelectorsResponseParams(int version) {
      super(16, version);
    }

    public TextFragmentReceiverGetExistingSelectorsResponseParams() {
      this(0);
    }

    public static TextFragmentReceiverGetExistingSelectorsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverGetExistingSelectorsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverGetExistingSelectorsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverGetExistingSelectorsResponseParams result =
            new TextFragmentReceiverGetExistingSelectorsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.selectors = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.selectors[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.selectors;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.selectors;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class TextFragmentReceiverGetExistingSelectorsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final TextFragmentReceiver.GetExistingSelectors_Response mCallback;

    TextFragmentReceiverGetExistingSelectorsResponseParamsForwardToCallback(
        TextFragmentReceiver.GetExistingSelectors_Response callback) {
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
        TextFragmentReceiverGetExistingSelectorsResponseParams response =
            TextFragmentReceiverGetExistingSelectorsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.selectors);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TextFragmentReceiverGetExistingSelectorsResponseParamsProxyToResponder
      implements TextFragmentReceiver.GetExistingSelectors_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TextFragmentReceiverGetExistingSelectorsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String[] selectors) {
      TextFragmentReceiverGetExistingSelectorsResponseParams _response =
          new TextFragmentReceiverGetExistingSelectorsResponseParams();
      _response.selectors = selectors;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class TextFragmentReceiverExtractFirstFragmentRectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverExtractFirstFragmentRectParams(int version) {
      super(8, version);
    }

    public TextFragmentReceiverExtractFirstFragmentRectParams() {
      this(0);
    }

    public static TextFragmentReceiverExtractFirstFragmentRectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverExtractFirstFragmentRectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverExtractFirstFragmentRectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverExtractFirstFragmentRectParams result =
            new TextFragmentReceiverExtractFirstFragmentRectParams(elementsOrVersion);
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

  static final class TextFragmentReceiverExtractFirstFragmentRectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect bounds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextFragmentReceiverExtractFirstFragmentRectResponseParams(int version) {
      super(16, version);
    }

    public TextFragmentReceiverExtractFirstFragmentRectResponseParams() {
      this(0);
    }

    public static TextFragmentReceiverExtractFirstFragmentRectResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextFragmentReceiverExtractFirstFragmentRectResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextFragmentReceiverExtractFirstFragmentRectResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextFragmentReceiverExtractFirstFragmentRectResponseParams result =
            new TextFragmentReceiverExtractFirstFragmentRectResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.bounds = Rect.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.bounds, 8, false);
    }
  }

  static class TextFragmentReceiverExtractFirstFragmentRectResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final TextFragmentReceiver.ExtractFirstFragmentRect_Response mCallback;

    TextFragmentReceiverExtractFirstFragmentRectResponseParamsForwardToCallback(
        TextFragmentReceiver.ExtractFirstFragmentRect_Response callback) {
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
        TextFragmentReceiverExtractFirstFragmentRectResponseParams response =
            TextFragmentReceiverExtractFirstFragmentRectResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.bounds);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TextFragmentReceiverExtractFirstFragmentRectResponseParamsProxyToResponder
      implements TextFragmentReceiver.ExtractFirstFragmentRect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TextFragmentReceiverExtractFirstFragmentRectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Rect bounds) {
      TextFragmentReceiverExtractFirstFragmentRectResponseParams _response =
          new TextFragmentReceiverExtractFirstFragmentRectResponseParams();
      _response.bounds = bounds;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
