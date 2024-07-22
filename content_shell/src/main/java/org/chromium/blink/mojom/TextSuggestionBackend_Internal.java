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

class TextSuggestionBackend_Internal {
  private static final int APPLY_SPELL_CHECK_SUGGESTION_ORDINAL = 0;
  private static final int APPLY_TEXT_SUGGESTION_ORDINAL = 1;
  private static final int DELETE_ACTIVE_SUGGESTION_RANGE_ORDINAL = 2;
  public static final Interface.Manager<TextSuggestionBackend, TextSuggestionBackend.Proxy>
      MANAGER =
          new Interface.Manager<TextSuggestionBackend, TextSuggestionBackend.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.TextSuggestionBackend";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public TextSuggestionBackend.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, TextSuggestionBackend impl) {
              return new Stub(core, impl);
            }

            @Override
            public TextSuggestionBackend[] buildArray(int size) {
              return new TextSuggestionBackend[size];
            }
          };
  private static final int ON_NEW_WORD_ADDED_TO_DICTIONARY_ORDINAL = 3;
  private static final int ON_SUGGESTION_MENU_CLOSED_ORDINAL = 4;
  private static final int SUGGESTION_MENU_TIMEOUT_CALLBACK_ORDINAL = 5;

  TextSuggestionBackend_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements TextSuggestionBackend.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void applySpellCheckSuggestion(String suggestion) {
      TextSuggestionBackendApplySpellCheckSuggestionParams _message =
          new TextSuggestionBackendApplySpellCheckSuggestionParams();
      _message.suggestion = suggestion;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void applyTextSuggestion(int markerTag, int suggestionIndex) {
      TextSuggestionBackendApplyTextSuggestionParams _message =
          new TextSuggestionBackendApplyTextSuggestionParams();
      _message.markerTag = markerTag;
      _message.suggestionIndex = suggestionIndex;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void deleteActiveSuggestionRange() {
      TextSuggestionBackendDeleteActiveSuggestionRangeParams _message =
          new TextSuggestionBackendDeleteActiveSuggestionRangeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onNewWordAddedToDictionary(String suggestion) {
      TextSuggestionBackendOnNewWordAddedToDictionaryParams _message =
          new TextSuggestionBackendOnNewWordAddedToDictionaryParams();
      _message.suggestion = suggestion;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onSuggestionMenuClosed() {
      TextSuggestionBackendOnSuggestionMenuClosedParams _message =
          new TextSuggestionBackendOnSuggestionMenuClosedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void suggestionMenuTimeoutCallback(int maxNumberOfSuggestions) {
      TextSuggestionBackendSuggestionMenuTimeoutCallbackParams _message =
          new TextSuggestionBackendSuggestionMenuTimeoutCallbackParams();
      _message.maxNumberOfSuggestions = maxNumberOfSuggestions;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<TextSuggestionBackend> {
    Stub(Core core, TextSuggestionBackend impl) {
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
                TextSuggestionBackend_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .applySpellCheckSuggestion(
                    TextSuggestionBackendApplySpellCheckSuggestionParams.deserialize(
                            messageWithHeader.getPayload())
                        .suggestion);
            return true;
          case 1:
            TextSuggestionBackendApplyTextSuggestionParams data =
                TextSuggestionBackendApplyTextSuggestionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().applyTextSuggestion(data.markerTag, data.suggestionIndex);
            return true;
          case 2:
            TextSuggestionBackendDeleteActiveSuggestionRangeParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().deleteActiveSuggestionRange();
            return true;
          case 3:
            TextSuggestionBackendOnNewWordAddedToDictionaryParams data2 =
                TextSuggestionBackendOnNewWordAddedToDictionaryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onNewWordAddedToDictionary(data2.suggestion);
            return true;
          case 4:
            TextSuggestionBackendOnSuggestionMenuClosedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onSuggestionMenuClosed();
            return true;
          case 5:
            TextSuggestionBackendSuggestionMenuTimeoutCallbackParams data3 =
                TextSuggestionBackendSuggestionMenuTimeoutCallbackParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().suggestionMenuTimeoutCallback(data3.maxNumberOfSuggestions);
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
                getCore(), TextSuggestionBackend_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class TextSuggestionBackendApplySpellCheckSuggestionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String suggestion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionBackendApplySpellCheckSuggestionParams(int version) {
      super(16, version);
    }

    public TextSuggestionBackendApplySpellCheckSuggestionParams() {
      this(0);
    }

    public static TextSuggestionBackendApplySpellCheckSuggestionParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionBackendApplySpellCheckSuggestionParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionBackendApplySpellCheckSuggestionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionBackendApplySpellCheckSuggestionParams result =
            new TextSuggestionBackendApplySpellCheckSuggestionParams(elementsOrVersion);
        result.suggestion = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.suggestion, 8, false);
    }
  }

  static final class TextSuggestionBackendApplyTextSuggestionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int markerTag;
    public int suggestionIndex;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionBackendApplyTextSuggestionParams(int version) {
      super(16, version);
    }

    public TextSuggestionBackendApplyTextSuggestionParams() {
      this(0);
    }

    public static TextSuggestionBackendApplyTextSuggestionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionBackendApplyTextSuggestionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionBackendApplyTextSuggestionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionBackendApplyTextSuggestionParams result =
            new TextSuggestionBackendApplyTextSuggestionParams(elementsOrVersion);
        result.markerTag = decoder0.readInt(8);
        result.suggestionIndex = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.markerTag, 8);
      encoder0.encode(this.suggestionIndex, 12);
    }
  }

  static final class TextSuggestionBackendDeleteActiveSuggestionRangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionBackendDeleteActiveSuggestionRangeParams(int version) {
      super(8, version);
    }

    public TextSuggestionBackendDeleteActiveSuggestionRangeParams() {
      this(0);
    }

    public static TextSuggestionBackendDeleteActiveSuggestionRangeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionBackendDeleteActiveSuggestionRangeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionBackendDeleteActiveSuggestionRangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionBackendDeleteActiveSuggestionRangeParams result =
            new TextSuggestionBackendDeleteActiveSuggestionRangeParams(elementsOrVersion);
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

  static final class TextSuggestionBackendOnNewWordAddedToDictionaryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String suggestion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionBackendOnNewWordAddedToDictionaryParams(int version) {
      super(16, version);
    }

    public TextSuggestionBackendOnNewWordAddedToDictionaryParams() {
      this(0);
    }

    public static TextSuggestionBackendOnNewWordAddedToDictionaryParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionBackendOnNewWordAddedToDictionaryParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionBackendOnNewWordAddedToDictionaryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionBackendOnNewWordAddedToDictionaryParams result =
            new TextSuggestionBackendOnNewWordAddedToDictionaryParams(elementsOrVersion);
        result.suggestion = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.suggestion, 8, false);
    }
  }

  static final class TextSuggestionBackendOnSuggestionMenuClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionBackendOnSuggestionMenuClosedParams(int version) {
      super(8, version);
    }

    public TextSuggestionBackendOnSuggestionMenuClosedParams() {
      this(0);
    }

    public static TextSuggestionBackendOnSuggestionMenuClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionBackendOnSuggestionMenuClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionBackendOnSuggestionMenuClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionBackendOnSuggestionMenuClosedParams result =
            new TextSuggestionBackendOnSuggestionMenuClosedParams(elementsOrVersion);
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

  static final class TextSuggestionBackendSuggestionMenuTimeoutCallbackParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int maxNumberOfSuggestions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionBackendSuggestionMenuTimeoutCallbackParams(int version) {
      super(16, version);
    }

    public TextSuggestionBackendSuggestionMenuTimeoutCallbackParams() {
      this(0);
    }

    public static TextSuggestionBackendSuggestionMenuTimeoutCallbackParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionBackendSuggestionMenuTimeoutCallbackParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionBackendSuggestionMenuTimeoutCallbackParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionBackendSuggestionMenuTimeoutCallbackParams result =
            new TextSuggestionBackendSuggestionMenuTimeoutCallbackParams(elementsOrVersion);
        result.maxNumberOfSuggestions = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.maxNumberOfSuggestions, 8);
    }
  }
}
