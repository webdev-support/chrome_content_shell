package org.chromium.ui.resources;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ResourceFactoryJni implements ResourceFactory.Natives {
  public static final JniStaticTestMocker<ResourceFactory.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ResourceFactory.Natives>() {
        @Override
        public void setInstanceForTesting(ResourceFactory.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ResourceFactoryJni.testInstance = instance;
        }
      };
  private static ResourceFactory.Natives testInstance;

  @Override
  public long createBitmapResource() {
    return GEN_JNI.org_chromium_ui_resources_ResourceFactory_createBitmapResource();
  }

  @Override
  public long createNinePatchBitmapResource(
      int paddingLeft,
      int paddingTop,
      int paddingRight,
      int paddingBottom,
      int apertureLeft,
      int apertureTop,
      int apertureRight,
      int apertureBottom) {
    return GEN_JNI.org_chromium_ui_resources_ResourceFactory_createNinePatchBitmapResource(
        paddingLeft,
        paddingTop,
        paddingRight,
        paddingBottom,
        apertureLeft,
        apertureTop,
        apertureRight,
        apertureBottom);
  }

  public static ResourceFactory.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ResourceFactory.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ResourceFactory.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ResourceFactoryJni();
  }
}
