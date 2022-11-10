import static java.lang.Math.abs;

import java.awt.*;

public class Parallelogram extends Polygon {
  protected double x4, y4;

  Parallelogram(
      Colors color, double x1, double y1, double x2, double y2, double x3, double y3, int id) {
    this.color = color;
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.x3 = x3;
    this.y3 = y3;
    this.x4 = x2 + (x1 - x2) + (x3 - x2);
    this.y4 = y2 + (y1 - y2) + (y3 - y2);
    this.id = id;
  }

  @Override
  public void move(double x, double y) {
    x1 += x;
    y1 += y;
    x2 += x;
    y2 += y;
    x3 += x;
    y3 += y;
    x4 += x;
    y4 += y;
  }

  @Override
  public Shape copy(double x, double y) {
    return new Parallelogram(color, x1 + x, y1 + y, x2 + x, y2 + y, x3 + x, y3 + y, id);
  }

  @Override
  public double getArea() {
    return (abs((x1 - x4) * (y3 - x4) - ((x3 - x4) * (y1 - y4)))); // S = |det(A-D, C-D)|
  }

  @Override
  public double getCircumference() {
    return (distance(x1, y1, x2, y2)
        + distance(x2, y2, x3, y3)
        + distance(x3, y3, x4, y4)
        + distance(x4, y4, x1, y1));
  }

  @Override
  public boolean inside(double x, double y) {
    if (abs((x2 - x) * (y3 - y) - ((x3 - x) * (y2 - y))) / 2 <= getArea()
        || abs((x1 - x) * (y4 - y) - ((x4 - x) * (y1 - y))) / 2 <= getArea()) {
      return true;
    }
    return false;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(convert(color));
    g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    g.drawLine((int) x2, (int) y2, (int) x3, (int) y3);
    g.drawLine((int) x3, (int) y3, (int) x4, (int) y4);
    g.drawLine((int) x4, (int) y4, (int) x1, (int) y1);
  }
}
