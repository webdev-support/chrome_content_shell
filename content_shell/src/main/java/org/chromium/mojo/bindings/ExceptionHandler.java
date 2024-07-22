package org.chromium.mojo.bindings;

public interface ExceptionHandler {
  boolean handleException(RuntimeException runtimeException);

  public static class DefaultExceptionHandler implements ExceptionHandler {
    private ExceptionHandler mDelegate;

    @Override
    public boolean handleException(RuntimeException e) {
      ExceptionHandler exceptionHandler = this.mDelegate;
      if (exceptionHandler != null) {
        return exceptionHandler.handleException(e);
      }
      throw e;
    }

    private DefaultExceptionHandler() {}

    private static class LazyHolder {
      static final DefaultExceptionHandler INSTANCE = new DefaultExceptionHandler();

      private LazyHolder() {}
    }

    public static DefaultExceptionHandler getInstance() {
      return LazyHolder.INSTANCE;
    }

    public void setDelegate(ExceptionHandler exceptionHandler) {
      this.mDelegate = exceptionHandler;
    }
  }
}
