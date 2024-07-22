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

class SpeechRecognitionSessionClient_Internal {
  private static final int AUDIO_ENDED_ORDINAL = 6;
  private static final int AUDIO_STARTED_ORDINAL = 3;
  private static final int ENDED_ORDINAL = 7;
  private static final int ERROR_OCCURRED_ORDINAL = 1;
  public static final Interface.Manager<
          SpeechRecognitionSessionClient, SpeechRecognitionSessionClient.Proxy>
      MANAGER =
          new Interface.Manager<
              SpeechRecognitionSessionClient, SpeechRecognitionSessionClient.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.SpeechRecognitionSessionClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SpeechRecognitionSessionClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SpeechRecognitionSessionClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public SpeechRecognitionSessionClient[] buildArray(int size) {
              return new SpeechRecognitionSessionClient[size];
            }
          };
  private static final int RESULT_RETRIEVED_ORDINAL = 0;
  private static final int SOUND_ENDED_ORDINAL = 5;
  private static final int SOUND_STARTED_ORDINAL = 4;
  private static final int STARTED_ORDINAL = 2;

  SpeechRecognitionSessionClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SpeechRecognitionSessionClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void resultRetrieved(SpeechRecognitionResult[] results) {
      SpeechRecognitionSessionClientResultRetrievedParams _message =
          new SpeechRecognitionSessionClientResultRetrievedParams();
      _message.results = results;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void errorOccurred(SpeechRecognitionError error) {
      SpeechRecognitionSessionClientErrorOccurredParams _message =
          new SpeechRecognitionSessionClientErrorOccurredParams();
      _message.error = error;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void started() {
      SpeechRecognitionSessionClientStartedParams _message =
          new SpeechRecognitionSessionClientStartedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void audioStarted() {
      SpeechRecognitionSessionClientAudioStartedParams _message =
          new SpeechRecognitionSessionClientAudioStartedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void soundStarted() {
      SpeechRecognitionSessionClientSoundStartedParams _message =
          new SpeechRecognitionSessionClientSoundStartedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void soundEnded() {
      SpeechRecognitionSessionClientSoundEndedParams _message =
          new SpeechRecognitionSessionClientSoundEndedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void audioEnded() {
      SpeechRecognitionSessionClientAudioEndedParams _message =
          new SpeechRecognitionSessionClientAudioEndedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void ended() {
      SpeechRecognitionSessionClientEndedParams _message =
          new SpeechRecognitionSessionClientEndedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }
  }

  public static final class Stub extends Interface.Stub<SpeechRecognitionSessionClient> {
    Stub(Core core, SpeechRecognitionSessionClient impl) {
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
                SpeechRecognitionSessionClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SpeechRecognitionSessionClientResultRetrievedParams data =
                SpeechRecognitionSessionClientResultRetrievedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().resultRetrieved(data.results);
            return true;
          case 1:
            SpeechRecognitionSessionClientErrorOccurredParams data2 =
                SpeechRecognitionSessionClientErrorOccurredParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().errorOccurred(data2.error);
            return true;
          case 2:
            SpeechRecognitionSessionClientStartedParams.deserialize(messageWithHeader.getPayload());
            getImpl().started();
            return true;
          case 3:
            SpeechRecognitionSessionClientAudioStartedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().audioStarted();
            return true;
          case 4:
            SpeechRecognitionSessionClientSoundStartedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().soundStarted();
            return true;
          case 5:
            SpeechRecognitionSessionClientSoundEndedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().soundEnded();
            return true;
          case 6:
            SpeechRecognitionSessionClientAudioEndedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().audioEnded();
            return true;
          case 7:
            SpeechRecognitionSessionClientEndedParams.deserialize(messageWithHeader.getPayload());
            getImpl().ended();
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
                SpeechRecognitionSessionClient_Internal.MANAGER,
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

  static final class SpeechRecognitionSessionClientResultRetrievedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SpeechRecognitionResult[] results;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionClientResultRetrievedParams(int version) {
      super(16, version);
    }

    public SpeechRecognitionSessionClientResultRetrievedParams() {
      this(0);
    }

    public static SpeechRecognitionSessionClientResultRetrievedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionClientResultRetrievedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionClientResultRetrievedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionClientResultRetrievedParams result =
            new SpeechRecognitionSessionClientResultRetrievedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.results = new SpeechRecognitionResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.results[i1] = SpeechRecognitionResult.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SpeechRecognitionResult[] speechRecognitionResultArr = this.results;
      if (speechRecognitionResultArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(speechRecognitionResultArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SpeechRecognitionResult[] speechRecognitionResultArr2 = this.results;
        if (i0 < speechRecognitionResultArr2.length) {
          encoder1.encode((Struct) speechRecognitionResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class SpeechRecognitionSessionClientErrorOccurredParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SpeechRecognitionError error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionClientErrorOccurredParams(int version) {
      super(16, version);
    }

    public SpeechRecognitionSessionClientErrorOccurredParams() {
      this(0);
    }

    public static SpeechRecognitionSessionClientErrorOccurredParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionClientErrorOccurredParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionClientErrorOccurredParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionClientErrorOccurredParams result =
            new SpeechRecognitionSessionClientErrorOccurredParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.error = SpeechRecognitionError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.error, 8, false);
    }
  }

  static final class SpeechRecognitionSessionClientStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionClientStartedParams(int version) {
      super(8, version);
    }

    public SpeechRecognitionSessionClientStartedParams() {
      this(0);
    }

    public static SpeechRecognitionSessionClientStartedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionClientStartedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionClientStartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionClientStartedParams result =
            new SpeechRecognitionSessionClientStartedParams(elementsOrVersion);
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

  static final class SpeechRecognitionSessionClientAudioStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionClientAudioStartedParams(int version) {
      super(8, version);
    }

    public SpeechRecognitionSessionClientAudioStartedParams() {
      this(0);
    }

    public static SpeechRecognitionSessionClientAudioStartedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionClientAudioStartedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionClientAudioStartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionClientAudioStartedParams result =
            new SpeechRecognitionSessionClientAudioStartedParams(elementsOrVersion);
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

  static final class SpeechRecognitionSessionClientSoundStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionClientSoundStartedParams(int version) {
      super(8, version);
    }

    public SpeechRecognitionSessionClientSoundStartedParams() {
      this(0);
    }

    public static SpeechRecognitionSessionClientSoundStartedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionClientSoundStartedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionClientSoundStartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionClientSoundStartedParams result =
            new SpeechRecognitionSessionClientSoundStartedParams(elementsOrVersion);
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

  static final class SpeechRecognitionSessionClientSoundEndedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionClientSoundEndedParams(int version) {
      super(8, version);
    }

    public SpeechRecognitionSessionClientSoundEndedParams() {
      this(0);
    }

    public static SpeechRecognitionSessionClientSoundEndedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionClientSoundEndedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionClientSoundEndedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionClientSoundEndedParams result =
            new SpeechRecognitionSessionClientSoundEndedParams(elementsOrVersion);
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

  static final class SpeechRecognitionSessionClientAudioEndedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionClientAudioEndedParams(int version) {
      super(8, version);
    }

    public SpeechRecognitionSessionClientAudioEndedParams() {
      this(0);
    }

    public static SpeechRecognitionSessionClientAudioEndedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionClientAudioEndedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionClientAudioEndedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionClientAudioEndedParams result =
            new SpeechRecognitionSessionClientAudioEndedParams(elementsOrVersion);
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

  static final class SpeechRecognitionSessionClientEndedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionClientEndedParams(int version) {
      super(8, version);
    }

    public SpeechRecognitionSessionClientEndedParams() {
      this(0);
    }

    public static SpeechRecognitionSessionClientEndedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionClientEndedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionClientEndedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionClientEndedParams result =
            new SpeechRecognitionSessionClientEndedParams(elementsOrVersion);
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
