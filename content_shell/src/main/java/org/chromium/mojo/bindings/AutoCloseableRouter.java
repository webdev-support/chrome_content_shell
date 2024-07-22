package org.chromium.mojo.bindings;

import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;

public class AutoCloseableRouter implements Router {
  private final Exception mAllocationException = new Exception("AutocloseableRouter allocated at:");
  private boolean mClosed;
  private final Executor mExecutor;
  private final Router mRouter;

  public AutoCloseableRouter(Core core, Router router) {
    this.mRouter = router;
    this.mExecutor = ExecutorFactory.getExecutorForCurrentThread(core);
  }

  @Override
  public void setIncomingMessageReceiver(MessageReceiverWithResponder incomingMessageReceiver) {
    this.mRouter.setIncomingMessageReceiver(incomingMessageReceiver);
  }

  @Override
  public MessagePipeHandle passHandle() {
    return this.mRouter.passHandle();
  }

  @Override
  public boolean accept(Message message) {
    return this.mRouter.accept(message);
  }

  @Override
  public boolean acceptWithResponder(Message message, MessageReceiver responder) {
    return this.mRouter.acceptWithResponder(message, responder);
  }

  @Override
  public void start() {
    this.mRouter.start();
  }

  @Override
  public void setErrorHandler(ConnectionErrorHandler errorHandler) {
    this.mRouter.setErrorHandler(errorHandler);
  }

  @Override
  public void close() {
    this.mRouter.close();
    this.mClosed = true;
  }

  protected void finalize() throws Throwable {
    if (!this.mClosed) {
      this.mExecutor.execute(
          new Runnable() {
            @Override
            public void run() {
              AutoCloseableRouter.this.close();
            }
          });
      throw new IllegalStateException(
          "Warning: Router objects should be explicitly closed when no longer required otherwise you may leak handles.",
          this.mAllocationException);
    } else {
      super.finalize();
    }
  }
}
