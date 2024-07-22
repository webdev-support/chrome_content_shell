package org.chromium.ui.util;

import java.util.HashSet;
import java.util.Set;

public class TokenHolder {
  public static final int INVALID_TOKEN = -1;
  private final Set<Integer> mAcquiredTokens = new HashSet();
  private final Runnable mCallback;
  private int mNextToken;

  public TokenHolder(Runnable callback) {
    this.mCallback = callback;
  }

  public int acquireToken() {
    int token = this.mNextToken;
    this.mNextToken = token + 1;
    this.mAcquiredTokens.add(Integer.valueOf(token));
    if (this.mAcquiredTokens.size() == 1) {
      this.mCallback.run();
    }
    return token;
  }

  public void releaseToken(int token) {
    if (this.mAcquiredTokens.remove(Integer.valueOf(token)) && this.mAcquiredTokens.isEmpty()) {
      this.mCallback.run();
    }
  }

  public boolean hasTokens() {
    return !this.mAcquiredTokens.isEmpty();
  }

  public boolean containsOnly(int token) {
    return this.mAcquiredTokens.size() == 1
        && this.mAcquiredTokens.contains(Integer.valueOf(token));
  }
}
