package org.chromium.ui.widget;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import com.example.chromium_content_view.R;

public class ButtonCompat extends AppCompatButton {
  private RippleBackgroundHelper mRippleBackgroundHelper;

  public ButtonCompat(Context context, int themeOverlay) {
    this(context, null, themeOverlay);
  }

  public ButtonCompat(Context context, AttributeSet attrs) {
    this(context, attrs, R.style.FilledButtonThemeOverlay);
  }

  private ButtonCompat(Context context, AttributeSet attrs, int themeOverlay) {
    super(new ContextThemeWrapper(context, themeOverlay), attrs, 16842824);
    int rippleColorId;
    boolean isBgTransparent;
    int rippleColorId2;
    TypedArray a =
        getContext().obtainStyledAttributes(attrs, R.styleable.ButtonCompat, 16842824, 0);
    int buttonColorId =
        a.getResourceId(R.styleable.ButtonCompat_buttonColor, R.color.blue_when_enabled_list);
    int rippleColorId3 = a.getResourceId(R.styleable.ButtonCompat_rippleColor, -1);
    if (rippleColorId3 != -1) {
      rippleColorId = rippleColorId3;
    } else {
      if (getContext().getColor(buttonColorId) != 0) {
        isBgTransparent = false;
      } else {
        isBgTransparent = true;
      }
      if (isBgTransparent) {
        rippleColorId2 = R.color.text_button_ripple_color_list_baseline;
      } else {
        rippleColorId2 = R.color.filled_button_ripple_color;
      }
      rippleColorId = rippleColorId2;
    }
    int borderColorId = a.getResourceId(R.styleable.ButtonCompat_borderColor, 17170445);
    int borderWidthId =
        a.getResourceId(
            R.styleable.ButtonCompat_borderWidth, R.dimen.default_ripple_background_border_size);
    boolean buttonRaised = a.getBoolean(R.styleable.ButtonCompat_buttonRaised, true);
    int verticalInset =
        a.getDimensionPixelSize(
            R.styleable.ButtonCompat_verticalInset,
            getResources().getDimensionPixelSize(R.dimen.button_bg_vertical_inset));
    int defaultRadius = getResources().getDimensionPixelSize(R.dimen.button_compat_corner_radius);
    int topStartRippleRadius =
        a.getDimensionPixelSize(R.styleable.ButtonCompat_rippleCornerRadiusTopStart, defaultRadius);
    int topEndRippleRadius =
        a.getDimensionPixelSize(R.styleable.ButtonCompat_rippleCornerRadiusTopEnd, defaultRadius);
    int bottomStartRippleRadius =
        a.getDimensionPixelSize(
            R.styleable.ButtonCompat_rippleCornerRadiusBottomStart, defaultRadius);
    int bottomEndRippleRadius =
        a.getDimensionPixelSize(
            R.styleable.ButtonCompat_rippleCornerRadiusBottomEnd, defaultRadius);
    int textColorRes = a.getResourceId(R.styleable.ButtonCompat_buttonTextColor, -1);
    if (textColorRes != -1) {
      setTextColor(AppCompatResources.getColorStateList(getContext(), textColorRes));
    }
    float[] radii =
        getLayoutDirection() == 1
            ? new float[] {
              topEndRippleRadius,
              topEndRippleRadius,
              topStartRippleRadius,
              topStartRippleRadius,
              bottomStartRippleRadius,
              bottomStartRippleRadius,
              bottomEndRippleRadius,
              bottomEndRippleRadius
            }
            : new float[] {
              topStartRippleRadius,
              topStartRippleRadius,
              topEndRippleRadius,
              topEndRippleRadius,
              bottomEndRippleRadius,
              bottomEndRippleRadius,
              bottomStartRippleRadius,
              bottomStartRippleRadius
            };
    a.recycle();
    this.mRippleBackgroundHelper =
        new RippleBackgroundHelper(
            this, buttonColorId, rippleColorId, radii, borderColorId, borderWidthId, verticalInset);
    setRaised(buttonRaised);
  }

  public void setButtonColor(ColorStateList buttonColorList) {
    this.mRippleBackgroundHelper.setBackgroundColor(buttonColorList);
  }

  private void setRaised(boolean raised) {
    if (raised) {
      TypedArray a = getContext().obtainStyledAttributes(null, new int[] {16843848}, 0, 16974424);
      int stateListAnimatorId = a.getResourceId(0, 0);
      a.recycle();
      StateListAnimator stateListAnimator = null;
      if (stateListAnimatorId != 0) {
        stateListAnimator =
            AnimatorInflater.loadStateListAnimator(getContext(), stateListAnimatorId);
      }
      setStateListAnimator(stateListAnimator);
      return;
    }
    setElevation(0.0f);
    setStateListAnimator(null);
  }
}
