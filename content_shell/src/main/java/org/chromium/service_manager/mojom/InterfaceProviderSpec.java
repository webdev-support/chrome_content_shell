package org.chromium.service_manager.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class InterfaceProviderSpec extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Map<String, CapabilitySet> needs;
  public Map<String, InterfaceSet> provides;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private InterfaceProviderSpec(int version) {
    super(24, version);
  }

  public InterfaceProviderSpec() {
    this(0);
  }

  public static InterfaceProviderSpec deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static InterfaceProviderSpec deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static InterfaceProviderSpec decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      InterfaceProviderSpec result = new InterfaceProviderSpec(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      decoder1.readDataHeaderForMap();
      Decoder decoder2 = decoder1.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String[] keys0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      Decoder decoder22 = decoder1.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
      InterfaceSet[] values0 = new InterfaceSet[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder3 = decoder22.readPointer((i22 * 8) + 8, false);
        values0[i22] = InterfaceSet.decode(decoder3);
      }
      result.provides = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.provides.put(keys0[index0], values0[index0]);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      decoder12.readDataHeaderForMap();
      Decoder decoder23 = decoder12.readPointer(8, false);
      DataHeader si23 = decoder23.readDataHeaderForPointerArray(-1);
      String[] keys02 = new String[si23.elementsOrVersion];
      for (int i23 = 0; i23 < si23.elementsOrVersion; i23++) {
        keys02[i23] = decoder23.readString((i23 * 8) + 8, false);
      }
      Decoder decoder24 = decoder12.readPointer(16, false);
      DataHeader si24 = decoder24.readDataHeaderForPointerArray(keys02.length);
      CapabilitySet[] values02 = new CapabilitySet[si24.elementsOrVersion];
      for (int i24 = 0; i24 < si24.elementsOrVersion; i24++) {
        Decoder decoder32 = decoder24.readPointer((i24 * 8) + 8, false);
        values02[i24] = CapabilitySet.decode(decoder32);
      }
      result.needs = new HashMap();
      for (int index02 = 0; index02 < keys02.length; index02++) {
        result.needs.put(keys02[index02], values02[index02]);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.provides == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.provides.size();
      String[] keys0 = new String[size0];
      InterfaceSet[] values0 = new InterfaceSet[size0];
      int index0 = 0;
      for (Map.Entry<String, InterfaceSet> entry0 : this.provides.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode((Struct) values0[i12], (i12 * 8) + 8, false);
      }
    }
    if (this.needs == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder12 = encoder0.encoderForMap(16);
    int size02 = this.needs.size();
    String[] keys02 = new String[size02];
    CapabilitySet[] values02 = new CapabilitySet[size02];
    int index02 = 0;
    for (Map.Entry<String, CapabilitySet> entry02 : this.needs.entrySet()) {
      keys02[index02] = entry02.getKey();
      values02[index02] = entry02.getValue();
      index02++;
    }
    Encoder encoder23 = encoder12.encodePointerArray(keys02.length, 8, -1);
    for (int i13 = 0; i13 < keys02.length; i13++) {
      encoder23.encode(keys02[i13], (i13 * 8) + 8, false);
    }
    Encoder encoder24 = encoder12.encodePointerArray(values02.length, 16, -1);
    for (int i14 = 0; i14 < values02.length; i14++) {
      encoder24.encode((Struct) values02[i14], (i14 * 8) + 8, false);
    }
  }
}
