import java.awt.*;

public abstract class Shape {
  protected Colors color = Colors.BLUE;
  protected int id;

  public Colors getColor() {
    return color;
  }

  public void setColor(Colors color) {
    this.color = color;
  }

  public Shape setId(int id) {
    this.id = id;
    return this;
  }

  public double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

  public abstract void move(double x, double y);

  public abstract Shape copy(double x, double y);

  public abstract double getArea();

  public abstract double getCircumference();

  public abstract boolean inside(double x, double y);

  public abstract void draw(Graphics g);

  public Color convert(Colors color) {
    switch (color) {
      case BLUE:
        return Color.BLUE;
      case GREEN:
        return Color.GREEN;
      case RED:
        return Color.RED;
      case YELLOW:
        return Color.YELLOW;
    }
    return Color.BLUE;
  }
}
