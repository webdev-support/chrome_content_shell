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

public final class FirstPartySetsContextConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public Map<SchemefulSite, FirstPartySetEntryOverride> customizations;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FirstPartySetsContextConfig(int version) {
    super(16, version);
  }

  public FirstPartySetsContextConfig() {
    this(0);
  }

  public static FirstPartySetsContextConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FirstPartySetsContextConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FirstPartySetsContextConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FirstPartySetsContextConfig result = new FirstPartySetsContextConfig(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
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
      FirstPartySetEntryOverride[] values0 = new FirstPartySetEntryOverride[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder32 = decoder22.readPointer((i22 * 8) + 8, false);
        values0[i22] = FirstPartySetEntryOverride.decode(decoder32);
      }
      result.customizations = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.customizations.put(keys0[index0], values0[index0]);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.customizations == null) {
      encoder0.encodeNullPointer(8, false);
      return;
    }
    Encoder encoder1 = encoder0.encoderForMap(8);
    int size0 = this.customizations.size();
    SchemefulSite[] keys0 = new SchemefulSite[size0];
    FirstPartySetEntryOverride[] values0 = new FirstPartySetEntryOverride[size0];
    int index0 = 0;
    for (Map.Entry<SchemefulSite, FirstPartySetEntryOverride> entry0 :
        this.customizations.entrySet()) {
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
}
