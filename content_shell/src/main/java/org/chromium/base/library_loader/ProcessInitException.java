package org.chromium.base.library_loader;

public class ProcessInitException extends RuntimeException {
  public ProcessInitException(int errorCode) {
    super("errorCode=" + errorCode);
  }

  public ProcessInitException(int errorCode, Throwable failureCause) {
    super("errorCode=" + errorCode, failureCause);
  }
}
