package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.TimeTicks;

public interface NetLogProxySink extends Interface {
  public static final Interface.Manager<NetLogProxySink, Proxy> MANAGER =
      NetLogProxySink_Internal.MANAGER;

  public interface Proxy extends NetLogProxySink, Interface.Proxy {}

  void addEntry(
      int i,
      NetLogSource netLogSource,
      int i2,
      TimeTicks timeTicks,
      DictionaryValue dictionaryValue);
}
