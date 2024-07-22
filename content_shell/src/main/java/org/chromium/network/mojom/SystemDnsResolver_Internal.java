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

class SystemDnsResolver_Internal {
  public static final Interface.Manager<SystemDnsResolver, SystemDnsResolver.Proxy> MANAGER =
      new Interface.Manager<SystemDnsResolver, SystemDnsResolver.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.SystemDnsResolver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SystemDnsResolver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SystemDnsResolver impl) {
          return new Stub(core, impl);
        }

        @Override
        public SystemDnsResolver[] buildArray(int size) {
          return new SystemDnsResolver[size];
        }
      };
  private static final int RESOLVE_ORDINAL = 0;

  SystemDnsResolver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SystemDnsResolver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void resolve(
        String hostname,
        int addrFamily,
        int flags,
        long network,
        SystemDnsResolver.Resolve_Response callback) {
      SystemDnsResolverResolveParams _message = new SystemDnsResolverResolveParams();
      _message.hostname = hostname;
      _message.addrFamily = addrFamily;
      _message.flags = flags;
      _message.network = network;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SystemDnsResolverResolveResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SystemDnsResolver> {
    Stub(Core core, SystemDnsResolver impl) {
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
                SystemDnsResolver_Internal.MANAGER, messageWithHeader);
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
                getCore(), SystemDnsResolver_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SystemDnsResolverResolveParams data =
                SystemDnsResolverResolveParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .resolve(
                    data.hostname,
                    data.addrFamily,
                    data.flags,
                    data.network,
                    new SystemDnsResolverResolveResponseParamsProxyToResponder(
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

  static final class SystemDnsResolverResolveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int addrFamily;
    public int flags;
    public String hostname;
    public long network;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SystemDnsResolverResolveParams(int version) {
      super(32, version);
    }

    public SystemDnsResolverResolveParams() {
      this(0);
    }

    public static SystemDnsResolverResolveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SystemDnsResolverResolveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SystemDnsResolverResolveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SystemDnsResolverResolveParams result =
            new SystemDnsResolverResolveParams(elementsOrVersion);
        result.hostname = decoder0.readString(8, true);
        int readInt = decoder0.readInt(16);
        result.addrFamily = readInt;
        AddressFamily.validate(readInt);
        result.addrFamily = AddressFamily.toKnownValue(result.addrFamily);
        result.flags = decoder0.readInt(20);
        result.network = decoder0.readLong(24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.hostname, 8, true);
      encoder0.encode(this.addrFamily, 16);
      encoder0.encode(this.flags, 20);
      encoder0.encode(this.network, 24);
    }
  }

  static final class SystemDnsResolverResolveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AddressList addrList;
    public int netError;
    public int osError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SystemDnsResolverResolveResponseParams(int version) {
      super(24, version);
    }

    public SystemDnsResolverResolveResponseParams() {
      this(0);
    }

    public static SystemDnsResolverResolveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SystemDnsResolverResolveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SystemDnsResolverResolveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SystemDnsResolverResolveResponseParams result =
            new SystemDnsResolverResolveResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.addrList = AddressList.decode(decoder1);
        result.osError = decoder0.readInt(16);
        result.netError = decoder0.readInt(20);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.addrList, 8, false);
      encoder0.encode(this.osError, 16);
      encoder0.encode(this.netError, 20);
    }
  }

  static class SystemDnsResolverResolveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SystemDnsResolver.Resolve_Response mCallback;

    SystemDnsResolverResolveResponseParamsForwardToCallback(
        SystemDnsResolver.Resolve_Response callback) {
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
        SystemDnsResolverResolveResponseParams response =
            SystemDnsResolverResolveResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.addrList, response.osError, response.netError);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SystemDnsResolverResolveResponseParamsProxyToResponder
      implements SystemDnsResolver.Resolve_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SystemDnsResolverResolveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(AddressList addrList, int osError, int netError) {
      SystemDnsResolverResolveResponseParams _response =
          new SystemDnsResolverResolveResponseParams();
      _response.addrList = addrList;
      _response.osError = osError;
      _response.netError = netError;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
