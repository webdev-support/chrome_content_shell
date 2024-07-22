package org.chromium.content.browser.androidoverlay;

import android.content.Context;
import android.os.IBinder;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.gfx.mojom.Rect;
import org.chromium.media.mojom.AndroidOverlay;
import org.chromium.media.mojom.AndroidOverlayClient;
import org.chromium.media.mojom.AndroidOverlayConfig;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.ui.base.WindowAndroid;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class DialogOverlayImpl
    implements AndroidOverlay, DialogOverlayCore.Host, ViewTreeObserver.OnPreDrawListener {

  private static final String TAG = "DialogOverlayImpl";
  private final boolean mAsPanel;
  private AndroidOverlayClient mClient;
  private boolean mClosed;
  private final AndroidOverlayConfig mConfig;
  private ViewTreeObserver mContainerViewViewTreeObserver;
  private DialogOverlayCore mDialogCore;
  private Rect mLastRect;
  private long mNativeHandle;
  private Runnable mReleasedRunnable;
  private int mSurfaceId;
  private WebContentsImpl mWebContents;
  private final int[] mCompositorOffset = new int[2];
  private final Runnable mTearDownDialogOverlaysHandler =
      new Runnable() {
        @Override
        public final void run() {
          DialogOverlayImpl.this.onOverlayDestroyed();
        }
      };

  public interface Natives {
    void completeInit(long j, DialogOverlayImpl dialogOverlayImpl);

    void destroy(long j, DialogOverlayImpl dialogOverlayImpl);

    void getCompositorOffset(long j, DialogOverlayImpl dialogOverlayImpl, Rect rect);

    long init(DialogOverlayImpl dialogOverlayImpl, long j, long j2, boolean z);

    Surface lookupSurfaceForTesting(int i);

    void notifyDestroyedSynchronously(long j);

    int registerSurface(Surface surface);

    void unregisterSurface(int i);
  }

  public DialogOverlayImpl(
      AndroidOverlayClient client,
      AndroidOverlayConfig config,
      Runnable releasedRunnable,
      boolean asPanel) {
    ThreadUtils.assertOnUiThread();
    this.mClient = client;
    this.mReleasedRunnable = releasedRunnable;
    this.mLastRect = copyRect(config.rect);
    this.mConfig = config;
    this.mAsPanel = asPanel;
    long init =
        DialogOverlayImplJni.get()
            .init(this, config.routingToken.high, config.routingToken.low, config.powerEfficient);
    this.mNativeHandle = init;
    if (init == 0) {
      notifyDestroyed();
      cleanup();
      return;
    }
    DialogOverlayImplJni.get().getCompositorOffset(this.mNativeHandle, this, config.rect);
    DialogOverlayImplJni.get().completeInit(this.mNativeHandle, this);
  }

  @Override
  public void close() {
    ThreadUtils.assertOnUiThread();
    if (this.mClosed) {
      return;
    }
    this.mClosed = true;
    DialogOverlayCore dialogOverlayCore = this.mDialogCore;
    if (dialogOverlayCore != null) {
      dialogOverlayCore.release();
      cleanup();
    }
    this.mReleasedRunnable.run();
  }

  @Override
  public void onConnectionError(MojoException e) {
    ThreadUtils.assertOnUiThread();
    close();
  }

  @Override
  public void scheduleLayout(Rect rect) {
    ThreadUtils.assertOnUiThread();
    this.mLastRect = copyRect(rect);
    if (this.mDialogCore == null) {
      return;
    }
    DialogOverlayImplJni.get().getCompositorOffset(this.mNativeHandle, this, rect);
    this.mDialogCore.layoutSurface(rect);
  }

  private static void receiveCompositorOffset(Rect rect, int x, int y) {
    rect.x += x;
    rect.y += y;
  }

  @Override
  public void onSurfaceReady(Surface surface) {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore == null || this.mClient == null) {
      return;
    }
    int registerSurface = DialogOverlayImplJni.get().registerSurface(surface);
    this.mSurfaceId = registerSurface;
    this.mClient.onSurfaceReady(registerSurface);
  }

  @Override
  public void onOverlayDestroyed() {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore == null) {
      return;
    }
    notifyDestroyed();
    cleanup();
  }

  @Override
  public boolean onPreDraw() {
    scheduleLayout(this.mLastRect);
    return true;
  }

  public void onWindowAndroid(WindowAndroid window) {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore == null) {
      initializeDialogCore(window);
      return;
    }
    IBinder token = window != null ? window.getWindowToken() : null;
    this.mDialogCore.onWindowToken(token);
  }

  private void observeContainerView(View containerView) {
    ViewTreeObserver viewTreeObserver = this.mContainerViewViewTreeObserver;
    if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
      this.mContainerViewViewTreeObserver.removeOnPreDrawListener(this);
    }
    this.mContainerViewViewTreeObserver = null;
    if (containerView != null) {
      ViewTreeObserver viewTreeObserver2 = containerView.getViewTreeObserver();
      this.mContainerViewViewTreeObserver = viewTreeObserver2;
      viewTreeObserver2.addOnPreDrawListener(this);
    }
  }

  public void onDismissed() {
    ThreadUtils.assertOnUiThread();
    notifyDestroyed();
    DialogOverlayCore dialogOverlayCore = this.mDialogCore;
    if (dialogOverlayCore != null) {
      dialogOverlayCore.onWindowToken(null);
    }
    cleanup();
  }

  private void onPowerEfficientState(boolean isPowerEfficient) {
    AndroidOverlayClient androidOverlayClient;
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore == null || (androidOverlayClient = this.mClient) == null) {
      return;
    }
    androidOverlayClient.onPowerEfficientState(isPowerEfficient);
  }

  private void onWebContents(WebContentsImpl webContents) {
    if (this.mWebContents != null) {
      throw new AssertionError();
    }
    if (webContents == null) {
      throw new AssertionError();
    }
    this.mWebContents = webContents;
    webContents.addTearDownDialogOverlaysHandler(this.mTearDownDialogOverlaysHandler);
  }

  private void initializeDialogCore(WindowAndroid window) {
    ThreadUtils.assertOnUiThread();
    if (window == null) {
      return;
    }
    Context context = window.getContext().get();
    if (ContextUtils.activityFromContext(context) == null) {
      return;
    }
    DialogOverlayCore dialogOverlayCore = new DialogOverlayCore();
    this.mDialogCore = dialogOverlayCore;
    dialogOverlayCore.initialize(context, this.mConfig, this, this.mAsPanel);
    this.mDialogCore.onWindowToken(window.getWindowToken());
  }

  private void cleanup() {
    ThreadUtils.assertOnUiThread();
    if (this.mSurfaceId != 0) {
      DialogOverlayImplJni.get().unregisterSurface(this.mSurfaceId);
      this.mSurfaceId = 0;
    }
    if (this.mNativeHandle != 0) {
      DialogOverlayImplJni.get().destroy(this.mNativeHandle, this);
      this.mNativeHandle = 0L;
    }
    this.mDialogCore = null;
    AndroidOverlayClient androidOverlayClient = this.mClient;
    if (androidOverlayClient != null) {
      androidOverlayClient.close();
    }
    this.mClient = null;
    if (this.mContainerViewViewTreeObserver != null) {
      throw new AssertionError();
    }
    WebContentsImpl webContentsImpl = this.mWebContents;
    if (webContentsImpl != null) {
      webContentsImpl.removeTearDownDialogOverlaysHandler(this.mTearDownDialogOverlaysHandler);
      this.mWebContents = null;
    }
  }

  private void notifyDestroyed() {
    if (this.mClient == null) {
      return;
    }
    AndroidOverlayClient client = this.mClient;
    this.mClient = null;
    if (this.mSurfaceId == 0) {
      client.onDestroyed();
      return;
    }
    AndroidOverlayClient.Proxy proxy = (AndroidOverlayClient.Proxy) client;
    MessagePipeHandle handle = proxy.getProxyHandler().passHandle();
    long nativeHandle = handle.releaseNativeHandle();
    DialogOverlayImplJni.get().notifyDestroyedSynchronously(nativeHandle);
  }

  private static Rect copyRect(Rect rect) {
    Rect copy = new Rect();
    copy.x = rect.x;
    copy.y = rect.y;
    copy.width = rect.width;
    copy.height = rect.height;
    return copy;
  }
}
