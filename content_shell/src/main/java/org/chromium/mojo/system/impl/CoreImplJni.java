package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.ResultAnd;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class CoreImplJni implements CoreImpl.Natives {
  public static final JniStaticTestMocker<CoreImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<CoreImpl.Natives>() {
        @Override
        public void setInstanceForTesting(CoreImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          CoreImplJni.testInstance = instance;
        }
      };
  private static CoreImpl.Natives testInstance;

  CoreImplJni() {}

  @Override
  public ResultAnd beginReadData(CoreImpl caller, long mojoHandle, int numBytes, int flags) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_beginReadData(
            caller, mojoHandle, numBytes, flags);
  }

  @Override
  public ResultAnd beginWriteData(CoreImpl caller, long mojoHandle, int numBytes, int flags) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_beginWriteData(
            caller, mojoHandle, numBytes, flags);
  }

  @Override
  public int close(CoreImpl caller, long mojoHandle) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_close(caller, mojoHandle);
  }

  @Override
  public ResultAnd createDataPipe(CoreImpl caller, ByteBuffer optionsBuffer) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_createDataPipe(caller, optionsBuffer);
  }

  @Override
  public ResultAnd createMessagePipe(CoreImpl caller, ByteBuffer optionsBuffer) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_createMessagePipe(caller, optionsBuffer);
  }

  @Override
  public long createPlatformHandle(int fd) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_createPlatformHandle(fd);
  }

  @Override
  public ResultAnd createSharedBuffer(CoreImpl caller, ByteBuffer optionsBuffer, long numBytes) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_createSharedBuffer(
            caller, optionsBuffer, numBytes);
  }

  @Override
  public ResultAnd duplicate(CoreImpl caller, long mojoHandle, ByteBuffer optionsBuffer) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_duplicate(caller, mojoHandle, optionsBuffer);
  }

  @Override
  public int endReadData(CoreImpl caller, long mojoHandle, int numBytesRead) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_endReadData(
        caller, mojoHandle, numBytesRead);
  }

  @Override
  public int endWriteData(CoreImpl caller, long mojoHandle, int numBytesWritten) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_endWriteData(
        caller, mojoHandle, numBytesWritten);
  }

  @Override
  public int getNativeBufferOffset(CoreImpl caller, ByteBuffer buffer, int alignment) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_getNativeBufferOffset(
        caller, buffer, alignment);
  }

  @Override
  public long getTimeTicksNow(CoreImpl caller) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_getTimeTicksNow(caller);
  }

  @Override
  public ResultAnd map(CoreImpl caller, long mojoHandle, long offset, long numBytes, int flags) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_map(
            caller, mojoHandle, offset, numBytes, flags);
  }

  @Override
  public int queryHandleSignalsState(
      CoreImpl caller, long mojoHandle, ByteBuffer signalsStateBuffer) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_queryHandleSignalsState(
        caller, mojoHandle, signalsStateBuffer);
  }

  @Override
  public ResultAnd readData(
      CoreImpl caller, long mojoHandle, ByteBuffer elements, int elementsSize, int flags) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_readData(
            caller, mojoHandle, elements, elementsSize, flags);
  }

  @Override
  public ResultAnd readMessage(CoreImpl caller, long mojoHandle, int flags) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_readMessage(caller, mojoHandle, flags);
  }

  @Override
  public int unmap(CoreImpl caller, ByteBuffer buffer) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_unmap(caller, buffer);
  }

  @Override
  public ResultAnd writeData(
      CoreImpl caller, long mojoHandle, ByteBuffer elements, int limit, int flags) {
    return (ResultAnd)
        GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_writeData(
            caller, mojoHandle, elements, limit, flags);
  }

  @Override
  public int writeMessage(
      CoreImpl caller,
      long mojoHandle,
      ByteBuffer bytes,
      int numBytes,
      ByteBuffer handlesBuffer,
      int flags) {
    return GEN_JNI.org_chromium_mojo_system_impl_CoreImpl_writeMessage(
        caller, mojoHandle, bytes, numBytes, handlesBuffer, flags);
  }

  public static CoreImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      CoreImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of CoreImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new CoreImplJni();
  }
}
