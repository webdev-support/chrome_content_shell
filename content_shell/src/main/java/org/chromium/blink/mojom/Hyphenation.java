package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyFile;

public interface Hyphenation extends Interface {
  public static final Interface.Manager<Hyphenation, Proxy> MANAGER = Hyphenation_Internal.MANAGER;

  public interface OpenDictionary_Response {
    void call(ReadOnlyFile readOnlyFile);
  }

  public interface Proxy extends Hyphenation, Interface.Proxy {}

  void openDictionary(String str, OpenDictionary_Response openDictionary_Response);
}
