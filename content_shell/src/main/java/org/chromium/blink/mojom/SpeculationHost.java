package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface SpeculationHost extends Interface {
  public static final Interface.Manager<SpeculationHost, Proxy> MANAGER =
      SpeculationHost_Internal.MANAGER;

  public interface Proxy extends SpeculationHost, Interface.Proxy {}

  void enableNoVarySearchSupport();

  void initiatePreview(Url url);

  void updateSpeculationCandidates(SpeculationCandidate[] speculationCandidateArr);
}
