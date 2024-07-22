package org.chromium.base.cached_flags;

import java.util.HashMap;
import java.util.Map;

abstract class ValuesReturned {
  static final Map<String, Boolean> sBoolValues = new HashMap();
  static final Map<String, String> sStringValues = new HashMap();
  static final Map<String, Integer> sIntValues = new HashMap();
  static final Map<String, Double> sDoubleValues = new HashMap();

  ValuesReturned() {}

  public static void clearForTesting() {
    Map<String, Boolean> map = sBoolValues;
    synchronized (map) {
      map.clear();
    }
    Map<String, String> map2 = sStringValues;
    synchronized (map2) {
      map2.clear();
    }
    Map<String, Integer> map3 = sIntValues;
    synchronized (map3) {
      map3.clear();
    }
    Map<String, Double> map4 = sDoubleValues;
    synchronized (map4) {
      map4.clear();
    }
  }
}
