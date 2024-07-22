package org.chromium.content.browser.remoteobjects;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.chromium.blink.mojom.RemoteObjectGateway;
import org.chromium.blink.mojom.RemoteObjectGatewayFactory;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.GlobalRenderFrameHostId;
import org.chromium.content_public.browser.RenderFrameHost;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsObserver;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.impl.CoreImpl;

public final class RemoteObjectInjector extends WebContentsObserver {
  private boolean mAllowInspection;
  private final Map<String, Pair<Object, Class<? extends Annotation>>> mInjectedObjects;
  private final Map<GlobalRenderFrameHostId, RemoteObjectGatewayHelper> mRemoteObjectGatewayHelpers;
  private final Set<Object> mRetainingSet;

  public static class RemoteObjectGatewayHelper {
    public RemoteObjectGateway.Proxy gateway;
    public RemoteObjectHostImpl host;
    public RemoteObjectRegistry registry;

    public RemoteObjectGatewayHelper(
        RemoteObjectGateway.Proxy newGateway,
        RemoteObjectHostImpl newHost,
        RemoteObjectRegistry newRegistry) {
      this.gateway = newGateway;
      this.host = newHost;
      this.registry = newRegistry;
    }
  }

  public RemoteObjectInjector(WebContents webContents) {
    super(webContents);
    this.mRetainingSet = new HashSet();
    this.mInjectedObjects = new HashMap();
    this.mRemoteObjectGatewayHelpers = new HashMap();
    this.mAllowInspection = true;
  }

  @Override
  public void renderFrameCreated(GlobalRenderFrameHostId id) {
    WebContents webContents;
    RenderFrameHost frameHost;
    if (this.mInjectedObjects.isEmpty()
        || (webContents = this.mWebContents.get()) == null
        || (frameHost = webContents.getRenderFrameHostFromId(id)) == null) {
      return;
    }
    for (Map.Entry<String, Pair<Object, Class<? extends Annotation>>> entry :
        this.mInjectedObjects.entrySet()) {
      addInterfaceForFrame(
          frameHost, entry.getKey(), entry.getValue().first, entry.getValue().second);
    }
  }

  @Override
  public void renderFrameDeleted(GlobalRenderFrameHostId id) {
    this.mRemoteObjectGatewayHelpers.remove(id);
  }

  public void addInterface(
      Object object, String name, Class<? extends Annotation> requiredAnnotation) {
    WebContentsImpl webContents = (WebContentsImpl) this.mWebContents.get();
    if (webContents == null) {
      return;
    }
    Pair<Object, Class<? extends Annotation>> value = this.mInjectedObjects.get(name);
    if (value == null || value.first != object) {
      if (value != null) {
        removeInterface(name);
      }
      this.mInjectedObjects.put(name, new Pair<>(object, requiredAnnotation));
      List<RenderFrameHost> frames = webContents.getAllRenderFrameHosts();
      for (RenderFrameHost frame : frames) {
        if (frame.isRenderFrameLive()) {
          addInterfaceForFrame(frame, name, object, requiredAnnotation);
        }
      }
    }
  }

  public void removeInterface(String name) {
    Pair<Object, Class<? extends Annotation>> value;
    WebContentsImpl webContents = (WebContentsImpl) this.mWebContents.get();
    if (webContents == null || (value = this.mInjectedObjects.remove(name)) == null) {
      return;
    }
    List<RenderFrameHost> frames = webContents.getAllRenderFrameHosts();
    for (RenderFrameHost frame : frames) {
      removeInterfaceForFrame(frame, name, value.first);
    }
  }

  public void setAllowInspection(boolean allow) {
    WebContentsImpl webContents = (WebContentsImpl) this.mWebContents.get();
    if (webContents == null) {
      return;
    }
    this.mAllowInspection = allow;
    List<RenderFrameHost> frames = webContents.getAllRenderFrameHosts();
    for (RenderFrameHost frame : frames) {
      setAllowInspectionForFrame(frame);
    }
  }

  private void addInterfaceForFrame(
      RenderFrameHost frameHost,
      String name,
      Object object,
      Class<? extends Annotation> requiredAnnotation) {
    RemoteObjectGatewayHelper helper = getRemoteObjectGatewayHelperForFrame(frameHost);
    helper.gateway.addNamedObject(name, helper.registry.getObjectId(object, requiredAnnotation));
  }

  private void removeInterfaceForFrame(RenderFrameHost frameHost, String name, Object object) {
    RemoteObjectGatewayHelper helper =
        this.mRemoteObjectGatewayHelpers.get(frameHost.getGlobalRenderFrameHostId());
    if (helper == null) {
      return;
    }
    helper.gateway.removeNamedObject(name);
    helper.registry.unrefObjectByObject(object);
  }

  private void setAllowInspectionForFrame(RenderFrameHost frameHost) {
    RemoteObjectGatewayHelper helper =
        this.mRemoteObjectGatewayHelpers.get(frameHost.getGlobalRenderFrameHostId());
    if (helper == null) {
      return;
    }
    helper.host.setAllowInspection(this.mAllowInspection);
  }

  private RemoteObjectGatewayHelper getRemoteObjectGatewayHelperForFrame(
      RenderFrameHost frameHost) {
    GlobalRenderFrameHostId frameHostId = frameHost.getGlobalRenderFrameHostId();
    if (!this.mRemoteObjectGatewayHelpers.containsKey(frameHostId)) {
      RemoteObjectRegistry registry = new RemoteObjectRegistry(this.mRetainingSet);
      RemoteObjectHostImpl host =
          new RemoteObjectHostImpl(new RemoteObjectAuditorImpl(), registry, this.mAllowInspection);
      RemoteObjectGatewayFactory factory =
          (RemoteObjectGatewayFactory)
              frameHost.getInterfaceToRendererFrame(RemoteObjectGatewayFactory.MANAGER);
      Pair<RemoteObjectGateway.Proxy, InterfaceRequest<RemoteObjectGateway>> result =
          RemoteObjectGateway.MANAGER.getInterfaceRequest(CoreImpl.getInstance());
      factory.createRemoteObjectGateway(host, result.second);
      this.mRemoteObjectGatewayHelpers.put(
          frameHostId, new RemoteObjectGatewayHelper(result.first, host, registry));
    }
    return this.mRemoteObjectGatewayHelpers.get(frameHostId);
  }
}
