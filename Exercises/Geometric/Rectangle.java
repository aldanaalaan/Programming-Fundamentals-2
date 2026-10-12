public class Rectangle extends GeometricObject {
  private double width = 0;
  private double height = 0;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    setWidth(width);
    setHeight(height);
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public double getArea() {
    return width * height;
  }

  @Override
  public double getPerimeter() {
    return (width + height) * 2;
  }

}