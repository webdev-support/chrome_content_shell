package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.url.internal.mojom.Origin;

public final class UrlLoaderFactoryBundle extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean bypassRedirectChecks;
  public UrlLoaderFactory defaultFactory;
  public Map<Origin, UrlLoaderFactory> isolatedWorldFactories;
  public Map<String, UrlLoaderFactory> schemeSpecificFactories;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UrlLoaderFactoryBundle(int version) {
    super(40, version);
    this.bypassRedirectChecks = false;
  }

  public UrlLoaderFactoryBundle() {
    this(0);
  }

  public static UrlLoaderFactoryBundle deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UrlLoaderFactoryBundle deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UrlLoaderFactoryBundle decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UrlLoaderFactoryBundle result = new UrlLoaderFactoryBundle(elementsOrVersion);
      result.defaultFactory =
          (UrlLoaderFactory) decoder0.readServiceInterface(8, true, UrlLoaderFactory.MANAGER);
      Decoder decoder1 = decoder0.readPointer(16, false);
      decoder1.readDataHeaderForMap();
      Decoder decoder2 = decoder1.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String[] keys0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      UrlLoaderFactory[] values0 =
          (UrlLoaderFactory[])
              decoder1.readServiceInterfaces(16, 0, keys0.length, UrlLoaderFactory.MANAGER);
      result.schemeSpecificFactories = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.schemeSpecificFactories.put(keys0[index0], values0[index0]);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      decoder12.readDataHeaderForMap();
      Decoder decoder22 = decoder12.readPointer(8, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(-1);
      Origin[] keys02 = new Origin[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder3 = decoder22.readPointer((i22 * 8) + 8, false);
        keys02[i22] = Origin.decode(decoder3);
      }
      UrlLoaderFactory[] values02 =
          (UrlLoaderFactory[])
              decoder12.readServiceInterfaces(16, 0, keys02.length, UrlLoaderFactory.MANAGER);
      result.isolatedWorldFactories = new HashMap();
      for (int index02 = 0; index02 < keys02.length; index02++) {
        result.isolatedWorldFactories.put(keys02[index02], values02[index02]);
      }
      result.bypassRedirectChecks = decoder0.readBoolean(32, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.defaultFactory, 8, true, UrlLoaderFactory.MANAGER);
    if (this.schemeSpecificFactories == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(16);
      int size0 = this.schemeSpecificFactories.size();
      String[] keys0 = new String[size0];
      UrlLoaderFactory[] values0 = new UrlLoaderFactory[size0];
      int index0 = 0;
      for (Map.Entry<String, UrlLoaderFactory> entry0 : this.schemeSpecificFactories.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      encoder1.encode(values0, 16, 0, -1, UrlLoaderFactory.MANAGER);
    }
    if (this.isolatedWorldFactories == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder12 = encoder0.encoderForMap(24);
      int size02 = this.isolatedWorldFactories.size();
      Origin[] keys02 = new Origin[size02];
      UrlLoaderFactory[] values02 = new UrlLoaderFactory[size02];
      int index02 = 0;
      for (Map.Entry<Origin, UrlLoaderFactory> entry02 : this.isolatedWorldFactories.entrySet()) {
        keys02[index02] = entry02.getKey();
        values02[index02] = entry02.getValue();
        index02++;
      }
      Encoder encoder22 = encoder12.encodePointerArray(keys02.length, 8, -1);
      for (int i12 = 0; i12 < keys02.length; i12++) {
        encoder22.encode((Struct) keys02[i12], (i12 * 8) + 8, false);
      }
      encoder12.encode(values02, 16, 0, -1, UrlLoaderFactory.MANAGER);
    }
    encoder0.encode(this.bypassRedirectChecks, 32, 0);
  }
}
