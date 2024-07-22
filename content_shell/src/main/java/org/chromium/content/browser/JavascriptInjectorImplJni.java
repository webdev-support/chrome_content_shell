package org.chromium.content.browser;

import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class JavascriptInjectorImplJni implements JavascriptInjectorImpl.Natives {

  public static final JniStaticTestMocker<JavascriptInjectorImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<JavascriptInjectorImpl.Natives>() {
        @Override
        public void setInstanceForTesting(JavascriptInjectorImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          JavascriptInjectorImplJni.testInstance = instance;
        }
      };
  private static JavascriptInjectorImpl.Natives testInstance;

  JavascriptInjectorImplJni() {}

  @Override
  public void addInterface(
      long nativeJavascriptInjector,
      JavascriptInjectorImpl caller,
      Object object,
      String name,
      Class requiredAnnotation) {
    if (nativeJavascriptInjector == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_JavascriptInjectorImpl_addInterface(
        nativeJavascriptInjector, caller, object, name, requiredAnnotation);
  }

  @Override
  public long init(JavascriptInjectorImpl caller, WebContents webContents, Object retainedObjects) {
    return GEN_JNI.org_chromium_content_browser_JavascriptInjectorImpl_init(
        caller, webContents, retainedObjects);
  }

  @Override
  public void removeInterface(
      long nativeJavascriptInjector, JavascriptInjectorImpl caller, String name) {
    if (nativeJavascriptInjector == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_JavascriptInjectorImpl_removeInterface(
        nativeJavascriptInjector, caller, name);
  }

  @Override
  public void setAllowInspection(
      long nativeJavascriptInjector, JavascriptInjectorImpl caller, boolean allow) {
    if (nativeJavascriptInjector == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_JavascriptInjectorImpl_setAllowInspection(
        nativeJavascriptInjector, caller, allow);
  }

  public static JavascriptInjectorImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      JavascriptInjectorImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of JavascriptInjectorImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new JavascriptInjectorImplJni();
  }
}
