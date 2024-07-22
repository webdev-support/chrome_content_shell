package org.chromium.net;

import java.net.InetAddress;
import java.util.List;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;

/** Class to access DNS server configuration. */
@JNINamespace("net::android")
public class DnsStatus {
  private final List<InetAddress> mDnsServers;

  private final boolean mPrivateDnsActive;

  private final String mPrivateDnsServerName;

  private final String mSearchDomains;

  public DnsStatus(
      List<InetAddress> dnsServers,
      boolean privateDnsActive,
      String privateDnsServerName,
      String searchDomains) {
    mDnsServers = dnsServers;
    mPrivateDnsActive = privateDnsActive;
    mPrivateDnsServerName = (privateDnsServerName != null) ? privateDnsServerName : "";
    mSearchDomains = (searchDomains != null) ? searchDomains : "";
  }

  @CalledByNative
  public byte[][] getDnsServers() {
    // 获取dns server
    byte[][] dnsServers = new byte[mDnsServers.size()][];
    for (int i = 0; i < mDnsServers.size(); i++) {
      dnsServers[i] = mDnsServers.get(i).getAddress();
    }
    return dnsServers;
  }

  @CalledByNative
  public boolean getPrivateDnsActive() {
    return mPrivateDnsActive;
  }

  @CalledByNative
  public String getPrivateDnsServerName() {
    return mPrivateDnsServerName;
  }

  @CalledByNative
  public String getSearchDomains() {
    return mSearchDomains;
  }
}
