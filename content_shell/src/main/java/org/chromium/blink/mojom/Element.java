package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class Element extends Union {

  private String mBlobUuid;
  private byte[] mBytes;
  private DeprecatedFileSystemFile mDeprecatedFileSystemFile;
  private File mFile;

  public static final class Tag {
    public static final int BlobUuid = 0;
    public static final int Bytes = 1;
    public static final int DeprecatedFileSystemFile = 3;
    public static final int File = 2;
  }

  public void setBlobUuid(String blobUuid) {
    this.mTag = 0;
    this.mBlobUuid = blobUuid;
  }

  public String getBlobUuid() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mBlobUuid;
  }

  public void setBytes(byte[] bytes) {
    this.mTag = 1;
    this.mBytes = bytes;
  }

  public byte[] getBytes() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mBytes;
  }

  public void setFile(File file) {
    this.mTag = 2;
    this.mFile = file;
  }

  public File getFile() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mFile;
  }

  public void setDeprecatedFileSystemFile(DeprecatedFileSystemFile deprecatedFileSystemFile) {
    this.mTag = 3;
    this.mDeprecatedFileSystemFile = deprecatedFileSystemFile;
  }

  public DeprecatedFileSystemFile getDeprecatedFileSystemFile() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mDeprecatedFileSystemFile;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mBlobUuid, offset + 8, false);
        return;
      case 1:
        encoder0.encode(this.mBytes, offset + 8, 0, -1);
        return;
      case 2:
        encoder0.encode((Struct) this.mFile, offset + 8, false);
        return;
      case 3:
        encoder0.encode((Struct) this.mDeprecatedFileSystemFile, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static Element deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final Element decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    Element result = new Element();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mBlobUuid = decoder0.readString(offset + 8, false);
        result.mTag = 0;
        break;
      case 1:
        result.mBytes = decoder0.readBytes(offset + 8, 0, -1);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mFile = File.decode(decoder1);
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mDeprecatedFileSystemFile = DeprecatedFileSystemFile.decode(decoder12);
        result.mTag = 3;
        break;
    }
    return result;
  }
}
