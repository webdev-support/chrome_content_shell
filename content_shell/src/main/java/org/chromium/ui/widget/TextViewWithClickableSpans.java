package org.chromium.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import org.chromium.ui.accessibility.AccessibilityState;

public class TextViewWithClickableSpans extends TextViewWithLeading
    implements View.OnLongClickListener {

  private PopupMenu mDisambiguationMenu;

  public TextViewWithClickableSpans(Context context) {
    super(context);
    init();
  }

  public TextViewWithClickableSpans(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    setSaveEnabled(false);
    setOnLongClickListener(this);
  }

  @Override
  public boolean onLongClick(View v) {
    if (v != this) {
      throw new AssertionError();
    }
    if (!AccessibilityState.isTouchExplorationEnabled()) {
      return false;
    }
    openDisambiguationMenu();
    return true;
  }

  @Override // android.view.View
  public final void setOnLongClickListener(OnLongClickListener listener) {
    if (listener != this && listener != null) {
      throw new AssertionError();
    }
    super.setOnLongClickListener(listener);
  }

  @Override // android.view.View
  public boolean performAccessibilityAction(int action, Bundle arguments) {
    if (action == 16) {
      handleAccessibilityClick();
      return true;
    }
    return super.performAccessibilityAction(action, arguments);
  }

  @Override // android.widget.TextView, android.view.View
  public boolean onTouchEvent(MotionEvent event) {
    boolean superResult = super.onTouchEvent(event);
    if (event.getAction() != 1
        && AccessibilityState.isTouchExplorationEnabled()
        && !touchIntersectsAnyClickableSpans(event)) {
      handleAccessibilityClick();
      return true;
    }
    return superResult;
  }

  protected boolean touchIntersectsAnyClickableSpans(MotionEvent event) {
    CharSequence text = getText();
    if (text instanceof SpannableString) {
      SpannableString spannable = (SpannableString) text;
      int x = (int) event.getX();
      int y = (int) event.getY();
      int x2 = x - getTotalPaddingLeft();
      int y2 = y - getTotalPaddingTop();
      int x3 = x2 + getScrollX();
      int y3 = y2 + getScrollY();
      Layout layout = getLayout();
      int line = layout.getLineForVertical(y3);
      int off = layout.getOffsetForHorizontal(line, x3);
      ClickableSpan[] clickableSpans =
          (ClickableSpan[]) spannable.getSpans(off, off, ClickableSpan.class);
      return clickableSpans.length > 0;
    }
    return false;
  }

  public ClickableSpan[] getClickableSpans() {
    CharSequence text = getText();
    if (text instanceof SpannableString) {
      SpannableString spannable = (SpannableString) text;
      return (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
    }
    return null;
  }

  private void handleAccessibilityClick() {
    ClickableSpan[] clickableSpans = getClickableSpans();
    if (clickableSpans == null || clickableSpans.length == 0) {
      return;
    }
    if (clickableSpans.length == 1) {
      clickableSpans[0].onClick(this);
    } else {
      openDisambiguationMenu();
    }
  }

  private void openDisambiguationMenu() {
    ClickableSpan[] clickableSpans = getClickableSpans();
    if (clickableSpans == null || clickableSpans.length == 0 || this.mDisambiguationMenu != null) {
      return;
    }
    SpannableString spannable = (SpannableString) getText();
    PopupMenu popupMenu = new PopupMenu(getContext(), this);
    this.mDisambiguationMenu = popupMenu;
    Menu menu = popupMenu.getMenu();
    for (final ClickableSpan clickableSpan : clickableSpans) {
      CharSequence itemText =
          spannable.subSequence(
              spannable.getSpanStart(clickableSpan), spannable.getSpanEnd(clickableSpan));
      MenuItem menuItem = menu.add(itemText);
      menuItem.setOnMenuItemClickListener(
          new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem menuItem2) {
              clickableSpan.onClick(TextViewWithClickableSpans.this);
              return true;
            }
          });
    }
    this.mDisambiguationMenu.setOnDismissListener(
        new PopupMenu.OnDismissListener() {

          @Override
          public void onDismiss(PopupMenu menu2) {
            TextViewWithClickableSpans.this.mDisambiguationMenu = null;
          }
        });
    this.mDisambiguationMenu.show();
  }
}
