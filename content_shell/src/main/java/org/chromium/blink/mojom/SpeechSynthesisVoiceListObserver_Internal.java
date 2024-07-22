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

class SpeechSynthesisVoiceListObserver_Internal {
  public static final Interface.Manager<
          SpeechSynthesisVoiceListObserver, SpeechSynthesisVoiceListObserver.Proxy>
      MANAGER =
          new Interface.Manager<
              SpeechSynthesisVoiceListObserver, SpeechSynthesisVoiceListObserver.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.SpeechSynthesisVoiceListObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SpeechSynthesisVoiceListObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SpeechSynthesisVoiceListObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public SpeechSynthesisVoiceListObserver[] buildArray(int size) {
              return new SpeechSynthesisVoiceListObserver[size];
            }
          };
  private static final int ON_SET_VOICE_LIST_ORDINAL = 0;

  SpeechSynthesisVoiceListObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SpeechSynthesisVoiceListObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onSetVoiceList(SpeechSynthesisVoice[] voiceList) {
      SpeechSynthesisVoiceListObserverOnSetVoiceListParams _message =
          new SpeechSynthesisVoiceListObserverOnSetVoiceListParams();
      _message.voiceList = voiceList;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<SpeechSynthesisVoiceListObserver> {
    Stub(Core core, SpeechSynthesisVoiceListObserver impl) {
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
                SpeechSynthesisVoiceListObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SpeechSynthesisVoiceListObserverOnSetVoiceListParams data =
                SpeechSynthesisVoiceListObserverOnSetVoiceListParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onSetVoiceList(data.voiceList);
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
                SpeechSynthesisVoiceListObserver_Internal.MANAGER,
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

  static final class SpeechSynthesisVoiceListObserverOnSetVoiceListParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SpeechSynthesisVoice[] voiceList;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechSynthesisVoiceListObserverOnSetVoiceListParams(int version) {
      super(16, version);
    }

    public SpeechSynthesisVoiceListObserverOnSetVoiceListParams() {
      this(0);
    }

    public static SpeechSynthesisVoiceListObserverOnSetVoiceListParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechSynthesisVoiceListObserverOnSetVoiceListParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechSynthesisVoiceListObserverOnSetVoiceListParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechSynthesisVoiceListObserverOnSetVoiceListParams result =
            new SpeechSynthesisVoiceListObserverOnSetVoiceListParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.voiceList = new SpeechSynthesisVoice[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.voiceList[i1] = SpeechSynthesisVoice.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SpeechSynthesisVoice[] speechSynthesisVoiceArr = this.voiceList;
      if (speechSynthesisVoiceArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(speechSynthesisVoiceArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SpeechSynthesisVoice[] speechSynthesisVoiceArr2 = this.voiceList;
        if (i0 < speechSynthesisVoiceArr2.length) {
          encoder1.encode((Struct) speechSynthesisVoiceArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
