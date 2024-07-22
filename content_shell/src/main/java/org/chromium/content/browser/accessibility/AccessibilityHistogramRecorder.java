package org.chromium.content.browser.accessibility;

import android.os.SystemClock;
import org.chromium.base.TraceEvent;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.ui.accessibility.AccessibilityState;

public class AccessibilityHistogramRecorder {

  public static final String AUTO_DISABLE_ACCESSIBILITY_DISABLED_TIME_INITIAL =
      "Accessibility.Android.AutoDisableV2.DisabledTime.Initial";
  public static final String AUTO_DISABLE_ACCESSIBILITY_DISABLED_TIME_SUCCESSIVE =
      "Accessibility.Android.AutoDisableV2.DisabledTime.Successive";
  public static final String AUTO_DISABLE_ACCESSIBILITY_DISABLE_METHOD_CALLED_INITIAL =
      "Accessibility.Android.AutoDisableV2.DisableCalled.Initial";
  public static final String AUTO_DISABLE_ACCESSIBILITY_DISABLE_METHOD_CALLED_SUCCESSIVE =
      "Accessibility.Android.AutoDisableV2.DisableCalled.Successive";
  public static final String AUTO_DISABLE_ACCESSIBILITY_ENABLED_TIME_INITIAL =
      "Accessibility.Android.AutoDisableV2.EnabledTime.Initial";
  public static final String AUTO_DISABLE_ACCESSIBILITY_ENABLED_TIME_SUCCESSIVE =
      "Accessibility.Android.AutoDisableV2.EnabledTime.Successive";
  public static final String AUTO_DISABLE_ACCESSIBILITY_REENABLE_METHOD_CALLED_INITIAL =
      "Accessibility.Android.AutoDisableV2.ReEnableCalled.Initial";
  public static final String AUTO_DISABLE_ACCESSIBILITY_REENABLE_METHOD_CALLED_SUCCESSIVE =
      "Accessibility.Android.AutoDisableV2.ReEnabledCalled.Successive";
  private static final int CACHE_MAX_NODES_BUCKET_COUNT = 100;
  public static final String CACHE_MAX_NODES_HISTOGRAM =
      "Accessibility.Android.Cache.MaxNodesInCache";
  private static final int CACHE_MAX_NODES_MAX_BUCKET = 3000;
  private static final int CACHE_MAX_NODES_MIN_BUCKET = 1;
  public static final String CACHE_PERCENTAGE_RETRIEVED_FROM_CACHE_HISTOGRAM =
      "Accessibility.Android.Cache.PercentageRetrievedFromCache";
  public static final String EVENTS_DROPPED_HISTOGRAM =
      "Accessibility.Android.OnDemand.EventsDropped";
  private static final int EVENTS_DROPPED_HISTOGRAM_BUCKET_COUNT = 100;
  private static final int EVENTS_DROPPED_HISTOGRAM_MAX_BUCKET = 10000;
  private static final int EVENTS_DROPPED_HISTOGRAM_MIN_BUCKET = 1;
  public static final String ONE_HUNDRED_PERCENT_HISTOGRAM =
      "Accessibility.Android.OnDemand.OneHundredPercentEventsDropped";
  public static final String ONE_HUNDRED_PERCENT_HISTOGRAM_AXMODE_BASIC =
      "Accessibility.Android.OnDemand.OneHundredPercentEventsDropped.Basic";
  public static final String ONE_HUNDRED_PERCENT_HISTOGRAM_AXMODE_COMPLETE =
      "Accessibility.Android.OnDemand.OneHundredPercentEventsDropped.Complete";
  public static final String ONE_HUNDRED_PERCENT_HISTOGRAM_AXMODE_FORM_CONTROLS =
      "Accessibility.Android.OnDemand.OneHundredPercentEventsDropped.FormControls";
  public static final String PERCENTAGE_DROPPED_HISTOGRAM =
      "Accessibility.Android.OnDemand.PercentageDropped";
  public static final String PERCENTAGE_DROPPED_HISTOGRAM_AXMODE_BASIC =
      "Accessibility.Android.OnDemand.PercentageDropped.Basic";
  public static final String PERCENTAGE_DROPPED_HISTOGRAM_AXMODE_COMPLETE =
      "Accessibility.Android.OnDemand.PercentageDropped.Complete";
  public static final String PERCENTAGE_DROPPED_HISTOGRAM_AXMODE_FORM_CONTROLS =
      "Accessibility.Android.OnDemand.PercentageDropped.FormControls";
  public static final String USAGE_ACCESSIBILITY_ALWAYS_ON_TIME =
      "Accessibility.Android.Usage.A11yAlwaysOn";
  public static final String USAGE_FOREGROUND_TIME = "Accessibility.Android.Usage.Foreground";
  public static final String USAGE_NATIVE_INITIALIZED_TIME =
      "Accessibility.Android.Usage.NativeInit";
  private int mMaxNodesInCache;
  private int mNodeWasCreatedFromScratch;
  private int mNodeWasReturnedFromCache;
  private long mOngoingSumOfTimeDisabled;
  private int mTotalDispatchedEvents;
  private int mTotalEnqueuedEvents;
  private long mTimeOfFirstShown = -1;
  private long mTimeOfNativeInitialization = -1;
  private long mTimeOfLastDisabledCall = -1;

