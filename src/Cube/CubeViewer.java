package Cube;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CubeViewer extends JPanel {

  private Cube cube;
  private final int size = 30;

  public CubeViewer() {
    this.setPreferredSize(new Dimension(18*size, 15*size));
    this.setBackground(new Color(196, 246, 237, 255));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.add(this);
    frame.pack();
    frame.setResizable(false);
    frame.setVisible(true);
  }

  public void showCube(Cube cube) {
    this.cube = cube;
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    if (cube != null) {
      drawFace(g2d, 2, 1, cube.getFace(CubeColor.YELLOW));
      drawFace(g2d, 2, 2, cube.getFace(CubeColor.BLUE));
      drawFace(g2d, 3, 2, cube.getFace(CubeColor.RED));
      drawFace(g2d, 4, 2, cube.getFace(CubeColor.GREEN));
      drawFace(g2d, 1, 2, cube.getFace(CubeColor.ORANGE));
      drawFace(g2d, 2, 3, cube.getFace(CubeColor.WHITE));
    }
  }

  public void drawFace(Graphics2D g2d, int tmpX, int tmpY, CubeColor[] colors) {
    int xPos = tmpX*3*size;
    int yPos = tmpY*3*size;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        g2d.setColor(colors[i+3*j].getColor());
        g2d.fillRect(xPos + i*size, yPos + j*size, size, size);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(xPos + i*size, yPos + j*size, size, size);
      }
    }
  }
}
