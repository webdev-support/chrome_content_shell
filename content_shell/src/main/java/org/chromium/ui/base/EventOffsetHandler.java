package org.chromium.ui.base;

import android.view.MotionEvent;

public class EventOffsetHandler {
  private final EventOffsetHandlerDelegate mDelegate;

  public interface EventOffsetHandlerDelegate {
    float getTop();

    void setCurrentDragEventOffsets(float f, float f2);

    void setCurrentTouchEventOffsets(float f);
  }

  public EventOffsetHandler(EventOffsetHandlerDelegate delegate) {
    this.mDelegate = delegate;
  }

  public void onPreDispatchDragEvent(int action, float dx, float dy) {
    setTouchEventOffsets(-this.mDelegate.getTop());
    setDragEventOffsets(dx, dy);
  }

  public void onPostDispatchDragEvent(int action) {
    if (action == 6 || action == 4 || action == 3) {
      setTouchEventOffsets(0.0f);
      setDragEventOffsets(0.0f, 0.0f);
    }
  }

  public void onInterceptTouchEvent(MotionEvent e) {
    setContentViewMotionEventOffsets(e, false);
  }

  public void onTouchEvent(MotionEvent e) {
    setContentViewMotionEventOffsets(e, true);
  }

  public void onInterceptHoverEvent(MotionEvent e) {
    setContentViewMotionEventOffsets(e, true);
  }

  public void onHoverEvent(MotionEvent e) {
    setContentViewMotionEventOffsets(e, true);
  }

  private void setContentViewMotionEventOffsets(MotionEvent e, boolean canClear) {
    int actionMasked = SPenSupport.convertSPenEventAction(e.getActionMasked());
    if (actionMasked == 0 || actionMasked == 9 || actionMasked == 7) {
      setTouchEventOffsets(-this.mDelegate.getTop());
    } else if (canClear) {
      if (actionMasked == 1 || actionMasked == 3 || actionMasked == 10) {
        setTouchEventOffsets(0.0f);
      }
    }
  }

  private void setTouchEventOffsets(float y) {
    this.mDelegate.setCurrentTouchEventOffsets(y);
  }

  private void setDragEventOffsets(float dx, float dy) {
    this.mDelegate.setCurrentDragEventOffsets(dx, dy);
  }
}
