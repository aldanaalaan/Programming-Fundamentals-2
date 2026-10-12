public class Test {
  public static void main(String[] args) {
    GeometricObject rectangle = new Rectangle(2, 5);
    GeometricObject circle = new Circle(6);

    System.out.println("Rectangle");
    displayGeometricObject(rectangle);

    System.out.println("Circle");
    displayGeometricObject(circle);

    System.out.println("Are the areas equal? " + areaIsEqual(rectangle, circle));

  }

public static boolean areaIsEqual(GeometricObject o1, GeometricObject o2){
  return o1.getArea() == o2.getArea();

}

  public static void displayGeometricObject(GeometricObject o) {
    System.out.println();
    System.out.println("The area of this geometric object is " + o.getArea());
    System.out.println("The perimeter of this geometric object is " + o.getPerimeter());
  }
}
