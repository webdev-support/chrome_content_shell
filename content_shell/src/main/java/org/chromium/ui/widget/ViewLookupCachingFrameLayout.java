package org.chromium.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.example.chromium_content_view.BuildConfig;
import java.lang.ref.WeakReference;

public class ViewLookupCachingFrameLayout extends OptimizedFrameLayout {

  private final SparseArray<WeakReference<View>> mCachedViews;
  final OnHierarchyChangeListener mListener;

  public ViewLookupCachingFrameLayout(Context context, AttributeSet atts) {
    super(context, atts);
    this.mCachedViews = new SparseArray<>();
    OnHierarchyChangeListener onHierarchyChangeListener =
        new OnHierarchyChangeListener() {
          @Override
          public void onChildViewAdded(View parent, View child) {
            ViewLookupCachingFrameLayout.this.mCachedViews.remove(child.getId());
            ViewLookupCachingFrameLayout.this.setHierarchyListenerOnTree(child, this);
          }

          @Override
          public void onChildViewRemoved(View parent, View child) {
            ViewLookupCachingFrameLayout.this.mCachedViews.remove(child.getId());
            ViewLookupCachingFrameLayout.this.setHierarchyListenerOnTree(child, null);
          }
        };
    this.mListener = onHierarchyChangeListener;
    setOnHierarchyChangeListener(onHierarchyChangeListener);
  }

  @Override
  public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
    if (listener != this.mListener) {
      throw new AssertionError("Hierarchy change listeners cannot be set for this group!");
    }
    super.setOnHierarchyChangeListener(listener);
  }

  public void setHierarchyListenerOnTree(View view, OnHierarchyChangeListener listener) {
    if (view instanceof ViewGroup) {
      ViewGroup group = (ViewGroup) view;
      group.setOnHierarchyChangeListener(listener);
      for (int i = 0; i < group.getChildCount(); i++) {
        setHierarchyListenerOnTree(group.getChildAt(i), listener);
      }
    }
  }

  public View fastFindViewById(int id) {
    WeakReference<View> ref = this.mCachedViews.get(id);
    View view = null;
    if (ref != null) {
      View view2 = ref.get();
      view = view2;
    }
    if (view == null) {
      view = findViewById(id);
    }
    if (BuildConfig.ENABLE_ASSERTS) {
      if (view != findViewById(id)) {
        throw new AssertionError("View caching logic is broken!");
      }
      if (ref != null && ref.get() == null) {
        throw new AssertionError("Cache held reference to garbage collected view!");
      }
    }
    if (view != null) {
      this.mCachedViews.put(id, new WeakReference<>(view));
    }
    return view;
  }

  SparseArray<WeakReference<View>> getCache() {
    return this.mCachedViews;
  }
}
