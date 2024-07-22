package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.WebSandboxFlags;
import org.chromium.url.internal.mojom.Origin;

public final class FrameReplicationState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public int activeSandboxFlags;
  public FramePolicy framePolicy;
  public boolean hasActiveUserGesture;
  public boolean hasPotentiallyTrustworthyUniqueOrigin;
  public boolean hasReceivedUserGestureBeforeNav;
  public int[] insecureNavigationsSet;
  public int insecureRequestPolicy;
  public boolean isAdFrame;
  public String name;
  public Origin origin;
  public ParsedPermissionsPolicyDeclaration[] permissionsPolicyHeader;
  public String uniqueName;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FrameReplicationState(int version) {
    super(72, version);
    this.activeSandboxFlags = 0;
    this.insecureRequestPolicy = 0;
    this.hasPotentiallyTrustworthyUniqueOrigin = false;
    this.hasActiveUserGesture = false;
    this.hasReceivedUserGestureBeforeNav = false;
    this.isAdFrame = false;
  }

  public FrameReplicationState() {
    this(0);
  }

  public static FrameReplicationState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FrameReplicationState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FrameReplicationState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FrameReplicationState result = new FrameReplicationState(elementsOrVersion);
      result.origin = Origin.decode(decoder0.readPointer(8, false));
      result.name = decoder0.readString(16, false);
      result.uniqueName = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.permissionsPolicyHeader =
          new ParsedPermissionsPolicyDeclaration[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.permissionsPolicyHeader[i1] = ParsedPermissionsPolicyDeclaration.decode(decoder2);
      }
      int readInt = decoder0.readInt(40);
      result.activeSandboxFlags = readInt;
      WebSandboxFlags.validate(readInt);
      result.activeSandboxFlags = WebSandboxFlags.toKnownValue(result.activeSandboxFlags);
      int readInt2 = decoder0.readInt(44);
      result.insecureRequestPolicy = readInt2;
      InsecureRequestPolicy.validate(readInt2);
      result.insecureRequestPolicy =
          InsecureRequestPolicy.toKnownValue(result.insecureRequestPolicy);
      result.framePolicy = FramePolicy.decode(decoder0.readPointer(48, false));
      result.insecureNavigationsSet = decoder0.readInts(56, 0, -1);
      result.hasPotentiallyTrustworthyUniqueOrigin = decoder0.readBoolean(64, 0);
      result.hasActiveUserGesture = decoder0.readBoolean(64, 1);
      result.hasReceivedUserGestureBeforeNav = decoder0.readBoolean(64, 2);
      result.isAdFrame = decoder0.readBoolean(64, 3);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.origin, 8, false);
    encoder0.encode(this.name, 16, false);
    encoder0.encode(this.uniqueName, 24, false);
    ParsedPermissionsPolicyDeclaration[] parsedPermissionsPolicyDeclarationArr =
        this.permissionsPolicyHeader;
    if (parsedPermissionsPolicyDeclarationArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(parsedPermissionsPolicyDeclarationArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        ParsedPermissionsPolicyDeclaration[] parsedPermissionsPolicyDeclarationArr2 =
            this.permissionsPolicyHeader;
        if (i0 >= parsedPermissionsPolicyDeclarationArr2.length) {
          break;
        }
        encoder1.encode((Struct) parsedPermissionsPolicyDeclarationArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.activeSandboxFlags, 40);
    encoder0.encode(this.insecureRequestPolicy, 44);
    encoder0.encode((Struct) this.framePolicy, 48, false);
    encoder0.encode(this.insecureNavigationsSet, 56, 0, -1);
    encoder0.encode(this.hasPotentiallyTrustworthyUniqueOrigin, 64, 0);
    encoder0.encode(this.hasActiveUserGesture, 64, 1);
    encoder0.encode(this.hasReceivedUserGestureBeforeNav, 64, 2);
    encoder0.encode(this.isAdFrame, 64, 3);
  }
}
