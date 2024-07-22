package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

public interface UdpSocket extends Interface {
  public static final Interface.Manager<UdpSocket, Proxy> MANAGER = UdpSocket_Internal.MANAGER;

  public interface Bind_Response {
    void call(int i, IpEndPoint ipEndPoint);
  }

  public interface Connect_Response {
    void call(int i, IpEndPoint ipEndPoint);
  }

  public interface JoinGroup_Response {
    void call(int i);
  }

  public interface LeaveGroup_Response {
    void call(int i);
  }

  public interface Proxy extends UdpSocket, Interface.Proxy {}

  public interface SendTo_Response {
    void call(int i);
  }

  public interface Send_Response {
    void call(int i);
  }

  public interface SetBroadcast_Response {
    void call(int i);
  }

  public interface SetReceiveBufferSize_Response {
    void call(int i);
  }

  public interface SetSendBufferSize_Response {
    void call(int i);
  }

  void bind(IpEndPoint ipEndPoint, UdpSocketOptions udpSocketOptions, Bind_Response bind_Response);

  @Override
  void close();

  void connect(
      IpEndPoint ipEndPoint, UdpSocketOptions udpSocketOptions, Connect_Response connect_Response);

  void joinGroup(IpAddress ipAddress, JoinGroup_Response joinGroup_Response);

  void leaveGroup(IpAddress ipAddress, LeaveGroup_Response leaveGroup_Response);

  void receiveMore(int i);

  void receiveMoreWithBufferSize(int i, int i2);

  void send(
      ReadOnlyBuffer readOnlyBuffer,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      Send_Response send_Response);

  void sendTo(
      IpEndPoint ipEndPoint,
      ReadOnlyBuffer readOnlyBuffer,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      SendTo_Response sendTo_Response);

  void setBroadcast(boolean z, SetBroadcast_Response setBroadcast_Response);

  void setReceiveBufferSize(int i, SetReceiveBufferSize_Response setReceiveBufferSize_Response);

  void setSendBufferSize(int i, SetSendBufferSize_Response setSendBufferSize_Response);
}
