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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class AudioProcessorControls_Internal {
  private static final int GET_STATS_ORDINAL = 0;
  public static final Interface.Manager<AudioProcessorControls, AudioProcessorControls.Proxy>
      MANAGER =
          new Interface.Manager<AudioProcessorControls, AudioProcessorControls.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.AudioProcessorControls";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AudioProcessorControls.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AudioProcessorControls impl) {
              return new Stub(core, impl);
            }

            @Override
            public AudioProcessorControls[] buildArray(int size) {
              return new AudioProcessorControls[size];
            }
          };
  private static final int SET_PREFERRED_NUM_CAPTURE_CHANNELS_ORDINAL = 1;

  AudioProcessorControls_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioProcessorControls.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getStats(GetStats_Response callback) {
      AudioProcessorControlsGetStatsParams _message = new AudioProcessorControlsGetStatsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new AudioProcessorControlsGetStatsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setPreferredNumCaptureChannels(int numPreferredChannels) {
      AudioProcessorControlsSetPreferredNumCaptureChannelsParams _message =
          new AudioProcessorControlsSetPreferredNumCaptureChannelsParams();
      _message.numPreferredChannels = numPreferredChannels;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioProcessorControls> {
    Stub(Core core, AudioProcessorControls impl) {
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
                AudioProcessorControls_Internal.MANAGER, messageWithHeader);
          case 1:
            AudioProcessorControlsSetPreferredNumCaptureChannelsParams data =
                AudioProcessorControlsSetPreferredNumCaptureChannelsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setPreferredNumCaptureChannels(data.numPreferredChannels);
            return true;
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
                getCore(), AudioProcessorControls_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            AudioProcessorControlsGetStatsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getStats(
                    new AudioProcessorControlsGetStatsResponseParamsProxyToResponder(
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

  static final class AudioProcessorControlsGetStatsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioProcessorControlsGetStatsParams(int version) {
      super(8, version);
    }

    public AudioProcessorControlsGetStatsParams() {
      this(0);
    }

    public static AudioProcessorControlsGetStatsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioProcessorControlsGetStatsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioProcessorControlsGetStatsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioProcessorControlsGetStatsParams result =
            new AudioProcessorControlsGetStatsParams(elementsOrVersion);
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

  static final class AudioProcessorControlsGetStatsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioProcessingStats stats;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioProcessorControlsGetStatsResponseParams(int version) {
      super(16, version);
    }

    public AudioProcessorControlsGetStatsResponseParams() {
      this(0);
    }

    public static AudioProcessorControlsGetStatsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioProcessorControlsGetStatsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioProcessorControlsGetStatsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioProcessorControlsGetStatsResponseParams result =
            new AudioProcessorControlsGetStatsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.stats = AudioProcessingStats.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.stats, 8, false);
    }
  }

  static class AudioProcessorControlsGetStatsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioProcessorControls.GetStats_Response mCallback;

    AudioProcessorControlsGetStatsResponseParamsForwardToCallback(
        AudioProcessorControls.GetStats_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        AudioProcessorControlsGetStatsResponseParams response =
            AudioProcessorControlsGetStatsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.stats);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioProcessorControlsGetStatsResponseParamsProxyToResponder
      implements AudioProcessorControls.GetStats_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioProcessorControlsGetStatsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(AudioProcessingStats stats) {
      AudioProcessorControlsGetStatsResponseParams _response =
          new AudioProcessorControlsGetStatsResponseParams();
      _response.stats = stats;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioProcessorControlsSetPreferredNumCaptureChannelsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int numPreferredChannels;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioProcessorControlsSetPreferredNumCaptureChannelsParams(int version) {
      super(16, version);
    }

    public AudioProcessorControlsSetPreferredNumCaptureChannelsParams() {
      this(0);
    }

    public static AudioProcessorControlsSetPreferredNumCaptureChannelsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioProcessorControlsSetPreferredNumCaptureChannelsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioProcessorControlsSetPreferredNumCaptureChannelsParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioProcessorControlsSetPreferredNumCaptureChannelsParams result =
            new AudioProcessorControlsSetPreferredNumCaptureChannelsParams(elementsOrVersion);
        result.numPreferredChannels = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.numPreferredChannels, 8);
    }
  }
}
