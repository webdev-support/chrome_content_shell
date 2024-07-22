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

class SpeechSynthesisClient_Internal {
  public static final Interface.Manager<SpeechSynthesisClient, SpeechSynthesisClient.Proxy>
      MANAGER =
          new Interface.Manager<SpeechSynthesisClient, SpeechSynthesisClient.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.SpeechSynthesisClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SpeechSynthesisClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SpeechSynthesisClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public SpeechSynthesisClient[] buildArray(int size) {
              return new SpeechSynthesisClient[size];
            }
          };
  private static final int ON_ENCOUNTERED_SENTENCE_BOUNDARY_ORDINAL = 5;
  private static final int ON_ENCOUNTERED_SPEAKING_ERROR_ORDINAL = 6;
  private static final int ON_ENCOUNTERED_WORD_BOUNDARY_ORDINAL = 4;
  private static final int ON_FINISHED_SPEAKING_ORDINAL = 1;
  private static final int ON_PAUSED_SPEAKING_ORDINAL = 2;
  private static final int ON_RESUMED_SPEAKING_ORDINAL = 3;
  private static final int ON_STARTED_SPEAKING_ORDINAL = 0;

  SpeechSynthesisClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SpeechSynthesisClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onStartedSpeaking() {
      SpeechSynthesisClientOnStartedSpeakingParams _message =
          new SpeechSynthesisClientOnStartedSpeakingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onFinishedSpeaking(int errorCode) {
      SpeechSynthesisClientOnFinishedSpeakingParams _message =
          new SpeechSynthesisClientOnFinishedSpeakingParams();
      _message.errorCode = errorCode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onPausedSpeaking() {
      SpeechSynthesisClientOnPausedSpeakingParams _message =
          new SpeechSynthesisClientOnPausedSpeakingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onResumedSpeaking() {
      SpeechSynthesisClientOnResumedSpeakingParams _message =
          new SpeechSynthesisClientOnResumedSpeakingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onEncounteredWordBoundary(int charIndex, int charLength) {
      SpeechSynthesisClientOnEncounteredWordBoundaryParams _message =
          new SpeechSynthesisClientOnEncounteredWordBoundaryParams();
      _message.charIndex = charIndex;
      _message.charLength = charLength;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onEncounteredSentenceBoundary(int charIndex, int charLength) {
      SpeechSynthesisClientOnEncounteredSentenceBoundaryParams _message =
          new SpeechSynthesisClientOnEncounteredSentenceBoundaryParams();
      _message.charIndex = charIndex;
      _message.charLength = charLength;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void onEncounteredSpeakingError() {
      SpeechSynthesisClientOnEncounteredSpeakingErrorParams _message =
          new SpeechSynthesisClientOnEncounteredSpeakingErrorParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }
  }

  public static final class Stub extends Interface.Stub<SpeechSynthesisClient> {
    Stub(Core core, SpeechSynthesisClient impl) {
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
                SpeechSynthesisClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SpeechSynthesisClientOnStartedSpeakingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onStartedSpeaking();
            return true;
          case 1:
            getImpl()
                .onFinishedSpeaking(
                    SpeechSynthesisClientOnFinishedSpeakingParams.deserialize(
                            messageWithHeader.getPayload())
                        .errorCode);
            return true;
          case 2:
            SpeechSynthesisClientOnPausedSpeakingParams.deserialize(messageWithHeader.getPayload());
            getImpl().onPausedSpeaking();
            return true;
          case 3:
            SpeechSynthesisClientOnResumedSpeakingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onResumedSpeaking();
            return true;
          case 4:
            SpeechSynthesisClientOnEncounteredWordBoundaryParams data =
                SpeechSynthesisClientOnEncounteredWordBoundaryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onEncounteredWordBoundary(data.charIndex, data.charLength);
            return true;
          case 5:
            SpeechSynthesisClientOnEncounteredSentenceBoundaryParams data2 =
                SpeechSynthesisClientOnEncounteredSentenceBoundaryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onEncounteredSentenceBoundary(data2.charIndex, data2.charLength);
            return true;
          case 6:
            SpeechSynthesisClientOnEncounteredSpeakingErrorParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onEncounteredSpeakingError();
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
                getCore(), SpeechSynthesisClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SpeechSynthesisClientOnStartedSpeakingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisClientOnStartedSpeakingParams(int version) {
      super(8, version);
    }

    public SpeechSynthesisClientOnStartedSpeakingParams() {
      this(0);
    }

    public static SpeechSynthesisClientOnStartedSpeakingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisClientOnStartedSpeakingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisClientOnStartedSpeakingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisClientOnStartedSpeakingParams result =
            new SpeechSynthesisClientOnStartedSpeakingParams(elementsOrVersion);
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

  static final class SpeechSynthesisClientOnFinishedSpeakingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisClientOnFinishedSpeakingParams(int version) {
      super(16, version);
    }

    public SpeechSynthesisClientOnFinishedSpeakingParams() {
      this(0);
    }

    public static SpeechSynthesisClientOnFinishedSpeakingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisClientOnFinishedSpeakingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisClientOnFinishedSpeakingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisClientOnFinishedSpeakingParams result =
            new SpeechSynthesisClientOnFinishedSpeakingParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        SpeechSynthesisErrorCode.validate(readInt);
        result.errorCode = SpeechSynthesisErrorCode.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static final class SpeechSynthesisClientOnPausedSpeakingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisClientOnPausedSpeakingParams(int version) {
      super(8, version);
    }

    public SpeechSynthesisClientOnPausedSpeakingParams() {
      this(0);
    }

    public static SpeechSynthesisClientOnPausedSpeakingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisClientOnPausedSpeakingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisClientOnPausedSpeakingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisClientOnPausedSpeakingParams result =
            new SpeechSynthesisClientOnPausedSpeakingParams(elementsOrVersion);
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

  static final class SpeechSynthesisClientOnResumedSpeakingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisClientOnResumedSpeakingParams(int version) {
      super(8, version);
    }

    public SpeechSynthesisClientOnResumedSpeakingParams() {
      this(0);
    }

    public static SpeechSynthesisClientOnResumedSpeakingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisClientOnResumedSpeakingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisClientOnResumedSpeakingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisClientOnResumedSpeakingParams result =
            new SpeechSynthesisClientOnResumedSpeakingParams(elementsOrVersion);
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

  static final class SpeechSynthesisClientOnEncounteredWordBoundaryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int charIndex;
    public int charLength;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisClientOnEncounteredWordBoundaryParams(int version) {
      super(16, version);
    }

    public SpeechSynthesisClientOnEncounteredWordBoundaryParams() {
      this(0);
    }

    public static SpeechSynthesisClientOnEncounteredWordBoundaryParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisClientOnEncounteredWordBoundaryParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisClientOnEncounteredWordBoundaryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisClientOnEncounteredWordBoundaryParams result =
            new SpeechSynthesisClientOnEncounteredWordBoundaryParams(elementsOrVersion);
        result.charIndex = decoder0.readInt(8);
        result.charLength = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.charIndex, 8);
      encoder0.encode(this.charLength, 12);
    }
  }

  static final class SpeechSynthesisClientOnEncounteredSentenceBoundaryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int charIndex;
    public int charLength;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisClientOnEncounteredSentenceBoundaryParams(int version) {
      super(16, version);
    }

    public SpeechSynthesisClientOnEncounteredSentenceBoundaryParams() {
      this(0);
    }

    public static SpeechSynthesisClientOnEncounteredSentenceBoundaryParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisClientOnEncounteredSentenceBoundaryParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisClientOnEncounteredSentenceBoundaryParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisClientOnEncounteredSentenceBoundaryParams result =
            new SpeechSynthesisClientOnEncounteredSentenceBoundaryParams(elementsOrVersion);
        result.charIndex = decoder0.readInt(8);
        result.charLength = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.charIndex, 8);
      encoder0.encode(this.charLength, 12);
    }
  }

  static final class SpeechSynthesisClientOnEncounteredSpeakingErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisClientOnEncounteredSpeakingErrorParams(int version) {
      super(8, version);
    }

    public SpeechSynthesisClientOnEncounteredSpeakingErrorParams() {
      this(0);
    }

    public static SpeechSynthesisClientOnEncounteredSpeakingErrorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisClientOnEncounteredSpeakingErrorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisClientOnEncounteredSpeakingErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisClientOnEncounteredSpeakingErrorParams result =
            new SpeechSynthesisClientOnEncounteredSpeakingErrorParams(elementsOrVersion);
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
