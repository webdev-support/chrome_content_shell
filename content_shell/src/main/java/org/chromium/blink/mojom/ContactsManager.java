package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ContactsManager extends Interface {
  public static final Interface.Manager<ContactsManager, Proxy> MANAGER =
      ContactsManager_Internal.MANAGER;

  public interface Proxy extends ContactsManager, Interface.Proxy {}

  public interface Select_Response {
    void call(ContactInfo[] contactInfoArr);
  }

  void select(
      boolean z,
      boolean z2,
      boolean z3,
      boolean z4,
      boolean z5,
      boolean z6,
      Select_Response select_Response);
}
