package org.chromium.media;

import android.media.MediaCodecInfo;
import java.util.ArrayList;
import java.util.List;
import org.jni_zero.JNINamespace;

@JNINamespace("media")
class CodecProfileLevelList {
  private static final String TAG = "CodecProfileLevelList";
  private final List<CodecProfileLevelAdapter> mList = new ArrayList();

  public boolean addCodecProfileLevel(
      String mime, MediaCodecInfo.CodecProfileLevel codecProfileLevel) {
    try {
      int codec = getCodecFromMime(mime);
      this.mList.add(
          new CodecProfileLevelAdapter(
              codec,
              mediaCodecProfileToChromiumMediaProfile(codec, codecProfileLevel.profile),
              mediaCodecLevelToChromiumMediaLevel(codec, codecProfileLevel.level)));
      return true;
    } catch (UnsupportedCodecProfileException e) {
      return false;
    }
  }

  public boolean addCodecProfileLevel(int codec, int profile, int level) {
    this.mList.add(new CodecProfileLevelAdapter(codec, profile, level));
    return true;
  }

  public Object[] toArray() {
    return this.mList.toArray();
  }

  static class CodecProfileLevelAdapter {
    private final int mCodec;
    private final int mLevel;
    private final int mProfile;

    public CodecProfileLevelAdapter(int codec, int profile, int level) {
      this.mCodec = codec;
      this.mProfile = profile;
      this.mLevel = level;
    }

    public int getCodec() {
      return this.mCodec;
    }

    public int getProfile() {
      return this.mProfile;
    }

    public int getLevel() {
      return this.mLevel;
    }
  }

  public static class UnsupportedCodecProfileException extends RuntimeException {
    private UnsupportedCodecProfileException() {}
  }

  public static int getCodecFromMime(String mime) {
    if (mime.endsWith("vp9")) {
      return 7;
    }
    if (mime.endsWith("vp8")) {
      return 6;
    }
    if (mime.endsWith("av01")) {
      return 10;
    }
    if (mime.endsWith("avc")) {
      return 1;
    }
    if (mime.endsWith("hevc")) {
      return 8;
    }
    if (mime.endsWith("dolby-vision")) {
      return 9;
    }
    throw new UnsupportedCodecProfileException();
  }

  public static int mediaCodecProfileToChromiumMediaProfile(int codec, int profile) {
    switch (codec) {
      case 1:
        switch (profile) {
          case 1:
          case 65536:
            return 0;
          case 2:
            return 1;
          case 4:
            return 2;
          case 8:
          case 524288:
            return 3;
          case 16:
            return 4;
          case 32:
            return 5;
          case 64:
            return 6;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 2:
      case 3:
      case 4:
      case 5:
      default:
        throw new UnsupportedCodecProfileException();
      case 6:
        switch (profile) {
          case 1:
            return 11;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 7:
        switch (profile) {
          case 1:
            return 12;
          case 2:
            return 13;
          case 4:
          case 4096:
          case 16384:
            return 14;
          case 8:
          case 8192:
            return 15;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 8:
        switch (profile) {
          case 1:
            return 16;
          case 2:
          case 4096:
          case 8192:
            return 17;
          case 4:
            return 18;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 9:
        switch (profile) {
          case 32:
            return 21;
          case 128:
            return 22;
          case 256:
            return 27;
          case 512:
            return 28;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 10:
        switch (profile) {
          case 1:
          case 2:
          case 4096:
          case 8192:
            return 24;
          default:
            throw new UnsupportedCodecProfileException();
        }
    }
  }

  public static int mediaCodecLevelToChromiumMediaLevel(int codec, int level) {
    switch (codec) {
      case 1:
        switch (level) {
          case 1:
            return 10;
          case 2:
            return 9;
          case 4:
            return 11;
          case 8:
            return 12;
          case 16:
            return 13;
          case 32:
            return 20;
          case 64:
            return 21;
          case 128:
            return 22;
          case 256:
            return 30;
          case 512:
            return 31;
          case 1024:
            return 32;
          case 2048:
            return 40;
          case 4096:
            return 41;
          case 8192:
            return 42;
          case 16384:
            return 50;
          case 32768:
            return 51;
          case 65536:
            return 52;
          case 262144:
            return 61;
          case 524288:
            return 62;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 2:
      case 3:
      case 4:
      case 5:
      default:
        throw new UnsupportedCodecProfileException();
      case 6:
        switch (level) {
          case 1:
            return 0;
          case 2:
            return 1;
          case 4:
            return 2;
          case 8:
            return 3;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 7:
        switch (level) {
          case 1:
            return 10;
          case 2:
            return 11;
          case 4:
            return 20;
          case 8:
            return 21;
          case 16:
            return 30;
          case 32:
            return 31;
          case 64:
            return 40;
          case 128:
            return 41;
          case 256:
            return 50;
          case 512:
            return 51;
          case 1024:
            return 52;
          case 2048:
            return 60;
          case 4096:
            return 61;
          case 8192:
            return 62;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 8:
        switch (level) {
          case 1:
          case 2:
            return 30;
          case 4:
          case 8:
            return 60;
          case 16:
          case 32:
            return 63;
          case 64:
          case 128:
            return 90;
          case 256:
          case 512:
            return 93;
          case 1024:
          case 2048:
            return 120;
          case 4096:
          case 8192:
            return 123;
          case 16384:
          case 32768:
            return 150;
          case 65536:
          case 131072:
            return 153;
          case 262144:
          case 524288:
            return 156;
          case 1048576:
          case 2097152:
            return 180;
          case 4194304:
          case 8388608:
            return 183;
          case 16777216:
          case 33554432:
            return 186;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 9:
        switch (level) {
          case 1:
            return 1;
          case 2:
            return 2;
          case 4:
            return 3;
          case 8:
            return 4;
          case 16:
            return 5;
          case 32:
            return 6;
          case 64:
            return 7;
          case 128:
            return 8;
          case 256:
            return 9;
          default:
            throw new UnsupportedCodecProfileException();
        }
      case 10:
        switch (level) {
          case 1:
            return 20;
          case 2:
            return 21;
          case 4:
            return 22;
          case 8:
            return 23;
          case 16:
            return 30;
          case 32:
            return 31;
          case 64:
            return 32;
          case 128:
            return 33;
          case 256:
            return 40;
          case 512:
            return 41;
          case 1024:
            return 42;
          case 2048:
            return 43;
          case 4096:
            return 50;
          case 8192:
            return 51;
          case 16384:
            return 52;
          case 32768:
            return 53;
          case 65536:
            return 60;
          case 131072:
            return 61;
          case 262144:
            return 62;
          case 524288:
            return 63;
          case 1048576:
            return 70;
          case 2097152:
            return 71;
          case 4194304:
            return 72;
          case 8388608:
            return 73;
          default:
            throw new UnsupportedCodecProfileException();
        }
    }
  }
}
