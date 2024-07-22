package org.jni_zero;

public interface JniStaticTestMocker<T> {
  void setInstanceForTesting(T t);
}
