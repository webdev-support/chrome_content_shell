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

class SpeechSynthesis_Internal {
  private static final int ADD_VOICE_LIST_OBSERVER_ORDINAL = 0;
  private static final int CANCEL_ORDINAL = 4;
  public static final Interface.Manager<SpeechSynthesis, SpeechSynthesis.Proxy> MANAGER =
      new Interface.Manager<SpeechSynthesis, SpeechSynthesis.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.SpeechSynthesis";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SpeechSynthesis.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SpeechSynthesis impl) {
          return new Stub(core, impl);
        }

        @Override
        public SpeechSynthesis[] buildArray(int size) {
          return new SpeechSynthesis[size];
        }
      };
  private static final int PAUSE_ORDINAL = 2;
  private static final int RESUME_ORDINAL = 3;
  private static final int SPEAK_ORDINAL = 1;

  SpeechSynthesis_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SpeechSynthesis.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addVoiceListObserver(SpeechSynthesisVoiceListObserver observer) {
      SpeechSynthesisAddVoiceListObserverParams _message =
          new SpeechSynthesisAddVoiceListObserverParams();
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void speak(SpeechSynthesisUtterance utterance, SpeechSynthesisClient client) {
      SpeechSynthesisSpeakParams _message = new SpeechSynthesisSpeakParams();
      _message.utterance = utterance;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void pause() {
      SpeechSynthesisPauseParams _message = new SpeechSynthesisPauseParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void resume() {
      SpeechSynthesisResumeParams _message = new SpeechSynthesisResumeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void cancel() {
      SpeechSynthesisCancelParams _message = new SpeechSynthesisCancelParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<SpeechSynthesis> {
    Stub(Core core, SpeechSynthesis impl) {
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
                SpeechSynthesis_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .addVoiceListObserver(
                    SpeechSynthesisAddVoiceListObserverParams.deserialize(
                            messageWithHeader.getPayload())
                        .observer);
            return true;
          case 1:
            SpeechSynthesisSpeakParams data =
                SpeechSynthesisSpeakParams.deserialize(messageWithHeader.getPayload());
            getImpl().speak(data.utterance, data.client);
            return true;
          case 2:
            SpeechSynthesisPauseParams.deserialize(messageWithHeader.getPayload());
            getImpl().pause();
            return true;
          case 3:
            SpeechSynthesisResumeParams.deserialize(messageWithHeader.getPayload());
            getImpl().resume();
            return true;
          case 4:
            SpeechSynthesisCancelParams.deserialize(messageWithHeader.getPayload());
            getImpl().cancel();
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
                getCore(), SpeechSynthesis_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SpeechSynthesisAddVoiceListObserverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SpeechSynthesisVoiceListObserver observer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisAddVoiceListObserverParams(int version) {
      super(16, version);
    }

    public SpeechSynthesisAddVoiceListObserverParams() {
      this(0);
    }

    public static SpeechSynthesisAddVoiceListObserverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisAddVoiceListObserverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisAddVoiceListObserverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisAddVoiceListObserverParams result =
            new SpeechSynthesisAddVoiceListObserverParams(elementsOrVersion);
        result.observer =
            (SpeechSynthesisVoiceListObserver)
                decoder0.readServiceInterface(8, false, SpeechSynthesisVoiceListObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.observer, 8, false, SpeechSynthesisVoiceListObserver.MANAGER);
    }
  }

  static final class SpeechSynthesisSpeakParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SpeechSynthesisClient client;
    public SpeechSynthesisUtterance utterance;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisSpeakParams(int version) {
      super(24, version);
    }

    public SpeechSynthesisSpeakParams() {
      this(0);
    }

    public static SpeechSynthesisSpeakParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisSpeakParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisSpeakParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisSpeakParams result = new SpeechSynthesisSpeakParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.utterance = SpeechSynthesisUtterance.decode(decoder1);
        result.client =
            (SpeechSynthesisClient)
                decoder0.readServiceInterface(16, false, SpeechSynthesisClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.utterance, 8, false);
      encoder0.encode(this.client, 16, false, SpeechSynthesisClient.MANAGER);
    }
  }

  static final class SpeechSynthesisPauseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisPauseParams(int version) {
      super(8, version);
    }

    public SpeechSynthesisPauseParams() {
      this(0);
    }

    public static SpeechSynthesisPauseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisPauseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisPauseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisPauseParams result = new SpeechSynthesisPauseParams(elementsOrVersion);
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

  static final class SpeechSynthesisResumeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisResumeParams(int version) {
      super(8, version);
    }

    public SpeechSynthesisResumeParams() {
      this(0);
    }

    public static SpeechSynthesisResumeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisResumeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisResumeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisResumeParams result = new SpeechSynthesisResumeParams(elementsOrVersion);
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

  static final class SpeechSynthesisCancelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisCancelParams(int version) {
      super(8, version);
    }

    public SpeechSynthesisCancelParams() {
      this(0);
    }

    public static SpeechSynthesisCancelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisCancelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisCancelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisCancelParams result = new SpeechSynthesisCancelParams(elementsOrVersion);
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
