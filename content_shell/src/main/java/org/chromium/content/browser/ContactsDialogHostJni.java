package org.chromium.content.browser;

import java.nio.ByteBuffer;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ContactsDialogHostJni implements ContactsDialogHost.Natives {

  public static final JniStaticTestMocker<ContactsDialogHost.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ContactsDialogHost.Natives>() {
        @Override
        public void setInstanceForTesting(ContactsDialogHost.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ContactsDialogHostJni.testInstance = instance;
        }
      };
  private static ContactsDialogHost.Natives testInstance;

  ContactsDialogHostJni() {}

  @Override
  public void addContact(
      long nativeContactsProviderAndroid,
      String[] names,
      String[] emails,
      String[] tel,
      ByteBuffer[] addresses,
      ByteBuffer[] icons) {
    if (nativeContactsProviderAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_ContactsDialogHost_addContact(
        nativeContactsProviderAndroid, names, emails, tel, addresses, icons);
  }

  @Override
  public void endContactsList(
      long nativeContactsProviderAndroid, int percentageShared, int propertiesSiteRequested) {
    if (nativeContactsProviderAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_ContactsDialogHost_endContactsList(
        nativeContactsProviderAndroid, percentageShared, propertiesSiteRequested);
  }

  @Override
  public void endWithPermissionDenied(long nativeContactsProviderAndroid) {
    if (nativeContactsProviderAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_ContactsDialogHost_endWithPermissionDenied(
        nativeContactsProviderAndroid);
  }

  public static ContactsDialogHost.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ContactsDialogHost.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ContactsDialogHost.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ContactsDialogHostJni();
  }
}
