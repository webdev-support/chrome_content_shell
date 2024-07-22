package org.chromium.ui.dragdrop;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

public class DropDataContentProvider extends ContentProvider {
  private DropDataProviderImpl mDropDataProviderImpl;

  @Override // android.content.ContentProvider
  public boolean onCreate() {
    this.mDropDataProviderImpl = new DropDataProviderImpl();
    return true;
  }

  @Override // android.content.ContentProvider
  public String getType(Uri uri) {
    return this.mDropDataProviderImpl.getType(uri);
  }

  @Override // android.content.ContentProvider
  public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
    return this.mDropDataProviderImpl.getStreamTypes(uri, mimeTypeFilter);
  }

  @Override // android.content.ContentProvider
  public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
    return this.mDropDataProviderImpl.openFile(this, uri);
  }

  @Override // android.content.ContentProvider
  public Cursor query(
      Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
    return this.mDropDataProviderImpl.query(uri, projection);
  }

  @Override // android.content.ContentProvider
  public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
    throw new UnsupportedOperationException();
  }

  @Override // android.content.ContentProvider
  public int delete(Uri uri, String selection, String[] selectionArgs) {
    throw new UnsupportedOperationException();
  }

  @Override // android.content.ContentProvider
  public Uri insert(Uri uri, ContentValues values) {
    throw new UnsupportedOperationException();
  }

  @Override // android.content.ContentProvider
  public Bundle call(String method, String arg, Bundle extras) {
    return this.mDropDataProviderImpl.call(method, arg, extras);
  }

  public void setDropDataProviderImpl(DropDataProviderImpl dropDataProviderImpl) {
    this.mDropDataProviderImpl = dropDataProviderImpl;
  }
}
