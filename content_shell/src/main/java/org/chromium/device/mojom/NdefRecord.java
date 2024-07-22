package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NdefRecord extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public int category;
  public byte[] data;
  public String encoding;

  public String f595id;
  public String lang;
  public String mediaType;
  public NdefMessage payloadMessage;
  public String recordType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NdefRecord(int version) {
    super(72, version);
  }

  public NdefRecord() {
    this(0);
  }

  public static NdefRecord deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NdefRecord deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NdefRecord decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NdefRecord result = new NdefRecord(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.category = readInt;
      NdefRecordTypeCategory.validate(readInt);
      result.category = NdefRecordTypeCategory.toKnownValue(result.category);
      result.recordType = decoder0.readString(16, false);
      result.mediaType = decoder0.readString(24, true);
      result.f595id = decoder0.readString(32, true);
      result.encoding = decoder0.readString(40, true);
      result.lang = decoder0.readString(48, true);
      result.data = decoder0.readBytes(56, 0, -1);
      Decoder decoder1 = decoder0.readPointer(64, true);
      result.payloadMessage = NdefMessage.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.category, 8);
    encoder0.encode(this.recordType, 16, false);
    encoder0.encode(this.mediaType, 24, true);
    encoder0.encode(this.f595id, 32, true);
    encoder0.encode(this.encoding, 40, true);
    encoder0.encode(this.lang, 48, true);
    encoder0.encode(this.data, 56, 0, -1);
    encoder0.encode((Struct) this.payloadMessage, 64, true);
  }
}
