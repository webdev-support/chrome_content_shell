package org.chromium.ui.base;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.net.Uri;
import org.chromium.base.Callback;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.url.GURL;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class Clipboard {
  private static final String TAG = "Clipboard";
  private static Clipboard sInstance;
  private long mNativeClipboard;

  public interface Natives {
    void cleanupForTesting();

    long getLastModifiedTimeToJavaTime(long j);

    void onPrimaryClipChanged(long j, Clipboard clipboard);

    void onPrimaryClipTimestampInvalidated(long j, Clipboard clipboard, long j2);
  }

  public interface ImageFileProvider {
    void clearLastCopiedImageMetadata();

    ClipboardFileMetadata getLastCopiedImageMetadata();

    void storeImageAndGenerateUri(byte[] bArr, String str, Callback<Uri> callback);

    void storeLastCopiedImageMetadata(ClipboardFileMetadata clipboardFileMetadata);

    public static class ClipboardFileMetadata {
      public static final long INVALID_TIMESTAMP = 0;
      public final long timestamp;
      public final Uri uri;

      public ClipboardFileMetadata(Uri uri, long timestamp) {
        this.uri = uri;
        this.timestamp = timestamp;
      }
    }
  }

  public static Clipboard getInstance() {
    if (sInstance == null) {
      ClipboardManager clipboardManager =
          (ClipboardManager) ContextUtils.getApplicationContext().getSystemService("clipboard");
      if (clipboardManager != null) {
        sInstance = new ClipboardImpl(clipboardManager);
      } else {
        sInstance = new Clipboard();
      }
    }
    return sInstance;
  }

  public static void resetForTesting() {
    sInstance = null;
  }

  public static void cleanupNativeForTesting() {
    ClipboardJni.get().cleanupForTesting();
  }

  protected String getCoercedText() {
    return null;
  }

  protected boolean hasCoercedText() {
    return false;
  }

  public String clipDataToHtmlText(ClipData clipData) {
    return null;
  }

  protected String getHTMLText() {
    return null;
  }

  public boolean hasHTMLOrStyledText() {
    return false;
  }

  boolean hasUrl() {
    return false;
  }

  String getUrl() {
    return null;
  }

  public Uri getImageUri() {
    return null;
  }

  public Uri getImageUriIfSharedByThisApp() {
    return null;
  }

  protected String getImageUriString() {
    return null;
  }

  public byte[] getPng() {
    return null;
  }

  protected boolean hasImage() {
    return false;
  }

  public void setText(String text) {
    Log.w(TAG, "setText is a no-op because Clipboard service isn't available");
  }

  public void setText(String label, String text) {
    Log.w(TAG, "setText is a no-op because Clipboard service isn't available");
  }

  public void setText(String label, String text, boolean notifyOnSuccess) {
    Log.w(TAG, "setText is a no-op because Clipboard service isn't available");
  }

  void setHTMLText(String html, String text) {
    Log.w(TAG, "setHTMLText is a no-op because Clipboard service isn't available");
  }

  public void setPassword(String password) {
    Log.w(TAG, "setPassword is a no-op because Clipboard service isn't available");
  }

  public void setImageUri(Uri uri) {
    Log.w(TAG, "setImageUri is a no-op because Clipboard service isn't available");
  }

  public void setImageUri(Uri uri, boolean notifyOnSuccess) {
    Log.w(TAG, "setImageUriAndNotify is a no-op because Clipboard service isn't available");
  }

  public void setImage(byte[] imageData, String extension) {
    Log.w(TAG, "setImage is a no-op because Clipboard service isn't available");
  }

  protected void clear() {}

  private void setNativePtr(long nativeClipboard) {
    this.mNativeClipboard = nativeClipboard;
  }

  public void setImageFileProvider(ImageFileProvider imageFileProvider) {
    Log.w(TAG, "setImageFileProvider is a no-op because Clipboard service isn't available");
  }

  public void copyUrlToClipboard(GURL url) {}

  public void onWindowFocusChanged(boolean hasFocus) {}

  public long getLastModifiedTimeMs() {
    return 0L;
  }

  public boolean canPaste() {
    return false;
  }

  public boolean canCopy() {
    return false;
  }

  public void notifyPrimaryClipChanged() {
    if (this.mNativeClipboard == 0) {
      return;
    }
    ClipboardJni.get().onPrimaryClipChanged(this.mNativeClipboard, this);
  }

  public void notifyPrimaryClipTimestampInvalidated(long timestamp) {
    if (this.mNativeClipboard == 0) {
      return;
    }
    ClipboardJni.get().onPrimaryClipTimestampInvalidated(this.mNativeClipboard, this, timestamp);
  }

  public long getLastModifiedTimeToJavaTime() {
    if (this.mNativeClipboard == 0) {
      return 0L;
    }
    return ClipboardJni.get().getLastModifiedTimeToJavaTime(this.mNativeClipboard);
  }
}
