package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.filesystem.mojom.DirectoryEntry;
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
import org.chromium.mojo_base.mojom.FileError;

class FileSystemOperationListener_Internal {
  private static final int DID_WRITE_ORDINAL = 1;
  private static final int ERROR_OCCURRED_ORDINAL = 2;
  public static final Interface.Manager<
          FileSystemOperationListener, FileSystemOperationListener.Proxy>
      MANAGER =
          new Interface.Manager<FileSystemOperationListener, FileSystemOperationListener.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemOperationListener";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemOperationListener.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemOperationListener impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemOperationListener[] buildArray(int size) {
              return new FileSystemOperationListener[size];
            }
          };
  private static final int RESULTS_RETRIEVED_ORDINAL = 0;

  FileSystemOperationListener_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemOperationListener.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void resultsRetrieved(DirectoryEntry[] entries, boolean hasMore) {
      FileSystemOperationListenerResultsRetrievedParams _message =
          new FileSystemOperationListenerResultsRetrievedParams();
      _message.entries = entries;
      _message.hasMore = hasMore;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void didWrite(long byteCount, boolean complete) {
      FileSystemOperationListenerDidWriteParams _message =
          new FileSystemOperationListenerDidWriteParams();
      _message.byteCount = byteCount;
      _message.complete = complete;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void errorOccurred(int errorCode) {
      FileSystemOperationListenerErrorOccurredParams _message =
          new FileSystemOperationListenerErrorOccurredParams();
      _message.errorCode = errorCode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemOperationListener> {
    Stub(Core core, FileSystemOperationListener impl) {
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
                FileSystemOperationListener_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FileSystemOperationListenerResultsRetrievedParams data =
                FileSystemOperationListenerResultsRetrievedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().resultsRetrieved(data.entries, data.hasMore);
            return true;
          case 1:
            FileSystemOperationListenerDidWriteParams data2 =
                FileSystemOperationListenerDidWriteParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didWrite(data2.byteCount, data2.complete);
            return true;
          case 2:
            getImpl()
                .errorOccurred(
                    FileSystemOperationListenerErrorOccurredParams.deserialize(
                            messageWithHeader.getPayload())
                        .errorCode);
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
                FileSystemOperationListener_Internal.MANAGER,
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

  static final class FileSystemOperationListenerResultsRetrievedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DirectoryEntry[] entries;
    public boolean hasMore;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemOperationListenerResultsRetrievedParams(int version) {
      super(24, version);
    }

    public FileSystemOperationListenerResultsRetrievedParams() {
      this(0);
    }

    public static FileSystemOperationListenerResultsRetrievedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemOperationListenerResultsRetrievedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemOperationListenerResultsRetrievedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemOperationListenerResultsRetrievedParams result =
            new FileSystemOperationListenerResultsRetrievedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.entries = new DirectoryEntry[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.entries[i1] = DirectoryEntry.decode(decoder2);
        }
        result.hasMore = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      DirectoryEntry[] directoryEntryArr = this.entries;
      if (directoryEntryArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(directoryEntryArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          DirectoryEntry[] directoryEntryArr2 = this.entries;
          if (i0 >= directoryEntryArr2.length) {
            break;
          }
          encoder1.encode((Struct) directoryEntryArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.hasMore, 16, 0);
    }
  }

  static final class FileSystemOperationListenerDidWriteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long byteCount;
    public boolean complete;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemOperationListenerDidWriteParams(int version) {
      super(24, version);
    }

    public FileSystemOperationListenerDidWriteParams() {
      this(0);
    }

    public static FileSystemOperationListenerDidWriteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemOperationListenerDidWriteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemOperationListenerDidWriteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemOperationListenerDidWriteParams result =
            new FileSystemOperationListenerDidWriteParams(elementsOrVersion);
        result.byteCount = decoder0.readLong(8);
        result.complete = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.byteCount, 8);
      encoder0.encode(this.complete, 16, 0);
    }
  }

  static final class FileSystemOperationListenerErrorOccurredParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemOperationListenerErrorOccurredParams(int version) {
      super(16, version);
    }

    public FileSystemOperationListenerErrorOccurredParams() {
      this(0);
    }

    public static FileSystemOperationListenerErrorOccurredParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemOperationListenerErrorOccurredParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemOperationListenerErrorOccurredParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemOperationListenerErrorOccurredParams result =
            new FileSystemOperationListenerErrorOccurredParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
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
}
