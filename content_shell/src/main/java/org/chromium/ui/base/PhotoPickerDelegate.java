package org.chromium.ui.base;

import java.util.List;

public interface PhotoPickerDelegate {
  boolean launchRegularWithoutBrowse();

  boolean launchViaActionGetContent();

  boolean launchViaActionPickImages();

  boolean launchViaActionPickImagesPlus();

  PhotoPicker showPhotoPicker(
      WindowAndroid windowAndroid,
      PhotoPickerListener photoPickerListener,
      boolean z,
      List<String> list);
}
