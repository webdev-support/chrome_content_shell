package org.chromium.blink.mojom;

import org.chromium.ax.mojom.AxActionData;
import org.chromium.ax.mojom.AxMode;
import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.Interface;

public interface RenderAccessibility extends Interface {
  public static final Interface.Manager<RenderAccessibility, Proxy> MANAGER =
      RenderAccessibility_Internal.MANAGER;

  public interface HitTest_Response {
    void call(HitTestResponse hitTestResponse);
  }

  public interface Proxy extends RenderAccessibility, Interface.Proxy {}

  void fatalError();

  void hitTest(Point point, int i, int i2, HitTest_Response hitTest_Response);

  void performAction(AxActionData axActionData);

  void reset(int i);

  void setMode(AxMode axMode, int i);
}
