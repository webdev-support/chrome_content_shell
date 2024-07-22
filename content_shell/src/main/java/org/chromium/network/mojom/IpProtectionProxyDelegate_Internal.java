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
import org.chromium.mojo_base.mojom.Time;

class IpProtectionProxyDelegate_Internal {
  private static final int INVALIDATE_IP_PROTECTION_CONFIG_CACHE_TRY_AGAIN_AFTER_TIME_ORDINAL = 1;
  private static final int IS_IP_PROTECTION_ENABLED_FOR_TESTING_ORDINAL = 3;
  public static final Interface.Manager<IpProtectionProxyDelegate, IpProtectionProxyDelegate.Proxy>
      MANAGER =
          new Interface.Manager<IpProtectionProxyDelegate, IpProtectionProxyDelegate.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.IpProtectionProxyDelegate";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public IpProtectionProxyDelegate.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, IpProtectionProxyDelegate impl) {
              return new Stub(core, impl);
            }

            @Override
            public IpProtectionProxyDelegate[] buildArray(int size) {
              return new IpProtectionProxyDelegate[size];
            }
          };
  private static final int SET_IP_PROTECTION_ENABLED_ORDINAL = 2;
  private static final int VERIFY_IP_PROTECTION_CONFIG_GETTER_FOR_TESTING_ORDINAL = 0;

  IpProtectionProxyDelegate_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements IpProtectionProxyDelegate.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void verifyIpProtectionConfigGetterForTesting(
        IpProtectionProxyDelegate.VerifyIpProtectionConfigGetterForTesting_Response callback) {
      IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams _message =
          new IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void invalidateIpProtectionConfigCacheTryAgainAfterTime() {
      IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams _message =
          new IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setIpProtectionEnabled(boolean value) {
      IpProtectionProxyDelegateSetIpProtectionEnabledParams _message =
          new IpProtectionProxyDelegateSetIpProtectionEnabledParams();
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void isIpProtectionEnabledForTesting(
        IpProtectionProxyDelegate.IsIpProtectionEnabledForTesting_Response callback) {
      IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams _message =
          new IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<IpProtectionProxyDelegate> {
    Stub(Core core, IpProtectionProxyDelegate impl) {
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
                IpProtectionProxyDelegate_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          default:
            return false;
          case 1:
            IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams
                .deserialize(messageWithHeader.getPayload());
            getImpl().invalidateIpProtectionConfigCacheTryAgainAfterTime();
            return true;
          case 2:
            IpProtectionProxyDelegateSetIpProtectionEnabledParams data =
                IpProtectionProxyDelegateSetIpProtectionEnabledParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setIpProtectionEnabled(data.value);
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
                getCore(), IpProtectionProxyDelegate_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .verifyIpProtectionConfigGetterForTesting(
                    new IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          case 2:
          default:
            return false;
          case 3:
            IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .isIpProtectionEnabledForTesting(
                    new IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams(int version) {
      super(8, version);
    }

    public IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams() {
      this(0);
    }

    public static IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams result =
            new IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingParams(
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

  static final class IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BlindSignedAuthToken bsaToken;
    public Time tryAgainAfter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams(
        int version) {
      super(24, version);
    }

    public IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams() {
      this(0);
    }

    public static IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams result =
            new IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.bsaToken = BlindSignedAuthToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.tryAgainAfter = Time.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.bsaToken, 8, true);
      encoder0.encode((Struct) this.tryAgainAfter, 16, true);
    }
  }

  static
  class IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final IpProtectionProxyDelegate.VerifyIpProtectionConfigGetterForTesting_Response
        mCallback;

    IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParamsForwardToCallback(
        IpProtectionProxyDelegate.VerifyIpProtectionConfigGetterForTesting_Response callback) {
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
        IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams response =
            IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams
                .deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.bsaToken, response.tryAgainAfter);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParamsProxyToResponder
      implements IpProtectionProxyDelegate.VerifyIpProtectionConfigGetterForTesting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BlindSignedAuthToken bsaToken, Time tryAgainAfter) {
      IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams _response =
          new IpProtectionProxyDelegateVerifyIpProtectionConfigGetterForTestingResponseParams();
      _response.bsaToken = bsaToken;
      _response.tryAgainAfter = tryAgainAfter;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final
  class IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams(
        int version) {
      super(8, version);
    }

    public IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams() {
      this(0);
    }

    public static IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams result =
            new IpProtectionProxyDelegateInvalidateIpProtectionConfigCacheTryAgainAfterTimeParams(
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

  static final class IpProtectionProxyDelegateSetIpProtectionEnabledParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionProxyDelegateSetIpProtectionEnabledParams(int version) {
      super(16, version);
    }

    public IpProtectionProxyDelegateSetIpProtectionEnabledParams() {
      this(0);
    }

    public static IpProtectionProxyDelegateSetIpProtectionEnabledParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionProxyDelegateSetIpProtectionEnabledParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionProxyDelegateSetIpProtectionEnabledParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionProxyDelegateSetIpProtectionEnabledParams result =
            new IpProtectionProxyDelegateSetIpProtectionEnabledParams(elementsOrVersion);
        result.value = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.value, 8, 0);
    }
  }

  static final class IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams(int version) {
      super(8, version);
    }

    public IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams() {
      this(0);
    }

    public static IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams result =
            new IpProtectionProxyDelegateIsIpProtectionEnabledForTestingParams(elementsOrVersion);
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

  static final class IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams(int version) {
      super(16, version);
    }

    public IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams() {
      this(0);
    }

    public static IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams result =
            new IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams(
                elementsOrVersion);
        result.value = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.value, 8, 0);
    }
  }

  static
  class IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final IpProtectionProxyDelegate.IsIpProtectionEnabledForTesting_Response mCallback;

    IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParamsForwardToCallback(
        IpProtectionProxyDelegate.IsIpProtectionEnabledForTesting_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams response =
            IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.value);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParamsProxyToResponder
      implements IpProtectionProxyDelegate.IsIpProtectionEnabledForTesting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean value) {
      IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams _response =
          new IpProtectionProxyDelegateIsIpProtectionEnabledForTestingResponseParams();
      _response.value = value;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
