package org.chromium.content_public.common;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ResourceRequestBodyJni implements ResourceRequestBody.Natives {
  public static final JniStaticTestMocker<ResourceRequestBody.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ResourceRequestBody.Natives>() {
        @Override
        public void setInstanceForTesting(ResourceRequestBody.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ResourceRequestBodyJni.testInstance = instance;
        }
      };
  private static ResourceRequestBody.Natives testInstance;

  @Override
  public byte[] createResourceRequestBodyFromBytes(byte[] httpBody) {
    return GEN_JNI
        .org_chromium_content_1public_common_ResourceRequestBody_createResourceRequestBodyFromBytes(
            httpBody);
  }

  public static ResourceRequestBody.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ResourceRequestBody.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ResourceRequestBody.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ResourceRequestBodyJni();
  }
}
