package org.chromium.mojo.system;

public interface UntypedHandle extends Handle {
  @Override
  UntypedHandle pass();

  DataPipe.ConsumerHandle toDataPipeConsumerHandle();

  DataPipe.ProducerHandle toDataPipeProducerHandle();

  MessagePipeHandle toMessagePipeHandle();

  SharedBufferHandle toSharedBufferHandle();
}
