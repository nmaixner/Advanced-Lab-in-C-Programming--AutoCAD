import static java.lang.Math.abs;

import java.awt.*;

public class Triangle extends Polygon {
  Triangle(Colors color, double x1, double y1, double x2, double y2, double x3, double y3, int id) {
    this.color = color;
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.x3 = x3;
    this.y3 = y3;
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
  }

  @Override
  public Shape copy(double x, double y) {

    return new Triangle(color, x1 + x, y1 + y, x2 + x, y2 + y, x3 + x, y3 + y, id);
  }

  @Override
  public double getArea() {
    return (abs((x2 - x1) * (y3 - y1) - ((x3 - x1) * (y2 - y1))) / 2);
  }

  @Override
  public double getCircumference() {
    return (distance(x1, y1, x2, y2) + distance(x2, y2, x3, y3) + distance(x3, y3, x1, y1));
  }

  @Override
  public boolean inside(double x, double y) {
    if (abs((x2 - x) * (y3 - y) - ((x3 - x) * (y2 - y))) / 2 <= getArea()) {
      return true;
    }
    return false;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(convert(color));
    g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    g.drawLine((int) x2, (int) y2, (int) x3, (int) y3);
    g.drawLine((int) x3, (int) y3, (int) x1, (int) y1);
  }
}
