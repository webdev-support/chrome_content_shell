package org.chromium.ui.animation;

import android.view.animation.Animation;

public interface EmptyAnimationListener extends Animation.AnimationListener {
  @Override // android.view.animation.Animation.AnimationListener
  default void onAnimationStart(Animation animation) {}

  @Override // android.view.animation.Animation.AnimationListener
  default void onAnimationEnd(Animation animation) {}

  @Override // android.view.animation.Animation.AnimationListener
  default void onAnimationRepeat(Animation animation) {}
}
