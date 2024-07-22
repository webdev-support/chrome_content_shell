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

class SpeculationHost_Internal {
  private static final int ENABLE_NO_VARY_SEARCH_SUPPORT_ORDINAL = 1;
  private static final int INITIATE_PREVIEW_ORDINAL = 2;
  public static final Interface.Manager<SpeculationHost, SpeculationHost.Proxy> MANAGER =
      new Interface.Manager<SpeculationHost, SpeculationHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.SpeculationHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SpeculationHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SpeculationHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public SpeculationHost[] buildArray(int size) {
          return new SpeculationHost[size];
        }
      };
  private static final int UPDATE_SPECULATION_CANDIDATES_ORDINAL = 0;

  SpeculationHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SpeculationHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void updateSpeculationCandidates(SpeculationCandidate[] candidates) {
      SpeculationHostUpdateSpeculationCandidatesParams _message =
          new SpeculationHostUpdateSpeculationCandidatesParams();
      _message.candidates = candidates;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void enableNoVarySearchSupport() {
      SpeculationHostEnableNoVarySearchSupportParams _message =
          new SpeculationHostEnableNoVarySearchSupportParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void initiatePreview(Url url) {
      SpeculationHostInitiatePreviewParams _message = new SpeculationHostInitiatePreviewParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<SpeculationHost> {
    Stub(Core core, SpeculationHost impl) {
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
                SpeculationHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SpeculationHostUpdateSpeculationCandidatesParams data =
                SpeculationHostUpdateSpeculationCandidatesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateSpeculationCandidates(data.candidates);
            return true;
          case 1:
            SpeculationHostEnableNoVarySearchSupportParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().enableNoVarySearchSupport();
            return true;
          case 2:
            SpeculationHostInitiatePreviewParams data2 =
                SpeculationHostInitiatePreviewParams.deserialize(messageWithHeader.getPayload());
            getImpl().initiatePreview(data2.url);
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
                getCore(), SpeculationHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SpeculationHostUpdateSpeculationCandidatesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SpeculationCandidate[] candidates;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeculationHostUpdateSpeculationCandidatesParams(int version) {
      super(16, version);
    }

    public SpeculationHostUpdateSpeculationCandidatesParams() {
      this(0);
    }

    public static SpeculationHostUpdateSpeculationCandidatesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeculationHostUpdateSpeculationCandidatesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeculationHostUpdateSpeculationCandidatesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeculationHostUpdateSpeculationCandidatesParams result =
            new SpeculationHostUpdateSpeculationCandidatesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.candidates = new SpeculationCandidate[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.candidates[i1] = SpeculationCandidate.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SpeculationCandidate[] speculationCandidateArr = this.candidates;
      if (speculationCandidateArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(speculationCandidateArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SpeculationCandidate[] speculationCandidateArr2 = this.candidates;
        if (i0 < speculationCandidateArr2.length) {
          encoder1.encode((Struct) speculationCandidateArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class SpeculationHostEnableNoVarySearchSupportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeculationHostEnableNoVarySearchSupportParams(int version) {
      super(8, version);
    }

    public SpeculationHostEnableNoVarySearchSupportParams() {
      this(0);
    }

    public static SpeculationHostEnableNoVarySearchSupportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeculationHostEnableNoVarySearchSupportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeculationHostEnableNoVarySearchSupportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeculationHostEnableNoVarySearchSupportParams result =
            new SpeculationHostEnableNoVarySearchSupportParams(elementsOrVersion);
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

  static final class SpeculationHostInitiatePreviewParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SpeculationHostInitiatePreviewParams(int version) {
      super(16, version);
    }

    public SpeculationHostInitiatePreviewParams() {
      this(0);
    }

    public static SpeculationHostInitiatePreviewParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SpeculationHostInitiatePreviewParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SpeculationHostInitiatePreviewParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SpeculationHostInitiatePreviewParams result =
            new SpeculationHostInitiatePreviewParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }
}
