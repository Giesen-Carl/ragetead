package Cube;

public class ArrayHelper {

  public static CubeColor[][] copyCubeFaces(CubeColor[][] old) {
    CubeColor[][] current = new CubeColor[old.length][old[0].length];
    for(int i=0; i < old.length; i++) {
      for(int j=0; j < old[i].length; j++) {
        current[i][j] = old[i][j];
      }
    }
    return current;
  }

  public static boolean contains(CubeColor[] cca, CubeColor c1, CubeColor c2) {
    boolean bc1 = false;
    boolean bc2 = false;
    for (CubeColor c : cca) {
      if (c == c1) {
        bc1 = true;
      }
      if (c == c2) {
        bc2 = true;
      }
    }
    return bc1 && bc2;
  }

  public static boolean contains(CubeColor[] cca, CubeColor c1, CubeColor c2, CubeColor c3) {
    boolean bc1 = false;
    boolean bc2 = false;
    boolean bc3 = false;
    for (CubeColor c : cca) {
      if (c == c1) {
        bc1 = true;
      }
      if (c == c2) {
        bc2 = true;
      }
      if (c == c3) {
        bc3 = true;
      }
    }
    return bc1 && bc2 && bc3;
  }
}
