package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class FileSystemAccessHandle extends Union {

  private FileSystemAccessDirectoryHandle mDirectory;
  private FileSystemAccessFileHandle mFile;

  public static final class Tag {
    public static final int Directory = 1;
    public static final int File = 0;
  }

  public void setFile(FileSystemAccessFileHandle file) {
    this.mTag = 0;
    this.mFile = file;
  }

  public FileSystemAccessFileHandle getFile() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mFile;
  }

  public void setDirectory(FileSystemAccessDirectoryHandle directory) {
    this.mTag = 1;
    this.mDirectory = directory;
  }

  public FileSystemAccessDirectoryHandle getDirectory() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mDirectory;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mFile, offset + 8, false, FileSystemAccessFileHandle.MANAGER);
        return;
      case 1:
        encoder0.encode(
            this.mDirectory, offset + 8, false, FileSystemAccessDirectoryHandle.MANAGER);
        return;
      default:
        return;
    }
  }

  public static FileSystemAccessHandle deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final FileSystemAccessHandle decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    FileSystemAccessHandle result = new FileSystemAccessHandle();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mFile =
            (FileSystemAccessFileHandle)
                decoder0.readServiceInterface(
                    offset + 8, false, FileSystemAccessFileHandle.MANAGER);
        result.mTag = 0;
        break;
      case 1:
        result.mDirectory =
            (FileSystemAccessDirectoryHandle)
                decoder0.readServiceInterface(
                    offset + 8, false, FileSystemAccessDirectoryHandle.MANAGER);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
