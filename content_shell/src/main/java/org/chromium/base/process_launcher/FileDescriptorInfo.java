package org.chromium.base.process_launcher;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

public final class FileDescriptorInfo implements Parcelable {
  public static final Creator<FileDescriptorInfo> CREATOR =
      new Creator<FileDescriptorInfo>() {
        @Override
        public FileDescriptorInfo createFromParcel(Parcel in) {
          return new FileDescriptorInfo(in);
        }

        @Override
        public FileDescriptorInfo[] newArray(int size) {
          return new FileDescriptorInfo[size];
        }
      };
  public final ParcelFileDescriptor fd;
  public final int id;
  public final long offset;
  public final long size;

  public FileDescriptorInfo(int id, ParcelFileDescriptor fd, long offset, long size) {
    this.id = id;
    this.fd = fd;
    this.offset = offset;
    this.size = size;
  }

  FileDescriptorInfo(Parcel in) {
    this.id = in.readInt();
    this.fd = (ParcelFileDescriptor) in.readParcelable(ParcelFileDescriptor.class.getClassLoader());
    this.offset = in.readLong();
    this.size = in.readLong();
  }

  @Override // android.os.Parcelable
  public int describeContents() {
    return 1;
  }

  @Override // android.os.Parcelable
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeParcelable(this.fd, 1);
    dest.writeLong(this.offset);
    dest.writeLong(this.size);
  }
}
