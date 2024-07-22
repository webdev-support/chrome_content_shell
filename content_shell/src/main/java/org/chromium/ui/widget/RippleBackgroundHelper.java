package org.chromium.ui.widget;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.StateSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import com.example.chromium_content_view.R;

public class RippleBackgroundHelper {
  private static final int[] STATE_SET_PRESSED = {16842919};
  private static final int[] STATE_SET_SELECTED = {16842913};
  private static final int[] STATE_SET_SELECTED_PRESSED = {16842913, 16842919};
  private ColorStateList mBackgroundColorList;
  private GradientDrawable mBackgroundGradient;
  private LayerDrawable mBackgroundLayerDrawable;
  private ColorStateList mStateLayerColorList;
  private GradientDrawable mStateLayerGradient;
  private final View mView;

  RippleBackgroundHelper(
      View view,
      int backgroundColorResId,
      int rippleColorResId,
      int cornerRadius,
      int verticalInset) {
    this(
        view,
        backgroundColorResId,
        rippleColorResId,
        cornerRadius,
        17170445,
        R.dimen.default_ripple_background_border_size,
        verticalInset);
  }

  RippleBackgroundHelper(
      View view,
      int backgroundColorResId,
      int rippleColorResId,
      float[] cornerRadii,
      int verticalInset) {
    this(
        view,
        backgroundColorResId,
        rippleColorResId,
        cornerRadii,
        17170445,
        R.dimen.default_ripple_background_border_size,
        verticalInset);
  }

  RippleBackgroundHelper(
      View view,
      int backgroundColorResId,
      int rippleColorResId,
      int cornerRadius,
      int borderColorResId,
      int borderSizeDimenId,
      int verticalInset) {
    this(
        view,
        backgroundColorResId,
        rippleColorResId,
        new float[] {
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius
        },
        borderColorResId,
        borderSizeDimenId,
        verticalInset);
  }

  public RippleBackgroundHelper(
      View view,
      int backgroundColorResId,
      int stateLayerColorResId,
      int rippleColorResId,
      int cornerRadius,
      int borderColorResId,
      int borderSizeDimenId,
      int verticalInset) {
    this(
        view,
        backgroundColorResId,
        rippleColorResId,
        cornerRadius,
        borderColorResId,
        borderSizeDimenId,
        verticalInset);
    setStateLayerColor(
        AppCompatResources.getColorStateList(view.getContext(), stateLayerColorResId));
  }

  public RippleBackgroundHelper(
      View view,
      int backgroundColorResId,
      int rippleColorResId,
      float[] cornerRadii,
      int borderColorResId,
      int borderSizeDimenId,
      int verticalInset) {
    this.mView = view;
    view.setBackground(
        createBackgroundDrawable(
            AppCompatResources.getColorStateList(view.getContext(), rippleColorResId),
            AppCompatResources.getColorStateList(view.getContext(), borderColorResId),
            view.getResources().getDimensionPixelSize(borderSizeDimenId),
            cornerRadii,
            verticalInset));
    setBackgroundColor(
        AppCompatResources.getColorStateList(view.getContext(), backgroundColorResId));
  }

  private Drawable createBackgroundDrawable(
      ColorStateList rippleColorList,
      ColorStateList borderColorList,
      int borderSize,
      float[] cornerRadii,
      int verticalInset) {
    GradientDrawable gradientDrawable = new GradientDrawable();
    this.mBackgroundGradient = gradientDrawable;
    gradientDrawable.setCornerRadii(cornerRadii);
    if (borderSize > 0) {
      this.mBackgroundGradient.setStroke(borderSize, borderColorList);
    }
    GradientDrawable gradientDrawable2 = new GradientDrawable();
    this.mStateLayerGradient = gradientDrawable2;
    gradientDrawable2.setCornerRadii(cornerRadii);
    this.mStateLayerGradient.setStroke(borderSize, 0);
    this.mBackgroundLayerDrawable =
        new LayerDrawable(new Drawable[] {this.mBackgroundGradient, this.mStateLayerGradient});
    GradientDrawable mask = new GradientDrawable();
    mask.setCornerRadii(cornerRadii);
    mask.setColor(-1);
    return new RippleDrawable(
        convertToRippleDrawableColorList(rippleColorList),
        wrapDrawableWithInsets(this.mBackgroundLayerDrawable, verticalInset),
        mask);
  }

  private Drawable createBackgroundDrawable(
      ColorStateList rippleColorList,
      ColorStateList borderColorList,
      int borderSize,
      int cornerRadius,
      int verticalInset) {
    return createBackgroundDrawable(
        rippleColorList,
        borderColorList,
        borderSize,
        new float[] {
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius,
          cornerRadius
        },
        verticalInset);
  }

  private static Drawable wrapDrawableWithInsets(Drawable drawable, int verticalInset) {
    return verticalInset == 0
        ? drawable
        : new InsetDrawable(drawable, 0, verticalInset, 0, verticalInset);
  }

  public void setBackgroundColor(ColorStateList color) {
    if (color == this.mBackgroundColorList) {
      return;
    }
    this.mBackgroundColorList = color;
    this.mBackgroundGradient.setColor(color);
  }

  void setStateLayerColor(ColorStateList color) {
    if (color == this.mStateLayerColorList) {
      return;
    }
    this.mStateLayerColorList = color;
    this.mStateLayerGradient.setColor(color);
  }

  public void setBackgroundColor(int color) {
    this.mBackgroundGradient.setColor(color);
  }

  public void setBorder(int width, int color) {
    this.mBackgroundGradient.setStroke(width, color);
  }

  private static int getColorForState(ColorStateList colorStateList, int[] states) {
    return colorStateList.getColorForState(states, colorStateList.getDefaultColor());
  }

  private static int doubleAlpha(int color) {
    int alpha = Math.min(Color.alpha(color) * 2, 255);
    return ColorUtils.setAlphaComponent(color, alpha);
  }

  private static ColorStateList convertToRippleDrawableColorList(ColorStateList colorStateList) {
    return new ColorStateList(
        new int[][] {STATE_SET_SELECTED, StateSet.NOTHING},
        new int[] {
          doubleAlpha(getColorForState(colorStateList, STATE_SET_SELECTED_PRESSED)),
          doubleAlpha(getColorForState(colorStateList, STATE_SET_PRESSED))
        });
  }
}
