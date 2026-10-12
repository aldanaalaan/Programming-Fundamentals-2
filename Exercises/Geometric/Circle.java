public class Circle extends GeometricObject {
  private double radius = 0;

  public Circle() {
  }

  public Circle(double radius) {
    setRadius(radius);
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return radius * radius * Math.PI;
  }

  @Override
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  public void printCircle() {
    System.out.println(toString() + "\n ");
  }
}