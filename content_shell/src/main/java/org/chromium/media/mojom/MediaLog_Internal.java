package org.chromium.media.mojom;

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

class MediaLog_Internal {
  private static final int ADD_LOG_RECORD_ORDINAL = 0;
  public static final Interface.Manager<MediaLog, MediaLog.Proxy> MANAGER =
      new Interface.Manager<MediaLog, MediaLog.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.MediaLog";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public MediaLog.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, MediaLog impl) {
          return new Stub(core, impl);
        }

        @Override
        public MediaLog[] buildArray(int size) {
          return new MediaLog[size];
        }
      };

  MediaLog_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements MediaLog.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addLogRecord(MediaLogRecord event) {
      MediaLogAddLogRecordParams _message = new MediaLogAddLogRecordParams();
      _message.event = event;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaLog> {
    Stub(Core core, MediaLog impl) {
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
                MediaLog_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaLogAddLogRecordParams data =
                MediaLogAddLogRecordParams.deserialize(messageWithHeader.getPayload());
            getImpl().addLogRecord(data.event);
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
                getCore(), MediaLog_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaLogAddLogRecordParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaLogRecord event;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaLogAddLogRecordParams(int version) {
      super(16, version);
    }

    public MediaLogAddLogRecordParams() {
      this(0);
    }

    public static MediaLogAddLogRecordParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaLogAddLogRecordParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaLogAddLogRecordParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaLogAddLogRecordParams result = new MediaLogAddLogRecordParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.event = MediaLogRecord.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.event, 8, false);
    }
  }
}
