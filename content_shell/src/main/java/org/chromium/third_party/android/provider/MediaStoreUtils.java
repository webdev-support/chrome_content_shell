package org.chromium.third_party.android.provider;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Objects;

public class MediaStoreUtils {
  private static final String TAG = "MediaStoreUtils";

  public static Uri createPending(Context context, PendingParams params) {
    return context.getContentResolver().insert(params.mInsertUri, params.mInsertValues);
  }

  public static PendingSession openPending(Context context, Uri uri) {
    return new PendingSession(context, uri);
  }

  public static class PendingParams {
    final Uri mInsertUri;
    final ContentValues mInsertValues;

    public PendingParams(Uri insertUri, String displayName, String mimeType) {
      this.mInsertUri = (Uri) Objects.requireNonNull(insertUri);
      long now = System.currentTimeMillis() / 1000;
      ContentValues contentValues = new ContentValues();
      this.mInsertValues = contentValues;
      contentValues.put("_display_name", (String) Objects.requireNonNull(displayName));
      contentValues.put("mime_type", (String) Objects.requireNonNull(mimeType));
      contentValues.put("date_added", Long.valueOf(now));
      contentValues.put("date_modified", Long.valueOf(now));
      try {
        MediaStoreUtils.setPendingContentValues(contentValues, true);
      } catch (Exception e) {
        Log.e(MediaStoreUtils.TAG, "Unable to set pending content values.", e);
      }
    }

    public void setDownloadUri(Uri downloadUri) {
      if (downloadUri == null) {
        this.mInsertValues.remove("download_uri");
      } else {
        this.mInsertValues.put("download_uri", downloadUri.toString());
      }
    }

    public void setRefererUri(Uri refererUri) {
      if (refererUri == null) {
        this.mInsertValues.remove("referer_uri");
      } else {
        this.mInsertValues.put("referer_uri", refererUri.toString());
      }
    }

    public void setExpirationTime(long time) {
      this.mInsertValues.put("date_expires", Long.valueOf(time));
    }
  }

  public static class PendingSession implements AutoCloseable {
    private final Context mContext;
    private final Uri mUri;

    PendingSession(Context context, Uri uri) {
      this.mContext = (Context) Objects.requireNonNull(context);
      this.mUri = (Uri) Objects.requireNonNull(uri);
    }

    public ParcelFileDescriptor open() throws FileNotFoundException {
      return this.mContext.getContentResolver().openFileDescriptor(this.mUri, "rw");
    }

    public OutputStream openOutputStream() throws FileNotFoundException {
      return this.mContext.getContentResolver().openOutputStream(this.mUri);
    }

    public Uri publish() {
      try {
        ContentValues values = new ContentValues();
        MediaStoreUtils.setPendingContentValues(values, false);
        values.putNull("date_expires");
        this.mContext.getContentResolver().update(this.mUri, values, null, null);
      } catch (Exception e) {
        Log.e(MediaStoreUtils.TAG, "Unable to publish pending session.", e);
      }
      return this.mUri;
    }

    public void abandon() {
      try {
        this.mContext.getContentResolver().delete(this.mUri, null, null);
      } catch (Exception e) {
        Log.e(MediaStoreUtils.TAG, "Unable to delete pending session.", e);
      }
    }

    @Override     public void close() {}
  }

  public static void setPendingContentValues(ContentValues values, boolean isPending)
      throws Exception {
    values.put("is_pending", Integer.valueOf(isPending ? 1 : 0));
  }
}
