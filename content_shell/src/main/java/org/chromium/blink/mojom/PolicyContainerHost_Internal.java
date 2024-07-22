package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.ContentSecurityPolicy;
import org.chromium.network.mojom.ReferrerPolicy;

class PolicyContainerHost_Internal {
  private static final int ADD_CONTENT_SECURITY_POLICIES_ORDINAL = 1;
  private static final int ISSUE_KEEP_ALIVE_HANDLE_ORDINAL = 2;
  public static final Interface.Manager<PolicyContainerHost, PolicyContainerHost.Proxy> MANAGER =
      new Interface.Manager<PolicyContainerHost, PolicyContainerHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PolicyContainerHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PolicyContainerHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PolicyContainerHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public PolicyContainerHost[] buildArray(int size) {
          return new PolicyContainerHost[size];
        }
      };
  private static final int SET_REFERRER_POLICY_ORDINAL = 0;

  PolicyContainerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PolicyContainerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setReferrerPolicy(int referrerPolicy) {
      PolicyContainerHostSetReferrerPolicyParams _message =
          new PolicyContainerHostSetReferrerPolicyParams();
      _message.referrerPolicy = referrerPolicy;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void addContentSecurityPolicies(ContentSecurityPolicy[] contentSecurityPolicies) {
      PolicyContainerHostAddContentSecurityPoliciesParams _message =
          new PolicyContainerHostAddContentSecurityPoliciesParams();
      _message.contentSecurityPolicies = contentSecurityPolicies;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void issueKeepAliveHandle(
        InterfaceRequest<PolicyContainerHostKeepAliveHandle> receiver) {
      PolicyContainerHostIssueKeepAliveHandleParams _message =
          new PolicyContainerHostIssueKeepAliveHandleParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<PolicyContainerHost> {
    Stub(Core core, PolicyContainerHost impl) {
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
                PolicyContainerHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PolicyContainerHostSetReferrerPolicyParams data =
                PolicyContainerHostSetReferrerPolicyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setReferrerPolicy(data.referrerPolicy);
            return true;
          case 1:
            PolicyContainerHostAddContentSecurityPoliciesParams data2 =
                PolicyContainerHostAddContentSecurityPoliciesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addContentSecurityPolicies(data2.contentSecurityPolicies);
            return true;
          case 2:
            PolicyContainerHostIssueKeepAliveHandleParams data3 =
                PolicyContainerHostIssueKeepAliveHandleParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().issueKeepAliveHandle(data3.receiver);
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
                getCore(), PolicyContainerHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PolicyContainerHostSetReferrerPolicyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int referrerPolicy;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PolicyContainerHostSetReferrerPolicyParams(int version) {
      super(16, version);
    }

    public PolicyContainerHostSetReferrerPolicyParams() {
      this(0);
    }

    public static PolicyContainerHostSetReferrerPolicyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PolicyContainerHostSetReferrerPolicyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PolicyContainerHostSetReferrerPolicyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PolicyContainerHostSetReferrerPolicyParams result =
            new PolicyContainerHostSetReferrerPolicyParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.referrerPolicy = readInt;
        ReferrerPolicy.validate(readInt);
        result.referrerPolicy = ReferrerPolicy.toKnownValue(result.referrerPolicy);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.referrerPolicy, 8);
    }
  }

  static final class PolicyContainerHostAddContentSecurityPoliciesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ContentSecurityPolicy[] contentSecurityPolicies;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PolicyContainerHostAddContentSecurityPoliciesParams(int version) {
      super(16, version);
    }

    public PolicyContainerHostAddContentSecurityPoliciesParams() {
      this(0);
    }

    public static PolicyContainerHostAddContentSecurityPoliciesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PolicyContainerHostAddContentSecurityPoliciesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PolicyContainerHostAddContentSecurityPoliciesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PolicyContainerHostAddContentSecurityPoliciesParams result =
            new PolicyContainerHostAddContentSecurityPoliciesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.contentSecurityPolicies = new ContentSecurityPolicy[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.contentSecurityPolicies[i1] = ContentSecurityPolicy.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      ContentSecurityPolicy[] contentSecurityPolicyArr = this.contentSecurityPolicies;
      if (contentSecurityPolicyArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(contentSecurityPolicyArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ContentSecurityPolicy[] contentSecurityPolicyArr2 = this.contentSecurityPolicies;
        if (i0 < contentSecurityPolicyArr2.length) {
          encoder1.encode((Struct) contentSecurityPolicyArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class PolicyContainerHostIssueKeepAliveHandleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<PolicyContainerHostKeepAliveHandle> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PolicyContainerHostIssueKeepAliveHandleParams(int version) {
      super(16, version);
    }

    public PolicyContainerHostIssueKeepAliveHandleParams() {
      this(0);
    }

    public static PolicyContainerHostIssueKeepAliveHandleParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PolicyContainerHostIssueKeepAliveHandleParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PolicyContainerHostIssueKeepAliveHandleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PolicyContainerHostIssueKeepAliveHandleParams result =
            new PolicyContainerHostIssueKeepAliveHandleParams(elementsOrVersion);
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
}
