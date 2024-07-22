package org.chromium.display.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.SkcmsMatrix3x3;

public final class ColorCalibration extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public GammaCurve linearToDevice;
  public SkcmsMatrix3x3 srgbToDeviceMatrix;
  public GammaCurve srgbToLinear;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ColorCalibration(int version) {
    super(32, version);
  }

  public ColorCalibration() {
    this(0);
  }

  public static ColorCalibration deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ColorCalibration deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ColorCalibration decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ColorCalibration result = new ColorCalibration(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.srgbToLinear = GammaCurve.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.srgbToDeviceMatrix = SkcmsMatrix3x3.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.linearToDevice = GammaCurve.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.srgbToLinear, 8, false);
    encoder0.encode((Struct) this.srgbToDeviceMatrix, 16, false);
    encoder0.encode((Struct) this.linearToDevice, 24, false);
  }
}
