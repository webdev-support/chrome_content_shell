package org.chromium.content.browser.font;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.CancellationSignal;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;

public class FontsContractWrapper {

  public FontsContractCompat.FontFamilyResult fetchFonts(
      Context context, CancellationSignal cancellationSignal, FontRequest request)
      throws PackageManager.NameNotFoundException {
    return FontsContractCompat.fetchFonts(context, cancellationSignal, request);
  }
}
