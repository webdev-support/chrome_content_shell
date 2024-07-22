package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FileEnumerator extends Interface {
  public static final Interface.Manager<FileEnumerator, Proxy> MANAGER =
      FileEnumerator_Internal.MANAGER;

  public interface GetNext_Response {
    void call(FileEnumerationEntry[] fileEnumerationEntryArr, boolean z, boolean z2);
  }

  public interface Proxy extends FileEnumerator, Interface.Proxy {}

  void getNext(int i, GetNext_Response getNext_Response);
}
