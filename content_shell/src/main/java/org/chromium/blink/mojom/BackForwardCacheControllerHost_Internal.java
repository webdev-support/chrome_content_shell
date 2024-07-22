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

class BackForwardCacheControllerHost_Internal {
  private static final int DID_CHANGE_BACK_FORWARD_CACHE_DISABLING_FEATURES_ORDINAL = 1;
  private static final int EVICT_FROM_BACK_FORWARD_CACHE_ORDINAL = 0;
  public static final Interface.Manager<
          BackForwardCacheControllerHost, BackForwardCacheControllerHost.Proxy>
      MANAGER =
          new Interface.Manager<
              BackForwardCacheControllerHost, BackForwardCacheControllerHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.BackForwardCacheControllerHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public BackForwardCacheControllerHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, BackForwardCacheControllerHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public BackForwardCacheControllerHost[] buildArray(int size) {
              return new BackForwardCacheControllerHost[size];
            }
          };

  BackForwardCacheControllerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements BackForwardCacheControllerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void evictFromBackForwardCache(int reason, BlockingDetails details) {
      BackForwardCacheControllerHostEvictFromBackForwardCacheParams _message =
          new BackForwardCacheControllerHostEvictFromBackForwardCacheParams();
      _message.reason = reason;
      _message.details = details;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void didChangeBackForwardCacheDisablingFeatures(BlockingDetails[] details) {
      BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams _message =
          new BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams();
      _message.details = details;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<BackForwardCacheControllerHost> {
    Stub(Core core, BackForwardCacheControllerHost impl) {
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
                BackForwardCacheControllerHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            BackForwardCacheControllerHostEvictFromBackForwardCacheParams data =
                BackForwardCacheControllerHostEvictFromBackForwardCacheParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().evictFromBackForwardCache(data.reason, data.details);
            return true;
          case 1:
            getImpl()
                .didChangeBackForwardCacheDisablingFeatures(
                    BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams
                        .deserialize(messageWithHeader.getPayload())
                        .details);
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
                BackForwardCacheControllerHost_Internal.MANAGER,
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

  static final class BackForwardCacheControllerHostEvictFromBackForwardCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BlockingDetails details;
    public int reason;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackForwardCacheControllerHostEvictFromBackForwardCacheParams(int version) {
      super(24, version);
    }

    public BackForwardCacheControllerHostEvictFromBackForwardCacheParams() {
      this(0);
    }

    public static BackForwardCacheControllerHostEvictFromBackForwardCacheParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static BackForwardCacheControllerHostEvictFromBackForwardCacheParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackForwardCacheControllerHostEvictFromBackForwardCacheParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackForwardCacheControllerHostEvictFromBackForwardCacheParams result =
            new BackForwardCacheControllerHostEvictFromBackForwardCacheParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.reason = readInt;
        RendererEvictionReason.validate(readInt);
        result.reason = RendererEvictionReason.toKnownValue(result.reason);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.details = BlockingDetails.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reason, 8);
      encoder0.encode((Struct) this.details, 16, true);
    }
  }

  static final class BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BlockingDetails[] details;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams(
        int version) {
      super(16, version);
    }

    public BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams() {
      this(0);
    }

    public static BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams result =
            new BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.details = new BlockingDetails[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.details[i1] = BlockingDetails.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      BlockingDetails[] blockingDetailsArr = this.details;
      if (blockingDetailsArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(blockingDetailsArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        BlockingDetails[] blockingDetailsArr2 = this.details;
        if (i0 < blockingDetailsArr2.length) {
          encoder1.encode((Struct) blockingDetailsArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
