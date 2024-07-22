package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface Renderer extends Interface {
  public static final Interface.Manager<Renderer, Proxy> MANAGER = Renderer_Internal.MANAGER;

  public interface Flush_Response {
    void call();
  }

  public interface Initialize_Response {
    void call(boolean z);
  }

  public interface Proxy extends Renderer, Interface.Proxy {}

  public interface SetCdm_Response {
    void call(boolean z);
  }

  void flush(Flush_Response flush_Response);

  void initialize(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      DemuxerStream[] demuxerStreamArr,
      MediaUrlParams mediaUrlParams,
      Initialize_Response initialize_Response);

  void setCdm(UnguessableToken unguessableToken, SetCdm_Response setCdm_Response);

  void setPlaybackRate(double d);

  void setVolume(float f);

  void startPlayingFrom(TimeDelta timeDelta);
}
