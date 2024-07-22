package org.chromium.content_public.common;

import org.jni_zero.JNINamespace;

@JNINamespace("content")
public final class ResourceRequestBody {
  private byte[] mEncodedNativeForm;

  public interface Natives {
    byte[] createResourceRequestBodyFromBytes(byte[] bArr);
  }

  private ResourceRequestBody(byte[] encodedNativeForm) {
    this.mEncodedNativeForm = encodedNativeForm;
  }

  private static ResourceRequestBody createFromEncodedNativeForm(byte[] encodedNativeForm) {
    return new ResourceRequestBody(encodedNativeForm);
  }

  public byte[] getEncodedNativeForm() {
    return this.mEncodedNativeForm;
  }

  public static ResourceRequestBody createFromBytes(byte[] httpBody) {
    byte[] encodedNativeForm =
        ResourceRequestBodyJni.get().createResourceRequestBodyFromBytes(httpBody);
    return createFromEncodedNativeForm(encodedNativeForm);
  }
}
