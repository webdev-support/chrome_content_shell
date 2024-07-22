package org.chromium.mojo.system;

import java.nio.ByteBuffer;
import java.util.List;

public interface MessagePipeHandle extends Handle {

  public static class ReadMessageResult {
    public byte[] mData;
    public List<UntypedHandle> mHandles;
    public long[] mRawHandles;
  }

  @Override
  MessagePipeHandle pass();

  ResultAnd<ReadMessageResult> readMessage(ReadFlags readFlags);

  void writeMessage(ByteBuffer byteBuffer, List<? extends Handle> list, WriteFlags writeFlags);

  public static class CreateFlags extends Flags<CreateFlags> {
    private static final int FLAG_NONE = 0;
    public static final CreateFlags NONE = none().immutable();

    protected CreateFlags(int flags) {
      super(flags);
    }

    public static CreateFlags none() {
      return new CreateFlags(0);
    }
  }

  public static class CreateOptions {
    private CreateFlags mFlags = CreateFlags.NONE;

    public CreateFlags getFlags() {
      return this.mFlags;
    }
  }

  public static class WriteFlags extends Flags<WriteFlags> {
    private static final int FLAG_NONE = 0;
    public static final WriteFlags NONE = none().immutable();

    private WriteFlags(int flags) {
      super(flags);
    }

    public static WriteFlags none() {
      return new WriteFlags(0);
    }
  }

  public static class ReadFlags extends Flags<ReadFlags> {
    private static final int FLAG_NONE = 0;
    public static final ReadFlags NONE = none().immutable();

    private ReadFlags(int flags) {
      super(flags);
    }

    public static ReadFlags none() {
      return new ReadFlags(0);
    }
  }
}
