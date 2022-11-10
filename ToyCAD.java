import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class ToyCAD extends JFrame {
  public static int ID = 0;
  private static List<Shape> shapes;

  public static void main(String[] args) {
    shapes = new ArrayList<Shape>();
    Scanner scanner = new Scanner(System.in);
    String comand_line = scanner.nextLine();
    while (!comand_line.equals("exit")) {
      String[] comand_line_array = comand_line.split(" ");
      String comand = comand_line_array[0];
      switch (comand.toLowerCase()) {
        case "new":
          new_shape(comand_line_array);
          break;
        case "delete":
          delete_shape(comand_line_array);
          break;
        case "move":
          move_shape(comand_line_array);
          break;
        case "copy":
          copy_shape(comand_line_array);
          break;
        case "area":
          area_of_shapes(comand_line_array);
          break;
        case "color":
          shape_color_change(comand_line_array);
          break;
        case "circumference":
          circumference_of_shapes(comand_line_array);
          break;
        case "inside_is":
          check_P_in_Shape(comand_line_array);
          break;
        case "draw":
          new ToyCAD();
          draw();
          break;
        case "print":
          for (int i = 0; i < shapes.size(); i++)
            if (shapes.get(i) != null) System.out.println(shapes.get(i).id + " ");
          break;
        default:
          System.out.println("Invalid command");
          break;
      }
      comand_line = scanner.nextLine();
    }
  }

  static void new_shape(String[] comand_line_array) {
    String type = comand_line_array[1];
    switch (type.toLowerCase()) {
      case "circle":
        new_circle(comand_line_array);
        break;
      case "ellipse":
        new_ellipse(comand_line_array);
        break;
      case "square":
        new_square(comand_line_array);
        break;
      case "triangle":
        new_triangle(comand_line_array);
        break;
      case "rectangle":
        new_rectangle(comand_line_array);
        break;
      case "parallelogram":
        new_parallelogram(comand_line_array);
        break;
      default:
        System.out.println("Unknown type of figure");
        break;
    }
  }

  private static void new_parallelogram(String[] comand_line_array) {
    double x1, y1, x2, y2, x3, y3;
    Colors color;
    color = Colors.valueOf(comand_line_array[2].toUpperCase());
    x1 = Double.parseDouble(comand_line_array[3]);
    y1 = Double.parseDouble(comand_line_array[4]);
    x2 = Double.parseDouble(comand_line_array[5]);
    y2 = Double.parseDouble(comand_line_array[6]);
    x3 = Double.parseDouble(comand_line_array[7]);
    y3 = Double.parseDouble(comand_line_array[8]);
    Parallelogram parallelogram = new Parallelogram(color, x1, y1, x2, y2, x3, y3, ID);
    System.out.println(ID);
    ID += 1;
    shapes.add(parallelogram);
  }

  private static void new_rectangle(String[] comand_line_array) {
    double x1, y1, x2, y2;
    Colors color;
    color = Colors.valueOf(comand_line_array[2].toUpperCase());
    x1 = Double.parseDouble(comand_line_array[3]);
    y1 = Double.parseDouble(comand_line_array[4]);
    x2 = Double.parseDouble(comand_line_array[5]);
    y2 = Double.parseDouble(comand_line_array[6]);
    Rectangle rectangle = new Rectangle(color, x1, y1, x2, y2, ID);
    System.out.println(ID);
    ID += 1;
    shapes.add(rectangle);
  }

  private static void new_triangle(String[] comand_line_array) {
    double x1, y1, x2, y2, x3, y3;
    Colors color;
    color = Colors.valueOf(comand_line_array[2].toUpperCase());
    x1 = Double.parseDouble(comand_line_array[3]);
    y1 = Double.parseDouble(comand_line_array[4]);
    x2 = Double.parseDouble(comand_line_array[5]);
    y2 = Double.parseDouble(comand_line_array[6]);
    x3 = Double.parseDouble(comand_line_array[7]);
    y3 = Double.parseDouble(comand_line_array[8]);
    Triangle triangle = new Triangle(color, x1, y1, x2, y2, x3, y3, ID);
    System.out.println(ID);
    ID += 1;
    shapes.add(triangle);
  }

  private static void new_square(String[] comand_line_array) {
    double x1, y1;
    Colors color;
    color = Colors.valueOf(comand_line_array[2].toUpperCase());
    x1 = Double.parseDouble(comand_line_array[3]);
    y1 = Double.parseDouble(comand_line_array[4]);
    double length = Double.parseDouble(comand_line_array[5]);
    Square square = new Square(color, x1, y1, length, ID);
    System.out.println(ID);
    ID += 1;
    shapes.add(square);
  }

  private static void new_ellipse(String[] comand_line_array) {
    double x1, y1, x2, y2, D;
    Colors color;
    color = Colors.valueOf(comand_line_array[2].toUpperCase());
    x1 = Double.parseDouble(comand_line_array[3]);
    y1 = Double.parseDouble(comand_line_array[4]);
    x2 = Double.parseDouble(comand_line_array[5]);
    y2 = Double.parseDouble(comand_line_array[6]);
    D = Double.parseDouble(comand_line_array[7]);
    Ellipse ellipse = new Ellipse(color, x1, y1, x2, y2, D, ID);
    System.out.println(ID);
    ID += 1;
    shapes.add(ellipse);
  }

  private static void new_circle(String[] comand_line_array) {
    double x, y;
    Colors color;
    color = Colors.valueOf(comand_line_array[2].toUpperCase());
    x = Double.parseDouble(comand_line_array[3]);
    y = Double.parseDouble(comand_line_array[4]);
    double radius = Double.parseDouble(comand_line_array[5]);
    Circle circle = new Circle(color, x, y, radius, ID);
    System.out.println(ID);
    ID += 1;
    shapes.add(circle);
  }

  private static void delete_shape(String[] comand_line_array) {
    int id = Integer.parseInt(comand_line_array[1]);
    shapes.set(id, null);
  }

  static void move_shape(String[] comand_line_array) {
    double x, y;
    int id = Integer.parseInt(comand_line_array[1]);
    if (shapes.get(id) != null) {
      x = Double.parseDouble(comand_line_array[2]);
      y = Double.parseDouble(comand_line_array[3]);
      shapes.get(id).move(x, y);
    }
  }

  static void copy_shape(String[] comand_line_array) {
    double x, y;
    int id = Integer.parseInt(comand_line_array[1]);
    if (shapes.get(id) != null) {
      x = Double.parseDouble(comand_line_array[2]);
      y = Double.parseDouble(comand_line_array[3]);
      Shape the_new_shape = shapes.get(id).copy(x, y);
      the_new_shape.id = ID;
      ID += 1;
      shapes.add(the_new_shape);
    }
  }

  static void area_of_shapes(String[] comand_line_array) {
    Colors color = Colors.valueOf(comand_line_array[1].toUpperCase());
    double area = 0;
    for (int i = 0; i < shapes.size(); i++)
      if (shapes.get(i) != null && shapes.get(i).getColor().equals(color))
        area += shapes.get(i).getArea();
    System.out.println(String.format("%.2f", area));
  }

  static void shape_color_change(String[] comand_line_array) {
    Colors color = Colors.valueOf(comand_line_array[1].toUpperCase());
    int id = Integer.parseInt(comand_line_array[2]);
    if (shapes.get(id) != null) shapes.get(id).setColor(color);
  }

  static void circumference_of_shapes(String[] comand_line_array) {
    Colors color = Colors.valueOf(comand_line_array[1].toUpperCase());
    double circumference = 0;
    for (int i = 0; i < shapes.size(); i++)
      if (shapes.get(i) != null && shapes.get(i).getColor().equals(color))
        circumference += shapes.get(i).getCircumference();
    if (circumference > 0) System.out.println(String.format("%.2f", circumference));
  }

  private static void check_P_in_Shape(String[] comand_line_array) {
    int id = Integer.parseInt(comand_line_array[1]);
    double x = Double.parseDouble(comand_line_array[2]);
    double y = Double.parseDouble(comand_line_array[3]);
    if (shapes.get(id) != null) System.out.println(shapes.get(id).inside(x, y) ? 1 : 0);
  }

  private static void draw() {
    new Drawing(shapes);
  }
}
