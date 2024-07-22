package org.chromium.content.browser;

import java.nio.ByteBuffer;
import org.chromium.url.Origin;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ClientDataJsonImplJni implements ClientDataJsonImpl.Natives {
  public static final JniStaticTestMocker<ClientDataJsonImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ClientDataJsonImpl.Natives>() {
        @Override
        public void setInstanceForTesting(ClientDataJsonImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ClientDataJsonImplJni.testInstance = instance;
        }
      };
  private static ClientDataJsonImpl.Natives testInstance;

  @Override
  public String buildClientDataJson(
      int clientDataRequestType,
      String callerOrigin,
      byte[] challenge,
      boolean isCrossOrigin,
      ByteBuffer optionsByteBuffer,
      String relyingPartyId,
      Origin topOrigin) {
    return GEN_JNI.org_chromium_content_browser_ClientDataJsonImpl_buildClientDataJson(
        clientDataRequestType,
        callerOrigin,
        challenge,
        isCrossOrigin,
        optionsByteBuffer,
        relyingPartyId,
        topOrigin);
  }

  public static ClientDataJsonImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ClientDataJsonImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ClientDataJsonImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ClientDataJsonImplJni();
  }
}
