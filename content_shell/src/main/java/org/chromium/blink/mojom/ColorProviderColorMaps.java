package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.color.mojom.RendererColorId;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.SkColor;

public final class ColorProviderColorMaps extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Map<Integer, SkColor> darkColorsMap;
  public Map<Integer, SkColor> forcedColorsMap;
  public Map<Integer, SkColor> lightColorsMap;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ColorProviderColorMaps(int version) {
    super(32, version);
  }

  public ColorProviderColorMaps() {
    this(0);
  }

  public static ColorProviderColorMaps deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ColorProviderColorMaps deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ColorProviderColorMaps decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ColorProviderColorMaps result = new ColorProviderColorMaps(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      decoder1.readDataHeaderForMap();
      int[] keys0 = decoder1.readInts(8, 0, -1);
      for (int i : keys0) {
        RendererColorId.validate(i);
      }
      Decoder decoder2 = decoder1.readPointer(16, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
      SkColor[] values0 = new SkColor[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
        values0[i2] = SkColor.decode(decoder3);
      }
      result.lightColorsMap = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.lightColorsMap.put(Integer.valueOf(keys0[index0]), values0[index0]);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      decoder12.readDataHeaderForMap();
      int[] keys02 = decoder12.readInts(8, 0, -1);
      for (int i3 : keys02) {
        RendererColorId.validate(i3);
      }
      Decoder decoder22 = decoder12.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys02.length);
      SkColor[] values02 = new SkColor[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder32 = decoder22.readPointer((i22 * 8) + 8, false);
        values02[i22] = SkColor.decode(decoder32);
      }
      result.darkColorsMap = new HashMap();
      for (int index02 = 0; index02 < keys02.length; index02++) {
        result.darkColorsMap.put(Integer.valueOf(keys02[index02]), values02[index02]);
      }
      Decoder decoder13 = decoder0.readPointer(24, false);
      decoder13.readDataHeaderForMap();
      int[] keys03 = decoder13.readInts(8, 0, -1);
      for (int i4 : keys03) {
        RendererColorId.validate(i4);
      }
      Decoder decoder23 = decoder13.readPointer(16, false);
      DataHeader si23 = decoder23.readDataHeaderForPointerArray(keys03.length);
      SkColor[] values03 = new SkColor[si23.elementsOrVersion];
      for (int i23 = 0; i23 < si23.elementsOrVersion; i23++) {
        Decoder decoder33 = decoder23.readPointer((i23 * 8) + 8, false);
        values03[i23] = SkColor.decode(decoder33);
      }
      result.forcedColorsMap = new HashMap();
      for (int index03 = 0; index03 < keys03.length; index03++) {
        result.forcedColorsMap.put(Integer.valueOf(keys03[index03]), values03[index03]);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.lightColorsMap == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.lightColorsMap.size();
      int[] keys0 = new int[size0];
      SkColor[] values0 = new SkColor[size0];
      int index0 = 0;
      for (Map.Entry<Integer, SkColor> entry0 : this.lightColorsMap.entrySet()) {
        keys0[index0] = entry0.getKey().intValue();
        values0[index0] = entry0.getValue();
        index0++;
      }
      encoder1.encode(keys0, 8, 0, -1);
      Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i1 = 0; i1 < values0.length; i1++) {
        encoder2.encode((Struct) values0[i1], (i1 * 8) + 8, false);
      }
    }
    if (this.darkColorsMap == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encoderForMap(16);
      int size02 = this.darkColorsMap.size();
      int[] keys02 = new int[size02];
      SkColor[] values02 = new SkColor[size02];
      int index02 = 0;
      for (Map.Entry<Integer, SkColor> entry02 : this.darkColorsMap.entrySet()) {
        keys02[index02] = entry02.getKey().intValue();
        values02[index02] = entry02.getValue();
        index02++;
      }
      encoder12.encode(keys02, 8, 0, -1);
      Encoder encoder22 = encoder12.encodePointerArray(values02.length, 16, -1);
      for (int i12 = 0; i12 < values02.length; i12++) {
        encoder22.encode((Struct) values02[i12], (i12 * 8) + 8, false);
      }
    }
    if (this.forcedColorsMap == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder13 = encoder0.encoderForMap(24);
    int size03 = this.forcedColorsMap.size();
    int[] keys03 = new int[size03];
    SkColor[] values03 = new SkColor[size03];
    int index03 = 0;
    for (Map.Entry<Integer, SkColor> entry03 : this.forcedColorsMap.entrySet()) {
      keys03[index03] = entry03.getKey().intValue();
      values03[index03] = entry03.getValue();
      index03++;
    }
    encoder13.encode(keys03, 8, 0, -1);
    Encoder encoder23 = encoder13.encodePointerArray(values03.length, 16, -1);
    for (int i13 = 0; i13 < values03.length; i13++) {
      encoder23.encode((Struct) values03[i13], (i13 * 8) + 8, false);
    }
  }
}
