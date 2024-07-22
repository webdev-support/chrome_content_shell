// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: anr_data.proto

package org.chromium.components.crash.anr;

public final class AnrDataOuterClass {
  private AnrDataOuterClass() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public interface AnrDataOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:crash.anr.proto.AnrData)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     *
     * @return Whether the cause field is set.
     */
    boolean hasCause();

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     *
     * @return The cause.
     */
    java.lang.String getCause();

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     *
     * @return The bytes for cause.
     */
    com.google.protobuf.ByteString getCauseBytes();

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     *
     * @return Whether the stackTraces field is set.
     */
    boolean hasStackTraces();

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     *
     * @return The stackTraces.
     */
    java.lang.String getStackTraces();

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     *
     * @return The bytes for stackTraces.
     */
    com.google.protobuf.ByteString getStackTracesBytes();

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     *
     * @return Whether the mainThreadStackTrace field is set.
     */
    boolean hasMainThreadStackTrace();

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     *
     * @return The mainThreadStackTrace.
     */
    java.lang.String getMainThreadStackTrace();

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     *
     * @return The bytes for mainThreadStackTrace.
     */
    com.google.protobuf.ByteString getMainThreadStackTraceBytes();

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     *
     * @return Whether the preamble field is set.
     */
    boolean hasPreamble();

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     *
     * @return The preamble.
     */
    java.lang.String getPreamble();

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     *
     * @return The bytes for preamble.
     */
    com.google.protobuf.ByteString getPreambleBytes();
  }

  /**
   *
   *
   * <pre>
   * This is a proto copied from the source code of the crash server to ensure we
   * have the correct format to upload.
   * </pre>
   *
   * Protobuf type {@code crash.anr.proto.AnrData}
   */
  public static final class AnrData
      extends com.google.protobuf.GeneratedMessageLite<AnrData, AnrData.Builder>
      implements
      // @@protoc_insertion_point(message_implements:crash.anr.proto.AnrData)
      AnrDataOrBuilder {
    private AnrData() {
      cause_ = "";
      stackTraces_ = "";
      mainThreadStackTrace_ = "";
      preamble_ = "";
    }

    private int bitField0_;
    public static final int CAUSE_FIELD_NUMBER = 2;
    private java.lang.String cause_;

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     *
     * @return Whether the cause field is set.
     */
    @java.lang.Override
    public boolean hasCause() {
      return ((bitField0_ & 0x00000001) != 0);
    }

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     *
     * @return The cause.
     */
    @java.lang.Override
    public java.lang.String getCause() {
      return cause_;
    }

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     *
     * @return The bytes for cause.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getCauseBytes() {
      return com.google.protobuf.ByteString.copyFromUtf8(cause_);
    }

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     *
     * @param value The cause to set.
     */
    private void setCause(java.lang.String value) {
      value.getClass();
      bitField0_ |= 0x00000001;
      cause_ = value;
    }

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     */
    private void clearCause() {
      bitField0_ = (bitField0_ & ~0x00000001);
      cause_ = getDefaultInstance().getCause();
    }

    /**
     *
     *
     * <pre>
     * Description of the operation that timed out.
     * Chrome does not put a useful value in here, but must include it to be
     * processed.
     * </pre>
     *
     * <code>optional string cause = 2;</code>
     *
     * @param value The bytes for cause to set.
     */
    private void setCauseBytes(com.google.protobuf.ByteString value) {
      cause_ = value.toStringUtf8();
      bitField0_ |= 0x00000001;
    }

    public static final int STACK_TRACES_FIELD_NUMBER = 4;
    private java.lang.String stackTraces_;

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     *
     * @return Whether the stackTraces field is set.
     */
    @java.lang.Override
    public boolean hasStackTraces() {
      return ((bitField0_ & 0x00000002) != 0);
    }

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     *
     * @return The stackTraces.
     */
    @java.lang.Override
    public java.lang.String getStackTraces() {
      return stackTraces_;
    }

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     *
     * @return The bytes for stackTraces.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getStackTracesBytes() {
      return com.google.protobuf.ByteString.copyFromUtf8(stackTraces_);
    }

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     *
     * @param value The stackTraces to set.
     */
    private void setStackTraces(java.lang.String value) {
      value.getClass();
      bitField0_ |= 0x00000002;
      stackTraces_ = value;
    }

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     */
    private void clearStackTraces() {
      bitField0_ = (bitField0_ & ~0x00000002);
      stackTraces_ = getDefaultInstance().getStackTraces();
    }

    /**
     *
     *
     * <pre>
     * Stack traces for all the threads that were running on the device. If
     * deobfuscation is enabled, these stack_traces will be deobfuscated during
     * the preprocessing phase.
     * </pre>
     *
     * <code>optional string stack_traces = 4;</code>
     *
     * @param value The bytes for stackTraces to set.
     */
    private void setStackTracesBytes(com.google.protobuf.ByteString value) {
      stackTraces_ = value.toStringUtf8();
      bitField0_ |= 0x00000002;
    }

    public static final int MAIN_THREAD_STACK_TRACE_FIELD_NUMBER = 6;
    private java.lang.String mainThreadStackTrace_;

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     *
     * @return Whether the mainThreadStackTrace field is set.
     */
    @java.lang.Override
    public boolean hasMainThreadStackTrace() {
      return ((bitField0_ & 0x00000004) != 0);
    }

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     *
     * @return The mainThreadStackTrace.
     */
    @java.lang.Override
    public java.lang.String getMainThreadStackTrace() {
      return mainThreadStackTrace_;
    }

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     *
     * @return The bytes for mainThreadStackTrace.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getMainThreadStackTraceBytes() {
      return com.google.protobuf.ByteString.copyFromUtf8(mainThreadStackTrace_);
    }

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     *
     * @param value The mainThreadStackTrace to set.
     */
    private void setMainThreadStackTrace(java.lang.String value) {
      value.getClass();
      bitField0_ |= 0x00000004;
      mainThreadStackTrace_ = value;
    }

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     */
    private void clearMainThreadStackTrace() {
      bitField0_ = (bitField0_ & ~0x00000004);
      mainThreadStackTrace_ = getDefaultInstance().getMainThreadStackTrace();
    }

    /**
     *
     *
     * <pre>
     * The stack trace of the main thread (starting from the status line)
     * of the process that is not responsive according to
     * MobileData.package_data.process_name.
     * </pre>
     *
     * <code>optional string main_thread_stack_trace = 6;</code>
     *
     * @param value The bytes for mainThreadStackTrace to set.
     */
    private void setMainThreadStackTraceBytes(com.google.protobuf.ByteString value) {
      mainThreadStackTrace_ = value.toStringUtf8();
      bitField0_ |= 0x00000004;
    }

    public static final int PREAMBLE_FIELD_NUMBER = 8;
    private java.lang.String preamble_;

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     *
     * @return Whether the preamble field is set.
     */
    @java.lang.Override
    public boolean hasPreamble() {
      return ((bitField0_ & 0x00000008) != 0);
    }

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     *
     * @return The preamble.
     */
    @java.lang.Override
    public java.lang.String getPreamble() {
      return preamble_;
    }

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     *
     * @return The bytes for preamble.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getPreambleBytes() {
      return com.google.protobuf.ByteString.copyFromUtf8(preamble_);
    }

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     *
     * @param value The preamble to set.
     */
    private void setPreamble(java.lang.String value) {
      value.getClass();
      bitField0_ |= 0x00000008;
      preamble_ = value;
    }

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     */
    private void clearPreamble() {
      bitField0_ = (bitField0_ & ~0x00000008);
      preamble_ = getDefaultInstance().getPreamble();
    }

    /**
     *
     *
     * <pre>
     * Preamble of anr report.
     * </pre>
     *
     * <code>optional string preamble = 8;</code>
     *
     * @param value The bytes for preamble to set.
     */
    private void setPreambleBytes(com.google.protobuf.ByteString value) {
      preamble_ = value.toStringUtf8();
      bitField0_ |= 0x00000008;
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(
        org.chromium.components.crash.anr.AnrDataOuterClass.AnrData prototype) {
      return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    /**
     *
     *
     * <pre>
     * This is a proto copied from the source code of the crash server to ensure we
     * have the correct format to upload.
     * </pre>
     *
     * Protobuf type {@code crash.anr.proto.AnrData}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageLite.Builder<
            org.chromium.components.crash.anr.AnrDataOuterClass.AnrData, Builder>
        implements
        // @@protoc_insertion_point(builder_implements:crash.anr.proto.AnrData)
        org.chromium.components.crash.anr.AnrDataOuterClass.AnrDataOrBuilder {
      // Construct using org.chromium.components.crash.anr.AnrDataOuterClass.AnrData.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }

      /**
       *
       *
       * <pre>
       * Description of the operation that timed out.
       * Chrome does not put a useful value in here, but must include it to be
       * processed.
       * </pre>
       *
       * <code>optional string cause = 2;</code>
       *
       * @return Whether the cause field is set.
       */
      @java.lang.Override
      public boolean hasCause() {
        return instance.hasCause();
      }

      /**
       *
       *
       * <pre>
       * Description of the operation that timed out.
       * Chrome does not put a useful value in here, but must include it to be
       * processed.
       * </pre>
       *
       * <code>optional string cause = 2;</code>
       *
       * @return The cause.
       */
      @java.lang.Override
      public java.lang.String getCause() {
        return instance.getCause();
      }

      /**
       *
       *
       * <pre>
       * Description of the operation that timed out.
       * Chrome does not put a useful value in here, but must include it to be
       * processed.
       * </pre>
       *
       * <code>optional string cause = 2;</code>
       *
       * @return The bytes for cause.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getCauseBytes() {
        return instance.getCauseBytes();
      }

      /**
       *
       *
       * <pre>
       * Description of the operation that timed out.
       * Chrome does not put a useful value in here, but must include it to be
       * processed.
       * </pre>
       *
       * <code>optional string cause = 2;</code>
       *
       * @param value The cause to set.
       * @return This builder for chaining.
       */
      public Builder setCause(java.lang.String value) {
        copyOnWrite();
        instance.setCause(value);
        return this;
      }

      /**
       *
       *
       * <pre>
       * Description of the operation that timed out.
       * Chrome does not put a useful value in here, but must include it to be
       * processed.
       * </pre>
       *
       * <code>optional string cause = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCause() {
        copyOnWrite();
        instance.clearCause();
        return this;
      }

      /**
       *
       *
       * <pre>
       * Description of the operation that timed out.
       * Chrome does not put a useful value in here, but must include it to be
       * processed.
       * </pre>
       *
       * <code>optional string cause = 2;</code>
       *
       * @param value The bytes for cause to set.
       * @return This builder for chaining.
       */
      public Builder setCauseBytes(com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setCauseBytes(value);
        return this;
      }

      /**
       *
       *
       * <pre>
       * Stack traces for all the threads that were running on the device. If
       * deobfuscation is enabled, these stack_traces will be deobfuscated during
       * the preprocessing phase.
       * </pre>
       *
       * <code>optional string stack_traces = 4;</code>
       *
       * @return Whether the stackTraces field is set.
       */
      @java.lang.Override
      public boolean hasStackTraces() {
        return instance.hasStackTraces();
      }

      /**
       *
       *
       * <pre>
       * Stack traces for all the threads that were running on the device. If
       * deobfuscation is enabled, these stack_traces will be deobfuscated during
       * the preprocessing phase.
       * </pre>
       *
       * <code>optional string stack_traces = 4;</code>
       *
       * @return The stackTraces.
       */
      @java.lang.Override
      public java.lang.String getStackTraces() {
        return instance.getStackTraces();
      }

      /**
       *
       *
       * <pre>
       * Stack traces for all the threads that were running on the device. If
       * deobfuscation is enabled, these stack_traces will be deobfuscated during
       * the preprocessing phase.
       * </pre>
       *
       * <code>optional string stack_traces = 4;</code>
       *
       * @return The bytes for stackTraces.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getStackTracesBytes() {
        return instance.getStackTracesBytes();
      }

      /**
       *
       *
       * <pre>
       * Stack traces for all the threads that were running on the device. If
       * deobfuscation is enabled, these stack_traces will be deobfuscated during
       * the preprocessing phase.
       * </pre>
       *
       * <code>optional string stack_traces = 4;</code>
       *
       * @param value The stackTraces to set.
       * @return This builder for chaining.
       */
      public Builder setStackTraces(java.lang.String value) {
        copyOnWrite();
        instance.setStackTraces(value);
        return this;
      }

      /**
       *
       *
       * <pre>
       * Stack traces for all the threads that were running on the device. If
       * deobfuscation is enabled, these stack_traces will be deobfuscated during
       * the preprocessing phase.
       * </pre>
       *
       * <code>optional string stack_traces = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStackTraces() {
        copyOnWrite();
        instance.clearStackTraces();
        return this;
      }

      /**
       *
       *
       * <pre>
       * Stack traces for all the threads that were running on the device. If
       * deobfuscation is enabled, these stack_traces will be deobfuscated during
       * the preprocessing phase.
       * </pre>
       *
       * <code>optional string stack_traces = 4;</code>
       *
       * @param value The bytes for stackTraces to set.
       * @return This builder for chaining.
       */
      public Builder setStackTracesBytes(com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setStackTracesBytes(value);
        return this;
      }

      /**
       *
       *
       * <pre>
       * The stack trace of the main thread (starting from the status line)
       * of the process that is not responsive according to
       * MobileData.package_data.process_name.
       * </pre>
       *
       * <code>optional string main_thread_stack_trace = 6;</code>
       *
       * @return Whether the mainThreadStackTrace field is set.
       */
      @java.lang.Override
      public boolean hasMainThreadStackTrace() {
        return instance.hasMainThreadStackTrace();
      }

      /**
       *
       *
       * <pre>
       * The stack trace of the main thread (starting from the status line)
       * of the process that is not responsive according to
       * MobileData.package_data.process_name.
       * </pre>
       *
       * <code>optional string main_thread_stack_trace = 6;</code>
       *
       * @return The mainThreadStackTrace.
       */
      @java.lang.Override
      public java.lang.String getMainThreadStackTrace() {
        return instance.getMainThreadStackTrace();
      }

      /**
       *
       *
       * <pre>
       * The stack trace of the main thread (starting from the status line)
       * of the process that is not responsive according to
       * MobileData.package_data.process_name.
       * </pre>
       *
       * <code>optional string main_thread_stack_trace = 6;</code>
       *
       * @return The bytes for mainThreadStackTrace.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getMainThreadStackTraceBytes() {
        return instance.getMainThreadStackTraceBytes();
      }

      /**
       *
       *
       * <pre>
       * The stack trace of the main thread (starting from the status line)
       * of the process that is not responsive according to
       * MobileData.package_data.process_name.
       * </pre>
       *
       * <code>optional string main_thread_stack_trace = 6;</code>
       *
       * @param value The mainThreadStackTrace to set.
       * @return This builder for chaining.
       */
      public Builder setMainThreadStackTrace(java.lang.String value) {
        copyOnWrite();
        instance.setMainThreadStackTrace(value);
        return this;
      }

      /**
       *
       *
       * <pre>
       * The stack trace of the main thread (starting from the status line)
       * of the process that is not responsive according to
       * MobileData.package_data.process_name.
       * </pre>
       *
       * <code>optional string main_thread_stack_trace = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMainThreadStackTrace() {
        copyOnWrite();
        instance.clearMainThreadStackTrace();
        return this;
      }

      /**
       *
       *
       * <pre>
       * The stack trace of the main thread (starting from the status line)
       * of the process that is not responsive according to
       * MobileData.package_data.process_name.
       * </pre>
       *
       * <code>optional string main_thread_stack_trace = 6;</code>
       *
       * @param value The bytes for mainThreadStackTrace to set.
       * @return This builder for chaining.
       */
      public Builder setMainThreadStackTraceBytes(com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setMainThreadStackTraceBytes(value);
        return this;
      }

      /**
       *
       *
       * <pre>
       * Preamble of anr report.
       * </pre>
       *
       * <code>optional string preamble = 8;</code>
       *
       * @return Whether the preamble field is set.
       */
      @java.lang.Override
      public boolean hasPreamble() {
        return instance.hasPreamble();
      }

      /**
       *
       *
       * <pre>
       * Preamble of anr report.
       * </pre>
       *
       * <code>optional string preamble = 8;</code>
       *
       * @return The preamble.
       */
      @java.lang.Override
      public java.lang.String getPreamble() {
        return instance.getPreamble();
      }

      /**
       *
       *
       * <pre>
       * Preamble of anr report.
       * </pre>
       *
       * <code>optional string preamble = 8;</code>
       *
       * @return The bytes for preamble.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getPreambleBytes() {
        return instance.getPreambleBytes();
      }

      /**
       *
       *
       * <pre>
       * Preamble of anr report.
       * </pre>
       *
       * <code>optional string preamble = 8;</code>
       *
       * @param value The preamble to set.
       * @return This builder for chaining.
       */
      public Builder setPreamble(java.lang.String value) {
        copyOnWrite();
        instance.setPreamble(value);
        return this;
      }

      /**
       *
       *
       * <pre>
       * Preamble of anr report.
       * </pre>
       *
       * <code>optional string preamble = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPreamble() {
        copyOnWrite();
        instance.clearPreamble();
        return this;
      }

      /**
       *
       *
       * <pre>
       * Preamble of anr report.
       * </pre>
       *
       * <code>optional string preamble = 8;</code>
       *
       * @param value The bytes for preamble to set.
       * @return This builder for chaining.
       */
      public Builder setPreambleBytes(com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setPreambleBytes(value);
        return this;
      }

      // @@protoc_insertion_point(builder_scope:crash.anr.proto.AnrData)
    }

    @java.lang.Override
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0,
        java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE:
          {
            return new org.chromium.components.crash.anr.AnrDataOuterClass.AnrData();
          }
        case NEW_BUILDER:
          {
            return new Builder();
          }
        case BUILD_MESSAGE_INFO:
          {
            java.lang.Object[] objects =
                new java.lang.Object[] {
                  "bitField0_", "cause_", "stackTraces_", "mainThreadStackTrace_", "preamble_",
                };
            java.lang.String info =
                "\u0001\u0004\u0000\u0001\u0002\b\u0004\u0000\u0000\u0000\u0002\u1008\u0000\u0004"
                    + "\u1008\u0001\u0006\u1008\u0002\b\u1008\u0003";
            return newMessageInfo(DEFAULT_INSTANCE, info, objects);
          }
          // fall through
        case GET_DEFAULT_INSTANCE:
          {
            return DEFAULT_INSTANCE;
          }
        case GET_PARSER:
          {
            com.google.protobuf.Parser<org.chromium.components.crash.anr.AnrDataOuterClass.AnrData>
                parser = PARSER;
            if (parser == null) {
              synchronized (org.chromium.components.crash.anr.AnrDataOuterClass.AnrData.class) {
                parser = PARSER;
                if (parser == null) {
                  parser =
                      new DefaultInstanceBasedParser<
                          org.chromium.components.crash.anr.AnrDataOuterClass.AnrData>(
                          DEFAULT_INSTANCE);
                  PARSER = parser;
                }
              }
            }
            return parser;
          }
        case GET_MEMOIZED_IS_INITIALIZED:
          {
            return (byte) 1;
          }
        case SET_MEMOIZED_IS_INITIALIZED:
          {
            return null;
          }
      }
      throw new UnsupportedOperationException();
    }

    // @@protoc_insertion_point(class_scope:crash.anr.proto.AnrData)
    private static final org.chromium.components.crash.anr.AnrDataOuterClass.AnrData
        DEFAULT_INSTANCE;

    static {
      AnrData defaultInstance = new AnrData();
      // New instances are implicitly immutable so no need to make
      // immutable.
      DEFAULT_INSTANCE = defaultInstance;
      com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
          AnrData.class, defaultInstance);
    }

    public static org.chromium.components.crash.anr.AnrDataOuterClass.AnrData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<AnrData> PARSER;

    public static com.google.protobuf.Parser<AnrData> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }

  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
