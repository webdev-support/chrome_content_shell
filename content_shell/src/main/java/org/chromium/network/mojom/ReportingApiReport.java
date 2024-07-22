package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

public final class ReportingApiReport extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public int attempts;
  public DictionaryValue body;
  public int depth;
  public String group;

  public UnguessableToken f703id;
  public int status;
  public TimeTicks timestamp;
  public String type;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ReportingApiReport(int version) {
    super(72, version);
  }

  public ReportingApiReport() {
    this(0);
  }

  public static ReportingApiReport deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ReportingApiReport deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ReportingApiReport decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ReportingApiReport result = new ReportingApiReport(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.f703id = UnguessableToken.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.url = Url.decode(decoder12);
      result.group = decoder0.readString(24, false);
      result.type = decoder0.readString(32, false);
      Decoder decoder13 = decoder0.readPointer(40, false);
      result.timestamp = TimeTicks.decode(decoder13);
      result.depth = decoder0.readInt(48);
      result.attempts = decoder0.readInt(52);
      Decoder decoder14 = decoder0.readPointer(56, false);
      result.body = DictionaryValue.decode(decoder14);
      int readInt = decoder0.readInt(64);
      result.status = readInt;
      ReportingApiReportStatus.validate(readInt);
      result.status = ReportingApiReportStatus.toKnownValue(result.status);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.f703id, 8, false);
    encoder0.encode((Struct) this.url, 16, false);
    encoder0.encode(this.group, 24, false);
    encoder0.encode(this.type, 32, false);
    encoder0.encode((Struct) this.timestamp, 40, false);
    encoder0.encode(this.depth, 48);
    encoder0.encode(this.attempts, 52);
    encoder0.encode((Struct) this.body, 56, false);
    encoder0.encode(this.status, 64);
  }
}
