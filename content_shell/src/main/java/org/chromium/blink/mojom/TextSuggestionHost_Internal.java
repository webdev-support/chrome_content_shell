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

class TextSuggestionHost_Internal {
  public static final Interface.Manager<TextSuggestionHost, TextSuggestionHost.Proxy> MANAGER =
      new Interface.Manager<TextSuggestionHost, TextSuggestionHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.TextSuggestionHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public TextSuggestionHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, TextSuggestionHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public TextSuggestionHost[] buildArray(int size) {
          return new TextSuggestionHost[size];
        }
      };
  private static final int SHOW_SPELL_CHECK_SUGGESTION_MENU_ORDINAL = 1;
  private static final int SHOW_TEXT_SUGGESTION_MENU_ORDINAL = 2;
  private static final int START_SUGGESTION_MENU_TIMER_ORDINAL = 0;

  TextSuggestionHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements TextSuggestionHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void startSuggestionMenuTimer() {
      TextSuggestionHostStartSuggestionMenuTimerParams _message =
          new TextSuggestionHostStartSuggestionMenuTimerParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void showSpellCheckSuggestionMenu(
        double caretX, double caretY, String markedText, SpellCheckSuggestion[] suggestions) {
      TextSuggestionHostShowSpellCheckSuggestionMenuParams _message =
          new TextSuggestionHostShowSpellCheckSuggestionMenuParams();
      _message.caretX = caretX;
      _message.caretY = caretY;
      _message.markedText = markedText;
      _message.suggestions = suggestions;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void showTextSuggestionMenu(
        double caretX, double caretY, String markedText, TextSuggestion[] suggestions) {
      TextSuggestionHostShowTextSuggestionMenuParams _message =
          new TextSuggestionHostShowTextSuggestionMenuParams();
      _message.caretX = caretX;
      _message.caretY = caretY;
      _message.markedText = markedText;
      _message.suggestions = suggestions;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<TextSuggestionHost> {
    Stub(Core core, TextSuggestionHost impl) {
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
                TextSuggestionHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            TextSuggestionHostStartSuggestionMenuTimerParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().startSuggestionMenuTimer();
            return true;
          case 1:
            TextSuggestionHostShowSpellCheckSuggestionMenuParams data =
                TextSuggestionHostShowSpellCheckSuggestionMenuParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .showSpellCheckSuggestionMenu(
                    data.caretX, data.caretY, data.markedText, data.suggestions);
            return true;
          case 2:
            TextSuggestionHostShowTextSuggestionMenuParams data2 =
                TextSuggestionHostShowTextSuggestionMenuParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .showTextSuggestionMenu(
                    data2.caretX, data2.caretY, data2.markedText, data2.suggestions);
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
                getCore(), TextSuggestionHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class TextSuggestionHostStartSuggestionMenuTimerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionHostStartSuggestionMenuTimerParams(int version) {
      super(8, version);
    }

    public TextSuggestionHostStartSuggestionMenuTimerParams() {
      this(0);
    }

    public static TextSuggestionHostStartSuggestionMenuTimerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionHostStartSuggestionMenuTimerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionHostStartSuggestionMenuTimerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionHostStartSuggestionMenuTimerParams result =
            new TextSuggestionHostStartSuggestionMenuTimerParams(elementsOrVersion);
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

  static final class TextSuggestionHostShowSpellCheckSuggestionMenuParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public double caretX;
    public double caretY;
    public String markedText;
    public SpellCheckSuggestion[] suggestions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionHostShowSpellCheckSuggestionMenuParams(int version) {
      super(40, version);
    }

    public TextSuggestionHostShowSpellCheckSuggestionMenuParams() {
      this(0);
    }

    public static TextSuggestionHostShowSpellCheckSuggestionMenuParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionHostShowSpellCheckSuggestionMenuParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionHostShowSpellCheckSuggestionMenuParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionHostShowSpellCheckSuggestionMenuParams result =
            new TextSuggestionHostShowSpellCheckSuggestionMenuParams(elementsOrVersion);
        result.caretX = decoder0.readDouble(8);
        result.caretY = decoder0.readDouble(16);
        result.markedText = decoder0.readString(24, false);
        Decoder decoder1 = decoder0.readPointer(32, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.suggestions = new SpellCheckSuggestion[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.suggestions[i1] = SpellCheckSuggestion.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.caretX, 8);
      encoder0.encode(this.caretY, 16);
      encoder0.encode(this.markedText, 24, false);
      SpellCheckSuggestion[] spellCheckSuggestionArr = this.suggestions;
      if (spellCheckSuggestionArr == null) {
        encoder0.encodeNullPointer(32, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(spellCheckSuggestionArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        SpellCheckSuggestion[] spellCheckSuggestionArr2 = this.suggestions;
        if (i0 < spellCheckSuggestionArr2.length) {
          encoder1.encode((Struct) spellCheckSuggestionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class TextSuggestionHostShowTextSuggestionMenuParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public double caretX;
    public double caretY;
    public String markedText;
    public TextSuggestion[] suggestions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TextSuggestionHostShowTextSuggestionMenuParams(int version) {
      super(40, version);
    }

    public TextSuggestionHostShowTextSuggestionMenuParams() {
      this(0);
    }

    public static TextSuggestionHostShowTextSuggestionMenuParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TextSuggestionHostShowTextSuggestionMenuParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestionHostShowTextSuggestionMenuParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TextSuggestionHostShowTextSuggestionMenuParams result =
            new TextSuggestionHostShowTextSuggestionMenuParams(elementsOrVersion);
        result.caretX = decoder0.readDouble(8);
        result.caretY = decoder0.readDouble(16);
        result.markedText = decoder0.readString(24, false);
        Decoder decoder1 = decoder0.readPointer(32, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.suggestions = new TextSuggestion[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.suggestions[i1] = TextSuggestion.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.caretX, 8);
      encoder0.encode(this.caretY, 16);
      encoder0.encode(this.markedText, 24, false);
      TextSuggestion[] textSuggestionArr = this.suggestions;
      if (textSuggestionArr == null) {
        encoder0.encodeNullPointer(32, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(textSuggestionArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        TextSuggestion[] textSuggestionArr2 = this.suggestions;
        if (i0 < textSuggestionArr2.length) {
          encoder1.encode((Struct) textSuggestionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
