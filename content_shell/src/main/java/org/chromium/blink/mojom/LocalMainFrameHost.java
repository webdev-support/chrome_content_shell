package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface LocalMainFrameHost extends Interface {
  public static final Interface.Manager<LocalMainFrameHost, Proxy> MANAGER =
      LocalMainFrameHost_Internal.MANAGER;

  public interface Proxy extends LocalMainFrameHost, Interface.Proxy {}

  public interface SetWindowRect_Response {
    void call();
  }

  public interface ShowCreatedWindow_Response {
    void call();
  }

  public interface UpdateTargetUrl_Response {
    void call();
  }

  void contentsPreferredSizeChanged(Size size);

  void didAccessInitialMainDocument();

  void didFirstVisuallyNonEmptyPaint();

  void focusPage();

  void maximize();

  void minimize();

  void requestClose();

  void restore();

  void scaleFactorChanged(float f);

  void setResizable(boolean z);

  void setWindowRect(Rect rect, SetWindowRect_Response setWindowRect_Response);

  void showCreatedWindow(
      LocalFrameToken localFrameToken,
      int i,
      WindowFeatures windowFeatures,
      boolean z,
      ShowCreatedWindow_Response showCreatedWindow_Response);

  void takeFocus(boolean z);

  void textAutosizerPageInfoChanged(TextAutosizerPageInfo textAutosizerPageInfo);

  void updateTargetUrl(Url url, UpdateTargetUrl_Response updateTargetUrl_Response);
}
