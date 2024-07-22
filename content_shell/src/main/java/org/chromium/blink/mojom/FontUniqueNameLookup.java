package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

public interface FontUniqueNameLookup extends Interface {
  public static final Interface.Manager<FontUniqueNameLookup, Proxy> MANAGER =
      FontUniqueNameLookup_Internal.MANAGER;

  public interface GetUniqueNameLookupTableIfAvailable_Response {
    void call(boolean z, ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion);
  }

  public interface GetUniqueNameLookupTable_Response {
    void call(ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion);
  }

  public interface Proxy extends FontUniqueNameLookup, Interface.Proxy {}

  void getUniqueNameLookupTable(
      GetUniqueNameLookupTable_Response getUniqueNameLookupTable_Response);

  void getUniqueNameLookupTableIfAvailable(
      GetUniqueNameLookupTableIfAvailable_Response getUniqueNameLookupTableIfAvailable_Response);
}