  public void onDisableCalled(boolean initialCall) {
    TraceEvent.begin("AccessibilityHistogramRecorder.onDisabledCalled");
    if (this.mTimeOfNativeInitialization <= 0) {
      throw new AssertionError(
          "Accessibility onDisabled was called, but accessibility has not been initialized.");
    }
    long now = SystemClock.elapsedRealtime();
    if (initialCall) {
      RecordHistogram.recordLongTimesHistogram(
          AUTO_DISABLE_ACCESSIBILITY_ENABLED_TIME_INITIAL, now - this.mTimeOfNativeInitialization);
      RecordHistogram.recordBooleanHistogram(
          AUTO_DISABLE_ACCESSIBILITY_DISABLE_METHOD_CALLED_INITIAL, true);
    } else {
      RecordHistogram.recordLongTimesHistogram(
          AUTO_DISABLE_ACCESSIBILITY_ENABLED_TIME_SUCCESSIVE,
          now - this.mTimeOfNativeInitialization);
      RecordHistogram.recordBooleanHistogram(
          AUTO_DISABLE_ACCESSIBILITY_DISABLE_METHOD_CALLED_SUCCESSIVE, true);
    }
    this.mTimeOfLastDisabledCall = now;
    RecordHistogram.recordLongTimesHistogram(
        USAGE_NATIVE_INITIALIZED_TIME, now - this.mTimeOfNativeInitialization);
    this.mTimeOfNativeInitialization = -1L;
    TraceEvent.end("AccessibilityHistogramRecorder.onDisabledCalled");
  }

  public void onReEnableCalled(boolean initialCall) {
    TraceEvent.begin("AccessibilityHistogramRecorder.onReEnabledCalled");
    long now = SystemClock.elapsedRealtime();
    if (initialCall) {
      RecordHistogram.recordLongTimesHistogram(
          AUTO_DISABLE_ACCESSIBILITY_DISABLED_TIME_INITIAL,
          (now - this.mTimeOfLastDisabledCall) + this.mOngoingSumOfTimeDisabled);
      RecordHistogram.recordBooleanHistogram(
          AUTO_DISABLE_ACCESSIBILITY_REENABLE_METHOD_CALLED_INITIAL, true);
    } else {
      RecordHistogram.recordLongTimesHistogram(
          AUTO_DISABLE_ACCESSIBILITY_DISABLED_TIME_SUCCESSIVE,
          (now - this.mTimeOfLastDisabledCall) + this.mOngoingSumOfTimeDisabled);
      RecordHistogram.recordBooleanHistogram(
          AUTO_DISABLE_ACCESSIBILITY_REENABLE_METHOD_CALLED_SUCCESSIVE, true);
    }
    this.mTimeOfNativeInitialization = now;
    this.mTimeOfLastDisabledCall = -1L;
    this.mOngoingSumOfTimeDisabled = 0L;
    TraceEvent.end("AccessibilityHistogramRecorder.onReEnabledCalled");
  }

  public void incrementEnqueuedEvents() {
    this.mTotalEnqueuedEvents++;
  }

  public void incrementDispatchedEvents() {
    this.mTotalDispatchedEvents++;
  }

  public void updateMaxNodesInCache(int nodeInfoCacheSize) {
    this.mMaxNodesInCache = Math.max(this.mMaxNodesInCache, nodeInfoCacheSize);
  }

  public void incrementNodeWasReturnedFromCache() {
    this.mNodeWasReturnedFromCache++;
  }

  public void incrementNodeWasCreatedFromScratch() {
    this.mNodeWasCreatedFromScratch++;
  }

  public void updateTimeOfFirstShown() {
    this.mTimeOfFirstShown = SystemClock.elapsedRealtime();
  }

  public void updateTimeOfNativeInitialization() {
    this.mTimeOfNativeInitialization = SystemClock.elapsedRealtime();
  }

  public void showAutoDisabledInstance() {
    this.mTimeOfLastDisabledCall = SystemClock.elapsedRealtime();
  }

  public void hideAutoDisabledInstance() {
    this.mOngoingSumOfTimeDisabled += SystemClock.elapsedRealtime() - this.mTimeOfLastDisabledCall;
  }

