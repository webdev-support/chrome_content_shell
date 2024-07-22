package org.chromium.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.content.res.AppCompatResources;
import com.example.chromium_content_view.R;
import org.chromium.ui.widget.AnchoredPopupWindow;
import org.chromium.ui.widget.RectProvider;
import org.chromium.ui.widget.ViewRectProvider;

class DropdownPopupWindowImpl
    implements AnchoredPopupWindow.LayoutObserver, DropdownPopupWindowInterface {

  ListAdapter mAdapter;
  private final View mAnchorView;
  private AnchoredPopupWindow mAnchoredPopupWindow;
  private Drawable mBackground;
  private final Context mContext;
  private CharSequence mDescription;
  private int mHorizontalPadding;
  private int mInitialSelection;
  private View.OnLayoutChangeListener mLayoutChangeListener;
  private final ListView mListView;
  private boolean mRtl;

  public DropdownPopupWindowImpl(Context context, View anchorView) {
    this(context, anchorView, null);
  }

  public DropdownPopupWindowImpl(
      Context context, View anchorView, RectProvider visibleWebContentsRectProvider) {
    this.mInitialSelection = -1;
    this.mContext = context;
    this.mAnchorView = anchorView;
    anchorView.setId(R.id.dropdown_popup_window);
    anchorView.setTag(this);
    View.OnLayoutChangeListener onLayoutChangeListener =
        new View.OnLayoutChangeListener() {
          @Override
          public void onLayoutChange(
              View v,
              int left,
              int top,
              int right,
              int bottom,
              int oldLeft,
              int oldTop,
              int oldRight,
              int oldBottom) {
            if (v == DropdownPopupWindowImpl.this.mAnchorView) {
              DropdownPopupWindowImpl.this.show();
            }
          }
        };
    this.mLayoutChangeListener = onLayoutChangeListener;
    anchorView.addOnLayoutChangeListener(onLayoutChangeListener);
    PopupWindow.OnDismissListener onDismissLitener =
        new PopupWindow.OnDismissListener() {
          @Override
          public void onDismiss() {
            DropdownPopupWindowImpl.this.mAnchoredPopupWindow.dismiss();
            DropdownPopupWindowImpl.this.mAnchorView.removeOnLayoutChangeListener(
                DropdownPopupWindowImpl.this.mLayoutChangeListener);
            DropdownPopupWindowImpl.this.mAnchorView.setTag(null);
          }
        };
    ListView listView = new ListView(context);
    this.mListView = listView;
    ViewRectProvider rectProvider = new ViewRectProvider(anchorView);
    rectProvider.setIncludePadding(true);
    this.mBackground = AppCompatResources.getDrawable(context, R.drawable.menu_bg_baseline);
    AnchoredPopupWindow anchoredPopupWindow =
        new AnchoredPopupWindow(
            context,
            anchorView,
            this.mBackground,
            listView,
            rectProvider,
            visibleWebContentsRectProvider);
    this.mAnchoredPopupWindow = anchoredPopupWindow;
    anchoredPopupWindow.addOnDismissListener(onDismissLitener);
    this.mAnchoredPopupWindow.setLayoutObserver(this);
    this.mAnchoredPopupWindow.setElevation(
        context.getResources().getDimensionPixelSize(R.dimen.dropdown_elevation));
    Rect paddingRect = new Rect();
    this.mBackground.getPadding(paddingRect);
    rectProvider.setInsetPx(0, paddingRect.bottom, 0, paddingRect.top);
    this.mHorizontalPadding = paddingRect.right + paddingRect.left;
    this.mAnchoredPopupWindow.setPreferredHorizontalOrientation(1);
    this.mAnchoredPopupWindow.setUpdateOrientationOnChange(true);
    this.mAnchoredPopupWindow.setOutsideTouchable(true);
  }

  @Override
  public void setAdapter(ListAdapter adapter) {
    this.mAdapter = adapter;
    this.mListView.setAdapter(adapter);
    this.mAnchoredPopupWindow.onRectChanged();
  }

  @Override
  public void onPreLayoutChange(
      boolean positionBelow, int x, int y, int width, int height, Rect anchorRect) {
    this.mBackground.setBounds(anchorRect);
    this.mAnchoredPopupWindow.setBackgroundDrawable(
        AppCompatResources.getDrawable(this.mContext, R.drawable.menu_bg_baseline));
  }

  @Override
  public void setInitialSelection(int initialSelection) {
    this.mInitialSelection = initialSelection;
  }

  @Override
  public void show() {
    if (this.mAdapter == null) {
      throw new AssertionError("Set the adapter before showing the popup.");
    }
    boolean wasShowing = this.mAnchoredPopupWindow.isShowing();
    this.mAnchoredPopupWindow.setVerticalOverlapAnchor(false);
    this.mAnchoredPopupWindow.setHorizontalOverlapAnchor(true);
    int windowWidthPx = this.mContext.getResources().getDisplayMetrics().widthPixels;
    int contentWidth = measureContentWidth();
    int i = this.mHorizontalPadding;
    if (windowWidthPx < contentWidth + i) {
      this.mAnchoredPopupWindow.setMaxWidth(windowWidthPx - i);
    } else if (this.mAnchorView.getWidth() < contentWidth) {
      this.mAnchoredPopupWindow.setMaxWidth(this.mHorizontalPadding + contentWidth);
    } else {
      this.mAnchoredPopupWindow.setMaxWidth(this.mAnchorView.getWidth() + this.mHorizontalPadding);
    }
    this.mAnchoredPopupWindow.show();
    this.mListView.setDividerHeight(0);
    boolean z = this.mRtl;
    ListView listView = this.mListView;
    int layoutDirection = z ? 1 : 0;
    listView.setLayoutDirection(layoutDirection);
    if (!wasShowing) {
      this.mListView.setContentDescription(this.mDescription);
      this.mListView.sendAccessibilityEvent(32);
    }
    int i2 = this.mInitialSelection;
    if (i2 >= 0) {
      this.mListView.setSelection(i2);
      this.mInitialSelection = -1;
    }
  }

  @Override
  public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
    this.mAnchoredPopupWindow.addOnDismissListener(listener);
  }

  @Override
  public void setRtl(boolean isRtl) {
    this.mRtl = isRtl;
  }

  @Override
  public void disableHideOnOutsideTap() {
    this.mAnchoredPopupWindow.setDismissOnTouchInteraction(false);
  }

  @Override
  public void setContentDescriptionForAccessibility(CharSequence description) {
    this.mDescription = description;
  }

  @Override
  public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
    this.mListView.setOnItemClickListener(clickListener);
  }

  @Override
  public void postShow() {
    this.mAnchoredPopupWindow.show();
  }

  @Override
  public void dismiss() {
    this.mAnchoredPopupWindow.dismiss();
  }

  @Override
  public ListView getListView() {
    return this.mListView;
  }

  @Override
  public boolean isShowing() {
    return this.mAnchoredPopupWindow.isShowing();
  }

  private int measureContentWidth() {
    ListAdapter listAdapter = this.mAdapter;
    if (listAdapter == null) {
      throw new AssertionError("Set the adapter before showing the popup.");
    }
    return UiUtils.computeListAdapterContentDimensions(listAdapter, null)[0];
  }
}
