public class GeometricObject {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;

  public GeometricObject(String color, boolean filled) {
    this.dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  public GeometricObject() {
    this.dateCreated = new java.util.Date();
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean isFilled() {
    return filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color + "\nfilled: " + filled;
  }
}
