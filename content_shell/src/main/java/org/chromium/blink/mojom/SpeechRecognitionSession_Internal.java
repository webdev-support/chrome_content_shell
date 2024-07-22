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

class SpeechRecognitionSession_Internal {
  private static final int ABORT_ORDINAL = 0;
  public static final Interface.Manager<SpeechRecognitionSession, SpeechRecognitionSession.Proxy>
      MANAGER =
          new Interface.Manager<SpeechRecognitionSession, SpeechRecognitionSession.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.SpeechRecognitionSession";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SpeechRecognitionSession.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SpeechRecognitionSession impl) {
              return new Stub(core, impl);
            }

            @Override
            public SpeechRecognitionSession[] buildArray(int size) {
              return new SpeechRecognitionSession[size];
            }
          };
  private static final int STOP_CAPTURE_ORDINAL = 1;

  SpeechRecognitionSession_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SpeechRecognitionSession.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void abort() {
      SpeechRecognitionSessionAbortParams _message = new SpeechRecognitionSessionAbortParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void stopCapture() {
      SpeechRecognitionSessionStopCaptureParams _message =
          new SpeechRecognitionSessionStopCaptureParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<SpeechRecognitionSession> {
    Stub(Core core, SpeechRecognitionSession impl) {
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
                SpeechRecognitionSession_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SpeechRecognitionSessionAbortParams.deserialize(messageWithHeader.getPayload());
            getImpl().abort();
            return true;
          case 1:
            SpeechRecognitionSessionStopCaptureParams.deserialize(messageWithHeader.getPayload());
            getImpl().stopCapture();
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
                getCore(), SpeechRecognitionSession_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SpeechRecognitionSessionAbortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionAbortParams(int version) {
      super(8, version);
    }

    public SpeechRecognitionSessionAbortParams() {
      this(0);
    }

    public static SpeechRecognitionSessionAbortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionAbortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionAbortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionAbortParams result =
            new SpeechRecognitionSessionAbortParams(elementsOrVersion);
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

  static final class SpeechRecognitionSessionStopCaptureParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeechRecognitionSessionStopCaptureParams(int version) {
      super(8, version);
    }

    public SpeechRecognitionSessionStopCaptureParams() {
      this(0);
    }

    public static SpeechRecognitionSessionStopCaptureParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeechRecognitionSessionStopCaptureParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeechRecognitionSessionStopCaptureParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeechRecognitionSessionStopCaptureParams result =
            new SpeechRecognitionSessionStopCaptureParams(elementsOrVersion);
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
