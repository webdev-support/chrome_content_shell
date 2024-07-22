package org.chromium.content.browser;

import org.chromium.content_public.browser.MessagePayload;
import org.chromium.content_public.browser.MessagePort;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class AppWebMessagePortJni implements AppWebMessagePort.Natives {

  public static final JniStaticTestMocker<AppWebMessagePort.Natives> TEST_HOOKS =
      new JniStaticTestMocker<AppWebMessagePort.Natives>() {
        @Override
        public void setInstanceForTesting(AppWebMessagePort.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          AppWebMessagePortJni.testInstance = instance;
        }
      };
  private static AppWebMessagePort.Natives testInstance;

  AppWebMessagePortJni() {}

  @Override
  public void closeAndDestroy(long nativeAppWebMessagePort) {
    if (nativeAppWebMessagePort == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_AppWebMessagePort_closeAndDestroy(nativeAppWebMessagePort);
  }

  @Override
  public AppWebMessagePort[] createPair() {
    return (AppWebMessagePort[])
        GEN_JNI.org_chromium_content_browser_AppWebMessagePort_createPair();
  }

  @Override
  public void postMessage(
      long nativeAppWebMessagePort, MessagePayload messagePayload, MessagePort[] sentPorts) {
    if (nativeAppWebMessagePort == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_AppWebMessagePort_postMessage(
        nativeAppWebMessagePort, messagePayload, sentPorts);
  }

  @Override
  public void setShouldReceiveMessages(long nativeAppWebMessagePort, boolean shouldReceiveMessage) {
    if (nativeAppWebMessagePort == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_AppWebMessagePort_setShouldReceiveMessages(
        nativeAppWebMessagePort, shouldReceiveMessage);
  }

  public static AppWebMessagePort.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      AppWebMessagePort.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of AppWebMessagePort.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new AppWebMessagePortJni();
  }
}
