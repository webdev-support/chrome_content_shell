// Copyright 2012 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.example.chromium_content_view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.chromium_content_view.jsinterface.MyJSInterface;
import org.chromium.base.CommandLine;
import org.chromium.base.MemoryPressureListener;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.library_loader.LibraryProcessType;
import org.chromium.content_public.browser.BrowserStartupController;
import org.chromium.content_public.browser.DeviceUtils;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_shell.ChromiumWebChromeClient;
import org.chromium.content_shell.ChromiumWebView;
import org.chromium.content_shell.ChromiumWebViewClient;
import org.chromium.content_shell.Shell;
import org.chromium.content_shell.ShellManager;
import org.chromium.mojo.bindings.ConnectionErrorHandler;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.network.mojom.CanonicalCookie;
import org.chromium.network.mojom.CookieManager;
import org.chromium.ui.base.ActivityWindowAndroid;
import org.chromium.ui.base.IntentRequestTracker;

/** Activity for managing the Content Shell. */
public class ContentShellActivity extends Activity {

  private static final String TAG = "ContentShellActivity";

  private static final String ACTIVE_SHELL_URL_KEY = "activeUrl";
  public static final String COMMAND_LINE_ARGS_KEY = "commandLineArgs";

  // Native switch - shell_switches::kRunWebTests
  private static final String RUN_WEB_TESTS_SWITCH = "run-web-tests";

  private ChromiumWebView webView;
  private ActivityWindowAndroid mWindowAndroid;
  private String mStartupUrl;
  private IntentRequestTracker mIntentRequestTracker;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initChromiumWebView();
    setContentView(R.layout.content_shell_activity);
    webView = findViewById(R.id.shell_container);
    webView.setWebViewClient(new ChromiumWebViewClient());
    webView.setWebChromeClient(new ChromiumWebChromeClient());
    final boolean listenToActivityState = true;
    mIntentRequestTracker = IntentRequestTracker.createFromActivity(this);
    mWindowAndroid = new ActivityWindowAndroid(this, listenToActivityState, mIntentRequestTracker);

    mIntentRequestTracker.restoreInstanceState(savedInstanceState);
    webView.setWindow(mWindowAndroid);
    // Set up the animation placeholder to be the SurfaceView. This disables the
    // SurfaceView's 'hole' clipping during animations that are notified to the window.
    mWindowAndroid.setAnimationPlaceholderView(webView.getContentViewRenderView().getSurfaceView());

