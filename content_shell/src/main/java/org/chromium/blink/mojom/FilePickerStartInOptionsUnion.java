package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class FilePickerStartInOptionsUnion extends Union {

  private FileSystemAccessTransferToken mDirectoryToken;
  private int mWellKnownDirectory;

  public static final class Tag {
    public static final int DirectoryToken = 1;
    public static final int WellKnownDirectory = 0;
  }

  public void setWellKnownDirectory(int wellKnownDirectory) {
    this.mTag = 0;
    this.mWellKnownDirectory = wellKnownDirectory;
  }

  public int getWellKnownDirectory() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mWellKnownDirectory;
  }

  public void setDirectoryToken(FileSystemAccessTransferToken directoryToken) {
    this.mTag = 1;
    this.mDirectoryToken = directoryToken;
  }

  public FileSystemAccessTransferToken getDirectoryToken() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mDirectoryToken;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mWellKnownDirectory, offset + 8);
        return;
      case 1:
        encoder0.encode(
            this.mDirectoryToken, offset + 8, false, FileSystemAccessTransferToken.MANAGER);
        return;
      default:
        return;
    }
  }

  public static FilePickerStartInOptionsUnion deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final FilePickerStartInOptionsUnion decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    FilePickerStartInOptionsUnion result = new FilePickerStartInOptionsUnion();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        int readInt = decoder0.readInt(offset + 8);
        result.mWellKnownDirectory = readInt;
        WellKnownDirectory.validate(readInt);
        result.mWellKnownDirectory = WellKnownDirectory.toKnownValue(result.mWellKnownDirectory);
        result.mTag = 0;
        break;
      case 1:
        result.mDirectoryToken =
            (FileSystemAccessTransferToken)
                decoder0.readServiceInterface(
                    offset + 8, false, FileSystemAccessTransferToken.MANAGER);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
