package org.chromium.mojo.system;

public class Pair<F, S> {
  public final F first;
  public final S second;

  public Pair(F first, S second) {
    this.first = first;
    this.second = second;
  }

  private boolean equals(Object o1, Object o2) {
    return o1 == null ? o2 == null : o1.equals(o2);
  }

  public boolean equals(Object o) {
    if (o instanceof Pair) {
      Pair<?, ?> p = (Pair) o;
      return equals(this.first, p.first) && equals(this.second, p.second);
    }
    return false;
  }

  public int hashCode() {
    F f = this.first;
    int hashCode = f == null ? 0 : f.hashCode();
    S s = this.second;
    return hashCode ^ (s != null ? s.hashCode() : 0);
  }

  public static <A, B> Pair<A, B> create(A a, B b) {
    return new Pair<>(a, b);
  }
}
