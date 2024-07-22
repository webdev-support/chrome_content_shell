package org.chromium.url;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class OriginJni implements Origin.Natives {
  public static final JniStaticTestMocker<Origin.Natives> TEST_HOOKS =
      new JniStaticTestMocker<Origin.Natives>() {
        @Override
        public void setInstanceForTesting(Origin.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          OriginJni.testInstance = instance;
        }
      };
  private static Origin.Natives testInstance;

  OriginJni() {}

  @Override
  public Origin createFromGURL(GURL gurl) {
    return (Origin) GEN_JNI.org_chromium_url_Origin_createFromGURL(gurl);
  }

  @Override
  public long createNative(
      String scheme,
      String host,
      short port,
      boolean isOpaque,
      long tokenHighBits,
      long tokenLowBits) {
    return GEN_JNI.org_chromium_url_Origin_createNative(
        scheme, host, port, isOpaque, tokenHighBits, tokenLowBits);
  }

  @Override
  public Origin createOpaque() {
    return (Origin) GEN_JNI.org_chromium_url_Origin_createOpaque();
  }

  public static Origin.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      Origin.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of Origin.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new OriginJni();
  }
}
