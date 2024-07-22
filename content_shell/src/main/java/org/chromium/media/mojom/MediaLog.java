package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MediaLog extends Interface {
  public static final Interface.Manager<MediaLog, Proxy> MANAGER = MediaLog_Internal.MANAGER;

  public interface Proxy extends MediaLog, Interface.Proxy {}

  void addLogRecord(MediaLogRecord mediaLogRecord);
}
