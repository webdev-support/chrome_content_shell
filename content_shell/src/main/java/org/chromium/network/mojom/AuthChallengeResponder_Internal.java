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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class AuthChallengeResponder_Internal {
  public static final Interface.Manager<AuthChallengeResponder, AuthChallengeResponder.Proxy>
      MANAGER =
          new Interface.Manager<AuthChallengeResponder, AuthChallengeResponder.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.AuthChallengeResponder";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AuthChallengeResponder.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AuthChallengeResponder impl) {
              return new Stub(core, impl);
            }

            @Override
            public AuthChallengeResponder[] buildArray(int size) {
              return new AuthChallengeResponder[size];
            }
          };
  private static final int ON_AUTH_CREDENTIALS_ORDINAL = 0;

  AuthChallengeResponder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AuthChallengeResponder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onAuthCredentials(AuthCredentials credentials) {
      AuthChallengeResponderOnAuthCredentialsParams _message =
          new AuthChallengeResponderOnAuthCredentialsParams();
      _message.credentials = credentials;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<AuthChallengeResponder> {
    Stub(Core core, AuthChallengeResponder impl) {
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
                AuthChallengeResponder_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AuthChallengeResponderOnAuthCredentialsParams data =
                AuthChallengeResponderOnAuthCredentialsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onAuthCredentials(data.credentials);
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
                getCore(), AuthChallengeResponder_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AuthChallengeResponderOnAuthCredentialsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AuthCredentials credentials;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AuthChallengeResponderOnAuthCredentialsParams(int version) {
      super(16, version);
    }

    public AuthChallengeResponderOnAuthCredentialsParams() {
      this(0);
    }

    public static AuthChallengeResponderOnAuthCredentialsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AuthChallengeResponderOnAuthCredentialsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AuthChallengeResponderOnAuthCredentialsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AuthChallengeResponderOnAuthCredentialsParams result =
            new AuthChallengeResponderOnAuthCredentialsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.credentials = AuthCredentials.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.credentials, 8, true);
    }
  }
}
