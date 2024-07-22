package org.chromium.content_public.browser;

import java.util.ArrayList;
import java.util.List;
import org.chromium.services.service_manager.InterfaceRegistry;

public interface InterfaceRegistrar<ParamType> {
  void registerInterfaces(InterfaceRegistry interfaceRegistry, ParamType paramtype);

  public static class Registry<ParamType> {
    private static Registry<RenderFrameHost> sRenderFrameHostRegistry;
    private static Registry<Void> sSingletonRegistry;
    private static Registry<WebContents> sWebContentsRegistry;
    private List<InterfaceRegistrar<ParamType>> mRegistrars = new ArrayList();

    public static void applySingletonRegistrars(InterfaceRegistry interfaceRegistry) {
      Registry<Void> registry = sSingletonRegistry;
      if (registry == null) {
        return;
      }
      registry.applyRegistrars(interfaceRegistry, null);
    }

    public static void applyWebContentsRegistrars(
        InterfaceRegistry interfaceRegistry, WebContents webContents) {
      Registry<WebContents> registry = sWebContentsRegistry;
      if (registry == null) {
        return;
      }
      registry.applyRegistrars(interfaceRegistry, webContents);
    }

    public static void applyRenderFrameHostRegistrars(
        InterfaceRegistry interfaceRegistry, RenderFrameHost renderFrameHost) {
      Registry<RenderFrameHost> registry = sRenderFrameHostRegistry;
      if (registry == null) {
        return;
      }
      registry.applyRegistrars(interfaceRegistry, renderFrameHost);
    }

    public static void addSingletonRegistrar(InterfaceRegistrar<Void> registrar) {
      if (sSingletonRegistry == null) {
        sSingletonRegistry = new Registry<>();
      }
      sSingletonRegistry.addRegistrar(registrar);
    }

    public static void addWebContentsRegistrar(InterfaceRegistrar<WebContents> registrar) {
      if (sWebContentsRegistry == null) {
        sWebContentsRegistry = new Registry<>();
      }
      sWebContentsRegistry.addRegistrar(registrar);
    }

    public static void addRenderFrameHostRegistrar(InterfaceRegistrar<RenderFrameHost> registrar) {
      if (sRenderFrameHostRegistry == null) {
        sRenderFrameHostRegistry = new Registry<>();
      }
      sRenderFrameHostRegistry.addRegistrar(registrar);
    }

    private Registry() {}

    private void addRegistrar(InterfaceRegistrar<ParamType> registrar) {
      this.mRegistrars.add(registrar);
    }

    private void applyRegistrars(InterfaceRegistry interfaceRegistry, ParamType param) {
      for (InterfaceRegistrar<ParamType> registrar : this.mRegistrars) {
        registrar.registerInterfaces(interfaceRegistry, param);
      }
    }
  }
}
