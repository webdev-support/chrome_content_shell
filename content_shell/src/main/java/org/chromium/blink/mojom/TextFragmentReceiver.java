package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;

public interface TextFragmentReceiver extends Interface {
  public static final Interface.Manager<TextFragmentReceiver, Proxy> MANAGER =
      TextFragmentReceiver_Internal.MANAGER;

  public interface ExtractFirstFragmentRect_Response {
    void call(Rect rect);
  }

  public interface ExtractTextFragmentsMatches_Response {
    void call(String[] strArr);
  }

  public interface GetExistingSelectors_Response {
    void call(String[] strArr);
  }

  public interface Proxy extends TextFragmentReceiver, Interface.Proxy {}

  public interface RequestSelector_Response {
    void call(String str, int i, int i2);
  }

  void cancel();

  void extractFirstFragmentRect(
      ExtractFirstFragmentRect_Response extractFirstFragmentRect_Response);

  void extractTextFragmentsMatches(
      ExtractTextFragmentsMatches_Response extractTextFragmentsMatches_Response);

  void getExistingSelectors(GetExistingSelectors_Response getExistingSelectors_Response);

  void removeFragments();

  void requestSelector(RequestSelector_Response requestSelector_Response);
}
