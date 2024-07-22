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

class MediaDevicesListener_Internal {
  public static final Interface.Manager<MediaDevicesListener, MediaDevicesListener.Proxy> MANAGER =
      new Interface.Manager<MediaDevicesListener, MediaDevicesListener.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.MediaDevicesListener";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public MediaDevicesListener.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, MediaDevicesListener impl) {
          return new Stub(core, impl);
        }

        @Override
        public MediaDevicesListener[] buildArray(int size) {
          return new MediaDevicesListener[size];
        }
      };
  private static final int ON_DEVICES_CHANGED_ORDINAL = 0;

  MediaDevicesListener_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaDevicesListener.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onDevicesChanged(int type, MediaDeviceInfo[] deviceInfos) {
      MediaDevicesListenerOnDevicesChangedParams _message =
          new MediaDevicesListenerOnDevicesChangedParams();
      _message.type = type;
      _message.deviceInfos = deviceInfos;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaDevicesListener> {
    Stub(Core core, MediaDevicesListener impl) {
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
                MediaDevicesListener_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaDevicesListenerOnDevicesChangedParams data =
                MediaDevicesListenerOnDevicesChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onDevicesChanged(data.type, data.deviceInfos);
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
                getCore(), MediaDevicesListener_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaDevicesListenerOnDevicesChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaDeviceInfo[] deviceInfos;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaDevicesListenerOnDevicesChangedParams(int version) {
      super(24, version);
    }

    public MediaDevicesListenerOnDevicesChangedParams() {
      this(0);
    }

    public static MediaDevicesListenerOnDevicesChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaDevicesListenerOnDevicesChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaDevicesListenerOnDevicesChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaDevicesListenerOnDevicesChangedParams result =
            new MediaDevicesListenerOnDevicesChangedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        MediaDeviceType.validate(readInt);
        result.type = MediaDeviceType.toKnownValue(result.type);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.deviceInfos = new MediaDeviceInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.deviceInfos[i1] = MediaDeviceInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      MediaDeviceInfo[] mediaDeviceInfoArr = this.deviceInfos;
      if (mediaDeviceInfoArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(mediaDeviceInfoArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        MediaDeviceInfo[] mediaDeviceInfoArr2 = this.deviceInfos;
        if (i0 < mediaDeviceInfoArr2.length) {
          encoder1.encode((Struct) mediaDeviceInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
