package org.chromium.mojo.system;

import java.nio.ByteBuffer;

public interface DataPipe {

  public interface ConsumerHandle extends Handle {
    ByteBuffer beginReadData(int i, ReadFlags readFlags);

    int discardData(int i, ReadFlags readFlags);

    void endReadData(int i);

    @Override
    ConsumerHandle pass();

    ResultAnd<Integer> readData(ByteBuffer byteBuffer, ReadFlags readFlags);
  }

  public interface ProducerHandle extends Handle {
    ByteBuffer beginWriteData(int i, WriteFlags writeFlags);

    void endWriteData(int i);

    @Override
    ProducerHandle pass();

    ResultAnd<Integer> writeData(ByteBuffer byteBuffer, WriteFlags writeFlags);
  }

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
    private int mCapacityNumBytes;
    private int mElementNumBytes;
    private CreateFlags mFlags = CreateFlags.none();

    public CreateFlags getFlags() {
      return this.mFlags;
    }

    public int getElementNumBytes() {
      return this.mElementNumBytes;
    }

    public void setElementNumBytes(int elementNumBytes) {
      this.mElementNumBytes = elementNumBytes;
    }

    public int getCapacityNumBytes() {
      return this.mCapacityNumBytes;
    }

    public void setCapacityNumBytes(int capacityNumBytes) {
      this.mCapacityNumBytes = capacityNumBytes;
    }
  }

  public static class WriteFlags extends Flags<WriteFlags> {
    private static final int FLAG_ALL_OR_NONE = 1;
    private static final int FLAG_NONE = 0;
    public static final WriteFlags NONE = none().immutable();

    private WriteFlags(int flags) {
      super(flags);
    }

    public WriteFlags setAllOrNone(boolean allOrNone) {
      return setFlag(1, allOrNone);
    }

    public static WriteFlags none() {
      return new WriteFlags(0);
    }
  }

  public static class ReadFlags extends Flags<ReadFlags> {
    private static final int FLAG_ALL_OR_NONE = 1;
    private static final int FLAG_NONE = 0;
    private static final int FLAG_PEEK = 8;
    private static final int FLAG_QUERY = 4;
    public static final ReadFlags NONE = none().immutable();

    private ReadFlags(int flags) {
      super(flags);
    }

    public ReadFlags setAllOrNone(boolean allOrNone) {
      return setFlag(1, allOrNone);
    }

    public ReadFlags query(boolean query) {
      return setFlag(4, query);
    }

    public ReadFlags peek(boolean peek) {
      return setFlag(8, peek);
    }

    public static ReadFlags none() {
      return new ReadFlags(0);
    }
  }
}
