package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class TraceEventJni implements TraceEvent.Natives {
  public static final JniStaticTestMocker<TraceEvent.Natives> TEST_HOOKS =
      new JniStaticTestMocker<TraceEvent.Natives>() {
        @Override
        public void setInstanceForTesting(TraceEvent.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          TraceEventJni.testInstance = instance;
        }
      };
  private static TraceEvent.Natives testInstance;

  TraceEventJni() {}

  @Override
  public void addViewDump(
      int id,
      int parentId,
      boolean isShown,
      boolean isDirty,
      String className,
      String resourceName,
      long activityProtoPtr) {
    GEN_JNI.org_chromium_base_TraceEvent_addViewDump(
        id, parentId, isShown, isDirty, className, resourceName, activityProtoPtr);
  }

  @Override
  public void begin(String name, String arg) {
    GEN_JNI.org_chromium_base_TraceEvent_begin(name, arg);
  }

  @Override
  public void beginToplevel(String target) {
    GEN_JNI.org_chromium_base_TraceEvent_beginToplevel(target);
  }

  @Override
  public void beginWithIntArg(String name, int arg) {
    GEN_JNI.org_chromium_base_TraceEvent_beginWithIntArg(name, arg);
  }

  @Override
  public void end(String name, String arg, long flow) {
    GEN_JNI.org_chromium_base_TraceEvent_end(name, arg, flow);
  }

  @Override
  public void endToplevel(String target) {
    GEN_JNI.org_chromium_base_TraceEvent_endToplevel(target);
  }

  @Override
  public void finishAsync(String name, long id) {
    GEN_JNI.org_chromium_base_TraceEvent_finishAsync(name, id);
  }

  @Override
  public void initViewHierarchyDump(long id, Object list) {
    GEN_JNI.org_chromium_base_TraceEvent_initViewHierarchyDump(id, list);
  }

  @Override
  public void instant(String name, String arg) {
    GEN_JNI.org_chromium_base_TraceEvent_instant(name, arg);
  }

  @Override
  public void instantAndroidIPC(String name, long durMs) {
    GEN_JNI.org_chromium_base_TraceEvent_instantAndroidIPC(name, durMs);
  }

  @Override
  public void instantAndroidToolbar(int blockReason, int allowReason, int snapshotDiff) {
    GEN_JNI.org_chromium_base_TraceEvent_instantAndroidToolbar(
        blockReason, allowReason, snapshotDiff);
  }

  @Override
  public void registerEnabledObserver() {
    GEN_JNI.org_chromium_base_TraceEvent_registerEnabledObserver();
  }

  @Override
  public long startActivityDump(String name, long dumpProtoPtr) {
    return GEN_JNI.org_chromium_base_TraceEvent_startActivityDump(name, dumpProtoPtr);
  }

  @Override
  public void startAsync(String name, long id) {
    GEN_JNI.org_chromium_base_TraceEvent_startAsync(name, id);
  }

  @Override
  public void startupActivityStart(long activityId, long startTimeMs) {
    GEN_JNI.org_chromium_base_TraceEvent_startupActivityStart(activityId, startTimeMs);
  }

  @Override
  public void startupLaunchCause(long activityId, long startTimeMs, int launchCause) {
    GEN_JNI.org_chromium_base_TraceEvent_startupLaunchCause(activityId, startTimeMs, launchCause);
  }

  @Override
  public void startupTimeToFirstVisibleContent2(
      long activityId, long startTimeMs, long durationMs) {
    GEN_JNI.org_chromium_base_TraceEvent_startupTimeToFirstVisibleContent2(
        activityId, startTimeMs, durationMs);
  }

  @Override
  public boolean viewHierarchyDumpEnabled() {
    return GEN_JNI.org_chromium_base_TraceEvent_viewHierarchyDumpEnabled();
  }

  @Override
  public void webViewStartupStage1(long startTimeMs, long durationMs) {
    GEN_JNI.org_chromium_base_TraceEvent_webViewStartupStage1(startTimeMs, durationMs);
  }

  @Override
  public void webViewStartupStage2(long startTimeMs, long durationMs, boolean isColdStartup) {
    GEN_JNI.org_chromium_base_TraceEvent_webViewStartupStage2(
        startTimeMs, durationMs, isColdStartup);
  }

  @Override
  public void webViewStartupStartChromiumLocked(long startTimeMs, long durationMs) {
    GEN_JNI.org_chromium_base_TraceEvent_webViewStartupStartChromiumLocked(startTimeMs, durationMs);
  }

  @Override
  public void webViewStartupTotalFactoryInit(long startTimeMs, long durationMs) {
    GEN_JNI.org_chromium_base_TraceEvent_webViewStartupTotalFactoryInit(startTimeMs, durationMs);
  }

  public static TraceEvent.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      TraceEvent.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of TraceEvent.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new TraceEventJni();
  }
}
