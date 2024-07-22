package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class TypeSpecificFilePickerOptionsUnion extends Union {

  private DirectoryPickerOptions mDirectoryPickerOptions;
  private OpenFilePickerOptions mOpenFilePickerOptions;
  private SaveFilePickerOptions mSaveFilePickerOptions;

  public static final class Tag {
    public static final int DirectoryPickerOptions = 2;
    public static final int OpenFilePickerOptions = 0;
    public static final int SaveFilePickerOptions = 1;
  }

  public void setOpenFilePickerOptions(OpenFilePickerOptions openFilePickerOptions) {
    this.mTag = 0;
    this.mOpenFilePickerOptions = openFilePickerOptions;
  }

  public OpenFilePickerOptions getOpenFilePickerOptions() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mOpenFilePickerOptions;
  }

  public void setSaveFilePickerOptions(SaveFilePickerOptions saveFilePickerOptions) {
    this.mTag = 1;
    this.mSaveFilePickerOptions = saveFilePickerOptions;
  }

  public SaveFilePickerOptions getSaveFilePickerOptions() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mSaveFilePickerOptions;
  }

  public void setDirectoryPickerOptions(DirectoryPickerOptions directoryPickerOptions) {
    this.mTag = 2;
    this.mDirectoryPickerOptions = directoryPickerOptions;
  }

  public DirectoryPickerOptions getDirectoryPickerOptions() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mDirectoryPickerOptions;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mOpenFilePickerOptions, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mSaveFilePickerOptions, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mDirectoryPickerOptions, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static TypeSpecificFilePickerOptionsUnion deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final TypeSpecificFilePickerOptionsUnion decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    TypeSpecificFilePickerOptionsUnion result = new TypeSpecificFilePickerOptionsUnion();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mOpenFilePickerOptions = OpenFilePickerOptions.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mSaveFilePickerOptions = SaveFilePickerOptions.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mDirectoryPickerOptions = DirectoryPickerOptions.decode(decoder13);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
