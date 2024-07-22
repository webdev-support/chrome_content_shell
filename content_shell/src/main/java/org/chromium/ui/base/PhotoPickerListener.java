package org.chromium.ui.base;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface PhotoPickerListener {
  public static final int SHOW_GALLERY = 2;
  public static final int TAKE_PHOTO_REQUEST = 1;

  @Retention(RetentionPolicy.SOURCE)
  public @interface PhotoPickerAction {
    public static final int CANCEL = 0;
    public static final int LAUNCH_CAMERA = 2;
    public static final int LAUNCH_GALLERY = 3;
    public static final int NUM_ENTRIES = 4;
    public static final int PHOTOS_SELECTED = 1;
  }

  void onPhotoPickerDismissed();

  void onPhotoPickerUserAction(int i, Uri[] uriArr);
}
