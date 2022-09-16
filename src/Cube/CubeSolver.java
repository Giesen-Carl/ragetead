package Cube;

import static Cube.CubeColor.*;

import General.BooleanPointer;

public class CubeSolver {

  private final Cube cube;
  private final StringBuilder solve;
  private boolean exitBruteForce;

  public CubeSolver(Cube cube) {
    this.cube = new Cube(cube);
    solve = new StringBuilder();
    exitBruteForce = false;
  }

  public String solve() throws InterruptedException {
    whiteCross();
    return solve.toString();
  }

  private void whiteCross() throws InterruptedException {
    bruteForce((Cube c) -> {
      boolean blue = c.findEdge(BLUE, WHITE) == 10 && c.getFaces()[WHITE.num()][1] == WHITE;
      boolean green = c.findEdge(GREEN, WHITE) == 8 && c.getFaces()[WHITE.num()][7] == WHITE;
      boolean red = c.findEdge(RED, WHITE) == 9 && c.getFaces()[WHITE.num()][5] == WHITE;
      boolean orange = c.findEdge(ORANGE, WHITE) == 11 && c.getFaces()[WHITE.num()][3] == WHITE;
      return blue && green && red && orange;
    });
  }

  private void bruteForce(BooleanPointer bp) throws InterruptedException {
    exitBruteForce = false;
    for (int i = 1; !exitBruteForce; i++) {
      System.out.println("Brute Force Depth: " + i);
      trySolutions("", i, bp);
    }
  }

  private void trySolutions(String prev, int iteration, BooleanPointer bp)
      throws InterruptedException {
    for (Rotation rot : Rotation.values()) {
      if (exitBruteForce) {
        return;
      }
      if (prev.length() < iteration-1) {
        trySolutions(prev + rot.c(), iteration, bp);
      } else {
        if (trySolution(bp, prev + rot.c())) {
          solve.append(prev).append(rot.c());
          exitBruteForce = true;
          return;
        }
      }
    }
  }

  private boolean trySolution(BooleanPointer bp, String solution) throws InterruptedException {
    Cube tmpCube = new Cube(cube);
    tmpCube.rotate(solution);
    return bp.b(tmpCube);
  }
}
