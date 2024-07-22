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
import org.chromium.url.mojom.Url;

class WebLaunchService_Internal {
  private static final int ENQUEUE_LAUNCH_PARAMS_ORDINAL = 1;
  public static final Interface.Manager<WebLaunchService, WebLaunchService.Proxy> MANAGER =
      new Interface.Manager<WebLaunchService, WebLaunchService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WebLaunchService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebLaunchService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebLaunchService impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebLaunchService[] buildArray(int size) {
          return new WebLaunchService[size];
        }
      };
  private static final int SET_LAUNCH_FILES_ORDINAL = 0;

  WebLaunchService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WebLaunchService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setLaunchFiles(FileSystemAccessEntry[] files) {
      WebLaunchServiceSetLaunchFilesParams _message = new WebLaunchServiceSetLaunchFilesParams();
      _message.files = files;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void enqueueLaunchParams(Url launchUrl) {
      WebLaunchServiceEnqueueLaunchParamsParams _message =
          new WebLaunchServiceEnqueueLaunchParamsParams();
      _message.launchUrl = launchUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<WebLaunchService> {
    Stub(Core core, WebLaunchService impl) {
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
                WebLaunchService_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WebLaunchServiceSetLaunchFilesParams data =
                WebLaunchServiceSetLaunchFilesParams.deserialize(messageWithHeader.getPayload());
            getImpl().setLaunchFiles(data.files);
            return true;
          case 1:
            WebLaunchServiceEnqueueLaunchParamsParams data2 =
                WebLaunchServiceEnqueueLaunchParamsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().enqueueLaunchParams(data2.launchUrl);
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
                getCore(), WebLaunchService_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebLaunchServiceSetLaunchFilesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessEntry[] files;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebLaunchServiceSetLaunchFilesParams(int version) {
      super(16, version);
    }

    public WebLaunchServiceSetLaunchFilesParams() {
      this(0);
    }

    public static WebLaunchServiceSetLaunchFilesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebLaunchServiceSetLaunchFilesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebLaunchServiceSetLaunchFilesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebLaunchServiceSetLaunchFilesParams result =
            new WebLaunchServiceSetLaunchFilesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.files = new FileSystemAccessEntry[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.files[i1] = FileSystemAccessEntry.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      FileSystemAccessEntry[] fileSystemAccessEntryArr = this.files;
      if (fileSystemAccessEntryArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(fileSystemAccessEntryArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        FileSystemAccessEntry[] fileSystemAccessEntryArr2 = this.files;
        if (i0 < fileSystemAccessEntryArr2.length) {
          encoder1.encode((Struct) fileSystemAccessEntryArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class WebLaunchServiceEnqueueLaunchParamsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url launchUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebLaunchServiceEnqueueLaunchParamsParams(int version) {
      super(16, version);
    }

    public WebLaunchServiceEnqueueLaunchParamsParams() {
      this(0);
    }

    public static WebLaunchServiceEnqueueLaunchParamsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebLaunchServiceEnqueueLaunchParamsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebLaunchServiceEnqueueLaunchParamsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebLaunchServiceEnqueueLaunchParamsParams result =
            new WebLaunchServiceEnqueueLaunchParamsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.launchUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.launchUrl, 8, false);
    }
  }
}
