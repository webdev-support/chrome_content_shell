package org.chromium.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PrivateKeyType {
  public static final int ECDSA = 2;
  public static final int INVALID = 255;
  public static final int RSA = 0;
}
