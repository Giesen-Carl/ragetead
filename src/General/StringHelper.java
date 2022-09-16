package General;

public class StringHelper {
  public static String reverseMove(String move) {
    String solve = "";
    for (char c : new StringBuilder(move).reverse().toString().toCharArray()) {
      solve += switch (c) {
        case 'r' -> "R";
        case 'R' -> "r";
        case 'l' -> "L";
        case 'L' -> "l";
        case 'u' -> "U";
        case 'U' -> "u";
        case 'd' -> "D";
        case 'D' -> "d";
        case 'f' -> "F";
        case 'F' -> "f";
        case 'b' -> "B";
        case 'B' -> "b";
        default -> "";
      };
    }
    return solve;
  }
}
