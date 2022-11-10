public abstract class Polygon extends Shape {
  protected double x1, y1, x2, y2, x3, y3;

  public abstract void move(double x, double y);

  public abstract Shape copy(double x, double y);

  public abstract double getArea();

  public abstract double getCircumference();

  public abstract boolean inside(double x, double y);
}
