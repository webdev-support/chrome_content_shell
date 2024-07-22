package org.chromium.content.browser.webid;

import android.app.Activity;
import org.chromium.base.Promise;

public interface IdentityCredentialsDelegate {
  default Promise<String> get(String origin, String request) {
    return Promise.rejected();
  }

  default Promise<byte[]> get(Activity activity, String origin, String request) {
    return Promise.rejected();
  }

  default Promise<Void> register(Activity activity, byte[] credential, byte[] matcher) {
    return Promise.rejected();
  }
}
