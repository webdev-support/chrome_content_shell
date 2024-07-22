package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoCaptureControlSupport;
import org.chromium.media.mojom.VideoCaptureFormat;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoInputDeviceCapabilities extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public Integer availability;
  public VideoCaptureControlSupport controlSupport;
  public String deviceId;
  public int facingMode;
  public VideoCaptureFormat[] formats;
  public String groupId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoInputDeviceCapabilities(int version) {
    super(56, version);
  }

  public VideoInputDeviceCapabilities() {
    this(0);
  }

  public static VideoInputDeviceCapabilities deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoInputDeviceCapabilities deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoInputDeviceCapabilities decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoInputDeviceCapabilities result = new VideoInputDeviceCapabilities(elementsOrVersion);
      result.deviceId = decoder0.readString(8, false);
      result.groupId = decoder0.readString(16, false);
      result.controlSupport = VideoCaptureControlSupport.decode(decoder0.readPointer(24, false));
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.formats = new VideoCaptureFormat[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.formats[i1] = VideoCaptureFormat.decode(decoder2);
      }
      int readInt = decoder0.readInt(40);
      result.facingMode = readInt;
      FacingMode.validate(readInt);
      result.facingMode = FacingMode.toKnownValue(result.facingMode);
      if (decoder0.readBoolean(44, 0)) {
        result.availability = new Integer(decoder0.readInt(48));
      } else {
        result.availability = null;
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    int availability$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.deviceId, 8, false);
    encoder0.encode(this.groupId, 16, false);
    encoder0.encode((Struct) this.controlSupport, 24, false);
    VideoCaptureFormat[] videoCaptureFormatArr = this.formats;
    if (videoCaptureFormatArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(videoCaptureFormatArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        VideoCaptureFormat[] videoCaptureFormatArr2 = this.formats;
        if (i0 >= videoCaptureFormatArr2.length) {
          break;
        }
        encoder1.encode((Struct) videoCaptureFormatArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.facingMode, 40);
    Integer num = this.availability;
    boolean availability$flag = num != null;
    if (availability$flag) {
      availability$value = num.intValue();
    } else {
      availability$value = 0;
    }
    encoder0.encode(availability$flag, 44, 0);
    encoder0.encode(availability$value, 48);
  }
}
