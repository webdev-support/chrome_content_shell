package org.chromium.base;

public final class BaseFeatures {
  public static final String ADD_TASK_LEEWAY_FEATURE = "AddTaskLeeway";
  public static final String ALIGN_WAKE_UPS = "AlignWakeUps";
  public static final String COLLECT_ANDROID_FRAME_TIMELINE_METRICS =
      "CollectAndroidFrameTimelineMetrics";
  public static final String DELAY_FIRST_WORKER_WAKE = "DelayFirstWorkerWake";
  public static final String ENABLE_CONFIGURABLE_THREAD_CACHE_MIN_CACHED_MEMORY_FOR_PURGING =
      "EnableConfigurableThreadCacheMinCachedMemoryForPurging";
  public static final String ENABLE_CONFIGURABLE_THREAD_CACHE_MULTIPLIER =
      "EnableConfigurableThreadCacheMultiplier";
  public static final String ENABLE_CONFIGURABLE_THREAD_CACHE_PURGE_INTERVAL =
      "EnableConfigurableThreadCachePurgeInterval";
  public static final String ENFORCE_NO_EXECUTABLE_FILE_HANDLES = "EnforceNoExecutableFileHandles";
  public static final String EXPLICIT_HIGH_RESOLUTION_TIMER_WIN = "ExplicitHighResolutionTimerWin";
  public static final String JSON_NEGATIVE_ZERO = "JsonNegativeZero";
  public static final String KILL_PARTITION_ALLOC_MEMORY_TAGGING =
      "KillPartitionAllocMemoryTagging";
  public static final String LOWER_PA_MEMORY_LIMIT_FOR_NON_MAIN_RENDERERS =
      "LowerPAMemoryLimitForNonMainRenderers";
  public static final String MAX_DELAYED_STARVATION_TASKS = "MaxDelayedStarvationTasks";
  public static final String NOT_REACHED_IS_FATAL = "NotReachedIsFatal";
  public static final String NO_WORKER_THREAD_RECLAIM = "NoWorkerThreadReclaim";
  public static final String OPTIMIZE_DATA_URLS = "OptimizeDataUrls";
  public static final String PAGE_ALLOCATOR_RETRY_ON_COMMIT_FAILURE =
      "PageAllocatorRetryOnCommitFailure";
  public static final String PARTIAL_LOW_END_MODE_ON3_GB_DEVICES = "PartialLowEndModeOn3GbDevices";
  public static final String PARTIAL_LOW_END_MODE_ON_MID_RANGE_DEVICES =
      "PartialLowEndModeOnMidRangeDevices";
  public static final String PARTITION_ALLOC_BACKUP_REF_PTR = "PartitionAllocBackupRefPtr";
  public static final String PARTITION_ALLOC_DANGLING_PTR = "PartitionAllocDanglingPtr";
  public static final String PARTITION_ALLOC_DC_SCAN = "PartitionAllocDCScan";
  public static final String PARTITION_ALLOC_DISABLE_BRP_IN_BUFFER_PARTITION =
      "PartitionAllocDisableBRPInBufferPartition";
  public static final String PARTITION_ALLOC_LARGE_EMPTY_SLOT_SPAN_RING =
      "PartitionAllocLargeEmptySlotSpanRing";
  public static final String PARTITION_ALLOC_LARGE_THREAD_CACHE_SIZE =
      "PartitionAllocLargeThreadCacheSize";
  public static final String PARTITION_ALLOC_MAKE_FREE_NO_OP_ON_SHUTDOWN =
      "PartitionAllocMakeFreeNoOpOnShutdown";
  public static final String PARTITION_ALLOC_MEMORY_RECLAIMER = "PartitionAllocMemoryReclaimer";
  public static final String PARTITION_ALLOC_MEMORY_TAGGING = "PartitionAllocMemoryTagging";
  public static final String PARTITION_ALLOC_PC_SCAN = "PartitionAllocPCScan";
  public static final String PARTITION_ALLOC_PC_SCAN_BROWSER_ONLY =
      "PartitionAllocPCScanBrowserOnly";
  public static final String PARTITION_ALLOC_PC_SCAN_EAGER_CLEARING =
      "PartitionAllocPCScanEagerClearing";
  public static final String PARTITION_ALLOC_PC_SCAN_IMMEDIATE_FREEING =
      "PartitionAllocPCScanImmediateFreeing";
  public static final String PARTITION_ALLOC_PC_SCAN_MU_AWARE_SCHEDULER =
      "PartitionAllocPCScanMUAwareScheduler";
  public static final String PARTITION_ALLOC_PC_SCAN_RENDERER_ONLY =
      "PartitionAllocPCScanRendererOnly";
  public static final String PARTITION_ALLOC_PC_SCAN_STACK_SCANNING =
      "PartitionAllocPCScanStackScanning";
  public static final String PARTITION_ALLOC_PERMISSIVE_MTE = "PartitionAllocPermissiveMte";
  public static final String PARTITION_ALLOC_SCHEDULER_LOOP_QUARANTINE =
      "PartitionAllocSchedulerLoopQuarantine";
  public static final String PARTITION_ALLOC_SORT_ACTIVE_SLOT_SPANS =
      "PartitionAllocSortActiveSlotSpans";
  public static final String PARTITION_ALLOC_SORT_SMALLER_SLOT_SPAN_FREE_LISTS =
      "PartitionAllocSortSmallerSlotSpanFreeLists";
  public static final String PARTITION_ALLOC_STRAIGHTEN_LARGER_SLOT_SPAN_FREE_LISTS =
      "PartitionAllocStraightenLargerSlotSpanFreeLists";
  public static final String PARTITION_ALLOC_UNRETAINED_DANGLING_PTR =
      "PartitionAllocUnretainedDanglingPtr";
  public static final String PARTITION_ALLOC_USE_DENSER_DISTRIBUTION =
      "PartitionAllocUseDenserDistribution";
  public static final String PARTITION_ALLOC_ZAPPING_BY_FREE_FLAGS =
      "PartitionAllocZappingByFreeFlags";
  public static final String RUN_TASKS_BY_BATCHES = "RunTasksByBatches";
  public static final String THREAD_GROUP_SEMAPHORE = "ThreadGroupSemaphore";
  public static final String THREAD_POOL_CAP2 = "ThreadPoolCap2";
  public static final String TIMER_SLACK_MAC = "TimerSlackMac";
  public static final String USE_POOL_OFFSET_FREELISTS = "PartitionAllocUsePoolOffsetFreelists";
  public static final String USE_RUST_JSON_PARSER = "UseRustJsonParser";
  public static final String USE_UTILITY_THREAD_GROUP = "UseUtilityThreadGroup";

  private BaseFeatures() {}
}
