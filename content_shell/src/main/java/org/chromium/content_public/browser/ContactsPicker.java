package org.chromium.content_public.browser;

public final class ContactsPicker {

  private static ContactsPickerDelegate sContactsPickerDelegate;
  private static Object sPicker;

  private ContactsPicker() {}

  public static void setContactsPickerDelegate(ContactsPickerDelegate delegate) {
    sContactsPickerDelegate = delegate;
  }

  public static boolean canShowContactsPicker(WebContents webContents) {
    return (webContents == null || webContents.isDestroyed() || webContents.getVisibility() != 2)
        ? false
        : true;
  }

  public static boolean showContactsPicker(
      WebContents webContents,
      ContactsPickerListener listener,
      boolean allowMultiple,
      boolean includeNames,
      boolean includeEmails,
      boolean includeTel,
      boolean includeAddresses,
      boolean includeIcons,
      String formattedOrigin) {
    if (sContactsPickerDelegate == null) {
      return false;
    }
    if (sPicker != null) {
      throw new AssertionError();
    }
    if (canShowContactsPicker(webContents)) {
      sPicker =
          sContactsPickerDelegate.showContactsPicker(
              webContents,
              listener,
              allowMultiple,
              includeNames,
              includeEmails,
              includeTel,
              includeAddresses,
              includeIcons,
              formattedOrigin);
      return true;
    }
    return false;
  }

  public static void onContactsPickerDismissed() {
    if (sPicker == null) {
      throw new AssertionError();
    }
    sPicker = null;
  }
}
