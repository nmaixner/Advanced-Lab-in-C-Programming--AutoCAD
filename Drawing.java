import java.awt.*;
import java.util.List;
import javax.swing.*;

public class Drawing extends JFrame {
  private JFrame DrawFrame;
  private List<Shape> shapes;

  public Drawing(List<Shape> shapes) {
    initComponents(shapes);
  }

  private void initComponents(List<Shape> shapes) {
    this.shapes = shapes;
    DrawFrame = new JFrame();
    DrawFrame.setSize(1000, 1000);
    DrawFrame.setResizable(false);
    JPanel p =
        new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < shapes.size(); i++)
              if (shapes.get(i) != null) shapes.get(i).draw(g);
          }

          @Override
          public Dimension getPreferredSize() {
            return new Dimension(800, 600);
          }
        };
    DrawFrame.add(p);
    DrawFrame.pack();
    DrawFrame.setVisible(true);
  }
}
