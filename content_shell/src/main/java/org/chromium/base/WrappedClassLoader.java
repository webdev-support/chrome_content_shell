package org.chromium.base;

import dalvik.system.BaseDexClassLoader;

public class WrappedClassLoader extends ClassLoader {
  private final ClassLoader mPrimaryClassLoader;
  private final ClassLoader mSecondaryClassLoader;

  public WrappedClassLoader(ClassLoader primary, ClassLoader secondary) {
    this.mPrimaryClassLoader = primary;
    this.mSecondaryClassLoader = secondary;
  }

  @Override   protected Class<?> findClass(String name) throws ClassNotFoundException {
    try {
      return this.mPrimaryClassLoader.loadClass(name);
    } catch (ClassNotFoundException e) {
      try {
        return this.mSecondaryClassLoader.loadClass(name);
      } catch (ClassNotFoundException e2) {
        e.addSuppressed(e2);
        throw e;
      }
    }
  }

  @Override   public String findLibrary(String name) {
    String path = null;
    ClassLoader classLoader = this.mPrimaryClassLoader;
    if (!(classLoader instanceof BaseDexClassLoader)
        || (path = ((BaseDexClassLoader) classLoader).findLibrary(name)) == null) {
      ClassLoader classLoader2 = this.mSecondaryClassLoader;
      if (classLoader2 instanceof BaseDexClassLoader) {
        String path2 = ((BaseDexClassLoader) classLoader2).findLibrary(name);
        return path2;
      }
      return path;
    }
    return path;
  }
}
