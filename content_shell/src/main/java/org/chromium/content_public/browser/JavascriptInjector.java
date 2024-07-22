package org.chromium.content_public.browser;

import android.util.Pair;
import java.lang.annotation.Annotation;
import java.util.Map;
import org.chromium.content.browser.JavascriptInjectorImpl;

public interface JavascriptInjector {
  void addPossiblyUnsafeInterface(Object obj, String str, Class<? extends Annotation> cls);

  Map<String, Pair<Object, Class>> getInterfaces();

  void removeInterface(String str);

  void setAllowInspection(boolean z);

  static JavascriptInjector fromWebContents(WebContents webContents, boolean useMojo) {
    return JavascriptInjectorImpl.fromWebContents(webContents, useMojo);
  }
}
