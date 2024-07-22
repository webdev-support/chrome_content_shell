package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.BufferFormat;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GpuFeatureInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public int[] appliedGpuBlocklistEntries;
  public int[] appliedGpuDriverBugListEntries;
  public String disabledExtensions;
  public String disabledWebglExtensions;
  public int[] enabledGpuDriverBugWorkarounds;
  public int[] statusValues;
  public int[] supportedBufferFormatsForAllocationAndTexturing;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GpuFeatureInfo(int version) {
    super(64, version);
  }

  public GpuFeatureInfo() {
    this(0);
  }

  public static GpuFeatureInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GpuFeatureInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GpuFeatureInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GpuFeatureInfo result = new GpuFeatureInfo(elementsOrVersion);
      result.statusValues = decoder0.readInts(8, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.statusValues;
        if (i1 >= iArr.length) {
          break;
        }
        GpuFeatureStatus.validate(iArr[i1]);
        i1++;
      }
      result.enabledGpuDriverBugWorkarounds = decoder0.readInts(16, 0, -1);
      result.disabledExtensions = decoder0.readString(24, false);
      result.disabledWebglExtensions = decoder0.readString(32, false);
      result.appliedGpuBlocklistEntries = decoder0.readInts(40, 0, -1);
      result.appliedGpuDriverBugListEntries = decoder0.readInts(48, 0, -1);
      result.supportedBufferFormatsForAllocationAndTexturing = decoder0.readInts(56, 0, -1);
      int i12 = 0;
      while (true) {
        int[] iArr2 = result.supportedBufferFormatsForAllocationAndTexturing;
        if (i12 < iArr2.length) {
          BufferFormat.validate(iArr2[i12]);
          i12++;
        } else {
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.statusValues, 8, 0, -1);
    encoder0.encode(this.enabledGpuDriverBugWorkarounds, 16, 0, -1);
    encoder0.encode(this.disabledExtensions, 24, false);
    encoder0.encode(this.disabledWebglExtensions, 32, false);
    encoder0.encode(this.appliedGpuBlocklistEntries, 40, 0, -1);
    encoder0.encode(this.appliedGpuDriverBugListEntries, 48, 0, -1);
    encoder0.encode(this.supportedBufferFormatsForAllocationAndTexturing, 56, 0, -1);
  }
}
