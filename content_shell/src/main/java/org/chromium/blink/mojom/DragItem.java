package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class DragItem extends Union {

  private DragItemBinary mBinary;
  private DataTransferFile mFile;
  private DragItemFileSystemFile mFileSystemFile;
  private DragItemString mString;

  public static final class Tag {
    public static final int Binary = 2;
    public static final int File = 1;
    public static final int FileSystemFile = 3;
    public static final int String = 0;
  }

  public void setString(DragItemString string) {
    this.mTag = 0;
    this.mString = string;
  }

  public DragItemString getString() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mString;
  }

  public void setFile(DataTransferFile file) {
    this.mTag = 1;
    this.mFile = file;
  }

  public DataTransferFile getFile() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mFile;
  }

  public void setBinary(DragItemBinary binary) {
    this.mTag = 2;
    this.mBinary = binary;
  }

  public DragItemBinary getBinary() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mBinary;
  }

  public void setFileSystemFile(DragItemFileSystemFile fileSystemFile) {
    this.mTag = 3;
    this.mFileSystemFile = fileSystemFile;
  }

  public DragItemFileSystemFile getFileSystemFile() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mFileSystemFile;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mString, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mFile, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mBinary, offset + 8, false);
        return;
      case 3:
        encoder0.encode((Struct) this.mFileSystemFile, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static DragItem deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final DragItem decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    DragItem result = new DragItem();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mString = DragItemString.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mFile = DataTransferFile.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mBinary = DragItemBinary.decode(decoder13);
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder14 = decoder0.readPointer(offset + 8, false);
        result.mFileSystemFile = DragItemFileSystemFile.decode(decoder14);
        result.mTag = 3;
        break;
    }
    return result;
  }
}
