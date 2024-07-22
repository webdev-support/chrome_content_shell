package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ListValue;

public interface PeerConnectionTrackerHost extends Interface {
  public static final Interface.Manager<PeerConnectionTrackerHost, Proxy> MANAGER =
      PeerConnectionTrackerHost_Internal.MANAGER;

  public interface Proxy extends PeerConnectionTrackerHost, Interface.Proxy {}

  void addLegacyStats(int i, ListValue listValue);

  void addPeerConnection(PeerConnectionInfo peerConnectionInfo);

  void addStandardStats(int i, ListValue listValue);

  void getDisplayMedia(int i, boolean z, boolean z2, String str, String str2);

  void getDisplayMediaFailure(int i, String str, String str2);

  void getDisplayMediaSuccess(int i, String str, String str2, String str3);

  void getUserMedia(int i, boolean z, boolean z2, String str, String str2);

  void getUserMediaFailure(int i, String str, String str2);

  void getUserMediaSuccess(int i, String str, String str2, String str3);

  void onPeerConnectionSessionIdSet(int i, String str);

  void removePeerConnection(int i);

  void updatePeerConnection(int i, String str, String str2);

  void webRtcEventLogWrite(int i, byte[] bArr);
}
