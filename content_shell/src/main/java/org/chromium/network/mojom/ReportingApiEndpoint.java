package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class ReportingApiEndpoint extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public int attemptedReports;
  public int attemptedUploads;
  public String groupName;
  public NetworkAnonymizationKey networkAnonymizationKey;
  public Origin origin;
  public int priority;
  public UnguessableToken reportingSource;
  public int successfulReports;
  public int successfulUploads;
  public Url url;
  public int weight;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ReportingApiEndpoint(int version) {
    super(80, version);
  }

  public ReportingApiEndpoint() {
    this(0);
  }

  public static ReportingApiEndpoint deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ReportingApiEndpoint deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ReportingApiEndpoint decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ReportingApiEndpoint result = new ReportingApiEndpoint(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      result.attemptedUploads = decoder0.readInt(16);
      result.successfulUploads = decoder0.readInt(20);
      result.attemptedReports = decoder0.readInt(24);
      result.successfulReports = decoder0.readInt(28);
      result.priority = decoder0.readInt(32);
      result.weight = decoder0.readInt(36);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.origin = Origin.decode(decoder12);
      result.groupName = decoder0.readString(48, false);
      result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 56);
      Decoder decoder13 = decoder0.readPointer(72, true);
      result.reportingSource = UnguessableToken.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode(this.attemptedUploads, 16);
    encoder0.encode(this.successfulUploads, 20);
    encoder0.encode(this.attemptedReports, 24);
    encoder0.encode(this.successfulReports, 28);
    encoder0.encode(this.priority, 32);
    encoder0.encode(this.weight, 36);
    encoder0.encode((Struct) this.origin, 40, false);
    encoder0.encode(this.groupName, 48, false);
    encoder0.encode((Union) this.networkAnonymizationKey, 56, false);
    encoder0.encode((Struct) this.reportingSource, 72, true);
  }
}
