import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape re = new Rectangle(2.0,5.0);
        Shape    ci = new Circle(3.0);
        Shape    sq = new Square(7.0);
        Shape  tr = new Triangle(10.0,15.0);

        System.out.println("area:"+re.calculateArea());
        System.out.println("Perimeter:"+re.calculatePerimeter());
        System.out.println("area:"+ci.calculateArea());
        System.out.println("Perimeter:"+ci.calculatePerimeter());
        System.out.println("area:"+sq.calculateArea());
        System.out.println("Perimeter:"+sq.calculatePerimeter());
        System.out.println("area:"+tr.calculateArea());
        System.out.println("Perimeter:"+tr.calculatePerimeter());

        Rectangle.color = "red";
        System.out.println(Shape.color);
        Triangle.color = "blue";
        System.out.println(Rectangle.color);

    }
}