    mStartupUrl = getUrlFromIntent(getIntent());
    boolean useSingleProcess = true;
    if (useSingleProcess) {
      BrowserStartupController.getInstance()
          .startBrowserProcessesSync(LibraryProcessType.PROCESS_BROWSER, true, true);
      webView.setRendererPriorityPolicyImport();
      finishInitialization(savedInstanceState);
      webView.addJavascriptInterface(new MyJSInterface(), MyJSInterface.namespace);
      webView.loadUrl("https://www.bing.com/");
      webView.post(
          new Runnable() {
            @Override
            public void run() {}
          });
    } else {
      BrowserStartupController.getInstance()
          .startBrowserProcessesAsync(
              LibraryProcessType.PROCESS_BROWSER,
              true,
              false,
              new BrowserStartupController.StartupCallback() {
                @Override
                public void onSuccess() {
                  webView.setRendererPriorityPolicyImport();
                  finishInitialization(savedInstanceState);
                  webView.addJavascriptInterface(new MyJSInterface(), MyJSInterface.namespace);
                  webView.loadUrl("https://www.bing.com/");
                  Pair<CookieManager.Proxy, InterfaceRequest<CookieManager>> re =
                      CookieManager.MANAGER.getInterfaceRequest(CoreImpl.getInstance());
                  re.first
                      .getProxyHandler()
                      .setErrorHandler(
                          new ConnectionErrorHandler() {
                            @Override
                            public void onConnectionError(MojoException e) {
                              System.out.println("error: " + e.getMessage());
                            }
                          });
                  re.first.getAllCookies(
                      canonicalCookieArr -> {
                        for (CanonicalCookie cookie : canonicalCookieArr) {
                          Log.i("", "cookie: " + cookie.name + " = " + cookie.value);
                        }
                      });
                }

                @Override
                public void onFailure() {
                  initializationFailed();
                }
              });
    }
  }

  private void initChromiumWebView() {
    if (!CommandLine.isInitialized()) {
      ((ContentShellApplication) getApplication()).initCommandLine();
      String[] commandLineParams = getCommandLineParamsFromIntent(getIntent());
      if (commandLineParams != null) {
        CommandLine.getInstance().appendSwitchesAndArguments(commandLineParams);
      }
    }
    DeviceUtils.addDeviceSpecificUserAgentSwitch();
    LibraryLoader.getInstance().ensureInitialized();
  }

  private void finishInitialization(Bundle savedInstanceState) {
    String shellUrl;
    if (!TextUtils.isEmpty(mStartupUrl)) {
      shellUrl = mStartupUrl;
    } else {
      shellUrl = ShellManager.DEFAULT_SHELL_URL;
    }

    if (savedInstanceState != null && savedInstanceState.containsKey(ACTIVE_SHELL_URL_KEY)) {
      shellUrl = savedInstanceState.getString(ACTIVE_SHELL_URL_KEY);
    }
    webView.initShell(shellUrl);
  }

  private void initializationFailed() {
    Log.e(TAG, "ContentView initialization failed.");
    Toast.makeText(ContentShellActivity.this, "初始化失敗！！！", Toast.LENGTH_SHORT).show();
    finish();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    WebContents webContents = getActiveWebContents();
    if (webContents != null) {
      // TODO(yfriedman): crbug/783819 - This should use GURL serialize/deserialize.
      outState.putString(ACTIVE_SHELL_URL_KEY, webContents.getLastCommittedUrl().getSpec());
    }
    mIntentRequestTracker.saveInstanceState(outState);
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      WebContents webContents = getActiveWebContents();
      if (webContents != null && webContents.getNavigationController().canGoBack()) {
        webContents.getNavigationController().goBack();
        return true;
      }
    }

    return super.onKeyUp(keyCode, event);
  }

  @Override
  protected void onNewIntent(Intent intent) {
    if (getCommandLineParamsFromIntent(intent) != null) {
      Log.i(TAG, "Ignoring command line params: can only be set when creating the activity.");
    }
    if (MemoryPressureListener.handleDebugIntent(this, intent.getAction())) return;
    String url = getUrlFromIntent(intent);
    if (!TextUtils.isEmpty(url)) {
      webView.loadUrl(url);
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
    WebContents webContents = getActiveWebContents();
    if (webContents != null) webContents.onShow();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    mIntentRequestTracker.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public void startActivity(Intent i) {
    super.startActivity(i);
  }

  @Override
  protected void onDestroy() {
    if (webView != null) webView.destroy();
    mWindowAndroid.destroy();
    super.onDestroy();
  }

  private static String getUrlFromIntent(Intent intent) {
    return intent != null ? intent.getDataString() : null;
  }

  private static String[] getCommandLineParamsFromIntent(Intent intent) {
    return intent != null ? intent.getStringArrayExtra(COMMAND_LINE_ARGS_KEY) : null;
  }

  /**
   * @return The currently visible {@link Shell} or null if one is not showing.
   */
  public Shell getActiveShell() {
    return webView != null ? webView.getActiveShell() : null;
  }

  /**
   * @return The {@link WebContents} owned by the currently visible {@link Shell} or null if one is
   *     not showing.
   */
  public WebContents getActiveWebContents() {
    Shell shell = getActiveShell();
    return shell != null ? shell.getWebContents() : null;
  }

  @Override
  public void onConfigurationChanged(@NonNull Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
  }
}
