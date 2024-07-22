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

class FileSystemAccessDirectoryEntriesListener_Internal {
  private static final int DID_READ_DIRECTORY_ORDINAL = 0;
  public static final Interface.Manager<
          FileSystemAccessDirectoryEntriesListener, FileSystemAccessDirectoryEntriesListener.Proxy>
      MANAGER =
          new Interface.Manager<
              FileSystemAccessDirectoryEntriesListener,
              FileSystemAccessDirectoryEntriesListener.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessDirectoryEntriesListener";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessDirectoryEntriesListener.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessDirectoryEntriesListener impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessDirectoryEntriesListener[] buildArray(int size) {
              return new FileSystemAccessDirectoryEntriesListener[size];
            }
          };

  FileSystemAccessDirectoryEntriesListener_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessDirectoryEntriesListener.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void didReadDirectory(
        FileSystemAccessError result, FileSystemAccessEntry[] entries, boolean hasMoreEntries) {
      FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams _message =
          new FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams();
      _message.result = result;
      _message.entries = entries;
      _message.hasMoreEntries = hasMoreEntries;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessDirectoryEntriesListener> {
    Stub(Core core, FileSystemAccessDirectoryEntriesListener impl) {
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
                FileSystemAccessDirectoryEntriesListener_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams data =
                FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didReadDirectory(data.result, data.entries, data.hasMoreEntries);
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
                FileSystemAccessDirectoryEntriesListener_Internal.MANAGER,
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

  static final class FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessEntry[] entries;
    public boolean hasMoreEntries;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams(int version) {
      super(32, version);
    }

    public FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams result =
            new FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams(elementsOrVersion);
        result.result = FileSystemAccessError.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.entries = new FileSystemAccessEntry[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.entries[i1] = FileSystemAccessEntry.decode(decoder2);
        }
        result.hasMoreEntries = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      FileSystemAccessEntry[] fileSystemAccessEntryArr = this.entries;
      if (fileSystemAccessEntryArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(fileSystemAccessEntryArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          FileSystemAccessEntry[] fileSystemAccessEntryArr2 = this.entries;
          if (i0 >= fileSystemAccessEntryArr2.length) {
            break;
          }
          encoder1.encode((Struct) fileSystemAccessEntryArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.hasMoreEntries, 24, 0);
    }
  }
}
