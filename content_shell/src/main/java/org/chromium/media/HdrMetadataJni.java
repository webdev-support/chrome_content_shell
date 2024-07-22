package org.chromium.media;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class HdrMetadataJni implements HdrMetadata.Natives {

  public static final JniStaticTestMocker<HdrMetadata.Natives> TEST_HOOKS =
      new JniStaticTestMocker<HdrMetadata.Natives>() {
        @Override
        public void setInstanceForTesting(HdrMetadata.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          HdrMetadataJni.testInstance = instance;
        }
      };
  private static HdrMetadata.Natives testInstance;

  HdrMetadataJni() {}

  @Override
  public int colorTransfer(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_colorTransfer(nativeJniHdrMetadata, caller);
  }

  @Override
  public float maxColorVolumeLuminance(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_maxColorVolumeLuminance(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public int maxContentLuminance(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_maxContentLuminance(nativeJniHdrMetadata, caller);
  }

  @Override
  public int maxFrameAverageLuminance(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_maxFrameAverageLuminance(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public float minColorVolumeLuminance(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_minColorVolumeLuminance(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public int primaries(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_primaries(nativeJniHdrMetadata, caller);
  }

  @Override
  public float primaryBChromaticityX(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_primaryBChromaticityX(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public float primaryBChromaticityY(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_primaryBChromaticityY(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public float primaryGChromaticityX(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_primaryGChromaticityX(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public float primaryGChromaticityY(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_primaryGChromaticityY(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public float primaryRChromaticityX(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_primaryRChromaticityX(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public float primaryRChromaticityY(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_primaryRChromaticityY(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public int range(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_range(nativeJniHdrMetadata, caller);
  }

  @Override
  public float whitePointChromaticityX(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_whitePointChromaticityX(
        nativeJniHdrMetadata, caller);
  }

  @Override
  public float whitePointChromaticityY(long nativeJniHdrMetadata, HdrMetadata caller) {
    if (nativeJniHdrMetadata == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_HdrMetadata_whitePointChromaticityY(
        nativeJniHdrMetadata, caller);
  }

  public static HdrMetadata.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      HdrMetadata.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of HdrMetadata.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new HdrMetadataJni();
  }
}
