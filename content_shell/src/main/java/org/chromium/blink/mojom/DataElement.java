package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class DataElement extends Union {

  private DataElementBlob mBlob;
  private DataElementBytes mBytes;
  private DataElementFile mFile;

  public static final class Tag {
    public static final int Blob = 2;
    public static final int Bytes = 0;
    public static final int File = 1;
  }

  public void setBytes(DataElementBytes bytes) {
    this.mTag = 0;
    this.mBytes = bytes;
  }

  public DataElementBytes getBytes() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mBytes;
  }

  public void setFile(DataElementFile file) {
    this.mTag = 1;
    this.mFile = file;
  }

  public DataElementFile getFile() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mFile;
  }

  public void setBlob(DataElementBlob blob) {
    this.mTag = 2;
    this.mBlob = blob;
  }

  public DataElementBlob getBlob() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mBlob;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mBytes, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mFile, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mBlob, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static DataElement deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final DataElement decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    DataElement result = new DataElement();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mBytes = DataElementBytes.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mFile = DataElementFile.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mBlob = DataElementBlob.decode(decoder13);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
