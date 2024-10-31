import java.io.Serializable;

abstract public class Shape implements Serializable {
  private static final long serialVersionUID = 1L;
  static public String color;
  abstract public Double calculateArea();
  abstract public Double calculatePerimeter();
}

