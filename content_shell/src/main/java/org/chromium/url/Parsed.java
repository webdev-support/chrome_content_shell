package org.chromium.url;

import org.jni_zero.JNINamespace;

@JNINamespace("url")
public class Parsed {
  final int mHostBegin;
  final int mHostLength;
  private final Parsed mInnerUrl;
  final int mPasswordBegin;
  final int mPasswordLength;
  final int mPathBegin;
  final int mPathLength;
  final int mPortBegin;
  final int mPortLength;
  private final boolean mPotentiallyDanglingMarkup;
  final int mQueryBegin;
  final int mQueryLength;
  final int mRefBegin;
  final int mRefLength;
  final int mSchemeBegin;
  final int mSchemeLength;
  final int mUsernameBegin;
  final int mUsernameLength;

  public interface Natives {
    long createNative(
        int i,
        int i2,
        int i3,
        int i4,
        int i5,
        int i6,
        int i7,
        int i8,
        int i9,
        int i10,
        int i11,
        int i12,
        int i13,
        int i14,
        int i15,
        int i16,
        boolean z,
        long j);
  }

  public static Parsed createEmpty() {
    return new Parsed(0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, false, null);
  }

  private Parsed(
      int schemeBegin,
      int schemeLength,
      int usernameBegin,
      int usernameLength,
      int passwordBegin,
      int passwordLength,
      int hostBegin,
      int hostLength,
      int portBegin,
      int portLength,
      int pathBegin,
      int pathLength,
      int queryBegin,
      int queryLength,
      int refBegin,
      int refLength,
      boolean potentiallyDanglingMarkup,
      Parsed innerUrl) {
    this.mSchemeBegin = schemeBegin;
    this.mSchemeLength = schemeLength;
    this.mUsernameBegin = usernameBegin;
    this.mUsernameLength = usernameLength;
    this.mPasswordBegin = passwordBegin;
    this.mPasswordLength = passwordLength;
    this.mHostBegin = hostBegin;
    this.mHostLength = hostLength;
    this.mPortBegin = portBegin;
    this.mPortLength = portLength;
    this.mPathBegin = pathBegin;
    this.mPathLength = pathLength;
    this.mQueryBegin = queryBegin;
    this.mQueryLength = queryLength;
    this.mRefBegin = refBegin;
    this.mRefLength = refLength;
    this.mPotentiallyDanglingMarkup = potentiallyDanglingMarkup;
    this.mInnerUrl = innerUrl;
  }

  public long toNativeParsed() {
    Parsed parsed = this.mInnerUrl;
    long inner = parsed != null ? parsed.toNativeParsed() : 0L;
    return ParsedJni.get()
        .createNative(
            this.mSchemeBegin,
            this.mSchemeLength,
            this.mUsernameBegin,
            this.mUsernameLength,
            this.mPasswordBegin,
            this.mPasswordLength,
            this.mHostBegin,
            this.mHostLength,
            this.mPortBegin,
            this.mPortLength,
            this.mPathBegin,
            this.mPathLength,
            this.mQueryBegin,
            this.mQueryLength,
            this.mRefBegin,
            this.mRefLength,
            this.mPotentiallyDanglingMarkup,
            inner);
  }

  public String serialize() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.mSchemeBegin).append((char) 0);
    builder.append(this.mSchemeLength).append((char) 0);
    builder.append(this.mUsernameBegin).append((char) 0);
    builder.append(this.mUsernameLength).append((char) 0);
    builder.append(this.mPasswordBegin).append((char) 0);
    builder.append(this.mPasswordLength).append((char) 0);
    builder.append(this.mHostBegin).append((char) 0);
    builder.append(this.mHostLength).append((char) 0);
    builder.append(this.mPortBegin).append((char) 0);
    builder.append(this.mPortLength).append((char) 0);
    builder.append(this.mPathBegin).append((char) 0);
    builder.append(this.mPathLength).append((char) 0);
    builder.append(this.mQueryBegin).append((char) 0);
    builder.append(this.mQueryLength).append((char) 0);
    builder.append(this.mRefBegin).append((char) 0);
    builder.append(this.mRefLength).append((char) 0);
    builder.append(this.mPotentiallyDanglingMarkup).append((char) 0);
    builder.append(this.mInnerUrl != null);
    if (this.mInnerUrl != null) {
      builder.append((char) 0).append(this.mInnerUrl.serialize());
    }
    return builder.toString();
  }

  public static Parsed deserialize(String[] tokens, int startIndex) {
    Parsed innerParsed;
    int startIndex2 = startIndex + 1;
    int schemeBegin = Integer.parseInt(tokens[startIndex]);
    int startIndex3 = startIndex2 + 1;
    int schemeLength = Integer.parseInt(tokens[startIndex2]);
    int startIndex4 = startIndex3 + 1;
    int usernameBegin = Integer.parseInt(tokens[startIndex3]);
    int startIndex5 = startIndex4 + 1;
    int usernameLength = Integer.parseInt(tokens[startIndex4]);
    int startIndex6 = startIndex5 + 1;
    int passwordBegin = Integer.parseInt(tokens[startIndex5]);
    int startIndex7 = startIndex6 + 1;
    int passwordLength = Integer.parseInt(tokens[startIndex6]);
    int startIndex8 = startIndex7 + 1;
    int hostBegin = Integer.parseInt(tokens[startIndex7]);
    int startIndex9 = startIndex8 + 1;
    int hostLength = Integer.parseInt(tokens[startIndex8]);
    int startIndex10 = startIndex9 + 1;
    int portBegin = Integer.parseInt(tokens[startIndex9]);
    int startIndex11 = startIndex10 + 1;
    int portLength = Integer.parseInt(tokens[startIndex10]);
    int startIndex12 = startIndex11 + 1;
    int pathBegin = Integer.parseInt(tokens[startIndex11]);
    int startIndex13 = startIndex12 + 1;
    int pathLength = Integer.parseInt(tokens[startIndex12]);
    int startIndex14 = startIndex13 + 1;
    int queryBegin = Integer.parseInt(tokens[startIndex13]);
    int startIndex15 = startIndex14 + 1;
    int queryLength = Integer.parseInt(tokens[startIndex14]);
    int startIndex16 = startIndex15 + 1;
    int refBegin = Integer.parseInt(tokens[startIndex15]);
    int startIndex17 = startIndex16 + 1;
    int refLength = Integer.parseInt(tokens[startIndex16]);
    int startIndex18 = startIndex17 + 1;
    boolean potentiallyDanglingMarkup = Boolean.parseBoolean(tokens[startIndex17]);
    int startIndex19 = startIndex18 + 1;
    if (!Boolean.parseBoolean(tokens[startIndex18])) {
      innerParsed = null;
    } else {
      Parsed innerParsed2 = deserialize(tokens, startIndex19);
      innerParsed = innerParsed2;
    }
    return new Parsed(
        schemeBegin,
        schemeLength,
        usernameBegin,
        usernameLength,
        passwordBegin,
        passwordLength,
        hostBegin,
        hostLength,
        portBegin,
        portLength,
        pathBegin,
        pathLength,
        queryBegin,
        queryLength,
        refBegin,
        refLength,
        potentiallyDanglingMarkup,
        innerParsed);
  }
}
