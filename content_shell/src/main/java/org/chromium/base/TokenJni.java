package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class TokenJni implements Token.Natives {
  public static final JniStaticTestMocker<Token.Natives> TEST_HOOKS =
      new JniStaticTestMocker<Token.Natives>() {
        @Override
        public void setInstanceForTesting(Token.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          TokenJni.testInstance = instance;
        }
      };
  private static Token.Natives testInstance;

  @Override
  public Token createRandom() {
    return (Token) GEN_JNI.org_chromium_base_Token_createRandom();
  }

  public static Token.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      Token.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of Token.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new TokenJni();
  }
}
