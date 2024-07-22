package org.chromium.content.browser.selection;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.textclassifier.TextClassifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.content_public.browser.SelectAroundCaretResult;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.content_public.browser.SelectionEventProcessor;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.WindowAndroid;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class SmartSelectionClient implements SelectionClient {

  private static final int NUM_EXTRA_CHARS = 240;
  private ResultCallback mCallback;
  private long mNativeSmartSelectionClient;
  private SmartSelectionProvider mProvider;
  private SmartSelectionEventProcessor mSmartSelectionEventProcessor;

  public interface Natives {
    void cancelAllRequests(long j, SmartSelectionClient smartSelectionClient);

    long init(SmartSelectionClient smartSelectionClient, WebContents webContents);

    void requestSurroundingText(long j, SmartSelectionClient smartSelectionClient, int i, int i2);
  }

  @Retention(RetentionPolicy.SOURCE)
  private @interface RequestType {
    public static final int CLASSIFY = 0;
    public static final int SUGGEST_AND_CLASSIFY = 1;
  }

  public static SmartSelectionClient create(ResultCallback callback, WebContents webContents) {
    WindowAndroid windowAndroid = webContents.getTopLevelNativeWindow();
    if (windowAndroid == null
        || !isDeviceProvisioned(windowAndroid.getContext().get())
        || webContents.isIncognito()) {
      return null;
    }
    return new SmartSelectionClient(callback, webContents);
  }

  private SmartSelectionClient(ResultCallback callback, WebContents webContents) {
    this.mCallback = callback;
    if (Build.VERSION.SDK_INT >= 28) {
      this.mSmartSelectionEventProcessor = SmartSelectionEventProcessor.create(webContents);
    }
    this.mProvider =
        new SmartSelectionProvider(callback, webContents, this.mSmartSelectionEventProcessor);
    this.mNativeSmartSelectionClient = SmartSelectionClientJni.get().init(this, webContents);
  }

  private void onNativeSideDestroyed(long nativeSmartSelectionClient) {
    if (nativeSmartSelectionClient != this.mNativeSmartSelectionClient) {
      throw new AssertionError();
    }
    this.mNativeSmartSelectionClient = 0L;
    this.mProvider.cancelAllRequests();
  }

  @Override
  public void onSelectionChanged(String selection) {}

  @Override
  public void onSelectionEvent(int eventType, float posXPix, float posYPix) {}

  @Override
  public void selectAroundCaretAck(SelectAroundCaretResult result) {}

  @Override
  public boolean requestSelectionPopupUpdates(boolean shouldSuggest) {
    requestSurroundingText(shouldSuggest ? 1 : 0);
    return true;
  }

  @Override
  public void cancelAllRequests() {
    if (this.mNativeSmartSelectionClient != 0) {
      SmartSelectionClientJni.get().cancelAllRequests(this.mNativeSmartSelectionClient, this);
    }
    this.mProvider.cancelAllRequests();
  }

  @Override
  public SelectionEventProcessor getSelectionEventProcessor() {
    return this.mSmartSelectionEventProcessor;
  }

  @Override
  public void setTextClassifier(TextClassifier textClassifier) {
    this.mProvider.setTextClassifier(textClassifier);
  }

  @Override
  public TextClassifier getTextClassifier() {
    return this.mProvider.getTextClassifier();
  }

  @Override
  public TextClassifier getCustomTextClassifier() {
    return this.mProvider.getCustomTextClassifier();
  }

  private void requestSurroundingText(int callbackData) {
    if (this.mNativeSmartSelectionClient == 0) {
      onSurroundingTextReceived(callbackData, "", 0, 0);
    } else {
      SmartSelectionClientJni.get()
          .requestSurroundingText(this.mNativeSmartSelectionClient, this, 240, callbackData);
    }
  }

  private void onSurroundingTextReceived(int callbackData, String text, int start, int end) {
    if (!textHasValidSelection(text, start, end)) {
      this.mCallback.onClassified(new Result());
      return;
    }
    switch (callbackData) {
      case 0:
        this.mProvider.sendClassifyRequest(text, start, end);
        return;
      case 1:
        this.mProvider.sendSuggestAndClassifyRequest(text, start, end);
        return;
      default:
        throw new AssertionError("Unexpected callback data");
    }
  }

  private static boolean isDeviceProvisioned(Context context) {
    return context == null
        || context.getContentResolver() == null
        || Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) != 0;
  }

  private boolean textHasValidSelection(String text, int start, int end) {
    return !TextUtils.isEmpty(text) && start >= 0 && start < end && end <= text.length();
  }
}
