package Cube;

import static Cube.CubeColor.*;

import General.Tupel;

public class Cube {
  private CubeColor[][] faces;
  private final CubeViewer cubeViewer;
  private int renderSpeed;

  public Cube() {
    faces = new CubeColor[6][9];
    for (CubeColor color : CubeColor.values()) {
      for (int i = 0; i < 9; i++) {
        faces[color.num()][i] = color;
      }
    }
    cubeViewer = new CubeViewer();
    this.renderSpeed = 0;
  }

  public CubeColor[] getFace(CubeColor color) {
    return switch (color) {
      case YELLOW -> faces[0];
      case BLUE -> faces[1];
      case RED -> faces[2];
      case GREEN -> faces[3];
      case ORANGE -> faces[4];
      case WHITE -> faces[5];
    };
  }

  public void rotate(String s) throws InterruptedException {
    for(char c : s.toCharArray()) {
      Rotation rotation = Rotation.getRot(c);
      if (rotation != null) {
        rotate(rotation);
        if (renderSpeed != 0) {
          Thread.sleep(1000/renderSpeed);
          cubeViewer.showCube(this);
        }
      }
    }
  }

  public void rotate(Rotation rotation) {
    switch (rotation) {
      case R -> r_rotation();
      case RP -> rp_rotation();
      case L -> l_rotation();
      case LP -> lp_rotation();
      case U -> u_rotation();
      case UP -> up_rotation();
      case D -> d_rotation();
      case DP -> dp_rotation();
      case F -> f_rotation();
      case FP -> fp_rotation();
      case B -> b_rotation();
      case BP -> bp_rotation();
    }
  }

  private void r_rotation() {
    rotationChain(
        new Tupel(YELLOW.num(), 2),
        new Tupel(BLUE.num(), 2),
        new Tupel(WHITE.num(), 2),
        new Tupel(GREEN.num(), 6)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 5),
        new Tupel(BLUE.num(), 5),
        new Tupel(WHITE.num(), 5),
        new Tupel(GREEN.num(), 3)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 8),
        new Tupel(BLUE.num(), 8),
        new Tupel(WHITE.num(), 8),
        new Tupel(GREEN.num(), 0)
    );
    rotateFace(RED.num());
  }

  private void rp_rotation() {
    r_rotation();
    r_rotation();
    r_rotation();
  }

  private void l_rotation() {
    rotationChain(
        new Tupel(YELLOW.num(), 0),
        new Tupel(BLUE.num(), 0),
        new Tupel(WHITE.num(), 0),
        new Tupel(GREEN.num(), 8)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 3),
        new Tupel(BLUE.num(), 3),
        new Tupel(WHITE.num(), 3),
        new Tupel(GREEN.num(), 5)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 6),
        new Tupel(BLUE.num(), 6),
        new Tupel(WHITE.num(), 6),
        new Tupel(GREEN.num(), 2)
    );
    rotateFace(ORANGE.num());
  }

  private void lp_rotation() {
    l_rotation();
    l_rotation();
    l_rotation();
  }

  private void u_rotation() {
    rotationChain(
        new Tupel(BLUE.num(), 0),
        new Tupel(RED.num(), 0),
        new Tupel(GREEN.num(), 0),
        new Tupel(ORANGE.num(), 0)
    );
    rotationChain(
        new Tupel(BLUE.num(), 1),
        new Tupel(RED.num(), 1),
        new Tupel(GREEN.num(), 1),
        new Tupel(ORANGE.num(), 1)
    );
    rotationChain(
        new Tupel(BLUE.num(), 2),
        new Tupel(RED.num(), 2),
        new Tupel(GREEN.num(), 2),
        new Tupel(ORANGE.num(), 2)
    );
    rotateFace(YELLOW.num());
  }

  private void up_rotation() {
    u_rotation();
    u_rotation();
    u_rotation();
  }

  private void d_rotation() {
    rotationChain(
        new Tupel(BLUE.num(), 6),
        new Tupel(ORANGE.num(), 6),
        new Tupel(GREEN.num(), 6),
        new Tupel(RED.num(), 6)
    );
    rotationChain(
        new Tupel(BLUE.num(), 7),
        new Tupel(ORANGE.num(), 7),
        new Tupel(GREEN.num(), 7),
        new Tupel(RED.num(), 7)
    );
    rotationChain(
        new Tupel(BLUE.num(), 8),
        new Tupel(ORANGE.num(), 8),
        new Tupel(GREEN.num(), 8),
        new Tupel(RED.num(), 8)
    );
    rotateFace(WHITE.num());
  }

  private void dp_rotation() {
    d_rotation();
    d_rotation();
    d_rotation();
  }

  private void f_rotation() {
    rotationChain(
        new Tupel(YELLOW.num(), 6),
        new Tupel(ORANGE.num(), 8),
        new Tupel(WHITE.num(), 2),
        new Tupel(RED.num(), 0)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 7),
        new Tupel(ORANGE.num(), 5),
        new Tupel(WHITE.num(), 1),
        new Tupel(RED.num(), 3)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 8),
        new Tupel(ORANGE.num(), 2),
        new Tupel(WHITE.num(), 0),
        new Tupel(RED.num(), 6)
    );
    rotateFace(BLUE.num());
  }

  private void fp_rotation() {
    f_rotation();
    f_rotation();
    f_rotation();
  }

  private void b_rotation() {
    rotationChain(
        new Tupel(YELLOW.num(), 0),
        new Tupel(RED.num(), 2),
        new Tupel(WHITE.num(), 8),
        new Tupel(ORANGE.num(), 6)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 1),
        new Tupel(RED.num(), 5),
        new Tupel(WHITE.num(), 7),
        new Tupel(ORANGE.num(), 3)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 2),
        new Tupel(RED.num(), 8),
        new Tupel(WHITE.num(), 6),
        new Tupel(ORANGE.num(), 0)
    );
    rotateFace(GREEN.num());
  }

  private void bp_rotation() {
    b_rotation();
    b_rotation();
    b_rotation();
  }

  private void rotationChain(Tupel t1, Tupel t2, Tupel t3, Tupel t4) {
    CubeColor tmp = faces[t1.a()][t1.b()];
    faces[t1.a()][t1.b()] = faces[t2.a()][t2.b()];
    faces[t2.a()][t2.b()] = faces[t3.a()][t3.b()];
    faces[t3.a()][t3.b()] = faces[t4.a()][t4.b()];
    faces[t4.a()][t4.b()] = tmp;
  }

  private void rotateFace(int f) {
    CubeColor tmp = faces[f][0];
    faces[f][0] = faces[f][6];
    faces[f][6] = faces[f][8];
    faces[f][8] = faces[f][2];
    faces[f][2] = tmp;

    tmp = faces[f][1];
    faces[f][1] = faces[f][3];
    faces[f][3] = faces[f][7];
    faces[f][7] = faces[f][5];
    faces[f][5] = tmp;
  }

  public void setRenderSpeed(int renderSpeed) {
    this.renderSpeed = renderSpeed;
  }
}
