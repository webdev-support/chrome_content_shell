package org.chromium.mojo.bindings;

import org.chromium.mojo.bindings.interfacecontrol.QueryVersionResult;
import org.chromium.mojo.bindings.interfacecontrol.RunMessageParams;
import org.chromium.mojo.bindings.interfacecontrol.RunOrClosePipeMessageParams;
import org.chromium.mojo.bindings.interfacecontrol.RunOutput;
import org.chromium.mojo.bindings.interfacecontrol.RunResponseMessageParams;
import org.chromium.mojo.system.Core;

public class InterfaceControlMessagesHelper {

  public interface SendRunMessageCallback {
    void call(RunResponseMessageParams runResponseMessageParams);
  }

  public static class RunResponseForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SendRunMessageCallback mCallback;

    RunResponseForwardToCallback(SendRunMessageCallback callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      RunResponseMessageParams response =
          RunResponseMessageParams.deserialize(message.asServiceMessage().getPayload());
      this.mCallback.call(response);
      return true;
    }
  }

  public static void sendRunMessage(
      Core core,
      MessageReceiverWithResponder receiver,
      RunMessageParams params,
      SendRunMessageCallback callback) {
    Message message = params.serializeWithHeader(core, new MessageHeader(-1, 1, 0L));
    receiver.acceptWithResponder(message, new RunResponseForwardToCallback(callback));
  }

  public static void sendRunOrClosePipeMessage(
      Core core, MessageReceiverWithResponder receiver, RunOrClosePipeMessageParams params) {
    Message message = params.serializeWithHeader(core, new MessageHeader(-2));
    receiver.accept(message);
  }

  public static <I extends Interface, P extends Interface.Proxy> boolean handleRun(
      Core core,
      Interface.Manager<I, P> manager,
      ServiceMessage message,
      MessageReceiver responder) {
    Message payload = message.getPayload();
    RunMessageParams query = RunMessageParams.deserialize(payload);
    RunResponseMessageParams response = new RunResponseMessageParams();
    response.output = new RunOutput();
    if (query.input.which() == 0) {
      response.output.setQueryVersionResult(new QueryVersionResult());
      response.output.getQueryVersionResult().version = manager.getVersion();
    } else {
      response.output = null;
    }
    return responder.accept(
        response.serializeWithHeader(
            core, new MessageHeader(-1, 2, message.getHeader().getRequestId())));
  }

  public static <I extends Interface, P extends Interface.Proxy> boolean handleRunOrClosePipe(
      Interface.Manager<I, P> manager, ServiceMessage message) {
    Message payload = message.getPayload();
    RunOrClosePipeMessageParams query = RunOrClosePipeMessageParams.deserialize(payload);
    return query.input.which() == 0
        && query.input.getRequireVersion().version <= manager.getVersion();
  }
}
