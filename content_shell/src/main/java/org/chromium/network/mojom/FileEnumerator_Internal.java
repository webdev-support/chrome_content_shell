package org.chromium.network.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class FileEnumerator_Internal {
  private static final int GET_NEXT_ORDINAL = 0;
  public static final Interface.Manager<FileEnumerator, FileEnumerator.Proxy> MANAGER =
      new Interface.Manager<FileEnumerator, FileEnumerator.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.FileEnumerator";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FileEnumerator.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FileEnumerator impl) {
          return new Stub(core, impl);
        }

        @Override
        public FileEnumerator[] buildArray(int size) {
          return new FileEnumerator[size];
        }
      };

  FileEnumerator_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements FileEnumerator.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getNext(int numEntries, FileEnumerator.GetNext_Response callback) {
      FileEnumeratorGetNextParams _message = new FileEnumeratorGetNextParams();
      _message.numEntries = numEntries;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileEnumeratorGetNextResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileEnumerator> {
    Stub(Core core, FileEnumerator impl) {
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
                FileEnumerator_Internal.MANAGER, messageWithHeader);
          default:
            return false;
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
                getCore(), FileEnumerator_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FileEnumeratorGetNextParams data =
                FileEnumeratorGetNextParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getNext(
                    data.numEntries,
                    new FileEnumeratorGetNextResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FileEnumeratorGetNextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int numEntries;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileEnumeratorGetNextParams(int version) {
      super(16, version);
    }

    public FileEnumeratorGetNextParams() {
      this(0);
    }

    public static FileEnumeratorGetNextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileEnumeratorGetNextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileEnumeratorGetNextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileEnumeratorGetNextParams result = new FileEnumeratorGetNextParams(elementsOrVersion);
        result.numEntries = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.numEntries, 8);
    }
  }

  static final class FileEnumeratorGetNextResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean end;
    public FileEnumerationEntry[] entries;
    public boolean error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileEnumeratorGetNextResponseParams(int version) {
      super(24, version);
    }

    public FileEnumeratorGetNextResponseParams() {
      this(0);
    }

    public static FileEnumeratorGetNextResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileEnumeratorGetNextResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileEnumeratorGetNextResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileEnumeratorGetNextResponseParams result =
            new FileEnumeratorGetNextResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.entries = new FileEnumerationEntry[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.entries[i1] = FileEnumerationEntry.decode(decoder2);
        }
        result.end = decoder0.readBoolean(16, 0);
        result.error = decoder0.readBoolean(16, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      FileEnumerationEntry[] fileEnumerationEntryArr = this.entries;
      if (fileEnumerationEntryArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(fileEnumerationEntryArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          FileEnumerationEntry[] fileEnumerationEntryArr2 = this.entries;
          if (i0 >= fileEnumerationEntryArr2.length) {
            break;
          }
          encoder1.encode((Struct) fileEnumerationEntryArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.end, 16, 0);
      encoder0.encode(this.error, 16, 1);
    }
  }

  static class FileEnumeratorGetNextResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final FileEnumerator.GetNext_Response mCallback;

    FileEnumeratorGetNextResponseParamsForwardToCallback(FileEnumerator.GetNext_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 6)) {
          return false;
        }
        FileEnumeratorGetNextResponseParams response =
            FileEnumeratorGetNextResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.entries, response.end, response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileEnumeratorGetNextResponseParamsProxyToResponder
      implements FileEnumerator.GetNext_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileEnumeratorGetNextResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileEnumerationEntry[] entries, boolean end, boolean error) {
      FileEnumeratorGetNextResponseParams _response = new FileEnumeratorGetNextResponseParams();
      _response.entries = entries;
      _response.end = end;
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
