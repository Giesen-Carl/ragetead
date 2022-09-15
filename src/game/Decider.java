package game;

import java.util.Random;

public class Decider {
  private static Random random;

  public static int decideWeighted(int... options) {
    int total = 0;
    for (int d : options) {
      total += d;
    }
    if (total != 100) {
      System.out.println("Probability is not 100%");
    }



    return 0;
  }

  public static void main(String[] args) {
    System.out.println(decideWeighted(50, 20, 30));
  }
}
