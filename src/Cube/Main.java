package Cube;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Cube cube = new Cube();
    String scramble = cube.scramble(100, 1234);
//    String scramble = "dd";
    cube.setRenderSpeed(100);
    cube.rotate(scramble);
    CubeSolver cs = new CubeSolver(cube);
    String solve = cs.solve();
    System.out.println(scramble);
    System.out.println(solve);

    Thread.sleep(1000);
    cube.setRenderSpeed(1);
    cube.rotate(solve);
  }
}
