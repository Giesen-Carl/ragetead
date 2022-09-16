package Cube;

import static Cube.CubeColor.*;

import General.Tupel;
import java.util.Random;

public class Cube {
  private final CubeColor[][] faces;
  private final CubeViewer cubeViewer;
  private int renderSpeed;

  public Cube() {
    faces = new CubeColor[6][9];
    for (CubeColor color : CubeColor.values()) {
      for (int i = 0; i < 9; i++) {
        faces[color.num()][i] = color;
      }
    }
    cubeViewer = new CubeViewer(this);
    this.renderSpeed = 0;
    cubeViewer.showCube();
  }

  public Cube(Cube cube) {
    this.faces = ArrayHelper.copyCubeFaces(cube.faces);
    this.cubeViewer = cube.cubeViewer;
    this.renderSpeed = 0;
  }

  public String scramble(int moves, long seed) {
    Random r = new Random(seed);
    StringBuilder scramble = new StringBuilder();
    for (int i = 0; i < moves; i++) {
      scramble.append(switch (r.nextInt(18)) {
        case 0 -> Rotation.R.c();
        case 1 -> Rotation.L.c();
        case 2 -> Rotation.U.c();
        case 3 -> Rotation.D.c();
        case 4 -> Rotation.F.c();
        case 5 -> Rotation.B.c();
        case 6 -> Rotation.RP.c();
        case 7 -> Rotation.LP.c();
        case 8 -> Rotation.UP.c();
        case 9 -> Rotation.DP.c();
        case 10 -> Rotation.FP.c();
        case 11 -> Rotation.BP.c();
        case 12 -> Rotation.R2.c();
        case 13 -> Rotation.L2.c();
        case 14 -> Rotation.U2.c();
        case 15 -> Rotation.D2.c();
        case 16 -> Rotation.F2.c();
        case 17 -> Rotation.B2.c();
        default -> "";
      });
    }
    return scramble.toString();
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

  public CubeColor[][] getFaces() {
    return faces;
  }

  public void rotate(String s) throws InterruptedException {
    for(char c : s.toCharArray()) {
      Rotation rotation = Rotation.getRot(c);
      if (rotation != null) {
        rotate(rotation);
        if (renderSpeed != 0) {
          Thread.sleep(1000/renderSpeed);
          cubeViewer.showCube();
        }
      }
    }
  }

  public int findEdge(CubeColor c1, CubeColor c2) {
    CubeColor[][] edges = {
        {faces[YELLOW.num()][1], faces[GREEN.num()][1]},
        {faces[YELLOW.num()][5], faces[RED.num()][1]},
        {faces[YELLOW.num()][7], faces[BLUE.num()][1]},
        {faces[YELLOW.num()][3], faces[ORANGE.num()][1]},
        {faces[GREEN.num()][5], faces[ORANGE.num()][3]},
        {faces[GREEN.num()][3], faces[RED.num()][5]},
        {faces[BLUE.num()][5], faces[RED.num()][3]},
        {faces[BLUE.num()][3], faces[ORANGE.num()][5]},
        {faces[WHITE.num()][7], faces[GREEN.num()][7]},
        {faces[WHITE.num()][5], faces[RED.num()][7]},
        {faces[WHITE.num()][1], faces[BLUE.num()][7]},
        {faces[WHITE.num()][3], faces[ORANGE.num()][7]},
    };

    for (int i = 0; i < edges.length; i++) {
      if (ArrayHelper.contains(edges[i], c1, c2)) {
        return i;
      }
    }
    return 0;
  }

  public int findCorner(CubeColor c1, CubeColor c2, CubeColor c3) {
    CubeColor[][] edges = {
        {faces[YELLOW.num()][0], faces[GREEN.num()][2], faces[ORANGE.num()][0]},
        {faces[YELLOW.num()][2], faces[GREEN.num()][0], faces[RED.num()][2]},
        {faces[YELLOW.num()][8], faces[BLUE.num()][2], faces[RED.num()][0]},
        {faces[YELLOW.num()][6], faces[BLUE.num()][0], faces[ORANGE.num()][2]},
        {faces[WHITE.num()][6], faces[GREEN.num()][8], faces[ORANGE.num()][6]},
        {faces[WHITE.num()][8], faces[GREEN.num()][6], faces[RED.num()][8]},
        {faces[WHITE.num()][2], faces[BLUE.num()][8], faces[RED.num()][6]},
        {faces[WHITE.num()][0], faces[BLUE.num()][6], faces[ORANGE.num()][8]},
    };

    for (int i = 0; i < edges.length; i++) {
      if (ArrayHelper.contains(edges[i], c1, c2, c3)) {
        return i;
      }
    }
    return 0;
  }

  public void rotate(Rotation rotation) {
    switch (rotation) {
      case R -> r_rotation();
      case L -> l_rotation();
      case U -> u_rotation();
      case D -> d_rotation();
      case F -> f_rotation();
      case B -> b_rotation();
      case RP -> rp_rotation();
      case LP -> lp_rotation();
      case UP -> up_rotation();
      case DP -> dp_rotation();
      case FP -> fp_rotation();
      case BP -> bp_rotation();
      case R2 -> r2_rotation();
      case L2 -> l2_rotation();
      case U2 -> u2_rotation();
      case D2 -> d2_rotation();
      case F2 -> f2_rotation();
      case B2 -> b2_rotation();
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

  private void l_rotation() {
    rotationChain(
        new Tupel(YELLOW.num(), 0),
        new Tupel(GREEN.num(), 8),
        new Tupel(WHITE.num(), 0),
        new Tupel(BLUE.num(), 0)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 3),
        new Tupel(GREEN.num(), 5),
        new Tupel(WHITE.num(), 3),
        new Tupel(BLUE.num(), 3)
    );
    rotationChain(
        new Tupel(YELLOW.num(), 6),
        new Tupel(GREEN.num(), 2),
        new Tupel(WHITE.num(), 6),
        new Tupel(BLUE.num(), 6)
    );
    rotateFace(ORANGE.num());
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

  private void rp_rotation() {
    r_rotation();
    r_rotation();
    r_rotation();
  }

  private void lp_rotation() {
    l_rotation();
    l_rotation();
    l_rotation();
  }

  private void up_rotation() {
    u_rotation();
    u_rotation();
    u_rotation();
  }

  private void dp_rotation() {
    d_rotation();
    d_rotation();
    d_rotation();
  }

  private void fp_rotation() {
    f_rotation();
    f_rotation();
    f_rotation();
  }

  private void bp_rotation() {
    b_rotation();
    b_rotation();
    b_rotation();
  }

  private void r2_rotation() {
    r_rotation();
    r_rotation();
  }

  private void l2_rotation() {
    l_rotation();
    l_rotation();
  }

  private void u2_rotation() {
    u_rotation();
    u_rotation();
  }

  private void d2_rotation() {
    d_rotation();
    d_rotation();
  }

  private void f2_rotation() {
    f_rotation();
    f_rotation();
  }

  private void b2_rotation() {
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

  public void show() {
    cubeViewer.showCube();
  }
}
