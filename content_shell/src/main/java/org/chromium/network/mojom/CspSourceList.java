package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CspSourceList extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowDynamic;
  public boolean allowEval;
  public boolean allowInline;
  public boolean allowInlineSpeculationRules;
  public boolean allowResponseRedirects;
  public boolean allowSelf;
  public boolean allowStar;
  public boolean allowUnsafeHashes;
  public boolean allowWasmEval;
  public boolean allowWasmUnsafeEval;
  public CspHashSource[] hashes;
  public String[] nonces;
  public boolean reportSample;
  public CspSource[] sources;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CspSourceList(int version) {
    super(40, version);
    this.allowSelf = false;
    this.allowStar = false;
    this.allowResponseRedirects = false;
    this.allowInline = false;
    this.allowInlineSpeculationRules = false;
    this.allowEval = false;
    this.allowWasmEval = false;
    this.allowWasmUnsafeEval = false;
    this.allowDynamic = false;
    this.allowUnsafeHashes = false;
    this.reportSample = false;
  }

  public CspSourceList() {
    this(0);
  }

  public static CspSourceList deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CspSourceList deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CspSourceList decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CspSourceList result = new CspSourceList(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.sources = new CspSource[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.sources[i1] = CspSource.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.nonces = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.nonces[i12] = decoder12.readString((i12 * 8) + 8, false);
      }
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.hashes = new CspHashSource[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder22 = decoder13.readPointer((i13 * 8) + 8, false);
        result.hashes[i13] = CspHashSource.decode(decoder22);
      }
      result.allowSelf = decoder0.readBoolean(32, 0);
      result.allowStar = decoder0.readBoolean(32, 1);
      result.allowResponseRedirects = decoder0.readBoolean(32, 2);
      result.allowInline = decoder0.readBoolean(32, 3);
      result.allowInlineSpeculationRules = decoder0.readBoolean(32, 4);
      result.allowEval = decoder0.readBoolean(32, 5);
      result.allowWasmEval = decoder0.readBoolean(32, 6);
      result.allowWasmUnsafeEval = decoder0.readBoolean(32, 7);
      result.allowDynamic = decoder0.readBoolean(33, 0);
      result.allowUnsafeHashes = decoder0.readBoolean(33, 1);
      result.reportSample = decoder0.readBoolean(33, 2);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    CspSource[] cspSourceArr = this.sources;
    if (cspSourceArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(cspSourceArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        CspSource[] cspSourceArr2 = this.sources;
        if (i0 >= cspSourceArr2.length) {
          break;
        }
        encoder1.encode((Struct) cspSourceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr = this.nonces;
    if (strArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr.length, 16, -1);
      int i02 = 0;
      while (true) {
        String[] strArr2 = this.nonces;
        if (i02 >= strArr2.length) {
          break;
        }
        encoder12.encode(strArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    CspHashSource[] cspHashSourceArr = this.hashes;
    if (cspHashSourceArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(cspHashSourceArr.length, 24, -1);
      int i03 = 0;
      while (true) {
        CspHashSource[] cspHashSourceArr2 = this.hashes;
        if (i03 >= cspHashSourceArr2.length) {
          break;
        }
        encoder13.encode((Struct) cspHashSourceArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    encoder0.encode(this.allowSelf, 32, 0);
    encoder0.encode(this.allowStar, 32, 1);
    encoder0.encode(this.allowResponseRedirects, 32, 2);
    encoder0.encode(this.allowInline, 32, 3);
    encoder0.encode(this.allowInlineSpeculationRules, 32, 4);
    encoder0.encode(this.allowEval, 32, 5);
    encoder0.encode(this.allowWasmEval, 32, 6);
    encoder0.encode(this.allowWasmUnsafeEval, 32, 7);
    encoder0.encode(this.allowDynamic, 33, 0);
    encoder0.encode(this.allowUnsafeHashes, 33, 1);
    encoder0.encode(this.reportSample, 33, 2);
  }
}
