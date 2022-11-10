public class Square extends Rectangle {
  Square(Colors color, double x1, double y1, double length, int id) {
    super(color, x1 + length / 2, y1 + length / 2, x1 - length / 2, y1 - length / 2, id);
  }
}
