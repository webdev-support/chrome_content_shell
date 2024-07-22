package org.chromium.device.nfc;

import android.content.Intent;
import android.net.Uri;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import androidx.core.net.MailTo;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.chromium.base.ApiCompatibilityUtils;

public final class NdefMessageUtils {

  private static final String ENCODING_UTF16 = "utf-16";
  private static final String ENCODING_UTF8 = "utf-8";
  public static final String RECORD_TYPE_ABSOLUTE_URL = "absolute-url";
  public static final String RECORD_TYPE_EMPTY = "empty";
  public static final String RECORD_TYPE_MIME = "mime";
  public static final String RECORD_TYPE_SMART_POSTER = "smart-poster";
  public static final String RECORD_TYPE_TEXT = "text";
  public static final String RECORD_TYPE_UNKNOWN = "unknown";
  public static final String RECORD_TYPE_URL = "url";
  private static final String[] URI_PREFIX_MAP = {
    "",
    "http://www.",
    "https://www.",
    "http://",
    "https://",
    "tel:",
    MailTo.MAILTO_SCHEME,
    "ftp://anonymous:anonymous@",
    "ftp://ftp.",
    "ftps://",
    "sftp://",
    "smb://",
    "nfs://",
    "ftp://",
    "dav://",
    "news:",
    "telnet://",
    "imap:",
    "rtsp://",
    "urn:",
    "pop:",
    "sip:",
    "sips:",
    "tftp:",
    "btspp://",
    "btl2cap://",
    "btgoep://",
    "tcpobex://",
    "irdaobex://",
    "file://",
    "urn:epc:id:",
    "urn:epc:tag:",
    "urn:epc:pat:",
    "urn:epc:raw:",
    "urn:epc:",
    "urn:nfc:"
  };

  public static NdefMessage toNdefMessage(org.chromium.device.mojom.NdefMessage message)
      throws InvalidNdefMessageException {
    try {
      List<NdefRecord> records = new ArrayList<>();
      for (int i = 0; i < message.data.length; i++) {
        records.add(toNdefRecord(message.data[i]));
      }
      int i2 = records.size();
      NdefRecord[] ndefRecords = new NdefRecord[i2];
      records.toArray(ndefRecords);
      return new NdefMessage(ndefRecords);
    } catch (UnsupportedEncodingException
        | IllegalArgumentException
        | InvalidNdefMessageException e) {
      throw new InvalidNdefMessageException();
    }
  }

  public static org.chromium.device.mojom.NdefMessage toNdefMessage(NdefMessage ndefMessage)
      throws UnsupportedEncodingException {
    NdefRecord[] ndefRecords = ndefMessage.getRecords();
    org.chromium.device.mojom.NdefMessage message = new org.chromium.device.mojom.NdefMessage();
    List<org.chromium.device.mojom.NdefRecord> records = new ArrayList<>();
    for (NdefRecord ndefRecord : ndefRecords) {
      org.chromium.device.mojom.NdefRecord record = toNdefRecord(ndefRecord);
      if (record != null) {
        records.add(record);
      }
    }
    int i = records.size();
    message.data = new org.chromium.device.mojom.NdefRecord[i];
    records.toArray(message.data);
    return message;
  }

  /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
  /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
     if (r0.equals(org.chromium.device.nfc.NdefMessageUtils.RECORD_TYPE_TEXT) != false) goto L8;
  */
  /*
      Code decompiled incorrectly, please refer to instructions dump.
      To view partially-correct code enable 'Show inconsistent code' option in preferences
  */
  private static android.nfc.NdefRecord toNdefRecord(org.chromium.device.mojom.NdefRecord r6)
      throws org.chromium.device.nfc.InvalidNdefMessageException,
          java.lang.IllegalArgumentException,
          java.io.UnsupportedEncodingException {
    /*
        Method dump skipped, instructions count: 314
        To view this dump change 'Code comments level' option to 'DEBUG'
    */
    throw new UnsupportedOperationException(
        "Method not decompiled: org.chromium.device.nfc.NdefMessageUtils.toNdefRecord(org.chromium.device.mojom.NdefRecord):android.nfc.NdefRecord");
  }

