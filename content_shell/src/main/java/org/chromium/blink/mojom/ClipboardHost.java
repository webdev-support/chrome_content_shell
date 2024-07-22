package org.chromium.blink.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.BigString;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.skia.mojom.BitmapN32;
import org.chromium.url.mojom.Url;

public interface ClipboardHost extends Interface {
  public static final Interface.Manager<ClipboardHost, Proxy> MANAGER =
      ClipboardHost_Internal.MANAGER;
  public static final int MAX_DATA_SIZE = 1073741824;
  public static final int MAX_FORMAT_SIZE = 1024;

  public interface GetSequenceNumber_Response {
    void call(ClipboardSequenceNumberToken clipboardSequenceNumberToken);
  }

  public interface IsFormatAvailable_Response {
    void call(boolean z);
  }

  public interface Proxy extends ClipboardHost, Interface.Proxy {}

  public interface ReadAvailableCustomAndStandardFormats_Response {
    void call(String16[] string16Arr);
  }

  public interface ReadAvailableTypes_Response {
    void call(String16[] string16Arr);
  }

  public interface ReadCustomData_Response {
    void call(BigString16 bigString16);
  }

  public interface ReadFiles_Response {
    void call(ClipboardFiles clipboardFiles);
  }

  public interface ReadHtml_Response {
    void call(BigString16 bigString16, Url url, int i, int i2);
  }

  public interface ReadPng_Response {
    void call(BigBuffer bigBuffer);
  }

  public interface ReadRtf_Response {
    void call(BigString bigString);
  }

  public interface ReadSvg_Response {
    void call(BigString16 bigString16);
  }

  public interface ReadText_Response {
    void call(BigString16 bigString16);
  }

  public interface ReadUnsanitizedCustomFormat_Response {
    void call(BigBuffer bigBuffer);
  }

  void commitWrite();

  void getSequenceNumber(int i, GetSequenceNumber_Response getSequenceNumber_Response);

  void isFormatAvailable(int i, int i2, IsFormatAvailable_Response isFormatAvailable_Response);

  void readAvailableCustomAndStandardFormats(
      ReadAvailableCustomAndStandardFormats_Response
          readAvailableCustomAndStandardFormats_Response);

  void readAvailableTypes(int i, ReadAvailableTypes_Response readAvailableTypes_Response);

  void readCustomData(int i, String16 string16, ReadCustomData_Response readCustomData_Response);

  void readFiles(int i, ReadFiles_Response readFiles_Response);

  void readHtml(int i, ReadHtml_Response readHtml_Response);

  void readPng(int i, ReadPng_Response readPng_Response);

  void readRtf(int i, ReadRtf_Response readRtf_Response);

  void readSvg(int i, ReadSvg_Response readSvg_Response);

  void readText(int i, ReadText_Response readText_Response);

  void readUnsanitizedCustomFormat(
      String16 string16, ReadUnsanitizedCustomFormat_Response readUnsanitizedCustomFormat_Response);

  void writeBookmark(String str, String16 string16);

  void writeCustomData(Map<String16, BigString16> map);

  void writeHtml(BigString16 bigString16, Url url);

  void writeImage(BitmapN32 bitmapN32);

  void writeSmartPasteMarker();

  void writeSvg(BigString16 bigString16);

  void writeText(BigString16 bigString16);

  void writeUnsanitizedCustomFormat(String16 string16, BigBuffer bigBuffer);
}
