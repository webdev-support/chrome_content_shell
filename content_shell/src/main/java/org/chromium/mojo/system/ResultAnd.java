package org.chromium.mojo.system;

public class ResultAnd<A> {
  private final int mMojoResult;
  private final A mValue;

  public ResultAnd(int result, A value) {
    this.mMojoResult = result;
    this.mValue = value;
  }

  public int getMojoResult() {
    return this.mMojoResult;
  }

  public A getValue() {
    return this.mValue;
  }
}
