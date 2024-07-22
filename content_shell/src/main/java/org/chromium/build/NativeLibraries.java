package org.chromium.build;

public class NativeLibraries {
  public static final int CPU_FAMILY_ARM = 1;
  public static final int CPU_FAMILY_MIPS = 2;
  public static final int CPU_FAMILY_RISCV = 4;
  public static final int CPU_FAMILY_UNKNOWN = 0;
  public static final int CPU_FAMILY_X86 = 3;
  public static final String[] LIBRARIES = {"test_trace_processor", "content_shell_content_view"};
  public static final int sCpuFamily = 1;
  public static final boolean sSupport32Bit = false;
  public static final boolean sSupport64Bit = true;
  public static final boolean sUseLinker = false;
}
