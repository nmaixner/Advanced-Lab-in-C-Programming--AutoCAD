import java.awt.*;

public class Ellipse extends Shape {
  protected double x1, y1, x2, y2, r;
  protected double PIE = Math.PI;
  private double a, b;

  Ellipse(Colors color, double x1, double y1, double x2, double y2, double D, int id) {
    this.color = color;
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.r = D;
    this.id = id;
    this.a = r / 2;
    this.b = Math.sqrt(Math.pow(r, 2) - Math.pow(x2 - x1, 2) - Math.pow(y2 - y1, 2)) / 2;
  }

  @Override
  public void move(double x, double y) {
    this.x1 += x;
    this.y1 += y;
    this.x2 += x;
    this.y2 += y;
  }

  @Override
  public Shape copy(double x, double y) {
    return new Ellipse(
        this.color, this.x1 + x, this.y1 + y, this.x2 + x, this.y2 + y, this.r, this.id);
  }

  @Override
  public double getArea() {
    return PIE * a * b;
  }

  @Override
  public double getCircumference() {
    double total_circumference = 0;
    double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
    for (int i = 1; i < 150; i++) {
      total_circumference +=
          (Math.pow(second_factorial(2 * i - 1) / factorial(2 * i - 1), 2))
              * (Math.pow(h, i) / Math.pow(2 * i - 1, 2));
    }
    return PIE * (a + b) * (total_circumference + 1);
  }

  public double factorial(int n) // n!
      {
    if (n == 0) return 1;
    else return n * factorial(n - 1);
  }

  public double second_factorial(int n) // n!!
      {
    if (n == 1) return 1;
    if (n == 2) return 2;
    else return n * second_factorial(n - 2);
  }

  @Override
  public boolean inside(double x, double y) {
    if (distance(this.x1, this.y1, x, y) + distance(this.x2, this.y2, x, y) <= this.r) {
      return true;
    }
    return false;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(convert(color));
    g.drawOval((int) ((x1 + x2) / 2), (int) (y1 + y2 / 2), (int) a, (int) b);
  }
}
