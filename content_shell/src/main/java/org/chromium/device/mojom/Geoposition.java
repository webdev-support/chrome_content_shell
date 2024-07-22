package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;

public final class Geoposition extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public double accuracy;
  public double altitude;
  public double altitudeAccuracy;
  public double heading;
  public double latitude;
  public double longitude;
  public double speed;
  public Time timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Geoposition(int version) {
    super(72, version);
    this.latitude = 200.0d;
    this.longitude = 200.0d;
    this.altitude = -10000.0d;
    this.accuracy = -1.0d;
    this.altitudeAccuracy = -1.0d;
    this.heading = -1.0d;
    this.speed = -1.0d;
  }

  public Geoposition() {
    this(0);
  }

  public static Geoposition deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Geoposition deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Geoposition decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Geoposition result = new Geoposition(elementsOrVersion);
      result.latitude = decoder0.readDouble(8);
      result.longitude = decoder0.readDouble(16);
      result.altitude = decoder0.readDouble(24);
      result.accuracy = decoder0.readDouble(32);
      result.altitudeAccuracy = decoder0.readDouble(40);
      result.heading = decoder0.readDouble(48);
      result.speed = decoder0.readDouble(56);
      Decoder decoder1 = decoder0.readPointer(64, false);
      result.timestamp = Time.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.latitude, 8);
    encoder0.encode(this.longitude, 16);
    encoder0.encode(this.altitude, 24);
    encoder0.encode(this.accuracy, 32);
    encoder0.encode(this.altitudeAccuracy, 40);
    encoder0.encode(this.heading, 48);
    encoder0.encode(this.speed, 56);
    encoder0.encode((Struct) this.timestamp, 64, false);
  }
}
