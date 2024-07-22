package org.chromium.ui.widget;

import android.graphics.Rect;

public class RectProvider {

  private Observer mObserver;
  protected final Rect mRect;

  public interface Observer {
    void onRectChanged();

    void onRectHidden();
  }

  public RectProvider() {
    this.mRect = new Rect();
  }

  public RectProvider(Rect rect) {
    Rect rect2 = new Rect();
    this.mRect = rect2;
    rect2.set(rect);
  }

  public void setRect(Rect rect) {
    this.mRect.set(rect);
    notifyRectChanged();
  }

  public void startObserving(Observer observer) {
    Observer observer2 = this.mObserver;
    if (observer2 != null && observer2 != observer) {
      throw new AssertionError();
    }
    this.mObserver = observer;
  }

  public void stopObserving() {
    this.mObserver = null;
  }

  public Rect getRect() {
    return this.mRect;
  }

  public void notifyRectChanged() {
    Observer observer = this.mObserver;
    if (observer != null) {
      observer.onRectChanged();
    }
  }

  public void notifyRectHidden() {
    Observer observer = this.mObserver;
    if (observer != null) {
      observer.onRectHidden();
    }
  }
}
