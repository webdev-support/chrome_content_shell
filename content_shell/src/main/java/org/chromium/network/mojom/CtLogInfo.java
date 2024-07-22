package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class CtLogInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public String currentOperator;
  public Time disqualifiedAt;

  public String f695id;
  public TimeDelta mmd;
  public String name;
  public PreviousOperatorEntry[] previousOperators;
  public String publicKey;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CtLogInfo(int version) {
    super(64, version);
  }

  public CtLogInfo() {
    this(0);
  }

  public static CtLogInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CtLogInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CtLogInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CtLogInfo result = new CtLogInfo(elementsOrVersion);
      result.f695id = decoder0.readString(8, false);
      result.publicKey = decoder0.readString(16, false);
      result.name = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, true);
      result.disqualifiedAt = Time.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.mmd = TimeDelta.decode(decoder12);
      result.currentOperator = decoder0.readString(48, false);
      Decoder decoder13 = decoder0.readPointer(56, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.previousOperators = new PreviousOperatorEntry[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.previousOperators[i1] = PreviousOperatorEntry.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f695id, 8, false);
    encoder0.encode(this.publicKey, 16, false);
    encoder0.encode(this.name, 24, false);
    encoder0.encode((Struct) this.disqualifiedAt, 32, true);
    encoder0.encode((Struct) this.mmd, 40, false);
    encoder0.encode(this.currentOperator, 48, false);
    PreviousOperatorEntry[] previousOperatorEntryArr = this.previousOperators;
    if (previousOperatorEntryArr == null) {
      encoder0.encodeNullPointer(56, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(previousOperatorEntryArr.length, 56, -1);
    int i0 = 0;
    while (true) {
      PreviousOperatorEntry[] previousOperatorEntryArr2 = this.previousOperators;
      if (i0 < previousOperatorEntryArr2.length) {
        encoder1.encode((Struct) previousOperatorEntryArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
