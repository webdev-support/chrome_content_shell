package org.chromium.content.browser.webid;

import org.chromium.base.ResettersForTesting;
import org.chromium.ui.base.WindowAndroid;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;

/** Class for issuing request to the Identity Credentials Manager in GMS core. */
@JNINamespace("content")
public class DigitalIdentityProvider {
  private static final String TAG = "DigitalIdentityProvider";
  private long mDigitalIdentityProvider;
  private static IdentityCredentialsDelegate sCredentials = new IdentityCredentialsDelegateImpl();

  private DigitalIdentityProvider(long digitalIdentityProvider) {
    mDigitalIdentityProvider = digitalIdentityProvider;
  }

  public static void setDelegateForTesting(IdentityCredentialsDelegate mock) {
    IdentityCredentialsDelegate oldValue = sCredentials;
    sCredentials = mock;
    ResettersForTesting.register(() -> sCredentials = oldValue);
  }

  // Methods that are called by native implementation
  @CalledByNative
  private static DigitalIdentityProvider create(long digitalIdentityProvider) {
    return new DigitalIdentityProvider(digitalIdentityProvider);
  }

  @CalledByNative
  private void destroy() {
    mDigitalIdentityProvider = 0;
  }

  /**
   * Triggers a request to the Identity Credentials Manager in GMS.
   *
   * @param window The window associated with the request.
   * @param origin The origin of the requester.
   * @param request The request.
   */
  @CalledByNative
  void request(WindowAndroid window, String origin, String request) {
    sCredentials
        .get(window.getActivity().get(), origin, request)
        .then(
            data -> {
              if (mDigitalIdentityProvider != 0) {
                DigitalIdentityProviderJni.get()
                    .onReceive(mDigitalIdentityProvider, new String(data));
              }
            },
            e -> {
              if (mDigitalIdentityProvider != 0) {
                DigitalIdentityProviderJni.get().onError(mDigitalIdentityProvider);
              }
            });
  }

  @NativeMethods
  interface Natives {
    void onReceive(long nativeDigitalIdentityProviderAndroid, String digitalIdentity);

    void onError(long nativeDigitalIdentityProviderAndroid);
  }
}
