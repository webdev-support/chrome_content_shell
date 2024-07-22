package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.File;

public interface NetLogExporter extends Interface {
  public static final Interface.Manager<NetLogExporter, Proxy> MANAGER =
      NetLogExporter_Internal.MANAGER;
  public static final long UNLIMITED_FILE_SIZE = -1;

  public interface Proxy extends NetLogExporter, Interface.Proxy {}

  public interface Start_Response {
    void call(int i);
  }

  public interface Stop_Response {
    void call(int i);
  }

  void start(
      File file, DictionaryValue dictionaryValue, int i, long j, Start_Response start_Response);

  void stop(DictionaryValue dictionaryValue, Stop_Response stop_Response);
}
