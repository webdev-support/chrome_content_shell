package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class FileSystemAccessChangeType extends Union {

  private FileSystemAccessChangeTypeCreated mCreated;
  private FileSystemAccessChangeTypeDeleted mDeleted;
  private FileSystemAccessChangeTypeErrored mErrored;
  private FileSystemAccessChangeTypeModified mModified;
  private FileSystemAccessChangeTypeMoved mMoved;
  private FileSystemAccessChangeTypeUnsupported mUnsupported;

  public static final class Tag {
    public static final int Created = 0;
    public static final int Deleted = 1;
    public static final int Errored = 2;
    public static final int Modified = 3;
    public static final int Moved = 4;
    public static final int Unsupported = 5;
  }

  public void setCreated(FileSystemAccessChangeTypeCreated created) {
    this.mTag = 0;
    this.mCreated = created;
  }

  public FileSystemAccessChangeTypeCreated getCreated() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mCreated;
  }

  public void setDeleted(FileSystemAccessChangeTypeDeleted deleted) {
    this.mTag = 1;
    this.mDeleted = deleted;
  }

  public FileSystemAccessChangeTypeDeleted getDeleted() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mDeleted;
  }

  public void setErrored(FileSystemAccessChangeTypeErrored errored) {
    this.mTag = 2;
    this.mErrored = errored;
  }

  public FileSystemAccessChangeTypeErrored getErrored() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mErrored;
  }

  public void setModified(FileSystemAccessChangeTypeModified modified) {
    this.mTag = 3;
    this.mModified = modified;
  }

  public FileSystemAccessChangeTypeModified getModified() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mModified;
  }

  public void setMoved(FileSystemAccessChangeTypeMoved moved) {
    this.mTag = 4;
    this.mMoved = moved;
  }

  public FileSystemAccessChangeTypeMoved getMoved() {
    if (this.mTag != 4) {
      throw new AssertionError();
    }
    return this.mMoved;
  }

  public void setUnsupported(FileSystemAccessChangeTypeUnsupported unsupported) {
    this.mTag = 5;
    this.mUnsupported = unsupported;
  }

  public FileSystemAccessChangeTypeUnsupported getUnsupported() {
    if (this.mTag != 5) {
      throw new AssertionError();
    }
    return this.mUnsupported;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mCreated, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mDeleted, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mErrored, offset + 8, false);
        return;
      case 3:
        encoder0.encode((Struct) this.mModified, offset + 8, false);
        return;
      case 4:
        encoder0.encode((Struct) this.mMoved, offset + 8, false);
        return;
      case 5:
        encoder0.encode((Struct) this.mUnsupported, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static FileSystemAccessChangeType deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final FileSystemAccessChangeType decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    FileSystemAccessChangeType result = new FileSystemAccessChangeType();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mCreated = FileSystemAccessChangeTypeCreated.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mDeleted = FileSystemAccessChangeTypeDeleted.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mErrored = FileSystemAccessChangeTypeErrored.decode(decoder13);
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder14 = decoder0.readPointer(offset + 8, false);
        result.mModified = FileSystemAccessChangeTypeModified.decode(decoder14);
        result.mTag = 3;
        break;
      case 4:
        Decoder decoder15 = decoder0.readPointer(offset + 8, false);
        result.mMoved = FileSystemAccessChangeTypeMoved.decode(decoder15);
        result.mTag = 4;
        break;
      case 5:
        Decoder decoder16 = decoder0.readPointer(offset + 8, false);
        result.mUnsupported = FileSystemAccessChangeTypeUnsupported.decode(decoder16);
        result.mTag = 5;
        break;
    }
    return result;
  }
}
