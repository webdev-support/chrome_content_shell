package org.chromium.attribution_reporting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TriggerRegistration extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public AggregatableDedupKey[] aggregatableDedupKeys;
  public AggregatableTriggerData[] aggregatableTriggerData;
  public AggregatableValues[] aggregatableValues;
  public SuitableOrigin aggregationCoordinatorOrigin;
  public Long debugKey;
  public boolean debugReporting;
  public EventTriggerData[] eventTriggers;
  public FilterPair filters;
  public int sourceRegistrationTimeConfig;
  public String triggerContextId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TriggerRegistration(int version) {
    super(80, version);
    this.debugReporting = false;
  }

  public TriggerRegistration() {
    this(0);
  }

  public static TriggerRegistration deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TriggerRegistration deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TriggerRegistration decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TriggerRegistration result = new TriggerRegistration(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.eventTriggers = new EventTriggerData[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.eventTriggers[i1] = EventTriggerData.decode(decoder2);
      }
      result.filters = FilterPair.decode(decoder0.readPointer(16, false));
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.aggregatableTriggerData = new AggregatableTriggerData[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.aggregatableTriggerData[i12] = AggregatableTriggerData.decode(decoder22);
      }
      Decoder decoder13 = decoder0.readPointer(32, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.aggregatableValues = new AggregatableValues[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder23 = decoder13.readPointer((i13 * 8) + 8, false);
        result.aggregatableValues[i13] = AggregatableValues.decode(decoder23);
      }
      if (decoder0.readBoolean(40, 0)) {
        result.debugKey = new Long(decoder0.readLong(48));
      } else {
        result.debugKey = null;
      }
      result.debugReporting = decoder0.readBoolean(40, 1);
      int readInt = decoder0.readInt(44);
      result.sourceRegistrationTimeConfig = readInt;
      SourceRegistrationTimeConfig.validate(readInt);
      result.sourceRegistrationTimeConfig =
          SourceRegistrationTimeConfig.toKnownValue(result.sourceRegistrationTimeConfig);
      Decoder decoder14 = decoder0.readPointer(56, false);
      DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
      result.aggregatableDedupKeys = new AggregatableDedupKey[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        Decoder decoder24 = decoder14.readPointer((i14 * 8) + 8, false);
        result.aggregatableDedupKeys[i14] = AggregatableDedupKey.decode(decoder24);
      }
      result.aggregationCoordinatorOrigin = SuitableOrigin.decode(decoder0.readPointer(64, true));
      result.triggerContextId = decoder0.readString(72, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    long debugKey$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    EventTriggerData[] eventTriggerDataArr = this.eventTriggers;
    if (eventTriggerDataArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(eventTriggerDataArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        EventTriggerData[] eventTriggerDataArr2 = this.eventTriggers;
        if (i0 >= eventTriggerDataArr2.length) {
          break;
        }
        encoder1.encode((Struct) eventTriggerDataArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.filters, 16, false);
    AggregatableTriggerData[] aggregatableTriggerDataArr = this.aggregatableTriggerData;
    if (aggregatableTriggerDataArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(aggregatableTriggerDataArr.length, 24, -1);
      int i02 = 0;
      while (true) {
        AggregatableTriggerData[] aggregatableTriggerDataArr2 = this.aggregatableTriggerData;
        if (i02 >= aggregatableTriggerDataArr2.length) {
          break;
        }
        encoder12.encode((Struct) aggregatableTriggerDataArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    AggregatableValues[] aggregatableValuesArr = this.aggregatableValues;
    if (aggregatableValuesArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(aggregatableValuesArr.length, 32, -1);
      int i03 = 0;
      while (true) {
        AggregatableValues[] aggregatableValuesArr2 = this.aggregatableValues;
        if (i03 >= aggregatableValuesArr2.length) {
          break;
        }
        encoder13.encode((Struct) aggregatableValuesArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    Long l = this.debugKey;
    boolean debugKey$flag = l != null;
    if (debugKey$flag) {
      debugKey$value = l.longValue();
    } else {
      debugKey$value = 0;
    }
    encoder0.encode(debugKey$flag, 40, 0);
    encoder0.encode(debugKey$value, 48);
    encoder0.encode(this.debugReporting, 40, 1);
    encoder0.encode(this.sourceRegistrationTimeConfig, 44);
    AggregatableDedupKey[] aggregatableDedupKeyArr = this.aggregatableDedupKeys;
    if (aggregatableDedupKeyArr == null) {
      encoder0.encodeNullPointer(56, false);
    } else {
      Encoder encoder14 = encoder0.encodePointerArray(aggregatableDedupKeyArr.length, 56, -1);
      int i04 = 0;
      while (true) {
        AggregatableDedupKey[] aggregatableDedupKeyArr2 = this.aggregatableDedupKeys;
        if (i04 >= aggregatableDedupKeyArr2.length) {
          break;
        }
        encoder14.encode((Struct) aggregatableDedupKeyArr2[i04], (i04 * 8) + 8, false);
        i04++;
      }
    }
    encoder0.encode((Struct) this.aggregationCoordinatorOrigin, 64, true);
    encoder0.encode(this.triggerContextId, 72, true);
  }
}