  private static org.chromium.device.mojom.NdefRecord toNdefRecord(NdefRecord ndefRecord)
      throws UnsupportedEncodingException {
    org.chromium.device.mojom.NdefRecord record = null;
    switch (ndefRecord.getTnf()) {
      case 0:
        record = createEmptyRecord();
        break;
      case 1:
        record = createWellKnownRecord(ndefRecord);
        break;
      case 2:
        record =
            createMIMERecord(new String(ndefRecord.getType(), "UTF-8"), ndefRecord.getPayload());
        break;
      case 3:
        record = createURLRecord(ndefRecord.toUri(), true);
        break;
      case 4:
        record =
            createExternalTypeRecord(
                new String(ndefRecord.getType(), "UTF-8"), ndefRecord.getPayload());
        break;
      case 5:
        record = createUnknownRecord(ndefRecord.getPayload());
        break;
    }
    if (record != null && ndefRecord.getTnf() != 0) {
      record.f595id = new String(ndefRecord.getId(), "UTF-8");
    }
    return record;
  }

  public static NdefMessage emptyNdefMessage() {
    return new NdefMessage(new NdefRecord((short) 0, null, null, null), new NdefRecord[0]);
  }

  private static org.chromium.device.mojom.NdefRecord createEmptyRecord() {
    org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
    nfcRecord.category = 0;
    nfcRecord.recordType = RECORD_TYPE_EMPTY;
    nfcRecord.data = new byte[0];
    return nfcRecord;
  }

  private static org.chromium.device.mojom.NdefRecord createURLRecord(Uri uri, boolean isAbsUrl) {
    if (uri == null) {
      return null;
    }
    org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
    nfcRecord.category = 0;
    if (isAbsUrl) {
      nfcRecord.recordType = RECORD_TYPE_ABSOLUTE_URL;
    } else {
      nfcRecord.recordType = "url";
    }
    nfcRecord.data = ApiCompatibilityUtils.getBytesUtf8(uri.toString());
    return nfcRecord;
  }

  private static org.chromium.device.mojom.NdefRecord createMIMERecord(
      String mediaType, byte[] payload) {
    org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
    nfcRecord.category = 0;
    nfcRecord.recordType = RECORD_TYPE_MIME;
    nfcRecord.mediaType = mediaType;
    nfcRecord.data = payload;
    return nfcRecord;
  }

  private static org.chromium.device.mojom.NdefRecord createTextRecord(byte[] text)
      throws UnsupportedEncodingException {
    if (text.length == 0) {
      return null;
    }
    org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
    nfcRecord.category = 0;
    nfcRecord.recordType = RECORD_TYPE_TEXT;
    nfcRecord.encoding = (text[0] & 128) == 0 ? ENCODING_UTF8 : ENCODING_UTF16;
    int langCodeLength = text[0] & 63;
    nfcRecord.lang = new String(text, 1, langCodeLength, "US-ASCII");
    int textBodyStartPos = langCodeLength + 1;
    if (textBodyStartPos > text.length) {
      return null;
    }
    nfcRecord.data = Arrays.copyOfRange(text, textBodyStartPos, text.length);
    return nfcRecord;
  }

  private static org.chromium.device.mojom.NdefRecord createSmartPosterRecord(byte[] payload) {
    org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
    nfcRecord.category = 0;
    nfcRecord.recordType = RECORD_TYPE_SMART_POSTER;
    nfcRecord.data = payload;
    nfcRecord.payloadMessage = getNdefMessageFromPayloadBytes(payload);
    return nfcRecord;
  }

  private static org.chromium.device.mojom.NdefRecord createLocalRecord(
      String localType, byte[] payload) {
    org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
    nfcRecord.category = 2;
    nfcRecord.recordType = localType;
    nfcRecord.data = payload;
    nfcRecord.payloadMessage = getNdefMessageFromPayloadBytes(payload);
    return nfcRecord;
  }

  private static org.chromium.device.mojom.NdefRecord createWellKnownRecord(NdefRecord record)
      throws UnsupportedEncodingException {
    if (Arrays.equals(record.getType(), NdefRecord.RTD_URI)) {
      return createURLRecord(record.toUri(), false);
    }
    if (Arrays.equals(record.getType(), NdefRecord.RTD_TEXT)) {
      return createTextRecord(record.getPayload());
    }
    if (Arrays.equals(record.getType(), NdefRecord.RTD_SMART_POSTER)) {
      return createSmartPosterRecord(record.getPayload());
    }
    String recordType = ":" + new String(record.getType(), "UTF-8");
    if (isValidLocalType(recordType)) {
      return createLocalRecord(recordType, record.getPayload());
    }
    return null;
  }

  private static org.chromium.device.mojom.NdefRecord createUnknownRecord(byte[] payload) {
    org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
    nfcRecord.category = 0;
    nfcRecord.recordType = "unknown";
    nfcRecord.data = payload;
    return nfcRecord;
  }

