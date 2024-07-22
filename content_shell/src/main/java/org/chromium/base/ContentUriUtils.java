package org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;

public abstract class ContentUriUtils {

  private static final String TAG = "ContentUriUtils";
  private static FileProviderUtil sFileProviderUtil;
  private static final Object sLock = new Object();

  public interface FileProviderUtil {
    Uri getContentUriFromFile(File file);
  }

  private ContentUriUtils() {}

  public static void setFileProviderUtil(FileProviderUtil util) {
    synchronized (sLock) {
      sFileProviderUtil = util;
    }
  }

  public static Uri getContentUriFromFile(File file) {
    synchronized (sLock) {
      FileProviderUtil fileProviderUtil = sFileProviderUtil;
      if (fileProviderUtil != null) {
        return fileProviderUtil.getContentUriFromFile(file);
      }
      return null;
    }
  }

  public static int openContentUriForRead(String uriString) {
    AssetFileDescriptor afd = getAssetFileDescriptor(uriString);
    if (afd != null) {
      return afd.getParcelFileDescriptor().detachFd();
    }
    return -1;
  }

  public static boolean contentUriExists(String uriString) {
    AssetFileDescriptor asf = null;
    try {
      asf = getAssetFileDescriptor(uriString);
      return asf != null;
    } finally {
      if (asf != null) {
        try {
          asf.close();
        } catch (IOException e) {
        }
      }
    }
  }

  public static String getMimeType(String uriString) {
    ContentResolver resolver = ContextUtils.getApplicationContext().getContentResolver();
    Uri uri = Uri.parse(uriString);
    if (isVirtualDocument(uri)) {
      String[] streamTypes = resolver.getStreamTypes(uri, "*/*");
      if (streamTypes == null || streamTypes.length <= 0) {
        return null;
      }
      return streamTypes[0];
    }
    return resolver.getType(uri);
  }

  private static AssetFileDescriptor getAssetFileDescriptor(String uriString) {
    ContentResolver resolver = ContextUtils.getApplicationContext().getContentResolver();
    Uri uri = Uri.parse(uriString);
    try {
      if (isVirtualDocument(uri)) {
        String[] streamTypes = resolver.getStreamTypes(uri, "*/*");
        if (streamTypes != null && streamTypes.length > 0) {
          AssetFileDescriptor afd =
              resolver.openTypedAssetFileDescriptor(uri, streamTypes[0], null);
          if (afd != null && afd.getStartOffset() != 0) {
            try {
              afd.close();
            } catch (IOException e) {
            }
            throw new SecurityException("Cannot open files with non-zero offset type.");
          }
          return afd;
        }
      } else {
        ParcelFileDescriptor pfd = resolver.openFileDescriptor(uri, "r");
        if (pfd != null) {
          return new AssetFileDescriptor(pfd, 0L, -1L);
        }
      }
    } catch (Exception e2) {
      Log.w(TAG, "Cannot open content uri: %s", (Object) uriString, (Throwable) e2);
    }
    return null;
  }

  public static String getDisplayName(Uri uri, Context context, String columnField) {
    String[] mimeTypes;
    String ext;
    if (uri == null) {
      return "";
    }
    ContentResolver contentResolver = context.getContentResolver();
    try {
      Cursor cursor = contentResolver.query(uri, null, null, null, null);
      if (cursor == null || cursor.getCount() < 1) {
        if (cursor != null) {
          cursor.close();
        }
        return "";
      }
      cursor.moveToFirst();
      int displayNameIndex = cursor.getColumnIndex(columnField);
      if (displayNameIndex == -1) {
        if (cursor != null) {
          cursor.close();
        }
        return "";
      }
      String displayName = cursor.getString(displayNameIndex);
      if (hasVirtualFlag(cursor)
          && (mimeTypes = contentResolver.getStreamTypes(uri, "*/*")) != null
          && mimeTypes.length > 0
          && (ext = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeTypes[0])) != null) {
        displayName = displayName + "." + ext;
      }
      if (cursor != null) {
        cursor.close();
      }
      return displayName;
    } catch (NullPointerException e) {
      return "";
    }
  }

  public static String maybeGetDisplayName(String uriString) {
    Uri uri = Uri.parse(uriString);
    try {
      String displayName =
          getDisplayName(uri, ContextUtils.getApplicationContext(), "_display_name");
      if (TextUtils.isEmpty(displayName)) {
        return null;
      }
      return displayName;
    } catch (Exception e) {
      Log.w(TAG, "Cannot open content uri: %s", (Object) uriString, (Throwable) e);
      return null;
    }
  }

  private static boolean isVirtualDocument(Uri uri) {
    if (uri == null
        || !DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), uri)) {
      return false;
    }
    ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
    try {
      Cursor cursor = contentResolver.query(uri, null, null, null, null);
      if (cursor != null && cursor.getCount() >= 1) {
        cursor.moveToFirst();
        boolean hasVirtualFlag = hasVirtualFlag(cursor);
        if (cursor != null) {
          cursor.close();
        }
        return hasVirtualFlag;
      }
      if (cursor != null) {
        cursor.close();
      }
      return false;
    } catch (NullPointerException e) {
      return false;
    }
  }

  private static boolean hasVirtualFlag(Cursor cursor) {
    int index = cursor.getColumnIndex("flags");
    return index > -1 && (cursor.getLong(index) & 512) != 0;
  }

  public static boolean isContentUri(String uri) {
    Uri parsedUri;
    return (uri == null
            || (parsedUri = Uri.parse(uri)) == null
            || !"content".equals(parsedUri.getScheme()))
        ? false
        : true;
  }

  public static boolean delete(String uriString) {
    if (!isContentUri(uriString)) {
      throw new AssertionError();
    }
    Uri parsedUri = Uri.parse(uriString);
    ContentResolver resolver = ContextUtils.getApplicationContext().getContentResolver();
    return resolver.delete(parsedUri, null, null) > 0;
  }

  public static String getContentUriFromFilePath(String filePathString) {
    try {
      Uri contentUri = getContentUriFromFile(new File(filePathString));
      if (contentUri != null) {
        return contentUri.toString();
      }
      return null;
    } catch (IllegalArgumentException e) {
      Log.e(
          TAG, "Cannot retrieve content uri from file: %s", (Object) filePathString, (Throwable) e);
      return null;
    }
  }
}
