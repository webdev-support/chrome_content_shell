package org.chromium.content_shell;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import org.chromium.content.browser.JavascriptInterface;
import org.chromium.content_public.browser.JavascriptInjector;

public class ChromiumWebView extends ShellManager {

  /**
   * Constructor for inflating via XML.
   *
   * @param context
   * @param attrs
   */
  public ChromiumWebView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  private ChromiumWebChromeClient webChromeClient;
  private ChromiumWebViewClient webViewClient;

  public void setRendererPriorityPolicyImport() {
    getActiveShell().getWebContents().setImportance(2);
  }

  public void addJavascriptInterface(@NonNull Object object, @NonNull String name) {
    JavascriptInjector javascriptInjector =
        JavascriptInjector.fromWebContents(getActiveShell().getWebContents(), false);
    javascriptInjector.setAllowInspection(true);
    javascriptInjector.addPossiblyUnsafeInterface(object, name, JavascriptInterface.class);
  }

  public void removeJavascriptInterface(@NonNull String name) {
    JavascriptInjector javascriptInjector =
        JavascriptInjector.fromWebContents(getActiveShell().getWebContents(), false);
    javascriptInjector.removeInterface(name);
  }

  public void stopLoading() {
    getActiveShell().getWebContents().stop();
  }

  /** Reloads the current URL. */
  public void reload() {
    getActiveShell().getWebContents().getNavigationController().reload(true);
  }

  /**
   * Gets whether this WebView has a back history item.
   *
   * @return {@code true} if this WebView has a back history item
   */
  public boolean canGoBack() {
    return getActiveShell().getWebContents().getNavigationController().canGoBack();
  }

  /** Goes back in the history of this WebView. */
  public void goBack() {
    if (canGoBack()) {
      getActiveShell().getWebContents().getNavigationController().goBack();
    }
  }

  /**
   * Gets whether this WebView has a forward history item.
   *
   * @return {@code true} if this WebView has a forward history item
   */
  public boolean canGoForward() {
    return getActiveShell().getWebContents().getNavigationController().canGoForward();
  }

  /** Goes forward in the history of this WebView. */
  public void goForward() {
    if (canGoForward()) {
      getActiveShell().getWebContents().getNavigationController().goForward();
    }
  }

  /**
   * Gets whether the page can go back or forward the given number of steps.
   *
   * @param steps the negative or positive number of steps to move the history
   */
  public boolean canGoBackOrForward(int steps) {
    return getActiveShell().getWebContents().getNavigationController().canGoToOffset(steps);
  }

  /**
   * Goes to the history item that is the number of steps away from the current item. Steps is
   * negative if backward and positive if forward.
   *
   * @param steps the number of steps to take back or forward in the back forward list
   */
  public void goBackOrForward(int steps) {
    if (canGoBackOrForward(steps)) {
      getActiveShell().getWebContents().getNavigationController().goToOffset(steps);
    }
  }

  public ChromiumWebChromeClient getWebChromeClient() {
    return this.webChromeClient;
  }

  public ChromiumWebViewClient getWebViewClient() {
    return this.webViewClient;
  }

  public void setWebViewClient(ChromiumWebViewClient chromiumWebViewClient) {
    this.webViewClient = chromiumWebViewClient;
  }

  public void setWebChromeClient(ChromiumWebChromeClient chromiumWebChromeClient) {
    this.webChromeClient = chromiumWebChromeClient;
  }
}