  private static org.chromium.device.mojom.NdefRecord createExternalTypeRecord(
      String type, byte[] payload) {
    org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
    nfcRecord.category = 1;
    nfcRecord.recordType = type;
    nfcRecord.data = payload;
    nfcRecord.payloadMessage = getNdefMessageFromPayloadBytes(payload);
    return nfcRecord;
  }

  public static NdefRecord createPlatformUrlRecord(byte[] url, String id, boolean isAbsUrl)
      throws UnsupportedEncodingException {
    Uri uri = Uri.parse(new String(url, "UTF-8"));
    if (uri == null) {
      throw new AssertionError();
    }
    String uriString = uri.normalizeScheme().toString();
    if (uriString.length() == 0) {
      throw new IllegalArgumentException("uri is empty");
    }
    byte[] idBytes = id == null ? null : ApiCompatibilityUtils.getBytesUtf8(id);
    if (isAbsUrl) {
      return new NdefRecord(
          (short) 3, ApiCompatibilityUtils.getBytesUtf8(uriString), idBytes, null);
    }
    byte prefix = 0;
    int i = 1;
    while (true) {
      String[] strArr = URI_PREFIX_MAP;
      if (i >= strArr.length) {
        break;
      } else if (!uriString.startsWith(strArr[i])) {
        i++;
      } else {
        prefix = (byte) i;
        uriString = uriString.substring(strArr[i].length());
        break;
      }
    }
    byte[] uriBytes = ApiCompatibilityUtils.getBytesUtf8(uriString);
    byte[] recordBytes = new byte[uriBytes.length + 1];
    recordBytes[0] = prefix;
    System.arraycopy(uriBytes, 0, recordBytes, 1, uriBytes.length);
    return new NdefRecord((short) 1, NdefRecord.RTD_URI, idBytes, recordBytes);
  }

  public static NdefRecord createPlatformTextRecord(
      String id, String lang, String encoding, byte[] text) throws UnsupportedEncodingException {
    if (lang == null || lang.isEmpty()) {
      throw new IllegalArgumentException("lang is invalid");
    }
    if (encoding == null || encoding.isEmpty()) {
      throw new IllegalArgumentException("encoding is invalid");
    }
    byte[] languageCodeBytes = lang.getBytes(StandardCharsets.US_ASCII);
    if (languageCodeBytes.length >= 64) {
      throw new IllegalArgumentException("language code is too long, must be <64 bytes.");
    }
    byte status = (byte) languageCodeBytes.length;
    if (!encoding.equals(ENCODING_UTF8)) {
      status = (byte) (status | Byte.MIN_VALUE);
    }
    ByteBuffer buffer = ByteBuffer.allocate(languageCodeBytes.length + 1 + text.length);
    buffer.put(status);
    buffer.put(languageCodeBytes);
    buffer.put(text);
    return new NdefRecord(
        (short) 1,
        NdefRecord.RTD_TEXT,
        id == null ? null : ApiCompatibilityUtils.getBytesUtf8(id),
        buffer.array());
  }

  public static NdefRecord createPlatformMimeRecord(String mimeType, String id, byte[] payload) {
    if (mimeType == null || mimeType.isEmpty()) {
      throw new AssertionError();
    }
    String mimeType2 = Intent.normalizeMimeType(mimeType);
    if (mimeType2.length() == 0) {
      throw new IllegalArgumentException("mimeType is empty");
    }
    int slashIndex = mimeType2.indexOf(47);
    if (slashIndex == 0) {
      throw new IllegalArgumentException("mimeType must have major type");
    }
    if (slashIndex == mimeType2.length() - 1) {
      throw new IllegalArgumentException("mimeType must have minor type");
    }
    return new NdefRecord(
        (short) 2,
        ApiCompatibilityUtils.getBytesUtf8(mimeType2),
        id == null ? null : ApiCompatibilityUtils.getBytesUtf8(id),
        payload);
  }

  public static NdefRecord createPlatformExternalRecord(
      String recordType,
      String id,
      byte[] payload,
      org.chromium.device.mojom.NdefMessage payloadMessage) {
    if (recordType == null || recordType.isEmpty()) {
      throw new AssertionError();
    }
    if (payloadMessage != null) {
      if (payload.length != 0) {
        throw new AssertionError();
      }
      payload = getBytesFromPayloadNdefMessage(payloadMessage);
    }
    return new NdefRecord(
        (short) 4,
        ApiCompatibilityUtils.getBytesUtf8(recordType.toLowerCase(Locale.ROOT)),
        id == null ? null : ApiCompatibilityUtils.getBytesUtf8(id),
        payload);
  }

