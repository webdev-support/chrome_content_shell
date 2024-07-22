package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

public final class SctAuditingConfiguration extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public Url hashdanceLookupUri;
  public MutableNetworkTrafficAnnotationTag hashdanceTrafficAnnotation;
  public TimeDelta logExpectedIngestionDelay;
  public TimeDelta logMaxIngestionRandomDelay;
  public Url reportUri;
  public double samplingRate;
  public MutableNetworkTrafficAnnotationTag trafficAnnotation;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SctAuditingConfiguration(int version) {
    super(64, version);
  }

  public SctAuditingConfiguration() {
    this(0);
  }

  public static SctAuditingConfiguration deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SctAuditingConfiguration deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SctAuditingConfiguration decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SctAuditingConfiguration result = new SctAuditingConfiguration(elementsOrVersion);
      result.samplingRate = decoder0.readDouble(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.logExpectedIngestionDelay = TimeDelta.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.logMaxIngestionRandomDelay = TimeDelta.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.reportUri = Url.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.hashdanceLookupUri = Url.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, false);
      result.hashdanceTrafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.samplingRate, 8);
    encoder0.encode((Struct) this.logExpectedIngestionDelay, 16, false);
    encoder0.encode((Struct) this.logMaxIngestionRandomDelay, 24, false);
    encoder0.encode((Struct) this.reportUri, 32, false);
    encoder0.encode((Struct) this.hashdanceLookupUri, 40, false);
    encoder0.encode((Struct) this.trafficAnnotation, 48, false);
    encoder0.encode((Struct) this.hashdanceTrafficAnnotation, 56, false);
  }
}
