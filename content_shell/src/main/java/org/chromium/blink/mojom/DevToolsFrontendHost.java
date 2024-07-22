package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.DictionaryValue;

public interface DevToolsFrontendHost extends Interface {
  public static final Interface.Manager<DevToolsFrontendHost, Proxy> MANAGER =
      DevToolsFrontendHost_Internal.MANAGER;

  public interface Proxy extends DevToolsFrontendHost, Interface.Proxy {}

  void dispatchEmbedderMessage(DictionaryValue dictionaryValue);
}