  public static NdefRecord createPlatformSmartPosterRecord(
      String id, org.chromium.device.mojom.NdefMessage payloadMessage)
      throws InvalidNdefMessageException {
    if (payloadMessage == null) {
      throw new InvalidNdefMessageException();
    }
    List<NdefRecord> records = new ArrayList<>();
    boolean hasUrlRecord = false;
    boolean hasSizeRecord = false;
    boolean hasTypeRecord = false;
    boolean hasActionRecord = false;
    for (int i = 0; i < payloadMessage.data.length; i++) {
      org.chromium.device.mojom.NdefRecord record = payloadMessage.data[i];
      if (record.recordType.equals("url")) {
        if (hasUrlRecord) {
          throw new InvalidNdefMessageException();
        }
        hasUrlRecord = true;
      } else if (record.recordType.equals(":s")) {
        if (hasSizeRecord || record.data.length != 4) {
          throw new InvalidNdefMessageException();
        }
        hasSizeRecord = true;
      } else if (record.recordType.equals(":t")) {
        if (hasTypeRecord) {
          throw new InvalidNdefMessageException();
        }
        hasTypeRecord = true;
      } else if (record.recordType.equals(":act")) {
        if (hasActionRecord || record.data.length != 1) {
          throw new InvalidNdefMessageException();
        }
        hasActionRecord = true;
      }
      try {
        records.add(toNdefRecord(payloadMessage.data[i]));
      } catch (UnsupportedEncodingException
          | IllegalArgumentException
          | InvalidNdefMessageException e) {
        throw new InvalidNdefMessageException();
      }
    }
    if (!hasUrlRecord) {
      throw new InvalidNdefMessageException();
    }
    NdefRecord[] ndefRecords = new NdefRecord[records.size()];
    records.toArray(ndefRecords);
    NdefMessage ndefMessage = new NdefMessage(ndefRecords);
    return new NdefRecord(
        (short) 1,
        NdefRecord.RTD_SMART_POSTER,
        id == null ? null : ApiCompatibilityUtils.getBytesUtf8(id),
        ndefMessage.toByteArray());
  }

  public static NdefRecord createPlatformLocalRecord(
      String recordType,
      String id,
      byte[] payload,
      org.chromium.device.mojom.NdefMessage payloadMessage) {
    if (recordType == null || recordType.isEmpty()) {
      throw new AssertionError();
    }
    if (payloadMessage != null) {
      if (payload.length != 0) {
        throw new AssertionError();
      }
      payload = getBytesFromPayloadNdefMessage(payloadMessage);
    }
    return new NdefRecord(
        (short) 1,
        ApiCompatibilityUtils.getBytesUtf8(recordType),
        id == null ? null : ApiCompatibilityUtils.getBytesUtf8(id),
        payload);
  }

  private static boolean isValidExternalType(String input) {
    int colonIndex;
    if (Charset.forName("US-ASCII").newEncoder().canEncode(input)
        && !input.isEmpty()
        && input.length() <= 255
        && (colonIndex = input.indexOf(58)) != -1) {
      String domain = input.substring(0, colonIndex).trim();
      if (domain.isEmpty()) {
        return false;
      }
      String type = input.substring(colonIndex + 1).trim();
      return !type.isEmpty() && type.matches("[a-zA-Z0-9:!()+,\\-=@;$_*'.]+");
    }
    return false;
  }

  private static boolean isValidLocalType(String input) {
    if (Charset.forName("US-ASCII").newEncoder().canEncode(input)
        && input.length() >= 2
        && input.length() <= 256
        && input.charAt(0) == ':') {
      return Character.isLowerCase(input.charAt(1)) || Character.isDigit(input.charAt(1));
    }
    return false;
  }

  private static org.chromium.device.mojom.NdefMessage getNdefMessageFromPayloadBytes(
      byte[] payload) {
    try {
      NdefMessage payloadMessage = new NdefMessage(payload);
      return toNdefMessage(payloadMessage);
    } catch (FormatException | UnsupportedEncodingException e) {
      return null;
    }
  }

  private static byte[] getBytesFromPayloadNdefMessage(
      org.chromium.device.mojom.NdefMessage payloadMessage) {
    try {
      NdefMessage message = toNdefMessage(payloadMessage);
      return message.toByteArray();
    } catch (InvalidNdefMessageException e) {
      return null;
    }
  }
}
