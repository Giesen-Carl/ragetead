package Cube;

public enum Rotation {
  R('r'),
  RP('R'),
  R2('t'),
  L('l'),
  LP('L'),
  L2('k'),
  U('u'),
  UP('U'),
  U2('i'),
  D('d'),
  DP('D'),
  D2('s'),
  F('f'),
  FP('F'),
  F2('g'),
  B('b'),
  BP('B'),
  B2('n');

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
