package org.chromium.base;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Objects;
import org.jni_zero.JNINamespace;

@DoNotMock("Create a real instance instead.")
@JNINamespace("base::android")
public final class Token {
  private final long mHigh;
  private final long mLow;

  public interface Natives {
    Token createRandom();
  }

  public static Token createRandom() {
    return TokenJni.get().createRandom();
  }

  public Token(long high, long low) {
    this.mHigh = high;
    this.mLow = low;
  }

  public boolean isZero() {
    return this.mHigh == 0 && this.mLow == 0;
  }

  public long getHigh() {
    return this.mHigh;
  }

  public long getLow() {
    return this.mLow;
  }

  public String toString() {
    return String.format("%016X%016X", Long.valueOf(this.mHigh), Long.valueOf(this.mLow));
  }

  public final int hashCode() {
    return Objects.hash(Long.valueOf(this.mHigh), Long.valueOf(this.mLow));
  }

  public final boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Token other = (Token) obj;
    return other.mHigh == this.mHigh && other.mLow == this.mLow;
  }
}
