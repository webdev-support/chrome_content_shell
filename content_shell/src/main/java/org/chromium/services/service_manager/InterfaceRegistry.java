package org.chromium.services.service_manager;

import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.service_manager.mojom.InterfaceProvider;

public class InterfaceRegistry implements InterfaceProvider {
  private final Map<String, InterfaceBinder> mBinders = new HashMap();

  public <I extends Interface> void addInterface(
      Manager<I, ? extends Interface.Proxy> manager, InterfaceFactory<I> factory) {
    this.mBinders.put(manager.getName(), new InterfaceBinder(manager, factory));
  }

  public static InterfaceRegistry create(MessagePipeHandle pipe) {
    InterfaceRegistry registry = new InterfaceRegistry();
    InterfaceProvider.MANAGER.bind(registry, pipe);
    return registry;
  }

  @Override
  public void getInterface(String name, MessagePipeHandle pipe) {
    InterfaceBinder binder = this.mBinders.get(name);
    if (binder == null) {
      return;
    }
    binder.bindToMessagePipe(pipe);
  }

  @Override
  public void close() {
    this.mBinders.clear();
  }

  @Override
  public void onConnectionError(MojoException e) {
    close();
  }

  InterfaceRegistry() {}

  public static class InterfaceBinder<I extends Interface> {
    private InterfaceFactory<I> mFactory;
    private Manager<I, ? extends Interface.Proxy> mManager;

    public InterfaceBinder(
        Manager<I, ? extends Interface.Proxy> manager, InterfaceFactory<I> factory) {
      this.mManager = manager;
      this.mFactory = factory;
    }

    public void bindToMessagePipe(MessagePipeHandle pipe) {
      I impl = this.mFactory.createImpl();
      if (impl == null) {
        pipe.close();
      } else {
        this.mManager.bind(impl, pipe);
      }
    }
  }
}
