package org.chromium.content_public.browser;

import org.chromium.base.UserDataHost;
import org.chromium.url.GURL;
import org.chromium.url.Origin;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class NavigationHandle {
  private GURL mBaseUrlForDataUrl;
  private int mErrorCode;
  private boolean mHasCommitted;
  private boolean mHasUserGesture;
  private int mHttpStatusCode;
  private Origin mInitiatorOrigin;
  private boolean mIsDownload;
  private boolean mIsErrorPage;
  private boolean mIsExternalProtocol;
  private boolean mIsInPrimaryMainFrame;
  private boolean mIsPageActivation;
  private boolean mIsPost;
  private boolean mIsPrimaryMainFrameFragmentNavigation;
  private boolean mIsRedirect;
  private boolean mIsReload;
  private boolean mIsRendererInitiated;
  private boolean mIsSameDocument;
  private boolean mIsValidSearchFormUrl;
  private long mNativeNavigationHandle;
  private long mNativeNavigationHandleProxy;
  private long mNavigationId;
  private int mPageTransition;
  private GURL mReferrerUrl;
  private GURL mUrl;
  private UserDataHost mUserDataHost;

  public static NavigationHandle createForTesting(
      GURL url, boolean isRendererInitiated, int transition, boolean hasUserGesture) {
    return createForTesting(
        url, true, false, isRendererInitiated, transition, hasUserGesture, false);
  }

  public static NavigationHandle createForTesting(
      GURL url,
      boolean isInPrimaryMainFrame,
      boolean isSameDocument,
      boolean isRendererInitiated,
      int transition,
      boolean hasUserGesture,
      boolean isReload) {
    NavigationHandle handle = new NavigationHandle(0L);
    handle.initialize(
        0L,
        url,
        GURL.emptyGURL(),
        GURL.emptyGURL(),
        isInPrimaryMainFrame,
        isSameDocument,
        isRendererInitiated,
        null,
        transition,
        false,
        hasUserGesture,
        false,
        false,
        0L,
        false,
        isReload);
    return handle;
  }

  private NavigationHandle(long nativeNavigationHandle) {
    this.mNativeNavigationHandle = nativeNavigationHandle;
  }

  private void initialize(
      long nativeNavigationHandleProxy,
      GURL url,
      GURL referrerUrl,
      GURL baseUrlForDataUrl,
      boolean isInPrimaryMainFrame,
      boolean isSameDocument,
      boolean isRendererInitiated,
      Origin initiatorOrigin,
      int transition,
      boolean isPost,
      boolean hasUserGesture,
      boolean isRedirect,
      boolean isExternalProtocol,
      long navigationId,
      boolean isPageActivation,
      boolean isReload) {
    this.mNativeNavigationHandleProxy = nativeNavigationHandleProxy;
    this.mUrl = url;
    this.mReferrerUrl = referrerUrl;
    this.mBaseUrlForDataUrl = baseUrlForDataUrl;
    this.mIsInPrimaryMainFrame = isInPrimaryMainFrame;
    this.mIsSameDocument = isSameDocument;
    this.mIsRendererInitiated = isRendererInitiated;
    this.mInitiatorOrigin = initiatorOrigin;
    this.mPageTransition = transition;
    this.mIsPost = isPost;
    this.mHasUserGesture = hasUserGesture;
    this.mIsRedirect = isRedirect;
    this.mIsExternalProtocol = isExternalProtocol;
    this.mNavigationId = navigationId;
    this.mIsPageActivation = isPageActivation;
    this.mIsReload = isReload;
  }

  public void didRedirect(GURL url, boolean isExternalProtocol) {
    this.mUrl = url;
    this.mIsRedirect = true;
    this.mIsExternalProtocol = isExternalProtocol;
  }

  public void didFinish(
      GURL url,
      boolean isErrorPage,
      boolean hasCommitted,
      boolean isPrimaryMainFrameFragmentNavigation,
      boolean isDownload,
      boolean isValidSearchFormUrl,
      int transition,
      int errorCode,
      int httpStatuscode,
      boolean isExternalProtocol) {
    this.mUrl = url;
    this.mIsErrorPage = isErrorPage;
    this.mHasCommitted = hasCommitted;
    this.mIsPrimaryMainFrameFragmentNavigation = isPrimaryMainFrameFragmentNavigation;
    this.mIsDownload = isDownload;
    this.mIsValidSearchFormUrl = isValidSearchFormUrl;
    this.mPageTransition = transition;
    this.mErrorCode = errorCode;
    this.mHttpStatusCode = httpStatuscode;
    this.mIsExternalProtocol = isExternalProtocol;
  }

  private void release() {
    this.mNativeNavigationHandle = 0L;
    this.mNativeNavigationHandleProxy = 0L;
  }

  public long nativeNavigationHandlePtr() {
    return this.mNativeNavigationHandle;
  }

  public GURL getUrl() {
    return this.mUrl;
  }

  public GURL getReferrerUrl() {
    return this.mReferrerUrl;
  }

  public GURL getBaseUrlForDataUrl() {
    return this.mBaseUrlForDataUrl;
  }

  public boolean isInPrimaryMainFrame() {
    return this.mIsInPrimaryMainFrame;
  }

  public boolean isRendererInitiated() {
    return this.mIsRendererInitiated;
  }

  public boolean isSameDocument() {
    return this.mIsSameDocument;
  }

  public String errorDescription() {
    return "";
  }

  public int errorCode() {
    return this.mErrorCode;
  }

  public boolean hasCommitted() {
    return this.mHasCommitted;
  }

  public int httpStatusCode() {
    return this.mHttpStatusCode;
  }

  public int pageTransition() {
    return this.mPageTransition;
  }

  public boolean isPrimaryMainFrameFragmentNavigation() {
    return this.mIsPrimaryMainFrameFragmentNavigation;
  }

  public boolean isErrorPage() {
    return this.mIsErrorPage;
  }

  public boolean isDownload() {
    return this.mIsDownload;
  }

  public boolean isValidSearchFormUrl() {
    return this.mIsValidSearchFormUrl;
  }

  public Origin getInitiatorOrigin() {
    return this.mInitiatorOrigin;
  }

  public boolean isPost() {
    return this.mIsPost;
  }

  public boolean hasUserGesture() {
    return this.mHasUserGesture;
  }

  public boolean isRedirect() {
    return this.mIsRedirect;
  }

  public boolean isExternalProtocol() {
    return this.mIsExternalProtocol;
  }

  public long getNavigationId() {
    return this.mNavigationId;
  }

  public boolean isPageActivation() {
    return this.mIsPageActivation;
  }

  public boolean isReload() {
    return this.mIsReload;
  }

  public UserDataHost getUserDataHost() {
    if (this.mUserDataHost == null) {
      this.mUserDataHost = new UserDataHost();
    }
    return this.mUserDataHost;
  }

  public void setUserDataHost(UserDataHost userDataHost) {
    this.mUserDataHost = userDataHost;
  }
}
