import java.awt.*;

public class Circle extends Ellipse {
  Circle(Colors color, double x, double y, double radius, int id) {
    super(color, x, y, x, y, radius, id);
  }

  @Override
  public void move(double x, double y) {
    super.move(x, y);
  }

  @Override
  public Shape copy(double x, double y) {
    return new Circle(this.color, this.x1 + x, this.y1 + y, this.r, this.id);
  }

  @Override
  public double getArea() {
    return PIE * Math.pow(this.r, 2);
  }

  @Override
  public double getCircumference() {
    return 2 * PIE * this.r;
  }

  @Override
  public boolean inside(double x, double y) {
    if (Math.sqrt(Math.pow(x - this.x1, 2) + Math.pow(y - this.y1, 2)) <= this.r) return true;
    return false;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(convert(color));
    g.drawOval((int) x1, (int) y1, (int) r, (int) r);
  }
}
