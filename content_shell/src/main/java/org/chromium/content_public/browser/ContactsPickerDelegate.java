package org.chromium.content_public.browser;

public interface ContactsPickerDelegate {
  Object showContactsPicker(
      WebContents webContents,
      ContactsPickerListener contactsPickerListener,
      boolean z,
      boolean z2,
      boolean z3,
      boolean z4,
      boolean z5,
      boolean z6,
      String str);
}
