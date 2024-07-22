package org.chromium.ui.dragdrop;

import android.util.SparseBooleanArray;
import android.view.DragEvent;
import android.view.View;

public class DragEventDispatchHelper implements View.OnDragListener {
  static final int[] ALL_DRAG_ACTIONS = {1, 2, 3, 4, 5, 6};
  private final DragEventDispatchDestination mDestinationView;
  private final View mSourceView;
  private final SparseBooleanArray mSupportedActionsMask;

  public interface DragEventDispatchDestination {
    boolean onDragEventWithOffset(DragEvent dragEvent, int i, int i2);

    View view();

    static DragEventDispatchDestination from(View view) {
      if (view instanceof DragEventDispatchDestination) {
        return (DragEventDispatchDestination) view;
      }
      return null;
    }
  }

  public DragEventDispatchHelper(View sourceView, DragEventDispatchDestination destination) {
    int[] iArr = ALL_DRAG_ACTIONS;
    this.mSupportedActionsMask = new SparseBooleanArray(iArr.length);
    this.mSourceView = sourceView;
    this.mDestinationView = destination;
    sourceView.setOnDragListener(this);
    for (int action : iArr) {
      boolean supported = true;
      if (action == 1 || action == 4) {
        supported = false;
      }
      markActionSupported(action, supported);
    }
  }

  public void stop() {
    this.mSourceView.setOnDragListener(null);
  }

  @Override // android.view.View.OnDragListener
  public boolean onDrag(View v, DragEvent event) {
    boolean isDragStart = event.getAction() == 1;
    View destinationView = this.mDestinationView.view();
    if (destinationView == null
        || !destinationView.isEnabled()
        || !destinationView.isAttachedToWindow()
        || !isActionSupported(event.getAction())) {
      return isDragStart;
    }
    if (event.getAction() == 5 || event.getAction() == 6 || event.getAction() == 4) {
      return this.mDestinationView.onDragEventWithOffset(event, 0, 0) || isDragStart;
    }
    int[] sourceLocation = new int[2];
    this.mSourceView.getLocationOnScreen(sourceLocation);
    int[] destLocation = new int[2];
    destinationView.getLocationOnScreen(destLocation);
    int dx = sourceLocation[0] - destLocation[0];
    int dy = sourceLocation[1] - destLocation[1];
    return this.mDestinationView.onDragEventWithOffset(event, dx, dy) || isDragStart;
  }

  void markActionSupported(int action, boolean supported) {
    this.mSupportedActionsMask.put(action, supported);
  }

  boolean isActionSupported(int action) {
    return this.mSupportedActionsMask.get(action);
  }
}
