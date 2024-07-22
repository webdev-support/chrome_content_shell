package org.chromium.viz.mojom;

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

class CompositingModeReporter_Internal {
  private static final int ADD_COMPOSITING_MODE_WATCHER_ORDINAL = 0;
  public static final Interface.Manager<CompositingModeReporter, CompositingModeReporter.Proxy>
      MANAGER =
          new Interface.Manager<CompositingModeReporter, CompositingModeReporter.Proxy>() {
            @Override
            public String getName() {
              return "viz.mojom.CompositingModeReporter";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CompositingModeReporter.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CompositingModeReporter impl) {
              return new Stub(core, impl);
            }

            @Override
            public CompositingModeReporter[] buildArray(int size) {
              return new CompositingModeReporter[size];
            }
          };

  CompositingModeReporter_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CompositingModeReporter.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addCompositingModeWatcher(CompositingModeWatcher watcher) {
      CompositingModeReporterAddCompositingModeWatcherParams _message =
          new CompositingModeReporterAddCompositingModeWatcherParams();
      _message.watcher = watcher;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<CompositingModeReporter> {
    Stub(Core core, CompositingModeReporter impl) {
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
                CompositingModeReporter_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CompositingModeReporterAddCompositingModeWatcherParams data =
                CompositingModeReporterAddCompositingModeWatcherParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addCompositingModeWatcher(data.watcher);
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
                getCore(), CompositingModeReporter_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CompositingModeReporterAddCompositingModeWatcherParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CompositingModeWatcher watcher;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositingModeReporterAddCompositingModeWatcherParams(int version) {
      super(16, version);
    }

    public CompositingModeReporterAddCompositingModeWatcherParams() {
      this(0);
    }

    public static CompositingModeReporterAddCompositingModeWatcherParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CompositingModeReporterAddCompositingModeWatcherParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositingModeReporterAddCompositingModeWatcherParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositingModeReporterAddCompositingModeWatcherParams result =
            new CompositingModeReporterAddCompositingModeWatcherParams(elementsOrVersion);
        result.watcher =
            (CompositingModeWatcher)
                decoder0.readServiceInterface(8, false, CompositingModeWatcher.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.watcher, 8, false, CompositingModeWatcher.MANAGER);
    }
  }
}
