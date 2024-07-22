package org.chromium.content.browser.accessibility;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
  ScrollDirection.FORWARD,
  ScrollDirection.BACKWARD,
  ScrollDirection.UP,
  ScrollDirection.DOWN,
  ScrollDirection.LEFT,
  ScrollDirection.RIGHT
})
@Retention(RetentionPolicy.SOURCE)
public @interface ScrollDirection {
  int FORWARD = 0;
  int BACKWARD = 1;
  int UP = 2;
  int DOWN = 3;
  int LEFT = 4;
  int RIGHT = 5;
}
