package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Version;

public final class GlobalFirstPartySets extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public Map<SchemefulSite, SchemefulSite> aliases;
  public Map<SchemefulSite, SchemefulSite> manualAliases;
  public FirstPartySetsContextConfig manualConfig;
  public Version publicSetsVersion;
  public Map<SchemefulSite, FirstPartySetEntry> sets;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GlobalFirstPartySets(int version) {
    super(48, version);
  }

  public GlobalFirstPartySets() {
    this(0);
  }

  public static GlobalFirstPartySets deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GlobalFirstPartySets deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GlobalFirstPartySets decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GlobalFirstPartySets result = new GlobalFirstPartySets(elementsOrVersion);
      result.publicSetsVersion = Version.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      decoder1.readDataHeaderForMap();
      Decoder decoder2 = decoder1.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      SchemefulSite[] keys0 = new SchemefulSite[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
        keys0[i2] = SchemefulSite.decode(decoder3);
      }
      Decoder decoder22 = decoder1.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
      FirstPartySetEntry[] values0 = new FirstPartySetEntry[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder32 = decoder22.readPointer((i22 * 8) + 8, false);
        values0[i22] = FirstPartySetEntry.decode(decoder32);
      }
      result.sets = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.sets.put(keys0[index0], values0[index0]);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      decoder12.readDataHeaderForMap();
      Decoder decoder23 = decoder12.readPointer(8, false);
      DataHeader si23 = decoder23.readDataHeaderForPointerArray(-1);
      SchemefulSite[] keys02 = new SchemefulSite[si23.elementsOrVersion];
      for (int i23 = 0; i23 < si23.elementsOrVersion; i23++) {
        Decoder decoder33 = decoder23.readPointer((i23 * 8) + 8, false);
        keys02[i23] = SchemefulSite.decode(decoder33);
      }
      Decoder decoder24 = decoder12.readPointer(16, false);
      DataHeader si24 = decoder24.readDataHeaderForPointerArray(keys02.length);
      SchemefulSite[] values02 = new SchemefulSite[si24.elementsOrVersion];
      for (int i24 = 0; i24 < si24.elementsOrVersion; i24++) {
        Decoder decoder34 = decoder24.readPointer((i24 * 8) + 8, false);
        values02[i24] = SchemefulSite.decode(decoder34);
      }
      result.aliases = new HashMap();
      for (int index02 = 0; index02 < keys02.length; index02++) {
        result.aliases.put(keys02[index02], values02[index02]);
      }
      result.manualConfig = FirstPartySetsContextConfig.decode(decoder0.readPointer(32, false));
      Decoder decoder13 = decoder0.readPointer(40, false);
      decoder13.readDataHeaderForMap();
      Decoder decoder25 = decoder13.readPointer(8, false);
      DataHeader si25 = decoder25.readDataHeaderForPointerArray(-1);
      SchemefulSite[] keys03 = new SchemefulSite[si25.elementsOrVersion];
      for (int i25 = 0; i25 < si25.elementsOrVersion; i25++) {
        Decoder decoder35 = decoder25.readPointer((i25 * 8) + 8, false);
        keys03[i25] = SchemefulSite.decode(decoder35);
      }
      Decoder decoder26 = decoder13.readPointer(16, false);
      DataHeader si26 = decoder26.readDataHeaderForPointerArray(keys03.length);
      SchemefulSite[] values03 = new SchemefulSite[si26.elementsOrVersion];
      for (int i26 = 0; i26 < si26.elementsOrVersion; i26++) {
        Decoder decoder36 = decoder26.readPointer((i26 * 8) + 8, false);
        values03[i26] = SchemefulSite.decode(decoder36);
      }
      result.manualAliases = new HashMap();
      for (int index03 = 0; index03 < keys03.length; index03++) {
        result.manualAliases.put(keys03[index03], values03[index03]);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.publicSetsVersion, 8, false);
    if (this.sets == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(16);
      int size0 = this.sets.size();
      SchemefulSite[] keys0 = new SchemefulSite[size0];
      FirstPartySetEntry[] values0 = new FirstPartySetEntry[size0];
      int index0 = 0;
      for (Map.Entry<SchemefulSite, FirstPartySetEntry> entry0 : this.sets.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode((Struct) keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode((Struct) values0[i12], (i12 * 8) + 8, false);
      }
    }
    if (this.aliases == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder12 = encoder0.encoderForMap(24);
      int size02 = this.aliases.size();
      SchemefulSite[] keys02 = new SchemefulSite[size02];
      SchemefulSite[] values02 = new SchemefulSite[size02];
      int index02 = 0;
      for (Map.Entry<SchemefulSite, SchemefulSite> entry02 : this.aliases.entrySet()) {
        keys02[index02] = entry02.getKey();
        values02[index02] = entry02.getValue();
        index02++;
      }
      Encoder encoder23 = encoder12.encodePointerArray(keys02.length, 8, -1);
      for (int i13 = 0; i13 < keys02.length; i13++) {
        encoder23.encode((Struct) keys02[i13], (i13 * 8) + 8, false);
      }
      Encoder encoder24 = encoder12.encodePointerArray(values02.length, 16, -1);
      for (int i14 = 0; i14 < values02.length; i14++) {
        encoder24.encode((Struct) values02[i14], (i14 * 8) + 8, false);
      }
    }
    encoder0.encode((Struct) this.manualConfig, 32, false);
    if (this.manualAliases == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder13 = encoder0.encoderForMap(40);
    int size03 = this.manualAliases.size();
    SchemefulSite[] keys03 = new SchemefulSite[size03];
    SchemefulSite[] values03 = new SchemefulSite[size03];
    int index03 = 0;
    for (Map.Entry<SchemefulSite, SchemefulSite> entry03 : this.manualAliases.entrySet()) {
      keys03[index03] = entry03.getKey();
      values03[index03] = entry03.getValue();
      index03++;
    }
    Encoder encoder25 = encoder13.encodePointerArray(keys03.length, 8, -1);
    for (int i15 = 0; i15 < keys03.length; i15++) {
      encoder25.encode((Struct) keys03[i15], (i15 * 8) + 8, false);
    }
    Encoder encoder26 = encoder13.encodePointerArray(values03.length, 16, -1);
    for (int i16 = 0; i16 < values03.length; i16++) {
      encoder26.encode((Struct) values03[i16], (i16 * 8) + 8, false);
    }
  }
}
