package org.chromium.components.crash.browser;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.chromium.base.PackageUtils;

public abstract class PackagePaths {
  private PackagePaths() {}

  public static String[] makePackagePaths(String arch) {
    PackageInfo pi = PackageUtils.getApplicationPackageInfo(9216);
    List<String> zipPaths = new ArrayList<>(10);
    zipPaths.add(pi.applicationInfo.sourceDir);
    if (pi.applicationInfo.splitSourceDirs != null) {
      Collections.addAll(zipPaths, pi.applicationInfo.splitSourceDirs);
    }
    if (pi.applicationInfo.sharedLibraryFiles != null) {
      Collections.addAll(zipPaths, pi.applicationInfo.sharedLibraryFiles);
    }
    List<String> libPaths = new ArrayList<>(10);
    File parent = new File(pi.applicationInfo.nativeLibraryDir).getParentFile();
    if (parent != null) {
      libPaths.add(new File(parent, arch).getPath());
      if (arch.startsWith("arm64")) {
        libPaths.add(new File(parent, "arm64").getPath());
      } else if (arch.startsWith("arm")) {
        libPaths.add(new File(parent, "arm").getPath());
      }
    }
    for (String zip : zipPaths) {
      if (zip.endsWith(".apk")) {
        libPaths.add(zip + "!/lib/" + arch);
      }
    }
    libPaths.add(System.getProperty("java.library.path"));
    libPaths.add(pi.applicationInfo.nativeLibraryDir);
    return new String[] {
      TextUtils.join(File.pathSeparator, zipPaths), TextUtils.join(File.pathSeparator, libPaths)
    };
  }
}
