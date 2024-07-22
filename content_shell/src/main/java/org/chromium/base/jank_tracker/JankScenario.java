package org.chromium.base.jank_tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public class JankScenario {
  private final long mId;
  private final int mType;
  public static final JankScenario PERIODIC_REPORTING = new JankScenario(1, -1);
  public static final JankScenario OMNIBOX_FOCUS = new JankScenario(2, -1);
  public static final JankScenario NEW_TAB_PAGE = new JankScenario(3, -1);
  public static final JankScenario STARTUP = new JankScenario(4, -1);
  public static final JankScenario TAB_SWITCHER = new JankScenario(5, -1);
  public static final JankScenario OPEN_LINK_IN_NEW_TAB = new JankScenario(6, -1);
  public static final JankScenario START_SURFACE_HOMEPAGE = new JankScenario(7, -1);
  public static final JankScenario START_SURFACE_TAB_SWITCHER = new JankScenario(8, -1);
  public static final JankScenario FEED_SCROLLING = new JankScenario(9, -1);
  public static final JankScenario WEBVIEW_SCROLLING = new JankScenario(10, -1);

  @Retention(RetentionPolicy.SOURCE)
  public @interface Type {
    public static final int FEED_SCROLLING = 9;
    public static final int NEW_TAB_PAGE = 3;
    public static final int OMNIBOX_FOCUS = 2;
    public static final int OPEN_LINK_IN_NEW_TAB = 6;
    public static final int PERIODIC_REPORTING = 1;
    public static final int STARTUP = 4;
    public static final int START_SURFACE_HOMEPAGE = 7;
    public static final int START_SURFACE_TAB_SWITCHER = 8;
    public static final int TAB_SWITCHER = 5;
    public static final int WEBVIEW_SCROLLING = 10;
  }

  public JankScenario(int type, long id) {
    this.mType = type;
    this.mId = id;
  }

  public int type() {
    return this.mType;
  }

  public long m500id() {
    return this.mId;
  }

  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof JankScenario)) {
      return false;
    }
    JankScenario other = (JankScenario) obj;
    return this.mType == other.type() && this.mId == other.m500id();
  }

  public int hashCode() {
    return Objects.hash(Integer.valueOf(this.mType), Long.valueOf(this.mId));
  }
}
