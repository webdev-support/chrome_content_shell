package org.chromium.base.process_launcher;

interface ChildServiceConnection {
  boolean bindServiceConnection();

  boolean isBound();

  void retire();

  void unbindServiceConnection();

  void updateGroupImportance(int i, int i2);
}
