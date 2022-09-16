package Cube;

import java.awt.Color;

public enum CubeColor {
  YELLOW(new Color(255, 255, 0), 0),
  BLUE(new Color(0, 102, 255), 1),
  RED(new Color(255, 0, 0), 2),
  GREEN(new Color(0, 255, 0), 3),
  ORANGE(new Color(255, 143, 0, 255), 4),
  WHITE(new Color(255, 255, 255), 5);

  private Color color;
  private int sideNum;
  public int num() {
    return sideNum;
  }
  public Color getColor() {
    return color;
  }
  CubeColor(Color color, int num) {
    this.color = color;
    this.sideNum = num;
  }
}