  public void recordAccessibilityPerformanceHistograms() {
    recordEventsHistograms();
    recordCacheHistograms();
  }

  public void recordEventsHistograms() {
    String str;
    String str2;
    boolean isAXModeComplete = AccessibilityState.isScreenReaderEnabled();
    boolean isAXModeFormControls = AccessibilityState.isOnlyPasswordManagersEnabled();
    int i = this.mTotalEnqueuedEvents;
    if (i > 0) {
      int percentSent = (int) (((this.mTotalDispatchedEvents * 1.0d) / i) * 100.0d);
      RecordHistogram.recordPercentageHistogram(PERCENTAGE_DROPPED_HISTOGRAM, 100 - percentSent);
      if (isAXModeComplete) {
        str = PERCENTAGE_DROPPED_HISTOGRAM_AXMODE_COMPLETE;
      } else if (isAXModeFormControls) {
        str = PERCENTAGE_DROPPED_HISTOGRAM_AXMODE_FORM_CONTROLS;
      } else {
        str = PERCENTAGE_DROPPED_HISTOGRAM_AXMODE_BASIC;
      }
      RecordHistogram.recordPercentageHistogram(str, 100 - percentSent);
      RecordHistogram.recordCustomCountHistogram(
          EVENTS_DROPPED_HISTOGRAM,
          this.mTotalEnqueuedEvents - this.mTotalDispatchedEvents,
          1,
          EVENTS_DROPPED_HISTOGRAM_MAX_BUCKET,
          100);
      if (percentSent == 0) {
        RecordHistogram.recordCustomCountHistogram(
            ONE_HUNDRED_PERCENT_HISTOGRAM,
            this.mTotalEnqueuedEvents - this.mTotalDispatchedEvents,
            1,
            EVENTS_DROPPED_HISTOGRAM_MAX_BUCKET,
            100);
        if (isAXModeComplete) {
          str2 = ONE_HUNDRED_PERCENT_HISTOGRAM_AXMODE_COMPLETE;
        } else if (isAXModeFormControls) {
          str2 = ONE_HUNDRED_PERCENT_HISTOGRAM_AXMODE_FORM_CONTROLS;
        } else {
          str2 = ONE_HUNDRED_PERCENT_HISTOGRAM_AXMODE_BASIC;
        }
        RecordHistogram.recordCustomCountHistogram(
            str2,
            this.mTotalEnqueuedEvents - this.mTotalDispatchedEvents,
            1,
            EVENTS_DROPPED_HISTOGRAM_MAX_BUCKET,
            100);
      }
    }
    this.mTotalEnqueuedEvents = 0;
    this.mTotalDispatchedEvents = 0;
  }

  public void recordCacheHistograms() {
    RecordHistogram.recordCustomCountHistogram(
        CACHE_MAX_NODES_HISTOGRAM, this.mMaxNodesInCache, 1, 3000, 100);
    int i = this.mNodeWasReturnedFromCache;
    int totalNodeRequests = this.mNodeWasCreatedFromScratch + i;
    int percentFromCache = (int) (((i * 1.0d) / totalNodeRequests) * 100.0d);
    RecordHistogram.recordPercentageHistogram(
        CACHE_PERCENTAGE_RETRIEVED_FROM_CACHE_HISTOGRAM, percentFromCache);
    this.mMaxNodesInCache = 0;
    this.mNodeWasReturnedFromCache = 0;
    this.mNodeWasCreatedFromScratch = 0;
  }

  public void recordAccessibilityUsageHistograms() {
    if (this.mTimeOfFirstShown < 0) {
      return;
    }
    long now = SystemClock.elapsedRealtime();
    long j = this.mTimeOfFirstShown;
    if (now - j < 250) {
      this.mTimeOfFirstShown = -1L;
      return;
    }
    RecordHistogram.recordLongTimesHistogram(USAGE_FOREGROUND_TIME, now - j);
    long j2 = this.mTimeOfNativeInitialization;
    if (j2 < 0) {
      this.mTimeOfFirstShown = -1L;
      return;
    }
    RecordHistogram.recordLongTimesHistogram(USAGE_NATIVE_INITIALIZED_TIME, now - j2);
    long timeDiff = Math.abs(this.mTimeOfNativeInitialization - this.mTimeOfFirstShown);
    if (timeDiff < 500 || timeDiff / (now - this.mTimeOfFirstShown) < 0.03d) {
      RecordHistogram.recordLongTimesHistogram(
          USAGE_ACCESSIBILITY_ALWAYS_ON_TIME, now - this.mTimeOfNativeInitialization);
    }
    this.mTimeOfFirstShown = -1L;
  }
}
