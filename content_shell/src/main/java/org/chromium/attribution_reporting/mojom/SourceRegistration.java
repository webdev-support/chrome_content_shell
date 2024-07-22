package org.chromium.attribution_reporting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class SourceRegistration extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 104;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeDelta aggregatableReportWindow;
  public AggregationKeys aggregationKeys;
  public Long debugKey;
  public boolean debugReporting;
  public DestinationSet destinations;
  public double eventLevelEpsilon;
  public TimeDelta expiry;
  public FilterData filterData;
  public int maxEventLevelReports;
  public long priority;
  public long sourceEventId;
  public int triggerDataMatching;
  public TriggerSpecs triggerSpecs;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(104, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SourceRegistration(int version) {
    super(104, version);
    this.sourceEventId = 0L;
    this.priority = 0L;
    this.debugReporting = false;
  }

  public SourceRegistration() {
    this(0);
  }

  public static SourceRegistration deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SourceRegistration deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SourceRegistration decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SourceRegistration result = new SourceRegistration(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.destinations = DestinationSet.decode(decoder1);
      result.sourceEventId = decoder0.readLong(16);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.expiry = TimeDelta.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.triggerSpecs = TriggerSpecs.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.aggregatableReportWindow = TimeDelta.decode(decoder14);
      result.maxEventLevelReports = decoder0.readInt(48);
      if (decoder0.readBoolean(52, 0)) {
        result.debugKey = new Long(decoder0.readLong(64));
      } else {
        result.debugKey = null;
      }
      result.debugReporting = decoder0.readBoolean(52, 1);
      result.priority = decoder0.readLong(56);
      Decoder decoder15 = decoder0.readPointer(72, false);
      result.filterData = FilterData.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(80, false);
      result.aggregationKeys = AggregationKeys.decode(decoder16);
      int readInt = decoder0.readInt(88);
      result.triggerDataMatching = readInt;
      TriggerDataMatching.validate(readInt);
      result.triggerDataMatching = TriggerDataMatching.toKnownValue(result.triggerDataMatching);
      result.eventLevelEpsilon = decoder0.readDouble(96);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    long debugKey$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.destinations, 8, false);
    encoder0.encode(this.sourceEventId, 16);
    encoder0.encode((Struct) this.expiry, 24, false);
    encoder0.encode((Struct) this.triggerSpecs, 32, false);
    encoder0.encode((Struct) this.aggregatableReportWindow, 40, false);
    encoder0.encode(this.maxEventLevelReports, 48);
    Long l = this.debugKey;
    boolean debugKey$flag = l != null;
    if (debugKey$flag) {
      debugKey$value = l.longValue();
    } else {
      debugKey$value = 0;
    }
    encoder0.encode(debugKey$flag, 52, 0);
    encoder0.encode(debugKey$value, 64);
    encoder0.encode(this.debugReporting, 52, 1);
    encoder0.encode(this.priority, 56);
    encoder0.encode((Struct) this.filterData, 72, false);
    encoder0.encode((Struct) this.aggregationKeys, 80, false);
    encoder0.encode(this.triggerDataMatching, 88);
    encoder0.encode(this.eventLevelEpsilon, 96);
  }
}
