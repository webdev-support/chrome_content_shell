package org.chromium.services.media_session;

import android.text.TextUtils;
import org.jni_zero.JNINamespace;

@JNINamespace("media_session")
public final class MediaMetadata {
  private String mAlbum;
  private String mArtist;
  private String mTitle;

  public String getTitle() {
    return this.mTitle;
  }

  public String getArtist() {
    return this.mArtist;
  }

  public String getAlbum() {
    return this.mAlbum;
  }

  public void setTitle(String title) {
    this.mTitle = title;
  }

  public void setArtist(String artist) {
    this.mArtist = artist;
  }

  public void setAlbum(String album) {
    this.mAlbum = album;
  }

  private static MediaMetadata create(String title, String artist, String album) {
    return new MediaMetadata(title, artist, album);
  }

  public MediaMetadata(String title, String artist, String album) {
    this.mTitle = title;
    this.mArtist = artist;
    this.mAlbum = album;
  }

  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof MediaMetadata) {
      MediaMetadata other = (MediaMetadata) obj;
      return TextUtils.equals(this.mTitle, other.mTitle)
          && TextUtils.equals(this.mArtist, other.mArtist)
          && TextUtils.equals(this.mAlbum, other.mAlbum);
    }
    return false;
  }

  public int hashCode() {
    int result = this.mTitle.hashCode();
    return (((result * 31) + this.mArtist.hashCode()) * 31) + this.mAlbum.hashCode();
  }
}
