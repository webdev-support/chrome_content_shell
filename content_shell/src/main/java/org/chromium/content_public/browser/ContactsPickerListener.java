package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.chromium.blink.mojom.ContactIconBlob;
import org.chromium.payments.mojom.PaymentAddress;

public interface ContactsPickerListener {

  @Retention(RetentionPolicy.SOURCE)
  public @interface ContactsPickerAction {
    public static final int CANCEL = 0;
    public static final int CONTACTS_SELECTED = 1;
    public static final int NUM_ENTRIES = 4;
    public static final int SELECT_ALL = 2;
    public static final int UNDO_SELECT_ALL = 3;
  }

  void onContactsPickerUserAction(int i, List<Contact> list, int i2, int i3, int i4);

  public static class Contact {
    public final List<String> emails;
    public final List<String> names;
    public final List<ByteBuffer> serializedAddresses;
    public final List<ByteBuffer> serializedIcons;
    public final List<String> tel;

    public Contact(
        List<String> contactNames,
        List<String> contactEmails,
        List<String> contactTel,
        List<PaymentAddress> contactAddresses,
        List<ContactIconBlob> contactIcons) {
      this.names = contactNames;
      this.emails = contactEmails;
      this.tel = contactTel;
      if (contactAddresses != null) {
        this.serializedAddresses = new ArrayList();
        for (PaymentAddress address : contactAddresses) {
          this.serializedAddresses.add(address.serialize());
        }
      } else {
        this.serializedAddresses = null;
      }
      if (contactIcons != null) {
        this.serializedIcons = new ArrayList();
        for (ContactIconBlob icon : contactIcons) {
          this.serializedIcons.add(icon.serialize());
        }
        return;
      }
      this.serializedIcons = null;
    }
  }
}
