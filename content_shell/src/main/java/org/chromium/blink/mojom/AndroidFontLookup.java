package org.chromium.blink.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyFile;

public interface AndroidFontLookup extends Interface {
  public static final Interface.Manager<AndroidFontLookup, Proxy> MANAGER =
      AndroidFontLookup_Internal.MANAGER;

  public interface FetchAllFontFiles_Response {
    void call(Map<String, ReadOnlyFile> map);
  }

  public interface GetUniqueNameLookupTable_Response {
    void call(String[] strArr);
  }

  public interface MatchLocalFontByUniqueName_Response {
    void call(ReadOnlyFile readOnlyFile);
  }

  public interface Proxy extends AndroidFontLookup, Interface.Proxy {}

  void fetchAllFontFiles(FetchAllFontFiles_Response fetchAllFontFiles_Response);

  void getUniqueNameLookupTable(
      GetUniqueNameLookupTable_Response getUniqueNameLookupTable_Response);

  void matchLocalFontByUniqueName(
      String str, MatchLocalFontByUniqueName_Response matchLocalFontByUniqueName_Response);
}
