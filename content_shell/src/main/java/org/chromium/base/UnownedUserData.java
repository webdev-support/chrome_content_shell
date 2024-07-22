package org.chromium.base;

public interface UnownedUserData {
  default void onDetachedFromHost(UnownedUserDataHost host) {}

  default boolean informOnDetachmentFromHost() {
    return true;
  }
}
