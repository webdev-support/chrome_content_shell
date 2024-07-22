package org.chromium.ui.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.NativeLibraryLoadedStatus;

public class SelectFileDialogJni implements SelectFileDialog.Natives {

  SelectFileDialogJni() {}

  @Override
  public void onContactsSelected(
      long nativeSelectFileDialogImpl, SelectFileDialog caller, String contacts) {
    if (nativeSelectFileDialogImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_SelectFileDialog_onContactsSelected(
        nativeSelectFileDialogImpl, caller, contacts);
  }

  @Override
  public void onFileNotSelected(long nativeSelectFileDialogImpl, SelectFileDialog caller) {
    if (nativeSelectFileDialogImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_SelectFileDialog_onFileNotSelected(
        nativeSelectFileDialogImpl, caller);
  }

  @Override
  public void onFileSelected(
      long nativeSelectFileDialogImpl,
      SelectFileDialog caller,
      String filePath,
      String displayName) {
    if (nativeSelectFileDialogImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_SelectFileDialog_onFileSelected(
        nativeSelectFileDialogImpl, caller, filePath, displayName);
  }

  @Override
  public void onMultipleFilesSelected(
      long nativeSelectFileDialogImpl,
      SelectFileDialog caller,
      String[] filePathArray,
      String[] displayNameArray) {
    if (nativeSelectFileDialogImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_base_SelectFileDialog_onMultipleFilesSelected(
        nativeSelectFileDialogImpl, caller, filePathArray, displayNameArray);
  }

  public static SelectFileDialog.Natives get() {
    NativeLibraryLoadedStatus.checkLoaded();
    return new SelectFileDialogJni();
  }
}
