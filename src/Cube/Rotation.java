package Cube;

public enum Rotation {
  R('r'),
  RP('R'),
  L('l'),
  LP('L'),
  U('u'),
  UP('U'),
  D('d'),
  DP('D'),
  F('f'),
  FP('F'),
  B('b'),
  BP('B');

  private final char c;
  public char c() {
    return c;
  }
  
  public static Rotation getRot(char c) {
    for (Rotation r : Rotation.values()) {
      if (c == r.c()) {
        return r;
      }
    }
    return null;
  }
  Rotation(char c) {
    this.c = c;
  }
}
