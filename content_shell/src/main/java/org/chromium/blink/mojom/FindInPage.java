package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.bindings.Interface;

public interface FindInPage extends Interface {
  public static final Interface.Manager<FindInPage, Proxy> MANAGER = FindInPage_Internal.MANAGER;

  public interface FindMatchRects_Response {
    void call(int i, RectF[] rectFArr, RectF rectF);
  }

  public interface GetNearestFindResult_Response {
    void call(float f);
  }

  public interface Proxy extends FindInPage, Interface.Proxy {}

  void activateNearestFindResult(int i, PointF pointF);

  void clearActiveFindMatch();

  void find(int i, String str, FindOptions findOptions);

  void findMatchRects(int i, FindMatchRects_Response findMatchRects_Response);

  void getNearestFindResult(
      PointF pointF, GetNearestFindResult_Response getNearestFindResult_Response);

  void setClient(FindInPageClient findInPageClient);

  void stopFinding(int i);
}
