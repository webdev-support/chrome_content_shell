package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface QuotaManagerHost extends Interface {
  public static final Interface.Manager<QuotaManagerHost, Proxy> MANAGER =
      QuotaManagerHost_Internal.MANAGER;

  public interface AddChangeListener_Response {
    void call();
  }

  public interface Proxy extends QuotaManagerHost, Interface.Proxy {}

  public interface QueryStorageUsageAndQuota_Response {
    void call(int i, long j, long j2, UsageBreakdown usageBreakdown);
  }

  void addChangeListener(
      QuotaChangeListener quotaChangeListener,
      AddChangeListener_Response addChangeListener_Response);

  void queryStorageUsageAndQuota(
      QueryStorageUsageAndQuota_Response queryStorageUsageAndQuota_Response);
}
