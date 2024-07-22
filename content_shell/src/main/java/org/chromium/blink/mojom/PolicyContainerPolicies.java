package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.ContentSecurityPolicy;
import org.chromium.network.mojom.CrossOriginEmbedderPolicy;
import org.chromium.network.mojom.IpAddressSpace;
import org.chromium.network.mojom.ReferrerPolicy;
import org.chromium.network.mojom.WebSandboxFlags;

public final class PolicyContainerPolicies extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowCrossOriginIsolation;
  public boolean canNavigateTopWithoutUserGesture;
  public ContentSecurityPolicy[] contentSecurityPolicies;
  public CrossOriginEmbedderPolicy crossOriginEmbedderPolicy;
  public int ipAddressSpace;
  public boolean isCredentialless;
  public int referrerPolicy;
  public int sandboxFlags;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PolicyContainerPolicies(int version) {
    super(40, version);
    this.referrerPolicy = 1;
    this.isCredentialless = false;
    this.sandboxFlags = 0;
    this.ipAddressSpace = 3;
    this.canNavigateTopWithoutUserGesture = true;
    this.allowCrossOriginIsolation = false;
  }

  public PolicyContainerPolicies() {
    this(0);
  }

  public static PolicyContainerPolicies deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PolicyContainerPolicies deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PolicyContainerPolicies decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PolicyContainerPolicies result = new PolicyContainerPolicies(elementsOrVersion);
      result.crossOriginEmbedderPolicy =
          CrossOriginEmbedderPolicy.decode(decoder0.readPointer(8, false));
      int readInt = decoder0.readInt(16);
      result.referrerPolicy = readInt;
      ReferrerPolicy.validate(readInt);
      result.referrerPolicy = ReferrerPolicy.toKnownValue(result.referrerPolicy);
      result.isCredentialless = decoder0.readBoolean(20, 0);
      result.canNavigateTopWithoutUserGesture = decoder0.readBoolean(20, 1);
      result.allowCrossOriginIsolation = decoder0.readBoolean(20, 2);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.contentSecurityPolicies = new ContentSecurityPolicy[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.contentSecurityPolicies[i1] = ContentSecurityPolicy.decode(decoder2);
      }
      int readInt2 = decoder0.readInt(32);
      result.sandboxFlags = readInt2;
      WebSandboxFlags.validate(readInt2);
      result.sandboxFlags = WebSandboxFlags.toKnownValue(result.sandboxFlags);
      int readInt3 = decoder0.readInt(36);
      result.ipAddressSpace = readInt3;
      IpAddressSpace.validate(readInt3);
      result.ipAddressSpace = IpAddressSpace.toKnownValue(result.ipAddressSpace);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.crossOriginEmbedderPolicy, 8, false);
    encoder0.encode(this.referrerPolicy, 16);
    encoder0.encode(this.isCredentialless, 20, 0);
    encoder0.encode(this.canNavigateTopWithoutUserGesture, 20, 1);
    encoder0.encode(this.allowCrossOriginIsolation, 20, 2);
    ContentSecurityPolicy[] contentSecurityPolicyArr = this.contentSecurityPolicies;
    if (contentSecurityPolicyArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(contentSecurityPolicyArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        ContentSecurityPolicy[] contentSecurityPolicyArr2 = this.contentSecurityPolicies;
        if (i0 >= contentSecurityPolicyArr2.length) {
          break;
        }
        encoder1.encode((Struct) contentSecurityPolicyArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.sandboxFlags, 32);
    encoder0.encode(this.ipAddressSpace, 36);
  }
}
