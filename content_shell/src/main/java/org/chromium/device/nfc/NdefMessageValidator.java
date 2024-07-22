package org.chromium.device.nfc;

import org.chromium.device.mojom.NdefMessage;
import org.chromium.device.mojom.NdefRecord;

public final class NdefMessageValidator {
  public static boolean isValid(NdefMessage message) {
    if (message == null || message.data == null || message.data.length == 0) {
      return false;
    }
    for (int i = 0; i < message.data.length; i++) {
      if (!isValid(message.data[i])) {
        return false;
      }
    }
    return true;
  }

  private static boolean isValid(NdefRecord record) {
    if (record == null) {
      return false;
    }
    if (record.recordType.equals(NdefMessageUtils.RECORD_TYPE_EMPTY)) {
      return true;
    }
    if (record.data == null) {
      return false;
    }
    if (record.recordType.equals(NdefMessageUtils.RECORD_TYPE_MIME)) {
      if (record.mediaType == null || record.mediaType.isEmpty()) {
        return false;
      }
    } else if (record.mediaType != null) {
      return false;
    }
    return true;
  }
}
