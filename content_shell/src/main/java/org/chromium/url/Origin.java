package org.chromium.url;

import org.jni_zero.JNINamespace;

@JNINamespace("url")
public class Origin {
  private final String mHost;
  private final boolean mIsOpaque;
  private final short mPort;
  private final String mScheme;
  private final long mTokenHighBits;
  private final long mTokenLowBits;

  public interface Natives {
    Origin createFromGURL(GURL gurl);

    long createNative(String str, String str2, short s, boolean z, long j, long j2);

    Origin createOpaque();
  }

  public static Origin createOpaqueOrigin() {
    return OriginJni.get().createOpaque();
  }

  public static Origin create(GURL gurl) {
    return OriginJni.get().createFromGURL(gurl);
  }

  public Origin(org.chromium.url.internal.mojom.Origin mojoOrigin) {
    this.mScheme = mojoOrigin.scheme;
    this.mHost = mojoOrigin.host;
    this.mPort = mojoOrigin.port;
    if (mojoOrigin.nonceIfOpaque != null) {
      this.mIsOpaque = true;
      this.mTokenHighBits = mojoOrigin.nonceIfOpaque.high;
      this.mTokenLowBits = mojoOrigin.nonceIfOpaque.low;
      return;
    }
    this.mIsOpaque = false;
    this.mTokenHighBits = 0L;
    this.mTokenLowBits = 0L;
  }

  private Origin(
      String scheme,
      String host,
      short port,
      boolean isOpaque,
      long tokenHighBits,
      long tokenLowBits) {
    this.mScheme = scheme;
    this.mHost = host;
    this.mPort = port;
    this.mIsOpaque = isOpaque;
    this.mTokenHighBits = tokenHighBits;
    this.mTokenLowBits = tokenLowBits;
  }

  public String getScheme() {
    return !isOpaque() ? this.mScheme : "";
  }

  public String getHost() {
    return !isOpaque() ? this.mHost : "";
  }

  public int getPort() {
    if (isOpaque()) {
      return 0;
    }
    return Short.toUnsignedInt(this.mPort);
  }

  public boolean isOpaque() {
    return this.mIsOpaque;
  }

  private long toNativeOrigin() {
    return OriginJni.get()
        .createNative(
            this.mScheme,
            this.mHost,
            this.mPort,
            this.mIsOpaque,
            this.mTokenHighBits,
            this.mTokenLowBits);
  }
}
