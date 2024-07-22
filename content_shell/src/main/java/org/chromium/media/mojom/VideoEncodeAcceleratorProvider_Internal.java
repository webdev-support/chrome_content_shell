package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class VideoEncodeAcceleratorProvider_Internal {
  private static final int CREATE_VIDEO_ENCODE_ACCELERATOR_ORDINAL = 0;
  private static final int GET_VIDEO_ENCODE_ACCELERATOR_SUPPORTED_PROFILES_ORDINAL = 1;
  public static final Interface.Manager<
          VideoEncodeAcceleratorProvider, VideoEncodeAcceleratorProvider.Proxy>
      MANAGER =
          new Interface.Manager<
              VideoEncodeAcceleratorProvider, VideoEncodeAcceleratorProvider.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.VideoEncodeAcceleratorProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public VideoEncodeAcceleratorProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, VideoEncodeAcceleratorProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public VideoEncodeAcceleratorProvider[] buildArray(int size) {
              return new VideoEncodeAcceleratorProvider[size];
            }
          };

  VideoEncodeAcceleratorProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VideoEncodeAcceleratorProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createVideoEncodeAccelerator(InterfaceRequest<VideoEncodeAccelerator> receiver) {
      VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams _message =
          new VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void getVideoEncodeAcceleratorSupportedProfiles(
        GetVideoEncodeAcceleratorSupportedProfiles_Response callback) {
      VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams _message =
          new VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<VideoEncodeAcceleratorProvider> {
    Stub(Core core, VideoEncodeAcceleratorProvider impl) {
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
                VideoEncodeAcceleratorProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams data =
                VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createVideoEncodeAccelerator(data.receiver);
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
                VideoEncodeAcceleratorProvider_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
          default:
            return false;
          case 1:
            VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams
                .deserialize(messageWithHeader.getPayload());
            getImpl()
                .getVideoEncodeAcceleratorSupportedProfiles(
                    new VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<VideoEncodeAccelerator> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams(int version) {
      super(16, version);
    }

    public VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams result =
            new VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }

  static final class VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams(
        int version) {
      super(8, version);
    }

    public VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams result =
            new VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesParams(
                elementsOrVersion);
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

  static final
  class VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public VideoEncodeAcceleratorSupportedProfile[] profiles;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams(
        int version) {
      super(16, version);
    }

    public
    VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams() {
      this(0);
    }

    public static
    VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static
    VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static
    VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams
            result =
                new VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams(
                    elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.profiles = new VideoEncodeAcceleratorSupportedProfile[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.profiles[i1] = VideoEncodeAcceleratorSupportedProfile.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      VideoEncodeAcceleratorSupportedProfile[] videoEncodeAcceleratorSupportedProfileArr =
          this.profiles;
      if (videoEncodeAcceleratorSupportedProfileArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 =
          encoder0.encodePointerArray(videoEncodeAcceleratorSupportedProfileArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        VideoEncodeAcceleratorSupportedProfile[] videoEncodeAcceleratorSupportedProfileArr2 =
            this.profiles;
        if (i0 < videoEncodeAcceleratorSupportedProfileArr2.length) {
          encoder1.encode(
              (Struct) videoEncodeAcceleratorSupportedProfileArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static
  class VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoEncodeAcceleratorProvider.GetVideoEncodeAcceleratorSupportedProfiles_Response
        mCallback;

    VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParamsForwardToCallback(
        VideoEncodeAcceleratorProvider.GetVideoEncodeAcceleratorSupportedProfiles_Response
            callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams
            response =
                VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams
                    .deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.profiles);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParamsProxyToResponder
      implements VideoEncodeAcceleratorProvider
          .GetVideoEncodeAcceleratorSupportedProfiles_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(VideoEncodeAcceleratorSupportedProfile[] profiles) {
      VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams
          _response =
              new VideoEncodeAcceleratorProviderGetVideoEncodeAcceleratorSupportedProfilesResponseParams();
      _response.profiles = profiles;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
