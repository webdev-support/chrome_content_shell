package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DigitalCredentialSelector extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String doctype;
  public DigitalCredentialFieldRequirement[] fields;
  public String[] format;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DigitalCredentialSelector(int version) {
    super(32, version);
  }

  public DigitalCredentialSelector() {
    this(0);
  }

  public static DigitalCredentialSelector deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DigitalCredentialSelector deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DigitalCredentialSelector decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DigitalCredentialSelector result = new DigitalCredentialSelector(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.format = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.format[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      result.doctype = decoder0.readString(16, true);
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.fields = new DigitalCredentialFieldRequirement[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder2 = decoder12.readPointer((i12 * 8) + 8, false);
        result.fields[i12] = DigitalCredentialFieldRequirement.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    String[] strArr = this.format;
    if (strArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.format;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.doctype, 16, true);
    DigitalCredentialFieldRequirement[] digitalCredentialFieldRequirementArr = this.fields;
    if (digitalCredentialFieldRequirementArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder12 =
        encoder0.encodePointerArray(digitalCredentialFieldRequirementArr.length, 24, -1);
    int i02 = 0;
    while (true) {
      DigitalCredentialFieldRequirement[] digitalCredentialFieldRequirementArr2 = this.fields;
      if (i02 < digitalCredentialFieldRequirementArr2.length) {
        encoder12.encode((Struct) digitalCredentialFieldRequirementArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
