package org.chromium.content.browser.input;

import android.content.Context;
import org.chromium.base.UserData;
import org.chromium.content.browser.PopupController;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.WindowEventObserverManager;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class TextSuggestionHost
    implements WindowEventObserver, PopupController.HideablePopup, UserData {

  private final Context mContext;
  private boolean mIsAttachedToWindow;
  private long mNativeTextSuggestionHost;
  private SpellCheckPopupWindow mSpellCheckPopupWindow;
  private TextSuggestionsPopupWindow mTextSuggestionsPopupWindow;
  private final ViewAndroidDelegate mViewDelegate;
  private final WebContentsImpl mWebContents;
  private WindowAndroid mWindowAndroid;

  public interface Natives {
    void applySpellCheckSuggestion(long j, TextSuggestionHost textSuggestionHost, String str);

    void applyTextSuggestion(long j, TextSuggestionHost textSuggestionHost, int i, int i2);

    void deleteActiveSuggestionRange(long j, TextSuggestionHost textSuggestionHost);

    void onNewWordAddedToDictionary(long j, TextSuggestionHost textSuggestionHost, String str);

    void onSuggestionMenuClosed(long j, TextSuggestionHost textSuggestionHost);
  }

  public static final class UserDataFactoryLazyHolder {
    private static final WebContentsImpl.UserDataFactory<TextSuggestionHost> INSTANCE =
        new WebContentsImpl.UserDataFactory() {
          @Override
          public final Object create(WebContents webContents) {
            return new TextSuggestionHost(webContents);
          }
        };

    private UserDataFactoryLazyHolder() {}
  }

  static TextSuggestionHost fromWebContents(WebContents webContents) {
    return (TextSuggestionHost)
        ((WebContentsImpl) webContents)
            .getOrSetUserData(TextSuggestionHost.class, UserDataFactoryLazyHolder.INSTANCE);
  }

  private static TextSuggestionHost create(WebContents webContents, long nativePtr) {
    TextSuggestionHost host = fromWebContents(webContents);
    host.setNativePtr(nativePtr);
    return host;
  }

  public TextSuggestionHost(WebContents webContents) {
    WebContentsImpl webContentsImpl = (WebContentsImpl) webContents;
    this.mWebContents = webContentsImpl;
    this.mContext = webContentsImpl.getContext();
    this.mWindowAndroid = webContentsImpl.getTopLevelNativeWindow();
    ViewAndroidDelegate viewAndroidDelegate = webContentsImpl.getViewAndroidDelegate();
    this.mViewDelegate = viewAndroidDelegate;
    if (viewAndroidDelegate == null) {
      throw new AssertionError();
    }
    PopupController.register(webContentsImpl, this);
    WindowEventObserverManager.from(webContentsImpl).addObserver(this);
  }

  private void setNativePtr(long nativePtr) {
    this.mNativeTextSuggestionHost = nativePtr;
  }

  private float getContentOffsetYPix() {
    return this.mWebContents.getRenderCoordinates().getContentOffsetYPix();
  }

  @Override
  public void onWindowAndroidChanged(WindowAndroid newWindowAndroid) {
    this.mWindowAndroid = newWindowAndroid;
    SpellCheckPopupWindow spellCheckPopupWindow = this.mSpellCheckPopupWindow;
    if (spellCheckPopupWindow != null) {
      spellCheckPopupWindow.updateWindowAndroid(newWindowAndroid);
    }
    TextSuggestionsPopupWindow textSuggestionsPopupWindow = this.mTextSuggestionsPopupWindow;
    if (textSuggestionsPopupWindow != null) {
      textSuggestionsPopupWindow.updateWindowAndroid(this.mWindowAndroid);
    }
  }

  @Override
  public void onAttachedToWindow() {
    this.mIsAttachedToWindow = true;
  }

  @Override
  public void onDetachedFromWindow() {
    this.mIsAttachedToWindow = false;
  }

  @Override
  public void onRotationChanged(int rotation) {
    hidePopups();
  }

  @Override
  public void hide() {
    hidePopups();
  }

  private void showSpellCheckSuggestionMenu(
      double caretXPx, double caretYPx, String markedText, String[] suggestions) {
    if (!this.mIsAttachedToWindow) {
      onSuggestionMenuClosed(false);
      return;
    }
    hidePopups();
    SpellCheckPopupWindow spellCheckPopupWindow =
        new SpellCheckPopupWindow(
            this.mContext, this, this.mWindowAndroid, this.mViewDelegate.getContainerView());
    this.mSpellCheckPopupWindow = spellCheckPopupWindow;
    spellCheckPopupWindow.show(
        caretXPx, caretYPx + getContentOffsetYPix(), markedText, suggestions);
  }

  private void showTextSuggestionMenu(
      double caretXPx, double caretYPx, String markedText, SuggestionInfo[] suggestions) {
    if (!this.mIsAttachedToWindow) {
      onSuggestionMenuClosed(false);
      return;
    }
    hidePopups();
    TextSuggestionsPopupWindow textSuggestionsPopupWindow =
        new TextSuggestionsPopupWindow(
            this.mContext, this, this.mWindowAndroid, this.mViewDelegate.getContainerView());
    this.mTextSuggestionsPopupWindow = textSuggestionsPopupWindow;
    textSuggestionsPopupWindow.show(
        caretXPx, caretYPx + getContentOffsetYPix(), markedText, suggestions);
  }

  public void hidePopups() {
    TextSuggestionsPopupWindow textSuggestionsPopupWindow = this.mTextSuggestionsPopupWindow;
    if (textSuggestionsPopupWindow != null && textSuggestionsPopupWindow.isShowing()) {
      this.mTextSuggestionsPopupWindow.dismiss();
      this.mTextSuggestionsPopupWindow = null;
    }
    SpellCheckPopupWindow spellCheckPopupWindow = this.mSpellCheckPopupWindow;
    if (spellCheckPopupWindow != null && spellCheckPopupWindow.isShowing()) {
      this.mSpellCheckPopupWindow.dismiss();
      this.mSpellCheckPopupWindow = null;
    }
  }

  public void applySpellCheckSuggestion(String suggestion) {
    TextSuggestionHostJni.get()
        .applySpellCheckSuggestion(this.mNativeTextSuggestionHost, this, suggestion);
  }

  public void applyTextSuggestion(int markerTag, int suggestionIndex) {
    TextSuggestionHostJni.get()
        .applyTextSuggestion(this.mNativeTextSuggestionHost, this, markerTag, suggestionIndex);
  }

  public void deleteActiveSuggestionRange() {
    TextSuggestionHostJni.get().deleteActiveSuggestionRange(this.mNativeTextSuggestionHost, this);
  }

  public void onNewWordAddedToDictionary(String word) {
    TextSuggestionHostJni.get()
        .onNewWordAddedToDictionary(this.mNativeTextSuggestionHost, this, word);
  }

  public void onSuggestionMenuClosed(boolean dismissedByItemTap) {
    if (!dismissedByItemTap) {
      TextSuggestionHostJni.get().onSuggestionMenuClosed(this.mNativeTextSuggestionHost, this);
    }
    this.mSpellCheckPopupWindow = null;
    this.mTextSuggestionsPopupWindow = null;
  }

  private void onNativeDestroyed() {
    hidePopups();
    this.mNativeTextSuggestionHost = 0L;
  }

  public SuggestionsPopupWindow getTextSuggestionsPopupWindowForTesting() {
    return this.mTextSuggestionsPopupWindow;
  }

  public SuggestionsPopupWindow getSpellCheckPopupWindowForTesting() {
    return this.mSpellCheckPopupWindow;
  }
}
