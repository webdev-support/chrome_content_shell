package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface AudioFocusManager extends Interface {
  public static final Interface.Manager<AudioFocusManager, Proxy> MANAGER =
      AudioFocusManager_Internal.MANAGER;

  public interface GetFocusRequests_Response {
    void call(AudioFocusRequestState[] audioFocusRequestStateArr);
  }

  public interface GetSourceFocusRequests_Response {
    void call(AudioFocusRequestState[] audioFocusRequestStateArr);
  }

  public interface Proxy extends AudioFocusManager, Interface.Proxy {}

  public interface RequestAudioFocus_Response {
    void call(UnguessableToken unguessableToken);
  }

  public interface RequestGroupedAudioFocus_Response {
    void call(boolean z);
  }

  void addObserver(AudioFocusObserver audioFocusObserver);

  void addSourceObserver(UnguessableToken unguessableToken, AudioFocusObserver audioFocusObserver);

  void getFocusRequests(GetFocusRequests_Response getFocusRequests_Response);

  void getSourceFocusRequests(
      UnguessableToken unguessableToken,
      GetSourceFocusRequests_Response getSourceFocusRequests_Response);

  void requestAudioFocus(
      InterfaceRequest<AudioFocusRequestClient> interfaceRequest,
      MediaSession mediaSession,
      MediaSessionInfo mediaSessionInfo,
      int i,
      RequestAudioFocus_Response requestAudioFocus_Response);

  void requestGroupedAudioFocus(
      UnguessableToken unguessableToken,
      InterfaceRequest<AudioFocusRequestClient> interfaceRequest,
      MediaSession mediaSession,
      MediaSessionInfo mediaSessionInfo,
      int i,
      UnguessableToken unguessableToken2,
      RequestGroupedAudioFocus_Response requestGroupedAudioFocus_Response);

  void requestIdReleased(UnguessableToken unguessableToken);

  void setEnforcementMode(int i);

  void setSource(UnguessableToken unguessableToken, String str);
}
