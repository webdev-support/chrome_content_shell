package org.chromium.content_public.browser;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.chromium.base.UserDataHost;
import org.chromium.base.supplier.Supplier;
import org.chromium.content_public.common.ContentUrlConstants;
import org.chromium.content_public.common.Referrer;
import org.chromium.content_public.common.ResourceRequestBody;
import org.chromium.url.GURL;
import org.chromium.url.Origin;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class LoadUrlParams {

  private AdditionalNavigationParams mAdditionalNavigationParams;
  private String mBaseUrlForDataUrl;
  private boolean mCanLoadLocalResources;
  private String mDataUrlAsString;
  private Map<String, String> mExtraHeaders;
  private boolean mHasUserGesture;
  private Origin mInitiatorOrigin;
  private long mInputStartTimestamp;
  private long mIntentReceivedTimestamp;
  private boolean mIsPdf;
  private boolean mIsRendererInitiated;
  private int mLoadUrlType;
  private UserDataHost mNavigationHandleUserDataHost;
  private Supplier<Long> mNavigationUIDataSupplier;
  private ResourceRequestBody mPostData;
  private Referrer mReferrer;
  private boolean mShouldClearHistoryList;
  private boolean mShouldReplaceCurrentEntry;
  private int mTransitionType;
  private int mUaOverrideOption;
  private String mUrl;
  private String mVerbatimHeaders;
  private String mVirtualUrlForDataUrl;

  public interface Natives {
    boolean isDataScheme(String str);
  }

  public LoadUrlParams(String url) {
    this(url, 0);
  }

  public LoadUrlParams(GURL url) {
    this(url.getSpec(), 0);
  }

  public LoadUrlParams(GURL url, int transitionType) {
    this(url.getSpec(), transitionType);
  }

  public LoadUrlParams(String url, int transitionType) {
    this.mUrl = url;
    this.mTransitionType = transitionType;
    this.mLoadUrlType = 0;
    this.mUaOverrideOption = 0;
    this.mPostData = null;
    this.mBaseUrlForDataUrl = null;
    this.mVirtualUrlForDataUrl = null;
    this.mDataUrlAsString = null;
  }

  public static LoadUrlParams copy(LoadUrlParams other) {
    LoadUrlParams copy = new LoadUrlParams(other.mUrl);
    copy.mInitiatorOrigin = other.mInitiatorOrigin;
    copy.mLoadUrlType = other.mLoadUrlType;
    copy.mTransitionType = other.mTransitionType;
    copy.mReferrer = other.mReferrer;
    if (other.mExtraHeaders != null) {
      copy.mExtraHeaders = new HashMap(other.mExtraHeaders);
    }
    copy.mVerbatimHeaders = other.mVerbatimHeaders;
    copy.mUaOverrideOption = other.mUaOverrideOption;
    copy.mPostData = other.mPostData;
    copy.mBaseUrlForDataUrl = other.mBaseUrlForDataUrl;
    copy.mVirtualUrlForDataUrl = other.mVirtualUrlForDataUrl;
    copy.mDataUrlAsString = other.mDataUrlAsString;
    copy.mCanLoadLocalResources = other.mCanLoadLocalResources;
    copy.mIsRendererInitiated = other.mIsRendererInitiated;
    copy.mShouldReplaceCurrentEntry = other.mShouldReplaceCurrentEntry;
    copy.mIntentReceivedTimestamp = other.mIntentReceivedTimestamp;
    copy.mInputStartTimestamp = other.mInputStartTimestamp;
    copy.mHasUserGesture = other.mHasUserGesture;
    copy.mShouldClearHistoryList = other.mShouldClearHistoryList;
    copy.mAdditionalNavigationParams = other.mAdditionalNavigationParams;
    return copy;
  }

  public static LoadUrlParams createLoadDataParams(
      String data, String mimeType, boolean isBase64Encoded) {
    return createLoadDataParams(data, mimeType, isBase64Encoded, null);
  }

  public static LoadUrlParams createLoadDataParams(
      String data, String mimeType, boolean isBase64Encoded, String charset) {
    LoadUrlParams params =
        new LoadUrlParams(buildDataUri(data, mimeType, isBase64Encoded, charset));
    params.setLoadType(2);
    params.setTransitionType(1);
    return params;
  }

  private static String buildDataUri(
      String data, String mimeType, boolean isBase64Encoded, String charset) {
    StringBuilder dataUrl = new StringBuilder("data:");
    dataUrl.append(mimeType);
    if (charset != null && !charset.isEmpty()) {
      dataUrl.append(";charset=" + charset);
    }
    if (isBase64Encoded) {
      dataUrl.append(";base64");
    }
    dataUrl.append(",");
    dataUrl.append(data);
    return dataUrl.toString();
  }

  public static LoadUrlParams createLoadDataParamsWithBaseUrl(
      String data, String mimeType, boolean isBase64Encoded, String baseUrl, String historyUrl) {
    return createLoadDataParamsWithBaseUrl(
        data, mimeType, isBase64Encoded, baseUrl, historyUrl, null);
  }

  public static LoadUrlParams createLoadDataParamsWithBaseUrl(
      String data,
      String mimeType,
      boolean isBase64Encoded,
      String baseUrl,
      String historyUrl,
      String charset) {
    if (baseUrl == null || !baseUrl.toLowerCase(Locale.US).startsWith("data:")) {
      LoadUrlParams params = createLoadDataParams("", mimeType, isBase64Encoded, charset);
      String str = ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL;
      params.setBaseUrlForDataUrl(
          baseUrl != null ? baseUrl : ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL);
      if (historyUrl != null) {
        str = historyUrl;
      }
      params.setVirtualUrlForDataUrl(str);
      params.setDataUrlAsString(buildDataUri(data, mimeType, isBase64Encoded, charset));
      return params;
    }
    return createLoadDataParams(data, mimeType, isBase64Encoded, charset);
  }

  public static LoadUrlParams createLoadHttpPostParams(String url, byte[] postData) {
    LoadUrlParams params = new LoadUrlParams(url);
    params.setLoadType(1);
    params.setTransitionType(1);
    params.setPostData(ResourceRequestBody.createFromBytes(postData));
    return params;
  }

  public void setUrl(String url) {
    this.mUrl = url;
  }

  public String getUrl() {
    return this.mUrl;
  }

  public void setInitiatorOrigin(Origin initiatorOrigin) {
    this.mInitiatorOrigin = initiatorOrigin;
  }

  public Origin getInitiatorOrigin() {
    return this.mInitiatorOrigin;
  }

  public String getBaseUrl() {
    return this.mBaseUrlForDataUrl;
  }

  public void setLoadType(int loadType) {
    this.mLoadUrlType = loadType;
  }

  public void setTransitionType(int transitionType) {
    this.mTransitionType = transitionType;
  }

  public int getTransitionType() {
    return this.mTransitionType;
  }

  public void setReferrer(Referrer referrer) {
    this.mReferrer = referrer;
  }

  public Referrer getReferrer() {
    return this.mReferrer;
  }

  public void setExtraHeaders(Map<String, String> extraHeaders) {
    this.mExtraHeaders = extraHeaders;
    verifyHeaders();
  }

  public Map<String, String> getExtraHeaders() {
    return this.mExtraHeaders;
  }

  public UserDataHost getNavigationHandleUserData() {
    if (this.mNavigationHandleUserDataHost == null) {
      this.mNavigationHandleUserDataHost = new UserDataHost();
    }
    return this.mNavigationHandleUserDataHost;
  }

  public UserDataHost takeNavigationHandleUserData() {
    UserDataHost returnValue = this.mNavigationHandleUserDataHost;
    this.mNavigationHandleUserDataHost = null;
    return returnValue;
  }

  public String getExtraHeadersString() {
    return getExtraHeadersString("\n", false);
  }

  public String getExtraHttpRequestHeadersString() {
    return getExtraHeadersString("\r\n", true);
  }

  private String getExtraHeadersString(String delimiter, boolean addTerminator) {
    if (this.mExtraHeaders == null) {
      return null;
    }
    StringBuilder headerBuilder = new StringBuilder();
    for (Map.Entry<String, String> header : this.mExtraHeaders.entrySet()) {
      if (headerBuilder.length() > 0) {
        headerBuilder.append(delimiter);
      }
      headerBuilder.append(header.getKey().toLowerCase(Locale.US));
      headerBuilder.append(":");
      headerBuilder.append(header.getValue());
    }
    if (addTerminator) {
      headerBuilder.append(delimiter);
    }
    return headerBuilder.toString();
  }

  public void setVerbatimHeaders(String headers) {
    this.mVerbatimHeaders = headers;
    verifyHeaders();
  }

  private void verifyHeaders() {
    String str;
    if (this.mExtraHeaders != null
        && (str = this.mVerbatimHeaders) != null
        && !str.equalsIgnoreCase(getExtraHeadersString())) {
      throw new AssertionError();
    }
  }

  public String getVerbatimHeaders() {
    return this.mVerbatimHeaders;
  }

  public void setOverrideUserAgent(int uaOption) {
    this.mUaOverrideOption = uaOption;
  }

  public int getUserAgentOverrideOption() {
    return this.mUaOverrideOption;
  }

  public void setPostData(ResourceRequestBody postData) {
    this.mPostData = postData;
    if (postData != null) {
      setLoadType(1);
    }
  }

  public ResourceRequestBody getPostData() {
    return this.mPostData;
  }

  public void setBaseUrlForDataUrl(String baseUrl) {
    this.mBaseUrlForDataUrl = baseUrl;
  }

  public String getVirtualUrlForDataUrl() {
    return this.mVirtualUrlForDataUrl;
  }

  public void setVirtualUrlForDataUrl(String virtualUrl) {
    this.mVirtualUrlForDataUrl = virtualUrl;
  }

  public String getDataUrlAsString() {
    return this.mDataUrlAsString;
  }

  public void setDataUrlAsString(String url) {
    this.mDataUrlAsString = url;
  }

  public void setCanLoadLocalResources(boolean canLoad) {
    this.mCanLoadLocalResources = canLoad;
  }

  public boolean getCanLoadLocalResources() {
    return this.mCanLoadLocalResources;
  }

  public int getLoadUrlType() {
    return this.mLoadUrlType;
  }

  public void setIsRendererInitiated(boolean rendererInitiated) {
    this.mIsRendererInitiated = rendererInitiated;
  }

  public boolean getIsRendererInitiated() {
    return this.mIsRendererInitiated;
  }

  public void setShouldReplaceCurrentEntry(boolean shouldReplaceCurrentEntry) {
    this.mShouldReplaceCurrentEntry = shouldReplaceCurrentEntry;
  }

  public boolean getShouldReplaceCurrentEntry() {
    return this.mShouldReplaceCurrentEntry;
  }

  public void setIntentReceivedTimestamp(long intentReceivedTimestamp) {
    this.mIntentReceivedTimestamp = intentReceivedTimestamp;
  }

  public long getIntentReceivedTimestamp() {
    return this.mIntentReceivedTimestamp;
  }

  public void setInputStartTimestamp(long inputStartTimestamp) {
    this.mInputStartTimestamp = inputStartTimestamp;
  }

  public long getInputStartTimestamp() {
    return this.mInputStartTimestamp;
  }

  public void setHasUserGesture(boolean hasUserGesture) {
    this.mHasUserGesture = hasUserGesture;
  }

  public boolean getHasUserGesture() {
    return this.mHasUserGesture;
  }

  public void setShouldClearHistoryList(boolean shouldClearHistoryList) {
    this.mShouldClearHistoryList = shouldClearHistoryList;
  }

  public boolean getShouldClearHistoryList() {
    return this.mShouldClearHistoryList;
  }

  public void setAdditionalNavigationParams(AdditionalNavigationParams additionalNavigationParams) {
    this.mAdditionalNavigationParams = additionalNavigationParams;
  }

  public AdditionalNavigationParams getAdditionalNavigationParams() {
    return this.mAdditionalNavigationParams;
  }

  public boolean isBaseUrlDataScheme() {
    if (this.mBaseUrlForDataUrl == null && this.mLoadUrlType == 2) {
      return true;
    }
    return LoadUrlParamsJni.get().isDataScheme(this.mBaseUrlForDataUrl);
  }

  public void setNavigationUIDataSupplier(Supplier<Long> navigationUIDataSupplier) {
    this.mNavigationUIDataSupplier = navigationUIDataSupplier;
  }

  public Supplier<Long> getNavigationUIDataSupplier() {
    return this.mNavigationUIDataSupplier;
  }

  public boolean getIsPdf() {
    return this.mIsPdf;
  }

  public void setIsPdf(boolean isPdf) {
    this.mIsPdf = isPdf;
  }
}
