package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;

public class UnguessableToken implements Parcelable {
  public static final Parcelable.Creator<UnguessableToken> CREATOR =
      new Parcelable.Creator<UnguessableToken>() {
        @Override
        public UnguessableToken createFromParcel(Parcel source) {
          long high = source.readLong();
          long low = source.readLong();
          if (high == 0 || low == 0) {
            return null;
          }
          return new UnguessableToken(high, low);
        }

        @Override
        public UnguessableToken[] newArray(int size) {
          return new UnguessableToken[size];
        }
      };
  private final long mHigh;
  private final long mLow;

  private UnguessableToken(long high, long low) {
    this.mHigh = high;
    this.mLow = low;
  }

  private static UnguessableToken create(long high, long low) {
    return new UnguessableToken(high, low);
  }

  public long getHighForSerialization() {
    return this.mHigh;
  }

  public long getLowForSerialization() {
    return this.mLow;
  }

  @Override // android.os.Parcelable
  public int describeContents() {
    return 0;
  }

  @Override // android.os.Parcelable
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(this.mHigh);
    dest.writeLong(this.mLow);
  }

  public boolean equals(Object obj) {
    return obj != null
        && getClass() == obj.getClass()
        && ((UnguessableToken) obj).mHigh == this.mHigh
        && ((UnguessableToken) obj).mLow == this.mLow;
  }

  public int hashCode() {
    long j = this.mLow;
    int mLowHash = (int) (j ^ (j >>> 32));
    long j2 = this.mHigh;
    int mHighHash = (int) ((j2 >>> 32) ^ j2);
    return (mLowHash * 31) + mHighHash;
  }

  private UnguessableToken parcelAndUnparcelForTesting() {
    Parcel parcel = Parcel.obtain();
    writeToParcel(parcel, 0);
    parcel.setDataPosition(0);
    UnguessableToken token = CREATOR.createFromParcel(parcel);
    parcel.recycle();
    return token;
  }
}
